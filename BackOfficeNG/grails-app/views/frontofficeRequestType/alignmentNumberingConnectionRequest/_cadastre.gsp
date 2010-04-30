


  
    <label for="requesterQuality" class="required"><g:message code="ancr.property.requesterQuality.label" /> *  <span><g:message code="ancr.property.requesterQuality.help" /></span></label>
            <select id="requesterQuality" name="requesterQuality" class="required condition-isOwner-trigger  validate-not-first ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('requesterQuality') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.requesterQuality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Owner','Tenant','Cabinet']}">
                <option value="fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType_${it}" ${it == rqt.requesterQuality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ancr.property.requesterQuality" /></option>
              </g:each>
            </select>
            

  

  
    <label for="ownerLastName" class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerLastName.label" /> *  <span><g:message code="ancr.property.ownerLastName.help" /></span></label>
            <input type="text" id="ownerLastName" name="ownerLastName" value="${rqt.ownerLastName?.toString()}" 
                    class="required condition-isOwner-unfilled  validate-lastName ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerLastName') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.ownerLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="ownerFirstNames" class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerFirstNames.label" /> *  <span><g:message code="ancr.property.ownerFirstNames.help" /></span></label>
            <input type="text" id="ownerFirstNames" name="ownerFirstNames" value="${rqt.ownerFirstNames?.toString()}" 
                    class="required condition-isOwner-unfilled  validate-string ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerFirstNames') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.ownerFirstNames.validationError" />"   />
            

  

  
    <label class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerAddress.label" /> *  <span><g:message code="ancr.property.ownerAddress.help" /></span></label>
            <div class="address-fieldset required condition-isOwner-unfilled  ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress') ? 'validation-failed' : ''}">
            <label for="ownerAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.additionalDeliveryInformation}" maxlength="38" id="ownerAddress.additionalDeliveryInformation" name="ownerAddress.additionalDeliveryInformation" />  
            <label for="ownerAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.additionalGeographicalInformation}" maxlength="38" id="ownerAddress.additionalGeographicalInformation" name="ownerAddress.additionalGeographicalInformation" />
            <label for="ownerAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="ownerAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.streetNumber}" size="5" maxlength="5" id="ownerAddress.streetNumber" name="ownerAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.streetName}" maxlength="32" id="ownerAddress.streetName" name="ownerAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="" id="ownerAddress_streetMatriculation" name="ownerAddress.streetMatriculation" />
            <label for="ownerAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.placeNameOrService}" maxlength="38" id="ownerAddress.placeNameOrService" name="ownerAddress.placeNameOrService" />
            <label for="ownerAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="ownerAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="hidden" value="" id="ownerAddress_cityInseeCode" name="ownerAddress.cityInseeCode" />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.postalCode}" size="5" maxlength="5" id="ownerAddress.postalCode" name="ownerAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.city') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.city}" maxlength="32" id="ownerAddress.city" name="ownerAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="ownerAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('ownerAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.countryName}" maxlength="38" id="ownerAddress.countryName" name="ownerAddress.countryName" />
            </div>
            

  

  
    <label for="section" class="required"><g:message code="ancr.property.section.label" /> *  <span><g:message code="ancr.property.section.help" /></span></label>
            <input type="text" id="section" name="section" value="${rqt.section?.toString()}" 
                    class="required  validate-string ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('section') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.section.validationError" />"   />
            

  

  
    <label for="number" class="required"><g:message code="ancr.property.number.label" /> *  <span><g:message code="ancr.property.number.help" /></span></label>
            <input type="text" id="number" name="number" value="${rqt.number?.toString()}" 
                    class="required  validate-positiveInteger ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('number') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.number.validationError" />"   />
            

  

  
    <label for="locality" class=""><g:message code="ancr.property.locality.label" />   <span><g:message code="ancr.property.locality.help" /></span></label>
            <input type="text" id="locality" name="locality" value="${rqt.locality?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('locality') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.locality.validationError" />"   />
            

  

  
    <label for="transportationRoute" class=""><g:message code="ancr.property.transportationRoute.label" />   <span><g:message code="ancr.property.transportationRoute.help" /></span></label>
            <input type="text" id="transportationRoute" name="transportationRoute" value="${rqt.transportationRoute?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('transportationRoute') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.transportationRoute.validationError" />"   />
            

  

  
    <label class="required"><g:message code="ancr.property.moreThanTwoYears.label" /> *  <span><g:message code="ancr.property.moreThanTwoYears.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('moreThanTwoYears') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="moreThanTwoYears_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="moreThanTwoYears" ${it == rqt.moreThanTwoYears ? 'checked="checked"': ''} />
                <label for="moreThanTwoYears_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="area" class=""><g:message code="ancr.property.area.label" />   <span><g:message code="ancr.property.area.help" /></span></label>
            <input type="text" id="area" name="area" value="${rqt.area?.toString()}" 
                    class="  validate-positiveInteger ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('area') ? 'validation-failed' : ''}" title="<g:message code="ancr.property.area.validationError" />"   />
            

  

  
    <label class="required"><g:message code="ancr.property.isAlignment.label" /> *  <span><g:message code="ancr.property.isAlignment.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('isAlignment') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isAlignment_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="isAlignment" ${it == rqt.isAlignment ? 'checked="checked"': ''} />
                <label for="isAlignment_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="ancr.property.isNumbering.label" /> *  <span><g:message code="ancr.property.isNumbering.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('isNumbering') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isNumbering_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="isNumbering" ${it == rqt.isNumbering ? 'checked="checked"': ''} />
                <label for="isNumbering_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="ancr.property.isConnection.label" /> *  <span><g:message code="ancr.property.isConnection.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['cadastre']?.invalidFields.contains('isConnection') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="isConnection_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="isConnection" ${it == rqt.isConnection ? 'checked="checked"': ''} />
                <label for="isConnection_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

