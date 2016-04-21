var angularDemoControllers = angular.module(
    'AngularDemoControllers', []);

angularDemoControllers.controller('AngularDemoController', ['$scope', '$routeParams', 'AngularDemoService', 'uiGridConstants', function ($scope, $routeParams, AngularDemoService, uiGridConstants) {
    $scope.demo = "Elo";

    $scope.param = $routeParams.param;

    $scope.getSection = function (sectionId) {
        $scope.section = AngularDemoService.getSection({id: 1}, function (section) {
            $scope.section = section;
        });
    }

    $scope.deleteModel = function () {
        AngularDemoService.deleteSection({id: 1}, $scope.section);
    }

    $scope.logoutUser = function(){
        AngularDemoService.logout();
    }

    $scope.gridOptions = {
        enableFiltering: true,
        paginationPageSizes: [1, 2, 3],
        paginationPageSize: 1,
        onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
        },
        columnDefs: [
            {
                field: "firstName",
                width: "*" ,
                filters: [
                {
                    condition: uiGridConstants.filter.CONTAINS,
                    placeholder: 'contains'
                }]
            },
            {field: "lastName",width: "*" },
            { field: 'company',width: "*" ,
                //cellClass: function(grid, row, col, rowRenderIndex, colRenderIndex) {
                //    var value;
                //   // if (grid.getCellValue(row,col) === 'Velity') {
                //        return '<button>'+ grid.getCellValue(row,col)+'</button>';
                //   // }
                //},
                cellTemplate:"<button> {{row.entity.company}}</button>"
            },
            {field: "employed",width: "*" ,
            cellTemplate:"<input type='checkbox' ng-model='row.entity.employed'/> "}
        ]
    };

    $scope.gridOptions.data = [
        {
            "firstName": "Cox",
            "lastName": "Carney",
            "company": "Enormo",
            "employed": true
        },
        {
            "firstName": "Lorraine",
            "lastName": "Wise",
            "company": "Comveyer",
            "employed": false
        },
        {
            "firstName": "Nancy",
            "lastName": "Waters",
            "company": "Fuelton",
            "employed": false
        }
    ];

}]);