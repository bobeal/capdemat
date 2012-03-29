


  
    <label class="required"><g:message code="scjar.property.typeInscription.label" /> *  <span><g:message code="scjar.property.typeInscription.help" /></span></label>
            <ul class="required ${rqt.stepStates['renseignements'].invalidFields.contains('typeInscription') ? 'validation-failed' : ''}">
              <g:each in="${['PREMIERE_FOIS','RENOUVELLEMENT']}">
              <li>
                <input type="radio" id="typeInscription_${it}" class="required  validate-one-required" value="${it}" name="typeInscription" ${it == rqt.typeInscription.toString() ? 'checked="checked"': ''} title="<g:message code="scjar.property.typeInscription.validationError" />" />
                <label for="typeInscription_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjar.property.typeInscription" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="scjar.property.secteurHabitation.label" /> *  <span><g:message code="scjar.property.secteurHabitation.help" /></span></label>
            <g:set var="secteurHabitationIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'secteurHabitation', 'i18nPrefixCode':'scjar.property.secteurHabitation', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.secteurHabitation.entries, 'depth':0]" />
            

  

  
    <label for="situationActuelle" class="required"><g:message code="scjar.property.situationActuelle.label" /> *  <span><g:message code="scjar.property.situationActuelle.help" /></span></label>
            <select id="situationActuelle" name="situationActuelle" class="required condition-estEtudiant-trigger condition-estSalarie-trigger  validate-not-first ${rqt.stepStates['renseignements'].invalidFields.contains('situationActuelle') ? 'validation-failed' : ''}" title="<g:message code="scjar.property.situationActuelle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['ETUDIANT','SALARIE','SANS_EMPLOI']}">
                <option value="${it}" ${it == rqt.situationActuelle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjar.property.situationActuelle" /></option>
              </g:each>
            </select>
            

  

  
    <label for="etudiantTypeEtablissement" class="required condition-estEtudiant-filled"><g:message code="scjar.property.etudiantTypeEtablissement.label" /> *  <span><g:message code="scjar.property.etudiantTypeEtablissement.help" /></span></label>
            <select id="etudiantTypeEtablissement" name="etudiantTypeEtablissement" class="required condition-estEtudiant-filled condition-estEtablissementAutre-trigger  validate-not-first ${rqt.stepStates['renseignements'].invalidFields.contains('etudiantTypeEtablissement') ? 'validation-failed' : ''}" title="<g:message code="scjar.property.etudiantTypeEtablissement.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['LYCEE','FAC','BTS','AUTRE']}">
                <option value="${it}" ${it == rqt.etudiantTypeEtablissement?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjar.property.etudiantTypeEtablissement" /></option>
              </g:each>
            </select>
            

  

  
    <fieldset class="required condition-estEtablissementAutre-filled">
    <legend><g:message code="scjar.property.etablissementScolaireAutre.label" /></legend>
    
      <label for="precisionEtablissementScolaireAutre" class="required"><g:message code="scjar.property.precisionEtablissementScolaireAutre.label" /> *  <span><g:message code="scjar.property.precisionEtablissementScolaireAutre.help" /></span></label>
            <input type="text" id="precisionEtablissementScolaireAutre" name="precisionEtablissementScolaireAutre" value="${rqt.precisionEtablissementScolaireAutre?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('precisionEtablissementScolaireAutre') ? 'validation-failed' : ''}" title="<g:message code="scjar.property.precisionEtablissementScolaireAutre.validationError" />"   />
            

    
      <label for="nomEtablissementScolaireAutre" class="required"><g:message code="scjar.property.nomEtablissementScolaireAutre.label" /> *  <span><g:message code="scjar.property.nomEtablissementScolaireAutre.help" /></span></label>
            <input type="text" id="nomEtablissementScolaireAutre" name="nomEtablissementScolaireAutre" value="${rqt.nomEtablissementScolaireAutre?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('nomEtablissementScolaireAutre') ? 'validation-failed' : ''}" title="<g:message code="scjar.property.nomEtablissementScolaireAutre.validationError" />"   />
            

    
      <label class="required"><g:message code="scjar.property.adresseEtablissementScolaireAutre.label" /> *  <span><g:message code="scjar.property.adresseEtablissementScolaireAutre.help" /></span></label>
            <div id="adresseEtablissementScolaireAutre" class="address required  ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre') ? 'validation-failed' : ''}">
            <label for="adresseEtablissementScolaireAutre.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.additionalDeliveryInformation}" maxlength="38" id="adresseEtablissementScolaireAutre.additionalDeliveryInformation" name="adresseEtablissementScolaireAutre.additionalDeliveryInformation" />  
            <label for="adresseEtablissementScolaireAutre.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.additionalGeographicalInformation}" maxlength="38" id="adresseEtablissementScolaireAutre.additionalGeographicalInformation" name="adresseEtablissementScolaireAutre.additionalGeographicalInformation" />
            <label for="adresseEtablissementScolaireAutre_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="adresseEtablissementScolaireAutre_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.streetNumber') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.streetNumber}" size="5" maxlength="5" id="adresseEtablissementScolaireAutre_streetNumber" name="adresseEtablissementScolaireAutre.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.streetName') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.streetName}" maxlength="32" id="adresseEtablissementScolaireAutre_streetName" name="adresseEtablissementScolaireAutre.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.adresseEtablissementScolaireAutre?.streetMatriculation}" id="adresseEtablissementScolaireAutre_streetMatriculation" name="adresseEtablissementScolaireAutre.streetMatriculation" />
            <input type="hidden" value="${rqt.adresseEtablissementScolaireAutre?.streetRivoliCode}" id="adresseEtablissementScolaireAutre_streetRivoliCode" name="adresseEtablissementScolaireAutre.streetRivoliCode" />
            <label for="adresseEtablissementScolaireAutre.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.placeNameOrService}" maxlength="38" id="adresseEtablissementScolaireAutre.placeNameOrService" name="adresseEtablissementScolaireAutre.placeNameOrService" />
            <label for="adresseEtablissementScolaireAutre_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="adresseEtablissementScolaireAutre_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.postalCode') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.postalCode}" size="5" maxlength="5" id="adresseEtablissementScolaireAutre_postalCode" name="adresseEtablissementScolaireAutre.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.city') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.city}" maxlength="32" id="adresseEtablissementScolaireAutre_city" name="adresseEtablissementScolaireAutre.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.adresseEtablissementScolaireAutre?.cityInseeCode}" id="adresseEtablissementScolaireAutre_cityInseeCode" name="adresseEtablissementScolaireAutre.cityInseeCode" />
            <label for="adresseEtablissementScolaireAutre.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['renseignements'].invalidFields.contains('adresseEtablissementScolaireAutre.countryName') ? 'validation-failed' : ''}" value="${rqt.adresseEtablissementScolaireAutre?.countryName}" maxlength="38" id="adresseEtablissementScolaireAutre.countryName" name="adresseEtablissementScolaireAutre.countryName" />
            </div>
            

    
    </fieldset>
  

  
    <label for="profession" class="required condition-estSalarie-filled"><g:message code="scjar.property.profession.label" /> *  <span><g:message code="scjar.property.profession.help" /></span></label>
            <input type="text" id="profession" name="profession" value="${rqt.profession?.toString()}" 
                    class="required condition-estSalarie-filled  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('profession') ? 'validation-failed' : ''}" title="<g:message code="scjar.property.profession.validationError" />"   />
            

  

  
    <label class="required"><g:message code="scjar.property.participeActivite.label" /> *  <span><g:message code="scjar.property.participeActivite.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['renseignements'].invalidFields.contains('participeActivite') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="participeActivite_${it ? 'yes' : 'no'}" class="required condition-participeActivite-trigger  validate-one-required boolean" title="" value="${it}" name="participeActivite" ${it == rqt.participeActivite ? 'checked="checked"': ''} />
                <label for="participeActivite_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-participeActivite-filled"><g:message code="scjar.property.typeActivite.label" /> *  <span><g:message code="scjar.property.typeActivite.help" /></span></label>
            <ul class="required condition-participeActivite-filled ${rqt.stepStates['renseignements'].invalidFields.contains('typeActivite') ? 'validation-failed' : ''}">
              <g:each in="${['ACCUEIL','ATELIER','PROJET']}">
              <li>
                <input type="radio" id="typeActivite_${it}" class="required condition-participeActivite-filled  validate-one-required" value="${it}" name="typeActivite" ${it == rqt.typeActivite.toString() ? 'checked="checked"': ''} title="<g:message code="scjar.property.typeActivite.validationError" />" />
                <label for="typeActivite_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjar.property.typeActivite" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="precisionActivite" class="required condition-participeActivite-filled"><g:message code="scjar.property.precisionActivite.label" /> *  <span><g:message code="scjar.property.precisionActivite.help" /></span></label>
            <input type="text" id="precisionActivite" name="precisionActivite" value="${rqt.precisionActivite?.toString()}" 
                    class="required condition-participeActivite-filled  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('precisionActivite') ? 'validation-failed' : ''}" title="<g:message code="scjar.property.precisionActivite.validationError" />"   />
            

  

