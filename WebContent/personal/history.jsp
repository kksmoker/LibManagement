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
							<i class="icon-home"></i>&nbsp;&nbsp;借阅历史
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<s:if test="%{#request.history.size() == 0}">
									<br />
									<span class="label label-info">
									您还没有借阅记录,多借几本好书充实你的大脑吧! 
									</span>
									<br /><br />
								</s:if>
								<s:else>
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>题名</th>
												<th>作者</th>
												<th>借阅日期</th>
												<th>馆藏地</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator id="history" value="#request.history">
												<tr>
													<td><s:property value="#history.books.name" /></td>
													<td><s:property value="#history.books.author" /></td>
													<td><s:date name="#history.borrdate"
															format="yyyy-MM-dd" /></td>
													<td><s:property value="#history.books.position.floor" /></td>
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

