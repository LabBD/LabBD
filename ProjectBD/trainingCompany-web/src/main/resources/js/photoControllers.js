var photoControllers = angular.module(
    'PhotoControllers', []);

photoControllers.controller('PhotoController', ['$scope', 'PhotoService', function ($scope, PhotoService) {
    $scope.photos = [];
    $scope.photos = PhotoService.getPhotos();

}]);