


  
    
              <label class="required">
                <g:message code="lrr.property.rulesAndRegulationsAcceptance.label" /> *
                <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsAcceptance']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="lrr.property.rulesAndRegulationsAcceptance.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['rules']?.invalidFields?.contains('rulesAndRegulationsAcceptance') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <label for="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="lrr.property.parentalAuthorization.label" /> *
                <g:if test="${availableRules.contains('parentalAuthorization')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'parentalAuthorization']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="lrr.property.parentalAuthorization.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['rules']?.invalidFields?.contains('parentalAuthorization') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="parentalAuthorization_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="parentalAuthorization" ${it == rqt.parentalAuthorization ? 'checked="checked"': ''} />
                    <label for="parentalAuthorization_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="lrr.property.adultContentAuthorization.label" /> *
                <g:if test="${availableRules.contains('adultContentAuthorization')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'adultContentAuthorization']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="lrr.property.adultContentAuthorization.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['rules']?.invalidFields?.contains('adultContentAuthorization') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="adultContentAuthorization_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="adultContentAuthorization" ${it == rqt.adultContentAuthorization ? 'checked="checked"': ''} />
                    <label for="adultContentAuthorization_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

