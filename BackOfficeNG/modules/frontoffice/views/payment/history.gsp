<html>
  <head>
    <meta name="layout" content="fo_main" />
  </head>
  
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
          <g:render template="paymentList" />
        </div> 
      </div> <!-- end of yui-main -->
    
      <div id="narrow" class="yui-b">
        <div id="requestSubject" class="requestBox">
          <h3>
            <g:message code="header.filterBy" />
          </h3>
          <div class="body">
            
          </div>
        </div>
      </div>
      
      <div id="narrow" class="yui-b">
        <div id="requestSubject" class="requestBox">
          <h3>
            <g:message code="header.display" />
          </h3>
          <div class="body">
            <a class="top-link" href="${createLink(action:'index')}">
              <g:message code="payment.header.accountAndBasketStatus" />
            </a>
          </div>
        </div>
      </div>
      <!-- end of narrow -->
      
      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

