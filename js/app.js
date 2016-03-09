'use strict';

/*
 * Express Dependencies
 */
var express = require('express');
var https = require('https');
var xml2js = require('xml2js');
var vatVersion = require('./vatVersion')();
var vatDetailsFunc = require('./vatDetails');
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

    var vatDetails = vatDetailsFunc(username,password, vatBy, vatFor);

    var req = https.request(vatDetails.httpOptions, function(res) {
        var output = '';

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
    req.write(vatDetails.postQueryData);
    req.end();
});

app.get('/version', function(request, response, next) {

    var req = https.request(vatVersion.httpOptions, function(res) {
        var output = '';
        console.log('HTTP POST on ' + vatVersion.httpOptions.host + vatVersion.httpOptions.path);

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
    req.write(vatVersion.postData);
    req.end();
});

/*
 * Start it up
 */
app.listen(process.env.PORT || port);
console.log('Express started on port ' + port);
