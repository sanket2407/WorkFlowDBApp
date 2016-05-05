//loading the 'login' angularJS module

var login = angular.module('admin', []);
var count=1;

//defining the login controller

login.controller('admincontroller', function($scope, $window ,$http) {


    $scope.init = function(org_name){

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/getAllDepartments',
            data: JSON.stringify({
                "org_name":org_name
            })
        }).success(function (data) {

            console.log("inside success");
            console.log(data);
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/orgAdminDashBoard?admin_email=' + data.admin_email+'&org_name='+data.org_name);

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });
    };
    
    $scope.addDept = function() {
        console.log("inside submit");
        console.log("Department Name ::" + $scope.dept_name);

            $http({
                method: "post",
                header:{
                    'Accept':'application/json',
                    'Content-Type': 'application/json'
                },
                url:'http://localhost:8080/createDepartment',
                data: JSON.stringify({
                    "admin_email":"micro@micro.com",
                    "department_name":$scope.dept_name
                })
            }).success(function (data) {

                console.log("inside success");
                console.log(data);
                // Setting up the session variable.
                // req.session.email=data.email;
               window.location.assign('/orgAdminDashBoard?admin_email=' + data.admin_email);

            }).error(function (error) {
                console.log("inside error");
                console.log(error);
                console.log("unexpected_error");
            });

    };

    $scope.addRole = function() {
        console.log("inside submit");
        console.log("Department Name ::" + $scope.role);

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/createRole',
            data: JSON.stringify({
                "role_name":$scope.role
            })
        }).success(function (data) {

            console.log("inside success");
            console.log(data);
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/orgAdminDashBoard?admin_email=' + data.admin_email);

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };

    $scope.createRequestType= function(){

        console.log("inside create request type");

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/createRequestType',
            data: JSON.stringify({
                    "email_id" : $scope.email,
                    "request_type_name" : $scope.req_type_name,
                    "org_name":$scope.org_name
            })
        }).success(function (data) {
            console.log("inside success");
            console.log(data);
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/deptAdminDashBoard');

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };

    $scope.createWorkflow = function() {

        console.log("inside createWorkflow js");

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
            console.log(data.email_id);
            
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/next?workflow_id=' + data.workflow_id +'&org_name='+$scope.org_name+'&level_name=Level '+count);
            //window.location.assign('/next?dataObj=' + data);

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };

})
