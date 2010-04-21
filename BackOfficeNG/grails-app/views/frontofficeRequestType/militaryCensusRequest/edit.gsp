
<html>
  <head>
     <title>${message(code:'mcr.description')}</title>
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
        ,"steps": [  "census-required",  "parentage-required",  "situation-required",  "exemption",  "document",  "validation-required"  ]
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
    
    <h2 class="request-creation"> <g:message code="mcr.label" /></h2>
    <p><g:message code="mcr.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="mcr.duration.value" /></strong></p>
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

  
  
        <li class="${['census', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  
          <a href="#census"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.census.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.census.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="mcr.step.census.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'parentage' ? 'selected' : ''}">
  
          <a href="#parentage"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.parentage.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.parentage.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="mcr.step.parentage.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'situation' ? 'selected' : ''}">
  
          <a href="#situation"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.situation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.situation.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="mcr.step.situation.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'exemption' ? 'selected' : ''}">
  
          <a href="#exemption"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.exemption.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.exemption.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <g:message code="mcr.step.exemption.label" />
            
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

  
       <div id="census">
         <form method="post"  id="stepForm-census" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.census.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.census.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="mcr.step.census.label" />
             <span><g:message code="mcr.step.census.desc" /></span>
             <span class="error">${stepStates?.census?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/militaryCensusRequest/census" />         
  
           </div>
           <div class="error" id="stepForm-census-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-census" name="submit-step-census" class="submit-step" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.census != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.census}
         </div>
         </g:if>
       </div>  
  

  
       <div id="parentage">
         <form method="post"  id="stepForm-parentage" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.parentage.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.parentage.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="mcr.step.parentage.label" />
             <span><g:message code="mcr.step.parentage.desc" /></span>
             <span class="error">${stepStates?.parentage?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/militaryCensusRequest/parentage" />         
  
           </div>
           <div class="error" id="stepForm-parentage-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-parentage" name="submit-step-parentage" class="submit-step" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.parentage != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.parentage}
         </div>
         </g:if>
       </div>  
  

  
       <div id="situation">
         <form method="post"  id="stepForm-situation" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.situation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.situation.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="mcr.step.situation.label" />
             <span><g:message code="mcr.step.situation.desc" /></span>
             <span class="error">${stepStates?.situation?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/militaryCensusRequest/situation" />         
  
           </div>
           <div class="error" id="stepForm-situation-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-situation" name="submit-step-situation" class="submit-step" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.situation != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.situation}
         </div>
         </g:if>
       </div>  
  

  
       <div id="exemption">
         <form method="post"  id="stepForm-exemption" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.exemption.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.exemption.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <g:message code="mcr.step.exemption.label" />
             <span><g:message code="mcr.step.exemption.desc" /></span>
             <span class="error">${stepStates?.exemption?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/militaryCensusRequest/exemption" />         
  
           </div>
           <div class="error" id="stepForm-exemption-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-exemption" name="submit-step-exemption" class="submit-step" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.exemption != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.exemption}
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
              <select id="meansOfContact" name="meansOfContact" class="required">
               <g:each in="${meansOfContact}" var="moc">
                 <option value="${moc.key}" <g:if test="${rqt.meansOfContact?.type == moc.key}">selected="selected"</g:if>>${moc.label}</option>
               </g:each>
              </select>
             </g:if>
             <g:else>
               <p>${message(code:'request.meansOfContact.message.notAvailable')}</p>
             </g:else>
             <div class="summary-box">
    
            <g:render template="/frontofficeRequestType/militaryCensusRequest/validation0" />
    
            </div>
            <h3><g:message code="request.step.note.label" /></h3>
            <label for="requestNote"><g:message code="request.step.note.desc" /></label>
            <textarea id="requestNote" name="requestNote" rows="" cols="">${params.requestNote}</textarea>
            <label><span id="requestNoteLimit"></span></label>
            <h3><g:message code="request.step.validation.label" /></h3>
            <g:if test="${!hasHomeFolder}">
              <g:render template="/frontofficeRequestType/outOfAccountValidation" />
            </g:if>
            <div id="useAcceptance" class="${stepStates != null && stepStates['validation']?.invalidFields.contains('useAcceptance') ? 'validation-failed' : ''}">
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
                       <g:message code="mcr.step.${missingStep}.label" />
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
