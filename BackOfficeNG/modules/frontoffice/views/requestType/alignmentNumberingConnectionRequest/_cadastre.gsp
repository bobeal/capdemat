


  
    <label class="required"><g:message code="ancr.property.requesterQuality.label" /> *  <span><g:message code="ancr.property.requesterQuality.help" /></span></label>
            <select name="requesterQuality" class="required condition-isOwner-trigger  validate-not-first" title="<g:message code="ancr.property.requesterQuality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Owner','Tenant','Cabinet']}">
                <option value="fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType_${it}" ${it == rqt.requesterQuality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="ancr.property.requesterQuality" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerLastName.label" /> *  <span><g:message code="ancr.property.ownerLastName.help" /></span></label>
            <input type="text" name="ownerLastName" value="${rqt.ownerLastName}" 
                    class="required condition-isOwner-unfilled  validate-lastName" title="<g:message code="ancr.property.ownerLastName.validationError" />"  maxLength="38"/>
            

  

  
    <label class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerFirstNames.label" /> *  <span><g:message code="ancr.property.ownerFirstNames.help" /></span></label>
            <input type="text" name="ownerFirstNames" value="${rqt.ownerFirstNames}" 
                    class="required condition-isOwner-unfilled  validate-string" title="<g:message code="ancr.property.ownerFirstNames.validationError" />"  />
            

  

  
    <label class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerAddress.label" /> *  <span><g:message code="ancr.property.ownerAddress.help" /></span></label>
            <div class="address-fieldset required condition-isOwner-unfilled ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.ownerAddress?.additionalDeliveryInformation}" maxlength="38" name="ownerAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.ownerAddress?.additionalGeographicalInformation}" maxlength="38" name="ownerAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.ownerAddress?.streetNumber}" maxlength="5" name="ownerAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.ownerAddress?.streetName}" maxlength="32" name="ownerAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.ownerAddress?.placeNameOrService}" maxlength="38" name="ownerAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.ownerAddress?.postalCode}" maxlength="5" name="ownerAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.ownerAddress?.city}" maxlength="32" name="ownerAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.ownerAddress?.countryName}" maxlength="38" name="ownerAddress.countryName"/>
            </div>
            

  

  
    <label class="required"><g:message code="ancr.property.section.label" /> *  <span><g:message code="ancr.property.section.help" /></span></label>
            <input type="text" name="section" value="${rqt.section}" 
                    class="required  validate-string" title="<g:message code="ancr.property.section.validationError" />"  />
            

  

  
    <label class="required"><g:message code="ancr.property.number.label" /> *  <span><g:message code="ancr.property.number.help" /></span></label>
            <input type="text" name="number" value="${rqt.number}" 
                    class="required  validate-positiveInteger" title="<g:message code="ancr.property.number.validationError" />"  />
            

  

  
    <label class=""><g:message code="ancr.property.locality.label" />   <span><g:message code="ancr.property.locality.help" /></span></label>
            <input type="text" name="locality" value="${rqt.locality}" 
                    class="  validate-string" title="<g:message code="ancr.property.locality.validationError" />"  />
            

  

  
    <label class=""><g:message code="ancr.property.transportationRoute.label" />   <span><g:message code="ancr.property.transportationRoute.help" /></span></label>
            <input type="text" name="transportationRoute" value="${rqt.transportationRoute}" 
                    class="  validate-string" title="<g:message code="ancr.property.transportationRoute.validationError" />"  />
            

  

  
    <label class="required"><g:message code="ancr.property.moreThanTwoYears.label" /> *  <span><g:message code="ancr.property.moreThanTwoYears.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="moreThanTwoYears" ${it == rqt.moreThanTwoYears ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class=""><g:message code="ancr.property.area.label" />   <span><g:message code="ancr.property.area.help" /></span></label>
            <input type="text" name="area" value="${rqt.area}" 
                    class="  validate-positiveInteger" title="<g:message code="ancr.property.area.validationError" />"  />
            

  

  
    <label class="required"><g:message code="ancr.property.isAlignment.label" /> *  <span><g:message code="ancr.property.isAlignment.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="isAlignment" ${it == rqt.isAlignment ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="ancr.property.isNumbering.label" /> *  <span><g:message code="ancr.property.isNumbering.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="isNumbering" ${it == rqt.isNumbering ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="ancr.property.isConnection.label" /> *  <span><g:message code="ancr.property.isConnection.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="isConnection" ${it == rqt.isConnection ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

