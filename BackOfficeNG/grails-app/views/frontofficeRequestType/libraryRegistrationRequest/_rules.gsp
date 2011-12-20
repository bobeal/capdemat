


  
    
              <label class="">
                <g:message code="lrr.property.rulesAndRegulationsAcceptance.label" /> 
                <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'rulesAndRegulationsAcceptance']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="lrr.property.rulesAndRegulationsAcceptance.help" /></span>
              </label>
              <ul class="yes-no  ${rqt.stepStates['rules'].invalidFields.contains('rulesAndRegulationsAcceptance') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}" class="  " title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <label for="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="">
                <g:message code="lrr.property.parentalAuthorization.label" /> 
                <g:if test="${availableRules.contains('parentalAuthorization')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'parentalAuthorization']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="lrr.property.parentalAuthorization.help" /></span>
              </label>
              <ul class="yes-no  ${rqt.stepStates['rules'].invalidFields.contains('parentalAuthorization') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="parentalAuthorization_${it ? 'yes' : 'no'}" class="  " title="" value="${it}" name="parentalAuthorization" ${it == rqt.parentalAuthorization ? 'checked="checked"': ''} />
                    <label for="parentalAuthorization_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="">
                <g:message code="lrr.property.adultContentAuthorization.label" /> 
                <g:if test="${availableRules.contains('adultContentAuthorization')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'adultContentAuthorization']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="lrr.property.adultContentAuthorization.help" /></span>
              </label>
              <ul class="yes-no  ${rqt.stepStates['rules'].invalidFields.contains('adultContentAuthorization') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="adultContentAuthorization_${it ? 'yes' : 'no'}" class="  " title="" value="${it}" name="adultContentAuthorization" ${it == rqt.adultContentAuthorization ? 'checked="checked"': ''} />
                    <label for="adultContentAuthorization_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

