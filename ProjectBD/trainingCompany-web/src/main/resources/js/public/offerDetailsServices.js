/**
 * Created by Mateusz on 2016-04-28.
 */

var offerDetailsServices  = angular.module(
    'OfferDetailsServices', ['ngResource']);

offerDetailsServices.factory('OfferDetailsService', [
    '$resource', function ($resource) {
        return $resource('', {}, {
            getOfferDetails: {
                method: 'GET',
                url: '/offer/:offerId',
                params: {offerId: "@offerId"}
            },

            getAttachements: {
                method: 'GET',
                url: 'attachment/offer/:offerId',
                params: {offerId: "@offerId"},
                isArray: true
            }
            
            
        });
    }]);
