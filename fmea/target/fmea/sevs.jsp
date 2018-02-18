<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>eFMEA</title>
		<script src="/fmea/fmea.js"></script>
		<link rel="stylesheet" type="text/css" href="/fmea/fmea.css">
	</head>
	<body>
		<h1>eFMEA Application</h1>
		<p>
		Severity Styles and Definitions
		<%@ include file="msgbanner.jsp" %>
		<%@ include file="navbar.html" %>
		<p>
		<table style="border-spacing: 15px; border-collapse: separate">
		<tr>
		<c:forEach items="${allSevGroups}" var="sevGroup">
			<td valign="top">
			<strong>Severity Style:</strong> ${sevGroup.sevStyle.name}<br>(${sevGroup.sevStyle.description})<p>
			<table id="compacttbl">
				<tr><th>Value</th><th>Description</th><th>Action</th></tr>
				<c:forEach items="${sevGroup.sevList}" var="sev">
					<tr>
						<td>${sev.value}</td>
						<td>${sev.description}</td>
						<td><a href="/fmea/sevs?action=delete&id=${sev.id}"><img class="smallicon" src="/fmea/images/delete.gif"></a>
							<a href="/fmea/sevs?action=edit&id=${sev.id}"><img class="smallicon" src="/fmea/images/edit.gif"></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>
			<form action="/fmea/sevs" method="POST">
				<table id="compacttbl">
				<tr><td colspan="2"><b>Add New Severity for ${sevGroup.sevStyle.name} Style:</b></td></tr>
				<tr><td>Value:</td><td><input type="number" name="value" min="1" required></td></tr>
				<tr><td>Description:</td><td><input type="text" name="description" required>
					<input type="hidden" name="sevStyleId" value="${sevGroup.sevStyle.id}">
					<input type="hidden" name="action" value="create">
					</td></tr>
				<tr><td colspan="2"><input type="submit"></td></tr>
				</table>
			</form>
			</td>
		</c:forEach>
		</tr>
		</table>
	</body>
</html>