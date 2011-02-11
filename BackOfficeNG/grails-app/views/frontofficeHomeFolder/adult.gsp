<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'form.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <div class="box individual">
      <h2>
        <g:if test="${adult.id != null}">
          ${adult.firstName} ${adult.lastName}
        </g:if>
        <g:else>
          ${message(code:'homeFolder.header.createAdult')}
        </g:else>
      </h2>
      <div class="main ${invalidFields && !invalidFields.isEmpty() ? 'Invalid' : 'Modified'}">
        <g:if test="${adult.id != null}">
          <h3 id="general">${message(code:'homeFolder.individual.header.general')}</h3>
          <g:render template="${adult.fragmentMode('general')}" />
          <h3 id="identity">${message(code:'homeFolder.individual.header.identity')}</h3>
          <g:render template="${adult.fragmentMode('identity')}" />
          <h3 id="address">${message(code:'homeFolder.individual.header.address')}</h3>
          <g:render template="${adult.fragmentMode('address')}" />
          <h3 id="contact">${message(code:'homeFolder.individual.header.contact')}</h3>
          <g:render template="${adult.fragmentMode('contact')}" />
        </g:if>
        <g:else>
          <form action="${createLink(controller : 'frontofficeHomeFolder', action:'adult')}" method="post">
            <g:render template="edit/adultCommonFields" />
            <input type="submit" value="${message(code:'action.create')}" />
          </form>
        </g:else>
      </div>
      <div class="side">
        <g:if test="${adult.id != null}">
          <div class="action">
            <a href="#general">${message(code:'homeFolder.individual.header.general')}</a>
            <a href="#identity">${message(code:'homeFolder.individual.header.identity')}</a>
            <a href="#address">${message(code:'homeFolder.individual.header.address')}</a>
            <a href="#contact">${message(code:'homeFolder.individual.header.contact')}</a>
%{--            <a href="#connexion">${message(code:'homeFolder.individual.header.connexion')}</a>--}%
          </div>
        </g:if>
        <div class="back">
          <a href="${createLink(action:'index')}">${message(code:'homeFolder.action.back')}</a>
        </div>
      </div>
    </div>
  </body>
</html>
