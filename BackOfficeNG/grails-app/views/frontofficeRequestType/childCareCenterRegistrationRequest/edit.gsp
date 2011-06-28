
<html>
  <head>
     <title>${message(code:'cccrr.description')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'condition.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'autofill.js')}"></script>
    <g:if test="${customJS}">
      <script type="text/javascript" src="${resource(dir:customJS.dir,file:customJS.file)}"></script>
    </g:if>
  </head>  
  <body>
    <g:set var="requestTypeInfo">
      {"label": "${requestTypeLabel}"
        ,"steps": [  "registrationSubject-required",  "registrationParams-required",  "welcoming-required",  "document",  "validation-required"  ]
      }
    </g:set>
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" scope="request" />
    <form action="${createLink(controller:'frontofficeRequestCreation',action:'condition')}"
      method="post" id="conditionsForm">
      <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
      <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
    </form>
    <form action="${createLink(controller:'frontofficeRequestCreation',action:'autofill')}"
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
    
    <g:render template="/frontofficeRequestType/cancelPanel" />
    <g:if test="${session.currentEcitizen && !isEdition}">
      <g:render template="/frontofficeRequestType/draftPanel" />
    </g:if>
    
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" />
    
    <h2 class="request-creation"> <g:message code="cccrr.label" /></h2>
    <p><g:message code="cccrr.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="cccrr.duration.value" /></strong></p>
    <p>
      <g:message code="request.requiredDocuments.header" /> :
      <g:if test="${!documentTypes.isEmpty()}">
        <g:each in="${documentTypes}" var="documentType" status="index">
          <strong>${documentType.value.name}<g:if test="${index < documentTypes.size() - 1}">,</g:if></strong>
        </g:each>
      </g:if>
      <g:else>
        <g:message code="message.none" />
      </g:else>
    </p>

    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">

  
  
        <li class="${['registrationSubject', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  
          <a href="#registrationSubject"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.registrationSubject.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.registrationSubject.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="cccrr.step.registrationSubject.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'registrationParams' ? 'selected' : ''}">
  
          <a href="#registrationParams"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.registrationParams.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.registrationParams.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="cccrr.step.registrationParams.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'welcoming' ? 'selected' : ''}">
  
          <a href="#welcoming"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.welcoming.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.welcoming.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="cccrr.step.welcoming.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
    
        <li class="${currentStep == 'document' ? 'selected' : ''}">
  
          <a href="#document"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <g:message code="request.step.document.label" />
            
          </em></a>
        </li>    
  
        </g:if>
  

  
    
        <li class="${currentStep == 'validation' ? 'selected' : ''}">
  
          <a href="#validation"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="request.step.validation.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

		 </ul>
		 
     <div class="yui-content">

  
       <div id="registrationSubject">
         <form method="post"  id="stepForm-registrationSubject" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.registrationSubject.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.registrationSubject.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="cccrr.step.registrationSubject.label" />
             <span><g:message code="cccrr.step.registrationSubject.desc" /></span>
             <span class="error">${stepStates?.registrationSubject?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/childCareCenterRegistrationRequest/registrationSubject" />         
  
           </div>
           <div class="error" id="stepForm-registrationSubject-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-registrationSubject" name="submit-step-registrationSubject" class="submit-step" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.registrationSubject != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.registrationSubject}
         </div>
         </g:if>
       </div>  
  

  
       <div id="registrationParams">
         <form method="post"  id="stepForm-registrationParams" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.registrationParams.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.registrationParams.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="cccrr.step.registrationParams.label" />
             <span><g:message code="cccrr.step.registrationParams.desc" /></span>
             <span class="error">${stepStates?.registrationParams?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/childCareCenterRegistrationRequest/registrationParams" />         
  
           </div>
           <div class="error" id="stepForm-registrationParams-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-registrationParams" name="submit-step-registrationParams" class="submit-step" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.registrationParams != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.registrationParams}
         </div>
         </g:if>
       </div>  
  

  
       <div id="welcoming">
         <form method="post"  id="stepForm-welcoming" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.welcoming.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.welcoming.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="cccrr.step.welcoming.label" />
             <span><g:message code="cccrr.step.welcoming.desc" /></span>
             <span class="error">${stepStates?.welcoming?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/childCareCenterRegistrationRequest/welcoming" />         
  
           </div>
           <div class="error" id="stepForm-welcoming-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-welcoming" name="submit-step-welcoming" class="submit-step" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.welcoming != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.welcoming}
         </div>
         </g:if>
       </div>  
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
       <div id="document">
         <form method="post" enctype="multipart/form-data" id="stepForm-document" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <g:message code="request.step.document.label" />
             <span><g:message code="request.step.document.desc" /></span>
             <span class="error">${stepStates?.document?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/document" />         
  
           </div>
           <div class="error" id="stepForm-document-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
         </form>
         
         <g:if test="${helps.document != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.document}
         </div>
         </g:if>
       </div>  
  
        </g:if>
  

  
       <div id="validation">
         <form method="post"  id="stepForm-validation" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="request.step.validation.label" />
             <span><g:message code="request.step.validation.desc" /></span>
             <span class="error">${stepStates?.validation?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
             <g:if test="${meansOfContact.size() > 0}">
              <label for="meansOfContact" class="required">
               <g:message code="request.meansOfContact.chooseMessage"/> *
              </label>
              <select id="meansOfContact" name="meansOfContact" class="required ${stepStates != null && stepStates['validation']?.invalidFields?.contains('meansOfContact') ? 'validation-failed' : ''}">
               <g:each in="${meansOfContact}" var="moc">
                 <option value="${moc.key}" <g:if test="${rqt.meansOfContact?.type == moc.key}">selected="selected"</g:if>>${moc.label}</option>
               </g:each>
              </select>
             </g:if>
             <g:else>
               <p>${message(code:'request.meansOfContact.message.notAvailable')}</p>
             </g:else>
             <div class="summary-box">
    
            <g:render template="/frontofficeRequestType/childCareCenterRegistrationRequest/validation0" />
    
            </div>
            <h3><g:message code="request.step.note.label" /></h3>
            <label for="requestNote"><g:message code="request.step.note.desc" /></label>
            <textarea id="requestNote" name="requestNote" rows="" cols="">${params.requestNote}</textarea>
            <label><span id="requestNoteLimit"></span></label>
            <h3><g:message code="request.step.validation.label" /></h3>
            <g:if test="${!hasHomeFolder}">
              <g:render template="/frontofficeRequestType/outOfAccountValidation" />
            </g:if>
            <div id="useAcceptance" class="${stepStates != null && stepStates['validation']?.invalidFields?.contains('useAcceptance') ? 'validation-failed' : ''}">
             <input type="checkbox" name="useAcceptance" class="required validate-one-required"
                    title="${message(code:'request.error.useAcceptanceRequired')}" />
             <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'use')}" target="blank">
               <g:message code="request.step.validation.useAcceptance"/>
             </a>
           </div>
  
           </div>
           <div class="error" id="stepForm-validation-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <g:if test="${missingSteps == null}">
             <div><strong><g:message code="request.step.validation.allRequiredSteps"/></strong></div>
           </g:if>
           <g:elseif test="${missingSteps.size() > 0}">
             <div>
               <strong><g:message code="request.step.validation.requiredSteps"/></strong>
               <ul>
                 <g:each var="missingStep" in="${missingSteps}">
                   <li>
                     <a id="active-tab-${missingStep}" href="#${missingStep}">
                       <g:message code="cccrr.step.${missingStep}.label" />
                     </a>
                   </li>
                 </g:each>
               </ul>
             </div>
           </g:elseif>
           <input type="submit" id="submit-step-validation" name="submit-step-validation" class="submit-step" value="${message(code:'action.send')}" ${missingSteps == null || missingSteps.size() > 0 ? 'disabled="disabled"': ''}/>
  
         </form>
         
         <g:if test="${helps.validation != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.validation}
         </div>
         </g:if>
       </div>  
  
        
 	    </div><!-- end yui-content -->
    </div><!-- end requestTabView -->
  
  </body>
</html>
