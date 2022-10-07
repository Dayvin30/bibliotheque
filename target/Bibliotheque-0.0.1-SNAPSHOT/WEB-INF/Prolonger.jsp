<%@page import="com.octest.bdd.functionsBDD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="Prolongez votre emprunt ici !">
<%@include file="Navbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Prolonger</title>
</head>
<meta name="description" content="Bienvenu sur l'accueil de votre bibliothèque !">
<body style="overflow: hidden;">
<div class="bg-image"
 
     style="background-image: url('https://www.en-vols.com/wp-content/uploads/afmm/2022/02/livres-ouverts_shutterstock_1840804387.jpg');
            height: 110vh; ">
<form id="contactForm" action="" method="post" >
<div class="container"> <div class=" text-center">
        <h1 style="color: white;">Prolonger un livre</h1>
    </div>
    <div class="row ">
        <div class="col-lg-7 mx-auto">
            <div class="card mt-2 mx-auto p-4 bg-light">
                <div class="card-body bg-light">
                    <div class="container">
                        <form id="contactForm"  role="form" >
                            <div class="controls">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group"> <label for="form_name">Titre</label> <input  id="form_name" type="text" name="titre" class="form-control" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println((String) request.getAttribute("titre")); %>" readonly="readonly" required="required" data-error="Firstname is required."> </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <div class="form-group"> <label for="form_lastname">Auteur</label> <input  id="form_lastname" type="text" name="auteur" class="form-control"  readonly="readonly" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println((String) request.getAttribute("prenom") + " " + request.getAttribute("nom")); %>" required="required" data-error="Lastname is required."> </div>
                                    </div>
                                <div class="col-md-6">
                                        <div class="form-group"> <label for="form_lastname">Date de début</label> <input id="form_lastname" type="text" name="date_debut" readonly="readonly" class="form-control" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println((String) request.getAttribute("date_debut")); %>" required="required" data-error="Lastname is required."> </div>
                                    </div>                               
                                     <div class="col-md-6">
                                        <div class="form-group"> <label for="form_lastname">Date de fin</label> <input id="form_lastname" type="date" name="dateFin"  class="form-control" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println((String) request.getAttribute("date_fin")); %>" required="required" data-error="Lastname is required."> </div>
                                    </div>

                                    
                                    
                                </div>
                                
                                
                                
     
                                    
                                   
                                <div class="row">
                                    <div class="col-md-12">
                                        <br>
                                    </div>
                                    <div class="col-md-12"><input type="submit" href="deletelink" onclick="return confirm('Êtes vous sûr de prolonger ce livre ?')" class="btn btn-warning" value="Enregistrer les modifications"></div>
                                    
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div> <!-- /.8 -->
        </div> <!-- /.row-->
    </div>
</div>
</form>






<c:if test="${!empty titre}"> 

<% 

out.println("coucou");
String titre = (String) request.getParameter("titre");
// && !empty nom && !empty prenom && !empty date_debut && !empty date_fin && !empty id 

String nom = (String) request.getParameter("nom");

String prenom = (String) request.getParameter("prenom");

String date_debut = (String) request.getParameter("date_debut");

String dateFin = (String) request.getParameter("dateFin");

String id = (String) request.getParameter("id");

functionsBDD bdd = new functionsBDD();

bdd.prolongerLivreByID(dateFin, Integer.parseInt(id));

out.println(dateFin);
out.println(Integer.parseInt(id));



//int id = bdd.getIdExemplaireByISBN_bibliotheque(Integer.parseInt(isbn), bibli);
//bdd.emprunterLivre(String.valueOf(java.time.LocalDate.now()), dateFin ,"non", 1, id);



%>

</c:if>

 </div>

 




 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</body>
</html>