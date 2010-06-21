<input type="hidden" name="id" value="${child?.id}" />
<input type="hidden" name="mode" value="edit" />
<div class="yui-g">
  <h3><g:message code="homeFolder.individual.header.civilInformations" /></h3>
  <div class="yui-u first">
    <label for="lastName" class="required">
      <g:message code="homeFolder.individual.property.lastName" />
    </label>
    <input type="text" id="lastName" name="lastName" value="${child?.lastName}"
      class="required validate-lastName ${invalidFields?.contains('lastName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />
    <label for="sex" class="required">
      <g:message code="homeFolder.child.property.sex" />
    </label>
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
  </div>
  <div class="yui-u">
    <label for="firstName" class="required">
      <g:message code="homeFolder.individual.property.firstName" />
    </label>
    <input type="text" id="firstName" name="firstName" value="${child?.firstName}"
      class="required validate-firstName ${invalidFields?.contains('firstName') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />
    <label for="birthDate" class="required">
      <g:message code="homeFolder.individual.property.birthDate" />
      <span><g:message code="homeFolder.individual.property.birthDate.help" /></span>
    </label>
    <input type="text" id="birthDate" name="birthDate"
      value="${formatDate(formatName:'format.date',date:editList?.children?.birthDate)}"
      class="required validate-date ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}"
      title="<g:message code="homeFolder.individual.property.birthDate.validationError" />" />
  </div>
</div>
