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
		<%@ include file="msgbanner.jsp" %>
		<p>
		<form action="/fmea/login" method="POST">
			<table id="stdtbl">
				<tr><th colspan="2" align="center"><b>eFMEA Login</b></th></tr>
				<tr><td>Username:</td><td><input type="text" name="username" required></td></tr>
				<tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
				<tr><td colspan="2" align="center"><input type="submit"></td></tr>
			</table>
		</form>
	</body>
</html>