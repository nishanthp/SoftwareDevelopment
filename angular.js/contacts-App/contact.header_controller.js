(function () {
    var module = angular.module("main_module");
    module.controller("hc", function Header_ctrl(serviceSvc) {
        this.app_title = serviceSvc.header;
        console.log(serviceSvc.header);
    })})();