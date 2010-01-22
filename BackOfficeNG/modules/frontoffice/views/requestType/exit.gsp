<html>
  <head>
    <title>${message(code:'request.title.services')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  
  <body>
    <div class="main-box requestExit">
      <h2>${translatedRequestTypeLabel}</h2>
      <div class="info">
        <g:if test="${isEdition}">
          <p><g:message code="request.message.successfulEdition" /></p>
        </g:if>
        <g:else>
          <p><g:message code="request.message.successfulCreation" /></p>
        </g:else>
        <g:if test="${hasHomeFolder}">
          <p><g:message code="request.message.requestIdNotice" args="${[requestId]}"/></p>
          <p><g:message code="account.message.loginReminder" /> : <strong>${requesterLogin}</strong></p>
        </g:if>
      </div>
      <g:if test="${hasHomeFolder}">
        <div class="link">
          <g:message code="request.message.actionAfterCreation" /> :
          <ul>
            <li>
              <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:requestId)}">
                <g:message code="request.action.seeSummary" />
              </a>
            </li>
            <li>
              <a href="${createLink(controller:'frontofficeRequestType')}">
              	<g:if test="${requestTypeLabel == 'VO Card'}">
                  <g:message code="request.action.issueRequest" />
                </g:if>
                <g:else>
                  <g:message code="request.action.issueNewRequest" />
                </g:else>
              </a>
            </li>
            <li>
              <a href="${createLink(controller:'frontofficeHome')}">
                <g:message code="action.goHome" />
              </a>
            </li>
            <g:if test="${returnUrl != ''}">
              <li>
                <a href="${returnUrl}">
                  <g:message code="request.action.returnToLocalAuthoritySite" />
                </a>
              </li>
            </g:if>
          </ul>
        </div>
      </g:if>
    </div>
  </body>
</html>

