var app = angular.module("app", []);
app.controller("appCtrl", function($scope, $http){
	var initAppUrl = "http://localhost:8080//app/init";
	$scope.isShow = false;
	$scope.initAppList = function(){
		$http.get(initAppUrl).success(
			function(responce){
				console.log(responce);
				$scope.appList = responce;
				$scope.isShow = true;
			}
		);
	}
});

