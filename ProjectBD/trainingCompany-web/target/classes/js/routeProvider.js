var mainApp = angular.module("mainApp", ['ngRoute','IndexControllers','IndexServices']);
mainApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.

        when('/registration', {
            templateUrl: '/registration.html',
            controller: 'RegistrationController'
        }).

    when('/url', {
        templateUrl: '/url.html',
        controller: 'NewController'
    }).

        otherwise({
            templateUrl: '/mainPage.html',
            controller: 'MainPageController'
        });
}]);

