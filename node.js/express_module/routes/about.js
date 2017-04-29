/**
 * Created by prakasni on 4/19/2017.
 */
var express = require('express');

var router = express.Router();

router.get('/', function (request, response, next){
    response.render('about', { title: "About",
        descripton: 'Welcome to the about page.'
    });
});

module.exports=router;