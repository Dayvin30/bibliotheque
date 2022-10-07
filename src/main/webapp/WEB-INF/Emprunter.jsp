<%@page import="com.octest.bdd.functionsBDD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="Empruntez un livre à la bibliothèque !">
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
      <th scope="col">Identifiant</th>
      <th scope="col">Titre</th>
      <th scope="col">Auteur</th>
      <th scope="col">Edition</th>
      <th scope="col">Date</th>
      <th scope="col">Nombre d'exemplaire</th>
      <th scope="col">Emprunter</th>
      
    </tr>
  </thead>
 
  <tbody>
    
  <c:forEach var="nbLivre" items="${ nbLivre }" >
<tr>
		
	  <td><c:out value="${ nbLivre.isbn }" /></td>
      <td><c:out value="${ nbLivre.titre }" /></td>
      <td><c:out value="${ nbLivre.auteur }" /></td>
      <td><c:out value="${ nbLivre.edition }" /></td>
      <td><c:out value="${ nbLivre.date }" /></td>
      <td><c:out value="${ nbLivre.nbexemplaire }" /></td>
        
        <c:if test="${nbLivre.nbexemplaire >=0 }">
        <td ><a href='EmprunterForm?isbn=<c:out value="${ nbLivre.isbn }" />&titre=<c:out value="${ nbLivre.titre }"/>&auteur=<c:out value="${ nbLivre.auteur }"/>&edition=<c:out value="${ nbLivre.edition }" />&date=<c:out value="${ nbLivre.date }" />&nbexemplaire=<c:out value="${ nbLivre.nbexemplaire }" />' ><button class ="btn btn-outline-info">Emprunter</button></a></td>
        </c:if>
    
    	  

      
     
      
      
	

 </c:forEach>
   <c:if test="${ !empty isbn && !empty titre && !empty auteur && !empty edition && !empty nbexemplaire }">
        

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
    td = tr[i].getElementsByTagName("td")[1];
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