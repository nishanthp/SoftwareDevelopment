(function () {
    var contact_app = angular.module("main_module");

    contact_app.service("Contact_data", function ($http) {

        var self = this;
        self.getContacts = function () {
            console.log("Is it coming till here..")
            var promise1 = $http.get("http://localhost:3005/getContacts");
            var promise2 = promise1.then(function (response) {
                return response.data;
            });
            return promise2;
        };

        this.createUserContact = function (userData){
            var promise = $http.post("http://localhost:3000/contacts/", userData);
            promise.then(function(response){
                console.log("The response data is: "+response.data);
            });
            return promise;
        }

        this.saveUserContact = function (userData){
            var promise = $http.put("http://localhost:3000/contacts/"+userData.id, userData);
            promise.then(function(response){
                console.log("The response data is: "+response.data);
            });
            return promise;
        }
    });
})();