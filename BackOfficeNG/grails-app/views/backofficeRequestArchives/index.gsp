<html>
  <head>
    <title><g:message code="requestArchives.header.index" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'requestArchives.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'requestArchives.js')}"></script>
    <script type="text/javascript">
      zenexity.capdemat.bong.request.Archives.content = {
        head : "<g:message code='requestArchive.message.deleteConfirmation.head' />",
        body : "<g:message code='requestArchive.message.deleteConfirmation.body' />"
      };
      zenexity.capdemat.bong.request.Archives.deleteErrorMessage =
        "<g:message code='requestArchive.error.notDeleted' />";
    </script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="requestArchives.header.index" /></h1>
        </div>
        <div id="archivesList" class="mainbox mainbox-yellow">
          <h2><g:message code="requestAdmin.header.availableArchives" /></h2>
          <g:if test="${archives.isEmpty()}">
            ${message(code : "requestArchive.message.noArchive")}
          </g:if>
          <g:else>
            <div class="editableListSwithcher">
              <a id="switchSelection"><g:message code="filter.switchSelection" /></a>
            </div>
            <form id="form" method="post" action="${createLink(action : "archive")}" target="_blank">
              <g:each var="archive" in="${archives}" status="i">
                <p id="${archive}" class="field">
                  <input type="checkbox" class="validate-one-required"
                    title="<g:message code='requestArchive.error.noSelection' />"
                    name="archiveIds" value="${archive}" />
                  <a href="${createLink(action : 'archive', params : ['archiveIds' : archive])}">
                    ${archive}
                  </a>
                </p>
              </g:each>
              <div class="form-button" id="errorsContainer"></div>
              <div class="form-button">
                <input id="download" type="button" value="${message(code:'action.download')}" />
                <input id="remove" type="button" value="${message(code:'action.delete')}" />
              </div>
            </form>
          </g:else>
        </div>
        <div id="archivesHistory"></div>
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
    </div>
  </body>
</html>
