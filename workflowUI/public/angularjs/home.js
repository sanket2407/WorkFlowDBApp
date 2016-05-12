//loading the 'login' angularJS module

var login = angular.module('home', []);

//defining the login controller
login.controller('homecontroller', function($scope, $window ,$http) {

    var bgImagesList =["background.png"];
    var background = bgImagesList[Math.floor(Math.random() * bgImagesList.length)];
    $scope.setBackground = function(){
        return {
            'background-image':'url(images/' + background + ')'
        }
    }

    $scope.submit = function(usecase) {

        console.log("inside submit");
        console.log("usecase:: " + usecase);
        console.log("email ::" + $scope.email);
        console.log("password:: " + $scope.password);

        if(usecase=='orgAdmin') {
            $http({
                method: "post",
                header:{
                    'Accept':'application/json',
                    'Content-Type': 'application/json'
                },
                url:'http://localhost:8080/orgAdminLogin',
                data: JSON.stringify({
                    "admin_email":$scope.email,
                    "password":$scope.password
                })
            }).success(function (data) {
                
                console.log("inside success");
                console.log(data);
                console.log(data.org_name);
                // Setting up the session variable.
               // req.session.email=data.email;
                window.location.assign('/orgAdminDashboard?admin_email=' + data.email_id+'&org_name='+data.org_name);

            }).error(function (error) {
                console.log("inside error");
                console.log(error);
                console.log("unexpected_error");
            });
        }

        else {
            $http({
                method: "post",
                header:{
                    'Accept':'application/json',
                    'Content-Type': 'application/json'
                },
                url:'http://localhost:8080/userLogin',
                data: JSON.stringify({
                    "email_id":$scope.email,
                    "password":$scope.password,
                    "org_name":$scope.org_name
                })
            }).success(function(data) {

                console.log("inside admin success");

                if(usecase=='admin')
                    window.location.assign('/deptAdminDashboard?email_id=' + data.email_id+'&org_name='+data.org_name);
                else
                    window.location.assign('/userDashboard?email_id=' + data.email_id +'&org_name='+data.org_name+'&dept_id='+data.dept_id+'&org_id='+data.org_id);
            }).error(function (error) {
                console.log("inside error");
                console.log(error);
                console.log("unexpected_error");
            });

        }
    };

    $scope.signUp = function(usecase) {
        
        console.log("inside sign up controller");
        
        if(usecase=='orgAdmin')
            window.location.assign('/orgAdminSignUp');
        else if(usecase=='user')
            window.location.assign('/userSignUp');
        else
            window.location.assign('/adminSignUp');

    };


    $scope.signOut = function(){

        window.location.assign("/");
    };
})
