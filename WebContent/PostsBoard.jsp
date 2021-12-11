<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<div>
		<a href='/ProjectTest1'> Main page </a>
		<a href='/ProjectTest1/posts'> Posts Board </a>
		<a href='/ProjectTest1/chat-page'> Chat room </a>
	</div>
	<h1>게시판</h1>
	<c:if test="${user!='null' && user.role=='ADMIN'}">
		<a href='/ProjectTest1/administrator-page'>admin dash board</a>
	</c:if>
	<a href='/ProjectTest1/add-post'><button>Add post</button></a>
	<c:if test="${user!=null}">
		<form action='logout' method='post'><button>Logout</button></form>
	</c:if>
	<table>
		<c:if test="${not empty postsList}">
			<c:forEach items="${postsList}" var="post">
				<tr>
				<th><a href='/ProjectTest1/post?id=${post.id}'>${post.title}</a></th>
				<th>${post.created}</th>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty  postsList}">
			<div>no any posts found</div>
		</c:if>
	</table>
</body>
</html>