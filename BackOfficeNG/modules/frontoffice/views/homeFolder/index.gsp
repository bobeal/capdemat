<html>
  <head>
    <title>${message(code:'homeFolder.title')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  
  <body>
    <g:if test="${flash.successMessage}"><div class="success-box"><p>${flash.successMessage}</p></div></g:if>
    <div class="main-box">
      <h2><g:message code="homeFolder.header.generalInformations"/></h2>
      <div class="yui-g homeFolder-action">
        <div class="yui-u first">
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
            <g:message code="property.address"/> : <strong>${homeFolder.addressDetails}</strong>
          </p>
        </div>
        <div class="yui-u">
          <p>
            <g:if test="${hfmr.enabled}">
              <a href="${createLink(controller:'frontofficeRequestCreation',params:['label':hfmr.label])}">
                <g:message code="account.action.edit"/>
              </a>
            </g:if>
            <g:else>
              <span>
                <g:message code="account.action.edit"/>
                <g:if test="${hfmr.message}">
                  <span>(<g:message code="${hfmr.message}"/>)</span>
                </g:if>
              </span>
            </g:else>
          </p>
          <p>
            <a href="${createLink(action:'editPassword')}"><g:message code="account.action.editPassword"/></a>
          </p>
          <p>
            <a href="${createLink(action:'editQuestion')}"><g:message code="account.action.editQuestion"/></a>
          </p>
        </div>
      </div>
      
    </div>
    
    <div class="yui-g individual">
      <div class="yui-u first">
        <g:render template="adults" />
      </div>
      <g:if test="${children?.size() > 0}">
        <div class="yui-u">
          <g:render template="children" />
        </div>
      </g:if>
    </div>
  </body>
</html>

