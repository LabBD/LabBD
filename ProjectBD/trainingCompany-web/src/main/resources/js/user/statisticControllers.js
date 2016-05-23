var statisticControllers = angular.module(
    'StatisticControllers', []);

statisticControllers.controller('StatisticController', ['$scope', '$routeParams', 'StatisticService', 'StatisticServiceRepo', '$location', function ($scope, $routeParams, StatisticService, StatisticServiceRepo, $location) {
    $scope.offersStatistic = [];
    $scope.title="My statistic:";
    $scope.categoryIsLoaded=false;
    $scope.offersIsLoaded=false;



    if ($routeParams.pageNumber === undefined || $routeParams.pageNumber === null) {
        $scope.actualPageNmber = 1;
    } else {
        $scope.actualPageNmber = parseInt($routeParams.pageNumber);
    }

    $scope.reloadPage = function (pageNumber, query) {
        var url = '/statistic/';

        if (pageNumber === null) {
            url += '1'
        } else {
            url += pageNumber
        }
        if (query !== null) {
            $location.search().query= query;
        }

        $location.path(url);
        $scope.reloadOffer();
    };
    $scope.reloadOffer = function () {
        var requestBody = {
            selectedOfferCategory: [],
            query: $location.search().query
        }
        $scope.allCategory.forEach(function (offerCategory) {
            if (offerCategory.isSelected === true) {
                requestBody.selectedOfferCategory.push(offerCategory);
            }
        });
        StatisticServiceRepo. getMyOfferPageCount(requestBody, function (offersCount) {
            $scope.maxPageNmber = offersCount.value;
            if($scope.maxPageNmber< $scope.actualPageNmber)
                $scope.reloadPage(null,null);
            $scope.pageNumberTab = StatisticService.getPageNumberTab($scope.actualPageNmber, $scope.maxPageNmber);
        });

        StatisticServiceRepo. getMyOfferPageStatistic({pageNumber: $scope.actualPageNmber}, requestBody, function (offersStatistic) {
            $scope.offersStatistic = offersStatistic;
            $scope.offersStatistic.forEach(function(offerStatistic){

                var myChartObject = {};
                myChartObject.type = "ColumnChart";

                var onions = [
                    {v: 'test'},
                    {v: 3}
                ];

                myChartObject.data = {"cols": [
                    {id: "t", label: "Topping", type: "string"}
                    ,{id: "s", label: "View", type: "number"}
                    ,{role: "style", type: "string"}
                ], "rows": [
                    //{c:onions}

                ]};
                var iterator =0;
                offerStatistic.numberOfVisits.forEach(function(number){
                    var d1 = new Date(offerStatistic.dates[iterator]);
                    var d2 = new Date(offerStatistic.dates[iterator+1]);
                    var stat = [
                        {v: d1.toLocaleDateString()+" - "+d2.toLocaleDateString()},
                        {v: number},
                        {v: "green" }
                    ];
                    iterator++;
                    myChartObject.data.rows.push({c: stat});
                });

                myChartObject.options = {
                    'title': 'View statistics'
                    ,colors: ['008000']
                };

                offerStatistic.chartObject = myChartObject;
            });
            $scope.offersIsLoaded=true;
        });
    };


    $scope.maxPageNmber = 1;
    $scope.pageNumberTab = StatisticService.getPageNumberTab($scope.actualPageNmber, $scope.maxPageNmber);

    if (StatisticService.getAllCategory() === undefined || StatisticService.getAllCategory() === null || StatisticService.getAllCategory().length === 0) {
        $scope.allCategory = [];
        StatisticServiceRepo.getOfferCattegory(function (allCategory) {
            allCategory.forEach(function (category) {
                category.isSelected = false;
            });
            StatisticService.setAllCategory(allCategory);
            $scope.allCategory = StatisticService.getAllCategory();
            $scope.categoryIsLoaded=true;
            $scope.reloadOffer();
        });
    } else {
        $scope.allCategory = StatisticService.getAllCategory();
        $scope.categoryIsLoaded=true;
        $scope.reloadOffer();
    }

    $scope.addToSelectedCategory = function (category) {
        if (category.isSelected === undefined || category.isSelected === null || category.isSelected === false) {
            category.isSelected = true;
        } else {
            category.isSelected = false;
        }
        StatisticService.setAllCategory($scope.allCategory);
        $scope.reloadPage(null,null);
    }



    $scope.searchPhrase = function (phrase) {
        if (typeof phrase === 'undefined') {
            $location.path('/statistic/1');
            //window.location = "../#/search/1";
        } else {
            //window.location = "/search/1?query=" + phrase;
            $location.search().query= phrase;
            $location.path('/statistic/1');
        }

    };

}]);