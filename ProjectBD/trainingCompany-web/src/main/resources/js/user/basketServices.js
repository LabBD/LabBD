/**
 * Created by Mateusz on 2016-04-13.
 */
var basketServices  = angular.module(
    'BasketServices', ['ngResource']);

basketServices.factory('BasketService', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            getAllOrders: {
                method: 'GET',
                url: '../order/my',
                isArray: true
            },
            deleteOrder: {
                method: 'POST',
                url: '../order/delete/:id'
            },
            saveOrder: {
                method: 'POST',
                url: '../order/save'
            },
            reduceQuantity: {
                method: 'POST',
                url: '../offer/reduceQuantity'
            },
            getAllOrdersFromAllUsers: {
                method: 'GET',
                url: '../order/all',
                isArray: true
            }
            //           getSection: { //nazwa metody
            //               params: {id: "@id"}, // parametry
            //              method: 'GET', // typ żądania
            //               url: '../section/:id', // url żądania
            //               isArray:true // jeżeli oczekujemy tablicy 
            //           }
// poniżej oczywiście można dodać wpizdu takich (, pomiędzy)
        });
    }]);
