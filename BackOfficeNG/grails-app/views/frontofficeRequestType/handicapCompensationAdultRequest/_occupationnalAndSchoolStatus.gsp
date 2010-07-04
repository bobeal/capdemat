


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.studies.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.studiesHighSchool.label" /> *  <span><g:message code="hcar.property.studiesHighSchool.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchool') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="studiesHighSchool_${it ? 'yes' : 'no'}" class="required condition-isHighSchool-trigger  validate-one-required boolean" title="" value="${it}" name="studiesHighSchool" ${it == rqt.studiesHighSchool ? 'checked="checked"': ''} />
                <label for="studiesHighSchool_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="studiesHighSchoolGrade" class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolGrade.label" /> *  <span><g:message code="hcar.property.studiesHighSchoolGrade.help" /></span></label>
            <input type="text" id="studiesHighSchoolGrade" name="studiesHighSchoolGrade" value="${rqt.studiesHighSchoolGrade?.toString()}" 
                    class="required condition-isHighSchool-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolGrade') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.studiesHighSchoolGrade.validationError" />"  maxlength="60" />
            

    
      <label for="studiesHighSchoolName" class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolName.label" /> *  <span><g:message code="hcar.property.studiesHighSchoolName.help" /></span></label>
            <input type="text" id="studiesHighSchoolName" name="studiesHighSchoolName" value="${rqt.studiesHighSchoolName?.toString()}" 
                    class="required condition-isHighSchool-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.studiesHighSchoolName.validationError" />"  maxlength="60" />
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolAddress.label" /> *  <span><g:message code="hcar.property.studiesHighSchoolAddress.help" /></span></label>
            <div id="studiesHighSchoolAddress" class="address-fieldset required condition-isHighSchool-filled  ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress') ? 'validation-failed' : ''}">
            <label for="studiesHighSchoolAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.additionalDeliveryInformation}" maxlength="38" id="studiesHighSchoolAddress.additionalDeliveryInformation" name="studiesHighSchoolAddress.additionalDeliveryInformation" />  
            <label for="studiesHighSchoolAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.additionalGeographicalInformation}" maxlength="38" id="studiesHighSchoolAddress.additionalGeographicalInformation" name="studiesHighSchoolAddress.additionalGeographicalInformation" />
            <label for="studiesHighSchoolAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="studiesHighSchoolAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.streetNumber}" size="5" maxlength="5" id="studiesHighSchoolAddress_streetNumber" name="studiesHighSchoolAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.streetName}" maxlength="32" id="studiesHighSchoolAddress_streetName" name="studiesHighSchoolAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.studiesHighSchoolAddress?.streetMatriculation}" id="studiesHighSchoolAddress_streetMatriculation" name="studiesHighSchoolAddress.streetMatriculation" />
            <label for="studiesHighSchoolAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.placeNameOrService}" maxlength="38" id="studiesHighSchoolAddress.placeNameOrService" name="studiesHighSchoolAddress.placeNameOrService" />
            <label for="studiesHighSchoolAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="studiesHighSchoolAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.postalCode}" size="5" maxlength="5" id="studiesHighSchoolAddress_postalCode" name="studiesHighSchoolAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.city') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.city}" maxlength="32" id="studiesHighSchoolAddress_city" name="studiesHighSchoolAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.studiesHighSchoolAddress?.cityInseeCode}" id="studiesHighSchoolAddress_cityInseeCode" name="studiesHighSchoolAddress.cityInseeCode" />
            <label for="studiesHighSchoolAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.countryName}" maxlength="38" id="studiesHighSchoolAddress.countryName" name="studiesHighSchoolAddress.countryName" />
            </div>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesAssistanceUnderDisability.label" /> *  <span><g:message code="hcar.property.studiesAssistanceUnderDisability.help" /></span></label>
            <ul class="yes-no required condition-isHighSchool-filled ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesAssistanceUnderDisability') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="studiesAssistanceUnderDisability_${it ? 'yes' : 'no'}" class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger  validate-one-required boolean" title="" value="${it}" name="studiesAssistanceUnderDisability" ${it == rqt.studiesAssistanceUnderDisability ? 'checked="checked"': ''} />
                <label for="studiesAssistanceUnderDisability_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="studiesAssistanceUnderDisabilityDetails" class="required condition-isAssistanceUnderDisability-filled"><g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.label" /> *  <span><g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.help" /></span></label>
            <input type="text" id="studiesAssistanceUnderDisabilityDetails" name="studiesAssistanceUnderDisabilityDetails" value="${rqt.studiesAssistanceUnderDisabilityDetails?.toString()}" 
                    class="required condition-isAssistanceUnderDisability-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesAssistanceUnderDisabilityDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.formation.label" /></legend>
    
      <label for="formationStudiesLevel" class=""><g:message code="hcar.property.formationStudiesLevel.label" />   <span><g:message code="hcar.property.formationStudiesLevel.help" /></span></label>
            <input type="text" id="formationStudiesLevel" name="formationStudiesLevel" value="${rqt.formationStudiesLevel?.toString()}" 
                    class="   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationStudiesLevel') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.formationStudiesLevel.validationError" />"  maxlength="30" />
            

    
      <label for="formationDiploma" class=""><g:message code="hcar.property.formationDiploma.label" />   <span><g:message code="hcar.property.formationDiploma.help" /></span></label>
            <textarea id="formationDiploma" name="formationDiploma" class="  validate-textarea ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationDiploma') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.formationDiploma.validationError" />" rows="2" cols=""  maxlength="120">${rqt.formationDiploma}</textarea>
            

    
      <label for="formationPreviousFormation" class=""><g:message code="hcar.property.formationPreviousFormation.label" />   <span><g:message code="hcar.property.formationPreviousFormation.help" /></span></label>
            <textarea id="formationPreviousFormation" name="formationPreviousFormation" class="  validate-textarea ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationPreviousFormation') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.formationPreviousFormation.validationError" />" rows="3" cols=""  maxlength="180">${rqt.formationPreviousFormation}</textarea>
            

    
      <label for="formationCurrentFormation" class=""><g:message code="hcar.property.formationCurrentFormation.label" />   <span><g:message code="hcar.property.formationCurrentFormation.help" /></span></label>
            <textarea id="formationCurrentFormation" name="formationCurrentFormation" class="  validate-textarea ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationCurrentFormation') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.formationCurrentFormation.validationError" />" rows="2" cols=""  maxlength="120">${rqt.formationCurrentFormation}</textarea>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.professionalStatus.label" /></legend>
    
      <label for="professionalStatusKind" class="required"><g:message code="hcar.property.professionalStatusKind.label" /> *  <span><g:message code="hcar.property.professionalStatusKind.help" /></span></label>
            <select id="professionalStatusKind" name="professionalStatusKind" class="required condition-isEmployed-trigger condition-isUnemployed-trigger  validate-not-first ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusKind') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Employee','Unemployed','Jobless','Student','Retired']}">
                <option value="fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType_${it}" ${it == rqt.professionalStatusKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.professionalStatusKind" /></option>
              </g:each>
            </select>
            

    
      <label for="professionalStatusDate" class="required"><g:message code="hcar.property.professionalStatusDate.label" /> *  <span><g:message code="hcar.property.professionalStatusDate.help" /></span></label>
            <input type="text" id="professionalStatusDate" name="professionalStatusDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusDate)}" 
                   class="required  validate-date ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusDate') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusDate.validationError" />" />
            

    
      <label for="professionalStatusEnvironment" class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusEnvironment.label" /> *  <span><g:message code="hcar.property.professionalStatusEnvironment.help" /></span></label>
            <select id="professionalStatusEnvironment" name="professionalStatusEnvironment" class="required condition-isEmployed-filled  validate-not-first ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusEnvironment') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusEnvironment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Ordinary','Adapted','Protected']}">
                <option value="fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType_${it}" ${it == rqt.professionalStatusEnvironment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hcar.property.professionalStatusEnvironment" /></option>
              </g:each>
            </select>
            

    
      <label for="professionalStatusProfession" class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusProfession.label" /> *  <span><g:message code="hcar.property.professionalStatusProfession.help" /></span></label>
            <input type="text" id="professionalStatusProfession" name="professionalStatusProfession" value="${rqt.professionalStatusProfession?.toString()}" 
                    class="required condition-isEmployed-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusProfession') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusProfession.validationError" />"  maxlength="60" />
            

    
      <label for="professionalStatusEmployerName" class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusEmployerName.label" /> *  <span><g:message code="hcar.property.professionalStatusEmployerName.help" /></span></label>
            <input type="text" id="professionalStatusEmployerName" name="professionalStatusEmployerName" value="${rqt.professionalStatusEmployerName?.toString()}" 
                    class="required condition-isEmployed-filled  validate-lastName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusEmployerName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusEmployerName.validationError" />"  maxlength="38" />
            

    
      <label class="condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusAddress.label" />   <span><g:message code="hcar.property.professionalStatusAddress.help" /></span></label>
            <div id="professionalStatusAddress" class="address-fieldset condition-isEmployed-filled  ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress') ? 'validation-failed' : ''}">
            <label for="professionalStatusAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.additionalDeliveryInformation}" maxlength="38" id="professionalStatusAddress.additionalDeliveryInformation" name="professionalStatusAddress.additionalDeliveryInformation" />  
            <label for="professionalStatusAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.additionalGeographicalInformation}" maxlength="38" id="professionalStatusAddress.additionalGeographicalInformation" name="professionalStatusAddress.additionalGeographicalInformation" />
            <label for="professionalStatusAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="professionalStatusAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.streetNumber}" size="5" maxlength="5" id="professionalStatusAddress_streetNumber" name="professionalStatusAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.streetName}" maxlength="32" id="professionalStatusAddress_streetName" name="professionalStatusAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.professionalStatusAddress?.streetMatriculation}" id="professionalStatusAddress_streetMatriculation" name="professionalStatusAddress.streetMatriculation" />
            <label for="professionalStatusAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.placeNameOrService}" maxlength="38" id="professionalStatusAddress.placeNameOrService" name="professionalStatusAddress.placeNameOrService" />
            <label for="professionalStatusAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="professionalStatusAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.postalCode}" size="5" maxlength="5" id="professionalStatusAddress_postalCode" name="professionalStatusAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.city') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.city}" maxlength="32" id="professionalStatusAddress_city" name="professionalStatusAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.professionalStatusAddress?.cityInseeCode}" id="professionalStatusAddress_cityInseeCode" name="professionalStatusAddress.cityInseeCode" />
            <label for="professionalStatusAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.countryName}" maxlength="38" id="professionalStatusAddress.countryName" name="professionalStatusAddress.countryName" />
            </div>
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hcar.property.professionalStatusRegisterAsUnemployed.label" /> *  <span><g:message code="hcar.property.professionalStatusRegisterAsUnemployed.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusRegisterAsUnemployed') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalStatusRegisterAsUnemployed_${it ? 'yes' : 'no'}" class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger  validate-one-required boolean" title="" value="${it}" name="professionalStatusRegisterAsUnemployed" ${it == rqt.professionalStatusRegisterAsUnemployed ? 'checked="checked"': ''} />
                <label for="professionalStatusRegisterAsUnemployed_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalStatusRegisterAsUnemployedDate" class="required condition-isRegisteredAsUnemployed-filled"><g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.label" /> *  <span><g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.help" /></span></label>
            <input type="text" id="professionalStatusRegisterAsUnemployedDate" name="professionalStatusRegisterAsUnemployedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusRegisterAsUnemployedDate)}" 
                   class="required condition-isRegisteredAsUnemployed-filled  validate-date ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusRegisterAsUnemployedDate') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.validationError" />" />
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hcar.property.professionalStatusIndemnified.label" /> *  <span><g:message code="hcar.property.professionalStatusIndemnified.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusIndemnified') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalStatusIndemnified_${it ? 'yes' : 'no'}" class="required condition-isUnemployed-filled condition-isIndemnified-trigger  validate-one-required boolean" title="" value="${it}" name="professionalStatusIndemnified" ${it == rqt.professionalStatusIndemnified ? 'checked="checked"': ''} />
                <label for="professionalStatusIndemnified_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalStatusIndemnifiedDate" class="required condition-isIndemnified-filled"><g:message code="hcar.property.professionalStatusIndemnifiedDate.label" /> *  <span><g:message code="hcar.property.professionalStatusIndemnifiedDate.help" /></span></label>
            <input type="text" id="professionalStatusIndemnifiedDate" name="professionalStatusIndemnifiedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusIndemnifiedDate)}" 
                   class="required condition-isIndemnified-filled  validate-date ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusIndemnifiedDate') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusIndemnifiedDate.validationError" />" />
            

    
      <label class="required"><g:message code="hcar.property.professionalStatusElectiveFunction.label" /> *  <span><g:message code="hcar.property.professionalStatusElectiveFunction.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusElectiveFunction') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalStatusElectiveFunction_${it ? 'yes' : 'no'}" class="required condition-isElectiveFunction-trigger  validate-one-required boolean" title="" value="${it}" name="professionalStatusElectiveFunction" ${it == rqt.professionalStatusElectiveFunction ? 'checked="checked"': ''} />
                <label for="professionalStatusElectiveFunction_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalStatusElectiveFunctionDetails" class="required condition-isElectiveFunction-filled"><g:message code="hcar.property.professionalStatusElectiveFunctionDetails.label" /> *  <span><g:message code="hcar.property.professionalStatusElectiveFunctionDetails.help" /></span></label>
            <input type="text" id="professionalStatusElectiveFunctionDetails" name="professionalStatusElectiveFunctionDetails" value="${rqt.professionalStatusElectiveFunctionDetails?.toString()}" 
                    class="required condition-isElectiveFunction-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusElectiveFunctionDetails') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.professionalStatusElectiveFunctionDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

