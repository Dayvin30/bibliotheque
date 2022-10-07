<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="Quelques informations sur nos livres et nos auteurs">
<%@include file="Navbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Statistiques</title>
</head>
<body style="overflow: hidden;">
<div class="bg-image"
 
     style="background-image: url('https://www.en-vols.com/wp-content/uploads/afmm/2022/02/livres-ouverts_shutterstock_1840804387.jpg');
            height: 100vh "> 
<c:if test="${ !empty statistiquesLivres }">

<h2 style="margin-left: 23px; color: white;"><strong> Statistiques sur nos livres </strong></h2>
<h4 style="margin-left: 23px; color: white;"><c:out value="${ statistiquesLivres }"></c:out></h4>



</c:if>
<h2 style="margin-left: 23px; color: white;"><strong> Statistiques sur nos auteurs </strong></h2>
<c:if test="${ !empty statistiquesAuteurs }">


<h4 style="margin-left: 23px; color: white;"><c:out value="${ statistiquesAuteurs }"></c:out></h4>



</c:if>
</div>
</body>
</html> 	