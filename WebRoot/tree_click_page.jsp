<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点击树之后，跳转的页面</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    var treeNodeId = $("#treeNodeId").val();
	$("#p").text('这是点击树节点后，跳转的界面，你点击的树节点的treeNode.id = '+treeNodeId);
  });
</script>
</head>
<body>
 <p id="p"></p>
 <input type="hidden" id="treeNodeId" value="<s:property value='#parameters.treeNodeId'/>"/>
</body>
</html>