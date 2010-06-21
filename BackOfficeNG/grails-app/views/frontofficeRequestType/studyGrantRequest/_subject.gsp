


  
    <fieldset class="required">
    <legend><g:message code="sgr.property.subjectInformations.label" /></legend>
    
      
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectFilling-trigger ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
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
            

    
      <label class="required"><g:message code="sgr.property.subjectAddress.label" /> *  <span><g:message code="sgr.property.subjectAddress.help" /></span></label>
            <div id="subjectAddress" class="address required autofill-subjectFilling-listener-Adress ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress') ? 'validation-failed' : ''}">
            <label for="subjectAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.additionalDeliveryInformation}" maxlength="38" id="subjectAddress.additionalDeliveryInformation" name="subjectAddress.additionalDeliveryInformation" />  
            <label for="subjectAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.additionalGeographicalInformation}" maxlength="38" id="subjectAddress.additionalGeographicalInformation" name="subjectAddress.additionalGeographicalInformation" />
            <label for="subjectAddress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="subjectAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.streetNumber}" size="5" maxlength="5" id="subjectAddress_streetNumber" name="subjectAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.streetName}" maxlength="32" id="subjectAddress_streetName" name="subjectAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.subjectAddress?.streetMatriculation}" id="subjectAddress_streetMatriculation" name="subjectAddress.streetMatriculation" />
            <input type="hidden" value="${rqt.subjectAddress?.streetRivoliCode}" id="subjectAddress_streetRivoliCode" name="subjectAddress.streetRivoliCode" />
            <label for="subjectAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.placeNameOrService}" maxlength="38" id="subjectAddress.placeNameOrService" name="subjectAddress.placeNameOrService" />
            <label for="subjectAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="subjectAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.postalCode}" size="5" maxlength="5" id="subjectAddress_postalCode" name="subjectAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.city') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.city}" maxlength="32" id="subjectAddress_city" name="subjectAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.subjectAddress?.cityInseeCode}" id="subjectAddress_cityInseeCode" name="subjectAddress.cityInseeCode" />
            <label for="subjectAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.subjectAddress?.countryName}" maxlength="38" id="subjectAddress.countryName" name="subjectAddress.countryName" />
            </div>
            

    
      <label for="subjectPhone" class=""><g:message code="sgr.property.subjectPhone.label" />   <span><g:message code="sgr.property.subjectPhone.help" /></span></label>
            <input type="text" id="subjectPhone" name="subjectPhone" value="${rqt.subjectPhone?.toString()}" 
                    class=" autofill-subjectFilling-listener-HomePhone validate-phone ${rqt.stepStates['subject'].invalidFields.contains('subjectPhone') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.subjectPhone.validationError" />"  maxlength="10" />
            

    
      <label for="subjectMobilePhone" class=""><g:message code="sgr.property.subjectMobilePhone.label" />   <span><g:message code="sgr.property.subjectMobilePhone.help" /></span></label>
            <input type="text" id="subjectMobilePhone" name="subjectMobilePhone" value="${rqt.subjectMobilePhone?.toString()}" 
                    class=" autofill-subjectFilling-listener-MobilePhone validate-mobilePhone ${rqt.stepStates['subject'].invalidFields.contains('subjectMobilePhone') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.subjectMobilePhone.validationError" />"  maxlength="10" />
            

    
      <label for="subjectEmail" class=""><g:message code="sgr.property.subjectEmail.label" />   <span><g:message code="sgr.property.subjectEmail.help" /></span></label>
            <input type="text" id="subjectEmail" name="subjectEmail" value="${rqt.subjectEmail?.toString()}" 
                    class=" autofill-subjectFilling-listener-Email validate-email ${rqt.stepStates['subject'].invalidFields.contains('subjectEmail') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.subjectEmail.validationError" />"   />
            

    
      <label class="required"><g:message code="sgr.property.subjectBirthDate.label" /> *  <span><g:message code="sgr.property.subjectBirthDate.help" /></span></label>
            <div class="date required autofill-subjectFilling-listener-BirthDate validate-date required autofill-subjectFilling-listener-BirthDate">
              <select class="day ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_day"
                name="subjectBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectBirthDate?.date == it
                      || (rqt.subjectBirthDate == null && params['subjectBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_month"
                name="subjectBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectBirthDate?.month == (it - 1)
                      || (rqt.subjectBirthDate == null && params['subjectBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthDate') ? 'validation-failed' : ''}"
                id="subjectBirthDate_year"
                name="subjectBirthDate_year"
                value="${rqt.subjectBirthDate ? rqt.subjectBirthDate.year + 1900 : params['subjectBirthDate_year']}"
                title="<g:message code="sgr.property.subjectBirthDate.validationError" />" />
            </div>
            

    
      <label class="required"><g:message code="sgr.property.subjectFirstRequest.label" /> *  <span><g:message code="sgr.property.subjectFirstRequest.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['subject'].invalidFields.contains('subjectFirstRequest') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="subjectFirstRequest_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="subjectFirstRequest" ${it == rqt.subjectFirstRequest ? 'checked="checked"': ''} />
                <label for="subjectFirstRequest_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

