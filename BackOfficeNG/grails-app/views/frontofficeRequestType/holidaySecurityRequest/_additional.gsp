


  
    <label class="required"><g:message code="hsr.property.alarm.label" /> *  <span><g:message code="hsr.property.alarm.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['additional'].invalidFields.contains('alarm') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="alarm_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="alarm" ${it == rqt.alarm ? 'checked="checked"': ''} />
                <label for="alarm_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="hsr.property.light.label" /> *  <span><g:message code="hsr.property.light.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['additional'].invalidFields.contains('light') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="light_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="light" ${it == rqt.light ? 'checked="checked"': ''} />
                <label for="light_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

