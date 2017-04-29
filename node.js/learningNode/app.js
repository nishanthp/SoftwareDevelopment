/*
var foodServer = function (orderNumber){
    console.log("Customer order"+orderNumber);
    makeFood(function(){
     console.log('The food is ready for the order:'+ orderNumber);
    })
};

function makeFood(callBack)
{
    setTimeout(callBack,5000);
};


foodServer(1);
foodServer(2);
foodServer(3);
foodServer(4);
foodServer(5);
foodServer(6);
foodServer(7);
*/

/*
var name = {
  FirstName: function(){
      console.log(this===name);
  }

};


name.FirstName();

function randomFunction(){
    console.log(this===global);
}

randomFunction();*/


/*function random(){
    this.name = "This is a random function";
}

var r = new random();
console.log (r.name);

var randomObejct = {
    FirstName : "This is a random object"
};

console.log(randomObejct.FirstName);*/

//var r = new randomObejct(); // Does not work.


//Prototypes.
// function User (){
//     this.name="";
//     this.points=30;
//     console.log(this.name + this.points);
// };
//
// var r1 = new User();
// var r2 = new User();
//
// r1.name = "r1";
// r2.name = "r2";
//
// User.prototype.magic_points = 50;
//
// console.log(r1.magic_points);
// console.log(r2.magic_points);

// var r = require('./random');
// r.r1();
//r.random2();

// var r = require('./random');
// console.log(r.favMovie);
// r.getFavMovie();
//
// require('./random_1');
// require('./random2');

// var fs = require('fs');
// fs.writeFileSync("node.txt", "Hello Node.js, there you are!!!");
// console.log(fs.readFileSync("node.txt").toString());
//
//
// var path = require('path');
// var dir_path = "C:/Users/prakasni//IdeaProjects/learningNode/app.js";
//
// console.log(path.normalize(dir_path));
// console.log(path.dirname(dir_path));
// console.log(path.extname(dir_path));

// console.log(__dirname);
// console.log(__filename);

var http_server = require('http');
var fileSystem = require('fs');
function ErrorResponse404 (response) {
    response.writeHead(404,{'Content-Type':'text/plain'});
    response.write('Error: 404. Page not found.');
    response.end();
};

function uponRequest(request, response) {
    if (request.method=="GET" && request.url == "/")
    {
        response.writeHead(200,{'Content-Type':'text/html'});
        fileSystem.createReadStream('./contacts.html').pipe(response);
    }else
    {
        ErrorResponse404(response);
    }
};

http_server.createServer(uponRequest).listen('8000');
console.log('The server is running');