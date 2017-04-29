/**
 * Created by prakasni on 4/23/2017.
 */
var timeout = setTimeout(function () {
    console.log("Hello world after 2 sec");
}, 2000);

clearTimeout(timeout);

var interval = setInterval(function () {
    console.log('OK cleartimeout what about now!')
}, 2000);

clearInterval(interval);

var os = require("os");

console.log(os.uptime());

console.log(os.endianness());
console.log(os.hostname());
console.log(os.platform());
console.log(os.cpus());
console.log(os.networkInterfaces());


var dns = require("dns");
dns.lookup('www.google.com', function (err, address, family) {
    if (err) {
        return console.log(err);
    }
    console.log(address);
    console.log(family);
})