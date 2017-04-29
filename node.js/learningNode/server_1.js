/**
 * Created by prakasni on 4/23/2017.
 */
/*
 var express = require("express");
 var app = express();

 app.use(express.static('images'));
 app.get("/indx", function (request, response) {
 response.sendFile('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\index.html');
 });

 app.listen('3001');

 console.log("Server is listening at port 3001...");*/


/*var cookie = require("cookie-parser");
 var express = require("express");

 var app = express();
 app.use(cookie());

 app.get('/', function (request, response) {
 console.log(request.cookies);
 });*/


var express = require("express");
var app = express();
var bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({extended: false}));
//app.use(multer({ dest: '/tmp/'}));

app.get('/', function (req, res) {
    res.sendFile('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\upload.html')
});
app.post('/fillform', function (request, resp) {
    response = {
        firstname: request.body.firstname,
        lastname: request.body.lastname
    };
    console.log(response);
    resp.send(JSON.stringify(response));
})
console.log("The server is listening on port: 3001...");
app.listen('3001');