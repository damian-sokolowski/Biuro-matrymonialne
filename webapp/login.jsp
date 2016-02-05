<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

<c:if test="${requestScope.error != null}">
	<c:set var="error_message" value="${requestScope.error}"/>
</c:if>


<div class="container">

	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<form action="LoginServlet" method="post" class="form-signin">
				<h2 class="form-signin-heading">Login</h2>
		    	<c:if test="${error != null}">
					<div class="alert bs-callout bs-callout-danger alert-dismissible" role="alert">
			   			<c:out value="${error_message}" />
			 		    </div>
			 	</c:if>
				<input class="form-control" type="login" name="login" placeholder="Username" required="" autofocus="">
				<input type="password" id="inputPassword" class="form-control" name="pass" placeholder="Password" required="">
			    
			    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		 	</form>
		</c:when>
		<c:otherwise>
			<h2>Jesteś zalogowany</h2>
		</c:otherwise>
	</c:choose>
</div>

<jsp:include page="footer.jsp" />