<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <div class="main-box data-detail">
      <h2>
        <g:if test="${adult.id}">
          ${adult.firstName} ${adult.lastName}
        </g:if>
        <g:else>
          <g:message code="homeFolder.header.createAdult" />
        </g:else>
        <g:if test="${params.requestId}">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params : ['id' : params.requestId])}">
            <g:message code="action.cancel" />
          </a>
        </g:if>
      </h2>
      <form action="${createLink(controller : 'frontofficeHomeFolder', action:'adult')}" method="post">
        <input type="hidden" name="requestId" value="${params.requestId}" />
        <g:render template="adultCommonFields" />
        <g:if test="${adult.id}">
          <input type="submit" value="${message(code:'action.modify')}" />
        </g:if>
        <g:else>
          <input type="submit" value="${message(code:'action.create')}" />
        </g:else>
      </form>
    </div>
  </body>
</html>
