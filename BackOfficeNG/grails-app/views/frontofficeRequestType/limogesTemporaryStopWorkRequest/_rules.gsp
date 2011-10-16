


  
    
              <label class="required">
                <g:message code="ltswr.property.ltswrRule.label" /> *
                <g:if test="${availableRules.contains('ltswrRule')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'ltswrRule']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="ltswr.property.ltswrRule.help" /></span>
              </label>
              <ul class="yes-no required ${rqt.stepStates['rules'].invalidFields.contains('ltswrRule') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="ltswrRule_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="ltswrRule" ${it == rqt.ltswrRule ? 'checked="checked"': ''} />
                    <label for="ltswrRule_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

