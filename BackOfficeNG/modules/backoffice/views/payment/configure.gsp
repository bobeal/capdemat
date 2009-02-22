
<html>
  <head>
    <title><g:message code="payment.header.configure" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/yui/editor',file:'simpleeditor.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'defaultToolbar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'paymentConfiguration.js')}"></script>
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="payment.header.configure" /></h1>
        </div>
        <form method="post" id="form1" action="configure" class="editor-form">
          <textarea id="editor" name="editor">${editorContent}</textarea>
          <input type="button" id="submit" name="submit" value="Save" />
        </form>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3>Explications et aide ...</h3>
        <div class="body"></div>
      </div>
    </div>    

  </body>
</html>
