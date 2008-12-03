<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
         
          <div class="yui-navset">
            <div class="yui-content">
              <!-- HOME FOLDER DATA -->
              <h2><g:message code="request.header.generalInformations"/></h2>

              <div class="sub-mainbox-raduis" style="line-height:2em">
                <div>
                  <g:message code="property.active"/> :
                  <span class="tag-enable">${homeFolder.isActive}</span>
                </div>
                <div>
                  <g:message code="property.state"/> :
                  <span class="tag-enable">
                    <g:capdematEnumToFlag var="${homeFolder.state}" i18nKeyPrefix="actor.state" />
                  </span>
                </div>
                <div>
                  <g:message code="request.requester.property.adress"/> :
                  <b>${homeFolder.addressDetails}</b>
                </div>
              </div>
              <g:render template="adults" />
              <g:render template="children" />
            </div>
          </div>
        </div> 
      </div>     
      <div id="narrow" class="yui-b">
      </div><!-- end of narrow -->
      
      <g:hiddenField name="ps" value="${pageState}" />
    </form>
  </body>
</html>

