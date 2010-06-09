


  
    <label class="required"><g:message code="mcr.property.japdExemption.label" /> *  <span><g:message code="mcr.property.japdExemption.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['exemption'].invalidFields.contains('japdExemption') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="japdExemption_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="japdExemption" ${it == rqt.japdExemption ? 'checked="checked"': ''} />
                <label for="japdExemption_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class=""><g:message code="mcr.property.highlyInfirm.label" />   <span><g:message code="mcr.property.highlyInfirm.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['exemption'].invalidFields.contains('highlyInfirm') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="highlyInfirm_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="highlyInfirm" ${it == rqt.highlyInfirm ? 'checked="checked"': ''} />
                <label for="highlyInfirm_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class=""><g:message code="mcr.property.affectionOrDisease.label" />   <span><g:message code="mcr.property.affectionOrDisease.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['exemption'].invalidFields.contains('affectionOrDisease') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="affectionOrDisease_${it ? 'yes' : 'no'}" class="  validate-one-required boolean" title="" value="${it}" name="affectionOrDisease" ${it == rqt.affectionOrDisease ? 'checked="checked"': ''} />
                <label for="affectionOrDisease_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

