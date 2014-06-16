<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../frame/head.jsp" />
</head>

<body>
	<%@ include file="../frame/nav.jsp" %>
	<div class="container">
		<div class="row-fluid">
			<jsp:include page="../frame/bar.jsp" />
			<!-- 右侧内容 -->
			<div class="span7">
				<div class="row-fluid">
					<div class="block">
						<p class="block-heading"><i class="icon-home"></i>&nbsp;&nbsp;入馆须知</p>
						<div id="chart-container" class="block-body collapse in">
							<div id="line-chart">
							<pre>
（一） 校内师生员工凭校徽（或工作证、借书证、学生证）入馆。
（二） 外单位人员凭介绍信到办公室联系。
（三） 馆内严禁吸烟。
（四） 请保持馆内清洁，切勿随地吐痰，切勿乱扔杂物，雨后入馆请注
       意脚下清洁。
（五） 请保持馆内安静，切勿喧哗。
（六） 读者入馆衣着应恭整，不得穿背心、裤衩、拖鞋入馆。
（七） 读者只能带书包入馆、禁止将各种球类等带入馆内。
（八） 闭馆前二十分钟，谢绝读者入馆。
							</pre>
							<br/>
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

