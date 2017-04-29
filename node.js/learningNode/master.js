/**
 * Created by prakasni on 4/23/2017.
 */
var child = require("child_process");
var fs = require("fs");

/*for (var i = 0; i < 3; i++) {
 var process = child.exec('node support.js ' + i, function (err, stdout, stderr) {
 if (err) {
 console.log(err);
 }
 else {
 console.log(stderr);
 console.log(stdout);
 }
 process.on('exit', function (code) {
 console.log(code);
 })
 }
 )
 }*/

/*for (var i = 0; i < 3; i++) {
 var spawn_process = child.spawn('node', ['support.js', i]);
 spawn_process.stdout.on('data', function (data) {
 console.log(data.toString());
 })
 spawn_process.stderr.on('data', function (data) {
 console.log(data.toString());
 })
 spawn_process.on('close', function (code) {
 console.log(code);
 })
 }*/

for (var i = 0; i < 3; i++) {
    var fork_process = child.fork('support.js', [i]);

    fork_process.on('close', function (code) {
        console.log(code);
    })
}