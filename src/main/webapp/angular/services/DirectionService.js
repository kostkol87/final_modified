'use strict';

app.factory('DirectionService.js', function (Network) {
    return {
        getDirections: function (onSuccess, onError) {
            Network.sendGet("./services/directions/getDirections", onSuccess, onError);
        },
        getDirection: function (directionID, onSuccess, onError) {
            Network.sendGet("./services/directions/getDirection", {"id": directionID}, onSuccess, onError);
        },
    };
});