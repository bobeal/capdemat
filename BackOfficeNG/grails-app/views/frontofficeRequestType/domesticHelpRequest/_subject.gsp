


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequester.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT].contains(subjectPolicy)}">
              <a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}">
                <g:message code="homeFolder.action.addAdult" />
              </a>
            </g:if>
            <g:if test="${[fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL, fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD].contains(subjectPolicy)}">
              <a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}">
                <g:message code="homeFolder.action.addChild" />
              </a>
            </g:if>
            

    
      <label class="required"><g:message code="dhr.property.dhrRequesterBirthDate.label" /> *  <span><g:message code="dhr.property.dhrRequesterBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterBirthDate') ? 'validation-failed' : ''}"
                id="dhrRequesterBirthDate_day"
                name="dhrRequesterBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrRequesterBirthDate?.date == it
                      || (rqt.dhrRequesterBirthDate == null && params['dhrRequesterBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterBirthDate') ? 'validation-failed' : ''}"
                id="dhrRequesterBirthDate_month"
                name="dhrRequesterBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrRequesterBirthDate?.month == (it - 1)
                      || (rqt.dhrRequesterBirthDate == null && params['dhrRequesterBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterBirthDate') ? 'validation-failed' : ''}"
                id="dhrRequesterBirthDate_year"
                name="dhrRequesterBirthDate_year"
                value="${rqt.dhrRequesterBirthDate ? rqt.dhrRequesterBirthDate.year + 1900 : params['dhrRequesterBirthDate_year']}"
                title="<g:message code="dhr.property.dhrRequesterBirthDate.validationError" />" />
            </div>
            

    
      <label for="dhrRequesterBirthPlace" class="required"><g:message code="dhr.property.dhrRequesterBirthPlace.label" /> *  <span><g:message code="dhr.property.dhrRequesterBirthPlace.help" /></span></label>
            <input type="text" id="dhrRequesterBirthPlace" name="dhrRequesterBirthPlace" value="${rqt.dhrRequesterBirthPlace?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterBirthPlace') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrRequesterBirthPlace.validationError" />"   />
            

    
      <label for="dhrRequesterNationality" class="required"><g:message code="dhr.property.dhrRequesterNationality.label" /> *  <span><g:message code="dhr.property.dhrRequesterNationality.help" /></span></label>
            <select id="dhrRequesterNationality" name="dhrRequesterNationality" class="required condition-isNonEuropean-trigger  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterNationality') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrRequesterNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
                <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == rqt.dhrRequesterNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrRequesterNationality" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrRequesterFranceArrivalDate.help" /></span></label>
            <div class="date required condition-isNonEuropean-filled  validate-date required condition-isNonEuropean-filled ">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterFranceArrivalDate') ? 'validation-failed' : ''}"
                id="dhrRequesterFranceArrivalDate_day"
                name="dhrRequesterFranceArrivalDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrRequesterFranceArrivalDate?.date == it
                      || (rqt.dhrRequesterFranceArrivalDate == null && params['dhrRequesterFranceArrivalDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterFranceArrivalDate') ? 'validation-failed' : ''}"
                id="dhrRequesterFranceArrivalDate_month"
                name="dhrRequesterFranceArrivalDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrRequesterFranceArrivalDate?.month == (it - 1)
                      || (rqt.dhrRequesterFranceArrivalDate == null && params['dhrRequesterFranceArrivalDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterFranceArrivalDate') ? 'validation-failed' : ''}"
                id="dhrRequesterFranceArrivalDate_year"
                name="dhrRequesterFranceArrivalDate_year"
                value="${rqt.dhrRequesterFranceArrivalDate ? rqt.dhrRequesterFranceArrivalDate.year + 1900 : params['dhrRequesterFranceArrivalDate_year']}"
                title="<g:message code="dhr.property.dhrRequesterFranceArrivalDate.validationError" />" />
            </div>
            

    
      <label class="required condition-isNonEuropean-filled"><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /> *  <span><g:message code="dhr.property.dhrRequesterIsFrenchResident.help" /></span></label>
            <ul class="yes-no required condition-isNonEuropean-filled ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterIsFrenchResident') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="dhrRequesterIsFrenchResident_${it ? 'yes' : 'no'}" class="required condition-isNonEuropean-filled  validate-one-required boolean" title="" value="${it}" name="dhrRequesterIsFrenchResident" ${it == rqt.dhrRequesterIsFrenchResident ? 'checked="checked"': ''} />
                <label for="dhrRequesterIsFrenchResident_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></legend>
    
      <label for="dhrPrincipalPensionPlan" class="required"><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /> *  <span><g:message code="dhr.property.dhrPrincipalPensionPlan.help" /></span></label>
            <select id="dhrPrincipalPensionPlan" name="dhrPrincipalPensionPlan" class="required condition-isOtherPensionPlan-trigger  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('dhrPrincipalPensionPlan') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPrincipalPensionPlan.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == rqt.dhrPrincipalPensionPlan?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPrincipalPensionPlan" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrPensionPlanDetail" class="required condition-isOtherPensionPlan-filled"><g:message code="dhr.property.dhrPensionPlanDetail.label" /> *  <span><g:message code="dhr.property.dhrPensionPlanDetail.help" /></span></label>
            <input type="text" id="dhrPensionPlanDetail" name="dhrPensionPlanDetail" value="${rqt.dhrPensionPlanDetail?.toString()}" 
                    class="required condition-isOtherPensionPlan-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('dhrPensionPlanDetail') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPensionPlanDetail.validationError" />"   />
            

    
      <label for="dhrComplementaryPensionPlan" class="required"><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /> *  <span><g:message code="dhr.property.dhrComplementaryPensionPlan.help" /></span></label>
            <input type="text" id="dhrComplementaryPensionPlan" name="dhrComplementaryPensionPlan" value="${rqt.dhrComplementaryPensionPlan?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['subject'].invalidFields.contains('dhrComplementaryPensionPlan') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrComplementaryPensionPlan.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrRequesterGuardian.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /> *  <span><g:message code="dhr.property.dhrRequesterHaveGuardian.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('dhrRequesterHaveGuardian') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="dhrRequesterHaveGuardian_${it ? 'yes' : 'no'}" class="required condition-haveGuardian-trigger  validate-one-required boolean" title="" value="${it}" name="dhrRequesterHaveGuardian" ${it == rqt.dhrRequesterHaveGuardian ? 'checked="checked"': ''} />
                <label for="dhrRequesterHaveGuardian_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="dhrGuardianMeasure" class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianMeasure.label" /> *  <span><g:message code="dhr.property.dhrGuardianMeasure.help" /></span></label>
            <select id="dhrGuardianMeasure" name="dhrGuardianMeasure" class="required condition-haveGuardian-filled  validate-not-first ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianMeasure') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrGuardianMeasure.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
                <option value="fr.cg95.cvq.business.request.social.DhrGuardianMeasureType_${it}" ${it == rqt.dhrGuardianMeasure?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrGuardianMeasure" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrGuardianName" class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianName.label" /> *  <span><g:message code="dhr.property.dhrGuardianName.help" /></span></label>
            <input type="text" id="dhrGuardianName" name="dhrGuardianName" value="${rqt.dhrGuardianName?.toString()}" 
                    class="required condition-haveGuardian-filled  validate-lastName ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrGuardianName.validationError" />"  maxlength="38" />
            

    
      <label class="required condition-haveGuardian-filled"><g:message code="dhr.property.dhrGuardianAddress.label" /> *  <span><g:message code="dhr.property.dhrGuardianAddress.help" /></span></label>
            <div id="dhrGuardianAddress" class="address required condition-haveGuardian-filled  ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress') ? 'validation-failed' : ''}">
            <label for="dhrGuardianAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrGuardianAddress.additionalDeliveryInformation" name="dhrGuardianAddress.additionalDeliveryInformation" />  
            <label for="dhrGuardianAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrGuardianAddress.additionalGeographicalInformation" name="dhrGuardianAddress.additionalGeographicalInformation" />
            <label for="dhrGuardianAddress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrGuardianAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.streetNumber}" size="5" maxlength="5" id="dhrGuardianAddress_streetNumber" name="dhrGuardianAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.streetName}" maxlength="32" id="dhrGuardianAddress_streetName" name="dhrGuardianAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.dhrGuardianAddress?.streetMatriculation}" id="dhrGuardianAddress_streetMatriculation" name="dhrGuardianAddress.streetMatriculation" />
            <input type="hidden" value="${rqt.dhrGuardianAddress?.streetRivoliCode}" id="dhrGuardianAddress_streetRivoliCode" name="dhrGuardianAddress.streetRivoliCode" />
            <label for="dhrGuardianAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.placeNameOrService}" maxlength="38" id="dhrGuardianAddress.placeNameOrService" name="dhrGuardianAddress.placeNameOrService" />
            <label for="dhrGuardianAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrGuardianAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.postalCode}" size="5" maxlength="5" id="dhrGuardianAddress_postalCode" name="dhrGuardianAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.city') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.city}" maxlength="32" id="dhrGuardianAddress_city" name="dhrGuardianAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.dhrGuardianAddress?.cityInseeCode}" id="dhrGuardianAddress_cityInseeCode" name="dhrGuardianAddress.cityInseeCode" />
            <label for="dhrGuardianAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('dhrGuardianAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.dhrGuardianAddress?.countryName}" maxlength="38" id="dhrGuardianAddress.countryName" name="dhrGuardianAddress.countryName" />
            </div>
            

    
    </fieldset>
  

