/**
 * Created by prakasni on 4/20/2017.
 */
var event = require("events");
var event_emitter = new event.EventEmitter();



/*var co = function (){
    console.log("It is conneted...");
}*/

/*event_emitter.on('connect', co);
event_emitter.on('connect', co);
event_emitter.emit('connect');*/

//console.log(event_emitter.listeners('connect'));

function listner1(){
    console.log("Listener 1 completed");
};
function listner2(){
    console.log("Listener 2 completed");
};

event_emitter.addListener('connect', listner1);
event_emitter.addListener('connect',listner2);

//event_emitter.on('connect', listner1);
//event_emitter.on('connect', l2);

event_emitter.emit('connect');

event_emitter.removeListener('connect',listner1);

event_emitter.emit('connect');

var count = require('events').EventEmitter.listenerCount(event_emitter, 'connect');
console.log(count);