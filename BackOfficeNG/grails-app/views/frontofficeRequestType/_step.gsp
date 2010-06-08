<g:if test="${currentStep == 'validation'}">
  <div id="validation">
   <form method="post"  id="stepForm-validation" action="<g:createLink action="edit" />">
     <input type="hidden" name="returnUrl" value="${returnUrl}" />
     <h3>
       <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}">${message(code:(stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'))}</span>
       <span class="tag-state tag-required">${message(code:'request.step.required')}</span>
       ${message(code:'request.step.validation.label')}
       <span>${message(code:'request.step.validation.desc')}</span>
       <span class="error">${stepStates?.validation?.errorMsg}</span>
     </h3>
     <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
     <div>
       <g:if test="${meansOfContact.size() > 0}">
        <label for="meansOfContact" class="required">
         ${message(code:'request.meansOfContact.chooseMessage')} *
        </label>
        <select id="meansOfContact" name="meansOfContact" class="required">
         <g:each in="${meansOfContact}" var="moc">
           <option value="${moc.key}" <g:if test="${rqt.meansOfContact?.type == moc.key}">selected="selected"</g:if>${moc.label}</option>
         </g:each>
        </select>
       </g:if>
       <g:else>
         <p>${message(code:'request.meansOfContact.message.notAvailable')}</p>
       </g:else>
       <div class="summary-box">
      <g:render template="/frontofficeRequestType/${requestTypeLabelAsDir}/validation0" />
      </div>
      <h3>${message(code:'request.step.note.label')}</h3>
      <label for="requestNote">${message(code:'request.step.note.desc')}</label>
      <textarea id="requestNote" name="requestNote" rows="" cols="">${params.requestNote}</textarea>
      <label><span id="requestNoteLimit"></span></label>
      <h3>${message(code:'request.step.validation.label')}</h3>
      <g:if test="${!hasHomeFolder}">
        <g:render template="/frontofficeRequestType/outOfAccountValidation" />
      </g:if>
      <div id="useAcceptance">
        <input type="checkbox" name="useAcceptance" class="required validate-one-required"
              title="${message(code:'request.error.useAcceptanceRequired')}" />
        <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'use')}" target="blank">
         ${message(code:'request.step.validation.useAcceptance')}
        </a>
      </div>
     </div>
     <div class="error" id="stepForm-validation-error"> </div>
     <!-- Input submit-->
     <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
     <input type="hidden" name="id" value="${rqt.id}" />
     <g:if test="${missingSteps == null}">
       <div><strong>${message(code:'request.step.validation.allRequiredSteps')}</strong></div>
     </g:if>
     <g:elseif test="${missingSteps.size() > 0}">
       <div>
         <strong>${message(code:'request.step.validation.requiredSteps')}</strong>
         <ul>
           <g:each var="missingStep" in="${missingSteps}">
             <li>
               <a id="active-tab-${missingStep}" href="#${missingStep}">
                 ${message(code:requestTypeAcronym + '.step.' + missingStep + '.label')}
               </a>
             </li>
           </g:each>
         </ul>
       </div>
     </g:elseif>
   </form>
   <g:if test="${helps.validation != null}">
   <div class="requestHelp">
     <h3>${message(code:'header.help')}</h3>
     ${helps.validation}
   </div>
   </g:if>
  </div>
</g:if>

<g:elseif test="${currentStep == 'document'}">
  <div id="document">
   <form method="post" enctype="multipart/form-data" id="stepForm-document" action="<g:createLink action="edit" />">
     <input type="hidden" name="returnUrl" value="${returnUrl}" />
     <h3>
       <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}">${message(code:(stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'))}</span>
       ${message(code:'request.step.document.label')}
       <span>${message(code:'request.step.document.desc')}</span>
       <span class="error">${stepStates?.document?.errorMsg}</span>
     </h3>
     <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
     <div>
      <g:render template="/frontofficeRequestType/document" />
     </div>
     <div class="error" id="stepForm-document-error"> </div>
     <!-- Input submit-->
     <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
     <input type="hidden" name="id" value="${rqt.id}" />
   </form>
   <g:if test="${helps.document != null}">
   <div class="requestHelp">
     <h3>${message(code:'header.help')}</h3>
     ${helps.document}
   </div>
   </g:if>
  </div>
</g:elseif>

<g:else>
  <div id="${currentStep}">
   <form method="post"  id="stepForm-${currentStep}" action="<g:createLink action="edit" />">
     <input type="hidden" name="returnUrl" value="${returnUrl}" />
     <h3>
       <span class="tag-state ${stepStates != null ? stepStates[currentStep].cssClass : 'tag-pending'}">${message(code:(stepStates != null ? stepStates[currentStep].i18nKey : 'request.step.state.uncomplete'))}</span>
       <span class="tag-state tag-required">${message(code:'request.step.required')}</span>
       ${message(code: requestTypeAcronym + '.step.' + currentStep + '.label')}
       <span>${message(code: requestTypeAcronym + '.step.' + currentStep + '.desc')}</span>
       <span class="error">${stepStates != null ? stepStates[currentStep].errorMsg : ''}</span>
     </h3>
     <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
     <div>
      <g:render template="/frontofficeRequestType/${requestTypeLabelAsDir}/${currentStep}" />
     </div>
     <div class="error" id="stepForm-${currentStep}-error"> </div>
     <!-- Input submit-->
     <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
     <input type="hidden" name="id" value="${rqt.id}" />
     <input type="submit" id="submit-step-${currentStep}" name="submit-step-${currentStep}" class="submit-step" value="${message(code:'action.validate')}" />
   </form>
   <g:if test="${helps[currentStep] != null}">
   <div class="requestHelp">
     <h3>${message(code:'header.help')}</h3>
     ${helps[currentStep]}
   </div>
   </g:if>
  </div>
</g:else>
