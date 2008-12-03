<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
          <div class="main-box">
            <h2><g:message code="request.header.generalInformations"/></h2>
            <p>
              <g:message code="property.active"/> : <span class="tag-enable">oui</span>
            </p>
            <p>
              <g:message code="property.state"/> : <span class="tag-enable">validé</span>
            </p>
            <p>
              <g:message code="request.requester.property.adress"/> :  <b>64 rue TaitBout 75009 Paris</b>
            </p>
          </div>
          <div class="individual">
            <g:render template="adults" />
            <g:render template="children" />
          </div>
        </div> 
      </div> 
    
      <div id="narrow" class="yui-b">
      </div><!-- end of narrow -->
      
      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

