<html>
  <head>
    <title><g:message code="payment.header.configure" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/yui/editor',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'defaultToolbar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'paymentConfiguration.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="payment.header.configure" /></h1>
        </div>
        <div id="deactivationBox" class="mainbox mainbox-yellow">
        </div>
        <div id="displayedMessageBox" class="mainbox mainbox-yellow">
        </div>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="payment.header" 
        data="${subMenuEntries}" />
    </div>

  </body>
</html>
