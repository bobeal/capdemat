<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
  
      <div class="yui-g login-box"> 
        <div class="yui-u first">
          <h2>Connexion</h2>
          <form id="loginForm" method="post" action="${createLink(action:'login')}" >
            %{--<g:if test="${error}">--}%
              %{--<span class="loginError">${error}</span>--}%
            %{--</g:if>--}%
            <label for="login">Identifiant</label>
            <input type="text" id="login" name="login" />
            
            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password" />
            <input type="submit" value="${message(code:'action.login')}" />
            <a href="">Mot de passe oublié ?</a>
          </form>
        </div> 
        <div class="yui-u">
          <h2>Créer un compte</h2>
          
          En créant un compte, vous avez accès à 
          <ul>
            <li>Un bouquet riche de téléservices</li>
            <li>Des fonctionnalités avancées de gestion de votre compte famille</li>
            <li>Du paiement sécurisé</li>
            <li>Du stockage sécurisé de vos pièces justificatives</li>
            <li>... Une nouvelle vie sans stress !</li>
          </ul>
          <a id="voCardRequestLink" href="VoCardRequestCreation">Créer un compte</a>
        </div>
      </div>
       
      <g:render template="/shared/services" />

  </body>
</html>

