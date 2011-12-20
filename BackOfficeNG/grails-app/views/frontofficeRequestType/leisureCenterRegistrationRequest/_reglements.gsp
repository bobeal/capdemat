


  
    
              <label class="">
                <g:message code="lcrr.property.acceptationReglementInterieur.label" /> 
                <g:if test="${availableRules.contains('acceptationReglementInterieur')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'acceptationReglementInterieur']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="lcrr.property.acceptationReglementInterieur.help" /></span>
              </label>
              <ul class="yes-no  ${rqt.stepStates['reglements'].invalidFields.contains('acceptationReglementInterieur') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="acceptationReglementInterieur_${it ? 'yes' : 'no'}" class="  " title="" value="${it}" name="acceptationReglementInterieur" ${it == rqt.acceptationReglementInterieur ? 'checked="checked"': ''} />
                    <label for="acceptationReglementInterieur_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

