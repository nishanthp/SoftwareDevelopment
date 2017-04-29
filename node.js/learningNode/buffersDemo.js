/**
 * Created by prakasni on 4/21/2017.
 */
var buff = new Buffer(14);
var len = buff.write('Hello Buffer!',"utf-8");

console.log(len);

console.log(buff.toString());

var json = buff.toJSON(buff);

console.log(json);

console.log(json.data.toString());


var b1 = new Buffer("This is buffer 1.");
var b2 = new Buffer("This is buffer 2.");
var b3 = Buffer.concat([b1, b2]);

 console.log(b3.toString());

 console.log(b3.length);

 var b4 = new Buffer(20);
 b2.copy(b4);
console.log(b4.toString());
console.log(b4.length);

var splice = new Buffer(10);
splice =b3.slice(0);
console.log(splice.toString());