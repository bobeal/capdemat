<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  
  <body>
    <div class="main-box requestExit">
      <h2>${requestTypeLabel}</h2>
      <div class="info">
        <g:if test="${isEdition}">
          <p><g:message code="request.message.successfulEdition" /></p>
        </g:if>
        <g:else>
          <p><g:message code="request.message.successfulCreation" /></p>
        </g:else>
        <g:if test="${hasHomeFolder}">
          <p><g:message code="request.message.requestIdNotice" args="${[rqt.id]}"/></p>
          <p><g:message code="account.message.tempLoginToFollowRequest" /> : <strong>${requester.login}</strong></p>
        </g:if>
      </div>
      <g:if test="${hasHomeFolder}">
        <div class="link">
          <g:message code="request.message.actionAfterCreation" /> :
          <ul>
            <li>
              <a href="${createLink(controller:'frontofficeRequest',action:'summary',id:rqt.id)}">
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
            <g:if test="${returnUrl != ''}">
              <li>
                <a href="${returnUrl}">
                  <g:message code="request.action.return.to.local.authority.site" />
                </a>
              </li>
            </g:if>
          </ul>
        </div>
      </g:if>
    </div>
  </body>
</html>

