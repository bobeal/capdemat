<html>
  <head>
    <title><g:message code="request.header.requestTreatment" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestInstruction.js')}"></script>
    <script type="text/javascript">
        YAHOO.capdematBo.requestId = '${request.id}';
    </script>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'requestInstruction.css')}" />      
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <div class="txt-right">
             <a href=""><g:message code="request.action.contactEcitizen" /></a>
          </div>
          <h1><g:message code="request.header.request" /> : ${requestLabel} (Réf : ${request.id})</h1>
        </div>
        
        <!-- request data template selectection by request type -->
        <g:if test="${request.requestType.label == 'Library Registration'}">
          <g:render template="/requestInstruction/requestType/libraryRegistrationRequest" model="['request':request]" />
        </g:if>
        <g:elseif test="${request.requestType.label == 'Domestic Help'}">
          <g:render template="/requestInstruction/requestType/domesticHelpRequest" model="['request':request]" />
        </g:elseif>
        <g:else>
          <g:render template="/requestInstruction/requestType/defaultRequest" model="['request':request]" />
        </g:else>
        
        <!-- request intruction document -->
        <div id="requestDocument"> 
          <!-- Request attached document -->
          <h2><g:message code="requestType.configuration.documents" /></h2>
          <div class="box-raduis"> 
            <g:each var="document" status="i" in="${documentList}">
              <g:if test="${i > 0}">| </g:if>
              <a href="did=${document.id}">${document.name}</a>
            </g:each>
          </div>
        </div>
   
        <!-- Request TabView -->
        <div id="requestInformation" ></div>
      
      </div>
    </div>
      
    <!-- request instruction tasks state --> 
    <div id="narrow" class="yui-b">
 
      <div class="nobox taskstate">
        <h3><g:message code="request.header.request" /></h3>
        <div class="body">
          <span class="tag-pending"><g:message code="request.property.stateOpened" /></span>
        </div>
      </div>
       
      <div class="nobox taskstate">
        <h3><g:message code="request.header.data" /></h3>
        <div class="body">
          <span class="tag-validated"><g:message code="request.property.stateValidated" /></span>
        </div>
      </div>
       
      <div class="nobox taskstate">
        <h3><g:message code="request.requester.property.evidences" /></h3>
        <div class="body">
          <span class="tag-pending"><g:message code="request.property.stateOpened" /></span>
          <ul>
          <g:each var="document" status="i" in="${documentList}">
            <li>
              <span class="tag-rejected">ref</span>
              ${document.name}
            </li>
          </g:each>
            <li>
              <span class="tag-validated">val</span>
              <g:message code="request.requester.property.homeRecords" />
            </li>
            <li>
              <span class="tag-pending">cou</span>
              <g:message code="request.requester.property.familyRecordBook" />
            </li>
          </ul>
        </div>
      </div>
         
      <div class="nobox  taskstate">
        <h3><g:message code="request.requester.property.certificate" /></h3>
        <div class="body">
          <span class="tag-pending">à envoyer</span>
        </div>
      </div>
    
    </div>
  </body>
</html>

