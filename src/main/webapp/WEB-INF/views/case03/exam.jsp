<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spform"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Exam Form</title>
</head>
<body style="padding: 15px">

	<spform:form class="pure-form" method="post"
		action="${ pageContext.request.contextPath }/mvc/case03/exam/"
		modelAttribute="exam">
		<fieldset>
			<legend>Exam Form</legend>
			<input type="hidden" id="_method" name="_method" value="${ _method }">
			學號:
			<spform:input path="studentId" />
			<p />
			科目:
			<spform:select path="examId">
				<spform:option value="">請選擇</spform:option>
				<spform:option value="809">Java 8 OCP I</spform:option>
				<spform:option value="819">Java 8 OCP II</spform:option>
				<spform:option value="900">Java 11 OCP</spform:option>
				<spform:option value="">JavaWeb OCP</spform:option>
			</spform:select>
			<p />
			日期:
			<spform:input path="examDate" type="date" />
			<p />
			時段:
			<spform:checkbox path="examSlot" value="A" />
			上午(A)
			<spform:checkbox path="examSlot" value="B" />
			中午(B)
			<spform:checkbox path="examSlot" value="C" />
			晚上(C)
			<p />
			繳費:
			<spform:radiobutton path="examPay" value="true" />
			已繳
			<spform:radiobutton path="examPay" value="false" />
			未繳
			<p />
			備註:
			<spform:textarea path="examNote"/>
			<p />
			<button type="submit"
				class="pure-button pure-button-primary">新增</button>
			<button type="button"
				class="pure-button pure-button-primary" disabled>修改</button>
			<button type="button"
				class="pure-button pure-button-primary">刪除</button>
		</fieldset>
	</spform:form>

	<p />
	${ exams }
	

	<p />
	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>index</th>
				
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<td>${ status.index }</td>
					
				</tr>
			
		</tbody>
	</table>
</body>
</html>