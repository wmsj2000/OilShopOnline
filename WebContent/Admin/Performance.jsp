<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/Js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>Performance</title>
</head>
<body>
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
		action="${pageContext.request.contextPath}/GetPerformanceServlet"
		method="post" onsubmit="return checkform1();">
<p align="center">
销售员：<input id="sname" name="sname" type="text" style="width:100px;" placeholder="姓名">
</p>
<p align="center">日期：<input id="date1" name="date1" class="Wdate" type="text" style="width:100px;" onclick="WdatePicker({skin:'whyGreen',minDate:'2020-01-01'})"placeholder="起始日期"/>
至<input id="date2" name="date2" class="Wdate" type="text" style="width:100px;" onclick="WdatePicker({skin:'whyGreen',minDate:'2020-01-01'})" placeholder="截止日期"/>
</p>
<p align="center"><input id="per" type="submit" value="查询"></p>

</form>
	
	<h3 align="center">销售业绩</h3>
	<p align="center">总销售额：<input id="count" name="count" type="text" style="width: 70px;" readonly="readonly" value="${count}">元</p>
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH:90%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td align="center">日期</td>
				<td align="center">时间</td>
				<td align="center">销售员</td>
				<td align="center">订单编号</td>
				<td align="center">商品</td>
				<td align="center">商品单价</td>
				<td align="center">销售数量</td>
				<td align="center">订单异常信息</td>
			</tr>
		<c:forEach items="${performances}" var="p">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 100px;HEIGHT: 22px;" type="text" name="order_date" value="${p.order_date }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 100px;HEIGHT: 22px;" type="text" name="order_time" value="${p.order_time }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 80px; HEIGHT: 22px;" type="text" name="seller_name" value="${p.seller_name }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 50px;HEIGHT: 22px;" type="text" name="order_id" value="${p.order_id }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 180px; HEIGHT: 22px;" type="text" name="oil" value="${p.oil_brand}${p.oil_rank}${p.oil_craft}${p.oil_category} ${p.oil_capacity}L" readonly="readonly"></td>
				<td  align="center"><input  style="width: 50px;HEIGHT: 22px;" type="text" name="oil_price" value="${p.oil_price }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 50px;HEIGHT: 22px;" type="text" name="order_number" value="${p.order_number }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 250px;HEIGHT: 22px;" type="text" name="order_abnormal_info" value="${p.order_abnormal_info }" readonly="readonly"></td>
			</tr>
		</c:forEach>            					
	</table>
 	
		</div>

	</div>
</body>
</html>