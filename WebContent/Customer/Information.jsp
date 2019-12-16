<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setContentType("text/html;charest=utf-8");
request.setCharacterEncoding("UTF-8");
String customer_name = (String)request.getSession().getAttribute("customer_name");
String customer_email = (String)request.getSession().getAttribute("customer_email");
%>
<div class="wrap">
<div class="nav">
		<ul class="lists">
			<li class="list"><a href="${pageContext.request.contextPath}/CustomerFindAllOilServlet">食用油商城</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ShowCartServlet">购物车</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ShowOrdersServlet">历史订单</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/Customer/Information.jsp">我的账号</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/LogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
		<h3 align="center">个人信息</h3>
	<table>
		<tr>
			<td width="300px" >
				用户名：
				<input type="text" name="customer_name"  id="customer_name" placeholder="用户名" value=<%=customer_name %> readonly="readonly">
			</td>
		</tr>
		<tr>
			<td width="300px" >
				邮箱账号：
				<input type="text" name="customer_email"  id="customer_email" placeholder="邮箱" value=<%=customer_email %> readonly="readonly">
			</td>
		</tr>			
	</table>
	<br/><hr/>
	<h3 align="center">注销账号</h3>
			<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/CancleServlet"
		method="post" onsubmit="return checkform();">
	<table>
	<tr>
			<td width="300px" >
				原密码：
				<input type="text" name="customer_password"  id="customer_password" placeholder="密码">
			</td>
		</tr>
	<tr>
			<td>
				<button id="cancle" type="submit" >注销账号</button>
			</td>
		</tr>
	</table>
		
	</form>
		</div>

	</div>
</body>
</html>