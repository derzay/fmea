<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>eFMEA</title>
		<link rel="stylesheet" type="text/css" href="fmea.css">
	</head>
	<body>
		<h1>eFMEA Application</h1>
		<%@ include file="msgbanner.jsp" %>
		<p><b>Application List</b><p>
		<table id="stdtbl">
			<tr><th>ID</th><th>Application Name</th><th>Action</th></tr>
			<c:forEach items="${allApps}" var="app">
				<tr>
					<td>${app.id}</td>
					<td>${app.name}</td>
					<td><a href="deleteApp?id=${app.id}"><img class="smallicon" src="images/delete.gif"></a>
						<a href="editApp?id=${app.id}"><img class="smallicon" src="images/edit.gif"></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<p>
		<form action="addApp" method="POST">
			Add New Application: <input type="text" name="newappname">
			<input type="submit">
		</form>
	</body>
</html>