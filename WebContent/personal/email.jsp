<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.lib.service.impl.BooksServiceImpl"%>
<%@page import="com.lib.service.BooksService, com.lib.domain.BorrowRecord"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../frame/head.jsp" />
</head>

<body>
	<%@ include file="../frame/nav.jsp"%>
	<div class="container">
		<div class="row-fluid">
			<jsp:include page="../frame/bar.jsp" />
			<!-- 右侧内容 -->
			<div class="span7">
				<div class="row-fluid">
					<div class="block">
						<p class="block-heading">
							<i class="icon-home"></i>&nbsp;&nbsp;邮箱
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<table class="table table-hover table-bordered">
									<tr>
										<th>当前邮箱</th>
										<td>
											<s:if test="%{#session.user.email == null}">
												<span class="label label-info">未填写</span>
											</s:if>
											<s:else>
												<span class="label label-info">
													<s:property value="#session.user.email" />
												</span>
											</s:else>
										</td>
									</tr>
									<tr>
										<th>新的邮箱</th>
										<td>
											<form action="${basePath }action/user/updateEmail.do" method="post">
												<input type="text" name="email" required="required"/>
												<input type="submit" value="确定" class="btn btn-primary"/>
											</form>
											${msg }
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 右侧内容 -->
		</div>
	</div>
	<jsp:include page="../frame/footer.html" />
</body>
</html>

