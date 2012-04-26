
<html>
  <head>
     <title>${message(code:'ancr.description')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'document.css')}" />
    <g:if test="${flash.addressesReferentialEnabled}">
        <link rel="stylesheet" type="text/css" href="${resource(dir:'css/common', file:'autocomplete.css')}" />
    </g:if>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'homeFolder.js')}"></script>
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
    
    <div id="request" class="main-box ${rqt.requestType.category.name}">
      <h2>
        <g:if test="${temporary}">
          <a href="${createLink(controller : 'frontofficeHome', action : 'logout')}" class="button">
            <g:message code="request.action.discard"/>
          </a>
        </g:if>
        <g:else>
          <a href="${createLink(controller:'frontofficeHome')}" class="button">
            <g:message code="request.action.continueLater"/>
          </a>
          <g:if test="${!isEdition}">
            <a href="${createLink(action:'deleteDraft', controller:'frontofficeRequest', params : ['id' : rqt.id, 'from' : 'edition'])}" class="button">
              <g:message code="request.action.discardDarft"/>
            </a>
          </g:if>
        </g:else>
        <g:message code="ancr.label" /> <g:message code="message.number" args="[rqt.id]" />
      </h2>
      <p><g:message code="request.duration.label" /><strong> : <g:message code="ancr.duration.value" /></strong></p>
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
         <g:set var="requestTypeAcronym" value="ancr" scope="request" />
         <g:render template="/frontofficeRequestType/step" /> 
      </div>
      
      <div  class="steps">
      <ul>

  
        <li class="${currentStep == 'address' ? 'current ' : ''}
          
            ${individual ? rqt.stepStates['address-' + params.type].state : rqt.stepStates['address'].state}
          
          ">
          <span class="number">1</span>
          <a
            <g:if test="${currentStep != 'address' && rqt.stepStates['address'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'address'])}"
            </g:if>
          >
            
              <g:message code="${individual ? 'homeFolder.action.add' + org.apache.commons.lang.StringUtils.capitalize(params.type) : 'ancr.step.address.label'}" />
              ${individual ? '' : '*'}
              <span class="help">
                <g:message code="request.step.message.${rqt.stepStates['address' + (individual ? '-' + params.type : '')].state}" />
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'cadastre' ? 'current ' : ''}
          
            ${rqt.stepStates['cadastre'].state}
          
          ">
          <span class="number">2</span>
          <a
            <g:if test="${currentStep != 'cadastre' && rqt.stepStates['cadastre'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'cadastre'])}"
            </g:if>
          >
            
              <g:message code="ancr.step.cadastre.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['cadastre'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'validation' ? 'current ' : ''}
          
            ${rqt.stepStates['validation'].state}
          
          ">
          <span class="number"></span>
          <a
            <g:if test="${currentStep != 'validation' && rqt.stepStates['validation'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'validation'])}"
            </g:if>
          >
            
              <g:message code="request.step.validation.label" /> *
              <span class="help">
                
                <g:if test="${rqt.stepStates.validation.state == 'unavailable'}">
                  <g:message code="request.step.validation.allRequiredSteps" />
                </g:if>
                <g:else>
                  <g:message code="request.step.message.${rqt.stepStates['validation'].state}" />
                </g:else>
                
              </span>
            
          </a>
        </li>    
  

		 </ul>
	  </div>
  </div>

  </body>
</html>
