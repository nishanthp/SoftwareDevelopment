var module = angular.module("mainModel", []).controller("ctr_main",check_box);

function check_box($scope)
{
    $scope.myList = [
        {name:"Foo", age:"12"},
        {name:"Foo1", age:"13"},
        {name:"Foo2", age:"14"},
        {name:"Foo3", age:"15"}

    ];
}