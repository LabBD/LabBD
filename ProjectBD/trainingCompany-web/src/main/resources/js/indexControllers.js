var indexControllers = angular.module(
    'IndexControllers', []);



indexControllers.controller('MainPageController', ['$scope', 'IndexService', function ($scope, IndexService) {
    $scope.message = "Main page";


    $scope.searchPhrase = function () {
        window.location = "../#/search/1?query=" + $scope.phrase;
    }
}]);
