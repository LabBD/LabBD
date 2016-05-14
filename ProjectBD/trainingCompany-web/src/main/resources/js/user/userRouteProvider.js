var mainApp = angular.module("mainApp", ['ngRoute', 'ngAnimate','toaster','IndexControllers', 'IndexServices',
    'AngularDemoControllers', 'AngularDemoServices', 'ErrorControllers', 'BasketControllers', 'BasketServices'
    , 'AddOfferControllers', 'AddOfferServices', 'SearchServices', 'SearchControllers', 'ui.grid', 'ui.grid.pagination', 'OfferDetailsServices', 'OfferDetailsControllers']);
mainApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.

        when('/angularDemo/:param', {
            templateUrl: '/templates/angularDemo.html',
            controller: 'AngularDemoController'
        }).

        when('/search', {
            templateUrl: '/templates/public/searchPage.html',
            controller: 'SearchController'
        }).

        when('/search/:pageNumber', {
            templateUrl: '/templates/public/searchPage.html',
            controller: 'SearchController'
        }).

        when('/error/:reasonOfError', {
            templateUrl: '/templates/error.html',
            controller: 'ErrorController'
        }).

        when('/offer/:offerId', {
            templateUrl: '/templates/public/offerDetails.html',
            controller: 'OfferDetailsController'
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





