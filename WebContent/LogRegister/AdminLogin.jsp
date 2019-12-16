<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/Login.css" />
<meta charset="UTF-8">
<title>管理员登录</title>
</head>
<body>
<div class="wrap">
    <div class="container">
        <h2>管理员登录</h2>
        <form action="${pageContext.request.contextPath}/AdminLoginServlet" method="post" onsubmit="return checkForm2();">
			<table>
				<tr>
					<td><input type="text" id="name" name="name" placeholder="用户名"/></td>
				</tr>
				<tr>
					<td><input type="text" id="pwd" name="pwd" placeholder="密码" /></td>
				</tr>
				<tr>
					<td><p><a href="${pageContext.request.contextPath}/LogRegister/AdminFindBackPassword.jsp" class="to_findbackpassword">忘记密码</a></p></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"/></td>
				</tr>
				<tr>
					<td>
						<p><a href="${pageContext.request.contextPath}/LogRegister/Login.jsp" class="backto_login">返回用户登录 </a></p>
					</td>
				</tr>
			</table>
            
        </form>
    </div>
</div>
</body>
</html>