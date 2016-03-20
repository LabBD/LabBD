var mainApp = angular.module("mainApp", ['ngRoute', 'IndexControllers', 'IndexServices','PhotoControllers','PhotoServices']);
mainApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.

        when('/registration', {
            templateUrl: '/registration.html',
            controller: 'RegistrationController'
        }).

        when('/url', {
            templateUrl: '/url.html',
            controller: 'NewController'
        }).

        when('/photoDemo', {
            templateUrl: '/photoDemo.html',
            controller: 'PhotoController'
        }).

        otherwise({
            templateUrl: '/mainPage.html',
            controller: 'MainPageController'
        });
}]);



