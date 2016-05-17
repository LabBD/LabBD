/**
 * Created by Mateusz on 2016-04-28.
 */

var offerDetailsControllers = angular.module(
    'OfferDetailsControllers', []);

offerDetailsControllers.controller('OfferDetailsController',
    ['$scope','$routeParams','OfferDetailsService','SearchService','$location','toaster' , function($scope, $routeParams, OfferDetailsService, SearchService, $location,toaster) {
    
        $scope.offerID = $routeParams.offerId;
        $scope.attachments=[];
        $scope.notLogged = {};

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

        $scope.tooBigQuantity = function () {
            if($scope.offerDetails.quantity < $scope.order.quantity)
                return true;
            else
                return false;
        };

        OfferDetailsService.getUsername(function (username) {
            if (username.value === null) {
                $scope.notLogged = true;
                $scope.username = '';
            } else {
                $scope.notLogged = false;
                $scope.username = username;
            }
        });

        $scope.addToBasket = function () {
            $scope.DtoOrder = {};
            $scope.DtoOrder.offerId = $scope.offerID;
            $scope.DtoOrder.offerName = $scope.offerDetails.name;
            $scope.DtoOrder.offerPrice = $scope.offerDetails.price;
            $scope.DtoOrder.offerQuantity = $scope.order.quantity;
            $scope.DtoOrder.amount = "";
            $scope.DtoOrder.basketId = ""
            $scope.DtoOrder.id = "";

            OfferDetailsService.addOrder($scope.DtoOrder, function () {
            });
            //jakies sprawdzenie czy wgl sie udalo zapisac w backendzie to zamowienie
            toaster.pop({
                type: 'success',
                title: 'Title text',
                body: 'Body text',
                timeout: 3000
            });
            $scope.offerDetails = OfferDetailsService.getOfferDetails({
                offerId: $scope.offerID
            });

        }


    }]);