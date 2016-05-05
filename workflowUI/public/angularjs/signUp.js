//loading the 'login' angularJS module

var login = angular.module('signup', []);

//defining the login controller

login.controller('signupcontroller', function($scope, $window ,$http) {

    $scope.register = function(usecase) {

        console.log("inside register");

        if(usecase=='orgAdmin'){
        $http({
            method : "post",
            header:{
                'accept': 'application/json',
                'content-type':'application/json; charset=utf-8'
            },
            url:'http://localhost:8080/orgAdminSignUp',
            data : JSON.stringify({
                "name" : $scope.name,
                "address" : $scope.address,
                "admin_email" :$scope.email,
                "password" :$scope.password
            })

        }).success(function(data) {
            console.log("inside success");
            window.location.assign('/');
        }).error(function(error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

        }
        else if(usecase=='user'){
            $http({
                method : "post",
                header:{
                    'accept': 'application/json',
                    'content-type':'application/json; charset=utf-8'
                },
                url:'http://localhost:8080/userSignUp',
                data : JSON.stringify({
                    "email_id": $scope.email,
                    "org_name": $scope.org_name,
                    "address": $scope.address,
                    "dept_name": $scope.dept_name,
                    "password": $scope.password,
                    "role_name":$scope.role_name,
                    "phones":[
                        {"phone": $scope.workphoneno},
                        {"phone": $scope.homephoneno}
                   ]
                })
            }).success(function(data) {
                console.log("inside success");
                window.location.assign('/');
            }).error(function(error) {
                console.log("inside error");
                console.log(error);
                console.log("unexpected_error");
            });
        }

        else{
            $http({
                method : "post",
                header:{
                    'accept': 'application/json',
                    'content-type':'application/json; charset=utf-8'
                },
                url:'http://localhost:8080/userSignUp',
                data : JSON.stringify({
                    "email_id": $scope.email,
                    "org_name": $scope.org_name,
                    "address": $scope.address,
                    "dept_name": $scope.dept_name,
                    "password": $scope.password,
                    "role_name":"depart_admin",
                    "phones":[
                        {"phone": $scope.workphoneno},
                        {"phone": $scope.homephoneno}
                    ]
                })
            }).success(function(data) {
                console.log("inside success");
                window.location.assign('/');
            }).error(function(error) {
                console.log("inside error");
                console.log(error);
                console.log("unexpected_error");
            });

        }
    };
})
