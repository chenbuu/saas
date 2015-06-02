<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
    <head>
    	<base href="<%=basePath%>">
        <title>退出</title>
        <script src="ui/jquery/jquery.min.js"></script>
    </head>
    <body>
		<a id="exitA" href="<s:url value="login.html"/>" >点击退出</a>
		<%
		 session.invalidate();//注销
		%>
		<script type="text/javascript">
	  		//得到href连接
		 	var link=$("#exitA").attr("href");
		 	//触发href连接
		 	window.location.href=link;
	  	</script>
    </body>
</html>
