var addOfferControllers = angular.module(
    'AddOfferControllers', []);

addOfferControllers.controller('AddOfferController', ['$scope', '$routeParams', '$http', '$location', 'AddOfferService', 'OfferDetailsService', 'AddOfferServiceRepo',
    function ($scope, $routeParams, $http, $location, AddOfferService, OfferDetailsService, AddOfferServiceRepo) {
        $scope.allCategory = [];
        $scope.duration = "3";
        $scope.isEditMode = false;
        $scope.offerDetails = undefined;
        $scope.allCategory = [];
        if (AddOfferService.getAllCategory() === undefined || AddOfferService.getAllCategory() === null || AddOfferService.getAllCategory().length === 0) {
            AddOfferServiceRepo.getOfferCategory(function (allCategory) {
                AddOfferService.setAllCategory(allCategory);
                $scope.allCategory = AddOfferService.getAllCategory();
            });
        } else {
            $scope.allCategory = AddOfferService.getAllCategory();
        }
        $scope.categorySel = $scope.allCategory[1];
        var url = $location.path();
        if (url.indexOf("/editOffer") > -1) {
            $scope.offerIdNum = $routeParams.offerId;
            $scope.isEditMode = true;
            OfferDetailsService.getOfferDetails({offerId: $scope.offerIdNum}, function (offerModel) {
                $scope.offerDetails = offerModel;
                $scope.title = $scope.offerDetails.name;
                $scope.quantity = $scope.offerDetails.quantity;
                $scope.price = $scope.offerDetails.price;
                $scope.description = $scope.offerDetails.description;
                $scope.categorySel = $scope.offerDetails.offerCategoryName;
            });
        }

        $scope.saveNewOffer = function () {
            var offerReqBody = {
                title: $scope.title,
                quantity: $scope.quantity,
                price: $scope.price,
                categoryName: $scope.categorySel,
                duration: $scope.duration,
                description: $scope.description
            };

            AddOfferServiceRepo.saveOffer(offerReqBody, function (rsp) {
                $scope.responseMsg = rsp.message;
                $scope.addedOfferId = rsp.offerId;
                $scope.detectedRsp(rsp);
                $scope.redirecToMyOffers(rsp);
            });
        };

        $scope.updateOffer = function () {
            var offerReqBody = {
                id: $scope.offerDetails.id,
                title: $scope.title,
                quantity: $scope.quantity,
                price: $scope.price,
                categoryName: $scope.categorySel,
                duration: $scope.duration,
                description: $scope.description
            };
            
            AddOfferServiceRepo.updateOffer(offerReqBody, function (rsp) {
                $scope.responseMsg = rsp.message;
                $scope.detectedRsp(rsp);
                $scope.redirecToMyOffers(rsp);
            });
        };

        $scope.detectedRsp = function (rsp) {
            setTimeout(function () {
                $('#rspModal').modal('show');
            }, 150);
            setTimeout(function () {
                $('#rspModal').modal('hide');
            }, 3000);
        };

        $scope.redirecToMyOffers = function (rsp) {
            if (rsp.isOfferAdded) {
                window.setTimeout(function () {
                    window.location = "#/myOffers";
                }, 3000);
            }
        }
        
    }]);