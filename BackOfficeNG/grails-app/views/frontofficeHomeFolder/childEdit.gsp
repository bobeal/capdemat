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
        <g:if test="${child.id}">
          <g:if test="${!child.isChildBorn}">
            <g:message code="request.subject.childNoBorn" args="${[child.fullName]}" />
          </g:if>
          <g:else>
            ${child.firstName} ${child.lastName}
          </g:else>
        </g:if>
        <g:else>
          <g:message code="homeFolder.header.createChild" />
        </g:else>
        <g:if test="${params.requestId}">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params : ['id' : params.requestId])}">
            <g:message code="action.cancel" />
          </a>
        </g:if>
      </h2>
      <form action="${createLink(controller : 'frontofficeHomeFolder', action:'child')}" method="post">
        <input type="hidden" name="requestId" value="${params.requestId}" />
        <g:render template="childCommonFields" />
        <g:if test="${child.id}">
          <input type="submit" value="${message(code:'action.modify')}" />
        </g:if>
        <g:else>
          <input type="submit" value="${message(code:'action.create')}" />
        </g:else>
      </form>
    </div>
  </body>
</html>
