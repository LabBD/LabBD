var searchControllers = angular.module(
    'SearchControllers', []);

searchControllers.controller('SearchController', ['$scope', '$routeParams', 'SearchService', 'SearchServiceRepo', function ($scope, $routeParams, SearchService, SearchServiceRepo) {

    $scope.reloadOffer = function(){
        var selectedOfferCategory = [];
        $scope.allCategory.forEach(function(offerCategory){
            if(offerCategory.isSelected===true){
                selectedOfferCategory.push(offerCategory);
            }
        });
        SearchServiceRepo.getOfferPage({pageNumber: $scope.actualPageNmber},selectedOfferCategory,function (offers) {
            $scope.offers = offers;
        });
    };

    if ($routeParams.pageNumber === undefined || $routeParams.pageNumber === null) {
        $scope.actualPageNmber = 1;
    } else {
        $scope.actualPageNmber = parseInt($routeParams.pageNumber);
    }
    $scope.maxPageNmber=20;
    $scope.pageNumberTab = SearchService.getPageNumberTab($scope.actualPageNmber,$scope.maxPageNmber);

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
        $scope.reloadOffer();
    }
    $scope.offers = [];


}]);