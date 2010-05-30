<html>
  <head>
    <title><g:message code="homeFolder.header.details" args="${[params.id]}"/></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'homeFolderDetails.js')}"></script>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common/yui-skin',file:'container.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'homeFolder.css')}" />
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
                <li><a href="#page2"><em><g:message code="homeFolder.property.children" /></em></a></li>
              </g:if>
              <g:if test="${identifierMappings && identifierMappings.size() > 0}">
                <li><a href="#page3"><em><g:message code="homeFolder.property.externalServiceMappings" /></em></a></li>
              </g:if>
            </ul>
            <div class="yui-content">
              <!-- Page 1 -->
              <div id="page1">
                <h2><g:message code="property.form" /><span> - <g:message code="homeFolder.property.adults" /></span></h2>
                <g:each in="${adults}" var="adult">
                  <g:render template="adult" model="['adult':adult]" />
                </g:each>
              </div>
               <!-- Page 2 -->
              <g:if test="${children && children.size() > 0}">
                <div id="page2">
                  <h2><g:message code="property.form" /><span> - <g:message code="homeFolder.property.children" /></span></h2>
                  <g:each in="${children}" var="child">
                    <g:render template="child" model="['child':child, 'responsibles':responsibles]" />
                  </g:each>
                </div>
              </g:if>
              <g:if test="${identifierMappings && identifierMappings.size() > 0}">
                <div id="page3">
                  <h2><span><g:message code="homeFolder.property.externalServiceMappings" /></span></h2>
                  <g:render template="detailsMappings" />
                </div>
              </g:if>
            </div>
          </div>
        
        <div id="homeFolderInformation" ><!-- Request TabView --></div>
      </div>
    </div>
    <div id="narrow" class="yui-b">

      <!-- home folder state -->
      <div class="nobox taskstate">
        <h3><g:message code="property.homeFolderState" /></h3>
        <div class="body">
          <span id="homeFolderState" class="tagged tag-${homeFolderState}">
            <g:message code="actor.state.${homeFolderState}" />
          </span>
        </div>
      </div>
      <!-- home folder status -->
      <div class="nobox taskstate">
        <h3><g:message code="property.homeFolderStatus" /></h3>
        <div class="body">
          <span id="homeFolderStatus" class="tagged tag-${homeFolderStatus}">
            ${message(code:"property."+(homeFolderStatus == 'enable' ? 'active' : 'inactive')).toLowerCase()}
          </span>
        </div>
      </div>
      
      <div class="nobox taskstate">
        <h3><g:message code="header.subMenus" /></h3>
        <div class="body">
          <p>
            <a href="${createLink(controller: 'frontofficeHome',action:'loginAgent')}/?login=${responsableLogin}" target="_blank">
              <g:message code="homeFolder.header.createRequest"/>
            </a>
          </p>
          <p>
            <a href="${createLink(controller: 'frontofficeHome',action:'loginAgent')}/?login=${responsableLogin}&requestTypeLabel=Home+Folder+Modification" target="_blank">
              <g:message code="homeFolder.header.createHomeFolderModificationRequest"/>
            </a>
          </p>
        </div>
      </div>
      
    </div>
  
  </body>
</html>
