


  
    <label class="required"><g:message code="gsrr.property.estPeriscolaire.label" /> *  <span><g:message code="gsrr.property.estPeriscolaire.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['periscolaire'].invalidFields.contains('estPeriscolaire') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estPeriscolaire_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="estPeriscolaire" ${it == rqt.estPeriscolaire ? 'checked="checked"': ''} />
                <label for="estPeriscolaire_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

