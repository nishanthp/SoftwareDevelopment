var current_time_module = angular.module("main_module",[]);
        current_time_module.controller("MainCtrl", getCurrentTime);      
        function getCurrentTime($scope)
        {
            $scope.time = new Date().toLocaleTimeString();
            $scope.username = "";
            console.log ($scope.textstring);
            $scope.update_time = function update(){
                $scope.time = new Date().toLocaleTimeString();
            };
            $scope.checkbox_changed = function () {
                console.log("Something changed..")
            }

            $scope.radio_change = function(){
                console.log("Radio button changed.."+$scope.radio_button)
            }
        }