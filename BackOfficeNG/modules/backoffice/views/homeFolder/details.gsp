<html>
  <head>
    <title><g:message code="homeFolder.header.details" args="${[params.id]}"/></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'homeFolderDetails.js')}"></script>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common/yui-skin/',file:'container.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'homeFolder.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'requestInstruction.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'document.css')}" />
    <script type="text/javascript">
      zenexity.capdemat.backoffice.homeFolder.id = parseInt('${params.id}');
    </script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>
            <g:message code="homeFolder.header.details" args="${[params.id]}"/>
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
                  <g:render template="detailsChildren" />
                </div>
              </g:if>
            </div>
          </div>
        
        <div id="homeFolderInformation" ><!-- Request TabView --></div>
      </div>
    </div>
  </body>
</html>
