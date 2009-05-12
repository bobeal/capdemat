


  
    
              <label class="">
                <g:message code="msrr.property.rulesAndRegulationsAcceptance.label" /> 
                <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsAcceptance'])}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="msrr.property.rulesAndRegulationsAcceptance.help" /></span>
              </label>
              <ul class="yes-no ">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

