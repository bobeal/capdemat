
<html>
  <head>
     <title>${message(code:'sagr.description')}</title>
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
        <g:message code="sagr.label" /> <g:message code="message.number" args="[rqt.id]" />
      </h2>
      <p><g:message code="request.duration.label" /><strong> : <g:message code="sagr.duration.value" /></strong></p>
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
         <g:set var="requestTypeAcronym" value="sagr" scope="request" />
         <g:render template="/frontofficeRequestType/step" /> 
      </div>
      
      <div  class="steps">
      <ul>

  
        <li class="${currentStep == 'association' ? 'current ' : ''}
          
            ${individual ? rqt.stepStates['association-' + params.type].state : rqt.stepStates['association'].state}
          
          ">
          <span class="number">1</span>
          <a
            <g:if test="${currentStep != 'association' && rqt.stepStates['association'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'association'])}"
            </g:if>
          >
            
              <g:message code="${individual ? 'homeFolder.action.add' + org.apache.commons.lang.StringUtils.capitalize(params.type) : 'sagr.step.association.label'}" />
              ${individual ? '' : '*'}
              <span class="help">
                <g:message code="request.step.message.${rqt.stepStates['association' + (individual ? '-' + params.type : '')].state}" />
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'president' ? 'current ' : ''}
          
            ${rqt.stepStates['president'].state}
          
          ">
          <span class="number">2</span>
          <a
            <g:if test="${currentStep != 'president' && rqt.stepStates['president'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'president'])}"
            </g:if>
          >
            
              <g:message code="sagr.step.president.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['president'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'bureau' ? 'current ' : ''}
          
            ${rqt.stepStates['bureau'].state}
          
          ">
          <span class="number">3</span>
          <a
            <g:if test="${currentStep != 'bureau' && rqt.stepStates['bureau'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'bureau'])}"
            </g:if>
          >
            
              <g:message code="sagr.step.bureau.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['bureau'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'activites' ? 'current ' : ''}
          
            ${rqt.stepStates['activites'].state}
          
          ">
          <span class="number">4</span>
          <a
            <g:if test="${currentStep != 'activites' && rqt.stepStates['activites'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'activites'])}"
            </g:if>
          >
            
              <g:message code="sagr.step.activites.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['activites'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <li class="${currentStep == 'subvention' ? 'current ' : ''}
          
            ${rqt.stepStates['subvention'].state}
          
          ">
          <span class="number">5</span>
          <a
            <g:if test="${currentStep != 'subvention' && rqt.stepStates['subvention'].state != 'unavailable'}">
              href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'subvention'])}"
            </g:if>
          >
            
              <g:message code="sagr.step.subvention.label" /> *
              <span class="help">
                
                  <g:message code="request.step.message.${rqt.stepStates['subvention'].state}" />
                
              </span>
            
          </a>
        </li>    
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
        <li class="${currentStep == 'document' ? 'current ' : ''}
          
            ${rqt.stepStates['document'].state}
          
          ">
          <span class="number">6</span>
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
