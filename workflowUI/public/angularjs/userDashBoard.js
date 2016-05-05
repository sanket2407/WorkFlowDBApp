//loading the 'login' angularJS module

var login = angular.module('user', []);

//defining the login controller

login.controller('usercontroller', function($scope, $window ,$http) {

    $scope.update = function() {
        console.log("inside update function");
        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/updateEmail',
            data: JSON.stringify({
                "current_email_id": $scope.current_email,
                "new_email_id": $scope.new_email,
                "org_name": $scope.org_name
            })
        }).success(function (data) {

            console.log("inside success");
            console.log(data);
            console.log(data.email_id);

            window.location.assign('/');

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };

    $scope.delete = function(org_name,email_id) {
        console.log("inside update function");
        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/deleteEmail',
            data: JSON.stringify({
                "email_id":email_id,
                "org_name": org_name
            })
        }).success(function (data) {

            console.log("inside success");
            console.log(data);
            console.log(data.email_id);
            console.log("Organization"+org_name);
            console.log("email"+email_id);
            window.location.assign('/');

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };

    $scope.cancel = function(){
        window.location.assign('/deptAdminDashBoard');
    }



})
