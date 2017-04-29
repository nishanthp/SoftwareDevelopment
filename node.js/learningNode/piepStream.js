/**
 * Created by prakasni on 4/22/2017.
 */
/*
 var fileSystem = require('fs');

 var writeStream = fileSystem.createWriteStream('output1.txt', 'UTF8');
 var readStream = fileSystem.createReadStream('output.txt');

 readStream.pipe(writeStream);

 writeStream.on('finish', function(){
 console.log("Finished writing...");
 });*/

/*

 var fileSystem = require('fs');
 var zip = require('zlib');

 //fileSystem.createReadStream('output.txt').pipe(zip.createGzip()).pipe(fileSystem.createWriteStream('output.txt.gz'));

 fileSystem.createReadStream('output.txt.gz').pipe(zip.createGunzip()).pipe(fileSystem.createWriteStream('output7.txt'));*/


var fileSystem = require('fs');

// fileSystem.mkdir('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\tmp', function (err) {
//     if (err) {
//         return console.log(err);
//     }
//     console.log("The dir was created...");

//});

fileSystem.readdir('C:\\Users\\prakasni\\IdeaProjects\\learningNode', function (err, files) {
    if (err) {
        return console.log(err);
    }

    console.log(files);
});

/*fileSystem.rmdir('C:\\Users\\prakasni\\IdeaProjects\\learningNode\\tmp', function (err) {
 if (err) {
 return console.log(err);
 }
 console.log("Removed the dir tmp...");
 });*/

fileSystem.stat('output.txt', function (err, status) {
    if (err) {
        return console.log(err);
    }
    console.log(status);

});

fileSystem.readFile('output.txt', function (err, chunk) {
    if (err) {
        return console.log(err);
    }

    console.log(chunk.toString());
});
var d = "This belongs there too..."
fileSystem.writeFile('output.txt', d, function (err) {
    if (err) {
        return console.log("Unable to write to the file");
    }
    console.log("Done writing with the file");
});