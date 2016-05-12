var addOfferControllers = angular.module(
    'AddOfferControllers', []);

addOfferControllers.controller('AddOfferController', ['$scope', '$routeParams', 'AddOfferService', 'AddOfferServiceRepo', function ($scope, $routeParams, AddOfferService, AddOfferServiceRepo) {
    if (AddOfferService.getAllCategory() === undefined || AddOfferService.getAllCategory() === null || AddOfferService.getAllCategory().length === 0) {
        $scope.allCategory = [];
        AddOfferServiceRepo.getOfferCategory(function (allCategory) {
            AddOfferService.setAllCategory(allCategory);
            $scope.allCategory = AddOfferService.getAllCategory();
        });
    } else {
        $scope.allCategory = AddOfferService.getAllCategory();
    }

    var minDate = new Date();

}]);