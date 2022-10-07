<%@page import="com.octest.bdd.functionsBDD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="description" content="Renseignez quelques informations pour emprunter votre livre !">
<%@include file="Navbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="overflow: hidden;">
<div class="bg-image"
 
     style="background-image: url('https://www.en-vols.com/wp-content/uploads/afmm/2022/02/livres-ouverts_shutterstock_1840804387.jpg');
            height: 110vh; ">
<form id="contactForm" action="" method="post" >
<div class="container"> <div class=" text-center">
        <h1 style="color: white;">Emprunter un livre</h1>
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
                                        <div class="form-group"> <label for="form_name">ISBN</label> <input  id="form_name" type="text" name="PrenomIntervention" class="form-control" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println((String) request.getAttribute("isbn")); %>" readonly="readonly" required="required" data-error="Firstname is required."> </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <div class="form-group"> <label for="form_lastname">Titre</label> <input  id="form_lastname" type="text" name="NomIntervention" class="form-control"  readonly="readonly" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println((String) request.getAttribute("titre")); %>" required="required" data-error="Lastname is required."> </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group"> <label for="form_email">Auteur</label> <input id="form_email" type="email" name="EmailIntervention" class="form-control"  readonly="readonly" onClick="this.select();" value="<% out.println((String) request.getAttribute("auteur")); %>" required="required" data-error="Valid email is required."> </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group"> <label for="form_name">Edition</label> <input id="form_name" type="tel" name="NumeroTelephoneIntervention" readonly="readonly" onClick="this.setSelectionRange(0, this.value.length)" class="form-control" value="<% out.println((String) request.getAttribute("edition")); %>" required="required" data-error="Firstname is required."> </div>
                                    </div>

                                    
                                    
                                </div>
                                
                                
                                
                                <div class="row">
                                <div class="col-md-6">
                                        <div class="form-group"> <label for="form_lastname">Date de réservation</label> <input id="form_lastname" type="text" name="LieuIntervention" readonly="readonly" class="form-control" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println(java.time.LocalDate.now()); %>" required="required" data-error="Lastname is required."> </div>
                                    </div>
                                    <div class="col-md-6">
                                     <div class="form-group"> <label for="form_lastname">Date fin</label> <input id="form_lastname" type="date" name="dateFin"  class="form-control" onClick="this.setSelectionRange(0, this.value.length)" value="<% out.println(java.time.LocalDate.now()); %>" required="required" data-error="Lastname is required."> </div>
                                    </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group"> <label for="form_need">Bibliothèque</label> <select id="form_need" name="bibliotheque" class="form-select" required="required" data-error="Please specify your need.">
                                                <option>Bibliothèque municipale de Paris</option>
                                                <option>Bibliothèque municipale de Marseille</option>
                                                <option>Bibliothèque municipale de Bordeaux</option>
                                                <option>Bibliothèque municipale de Nice</option>
                                                <option>Bibliothèque municipale de Strasbourg</option>
                                            </select> </div>
                                    
                                   
                                <div class="row">
                                    <div class="col-md-12">
                                        <br>
                                    </div>
                                    <div class="col-md-12"><input type="submit" href="deletelink" onclick="return confirm('Êtes vous sûr de vouloir modifier cette intervention ?')" class="btn btn-warning" value="Enregistrer les modifications"></div>
                                    
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
 </div>
 
 
<c:if test="${!empty dateFin && !empty bibliotheque  }"> 

<% 	
out.println("coucou");
String dateFin = (String) request.getParameter("dateFin");
functionsBDD bdd = new functionsBDD();

String isbn = (String) request.getParameter("isbn");
String bibli = (String) request.getParameter("bibliotheque");
out.println(isbn);
out.println(bibli);
int id = bdd.getIdExemplaireByISBN_bibliotheque(Integer.parseInt(isbn), bibli);
bdd.emprunterLivre(String.valueOf(java.time.LocalDate.now()), dateFin ,"non", 1, id);


%>

</c:if>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</body>
</html>