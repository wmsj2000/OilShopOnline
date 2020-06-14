<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>OilManage</title>
<script type="text/javascript">
		function addOil() {
			window.location.href = "${pageContext.request.contextPath}/Seller/AddOil.jsp";
		}
		function p_del() {   
			var msg = "您确定要下架该商品吗？";   
			if (confirm(msg)==true){   
			return true;   
			}else{   
			return false;   
			}   
		}

	</script>
</head>
<body>
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
			<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/SellerFindByManyConditionsServlet"
		method="post" onsubmit="return checkform1();">
	<table>
		<tr>
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
				容量<input style="width: 100px" type="text" name="oil_capacity"  id="oil_capacity" placeholder="L" >
			</td>
			<td width="300px">
				单价<input style="width: 60px"  type="text" name="oil_price1"  id="oil_price1" placeholder="最小价格（元）" >~<input style="width: 60px" type="text" name="oil_price2"  id="oil_price2" placeholder="最大价格（元）" >

			</td>
		</tr>
		<tr>
			<td width="300px">
				上架状态<select name="oil_state"  id="oil_state" >
					<option value =""></option>
  					<option value ="true">上架中</option>
  					<option value="false">已下架</option>
					 </select> 
			</td>
			<td width="300px">
				数量（L）<input style="width: 60px"  type="text" name="oil_number1"  id="oil_number1" placeholder="最小数量" >~<input style="width: 60px" type="text" name="oil_number2"  id="oil_number2" placeholder="最大数量" >
			</td>
			<td width="300px">
				编号<input style="width: 100px" type="text" name="oil_id"  id="oil_id" placeholder="食用油编号" >
			</td>
		</tr>
		<tr>
			<td>
				<button id="search" type="submit" >查询</button>
			</td>
		</tr>
		
	</table>
	</form>
	
	<h3 align="center">商品列表</h3>
	
	<p align="center"><button id="add" type="button" onClick="addOil()">增加商品</button></p>
	
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH:80%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td  align="center" >食用油id</td>
				<td align="center">品牌</td>
				<td align="center">类别</td>
				<td align="center">工艺</td>
				<td align="center">等级</td>
				<td align="center">容量</td>
				<td align="center">单价</td>
				<td align="center">数量</td>
				<td align="center">上架状态</td>
				<td align="center">编辑</td>
				<td align="center">下架</td>
			</tr>
            <!--  循环输出所有商品 -->
		<c:forEach items="${oils}" var="p">
		<form id="Form2" name="Form2" action="${pageContext.request.contextPath}/Seller/UpdateOil.jsp" method="post">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_brand" value="${p.oil_brand }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_category" value="${p.oil_category }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_craft" value="${p.oil_craft }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_rank" value="${p.oil_rank }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_capacity" value="${p.oil_capacity }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_price" value="${p.oil_price }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_number" value="${p.oil_number }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_state" value="${p.oil_state }" readonly="readonly"></td>
				<td align="center" style="HEIGHT: 22px" >
				<button type="submit">
				<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" ></button>
				</td>
				<td align="center" style="HEIGHT: 22px" >
				<a href="${pageContext.request.contextPath}/SellerRemoveOilServlet?oil_id=${p.oil_id}" onclick="javascript:return p_del()">
				<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0"></a>
				</td>
			</tr>
		</form>
		</c:forEach>            					
	</table>
 	
		</div>

	</div>
</body>
</html>