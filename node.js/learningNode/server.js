/**
 * Created by prakasni on 4/19/2017.
 */
var http = require("http");
var url = require("url");
var fileSystem = require("fs");

http.createServer(function (request, response) {
    var pathname = url.parse(request.url).pathname;
    console.log(pathname);
    fileSystem.readFile(pathname.substr(1), function (err, data) {
        if (err) {
            console.log("Unable to read the file.");
            response.writeHead(404, {"Content-Type": "text/html"});
            //response.end();
        } else {
            response.writeHead(200, {"Content-Type": "text/html"});
            response.write(data.toString());
            response.end();
        }

    })
}).listen(8082);

console.log("The server is listening on port 8082...")