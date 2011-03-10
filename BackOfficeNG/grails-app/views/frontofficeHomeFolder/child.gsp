<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <g:if test="${flash.addressesReferentialEnabled}">
      <link rel="stylesheet" type="text/css" href="${resource(dir:'css/common', file:'autocomplete.css')}" />
      <script type="text/javascript">
        zenexity.capdemat.contextPath = "${request.contextPath}";
      </script>
      <script type="text/javascript" src="${resource(dir:'js/common',file:'addressAutocomplete.js')}"></script>
      <script type="text/javascript" src="${resource(dir:'js/common',file:'autocomplete.js')}"></script>
    </g:if>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice', file:'homeFolder.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <div class="individual box">
      <h2>
        <g:if test="${child.id != null}">
          ${child.born ? child.fullName : message(code:'request.subject.childNoBorn', args:[child.fullName])}
        </g:if>
        <g:else>
          ${message(code:'homeFolder.header.createChild')}
        </g:else>
      </h2>
      <div class="main ${flash.invalidFields ? 'Invalid' : 'Modified'}">
        <g:if test="${child.id != null}">
          <h3 id="generalInformations">${message(code:'homeFolder.individual.header.general')}</h3>
          <g:render template="${child.fragmentMode('general')}" />
          <h3 id="identity">${message(code:'homeFolder.individual.header.identity')}</h3>
          <g:render template="${child.fragmentMode('identity')}" />
          <h3 id="responsibles">${message(code:'homeFolder.individual.header.responsibles')}</h3>
          <g:render template="${child.fragmentMode('responsibles')}" />
        </g:if>
        <g:else>
          <form action="${createLink(controller : 'frontofficeHomeFolder', action:'child')}" method="post">
            <g:render template="edit/childCommonFields" />
            <input type="submit" value="${message(code:'action.create')}" />
          </form>
        </g:else>
      </div>
      <div class="side">
        <g:if test="${child.id != null}">
          <div class="action">
            <a href="#generalInformations">${message(code:'homeFolder.individual.header.general')}</a>
            <a href="#identity">${message(code:'homeFolder.individual.header.identity')}</a>
            <a href="#responsibles">${message(code:'homeFolder.individual.header.responsibles')}</a>
          </div>
        </g:if>
        <div class="back">
          <a href="${createLink(action:'index')}">${message(code:'homeFolder.action.back')}</a>
        </div>
      </div>
    </div>
  </body>
</html>
