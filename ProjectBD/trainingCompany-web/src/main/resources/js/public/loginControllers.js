var loginControllers = angular.module(
    'loginControllers', []);

loginControllers.controller('loginController',['$scope','$location' ,function($scope,$location){
    $scope.nextUrl = function(){
        return $location.url();
    }
}]);