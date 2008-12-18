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
          <h1><g:message code="monitoring.header.system" /></h1>
        </div>
        
        <form id="pageForm" method="post" action="${createLink(action:'index')}">
          <g:render template="os" />
          <g:render template="runtime" />
          <g:render template="classLoading" />
          <g:render template="compilation" />
          <g:render template="memory" />
          <g:render template="threads" />
          <g:render template="garbageCollectors" />
          <input name="pageState" id="pageState" type="hidden" value="${pageState}" />
        </form>
        
      </div>
      
    </div>
    
    <div id="narrow" class="yui-b">
      
      <div id="displayPanel" class="nobox">
        <h3><g:message code="header.display" /></h3>
        <div class="body">
          <form action="#" id="displayForm"></form>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#" id="filterForm"></form>
        </div>
      </div>
    </div>
    
  </body>
</html>