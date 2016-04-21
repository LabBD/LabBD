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
                    $scope.checkAll = false;
            }
                angular.forEach($scope.allOrders, function (order) {
                        order.check = $scope.checkAll;
                });
        };

        $scope.totalCost = function(){
                $scope.totalCostAllOrders = 0;
                angular.forEach($scope.allOrders, function (order) {
                        $scope.totalCostAllOrders += order.offerPrice*order.amount;
                });
                return $scope.totalCostAllOrders;
        };
            
        $scope.totalAmount = function(){
                $scope.totalAmountAllOrders = 0;
                angular.forEach($scope.allOrders, function (order) {
                        $scope.totalAmountAllOrders += order.amount;
                });
                return $scope.totalAmountAllOrders;
        };
            
        $scope.allOrders = BasketService.getAllOrders();

        $scope.delete = function () {
                BasketService.deleteOrder({id:1});
                $location.reload();
        }

    }]);