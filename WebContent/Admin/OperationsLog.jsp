<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<%
response.setContentType("text/html;charest=utf-8");
request.setCharacterEncoding("UTF-8");
double total_money=(double)request.getAttribute("total_money"); 
%>
<div class="wrap">
<div class="nav">
		<ul class="lists">
			<li class="list"><a href="${pageContext.request.contextPath}/FindAllOilServlet">食用油管理</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ShowAllOrdersServlet">用户购买日志</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/AdminLogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
		<h3 align="center">用户购买日志</h3>
	
	<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 60%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td  align="center" >订单编号</td>
				<td align="center">日期</td>
				<td align="center">时间</td>
				<td align="center">用户名</td>
				<td align="center">商品编号</td>
				<td align="center">购买数量</td>
			</tr>
            <!--  循环输出所有商品 -->
		<c:forEach items="${orders}" var="p" varStatus="status">
		<form id="Form2" name="Form2" action="${pageContext.request.contextPath}/BuyOilServlet?oil_id=${p.oil_id}" method="post">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="order_id" value="${p.order_id}" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 120px;HEIGHT: 22px;" type="text" name="order_date" value="${p.order_date }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 120px; HEIGHT: 22px;" type="text" name="order_time" value="${p.order_time}" readonly="readonly"></td>
				<td  align="center"><input  style="width: 100px;HEIGHT: 22px;" type="text" name="customer_name"value="${p.customer_name }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_id"value="${p.oil_id }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 60px;HEIGHT: 22px;" type="text" name="order_number"value="${p.order_number }" readonly="readonly"></td>			
			</tr>
		</form>
		</c:forEach>            					
	</table>
	<br/><hr/>
	总销售额：<input style="width: 60px;HEIGHT: 22px;" type="text" name="total_money" value="<%=total_money%>" readonly="readonly">元
		</div>
</div>
</body>
</html>