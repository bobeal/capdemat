
<html>
  <head>
    <title><g:message code="payment.header.paymentConfiguration" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/yui/editor',file:'simpleeditor.css')}" />
		<link rel="stylesheet" href="${createLinkTo(dir:'css',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'paymentConfiguration.js')}"></script>
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>Payment configuration</h1>
        </div>
			<form method="post" id="form1" action="configure" class="editorForm">
				<textarea id="editor" name="editor">${editorContent}</textarea>
				<input type="button" id="submit" name="submit" value="Save">
			</form>
      </div>
    </div>
    
    <!-- filters and sorters -->
    <div id="narrow" class="yui-b">
    
      <div class="nobox">
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
        </div>
      </div>
      
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
        </div>
      </div>
      
    </div>    
  </body>
</html>
