


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.schooling.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.schoolingEnrolment.label" /> *  <span><g:message code="hccr.property.schoolingEnrolment.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingEnrolment') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="schoolingEnrolment_${it ? 'yes' : 'no'}" class="required condition-isSchoolingEnrolment-trigger  validate-one-required boolean" title="" value="${it}" name="schoolingEnrolment" ${it == rqt.schoolingEnrolment ? 'checked="checked"': ''} />
                <label for="schoolingEnrolment_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="schoolingSchoolName" class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolName.label" /> *  <span><g:message code="hccr.property.schoolingSchoolName.help" /></span></label>
            <input type="text" id="schoolingSchoolName" name="schoolingSchoolName" value="${rqt.schoolingSchoolName?.toString()}" 
                    class="required condition-isSchoolingEnrolment-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingSchoolName.validationError" />"  maxlength="80" />
            

    
      <label class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolAddress.label" /> *  <span><g:message code="hccr.property.schoolingSchoolAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSchoolingEnrolment-filled  ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress') ? 'validation-failed' : ''}">
            <label for="schoolingSchoolAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.additionalDeliveryInformation}" maxlength="38" id="schoolingSchoolAddress.additionalDeliveryInformation" name="schoolingSchoolAddress.additionalDeliveryInformation" />  
            <label for="schoolingSchoolAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.additionalGeographicalInformation}" maxlength="38" id="schoolingSchoolAddress.additionalGeographicalInformation" name="schoolingSchoolAddress.additionalGeographicalInformation" />
            <label for="schoolingSchoolAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="schoolingSchoolAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.streetNumber}" size="5" maxlength="5" id="schoolingSchoolAddress.streetNumber" name="schoolingSchoolAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.streetName}" maxlength="32" id="schoolingSchoolAddress.streetName" name="schoolingSchoolAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="schoolingSchoolAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.placeNameOrService}" maxlength="38" id="schoolingSchoolAddress.placeNameOrService" name="schoolingSchoolAddress.placeNameOrService" />
            <label for="schoolingSchoolAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="schoolingSchoolAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.postalCode}" size="5" maxlength="5" id="schoolingSchoolAddress.postalCode" name="schoolingSchoolAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.city') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.city}" maxlength="32" id="schoolingSchoolAddress.city" name="schoolingSchoolAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="schoolingSchoolAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.schoolingSchoolAddress?.countryName}" maxlength="38" id="schoolingSchoolAddress.countryName" name="schoolingSchoolAddress.countryName" />
            </div>
            

    
      <label class="required"><g:message code="hccr.property.schoolingSendToSchool.label" /> *  <span><g:message code="hccr.property.schoolingSendToSchool.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSendToSchool') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="schoolingSendToSchool_${it ? 'yes' : 'no'}" class="required condition-isSentToSchool-trigger  validate-one-required boolean" title="" value="${it}" name="schoolingSendToSchool" ${it == rqt.schoolingSendToSchool ? 'checked="checked"': ''} />
                <label for="schoolingSendToSchool_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="schoolingAttendedGrade" class="required condition-isSentToSchool-filled"><g:message code="hccr.property.schoolingAttendedGrade.label" /> *  <span><g:message code="hccr.property.schoolingAttendedGrade.help" /></span></label>
            <select id="schoolingAttendedGrade" name="schoolingAttendedGrade" class="required condition-isSentToSchool-filled  validate-not-first ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingAttendedGrade') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingAttendedGrade.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['BeforeFirstSection','FirstSection','SecondSection','ThirdSection','CP','CE1','CE2','CM1','CM2','CLISS','Unknown']}">
                <option value="fr.cg95.cvq.business.users.SectionType_${it}" ${it == rqt.schoolingAttendedGrade?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.schoolingAttendedGrade" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="hccr.property.schoolingSpecializedGrade.label" /> *  <span><g:message code="hccr.property.schoolingSpecializedGrade.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSpecializedGrade') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="schoolingSpecializedGrade_${it ? 'yes' : 'no'}" class="required condition-isSpecializedGrade-trigger  validate-one-required boolean" title="" value="${it}" name="schoolingSpecializedGrade" ${it == rqt.schoolingSpecializedGrade ? 'checked="checked"': ''} />
                <label for="schoolingSpecializedGrade_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="schoolingSpecializedGradeDetails" class="required condition-isSpecializedGrade-filled"><g:message code="hccr.property.schoolingSpecializedGradeDetails.label" /> *  <span><g:message code="hccr.property.schoolingSpecializedGradeDetails.help" /></span></label>
            <input type="text" id="schoolingSpecializedGradeDetails" name="schoolingSpecializedGradeDetails" value="${rqt.schoolingSpecializedGradeDetails?.toString()}" 
                    class="required condition-isSpecializedGrade-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSpecializedGradeDetails') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingSpecializedGradeDetails.validationError" />"  maxlength="30" />
            

    
      <label for="schoolingSchoolingKind" class="required"><g:message code="hccr.property.schoolingSchoolingKind.label" /> *  <span><g:message code="hccr.property.schoolingSchoolingKind.help" /></span></label>
            <select id="schoolingSchoolingKind" name="schoolingSchoolingKind" class="required condition-isPartTimeSchooling-trigger  validate-not-first ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingSchoolingKind') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingSchoolingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['FullTime','PartTime']}">
                <option value="fr.cg95.cvq.business.request.social.HccrSchoolingKindType_${it}" ${it == rqt.schoolingSchoolingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.schoolingSchoolingKind" /></option>
              </g:each>
            </select>
            

    
      <label for="schoolingTime" class="required condition-isPartTimeSchooling-filled"><g:message code="hccr.property.schoolingTime.label" /> *  <span><g:message code="hccr.property.schoolingTime.help" /></span></label>
            <input type="text" id="schoolingTime" name="schoolingTime" value="${rqt.schoolingTime?.toString()}" 
                    class="required condition-isPartTimeSchooling-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingTime') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingTime.validationError" />"   />
            

    
      <label class="required"><g:message code="hccr.property.schoolingHomeSchooling.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchooling.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchooling') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="schoolingHomeSchooling_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="schoolingHomeSchooling" ${it == rqt.schoolingHomeSchooling ? 'checked="checked"': ''} />
                <label for="schoolingHomeSchooling_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="hccr.property.schoolingPersonalizedSchoolingPlan.label" /> *  <span><g:message code="hccr.property.schoolingPersonalizedSchoolingPlan.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingPersonalizedSchoolingPlan') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="schoolingPersonalizedSchoolingPlan_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="schoolingPersonalizedSchoolingPlan" ${it == rqt.schoolingPersonalizedSchoolingPlan ? 'checked="checked"': ''} />
                <label for="schoolingPersonalizedSchoolingPlan_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="schoolingHomeSchoolingKind" class="required"><g:message code="hccr.property.schoolingHomeSchoolingKind.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchoolingKind.help" /></span></label>
            <select id="schoolingHomeSchoolingKind" name="schoolingHomeSchoolingKind" class="required condition-isAccompaniedHomeSchooling-trigger  validate-not-first ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingKind') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingHomeSchoolingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Alone','Accompanied']}">
                <option value="fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType_${it}" ${it == rqt.schoolingHomeSchoolingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.schoolingHomeSchoolingKind" /></option>
              </g:each>
            </select>
            

    
      <label for="schoolingHomeSchoolingAccompanistLastName" class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.help" /></span></label>
            <input type="text" id="schoolingHomeSchoolingAccompanistLastName" name="schoolingHomeSchoolingAccompanistLastName" value="${rqt.schoolingHomeSchoolingAccompanistLastName?.toString()}" 
                    class="required condition-isAccompaniedHomeSchooling-filled  validate-lastName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistLastName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.validationError" />"  maxlength="38" />
            

    
      <label for="schoolingHomeSchoolingAccompanistFirstName" class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.label" /> *  <span><g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.help" /></span></label>
            <input type="text" id="schoolingHomeSchoolingAccompanistFirstName" name="schoolingHomeSchoolingAccompanistFirstName" value="${rqt.schoolingHomeSchoolingAccompanistFirstName?.toString()}" 
                    class="required condition-isAccompaniedHomeSchooling-filled  validate-firstName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistFirstName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.validationError" />"  maxlength="38" />
            

    
      <label class="condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistAddress.label" />   <span><g:message code="hccr.property.schoolingHomeSchoolingAccompanistAddress.help" /></span></label>
            <div class="address-fieldset condition-isAccompaniedHomeSchooling-filled  ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress') ? 'validation-failed' : ''}">
            <label for="schoolingHomeSchoolingAccompanistAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.additionalDeliveryInformation}" maxlength="38" id="schoolingHomeSchoolingAccompanistAddress.additionalDeliveryInformation" name="schoolingHomeSchoolingAccompanistAddress.additionalDeliveryInformation" />  
            <label for="schoolingHomeSchoolingAccompanistAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.additionalGeographicalInformation}" maxlength="38" id="schoolingHomeSchoolingAccompanistAddress.additionalGeographicalInformation" name="schoolingHomeSchoolingAccompanistAddress.additionalGeographicalInformation" />
            <label for="schoolingHomeSchoolingAccompanistAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="schoolingHomeSchoolingAccompanistAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.streetNumber}" size="5" maxlength="5" id="schoolingHomeSchoolingAccompanistAddress.streetNumber" name="schoolingHomeSchoolingAccompanistAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.streetName}" maxlength="32" id="schoolingHomeSchoolingAccompanistAddress.streetName" name="schoolingHomeSchoolingAccompanistAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="schoolingHomeSchoolingAccompanistAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.placeNameOrService}" maxlength="38" id="schoolingHomeSchoolingAccompanistAddress.placeNameOrService" name="schoolingHomeSchoolingAccompanistAddress.placeNameOrService" />
            <label for="schoolingHomeSchoolingAccompanistAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="schoolingHomeSchoolingAccompanistAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.postalCode}" size="5" maxlength="5" id="schoolingHomeSchoolingAccompanistAddress.postalCode" name="schoolingHomeSchoolingAccompanistAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.city') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.city}" maxlength="32" id="schoolingHomeSchoolingAccompanistAddress.city" name="schoolingHomeSchoolingAccompanistAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="schoolingHomeSchoolingAccompanistAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingHomeSchoolingAccompanistAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.schoolingHomeSchoolingAccompanistAddress?.countryName}" maxlength="38" id="schoolingHomeSchoolingAccompanistAddress.countryName" name="schoolingHomeSchoolingAccompanistAddress.countryName" />
            </div>
            

    
      <label class="required"><g:message code="hccr.property.schoolingExtraCurricular.label" /> *  <span><g:message code="hccr.property.schoolingExtraCurricular.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingExtraCurricular') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="schoolingExtraCurricular_${it ? 'yes' : 'no'}" class="required condition-isExtraCurricular-trigger  validate-one-required boolean" title="" value="${it}" name="schoolingExtraCurricular" ${it == rqt.schoolingExtraCurricular ? 'checked="checked"': ''} />
                <label for="schoolingExtraCurricular_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="schoolingExtraCurricularDetails" class="required condition-isExtraCurricular-filled"><g:message code="hccr.property.schoolingExtraCurricularDetails.label" /> *  <span><g:message code="hccr.property.schoolingExtraCurricularDetails.help" /></span></label>
            <input type="text" id="schoolingExtraCurricularDetails" name="schoolingExtraCurricularDetails" value="${rqt.schoolingExtraCurricularDetails?.toString()}" 
                    class="required condition-isExtraCurricular-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('schoolingExtraCurricularDetails') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.schoolingExtraCurricularDetails.validationError" />"  maxlength="50" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.studies.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.studiesHighSchool.label" /> *  <span><g:message code="hccr.property.studiesHighSchool.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchool') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="studiesHighSchool_${it ? 'yes' : 'no'}" class="required condition-isHighSchool-trigger  validate-one-required boolean" title="" value="${it}" name="studiesHighSchool" ${it == rqt.studiesHighSchool ? 'checked="checked"': ''} />
                <label for="studiesHighSchool_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="studiesHighSchoolGrade" class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolGrade.label" /> *  <span><g:message code="hccr.property.studiesHighSchoolGrade.help" /></span></label>
            <input type="text" id="studiesHighSchoolGrade" name="studiesHighSchoolGrade" value="${rqt.studiesHighSchoolGrade?.toString()}" 
                    class="required condition-isHighSchool-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolGrade') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.studiesHighSchoolGrade.validationError" />"  maxlength="60" />
            

    
      <label for="studiesHighSchoolName" class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolName.label" /> *  <span><g:message code="hccr.property.studiesHighSchoolName.help" /></span></label>
            <input type="text" id="studiesHighSchoolName" name="studiesHighSchoolName" value="${rqt.studiesHighSchoolName?.toString()}" 
                    class="required condition-isHighSchool-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.studiesHighSchoolName.validationError" />"  maxlength="60" />
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolAddress.label" /> *  <span><g:message code="hccr.property.studiesHighSchoolAddress.help" /></span></label>
            <div class="address-fieldset required condition-isHighSchool-filled  ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress') ? 'validation-failed' : ''}">
            <label for="studiesHighSchoolAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.additionalDeliveryInformation}" maxlength="38" id="studiesHighSchoolAddress.additionalDeliveryInformation" name="studiesHighSchoolAddress.additionalDeliveryInformation" />  
            <label for="studiesHighSchoolAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.additionalGeographicalInformation}" maxlength="38" id="studiesHighSchoolAddress.additionalGeographicalInformation" name="studiesHighSchoolAddress.additionalGeographicalInformation" />
            <label for="studiesHighSchoolAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="studiesHighSchoolAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.streetNumber}" size="5" maxlength="5" id="studiesHighSchoolAddress.streetNumber" name="studiesHighSchoolAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.streetName}" maxlength="32" id="studiesHighSchoolAddress.streetName" name="studiesHighSchoolAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="studiesHighSchoolAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.placeNameOrService}" maxlength="38" id="studiesHighSchoolAddress.placeNameOrService" name="studiesHighSchoolAddress.placeNameOrService" />
            <label for="studiesHighSchoolAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="studiesHighSchoolAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.postalCode}" size="5" maxlength="5" id="studiesHighSchoolAddress.postalCode" name="studiesHighSchoolAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.city') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.city}" maxlength="32" id="studiesHighSchoolAddress.city" name="studiesHighSchoolAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="studiesHighSchoolAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesHighSchoolAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.studiesHighSchoolAddress?.countryName}" maxlength="38" id="studiesHighSchoolAddress.countryName" name="studiesHighSchoolAddress.countryName" />
            </div>
            

    
      <label class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesAssistanceUnderDisability.label" /> *  <span><g:message code="hccr.property.studiesAssistanceUnderDisability.help" /></span></label>
            <ul class="yes-no required condition-isHighSchool-filled ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesAssistanceUnderDisability') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="studiesAssistanceUnderDisability_${it ? 'yes' : 'no'}" class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger  validate-one-required boolean" title="" value="${it}" name="studiesAssistanceUnderDisability" ${it == rqt.studiesAssistanceUnderDisability ? 'checked="checked"': ''} />
                <label for="studiesAssistanceUnderDisability_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="studiesAssistanceUnderDisabilityDetails" class="required condition-isAssistanceUnderDisability-filled"><g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.label" /> *  <span><g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.help" /></span></label>
            <input type="text" id="studiesAssistanceUnderDisabilityDetails" name="studiesAssistanceUnderDisabilityDetails" value="${rqt.studiesAssistanceUnderDisabilityDetails?.toString()}" 
                    class="required condition-isAssistanceUnderDisability-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('studiesAssistanceUnderDisabilityDetails') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.formation.label" /></legend>
    
      <label for="formationStudiesLevel" class=""><g:message code="hccr.property.formationStudiesLevel.label" />   <span><g:message code="hccr.property.formationStudiesLevel.help" /></span></label>
            <input type="text" id="formationStudiesLevel" name="formationStudiesLevel" value="${rqt.formationStudiesLevel?.toString()}" 
                    class="   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationStudiesLevel') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.formationStudiesLevel.validationError" />"  maxlength="30" />
            

    
      <label for="formationDiploma" class=""><g:message code="hccr.property.formationDiploma.label" />   <span><g:message code="hccr.property.formationDiploma.help" /></span></label>
            <textarea id="formationDiploma" name="formationDiploma" class="  validate-textarea ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationDiploma') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.formationDiploma.validationError" />" rows="2" cols=""  maxlength="120">${rqt.formationDiploma}</textarea>
            

    
      <label for="formationPreviousFormation" class=""><g:message code="hccr.property.formationPreviousFormation.label" />   <span><g:message code="hccr.property.formationPreviousFormation.help" /></span></label>
            <textarea id="formationPreviousFormation" name="formationPreviousFormation" class="  validate-textarea ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationPreviousFormation') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.formationPreviousFormation.validationError" />" rows="3" cols=""  maxlength="180">${rqt.formationPreviousFormation}</textarea>
            

    
      <label for="formationCurrentFormation" class=""><g:message code="hccr.property.formationCurrentFormation.label" />   <span><g:message code="hccr.property.formationCurrentFormation.help" /></span></label>
            <textarea id="formationCurrentFormation" name="formationCurrentFormation" class="  validate-textarea ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('formationCurrentFormation') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.formationCurrentFormation.validationError" />" rows="2" cols=""  maxlength="120">${rqt.formationCurrentFormation}</textarea>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="hccr.property.professionalStatus.label" /></legend>
    
      <label for="professionalStatusKind" class="required"><g:message code="hccr.property.professionalStatusKind.label" /> *  <span><g:message code="hccr.property.professionalStatusKind.help" /></span></label>
            <select id="professionalStatusKind" name="professionalStatusKind" class="required condition-isEmployed-trigger condition-isUnemployed-trigger  validate-not-first ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusKind') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Employee','Unemployed','Jobless','Student','Retired']}">
                <option value="fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType_${it}" ${it == rqt.professionalStatusKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.professionalStatusKind" /></option>
              </g:each>
            </select>
            

    
      <label for="professionalStatusDate" class="required"><g:message code="hccr.property.professionalStatusDate.label" /> *  <span><g:message code="hccr.property.professionalStatusDate.help" /></span></label>
            <input type="text" id="professionalStatusDate" name="professionalStatusDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusDate)}" 
                   class="required  validate-date ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusDate') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusDate.validationError" />" />
            

    
      <label for="professionalStatusEnvironment" class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEnvironment.label" /> *  <span><g:message code="hccr.property.professionalStatusEnvironment.help" /></span></label>
            <select id="professionalStatusEnvironment" name="professionalStatusEnvironment" class="required condition-isEmployed-filled  validate-not-first ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusEnvironment') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusEnvironment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Ordinary','Adapted','Protected']}">
                <option value="fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType_${it}" ${it == rqt.professionalStatusEnvironment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="hccr.property.professionalStatusEnvironment" /></option>
              </g:each>
            </select>
            

    
      <label for="professionalStatusProfession" class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusProfession.label" /> *  <span><g:message code="hccr.property.professionalStatusProfession.help" /></span></label>
            <input type="text" id="professionalStatusProfession" name="professionalStatusProfession" value="${rqt.professionalStatusProfession?.toString()}" 
                    class="required condition-isEmployed-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusProfession') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusProfession.validationError" />"  maxlength="60" />
            

    
      <label for="professionalStatusEmployerName" class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEmployerName.label" /> *  <span><g:message code="hccr.property.professionalStatusEmployerName.help" /></span></label>
            <input type="text" id="professionalStatusEmployerName" name="professionalStatusEmployerName" value="${rqt.professionalStatusEmployerName?.toString()}" 
                    class="required condition-isEmployed-filled  validate-lastName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusEmployerName') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusEmployerName.validationError" />"  maxlength="38" />
            

    
      <label class="condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusAddress.label" />   <span><g:message code="hccr.property.professionalStatusAddress.help" /></span></label>
            <div class="address-fieldset condition-isEmployed-filled  ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress') ? 'validation-failed' : ''}">
            <label for="professionalStatusAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.additionalDeliveryInformation}" maxlength="38" id="professionalStatusAddress.additionalDeliveryInformation" name="professionalStatusAddress.additionalDeliveryInformation" />  
            <label for="professionalStatusAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.additionalGeographicalInformation}" maxlength="38" id="professionalStatusAddress.additionalGeographicalInformation" name="professionalStatusAddress.additionalGeographicalInformation" />
            <label for="professionalStatusAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="professionalStatusAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.streetNumber}" size="5" maxlength="5" id="professionalStatusAddress.streetNumber" name="professionalStatusAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.streetName}" maxlength="32" id="professionalStatusAddress.streetName" name="professionalStatusAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="professionalStatusAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.placeNameOrService}" maxlength="38" id="professionalStatusAddress.placeNameOrService" name="professionalStatusAddress.placeNameOrService" />
            <label for="professionalStatusAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="professionalStatusAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.postalCode}" size="5" maxlength="5" id="professionalStatusAddress.postalCode" name="professionalStatusAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.city') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.city}" maxlength="32" id="professionalStatusAddress.city" name="professionalStatusAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="professionalStatusAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.professionalStatusAddress?.countryName}" maxlength="38" id="professionalStatusAddress.countryName" name="professionalStatusAddress.countryName" />
            </div>
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hccr.property.professionalStatusRegisterAsUnemployed.label" /> *  <span><g:message code="hccr.property.professionalStatusRegisterAsUnemployed.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusRegisterAsUnemployed') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalStatusRegisterAsUnemployed_${it ? 'yes' : 'no'}" class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger  validate-one-required boolean" title="" value="${it}" name="professionalStatusRegisterAsUnemployed" ${it == rqt.professionalStatusRegisterAsUnemployed ? 'checked="checked"': ''} />
                <label for="professionalStatusRegisterAsUnemployed_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalStatusRegisterAsUnemployedDate" class="required condition-isRegisteredAsUnemployed-filled"><g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.label" /> *  <span><g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.help" /></span></label>
            <input type="text" id="professionalStatusRegisterAsUnemployedDate" name="professionalStatusRegisterAsUnemployedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusRegisterAsUnemployedDate)}" 
                   class="required condition-isRegisteredAsUnemployed-filled  validate-date ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusRegisterAsUnemployedDate') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.validationError" />" />
            

    
      <label class="required condition-isUnemployed-filled"><g:message code="hccr.property.professionalStatusIndemnified.label" /> *  <span><g:message code="hccr.property.professionalStatusIndemnified.help" /></span></label>
            <ul class="yes-no required condition-isUnemployed-filled ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusIndemnified') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalStatusIndemnified_${it ? 'yes' : 'no'}" class="required condition-isUnemployed-filled condition-isIndemnified-trigger  validate-one-required boolean" title="" value="${it}" name="professionalStatusIndemnified" ${it == rqt.professionalStatusIndemnified ? 'checked="checked"': ''} />
                <label for="professionalStatusIndemnified_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalStatusIndemnifiedDate" class="required condition-isIndemnified-filled"><g:message code="hccr.property.professionalStatusIndemnifiedDate.label" /> *  <span><g:message code="hccr.property.professionalStatusIndemnifiedDate.help" /></span></label>
            <input type="text" id="professionalStatusIndemnifiedDate" name="professionalStatusIndemnifiedDate" value="${formatDate(formatName:'format.date',date:rqt.professionalStatusIndemnifiedDate)}" 
                   class="required condition-isIndemnified-filled  validate-date ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusIndemnifiedDate') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusIndemnifiedDate.validationError" />" />
            

    
      <label class="required"><g:message code="hccr.property.professionalStatusElectiveFunction.label" /> *  <span><g:message code="hccr.property.professionalStatusElectiveFunction.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusElectiveFunction') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="professionalStatusElectiveFunction_${it ? 'yes' : 'no'}" class="required condition-isElectiveFunction-trigger  validate-one-required boolean" title="" value="${it}" name="professionalStatusElectiveFunction" ${it == rqt.professionalStatusElectiveFunction ? 'checked="checked"': ''} />
                <label for="professionalStatusElectiveFunction_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="professionalStatusElectiveFunctionDetails" class="required condition-isElectiveFunction-filled"><g:message code="hccr.property.professionalStatusElectiveFunctionDetails.label" /> *  <span><g:message code="hccr.property.professionalStatusElectiveFunctionDetails.help" /></span></label>
            <input type="text" id="professionalStatusElectiveFunctionDetails" name="professionalStatusElectiveFunctionDetails" value="${rqt.professionalStatusElectiveFunctionDetails?.toString()}" 
                    class="required condition-isElectiveFunction-filled   ${stepStates != null && stepStates['occupationnalAndSchoolStatus']?.invalidFields.contains('professionalStatusElectiveFunctionDetails') ? 'validation-failed' : ''}" title="<g:message code="hccr.property.professionalStatusElectiveFunctionDetails.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

