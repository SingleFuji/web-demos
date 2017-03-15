<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/app/appRankList.js"></script>
<title>App Rank List</title>
</head>
<body ng-app="app">
	<div ng-controller="appCtrl">
		<input type="button" value="初始化榜单" ng-click="initAppList" />
		<div ng-if="isShow">
			<ol>
				<li ng-repeat="app in appList">{{app.name}} {{app.score}}</li>

			</ol>
		</div>

	</div>
</body>
</html>

