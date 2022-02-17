<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	Index <%=new Date() %>
	<ol>
		<li>
		<a href="./mvc/case01/hello/welcome">./mvc/case01/hello/welcome</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/sayhi?name=stanley&age=999">./mvc/case01/hello/sayhi?name=stanley&age=999</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/bmi?h=170&w=60">./mvc/case01/hello/bmi?h=170&w=60</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/exam/75">./mvc/case01/hello/exam/75</a>
		</li>
	</ol>
</body>
</html>