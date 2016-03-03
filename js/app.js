'use strict';

/*
 * Express Dependencies
 */
var express = require('express');
var easySoap = require('easySoap');
var app = express();
var port = 3000;

/*
 * Use Handlebars for templating
 */
var exphbs = require('express3-handlebars');
var hbs;

// For gzip compression
app.use(express.compress());


var soap = require('soap');
var url = 'https://www1.gsis.gr/webtax2/wsgsis/RgWsPublic/RgWsPublicPort?WSDL';
var args = {name: 'value'};
soap.createClient(url, function(err, client) {
    client.rgWsPublicVersionInfo(null, function(err, result) {
        console.log(result);
    });

    /*client.rgWsPublicAfmMethod(null, function(err, result) {
        console.log(result);
    });*/
});

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


/*
 * Start it up
 */
app.listen(process.env.PORT || port);
console.log('Express started on port ' + port);
