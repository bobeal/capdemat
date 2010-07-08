


  
    
            <label for="subjectId" class="required">
              <g:message code="request.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${!fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_NONE.equals(subjectPolicy)}">
                <g:if test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT.equals(subjectPolicy)}">
                  <span>(<a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                </g:if>
                <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD.equals(subjectPolicy)}">
                  <span>(<a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                </g:elseif>
                <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL.equals(subjectPolicy)}">
                  <span>(<a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addAdult" /></a>
                  <g:message code="message.or" />
                  <a href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addChild" /></a>)</span>
                </g:elseif>
              </g:if>
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['registration'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="subjectNationality" class="required"><g:message code="errr.property.subjectNationality.label" /> *  <span><g:message code="errr.property.subjectNationality.help" /></span></label>
            <select id="subjectNationality" name="subjectNationality" class="required  validate-not-first ${rqt.stepStates['registration'].invalidFields.contains('subjectNationality') ? 'validation-failed' : ''}" title="<g:message code="errr.property.subjectNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
                <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == rqt.subjectNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="errr.property.subjectNationality" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="errr.property.motive.label" /> *  <span><g:message code="errr.property.motive.help" /></span></label>
            <ul class="required ${rqt.stepStates['registration'].invalidFields.contains('motive') ? 'validation-failed' : ''}">
              <g:each in="${['NewCityResident','DirectCityContribution','CivilServantObligatoryResident','FutureAuthorizedCitizen']}">
              <li>
                <input type="radio" id="motive_${it}" class="required condition-isDirect-trigger  validate-one-required" value="fr.cg95.cvq.business.request.election.ElectoralMotiveType_${it}" name="motive" ${it == rqt.motive.toString() ? 'checked="checked"': ''} title="<g:message code="errr.property.motive.validationError" />" />
                <label for="motive_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="errr.property.motive" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="subjectOldCity" class="required condition-isDirect-unfilled"><g:message code="errr.property.subjectOldCity.label" /> *  <span><g:message code="errr.property.subjectOldCity.help" /></span></label>
            <input type="text" id="subjectOldCity" name="subjectOldCity" value="${rqt.subjectOldCity?.toString()}" 
                    class="required condition-isDirect-unfilled  validate-postalCode ${rqt.stepStates['registration'].invalidFields.contains('subjectOldCity') ? 'validation-failed' : ''}" title="<g:message code="errr.property.subjectOldCity.validationError" />"  maxlength="5" />
            

  

  
    <label class="required condition-isDirect-filled"><g:message code="errr.property.subjectAddressOutsideCity.label" /> *  <span><g:message code="errr.property.subjectAddressOutsideCity.help" /></span></label>
            <div id="subjectAddressOutsideCity" class="address required condition-isDirect-filled  ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity') ? 'validation-failed' : ''}">
            <label for="subjectAddressOutsideCity.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.additionalDeliveryInformation}" maxlength="38" id="subjectAddressOutsideCity.additionalDeliveryInformation" name="subjectAddressOutsideCity.additionalDeliveryInformation" />  
            <label for="subjectAddressOutsideCity.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.additionalGeographicalInformation}" maxlength="38" id="subjectAddressOutsideCity.additionalGeographicalInformation" name="subjectAddressOutsideCity.additionalGeographicalInformation" />
            <label for="subjectAddressOutsideCity_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="subjectAddressOutsideCity_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.streetNumber') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.streetNumber}" size="5" maxlength="5" id="subjectAddressOutsideCity_streetNumber" name="subjectAddressOutsideCity.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.streetName') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.streetName}" maxlength="32" id="subjectAddressOutsideCity_streetName" name="subjectAddressOutsideCity.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.subjectAddressOutsideCity?.streetMatriculation}" id="subjectAddressOutsideCity_streetMatriculation" name="subjectAddressOutsideCity.streetMatriculation" />
            <input type="hidden" value="${rqt.subjectAddressOutsideCity?.streetRivoliCode}" id="subjectAddressOutsideCity_streetRivoliCode" name="subjectAddressOutsideCity.streetRivoliCode" />
            <label for="subjectAddressOutsideCity.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.placeNameOrService}" maxlength="38" id="subjectAddressOutsideCity.placeNameOrService" name="subjectAddressOutsideCity.placeNameOrService" />
            <label for="subjectAddressOutsideCity_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="subjectAddressOutsideCity_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.postalCode') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.postalCode}" size="5" maxlength="5" id="subjectAddressOutsideCity_postalCode" name="subjectAddressOutsideCity.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.city') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.city}" maxlength="32" id="subjectAddressOutsideCity_city" name="subjectAddressOutsideCity.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.subjectAddressOutsideCity?.cityInseeCode}" id="subjectAddressOutsideCity_cityInseeCode" name="subjectAddressOutsideCity.cityInseeCode" />
            <label for="subjectAddressOutsideCity.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['registration'].invalidFields.contains('subjectAddressOutsideCity.countryName') ? 'validation-failed' : ''}" value="${rqt.subjectAddressOutsideCity?.countryName}" maxlength="38" id="subjectAddressOutsideCity.countryName" name="subjectAddressOutsideCity.countryName" />
            </div>
            

  

