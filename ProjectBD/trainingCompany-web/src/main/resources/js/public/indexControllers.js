var indexControllers = angular.module(
    'IndexControllers', []);

indexControllers.controller('MainPageController', ['$scope', 'IndexService', function ($scope, IndexService) {
    $scope.message = "Main page";

    $scope.searchPhrase = function (phrase) {
        if (typeof phrase == 'undefined') {
            window.location = "../#/search/1";
        } else window.location = "../#/search/1?query=" + phrase;
    };
    
}]);

indexControllers.controller('LoginController', ['$scope', 'IndexService', function ($scope, IndexService) {
    $scope.message = "Login page";

    $scope.login = function () {
        IndexService.login($scope.user, function (data) {

            window.alert('succes');
        });

    }

}]);
