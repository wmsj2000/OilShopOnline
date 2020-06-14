<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/Js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>Portrait</title>
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
		action="${pageContext.request.contextPath}/PortraitServlet"
		method="post" onsubmit="return checkform1();">
<p align="center">
用户姓名：<input id="oid" name="cname" type="text" style="width:100px;" placeholder="customer_name">
</p>
<p align="center"><input id="per" type="submit" value="查询"></p>
</form>
	
	<h3 align="center">用户画像</h3>
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH:60%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td align="center">编号</td>
				<td align="center">用户姓名</td>
				<td align="center">喜欢品牌</td>
				<td align="center">喜欢类别</td>
				<td align="center">喜欢等级</td>
				<td align="center">喜欢工艺</td>
				
				
			</tr>
		<c:forEach items="${portraits}" var="p" varStatus="status">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center"><input  style="width: 50px;HEIGHT: 22px;" type="text" name="index" value="${status.index+1 }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 80px; HEIGHT: 22px;" type="text" name="customer_name" value="${p.customer_name}" readonly="readonly"></td>
				<td  align="center"><input  style="width: 80px;HEIGHT: 22px;" type="text" name="oil_brand" value="${p.oil_brand}" readonly="readonly"></td>
				<td  align="center"><input  style="width: 80px; HEIGHT: 22px;" type="text" name="oil_category" value="${p.oil_category }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 70px;HEIGHT: 22px;" type="text" name="oil_rank" value="${p.oil_rank }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 70px;HEIGHT: 22px;" type="text" name="oil_craft" value="${p.oil_craft }" readonly="readonly"></td>
			</tr>
		</c:forEach>            					
	</table>
 	
		</div>

	</div>
</body>
</html>