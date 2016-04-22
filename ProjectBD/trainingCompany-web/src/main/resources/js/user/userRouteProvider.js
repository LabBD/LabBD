var mainApp = angular.module("mainApp", ['ngRoute', 'IndexControllers', 'IndexServices', 'PhotoControllers'
    , 'PhotoServices', 'AngularDemoControllers', 'AngularDemoServices', 'BasketControllers', 'BasketServices'
    , 'SearchServices', 'SearchControllers', 'ui.grid', 'ui.grid.pagination']);
mainApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.

        when('/angularDemo/:param', {
            templateUrl: '/templates/angularDemo.html',
            controller: 'AngularDemoController'
        }).

        when('/photoDemo', {
            templateUrl: '/templates/photoDemo.html',
            controller: 'PhotoController'
        }).

        when('/search', {
            templateUrl: '/templates/public/searchPage.html',
            controller: 'SearchController'
        }).

        when('/search/:pageNumber', {
            templateUrl: '/templates/public/searchPage.html',
            controller: 'SearchController'
        }).

        when('/addOffer', {
            templateUrl: '/templates/user/addOffer.html'
        }).

        when('/basket', {
            templateUrl: '/templates/user/basket.html',
            controller: 'BasketController'
        }).

        otherwise({
            templateUrl: '/templates/public/main.html',
            controller: 'MainPageController'
        });
}]);





