<html>
  <head>
    <title><g:message code="request.header.taskBoard" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'taskBoard.css')}" />
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="request.header.taskBoard" /></h1>
        </div>
        
        <g:if test="${requestMap.containsKey('redRequests')}">
          <div class="mainbox taskboard-red">
            <h2>
              <g:message code="request.header.lateRequests" />
               (${requestMap.get('redRequestsCount')})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap.get('redRequests')}" />
            </ul>
            <g:link controller="request" action="search">
              <g:message code="action.seeAll" /> 
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('orangeRequests')}">
          <div class="mainbox taskboard-orange">
            <h2>
              <g:message code="request.header.alertRequests" />
               (${requestMap.get('orangeRequestsCount')})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap.get('orangeRequests')}" />
            </ul>
            <g:link  controller="request" action="search">
              <g:message code="action.seeAll" />
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('pendingRequests')}"> 
          <div class="mainbox taskboard-orange">
            <h2>
              <g:message code="request.header.newRequests" />
               (${requestMap.get('pendingRequestsCount')})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap.get('pendingRequests')}" />
            </ul>
            <g:link controller="request" action="search" params="[state:'Pending']">
              <g:message code="action.seeAll" />
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('lastRequests')}">
          <div class="mainbox taskboard-blue">
            <h2>
              <g:message code="request.header.lastRequests" />
               (${requestMap.get('lastRequestsCount')})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap.get('lastRequests')}" />
            </ul>
            <g:link controller="request" action="search">
              <g:message code="action.seeAll" />
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('validatedRequests')}">
          <div class="mainbox taskboard-green">
            <h2>
              <g:message code="request.header.validatedRequests" />
               (${requestMap.get('validatedRequestsCount')})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap.get('validatedRequests')}" />
            </ul>
            <g:link controller="request" action="search" params="[state:'Validated']">
              <g:message code="action.seeAll" />
            </g:link>
          </div>
        </g:if>
      </div>
      
    </div>
    
    <div id="narrow" class="yui-b">
      
      <div class="nobox">
        <h3><g:message code="header.display" /></h3>
        <div class="body">
          <form action="#">
            <ul>
              <li>
                <input type="checkbox" />
                <g:message code="request.header.lateRequests" />
              </li>
              <li>
                <input type="checkbox" />
                <g:message code="request.header.alertRequests" />
              </li>
              <li>
                <input type="checkbox" />
                <g:message code="request.header.newRequests" />
              </li>
              <li>
                <input type="checkbox" />
                <g:message code="request.header.lastRequests" />
              </li>
              <li>
                <input type="checkbox" />
                <g:message code="request.header.validatedRequests" />
              </li>
            </ul>
          </form>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#" id="taskBoardFilters">
            <label for="categoryIdFilter"><g:message code="property.category" /> :</label>
            <select id="categoryIdFilter" 
              <option value=""></option>
              <g:each in="${allCategories}" var="category">
                <option value="${category.id}">
                  ${category.name}
                </option>
              </g:each>
            </select>
            
            <label for="requestTypeFilter"><g:message code="property.requestType" /> :</label>
            <select id="requestTypeFilter" 
              <option value=""></option>
              <g:each in="${allRequestTypes}" var="requestType">
                <option value="${requestType.id}">
                  ${requestType.label}
                </option>
              </g:each>
            </select>
          </form>
        </div>
      </div>

    </div>
    
  </body>
</html>


