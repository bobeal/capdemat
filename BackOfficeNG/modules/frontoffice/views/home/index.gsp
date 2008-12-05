<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
          <g:if test="${commonInfo != null}">
            <div class="information-box">
              ${commonInfo}
            </div>
          </g:if>
          <g:render template="requestList" />
          <g:render template="paymentList" />
          <g:render template="documentList" />
        </div> 
      </div> 

      <div id="narrow" class="yui-b">
      </div>
      
  </body>
</html>

