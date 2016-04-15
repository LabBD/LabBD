/**
 * Created by Mateusz on 2016-04-13.
 */
var basketControllers = angular.module(
    'BasketControllers', []);

basketControllers.controller('BasketController',
    ['$scope','$routeParams','BasketService', function($scope, $routeParams, BasketService) {

        $scope.selectAll = function () {
            if ($scope.checkAll) {
                    $scope.checkAll = true;
            } else {
                    $scope.checkdAll = false;
            }
                angular.forEach($scope.allOrders, function (order) {
                        order.check = $scope.checkAll;
                });
        };

        $scope.allOrders = BasketService.getAllOrders();
            
        $scope.totalCost = function(price) {
                $scope.total = 0;
                total = total + price;
                
        }    

    }]);