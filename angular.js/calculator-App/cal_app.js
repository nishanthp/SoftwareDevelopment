var calculator_module = angular.module("main", []);
calculator_module.controller("ctrl",operation);

function operation($scope){
    $scope.add = "+";
    $scope.sub = "-";
    $scope.mult = "*";
    $scope.div = "/";
    $scope.op_used="";
    $scope.operand = function(value){
        $scope.op_used = value;

    $scope.input_1 = parseInt($scope.input_1, 10);
    $scope.input_2 = parseInt($scope.input_2, 10);
    console.log("printing"+$scope.input_2)
    switch($scope.op_used)
    {
        case "+":
            $scope.result = $scope.input_1+$scope.input_2;
            break;
        case "-":
            $scope.result = $scope.input_1-$scope.input_2;
            break;
        case "*":
            $scope.result = $scope.input_1*$scope.input_2;
            break;
        case "/":
            $scope.result = $scope.input_1/$scope.input_2;
            break;
    }
    //console.log($scope.result);
    }
    
    
}