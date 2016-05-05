//loading the 'login' angularJS module

var login = angular.module('user', []);

//defining the login controller

login.controller('usercontroller', function($scope, $window ,$http) {

    /*$scope.createRequest = function() {
        console.log("inside submit");
        console.log("Department Name ::" + $scope.dept_name);

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/createWorkflow',
            data: JSON.stringify({
                    "email_id" : $scope.email,
                    "request_type_name" : $scope.req_type,
                    "org_name":$scope.org_name,
                    "description" : $scope.desc,
                    "department_name" : $scope.dept_name
    })
        }).success(function (data) {

            console.log("inside success");
            console.log(data);
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/userDashBoard');

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };*/

})
