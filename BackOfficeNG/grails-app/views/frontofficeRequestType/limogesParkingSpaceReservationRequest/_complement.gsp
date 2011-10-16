


  
    <label class="required"><g:message code="lpsrr.property.footWay.label" /> *  <span><g:message code="lpsrr.property.footWay.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['complement'].invalidFields.contains('footWay') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="footWay_${it ? 'yes' : 'no'}" class="required condition-isFootWay-trigger  validate-one-required boolean" title="" value="${it}" name="footWay" ${it == rqt.footWay ? 'checked="checked"': ''} />
                <label for="footWay_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="vehiclesRegistration" class="required condition-isFootWay-filled"><g:message code="lpsrr.property.vehiclesRegistration.label" /> *  <span><g:message code="lpsrr.property.vehiclesRegistration.help" /></span></label>
            <input type="text" id="vehiclesRegistration" name="vehiclesRegistration" value="${rqt.vehiclesRegistration?.toString()}" 
                    class="required condition-isFootWay-filled  validate-string ${rqt.stepStates['complement'].invalidFields.contains('vehiclesRegistration') ? 'validation-failed' : ''}" title="<g:message code="lpsrr.property.vehiclesRegistration.validationError" />"   />
            

  

