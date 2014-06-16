<%@page import="com.lib.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- 导航 -->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<ul class="nav pull-right">
				<%
					String console = "";
					User user = (User) session.getAttribute("user");
					if (user == null) {
						response.sendRedirect(basePath + "sign-in.jsp");
					} else {%>
						<li id="fat-menu" class="dropdown">
					<a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown"> 
						<i class="icon-user"></i>
						<%=user.getName()%>
						<i class="icon-caret-down"></i>
					</a>
						<%
						if (user.getPower() == 0) {
							console = basePath + "personal/index.jsp";
						} else if (user.getPower() == 1) {
							console = basePath + "admin/index.jsp";
						} else if (user.getPower() == 2) {
							console = basePath + "super/index.jsp";
						} else {
							console = "null";
						}
					}
				%>
					<ul class="dropdown-menu">
						<li><a href="<%=console %>">控制台</a></li>
						<li><a tabindex="-1" href="${basePath }action/user/logout.do"> 退出 </a></li>
					</ul>
				</li>
			</ul>
			<a class="brand" href="javascript:void(0);"> <span class="first">zmp</span><span
				class="second">图书馆管理系统</span>
			</a>
			<ul class="nav">
				<li><a href="${basePath }index.jsp">首页</a></li>
				<li><a href="${basePath }action/book/toSearch.do">检索</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- 导航结束 -->