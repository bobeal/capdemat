<g:if test="${currentStep == 'validation'}">
  <div id="validation">
   <form method="post" id="stepForm-validation" action="${createLink(action:'edit')}" class="${rqt.stepStates[currentStep]?.state}">
     <h3>
       ${message(code:'request.step.validation.label')}
       <span>${message(code:'request.step.validation.desc')}</span>
       <span class="error">${rqt.stepStates[currentStep]?.errorMsg}</span>
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
     <input type="submit" id="send" name="send" style=" float:right; font-size: 1.8em;" value="${message(code:'action.send')}" ${missingSteps == null || missingSteps.size() > 0 ? 'disabled="disabled"': ''}/>
     <input type="submit" id="previousStep" name="previousStep" value="${message(code:'request.action.previousStep')}" />
   </form>
   <g:if test="${helps.validation != null}">
   <div class="help">
     <h3>${message(code:'header.help')}</h3>
     ${helps.validation}
   </div>
   </g:if>
  </div>
</g:if>

<g:elseif test="${currentStep == 'document'}">
  <div id="document">
    <form method="post" enctype="multipart/form-data" action="${createLink(controller:'frontofficeRequest' + (documentType ? 'Document' : ''), action:'edit')}" class="${rqt.stepStates[currentStep].state}">
      <input type="hidden" name="returnUrl" value="${returnUrl}" />
      <input type="hidden" name="id" value="${rqt.id}" />
      <input type="hidden" name="currentStep" value="document" />
      <h3>
        ${message(code:'request.step.document.label')}
        <span>${message(code:'request.step.document.desc')}</span>
        <span class="error">${rqt.stepStates[currentStep]?.errorMsg}</span>
      </h3>
      <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
      <div>
        <g:render template="/frontofficeRequestType/${documentType ? 'document' : 'documents'}" />
      </div>
    </form>
    <g:if test="${helps.document != null}">
      <div class="help">
        <h3>${message(code:'header.help')}</h3>
        ${helps.document}
      </div>
    </g:if>
  </div>
</g:elseif>

<g:else>
  <div id="${currentStep}">
   <form method="post" id="stepForm-${currentStep}" action="${createLink(action:'edit')}" class="${rqt.stepStates[currentStep]?.state}">
     <h3>
        ${message(code: requestTypeAcronym + '.step.' + currentStep + '.label')}
       <span>${message(code: requestTypeAcronym + '.step.' + currentStep + '.desc')}</span>
       <span class="error">${rqt.stepStates[currentStep]?.errorMsg}</span>
     </h3>
     <p class="required-fields-notice">${message(code:'request.message.requiredFieldsNotice')}</p>
     <div>
      <g:render template="/frontofficeRequestType/${requestTypeLabelAsDir}/${currentStep}${currentCollection ? '-' + currentCollection : ''}" />
     </div>
     <div class="error" id="stepForm-${currentStep}-error"> </div>
     <input type="hidden" name="returnUrl" value="${returnUrl}" />
     <input type="hidden" name="id" value="${rqt.id}" />
     <input type="hidden" name="currentStep" value="${currentStep}" />
     <g:if test="${!currentCollection}">
       <input type="submit" id="nextStep" name="nextStep" style="float:right;" value="${message(code:'request.action.nextStep')}" />
       <g:if test="${!(rqt.stepStates.keySet().iterator().next() == currentStep)}">
         <input type="submit" id="previousStep" name="previousStep" value="${message(code:'request.action.previousStep')}" />
       </g:if>
     </g:if>
   </form>
   <g:if test="${helps[currentStep] != null}">
   <div class="help">
     <h3>${message(code:'header.help')}</h3>
     ${helps[currentStep]}
   </div>
   </g:if>
  </div>
</g:else>
