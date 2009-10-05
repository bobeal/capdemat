


  
    <label class="required"><g:message code="acr.property.requesterQuality.label" /> *  <span><g:message code="acr.property.requesterQuality.help" /></span></label>
            <ul class="required">
              <g:each in="${['Owner','Tenant']}">
              <li>
                <input type="radio" class="required condition-isTenant-trigger  validate-one-required" value="fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType_${it}" name="requesterQuality" ${it == rqt.requesterQuality.toString() ? 'checked="checked"': ''} title="<g:message code="acr.property.requesterQuality.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="acr.property.requesterQuality" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-isTenant-filled"><g:message code="acr.property.ownerLastName.label" /> *  <span><g:message code="acr.property.ownerLastName.help" /></span></label>
            <input type="text" name="ownerLastName" value="${rqt.ownerLastName?.toString()}" 
                    class="required condition-isTenant-filled  validate-lastName" title="<g:message code="acr.property.ownerLastName.validationError" />"  maxlength="38" />
            

  

  
    <label class="required condition-isTenant-filled"><g:message code="acr.property.ownerFirstNames.label" /> *  <span><g:message code="acr.property.ownerFirstNames.help" /></span></label>
            <input type="text" name="ownerFirstNames" value="${rqt.ownerFirstNames?.toString()}" 
                    class="required condition-isTenant-filled  validate-string" title="<g:message code="acr.property.ownerFirstNames.validationError" />"   />
            

  

  
    <label class="required condition-isTenant-filled"><g:message code="acr.property.ownerAddress.label" /> *  <span><g:message code="acr.property.ownerAddress.help" /></span></label>
            <div class="address-fieldset required condition-isTenant-filled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.ownerAddress?.additionalDeliveryInformation}" maxlength="38" name="ownerAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.ownerAddress?.additionalGeographicalInformation}" maxlength="38" name="ownerAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.ownerAddress?.streetNumber}" size="5" maxlength="5" name="ownerAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.ownerAddress?.streetName}" maxlength="32" name="ownerAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.ownerAddress?.placeNameOrService}" maxlength="38" name="ownerAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.ownerAddress?.postalCode}" size="5" maxlength="5" name="ownerAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.ownerAddress?.city}" maxlength="32" name="ownerAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.ownerAddress?.countryName}" maxlength="38" name="ownerAddress.countryName"/>
            </div>
            

  

  
    <label class="required"><g:message code="acr.property.section.label" /> *  <span><g:message code="acr.property.section.help" /></span></label>
            <input type="text" name="section" value="${rqt.section?.toString()}" 
                    class="required  validate-string" title="<g:message code="acr.property.section.validationError" />"   />
            

  

  
    <label class="required"><g:message code="acr.property.number.label" /> *  <span><g:message code="acr.property.number.help" /></span></label>
            <input type="text" name="number" value="${rqt.number?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="acr.property.number.validationError" />"   />
            

  

  
    <label class=""><g:message code="acr.property.locality.label" />   <span><g:message code="acr.property.locality.help" /></span></label>
            <input type="text" name="locality" value="${rqt.locality?.toString()}" 
                    class="  validate-string" title="<g:message code="acr.property.locality.validationError" />"   />
            

  

  
    <label class=""><g:message code="acr.property.transportationRoute.label" />   <span><g:message code="acr.property.transportationRoute.help" /></span></label>
            <input type="text" name="transportationRoute" value="${rqt.transportationRoute?.toString()}" 
                    class="  validate-string" title="<g:message code="acr.property.transportationRoute.validationError" />"   />
            

  

