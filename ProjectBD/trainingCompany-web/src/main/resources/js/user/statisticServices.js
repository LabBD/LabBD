var statisticServices = angular.module(
    'StatisticServices', ['ngResource']);

statisticServices.factory('StatisticServiceRepo', [
    '$resource', function ($resource) {
        return $resource('', {}, {

            getOfferCattegory: {
                method: 'GET',
                url: '/offerCategory/all',
                isArray: true
            },
            getMyOfferPageStatistic: {
                params: {pageNumber: "@pageNumber"},
                method: 'POST',
                url: '/guest/statistic/my/page/:pageNumber',
                isArray: true
            },

            getMyOfferPageCount: {
                method: 'POST',
                url: '/offer/my/page/count'
            }

        });
    }]);


statisticServices.service('StatisticService', function () {

    var allCategory = [];

    this.lastQuery = '';

    this.lastPageNumber = 1;


    this.setAllCategory = function (newAllCategory) {
        allCategory = newAllCategory;
    };

    this.getAllCategory = function () {
        return allCategory;
    };

    this.getPageNumberTab = function(actualPageNmber, maxPageNmber){
        var pageNumberTab = [];
        if (actualPageNmber - 2 >= 1) {
            pageNumberTab.push(actualPageNmber - 2)
        }else{
            if (actualPageNmber + 3 <= maxPageNmber) {
                pageNumberTab.push(actualPageNmber + 3)
            }
        }
        if (actualPageNmber - 1 >= 1) {
            pageNumberTab.push(actualPageNmber - 1)
        }else{
            if (actualPageNmber + 4 <= maxPageNmber) {
                pageNumberTab.push(actualPageNmber + 4)
            }
        }
        pageNumberTab.push(actualPageNmber);

        if (actualPageNmber + 1 <= maxPageNmber) {
            pageNumberTab.push(actualPageNmber + 1)
        }else{
            if (actualPageNmber -4 >= 1) {
                pageNumberTab.push(actualPageNmber - 4)
            }
        }
        if (actualPageNmber + 2 <= maxPageNmber) {
            pageNumberTab.push(actualPageNmber + 2)
        }else{
            if (actualPageNmber - 3 >= 1) {
                pageNumberTab.push(actualPageNmber - 3)
            }
        }
        pageNumberTab.sort();
        return pageNumberTab;
    };


});