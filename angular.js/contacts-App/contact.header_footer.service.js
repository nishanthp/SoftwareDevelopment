
(function () {
    module = angular.module("main_module");
    function provideHeaderFooter(Provide_header, Provide_footer) {
        this.header = Provide_header;
        this.footer = Provide_footer();
    }
    module.service("serviceSvc", provideHeaderFooter);
})(); // new provideHeaderFooter();