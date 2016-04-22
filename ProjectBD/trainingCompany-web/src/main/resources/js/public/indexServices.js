var IndexServices = angular.module(
    "IndexServices", ['ngResource']);

IndexServices.factory('IndexService', [
    '$resource', function ($resource) {
        return $resource('', {}, {

            login: {
                method: 'POST',
                url: '/login'
            },

            getLoggedUsername: {
                method: 'GET',
                url: '/account/logged/name'
            },

            getUser: {
                params: {id: "@id"},
                method: 'GET',
                url: '../user/:id'
            },
            postGret: {
                params: {id: "@id"},
                method: 'POST',
                url: '../gret/save/:id'
            },

            getGret: {
                params: {id: "@id"},
                method: 'GET',
                url: '../gret/:id'
            },

            postUser: {
                method: 'POST',
                url: '../user'
                //               isArray: true
            }
        });
    }]);