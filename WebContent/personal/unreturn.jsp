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
							<i class="icon-home"></i>&nbsp;&nbsp;正在借阅
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<table class="table table-hover table-bordered">
									<thead>
										<tr>	
											<th>条码号</th>
											<th>题名</th>
											<th>作者</th>
											<th>借阅日期</th>
											<th>应还日期</th>
											<th>馆藏地</th>
											<th>续借</th>
										</tr>
									</thead>
									<tbody>
										 <%
										if (user == null) {%>
											<tr>
												<td colspan="7">*暂无借阅书籍</td>
											</tr>
										<%} else {%>
											<s:iterator id="records" value="#request.records">
												<tr>
													<td><s:property value="#records.books.barcode" /></td>
													<td><s:property value="#records.books.name" /></td>
													<td><s:property value="#records.books.author" /></td>
													<td><s:date name="#records.borrdate" format="yyyy-MM-dd" /></td>
													<td><s:date name="#records.retndate" format="yyyy-MM-dd" /></td>
													<td><s:property value="#records.books.position.floor" /></td>
													<td>
														<s:if test="#hasOverdue == true">
															<span class="label label-important">
																有超期书籍未还,不得续借!
															</span>
														</s:if>
														<s:elseif test="#records.isadd == 1">
															<span class="label label-success">
																已续借
															</span>
														</s:elseif>
														<s:else>
															<a class="btn btn-primary" 
																href="<%=basePath %>action/book/renew.do?borrid=
																<s:property value="#records.id"/>">
																	续借
															</a>
														</s:else>
													</td>
												</tr>
											</s:iterator>
										<%} %>	
									</tbody>
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

