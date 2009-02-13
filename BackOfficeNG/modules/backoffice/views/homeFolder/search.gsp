<html>
  <head>
    <title><g:message code="request.header.simpleSearch" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'homeFolderSearch.js')}"></script>
  </head>
  <body>

    <div id="yui-main">
      <div class="yui-b">
        
        <div id="head" class="head">
          <g:render template="searchForm" />
        </div>

        <div id="search-results">
          <g:render template="searchResults" />
        </div>
        
      </div>
    </div>

    <!-- filters and sorters -->
    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
        </div>
      </div>
      
    </div>
  
  </body>
</html>