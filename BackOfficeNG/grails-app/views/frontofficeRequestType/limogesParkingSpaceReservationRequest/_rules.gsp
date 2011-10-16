


  
    
              <label class="required">
                <g:message code="lpsrr.property.lpsrrRule.label" /> *
                <g:if test="${availableRules.contains('lpsrrRule')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'lpsrrRule']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="lpsrr.property.lpsrrRule.help" /></span>
              </label>
              <ul class="yes-no required ${rqt.stepStates['rules'].invalidFields.contains('lpsrrRule') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="lpsrrRule_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="lpsrrRule" ${it == rqt.lpsrrRule ? 'checked="checked"': ''} />
                    <label for="lpsrrRule_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

