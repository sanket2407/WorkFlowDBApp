//loading the 'login' angularJS module

var login = angular.module('next', []);

//defining the login controller

login.controller('nextcontroller', function($scope, $window ,$http) {

    $scope.signOut = function(){

        window.location.assign("/");
    };

    $scope.createNext= function(level_name,org_name,workflow_id){

        var a = parseInt(level_name.slice(-1));
        console.log("inside level js");
        console.log("level name:"+ level_name);
        console.log("level count:"+ a );
        console.log("org name:" + org_name);
        console.log("email:"+$scope.email);
        console.log("description:"+$scope.desc);
        console.log("workflow_id:"+workflow_id);

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/addLevelIntoWorkflow',
            data: JSON.stringify({
                    "workflow_id" : workflow_id,
                    "worker_email_id" : $scope.email,
                    "worker_org_name": org_name,
                    "description" : $scope.desc,
                    "level_name": level_name
            })
        }).success(function(data) {
            console.log("inside success");
            console.log(data);
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/next?workflow_id=' + data.workflow_id +'&org_name='+org_name+'&level_name=Level '+(a+1));
        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };

    $scope.createLayer= function(level_name,org_name,workflow_id,layer_name){

        var a = parseInt(level_name.slice(-1));
        var b = parseInt(layer_name.slice(-1));
        //var b=0;
        console.log("inside level js");
        console.log("level name:"+ level_name);
        console.log("level count:"+ a );
        console.log("org name:" + org_name);
        console.log("email:"+$scope.email);
        console.log("description:"+$scope.desc);
        console.log("workflow_id:"+workflow_id);

        $http({
            method: "post",
            header:{
                'Accept':'application/json',
                'Content-Type': 'application/json'
            },
            url:'http://localhost:8080/addLayerIntoWorkflow',
            data: JSON.stringify({
                "workflow_id" : workflow_id,
                "worker_email_id" : $scope.email,
                "worker_org_name": org_name,
                "description" : $scope.desc,
                "level_name": level_name,
                "layer_name": "Layer 1"
            })
        }).success(function(data) {
            console.log("inside success");
            console.log(data);
            // Setting up the session variable.
            // req.session.email=data.email;
            window.location.assign('/next?workflow_id=' + data.workflow_id +'&org_name='+org_name+'&level_name=Level '+a+'&layer_name=Level '+(b+1));

        }).error(function (error) {
            console.log("inside error");
            console.log(error);
            console.log("unexpected_error");
        });

    };



    $scope.finish = function(level_name,org_name,workflow_id) {
            console.log("inside finish");

             var a = parseInt(level_name.slice(-1));
                console.log("inside level js");
                console.log("level name:"+ level_name);
                console.log("level count:"+ a );
                console.log("org name:" + org_name);
                console.log("email:"+$scope.email);
                console.log("description:"+$scope.desc);
                console.log("workflow_id:"+workflow_id);

                $http({
                    method: "post",
                    header:{
                        'Accept':'application/json',
                        'Content-Type': 'application/json'
                    },
                    url:'http://localhost:8080/addLevelIntoWorkflow',
                    data: JSON.stringify({
                            "workflow_id" : workflow_id,
                            "worker_email_id" : $scope.email,
                            "worker_org_name": org_name,
                            "description" : $scope.desc,
                            "level_name": level_name
                    })
                }).success(function(data) {
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

})
