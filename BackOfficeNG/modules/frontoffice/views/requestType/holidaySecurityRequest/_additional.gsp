


  
    <label class="required"><g:message code="hsr.property.alarm.label" /> *  <span><g:message code="hsr.property.alarm.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-one-required" title="" value="${it}" name="alarm" ${it == rqt.alarm ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="hsr.property.light.label" /> *  <span><g:message code="hsr.property.light.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-one-required" title="" value="${it}" name="light" ${it == rqt.light ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

