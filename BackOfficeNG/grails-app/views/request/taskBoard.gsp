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
        
        <g:if test="${requestMap.containsKey('cvq.tasks.qualityRed')}">
          <div class="mainbox taskboard-red">
            <h2>
              <g:message code="request.header.lateRequests" />
               (${requestMap.get('cvq.tasks.qualityRed').size()})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" collection="${requestMap.get('cvq.tasks.qualityRed')}" />
            </ul>
            <g:link  controller="request" action="search">
              <g:message code="action.seeAll" /> 
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('cvq.tasks.qualityOrange')}">
          <div class="mainbox taskboard-orange">
            <h2>
              <g:message code="request.header.alertRequests" />
               (${requestMap.get('cvq.tasks.qualityOrange').size()})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" collection="${requestMap.get('cvq.tasks.qualityOrange')}" />
            </ul>
            <g:link  controller="request" action="search">
              <g:message code="action.seeAll" />
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('cvq.tasks.pending')}"> 
          <div class="mainbox taskboard-orange">
            <h2>
              <g:message code="request.header.newRequests" />
               (${requestMap.get('cvq.tasks.pending').size()})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" collection="${requestMap.get('cvq.tasks.pending')}" />
            </ul>
            <g:link controller="request" action="search" params="[state:'Pending']">
              <g:message code="action.seeAll" />
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('cvq.tasks.opened')}">
          <div class="mainbox taskboard-blue">
            <h2>
              <g:message code="request.header.lastRequests" />
               (${requestMap.get('cvq.tasks.opened').size()})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" collection="${requestMap.get('cvq.tasks.opened')}" />
            </ul>
            <g:link controller="request" action="search" params="[state:'Complete']">
              <g:message code="action.seeAll" />
            </g:link>
          </div>
        </g:if>
        
        <g:if test="${requestMap.containsKey('cvq.tasks.validated')}">
          <div class="mainbox taskboard-green">
            <h2>
              <g:message code="request.header.validatedRequests" />
               (${requestMap.get('cvq.tasks.validated').size()})
            </h2>
            <ul>
              <g:render template="taskBoardEntry" var="record" collection="${requestMap.get('cvq.tasks.validated')}" />
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
          <ul>
            <li>
              <label for="categoryId"><g:message code="property.category" /> :</label>
              <select name="categoryId" id="categoryId" style="width:100%;">
                <option value=""></option>
                <g:each in="${allCategories}" var="category">
                  <option value="${category.id}">${category.name}</option>
                </g:each>
              </select>
            </li>
            <li>
              <label for="requestTypeId">
                <g:message code="property.requestType" /> :</label>
              <select name="requestTypeId" id="requestTypeId" style="width:100%;">
                <option value=""></option>
                <g:each in="${allRequestTypes}" var="requestType">
                  <option value="${requestType.key}">${requestType.value}</option>
                </g:each>
              </select>
            </li>
          </ul>
        </div>
      </div>

    </div>
    
  </body>
</html>


