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
                url: '../order/offers',
                isArray: true
            },
            deleteOrder: {
                params: {id: "@id"},
                method: 'DELETE',
                url: '../order/delete/{id}'
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
