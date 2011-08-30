<html>
  <head>
    <title>${message(code:'home.title')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'dashboard.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolderTracker.css')}" />
    <style>
      .box { /*overflow: auto;*/ border: 0; background: transparent; }
      .box .main { width: 56%; float: left; }
      .box .side { width: 42%; float: right; }

      .list-box h2 { border: 0; }
      .list-box { font-size: .9em; border-width: 1px; }
      .list-box ul li { padding: .4em 0; overflow: auto; }
      .list-box .tag-draft { text-decoration: none; }
      .list-box .tag-state { font-size: .95em; text-align: right; }

      .group-box { margin: 1em .2em; }
      .group-box ul { margin: 0 1em 0 7em; }
      .group-box h3 { border: 0; }
    </style>
  </head>

  <body>
    <div class="box">
      <div class="main">
        <g:if test="${commonInfo != null}">
          <div class="information-box">${commonInfo}</div>
        </g:if>
        <div class="list-box">
          <h2>${message(code:'homeFolder.header')}</h2>
          <br/>
          <g:render template="/frontofficeHomeFolder/tracker" model="['clickable' : true, 'flat' : true]" />
        </div>
        <g:render template="/shared/services" model="['groups':requestTypes]" />
      </div>
      <div class="side">
        <g:render template="requestList" />
        <g:render template="paymentList" />
      </div>
    </div>
  </body>
</html>
