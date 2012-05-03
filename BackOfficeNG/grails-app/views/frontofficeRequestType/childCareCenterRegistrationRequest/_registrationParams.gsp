


  
    <label class="required"><g:message code="cccrr.property.registrationDate.label" /> *  <span><g:message code="cccrr.property.registrationDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('registrationDate') ? 'validation-failed' : ''}"
                id="registrationDate_day"
                name="registrationDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.registrationDate?.date == it
                      || (rqt.registrationDate == null && params['registrationDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('registrationDate') ? 'validation-failed' : ''}"
                id="registrationDate_month"
                name="registrationDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.registrationDate?.month == (it - 1)
                      || (rqt.registrationDate == null && params['registrationDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
               <% def cal = new GregorianCalendar() %>
              <select class="year ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('registrationDate') ? 'validation-failed' : ''}"
              	name="registrationDate_year" id="registrationDate_year" title="<g:message code="cccrr.property.registrationDate.validationError" />">
              	<g:each in="${((cal.get(Calendar.YEAR) + 2) .. cal.get(Calendar.YEAR))}">
              	 <option value="${it }"
              	 	<g:if test="${params['registrationDate_year'] ==  it.toString()}">selected="selected"</g:if>>
              	 	${it}
              	 </option>
              	</g:each>
              </select> 
              
             
            </div>
            

  

  
    <fieldset class="">
    <legend><g:message code="cccrr.property.mondayRegistrationParam.label" /></legend>
    
      <label class=""><g:message code="cccrr.property.mondayPeriod.label" />   <span><g:message code="cccrr.property.mondayPeriod.help" /></span></label>
            <ul class=" ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('mondayPeriod') ? 'validation-failed' : ''}">
              <g:each in="${['allDay','halfDay']}">
              <li>
                <input type="radio" id="mondayPeriod_${it}" class="condition-isMondayPeriodeChoice-trigger  validate-one-required" value="fr.cg95.cvq.business.request.school.DayPeriodType_${it}" name="mondayPeriod" ${it == rqt.mondayPeriod.toString() ? 'checked="checked"': ''} title="<g:message code="cccrr.property.mondayPeriod.validationError" />" />
                <label for="mondayPeriod_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="cccrr.property.mondayPeriod" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="mondayFirstPeriodBegining" class=""><g:message code="cccrr.property.mondayFirstPeriodBegining.label" />   <span><g:message code="cccrr.property.mondayFirstPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="mondayFirstPeriodBegining" name="mondayFirstPeriodBegining" value="${rqt.mondayFirstPeriodBegining?.toString()}" 
                    class="periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('mondayFirstPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.mondayFirstPeriodBegining.validationError" />"   />
            

    
      <label for="mondayFirstPeriodEnding" class=""><g:message code="cccrr.property.mondayFirstPeriodEnding.label" />   <span><g:message code="cccrr.property.mondayFirstPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="mondayFirstPeriodEnding" name="mondayFirstPeriodEnding" value="${rqt.mondayFirstPeriodEnding?.toString()}" 
                    class="periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('mondayFirstPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.mondayFirstPeriodEnding.validationError" />"   />
            

    
      <label for="mondaySecondPeriodBegining" class="condition-isMondayPeriodeChoice-filled"><g:message code="cccrr.property.mondaySecondPeriodBegining.label" />   <span><g:message code="cccrr.property.mondaySecondPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="mondaySecondPeriodBegining" name="mondaySecondPeriodBegining" value="${rqt.mondaySecondPeriodBegining?.toString()}" 
                    class="condition-isMondayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('mondaySecondPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.mondaySecondPeriodBegining.validationError" />"   />
            

    
      <label for="mondaySecondPeriodEnding" class="condition-isMondayPeriodeChoice-filled"><g:message code="cccrr.property.mondaySecondPeriodEnding.label" />   <span><g:message code="cccrr.property.mondaySecondPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="mondaySecondPeriodEnding" name="mondaySecondPeriodEnding" value="${rqt.mondaySecondPeriodEnding?.toString()}" 
                    class="condition-isMondayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('mondaySecondPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.mondaySecondPeriodEnding.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="cccrr.property.tuesdayRegistrationParam.label" /></legend>
    
      <label class=""><g:message code="cccrr.property.tuesdayPeriod.label" />   <span><g:message code="cccrr.property.tuesdayPeriod.help" /></span></label>
            <ul class=" ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('tuesdayPeriod') ? 'validation-failed' : ''}">
              <g:each in="${['allDay','halfDay']}">
              <li>
                <input type="radio" id="tuesdayPeriod_${it}" class="condition-isTuesdayPeriodeChoice-trigger  validate-one-required" value="fr.cg95.cvq.business.request.school.DayPeriodType_${it}" name="tuesdayPeriod" ${it == rqt.tuesdayPeriod.toString() ? 'checked="checked"': ''} title="<g:message code="cccrr.property.tuesdayPeriod.validationError" />" />
                <label for="tuesdayPeriod_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="cccrr.property.tuesdayPeriod" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="tuesdayFirstPeriodBegining" class=""><g:message code="cccrr.property.tuesdayFirstPeriodBegining.label" />   <span><g:message code="cccrr.property.tuesdayFirstPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="tuesdayFirstPeriodBegining" name="tuesdayFirstPeriodBegining" value="${rqt.tuesdayFirstPeriodBegining?.toString()}" 
                    class="periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('tuesdayFirstPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.tuesdayFirstPeriodBegining.validationError" />"   />
            

    
      <label for="tuesdayFirstPeriodEnding" class=""><g:message code="cccrr.property.tuesdayFirstPeriodEnding.label" />   <span><g:message code="cccrr.property.tuesdayFirstPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="tuesdayFirstPeriodEnding" name="tuesdayFirstPeriodEnding" value="${rqt.tuesdayFirstPeriodEnding?.toString()}" 
                    class=" periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('tuesdayFirstPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.tuesdayFirstPeriodEnding.validationError" />"   />
            

    
      <label for="tuesdaySecondPeriodBegining" class="condition-isTuesdayPeriodeChoice-filled"><g:message code="cccrr.property.tuesdaySecondPeriodBegining.label" />   <span><g:message code="cccrr.property.tuesdaySecondPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="tuesdaySecondPeriodBegining" name="tuesdaySecondPeriodBegining" value="${rqt.tuesdaySecondPeriodBegining?.toString()}" 
                    class="condition-isTuesdayPeriodeChoice-filled periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('tuesdaySecondPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.tuesdaySecondPeriodBegining.validationError" />"   />
            

    
      <label for="tuesdaySecondPeriodEnding" class="condition-isTuesdayPeriodeChoice-filled"><g:message code="cccrr.property.tuesdaySecondPeriodEnding.label" />   <span><g:message code="cccrr.property.tuesdaySecondPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="tuesdaySecondPeriodEnding" name="tuesdaySecondPeriodEnding" value="${rqt.tuesdaySecondPeriodEnding?.toString()}" 
                    class="condition-isTuesdayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('tuesdaySecondPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.tuesdaySecondPeriodEnding.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="cccrr.property.wednesdayRegistrationParam.label" /></legend>
    
      <label class=""><g:message code="cccrr.property.wednesdayPeriod.label" />   <span><g:message code="cccrr.property.wednesdayPeriod.help" /></span></label>
            <ul class=" ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('wednesdayPeriod') ? 'validation-failed' : ''}">
              <g:each in="${['allDay','halfDay']}">
              <li>
                <input type="radio" id="wednesdayPeriod_${it}" class="condition-isWednesdayPeriodeChoice-trigger  validate-one-required" value="fr.cg95.cvq.business.request.school.DayPeriodType_${it}" name="wednesdayPeriod" ${it == rqt.wednesdayPeriod.toString() ? 'checked="checked"': ''} title="<g:message code="cccrr.property.wednesdayPeriod.validationError" />" />
                <label for="wednesdayPeriod_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="cccrr.property.wednesdayPeriod" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="wednesdayFirstPeriodBegining" class=""><g:message code="cccrr.property.wednesdayFirstPeriodBegining.label" />   <span><g:message code="cccrr.property.wednesdayFirstPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="wednesdayFirstPeriodBegining" name="wednesdayFirstPeriodBegining" value="${rqt.wednesdayFirstPeriodBegining?.toString()}" 
                    class=" periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('wednesdayFirstPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.wednesdayFirstPeriodBegining.validationError" />"   />
            

    
      <label for="wednesdayFirstPeriodEnding" class=""><g:message code="cccrr.property.wednesdayFirstPeriodEnding.label" />   <span><g:message code="cccrr.property.wednesdayFirstPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="wednesdayFirstPeriodEnding" name="wednesdayFirstPeriodEnding" value="${rqt.wednesdayFirstPeriodEnding?.toString()}" 
                    class=" periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('wednesdayFirstPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.wednesdayFirstPeriodEnding.validationError" />"   />
            

    
      <label for="wednesdaySecondPeriodBegining" class="condition-isWednesdayPeriodeChoice-filled"><g:message code="cccrr.property.wednesdaySecondPeriodBegining.label" />   <span><g:message code="cccrr.property.wednesdaySecondPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="wednesdaySecondPeriodBegining" name="wednesdaySecondPeriodBegining" value="${rqt.wednesdaySecondPeriodBegining?.toString()}" 
                    class="condition-isWednesdayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('wednesdaySecondPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.wednesdaySecondPeriodBegining.validationError" />"   />
            

    
      <label for="wednesdaySecondPeriodEnding" class="condition-isWednesdayPeriodeChoice-filled"><g:message code="cccrr.property.wednesdaySecondPeriodEnding.label" />   <span><g:message code="cccrr.property.wednesdaySecondPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="wednesdaySecondPeriodEnding" name="wednesdaySecondPeriodEnding" value="${rqt.wednesdaySecondPeriodEnding?.toString()}" 
                    class="condition-isWednesdayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('wednesdaySecondPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.wednesdaySecondPeriodEnding.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="cccrr.property.thursdayRegistrationParam.label" /></legend>
    
      <label class=""><g:message code="cccrr.property.thursdayPeriod.label" />   <span><g:message code="cccrr.property.thursdayPeriod.help" /></span></label>
            <ul class=" ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('thursdayPeriod') ? 'validation-failed' : ''}">
              <g:each in="${['allDay','halfDay']}">
              <li>
                <input type="radio" id="thursdayPeriod_${it}" class="condition-isThursdayPeriodeChoice-trigger  validate-one-required" value="fr.cg95.cvq.business.request.school.DayPeriodType_${it}" name="thursdayPeriod" ${it == rqt.thursdayPeriod.toString() ? 'checked="checked"': ''} title="<g:message code="cccrr.property.thursdayPeriod.validationError" />" />
                <label for="thursdayPeriod_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="cccrr.property.thursdayPeriod" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="thursdayFirstPeriodBegining" class=""><g:message code="cccrr.property.thursdayFirstPeriodBegining.label" />   <span><g:message code="cccrr.property.thursdayFirstPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="thursdayFirstPeriodBegining" name="thursdayFirstPeriodBegining" value="${rqt.thursdayFirstPeriodBegining?.toString()}" 
                    class="periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('thursdayFirstPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.thursdayFirstPeriodBegining.validationError" />"   />
            

    
      <label for="thursdayFirstPeriodEnding" class=""><g:message code="cccrr.property.thursdayFirstPeriodEnding.label" />   <span><g:message code="cccrr.property.thursdayFirstPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="thursdayFirstPeriodEnding" name="thursdayFirstPeriodEnding" value="${rqt.thursdayFirstPeriodEnding?.toString()}" 
                    class="periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('thursdayFirstPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.thursdayFirstPeriodEnding.validationError" />"   />
            

    
      <label for="thursdaySecondPeriodBegining" class="condition-isThursdayPeriodeChoice-filled"><g:message code="cccrr.property.thursdaySecondPeriodBegining.label" />   <span><g:message code="cccrr.property.thursdaySecondPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="thursdaySecondPeriodBegining" name="thursdaySecondPeriodBegining" value="${rqt.thursdaySecondPeriodBegining?.toString()}" 
                    class="condition-isThursdayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('thursdaySecondPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.thursdaySecondPeriodBegining.validationError" />"   />
            

    
      <label for="thursdaySecondPeriodEnding" class="condition-isThursdayPeriodeChoice-filled"><g:message code="cccrr.property.thursdaySecondPeriodEnding.label" />   <span><g:message code="cccrr.property.thursdaySecondPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="thursdaySecondPeriodEnding" name="thursdaySecondPeriodEnding" value="${rqt.thursdaySecondPeriodEnding?.toString()}" 
                    class="condition-isThursdayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('thursdaySecondPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.thursdaySecondPeriodEnding.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="cccrr.property.fridayRegistrationParam.label" /></legend>
    
      <label class=""><g:message code="cccrr.property.fridayPeriod.label" />   <span><g:message code="cccrr.property.fridayPeriod.help" /></span></label>
            <ul class=" ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('fridayPeriod') ? 'validation-failed' : ''}">
              <g:each in="${['allDay','halfDay']}">
              <li>
                <input type="radio" id="fridayPeriod_${it}" class="condition-isFridayPeriodeChoice-trigger  validate-one-required" value="fr.cg95.cvq.business.request.school.DayPeriodType_${it}" name="fridayPeriod" ${it == rqt.fridayPeriod.toString() ? 'checked="checked"': ''} title="<g:message code="cccrr.property.fridayPeriod.validationError" />" />
                <label for="fridayPeriod_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="cccrr.property.fridayPeriod" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="fridayFirstPeriodBegining" class=""><g:message code="cccrr.property.fridayFirstPeriodBegining.label" />   <span><g:message code="cccrr.property.fridayFirstPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="fridayFirstPeriodBegining" name="fridayFirstPeriodBegining" value="${rqt.fridayFirstPeriodBegining?.toString()}" 
                    class="periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('fridayFirstPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.fridayFirstPeriodBegining.validationError" />"   />
            

    
      <label for="fridayFirstPeriodEnding" class=""><g:message code="cccrr.property.fridayFirstPeriodEnding.label" />   <span><g:message code="cccrr.property.fridayFirstPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="fridayFirstPeriodEnding" name="fridayFirstPeriodEnding" value="${rqt.fridayFirstPeriodEnding?.toString()}" 
                    class="periodDay  validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('fridayFirstPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.fridayFirstPeriodEnding.validationError" />"   />
            

    
      <label for="fridaySecondPeriodBegining" class="condition-isFridayPeriodeChoice-filled"><g:message code="cccrr.property.fridaySecondPeriodBegining.label" />   <span><g:message code="cccrr.property.fridaySecondPeriodBegining.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="fridaySecondPeriodBegining" name="fridaySecondPeriodBegining" value="${rqt.fridaySecondPeriodBegining?.toString()}" 
                    class="condition-isFridayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('fridaySecondPeriodBegining') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.fridaySecondPeriodBegining.validationError" />"   />
            

    
      <label for="fridaySecondPeriodEnding" class="condition-isFridayPeriodeChoice-filled"><g:message code="cccrr.property.fridaySecondPeriodEnding.label" />   <span><g:message code="cccrr.property.fridaySecondPeriodEnding.help" /></span></label>
            <input type="text" maxlength="5" size="3" id="fridaySecondPeriodEnding" name="fridaySecondPeriodEnding" value="${rqt.fridaySecondPeriodEnding?.toString()}" 
                    class="condition-isFridayPeriodeChoice-filled periodDay validate-string ${stepStates != null && stepStates['registrationParams']?.invalidFields?.contains('fridaySecondPeriodEnding') ? 'validation-failed' : ''}" title="<g:message code="cccrr.property.fridaySecondPeriodEnding.validationError" />"   />
            

    
    </fieldset>
  

