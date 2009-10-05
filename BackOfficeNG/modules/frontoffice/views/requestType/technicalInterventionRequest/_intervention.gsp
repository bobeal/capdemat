


  
    <label class="required"><g:message code="tir.property.interventionType.label" /> *  <span><g:message code="tir.property.interventionType.help" /></span></label>
            <g:set var="interventionTypeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'interventionType', 'i18nPrefixCode':'tir.property.interventionType', 'htmlClass':'required condition-otherIntervention-trigger  ', 
                              'lrEntries': lrTypes.interventionType.entries, 'depth':0]" />
            

  

  
    <label class="required condition-otherIntervention-filled"><g:message code="tir.property.otherInterventionLabel.label" /> *  <span><g:message code="tir.property.otherInterventionLabel.help" /></span></label>
            <input type="text" name="otherInterventionLabel" value="${rqt.otherInterventionLabel?.toString()}" 
                    class="required condition-otherIntervention-filled  validate-string" title="<g:message code="tir.property.otherInterventionLabel.validationError" />"   />
            

  

  
    <label class="required"><g:message code="tir.property.interventionPlace.label" /> *  <span><g:message code="tir.property.interventionPlace.help" /></span></label>
            <div class="address-fieldset required ">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.interventionPlace?.additionalDeliveryInformation}" maxlength="38" name="interventionPlace.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.interventionPlace?.additionalGeographicalInformation}" maxlength="38" name="interventionPlace.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.interventionPlace?.streetNumber}" size="5" maxlength="5" name="interventionPlace.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.interventionPlace?.streetName}" maxlength="32" name="interventionPlace.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.interventionPlace?.placeNameOrService}" maxlength="38" name="interventionPlace.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.interventionPlace?.postalCode}" size="5" maxlength="5" name="interventionPlace.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.interventionPlace?.city}" maxlength="32" name="interventionPlace.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.interventionPlace?.countryName}" maxlength="38" name="interventionPlace.countryName"/>
            </div>
            

  

  
    <label class="required"><g:message code="tir.property.interventionDescription.label" /> *  <span><g:message code="tir.property.interventionDescription.help" /></span></label>
            <textarea name="interventionDescription" class="required  validate-textarea" title="<g:message code="tir.property.interventionDescription.validationError" />" rows="3" >${rqt.interventionDescription}</textarea>
            

  

