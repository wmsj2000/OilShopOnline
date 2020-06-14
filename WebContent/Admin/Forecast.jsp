<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/Js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>Forecast</title>
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
	<div align="center" style="margin-top:150px;">
	<h3 align="center">热门商品top10</h3>
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH:70%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td align="center">top</td>
				<td align="center">商品编号</td>
				<td align="center">品牌</td>
				<td align="center">类别</td>
				<td align="center">等级</td>
				<td align="center">工艺</td>
				<td align="center">容量/L</td>
				<td align="center">单价/元</td>
				<td align="center">已售</td>
			</tr>
		<c:forEach items="${reports2}" var="p" varStatus="status">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="index" value="${status.index+1 }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 80px;HEIGHT: 22px;" type="text" name="oil_brand" value="${p.oil_brand }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 80px;HEIGHT: 22px;" type="text" name="oil_category" value="${p.oil_category }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 80px;HEIGHT: 22px;" type="text" name="oil_rank" value="${p.oil_rank }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 80px; HEIGHT: 22px;" type="text" name="oil_craft" value="${p.oil_craft}" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 80px; HEIGHT: 22px;" type="text" name="oil_capacity" value="${p.oil_capacity}" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_price" value="${p.oil_price }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 60px; HEIGHT: 22px;" type="text" name="sold_number" value="${p.sold_number }" readonly="readonly"></td>
			</tr>
		</c:forEach>            					
	</table>
	</div>
		</div>

	</div>
</body>
</html>