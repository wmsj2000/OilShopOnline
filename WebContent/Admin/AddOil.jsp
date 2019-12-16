<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<li class="list"><a href="${pageContext.request.contextPath}/AdminLogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
			<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/AddOilServlet"
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
  					<option value ="花生油">花生油</option>
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
			
		</tr>
		<tr>
			<td>
				
			</td>
			<td>
				
			</td>
			<td>
			<button id="add" type="submit" >确认增加</button>
			</td>
		</tr>
		
	</table>
	</form>
		</div>

	</div>
</body>
</body>
</html>