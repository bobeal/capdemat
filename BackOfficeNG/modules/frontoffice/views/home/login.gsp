<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
  
      <div class="yui-g login-box"> 
        <div class="yui-u first">
          <h2>Connexion</h2>
          <form id="loginForm" method="post" action="${createLink(action:'login')}" >
          
            <label for="login">Identifiant</label>
            <input type="text" name="login" />
            
            <label for="password">Mot de passe</label>
            <input type="password" name="password" />
            
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
       
      <div class="yui-g">
        <div class="yui-u first">
        
        <g:each var="group" in="${groups}" status="i">
          <div class="group-box">
            <h3>${group.key}</h3>
            <img style="float:left;padding:1em;" src="<g:createLinkTo dir="images/frontoffice" file="${group.key}.gif" />" />
            <ul>
              <g:each var="rtLabel" in="${group.value}">
                <li><a href=""><g:translateRequestTypeLabel label="${rtLabel}"/></a></li>
              </g:each>
            </ul>
          </div>
          <g:if test="${(groups.size() - 2) / 2 < i }">  
            </div>
            <div class="yui-u">
          </g:if>
        </g:each>

        </div> 
        
      </div>

  </body>
</html>

