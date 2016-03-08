'use strict';

/*
 * Express Dependencies
 */
var express = require('express');
var https = require('https');
var xml2js = require('xml2js');
var app = express();
var port = 3000;

/*
 * Use Handlebars for templating
 */
var exphbs = require('express3-handlebars');
var hbs;

// For gzip compression
app.use(express.compress());

// See http://stackoverflow.com/questions/5710358/how-to-retrieve-post-query-parameters-in-express
app.use(express.json());       // to support JSON-encoded bodies

/**
 * Construct SOAP request XML
 *
 * @param userName GSIS username
 * @param password GSIS password
 * @param vatBy Greek VAT of requester (above username/password issued with this VAT)
 * @param vatFor Greek VAT to request information
 * @returns {string} Request SOAP XML
 */
function prepareQuery(userName, password, vatBy, vatFor){
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<env:Envelope\n  xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"\n  xmlns:ns=\"http://gr/gsis/rgwspublic/RgWsPublic.wsdl\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n  xmlns:ns1=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n  <env:Header>\n    <ns1:Security>\n      <ns1:UsernameToken>\n\t<ns1:Username>" + userName +"</ns1:Username>\n\t<ns1:Password>"+ password + "</ns1:Password>\n      </ns1:UsernameToken>\n    </ns1:Security>\n  </env:Header>\n  <env:Body>\n    <ns:rgWsPublicAfmMethod>\n      <RgWsPublicInputRt_in xsi:type=\"ns:RgWsPublicInputRtUser\">\n\t<ns:afmCalledBy>" + vatBy +"</ns:afmCalledBy>\n\t<ns:afmCalledFor> " + vatFor+ "</ns:afmCalledFor>\n      </RgWsPublicInputRt_in>\n      <RgWsPublicBasicRt_out xsi:type=\"ns:RgWsPublicBasicRtUser\">\n\t<ns:afm xsi:nil=\"true\"/>\n\t<ns:stopDate xsi:nil=\"true\"/>\n\t<ns:postalAddressNo xsi:nil=\"true\"/>\n\t<ns:doyDescr xsi:nil=\"true\"/>\n\t<ns:doy xsi:nil=\"true\"/>\n\t<ns:onomasia xsi:nil=\"true\"/>\n\t<ns:legalStatusDescr xsi:nil=\"true\"/>\n\t<ns:registDate xsi:nil=\"true\"/>\n\t<ns:deactivationFlag xsi:nil=\"true\"/>\n\t<ns:deactivationFlagDescr xsi:nil=\"true\"/>\n\t<ns:postalAddress xsi:nil=\"true\"/>\n\t<ns:firmFlagDescr xsi:nil=\"true\"/>\n\t<ns:commerTitle xsi:nil=\"true\"/>\n\t<ns:postalAreaDescription xsi:nil=\"true\"/>\n\t<ns:INiFlagDescr xsi:nil=\"true\"/>\n\t<ns:postalZipCode xsi:nil=\"true\"/>\n      </RgWsPublicBasicRt_out>\n      <arrayOfRgWsPublicFirmActRt_out xsi:type=\"ns:RgWsPublicFirmActRtUserArray\"/>\n      <pCallSeqId_out xsi:type=\"xsd:decimal\">0</pCallSeqId_out>\n      <pErrorRec_out xsi:type=\"ns:GenWsErrorRtUser\">\n\t<ns:errorDescr xsi:nil=\"true\"/>\n\t<ns:errorCode xsi:nil=\"true\"/>\n      </pErrorRec_out>\n    </ns:rgWsPublicAfmMethod>\n  </env:Body>\n</env:Envelope>";
}

/*
 * Config for Production and Development
 */
