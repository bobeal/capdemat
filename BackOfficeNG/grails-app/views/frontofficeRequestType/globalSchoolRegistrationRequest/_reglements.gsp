


  
    
              <label class="required">
                <g:message code="gsrr.property.acceptationReglementInterieur.label" /> *
                <g:if test="${availableRules.contains('acceptationReglementInterieur')}">
                  <p><a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':rqt.requestType.label, 'filename':'acceptationReglementInterieur']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a></p>
                </g:if>
                <span><g:message code="gsrr.property.acceptationReglementInterieur.help" /></span>
              </label>
              <ul class="yes-no required ${rqt.stepStates['reglements'].invalidFields.contains('acceptationReglementInterieur') ? 'validation-failed' : ''}">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="acceptationReglementInterieur_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="acceptationReglementInterieur" ${it == rqt.acceptationReglementInterieur ? 'checked="checked"': ''} />
                    <label for="acceptationReglementInterieur_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

