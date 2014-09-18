<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'userlist.jsp' starting page</title>
   <!--  <meta http-equiv="refresh" content="0;URL=gs_showAction.action"> -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body onload="javascript:location.href='gs_showAction.action'">
    <s:iterator value ="gsList">
    	
    	<table>
    	<s:property value="name"/> 
    	<s:property value="time"/>
    	<s:property value="power_voltage"/>
    	<s:property value="oil_voltage"/>
    	<s:property value="tao_voltage"/>
    	<s:property value="land_voltage"/>
    	<s:property value="temperature"/>
    	<s:property value="yd_flow"/>
    	<s:property value="total_flow"/>
    	<s:property value="nstantaneous_flow"/>
    	<s:property value="switch_status"/>
    	</table>
    </s:iterator> 
  </body>
</html>
