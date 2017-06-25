<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>

<!-- <script type="text/javascript" src="../js/angular.min.js"></script> -->
<script type="text/javascript" src="../js/app/appRankList.js"></script>
<title>App Rank List</title>
</head>
<body ng-app="app">
	<div ng-controller="appCtrl">
		<input type="button" ng-click="initAppList()" name="初始化数据"
			value="init data" /> <span ng-click="initAppList"> init  data</span>
		<ol>
			<li ng-repeat="app in appList">{{app.name}} {{app.score}}</li>
		</ol>
		<button ng-click="initAppList()">OK</button>
	</div>
</body>
</html>




