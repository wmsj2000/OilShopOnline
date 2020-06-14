<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/Login.css" />
<meta charset="UTF-8">
<title>找回密码</title>
</head>
<body>
<%
String pwd = (String)request.getAttribute("pwd");
if(pwd==null){
	pwd="";
}else{
	pwd="成功找回密码:"+pwd;
}
%>
        
<div class="wrap">
    <div class="container">
        <h2>找回密码</h2>
			
  			<form id="getvc" name="getvc" action="${pageContext.request.contextPath}/FindBackPasswordServlet" method="post" onsubmit="return checkForm();">
			<table id="t1" >
				<tr>
					<td><input type="text" id="email" name="email" placeholder="账号绑定邮箱"/></td>
				</tr>
				<tr>
					<td><input type="submit" id="getvc" name="getvc" value="获取验证码"></td>
				</tr>
			
				
			</table>
			</form>
			
				<form id="submitvc" name="submitvc" action="${pageContext.request.contextPath}/CheckVcServlet" method="post" onsubmit="return checkForm();">
				<table id="t2" >
				<tr>
					<td><input type="text" id="vc" name="vc" placeholder="请输入验证码" /></td>
				</tr>
				<tr>
					<td><input type="submit" id="submitvc" name="submitvc" value="提交验证码"></td>
				</tr>
				
				<tr>
					<td><input type="text" id="pwd" name="pwd" placeholder="密码" value=<%=pwd%> ></td>
				</tr>
				<tr>
					<td><p><a href="${pageContext.request.contextPath}/LogRegister/Login.jsp">返回登录</a></p></td>
				</tr>
			</table>
			</form>
    </div>
</div>
</body>
</html>