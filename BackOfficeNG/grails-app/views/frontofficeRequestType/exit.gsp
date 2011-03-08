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
        <p><g:message code="request.message.requestIdNotice" args="${[requestId]}"/></p>
        <g:if test="${!temporary}">
          <p><g:message code="account.message.loginReminder" /> : <strong>${requesterLogin}</strong></p>
        </g:if>
      </div>
      <g:if test="${!temporary || returnUrl != ''}">
        <div class="link">
          <g:message code="request.message.actionAfterCreation" /> :
          <ul>
            <g:if test="${!temporary}">
              <li>
                <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:requestId)}">
                  <g:message code="request.action.seeSummary" />
                </a>
              </li>
              <li>
                <a href="${createLink(controller:'frontofficeRequestType')}">
                  <g:message code="request.action.issueNewRequest" />
                </a>
              </li>
              <li>
                <a href="${createLink(controller:'frontofficeHome')}">
                  <g:message code="action.goHome" />
                </a>
              </li>
            </g:if>
            <g:if test="${returnUrl != ''}">
              <li>
                <a href="${returnUrl}">
                  <g:message code="request.action.returnToLocalAuthoritySite" />
                </a>
              </li>
            </g:if>
            <g:if test="${session.proxyAgent}">
                <hr />
                <li>
                    <a href="${createLink(controller:'frontofficeHome', action:'logoutAgent', id:requestId)}" class="link-agent">
                        <g:message code="request.action.continueRequest" />
                    </a>
                </li>
            </g:if>
          </ul>
          <!-- Payment confirmation -->
          <g:if test="${paymentStatus}">
          <ul>
            <li>${message(code:'payment.header.statusAt')}: ${paymentStatus}</li>
            <li>${message(code:'payment.property.bankReference')}: ${bankReference}</li>
            <li>${message(code:'payment.property.cvqReference')}: ${cvqReference}</li>
          </ul>
          </g:if>
        </div>
      </g:if>
    </div>
  </body>
</html>

