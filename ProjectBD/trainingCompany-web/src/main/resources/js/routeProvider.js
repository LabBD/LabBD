var mainApp = angular.module("mainApp", ['ngRoute', 'IndexControllers', 'IndexServices', 'PhotoControllers'
    , 'PhotoServices', 'AngularDemoControllers', 'AngularDemoServices', 'BasketControllers', 'BasketServices'
    , 'SearchServices', 'SearchControllers', 'ui.grid', 'ui.grid.pagination']);
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
            templateUrl: '/searchPage.html',
            controller: 'SearchController'
        }).

        when('/search/:pageNumber', {
            templateUrl: '/searchPage.html',
            controller: 'SearchController'
        }).

        when('/addOffer', {
            templateUrl: '/addOffer.html'
        }).

        when('/basket', {
            templateUrl: '/basket.html',
            controller: 'BasketController'
        }).

        otherwise({
            templateUrl: '/main.html',
            controller: 'MainPageController'
        });
}]);



