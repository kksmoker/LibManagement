<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="frame/head.jsp" />
</head>

<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
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
	<div class="container">
		<div class="row-fluid">
			<!-- 登录框 -->
			<div class="dialog span4">
				<div class="block">
					<div class="block-heading">登录</div>
					<div class="block-body">
						<form method="post" action="action/user/login.do">
							<label>用户名</label> <input type="text" class="span12" name="name" required="required">
							<label>密码</label> <input type="password" class="span12" required="required"
								name="password"> <input type="submit" value="登录"
								class="btn btn-primary pull-right"> <label
								class="remember-me"> <input type="checkbox">
								记住我一周
							</label> <span style="color: red">${msg}</span>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
				<p>
					<a href="#"> 忘记密码? </a>
				</p>
			</div>
			<!-- 登录框 -->
		</div>
	</div>
	<jsp:include page="frame/footer.html" />
</body>
</html>

