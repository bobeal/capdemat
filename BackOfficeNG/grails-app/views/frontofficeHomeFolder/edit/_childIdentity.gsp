<form id="childIdentity_${child.id}" method="post" action="${g.createLink(action:'child')}">
    <label class="required">
    ${message(code:'homeFolder.individual.property.born')} *
    </label>
    <ul class="yes-no required ${flash.invalidFields?.contains('born') ? 'validation-failed' : ''}">
      <g:each in="${[true,false]}">
        <li>
          <input type="radio" id="born_${it ? 'yes' : 'no'}"
            class="required validate-one-required boolean born" title=""
            value="${it}" name="born" ${it == child?.born ? 'checked="checked"': ''} />
          <label for="born_${it ? 'yes' : 'no'}">${message(code:'message.' + (it ? 'yes' : 'no'))}</label>
        </li>
      </g:each>
    </ul>

    <label for="lastName" class="required">${message(code:'homeFolder.individual.property.lastName')} *</label>
    <input type="text" name="lastName" value="${child.lastName}" 
      class="required validate-lastName ${flash.invalidFields?.contains('lastName') ? 'validation-failed' : ''}" 
      title="${message(code:'homeFolder.individual.property.lastName.validationError')}" />

    <label for="firstName" class="required">${message(code:'homeFolder.individual.property.firstName')} *</label>
    <input type="text" name="firstName" value="${child.firstName}" 
      class="required validate-firstName ${flash.invalidFields?.contains('firstName') ? 'validation-failed' : ''}" 
      title="${message(code:'homeFolder.individual.property.firstName.validationError')}" />

    <label for="firstName2">${message(code:'homeFolder.individual.property.firstName2')}</label>
    <input type="text" name="firstName2" value="${child.firstName2}" />

    <label for="firstName3">${message(code:'homeFolder.individual.property.firstName3')}</label>
    <input type="text" name="firstName3" value="${child.firstName3}" />

   <label for="sex" class="required">${message(code:'homeFolder.child.property.sex')}</label>
    <select id="sex" name="sex"
      class="required validate-not-first ${flash.invalidFields?.contains('sex') ? 'validation-failed' : ''}"
      title="${message(code:'homeFolder.child.property.sex.validationError')}">
      <option value="">${message(code:'message.select.defaultOption')}</option>
      <g:each in="${fr.cg95.cvq.business.users.SexType.allSexTypes}">
        <option value="fr.cg95.cvq.business.users.SexType_${it}"
          ${it == child.sex ? 'selected="selected"': ''}>
          ${g.capdematEnumToText(var:it, i18nKeyPrefix:'homeFolder.child.property.sex')}
        </option>
      </g:each>
    </select>

    <label class="required">${message(code:'homeFolder.individual.property.birthDate')} *</label>
      <script type="text/javascript">
        var zcf = zenexity.capdemat.fong;
        zcf.i18n = {};
        zcf.i18n['child.expectedBirthDate'] = "${message(code:'homeFolder.individual.property.expectedBirthDate')}";
        zcf.i18n['child.birthDate'] = "${message(code:'homeFolder.individual.property.birthDate')}";
      </script>
      <div class="date required validate-date">
        <select id="birthDate_day" name="birthDate_day" class="day ${flash.invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">
          <option value="">${message(code:'message.select.defaultOption')}</option>
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
        <select id="birthDate_month" name="birthDate_month" class="month ${flash.invalidFields?.contains('birthDate') ? 'validation-failed' : ''}">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each in="${1..12}">
            <option value="${it}"
              <g:if test="${child?.birthDate?.month == (it - 1)
                || (child?.birthDate == null && params['birthDate_month'] == it.toString())}">
                selected="selected"
              </g:if>>
              ${message(code:'month.' + it)}
            </option>
          </g:each>
        </select>
        <input type="text" id="birthDate_year" name="birthDate_year" maxlength="4" size="3"
          class="year ${flash.invalidFields?.contains('birthDate') ? 'validation-failed' : ''}"
          value="${child?.birthDate ? child?.birthDate.year + 1900 : params['birthDate_year']}" />
      </div>

    <label for="birthPostalCode">${message(code:'homeFolder.individual.property.birthPostalCode')}</label>
    <input type="text" name="birthPostalCode" value="${child.birthPostalCode}" />

    <label for="birthCity">${message(code:'homeFolder.individual.property.birthCity')}</label>
    <input type="text" name="birthCity" value="${child.birthCity}" />

    <label for="birthCountry">${message(code:'homeFolder.individual.property.birthCountry')}</label>
    <input type="text" name="birthCountry" value="${child.birthCountry}" />

    <g:render template="edit/submit" model="['individual':child, 'fragment':'identity']" />
</form>