if (process.env.NODE_ENV === 'production') {
    // Set the default layout and locate layouts and partials
    app.engine('handlebars', exphbs({
        defaultLayout: 'main',
        layoutsDir: 'dist/views/layouts/',
        partialsDir: 'dist/views/partials/'
    }));

    // Locate the views
    app.set('views', __dirname + '/dist/views');

    // Locate the assets
    app.use(express.static(__dirname + '/dist/assets'));

} else {
    app.engine('handlebars', exphbs({
        // Default Layout and locate layouts and partials
        defaultLayout: 'main',
        layoutsDir: 'views/layouts/',
        partialsDir: 'views/partials/'
    }));

    // Locate the views
    app.set('views', __dirname + '/views');

    // Locate the assets
    app.use(express.static(__dirname + '/assets'));
}

// Set Handlebars
app.set('view engine', 'handlebars');


/*
 * Routes
 */
// Index Page
app.get('/', function(request, response, next) {
    response.render('index');
});

app.get('/details', function(request, response, next) {

    var username = request.param('username', null);
    var password = request.param('password', null);
    var vatBy = request.param('vatBy', null);
    var vatFor = request.param('vatFor', null);

    console.log('Get parameters:');
    console.log('username: '+ username);
    console.log('password: ' + password);
    console.log('vatBy: ' + vatBy);
    console.log('vatFor: ' + vatFor);

    var postData = prepareQuery(username, password, vatBy, vatFor);

    var vatDetailsOption = {
        debug: true,
        host: 'www1.gsis.gr',
        port: '443',
        path: '/webtax2/wsgsis/RgWsPublic/RgWsPublicPort',
        method: 'POST',
        headers: {
            'Content-Type': 'application/soap+xml;charset=UTF-8',
            'Content-Length': postData.length,
            'SOAPAction': 'http://gr/gsis/rgwspublic/RgWsPublic.wsdl/rgWsPublicAfmMethod'
        }
    };

    var req = https.request(vatDetailsOption, function(res) {
        var output = '';
        console.log('HTTP POST on ' + vatDetailsOption.host + vatDetailsOption.path);

        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            console.log("Loading chunk...");
            output += chunk;
        });

        res.on('end', function () {
            console.log('Data loaded successfully');
            // Parse it to XML
            var parseXML = xml2js.parseString;
            parseXML(output, function (err, result) {
                response.send(result);
            });
        });
    });

    req.on('error', function (err) {
        console.log('https error code: ' + err.message);
        console.dir(err);
    });

    // write the request parameters
    req.write(postData);
    req.end();
});

app.get('/version', function(request, response, next) {
    // SOAP XML for version
    var postData = '<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<env:Envelope\n  xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"\n  xmlns:ns=\"http://gr/gsis/rgwspublic/RgWsPublic.wsdl\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n<env:Header/>\n<env:Body>\n<ns:rgWsPublicVersionInfo/>\n</env:Body>\n</env:Envelope>';

    var vatVersionOptions = {
        debug: true,
        host: 'www1.gsis.gr',
        port: '443',
        path: '/webtax2/wsgsis/RgWsPublic/RgWsPublicPort',
        method: 'POST',
        headers: {
            'Content-Type': 'application/soap+xml;charset=UTF-8',
            'Content-Length': postData.length,
            'SOAPAction': 'http://gr/gsis/rgwspublic/RgWsPublic.wsdl/rgWsPublicVersionInfo'
        }
    };

    var req = https.request(vatVersionOptions, function(res) {
        var output = '';
        console.log('HTTP POST on ' + vatVersionOptions.host + vatVersionOptions.path);

        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            console.log("Loading chunk...");
            output += chunk;
        });

        res.on('end', function () {
            console.log('Data loaded successfully');
            // Parse it to XML
            var parseXML = xml2js.parseString;
            parseXML(output, function (err, result) {
                response.send(result);
            });
        });
    });

    req.on('error', function (err) {
        console.log('https error code: ' + err.message);
        console.dir(err);
    });

    // write the request parameters
    req.write(postData);
    req.end();
});

/*
 * Start it up
 */
app.listen(process.env.PORT || port);
console.log('Express started on port ' + port);
