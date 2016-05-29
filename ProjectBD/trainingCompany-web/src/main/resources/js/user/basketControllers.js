/**
 * Created by Mateusz on 2016-04-13.
 */
var basketControllers = angular.module(
    'BasketControllers', []);

basketControllers.controller('BasketController',
    ['$scope','$routeParams','BasketService', '$location', function($scope, $routeParams, BasketService, $location) {

        $scope.allOrders = BasketService.getAllOrders();
        $scope.allOrdersFromAllUsers = BasketService.getAllOrdersFromAllUsers();

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
                        if(!order.datePayment) {
                            $scope.totalCostAllOrders += order.offerPrice * order.offerQuantity;
                        }
                });
                return $scope.totalCostAllOrders;
        };
            
        $scope.totalAmount = function(){
                $scope.totalAmountAllOrders = 0;
                angular.forEach($scope.allOrders, function (order) {
                    if(!order.datePayment) {
                        $scope.totalAmountAllOrders += order.offerQuantity;
                    }
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
                    if(order.amount > 0) {
                        order.datePayment = new Date();
                        BasketService.reduceQuantity(order);
                        angular.forEach($scope.allOrdersFromAllUsers, function (orderFromAll) {
                            if (order.offerId == orderFromAll.offerId)
                            {
                                orderFromAll.amount = orderFromAll.amount - order.offerQuantity;
                                if ( orderFromAll.amount == 0)
                                {
                                    orderFromAll.offerQuantity = 0;
                                }
                                else if (orderFromAll.amount < orderFromAll.offerQuantity)
                                {
                                    orderFromAll.offerQuantity = orderFromAll.amount;
                                }
                            }
                            if (order.id != orderFromAll.id)
                            {
                                BasketService.saveOrder(orderFromAll);
                            }
                            else
                            {
                                BasketService.saveOrder(order);
                            }
                        $scope.paymentInformation = "Your transaction is correct. Payment was accepted.";
                        });
                    } else {
                        // Jeśli nie ma już ofert
                        $scope.paymentInformation = "We don't have more offerts to buy. Sorry.";
                    }
                } else {
                    $scope.paymentInformation = "Check order to pay."
                }
            });
        }

        $scope.remove = function(order) {
            var index = $scope.allOrders.indexOf(order);
            $scope.allOrders.splice(index, 1);
        }
        
        $scope.reloadPage = function(){
            window.location.reload();
        }

    }]);