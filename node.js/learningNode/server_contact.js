/**
 * Created by prakasni on 4/25/2017.
 */

var fs = require("fs");
var express = require("express");
var cors = require("cors");
var app = express();
app.use(cors());

app.get('/getContacts', function (request, response) {
    fs.readFile('./db.json', function (err, data) {
            if (err) {
                console.log(err);
            } else {
                var chunk = JSON.parse(data);
                response.writeHead('200', {'Content-Type': 'text/json'});
                response.end(JSON.stringify(chunk));
            }

        }
    )
})
app.listen('3005');
console.log("The server is running on port 3005...")