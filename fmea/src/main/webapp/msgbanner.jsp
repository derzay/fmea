		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:if test="${!empty sessionScope.msg}">
			<c:choose>
				<c:when test="${sessionScope.status == 1}">
					<c:set var="responseType" value="success" />
				</c:when>
				<c:when test="${sessionScope.status == 0}">
					<c:set var="responseType" value="error" />
				</c:when>
			</c:choose>
			
			<div class="${responseType}">
  				<p>${sessionScope.msg}</p>
			</div>
			
			<c:remove var="msg" scope="session" />
			<c:remove var="status" scope="session" />
		</c:if>