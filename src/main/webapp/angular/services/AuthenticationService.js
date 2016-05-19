'use strict';

app.factory('AuthenticationService', function ($state, $cookies, Network, constants, $rootScope) {
    return {
        login: function (credentials, onSuccess, onError) {
            var ascii = /^[ -~]+$/;
            if (!ascii.test(credentials.username) || (!ascii.test(credentials.password)))
                return onError("Username or password must be written using only Latin letters and special symbols, please try again.");
            var headers = credentials ? {authorization: "Basic " + btoa(credentials.username + ":" + credentials.password)} : {};
            Network.sendGetHeaders('./services/authentication/login', {}, headers, onSuccess, onError);
        },

        logout: function (onSuccess, onError) {
            $cookies.remove(constants.rememberMeName);
            $cookies.remove(constants.eMail);
            $rootScope.imageAvatar = null;
            Network.sendGet("./services/authentication/logout", {}, onSuccess, onError);
        }
    };
});