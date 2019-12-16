<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			<h3 align="center">购物车列表</h3>
	
	<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 80%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td  align="center" >编号</td>
				<td align="center">商品</td>
				<td align="center">上架情况</td>
				<td align="center">商品单价</td>
				<td align="center">商品余量</td>
				<td align="center">购买数量</td>
				<td align="center">购买</td>
				<td align="center">移除</td>
			</tr>
            <!--  循环输出所有商品 -->
		<c:forEach items="${oils}" var="p" varStatus="status">
		<form id="Form2" name="Form2" action="${pageContext.request.contextPath}/BuyOilServlet?oil_id=${p.oil_id}" method="post">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 50px;HEIGHT: 22px;" type="text" name="id" value="${status.index+1}" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 200px;HEIGHT: 22px;" type="text" name="oil" value="${p.oil_brand }${p.oil_rank }${p.oil_craft }${p.oil_category } ${p.oil_capacity }L" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 50px; HEIGHT: 22px;" type="text" name="oil_state" value="${p.oil_state}" readonly="readonly"></td>
				<!-- <td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_category" value="${p.oil_category }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_craft" value="${p.oil_craft }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_rank"value="${p.oil_rank }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_capacity"value="${p.oil_capacity }" readonly="readonly"></td> -->
				<td  align="center"><input  style="width: 100px;HEIGHT: 22px;" type="text" name="oil_price"value="${p.oil_price }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 100px;HEIGHT: 22px;" type="text" name="oil_number"value="${p.oil_number }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 100px;HEIGHT: 22px;" type="text" name="buy_number"value="1"></td>
				<td align="center" style="HEIGHT: 22px" >
				<button type="submit">
				<img src="${pageContext.request.contextPath}/images/i_add.jpg" border="0" ></button>
				</td>
				<td align="center" style="HEIGHT: 22px" >
				<a href="${pageContext.request.contextPath}/RemoveFromCartServlet?oil_id=${p.oil_id}">
				<img src="${pageContext.request.contextPath}/images/i_del.gif" border="0" ></a>
				</td>				
			</tr>
		</form>
		</c:forEach>            					
	</table>
		</div>
</div>
</body>
</html>