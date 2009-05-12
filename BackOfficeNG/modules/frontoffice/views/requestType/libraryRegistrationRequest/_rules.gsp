


  
    
              <label class="required">
                <g:message code="lrr.property.rulesAndRegulationsAcceptance.label" /> *
                <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsAcceptance'])}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="lrr.property.rulesAndRegulationsAcceptance.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="lrr.property.parentalAuthorization.label" /> *
                <g:if test="${availableRules.contains('parentalAuthorization')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'parentalAuthorization'])}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="lrr.property.parentalAuthorization.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="parentalAuthorization" ${it == rqt.parentalAuthorization ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

