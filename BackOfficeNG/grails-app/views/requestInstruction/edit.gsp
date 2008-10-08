<html>
  <head>
    <title><g:message code="request.header.requestTreatment" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'requestInstruction.js')}"></script>
    <script type="text/javascript">
        zenexity.capdemat.bong.requestId = '${request.id}';
    </script>
  </head>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'requestInstruction.css')}" />      
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <div id="ecitizenContact" class="txt-right">
            <a id="ecitizenContactLink" href="/contactInformation/${request.id}">
              <g:message code="request.action.contactEcitizen" />
            </a>
            <!-- ecitizen contact panel [default display = none] -->
            <div id="ecitizenContactPanel">
              <div class="hd"></div>
              <div class="bd"></div>
            </div>
          </div>
          <h1>
            <g:message code="request.header.request" /> : 
            ${requestLabel} (<g:message code="property.id" /> : ${request.id})
          </h1>
        </div>
        
        <!-- request data template selectection by request type -->
        <g:if test="${request.requestType.label == 'Library Registration'}">
          <g:render template="/requestInstruction/requestType/libraryRegistrationRequest" model="['request':request]" />
        </g:if>
        <g:elseif test="${request.requestType.label == 'Domestic Help'}">
          <g:render template="/requestInstruction/requestType/domesticHelpRequest" model="['request':request]" />
        </g:elseif>
        <g:elseif test="${request.requestType.label == 'VO Card Request'}">
          <g:render template="/requestInstruction/requestType/voCardRequest" model="['request':request]" />
        </g:elseif>
        <g:elseif test="${request.requestType.label == 'Home Folder Modification'}">
          <g:render template="/requestInstruction/requestType/homeFolderModificationRequest" model="['request':request]" />
        </g:elseif>
        <g:else>
          <g:render template="/requestInstruction/requestType/defaultRequest" model="['request':request]" />
        </g:else>
        
        <!-- request intruction document -->
        <div id="requestDocument"> 
          <!-- Request attached document -->
          <h2><g:message code="requestType.configuration.documents" /></h2>
          <div class="box-raduis">
            <ul>
            <g:each var="document" status="i" in="${documentList}">
              <g:if test="${document.id != 0}">
                <li>
                  <a class="documentLink" href="/document/${document.id}">${document.name}</a>
                   - ${document.pageNumber} pages
                    ( ${document.endValidityDate} )
                </li>
              </g:if>
            </g:each>
            </ul>
          </div>
          <!-- document managment panel [default display = none] -->
          <div id="requestDocumentPanel">
            <div class="hd"></div>
            <div class="bd"></div>
          </div>
        </div>
   
        <!-- Request TabView -->
        <div id="requestInformation" ></div>
      
      </div>
    </div>
      
    <!-- request instruction tasks state --> 
    <div id="narrow" class="yui-b">
      
      <!-- request state -->
      <div class="nobox taskstate">
        <h3><g:message code="request.header.request" /></h3>
        <div class="body">
          <span id="requestState" class="${requestState.cssClass}">
            <g:message code="${requestState.i18nKey}" />
          </span>
        </div>
      </div>
      
      <!-- request data state -->
      <div class="nobox taskstate">
        <h3><g:message code="request.header.data" /></h3>
        <div class="body">
          <span id="requestDataState" class="${requestDataState.cssClass}">
            <g:message code="${requestDataState.i18nKey}" />
          </span>
        </div>
      </div>
      
      <!-- request document state -->
      <div class="nobox taskstate">
        <h3><g:message code="request.requester.property.evidences" /></h3>
        <div class="body">
          <ul>
          <g:each var="document" in="${documentList}">
            <li>
              <span id="documentState_${document.id}" class="${document.state.cssClass}">
                <g:message code="${document.state.i18nKey}" />
              </span>
              ${document.name}
            </li>
          </g:each>
          </ul>
        </div>
      </div>
      
      <!-- instruction state panel [default display = none] -->
      <div id="instructionStatePanel">
        <div class="hd"><g:message code="request.header.changeState" /></div>
        <div class="bd">
        </div>
        <div class="ft"></div>
      </div>
      
    </div>
  </body>
</html>

