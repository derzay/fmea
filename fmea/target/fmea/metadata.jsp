		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ page import = "java.io.*,java.util.*" %>
		<p>
		${pageContext.request.remoteHost}, ${pageContext.request.protocol}
		<p>Header Info:
		<ul>
			<c:forEach var="req" items="${header}">
				<li><b>${req.key}</b>: ${req.value}
			</c:forEach>
		</ul>
		<p>Param Info:
		<ul>
			<c:forEach var="req" items="${initParam}">
				<li><b>${req.key}</b>: ${req.value}
			</c:forEach>
		</ul>
		<p>Session Info:
		<ul>
		<%
			out.print("<li>Session ID: " + session.getId());
			out.print("<li>Create Time: " + (new Date(session.getCreationTime())));
			out.print("<li>Last Access Time: " + (new Date(session.getLastAccessedTime())));
			out.print("<li>Max Inactive Interval: " + (session.getMaxInactiveInterval()) + " sec");
		%>
		</ul>