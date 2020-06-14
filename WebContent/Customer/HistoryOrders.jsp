<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>History Orders</title>
</head>
<body>
<div class="wrap">
<div class="nav">
		<ul class="lists">
			<li class="list"><a href="${pageContext.request.contextPath}/CustomerFindAllOilServlet">食用油商城</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/RecommendationServlet">商品推荐</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ShowCartServlet">购物车</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ShowOrdersServlet">历史订单</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/Customer/Information.jsp">我的账号</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/LogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
			<h3 align="center">已购商品列表</h3>
	
	<table  border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 70%;WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td  align="center" >序号</td>
				<td align="center">商品编号</td>
				<td align="center">商品</td>
				<td align="center">上架情况</td>
				<td align="center">商品单价</td>
				<td align="center">已购数量</td>
			</tr>
            <!--  循环输出所有商品 -->
		<c:forEach items="${boughtoils}" var="p" varStatus="status">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 50px;HEIGHT: 22px;" type="text" name="id" value="${status.index+1}" readonly="readonly"></td>
				<td  align="center" ><input  align="middle" style="width: 50px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id}" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 220px;HEIGHT: 22px;" type="text" name="oil" value="${p.oil_brand }${p.oil_rank }${p.oil_craft }${p.oil_category } ${p.oil_capacity }L" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 60px; HEIGHT: 22px;" type="text" name="oil_state" value="${p.oil_state}" readonly="readonly"></td>
				<!-- <td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_category" value="${p.oil_category }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_craft" value="${p.oil_craft }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_rank"value="${p.oil_rank }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_capacity"value="${p.oil_capacity }" readonly="readonly"></td> -->
				<td  align="center"><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_price"value="${p.oil_price }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 60px;HEIGHT: 22px;" type="text" name="order_number"value="${orders[status.index].order_number}" readonly="readonly"></td>
								
			</tr>
		</c:forEach>            					
	</table>
		</div>

	</div>
</body>
</html>