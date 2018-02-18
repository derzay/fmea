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
		Manage Applications
		<%@ include file="msgbanner.jsp" %>
		<%@ include file="navbar.html" %>
		<p>
		<table id="stdtbl">
			<tr><th>ID</th><th>Application Name</th><th>Action</th></tr>
			<c:forEach items="${allApps}" var="app">
				<tr>
					<td>${app.id}</td>
					<td>${app.name}</td>
					<td><a href="/fmea/apps?action=delete&id=${app.id}"><img class="smallicon" src="/fmea/images/delete.gif"></a>
						<a href="/fmea/apps?action=edit&id=${app.id}"><img class="smallicon" src="/fmea/images/edit.gif"></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<p>
		<form action="/fmea/apps" method="POST">
			Add New Application: <input type="text" name="name">
			<input type="hidden" name="action" value="create">
			<input type="submit">
		</form>
	</body>
</html>