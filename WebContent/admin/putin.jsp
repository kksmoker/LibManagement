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
<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.css">
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
							<i class="icon-home"></i>&nbsp;&nbsp;入库
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<form action="${basePath }action/storage/putin.do" method="post">
									<table class="table table-hover table-bordered">
										<tr>
											<th>条形码</th>
											<td><input type="text" name="book.barcode" required="required"/></td>
										</tr>
										<tr>
											<th>题名</th>
											<td><input type="text" name="book.name" required="required" /></td>
										</tr>
										<tr>
											<th>作者</th>
											<td><input type="text" name="book.author" required="required" /></td>
										</tr>
										<tr>
											<th>ISBN</th>
											<td><input type="text" name="book.isbn" required="required" /></td>
										</tr>
										<tr>
											<th>分类</th>
											<td>
												<select name="category.id">
													<s:iterator value="#request.categorys" id="category">
														<option value="<s:property value="#category.id"/>">
															<s:property value="#category.name"/>
														</option>
													</s:iterator>
												</select>
											</td>
										</tr>
										<tr>
											<th>位置</th>
											<td>
												<select name="position.id">
													<s:iterator value="#request.positions" id="position">
														<option value="<s:property value="#position.id"/>">
															<s:property value="#position.floor"/>
														</option>
													</s:iterator>
												</select>
											</td>
										</tr>
										<tr>
											<th>出版社</th>
											<td><input type="text" name="book.press" required="required" /></td>
										</tr>
										<tr>
											<th>出版日期</th>
											<td><input type="text" name="book.pubdate" required="required" /></td>
										</tr>
										<tr>
											<th>单价</th>
											<td><input type="text" name="book.price" required="required" /></td>
										</tr>
										<tr>
											<th>数量</th>
											<td><input type="text" name="book.amount" required="required"></td>
										</tr>
										<tr>
											<th></th>
											<td colspan="1">
												<input type="submit" value="确定" class="btn btn-primary" />
												${msg }
											</td>
										</tr>
									</table>
								</form>
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

										