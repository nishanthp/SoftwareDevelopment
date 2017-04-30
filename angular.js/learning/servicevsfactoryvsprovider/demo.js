var app = angular.module("MyApp",[]);
app.controller("MyCtrl", function(helloFromService,helloFromtheFactory,helloFromtheProvider){
       this.sayHellos = [
        helloFromtheFactory.sayHello(),
        helloFromService.sayHello(),
        helloFromtheProvider.sayhello()
       ]; 
});

//Returns the instance of function()
app.service('helloFromService', function(){
    this.sayHello = function(){
        return "Hello from the service";
    }
});

//Returns the object.
app.factory('helloFromtheFactory', function(){
    return {
        sayHello: function(){
            return "Hello from the factory";
        }
    }
});

//Returns the $get()
app.provider('helloFromtheProvider', function(){
    this.name = "Default";
    this.$get = function(){
        var name = this.name;
        return {
            sayhello: function(){
                console.log(this.name1)
                return "Hello from the "+ name;
            } 
        }
    }

    this.setName = function(reqName){
        this.name = reqName;
    }
});

//Used to configure the providers.
app.config(function(helloFromtheProviderProvider){
    helloFromtheProviderProvider.setName("Provider");
});