//loading the 'login' angularJS module

var login = angular.module('loginapp', []);

//defining the login controller

login.controller('logincontroller', function($scope, $window ,$http) {
	//Initializing the 'invalid_login' and 'unexpected_error' 
	//to be hidden in the UI by setting them true,
	//Note: They become visible when we set them to false
	$scope.invalid_login = true;
	$scope.unexpected_error = true;
	
	$scope.submit = function() {
		console.log("inside submit");
		console.log("email ::" + $scope.email);
		console.log("password:: " + $scope.password)
		$http({
			method : "POST",
			url : '/checklogin',
			data : {
				"email" : $scope.email,
				"password" : $scope.password
			}
		}).success(function(data) {
			console.log("inside success");
			console.log("data is ::");
			console.log(data);
			console.log(data.statusCode);

				 
		}).error(function(error) {
			console.log("inside error");
			console.log(error);
			$scope.unexpected_error = false;
			$scope.invalid_login = true;
			//$window.alert("unexpected_error");
			console.log("unexpected_error");
		});
	};

	$scope.signup = function() {
		console.log("in sign up controller");
		$http({
			method : "GET",
			url : '/signup'
			}).success(function(data) {
				//checking the response data for statusCode
				if (data.statusCode == 401) {
					
				}
				else
					//Making a get call to the '/redirectToHomepage' API
					window.location.assign("/signup");
			}).error(function(error) {
				
			})
	};
})
