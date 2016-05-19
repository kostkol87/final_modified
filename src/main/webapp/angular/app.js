'use strict';

angular.module('Libraries', [
    'angular-sha1',
    'ui.router',
    'utils',
    'ngCookies',
    'ngDialog',
    'ui.validate',
    'ui.tree',
    'smart-table'
]);

angular.module('Login', ['ngAnimate','ui.bootstrap']);
angular.module('Directions', []);
angular.module('UserDashboard', []);
// angular.module('TeacherDashboard', []);
// angular.module('AdminDashboard', []);
angular.module('Registration', []);
// angular.module('UserProfile', []);
// angular.module('ExamsHistory', []);
// angular.module('OperatorDashboard', ['ngAnimate', 'ui.bootstrap']);
// angular.module('Students', []);
// angular.module('StudentExams', []);
// angular.module('ExamStudent', []);

var app = angular.module('main', [
    'Login',
    'Registration',
    'Libraries'])
    .constant("constants", {
        rememberMeName: "rememberMe",
        name: "name",
        surname: "surname",
        eMail: "eMail",
        roles: [
            {key: "ROLE_ADMININISTRATOR", value: "ADMININISTRATOR"},
            {key: "ROLE_USER", value: "USER"}],

        roleObject: {
            "ROLE_ADMININISTRATOR": "ADMININISTRATOR",
            "ROLE_USER": "USER"
        }
    })
    .config(function ($stateProvider, $urlRouterProvider, $httpProvider){
        $urlRouterProvider.when('', '/login').when('/', '/login');
        $stateProvider.state('login', {
            url: '/login',
            controller: 'LoginController',
            templateUrl: './angular/templates/states/login.html'
            })
            .state('registration', {
                url: '/registration',
                controller: 'RegistrationController',
                templateUrl: './angular/templates/states/registration.html'
            })
            .state('user', {
                url: '/userDashboard',
                controller: 'UserDashboardController',
                templateUrl: './angular/templates/states/userdashboard.html'
            })
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    }).run(function ($rootScope, utils) {
    });
