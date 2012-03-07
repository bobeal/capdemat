


  
    <label class="required"><g:message code="gsrr.property.estRestauration.label" /> *  <span><g:message code="gsrr.property.estRestauration.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['restauration'].invalidFields.contains('estRestauration') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estRestauration_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="estRestauration" ${it == rqt.estRestauration ? 'checked="checked"': ''} />
                <label for="estRestauration_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

