<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.lib.service.impl.BooksServiceImpl"%>
<%@page
	import="com.lib.service.BooksService, com.lib.domain.BorrowRecord"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
							<i class="icon-home"></i>&nbsp;&nbsp;位置
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<table class="table table-hover table-bordered">
									<form action="${basePath }action/position/posi_save.do" method="post">
										<tr>
											<th>位置</th>
											<td>
												<input type="text" name="position.floor" required="required">
												&nbsp;&nbsp;
												<input type="submit" value="添加" class="btn btn-primary"/>
												&nbsp;&nbsp;
												${msg }
											</td>
										</tr>
									</form>
								</table>
								<s:bean name="com.lib.service.impl.PositionServiceImpl" var="positions" />
								<s:if test="%{#positions.listAll().size() == 0}">
									<br />
									<span class="label label-info">
										还没有分类! 
									</span>
									<br /><br />
								</s:if>
								<s:else>
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>编号</th>
												<th>位置</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator var="position" value="#positions.listAll()">
												<tr>
													<td><s:property value="#position.id"/></td>
													<td><s:property value="#position.floor"/></td>
													<td>
														<a href="${basePath }action/position/posi_toEdit.do?
															id=<s:property value="#position.id" />">
															<span class="icon icon-edit"></span>
														</a>
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</s:else>

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

