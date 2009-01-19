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
              <p class="paginator">
                <g:paginate action="index" total="${requests.count}" max="10" next="&gt;" prev="&lt;" 
                  params="${['ps':pageState]}"  />
              </p>
              <g:render template="requestList" />
              <p class="paginator">
                <g:paginate action="index" total="${requests.count}" max="10" next="&gt;" prev="&lt;" 
                  params="${['ps':pageState]}"  />
              </p>
            </div>
              
        </div> 
      </div> 
    
      <div id="narrow" class="yui-b">
      
        <div id="requestSubject" class="requestBox">
          <h3>
            <g:message code="header.filterBy" />
          </h3>
          <div class="body">
            <label for="subjectFilter">
              <g:message code="request.property.subject" /> :
            </label>
            <g:select 
              optionKey="id"
              optionValue="firstName"
              id="subjectFilter"
              name="subjectFilter" 
              from="${individuals}" 
              value="${state.subjectFilter}"
              noSelection="['':' ']"/>
              
            <label for="stateFilter">
              <g:message code="property.requestState" /> :
            </label>
            <g:select 
              id="stateFilter"
              name="stateFilter" 
              from="${requestStates}" 
              valueMessagePrefix="request.state"
              value="${state.stateFilter}"
              noSelection="['':' ']"/>
              
            <label for="typeFilter">
              <g:message code="property.requestType" /> :
            </label>
            <g:select 
              optionKey="id"
              optionValue="label"
              id="typeFilter"
              name="typeFilter" 
              from="${allRequestTypes}"
              value="${state.typeFilter}"
              noSelection="['':' ']"/>
              
            <input type="submit" value="${message(code:'action.filter')}"/>
          </div>
        </div>
      
      </div><!-- end of narrow -->
      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

