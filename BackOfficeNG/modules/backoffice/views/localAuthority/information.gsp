<html>
  <head>
    <title><g:message code="localAuthority.header.configuration" /></title>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/yui/editor',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'editor.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'localAuthorityInformation.js')}"></script>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="localAuthority.header.configuration" /></h1>
        </div>
        <g:each var="currentMessage" in="${messages}">
          <div id="${currentMessage.id}Box" class="mainbox mainbox-yellow">
            <h2><g:message code="localAuthority.header.setup.${currentMessage.id}" /></h2>
            <form method="post" id="${currentMessage.id}Form" class="editor-form"
              action="${createLink(action : 'information')}">
              <p class="field">
                <textarea id="${currentMessage.id}Editor"
                  name="editor">${currentMessage.text}</textarea>
              </p>
              <input type="hidden" name="id" value="${currentMessage.id}" />
              <div class="form-button">
                <input type="button" value="${message(code:'action.save')}" id="${currentMessage.id}Button" />
              </div>
            </form>
          </div>
        </g:each>
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
    </div>
  </body>
</html>