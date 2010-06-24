


  
    <fieldset class="required">
    <legend><g:message code="sgr.property.subjectInformations.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectFilling-trigger ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="sgr.property.subjectAddress.label" /> *  <span><g:message code="sgr.property.subjectAddress.help" /></span></label>
            <div id="subjectAddress" class="address-fieldset required autofill-subjectFilling-listener-Adress ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress') ? 'validation-failed' : ''}">
            <label for="subjectAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.additionalDeliveryInformation}" maxlength="38" id="subjectAddress.additionalDeliveryInformation" name="subjectAddress.additionalDeliveryInformation" />  
            <label for="subjectAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.additionalGeographicalInformation}" maxlength="38" id="subjectAddress.additionalGeographicalInformation" name="subjectAddress.additionalGeographicalInformation" />
            <label for="subjectAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="subjectAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.streetNumber}" size="5" maxlength="5" id="subjectAddress.streetNumber" name="subjectAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.streetName}" maxlength="32" id="subjectAddress_streetName" name="subjectAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.subjectAddress?.streetMatriculation}" id="subjectAddress_streetMatriculation" name="subjectAddress.streetMatriculation" />
            <label for="subjectAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.placeNameOrService}" maxlength="38" id="subjectAddress.placeNameOrService" name="subjectAddress.placeNameOrService" />
            <label for="subjectAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="subjectAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.postalCode}" size="5" maxlength="5" id="subjectAddress_postalCode" name="subjectAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.city') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.city}" maxlength="32" id="subjectAddress_city" name="subjectAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.subjectAddress?.cityInseeCode}" id="subjectAddress_cityInseeCode" name="subjectAddress.cityInseeCode" />
            <label for="subjectAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.countryName}" maxlength="38" id="subjectAddress.countryName" name="subjectAddress.countryName" />
            </div>
            

    
      <label for="subjectPhone" class=""><g:message code="sgr.property.subjectPhone.label" />   <span><g:message code="sgr.property.subjectPhone.help" /></span></label>
            <input type="text" id="subjectPhone" name="subjectPhone" value="${rqt.subjectPhone?.toString()}" 
                    class=" autofill-subjectFilling-listener-HomePhone validate-phone ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectPhone') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.subjectPhone.validationError" />"  maxlength="10" />
            

    
      <label for="subjectMobilePhone" class=""><g:message code="sgr.property.subjectMobilePhone.label" />   <span><g:message code="sgr.property.subjectMobilePhone.help" /></span></label>
            <input type="text" id="subjectMobilePhone" name="subjectMobilePhone" value="${rqt.subjectMobilePhone?.toString()}" 
                    class=" autofill-subjectFilling-listener-MobilePhone validate-mobilePhone ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectMobilePhone') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.subjectMobilePhone.validationError" />"  maxlength="10" />
            

    
      <label for="subjectEmail" class=""><g:message code="sgr.property.subjectEmail.label" />   <span><g:message code="sgr.property.subjectEmail.help" /></span></label>
            <input type="text" id="subjectEmail" name="subjectEmail" value="${rqt.subjectEmail?.toString()}" 
                    class=" autofill-subjectFilling-listener-Email validate-email ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectEmail') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.subjectEmail.validationError" />"   />
            

    
      <label for="subjectBirthDate" class="required"><g:message code="sgr.property.subjectBirthDate.label" /> *  <span><g:message code="sgr.property.subjectBirthDate.help" /></span></label>
            <input type="text" id="subjectBirthDate" name="subjectBirthDate" value="${formatDate(formatName:'format.date',date:rqt.subjectBirthDate)}" 
                   class="required autofill-subjectFilling-listener-BirthDate validate-date ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.subjectBirthDate.validationError" />" />
            

    
      <label class="required"><g:message code="sgr.property.subjectFirstRequest.label" /> *  <span><g:message code="sgr.property.subjectFirstRequest.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['subject']?.invalidFields.contains('subjectFirstRequest') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="subjectFirstRequest_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="subjectFirstRequest" ${it == rqt.subjectFirstRequest ? 'checked="checked"': ''} />
                <label for="subjectFirstRequest_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

