<html>
  <head>
    <title><g:message code="request.header.requestTreatment" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'homeFolderDetails.js')}"></script>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common/yui-skin/',file:'container.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'homeFolder.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'requestInstruction.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'document.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>
            ${message(code:'property.homeFolder')} (ID : ${params.id})
          </h1>
        </div>
          <div id="homeFolderData" class="yellow-yui-tabview">
            <ul class="yui-nav">
              <li class="selected"><a href="#page1"><em><g:message code="homeFolder.property.adults" /></em></a></li>
              <g:if test="${children && children.size() > 0}">
                <li><a href="#page1"><em><g:message code="homeFolder.property.children" /></em></a></li>
              </g:if>
            </ul>
            <div class="yui-content">
              <!-- Page 1 -->
              <div id="page1">
                <h2><g:message code="property.form" /><span> - <g:message code="homeFolder.property.adults" /></span></h2>
                <g:render template="detailsAdults" />
              </div>
               <!-- Page 2 -->
              <g:if test="${children && children.size() > 0}">
                <div id="page2">
                  <h2><g:message code="property.form" /><span> - <g:message code="homeFolder.property.children" /></span></h2>
                  <g:render template="detailsAdults" />
                </div>
              </g:if>
            </div>
          </div>
        <!-- request intruction document -->
        <div id="requestDocument">
          <!-- Request attached document -->
          <h2><g:message code="requestType.configuration.documents" /></h2>
          <div class="box-raduis">
            <ul><!-- Request TabView --></ul>
          </div>
        </div>
        
        <div id="requestInformation" ><!-- Request TabView --></div>
      </div>
    </div>

  </body>
</html>
