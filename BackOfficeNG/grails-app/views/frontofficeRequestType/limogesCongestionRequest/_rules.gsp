


  
    
              <label class="required">
                <g:message code="lcr.property.lcrDuesAcceptance.label" /> *
                <g:if test="${availableRules.contains('lcrDuesAcceptance')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'lcrDuesAcceptance']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="lcr.property.lcrDuesAcceptance.help" /></span>
              </label>
              <ul class="yes-no required ${rqt.stepStates['rules'].invalidFields.contains('lcrDuesAcceptance') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="lcrDuesAcceptance_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="lcrDuesAcceptance" ${it == rqt.lcrDuesAcceptance ? 'checked="checked"': ''} />
                    <label for="lcrDuesAcceptance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

