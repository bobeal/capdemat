<html>
  <head>
    <title></title>
    <meta name="layout" content="mn_main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/monitoring',file:'syntaxHighlighter.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/monitoring/sh',file:'shCore.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/monitoring/sh',file:'shBrushSql.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/monitoring',file:'database.js')}"></script>
    <script language="javascript">
      dp.SyntaxHighlighter.ClipboardSwf = '${createLinkTo(dir:'css/monitoring',file:'clipboard.swf')}';
    </script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        
        <div class="head">
          <h1><g:message code="monitoring.header.database" /></h1>
        </div>
        
        <form id="pageForm" method="post" action="${createLink(action:'index')}">
          <input name="pageState" id="pageState" type="hidden" value="${pageState}" />
          
          <div id="databaseTabView" class="yui-navset">
            <ul class="yui-nav">
              <li class="selected"><a href="#tabStats"><em>
                <g:message code="monitoring.tab.stats" />
              </em></a></li>
              <g:if test="${stats && stats?.queries}" >
                <li><a href="#tabQueries"><em>
                  <g:message code="monitoring.tab.queries" />
                </em></a></li>
              </g:if>
              <li><a href="#tabEntityNames"><em>
                <g:message code="monitoring.header.entities" />
              </em></a></li>
              <g:if test="${stats && stats?.collectionRoleNames}" >
                <li><a href="#tabRoleNames"><em>
                  <g:message code="monitoring.tab.roles" />
                </em></a></li>
              </g:if>
              <g:if test="${stats && stats?.secondLevelCacheRegionNames}" >
                <li><a href="#tabRegionNames"><em>
                  <g:message code="monitoring.tab.regions" />
                </em></a></li>
              </g:if>
            </ul>
            <div class="yui-content">
              <div id="tabStats"><g:render template="stats" /></div>
              <g:if test="${stats && stats?.queries}" >
                <div id="tabQueries"><g:render template="queries" /></div>
              </g:if>
              <div id="tabEntityNames"><g:render template="entityNames" /></div>
              <g:if test="${stats && stats?.collectionRoleNames}" >
                <div id="tabRoleNames"><g:render template="roleNames" /></div>
              </g:if>
              <g:if test="${stats && stats?.secondLevelCacheRegionNames}" >
                <div id="tabRegionNames"><g:render template="regionNames" /></div>
              </g:if>
            </div>
          </div>
          
        </form>
      </div>
    </div>
    
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="monitoring.header.authority" /></h3>
        <div class="body">
          <form action="#" id="filterForm">
            <ul>
              <li>
                <select id="authorityName" name="authorityName">
                  <g:each in="${authorities}" var="a">
                    <option value="${a}" ${authoritiy == a ? 'selected' : ''}>${a}</option>
                  </g:each>
                </select>
              </li>
              <li>
                <input type="button" id="apply" value="${message(code:'action.refresh')}" />
              </li>
            </ul>
            
          </form>
        </div>
      </div>
    </div>
    
  </body>
</html>