<html>
  <head>
    <title><g:message code="localAuthority.header.configuration" /></title>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'localAuthorityDrafts.js')}"></script>
    %{--<script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'localAuthorityContacts.js')}"></script>--}%
    <meta name="layout" content="main" />
    <g:if test="${entity.posted}">
      <script type="text/javascript">
        YAHOO.util.Event.onDOMReady(function(){
          zenexity.capdemat.tools.Notifier.processMessage(
            '${entity.posted.state}',
            '${entity.posted.message}'
          );
        });
      </script>
    </g:if>
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1><g:message code="localAuthority.header.configuration" /></h1>
        </div>
        
        <div class="mainbox mainbox-yellow">
          <h2><g:message code="localAuthority.header.setupDrafts" /></h2>
        
          <form method="post" id="setupDraftsForm" action="${createLink(action:'setupDrafts')}">
            <div class="error" id="setupDraftsFormErrors"></div>
            
            <label for="draftLiveDuration" class="required">
              <g:message code="localAuthority.property.draftLiveDuration" /> * :
              <!-- <span> (<g:message code="property.days" />) </span> -->
            </label>
            <input type="text" class="required validate-positiveinteger" name="draftLiveDuration" value="${entity.draftLiveDuration}" 
              class="required validate-positiveinteger" />
          
            <br/>
            <label for="draftNotificationBeforeDelete" class="required">
              <g:message code="localAuthority.property.draftNotificationBeforeDelete" /> * :
              <!-- <span> (<g:message code="property.days" />) </span> -->
            </label>
            <input type="text" class="required validate-positiveinteger" name="draftNotificationBeforeDelete" 
              value="${entity.draftNotificationBeforeDelete}" 
              class="required validate-positiveinteger" />
              
            <div class="form-button">
              <input id="save" name="save" type="button" value="${message(code:'action.save')}" />
            </div>
          </form>
        </div>
        
      </div>
    </div>
    <g:render template="subMenus"/>
  </body>
</html>
