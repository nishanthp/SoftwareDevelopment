/**
 * Created by prakasni on 4/20/2017.
 */
var fileSystem = require('fs');

fileSystem.readFile('node.txt', function(err, data){
    if(err) {
        console.log(err);
    }

    console.log(data.toString());
});

console.log("Program has ended...")