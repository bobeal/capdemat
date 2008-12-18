<html>
  <head>
    <title></title>
    <meta name="layout" content="mn_main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/monitoring',file:'index.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        
        <div class="head">
          <h1><g:message code="monitoring.header.database" /></h1>
        </div>
        
        <form id="pageForm" method="post" action="${createLink(action:'index')}">
          <input name="pageState" id="pageState" type="hidden" value="${pageState}" />
          <g:render template="stats" />
          <g:render template="queries" />
          <g:render template="entityNames" />
          <g:render template="roleNames" />
          <g:render template="regionNames" />
        </form>
        
      </div>
      
    </div>
    
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#" id="filterForm">
            
            <label for="authorityName"><g:message code="monitoring.header.authorityName" /> :</label>
            <select id="authorityName" name="authorityName">
              <g:each in="${authorities}" var="a">
                <option value="${a}" ${authoritiy == a ? 'selected' : ''}>${a}</option>
              </g:each>
            </select>
            
          </form>
        </div>
      </div>
    </div>
    
  </body>
</html>