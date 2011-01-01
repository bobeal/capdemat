


  
    <fieldset class="required">
    <legend><g:message code="ladrr.property.accompagnateurEnfant.label" /></legend>
    
      <label for="nomAccompagnateur" class="required"><g:message code="ladrr.property.nomAccompagnateur.label" /> *  <span><g:message code="ladrr.property.nomAccompagnateur.help" /></span></label>
            <input type="text" id="nomAccompagnateur" name="nomAccompagnateur" value="${rqt.nomAccompagnateur?.toString()}" 
                    class="required  validate-lastName ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('nomAccompagnateur') ? 'validation-failed' : ''}" title="<g:message code="ladrr.property.nomAccompagnateur.validationError" />"  maxlength="38" />
            

    
      <label for="prenomAccompagnateur" class="required"><g:message code="ladrr.property.prenomAccompagnateur.label" /> *  <span><g:message code="ladrr.property.prenomAccompagnateur.help" /></span></label>
            <input type="text" id="prenomAccompagnateur" name="prenomAccompagnateur" value="${rqt.prenomAccompagnateur?.toString()}" 
                    class="required  validate-firstName ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('prenomAccompagnateur') ? 'validation-failed' : ''}" title="<g:message code="ladrr.property.prenomAccompagnateur.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="ladrr.property.adresseAccompagnateur.label" /> *  <span><g:message code="ladrr.property.adresseAccompagnateur.help" /></span></label>
            <div class="address-fieldset required  ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur') ? 'validation-failed' : ''}">
            <label for="adresseAccompagnateur.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.additionalDeliveryInformation}" maxlength="38" id="adresseAccompagnateur.additionalDeliveryInformation" name="adresseAccompagnateur.additionalDeliveryInformation" />  
            <label for="adresseAccompagnateur.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.additionalGeographicalInformation}" maxlength="38" id="adresseAccompagnateur.additionalGeographicalInformation" name="adresseAccompagnateur.additionalGeographicalInformation" />
            <label for="adresseAccompagnateur.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="adresseAccompagnateur.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.streetNumber') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.streetNumber}" size="5" maxlength="5" id="adresseAccompagnateur.streetNumber" name="adresseAccompagnateur.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.streetName') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.streetName}" maxlength="32" id="adresseAccompagnateur.streetName" name="adresseAccompagnateur.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="adresseAccompagnateur.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.placeNameOrService}" maxlength="38" id="adresseAccompagnateur.placeNameOrService" name="adresseAccompagnateur.placeNameOrService" />
            <label for="adresseAccompagnateur.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="adresseAccompagnateur.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.postalCode') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.postalCode}" size="5" maxlength="5" id="adresseAccompagnateur.postalCode" name="adresseAccompagnateur.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.city') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.city}" maxlength="32" id="adresseAccompagnateur.city" name="adresseAccompagnateur.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="adresseAccompagnateur.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('adresseAccompagnateur.countryName') ? 'validation-failed' : ''}" value="${rqt.adresseAccompagnateur?.countryName}" maxlength="38" id="adresseAccompagnateur.countryName" name="adresseAccompagnateur.countryName" />
            </div>
            

    
      <label for="telephoneDomicileAccompagnateur" class=""><g:message code="ladrr.property.telephoneDomicileAccompagnateur.label" />   <span><g:message code="ladrr.property.telephoneDomicileAccompagnateur.help" /></span></label>
            <input type="text" id="telephoneDomicileAccompagnateur" name="telephoneDomicileAccompagnateur" value="${rqt.telephoneDomicileAccompagnateur?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('telephoneDomicileAccompagnateur') ? 'validation-failed' : ''}" title="<g:message code="ladrr.property.telephoneDomicileAccompagnateur.validationError" />"  maxlength="10" />
            

    
      <label for="telephonePortableAccompagnateur" class=""><g:message code="ladrr.property.telephonePortableAccompagnateur.label" />   <span><g:message code="ladrr.property.telephonePortableAccompagnateur.help" /></span></label>
            <input type="text" id="telephonePortableAccompagnateur" name="telephonePortableAccompagnateur" value="${rqt.telephonePortableAccompagnateur?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('telephonePortableAccompagnateur') ? 'validation-failed' : ''}" title="<g:message code="ladrr.property.telephonePortableAccompagnateur.validationError" />"  maxlength="10" />
            

    
      <label for="telephoneBureauAccompagnateur" class=""><g:message code="ladrr.property.telephoneBureauAccompagnateur.label" />   <span><g:message code="ladrr.property.telephoneBureauAccompagnateur.help" /></span></label>
            <input type="text" id="telephoneBureauAccompagnateur" name="telephoneBureauAccompagnateur" value="${rqt.telephoneBureauAccompagnateur?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('telephoneBureauAccompagnateur') ? 'validation-failed' : ''}" title="<g:message code="ladrr.property.telephoneBureauAccompagnateur.validationError" />"  maxlength="10" />
            

    
      <label for="emailAccompagnateur" class=""><g:message code="ladrr.property.emailAccompagnateur.label" />   <span><g:message code="ladrr.property.emailAccompagnateur.help" /></span></label>
            <input type="text" id="emailAccompagnateur" name="emailAccompagnateur" value="${rqt.emailAccompagnateur?.toString()}" 
                    class="  validate-email ${stepStates != null && stepStates['autorisations']?.invalidFields.contains('emailAccompagnateur') ? 'validation-failed' : ''}" title="<g:message code="ladrr.property.emailAccompagnateur.validationError" />"   />
            

    
    </fieldset>
  

