var mainApp = angular.module("mainApp", ['ngRoute', 'IndexControllers', 'IndexServices', 'PhotoControllers'
    , 'PhotoServices', 'AngularDemoControllers', 'AngularDemoServices', 'BasketControllers', 'BasketServices'
    , 'AddOfferControllers', 'AddOfferServices', 'SearchServices', 'SearchControllers', 'ui.grid', 'ui.grid.pagination']);
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

        when('/offer/:offerId', {
            templateUrl: '/templates/public/offerDetails.html'
        }).

        when('/addOffer', {
            templateUrl: '/templates/user/addOffer.html',
            controller: 'AddOfferController'
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





