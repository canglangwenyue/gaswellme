<%@ page language="java" import="java.sql.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<table border=2 align="center">
<!-- <tr><td>����</td><td>ʱ��</td><td>�뿪ʱ��</td><td>�Ƿ�ռ�ã�1:�ǣ�0:��</td></tr> -->
<%

   Class.forName("org.gjt.mm.mysql.Driver").newInstance();
   Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1/oil_work","root","bjx719519");
   Statement stmt=con.createStatement();
    ResultSet rst=stmt.executeQuery("select * from gw_show;");
    while(rst.next())
    {
	    out.println("<tr>");
	    /* out.println("<td>"+rst.getString("id")+"</td>"); */
	    out.println("<td>"+rst.getString("name")+"</td>");
	    out.println("<td>"+rst.getString("time")+"</td>");
	    out.println("<td>"+rst.getString("power_voltage")+"</td>");
	    out.println("<td>"+rst.getString("oil_voltage")+"</td>");
	    out.println("<td>"+rst.getString("tao_voltage")+"</td>");
	    out.println("<td>"+rst.getString("land_voltage")+"</td>");
	    out.println("<td>"+rst.getString("temperature")+"</td>");
	    out.println("<td>"+rst.getString("yd_flow")+"</td>");
	    out.println("<td>"+rst.getString("total_flow")+"</td>");
	    out.println("<td>"+rst.getString("nstantaneous_flow")+"</td>");
		out.println("<td>"+rst.getString("switch_status")+"</td>");	    
	    out.println("</tr>");
    }
    //�ر����ӣ��ͷ���Դ
    rst.close();
    stmt.close();
    con.close();
    %>    
</table>
</body>
</html>
