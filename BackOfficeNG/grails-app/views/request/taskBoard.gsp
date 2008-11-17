<html>
  <head>
    <title><g:message code="request.header.taskBoard" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'taskBoard.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestTaskBoard.js')}"></script>
  </head>
  <body>
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="request.header.taskBoard" /></h1>
        </div>
        
        <form id="pageForm" method="post" action="${createLink(action:'taskBoard')}">
          <input name="pageState" id="pageState" type="hidden" value="${pageState}"></input>
        </form>
        
        <g:if test="${requestMap.containsKey('redRequests')}">
          <div class="mainbox taskboard-red">
            <h2>
              <g:message code="request.header.lateRequests" />
               (${requestMap?.redRequests?.count})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap?.redRequests?.all}" />
            </ul>
            <a href="${createLink(action:'search',controller:'request')}" id="showAllRed">
              <g:message code="action.seeAll" />
            </a>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('orangeRequests')}">
          <div class="mainbox taskboard-orange">
            <h2>
              <g:message code="request.header.alertRequests" />
               (${requestMap?.orangeRequests?.count})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record"
                collection="${requestMap?.orangeRequests?.all}" />
            </ul>
            <a href="${createLink(action:'search',controller:'request')}" id="showAllOrange">
              <g:message code="action.seeAll" />
            </a>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('pendingRequests')}"> 
          <div class="mainbox taskboard-orange">
            <h2>
              <g:message code="request.header.newRequests" />
               (${requestMap?.pendingRequests?.count})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap?.pendingRequests?.all}" />
            </ul>
            <a href="${createLink(action:'search',controller:'request')}" id="showAllPending">
              <g:message code="action.seeAll" />
            </a>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('lastRequests')}">
          <div class="mainbox taskboard-blue">
            <h2>
              <g:message code="request.header.lastRequests" />
               (${requestMap?.lastRequests?.count})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap?.lastRequests?.all}" />
            </ul>
            <a href="${createLink(action:'search',controller:'request')}" id="showAllLast_${userId}">
              <g:message code="action.seeAll" />
            </a>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('validatedRequests')}">
          <div class="mainbox taskboard-green">
            <h2>
              <g:message code="request.header.validatedRequests" />
               (${requestMap?.validatedRequests?.count})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" 
                collection="${requestMap?.validatedRequests?.all}" />
            </ul>
            <a href="${createLink(action:'search',controller:'request')}" id="showAllValidated">
              <g:message code="action.seeAll" />
            </a>
          </div>
        </g:if>
      </div>
      
    </div>
    
    <div id="narrow" class="yui-b">
      
      <div id="displayPanel" class="nobox">
        <h3><g:message code="header.display" /></h3>
        <div class="body">
          <form action="#" id="displayForm">
            <ul>
              <li>
                <g:checkBox class="display" name="displayLateRequests" value="${state?.displayForm?.contains('Late')}" />
                <g:message code="request.header.lateRequests" />
              </li>
              <li>
                <g:checkBox class="display" name="displayAlertRequests" value="${state?.displayForm?.contains('Alert')}" />
                <g:message code="request.header.alertRequests" />
              </li>
              <li>
                <g:checkBox class="display" name="displayNewRequests" value="${state?.displayForm?.contains('New')}" />
                <g:message code="request.header.newRequests" />
              </li>
              <li>
                <g:checkBox class="display" name="displayLastRequests" value="${state?.displayForm?.contains('Last')}" />
                <g:message code="request.header.lastRequests" />
              </li>
              <li>
                <g:checkBox class="display" name="displayValidatedRequests" value="${state?.displayForm?.contains('Validated')}" />
                <g:message code="request.header.validatedRequests" />
              </li>
              <li>
                <input type="button" id="refreshDisplay" value="${message(code:'action.refresh')}" />
                <input type="button" id="defaultDisplay" value="${message(code:'action.default')}" />
                <input type="button" id="saveDisplay" value="${message(code:'action.save')}" />
              </li>
            </ul>
          </form>
        </div>
      </div>

      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
          <form action="#" id="filterForm">
            <label for="categoryFilter"><g:message code="property.category" /> :</label>
            
            <g:select 
              optionKey="id"
              optionValue="name"
              id="categoryFilter"
              name="categoryFilter" 
              from="${allCategories}" 
              value="${state?.filters?.categoryFilter}"
              noSelection="['':' ']"/>
              
            
            <label for="requestTypeFilter"><g:message code="property.requestType" /> :</label>
            <g:select 
              optionKey="id"
              optionValue="label"
              id="requestTypeFilter"
              name="requestTypeFilter" 
              from="${allRequestTypes}" 
              value="${state?.filters?.requestTypeFilter}"
              noSelection="['':' ']"/>
          </form>
        </div>
      </div>

    </div>
    
  </body>
</html>


