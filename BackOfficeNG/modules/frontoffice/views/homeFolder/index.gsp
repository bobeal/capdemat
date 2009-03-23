<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  
  <body>
    <g:if test="${flash.successMessage}"><div class="success-box"><p>${flash.successMessage}</p></div></g:if>
    <div class="main-box">
      <h2><g:message code="homeFolder.header.generalInformations"/></h2>
      <p style="float:right;">
        <span style="display:block;text-align:right;"><a href="#">Modifier mon compte</a></span>
        <span style="display:block;text-align:right;"><a href="${createLink(action:'editPassword')}">Modifier mon mot de passe</a></span>
        <a href="${createLink(action:'editQuestion')}">Modifier ma question/réponse</a>
      </p>
      <p>
        <g:message code="property.active"/> :
        <g:if test="${homeFolder.isActive}">
          <span class="tag-valid"><g:message code="message.yes" /></span>
        </g:if>
        <g:else>
          <span class="tag-invalid"><g:message code="message.no" /></span>
        </g:else>
      </p>
      <p>
        <g:message code="property.state"/> : 
        <g:capdematEnumToFlag var="${homeFolder.state}" i18nKeyPrefix="actor.state" />
      </p>
      <p>
        <g:message code="request.requester.property.adress"/> : <strong>${homeFolder.addressDetails}</strong>
      </p>
    </div>
    
    <div class="yui-g individual">
      <div class="yui-u first">
        <g:render template="adults" />
      </div>
      <div class="yui-u">
        <g:render template="children" />
      </div>
    </div>
  </body>
</html>

