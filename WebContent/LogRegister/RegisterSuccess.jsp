<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功</title>
<script type="text/javascript">
    var current_time;
 
    t = setInterval(function () {
        current_time = document.getElementById('stime').innerText;
        document.getElementById('stime').innerText = current_time - 1;
        if (current_time <= 1) {
            clearInterval(t);
            location.href = '${pageContext.request.contextPath}/LogRegister/Login.jsp';
        }
    }, 1000);
</script>
</head>
<body>
<div>
	<p>注册成功！</p><br/>
	<a href="${pageContext.request.contextPath }/LogRegister/Login.jsp"><span id="stime">3</span>秒后跳转至登录页面</a>
</div>
</body>
</html>