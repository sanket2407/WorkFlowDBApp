//loading the 'login' angularJS module

var login = angular.module('admin', []);
var count=1;
var orgname;
var email;
//defining the login controller

login.controller('admincontroller', function($scope, $window ,$http) {

    $scope.signOut = function(){

        window.location.assign("/");
    };

    $scope.department = [];
// Organization Admin  services
    $scope.init = function(org_name,email_id){

        email=email_id;
        console.log("inside init function");
        console.log("organization name"+org_name);
        orgname=org_name;
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
            console.log("inside init success");

            angular.forEach(data.department_list, function(item){
                console.log(item.admin);
                console.log(item.department_id);
                console.log(item.department_name);
                console.log(item);
                $scope.department.push(item);
                console.log($scope.department);
                /*console.log(department[1]);
                console.log(department[2]);*/
            })

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
               window.location.assign('/orgAdminDashBoard?admin_email=' + data.admin_email+'&org_name='+orgname);
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
            console.log("organization name in "+ orgname);
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/orgAdminDashBoard?admin_email=' + data.admin_email+'&org_name='+orgname);
        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };



// Department Admin  services

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
