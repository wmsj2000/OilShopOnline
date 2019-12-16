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
			<li class="list"><a href="${pageContext.request.contextPath}/FindAllOilServlet">食用油管理</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ShowAllOrdersServlet">用户购买日志</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/Admin/Summary.jsp">统计报表</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/AdminLogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
			<h3 align="center">用户购买日志</h3>
	
	<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 60%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td  align="center" >商品编号</td>
				<td align="center">上架状态</td>
				<td align="center">商品单价</td>
				<td align="center">已售数目</td>
				<td align="center">商品售额</td>
			</tr>
            <!--  循环输出所有商品 -->
		<c:forEach items="${oils}" var="p" varStatus="status">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id}" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 120px;HEIGHT: 22px;" type="text" name="oil_state" value="${p.oil_state }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 120px; HEIGHT: 22px;" type="text" name="oil_price" value="${p.oil_price}" readonly="readonly"></td>
				<td  align="center"><input  style="width: 100px;HEIGHT: 22px;" type="text" name="sold_number"value="${sold_numbers[status.index].order_number}" readonly="readonly"></td>
				<td  align="center"><input  style="width: 60px;HEIGHT: 22px;" type="text" name="money" value="${sold_numbers[status.index].order_number}*${p.oil_price}" readonly="readonly"></td>		
			</tr>
		</c:forEach>          					
	</table>
	<br/><hr/>
	<p style="font_size:20px;">总售额：</p><input  style="width: 60px;HEIGHT: 22px;" type="text" name="total_money" value="${total_money}" readonly="readonly">
		</div>

	</div>
</body>
</html>