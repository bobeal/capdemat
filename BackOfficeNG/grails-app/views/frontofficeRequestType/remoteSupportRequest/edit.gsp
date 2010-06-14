
<html>
  <head>
     <title>${message(code:'rsr.description')}</title>
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
      <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
    </form>
    <form action="${createLink(controller:'frontofficeRequest',action:'autofill')}"
      method="post" id="autofillForm">
      <input type="hidden" id="autofillContainer" name="autofillContainer" value="" />
      <input type="hidden" id="triggerName" name="triggerName" value="" />
      <input type="hidden" id="triggerValue" name="triggerValue" value="" />
    </form>
    <g:if test="${flash.isOutOfAccountRequest}">
      <g:render template="/frontofficeRequestType/loginPanel" />
    </g:if>
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

    <h2 class="request-creation"> <g:message code="rsr.label" /></h2>
    <p><g:message code="rsr.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="rsr.duration.value" /></strong></p>
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

  
        <li class="${currentStep == 'subject' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'subject'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.subject.state}"><g:message code="request.step.state.${rqt.stepStates.subject.state}" /></span>
    
          <strong>
            <g:message code="rsr.step.subject.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
        <li class="${currentStep == 'contact' ? 'selected' : ''}">
          <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'contact'])}">
          <em>
          <span class="tag-state tag-${rqt.stepStates.contact.state}"><g:message code="request.step.state.${rqt.stepStates.contact.state}" /></span>
    
          <strong>
            <g:message code="rsr.step.contact.label" /> *
          </strong>
            
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
       <g:set var="requestTypeLabel" value="${requestTypeLabel}" />
       <g:set var="requestTypeAcronym" value="rsr" scope="request" />
       <g:render template="/frontofficeRequestType/step" /> 
     </div><!-- end yui-content -->
    </div><!-- end requestTabView -->

  </body>
</html>
