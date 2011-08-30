<html>
  <head>
    <title>${message(code:'home.portal.title',args:[session.currentSiteDisplayTitle])}</title>
    <meta name="layout" content="fo_main" />
    <!-- TODO : extract styles for form styles -->
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolderTracker.css')}" />
    <style>
      .box { /*overflow: auto;*/ border: 0; background: transparent; }
      .box .main { width: 56%; float: left; }
      .box .side { width: 42%; float: right; }

      .group-box h3 { border: 0; }

      .information-box { margin-top: 1em; }

      .group-box.homefolder img { padding: 0; margin: 1em; background: #E6648D; }
    </style>
  </head>
  <body>
    <div class="box">
      <div class="main">
        <g:if test="${commonInfo != null}">
          <div class="information-box">${commonInfo}</div>
        </g:if>
        <g:render template="/shared/services" model="['groups':groups]" />
      </div>
      <div class="side">
        <g:if test="${homeFolderIndependentCreationEnabled}">
          <div class="group-box homefolder">
            <h3>${message(code:'homeFolder.action.createAccount')}</h3>
            <img src="${resource(dir:'images/icons',file:'account-tracker-family-100.png')}" />
            <ul>
              <li>${message(code:'homeFolder.message.accountAdvantage0')}:</li>
              <li><span class="notice">${message(code:'homeFolder.message.accountAdvantage1')}</span></li>
              <li><span class="notice">${message(code:'homeFolder.message.accountAdvantage2')}</span></li>
              <li><span class="notice">${message(code:'homeFolder.message.accountAdvantage3')}</span></li>
              <li>
                <a style="font-size: 1.3em;" href="${createLink(controller : 'frontofficeHomeFolder', action : 'create')}">
                ${message(code:'homeFolder.action.wishCreateAccount')}
              </a>
              </li>
            </ul>
          </div>
        </g:if>
      </div>
    </div>
  </body>
</html>


