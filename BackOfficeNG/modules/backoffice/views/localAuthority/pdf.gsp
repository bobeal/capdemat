<html>
  <head>
    <title><g:message code="localAuthority.header.configuration" /></title>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'localAuthorityPDF.js')}"></script>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="localAuthority.header.configuration" /></h1>
        </div>
        <div id="faqFoBox" class="mainbox mainbox-yellow"></div>
        <div id="helpBoBox" class="mainbox mainbox-yellow"></div>
        <div id="helpFoBox" class="mainbox mainbox-yellow"></div>
        <div id="legalBox" class="mainbox mainbox-yellow"></div>
        <div id="useBox" class="mainbox mainbox-yellow"></div>
      </div>
    </div>
    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="localAuthority.header" 
        data="${subMenuEntries}" />
    </div>
  </body>
</html>
