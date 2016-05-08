/**
 * Created by Sebastian on 2016-05-06.
 */
var errorControllers = angular.module('ErrorControllers', []);

errorControllers.controller('ErrorController', ['$scope', '$routeParams', '$window', '$location', function ($scope, $routeParams, $window, $location) {

    $scope.param = $routeParams.reasonOfError;
    
    if($scope.param == "registration") {
        $scope.information = "There was some error during registration, please try again.";
    } else if ($scope.param == "login") {
        $scope.information = "There was some error during attempt to login, please try again.";
    }  else if ($scope.param == "userExisted") {
        $scope.information = "Given username already existed, please try again with another username.";
    }
    else {
        $scope.information = "There was some error processing your request, please try again.";
    }
    
    $scope.goBack = function () {
        $window.history.back();
    }

    $scope.goMainPage = function () {
        $location.path('/');
    }
}]);