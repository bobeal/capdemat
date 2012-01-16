


  
    <label for="choixTypeRendezVous" class="required"><g:message code="sdccrr.property.choixTypeRendezVous.label" /> *  <span><g:message code="sdccrr.property.choixTypeRendezVous.help" /></span></label>
            <select id="choixTypeRendezVous" name="choixTypeRendezVous" class="required  validate-not-first ${rqt.stepStates['rendezVous'].invalidFields.contains('choixTypeRendezVous') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.choixTypeRendezVous.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PHYSIQUE','TELEPHONIQUE']}">
                <option value="${it}" ${it == rqt.choixTypeRendezVous?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sdccrr.property.choixTypeRendezVous" /></option>
              </g:each>
            </select>
            

  

  
    <label for="telephoneContact" class="required"><g:message code="sdccrr.property.telephoneContact.label" /> *  <span><g:message code="sdccrr.property.telephoneContact.help" /></span></label>
            <input type="text" id="telephoneContact" name="telephoneContact" value="${rqt.telephoneContact?.toString()}" 
                    class="required  validate-phone ${rqt.stepStates['rendezVous'].invalidFields.contains('telephoneContact') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.telephoneContact.validationError" />"  maxlength="10" />
            

  

  
    <label class="required"><g:message code="sdccrr.property.plageHoraireContact.label" /> *  <span><g:message code="sdccrr.property.plageHoraireContact.help" /></span></label>
            <g:set var="plageHoraireContactIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'plageHoraireContact', 'i18nPrefixCode':'sdccrr.property.plageHoraireContact', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.plageHoraireContact.entries, 'depth':0]" />
            

  

  
    <label for="commentaireCitoyen" class=""><g:message code="sdccrr.property.commentaireCitoyen.label" />   <span><g:message code="sdccrr.property.commentaireCitoyen.help" /></span></label>
            <textarea id="commentaireCitoyen" name="commentaireCitoyen" class="  validate-textarea ${rqt.stepStates['rendezVous'].invalidFields.contains('commentaireCitoyen') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.commentaireCitoyen.validationError" />" rows="10" cols=""  maxlength="600">${rqt.commentaireCitoyen}</textarea>
            

  

