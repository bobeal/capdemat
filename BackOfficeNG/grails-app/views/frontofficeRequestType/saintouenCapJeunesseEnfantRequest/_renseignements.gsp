


  
    <label class="required"><g:message code="scjer.property.typeInscription.label" /> *  <span><g:message code="scjer.property.typeInscription.help" /></span></label>
            <ul class="required ${rqt.stepStates['renseignements'].invalidFields.contains('typeInscription') ? 'validation-failed' : ''}">
              <g:each in="${['PREMIERE_FOIS','RENOUVELLEMENT']}">
              <li>
                <input type="radio" id="typeInscription_${it}" class="required  validate-one-required" value="${it}" name="typeInscription" ${it == rqt.typeInscription.toString() ? 'checked="checked"': ''} title="<g:message code="scjer.property.typeInscription.validationError" />" />
                <label for="typeInscription_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjer.property.typeInscription" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="scjer.property.secteurHabitation.label" /> *  <span><g:message code="scjer.property.secteurHabitation.help" /></span></label>
            <g:set var="secteurHabitationIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'secteurHabitation', 'i18nPrefixCode':'scjer.property.secteurHabitation', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.secteurHabitation.entries, 'depth':0]" />
            

  

  
    <label for="typeEtablissementScolaireFrenquente" class="required"><g:message code="scjer.property.typeEtablissementScolaireFrenquente.label" /> *  <span><g:message code="scjer.property.typeEtablissementScolaireFrenquente.help" /></span></label>
            <select id="typeEtablissementScolaireFrenquente" name="typeEtablissementScolaireFrenquente" class="required condition-estEtablissementFrequenteCollege-trigger condition-estEtablissementFrequenteLycee-trigger condition-estEtablissementFrequenteAutre-trigger  validate-not-first ${rqt.stepStates['renseignements'].invalidFields.contains('typeEtablissementScolaireFrenquente') ? 'validation-failed' : ''}" title="<g:message code="scjer.property.typeEtablissementScolaireFrenquente.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['COLLEGE','LYCEE','AUTRE']}">
                <option value="${it}" ${it == rqt.typeEtablissementScolaireFrenquente?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjer.property.typeEtablissementScolaireFrenquente" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required condition-estEtablissementFrequenteCollege-filled"><g:message code="scjer.property.etablissementScolaireCollege.label" /> *  <span><g:message code="scjer.property.etablissementScolaireCollege.help" /></span></label>
            <g:set var="etablissementScolaireCollegeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'etablissementScolaireCollege', 'i18nPrefixCode':'scjer.property.etablissementScolaireCollege', 'htmlClass':'required condition-estEtablissementFrequenteCollege-filled  ', 
                              'lrEntries': lrTypes.etablissementScolaireCollege.entries, 'depth':0]" />
            

  

  
    <label class="required condition-estEtablissementFrequenteLycee-filled"><g:message code="scjer.property.etablissementScolaireLycee.label" /> *  <span><g:message code="scjer.property.etablissementScolaireLycee.help" /></span></label>
            <g:set var="etablissementScolaireLyceeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'etablissementScolaireLycee', 'i18nPrefixCode':'scjer.property.etablissementScolaireLycee', 'htmlClass':'required condition-estEtablissementFrequenteLycee-filled  ', 
                              'lrEntries': lrTypes.etablissementScolaireLycee.entries, 'depth':0]" />
            

  

  
    <label for="etablissementScolaireAutre" class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutre.label" /> *  <span><g:message code="scjer.property.etablissementScolaireAutre.help" /></span></label>
            <input type="text" id="etablissementScolaireAutre" name="etablissementScolaireAutre" value="${rqt.etablissementScolaireAutre?.toString()}" 
                    class="required condition-estEtablissementFrequenteAutre-filled  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutre') ? 'validation-failed' : ''}" title="<g:message code="scjer.property.etablissementScolaireAutre.validationError" />"   />
            

  

  
    <label for="etablissementScolaireAutreNom" class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutreNom.label" /> *  <span><g:message code="scjer.property.etablissementScolaireAutreNom.help" /></span></label>
            <input type="text" id="etablissementScolaireAutreNom" name="etablissementScolaireAutreNom" value="${rqt.etablissementScolaireAutreNom?.toString()}" 
                    class="required condition-estEtablissementFrequenteAutre-filled  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreNom') ? 'validation-failed' : ''}" title="<g:message code="scjer.property.etablissementScolaireAutreNom.validationError" />"   />
            

  

  
    <label class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutreAdresse.label" /> *  <span><g:message code="scjer.property.etablissementScolaireAutreAdresse.help" /></span></label>
            <div id="etablissementScolaireAutreAdresse" class="address required condition-estEtablissementFrequenteAutre-filled  ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse') ? 'validation-failed' : ''}">
            <label for="etablissementScolaireAutreAdresse.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.additionalDeliveryInformation}" maxlength="38" id="etablissementScolaireAutreAdresse.additionalDeliveryInformation" name="etablissementScolaireAutreAdresse.additionalDeliveryInformation" />  
            <label for="etablissementScolaireAutreAdresse.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.additionalGeographicalInformation}" maxlength="38" id="etablissementScolaireAutreAdresse.additionalGeographicalInformation" name="etablissementScolaireAutreAdresse.additionalGeographicalInformation" />
            <label for="etablissementScolaireAutreAdresse_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="etablissementScolaireAutreAdresse_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.streetNumber') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.streetNumber}" size="5" maxlength="5" id="etablissementScolaireAutreAdresse_streetNumber" name="etablissementScolaireAutreAdresse.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.streetName') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.streetName}" maxlength="32" id="etablissementScolaireAutreAdresse_streetName" name="etablissementScolaireAutreAdresse.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.etablissementScolaireAutreAdresse?.streetMatriculation}" id="etablissementScolaireAutreAdresse_streetMatriculation" name="etablissementScolaireAutreAdresse.streetMatriculation" />
            <input type="hidden" value="${rqt.etablissementScolaireAutreAdresse?.streetRivoliCode}" id="etablissementScolaireAutreAdresse_streetRivoliCode" name="etablissementScolaireAutreAdresse.streetRivoliCode" />
            <label for="etablissementScolaireAutreAdresse.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.placeNameOrService}" maxlength="38" id="etablissementScolaireAutreAdresse.placeNameOrService" name="etablissementScolaireAutreAdresse.placeNameOrService" />
            <label for="etablissementScolaireAutreAdresse_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="etablissementScolaireAutreAdresse_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.postalCode') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.postalCode}" size="5" maxlength="5" id="etablissementScolaireAutreAdresse_postalCode" name="etablissementScolaireAutreAdresse.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.city') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.city}" maxlength="32" id="etablissementScolaireAutreAdresse_city" name="etablissementScolaireAutreAdresse.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.etablissementScolaireAutreAdresse?.cityInseeCode}" id="etablissementScolaireAutreAdresse_cityInseeCode" name="etablissementScolaireAutreAdresse.cityInseeCode" />
            <label for="etablissementScolaireAutreAdresse.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse.countryName') ? 'validation-failed' : ''}" value="${rqt.etablissementScolaireAutreAdresse?.countryName}" maxlength="38" id="etablissementScolaireAutreAdresse.countryName" name="etablissementScolaireAutreAdresse.countryName" />
            </div>
            

  

