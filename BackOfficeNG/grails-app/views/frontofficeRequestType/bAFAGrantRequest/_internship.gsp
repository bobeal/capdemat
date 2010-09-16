


  
    <label class="required"><g:message code="bgr.property.internshipStartDate.label" /> *  <span><g:message code="bgr.property.internshipStartDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['internship'].invalidFields.contains('internshipStartDate') ? 'validation-failed' : ''}"
                id="internshipStartDate_day"
                name="internshipStartDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.internshipStartDate?.date == it
                      || (rqt.internshipStartDate == null && params['internshipStartDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['internship'].invalidFields.contains('internshipStartDate') ? 'validation-failed' : ''}"
                id="internshipStartDate_month"
                name="internshipStartDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.internshipStartDate?.month == (it - 1)
                      || (rqt.internshipStartDate == null && params['internshipStartDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['internship'].invalidFields.contains('internshipStartDate') ? 'validation-failed' : ''}"
                id="internshipStartDate_year"
                name="internshipStartDate_year"
                value="${rqt.internshipStartDate ? rqt.internshipStartDate.year + 1900 : params['internshipStartDate_year']}"
                title="<g:message code="bgr.property.internshipStartDate.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="bgr.property.internshipEndDate.label" /> *  <span><g:message code="bgr.property.internshipEndDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['internship'].invalidFields.contains('internshipEndDate') ? 'validation-failed' : ''}"
                id="internshipEndDate_day"
                name="internshipEndDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.internshipEndDate?.date == it
                      || (rqt.internshipEndDate == null && params['internshipEndDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['internship'].invalidFields.contains('internshipEndDate') ? 'validation-failed' : ''}"
                id="internshipEndDate_month"
                name="internshipEndDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.internshipEndDate?.month == (it - 1)
                      || (rqt.internshipEndDate == null && params['internshipEndDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['internship'].invalidFields.contains('internshipEndDate') ? 'validation-failed' : ''}"
                id="internshipEndDate_year"
                name="internshipEndDate_year"
                value="${rqt.internshipEndDate ? rqt.internshipEndDate.year + 1900 : params['internshipEndDate_year']}"
                title="<g:message code="bgr.property.internshipEndDate.validationError" />" />
            </div>
            

  

  
    <label for="internshipInstituteName" class="required"><g:message code="bgr.property.internshipInstituteName.label" /> *  <span><g:message code="bgr.property.internshipInstituteName.help" /></span></label>
            <input type="text" id="internshipInstituteName" name="internshipInstituteName" value="${rqt.internshipInstituteName?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteName') ? 'validation-failed' : ''}" title="<g:message code="bgr.property.internshipInstituteName.validationError" />"   />
            

  

  
    <label class="required"><g:message code="bgr.property.internshipInstituteAddress.label" /> *  <span><g:message code="bgr.property.internshipInstituteAddress.help" /></span></label>
            <div class="address required  ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress') ? 'validation-failed' : ''}">
            <label for="internshipInstituteAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.additionalDeliveryInformation}" maxlength="38" id="internshipInstituteAddress.additionalDeliveryInformation" name="internshipInstituteAddress.additionalDeliveryInformation" />  
            <label for="internshipInstituteAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.additionalGeographicalInformation}" maxlength="38" id="internshipInstituteAddress.additionalGeographicalInformation" name="internshipInstituteAddress.additionalGeographicalInformation" />
            <label for="internshipInstituteAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="internshipInstituteAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.streetNumber}" size="5" maxlength="5" id="internshipInstituteAddress.streetNumber" name="internshipInstituteAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.streetName}" maxlength="32" id="internshipInstituteAddress.streetName" name="internshipInstituteAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="internshipInstituteAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.placeNameOrService}" maxlength="38" id="internshipInstituteAddress.placeNameOrService" name="internshipInstituteAddress.placeNameOrService" />
            <label for="internshipInstituteAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="internshipInstituteAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.postalCode}" size="5" maxlength="5" id="internshipInstituteAddress.postalCode" name="internshipInstituteAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.city') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.city}" maxlength="32" id="internshipInstituteAddress.city" name="internshipInstituteAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="internshipInstituteAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['internship'].invalidFields.contains('internshipInstituteAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.internshipInstituteAddress?.countryName}" maxlength="38" id="internshipInstituteAddress.countryName" name="internshipInstituteAddress.countryName" />
            </div>
            

  

