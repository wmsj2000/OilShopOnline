<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>AddSeller</title>
</head>
<body>
<%
response.setContentType("text/html;charest=utf-8");
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8"); 
%>
<div class="wrap">
<div class="nav">
		<ul class="lists">
			<li class="list"><a href="${pageContext.request.contextPath}/ManageSellerServlet">销售员管理</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/GetPerformanceServlet">销售业绩</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ReportServlet">销售报表</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ForecastServlet">销售预测</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/PortraitServlet">用户画像</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/LogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
			<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/AddSellerServlet"
		method="post" onsubmit="return checkform1();">
	<div align="center" style="height:30%;width:30%;position:fixed;margin-left:30%;margin-top:240px;background-color: antiquewhite;">
	<h3>新增销售员信息</h3>
	<table>
		<tr>
			<td width="300px" >
				姓名
				<input style="width: 100px" type="text" name="seller_name"  id="seller_name" placeholder="必填">
			</td>
			<td width="300px" >
				密码
				<input style="width: 100px" type="text" name="seller_password"  id="seller_password" placeholder="必填">
			</td>
		</tr>
		<tr>
			<td width="300px" >
				邮箱
				<input style="width: 100px" type="text" name="seller_email"  id="seller_name" placeholder="必填">
			</td>
			<td width="300px" >
				负责品牌
				<input style="width: 100px" type="text" name="seller_brand"  id="seller_brand" placeholder="必填">
			</td>
		</tr>
		
	</table>
	<hr/>
	<br/>
	<input id="add" type="submit" value="确认增加">

	</div>
	
	</form>
		</div>

	</div>
</body>
</body>
</html>