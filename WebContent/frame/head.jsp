<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<meta charset="utf-8">
<title>图书馆管理系统</title>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="${basePath}css/theme.css" />
<link rel="stylesheet" type="text/css" href="${basePath}css/demo.css" />
<link rel="stylesheet" type="text/css" href="${basePath}css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="${basePath}css/font-awesome-ie7.css" />
<script src="${basePath}js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${basePath}js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>