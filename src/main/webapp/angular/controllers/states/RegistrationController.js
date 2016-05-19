'use strict';

angular.module('Registration').controller('RegistrationController', function ($scope, $state, RegistrationService, $rootScope) {
    $rootScope.bodylayout = 'body-login';
    $scope.alerts = [];
    $scope.showAlerts = false;

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.signUp = function () {
        $scope.showAlerts = false;
        RegistrationService.signUp($scope.registrationData,
            function onSuccess(payload) {
                if( $scope.alerts[0] != null) {
                    $scope.alerts.splice(0, 1);
                }
                $scope.alerts.push({type: 'danger', msg: payload.message});
                $scope.showAlerts = true;
                if (payload.isRegistered)
                    $state.go("login");
            },
            function onError() {
                $state.go("registration");
            }
        );
    };

    $scope.backToLogin = function () {
        $state.go("login");
    }
});