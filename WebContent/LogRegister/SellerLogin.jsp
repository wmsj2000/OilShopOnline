<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/Login.css" />
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<div class="wrap">
    <div class="container">
        <h2>销售员登录</h2>
        <form action="${pageContext.request.contextPath}/SellerLoginServlet" method="post" onsubmit="return checkForm2();">
			<table>
				<tr>
					<td><input type="text" id="name" name="name" placeholder="用户名"/></td>
				</tr>
				<tr>
					<td><input type="text" id="pwd" name="pwd" placeholder="密码" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"/></td>
				</tr>
				<tr>
					<td>
						<p><a href="${pageContext.request.contextPath}/LogRegister/Login.jsp" class="to_sellerlogin">用户登录 </a></p>
					</td>
				</tr>  
				<tr>
					<td>
						<p><a href="${pageContext.request.contextPath}/LogRegister/AdminLogin.jsp" class="to_adminlogin">管理员登录 </a></p>
					</td>
				</tr>
				<tr>
					<td>
						<p><a href="${pageContext.request.contextPath}/NoLoginServlet" class="to_nologin">游客登录 </a></p>
					</td>
				</tr>
				
			</table>
            
        </form>
    </div>
</div>
</body>
</html>