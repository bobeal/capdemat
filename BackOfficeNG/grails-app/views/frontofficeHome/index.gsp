<html>
  <head>
    <title>${message(code:'home.title')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'dashboard.css')}" />
  </head>

  <body>
    <div class="box">
      <g:if test="${commonInfo != null}">
        <div class="information-box">${commonInfo}</div>
      </g:if>
      <g:render template="homeFolderDocumentList" />
      <g:render template="draftList" />
      <g:render template="requestList" />
      <g:render template="paymentList" />
    </div>
  </body>
</html>
