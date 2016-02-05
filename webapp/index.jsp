<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />
	
<c:set var="person" value="${requestScope.persons}"/>

<div class="container">
	
	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<h2 class="info"> Aby zobaczyć szczegółowy opis zaloguj się</h2>
		</c:when>
		<c:otherwise>
		    <c:if test="${person != null}">
				<table class="table table-hover">
			        <thead>
			            <tr>
			                <th>#</th>
			                <th>Imie</th>
			                <th>Wiek</th>
			                <th>Wzrost</th>
			                <th>Waga</th>
			                <th>Krótki opis</th>
	                		<th>Szczegóły</th>
			            </tr>
			        </thead>
			        <tbody>        
				        <c:forEach begin="0" end="${fn:length(person)-1}" var="index">
						   <tr>
						      <td><c:out value="${index + 1}"/></td>
						      <td><c:out value="${person[index].get('name'.concat(index))}"/></td>
						      <td><c:out value="${person[index].get('age'.concat(index))}"/></td>
						      <td><c:out value="${person[index].get('weight'.concat(index))}"/></td>
						      <td><c:out value="${person[index].get('hight'.concat(index))}"/></td>
						      <td><c:out value="${person[index].get('short_description'.concat(index))}"/></td>
						      <td><a href='DetailsServlet?id=<c:out value="${person[index].get('person_id'.concat(index))}"/>'>Więcej</a></td>
						   </tr>
						</c:forEach>
			        </tbody>
			    </table>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>

<jsp:include page="footer.jsp" />
