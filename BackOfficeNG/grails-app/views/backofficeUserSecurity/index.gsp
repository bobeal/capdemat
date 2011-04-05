<html>
  <head>
    <title>${message(code:'user.header.security')}</title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'configuration.css')}" >
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'userSecurity.js')}"></script>
    <style>
      .editableList li a.configure          { background-image: url(../../images/icons/16-edit.png); }
      .editableList li a.disallow           { background-image: url(../../images/icons/16-delete.png); }
      .editableList li.notBelong a.disallow { display: none; }
      .editableList li span.active { font-weight: bold; }

      .editableList li form a,
      .editableList li form input,
      .editableList li form label,
      .editableList li form span {
        display: inline; float: none; margin: 0; font-size: 1em;
      }

      .editableList li form a:hover { background: #00F; }
      .editableList li form input[type=radio] { margin-right: 2em; }

      .tag {
        padding: 0 .2em;
        border-bottom: 1px solid; border-right: 1px solid;
        border-radius: .2em; -moz-border-radius: .2em; -webkit-border-radius: .2em;
        font-size: .9em;
        color: #fff;
      }
      .tag.Read   { background: #2020cc; border-color:#2020aa; }
      .tag.Write  { background: #ec7000; border-color:#da7000; }
      .tag.Manage { background: #aa00ff; border-color:#aa00ff; }
      .tag.null   { color: #444; border: 0; font-style: italic; }

      form .tag { font-size: .85em !important; font-weight: bold; background: transparent !important; border: 0 !important; }
      form .tag.Read   { color: #2020cc; }
      form .tag.Write  { color: #ec7000; }
      form .tag.Manage { color: #aa00ff; }
    </style>
  </head>

  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'user.header.security')}</h1>
        </div>

        <div id="agents" class="mainbox mainbox-yellow">
           <g:render template="agents" />
        </div>

      </div>
    </div>
    
    <div id="narrow" class="yui-b">
      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />
    </div>
    
  </body>
</html>


