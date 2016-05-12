//loading the 'login' angularJS module

var login = angular.module('signup', []);

//defining the login controller

login.controller('signupcontroller', function($scope, $window ,$http) {
    
    $scope.orgs = function(){

            $http({
            method : "post",
            header:{
                'accept': 'application/json',
                'content-type':'application/json; charset=utf-8'
            },
            url:'http://localhost:8080/getAllOrganizations',
            data : JSON.stringify({
            })

        }).success(function(data) {
            console.log("inside success");
            console.log(data);
            $scope.names = data.organization_list;
        }).error(function(error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });
        
    }

    $scope.orgs();


    $scope.dept = function(){

        console.log(">>>>>" +$scope.selectedName);

         $http({
            method : "post",
            header:{
                'accept': 'application/json',
                'content-type':'application/json; charset=utf-8'
            },
            url:'http://localhost:8080/getAllDepartments1',
            data : JSON.stringify({
                "org_name" : $scope.selectedName
            })

        }).success(function(data) {
            console.log("inside success");
            console.log(data);
            // var dept_lists = [];
            // var temp_list = [];
            // temp_list = data.department_list;
            // console.log(temp_list);
            // //data.department_list
            // for (i = 0; i < temp_list.length; i++) { 
            //     console.log("inside loooop");
            //     dept_lists.push(temp_list[i].department_name) ;
            // }
            // console.log(dept_lists);
            $scope.dept_list = data.dept_list;

        }).error(function(error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    }

    $scope.signOut = function(){

        window.location.assign("/");
    };

    $scope.register = function(usecase) {

        console.log("inside register");
        console.log(">>> "+ $scope.selectedName);
        console.log(">>> "+ $scope.selectedDeptName);

        if(usecase=='orgAdmin'){
            console.log("org_Admin");
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

            console.log("user");
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

            console.log("admin");
            console.log(">>> "+$scope.selectedName);
            
            $http({
                method : "post",
                header:{
                    'accept': 'application/json',
                    'content-type':'application/json; charset=utf-8'
                },
                url:'http://localhost:8080/userSignUp',
                data : JSON.stringify({
                    "email_id": $scope.email,
                    "org_name": $scope.selectedName,
                    "address": $scope.address,
                    "dept_name": $scope.selectedDeptName,
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
