<html>
  <head>
    <title><g:message code="payment.header.paymentConfiguration" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/yui/editor',file:'simpleeditor.css')}" />
		<link rel="stylesheet" href="${createLinkTo(dir:'css',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'defaultToolbar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'templateManager.js')}"></script>
    <script type="text/javascript">
      zenexity.capdemat.bong.request.templates.manager.name = "${name}";
    </script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>Mail templates</h1>
        </div>
        <!--
        <div id="workArea" class="yellow-yui-tabview">
        </div>
        -->
        <div id="workArea" class="yui-navset yellow-yui-tabview" style="display:none">
          <ul class="yui-nav">
            <li class="selected" title="active">
              <a href="#workArea_Tab1"><em>Work area</em></a>
            </li>
          </ul>            
          <div class="yui-content">
              <div id="workArea_Tab1" class="editable-work-area">
              </div>
          </div>
        </div>
        
        <form method="post" id="form1" action="mailTemplate" class="editorForm">
          <div id="editPanel">
            <div class="hd">Change state</div>
            <div class="bd" >
              <div id="bd-editor" style="display:none">
                  <textarea id="editor" rows="15" name="editor"></textarea>
                  <input type="hidden" id="element" name="element" value="" />
                  <input type="button" id="submit" name="submit" value="Save" />
              </div>
            </div>
          </div>
        </form>
        
        <div id="trash" style="display:none">
          <div id="wrapper"></div>
        </div>
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