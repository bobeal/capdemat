
<html>
  <head>
     <title>${message(code:'mcr.description')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <g:if test="${flash.addressesReferentialEnabled}">
        <link rel="stylesheet" type="text/css" href="${resource(dir:'css/common', file:'autocomplete.css')}" />
    </g:if>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'condition.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'autofill.js')}"></script>
    <g:if test="${flash.addressesReferentialEnabled}">
        <script type="text/javascript" src="${resource(dir:'js/common',file:'addressAutocomplete.js')}"></script>
        <script type="text/javascript" src="${resource(dir:'js/common',file:'autocomplete.js')}"></script>
    </g:if>
    <g:if test="${customJS}">
      <script type="text/javascript" src="${resource(dir:customJS.dir,file:customJS.file)}"></script>
    </g:if>
    <script type="text/javascript">
        zenexity.capdemat.contextPath = "${request.contextPath}";
    </script>
  </head>
  <body>
    <form action="${createLink(controller:'frontofficeRequest',action:'condition')}"
      method="post" id="conditionsForm">
      <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
      <input type="hidden" name="requestTypeLabel" value="${rqt.requestType.label}" />
    </form>
    <form action="${createLink(controller:'frontofficeRequest',action:'autofill')}"
      method="post" id="autofillForm">
      <input type="hidden" id="autofillContainer" name="autofillContainer" value="" />
      <input type="hidden" id="triggerName" name="triggerName" value="" />
      <input type="hidden" id="triggerValue" name="triggerValue" value="" />
    </form>
    <g:if test="${flash.confirmationMessage}">
      <div class="information-box">
      	<p>${flash.confirmationMessage}</p>
      	<g:if test="${flash.confirmationMessageNotice}">
      	  <strong>${flash.confirmationMessageNotice}</strong>
      	</g:if>
      </div>
    </g:if>
    <g:if test="${flash.errorMessage}">
      <div class="error-box">
        <p>${flash.errorMessage}</p>
        <g:if test="${flash.errorMessageNotice}">
          <strong>${flash.errorMessageNotice}</strong>
        </g:if>
      </div>
    </g:if>
    
    <div id="request" class="main-box">
      <h2>
        <a href="${createLink(controller:'frontofficeHome')}" class="button">
          <g:message code="action.quit"/>
        </a>
        <g:if test="${!isEdition}">
          <a href="${createLink(action:'deleteDraft', controller:'frontofficeRequest', params : ['id' : rqt.id, 'from' : 'edition'])}" class="button">
            <g:message code="action.cancel"/>
          </a>
        </g:if>
        <g:message code="mcr.label" />
        <span><g:message code="mcr.description" /></span> 
      </h2>
      <p><g:message code="request.duration.label" /><strong> : <g:message code="mcr.duration.value" /></strong></p>
      <p>
        <g:message code="request.requiredDocuments.header" /> :
        <g:if test="${!documentTypes.isEmpty()}">
          <g:each var="documentType" in="${documentTypes}" status="index">
            <strong>${documentType?.name}${index < documentTypes.size() - 1 ? ', ' : ''}</strong>
          </g:each>
        </g:if>
        <g:else>
          <g:message code="message.none" />
        </g:else>
      </p>
      <div class="datas">
         <g:set var="requestTypeAcronym" value="mcr" scope="request" />
         <g:render template="/frontofficeRequestType/step" /> 
      </div>
      
      <div  class="steps">
      <ul>

  
        <li class="${currentStep == 'census' ? 'current' : ''} ${rqt.stepStates['census'].state}">
          <span class="number">1</span>
          <a
            <g:if test="${rqt.stepStates['census'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'census'])}"
            </g:if>
          >
            <g:message code="mcr.step.census.label" /> *
            <span class="help">
              <g:message code="request.step.message.${rqt.stepStates['census'].state}" />
            </span>
          </a>
        </li>    
  

  
        <li class="${currentStep == 'parentage' ? 'current' : ''} ${rqt.stepStates['parentage'].state}">
          <span class="number">2</span>
          <a
            <g:if test="${rqt.stepStates['parentage'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'parentage'])}"
            </g:if>
          >
            <g:message code="mcr.step.parentage.label" /> *
            <span class="help">
              <g:message code="request.step.message.${rqt.stepStates['parentage'].state}" />
            </span>
          </a>
        </li>    
  

  
        <li class="${currentStep == 'situation' ? 'current' : ''} ${rqt.stepStates['situation'].state}">
          <span class="number">3</span>
          <a
            <g:if test="${rqt.stepStates['situation'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'situation'])}"
            </g:if>
          >
            <g:message code="mcr.step.situation.label" /> *
            <span class="help">
              <g:message code="request.step.message.${rqt.stepStates['situation'].state}" />
            </span>
          </a>
        </li>    
  

  
        <li class="${currentStep == 'exemption' ? 'current' : ''} ${rqt.stepStates['exemption'].state}">
          <span class="number">4</span>
          <a
            <g:if test="${rqt.stepStates['exemption'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'exemption'])}"
            </g:if>
          >
            <g:message code="mcr.step.exemption.label" />
            <span class="help">
              <g:message code="request.step.message.${rqt.stepStates['exemption'].state}" />
            </span>
          </a>
        </li>    
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
        <li class="${currentStep == 'document' ? 'current' : ''} ${rqt.stepStates['document'].state}">
          <span class="number">5</span>
          <a
            <g:if test="${rqt.stepStates['document'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'document'])}"
            </g:if>
          >
            <g:message code="request.step.document.label" />
            <span class="help">
              <g:message code="request.step.message.${rqt.stepStates['document'].state}" />
            </span>
          </a>
        </li>    
  
        </g:if>
  

  
        <li class="${currentStep == 'validation' ? 'current' : ''} ${rqt.stepStates['validation'].state}">
          <span class="number"></span>
          <a
            <g:if test="${rqt.stepStates['validation'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'validation'])}"
            </g:if>
          >
            <g:message code="request.step.validation.label" /> *
            <span class="help">
              <g:message code="request.step.message.${rqt.stepStates['validation'].state}" />
            </span>
          </a>
        </li>    
  

		 </ul>
	  </div>
  </div>

  </body>
</html>
