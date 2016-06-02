/**
 * Created by Sebastian on 2016-05-23.
 */
var accountDetailsControllers = angular.module('AccountDetailsControllers', ['ngRoute']);

accountDetailsControllers.controller('AccountDetailsController',
    ['$scope', '$log', '$routeParams', 'AccountDetailsService', 'toaster',
        function ($scope, $log, $routeParams, AccountDetailsService, toaster) {

    $scope.normalText = /^[a-zA-Z0-9_]+$/i;
    $scope.emailRegex = /^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/i;
    $scope.phoneNumberRegex = /^\d{3,3} \d{3,3} \d{3,3}$/i;
    $scope.textWithSpaces = /^[a-zA-Z0-9_ ]+$/i;
    $scope.passwordRegex = /^\S+$/i;
    $scope.accountDetails = {};
    $scope.companyDetails = {};
    $scope.ifCompany = false;

    AccountDetailsService.getAccountDetails(function (accountDetails) {
        $scope.accountDetails = accountDetails;
        AccountDetailsService.getCompanyDetails(function (companyDetails) {
            $scope.companyDetails = companyDetails;
            if ($scope.companyDetails.id != -1) {
                $scope.ifCompany = true;
            }
        })
    });

    $scope.validationOK = true;
    $scope.showNoValidateDataInformation = [];

    $scope.update = function () {
        if ($scope.updateForm.$valid) {
            AccountDetailsService.updateAccountDetails($scope.accountDetails, function () {
            });

            $log.info('Form is valid');
            if (ifCompany) {
                AccountDetailsService.updateCompanyDetails($scope.companyDetails, function () {
                })
            }

            toaster.pop({
                type: 'success',
                title: 'Information updated',
                timeout: 5000
            });
        } else {
            $scope.showNoValidateDataInformation = true;
            $log.error('Form is not valid');
            toaster.pop({
                type: 'success',
                title: 'Something went wrong',
                timeout: 5000
            });
        }
    };

}]);

accountDetailsControllers.directive("repeatPassword", function() {
    return {
        require: "ngModel",
        link: function(scope, elem, attrs, ctrl) {
            var otherInput = elem.inheritedData("$formController")[attrs.repeatPassword];

            ctrl.$parsers.push(function(value) {
                if(value === otherInput.$viewValue) {
                    ctrl.$setValidity("repeat", true);
                    return value;
                }
                ctrl.$setValidity("repeat", false);
            });

            otherInput.$parsers.push(function(value) {
                ctrl.$setValidity("repeat", value === ctrl.$viewValue);
                return value;
            });
        }
    };
});