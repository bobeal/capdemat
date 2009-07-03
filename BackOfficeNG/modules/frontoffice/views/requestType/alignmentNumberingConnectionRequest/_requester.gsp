


  
    
              <g:render template="/frontofficeRequestType/widget/requester" model="['requester':requester, 'hasHomeFolder':hasHomeFolder]" />
            

  

  
    <label class="required"><g:message code="ancr.property.isAccountAddress.label" /> *  <span><g:message code="ancr.property.isAccountAddress.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isSameAddress-trigger  validate-one-required" title="" value="${it}" name="isAccountAddress" ${it == rqt.isAccountAddress ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-isSameAddress-unfilled"><g:message code="ancr.property.otherAddress.label" /> *  <span><g:message code="ancr.property.otherAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSameAddress-unfilled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.otherAddress?.additionalDeliveryInformation}" maxlength="38" name="otherAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.otherAddress?.additionalGeographicalInformation}" maxlength="38" name="otherAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.otherAddress?.streetNumber}" size="5" maxlength="5" name="otherAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.otherAddress?.streetName}" maxlength="32" name="otherAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.otherAddress?.placeNameOrService}" maxlength="38" name="otherAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.otherAddress?.postalCode}" size="5" maxlength="5" name="otherAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.otherAddress?.city}" maxlength="32" name="otherAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.otherAddress?.countryName}" maxlength="38" name="otherAddress.countryName"/>
            </div>
            

  

