


  
    <label for="selectedRequestType" class="required"><g:message code="ltswr.property.selectedRequestType.label" /> *  <span><g:message code="ltswr.property.selectedRequestType.help" /></span></label>
            <select id="selectedRequestType" name="selectedRequestType" class="required condition-isExtension-trigger  validate-not-first ${rqt.stepStates['work'].invalidFields.contains('selectedRequestType') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.selectedRequestType.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['INITIAL','EXTENSION']}">
                <option value="${it}" ${it == rqt.selectedRequestType?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ltswr.property.selectedRequestType" /></option>
              </g:each>
            </select>
            

  

  
    <label for="autorizationNumber" class="required condition-isExtension-filled"><g:message code="ltswr.property.autorizationNumber.label" /> *  <span><g:message code="ltswr.property.autorizationNumber.help" /></span></label>
            <input type="text" id="autorizationNumber" name="autorizationNumber" value="${rqt.autorizationNumber?.toString()}" 
                    class="required condition-isExtension-filled  validate-string ${rqt.stepStates['work'].invalidFields.contains('autorizationNumber') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.autorizationNumber.validationError" />"   />
            

  

  
    <label for="onBehalf" class="required"><g:message code="ltswr.property.onBehalf.label" /> *  <span><g:message code="ltswr.property.onBehalf.help" /></span></label>
            <input type="text" id="onBehalf" name="onBehalf" value="${rqt.onBehalf?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('onBehalf') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.onBehalf.validationError" />"   />
            

  

  
    <label for="workAddress" class="required"><g:message code="ltswr.property.workAddress.label" /> *  <span><g:message code="ltswr.property.workAddress.help" /></span></label>
            <textarea id="workAddress" name="workAddress" class="required  validate-textarea ${rqt.stepStates['work'].invalidFields.contains('workAddress') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.workAddress.validationError" />" rows="5" cols=""  >${rqt.workAddress}</textarea>
            

  

  
    <label for="workType" class="required"><g:message code="ltswr.property.workType.label" /> *  <span><g:message code="ltswr.property.workType.help" /></span></label>
            <textarea id="workType" name="workType" class="required  validate-textarea ${rqt.stepStates['work'].invalidFields.contains('workType') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.workType.validationError" />" rows="5" cols=""  >${rqt.workType}</textarea>
            

  

  
    <label class="required"><g:message code="ltswr.property.workDate.label" /> *  <span><g:message code="ltswr.property.workDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['work'].invalidFields.contains('workDate') ? 'validation-failed' : ''}"
                id="workDate_day"
                name="workDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.workDate?.date == it
                      || (rqt.workDate == null && params['workDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['work'].invalidFields.contains('workDate') ? 'validation-failed' : ''}"
                id="workDate_month"
                name="workDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.workDate?.month == (it - 1)
                      || (rqt.workDate == null && params['workDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['work'].invalidFields.contains('workDate') ? 'validation-failed' : ''}"
                id="workDate_year"
                name="workDate_year"
                value="${rqt.workDate ? rqt.workDate.year + 1900 : params['workDate_year']}"
                title="<g:message code="ltswr.property.workDate.validationError" />" />
            </div>
            

  

  
    <label for="workTime" class="required"><g:message code="ltswr.property.workTime.label" /> *  <span><g:message code="ltswr.property.workTime.help" /></span></label>
            <input type="text" id="workTime" name="workTime" value="${rqt.workTime?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('workTime') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.workTime.validationError" />"   />
            

  

  
    <label for="workDuration" class="required"><g:message code="ltswr.property.workDuration.label" /> *  <span><g:message code="ltswr.property.workDuration.help" /></span></label>
            <input type="text" id="workDuration" name="workDuration" value="${rqt.workDuration?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('workDuration') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.workDuration.validationError" />"   />
            

  

