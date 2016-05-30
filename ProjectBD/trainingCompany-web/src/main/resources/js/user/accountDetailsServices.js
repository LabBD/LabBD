/**
 * Created by Sebastian on 2016-05-23.
 */
var accountDetailsServices = angular.module('AccountDetailsServices', ['ngResource']);

accountDetailsServices.factory('AccountDetailsService',
    ['$resource', function ($resource) {
        return $resource('', {}, {
            getAccountDetails: {
                method: 'POST',
                url: '/account/details'
            },
            getCompanyDetails: {
                method: 'POST',
                url: '/company/details'
            },
            updateAccountDetails: {
                method: 'POST',
                url: '/account/update'
            },
            updateCompanyDetails: {
                method: 'POST',
                url: 'company/update'
            }
        });
    }]);