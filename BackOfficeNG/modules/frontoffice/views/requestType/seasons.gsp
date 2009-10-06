<html>
  <head>
    <title>${message(code:'request.title.services')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice/common', file:'data-detail.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'requestSeasons.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div id="main" class="yui-b">
        <div class="main-box data-detail">
          <h2><g:translateRequestTypeLabel label='${label}'/></h2>
          <span id="notice">
            <g:message code="request.action.choose.requestSeason" />&nbsp;:
          </span>
          <g:each var="season" in="${seasons}">
            <div class="yui-g">
              <h3>
                <a href="${createLink(controller:'frontofficeRequestCreation',
                  params:['label':request.label, 'requestSeasonId' : season.id])}">
                  ${season.label}
                </a>
              </h3>
              <div class="yui-u first">
                <dl>
                  <dt><g:message code="requestSeason.property.registrationStart"/>&nbsp;:</dt>
                  <dd><g:formatDate formatName='format.date' date='${season?.registrationStart.toDate()}'/></dd>
                  <dt><g:message code="requestSeason.property.registrationEnd"/>&nbsp;:</dt>
                  <dd><g:formatDate formatName='format.date' date='${season?.registrationEnd.toDate()}'/></dd>
                </dl>
              </div>
              <div class="yui-u">
                <dl>
                  <dt><g:message code="requestSeason.property.effectStart"/>&nbsp;:</dt>
                  <dd><g:formatDate formatName='format.date' date='${season?.effectStart.toDate()}'/></dd>
                  <dt><g:message code="requestSeason.property.effectEnd"/>&nbsp;:</dt>
                  <dd><g:formatDate formatName='format.date' date='${season?.effectEnd.toDate()}'/></dd>
                </dl>
              </div>
            </div>
          </g:each>
        </div>
      </div>
    </div>
    <div class="yui-b">
      <div class="narrow-box">
        <h3>
          <g:message code="header.display"/>
        </h3>
        <div class="body">
          <a class="top-link" href="${createLink(action: 'index')}">
            <g:message code="requestType.header.requestList"/>
          </a>
        </div>
      </div>
    </div>
  </body>
</html>
