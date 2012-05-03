


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${stepStates != null && stepStates['registrationSubject']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="hide"><g:message code="cccrr.property.subjectChoiceBirthDate.label" />   <span><g:message code="cccrr.property.subjectChoiceBirthDate.help" /></span></label>
            <div class="date   validate-date hide">
              <select class="day ${stepStates != null && stepStates['registrationSubject']?.invalidFields?.contains('subjectChoiceBirthDate') ? 'validation-failed' : ''}"
                id="subjectChoiceBirthDate_day"
                name="subjectChoiceBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectChoiceBirthDate?.date == it
                      || (rqt.subjectChoiceBirthDate == null && params['subjectChoiceBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['registrationSubject']?.invalidFields?.contains('subjectChoiceBirthDate') ? 'validation-failed' : ''}"
                id="subjectChoiceBirthDate_month"
                name="subjectChoiceBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.subjectChoiceBirthDate?.month == (it - 1)
                      || (rqt.subjectChoiceBirthDate == null && params['subjectChoiceBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <% def cal = new GregorianCalendar() %>
              <select class="year ${stepStates != null && stepStates['registrationSubject']?.invalidFields?.contains('subjectChoiceBirthDate') ? 'validation-failed' : ''}"
              	name="subjectChoiceBirthDate_year" id="subjectChoiceBirthDate_year">
              	<g:each in="${((cal.get(Calendar.YEAR) + 2) .. cal.get(Calendar.YEAR))}">
              	 <option value="${it }"
              	 	<g:if test="${params['subjectChoiceBirthDate_year'] ==  it.toString()}">selected="selected"</g:if>>
              	 	${it}
              	 </option>
              	</g:each>
              </select> 
	</div>
            

  

  
    <label class="hide"><g:message code="cccrr.property.subjectChoiceGender.label" />   <span><g:message code="cccrr.property.subjectChoiceGender.help" /></span></label>
            <ul class="hide ${stepStates != null && stepStates['registrationSubject']?.invalidFields?.contains('subjectChoiceGender') ? 'validation-failed' : ''}">
              <g:each in="${['Male','Female','Unknown']}">
              <li>
                <input type="radio" id="subjectChoiceGender_${it}" class="  validate-one-required" value="fr.cg95.cvq.business.users.SexType_${it}" name="subjectChoiceGender" ${it == rqt.subjectChoiceGender.toString() ? 'checked="checked"': ''} title="<g:message code="cccrr.property.subjectChoiceGender.validationError" />" />
                <label for="subjectChoiceGender_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="cccrr.property.subjectChoiceGender" /></label>
              </li>
              </g:each>
            </ul>
            

  

