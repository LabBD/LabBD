var mainApp = angular.module("mainApp", ['ngRoute', 'IndexControllers', 'IndexServices', 'PhotoControllers'
    , 'PhotoServices', 'AngularDemoControllers', 'AngularDemoServices'
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

        otherwise({
            templateUrl: '/templates/public/main.html',
            controller: 'MainPageController'
        });
}]);

mainApp.run(['$rootScope', '$location', 'IndexService', function ($rootScope, $location, IndexService) {
    $rootScope.$on('$routeChangeStart', function (event) {

            IndexService.getLoggedUsername(function (username) {
                if (username.value !== null) {
                    window.location = "/user/#" + $location.path();
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



