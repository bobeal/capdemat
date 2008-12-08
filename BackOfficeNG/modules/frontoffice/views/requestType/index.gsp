<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
    <form action="${createLink(action:'index')}" method="post" id="mainForm">
      
      <div id="yui-main"> 
        <div id="main" class="yui-b">
          <div class="list-box">
            <h2>Quelques liens temporaires ...</h2>
            <p>
              <a href="${createLink(controller:'frontofficeHandicapAllowanceRequest')}">Demande de compensation du handicap</a>
            </p>
            <p>
              <a href="${createLink(controller:'frontofficeDomesticHelpRequest')}">Demande d'aide ménagère</a>
            </p>
            <p>
              <a href="${createLink(controller:'frontofficeHome',action:'login')}">Maquette page d'accueil</a>            
            </p>
          </div>
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

