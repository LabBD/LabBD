var addOfferServices = angular.module(
    'AddOfferServices', ['ngResource']);

addOfferServices.factory('AddOfferServiceRepo', [
    '$resource', function ($resource) {
        return $resource('', {}, {

            getOfferCategory: {
                method: 'GET',
                url: '/offerCategory/all',
                isArray: true
            },
            saveOffer: {
                method: 'POST',
                url: '/offer/saveNew'
             }

        });
    }]);

addOfferServices.service('AddOfferService', function () {
    var allCategory = [];

    this.setAllCategory = function (allCat) {
        allCategory = allCat;
    };

    this.getAllCategory = function () {
        return allCategory;
    };

 });