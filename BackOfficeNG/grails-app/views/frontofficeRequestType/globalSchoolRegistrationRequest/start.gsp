<html>
  <head>
    <title>${message(code:'gsrr.description')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
  
  <div class="start-screen-details">
  
  <div class="yui-g">
    <div class="group-box">
      
    <h3><g:translateRequestTypeLabel label="${requestTypeLabel}"/></h3>
    <p>
        ${intro}
    </p>
    
    <hr />
    
    <div class="yui-g first">
        <h4><g:message code="requestType.label.newRequest" /></h4>
        <p><a href="${createLink(controller:'frontofficeRequest', action:'edit',                params:['label':requestTypeLabel,'requestSeasonId':requestSeasonId])}">
                <g:message code="requestType.action.newRequest" /> <g:translateRequestTypeLabel label="${requestTypeLabel}"/>
        </a></p>
    </div>
    
    <div class="yui-g">
        <h4><g:message code="requestType.label.renewRequest" /></h4>
          <p><g:message code="requestType.message.renew.chooseRequest" /></p>
          <g:if test="${!lastRequests.isEmpty()}">
            <ul class="request-renew">
              <g:each in="${lastRequests}" var="lastRequest">
                <li>
                  <g:capdematEnumToFlag var="${lastRequest.value.state}" i18nKeyPrefix="request.state" />
                  <a href="${createLink(controller : 'frontofficeRequest', action : 'renew',                    params : ['id' : lastRequest.value.id, 'requestSeasonId' : requestSeasonId])}">
                   <g:message code="requestType.property.renew.requestFor" /> ${lastRequest.key.lastName} ${lastRequest.key.firstName} 
                   <g:message code="requestType.property.renew.dateTo" /> <g:formatDate formatName="format.date" date="${lastRequest.value.creationDate}"/></a>
                  - <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:lastRequest.value.id)}">
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