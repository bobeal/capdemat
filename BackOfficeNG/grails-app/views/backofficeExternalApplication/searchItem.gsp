<html>
  <head>
    <title><g:message code="external.header.searchItem" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'externalSearch.js')}"></script>
    <script type="text/javascript">
    zenexity.capdemat.bong.external.Search.before = function() {
      if ('${searchType}' === 'invoice')
        zenexity.capdemat.bong.Calendar("expirationDateBefore");
    }
    </script>
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
    
    <!-- filters -->
    <div id="narrow" class="yui-b">
      <menu:subMenu id="secondMenu" i18nPrefix="header" data="${subMenuEntries}" />
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          
          <form action="#" id="itemSearchFilters">
            <label for="brokerFilter"><g:message code="payment.property.broker" /> :</label>
            <select name="brokerFilter" id="brokerFilter">
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allBrokers}" var="broker">
                <option value="${broker.key}" ${filters['brokerFilter'] == broker.key ? 'selected' : ''}>
                  ${broker.key}
                </option>
              </g:each>
            </select>
            
            <label for="externalApplicationFilter"><g:message code="external.property.externalApplications" /> :</label>
            <select name="externalApplicationFilter" id="externalApplicationFilter"> 
              <option value=""><g:message code="search.filter.defaultValue"/></option>
              <g:each in="${allExternalApplications}" var="externalApplication">
                <option value="${externalApplication.id}" ${filters['externalApplicationFilter'] == externalApplication.id.toString() ? 'selected="selected"' : ''}>
                  ${externalApplication.label}
                </option>
              </g:each>
            </select>
          </form>

        </div>
      </div>

    </div>
  
  </body>
</html>
