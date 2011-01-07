<html>
  <head>
    <title><g:message code="homeFolder.header.meansOfContact" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${resource(dir : 'js/backoffice', file : 'meansOfContact.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="homeFolder.header.meansOfContact" /></h1>
        </div>
        <div id="meansOfContactBox" class="mainbox mainbox-yellow">
          <h2><g:message code="homeFolder.header.meansOfContactConfiguration" /></h2>
          <div id="listContainer"></div>
        </div>
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />
    </div>
  </body>
</html>
