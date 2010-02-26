


  
    <label class="required"><g:message code="scr.property.requesterQuality.label" /> *  <span><g:message code="scr.property.requesterQuality.help" /></span></label>
            <ul class="required">
              <g:each in="${['Owner','Tenant']}">
              <li>
                <input type="radio" id="requesterQuality_${it}" class="required condition-isTenant-trigger  validate-one-required" value="fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType_${it}" name="requesterQuality" ${it == rqt.requesterQuality.toString() ? 'checked="checked"': ''} title="<g:message code="scr.property.requesterQuality.validationError" />" />
                <label for="requesterQuality_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scr.property.requesterQuality" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="ownerLastName" class="required condition-isTenant-filled"><g:message code="scr.property.ownerLastName.label" /> *  <span><g:message code="scr.property.ownerLastName.help" /></span></label>
            <input type="text" id="ownerLastName" name="ownerLastName" value="${rqt.ownerLastName?.toString()}" 
                    class="required condition-isTenant-filled  validate-lastName" title="<g:message code="scr.property.ownerLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="ownerFirstNames" class="required condition-isTenant-filled"><g:message code="scr.property.ownerFirstNames.label" /> *  <span><g:message code="scr.property.ownerFirstNames.help" /></span></label>
            <input type="text" id="ownerFirstNames" name="ownerFirstNames" value="${rqt.ownerFirstNames?.toString()}" 
                    class="required condition-isTenant-filled  validate-string" title="<g:message code="scr.property.ownerFirstNames.validationError" />"   />
            

  

  
    <label class="required condition-isTenant-filled"><g:message code="scr.property.ownerAddress.label" /> *  <span><g:message code="scr.property.ownerAddress.help" /></span></label>
            <div class="address-fieldset required condition-isTenant-filled ">
            <label for="ownerAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.ownerAddress?.additionalDeliveryInformation}" maxlength="38" id="ownerAddress.additionalDeliveryInformation" name="ownerAddress.additionalDeliveryInformation" />  
            <label for="ownerAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.ownerAddress?.additionalGeographicalInformation}" maxlength="38" id="ownerAddress.additionalGeographicalInformation" name="ownerAddress.additionalGeographicalInformation" />
            <label for="ownerAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="ownerAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1" value="${rqt.ownerAddress?.streetNumber}" size="5" maxlength="5" id="ownerAddress.streetNumber" name="ownerAddress.streetNumber" />
            <input type="text" class="line2 required" value="${rqt.ownerAddress?.streetName}" maxlength="32" id="ownerAddress.streetName" name="ownerAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="ownerAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.ownerAddress?.placeNameOrService}" maxlength="38" id="ownerAddress.placeNameOrService" name="ownerAddress.placeNameOrService" />
            <label for="ownerAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="ownerAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required" value="${rqt.ownerAddress?.postalCode}" size="5" maxlength="5" id="ownerAddress.postalCode" name="ownerAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.ownerAddress?.city}" maxlength="32" id="ownerAddress.city" name="ownerAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="ownerAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.ownerAddress?.countryName}" maxlength="38" id="ownerAddress.countryName" name="ownerAddress.countryName" />
            </div>
            

  

  
    <label for="section" class="required"><g:message code="scr.property.section.label" /> *  <span><g:message code="scr.property.section.help" /></span></label>
            <input type="text" id="section" name="section" value="${rqt.section?.toString()}" 
                    class="required  validate-string" title="<g:message code="scr.property.section.validationError" />"   />
            

  

  
    <label for="number" class="required"><g:message code="scr.property.number.label" /> *  <span><g:message code="scr.property.number.help" /></span></label>
            <input type="text" id="number" name="number" value="${rqt.number?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="scr.property.number.validationError" />"   />
            

  

  
    <label for="locality" class=""><g:message code="scr.property.locality.label" />   <span><g:message code="scr.property.locality.help" /></span></label>
            <input type="text" id="locality" name="locality" value="${rqt.locality?.toString()}" 
                    class="  validate-string" title="<g:message code="scr.property.locality.validationError" />"   />
            

  

  
    <label for="transportationRoute" class=""><g:message code="scr.property.transportationRoute.label" />   <span><g:message code="scr.property.transportationRoute.help" /></span></label>
            <input type="text" id="transportationRoute" name="transportationRoute" value="${rqt.transportationRoute?.toString()}" 
                    class="  validate-string" title="<g:message code="scr.property.transportationRoute.validationError" />"   />
            

  

  
    <label class="required"><g:message code="scr.property.moreThanTwoYears.label" /> *  <span><g:message code="scr.property.moreThanTwoYears.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="moreThanTwoYears_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="moreThanTwoYears" ${it == rqt.moreThanTwoYears ? 'checked="checked"': ''} />
                <label for="moreThanTwoYears_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

