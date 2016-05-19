(function(window, angular){
    'use strict';

    function utils(){
        function getURLParameterPrivate(name) {
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)");
            var results = regex.exec(location.search);
            return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        }

        function parseURLPrivate(url) {
            var parser = document.createElement('a');
            parser.href = url;

            parser.getState = function (){
                return parser.hash.toString().replace('#/', '');
            };
            return parser;
        }

        return {
            getURLParameter: getURLParameterPrivate,
            hasURLParameter: getURLParameterPrivate,
            parseUrl : parseURLPrivate
        };
    }

    angular.module('utils', []).factory('utils', utils);
})(window, window.angular);