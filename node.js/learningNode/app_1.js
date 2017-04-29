var http_server = require('http');

var connect = require('connect');

var app =connect();

http_server.createServer(app).listen(8888);

app.use('/first',firstMethod);
app.use('/second',secondMethod);

function firstMethod(request, response, next){
    console.log("This is the first method");
    next();
};

function secondMethod(request, response, next){
    console.log(request.url);
};


