<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>OrderLog</title>
</head>
<body>
<div class="wrap">
<div class="nav">
		<ul class="lists">
			<li class="list"><a href="${pageContext.request.contextPath}/OilManageServlet">食用油管理</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/BrowseLogServlet">用户浏览日志</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/OrderLogServlet">用户购买日志</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/AbnormalServlet">销售监控</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/LogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
	<h3 align="center">用户购买日志</h3>
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 70%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td align="center">订单编号</td>
				<td align="center">日期</td>
				<td align="center">时间</td>
				<td align="center">顾客姓名</td>
				<td align="center">商品编号</td>
				<td align="center">商品数目</td>
			</tr>
            <!--  循环输出所有商品 -->
		<c:forEach items="${orders}" var="p">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="order_id" value="${p.order_id }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="order_date" value="${p.order_date }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="order_time" value="${p.order_time }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="customer_name" value="${p.customer_name }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="order_number" value="${p.order_number }" readonly="readonly"></td>
			</tr>
		</c:forEach>            					
	</table>
 	
		</div>

	</div>
</body>
</html>