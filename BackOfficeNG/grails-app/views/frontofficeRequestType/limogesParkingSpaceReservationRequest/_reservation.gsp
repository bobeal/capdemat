


  
    <label for="requesterFirstAddressKind" class="required"><g:message code="lpsrr.property.requesterFirstAddressKind.label" /> *  <span><g:message code="lpsrr.property.requesterFirstAddressKind.help" /></span></label>
            <select id="requesterFirstAddressKind" name="requesterFirstAddressKind" class="required condition-AddressOne-trigger  validate-not-first ${rqt.stepStates['reservation'].invalidFields.contains('requesterFirstAddressKind') ? 'validation-failed' : ''}" title="<g:message code="lpsrr.property.requesterFirstAddressKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CURRENT','FUTURE']}">
                <option value="${it}" ${it == rqt.requesterFirstAddressKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="lpsrr.property.requesterFirstAddressKind" /></option>
              </g:each>
            </select>
            

  

  
    <label for="requesterFirstAddress" class="required condition-AddressOne-filled"><g:message code="lpsrr.property.requesterFirstAddress.label" /> *  <span><g:message code="lpsrr.property.requesterFirstAddress.help" /></span></label>
            <input type="text" id="requesterFirstAddress" name="requesterFirstAddress" value="${rqt.requesterFirstAddress?.toString()}" 
                    class="required condition-AddressOne-filled  validate-string ${rqt.stepStates['reservation'].invalidFields.contains('requesterFirstAddress') ? 'validation-failed' : ''}" title="<g:message code="lpsrr.property.requesterFirstAddress.validationError" />"   />
            

  

  
    <label for="requesterOtherAddressKind" class=""><g:message code="lpsrr.property.requesterOtherAddressKind.label" />   <span><g:message code="lpsrr.property.requesterOtherAddressKind.help" /></span></label>
            <select id="requesterOtherAddressKind" name="requesterOtherAddressKind" class="condition-AddressTwo-trigger  validate-select ${rqt.stepStates['reservation'].invalidFields.contains('requesterOtherAddressKind') ? 'validation-failed' : ''}" title="<g:message code="lpsrr.property.requesterOtherAddressKind.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CURRENT','FUTURE']}">
                <option value="${it}" ${it == rqt.requesterOtherAddressKind?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="lpsrr.property.requesterOtherAddressKind" /></option>
              </g:each>
            </select>
            

  

  
    <label for="requesterOtherAddress" class="required condition-AddressTwo-filled"><g:message code="lpsrr.property.requesterOtherAddress.label" /> *  <span><g:message code="lpsrr.property.requesterOtherAddress.help" /></span></label>
            <input type="text" id="requesterOtherAddress" name="requesterOtherAddress" value="${rqt.requesterOtherAddress?.toString()}" 
                    class="required condition-AddressTwo-filled  validate-string ${rqt.stepStates['reservation'].invalidFields.contains('requesterOtherAddress') ? 'validation-failed' : ''}" title="<g:message code="lpsrr.property.requesterOtherAddress.validationError" />"   />
            

  

  
    <label class="required"><g:message code="lpsrr.property.furnitureLift.label" /> *  <span><g:message code="lpsrr.property.furnitureLift.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['reservation'].invalidFields.contains('furnitureLift') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="furnitureLift_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="furnitureLift" ${it == rqt.furnitureLift ? 'checked="checked"': ''} />
                <label for="furnitureLift_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="lpsrr.property.startDate.label" /> *  <span><g:message code="lpsrr.property.startDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['reservation'].invalidFields.contains('startDate') ? 'validation-failed' : ''}"
                id="startDate_day"
                name="startDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.startDate?.date == it
                      || (rqt.startDate == null && params['startDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['reservation'].invalidFields.contains('startDate') ? 'validation-failed' : ''}"
                id="startDate_month"
                name="startDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.startDate?.month == (it - 1)
                      || (rqt.startDate == null && params['startDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['reservation'].invalidFields.contains('startDate') ? 'validation-failed' : ''}"
                id="startDate_year"
                name="startDate_year"
                value="${rqt.startDate ? rqt.startDate.year + 1900 : params['startDate_year']}"
                title="<g:message code="lpsrr.property.startDate.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="lpsrr.property.duration.label" /> *  <span><g:message code="lpsrr.property.duration.help" /></span></label>
            <g:set var="durationIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'duration', 'i18nPrefixCode':'lpsrr.property.duration', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.duration.entries, 'depth':0]" />
            

  

