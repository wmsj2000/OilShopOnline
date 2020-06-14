<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/main.css" />
<meta charset="UTF-8">
<title>ManageSeller</title>
<script type="text/javascript">
		function addSeller() {
			window.location.href = "${pageContext.request.contextPath}/Admin/AddSeller.jsp";
		}
		function p_del() {   
			var msg = "您确定要删除此售货员吗？";   
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
			<li class="list"><a href="${pageContext.request.contextPath}/ManageSellerServlet">销售员管理</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/GetPerformanceServlet">销售业绩</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ReportServlet">销售报表</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/ForecastServlet">销售预测</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/PortraitServlet">用户画像</a></li>
			<li class="list"><a href="${pageContext.request.contextPath}/LogoutServlet">退出登录</a></li>
		</ul>
		</div>
		<div class="main">
	<h3 align="center">销售员列表</h3>
	<p align="center"><button id="add" type="button" onClick="addSeller()">增加销售员</button></p>
	<table border="1" id="DataGrid1" align="center"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;WIDTH: 70%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; background-color: antiquewhite;">
				<td align="center">编号</td>
				<td align="center">销售员姓名</td>
				<td align="center">邮箱</td>
				<td align="center">密码</td>
				<td align="center">负责品牌</td>
				<td align="center">口令重置</td>
				<td align="center">删除</td>
			</tr>
		<c:forEach items="${sellers}" var="p" varStatus="status">
			<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
				<td  align="center" ><input  style="width: 60px;HEIGHT: 22px;" type="text" name="index" value="${status.index+1}" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 100px;HEIGHT: 22px;" type="text" name="seller_name" value="${p.seller_name }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 140px; HEIGHT: 22px;" type="text" name="seller_email" value="${p.seller_email }" readonly="readonly"></td>
				<td  align="center" ><input  style="width: 100px; HEIGHT: 22px;" type="text" name="seller_password" value="${p.seller_password }" readonly="readonly"></td>
				<td  align="center"><input  style="width: 100px;HEIGHT: 22px;" type="text" name="seller_brand" value="${p.seller_brand }" readonly="readonly"></td>
				<td align="center"><button type="button" onclick="window.location='${pageContext.request.contextPath}/ResetPwdServlet?seller_name=${p.seller_name}'">口令重置</button></td>
				<td align="center" style="HEIGHT: 22px" >
				<a href="${pageContext.request.contextPath}/DeleteSellerServlet?seller_name=${p.seller_name}" onclick="javascript:return p_del()">
				<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0"></a>
				</td>		
			</tr>
		</c:forEach>            					
	</table>
 	
		</div>

	</div>
</body>
</html>