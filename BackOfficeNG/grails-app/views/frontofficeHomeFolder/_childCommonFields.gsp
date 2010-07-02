<input type="hidden" name="id" value="${child?.id}" />
<input type="hidden" name="mode" value="edit" />
  <fieldset>
    <legend><g:message code="homeFolder.individual.header.civilInformations" /></legend>
    <label for="lastName" class="required">
      <g:message code="homeFolder.individual.property.lastName" />
    </label>
    <input type="text" id="lastName" name="lastName" value="${child?.lastName}"
      class="required validate-lastName ${invalidFields?.contains('lastName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />
    <label for="firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /></label>
    <input type="text" id="firstName" name="firstName" value="${child?.firstName}"
      class="required validate-firstName ${invalidFields?.contains('firstName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />

    <label for="sex" class="required"><g:message code="homeFolder.child.property.sex" /></label>
    <select id="sex" name="sex"
      class="required validate-not-first ${invalidFields?.contains('sex') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.child.property.sex.validationError" />">
      <option value=""><g:message code="message.select.defaultOption" /></option>
      <g:each in="${fr.cg95.cvq.business.users.SexType.allSexTypes}">
        <option value="fr.cg95.cvq.business.users.SexType_${it}"
          ${it == child.sex ? 'selected="selected"': ''}>
          <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.child.property.sex" />
        </option>
      </g:each>
    </select>

    <label class="required"><g:message code="homeFolder.individual.property.birthDate" /></label>
    <div class="date required validate-date">
      <select id="birthDate_day" name="birthDate_day"
        class="day ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">
        <option value=""><g:message code="message.select.defaultOption" /></option>
        <g:each in="${1..31}">
          <option value="${it}"
            <g:if test="${child?.birthDate?.date == it
              || (child?.birthDate == null && params['birthDate_day'] == it.toString())}">
              selected="selected"
            </g:if>>
            ${it}
          </option>
        </g:each>
      </select>
      <select id="birthDate_month" name="birthDate_month"
        class="month ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">
        <option value=""><g:message code="message.select.defaultOption" /></option>
        <g:each in="${1..12}">
          <option value="${it}"
            <g:if test="${child?.birthDate?.month == (it - 1)
              || (child?.birthDate == null && params['birthDate_month'] == it.toString())}">
              selected="selected"
            </g:if>>
            <g:message code="month.${it}" />
          </option>
        </g:each>
      </select>
      <input type="text" id="birthDate_year" name="birthDate_year" maxlength="4" size="3"
        class="year ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}"
        value="${child?.birthDate ? child?.birthDate.year + 1900 : params['birthDate_year']}" />
      </div>
    </fieldset>

