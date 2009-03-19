<html>
  <head>
    <meta name="layout" content="fo_main" />
  </head>
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
          <div class="list-box">
            <g:render template="itemDetails"/>
          </div>
        </div> 
      </div> 
      <!-- end of yui-main -->
      <g:render template="cart"/>
      <div id="narrow" class="yui-b">
        <div id="requestSubject" class="requestBox">
          <h3>
            <g:message code="header.display" />
          </h3>
          <div class="body">
            <a class="top-link" href="${createLink(action:'index')}">
              <g:message code="payment.header.accountStatus" />
            </a>
          </div>
        </div>
      </div>
      
    </form>
  </body>
</html>