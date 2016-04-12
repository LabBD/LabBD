var mainApp = angular.module("mainApp", ['ngRoute', 'IndexControllers', 'IndexServices','PhotoControllers'
    ,'PhotoServices','AngularDemoControllers','AngularDemoServices']);
mainApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.

        when('/angularDemo/:param', {
            templateUrl: '/angularDemo.html',
            controller: 'AngularDemoController'
        }).

        when('/photoDemo', {
            templateUrl: '/photoDemo.html',
            controller: 'PhotoController'
        }).

        when('/search', {
            templateUrl: '/searchPage.html'
        }).

        when('/addOffer', {
            templateUrl: '/addOffer.html'
        }).

        when('/basket', {
            templateUrl: '/basket.html'
        }).

        otherwise({
            templateUrl: '/main.html',
            controller: 'MainPageController'
        });
}]);



