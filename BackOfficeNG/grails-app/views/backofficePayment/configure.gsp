<html>
  <head>
    <title><g:message code="payment.header.configure" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/yui/editor',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/yui/editor',file:'simpleeditor-min.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/common',file:'editor.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'paymentConfiguration.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="payment.header.configure" /></h1>
        </div>
        <div id="displayConfigurationBox" class="mainbox mainbox-yellow">
        </div>
        <div id="deactivationBox" class="mainbox mainbox-yellow">
        </div>
        <div id="displayedMessageBox" class="mainbox mainbox-yellow">
        </div>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
    </div>

  </body>
</html>
