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
		action="${pageContext.request.contextPath}/ReportServlet"
		method="post" onsubmit="return checkform1();">
<p align="center">
商品编号：<input id="oid" name="oid" type="text" style="width:100px;" placeholder="id">
商品品牌：<input id="obrand" name="obrand" type="text" style="width:100px;" placeholder="brand">
</p>
<p align="center"><input id="per" type="submit" value="查询"></p>
</form>
	
	<h3 align="center">销售报表</h3>
	<p align="center">总销售额：<input id="count" name="count" type="text" style="width: 70px;" readonly="readonly" value="${count}">元</p>
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH:70%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td align="center">商品编号</td>
				<td align="center">商品</td>
				<td align="center">商品单价/元</td>
				<td align="center">商品已售</td>
				<td align="center">商品库存</td>
				<td align="center">销售状态</td>
				
			</tr>
		<c:forEach items="${reports}" var="p">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 200px; HEIGHT: 22px;" type="text" name="oil" value="${p.oil_brand}${p.oil_rank}${p.oil_craft}${p.oil_category} ${p.oil_capacity}L" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_price" value="${p.oil_price }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 60px; HEIGHT: 22px;" type="text" name="sold_number" value="${p.sold_number }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_number" value="${p.oil_number }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_state" value="${p.oil_state }" readonly="readonly"></td>
			</tr>
		</c:forEach>            					
	</table>
 	
		</div>

	</div>
</body>
</html>