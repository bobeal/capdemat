


  
    
              <label class="required">
                <g:message code="scrr.property.hospitalizationPermission.label" /> *
                <g:if test="${availableRules.contains('hospitalizationPermission')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'hospitalizationPermission']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="scrr.property.hospitalizationPermission.help" /></span>
              </label>
              <ul class="yes-no required ${rqt.stepStates['rules'].invalidFields.contains('hospitalizationPermission') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="hospitalizationPermission_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="hospitalizationPermission" ${it == rqt.hospitalizationPermission ? 'checked="checked"': ''} />
                    <label for="hospitalizationPermission_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="scrr.property.rulesAndRegulationsAcceptance.label" /> *
                <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'rulesAndRegulationsAcceptance']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="scrr.property.rulesAndRegulationsAcceptance.help" /></span>
              </label>
              <ul class="yes-no required ${rqt.stepStates['rules'].invalidFields.contains('rulesAndRegulationsAcceptance') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <label for="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

