<html>
  <head>
    <title><g:message code="request.header.requestTreatment" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'requestInstruction.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'document.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/backoffice',file:'condition.js')}"></script>
    <script type="text/javascript">
      zenexity.capdemat.bong.requestId = '${request.id}';
      zenexity.capdemat.bong.editableStates = ${editableStates} ; 
      zenexity.capdemat.bong.agentCanWrite = '${agentCanWrite}';
      
    </script>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common/yui-skin/',file:'container.css')}" ></link>
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'requestInstruction.css')}" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice',file:'document.css')}" />
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
              <div class="bd">
              </div>
            </div>
          </div>
          <h1>
            <g:message code="request.header.request" /> :
            ${requestLabel} (${request.id})
          </h1>
          <span id="requestTypeLabel">${request.requestType.label}</span>
        </div>

        <!-- request data template selection by request type -->
        <g:render template="/backofficeRequestInstruction/requestType/${requestTypeTemplate}/edit" model="['request':request]" />


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
                   - ${document.pageNumber} <g:message code="property.pages"/>
                   <g:if test="${document.endValidityDate}">
                    (<g:message code="document.property.endValidityDate"/> : 
                      <g:formatDate formatName="format.date" date="${document.endValidityDate}" />)
                   </g:if>
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
              <a class="${document.state.cssClass} documentState_${document.id} documentLink"
                  href="/document/${document.id}">
                <g:message code="${document.state.i18nKey}" />
              </a>
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
      <form action="${createLink(action:'condition')}" method="post" id="conditionsForm">
        <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
        <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
      </form>
    </div>
  </body>
</html>
