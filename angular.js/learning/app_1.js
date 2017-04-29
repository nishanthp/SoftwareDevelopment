var current_time_module = angular.module("main_module",[]);
current_time_module.controller("Ctrl1",ctrl_1);
current_time_module.controller("Ctrl2",ctrl_2);

function ctrl_1(){
    this.new_var = "This is from Ctrl1";
}

function ctrl_2(){
    this.new_var = "This is from Ctrl2";
}