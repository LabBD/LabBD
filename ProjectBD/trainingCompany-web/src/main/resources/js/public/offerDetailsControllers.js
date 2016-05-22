/**
 * Created by Mateusz on 2016-04-28.
 */

var offerDetailsControllers = angular.module(
    'OfferDetailsControllers', []);

offerDetailsControllers.controller('OfferDetailsController',
    ['$scope', '$routeParams', 'OfferDetailsService', 'SearchService', '$location', 'toaster', function ($scope, $routeParams, OfferDetailsService, SearchService, $location, toaster) {

        $scope.offerID = $routeParams.offerId;
        $scope.attachments = [];
        $scope.notLogged = {};
        $scope.comments = [];
        $scope.canBuy = [];


        $scope.offerDetails = OfferDetailsService.getOfferDetails({
            offerId: $scope.offerID
        });

        OfferDetailsService.getAttachements({offerId: $scope.offerID}, function (attachements) {
            $scope.attachments = attachements;
        });

        OfferDetailsService.getComments({offerId: $scope.offerID}, function (comments) {
            $scope.comments = comments;
        });

        $scope.getCommentDate = function (comment) {
            var date = new Date(comment.date);
            return date.getUTCDay() + "." + date.getUTCMonth() + "." + date.getFullYear();
        };

        $scope.redirectToSearchPage = function () {
            var url = '/search';
            if (SearchService.lastQuery !== undefined && SearchService.lastQuery !== null && SearchService.lastQuery !== '') {
                $location.search().query = SearchService.lastQuery;
            }
            if (SearchService.lastPageNumber !== undefined && SearchService.lastPageNumber != null) {
                url = url + '/' + SearchService.lastPageNumber;
            }
            $location.path(url);
        };

        $scope.tooBigQuantity = function () {
            if ($scope.offerDetails.quantity < $scope.order.quantity || $scope.order.quantity === null) {
                $scope.canBuy = false;
                return true;
            } else {
                if (!$scope.notLogged) {
                    $scope.canBuy = true;
                }
                return false;
            }
        };

        OfferDetailsService.getUsername(function (username) {
            if (username.value === null) {
                $scope.notLogged = true;
                $scope.canBuy = false;
                $scope.username = '';
            } else {
                $scope.notLogged = false;
                if (!$scope.tooBigQuantity()) {
                    $scope.canBuy = true;
                }
                $scope.username = username;
            }
        });

        $scope.addToBasket = function () {
            if ($scope.notLogged || $scope.tooBigQuantity()) {
                //modal zostaje widoczny
            }
            else {
                $scope.DtoOrder = {};
                $scope.DtoOrder.offerId = $scope.offerID;
                $scope.DtoOrder.offerName = $scope.offerDetails.name;
                $scope.DtoOrder.offerPrice = $scope.offerDetails.price;
                $scope.DtoOrder.offerQuantity = $scope.order.quantity;
                $scope.DtoOrder.amount = $scope.offerDetails.quantity;
                $scope.DtoOrder.basketId = "";
                $scope.DtoOrder.id = "";

                OfferDetailsService.addOrder($scope.DtoOrder, function () {
                });

                toaster.pop({
                    type: 'success',
                    title: 'Added to basket',
                    body: 'Go to basket to finalize order and buy',
                    timeout: 3000
                });
                // $scope.offerDetails = OfferDetailsService.getOfferDetails({
                //     offerId: $scope.offerID
                // });
            }
        };

        // comments pagination
        $scope.currentPage = 0;
        $scope.pageSize = 4;
        $scope.numberOfPages = function () {
            return Math.ceil($scope.comments.length / $scope.pageSize);
        };

    }]);

offerDetailsControllers.filter('startFrom', function () {
    return function (input, start) {
        start = +start; //parse to int
        return input.slice(start);
    };
});