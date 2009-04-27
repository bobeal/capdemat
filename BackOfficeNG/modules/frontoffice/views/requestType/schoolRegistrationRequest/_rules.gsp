


  
    <label class="required"><g:message code="srr.property.rulesAndRegulationsAcceptance.label" /> *  <span><g:message code="srr.property.rulesAndRegulationsAcceptance.help" /></span></label>
              <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsAcceptance'])}"><g:message code="action.consult" /></a>
              </g:if>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

