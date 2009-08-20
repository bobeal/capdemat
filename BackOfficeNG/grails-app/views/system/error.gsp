<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'error.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="error-box">
        <p>
          <g:message code="${i18nKey}" args="${i18nArgs}" />
        </p>
        <div class="links">
          <g:message code="request.message.actionWhenLocked" /> :
          <ul>
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
          </ul>
        </div>
      </div>
    </div>
  </body>
</html>
