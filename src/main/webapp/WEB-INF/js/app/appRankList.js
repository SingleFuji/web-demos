var app = angular.module("app", []);
app.controller("appCtrl", function($scope, $http){
	var initAppUrl = "http://localhost:8080/web-demos/app/init";
	
	$scope.appList = [
		{name : "instagram",
		score : 9.9},
		{name : "chrome",
		score : 9.5}
	];
	
	$scope.initAppList = function(){
		$http.get(initAppUrl).success(
			function(responce){
				console.log(responce);
			}
		);
	}
});

