 (function (){
     var module = angular.module("main_module");
     module.value("Provide_footer", function()
 {
     return new Date().toDateString();
 })})();