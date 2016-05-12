/**
 * Created by Mateusz on 2016-04-28.
 */

var offerDetailsControllers = angular.module(
    'OfferDetailsControllers', []);

offerDetailsControllers.controller('OfferDetailsController',
    ['$scope','$routeParams','OfferDetailsService','SearchService','$location','toaster' , function($scope, $routeParams, OfferDetailsService, SearchService, $location,toaster) {
    
        $scope.offerID = $routeParams.offerId;
        $scope.attachments=[];

        $scope.offerDetails = OfferDetailsService.getOfferDetails({
            offerId: $scope.offerID
        });

        OfferDetailsService.getAttachements({offerId: $scope.offerID},function(attachements){
            $scope.attachments=attachements;
        });


        $scope.redirectToSearchPage = function(){
            var url = '/search';
            if(SearchService.lastQuery!==undefined && SearchService.lastQuery!==null && SearchService.lastQuery !== ''){
                $location.search().query = SearchService.lastQuery;
            }
            if(SearchService.lastPageNumber!==undefined && SearchService.lastPageNumber!=null){
                url = url + '/' + SearchService.lastPageNumber;
            }
            $location.path(url);
        }

        $scope.addToBasket = function(){
            toaster.pop({
                type: 'success',
                title: 'Title text',
                body: 'Body text',
                timeout: 3000
            });
        }


    }]);