


  
    
            <label for="subjectId" class="required">
              <g:message code="bgr.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${rqt.stepStates[currentStep].state != 'complete'}">
                <g:if test="${!fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_NONE.equals(subjectPolicy)}">
                  <g:if test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:if>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:elseif>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL.equals(subjectPolicy)}">
                    <span>(<a id="addAdultLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addAdult" /></a>
                    <g:message code="message.or" />
                    <a id="addChildLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addChild" /></a>)</span>
                  </g:elseif>
                </g:if>
              </g:if>
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectFilling-trigger ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="bgr.property.subjectBirthDate.label" /> *  <span><g:message code="bgr.property.subjectBirthDate.help" /></span></label>
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
                title="<g:message code="bgr.property.subjectBirthDate.validationError" />" />
            </div>
            

  

  
    <label for="subjectBirthCity" class="required"><g:message code="bgr.property.subjectBirthCity.label" /> *  <span><g:message code="bgr.property.subjectBirthCity.help" /></span></label>
            <input type="text" id="subjectBirthCity" name="subjectBirthCity" value="${rqt.subjectBirthCity?.toString()}" 
                    class="required autofill-subjectFilling-listener-BirthCity validate-city ${rqt.stepStates['subject'].invalidFields.contains('subjectBirthCity') ? 'validation-failed' : ''}" title="<g:message code="bgr.property.subjectBirthCity.validationError" />"  maxlength="32" />
            

  

  
    <label class="required"><g:message code="bgr.property.subjectAddress.label" /> *  <span><g:message code="bgr.property.subjectAddress.help" /></span></label>
            <div id="subjectAddress" class="address required autofill-subjectFilling-listener-Address ${rqt.stepStates['subject'].invalidFields.contains('subjectAddress') ? 'validation-failed' : ''}">
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
            

  

  
    <label for="subjectPhone" class="required"><g:message code="bgr.property.subjectPhone.label" /> *  <span><g:message code="bgr.property.subjectPhone.help" /></span></label>
            <input type="text" id="subjectPhone" name="subjectPhone" value="${rqt.subjectPhone?.toString()}" 
                    class="required autofill-subjectFilling-listener-homePhone validate-phone ${rqt.stepStates['subject'].invalidFields.contains('subjectPhone') ? 'validation-failed' : ''}" title="<g:message code="bgr.property.subjectPhone.validationError" />"  maxlength="10" />
            

  

  
    <label for="subjectEmail" class="required"><g:message code="bgr.property.subjectEmail.label" /> *  <span><g:message code="bgr.property.subjectEmail.help" /></span></label>
            <input type="text" id="subjectEmail" name="subjectEmail" value="${rqt.subjectEmail?.toString()}" 
                    class="required autofill-subjectFilling-listener-email validate-email ${rqt.stepStates['subject'].invalidFields.contains('subjectEmail') ? 'validation-failed' : ''}" title="<g:message code="bgr.property.subjectEmail.validationError" />"   />
            

  

