<form id="adultIdentity_${adult.id}" method="post" action="${g.createLink(action:'adult')}">

  <label for="title" class="required">${message(code:'homeFolder.adult.property.title')} *</label>
  <select id="title" name="title"
      class="required validate-not-first ${invalidFields?.contains('title') ? 'validation-failed' : ''}"
      title="${message(code:'homeFolder.adult.property.title.validationError')}">
    <option value="">${message(code:'message.select.defaultOption')}</option>
    <g:each in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
      <option value="fr.cg95.cvq.business.users.TitleType_${it}"
          ${it == adult.title ? 'selected="selected"' : ''}>
        <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.title" />
      </option>
    </g:each>
  </select>

  <label for="familyStatus">${message(code:'homeFolder.adult.property.familyStatus')}</label>
  <select id="familyStatus" name="familyStatus">
    <option value="">${message(code:'message.select.defaultOption')}</option>
    <g:each in="${fr.cg95.cvq.business.users.FamilyStatusType.allFamilyStatusTypes}">
      <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}"
          ${it == adult.familyStatus ? 'selected="selected"' : ''}>
        <g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.adult.familyStatus" />
      </option>
    </g:each>
  </select>

  <label for="lastName" class="required">${message(code:'homeFolder.individual.property.lastName')} *</label>
  <input type="text" id="lastName" name="lastName" value="${adult.lastName}"
      class="required validate-lastName ${invalidFields?.contains('lastName') ? 'validation-failed' : ''}"
      title="${message(code:'homeFolder.individual.property.lastName.validationError')}" />

  <label for="maidenName">${message(code:'homeFolder.adult.property.maidenName')}</label>
  <input type="text" name="maidenName" value="${adult.maidenName}" />

  <label for="nameOfUse">${message(code:'homeFolder.adult.property.nameOfUse')}</label>
  <input type="text" name="nameOfUse" value="${adult.nameOfUse}" />

  <label for="firstName" class="required">${message(code:'homeFolder.individual.property.firstName')} *</label>
  <input type="text" id="firstName" name="firstName" value="${adult.firstName}"
      class="required validate-firstName ${invalidFields?.contains('firstName') ? 'validation-failed' : ''}"
      title="${message(code:'homeFolder.individual.property.firstName.validationError')}" />

  <label for="firstName2">${message(code:'homeFolder.individual.property.firstName2')}</label>
  <input type="text" id="firstName2" name="firstName2" value="${adult.firstName2}"
      class="validate-firstName ${invalidFields?.contains('firstName2') ? 'validation-failed' : ''}"
      title="${message(code:'homeFolder.individual.property.firstName2.validationError')}" />

  <label for="firstName3">${message(code:'homeFolder.individual.property.firstName3')}</label>
  <input type="text" id="firstName3" name="firstName3" value="${adult.firstName3}"
      class="validate-firstName ${invalidFields?.contains('firstName3') ? 'validation-failed' : ''}"
      title="${message(code:'homeFolder.individual.property.firstName3.validationError')}" />

  <label for="profession">${message(code:'homeFolder.adult.property.profession')}</label>
  <input type="text" name="profession" value="${adult.profession}" />

%{--  <label >${message(code:'homeFolder.individual.property.birthDate')}</label>--}%
%{--  <div class="date validate-date">--}%
%{--    <select id="birthDate_day" name="birthDate_day" class="day ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">--}%
%{--    <option value="">${message(code:'message.select.defaultOption')}</option>--}%
%{--      <g:each in="${1..31}">--}%
%{--        <option value="${it}"--}%
%{--          <g:if test="${adult.birthDate?.date == it || (adult.birthDate == null && params['birthDate_day'] == it.toString())}">--}%
%{--            selected="selected"--}%
%{--          </g:if>--}%
%{--        >${it}</option>--}%
%{--      </g:each>--}%
%{--    </select>--}%
%{--    <select id="birthDate_month" name="birthDate_month" class="month ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">--}%
%{--      <option value="">${message(code:'message.select.defaultOption')}</option>--}%
%{--      <g:each in="${1..12}">--}%
%{--        <option value="${it}"--}%
%{--          <g:if test="${adult.birthDate?.month == (it - 1) || (adult?.birthDate == null && params['birthDate_month'] == it.toString())}">--}%
%{--            selected="selected"--}%
%{--          </g:if>--}%
%{--        ><g:message code="month.${it}" /></option>--}%
%{--      </g:each>--}%
%{--    </select>--}%
%{--    <input type="text" id="birthDate_year" name="birthDate_year" maxlength="4" size="3"--}%
%{--        class="year ${invalidFields?.contains('birthDate') ? 'validation-failed' : ''}"--}%
%{--        value="${adult.birthDate ? adult.birthDate.year + 1900 : params['birthDate_year']}" />--}%
%{--  </div>--}%

%{--  <label for="birthCity">${message(code:'homeFolder.individual.property.birthCity')}</label>--}%
%{--  <input type="text" name="birthCity" value="${adult.birthCity}" />--}%

%{--  <label for="birthPostalCode">${message(code:'homeFolder.individual.property.birthPostalCode')}</label>--}%
%{--  <input type="text" name="birthPostalCode" value="${adult.birthPostalCode}" />--}%

%{--  <label for="birthCountry">${message(code:'homeFolder.individual.property.birthCountry')}</label>--}%
%{--  <input type="text" name="birthCountry" value="${adult.birthCountry}" />--}%

  <g:render template="edit/submit" model="['individual':adult, 'fragment':'identity']" />
</form>
