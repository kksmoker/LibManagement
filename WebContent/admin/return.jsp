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
							<i class="icon-home"></i>&nbsp;&nbsp;借入
						</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="tablewidget" class="block-body collapse in">
								<table class="table table-hover table-bordered">
									<form action="${basePath }action/storage/retn.do" method="post">
										<tr>
											<th>图书条形码</th>
											<td>
												<input type="text" required="required" name="barcode"/>
											</td>
										</tr>
										<tr>
											<th>读者编号</th>
											<td>
												<input type="text" required="required" name="uid"/>
											</td>
										</tr>
										<tr>
											<th></th>
											<td>
												<input type="submit" value="确定" class="btn btn-primary" />
												${msg }
											</td>
										</tr>
									</form>
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

