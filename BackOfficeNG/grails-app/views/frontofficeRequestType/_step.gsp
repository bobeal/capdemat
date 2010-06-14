<g:if test="${currentStep == 'validation'}">
  <div id="validation">
   <form method="post"  id="stepForm-validation" action="<g:createLink action="edit" />">
     <h3>
       <span class="tag-state tag-${rqt.stepStates.validation.state}">${message(code:("request.step.state." + rqt.stepStates.validation.state))}</span>
       <span class="tag-state tag-required">${message(code:'request.step.required')}</span>
       ${message(code:'request.step.validation.label')}
       <span>${message(code:'request.step.validation.desc')}</span>
       <span class="error">${rqt.stepStates.validation.errorMsg}</span>
     </h3>
     <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
     <div>
       <g:if test="${meansOfContact.size() > 0}">
        <label for="meansOfContact" class="required">
         ${message(code:'request.meansOfContact.chooseMessage')} *
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
      <div id="useAcceptance" class="${rqt.stepStates['validation'].invalidFields.contains('useAcceptance') ? 'validation-failed' : ''}">
        <input type="checkbox" name="useAcceptance" class="required validate-one-required"
              title="${message(code:'request.error.useAcceptanceRequired')}" />
        <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'use')}" target="blank">
         ${message(code:'request.step.validation.useAcceptance')}
        </a>
      </div>
     </div>
     <div class="error" id="stepForm-validation-error"> </div>
     <g:if test="${missingSteps == null}">
       <div><strong>${message(code:'request.step.validation.allRequiredSteps')}</strong></div>
     </g:if>
     <g:elseif test="${missingSteps.size() > 0}">
       <div>
         <strong>${message(code:'request.step.validation.requiredSteps')}</strong>
         <ul>
           <g:each var="missingStep" in="${missingSteps}">
             <li>
               <a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':missingStep])}">
                 ${message(code:requestTypeAcronym + '.step.' + missingStep + '.label')}
               </a>
             </li>
           </g:each>
         </ul>
       </div>
     </g:elseif>
     <input type="hidden" name="returnUrl" value="${returnUrl}" />
     <input type="hidden" name="id" value="${rqt.id}" />
     <input type="hidden" name="currentStep" value="validation" />
     <input type="submit" id="submit-step-validation" name="submit-step-validation" class="submit-step" value="${message(code:'action.send')}" ${missingSteps == null || missingSteps.size() > 0 ? 'disabled="disabled"': ''}/>
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
    <form method="post" enctype="multipart/form-data" action="${createLink(controller:'frontofficeRequestDocument', action:'edit')}">
      <input type="hidden" name="returnUrl" value="${returnUrl}" />
      <input type="hidden" name="id" value="${rqt.id}" />
      <input type="hidden" name="currentStep" value="document" />
      <h3>
        <span class="tag-state tag-${rqt.stepStates.document.state}">${message(code:("request.step.state." + rqt.stepStates.document.state))}</span>
        ${message(code:'request.step.document.label')}
        <span>${message(code:'request.step.document.desc')}</span>
        <span class="error">${rqt.stepStates.document.errorMsg}</span>
      </h3>
      <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
      <div>
        <g:render template="/frontofficeRequestType/${documentType ? 'document' : 'documents'}" />
      </div>
      <div class="error" id="stepForm-document-error"> </div>
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
     <h3>
       <span class="tag-state tag-${rqt.stepStates[currentStep].state}">${message(code:("request.step.state." + rqt.stepStates[currentStep].state))}</span>
       <span class="tag-state tag-required">${message(code:'request.step.required')}</span>
       ${message(code: requestTypeAcronym + '.step.' + currentStep + '.label')}
       <span>${message(code: requestTypeAcronym + '.step.' + currentStep + '.desc')}</span>
       <span class="error">${rqt.stepStates[currentStep].errorMsg}</span>
     </h3>
     <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
     <div>
      <g:render template="/frontofficeRequestType/${requestTypeLabelAsDir}/${currentStep}${currentCollection ? '-' + currentCollection : ''}" />
     </div>
     <div class="error" id="stepForm-${currentStep}-error"> </div>
     <input type="hidden" name="returnUrl" value="${returnUrl}" />
     <input type="hidden" name="id" value="${rqt.id}" />
     <input type="hidden" name="currentStep" value="${currentStep}" />
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
