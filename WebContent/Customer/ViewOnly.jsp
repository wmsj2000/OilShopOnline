<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>ViewOnly</title>
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
			<li class="list"><a href="${pageContext.request.contextPath}/NoLoginServlet">全部商品浏览</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/LogRegister/Login.jsp">返回登录</a></li>
		</ul>
		</div>
		<div class="main">
			
	
	<h3 align="center">食用油列表</h3>
	
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 60%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td  align="center" >食用油id</td>
				<td align="center">品牌</td>
				<td align="center">类别</td>
				<td align="center">工艺</td>
				<td align="center">等级</td>
				<td align="center">容量</td>
			</tr>
            <!--  循环输出所有商品 -->
		<c:forEach items="${oils}" var="p">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_id" value="${p.oil_id }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_brand" value="${p.oil_brand }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_category" value="${p.oil_category }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 110px; HEIGHT: 22px;" type="text" name="oil_craft" value="${p.oil_craft }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_rank"value="${p.oil_rank }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 110px;HEIGHT: 22px;" type="text" name="oil_capacity"value="${p.oil_capacity }" readonly="readonly"></td>		
			</tr>
		</c:forEach>            					
	</table>
  
		</div>

</div>
</body>
</html>