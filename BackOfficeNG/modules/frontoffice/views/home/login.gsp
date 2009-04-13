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
            <input type="submit" value="${message(code:'action.login')}" />
            <a href="${createLink(controller : 'frontofficeHomeFolder', action:'resetPassword')}">
              <g:message code="account.message.forgottenPassword" />
            </a>
            <g:if test="${flash.isOutOfAccountRequest}">
              <input type="hidden" name="requestLabel" class="hidden" value="${requestLabel}" />
            </g:if>
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
          <a href="${createLink(controller:'frontofficeVOCardRequestCreation',params:['label':'VO Card Request'])}">
            <g:translateRequestTypeLabel label="VO Card Request"/>
          </a>
        </div>
      </div>
      <!%--
      <g:if test="${!flash.isOutOfAccountRequest}">
      --%>
        <g:render template="/shared/services" />
      <!%--
      </g:if>
      <g:else>
       
        <div class="main-box requestExit">
          <h2><g:translateRequestTypeLabel label="${requestLabel}"/></h2>
          <p>
            <a href="${createLink(controller:'frontofficeRequestCreation', 
                params:['label':requestLabel,'isOutOfAccountRequest':flash.isOutOfAccountRequest])}">
              Commencer la demande
            </a>
          </p>
        </div>
      </g:else>
      --%>
  </body>
</html>

