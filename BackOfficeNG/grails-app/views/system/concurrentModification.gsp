<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'error.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="error-box">
        <p>
          <g:message code="${i18nKey}" args="${i18nArgs}" />
        </p>
        <div class="links">
          <a href="javascript:history.back();">
            <g:message code="action.goBack" />
          </a>
        </div>
      </div>
    </div>
  </body>
</html>
