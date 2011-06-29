


  
    
              <label class="required">
                <g:message code="raprr.property.rulesAndRegulationsPolyAcceptance.label" /> *
                <g:if test="${availableRules.contains('rulesAndRegulationsPolyAcceptance')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsPolyAcceptance']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="raprr.property.rulesAndRegulationsPolyAcceptance.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['rules']?.invalidFields?.contains('rulesAndRegulationsPolyAcceptance') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="rulesAndRegulationsPolyAcceptance_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsPolyAcceptance" ${it == rqt.rulesAndRegulationsPolyAcceptance ? 'checked="checked"': ''} />
                    <label for="rulesAndRegulationsPolyAcceptance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="raprr.property.classTripPolyPermission.label" /> *
                <g:if test="${availableRules.contains('classTripPolyPermission')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'classTripPolyPermission']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="raprr.property.classTripPolyPermission.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['rules']?.invalidFields?.contains('classTripPolyPermission') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="classTripPolyPermission_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="classTripPolyPermission" ${it == rqt.classTripPolyPermission ? 'checked="checked"': ''} />
                    <label for="classTripPolyPermission_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="raprr.property.childPhotoExploitationPolyPermission.label" /> *
                <g:if test="${availableRules.contains('childPhotoExploitationPolyPermission')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'childPhotoExploitationPolyPermission']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="raprr.property.childPhotoExploitationPolyPermission.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['rules']?.invalidFields?.contains('childPhotoExploitationPolyPermission') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="childPhotoExploitationPolyPermission_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="childPhotoExploitationPolyPermission" ${it == rqt.childPhotoExploitationPolyPermission ? 'checked="checked"': ''} />
                    <label for="childPhotoExploitationPolyPermission_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="raprr.property.hospitalizationPolyPermission.label" /> *
                <g:if test="${availableRules.contains('hospitalizationPolyPermission')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'hospitalizationPolyPermission']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="raprr.property.hospitalizationPolyPermission.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['rules']?.invalidFields?.contains('hospitalizationPolyPermission') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="hospitalizationPolyPermission_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="hospitalizationPolyPermission" ${it == rqt.hospitalizationPolyPermission ? 'checked="checked"': ''} />
                    <label for="hospitalizationPolyPermission_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

