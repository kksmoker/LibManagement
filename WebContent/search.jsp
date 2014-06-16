<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.lib.domain.User" %>
<%@page import="com.lib.service.impl.BooksServiceImpl"%>
<%@page	import="com.lib.service.BooksService, com.lib.domain.BorrowRecord"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function input_me(str)
{
	$("#searchContent").val(str);
	$('#search').submit();
}

function input_cate(str)
{
	$("#searchMethod").append("<option value='byCategory' selected>按分类检索</option>");
	$("#searchContent").val(str);
	$("#search").submit();
}
</script>
<jsp:include page="frame/head.jsp" />
</head>

<body>
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
						User user = (User) session.getAttribute("user");
						if (user == null) {%>
						<li id="fat-menu" class="dropdown">
							<a href="sign-in.jsp">
								<i class="icon-user"></i>登录
							</a>
						</li>
						<%} else {%>
							<li id="fat-menu" class="dropdown">
						<a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown"> 
							<i class="icon-user"></i>
							<%=user.getName()%>
							<i class="icon-caret-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="personal/index.jsp">控制台</a></li>
							<li><a tabindex="-1" href="${basePath }action/user/logout.do"> 退出 </a></li>
						</ul>
						<%} %>
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
	<div class="container">
		<div class="row-fluid">
			<!-- bar -->
			<div class="span3 offset1">
				<div class="row-fluid">
					<div class="block">
						<p class="block-heading">
							<i class="icon-home"></i>&nbsp;&nbsp;检索
						</p>
						<div id="chart-container" class="block-body collapse in">
							<br />
							<form id="search" action="${basePath }action/book/search.do" method="post">
								<select class="select" id="searchMethod" name="searchMethod">
									<option value="byName">按名称检索</option>
									<option value="byPress">按出版社检索</option>
								</select> 
								<input type="text" id="searchContent" name="searchContent" required="required" />
								<input type="submit" value="检索" class="btn btn-primary">
							</form>
						</div>
					</div>
					<div class="block">
						<p class="block-heading">
							<i class="icon-home"></i>&nbsp;&nbsp;分类
						</p>
						<div class="sidebar-nav">
							<ul class="nav nav-list">
								<s:iterator id="category" value="#request.categorys">
									<li>
										<a href="javascript:void(0);" title="<s:property value="#category.name"/>" 
											onclick="input_cate('<s:property value="#category.name"/>')">
									  		<s:if test="%{#category.name.length() > 10}">
												<s:property value="#category.name.substring(0, 10)"/>...
											</s:if>
											<s:else>
												<s:property value="#category.name"/>
											</s:else>
										</a>
									</li>
								</s:iterator>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- bar结束 -->
			<!-- 右侧内容 -->
			<div class="span7">
				<div class="row-fluid">
					<div class="block">
						<p class="block-heading">
							<i class="icon-home"></i>&nbsp;&nbsp;结果
							<span class="label label-success">
								<s:property value="#request.results.size()"/>
							</span>
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<table class="table table-hover table-bordered">
									<thead>
										<tr>
											<td colspan="6">
												<span class="label label-warning">
													Top&nbsp;10
												</span>
												<s:iterator id="topTen" value="#request.topTen">
													<a href="javascript:void(0);" onclick="input_me('<s:property value="#topTen.title"/>')">
														<s:property value="#topTen.title"/>
													</a>
													&nbsp;/&nbsp;
												</s:iterator>
											</td>
										</tr>
										<tr>
											<th>题名</th>
											<th>作者</th>
											<th>出版社</th>
											<th>可借&nbsp;/&nbsp;总量</th>
											<th>类别</th>
											<th>位置</th>
											<s:if test="%{#session.user.power == 1}">
												<th>操作</th>
											</s:if>
										</tr>
									</thead>
									<s:if test="%{#request.results.size() == 0}">
										<tr>
											<td colspan="7" style="color:red;"><b>0</b>&nbsp;条检索记录</td>
										</tr>
									</s:if>
									<s:else>
										<s:iterator id="books" value="#request.results">
											<tr>
												<td><s:property value="#books.name"/></td>
												<td><s:property value="#books.author"/></td>
												<td><s:property value="#books.press"/></td>
												<td>
													<span style="color:green;">
														<s:property value="#books.surplus"/>
													</span>
													&nbsp;/&nbsp;
													<span style="color:red;">
														<s:property value="#books.amount"/>
													</span>
												</td>
												<td>
													<a href="javascript:void(0);" title="<s:property value="#books.category.name"/>" 
														onclick="input_cate('<s:property value="#books.category.name"/>')">
													<s:if test="%{#books.category.name.length() > 10}">
														<s:property value="#books.category.name.substring(0, 10)"/>...
													</s:if>
													<s:else>
														<s:property value="#books.category.name"/>
													</s:else>
													</a>
												</td>
												<td><s:property value="#books.position.floor"/></td>
												<s:if test="%{#session.user.power == 1}">
													<td>
														<a href="${basePath }action/storage/toEdit.do?bid=
														<s:property value="#books.id" />">
															<span class="icon icon-edit"></span>
														</a>
													</td>
												</s:if>
											</tr>
										</s:iterator>
									</s:else>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 右侧内容 -->
		</div>
	</div>
	<jsp:include page="frame/footer.html" />
</body>
</html>

