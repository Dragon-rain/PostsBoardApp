<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello test</title>
</head>
<body>
	<div>
		<a href='/ProjectTest1'> Main page </a>
		<a href='/ProjectTest1/posts'> Posts Board </a>
		<a href='/ProjectTest1/chat-page'> Chat room </a>
	</div>
	<h1 id="title" >안녕하세요!</h1>
		<h3>Login</h3>
		<form action="login" method="post">
			<div>
				<input name="username" placeholder="username" required="required"/>
			</div>
			<div>
				<input name="password" placeholder="password" required="required" type="password"/>
			</div>
			<button type="submit">Login</button>
		</form>
	<a href="http://localhost:8090/ProjectTest1/registration"><button>회원가입</button></a>
</body> 
</html>