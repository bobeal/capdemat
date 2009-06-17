


  
    <label class="required"><g:message code="bwc.property.bulkyWasteType.label" /> *  <span><g:message code="bwc.property.bulkyWasteType.help" /></span></label>
            <g:set var="bulkyWasteTypeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'bulkyWasteType', 'i18nPrefixCode':'bwc.property.bulkyWasteType', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.bulkyWasteType.entries, 'depth':0]" />
            

  

  
    <label class=""><g:message code="bwc.property.otherWaste.label" />   <span><g:message code="bwc.property.otherWaste.help" /></span></label>
            <input type="text" name="otherWaste" value="${rqt.otherWaste?.toString()}" 
                    class="  validate-string" title="<g:message code="bwc.property.otherWaste.validationError" />"  />
            

  

  
    <label class=""><g:message code="bwc.property.collectionAddress.label" />   <span><g:message code="bwc.property.collectionAddress.help" /></span></label>
            <div class="address-fieldset  ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.collectionAddress?.additionalDeliveryInformation}" maxlength="38" name="collectionAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.collectionAddress?.additionalGeographicalInformation}" maxlength="38" name="collectionAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.collectionAddress?.streetNumber}" maxlength="5" name="collectionAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.collectionAddress?.streetName}" maxlength="32" name="collectionAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.collectionAddress?.placeNameOrService}" maxlength="38" name="collectionAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.collectionAddress?.postalCode}" maxlength="5" name="collectionAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.collectionAddress?.city}" maxlength="32" name="collectionAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.collectionAddress?.countryName}" maxlength="38" name="collectionAddress.countryName"/>
            </div>
            

  

