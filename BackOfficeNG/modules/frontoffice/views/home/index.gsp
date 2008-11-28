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
            
              <g:if test="${commonInfo != null}">
                <div id="informationPanel">
                  ${commonInfo}
                </div>
              </g:if>
              <p>
                <g:render template="requestList" />
              </p>
              <p>
                <g:render template="paymentList" />
              </p>
              <p>
                <g:render template="documentList" />
              </p>
            
            </div>
          </div>
     
        </div> 
      </div> 
    <!-- 
      <div id="narrow" class="yui-b">
      
        <div id="requestSubject" class="requestBox">
          <h3>
            <g:message code="header.filterBy" />
          </h3>
          <div class="body">
            
          </div>
        </div>
      
      </div>-->
      <!-- end of narrow -->
      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

