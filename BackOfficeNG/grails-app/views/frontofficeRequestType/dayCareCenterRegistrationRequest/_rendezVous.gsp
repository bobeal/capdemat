


  
    <label for="choixTypeRendezVous" class="required"><g:message code="dccrr.property.choixTypeRendezVous.label" /> *  <span><g:message code="dccrr.property.choixTypeRendezVous.help" /></span></label>
            <select id="choixTypeRendezVous" name="choixTypeRendezVous" class="required  validate-not-first ${stepStates != null && stepStates['rendezVous']?.invalidFields?.contains('choixTypeRendezVous') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.choixTypeRendezVous.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Physique','Telephonique']}">
                <option value="fr.cg95.cvq.business.request.school.RendezVousType_${it}" ${it == rqt.choixTypeRendezVous?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.choixTypeRendezVous" /></option>
              </g:each>
            </select>
            

  

  
    <label for="telephoneContact" class="required"><g:message code="dccrr.property.telephoneContact.label" /> *  <span><g:message code="dccrr.property.telephoneContact.help" /></span></label>
            <input type="text" id="telephoneContact" name="telephoneContact" value="${rqt.telephoneContact?.toString()}" 
                    class="required  validate-phone ${stepStates != null && stepStates['rendezVous']?.invalidFields?.contains('telephoneContact') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.telephoneContact.validationError" />"  maxlength="10" />
            

  

  
    <label for="plageHoraireContact" class="required"><g:message code="dccrr.property.plageHoraireContact.label" /> *  <span><g:message code="dccrr.property.plageHoraireContact.help" /></span></label>
            <select id="plageHoraireContact" name="plageHoraireContact" class="required  validate-not-first ${stepStates != null && stepStates['rendezVous']?.invalidFields?.contains('plageHoraireContact') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.plageHoraireContact.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Matin','Aprem','Soir','Indifferent']}">
                <option value="fr.cg95.cvq.business.request.school.PlageHoraireContactType_${it}" ${it == rqt.plageHoraireContact?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.plageHoraireContact" /></option>
              </g:each>
            </select>
            

  

  
    <label for="commentaireCitoyen" class=""><g:message code="dccrr.property.commentaireCitoyen.label" />   <span><g:message code="dccrr.property.commentaireCitoyen.help" /></span></label>
            <textarea id="commentaireCitoyen" name="commentaireCitoyen" class="  validate-textarea ${stepStates != null && stepStates['rendezVous']?.invalidFields?.contains('commentaireCitoyen') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.commentaireCitoyen.validationError" />" rows="10" cols=""  maxlength="600">${rqt.commentaireCitoyen}</textarea>
            

  

