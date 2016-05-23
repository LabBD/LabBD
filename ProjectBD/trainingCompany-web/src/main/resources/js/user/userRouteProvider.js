var mainApp = angular.module("mainApp", ['ngRoute', 'ngAnimate','toaster','IndexControllers', 'IndexServices',
    'AngularDemoControllers', 'AngularDemoServices', 'ErrorControllers', 'BasketControllers', 'BasketServices'
    , 'AddOfferControllers', 'AddOfferServices', 'SearchServices', 'SearchControllers', 'ui.grid', 'ui.grid.pagination',
    'OfferDetailsServices', 'OfferDetailsControllers','MyOffersServices','MyOffersControllers'
    , 'StatisticServices', 'StatisticControllers','googlechart']);


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

        when('/myOffers', {
            templateUrl: '/templates/public/searchPage.html',
            controller: 'MyOffersController'
        }).

        when('/myOffers/:pageNumber', {
            templateUrl: '/templates/public/searchPage.html',
            controller: 'MyOffersController'
        }).

        when('/statistic', {
            templateUrl: '/templates/user/statisticPage.html',
            controller: 'StatisticController'
        }).

        when('/statistic/:pageNumber', {
            templateUrl: '/templates/user/statisticPage.html',
            controller: 'StatisticController'
        }).

        when('/search/:pageNumber', {
            templateUrl: '/templates/public/searchPage.html',
            controller: 'SearchController'
        }).

        when('/error/:reasonOfError', {
            templateUrl: '/templates/public/error.html',
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

mainApp.run(['$rootScope', '$location', 'IndexService', function ($rootScope, $location, IndexService) {
    $rootScope.$on('$routeChangeStart', function (event) {

            IndexService.getLoggedUsername(function (username) {
                if (username.value === null) {
                    window.location = "/#" + $location.path();
                }
            });
            //window.alert($location.path().toString());
            //if (!Auth.isLoggedIn()) {
            //    console.log('DENY');
            //    event.preventDefault();
            //    $location.path('/login');
            //}
            //else {
            //    console.log('ALLOW');
            //    $location.path('/home');
            //}
        }
    );
}]);



