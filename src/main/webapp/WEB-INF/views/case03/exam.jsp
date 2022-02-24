<!DOCTYPE html>
<html>
<head>
	<%@ include file="include/header.jspf" %>
</head>
<body class="exambody">
	<table class="examtable">
		<tr>
			<!-- Exam Form -->
			<td valign="top">
				<%@ include file="exam_form.jspf" %>
			</td>
			<!-- Exam List -->
			<td valign="top">
				<%@ include file="exam_list.jspf" %>
			</td>
		</tr>
		
	</table>
	<%@ include file="include/footer.jspf" %>
</body>
</html>