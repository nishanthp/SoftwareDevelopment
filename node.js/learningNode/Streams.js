/**
 * Created by prakasni on 4/22/2017.
 */
var data = "This should be a part of the output file...";
var fileSystem = require('fs');
var writeStream = fileSystem.createWriteStream('output.txt');
writeStream.write(data, 'UTF8');
writeStream.end();

writeStream.on('finish', function(){
    console.log("I have finisied writing to the file");
});

var read_data="";

var readStream = fileSystem.createReadStream('output.txt');
readStream.setEncoding('UTF8');

readStream.on('data', function(chunk) {
    read_data+= chunk;
});


readStream.on('end', function(){
    console.log(read_data);
})