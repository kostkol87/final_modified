'use strict';

angular.module('Login')
    .controller('LoginController', 
        function ($window, $scope, $state, $cookies, AuthenticationService, constants, $rootScope) {
    $scope.isLoading = false;
    $rootScope.bodylayout = 'body-login';

    function setCookieEmail(eMail) {
        var now = new $window.Date(),
            exp = new $window.Date(now.getFullYear(), now.getMonth() + 1, now.getDate());
        $cookies.putObject(constants.eMail, eMail, {
            expires: exp
        });
    }
if($scope.alerts == null){
        $scope.alerts = [];
    }    $scope.showAlerts = false;
    $scope.alerts = [];

    $scope.$on('$locationChangeStart', function (currentScope, newUrl) {
        var rememberMeCredentials = $cookies.getObject(constants.rememberMeName);
        var loggedIn = $cookies.getObject(constants.eMail);
        if (!rememberMeCredentials && !loggedIn && (newUrl.indexOf('registration') <= -1 || newUrl.indexOf('login') <= -1)) {
            currentScope.preventDefault();
        }
    });

    function chooseStateByRole(response) {
        switch (response.userEntity.role) {
            case "ROLE_ADMIN":
                return $state.go("admindashboard");
            case "ROLE_OPERATOR":
                return $state.go("operatordashboard");
            case "ROLE_TEACHER":
                return $state.go("teacherdashboard");
            case "ROLE_USER":
                return $state.go("studentdashboard");
            default :
                return $state.go("login");
        }
    }

    var rememberMeCredentials = $cookies.getObject(constants.rememberMeName);
    if (rememberMeCredentials) {
        AuthenticationService.login(rememberMeCredentials, function onSuccess(response) {
                chooseStateByRole(response);
            },
            function onError() {
                $cookies.remove(constants.rememberMeName);
            }
        );
    }

    var registration = $cookies.get("registration");
        if (registration == 'true') {
            $scope.showAlerts = true;
            $scope.alerts = [{type: 'success', msg: "Thank You! Please check your email to activate your account."}];
            $cookies.remove('registration');
        }
    var confirm = $cookies.get("confirm");
    if (confirm == 'true') {
        $scope.showAlerts = true;
        $scope.alerts = [{type: 'success', msg: "You have successfully registered your account"}];
        $cookies.remove('confirm');
    }
    if (confirm == 'false') {
        $scope.showAlerts = true;
        $scope.alerts = [{type: 'danger', msg: 'Account activation failed'}];
        $cookies.remove('confirm');
    }

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.login = function () {
        $scope.isLoading = true;
        $scope.showAlerts = false;
        AuthenticationService.login($scope.credentials, function onSuccess(response) {
                setCookieEmail(response.userEntity.eMail);
                $scope.isLoading = false;
                if ($scope.rememberMe === true) {
                    var now = new $window.Date(),
                        exp = new $window.Date(now.getFullYear(), now.getMonth() + 1, now.getDate());
                    $cookies.putObject(constants.rememberMeName, $scope.credentials, {
                        expires: exp
                    });
                } else {
                    $cookies.remove(constants.rememberMeName);
                }
                chooseStateByRole(response);
            },
            function onError(message) {
                if ($scope.alerts[0] != null) {
                    $scope.alerts.splice(0, 1);
                }
                $scope.alerts.push({type: 'danger', msg: message});
                $scope.isLoading = false;
                $state.go("login");
                $scope.showAlerts = true;
            }
        );
    };

    $scope.register = function () {
        $state.go("registration");
    }
});