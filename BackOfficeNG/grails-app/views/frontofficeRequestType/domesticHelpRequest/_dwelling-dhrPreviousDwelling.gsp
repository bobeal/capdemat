
  <g:set var="currentCollectionItem" value="${rqt?.dhrPreviousDwelling.size() > collectionIndex ? rqt.dhrPreviousDwelling.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'dhr.property.dhrPreviousDwelling.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label class="required"><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingAddress.help" /></span></label>
            <div class="address required  ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress') ? 'validation-failed' : ''}">
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.additionalDeliveryInformation" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.additionalDeliveryInformation" />  
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.additionalGeographicalInformation" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.additionalGeographicalInformation" />
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.streetNumber') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.streetNumber}" size="5" maxlength="5" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.streetNumber" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.streetName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.streetName}" maxlength="32" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.streetName" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.placeNameOrService}" maxlength="38" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.placeNameOrService" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.placeNameOrService" />
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.postalCode') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.postalCode}" size="5" maxlength="5" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.postalCode" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.city') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.city}" maxlength="32" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.city" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingAddress.countryName') ? 'validation-failed' : ''}" value="${currentCollectionItem?.dhrPreviousDwellingAddress?.countryName}" maxlength="38" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingAddress.countryName" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingAddress.countryName" />
            </div>
            

  
    <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingKind" class="required"><g:message code="dhr.property.dhrPreviousDwellingKind.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingKind.help" /></span></label>
            <select id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingKind" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingKind" class="required condition-isPreviousDwellingPlaceOfResidence-trigger  validate-not-first ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingKind') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPreviousDwellingKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PLACE_OF_RESIDENCE','RETIREMENT_HOME','OTHER']}">
                <option value="${it}" ${it == currentCollectionItem?.dhrPreviousDwellingKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" /></option>
              </g:each>
            </select>
            

  
    <label class="required condition-isPreviousDwellingPlaceOfResidence-filled"><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingStatus.help" /></span></label>
            <ul class="required condition-isPreviousDwellingPlaceOfResidence-filled ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingStatus') ? 'validation-failed' : ''}">
              <g:each in="${['OWNER','TENANT']}">
              <li>
                <input type="radio" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingStatus_${it}" class="required condition-isPreviousDwellingPlaceOfResidence-filled  validate-one-required" value="${it}" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingStatus" ${it == currentCollectionItem?.dhrPreviousDwellingStatus.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrPreviousDwellingStatus.validationError" />" />
                <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingStatus_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" /></label>
              </li>
              </g:each>
            </ul>
            

  
    <label class="required"><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingArrivalDate') ? 'validation-failed' : ''}"
                id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingArrivalDate_day"
                name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingArrivalDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${currentCollectionItem?.dhrPreviousDwellingArrivalDate?.date == it
                      || (currentCollectionItem?.dhrPreviousDwellingArrivalDate == null && params['dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingArrivalDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingArrivalDate') ? 'validation-failed' : ''}"
                id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingArrivalDate_month"
                name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingArrivalDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${currentCollectionItem?.dhrPreviousDwellingArrivalDate?.month == (it - 1)
                      || (currentCollectionItem?.dhrPreviousDwellingArrivalDate == null && params['dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingArrivalDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingArrivalDate') ? 'validation-failed' : ''}"
                id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingArrivalDate_year"
                name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingArrivalDate_year"
                value="${currentCollectionItem?.dhrPreviousDwellingArrivalDate ? currentCollectionItem?.dhrPreviousDwellingArrivalDate.year + 1900 : params['dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingArrivalDate_year']}"
                title="<g:message code="dhr.property.dhrPreviousDwellingArrivalDate.validationError" />" />
            </div>
            

  
    <label class="required"><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingDepartureDate') ? 'validation-failed' : ''}"
                id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingDepartureDate_day"
                name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingDepartureDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${currentCollectionItem?.dhrPreviousDwellingDepartureDate?.date == it
                      || (currentCollectionItem?.dhrPreviousDwellingDepartureDate == null && params['dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingDepartureDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingDepartureDate') ? 'validation-failed' : ''}"
                id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingDepartureDate_month"
                name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingDepartureDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${currentCollectionItem?.dhrPreviousDwellingDepartureDate?.month == (it - 1)
                      || (currentCollectionItem?.dhrPreviousDwellingDepartureDate == null && params['dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingDepartureDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingDepartureDate') ? 'validation-failed' : ''}"
                id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingDepartureDate_year"
                name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingDepartureDate_year"
                value="${currentCollectionItem?.dhrPreviousDwellingDepartureDate ? currentCollectionItem?.dhrPreviousDwellingDepartureDate.year + 1900 : params['dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingDepartureDate_year']}"
                title="<g:message code="dhr.property.dhrPreviousDwellingDepartureDate.validationError" />" />
            </div>
            

  
    <label for="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingComment" class="required"><g:message code="dhr.property.dhrPreviousDwellingComment.label" /> *  <span><g:message code="dhr.property.dhrPreviousDwellingComment.help" /></span></label>
            <input type="text" id="dhrPreviousDwelling.${collectionIndex}.dhrPreviousDwellingComment" name="dhrPreviousDwelling[${collectionIndex}].dhrPreviousDwellingComment" value="${currentCollectionItem?.dhrPreviousDwellingComment?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['dwelling'].invalidFields.contains('dhrPreviousDwelling['+collectionIndex+'].dhrPreviousDwellingComment') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrPreviousDwellingComment.validationError" />"   />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'dwelling'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
