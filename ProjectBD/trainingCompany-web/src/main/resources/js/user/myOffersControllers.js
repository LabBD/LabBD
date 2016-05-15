var myOffersControllers = angular.module(
    'MyOffersControllers', []);

myOffersControllers.controller('MyOffersController', ['$scope', '$routeParams', 'MyOffersService', 'MyOffersServiceRepo', '$location', function ($scope, $routeParams, MyOffersService, MyOffersServiceRepo, $location) {
    $scope.offers = [];
    $scope.title="My offers:";
    $scope.categoryIsLoaded=false;
    $scope.offersIsLoaded=false;

    if ($routeParams.pageNumber === undefined || $routeParams.pageNumber === null) {
        $scope.actualPageNmber = 1;
    } else {
        $scope.actualPageNmber = parseInt($routeParams.pageNumber);
    }

    $scope.reloadPage = function (pageNumber, query) {
        var url = '/myOffers/';

        if (pageNumber === null) {
            url += '1'
        } else {
            url += pageNumber
        }
        if (query !== null) {
            $location.search().query= query;
        }

        $location.path(url);
        $scope.reloadOffer();
    };
    $scope.reloadOffer = function () {
        var requestBody = {
            selectedOfferCategory: [],
            query: $location.search().query
        }
        $scope.allCategory.forEach(function (offerCategory) {
            if (offerCategory.isSelected === true) {
                requestBody.selectedOfferCategory.push(offerCategory);
            }
        });
        MyOffersServiceRepo. getMyOfferPageCount(requestBody, function (offersCount) {
            $scope.maxPageNmber = offersCount.value;
            if($scope.maxPageNmber< $scope.actualPageNmber)
                $scope.reloadPage(null,null);
            $scope.pageNumberTab = MyOffersService.getPageNumberTab($scope.actualPageNmber, $scope.maxPageNmber);
        });

        MyOffersServiceRepo. getMyOfferPage({pageNumber: $scope.actualPageNmber}, requestBody, function (offers) {
            $scope.offers = offers;
            $scope.offersIsLoaded=true;
        });
    };


    $scope.maxPageNmber = 1;
    $scope.pageNumberTab = MyOffersService.getPageNumberTab($scope.actualPageNmber, $scope.maxPageNmber);

    if (MyOffersService.getAllCategory() === undefined || MyOffersService.getAllCategory() === null || MyOffersService.getAllCategory().length === 0) {
        $scope.allCategory = [];
        MyOffersServiceRepo.getOfferCattegory(function (allCategory) {
            allCategory.forEach(function (category) {
                category.isSelected = false;
            });
            MyOffersService.setAllCategory(allCategory);
            $scope.allCategory = MyOffersService.getAllCategory();
            $scope.categoryIsLoaded=true;
            $scope.reloadOffer();
        });
    } else {
        $scope.allCategory = MyOffersService.getAllCategory();
        $scope.categoryIsLoaded=true;
        $scope.reloadOffer();
    }

    $scope.addToSelectedCategory = function (category) {
        if (category.isSelected === undefined || category.isSelected === null || category.isSelected === false) {
            category.isSelected = true;
        } else {
            category.isSelected = false;
        }
        MyOffersService.setAllCategory($scope.allCategory);
        $scope.reloadPage(null,null);
    }

    $scope.redirectToOfferPage = function(offer){
        MyOffersService.lastQuery = $location.search().query;
        MyOffersService.lastPageNumber = $scope.actualPageNmber;
        $location.url($location.path());
        $location.path('/offer/'+ offer.id);
    }

    $scope.searchPhrase = function (phrase) {
        if (typeof phrase === 'undefined') {
            $location.path('/myOffers/1');
            //window.location = "../#/search/1";
        } else {
            //window.location = "/search/1?query=" + phrase;
            $location.search().query= phrase;
            $location.path('/myOffers/1');
        }

    };

}]);