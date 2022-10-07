<%@page import="com.octest.bdd.functionsBDD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="Ici s'afficheront tous vos emprunts !">
<%@include file="Navbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Emprunter un livre</title>

</head>
<body>
<div class="table-responsive" id="card">
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Rechercher un livre">
<table id="sortMe" class="table">
  <thead>
    <tr>
      <th scope="col">Titre</th>
      <th scope="col">Auteur</th>
      <th scope="col">Date début</th>
      <th scope="col">Date fin</th>
	  <th scope="col">Prolonger</th>
      
    </tr>
  </thead>
 
  <tbody>
    
  <c:forEach var="MesEmprunts" items="${ MesEmprunts }" >
<tr>
		
	  <td><c:out value="${ MesEmprunts.titre }" /></td>
      <td><c:out value="${ MesEmprunts.nom } " /><c:out value="${ MesEmprunts.prenom }" /></td>
      <td><c:out value="${ MesEmprunts.date_debut }" /></td>
      <td><c:out value="${ MesEmprunts.date_fin }" /></td>
      <td ><a href='Prolonger?titre=<c:out value="${ MesEmprunts.titre }" />&prenom=<c:out value="${ MesEmprunts.prenom }"/>&nom=<c:out value="${ MesEmprunts.nom }"/>&date_debut=<c:out value="${ MesEmprunts.date_debut }" />&date_fin=<c:out value="${ MesEmprunts.date_fin }" />&id=<c:out value="${ MesEmprunts.id }"/>'><button class ="btn btn-outline-info">Prolonger</button></a></td>
        
     

    	  
    
    	  

      
     
      
      
	

 </c:forEach>
   <c:if test="${ !empty email }">
        
	<c:out value=" votres adresse email : ${ email }" />
        
        </c:if>

  </tbody>
</table>
</div>
</body>
</html>

<script>

function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("sortMe");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>