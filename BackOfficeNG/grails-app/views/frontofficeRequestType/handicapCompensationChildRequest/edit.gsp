
<html>
  <head>
     <title>${message(code:'hccr.description')}</title>
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
        <g:message code="hccr.label" />
      </h2>
      <p><g:message code="request.duration.label" /><strong> : <g:message code="hccr.duration.value" /></strong></p>
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
         <g:set var="requestTypeAcronym" value="hccr" scope="request" />
         <g:render template="/frontofficeRequestType/step" /> 
      </div>
      
      <div  class="steps">
      <ul>

  
        <li class="${currentStep == 'subject' ? 'current' : ''}
          
            ${individual ? rqt.stepStates['subject-' + params.type].state : rqt.stepStates['subject'].state}
          
          ">
          <span class="number">1</span>
          <a
            <g:if test="${currentStep != 'subject' && rqt.stepStates['subject'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'subject'])}"
            </g:if>
          >
            
              <g:message code="${individual ? 'homeFolder.action.add' + org.apache.commons.lang.StringUtils.capitalize(params.type) : 'hccr.step.subject.label'}" />
              ${individual ? '' : '*'}
              <span class="help">
                <g:message code="request.step.message.${rqt.stepStates['subject' + (individual ? '-' + params.type : '')].state}" />
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'dwelling' ? 'current' : ''}
          
            ${rqt.stepStates['dwelling'].state}
          
          ">
          <span class="number">2</span>
          <a
            <g:if test="${currentStep != 'dwelling' && rqt.stepStates['dwelling'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'dwelling'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.dwelling.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['dwelling'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'socialSecurityAndPaymentAgency' ? 'current' : ''}
          
            ${rqt.stepStates['socialSecurityAndPaymentAgency'].state}
          
          ">
          <span class="number">3</span>
          <a
            <g:if test="${currentStep != 'socialSecurityAndPaymentAgency' && rqt.stepStates['socialSecurityAndPaymentAgency'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'socialSecurityAndPaymentAgency'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.socialSecurityAndPaymentAgency.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['socialSecurityAndPaymentAgency'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'occupationnalAndSchoolStatus' ? 'current' : ''}
          
            ${rqt.stepStates['occupationnalAndSchoolStatus'].state}
          
          ">
          <span class="number">4</span>
          <a
            <g:if test="${currentStep != 'occupationnalAndSchoolStatus' && rqt.stepStates['occupationnalAndSchoolStatus'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'occupationnalAndSchoolStatus'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.occupationnalAndSchoolStatus.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['occupationnalAndSchoolStatus'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'folders' ? 'current' : ''}
          
            ${rqt.stepStates['folders'].state}
          
          ">
          <span class="number">5</span>
          <a
            <g:if test="${currentStep != 'folders' && rqt.stepStates['folders'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'folders'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.folders.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['folders'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'benefits' ? 'current' : ''}
          
            ${rqt.stepStates['benefits'].state}
          
          ">
          <span class="number">6</span>
          <a
            <g:if test="${currentStep != 'benefits' && rqt.stepStates['benefits'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'benefits'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.benefits.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['benefits'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'aid' ? 'current' : ''}
          
            ${rqt.stepStates['aid'].state}
          
          ">
          <span class="number">7</span>
          <a
            <g:if test="${currentStep != 'aid' && rqt.stepStates['aid'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'aid'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.aid.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['aid'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'health' ? 'current' : ''}
          
            ${rqt.stepStates['health'].state}
          
          ">
          <span class="number">8</span>
          <a
            <g:if test="${currentStep != 'health' && rqt.stepStates['health'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'health'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.health.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['health'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'project' ? 'current' : ''}
          
            ${rqt.stepStates['project'].state}
          
          ">
          <span class="number">9</span>
          <a
            <g:if test="${currentStep != 'project' && rqt.stepStates['project'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'project'])}"
            </g:if>
          >
            
              <g:message code="hccr.step.project.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['project'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
        <li class="${currentStep == 'document' ? 'current' : ''}
          
            ${rqt.stepStates['document'].state}
          
          ">
          <span class="number">10</span>
          <a
            <g:if test="${currentStep != 'document' && rqt.stepStates['document'].state != 'unavailable'}">
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
  

  
        <li class="${currentStep == 'validation' ? 'current' : ''}
          
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
