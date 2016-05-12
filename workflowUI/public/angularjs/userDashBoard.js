//loading the 'login' angularJS module

var login = angular.module('user', []);
var email;
var orgname;
var dept_id;
var org_id;
var workflow_instance_id;
var workflow_id;
var level_id;
var layer_id;

//defining the login controller

login.controller('usercontroller', function($scope, $window ,$http) {


    $scope.user = [];
    $scope.request_list=[];
    $scope.asp_request_list=[];

    $scope.signOut = function(){
        window.location.assign("/");
    };

    $scope.init = function(org_name,email_id, deptid,orgid){

        email=email_id;
        console.log("inside init function");
        console.log("organization name"+org_name);
        orgname=org_name;
        org_id=orgid;
        dept_id=deptid;

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/getStatsUserDashBoard',
            data: JSON.stringify({
                    "email_id": email,
                    "org_name":org_name,
                    "dept_id": dept_id

            })
        }).success(function (data) {
            console.log("inside init success");

            angular.forEach(data.user_dashboard_stats, function(item){
                console.log(item.admin);
                console.log(item.department_id);
                console.log(item.department_name);
                console.log(item);

                $scope.workflow_instance_id=item.workflow_instance_id;
                $scope.workflow_id=item.workflow_id;;
                $scope.level_id=item.level_id;
                $scope.layer_id=item.layer_id;

                console.log("Workflow instance id:"+workflow_instance_id);
                console.log("workflow id:"+workflow_id);
                console.log("level id:"+level_id);
                console.log("layer id:"+layer_id);

                $scope.user.push(item);
                console.log($scope.user);
                /*console.log(department[1]);
                 console.log(department[2]);*/
            })
        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });
    };

    var instance_id_x;
    var workflow_id_x;
    var level_id_x;
    var layer_id_x;

    $scope.inbox = function() {
        console.log("inside inbox function");
        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/getAllAssignedAndPendingRequests',
            data: JSON.stringify({
                "email_id": email,
                "org_name": orgname
            })
        }).success(function (data) {

            console.log("*************");
            console.log(data);

        instance_id_x = data.assigned_or_pending_req_list[0].workflow_instance_id;
        workflow_id_x = data.assigned_or_pending_req_list[0].workflow_id;
        level_id_x = data.assigned_or_pending_req_list[0].level_id;
        layer_id_x = data.assigned_or_pending_req_list[0].layer_id;

            angular.forEach(data.assigned_or_pending_req_list, function(item){
                console.log(item.request_name);
                console.log(item.workflow_id);
                console.log(item.description);
                console.log(item);
                $scope.asp_request_list.push(item);
                console.log($scope.asp_request_list);

            })


            //window.location.assign('/');

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };

    $scope.approve = function() {
        console.log("inside inbox function");
    console.log(instance_id_x);
    console.log(workflow_id_x);
    console.log(email);
    console.log(orgname);
    console.log(level_id_x);
    console.log(layer_id_x);

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/approveRequest',
            data: JSON.stringify({
                    "workflow_instance_id": instance_id_x ,
                    "workflow_id" : workflow_id_x,
                    "email_id" : email,
                    "org_name": orgname,
                    "level_id" : level_id_x,
                    "layer_id" : layer_id_x
            })
        }).success(function (data) {

            console.log("inside approve success");
            console.log(data);
            //console.log(data.email_id);
            var temp_workflow_instance = data.workflow_instance_id;

                                 //=====================================1
                                    $http({
                                    method: "post",
                                    header:{
                                        'Accept':'application/json',
                                        'Content-Type': 'application/json'
                                    },
                                    url:'http://localhost:8080/getNextWorkers',
                                    data: JSON.stringify({
                                        "workflow_instance_id": temp_workflow_instance
                                    })
                                }).success(function (data) {

                                    console.log("inside success");
                                    console.log("=======>:");
                                    console.log(data);
        

                                    }).error(function (error) {
                                        console.log("inside error");
                                        console.log(error);
                                        console.log("unexpected_error");
                                    });

                                    //=====================================

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };


    $scope.reject = function() {
        console.log("inside inbox function");
        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/rejectRequest',
            data: JSON.stringify({
                "workflow_instance_id":workflow_instance_id ,
                "workflow_id" : workflow_id,
                "email_id" : email,
                "org_name":orgname,
                "level_id" : level_id,
                "layer_id" : layer_id
            })
        }).success(function (data) {

            console.log("inside reject success");
            console.log(data);
            console.log(data.email_id);

            //window.location.assign('/');

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

    $scope.request = function() {
        console.log("inside update function");
        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/getAllRequestsOfUser',
            data: JSON.stringify({
                "email_id":email,
                "org_id": org_id,
                "dept_id":dept_id
            })
        }).success(function (data) {

            console.log("inside success");
            console.log(data);
            console.log(data.email_id);
            console.log("Organization"+orgname);
            console.log("email"+email);

            angular.forEach(data.request_list, function(item){
                console.log(item.request_name);
                console.log(item.workflow_id);
                console.log(item.description);
                console.log(item);
                $scope.request_list.push(item);
                console.log($scope.request_list);

            })


        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };
    $scope.doRequest = function(workflow_id) {
        console.log("inside update function");
        console.log(">>>>>>>>>>>>>>>>>>>>>" + workflow_id);
        console.log(">>>>>>>>>>>>>>>>>>>>>" + email);
        console.log(">>>>>>>>>>>>>>>>>>>>>" + orgname);

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/doRequest',
            data: JSON.stringify({
                "workflow_id": workflow_id,
                "email_id":email,
                "org_name":orgname
            })
        }).success(function (data) {

            console.log("inside success");
            console.log(data);
            console.log(data.email_id);
            console.log("Organization"+orgname);
           // console.log("email"+email_id);
            var temp_workflow_instance = data.workflow_instance_id;

                                    //=====================================1
                                    $http({
                                    method: "post",
                                    header:{
                                        'Accept':'application/json',
                                        'Content-Type': 'application/json'
                                    },
                                    url:'http://localhost:8080/getNextWorkers',
                                    data: JSON.stringify({
                                        "workflow_instance_id": temp_workflow_instance
                                    })
                                }).success(function (data) {

                                    console.log("inside success");
                                    console.log("=======>:"+data);
        

                                    }).error(function (error) {
                                        console.log("inside error");
                                        console.log(error);
                                        console.log("unexpected_error");
                                    });

                                    //=====================================

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
