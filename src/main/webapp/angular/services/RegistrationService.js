'use strict';

app.factory('RegistrationService', function (Network) {
    return {
        signUp: function (registrationData, onSuccess, onError) {
            Network.sendPost("./services/users/createUser", registrationData , onSuccess, onError);
        }
    };
});