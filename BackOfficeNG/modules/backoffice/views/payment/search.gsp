<html>
  <head>
    <title><g:message code="payment.header.simpleSearch" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'payment.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript">
      YAHOO.capdematBo.calendar.cal = new Array(2);
      YAHOO.util.Event.onDOMReady(
          YAHOO.capdematBo.calendar.init, {id : 0, label : "initDateFrom"}
      );
      YAHOO.util.Event.onDOMReady(
          YAHOO.capdematBo.calendar.init, {id : 1, label : "initDateTo"}
      );
    </script>
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <g:if test="${mode == 'simple'}">
            <div class="txt-right">
              <g:message code="action.goToSimpleSearch" /> | 
              <a href="${createLink(action:'search')}?mode=advanced">
                <g:message code="action.goToAdvancedSearch" />
              </a>
            </div>
            <div id="search-form">
              <g:render template="simpleSearchForm" />
            </div>
          </g:if>
          <g:else>
            <div class="txt-right">
              <a href="${createLink(action:'search')}?mode=simple">
                <g:message code="action.goToSimpleSearch" />
              </a>
               | <g:message code="action.goToAdvancedSearch" />
            </div>
            <div id="search-form">
              <g:render template="advancedSearchForm" />
            </div>
          </g:else>
        </div>
        
        <div id="search-results"></div>
        
      </div>
    </div>
    
    <!-- filters and sorters -->
    <div id="narrow" class="yui-b">
    
      <div class="nobox">
        <h3><g:message code="header.switchTo" /></h3>
        <div class="body">
          <g:link action="configure">${message(code:'payment.header.configure')}</g:link>
        </div>
      </div>
      
      <div class="nobox">
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
          <form action="#">
            <ul>
              <li>
                <label><g:message code="property.date" /></label>
                <input type="radio" />
              </li>
              <li>
                <label><g:message code="property.requester" /></label>
                <input type="radio" />
              </li>
              <li>
                <label><g:message code="property.homeFolder" /></label>
                <input type="radio" />
              </li>
            </ul>
          </form>
        </div>
      </div>
      
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#">
            <label for="paymentState"><g:message code="property.state" /> :</label>
            <select name="paymentState" id="paymentState">
              <option value=""></option>
              <g:each in="${allStates}" var="paymentState">
                <option value="${paymentState}">${paymentState}</option>
              </g:each>
            </select>
            <label for="broker"><g:message code="payment.property.broker" /> :</label>
            <select name="broker" id="broker" style="width:100%;">
              <option value=""></option>
              <g:each in="${allBrokers}" var="broker">
                <option value="${broker.key}">${broker.value}</option>
              </g:each>
            </select>
          </form>
        </div>
      </div>
      
    </div>    
  </body>
</html>


