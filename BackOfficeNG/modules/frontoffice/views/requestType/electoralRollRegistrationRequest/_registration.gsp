


  
    <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="errr.property.subjectNationality.label" /> *  <span><g:message code="errr.property.subjectNationality.help" /></span></label>
            <select name="subjectNationality" class="required  validate-not-first" title="<g:message code="errr.property.subjectNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
                <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == rqt.subjectNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="errr.property.subjectNationality" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="errr.property.motive.label" /> *  <span><g:message code="errr.property.motive.help" /></span></label>
            <ul class="required">
              <g:each in="${['NewCityResident','DirectCityContribution','CivilServantObligatoryResident','FutureAuthorizedCitizen']}">
              <li>
                <input type="radio" class="required condition-isDirect-trigger  validate-one-required" value="fr.cg95.cvq.business.request.election.ElectoralMotiveType_${it}" name="motive" ${it == rqt.motive.toString() ? 'checked="checked"': ''} title="<g:message code="errr.property.motive.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="errr.property.motive" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-isDirect-unfilled"><g:message code="errr.property.subjectOldCity.label" /> *  <span><g:message code="errr.property.subjectOldCity.help" /></span></label>
            <input type="text" name="subjectOldCity" value="${rqt.subjectOldCity}" 
                    class="required condition-isDirect-unfilled  validate-city" title="<g:message code="errr.property.subjectOldCity.validationError" />"  maxLength="32"/>
            

  

  
    <label class="required condition-isDirect-filled"><g:message code="errr.property.subjectAddressOutsideCity.label" /> *  <span><g:message code="errr.property.subjectAddressOutsideCity.help" /></span></label>
            <div class="address-fieldset required condition-isDirect-filled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.subjectAddressOutsideCity?.additionalDeliveryInformation}" maxlength="38" name="subjectAddressOutsideCity.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.subjectAddressOutsideCity?.additionalGeographicalInformation}" maxlength="38" name="subjectAddressOutsideCity.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.subjectAddressOutsideCity?.streetNumber}" maxlength="5" name="subjectAddressOutsideCity.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.subjectAddressOutsideCity?.streetName}" maxlength="32" name="subjectAddressOutsideCity.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.subjectAddressOutsideCity?.placeNameOrService}" maxlength="38" name="subjectAddressOutsideCity.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.subjectAddressOutsideCity?.postalCode}" maxlength="5" name="subjectAddressOutsideCity.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.subjectAddressOutsideCity?.city}" maxlength="32" name="subjectAddressOutsideCity.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.subjectAddressOutsideCity?.countryName}" maxlength="38" name="subjectAddressOutsideCity.countryName"/>
            </div>
            

  

