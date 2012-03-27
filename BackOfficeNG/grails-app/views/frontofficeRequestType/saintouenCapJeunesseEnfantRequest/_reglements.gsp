


  
    
            <ul ${rqt.stepStates['reglements'].invalidFields.contains('autorisationMedicale') ? 'class="validation-failed"' : ''}>
              <li>
                <input type="hidden" name="_autorisationMedicale" /><!-- Grails 1.2.x convention to bind checkboxes. -->
                <input type="checkbox" id="autorisationMedicale" name="autorisationMedicale"
                       class="  "
                       title="${message(code:'scjer.property.autorisationMedicale.validationError')}"
                       ${rqt.autorisationMedicale ? 'checked="checked"' : ''} value="true" />
                <label for="autorisationMedicale" class="">
                  ${message(code:'scjer.property.autorisationMedicale.label')}
                  <g:if test="${availableRules.contains('autorisationMedicale')}">
                  <a target="_blank"
                     href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'autorisationMedicale']).encodeAsXML()}">
                    <span>${message(code:'request.action.consult.rules')}</span>
                  </a>
                  </g:if>
                  <span>${message(code:'scjer.property.autorisationMedicale.help')}</span>
                </label>
              </li>
            </ul>
            

  

  
    
            <ul ${rqt.stepStates['reglements'].invalidFields.contains('autorisationImage') ? 'class="validation-failed"' : ''}>
              <li>
                <input type="hidden" name="_autorisationImage" /><!-- Grails 1.2.x convention to bind checkboxes. -->
                <input type="checkbox" id="autorisationImage" name="autorisationImage"
                       class="  "
                       title="${message(code:'scjer.property.autorisationImage.validationError')}"
                       ${rqt.autorisationImage ? 'checked="checked"' : ''} value="true" />
                <label for="autorisationImage" class="">
                  ${message(code:'scjer.property.autorisationImage.label')}
                  <g:if test="${availableRules.contains('autorisationImage')}">
                  <a target="_blank"
                     href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'autorisationImage']).encodeAsXML()}">
                    <span>${message(code:'request.action.consult.rules')}</span>
                  </a>
                  </g:if>
                  <span>${message(code:'scjer.property.autorisationImage.help')}</span>
                </label>
              </li>
            </ul>
            

  

  
    
            <ul ${rqt.stepStates['reglements'].invalidFields.contains('acceptationReglement') ? 'class="validation-failed"' : ''}>
              <li>
                <input type="hidden" name="_acceptationReglement" /><!-- Grails 1.2.x convention to bind checkboxes. -->
                <input type="checkbox" id="acceptationReglement" name="acceptationReglement"
                       class="required  validate-acceptance"
                       title="${message(code:'scjer.property.acceptationReglement.validationError')}"
                       ${rqt.acceptationReglement ? 'checked="checked"' : ''} value="true" />
                <label for="acceptationReglement" class="required">
                  ${message(code:'scjer.property.acceptationReglement.label')}*
                  <g:if test="${availableRules.contains('acceptationReglement')}">
                  <a target="_blank"
                     href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'acceptationReglement']).encodeAsXML()}">
                    <span>${message(code:'request.action.consult.rules')}</span>
                  </a>
                  </g:if>
                  <span>${message(code:'scjer.property.acceptationReglement.help')}</span>
                </label>
              </li>
            </ul>
            

  

