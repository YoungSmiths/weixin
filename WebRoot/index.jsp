<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
a {
	color: red;
}
</style>
</head>

<body>
	<a href="<%=basePath%>servlet/WangjingServlet">微信Url测试接口</a>
	<a
		href="<%=basePath%>servlet/VerificationServlet?operationType=GENERATE_VERIFICATON_CODE&size=10000&length=20">生成兑奖码</a>
	<a href="<%=basePath%>servlet/VerificationServlet?operationType=DOWNLOAD&version=20160606">下载</a>
</body>
</html>
