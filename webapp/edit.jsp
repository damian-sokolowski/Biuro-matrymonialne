<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />
	
<c:set var="value" value="${requestScope.value}"/>

<div class="container">
	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<h2 class="info">Zaloguj się jako admin by móc edytować</h2>
		</c:when>
		<c:otherwise>
			<form action="EditServlet" method="post" class="form-signin">
				<h2 class="form-signin-heading">Edycja</h2>
				<textarea class="form-control" id="console" name="edited"><c:out value="${value}" /></textarea>
			    
			    <button class="btn btn-lg btn-primary btn-block" type="submit">Zapisz</button>
		 	</form>
		</c:otherwise>
	</c:choose>
</div>

<jsp:include page="footer.jsp" />