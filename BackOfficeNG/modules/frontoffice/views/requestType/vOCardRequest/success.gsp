<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
  </head>
  <body>
    <g:render template="/frontofficeRequestType/draftPanel" />
    <h2 class="request-creation"> <g:message code="vcr.label" /></h2>
    <p><g:message code="vcr.description" /></p>

    <div id="requestTabView" class="yui-navset">
     <div class="creation-success">
       <h3><g:message code="vcr.message.creationSuccess" /></h3>
       <dl>
         <dt><g:message code="request.property.requestId" /> :</dt>
         <dd>${requestId}</dd>

         <dt><g:message code="homeFolder.adult.property.login" /> :</dt>
         <dd>${login}</dd>
       </dl>
       <a href="${createLink(controller:'frontofficeHome')}"><g:message code="vcr.action.quit" /></a>
     </div>  
    </div><!-- end requestTabView -->

  </body>
</html>
