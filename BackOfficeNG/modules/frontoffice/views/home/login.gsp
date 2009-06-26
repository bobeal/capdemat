<html>
  <head>
    <meta name="layout" content="fo_main" />
    <!-- TODO : extract styles for form styles -->
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  
  <body>
    <g:if test="${flash.successMessage}">
      <div class="success-box"><p>${flash.successMessage}</p></div>
    </g:if>
      <div class="yui-g login-box">
        <div class="yui-u first">
          <h2><g:message code="account.message.connexion" /></h2>
          <form id="loginForm" method="post" action="${createLink(action:'login')}" >
            <g:if test="${error}">
              <div class="login-error">${error}</div>
            </g:if>
            <label for="login"><g:message code="account.property.login"/></label>
            <input type="text" id="login" name="login" />
            
            <label for="password"><g:message code="account.property.password"/></label>
            <input type="password" id="password" name="password" />
            <p>
              <input type="submit" value="${message(code:'action.login')}" />
              <a href="${createLink(controller : 'frontofficeHomeFolder', action:'resetPassword')}">
                <g:message code="account.message.forgottenPassword" />
              </a>
            </p>
            <g:if test="${flash.isOutOfAccountRequest}">
              <input type="hidden" name="requestLabel" class="hidden" value="${requestLabel}" />
            </g:if>
          </form>
        </div> 
        <div class="yui-u">
          <h2>Créer un compte</h2>
          
          En créant un compte, vous avez la possibilité de : 
          <ul>
            <li>gérer vos données administratives et déclarer les membres de votre foyer,</li>
            <li>accéder à des démarches en ligne pour vous ou un membre de votre foyer,</li>
            <li>suivre l'avancement de vos demandes.</li>
          </ul>
          <a href="${createLink(controller:'frontofficeRequestCreation',params:['label':'VO Card'])}"
          	 style="float:right;font-size:1.3em;margin-right:10%;">
            Je souhaite créer mon compte
          </a>
        </div>
      </div>
      <g:render template="/shared/services" />
  </body>
</html>

