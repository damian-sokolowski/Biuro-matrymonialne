<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="user" value="${sessionScope.user}" />

<jsp:include page="head.jsp" />

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="/BiuroMatrymonialne">Biuro matrymonialne</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/BiuroMatrymonialne/">Home</a></li>
            <li><a href="/BiuroMatrymonialne/about.jsp">About</a></li>
            <li><a href="/BiuroMatrymonialne/contact.jsp">Contact</a></li>
           </ul>
           <ul class="nav navbar-nav navbar-right">
            <li id="login">
			<c:choose>
				<c:when test="${user == null}">
					<a href="/BiuroMatrymonialne/login">Logowanie</a>
				</c:when>
				<c:otherwise>
					<p class="user">Witaj <c:out value="${user}" /></p>
					<a href="/BiuroMatrymonialne/LogoutServlet">Wylogowanie</a>
				</c:otherwise>
			</c:choose>
			</li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>



