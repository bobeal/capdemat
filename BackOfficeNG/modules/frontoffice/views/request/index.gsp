<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
          
          <div class="yui-navset">
            <div class="yui-content" style="margin-left:1em!important;">
            
              <div id="search-results">
                <g:render template="requestList" />
                <g:paginate action="index" total="${requests.count}" 
                            max="10" next="&gt;" prev="&lt;"
                            params="${['ps':pageState]}"
                            />
              </div>
            
            </div>
          </div>
     
        </div> 
      </div> 
    
      <div id="narrow" class="yui-b">
      
        <div id="requestSubject" class="requestBox">
          <h3>
            <g:message code="header.filterBy" />
          </h3>
          <div class="body">
            <label for="categoryFilter">
              <g:message code="property.individual" /> :
            </label>
            
            <g:select 
              optionKey="id"
              optionValue="firstName"
              id="indvFilter"
              name="indvFilter" 
              from="${individuals}" 
              value="${state?.indvFilter}"
              noSelection="['':' ']"/>
              
            <label for="requestState">
              <g:message code="property.requestState" /> :
            </label>
            
            <g:select 
              id="stateFilter"
              name="stateFilter" 
              from="${requestStates}" 
              valueMessagePrefix="request.state"
              value="${state?.stateFilter}"
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
              value="${state?.typeFilter}"
              noSelection="['':' ']"/>
              
            <input type="submit" value="${message(code:'action.filter')}"/>
          </div>
        </div>
      
      </div><!-- end of narrow -->
      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

