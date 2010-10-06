


  
    <label for="deathLastName" class="required"><g:message code="ddr.property.deathLastName.label" /> *  <span><g:message code="ddr.property.deathLastName.help" /></span></label>
            <input type="text" id="deathLastName" name="deathLastName" value="${rqt.deathLastName?.toString()}" 
                    class="required  validate-lastName ${stepStates != null && stepStates['nature']?.invalidFields?.contains('deathLastName') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathLastName.validationError" />"  maxlength="38" />
            

  

  
    <label for="deathFirstNames" class="required"><g:message code="ddr.property.deathFirstNames.label" /> *  <span><g:message code="ddr.property.deathFirstNames.help" /></span></label>
            <input type="text" id="deathFirstNames" name="deathFirstNames" value="${rqt.deathFirstNames?.toString()}" 
                    class="required  validate-string ${stepStates != null && stepStates['nature']?.invalidFields?.contains('deathFirstNames') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathFirstNames.validationError" />"   />
            

  

  
    <label class="required"><g:message code="ddr.property.deathDate.label" /> *  <span><g:message code="ddr.property.deathDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${stepStates != null && stepStates['nature']?.invalidFields?.contains('deathDate') ? 'validation-failed' : ''}"
                id="deathDate_day"
                name="deathDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.deathDate?.date == it
                      || (rqt.deathDate == null && params['deathDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['nature']?.invalidFields?.contains('deathDate') ? 'validation-failed' : ''}"
                id="deathDate_month"
                name="deathDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.deathDate?.month == (it - 1)
                      || (rqt.deathDate == null && params['deathDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['nature']?.invalidFields?.contains('deathDate') ? 'validation-failed' : ''}"
                id="deathDate_year"
                name="deathDate_year"
                value="${rqt.deathDate ? rqt.deathDate.year + 1900 : params['deathDate_year']}"
                title="<g:message code="ddr.property.deathDate.validationError" />" />
            </div>
            

  

  
    <label for="deathCity" class="required"><g:message code="ddr.property.deathCity.label" /> *  <span><g:message code="ddr.property.deathCity.help" /></span></label>
            <input type="text" id="deathCity" name="deathCity" value="${rqt.deathCity?.toString()}" 
                    class="required  validate-city ${stepStates != null && stepStates['nature']?.invalidFields?.contains('deathCity') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathCity.validationError" />"  maxlength="32" />
            

  

  
    <label for="deathPostalCode" class="required"><g:message code="ddr.property.deathPostalCode.label" /> *  <span><g:message code="ddr.property.deathPostalCode.help" /></span></label>
            <input type="text" id="deathPostalCode" name="deathPostalCode" value="${rqt.deathPostalCode?.toString()}" 
                    class="required  validate-departmentCode ${stepStates != null && stepStates['nature']?.invalidFields?.contains('deathPostalCode') ? 'validation-failed' : ''}" title="<g:message code="ddr.property.deathPostalCode.validationError" />"  maxlength="2" />
            

  

