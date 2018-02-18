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
	Features and Enhancements
	<%@ include file="msgbanner.jsp" %>
	<%@ include file="navbar.html" %>
	<p>
	<table id="compacttbl">
		<tr><th>Category</th><th>Requirement</th><th>Status</th></tr>
		<tr><td>Approval Process<td>Provide a mechanism to export a set/sub-set of FMEA risk items to PDF.</td><td>Not Yet Started</td></tr>
	</table>
</body>
</html>