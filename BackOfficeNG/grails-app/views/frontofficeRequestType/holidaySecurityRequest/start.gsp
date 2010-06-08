<html>
  <head>
    <title>${message(code:'hsr.description')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
  
  <div class="start-screen-details">
  
  <div class="yui-g">
    <div class="group-box">
      
    <h3><g:translateRequestTypeLabel label="${requestLabel}"/></h3>
    <p>
        ${intro}
    </p>
    
    <hr />
    
    <div class="yui-g first">
        <h4><g:message code="requestType.label.newRequest" /></h4>
        <p><a href="${createLink(controller:'frontofficeRequest', action:'edit',                params:['label':requestLabel,'requestSeasonId':requestSeasonId])}">
                <g:message code="requestType.action.newRequest" /> <g:translateRequestTypeLabel label="${requestLabel}"/>
        </a></p>
    </div>
    
    <div class="yui-g">
        <h4><g:message code="requestType.label.renewRequest" /></h4>
          <p><g:message code="requestType.message.renew.chooseRequest" /></p>
          <g:if test="${!lastRequests.isEmpty()}">
            <ul class="request-renew">
              <g:each in="${lastRequests}" var="lastRequest">
                <li>
                  <g:capdematEnumToFlag var="${lastRequest.state}" i18nKeyPrefix="request.state" />
                  <a href="${createLink(controller:'frontofficeRequest',action:'edit',params:['label':requestLabel, 'isRenewal':lastRequest.isRenewal,                             'requestId':lastRequest.requestId, 'subjectId':lastRequest.subjectId,'requestSeasonId':requestSeasonId])}">
                   <g:message code="requestType.property.renew.requestFor" /> ${lastRequest.subjectLastName} ${lastRequest.subjectFirstName} 
                   <g:message code="requestType.property.renew.dateTo" /> <g:formatDate formatName="format.date" date="${lastRequest.creationDate}"/></a>
                  - <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:lastRequest.requestId)}">
                  <g:message code="requestType.action.display" /></a>
                </li>
              </g:each>
            </ul>
          </g:if>
          <g:else>
            <g:if test="${isOutOfAccountRequest}">
              <p><g:message code="requestType.message.renew.noConnected" /></p>
            </g:if>
            <g:else>
              <p><g:message code="requestType.message.renew.noRequest" /></p>
            </g:else>
          </g:else>
    </div>
    <hr />
    
    </div>
  </div>
  
  </div>
  
  </body>
</html>