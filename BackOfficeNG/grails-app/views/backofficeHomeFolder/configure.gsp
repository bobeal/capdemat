<html>
  <head>
    <title>${message(code:'homeFolder.title.configuration')}</title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice', file:'homeFolderConfiguration.js')}"></script>
    <!-- Needed for document management -->
    <script type="text/javascript" src="${resource(dir:'js/backoffice', file:'requestTypeConfigure.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice', file:'requestTypeDocuments.js')}"></script>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice', file:'configuration.css')}" />
    <!-- / -->
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin',file:'container.css')}" ></link>
  </head>
  <body>

    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>${message(code:'homeFolder.title.configuration')}</h1>
        </div>
        <div id="configuration" class="yellow-yui-tabview">
          <ul class="yui-nav">
            <li class="selected">
              <a href="#homeFolderCreation"><em>Création de compte</em></a>
            </li>
          </ul>
          <div class="yui-content">
            <div id="homeFolderCreation">

              <div id="notification"></div>

              <h2>Création de compte autonome</h2>
              <form method="post" id="independentCreationForm" action="${createLink(action:'setIndependentCreation')}">
                <div class="error" id="independentCreationErrors"></div>
                <p class="field">
                  <label>
                    Activer :
                  </label>
                  <input id="independentCreationInput" type="radio" ${independentCreationEnabled ? 'checked="checked"' : ''} value="1" name="independentCreation" class="required validate-one-required"/>
                    oui
                  <input id="independentCreationInput" type="radio" ${independentCreationEnabled ? '' : 'checked="checked"'} value="0" name="independentCreation" class="required validate-one-required"/>
                    non
                </p>
              </form>

              <h2>Pièces justificatives<span> à associer lors d'une création de compte</span></h2>
              <div id="mainPanel">
                <div id="documentTypeFilterPanel" class="editableListSwithcher">
                  <a id="showAssociatedDocuments">${message(code:'filter.viewBounded')}</a>/
                  <a id="showUnassociatedDocuments" class="current">${message(code:'filter.viewUnbounded')}</a>/
                  <a id="showAllDocuments">${message(code:'filter.viewAll')}</a>
                </div>
                <div id="documentList"></div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />
    </div>
  </body>
</html>
