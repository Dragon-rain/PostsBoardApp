<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href='/ProjectTest1'> Main page </a>
		<a href='/ProjectTest1/posts'> Posts Board </a>
	</div>
	<form method='post'>
		<label>Title:</label><br>
		<input name='title' value='${post.title}' required='required'/><br>
		<label>Description:</label><br>
		<textarea name='description' required='required'>${post.description}</textarea><br>
		<button>save</button>
	</form>
</body>
</html>