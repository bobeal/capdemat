<html>
  <head>
    <title></title>
    <meta name="layout" content="mn_main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/monitoring',file:'system.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        
        <div class="head">
          <h1><g:message code="monitoring.header.system" /></h1>
        </div>
        
        <form id="pageForm" method="post" action="${createLink(action:'index')}">
          
          <div id="systemTabView" class="yui-navset">
            <ul class="yui-nav">
              <li class="selected">
                <a href="#tabGeneral">
                  <em><g:message code="monitoring.tab.general" /></em>
                </a>
              </li>
              <li><a href="#tabMemory"><em>
                <g:message code="monitoring.tab.memory" />
              </em></a></li>
              <li><a href="#tabThreads"><em>
                <g:message code="monitoring.header.threads" />
              </em></a></li>
              <li><a href="#tabGarbageCollectors"><em>
                <g:message code="monitoring.tab.garbage" />
              </em></a></li>
            </ul>
            <div class="yui-content">
              <div id="tabGeneral">
                <g:render template="os" />
                <g:render template="runtime" />
                <g:render template="classLoading" />
                <g:render template="compilation" />
              </div>
              <div id="tabMemory"><g:render template="memory" /></div>
              <div id="tabThreads"><g:render template="threads" /></div>
              <div id="tabGarbageCollectors"><g:render template="garbageCollectors" /></div>
            </div>
          </div>
          
          <input name="pageState" id="pageState" type="hidden" value="${pageState}" />
        </form>
        
      </div>
      
    </div>
    
    <div id="narrow" class="yui-b"></div>
    
  </body>
</html>