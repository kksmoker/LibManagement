<%@page import="com.lib.domain.User"%>
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
				<ul class="nav pull-right">
					<%
						User user = (User) session.getAttribute("user");
						if (user == null) {
					%>
					<li id="fat-menu" class="dropdown">
						<a href="sign-in.jsp">
							<i class="icon-user"></i>登录
						</a>
					</li>
					<%
						} else {
					%>
					<li id="fat-menu" class="dropdown">
						<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> 
							<i class="icon-user"></i><%=user.getName()%>
							<i class="icon-caret-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="personal/index.jsp"> 控制台</a></li>
							<li><a tabindex="-1" href="action/user/logout.do"> 退出 </a></li>
						</ul>
					</li>
					<%
						}
					%>


				</ul>
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
			<div class="container-fluid">

				<div class="row-fluid">
					<div class="span9 offset1">
						<br />
						<h1 class="page-title">图书馆简介</h1>
						<div class="well">
							<h2>图书馆的历史</h2>
							<span class="span12"> <img src="img/tsg.jpg"
								class="span4 img-polaroid" />
							</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图书馆的历史——早在公元前3000年时，巴比伦的神庙中就收藏有刻在胶泥板上的各类记载。
							最早的图书馆是希腊神庙的藏书之所和附属于希腊哲学书院（公元前4世纪）的藏书之所。 <br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最早的图书馆——亚述巴尼拔图书馆
							<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据考古学家的发掘成果，我们已知世界上最早的图书馆也在美索不达米亚。
							而闻名于世的是亚述巴尼拔图书馆。这是现今已发掘的古文明遗址中保存最完整、规模最宏大、书籍最齐全的图书馆。
							在时间上要比埃及著名的亚历山大图书馆早400年，而且由于泥版图书的特殊性，没有像亚历山大图书馆一样毁于战火，
							大部分都保存了下来。我国的图书馆历史悠久。只是起初并不称做“图书馆”，而是称
							为“府”、“阁”、“观”、“台”、“殿”、“院”、“堂”、“斋”、“楼”罢了。如西周的盟府，两汉的石渠阁、东观和兰台，
							隋朝的观文殿，宋朝的崇文院，明代的澹生堂，清朝的四库全书七阁等等。“图书馆”是一个外来语， 于19世纪末从日本传到我国。

							<h2>中国情况</h2>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在我国，通常使用的划分图书馆类型的标准主要有如下几种：
							<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							1.按图书馆的管理体制（隶属关系）划分。如：文化系统图书馆，教育系统图书馆，军事系统图书馆等。 <br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							2.按馆藏文献范围划分。如：综合性图书馆，专业性图书馆等。 <br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							3.按用户群划分。如：儿童图书馆，盲人图书馆，少数民族图书馆等。 <br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							4.按图书载体划分。如：传统图书馆，数字图书馆，移动图书馆，真人图书馆等。 <br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							5.我国图书馆的类型主要有：国家图书馆，公共图书馆，学校图书馆，科学图书馆，专业图书馆,少数民族图书馆等。 <br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							对图书馆类型的划分不能只采用单一的标准，必须把各种标准结合起来使用，才具有完全的意义。 <br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							在上述各类型图书馆中，通常认为公共图书馆，科学图书馆，高等院校图书馆是我国整个图书馆事业的三大支柱。 <br />

							<h2>世界十大图书馆</h2>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							1．美国国会图书馆——华盛顿<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							2．俄罗斯国立图书馆——莫斯科<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							3．中国国家图书馆——北京<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							4．俄罗斯国家图书馆——圣彼得堡<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							5．大英图书馆——伦敦<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							6．哈佛大学图书馆——马萨诸塞<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							7．法国国家图书馆——巴黎<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							8．莱比锡图书馆（属于德意志国家图书馆）——莱比锡<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							9．日本国会图书馆——东京<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							10．法兰克福图书馆（属于德意志国家图书馆）——法兰克福<br />
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="frame/footer.html" />
</body>
</html>

