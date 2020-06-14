<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	    function findAllOil(){
	    	window.location.href = "${pageContext.request.contextPath}/CustomerFindAllOilServlet";
	    }
	</script>
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
			<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/CustomerFindOilByManyConditionServlet"
		method="post" onsubmit="return checkform1();">
	<div align="center" style="margin-left:10%;">
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
				容量<input style="width: 60px" type="text" name="oil_capacity"  id="oil_capacity" placeholder="L" >
			</td>
			<td width="300px">
				单价<input style="width: 60px"  type="text" name="oil_price1"  id="oil_price1" placeholder="最小价格（元）" >~<input style="width: 60px" type="text" name="oil_price2"  id="oil_price2" placeholder="最大价格（元）" >

			</td>
		</tr>
	</table>
	</div>
	<p align="center">
	<button id="search" type="submit" >查询</button>
	<button id="searchAll" type="button" onclick="findAllOil()">全部查询</button>
	</p>
	</form >
	
	<h3 align="center">商品列表</h3>
	
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 70%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td  align="center" >商品编号</td>
				<td align="center">品牌</td>
				<td align="center">类别</td>
				<td align="center">工艺</td>
				<td align="center">等级</td>
				<td align="center">容量</td>
				<td align="center">浏览详情</td>
			</tr>
            <!--  循环输出所有商品 -->
        
		<c:forEach items="${oils}" var="p">
		<form id="Form2" name="Form2" action="${pageContext.request.contextPath}/BrowseServlet?oil_price=${p.oil_price}&oil_number=${p.oil_number}" method="post" >
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_brand" value="${p.oil_brand }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_category" value="${p.oil_category }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_craft" value="${p.oil_craft }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_rank"value="${p.oil_rank }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_capacity"value="${p.oil_capacity }" readonly="readonly"></td>
				<td align="center" style="HEIGHT: 22px" >
				<button type="submit">详情</button>
				</td>				
			</tr>
		</form> 
		</c:forEach>    
		       					
	</table>
  
		</div>

</div>
</body>
</html>