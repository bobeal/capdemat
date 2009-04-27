


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.studies.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.studiesHighSchool.label" /> *  <span><g:message code="hcar.property.studiesHighSchool.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isHighSchool-trigger  validate-boolean" title="" value="${it}" name="studiesHighSchool" ${it == rqt.studiesHighSchool ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolGrade.label" /> *  <span><g:message code="hcar.property.studiesHighSchoolGrade.help" /></span></label>
            <input type="text" name="studiesHighSchoolGrade" value="${rqt.studiesHighSchoolGrade}" 
                    class="required condition-isHighSchool-filled  " title="<g:message code="hcar.property.studiesHighSchoolGrade.validationError" />"  maxLength="60"/>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolName.label" /> *  <span><g:message code="hcar.property.studiesHighSchoolName.help" /></span></label>
            <input type="text" name="studiesHighSchoolName" value="${rqt.studiesHighSchoolName}" 
                    class="required condition-isHighSchool-filled  " title="<g:message code="hcar.property.studiesHighSchoolName.validationError" />"  maxLength="60"/>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesHighSchoolAddress.label" /> *  <span><g:message code="hcar.property.studiesHighSchoolAddress.help" /></span></label>
            <div class="address-fieldset required condition-isHighSchool-filled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.studiesHighSchoolAddress?.additionalDeliveryInformation}" maxlength="38" name="studiesHighSchoolAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.studiesHighSchoolAddress?.additionalGeographicalInformation}" maxlength="38" name="studiesHighSchoolAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.studiesHighSchoolAddress?.streetNumber}" maxlength="5" name="studiesHighSchoolAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.studiesHighSchoolAddress?.streetName}" maxlength="32" name="studiesHighSchoolAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.studiesHighSchoolAddress?.placeNameOrService}" maxlength="38" name="studiesHighSchoolAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.studiesHighSchoolAddress?.postalCode}" maxlength="5" name="studiesHighSchoolAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.studiesHighSchoolAddress?.city}" maxlength="32" name="studiesHighSchoolAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.studiesHighSchoolAddress?.countryName}" maxlength="38" name="studiesHighSchoolAddress.countryName"/>
            </div>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hcar.property.studiesAssistanceUnderDisability.label" /> *  <span><g:message code="hcar.property.studiesAssistanceUnderDisability.help" /></span></label>
            <ul class="yes-no required condition-isHighSchool-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger  validate-boolean" title="" value="${it}" name="studiesAssistanceUnderDisability" ${it == rqt.studiesAssistanceUnderDisability ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isAssistanceUnderDisability-filled"><g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.label" /> *  <span><g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.help" /></span></label>
            <input type="text" name="studiesAssistanceUnderDisabilityDetails" value="${rqt.studiesAssistanceUnderDisabilityDetails}" 
                    class="required condition-isAssistanceUnderDisability-filled  " title="<g:message code="hcar.property.studiesAssistanceUnderDisabilityDetails.validationError" />"  maxLength="60"/>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.formation.label" /></legend>
    
      <label class=""><g:message code="hcar.property.formationStudiesLevel.label" />   <span><g:message code="hcar.property.formationStudiesLevel.help" /></span></label>
            <input type="text" name="formationStudiesLevel" value="${rqt.formationStudiesLevel}" 
                    class="  " title="<g:message code="hcar.property.formationStudiesLevel.validationError" />"  maxLength="30"/>
            

    
      <label class=""><g:message code="hcar.property.formationDiploma.label" />   <span><g:message code="hcar.property.formationDiploma.help" /></span></label>
            <textarea name="formationDiploma" class="  validate-textarea" title="<g:message code="hcar.property.formationDiploma.validationError" />" rows="2" maxLength="120">${rqt.formationDiploma}</textarea>
            

    
      <label class=""><g:message code="hcar.property.formationPreviousFormation.label" />   <span><g:message code="hcar.property.formationPreviousFormation.help" /></span></label>
            <textarea name="formationPreviousFormation" class="  validate-textarea" title="<g:message code="hcar.property.formationPreviousFormation.validationError" />" rows="3" maxLength="180">${rqt.formationPreviousFormation}</textarea>
            

    
      <label class=""><g:message code="hcar.property.formationCurrentFormation.label" />   <span><g:message code="hcar.property.formationCurrentFormation.help" /></span></label>
            <textarea name="formationCurrentFormation" class="  validate-textarea" title="<g:message code="hcar.property.formationCurrentFormation.validationError" />" rows="2" maxLength="120">${rqt.formationCurrentFormation}</textarea>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hcar.property.professionalStatus.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.professionalStatusKind.label" /> *  <span><g:message code="hcar.property.professionalStatusKind.help" /></span></label>
            <select name="professionalStatusKind" class="required condition-isEmployed-trigger condition-isUnemployed-trigger  validate-not-first" title="<g:message code="hcar.property.professionalStatusKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Employee','Unemployed','Jobless','Student','Retired']}">
                <option value="fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType_${it}" ${it == rqt.professionalStatusKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.professionalStatusKind" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hcar.property.professionalStatusDate.label" /> *  <span><g:message code="hcar.property.professionalStatusDate.help" /></span></label>
            <input type="text" name="professionalStatusDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusDate)}" 
                   class="required  validate-date" title="<g:message code="hcar.property.professionalStatusDate.validationError" />" />
            

    
      <label class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusEnvironment.label" /> *  <span><g:message code="hcar.property.professionalStatusEnvironment.help" /></span></label>
            <select name="professionalStatusEnvironment" class="required condition-isEmployed-filled  validate-not-first" title="<g:message code="hcar.property.professionalStatusEnvironment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Ordinary','Adapted','Protected']}">
                <option value="fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType_${it}" ${it == rqt.professionalStatusEnvironment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hcar.property.professionalStatusEnvironment" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusProfession.label" /> *  <span><g:message code="hcar.property.professionalStatusProfession.help" /></span></label>
            <input type="text" name="professionalStatusProfession" value="${rqt.professionalStatusProfession}" 
                    class="required condition-isEmployed-filled  " title="<g:message code="hcar.property.professionalStatusProfession.validationError" />"  maxLength="60"/>
            

    
      <label class="required condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusEmployerName.label" /> *  <span><g:message code="hcar.property.professionalStatusEmployerName.help" /></span></label>
            <input type="text" name="professionalStatusEmployerName" value="${rqt.professionalStatusEmployerName}" 
                    class="required condition-isEmployed-filled  validate-lastName" title="<g:message code="hcar.property.professionalStatusEmployerName.validationError" />"  maxLength="38"/>
            

    
      <label class="condition-isEmployed-filled"><g:message code="hcar.property.professionalStatusAddress.label" />   <span><g:message code="hcar.property.professionalStatusAddress.help" /></span></label>
            <div class="address-fieldset condition-isEmployed-filled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.professionalStatusAddress?.additionalDeliveryInformation}" maxlength="38" name="professionalStatusAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.professionalStatusAddress?.additionalGeographicalInformation}" maxlength="38" name="professionalStatusAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.professionalStatusAddress?.streetNumber}" maxlength="5" name="professionalStatusAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.professionalStatusAddress?.streetName}" maxlength="32" name="professionalStatusAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.professionalStatusAddress?.placeNameOrService}" maxlength="38" name="professionalStatusAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.professionalStatusAddress?.postalCode}" maxlength="5" name="professionalStatusAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.professionalStatusAddress?.city}" maxlength="32" name="professionalStatusAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.professionalStatusAddress?.countryName}" maxlength="38" name="professionalStatusAddress.countryName"/>
            </div>
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hcar.property.professionalStatusRegisterAsUnemployed.label" /> *  <span><g:message code="hcar.property.professionalStatusRegisterAsUnemployed.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger  validate-boolean" title="" value="${it}" name="professionalStatusRegisterAsUnemployed" ${it == rqt.professionalStatusRegisterAsUnemployed ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isRegisteredAsUnemployed-filled"><g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.label" /> *  <span><g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.help" /></span></label>
            <input type="text" name="professionalStatusRegisterAsUnemployedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusRegisterAsUnemployedDate)}" 
                   class="required condition-isRegisteredAsUnemployed-filled  validate-date" title="<g:message code="hcar.property.professionalStatusRegisterAsUnemployedDate.validationError" />" />
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hcar.property.professionalStatusIndemnified.label" /> *  <span><g:message code="hcar.property.professionalStatusIndemnified.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isUnemployed-filled condition-isIndemnified-trigger  validate-boolean" title="" value="${it}" name="professionalStatusIndemnified" ${it == rqt.professionalStatusIndemnified ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isIndemnified-filled"><g:message code="hcar.property.professionalStatusIndemnifiedDate.label" /> *  <span><g:message code="hcar.property.professionalStatusIndemnifiedDate.help" /></span></label>
            <input type="text" name="professionalStatusIndemnifiedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusIndemnifiedDate)}" 
                   class="required condition-isIndemnified-filled  validate-date" title="<g:message code="hcar.property.professionalStatusIndemnifiedDate.validationError" />" />
            

    
      <label class="required"><g:message code="hcar.property.professionalStatusElectiveFunction.label" /> *  <span><g:message code="hcar.property.professionalStatusElectiveFunction.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isElectiveFunction-trigger  validate-boolean" title="" value="${it}" name="professionalStatusElectiveFunction" ${it == rqt.professionalStatusElectiveFunction ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isElectiveFunction-filled"><g:message code="hcar.property.professionalStatusElectiveFunctionDetails.label" /> *  <span><g:message code="hcar.property.professionalStatusElectiveFunctionDetails.help" /></span></label>
            <input type="text" name="professionalStatusElectiveFunctionDetails" value="${rqt.professionalStatusElectiveFunctionDetails}" 
                    class="required condition-isElectiveFunction-filled  " title="<g:message code="hcar.property.professionalStatusElectiveFunctionDetails.validationError" />"  maxLength="60"/>
            

    
    </fieldset>
  

