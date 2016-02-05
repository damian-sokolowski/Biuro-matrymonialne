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
		<table class="table table-hover table-bordered">
	        <thead>
            	<tr>
	                <th>#</th>
	                <th>Imie</th>
	                <th>Wiek</th>
	                <th>Wzrost</th>
	                <th>Waga</th>
	                <th>Krótki opis</th>
	                <th>Opis</th>
	            </tr>
	        </thead>
	        <tbody>
				<tr>
			      <td><c:out value="${index + 1}"/></td>
			      <td><c:out value="${person.get('name0')}"/></td>
			      <td><c:out value="${person.get('age0')}"/></td>
			      <td><c:out value="${person.get('weight0')}"/></td>
			      <td><c:out value="${person.get('hight0')}"/></td>
			      <td><c:out value="${person.get('short_description0')}"/></td>
			      <td><c:out value="${person.get('description0')}"/></td>
				</tr>		   
				<c:if test="${sessionScope.userType == 'admin'}">
				   <tr>
				      <td></td>
				      <td>
				      	 <a class="btn btn-info btn-block" href='EditServlet?id=<c:out value="${person.get('person_id0')}"/>&label=name'>
				      		Edytuj
				      	 </a>
					  </td>
				      <td>
				      	 <a class="btn btn-info btn-block" href='EditServlet?id=<c:out value="${person.get('person_id0')}"/>&label=age'>
				      		Edytuj
				      	 </a>
					  </td>
				      <td>
				      	 <a class="btn btn-info btn-block" href='EditServlet?id=<c:out value="${person.get('person_id0')}"/>&label=weight'>
				      		Edytuj
				      	 </a>
					  </td>
				      <td>
				      	 <a class="btn btn-info btn-block" href='EditServlet?id=<c:out value="${person.get('person_id0')}"/>&label=hight'>
				      		Edytuj
				      	 </a>
					  </td>
				      <td>
				      	 <a class="btn btn-info btn-block" href='EditServlet?id=<c:out value="${person.get('person_id0')}"/>&label=short_description'>
				      		Edytuj
				      	 </a>
					  </td>
				      <td>
				      	 <a class="btn btn-info btn-block" href='EditServlet?id=<c:out value="${person.get('person_id0')}"/>&label=short_description'>
				      		Edytuj
				      	 </a>
					  </td>
				   </tr>
				</c:if>
	        </tbody>
	    </table>
		<c:if test="${sessionScope.userType == 'admin'}">
	    	<a class="btn btn-danger btn-block" href='DeleteServlet?id=<c:out value="${person.get('person_id0')}"/>'>Usuń</a>
		</c:if>
</c:otherwise>
</c:choose>

</div>


<jsp:include page="footer.jsp" />
