'use strict';

angular.module('UserDashboard').controller('UserDashboardController', function ($scope, $state, ExamsService, AuthenticationService, SessionService, UsersService, TestsService, CategoriesService, DialogManager, $rootScope) {
    $rootScope.bodylayout = 'body-page';
    $scope.user = {};    $scope.getProfile = function () {
        UsersService.getProfile(
            function onSuccess(payload) {
                $scope.user = payload;
                if( $scope.user.image != undefined){
                    $rootScope.imageAvatar = "data:image/png;base64," +  $scope.user.image;
                    } else {
                        $rootScope.imageAvatar = "http://image005.flaticon.com/1/svg/67/67902.svg";
                    }
            },
            function onError() {
            }
        );
    };
    $scope.closeAlert = function (index) {
        $rootScope.alertsStudent.splice(index, 1);
    };
    $scope.getProfile();


    $scope.getImage = function () {
        UsersService.getImage(
            function onSuccess(payload) {
                if (payload != '') {
                    $rootScope.imageAvatar = "data:image/png;base64," + payload;
                } else {
                    $rootScope.imageAvatar = "http://image005.flaticon.com/1/svg/67/67902.svg";
                }
            },
            function onError() {
                $state.go("login");
            });
    };
    $scope.getImage();

    $scope.toProfile = function () {
        DialogManager.showUserProfileDialog(function () {
            $scope.getProfile();
        });
    };
    $scope.startTest = function (testID, testName) {
        ExamsService.protectionReTest($scope.user.id, testID,
            function onSuccess(payload) {
                if (payload == true) {
                    SessionService.set("userID", $scope.user.id);
                    SessionService.set("testID", testID);
                    SessionService.set("testName", testName);
                    $state.go("examstudent");
                }
                else {
                    if (angular.isDefined($rootScope.alertsStudent)) {
                        $rootScope.alertsStudent.push({type: $scope.alerType, msg: "You have already passed the test"});
                    } else {
                        $rootScope.alertsStudent = [];
                        $rootScope.alertsStudent.push({type: $scope.alerType, msg: "You have already passed the test"});
                    }
                }
            }, function onError(message) {
                if (angular.isDefined($rootScope.alertsStudent)) {
                    $rootScope.alertsStudent.push({type: $scope.alerType, msg: message});
                } else {
                    $rootScope.alertsStudent = [];
                    $rootScope.alertsStudent.push({type: $scope.alerType, msg: message});
                }
            })
    };

    $scope.logout = function () {
        AuthenticationService.logout(
            function onSuccess() {
                console.log("logout was successful");
                $state.go("main");
            }, function onError() {
                console.log("logout was with error");
                $state.go("main");
            }
        )
    };

    $scope.showHistory = function () {
        $state.go("examshistory");
    };
    $scope.currSelectedCategoryID = 0;
    CategoriesService.treeCategories(function onSuccess(payload) {
        $scope.treeData = payload;
    }, function onError() {
        console.log("Some problem");
    });

    $scope.rowCollection = [];
    $scope.getTests = function (category) {
        $scope.currSelectedCategoryID = category.$modelValue.id;
        $scope.rowCollection = [];
        if (category.$modelValue.isLeaf) {
            TestsService.getTestsForStudent(category, function onSuccess(payload) {
                console.log(payload);
                $scope.rowCollection = payload;
            })
        }
    };
});