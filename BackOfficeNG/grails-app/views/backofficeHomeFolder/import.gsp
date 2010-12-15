<html>
  <head>
    <title><g:message code="homeFolder.header.importHomeFolders" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir : 'js/backoffice', file : 'homeFolderImport.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="homeFolder.header.importHomeFolders" /></h1>
        </div>
        <div id="fileBox" class="mainbox mainbox-yellow">
          <h2><g:message code="homeFolder.header.importHomeFoldersFromXML" /></h2>
          <g:if test="${hasAdminEmail}">
            <form method="post" id="fileForm" action="${createLink(action : "importHomeFolders")}">
              <div class="error" id="fileFormErrors"></div>
              <p class="field">
                <label for="importDocument">
                  <g:message code="homeFolder.import.message.file" /> :
                </label>
                <input type="file" class="required" name="document" id="importDocument" />
              </p>
              <div class="form-button">
                <input id="uploadDocument" type="button" value="${message(code:'action.send')}" />
              </div>
            </form>
          </g:if>
          <g:else>
            <p class="message"><g:message code="homeFolder.import.error.noAdminEmail" /></p>
          </g:else>
        </div>
      </div>
    </div>
    <div id="narrow" class="yui-b">
%{--      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />--}%
    </div>
  </body>
</html>
