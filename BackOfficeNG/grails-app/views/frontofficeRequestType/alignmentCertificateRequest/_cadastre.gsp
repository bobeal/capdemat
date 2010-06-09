


  
    <label class="required"><g:message code="acr.property.requesterQuality.label" /> *  <span><g:message code="acr.property.requesterQuality.help" /></span></label>
            <ul class="required ${rqt.stepStates['cadastre'].invalidFields.contains('requesterQuality') ? 'validation-failed' : ''}">
              <g:each in="${['Owner','Tenant']}">
              <li>
                <input type="radio" id="requesterQuality_${it}" class="required condition-isTenant-trigger  validate-one-required" value="fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType_${it}" name="requesterQuality" ${it == rqt.requesterQuality.toString() ? 'checked="checked"': ''} title="<g:message code="acr.property.requesterQuality.validationError" />" />
                <label for="requesterQuality_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="acr.property.requesterQuality" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="ownerLastName" class="required condition-isTenant-filled"><g:message code="acr.property.ownerLastName.label" /> *  <span><g:message code="acr.property.ownerLastName.help" /></span></label>
            <input type="text" id="ownerLastName" name="ownerLastName" value="${rqt.ownerLastName?.toString()}" 
                    class="required condition-isTenant-filled  validate-lastName ${rqt.stepStates['cadastre'].invalidFields.contains('ownerLastName') ? 'validation-failed' : ''}" title="<g:message code="acr.property.ownerLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="ownerFirstNames" class="required condition-isTenant-filled"><g:message code="acr.property.ownerFirstNames.label" /> *  <span><g:message code="acr.property.ownerFirstNames.help" /></span></label>
            <input type="text" id="ownerFirstNames" name="ownerFirstNames" value="${rqt.ownerFirstNames?.toString()}" 
                    class="required condition-isTenant-filled  validate-string ${rqt.stepStates['cadastre'].invalidFields.contains('ownerFirstNames') ? 'validation-failed' : ''}" title="<g:message code="acr.property.ownerFirstNames.validationError" />"   />
            

  

  
    <label class="required condition-isTenant-filled"><g:message code="acr.property.ownerAddress.label" /> *  <span><g:message code="acr.property.ownerAddress.help" /></span></label>
            <div id="ownerAddress" class="address-fieldset required condition-isTenant-filled  ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress') ? 'validation-failed' : ''}">
            <label for="ownerAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.additionalDeliveryInformation}" maxlength="38" id="ownerAddress.additionalDeliveryInformation" name="ownerAddress.additionalDeliveryInformation" />  
            <label for="ownerAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.additionalGeographicalInformation}" maxlength="38" id="ownerAddress.additionalGeographicalInformation" name="ownerAddress.additionalGeographicalInformation" />
            <label for="ownerAddress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="ownerAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.streetNumber}" size="5" maxlength="5" id="ownerAddress_streetNumber" name="ownerAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.streetName}" maxlength="32" id="ownerAddress_streetName" name="ownerAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.ownerAddress?.streetMatriculation}" id="ownerAddress_streetMatriculation" name="ownerAddress.streetMatriculation" />
            <input type="hidden" value="${rqt.ownerAddress?.streetRivoliCode}" id="ownerAddress_streetRivoliCode" name="ownerAddress.streetRivoliCode" />
            <label for="ownerAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.placeNameOrService}" maxlength="38" id="ownerAddress.placeNameOrService" name="ownerAddress.placeNameOrService" />
            <label for="ownerAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="ownerAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.postalCode}" size="5" maxlength="5" id="ownerAddress_postalCode" name="ownerAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.city') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.city}" maxlength="32" id="ownerAddress_city" name="ownerAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.ownerAddress?.cityInseeCode}" id="ownerAddress_cityInseeCode" name="ownerAddress.cityInseeCode" />
            <label for="ownerAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['cadastre'].invalidFields.contains('ownerAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.ownerAddress?.countryName}" maxlength="38" id="ownerAddress.countryName" name="ownerAddress.countryName" />
            </div>
            

  

  
    <label for="section" class="required"><g:message code="acr.property.section.label" /> *  <span><g:message code="acr.property.section.help" /></span></label>
            <input type="text" id="section" name="section" value="${rqt.section?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['cadastre'].invalidFields.contains('section') ? 'validation-failed' : ''}" title="<g:message code="acr.property.section.validationError" />"   />
            

  

  
    <label for="number" class="required"><g:message code="acr.property.number.label" /> *  <span><g:message code="acr.property.number.help" /></span></label>
            <input type="text" id="number" name="number" value="${rqt.number?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['cadastre'].invalidFields.contains('number') ? 'validation-failed' : ''}" title="<g:message code="acr.property.number.validationError" />"   />
            

  

  
    <label for="locality" class=""><g:message code="acr.property.locality.label" />   <span><g:message code="acr.property.locality.help" /></span></label>
            <input type="text" id="locality" name="locality" value="${rqt.locality?.toString()}" 
                    class="  validate-string ${rqt.stepStates['cadastre'].invalidFields.contains('locality') ? 'validation-failed' : ''}" title="<g:message code="acr.property.locality.validationError" />"   />
            

  

  
    <label for="transportationRoute" class=""><g:message code="acr.property.transportationRoute.label" />   <span><g:message code="acr.property.transportationRoute.help" /></span></label>
            <input type="text" id="transportationRoute" name="transportationRoute" value="${rqt.transportationRoute?.toString()}" 
                    class="  validate-string ${rqt.stepStates['cadastre'].invalidFields.contains('transportationRoute') ? 'validation-failed' : ''}" title="<g:message code="acr.property.transportationRoute.validationError" />"   />
            

  

