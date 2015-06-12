<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>/main.jsp">
    <title>科教平台系统</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is index page">

	<link href="ui/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
  </head>
  <body>
  	aaaaaaaaaaaa
	<script src="ui/jquery/jquery.min.js"></script>
    <script src="ui/bootstrap/js/bootstrap.min.js"></script>
    <%@ include file="/www/ui/util/permIds.jsp"%>
	<%@ include file="/www/login/jsp/mainRes.jsp"%>
</body>
</html>
