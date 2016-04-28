/**
 * Created by Mateusz on 2016-04-28.
 */

var offerDetailsControllers = angular.module(
    'OfferDetailsControllers', []);

offerDetailsControllers.controller('OfferDetailsController',
    ['$scope','$routeParams','OfferDetailsService', function($scope, $routeParams, OfferDetailsService) {
    
        $scope.offerID = $routeParams.offerId;
        $scope.offerDetails = OfferDetailsService.getOfferDetails({
            offerId: $scope.offerID
        });


    }]);