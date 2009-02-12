




  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrCurrentDwelling.label" /></legend> 
      
    
      <label class="required"><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingAddress.help" /></span></label>
      
            <div class="address-fieldset required">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.dhrCurrentDwellingAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.dhrCurrentDwellingAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalGeographicalInformation"/>
            <label class="required"><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
            <input type="text" class="line1" value="${rqt.dhrCurrentDwellingAddress?.streetNumber}" maxlength="5" name="dhrCurrentDwellingAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.dhrCurrentDwellingAddress?.streetName}" maxlength="32" name="dhrCurrentDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.dhrCurrentDwellingAddress?.placeNameOrService}" maxlength="38" name="dhrCurrentDwellingAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="${rqt.dhrCurrentDwellingAddress?.postalCode}" maxlength="5" name="dhrCurrentDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.dhrCurrentDwellingAddress?.city}" maxlength="32" name="dhrCurrentDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.dhrCurrentDwellingAddress?.countryName}" maxlength="38" name="dhrCurrentDwellingAddress.countryName"/>
            </div>
            
    
      <label class=""><g:message code="dhr.property.dhrCurrentDwellingPhone.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingPhone.help" /></span></label>
      
            <input name="dhrCurrentDwellingPhone" value="${rqt.dhrCurrentDwellingPhone}" 
                    class=" validate-phone" title="<g:message code="dhr.property.dhrCurrentDwellingPhone.validationError" />">
            
    
      <label class="required"><g:message code="dhr.property.dhrCurrentDwellingKind.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingKind.help" /></span></label>
      
            <select name="dhrCurrentDwellingKind" class="required condition-isCurrentDwellingPlaceOfResidence-trigger validate-no-first" title="<g:message code="dhr.property.dhrCurrentDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['placeOfResidence','retirementHome','other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == rqt.dhrCurrentDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" /></option>
              </g:each>
            </select>
            
    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.help" /></span></label>
      
            <input name="dhrCurrentDwellingArrivalDate" value="${formatDate(formatName:'format.date',date:rqt.dhrCurrentDwellingArrivalDate)}" 
                   class="required condition-isCurrentDwellingPlaceOfResidence-filled validate-date" title="<g:message code="dhr.property.dhrCurrentDwellingArrivalDate.validationError" />">
            
    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingStatus.help" /></span></label>
      
            <ul class="required condition-isCurrentDwellingPlaceOfResidence-filled">
              <g:each in="${['owner','tenant']}">
              <li>
                <input type="radio" class="required condition-isCurrentDwellingPlaceOfResidence-filled validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrCurrentDwellingStatus" ${it == rqt.dhrCurrentDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrCurrentDwellingStatus.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" />
              </li>
              </g:each>
            </ul>
            
    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.help" /></span></label>
      
            <input name="dhrCurrentDwellingNumberOfRoom" value="${rqt.dhrCurrentDwellingNumberOfRoom}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled validate-dhrDwellingNumberOfRoom" title="<g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.validationError" />">
            
    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingNetArea.help" /></span></label>
      
            <input name="dhrCurrentDwellingNetArea" value="${rqt.dhrCurrentDwellingNetArea}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled validate-dhrDwellingNetArea" title="<g:message code="dhr.property.dhrCurrentDwellingNetArea.validationError" />">
            
    
    </fieldset>
  

  
    <label class="required"><g:message code="dhr.property.dhrPreviousDwelling.label" /> <span><g:message code="dhr.property.dhrPreviousDwelling.help" /></span></label>
    <div class="collection-fieldset required validation-scope">
      <!--<h4><g:message code="dhr.property.dhrPreviousDwelling.label" /></h4>-->
      <g:set var="listIndex" value="${editList?.name == 'dhrPreviousDwelling' ? editList?.index : ( rqt.dhrPreviousDwelling ? rqt.dhrPreviousDwelling.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add required">
    
        <label class="required"><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /> <span><g:message code="dhr.property.dhrPreviousDwellingAddress.help" /></span></label>
        
            <div class="address-fieldset required">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.additionalDeliveryInformation}" maxlength="38" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.additionalGeographicalInformation}" maxlength="38" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.additionalGeographicalInformation"/>
            <label class="required"><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
            <input type="text" class="line1" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.streetNumber}" maxlength="5" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.streetName}" maxlength="32" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.placeNameOrService}" maxlength="38" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
            <input type="text" class="line1 required" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.postalCode}" maxlength="5" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.city}" maxlength="32" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingAddress?.countryName}" maxlength="38" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingAddress.countryName"/>
            </div>
            
    
        <label class="required"><g:message code="dhr.property.dhrPreviousDwellingKind.label" /> <span><g:message code="dhr.property.dhrPreviousDwellingKind.help" /></span></label>
        
            <select name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingKind" class="required condition-isPreviousDwellingPlaceOfResidence-trigger validate-no-first" title="<g:message code="dhr.property.dhrPreviousDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['placeOfResidence','retirementHome','other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == editList?.dhrPreviousDwelling?.dhrPreviousDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" /></option>
              </g:each>
            </select>
            
    
        <label class="required condition-isPreviousDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /> <span><g:message code="dhr.property.dhrPreviousDwellingStatus.help" /></span></label>
        
            <ul class="required condition-isPreviousDwellingPlaceOfResidence-filled">
              <g:each in="${['owner','tenant']}">
              <li>
                <input type="radio" class="required condition-isPreviousDwellingPlaceOfResidence-filled validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingStatus" ${it == editList?.dhrPreviousDwelling?.dhrPreviousDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrPreviousDwellingStatus.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" />
              </li>
              </g:each>
            </ul>
            
    
        <label class="required"><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /> <span><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.help" /></span></label>
        
            <input name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingArrivalDate" value="${formatDate(formatName:'format.date',date:editList?.dhrPreviousDwelling?.dhrPreviousDwellingArrivalDate)}" 
                   class="required validate-date" title="<g:message code="dhr.property.dhrPreviousDwellingArrivalDate.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /> <span><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.help" /></span></label>
        
            <input name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingDepartureDate" value="${formatDate(formatName:'format.date',date:editList?.dhrPreviousDwelling?.dhrPreviousDwellingDepartureDate)}" 
                   class="required validate-date" title="<g:message code="dhr.property.dhrPreviousDwellingDepartureDate.validationError" />">
            
    
        <label class="required"><g:message code="dhr.property.dhrPreviousDwellingComment.label" /> <span><g:message code="dhr.property.dhrPreviousDwellingComment.help" /></span></label>
        
            <input name="dhrPreviousDwelling[${listIndex}].dhrPreviousDwellingComment" value="${editList?.dhrPreviousDwelling?.dhrPreviousDwellingComment}" 
                    class="required validate-string" title="<g:message code="dhr.property.dhrPreviousDwellingComment.validationError" />">
            
    
        <g:if test="${editList?.name == 'dhrPreviousDwelling'}">
          <input type="submit" id="submit-modify-dwelling-dhrPreviousDwelling[${listIndex}]" name="submit-modify-dwelling-dhrPreviousDwelling[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-add-dwelling-dhrPreviousDwelling[${listIndex}]" name="submit-add-dwelling-dhrPreviousDwelling[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.dhrPreviousDwelling}" status="index">
      <fieldset class="collection-fieldset-edit">
        <!-- <legend><g:message code="dhr.property.dhrPreviousDwelling.label" /></legend> -->
        <dl>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /></dt>
        
              <g:if test="${it.dhrPreviousDwellingAddress}">
                <dd>
                  <p>${it.dhrPreviousDwellingAddress?.additionalDeliveryInformation}</p>
                  <p>${it.dhrPreviousDwellingAddress?.additionalGeographicalInformation}</p>
                  <p>${it.dhrPreviousDwellingAddress?.streetNumber} ${it.dhrPreviousDwellingAddress?.streetName}</p>
                  <p>${it.dhrPreviousDwellingAddress?.placeNameOrService}</p>
                  <p>${it.dhrPreviousDwellingAddress?.postalCode} ${it.dhrPreviousDwellingAddress?.city}</p>
                  <p>${it.dhrPreviousDwellingAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingKind.label" /></dt>
        
              <dd>
                <g:if test="${it.dhrPreviousDwellingKind}">
                  <g:capdematEnumToField var="${it.dhrPreviousDwellingKind}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /></dt>
        
              <dd>
                <g:if test="${it.dhrPreviousDwellingStatus}">
                  <g:capdematEnumToField var="${it.dhrPreviousDwellingStatus}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingArrivalDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /></dt>
        <dd><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingDepartureDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingComment.label" /></dt>
        <dd>${it.dhrPreviousDwellingComment}</dd>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-edit-dwelling-dhrPreviousDwelling[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-delete-dwelling-dhrPreviousDwelling[${index}]" />
      </fieldset>
    </g:each>
    </div>
  

