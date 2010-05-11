<html>
  <head>
    <title>${message(code:'document.title.details')}</title>
    <meta name="layout" content="fo_main"/>
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
  </head>

  <body>
    <div class="main-box data-detail">
      <h2><g:message code="document.header.details"
                     args="${[doc.title,doc.id.toString()]}"/></h2>
     
      <div class="yui-g">
         <h3><g:message code="document.header.generalInformations" /></h3>
        <div class="yui-u first">
          <dl>
            <dt><g:message code="document.property.endValidityDate"/> :</dt>
            <dd><g:formatDate date="${doc.endValidityDate}" formatName="format.date" /></dd>
    
            <dt><g:message code="document.property.creationDate"/> :</dt>
            <dd><g:formatDate date="${doc.creationDate}" formatName="format.date" /></dd>

            <dt><g:message code="document.property.validationDate"/> :</dt>
            <dd><g:formatDate date="${doc.validationDate}" formatName="format.date" /></dd>
    
            <dt><g:message code="document.property.state"/> :</dt>
            <dd>
              <g:if test="${doc.state}">
                <g:capdematEnumToFlag var="${doc.state}" i18nKeyPrefix="document.state" />
              </g:if>
            </dd>
            
             <dt><g:message code="document.property.contentType"/> :</dt>
             <dd>.${doc.contentType}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="document.property.ecitizenNote"/> :</dt>
            <dd>${doc.ecitizenNote}</dd>

            <dt><g:message code="document.property.agentNote"/> :</dt>
            <dd>${doc.agentNote}</dd>

            <dt><g:message code="document.property.depositType"/> :</dt>
            <dd>
              <g:if test="${doc.depositType}">
                <g:capdematEnumToFlag var="${doc.depositType}" i18nKeyPrefix="document.depositType" />
			  </g:if>
			</dd>
			
            <dt><g:message code="document.property.depositOrigin"/> :</dt>
            <dd>
              ${doc.depositor}
              <g:if test="${doc.depositType}">
                <g:capdematEnumToFlag var="${doc.depositOrigin}" i18nKeyPrefix="document.depositOrigin" />
              </g:if>
            </dd>
          </dl>
        </div>
      </div>

      <g:render template="binaries"/>

      <g:render template="actions"/>

    </div>
  </body>
</html>
