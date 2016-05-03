


//loading the 'login' angularJS module

var login = angular.module('home', []);

//defining the login controller

login.controller('homecontroller', function($scope, $window ,$http) {






    $scope.submit = function(usecase) {

        console.log("inside submit");
        console.log("usecase:: " + usecase);
        console.log("email ::" + $scope.email);
        console.log("password:: " + $scope.password);

        if(usecase=='admin') {

            $http({
                method: "post",
                header:{
                    'accept': 'application/json',
                    'content-type':'application/json; charset=utf-8'
                },
                url:'http://localhost:8080/orgAdminLogin',
                data: {
                    "email": $scope.email,
                    "password": $scope.password
                }
            }).success(function (data) {
                
                console.log("inside success");
                // Setting up the session variable.
                req.session.email=data.email;
                window.location.assign('/userLogin');

            }).error(function (error) {
                console.log("inside error");
                console.log(error);
                console.log("unexpected_error");
            });
        }

        else{

            $http({
                method: "post",
                header:{
                    'accept': 'application/json',
                    'content-type':'application/json; charset=utf-8'
                },
                url:'http://localhost:8080/orgAdminSignUp',
                data: {
                    "email": $scope.email,
                    "password": $scope.password
                }
            }).success(function (data) {
                console.log("inside success");
                window.location.assign('/adminLogin');

            }).error(function (error) {
                console.log("inside error");
                console.log(error);
                console.log("unexpected_error");
            });




        }



    };

    $scope.signUp = function(usecase) {

        console.log("inside sign up controller");
        if(usecase=='admin')
            window.location.assign('/orgAdminSignUp');
        else
            window.location.assign('/userSignUp');

    };
    
    

})
