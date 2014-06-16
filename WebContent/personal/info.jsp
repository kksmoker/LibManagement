<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
							<i class="icon-home"></i>&nbsp;&nbsp;证件信息
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<table class="table table-hover">
								<%if (user != null) {%>
									<tr>
										<th>读者编号</th>
										<td><%=user.getName() %></td>
									</tr>
									<tr>
										<th>邮箱</th>
										<td>
											<%
												if(user.getEmail() == null) {
													out.print("未填写");
												} else {
													out.print(user.getEmail());
												}
											%>
										</td>
									</tr>
								<%}%>
									<tr>
										<th>用户级别</th>
										<td>	
											<s:if test="%{#session.user.power == 0 }">
												普通用户
											</s:if>
											<s:elseif test="%{#session.user.power == 1 }">
												管理员
											</s:elseif>
											<s:else>
												超级管理员
											</s:else>
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

