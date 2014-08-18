<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>长庆油田长南项目气井监控系统</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
	    <link rel="stylesheet" type="text/css" href="css/icon.css" />
	    <link rel="stylesheet" type="text/css" href="css/main.css" />
		<link rel="stylesheet" type="text/css" href="zTree/css/zTreeStyle/zTreeStyle.css"/>
 		<link rel="stylesheet" type="text/css" href="zTree/css/demo.css"/>
 		<script type="text/javascript" src="js/jquery.min.js"></script>
	    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="zTree/js/jquery.ztree.all-3.5.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
	</head>
	<body id="main" class="easyui-layout">
		<div data-options="region:'west',split:true" title="导航菜单" style="width: 240px;  overflow: auto; ">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div style="z-index:12754; border: 1px solid lightgray; background: white; width: 150px; height: 35px; display: none; padding: 4px;" id="treeLoadMsg">
					<img src="images/loading.gif" style="vertical-align: middle;" width="32" height="32"/>
					<span>Loading...</span>
				</div>
		        <ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
		<div data-options="region:'center'" title="首页" style="overflow: hidden;">
			<iframe id="iframepage" src="default.jsp" style=" background: white;border: 1px; width: 100%; height: 100%; padding: 0;"></iframe>
		</div>
	</body>
</html>

