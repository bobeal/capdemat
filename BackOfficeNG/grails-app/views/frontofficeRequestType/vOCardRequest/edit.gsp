<html>
  <head>
    <title>${message(code:requestTypeLabel == 'VO Card' ? 'vcr.description' : 'homeFolder.title.admin')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'request.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'account.css')}" />
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice',file:'condition.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/frontoffice/requesttype',file:'vOCardRequest.js')}"></script>
  </head>
  <body>
    <g:set var="requestTypeInfo">
      {"label": "${requestTypeLabel}"
	  ,"steps": [  "adults-required", "children", "foreignAdults", "account-required", "document", "validation"  ]
	  }
    </g:set>
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" scope="request" />
    <form action="${createLink(controller:'frontofficeRequestCreation',action:'condition')}"
      method="post" id="conditionsForm">
      <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
      <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
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
	<g:render template="/frontofficeRequestType/cancelPanel" />
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" />
    
	<h2 class="request-creation"> <g:translateRequestTypeLabel label="${requestTypeLabel}"/></h2>
    <p><g:message code="request.duration.label" /><strong> : <g:message code="vcr.duration.value" /></strong></p>
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
        <li class="${['adults', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  
          <a href="#adults"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.adults.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.adults.i18nKey : 'request.step.state.uncomplete'}" /></span>
          <strong>
            <g:if test="${displayChildrenInAccountCreation}">
              <g:message code="vcr.step.adults.label" /> *
            </g:if>
            <g:else>
              <g:message code="vcr.step.members.label" /> *
            </g:else>
          </strong>
          </em></a>
        </li>

        <g:if test="${displayChildrenInAccountCreation}">
        <li class="${currentStep == 'children' ? 'selected' : ''}">
          <a href="#children"><em>
            <span class="tag-state ${stepStates!= null ? stepStates.children.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.children.i18nKey : 'request.step.state.uncomplete'}" /></span>
            <span><g:message code="vcr.step.children.label" /></span>
          </em></a>
        </li>
        </g:if>
        
        <g:if test="${displayTutorsInAccountCreation && displayChildrenInAccountCreation}">
        <li class="${currentStep == 'foreignAdults' ? 'selected' : ''}">
          <a href="#foreignAdults"><em>
            <span class="tag-state ${stepStates!= null ? stepStates.foreignAdults.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.foreignAdults.i18nKey : 'request.step.state.uncomplete'}" /></span>
            <span><g:message code="vcr.step.foreignAdults.label" /></span>
          </em></a>
        </li>
        </g:if>
        
        <li class="${currentStep == 'account' ? 'selected' : ''}">
          <a href="#account"><em>
            <span class="tag-state ${stepStates!= null ? stepStates.account.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.account.i18nKey : 'request.step.state.uncomplete'}" /></span>
            <strong><g:message code="vcr.step.account.label" /> *</strong>
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
          <strong><g:message code="request.step.validation.label" /> *</strong>
          </em></a>
        </li>
	  </ul>
		 
     <div class="yui-content">

       <div id="adults">
         <form method="post"  id="stepForm-adults" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.adults.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.adults.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="vcr.step.adults.label" />
             <span><g:message code="vcr.step.adults.desc" /></span>
             <span class="error">${stepStates?.adults?.errorMsg}</span>
           </h3>
           <div class="requestManual">
               <g:message code="vcr.manual.addAdult" />
           </div>
           <div>
         	   <g:render template="/frontofficeRequestType/vOCardRequest/adults" />
           </div>
           <div class="requestManual">
               <g:message code="vcr.manual.validationAdult" />
           </div>

           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
           <input type="submit" id="submit-step-adults" class="submit-step" name="submit-step-adults" value="${message(code:'action.validate')}" />
  
         </form>
         
         <g:if test="${helps.adults != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.adults}
         </div>
         </g:if>
       </div>  
       
       <g:if test="${displayChildrenInAccountCreation}">
       <div id="children">
         <form method="post"  id="stepForm-children" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.children.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.children.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <g:message code="vcr.step.children.label" />
             <span><g:message code="vcr.step.children.desc" /></span>
             <span class="error">${stepStates?.children?.errorMsg}</span>
           </h3>
           <div class="requestManual">
               <g:message code="vcr.manual.addChildren" />
           </div>
           <div>
         	   <g:render template="/frontofficeRequestType/vOCardRequest/children" />
           </div>
           <div class="requestManual">
               <g:message code="vcr.manual.validationChildren" />
           </div>

           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
           <input type="submit" id="submit-step-children" class="submit-step" name="submit-step-children" value="${message(code:'action.validate')}" />
         
         </form>
         
         <g:if test="${helps.children != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.children}
         </div>
         </g:if>
       </div>
       </g:if>
       
       <g:if test="${displayTutorsInAccountCreation && displayChildrenInAccountCreation}">
       <div id="foreignAdults">
         <form method="post"  id="stepForm-foreignAdults" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.foreignAdults.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.foreignAdults.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="vcr.step.foreignAdults.label" />
             <span><g:message code="vcr.step.foreignAdults.desc" /></span>
             <span class="error">${stepStates?.adults?.errorMsg}</span>
           </h3>
           <div class="requestManual">
               <g:message code="vcr.manual.addForeignAdult" />
           </div>
           <div>
         	   <g:render template="/frontofficeRequestType/vOCardRequest/foreignAdults" />
           </div>
           <div class="requestManual">
               <g:message code="vcr.manual.validationForeignAdult" />
           </div>

           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
           <input type="submit" id="submit-step-foreignAdults" class="submit-step" name="submit-step-foreignAdults" value="${message(code:'action.validate')}" />
  
         </form>
        
         <g:if test="${helps.foreignAdults != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.foreignAdults}
         </div>
         </g:if>
       </div> 
       </g:if>
       
       <div id="account">
         <form method="post"  id="stepForm-account" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.account.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.account.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="vcr.step.account.label" />
             <span>
               <g:if test="${displayTutorsInAccountCreation}">
                 <g:message code="vcr.step.account.desc" />
               </g:if>
               <g:else>
                 <g:message code="vcr.step.accountWithoutTutors.desc" />
               </g:else>
             </span>
             <span class="error">${stepStates?.account?.errorMsg}</span>
           </h3>
           <div>
         	   <g:render template="/frontofficeRequestType/vOCardRequest/account" /> 
           </div>
           <div class="error" id="stepForm-account-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
           <input type="submit" id="submit-step-account" class="submit-step" name="submit-step-account" value="${message(code:'action.validate')}" />
         </form>
         
         <g:if test="${helps.account != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.account}
         </div>
         </g:if>
       </div>

       <g:if test="${!documentTypes.isEmpty()}">
       <div id="document">
         <form method="post" enctype="multipart/form-data" id="stepForm-document" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>

             <g:message code="request.step.document.label" />
             <span><g:message code="request.step.document.desc" /></span>
             <span class="error">${stepStates?.document?.errorMsg}</span>
           </h3>
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
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="request.step.validation.label" />
             <span><g:message code="request.step.validation.desc" /></span>
             <span class="error">${stepStates?.validation?.errorMsg}</span>
           </h3>
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
             <g:render template="/frontofficeRequestType/vOCardRequest/validation" />
           </div>
            <h3><g:message code="request.step.note.label" /></h3>
            <label for="requestNote"><g:message code="request.step.note.desc" /></label>
            <textarea id="requestNote" name="requestNote" rows="" cols="">${params.requestNote}</textarea>
            <label><span id="requestNoteLimit"></span></label>
			      <h3><g:message code="request.step.validation.label" /></h3>
            <g:if test="${!hasHomeFolder || homeFolderResponsible.password == null}">
              <g:render template="/frontofficeRequestType/outOfAccountValidation" />
            </g:if>
            
            <div id="useAcceptance">
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
                       <g:message code="vcr.step.${missingStep}.label" />
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
