var angularDemoControllers = angular.module(
    'AngularDemoControllers', []);

angularDemoControllers.controller('AngularDemoController',['$scope','$routeParams','AngularDemoService', function($scope,$routeParams,AngularDemoService) {
   $scope.demo="Elo";

    $scope.param = $routeParams.param;

    $scope.getSection = function(sectionId){
        $scope.section = AngularDemoService.getSection({id:1},function(section){
            $scope.section =section;
        });
    }


}]);