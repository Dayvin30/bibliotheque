<!DOCTYPE html>
<html lang="fr">
 <head>
 <meta name="description" content="Connectez-vous à votre bibilitohèque !">
   <meta charset="UTF-8" />
   <meta name="viewport" >
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <link rel="stylesheet" href="css/connexion.css" />
   
   
   <title>Document</title>
 </head>
 <body>
 <% session.invalidate(); %>>
<c:if test="${ !empty error }"><p><c:out value="${ error }" /></p></c:if>
<div class="grid">
 <section class="forms-section">
  <h1 class="section-title">Bibliothèque</h1>
  <div class="forms">
    <div class="form-wrapper is-active">
      <button type="button" class="switcher switcher-login">
        Connexion
        <span class="underline"></span>
      </button>


      <form method = "post" action = "Connexion" class="form form-login">
        <fieldset>
          <legend>Veuillez entrer une adresse email et un mot de passe</legend>
          
          <div class="input-block">
            
            <label for="login-email">E-mail</label>
            <input name = "email" id="email" type="Email" required>
          </div>
          <div class="input-block">
            <label for="login-password">Mot de passe</label>
            <input name = "password" id="password" type="password" required>
          </div>
        </fieldset>
        <button style=" background-color: #3b4465;" type="submit" class="btn-login">Connexion</button>
      </form>
    </div>




    <div class="form-wrapper">
      <button type="button" class="switcher switcher-signup">
        Inscription
        <span class="underline"></span>
      </button>




      <form method = post action = "" class="form form-signup">
        <fieldset>
          <legend>Veuillez entrer une adresse email et un mot de passe</legend>
          <div class="input-block">
            <label for="signup-email">Identifiant</label>
            <input name ="signup-identifiant" id="signup-email" type="text" required>
          </div>

          <div class="input-block">
            <label for="signup-password">Mot de passe</label>
            <input name="signup-password" id="signup-password" type="password" required>
          </div>
          <div class="input-block">
            <label for="signup-password">Mot de passe</label>
            <input name="signup-password" id="signup-password" type="password" required>
          </div>
          <div class="input-block">
            <label for="signup-password-confirm">Confirmer le mot de passe</label>
            <input name ="signup-password-confirm" id="signup-password-confirm" type="password" required>
          </div>
        </fieldset>
        <button type="submit" class="btn-signup">Continuer</button>
      </form>
    </div>
  </div>
</section>
</div>
</body>
</html>

















<script>

const switchers = [...document.querySelectorAll('.switcher')]

switchers.forEach(item => {
	item.addEventListener('click', function() {
		switchers.forEach(item => item.parentElement.classList.remove('is-active'))
		this.parentElement.classList.add('is-active')
	})
})

 </script>
