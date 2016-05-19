'use strict';

app.factory('UsersService.js', function (Network) {
    return {
        getUser: function (userID, onSuccess, onError) {
            Network.sendGet("./services/users/getUser",{"id" : userID}, onSuccess, onError);
        },
        getAllUser: function (onSuccess, onError) {
            Network.sendGet("./services/users/getAllUsers", onSuccess, onError);
        },
    };
});