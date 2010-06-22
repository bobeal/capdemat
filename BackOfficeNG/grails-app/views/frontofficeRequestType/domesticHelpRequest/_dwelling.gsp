


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrCurrentDwelling.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingAddress.help" /></span></label>
            <div id="dhrCurrentDwellingAddress" class="address required  ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress') ? 'validation-failed' : ''}">
            <label for="dhrCurrentDwellingAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrCurrentDwellingAddress.additionalDeliveryInformation" name="dhrCurrentDwellingAddress.additionalDeliveryInformation" />  
            <label for="dhrCurrentDwellingAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrCurrentDwellingAddress.additionalGeographicalInformation" name="dhrCurrentDwellingAddress.additionalGeographicalInformation" />
            <label for="dhrCurrentDwellingAddress_streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrCurrentDwellingAddress_streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.streetNumber}" size="5" maxlength="5" id="dhrCurrentDwellingAddress_streetNumber" name="dhrCurrentDwellingAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.streetName}" maxlength="32" id="dhrCurrentDwellingAddress_streetName" name="dhrCurrentDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <input type="hidden" value="${rqt.dhrCurrentDwellingAddress?.streetMatriculation}" id="dhrCurrentDwellingAddress_streetMatriculation" name="dhrCurrentDwellingAddress.streetMatriculation" />
            <input type="hidden" value="${rqt.dhrCurrentDwellingAddress?.streetRivoliCode}" id="dhrCurrentDwellingAddress_streetRivoliCode" name="dhrCurrentDwellingAddress.streetRivoliCode" />
            <label for="dhrCurrentDwellingAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.placeNameOrService}" maxlength="38" id="dhrCurrentDwellingAddress.placeNameOrService" name="dhrCurrentDwellingAddress.placeNameOrService" />
            <label for="dhrCurrentDwellingAddress_postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrCurrentDwellingAddress_city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.postalCode}" size="5" maxlength="5" id="dhrCurrentDwellingAddress_postalCode" name="dhrCurrentDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.city') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.city}" maxlength="32" id="dhrCurrentDwellingAddress_city" name="dhrCurrentDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <input type="hidden" value="${rqt.dhrCurrentDwellingAddress?.cityInseeCode}" id="dhrCurrentDwellingAddress_cityInseeCode" name="dhrCurrentDwellingAddress.cityInseeCode" />
            <label for="dhrCurrentDwellingAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.dhrCurrentDwellingAddress?.countryName}" maxlength="38" id="dhrCurrentDwellingAddress.countryName" name="dhrCurrentDwellingAddress.countryName" />
            </div>
            

    
      <label for="dhrCurrentDwellingPhone" class=""><g:message code="dhr.property.dhrCurrentDwellingPhone.label" />   <span><g:message code="dhr.property.dhrCurrentDwellingPhone.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingPhone" name="dhrCurrentDwellingPhone" value="${rqt.dhrCurrentDwellingPhone?.toString()}" 
                    class="  validate-phone ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingPhone') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingPhone.validationError" />"  maxlength="10" />
            

    
      <label for="dhrCurrentDwellingKind" class="required"><g:message code="dhr.property.dhrCurrentDwellingKind.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingKind.help" /></span></label>
            <select id="dhrCurrentDwellingKind" name="dhrCurrentDwellingKind" class="required condition-isCurrentDwellingPlaceOfResidence-trigger  validate-not-first ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingKind') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['placeOfResidence','retirementHome','other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == rqt.dhrCurrentDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.help" /></span></label>
            <div class="date required condition-isCurrentDwellingPlaceOfResidence-filled  validate-date required condition-isCurrentDwellingPlaceOfResidence-filled ">
              <select class="day ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingArrivalDate') ? 'validation-failed' : ''}"
                id="dhrCurrentDwellingArrivalDate_day"
                name="dhrCurrentDwellingArrivalDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrCurrentDwellingArrivalDate?.date == it
                      || (rqt.dhrCurrentDwellingArrivalDate == null && params['dhrCurrentDwellingArrivalDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingArrivalDate') ? 'validation-failed' : ''}"
                id="dhrCurrentDwellingArrivalDate_month"
                name="dhrCurrentDwellingArrivalDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrCurrentDwellingArrivalDate?.month == (it - 1)
                      || (rqt.dhrCurrentDwellingArrivalDate == null && params['dhrCurrentDwellingArrivalDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingArrivalDate') ? 'validation-failed' : ''}"
                id="dhrCurrentDwellingArrivalDate_year"
                name="dhrCurrentDwellingArrivalDate_year"
                value="${rqt.dhrCurrentDwellingArrivalDate ? rqt.dhrCurrentDwellingArrivalDate.year + 1900 : params['dhrCurrentDwellingArrivalDate_year']}"
                title="<g:message code="dhr.property.dhrCurrentDwellingArrivalDate.validationError" />" />
            </div>
            

    
      <label class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingStatus.help" /></span></label>
            <ul class="required condition-isCurrentDwellingPlaceOfResidence-filled ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingStatus') ? 'validation-failed' : ''}">
              <g:each in="${['owner','tenant']}">
              <li>
                <input type="radio" id="dhrCurrentDwellingStatus_${it}" class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrCurrentDwellingStatus" ${it == rqt.dhrCurrentDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrCurrentDwellingStatus.validationError" />" />
                <label for="dhrCurrentDwellingStatus_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="dhrCurrentDwellingNumberOfRoom" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingNumberOfRoom" name="dhrCurrentDwellingNumberOfRoom" value="${rqt.dhrCurrentDwellingNumberOfRoom?.toString()}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-dhrDwellingNumberOfRoom ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingNumberOfRoom') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.validationError" />"   />
            

    
      <label for="dhrCurrentDwellingNetArea" class="required condition-isCurrentDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /> *  <span><g:message code="dhr.property.dhrCurrentDwellingNetArea.help" /></span></label>
            <input type="text" id="dhrCurrentDwellingNetArea" name="dhrCurrentDwellingNetArea" value="${rqt.dhrCurrentDwellingNetArea?.toString()}" 
                    class="required condition-isCurrentDwellingPlaceOfResidence-filled  validate-regex ${rqt.stepStates['dwelling'].invalidFields.contains('dhrCurrentDwellingNetArea') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrCurrentDwellingNetArea.validationError" />" regex="^[1-9]$|^[1-9][0-9]$|^[1-4][0-9][0-9]$|^500$"  />
            

    
    </fieldset>
  

  
    <div class="collection required summary-box">
      <h4 class="required"><g:message code="dhr.property.dhrPreviousDwelling.label" /> 
        <span><g:message code="dhr.property.dhrPreviousDwelling.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'dwelling', 'currentCollection':'dhrPreviousDwelling', 'collectionIndex':(rqt.dhrPreviousDwelling ? rqt.dhrPreviousDwelling.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.dhrPreviousDwelling}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="dhr.property.dhrPreviousDwelling.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'dwelling', 'currentCollection':'dhrPreviousDwelling', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'dwelling', 'currentCollection':'dhrPreviousDwelling', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /></dt>
        
              <g:if test="${it.dhrPreviousDwellingAddress}">
                <dd class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress') ? 'validation-failed' : ''}">
                  <p class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}">${it.dhrPreviousDwellingAddress?.additionalDeliveryInformation}</p>
                  <p class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}">${it.dhrPreviousDwellingAddress?.additionalGeographicalInformation}</p>
                  <p class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.streetNumber') || rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.streetName') ? 'validation-failed' : ''}">${it.dhrPreviousDwellingAddress?.streetNumber} ${it.dhrPreviousDwellingAddress?.streetName}</p>
                  <p class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.placeNameOrService') ? 'validation-failed' : ''}">${it.dhrPreviousDwellingAddress?.placeNameOrService}</p>
                  <p class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.postalCode') || rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.city') ? 'validation-failed' : ''}">${it.dhrPreviousDwellingAddress?.postalCode} ${it.dhrPreviousDwellingAddress?.city}</p>
                  <p class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingAddress.countryName') ? 'validation-failed' : ''}">${it.dhrPreviousDwellingAddress?.countryName}</p>
                </dd>
              </g:if>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingKind.label" /></dt>
        
              <dd class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingKind') ? 'validation-failed' : ''}">
                <g:if test="${it.dhrPreviousDwellingKind}">
                  <g:capdematEnumToField var="${it.dhrPreviousDwellingKind}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /></dt>
        
              <dd class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingStatus') ? 'validation-failed' : ''}">
                <g:if test="${it.dhrPreviousDwellingStatus}">
                  <g:capdematEnumToField var="${it.dhrPreviousDwellingStatus}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /></dt>
        <dd class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingArrivalDate') ? 'validation-failed' : ''}"><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingArrivalDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /></dt>
        <dd class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingDepartureDate') ? 'validation-failed' : ''}"><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingDepartureDate}"/></dd>
    
        <dt><g:message code="dhr.property.dhrPreviousDwellingComment.label" /></dt>
        <dd class="${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling[' + index + '].dhrPreviousDwellingComment') ? 'validation-failed' : ''}">${it.dhrPreviousDwellingComment?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  

