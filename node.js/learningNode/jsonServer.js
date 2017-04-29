/**
 * Created by prakasni on 4/23/2017.
 */
var filesystem = require("fs");
var express = require("express");
var body = require("body-parser");
var app = express();
app.use(body.json());
app.get('/listUsers', function (request, response) {
    var chunk = "";
    filesystem.readFile('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\users.json', function (err, data) {
        if (err) {
            console.log(err);
        }
        console.log(data);
        response.end(JSON.stringify(data));
    });
})


app.post('/addUser', function (request, response) {
    filesystem.readFile('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\users.json', function (err, data) {
        if (err) {
            console.log(err);
        } else {
            var d = JSON.parse(data);
            d["users4"] = request.body;
            console.log(request.body);
            response.writeHead('200', {"Content-Type": "application/json"});
            response.end(JSON.stringify(d));
        }
    })
})

app.get('/:id', function (request, response) {
    filesystem.readFile('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\users.json', function (err, data) {
        if (err) {
            console.log(err);
        } else {
            var d = JSON.parse(data);
            var retData = d["user" + request.params.id];
            console.log(d["user" + request.params.id]);
            response.end(JSON.stringify(retData));
        }

    })
});


app.delete('/deleteUser/:id', function (request, response) {
    filesystem.readFile('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\users.json', function (err, data) {
        if (err) {
            console.log(err);
        } else {
            var d = JSON.parse(data);
            delete d["user" + request.params.id];
            console.log(d)
            response.send(JSON.stringify(d));
        }
    })
})
app.listen('3002');

console.log("The server is listening at port 3002...");