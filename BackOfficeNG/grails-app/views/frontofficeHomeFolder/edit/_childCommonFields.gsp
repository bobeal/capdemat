<%
  // hack : this template is use by FrontofficeRequestController
  if (flash.invalidFields) invalidFields = flash.invalidFields
%>
<input type="hidden" name="id" value="${child?.id}" />
<label class="required">
  <g:message code="homeFolder.individual.property.born" /> *
</label>
<ul class="yes-no required ${stepStates != null && stepStates['children']?.invalidFields?.contains('born') ? 'validation-failed' : ''}">
  <g:each in="${[true,false]}">
    <li>
      <input type="radio" id="born_${it ? 'yes' : 'no'}"
        class="required validate-one-required boolean born" title=""
        value="${it}" name="born" ${it == child?.born ? 'checked="checked"': ''} />
      <label for="born_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
    </li>
  </g:each>
</ul>

<label for="lastName" class="required">
  <g:message code="homeFolder.individual.property.lastName" /> *
</label>
<input type="text" id="lastName" name="lastName" value="${child?.lastName}"
  class="required validate-lastName ${invalidFields?.contains('lastName') ? 'validation-failed' : ''}"
  title="<g:message code="homeFolder.individual.property.lastName.validationError" />" />
<label for="firstName" class="required"><g:message code="homeFolder.individual.property.firstName" /> *</label>
<input type="text" id="firstName" name="firstName" value="${child?.firstName}"
  class="required validate-firstName ${invalidFields?.contains('firstName') ? 'validation-failed' : ''}"
  title="<g:message code="homeFolder.individual.property.firstName.validationError" />" />

<label for="sex" class="required"><g:message code="homeFolder.child.property.sex" /> *</label>
<select id="sex" name="sex"
  class="required validate-not-first ${invalidFields?.contains('sex') ? 'validation-failed' : ''}"
  title="<g:message code="homeFolder.child.property.sex.validationError" />">
  <option value=""><g:message code="message.select.defaultOption" /></option>
  <g:each in="${fr.cg95.cvq.business.users.SexType.allSexTypes}">
    <option value="${it.name()}"
      ${it == child.sex ? 'selected="selected"': ''}>
      <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.child.property.sex" />
    </option>
  </g:each>
</select>
<label class="required"><g:message code="homeFolder.individual.property.birthDate" /> * <span class="help"><g:message code="homeFolder.individual.property.birthDate.help" /></span></label>
<script type="text/javascript">
  var zcf = zenexity.capdemat.fong;
  zcf.i18n = {};
  zcf.i18n['child.expectedBirthDate'] = '<g:message code="homeFolder.individual.property.expectedBirthDate" /> * <span class="help"><g:message code="homeFolder.individual.property.birthDate.help" /></span>';
  zcf.i18n['child.birthDate'] = '<g:message code="homeFolder.individual.property.birthDate" /> * <span class="help"><g:message code="homeFolder.individual.property.birthDate.help" />';
</script>

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

<label class="required">
  <g:message code="homeFolder.child.property.legalResponsibles" /> *
</label>
<g:if test="${invalidFields?.contains('legalResponsibles')}">
  <p class="error" style="text-align:left;">${message(code:'homeFolder.child.property.legalResponsibles.help')}<p>
</g:if>
<g:each var="adult" in="${adults}">
  <p>
    <input type="hidden" name="roles.${adults.indexOf(adult)}.owner"style="width: auto; display: inline; margin-bottom: .5em;" value="${adult.id}"/>
    ${adult.fullName + message(code:'homeFolder.role.message.anotherAdultIs', args:['']) }
    <select name="roles.${adults.indexOf(adult)}.type" style="width: auto; display: inline; margin-bottom: .5em;">
      <option value="">${message(code:'homeFolder.role.message.none')}</option>
      <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
        <option value="${roleType}" ${roles?.(adults.indexOf(adult) + ".type").equals(roleType.toString()) ? 'selected="selected"' : ''}>
          ${g.capdematEnumToText(var:roleType, i18nKeyPrefix:'homeFolder.role.withParticle')}
        </option>
      </g:each>
    </select>
  </p>
</g:each>
