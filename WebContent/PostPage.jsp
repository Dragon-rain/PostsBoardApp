<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
<title>post page</title>
</head>
<body>
	<div>
		<a href='/ProjectTest1'> Main page </a>
		<a href='/ProjectTest1/posts'> Posts Board </a>
	</div>
	<h1>${post.title}</h1>
	<span>${post.created}</span>
	<div>${post.description}</div>
	<c:if test="${not empty user && user.id == post.userId}">
		<a href='/ProjectTest1/edit-post?id=${post.id}'><button>편집 </button></a>
		<form action='delete-post' method='post'><input name='id' value='${post.id}' hidden='true'/><button>삭제</button></form>
	</c:if>
</body>
</html>