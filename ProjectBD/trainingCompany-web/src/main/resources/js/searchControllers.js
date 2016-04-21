var searchControllers = angular.module(
    'SearchControllers', []);

searchControllers.controller('SearchController', ['$scope', '$routeParams', 'SearchService', 'SearchServiceRepo', '$location', function ($scope, $routeParams, SearchService, SearchServiceRepo, $location) {
    $scope.offers = [];

    if ($routeParams.pageNumber === undefined || $routeParams.pageNumber === null) {
        $scope.actualPageNmber = 1;
    } else {
        $scope.actualPageNmber = parseInt($routeParams.pageNumber);
    }

    $scope.reloadPage = function (pageNumber, query) {
        var url = '/search/';

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
        SearchServiceRepo.getOfferPageCount(requestBody, function (offersCount) {
            $scope.maxPageNmber = offersCount.value;
            $scope.pageNumberTab = SearchService.getPageNumberTab($scope.actualPageNmber, $scope.maxPageNmber);
        });

        SearchServiceRepo.getOfferPage({pageNumber: $scope.actualPageNmber}, requestBody, function (offers) {
            $scope.offers = offers;
        });
    };


    $scope.maxPageNmber = 1;
    $scope.pageNumberTab = SearchService.getPageNumberTab($scope.actualPageNmber, $scope.maxPageNmber);

    if (SearchService.getAllCategory() === undefined || SearchService.getAllCategory() === null || SearchService.getAllCategory().length === 0) {
        $scope.allCategory = [];
        SearchServiceRepo.getOfferCattegory(function (allCategory) {
            allCategory.forEach(function (category) {
                category.isSelected = false;
            });
            SearchService.setAllCategory(allCategory);
            $scope.allCategory = SearchService.getAllCategory();
            $scope.reloadOffer();
        });
    } else {
        $scope.allCategory = SearchService.getAllCategory();
        $scope.reloadOffer();
    }

    $scope.addToSelectedCategory = function (category) {
        if (category.isSelected === undefined || category.isSelected === null || category.isSelected === false) {
            category.isSelected = true;
        } else {
            category.isSelected = false;
        }
        SearchService.setAllCategory($scope.allCategory);
        $scope.reloadPage(null,null);
    }


}]);