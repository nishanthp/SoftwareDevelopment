var app = angular.module('thirdParty', []);
app.service('emailService', function(){
    this.name = "";
    this.setName = function(reqName){
        this.name = reqName;
    }

    this.sendEmail = function(){
        return "Sending email to "+ this.name;
    }
})


var myApp = angular.module("MyApp", ['thirdParty']);
myApp.config(function($provide){
    $provide.decorator('emailService', function($delegate){
        $delegate.sendEmailWithSignature = function(signature){
            return "Sending email to "+ this.name + " with signature as " +  signature
        };
        return $delegate;
    });
})


myApp.controller("MyCtrl", function(emailService){
    emailService.setName("NishanthPrakash");
    this.sendEmail = emailService.sendEmailWithSignature("np");
})