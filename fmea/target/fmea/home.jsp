<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>eFMEA</title>
		<script src="/fmea/fmea.js"></script>
		<link rel="stylesheet" type="text/css" href="/fmea/fmea.css">
	</head>
	<body>
		<h1>eFMEA Application</h1>
		<br>User: ${user.firstname} ${user.lastname}
		<p>
		Home Page
		<%@ include file="msgbanner.jsp" %>
		<%@ include file="navbar.html" %>
		<p>
		<table border="1">
			<tr valign="top"><th>My FMEAs</th><th>Recent Activity</th></tr>
			<tr valign="top">
				<td>STEP v1.1, Last Revised: 23-Jan-2018</td>
				<td>
					<ol>
						<li>23-Jan-2018, STEP v1.1 FMEA update by Derzay, Gregory
						<li>21-Jan-2018, FFA v1.1 FMEA update by Ks, Shailendra
					</ol>
				</td>
			</tr>
		</table>
	</body>
</html>