<html>
  <head>
    <meta name="layout" content="fo_main" />
  </head>
  
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
          
            <div class="list-box">
              <h2><g:message code="request.header.requests" /></h2>
              <g:if test="${requests?.count > 0}">
                <p class="paginator">
                  <g:paginate action="index" total="${requests.count}" max="10" next="&gt;" prev="&lt;"  params="${['ps':pageState]}"  />
                </p>
                <g:render template="requestList" />
                <p class="paginator">
                  <g:paginate action="index" total="${requests.count}" max="10" next="&gt;" prev="&lt;" params="${['ps':pageState]}"  />
                </p>
              </g:if>
              <g:else>
                <p class="empty"><g:message code="message.noRequests" /></p>
              </g:else>
            </div>
              
        </div> 
      </div> 
    
      <div id="narrow" class="yui-b">
      
        <div class="narrow-box">
          <h3>
            <g:message code="header.filterBy" />
          </h3>
          <div class="body">
            <label for="subjectFilter">
              <g:message code="request.property.subject" /> :
            </label>
            <g:select id="subjectFilter" name="subjectFilter"
              optionKey="id" optionValue="firstName"
              from="${individuals}" value="${state.subjectFilter}"
              noSelection="['':message(code:'search.filter.defaultValue')]"/>
              
            <label for="stateFilter">
              <g:message code="property.requestState" /> :
            </label>
            <g:select id="stateFilter" name="stateFilter"
              from="${requestStates}" 
              valueMessagePrefix="request.state" value="${state.stateFilter}"
              noSelection="['':message(code:'search.filter.defaultValue')]" />
              
            <label for="typeFilter">
              <g:message code="property.requestType" /> :
            </label>
            <g:select id="typeFilter" name="typeFilter"
              optionKey="id" optionValue="label"
              from="${allRequestTypes}" value="${state.typeFilter}"
              noSelection="['':message(code:'search.filter.defaultValue')]" />
              
            <input type="submit" value="${message(code:'action.filter')}"/>
          </div>
        </div>
      
      </div><!-- end of narrow -->
      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>
