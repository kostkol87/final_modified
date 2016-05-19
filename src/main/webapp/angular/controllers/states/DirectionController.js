'use strict';

angular.module('Directions').controller('DirectionController', function ($scope, $state, $rootScope, DirectionService) {
    $scope.directions = {};
    function getAllDirections() {
        DirectionService.getDirections(
            function onSuccess(payload) {
                $scope.directions = payload
            },
            function onError() {
                $state.go("Login");
            }
        );
    }

});