<html>
  <head>
    <title><g:message code="request.header.instruction" /></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/common',file:'calendar.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/common',file:'autocomplete.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'contact.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'requestInstruction.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'documentInstruction.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'condition.js')}"></script>
    <g:if test="${flash.addressesReferentialEnabled}">
        <script type="text/javascript" src="${resource(dir:'js/common',file:'autocomplete.js')}"></script>
        <script type="text/javascript" src="${resource(dir:'js/common',file:'addressAutocomplete.js')}"></script>
    </g:if>
    <script type="text/javascript">
      zenexity.capdemat.bong.requestId = '${rqt.id}';
      zenexity.capdemat.bong.editableStates = ${editableStates} ; 
      zenexity.capdemat.bong.agentCanWrite = '${agentCanWrite}';
      zenexity.capdemat.bong.contactPanelUrl = "${createLink(controller : 'backofficeContact', action : 'panel')}";
    </script>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin',file:'container.css')}" ></link>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'contact.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'requestInstruction.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'document.css')}" />
    <g:if test="${flash.addressesReferentialEnabled}">
        <link rel="stylesheet" type="text/css" href="${resource(dir:'css/common', file:'autocomplete.css')}" />
    </g:if>
    <g:if test="${externalProviderServiceLabel != null}">
      <script type="text/javascript">
        zenexity.capdemat.bong.request.External.label = '${externalProviderServiceLabel}';
      </script>
    </g:if>
  </head>
  <body>

    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <div id="contactContainer" class="txt-right">
            <a id="contactLink">
              <g:message code="contact.header.contactEcitizen" />
            </a>
            <!-- ecitizen contact panel [default display = none] -->
            <div id="contactPanel">
              <div class="hd"></div>
              <div class="bd">
              </div>
            </div>
          </div>
          <h1>
            <g:message code="request.header.request" />
          	<g:if test="${!hasHomeFolder}">
              (<g:message code="request.message.outOfAccount" />)
            </g:if>
            ${requestLabel} (${rqt.id})
          </h1>
          <g:if test="${rqt.requestSeason}">
            <span id="requestSeasonLabel">${rqt.requestSeason.label}</span>
          </g:if>
          <span id="requestTypeLabel">${requestTypeLabel}</span>
        </div>

        <!-- request data template selection by request type -->
        <g:render template="/backofficeRequestInstruction/requestType/${requestTypeTemplate}/edit" 
                  model="['rqt':rqt, 'requester':requester]" />


        <!-- request intruction document -->
        <div id="requestDocument">
          <!-- Request attached document -->
          <h2><g:message code="requestType.configuration.documents" /></h2>
          <div class="box-raduis">
            <ul class="document-list" id="partialDocumentList">
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
      <menu:subMenu i18nPrefix="header" data="${subMenuEntries}" />
      <!-- request state -->
      <div class="nobox taskstate">
        <h3><g:message code="request.header.request" /></h3>
        <div class="body">
          <span id="requestState" class="${requestState.cssClass}">
            <g:message code="${requestState.i18nKey}" />
          </span>
          <div id="requestLockContainer"></div>
          <g:if test="${lastActionNote}">
          	<p class="block">${lastActionNote}</p>
          </g:if>
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
        <h3><g:message code="property.documents" /></h3>
        <div class="body">
          <ul class="document-list" id="fullDocumentList">
          </ul>
        </div>
      </div>

      <!-- external service block -->
      <g:if test="${externalProviderServiceLabel != null && externalTemplateName != null}">
        <g:render template="${externalTemplateName}"
          model="['rqt' : rqt, 'externalProviderServiceLabel' : externalProviderServiceLabel, 'lastTraceStatus' : lastTraceStatus]" />
      </g:if>

      <!-- instruction state panel [default display = none] -->
      <div id="instructionStatePanel">
        <div class="hd"><g:message code="request.header.changeState" /></div>
        <div class="bd">
        </div>
        <div class="ft"> </div>
      </div>
      <div id="requestLockPanel">
        <div class="hd"></div>
        <div class="bd">
        </div>
        <div class="ft"> </div>
      </div>
      <div id="documentStateOverlay" class="state-overlay">
        <div class="hd"> </div>
        <div class="bd"> </div>
      </div>
      <div id="documentCalendarTip">
        <div class="hd"> </div>
        <div class="bd">
          <div id="documentCalendar"> </div>
        </div>
      </div>
      <form action="${createLink(action:'condition')}" method="post" id="conditionsForm">
        <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
        <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
      </form>
    </div>
  </body>
</html>
