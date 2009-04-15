


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.schooling.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.schoolingEnrolment.label" /> *  <span><g:message code="hccr.property.schoolingEnrolment.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSchoolingEnrolment-trigger validate-boolean" title="" value="${it}" name="schoolingEnrolment" ${it == rqt.schoolingEnrolment ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolName.label" /> *  <span><g:message code="hccr.property.schoolingSchoolName.help" /></span></label>
            <input type="text" name="schoolingSchoolName" value="${rqt.schoolingSchoolName}" 
                    class="required condition-isSchoolingEnrolment-filled " title="<g:message code="hccr.property.schoolingSchoolName.validationError" />"  maxLength="80"/>
            

    
      <label class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolAddress.label" /> *  <span><g:message code="hccr.property.schoolingSchoolAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSchoolingEnrolment-filled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.schoolingSchoolAddress?.additionalDeliveryInformation}" maxlength="38" name="schoolingSchoolAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.schoolingSchoolAddress?.additionalGeographicalInformation}" maxlength="38" name="schoolingSchoolAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.schoolingSchoolAddress?.streetNumber}" maxlength="5" name="schoolingSchoolAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.schoolingSchoolAddress?.streetName}" maxlength="32" name="schoolingSchoolAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.schoolingSchoolAddress?.placeNameOrService}" maxlength="38" name="schoolingSchoolAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.schoolingSchoolAddress?.postalCode}" maxlength="5" name="schoolingSchoolAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.schoolingSchoolAddress?.city}" maxlength="32" name="schoolingSchoolAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.schoolingSchoolAddress?.countryName}" maxlength="38" name="schoolingSchoolAddress.countryName"/>
            </div>
            

    
      <label class="required"><g:message code="hccr.property.schoolingSendToSchool.label" /> *  <span><g:message code="hccr.property.schoolingSendToSchool.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSentToSchool-trigger validate-boolean" title="" value="${it}" name="schoolingSendToSchool" ${it == rqt.schoolingSendToSchool ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isSentToSchool-filled"><g:message code="hccr.property.schoolingAttendedGrade.label" /> *  <span><g:message code="hccr.property.schoolingAttendedGrade.help" /></span></label>
            <select name="schoolingAttendedGrade" class="required condition-isSentToSchool-filled validate-not-first" title="<g:message code="hccr.property.schoolingAttendedGrade.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['BeforeFirstSection','FirstSection','SecondSection','ThirdSection','CP','CE1','CE2','CM1','CM2','CLISS','Unknown']}">
                <option value="fr.cg95.cvq.business.users.SectionType_${it}" ${it == rqt.schoolingAttendedGrade?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.schoolingAttendedGrade" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hccr.property.schoolingSpecializedGrade.label" /> *  <span><g:message code="hccr.property.schoolingSpecializedGrade.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSpecializedGrade-trigger validate-boolean" title="" value="${it}" name="schoolingSpecializedGrade" ${it == rqt.schoolingSpecializedGrade ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isSpecializedGrade-filled"><g:message code="hccr.property.schoolingSpecializedGradeDetails.label" /> *  <span><g:message code="hccr.property.schoolingSpecializedGradeDetails.help" /></span></label>
            <input type="text" name="schoolingSpecializedGradeDetails" value="${rqt.schoolingSpecializedGradeDetails}" 
                    class="required condition-isSpecializedGrade-filled " title="<g:message code="hccr.property.schoolingSpecializedGradeDetails.validationError" />"  maxLength="30"/>
            

    
      <label class="required"><g:message code="hccr.property.schoolingSchoolingKind.label" /> *  <span><g:message code="hccr.property.schoolingSchoolingKind.help" /></span></label>
            <select name="schoolingSchoolingKind" class="required condition-isPartTimeSchooling-trigger validate-not-first" title="<g:message code="hccr.property.schoolingSchoolingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['FullTime','PartTime']}">
                <option value="fr.cg95.cvq.business.request.social.HccrSchoolingKindType_${it}" ${it == rqt.schoolingSchoolingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.schoolingSchoolingKind" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isPartTimeSchooling-filled"><g:message code="hccr.property.schoolingTime.label" /> *  <span><g:message code="hccr.property.schoolingTime.help" /></span></label>
            <input type="text" name="schoolingTime" value="${rqt.schoolingTime}" 
                    class="required condition-isPartTimeSchooling-filled " title="<g:message code="hccr.property.schoolingTime.validationError" />"  />
            

    
      <label class="required"><g:message code="hccr.property.schoolingHomeSchooling.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchooling.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="schoolingHomeSchooling" ${it == rqt.schoolingHomeSchooling ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.schoolingPersonalizedSchoolingPlan.label" /> *  <span><g:message code="hccr.property.schoolingPersonalizedSchoolingPlan.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="schoolingPersonalizedSchoolingPlan" ${it == rqt.schoolingPersonalizedSchoolingPlan ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.schoolingHomeSchoolingKind.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchoolingKind.help" /></span></label>
            <select name="schoolingHomeSchoolingKind" class="required condition-isAccompaniedHomeSchooling-trigger validate-not-first" title="<g:message code="hccr.property.schoolingHomeSchoolingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Alone','Accompanied']}">
                <option value="fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType_${it}" ${it == rqt.schoolingHomeSchoolingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.schoolingHomeSchoolingKind" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.help" /></span></label>
            <input type="text" name="schoolingHomeSchoolingAccompanistLastName" value="${rqt.schoolingHomeSchoolingAccompanistLastName}" 
                    class="required condition-isAccompaniedHomeSchooling-filled validate-lastName" title="<g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.validationError" />"  maxLength="38"/>
            

    
      <label class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.help" /></span></label>
            <input type="text" name="schoolingHomeSchoolingAccompanistFirstName" value="${rqt.schoolingHomeSchoolingAccompanistFirstName}" 
                    class="required condition-isAccompaniedHomeSchooling-filled validate-firstName" title="<g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class="condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistAddress.label" />   <span><g:message code="hccr.property.schoolingHomeSchoolingAccompanistAddress.help" /></span></label>
            <div class="address-fieldset condition-isAccompaniedHomeSchooling-filled">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.additionalDeliveryInformation}" maxlength="38" name="schoolingHomeSchoolingAccompanistAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.additionalGeographicalInformation}" maxlength="38" name="schoolingHomeSchoolingAccompanistAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.streetNumber}" maxlength="5" name="schoolingHomeSchoolingAccompanistAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.streetName}" maxlength="32" name="schoolingHomeSchoolingAccompanistAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.placeNameOrService}" maxlength="38" name="schoolingHomeSchoolingAccompanistAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.postalCode}" maxlength="5" name="schoolingHomeSchoolingAccompanistAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.city}" maxlength="32" name="schoolingHomeSchoolingAccompanistAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.countryName}" maxlength="38" name="schoolingHomeSchoolingAccompanistAddress.countryName"/>
            </div>
            

    
      <label class="required"><g:message code="hccr.property.schoolingExtraCurricular.label" /> *  <span><g:message code="hccr.property.schoolingExtraCurricular.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isExtraCurricular-trigger validate-boolean" title="" value="${it}" name="schoolingExtraCurricular" ${it == rqt.schoolingExtraCurricular ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isExtraCurricular-filled"><g:message code="hccr.property.schoolingExtraCurricularDetails.label" /> *  <span><g:message code="hccr.property.schoolingExtraCurricularDetails.help" /></span></label>
            <input type="text" name="schoolingExtraCurricularDetails" value="${rqt.schoolingExtraCurricularDetails}" 
                    class="required condition-isExtraCurricular-filled " title="<g:message code="hccr.property.schoolingExtraCurricularDetails.validationError" />"  maxLength="50"/>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.studies.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.studiesHighSchool.label" /> *  <span><g:message code="hccr.property.studiesHighSchool.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isHighSchool-trigger validate-boolean" title="" value="${it}" name="studiesHighSchool" ${it == rqt.studiesHighSchool ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolGrade.label" /> *  <span><g:message code="hccr.property.studiesHighSchoolGrade.help" /></span></label>
            <input type="text" name="studiesHighSchoolGrade" value="${rqt.studiesHighSchoolGrade}" 
                    class="required condition-isHighSchool-filled " title="<g:message code="hccr.property.studiesHighSchoolGrade.validationError" />"  maxLength="60"/>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolName.label" /> *  <span><g:message code="hccr.property.studiesHighSchoolName.help" /></span></label>
            <input type="text" name="studiesHighSchoolName" value="${rqt.studiesHighSchoolName}" 
                    class="required condition-isHighSchool-filled " title="<g:message code="hccr.property.studiesHighSchoolName.validationError" />"  maxLength="60"/>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolAddress.label" /> *  <span><g:message code="hccr.property.studiesHighSchoolAddress.help" /></span></label>
            <div class="address-fieldset required condition-isHighSchool-filled">
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
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesAssistanceUnderDisability.label" /> *  <span><g:message code="hccr.property.studiesAssistanceUnderDisability.help" /></span></label>
            <ul class="yes-no required condition-isHighSchool-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger validate-boolean" title="" value="${it}" name="studiesAssistanceUnderDisability" ${it == rqt.studiesAssistanceUnderDisability ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isAssistanceUnderDisability-filled"><g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.label" /> *  <span><g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.help" /></span></label>
            <input type="text" name="studiesAssistanceUnderDisabilityDetails" value="${rqt.studiesAssistanceUnderDisabilityDetails}" 
                    class="required condition-isAssistanceUnderDisability-filled " title="<g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.validationError" />"  maxLength="60"/>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.formation.label" /></legend>
    
      <label class=""><g:message code="hccr.property.formationStudiesLevel.label" />   <span><g:message code="hccr.property.formationStudiesLevel.help" /></span></label>
            <input type="text" name="formationStudiesLevel" value="${rqt.formationStudiesLevel}" 
                    class=" " title="<g:message code="hccr.property.formationStudiesLevel.validationError" />"  maxLength="30"/>
            

    
      <label class=""><g:message code="hccr.property.formationDiploma.label" />   <span><g:message code="hccr.property.formationDiploma.help" /></span></label>
            <textarea name="formationDiploma" class=" validate-textarea" title="<g:message code="hccr.property.formationDiploma.validationError" />" rows="2" maxLength="120">${rqt.formationDiploma}</textarea>
            

    
      <label class=""><g:message code="hccr.property.formationPreviousFormation.label" />   <span><g:message code="hccr.property.formationPreviousFormation.help" /></span></label>
            <textarea name="formationPreviousFormation" class=" validate-textarea" title="<g:message code="hccr.property.formationPreviousFormation.validationError" />" rows="3" maxLength="180">${rqt.formationPreviousFormation}</textarea>
            

    
      <label class=""><g:message code="hccr.property.formationCurrentFormation.label" />   <span><g:message code="hccr.property.formationCurrentFormation.help" /></span></label>
            <textarea name="formationCurrentFormation" class=" validate-textarea" title="<g:message code="hccr.property.formationCurrentFormation.validationError" />" rows="2" maxLength="120">${rqt.formationCurrentFormation}</textarea>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.professionalStatus.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.professionalStatusKind.label" /> *  <span><g:message code="hccr.property.professionalStatusKind.help" /></span></label>
            <select name="professionalStatusKind" class="required condition-isEmployed-trigger condition-isUnemployed-trigger validate-not-first" title="<g:message code="hccr.property.professionalStatusKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Employee','Unemployed','Jobless','Student','Retired']}">
                <option value="fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType_${it}" ${it == rqt.professionalStatusKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.professionalStatusKind" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hccr.property.professionalStatusDate.label" /> *  <span><g:message code="hccr.property.professionalStatusDate.help" /></span></label>
            <input type="text" name="professionalStatusDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusDate)}" 
                   class="required validate-date" title="<g:message code="hccr.property.professionalStatusDate.validationError" />" />
            

    
      <label class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEnvironment.label" /> *  <span><g:message code="hccr.property.professionalStatusEnvironment.help" /></span></label>
            <select name="professionalStatusEnvironment" class="required condition-isEmployed-filled validate-not-first" title="<g:message code="hccr.property.professionalStatusEnvironment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Ordinary','Adapted','Protected']}">
                <option value="fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType_${it}" ${it == rqt.professionalStatusEnvironment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="hccr.property.professionalStatusEnvironment" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusProfession.label" /> *  <span><g:message code="hccr.property.professionalStatusProfession.help" /></span></label>
            <input type="text" name="professionalStatusProfession" value="${rqt.professionalStatusProfession}" 
                    class="required condition-isEmployed-filled " title="<g:message code="hccr.property.professionalStatusProfession.validationError" />"  maxLength="60"/>
            

    
      <label class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEmployerName.label" /> *  <span><g:message code="hccr.property.professionalStatusEmployerName.help" /></span></label>
            <input type="text" name="professionalStatusEmployerName" value="${rqt.professionalStatusEmployerName}" 
                    class="required condition-isEmployed-filled validate-lastName" title="<g:message code="hccr.property.professionalStatusEmployerName.validationError" />"  maxLength="38"/>
            

    
      <label class="condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusAddress.label" />   <span><g:message code="hccr.property.professionalStatusAddress.help" /></span></label>
            <div class="address-fieldset condition-isEmployed-filled">
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
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hccr.property.professionalStatusRegisterAsUnemployed.label" /> *  <span><g:message code="hccr.property.professionalStatusRegisterAsUnemployed.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger validate-boolean" title="" value="${it}" name="professionalStatusRegisterAsUnemployed" ${it == rqt.professionalStatusRegisterAsUnemployed ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isRegisteredAsUnemployed-filled"><g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.label" /> *  <span><g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.help" /></span></label>
            <input type="text" name="professionalStatusRegisterAsUnemployedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusRegisterAsUnemployedDate)}" 
                   class="required condition-isRegisteredAsUnemployed-filled validate-date" title="<g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.validationError" />" />
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hccr.property.professionalStatusIndemnified.label" /> *  <span><g:message code="hccr.property.professionalStatusIndemnified.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isUnemployed-filled condition-isIndemnified-trigger validate-boolean" title="" value="${it}" name="professionalStatusIndemnified" ${it == rqt.professionalStatusIndemnified ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isIndemnified-filled"><g:message code="hccr.property.professionalStatusIndemnifiedDate.label" /> *  <span><g:message code="hccr.property.professionalStatusIndemnifiedDate.help" /></span></label>
            <input type="text" name="professionalStatusIndemnifiedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusIndemnifiedDate)}" 
                   class="required condition-isIndemnified-filled validate-date" title="<g:message code="hccr.property.professionalStatusIndemnifiedDate.validationError" />" />
            

    
      <label class="required"><g:message code="hccr.property.professionalStatusElectiveFunction.label" /> *  <span><g:message code="hccr.property.professionalStatusElectiveFunction.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isElectiveFunction-trigger validate-boolean" title="" value="${it}" name="professionalStatusElectiveFunction" ${it == rqt.professionalStatusElectiveFunction ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isElectiveFunction-filled"><g:message code="hccr.property.professionalStatusElectiveFunctionDetails.label" /> *  <span><g:message code="hccr.property.professionalStatusElectiveFunctionDetails.help" /></span></label>
            <input type="text" name="professionalStatusElectiveFunctionDetails" value="${rqt.professionalStatusElectiveFunctionDetails}" 
                    class="required condition-isElectiveFunction-filled " title="<g:message code="hccr.property.professionalStatusElectiveFunctionDetails.validationError" />"  maxLength="60"/>
            

    
    </fieldset>
  

