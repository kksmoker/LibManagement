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
							<i class="icon-home"></i>&nbsp;&nbsp;修改
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<form action="${basePath }action/storage/edit.do" method="post">
									<input type="hidden" name="book.id" value="<s:property value="#book.id"/>">
									<table class="table table-hover table-bordered">
										<tr>
											<th>条形码</th> 
											<td>
												<input type="text" name="book.barcode" required="required"
													value="<s:property value="#book.barcode" />"
													 />
											</td>
										</tr>
										<tr>
											<th>题名</th>
											<td>
												<input type="text" name="book.name" required="required"
												value="<s:property value="#book.name" />"
												 />
											</td>
										</tr>
										<tr>
											<th>作者</th>
											<td>
												<input type="text" name="book.author" required="required"
												value="<s:property value="#book.author" />"
												 />
											</td>
										</tr>
										<tr>
											<th>ISBN</th>
											<td>
												<input type="text" name="book.isbn" required="required"
												value="<s:property value="#book.isbn" />"
												 />
											</td>
										</tr>
										<tr>
											<th>分类</th>
											<td>
												<s:bean name="com.lib.service.impl.CategoryServiceImpl" var="categorys">
													<select name="category.id">
														<s:iterator value="#categorys.listAll()" var="category">
															<s:if test="%{#category.id == #book.category.id}">
																<option selected value="<s:property value="#category.id"/>">
																	<s:property value="#category.name"/>
																</option>
															</s:if>
															<s:else>
																<option value="<s:property value="#category.id"/>">
																	<s:property value="#category.name"/>
																</option>
															</s:else>
														</s:iterator>
													</select>	
												</s:bean>
											</td>
										</tr>
										<tr>
											<th>位置</th>
											<td>
												<s:bean name="com.lib.service.impl.PositionServiceImpl" var="positions">
													<select name="position.id">
														<s:iterator value="#positions.listAll()" id="position">
															<s:if test="%{#position.id == #book.position.id}">
																<option value="<s:property value="#position.id"/>">
																	<s:property value="#position.floor"/>
																</option>
															</s:if>
															<s:else>
																<option value="<s:property value="#position.id"/>">
																	<s:property value="#position.floor"/>
																</option>
															</s:else>
														</s:iterator>
													</select>
												</s:bean>
											</td>
										</tr>
										<tr>
											<th>出版社</th>
											<td>
												<input type="text" name="book.press" required="required"
													value="<s:property value="#book.press" />"
												 />
											</td>
										</tr>
										<tr>
											<th>出版日期</th>
											<td>
												<input type="text" name="book.pubdate" required="required"
													value="<s:date name="#book.pubdate" format="yyyy-MM-dd" />"
												 />
											</td>
										</tr>
										<tr>
											<th>单价</th>
											<td>
												<input type="text" name="book.price" required="required"
													value="<s:property value="#book.price" />"
												 />
											</td>
										</tr>
										<tr>
											<th>数量</th>
											<td>
												<input type="text" name="book.amount" required="required"
													value="<s:property value="#book.amount" />"
												/>
											</td>
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

										