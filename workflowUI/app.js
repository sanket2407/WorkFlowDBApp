var express = require('express');
var http = require('http');
var path = require('path');
var favicon = require('static-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var routes = require('./routes');
var checkLogin = require('./routes/checkLogin');
var orgAdminDashBoard = require('./routes/orgAdminDashBoard');
var deptAdminDashboard = require('./routes/deptAdminDashboard');
var next = require('./routes/next');
var userDashboard = require('./routes/userDashboard');
var homepage=require('./routes/homepage');
var orgAdminSignUp = require('./routes/orgAdminSignUp');
var userSignUp = require('./routes/userSignUp');
var adminSignUp = require('./routes/adminSignUp');


//var expressSession = require("express-session");
//client-session
var session = require('client-sessions');
var app = express();

/*var FileStore = require('session-file-store')(expressSession);*/

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(favicon());
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded());
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
app.use(app.router);

app.get('/',homepage.index);
app.get('/orgAdminDashBoard', orgAdminDashBoard.loginPage);
app.get('/userDashboard', userDashboard.loginPage);
app.get('/deptAdminDashboard',deptAdminDashboard.loginPage);
app.get('/next',next.nextLevel);
app.post('/checklogin', checkLogin.checklogin);
app.get('/orgAdminSignUp', orgAdminSignUp.loginPage);
app.get('/userSignUp', userSignUp.loginPage);
app.get('/adminSignUp', adminSignUp.loginPage);


/// catch 404 and forwarding to error handler
app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

/// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
    app.use(function(err, req, res, next) {
        res.render('error', {
            message: err.message,
            error: err
        });
    });
}

// production error handler
// no stacktraces leaked to user

app.use(function(err, req, res, next) {
    res.render('error', {
        message: err.message,
        error: {}
    });
});

//EXPRESS SESSION CONFIG
/*
app.use(expressSession({
    key: 'workflowid',
    secret: 'workflow',
    resave: true,
    saveUninitialized: true,
    store: new FileStore()
}));
*/

// all environments
//configure the sessions with our application

app.use(session({
    cookieName: 'session',
    secret: 'workflow',
    duration: 30 * 60 * 1000,    //setting the time for active session
    activeDuration: 5 * 60 * 1000,  })); // setting time for the session to be active when the window is open // 5 minutes set currently


module.exports = app;
