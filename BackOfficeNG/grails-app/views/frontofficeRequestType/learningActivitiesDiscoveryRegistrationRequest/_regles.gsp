


  
    
              <label class="required">
                <g:message code="ladrr.property.reglement.label" /> *
                <g:if test="${availableRules.contains('reglement')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'reglement']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="ladrr.property.reglement.help" /></span>
              </label>
              <ul class="yes-no required ${stepStates != null && stepStates['regles']?.invalidFields.contains('reglement') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="reglement_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="reglement" ${it == rqt.reglement ? 'checked="checked"': ''} />
                    <label for="reglement_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

