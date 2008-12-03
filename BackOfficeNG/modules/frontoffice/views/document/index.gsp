<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">

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
      </div><!-- end of narrow -->

      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

