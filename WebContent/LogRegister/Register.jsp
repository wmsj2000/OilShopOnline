<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/Login.css" />
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
<div class="wrap">
    <div class="container">
        <h2>注册</h2>
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post" onsubmit="return checkForm1();">
			<table>
				<tr>
					<td><input type="text" id="name" name="name" placeholder="用户名"/></td>
				</tr>
				<tr>
					<td><input type="text" id="email" name="email" placeholder="邮箱"/></td>	
				</tr>
				<tr>
					<td><input type="text" id="pwd" name="pwd" placeholder="密码" /></td>
				</tr>
				<tr>
					<td><input type="text" id="pwd2" name="pwd2" placeholder="确认密码" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="注册"/></td>
				</tr>
				<tr>
					<td>
						<p class="change_link" align="center">
                已经有账号？<a href="Login.jsp" class="to_login"> 去登录 </a></p>
					</td>
				</tr>
			</table>
            
        </form>
    </div>
</div>
</body>
</html>