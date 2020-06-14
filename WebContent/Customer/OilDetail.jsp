<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="OilShopOline.domain.Oil" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<%
response.setContentType("text/html;charest=utf-8");
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
String oil_id = request.getParameter("oil_id"); 
String oil_brand = request.getParameter("oil_brand"); 
String oil_category = request.getParameter("oil_category"); 
oil_category=java.net.URLDecoder.decode(oil_category,"UTF-8");
String oil_craft = request.getParameter("oil_craft"); 
String oil_rank = request.getParameter("oil_rank"); 
String oil_capacity = request.getParameter("oil_capacity"); 
String oil_price = request.getParameter("oil_price"); 
String oil_number = request.getParameter("oil_number"); 
%>
<div id="container" style="height:100%;width:100%;position:fixed;background-color: antiquewhite;">
<div id="box" align="center" style="height:30%;width:30%;position:fixed;margin-left:35%;margin-top:200px;background-color: white;">
<h3 align="center">商品详情</h3>
<table align="center">
		<tr>
			<td>
				编号:<%=oil_id %>
			</td>
			<td>
				品牌:<%=oil_brand %>
			</td>
			
		</tr>
		<tr>
		<td>
				类别:<%=oil_category %>
			</td>
			<td>
				工艺:<%=oil_craft %>
			</td>
			
		</tr>
		<tr>
			<td>
				等级:<%=oil_rank %>
			</td>
			<td>
				容量:<%=oil_capacity %>(L)
			</td>
			
		</tr>
		<tr>
			<td>
				单价:<%=oil_price %>（元）

			</td>
			<td>
				余量:<%=oil_number %>
			</td>
		</tr>
	</table>
<hr>
<a href="${pageContext.request.contextPath}/AddToCartServlet?oil_id=<%=oil_id %>">
<input type="button" value="加入购物车">
</a>

<a href="${pageContext.request.contextPath}/ReturnServlet">
<input type="button" value="返回商城">
</a>
</div>
</div>
</body>
</html>