<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>UpdateOil</title>
</head>
<body>
<%
response.setContentType("text/html;charest=utf-8");
request.setCharacterEncoding("UTF-8");
String oil_id = request.getParameter("oil_id"); 
String oil_brand = request.getParameter("oil_brand"); 
String oil_category = request.getParameter("oil_category"); 
String oil_craft = request.getParameter("oil_craft"); 
String oil_rank = request.getParameter("oil_rank"); 
String oil_capacity = request.getParameter("oil_capacity"); 
String oil_price = request.getParameter("oil_price"); 
String oil_number = request.getParameter("oil_number"); 
String oil_state = request.getParameter("oil_state"); 
%>
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
		<div align="center" style="height:32%;width:40%;position:fixed;margin-left:24%;margin-top:200px;background-color: antiquewhite;">
		<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/SellerUpdateOilServlet"
		method="post" onsubmit="return checkform1();">
		<h3 align="center">商品信息修改</h3>
		<table>
		<tr>
			<td width="300px">
				编号<input style="width: 60px"  type="text" name="oil_id"  id="oil_id" placeholder="id" readonly="readonly" value=<%=oil_id %>>
			</td>
			<td width="300px" >
				品牌
				<input style="width: 100px" type="text" name="oil_brand"  id="oil_brand" placeholder="品牌名" readonly="readonly" value=<%=oil_brand %>>
			</td>
			<td width="300px">
				类别<input style="width: 100px" type="text" name="oil_category"  id="oil_category" placeholder="类别" readonly="readonly" value=<%=oil_category %>>
			</td>
			
		</tr>
		<tr>
			<td width="300px">
				工艺<input style="width: 100px" type="text" name="oil_craft"  id="oil_craft" placeholder="工艺" readonly="readonly" value=<%=oil_craft %>>
			</td>
			<td width="300px">
				等级<input style="width: 100px" type="text" name="oil_rank"  id="oil_rank" placeholder="等级" readonly="readonly" value=<%=oil_rank %>>
			</td>
			<td width="300px">
				容量（L）<input style="width: 60px" type="text" name="oil_capacity"  id="oil_capacity" placeholder="L" readonly="readonly" value=<%=oil_capacity %>>
			</td>
			
			
		</tr>
		<tr>
		
			<td width="300px">
				上架状态<input style="width: 60px"  type="text" name="oil_state"  id="oil_state" placeholder="上架状态" readonly="readonly" value=<%=oil_state %>>
			</td>
			<td width="300px">
				单价（元）<input style="width: 60px"  type="text" name="oil_price"  id="oil_price" placeholder="单价" value=<%=oil_price %>>

			</td>
			<td width="300px">
				数量（L）<input style="width: 60px"  type="text" name="oil_number"  id="oil_number" placeholder="数量" value=<%=oil_number %>>
			</td>
			
		</tr>		
	</table>
	<hr/>
	<br/>
	<input id="update" type="submit" value="确认修改">
	</form>
	</div>	
		</div>

	</div>
</body>
</html>