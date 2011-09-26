<html>
  <head>
    <title>${message(code:'home.title')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'dashboard.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolderTracker.css')}" />
  </head>

  <body>
    <div class="box">
      <div class="main">
        <div class="list-box">
          <h2>${message(code:'homeFolder.header')}</h2>
          <br/>
          <g:render template="/frontofficeHomeFolder/tracker" model="['clickable' : true, 'flat' : true]" />
        </div>
        <g:render template="draftList" />
        <g:render template="requestList" />
        <g:render template="paymentList" />
      </div>
      <div class="side">
        <g:if test="${commonInfo != null}">
          <div class="information-box">${commonInfo}</div>
        </g:if>
        <g:render template="/shared/services" model="['groups':requestTypes]" />
      </div>
    </div>
  </body>
</html>
