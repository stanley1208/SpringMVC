<%@ page import="java.util.Date"%>
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
		<li>
		<a href="./mvc/case01/hello/calc/add?x=30&y=20">./mvc/case01/hello/calc/add?x=30&y=20</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/path/namejohn/java8">./mvc/case01/hello/path/namejohn/java8</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/age?age=18&age=19&age=20">./mvc/case01/hello/age?age=18&age=19&age=20</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/javaexam?score=80&score=100&score=50">./mvc/case01/hello/javaexam?score=80&score=100&score=50</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/user?name=John&age=18">./mvc/case01/hello/user?name=John&age=18</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/person?name=Mary&score=90&level=2">./mvc/case01/hello/person?name=Mary&score=90&level=2</a>
		</li>
		<li>
		<a href="./mvc/case01/hello/sessionInfo">./mvc/case01/hello/sessionInfo</a>
		</li>
	</ol>
</body>
</html>