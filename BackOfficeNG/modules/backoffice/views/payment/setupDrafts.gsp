<html>
  <head>
    <title><g:message code="payment.header.configure" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/yui/editor',file:'simpleeditor.css')}" />
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
          <h1><g:message code="payment.header.setupDrafts" /></h1>
        </div>
        <form method="post" 
          id="setupDraftsForm" 
          action="setupDrafts" 
          class="editable-list-form"
          style="border: none">
          <label for="draftLiveDuration">
            <g:message code="payment.property.draftLiveDuration" /> :
            <span> (<g:message code="property.days" />) </span>
          </label>
          <g:textField name="draftLiveDuration" 
            value="${entity.draftLiveDuration}" />
          <label for="draftNotificationBeforeDelete">
            <g:message code="payment.property.draftNotificationBeforeDelete" /> :
            <span> (<g:message code="property.days" />) </span>
          </label>
          <g:textField name="draftNotificationBeforeDelete" 
            value="${entity.draftNotificationBeforeDelete}" />
          <p class="same-line">
            <input type="submit" class="first-button" value="${message(code:'action.save')}" />
          </p>
        </form>
      </div>
    </div>

    <div id="narrow" class="yui-b">
      <div class="nobox">
        <h3>Explications et aide ...</h3>
        <div class="body"></div>
      </div>
    </div>    

  </body>
</html>
