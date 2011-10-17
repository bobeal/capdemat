


  
    <label for="nomAssociation" class="required"><g:message code="sagr.property.nomAssociation.label" /> *  <span><g:message code="sagr.property.nomAssociation.help" /></span></label>
            <input type="text" id="nomAssociation" name="nomAssociation" value="${rqt.nomAssociation?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['association'].invalidFields.contains('nomAssociation') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nomAssociation.validationError" />"   />
            

  

  
    <label class="required"><g:message code="sagr.property.siegeSocialAssociation.label" /> *  <span><g:message code="sagr.property.siegeSocialAssociation.help" /></span></label>
            <div id="siegeSocialAssociation" class="address required  ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation') ? 'validation-failed' : ''}">
            <label for="siegeSocialAssociation.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.additionalDeliveryInformation}" maxlength="38" id="siegeSocialAssociation.additionalDeliveryInformation" name="siegeSocialAssociation.additionalDeliveryInformation" />  
            <label for="siegeSocialAssociation.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.additionalGeographicalInformation}" maxlength="38" id="siegeSocialAssociation.additionalGeographicalInformation" name="siegeSocialAssociation.additionalGeographicalInformation" />
            <label for="siegeSocialAssociation_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="siegeSocialAssociation_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.streetNumber') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.streetNumber}" size="5" maxlength="5" id="siegeSocialAssociation_streetNumber" name="siegeSocialAssociation.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.streetName') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.streetName}" maxlength="32" id="siegeSocialAssociation_streetName" name="siegeSocialAssociation.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.siegeSocialAssociation?.streetMatriculation}" id="siegeSocialAssociation_streetMatriculation" name="siegeSocialAssociation.streetMatriculation" />
            <input type="hidden" value="${rqt.siegeSocialAssociation?.streetRivoliCode}" id="siegeSocialAssociation_streetRivoliCode" name="siegeSocialAssociation.streetRivoliCode" />
            <label for="siegeSocialAssociation.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.placeNameOrService}" maxlength="38" id="siegeSocialAssociation.placeNameOrService" name="siegeSocialAssociation.placeNameOrService" />
            <label for="siegeSocialAssociation_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="siegeSocialAssociation_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.postalCode') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.postalCode}" size="5" maxlength="5" id="siegeSocialAssociation_postalCode" name="siegeSocialAssociation.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.city') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.city}" maxlength="32" id="siegeSocialAssociation_city" name="siegeSocialAssociation.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.siegeSocialAssociation?.cityInseeCode}" id="siegeSocialAssociation_cityInseeCode" name="siegeSocialAssociation.cityInseeCode" />
            <label for="siegeSocialAssociation.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('siegeSocialAssociation.countryName') ? 'validation-failed' : ''}" value="${rqt.siegeSocialAssociation?.countryName}" maxlength="38" id="siegeSocialAssociation.countryName" name="siegeSocialAssociation.countryName" />
            </div>
            

  

  
    <fieldset class="required">
    <legend><g:message code="sagr.property.numerosAssociation.label" /></legend>
    
      <label for="numeroSiretAssociation" class="required"><g:message code="sagr.property.numeroSiretAssociation.label" /> *  <span><g:message code="sagr.property.numeroSiretAssociation.help" /></span></label>
            <input type="text" id="numeroSiretAssociation" name="numeroSiretAssociation" value="${rqt.numeroSiretAssociation?.toString()}" 
                    class="required  validate-regex ${rqt.stepStates['association'].invalidFields.contains('numeroSiretAssociation') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.numeroSiretAssociation.validationError" />" regex="^[\w\W]{0,14}$" maxlength="14" />
            

    
      <label for="numeroEnregistrementPrefectureAssociation" class="required"><g:message code="sagr.property.numeroEnregistrementPrefectureAssociation.label" /> *  <span><g:message code="sagr.property.numeroEnregistrementPrefectureAssociation.help" /></span></label>
            <input type="text" id="numeroEnregistrementPrefectureAssociation" name="numeroEnregistrementPrefectureAssociation" value="${rqt.numeroEnregistrementPrefectureAssociation?.toString()}" 
                    class="required  validate-regex ${rqt.stepStates['association'].invalidFields.contains('numeroEnregistrementPrefectureAssociation') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.numeroEnregistrementPrefectureAssociation.validationError" />" regex="^[\w\W]{0,9}$" maxlength="9" />
            

    
      <label for="numeroAgrementJeunesseSportAssociation" class=""><g:message code="sagr.property.numeroAgrementJeunesseSportAssociation.label" />   <span><g:message code="sagr.property.numeroAgrementJeunesseSportAssociation.help" /></span></label>
            <input type="text" id="numeroAgrementJeunesseSportAssociation" name="numeroAgrementJeunesseSportAssociation" value="${rqt.numeroAgrementJeunesseSportAssociation?.toString()}" 
                    class="  validate-string ${rqt.stepStates['association'].invalidFields.contains('numeroAgrementJeunesseSportAssociation') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.numeroAgrementJeunesseSportAssociation.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="sagr.property.contactsAssociation.label" /></legend>
    
      <label class="required"><g:message code="sagr.property.estAdresseCorrespondantPrincipal.label" /> *  <span><g:message code="sagr.property.estAdresseCorrespondantPrincipal.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['association'].invalidFields.contains('estAdresseCorrespondantPrincipal') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estAdresseCorrespondantPrincipal_${it ? 'yes' : 'no'}" class="required condition-estAdresseCorrespondantPrincipal-trigger  validate-one-required boolean" title="" value="${it}" name="estAdresseCorrespondantPrincipal" ${it == rqt.estAdresseCorrespondantPrincipal ? 'checked="checked"': ''} />
                <label for="estAdresseCorrespondantPrincipal_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="nomCompletCorrespondantPrincipal" class="required condition-estAdresseCorrespondantPrincipal-filled"><g:message code="sagr.property.nomCompletCorrespondantPrincipal.label" /> *  <span><g:message code="sagr.property.nomCompletCorrespondantPrincipal.help" /></span></label>
            <input type="text" id="nomCompletCorrespondantPrincipal" name="nomCompletCorrespondantPrincipal" value="${rqt.nomCompletCorrespondantPrincipal?.toString()}" 
                    class="required condition-estAdresseCorrespondantPrincipal-filled  validate-string ${rqt.stepStates['association'].invalidFields.contains('nomCompletCorrespondantPrincipal') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nomCompletCorrespondantPrincipal.validationError" />"   />
            

    
      <label class="required condition-estAdresseCorrespondantPrincipal-filled"><g:message code="sagr.property.adresseCorrespondantPrincipal.label" /> *  <span><g:message code="sagr.property.adresseCorrespondantPrincipal.help" /></span></label>
            <div id="adresseCorrespondantPrincipal" class="address required condition-estAdresseCorrespondantPrincipal-filled  ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal') ? 'validation-failed' : ''}">
            <label for="adresseCorrespondantPrincipal.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.additionalDeliveryInformation}" maxlength="38" id="adresseCorrespondantPrincipal.additionalDeliveryInformation" name="adresseCorrespondantPrincipal.additionalDeliveryInformation" />  
            <label for="adresseCorrespondantPrincipal.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.additionalGeographicalInformation}" maxlength="38" id="adresseCorrespondantPrincipal.additionalGeographicalInformation" name="adresseCorrespondantPrincipal.additionalGeographicalInformation" />
            <label for="adresseCorrespondantPrincipal_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="adresseCorrespondantPrincipal_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.streetNumber') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.streetNumber}" size="5" maxlength="5" id="adresseCorrespondantPrincipal_streetNumber" name="adresseCorrespondantPrincipal.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.streetName') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.streetName}" maxlength="32" id="adresseCorrespondantPrincipal_streetName" name="adresseCorrespondantPrincipal.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.adresseCorrespondantPrincipal?.streetMatriculation}" id="adresseCorrespondantPrincipal_streetMatriculation" name="adresseCorrespondantPrincipal.streetMatriculation" />
            <input type="hidden" value="${rqt.adresseCorrespondantPrincipal?.streetRivoliCode}" id="adresseCorrespondantPrincipal_streetRivoliCode" name="adresseCorrespondantPrincipal.streetRivoliCode" />
            <label for="adresseCorrespondantPrincipal.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.placeNameOrService}" maxlength="38" id="adresseCorrespondantPrincipal.placeNameOrService" name="adresseCorrespondantPrincipal.placeNameOrService" />
            <label for="adresseCorrespondantPrincipal_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="adresseCorrespondantPrincipal_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.postalCode') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.postalCode}" size="5" maxlength="5" id="adresseCorrespondantPrincipal_postalCode" name="adresseCorrespondantPrincipal.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.city') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.city}" maxlength="32" id="adresseCorrespondantPrincipal_city" name="adresseCorrespondantPrincipal.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.adresseCorrespondantPrincipal?.cityInseeCode}" id="adresseCorrespondantPrincipal_cityInseeCode" name="adresseCorrespondantPrincipal.cityInseeCode" />
            <label for="adresseCorrespondantPrincipal.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['association'].invalidFields.contains('adresseCorrespondantPrincipal.countryName') ? 'validation-failed' : ''}" value="${rqt.adresseCorrespondantPrincipal?.countryName}" maxlength="38" id="adresseCorrespondantPrincipal.countryName" name="adresseCorrespondantPrincipal.countryName" />
            </div>
            

    
      <label for="emailClubOuCorrespondant" class=""><g:message code="sagr.property.emailClubOuCorrespondant.label" />   <span><g:message code="sagr.property.emailClubOuCorrespondant.help" /></span></label>
            <input type="text" id="emailClubOuCorrespondant" name="emailClubOuCorrespondant" value="${rqt.emailClubOuCorrespondant?.toString()}" 
                    class="  validate-email ${rqt.stepStates['association'].invalidFields.contains('emailClubOuCorrespondant') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.emailClubOuCorrespondant.validationError" />"   />
            

    
    </fieldset>
  

