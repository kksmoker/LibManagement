<%@page import="com.lib.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- 左侧bar -->
<div class="span3 offset1">
	<div class="sidebar-nav">
		<div class="nav-header">
			<i class="icon-dashboard"></i>功能列表
		</div>
		<ul class="nav nav-list">
			<%
			User user = (User) session.getAttribute("user");
		    if (user != null) {
				if (user.getPower() == 0) {%>
					<li><a href="<%=basePath %>personal/index.jsp">入馆须知</a></li>
					<li><a href="<%=basePath %>personal/info.jsp">证件信息</a></li>
					<li><a href="<%=basePath %>action/book/toSearch.do">图书检索</a></li>
					<li><a href="<%=basePath %>action/book/unreturn.do">书刊借阅</a></li>
					<li><a href="<%=basePath %>action/book/history.do">借阅历史</a></li>
					<li><a href="<%=basePath %>personal/email.jsp">修改邮箱</a></li>
					<li><a href="<%=basePath %>personal/pass.jsp">修改密码</a></li>
				<%} else if (user.getPower() == 1) {%>
					<li><a href="<%=basePath %>personal/index.jsp">入馆须知</a></li>
					<li><a href="<%=basePath %>action/storage/toPutin.do">图书入库</a></li>
					<li><a href="<%=basePath %>action/book/toSearch.do">图书修改</a></li>
					<li><a href="<%=basePath %>admin/borrow.jsp">图书借出</a></li>
					<li><a href="<%=basePath %>admin/return.jsp">图书借入</a></li>
					<li><a href="<%=basePath %>personal/info.jsp">证件信息</a></li>
					<li><a href="<%=basePath %>personal/email.jsp">修改邮箱</a></li>
					<li><a href="<%=basePath %>personal/pass.jsp">修改密码</a></li>
				<%} else if (user.getPower() == 2) {%>
					<li><a href="<%=basePath %>personal/index.jsp">入馆须知</a></li>
					<li><a href="<%=basePath %>super/cate.jsp">图书分类</a></li>
					<li><a href="<%=basePath %>super/posi.jsp">藏书位置</a></li>
					<li><a href="<%=basePath %>personal/info.jsp">证件信息</a></li>
					<li><a href="<%=basePath %>personal/email.jsp">修改邮箱</a></li>
					<li><a href="<%=basePath %>personal/pass.jsp">修改密码</a></li>
				<%} else {%>
					<li><a href="<%=basePath %>sign-in.jsp" class="btn btn-primary">登录</a>
				<%}
			} 
			%>
		</ul>
	</div>
</div>
<!-- 左侧bar结束 -->