/**
 * Created by prakasni on 4/23/2017.
 */
var http = require("http");
options = {
    host: "localhost",
    port: 8082,
    path: "/index.html"
}


var request = http.request(options, function (response) {

    var chunk = "";
    response.on('data', function (data) {
        chunk += data;
    });

    response.on('end', function () {
        console.log("This is the data:" + chunk);
    })


});

request.end();