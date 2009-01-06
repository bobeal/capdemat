<html>
  <head>
    <meta name="layout" content="fo_main"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice/common', file:'data-detail.css')}" />
  </head>

  <body>
    <div class="main-box data-detail">
      <h2>${doc.title} (<g:message code="property.id" /> : ${doc.id})</h2>
     
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
            <dd><g:capdematEnumToFlag var="${doc.state}" i18nKeyPrefix="document.state" /></dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="document.property.ecitizenNote"/> :</dt>
            <dd>${doc.ecitizenNote}</dd>

            <dt><g:message code="document.property.agentNote"/> :</dt>
            <dd>${doc.agentNone}</dd>

            <dt><g:message code="document.property.depositType"/> :</dt>
            <dd><g:capdematEnumToFlag var="${doc.depositType}" i18nKeyPrefix="document.depositType" /></dd>

            <dt><g:message code="document.property.depositOrigin"/> :</dt>
            <dd>
              ${doc.depositor}
              <g:capdematEnumToFlag var="${doc.depositOrigin}" i18nKeyPrefix="document.depositOrigin" />
            </dd>
          </dl>
        </div>
      </div>

      <g:render template="binaries"/>

      <g:render template="actions"/>

    </div>
  </body>
</html>
