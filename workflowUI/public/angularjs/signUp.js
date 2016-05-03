//loading the 'login' angularJS module

var login = angular.module('signup', []);

login.config(['$httpProvider', function ($httpProvider) {

    $httpProvider.defaults.headers.common['Accept'] = 'application/json, text/javascript';
    $httpProvider.defaults.headers.common['Content-Type'] ='application/json; charset=utf-8';
    $httpProvider.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

}]);

//defining the login controller

login.controller('signupcontroller', function($scope, $window ,$http) {

    $scope.register = function() {
        console.log("inside register");

        $http({
            method : "post",
            header:{
                'accept': 'application/json',
                'content-type':'application/json; charset=utf-8'
            },
            url:'http://localhost:8080/orgAdminSignUp',
            data : {
                "name" : $scope.name,
                "address" : $scope.address,
                "admin_email" :$scope.email,
                "password" :$scope.password
            }
        }).success(function(data) {

            console.log("inside success");
            window.location.assign('/');
        }).error(function(error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });
    };


})
