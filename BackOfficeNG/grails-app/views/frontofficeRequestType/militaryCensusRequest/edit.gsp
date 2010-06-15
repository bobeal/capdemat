
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
    
    <a href="${createLink(controller:'frontofficeHome')}">
      <g:message code="action.quit"/>
    </a>
    <g:if test="${!isEdition}">
      <a href="${createLink(action:'deleteDraft', controller:'frontofficeRequest', params : ['id' : rqt.id, 'from' : 'edition'])}">
        <g:message code="action.cancel"/>
      </a>
    </g:if>

    <h2 class="request-creation"> <g:message code="mcr.label" /></h2>
    <p><g:message code="mcr.description" /></p> 
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

    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">

  
        <li class="${currentStep == 'census' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'census'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.census.state}"><g:message code="request.step.state.${rqt.stepStates.census.state}" /></span>
    
          <strong>
            <g:message code="mcr.step.census.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
        <li class="${currentStep == 'parentage' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'parentage'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.parentage.state}"><g:message code="request.step.state.${rqt.stepStates.parentage.state}" /></span>
    
          <strong>
            <g:message code="mcr.step.parentage.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
        <li class="${currentStep == 'situation' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'situation'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.situation.state}"><g:message code="request.step.state.${rqt.stepStates.situation.state}" /></span>
    
          <strong>
            <g:message code="mcr.step.situation.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
        <li class="${currentStep == 'exemption' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'exemption'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.exemption.state}"><g:message code="request.step.state.${rqt.stepStates.exemption.state}" /></span>
    
          <g:message code="mcr.step.exemption.label" />
            
          </em></a>
        </li>    
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
        <li class="${currentStep == 'document' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'document'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.document.state}"><g:message code="request.step.state.${rqt.stepStates.document.state}" /></span>
    
          <g:message code="request.step.document.label" />
            
          </em></a>
        </li>    
  
        </g:if>
  

  
        <li class="${currentStep == 'validation' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'validation'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.validation.state}"><g:message code="request.step.state.${rqt.stepStates.validation.state}" /></span>
    
          <strong>
            <g:message code="request.step.validation.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

		 </ul>

     <div class="yui-content">
       <g:set var="requestTypeAcronym" value="mcr" scope="request" />
       <g:render template="/frontofficeRequestType/step" /> 
     </div><!-- end yui-content -->
    </div><!-- end requestTabView -->

  </body>
</html>
