<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<li class="list"><a href="${pageContext.request.contextPath}/FindAllOilServlet">食用油管理</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ShowAllOrdersServlet">用户购买日志</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/AdminLogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
		<table>
		<tr>
			<td width="300px" >
				品牌
				<input style="width: 100px" type="text" name="brand"  id="brand" placeholder="品牌名" readonly="readonly" value=<%=oil_brand %>>
			</td>
			<td width="300px">
				类别<input style="width: 100px" type="text" name="category"  id="category" placeholder="类别" readonly="readonly" value=<%=oil_category %>>
			</td>
			<td width="300px">
				工艺<input style="width: 100px" type="text" name="craft"  id="craft" placeholder="工艺" readonly="readonly" value=<%=oil_craft %>>
			</td>
		</tr>
		<tr>
			<td width="300px">
				等级<input style="width: 100px" type="text" name="rank"  id="rank" placeholder="等级" readonly="readonly" value=<%=oil_rank %>>
			</td>
			<td width="300px">
				容量（L）<input style="width: 60px" type="text" name="capacity"  id="capacity" placeholder="L" readonly="readonly" value=<%=oil_capacity %>>
			</td>
			<td width="300px">
				单价（元）<input style="width: 60px"  type="text" name="price"  id="price" placeholder="单价" readonly="readonly" value=<%=oil_price %>>

			</td>
		</tr>
		<tr>
			<td width="300px">
				上架状态<input style="width: 60px"  type="text" name="state"  id="state" placeholder="上架状态" readonly="readonly" value=<%=oil_state %>>
			</td>
			<td width="300px">
				数量（L）<input style="width: 60px"  type="text" name="number"  id="number" placeholder="数量" readonly="readonly" value=<%=oil_number %>>
			</td>
			<td width="300px">
				编号<input style="width: 60px"  type="text" name="id"  id="id" placeholder="id" readonly="readonly" value=<%=oil_id %>>
			</td>
		</tr>		
	</table>
			<br/><hr/><br/>
			<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/UpdateOilServlet"
		method="post" onsubmit="return checkform1();">
	<table>
		<tr>
			<td width="300px" >
				品牌
				<input style="width: 100px" type="text" name="oil_brand"  id="oil_brand" placeholder="品牌名">
			</td>
			<td width="300px">
				类别<select name="oil_category"  id="oil_category" >
  					<option value =""></option>
  					<option value ="花生油" >花生油</option>
  					<option value="菜籽油">菜籽油</option>
  					<option value="玉米油">玉米油</option>
					<option value="葵花籽油">葵花籽油</option>
					<option value="橄榄油">橄榄油</option>
					<option value="大豆油">大豆油</option>
					<option value="山茶油">山茶油</option>
					<option value="调和油">调和油</option>
					 </select>
			</td>
			<td width="300px">
				工艺<select name="oil_craft"  id="oil_craft" >
  					<option value =""></option>
  					<option value ="压榨">压榨</option>
  					<option value="浸出">浸出</option>
					 </select> 
				
			</td>
		</tr>
		<tr>
			<td width="300px">
				等级<select name="oil_rank"  id="oil_rank" >
  					<option value =""></option>
  					<option value ="二级">二级</option>
  					<option value="一级">一级</option>
					<option value="特级">特级</option>
					 </select> 
			</td>
			<td width="300px">
				容量（L）<input style="width: 60px" type="text" name="oil_capacity"  id="oil_capacity" placeholder="L" >
			</td>
			<td width="300px">
				单价（元）<input style="width: 60px"  type="text" name="oil_price"  id="oil_price" placeholder="单价" >

			</td>
		</tr>
		<tr>
			<td width="300px">
				上架状态<select name="oil_state"  id="oil_state" >
  					<option value ="true">上架中</option>
  					<option value="false">已下架</option>
					 </select> 
			</td>
			<td width="300px">
				数量（L）<input style="width: 60px"  type="text" name="oil_number"  id="oil_number" placeholder="数量" >
			</td>
			<td width="300px">
				编号<input style="width: 60px"  type="text" name="oil_id"  id="oil_id" placeholder="id" readonly="readonly" value=<%=oil_id%>>
			</td>
		</tr>
		<tr>
			<td>
				
			</td>
			<td>
				
			</td>
			<td>
			<button id="update" type="submit" >确认修改</button>
			</td>
		</tr>
		
	</table>
	</form>
		</div>

	</div>
</body>
</html>