(function () {
    var module = angular.module("main_module");
    module.controller("fc", function Footer_ctrl(serviceSvc) {
        this.app_title = serviceSvc.footer;
        console.log(serviceSvc.footer);
    })})();