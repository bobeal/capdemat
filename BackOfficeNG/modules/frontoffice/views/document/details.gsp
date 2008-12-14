<html>
<head>
  <meta name="layout" content="fo_main"/>
</head>

<body>
<div class="main-box">
  <h2>
    <g:message code="document.header.document"/> : ${doc.title} (<g:message code="property.id" /> : ${doc.id})
  </h2>
  <div class="individual-detail">
    <dl>
      <dt><g:message code="document.property.endValidityDate"/> :</dt>
      <dd><g:formatDate date="${doc.endValidityDate}" formatName="format.date" /></dd>
    
      <dt><g:message code="document.property.creationDate"/> :</dt>
      <dd><g:formatDate date="${doc.creationDate}" formatName="format.date" /></dd>

      <dt><g:message code="document.property.validationDate"/> :</dt>
      <dd><g:formatDate date="${doc.validationDate}" formatName="format.date" /></dd>
    
      <dt><g:message code="document.property.ecitizenNone"/> :</dt>
      <dd>${doc.validationDate}</dd>
      
      <dt><g:message code="document.property.agentNone"/> :</dt>
      <dd>${doc.agentNone}</dd>
      
      <dt><g:message code="document.property.state"/> :</dt>
      <dd><g:capdematEnumToFlag var="${doc.state}" i18nKeyPrefix="document.state" /></dd>
      
      <dt><g:message code="document.property.depositType"/> :</dt>
      <dd>
        <g:capdematEnumToFlag var="${doc.depositType}" i18nKeyPrefix="document.depositType" />
      </dd>
      
      <dt><g:message code="document.property.depositOrigin"/> :</dt>
      <dd>
        ${doc.depositor}
        <g:capdematEnumToFlag var="${doc.depositOrigin}" i18nKeyPrefix="document.depositOrigin" />
      </dd>
    </dl>
  </div>
  <g:render template="binaries"/>
  <g:render template="actions"/>
</div>
</body>
</html>