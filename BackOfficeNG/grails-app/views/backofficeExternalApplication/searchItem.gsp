<html>
  <head>
    <title><g:message code="external.header.searchItem" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'externalSearch.js')}"></script>
  </head>
  <body>

    <div id="yui-main">
      <div class="yui-b">
        
        <div id="head" class="head">
          <g:render template="searchItemForm" />
        </div>

        <div class="search-results">
          <g:render template="searchItemResults" />
        </div>

      </div>
    </div>

    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
    </div>
  
  </body>
</html>
