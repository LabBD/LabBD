/**
 * Created by Mateusz on 2016-04-13.
 */
var basketControllers = angular.module(
    'BasketControllers', []);

basketControllers.controller('BasketController',
    ['$scope','$routeParams','BasketService', '$location', function($scope, $routeParams, BasketService, $location) {

        $scope.allOrders = BasketService.getAllOrders();

        angular.forEach($scope.allOrders, function (order) {
            if (!order.datePayment) {
                $scope.remove(order);
            }
        });

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
        
        $scope.delete = function () {
            angular.forEach($scope.allOrders, function (order) {
                if(order.check){
                    BasketService.deleteOrder({id:order.offerId}, order);
                }
            });
            window.location.reload();
        }


        $scope.redirectToOfferPage = function(order){
            $location.path('/offer/'+ order.offerId);
        }

        $scope.pay = function(){
            angular.forEach($scope.allOrders, function (order) {
                if(order.check){
                    order.datePayment = new Date();
                    BasketService.saveOrder(order);
                    $scope.remove(order);
                }
            });
            //window.location.reload();
        }

        $scope.remove = function(order) {
            var index = $scope.allOrders.indexOf(order);
            $scope.allOrders.splice(index, 1);
        }

    }]);