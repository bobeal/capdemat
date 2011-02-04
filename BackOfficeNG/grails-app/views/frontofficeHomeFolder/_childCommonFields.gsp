<input type="hidden" name="id" value="${child?.id}" />
<input type="hidden" name="mode" value="edit" />
  <fieldset>
    <label class="required">
   <g:message code="homeFolder.individual.property.born" /> *
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
    <script type="text/javascript">
      var zcf = zenexity.capdemat.fong;
      zcf.i18n = {};
      zcf.i18n['child.expectedBirthDate'] = '<g:message code="homeFolder.individual.property.expectedBirthDate" />';
      zcf.i18n['child.birthDate'] = '<g:message code="homeFolder.individual.property.birthDate" />';
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
    </fieldset>
  <fieldset>
    <legend><g:message code="homeFolder.property.legalResponsibles" /></legend>
    <g:set var="roleCount" value="${0}" />
    <ul>
      <g:each var="roleOwner" in="${roleOwners}">
        <g:each var="individualRole" in="${roleOwner.getIndividualRoles(child.id)}">
          <li>
            <input type="hidden" name="roles.${roleCount}.id" value="${individualRole.id}" />
            <select name="roles.${roleCount}.owner" style="width : auto; display : inline;">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="adult" in="${adults}">
                <option value="${adult.id}"
                  <g:if test="${roleOwner.id == adult.id}">selected="selected"</g:if>>
                  <g:if test="${adult.id == currentUser.id}">
                    <g:message code="homeFolder.role.message.YouAre" />
                  </g:if>
                  <g:else>
                    <g:message code="homeFolder.role.message.anotherAdultIs" args="${[adult.fullName]}"/>
                  </g:else>
                </option>
              </g:each>
            </select>
            <select name="roles.${roleCount}.type" style="width : auto; display : inline;">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
                <option value="${roleType}"
                  <g:if test="${individualRole.role.equals(roleType)}">selected="selected"</g:if>>
                  <g:capdematEnumToText var="${roleType}" i18nKeyPrefix="homeFolder.role.withParticle" />
                </option>
              </g:each>
            </select>
          </li>
          <g:set var="roleCount" value="${roleCount + 1}" />
        </g:each>
      </g:each>
      <g:if test="${roleCount < 3}">
        <g:each var="i" in="${roleCount..2}">
          <li>
            <select name="roles.${i}.owner" style="width : auto; display : inline;"
              class="${i == 0 && invalidFields?.contains('legalResponsibles') ? 'validation-failed' : ''}">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="adult" in="${adults}">
                <option value="${adult.id}"
                  <g:if test="${params['roles.' + i + '.owner'] == adult.id.toString()}">selected="selected"</g:if>>
                  <g:if test="${adult.id == currentUser.id}">
                    <g:message code="homeFolder.role.message.YouAre" />
                  </g:if>
                  <g:else>
                    <g:message code="homeFolder.role.message.anotherAdultIs" args="${[adult.fullName]}"/>
                  </g:else>
                </option>
              </g:each>
            </select>
            <select name="roles.${i}.type" style="width : auto; display : inline;"
              class="${i == 0 && invalidFields?.contains('legalResponsibles') ? 'validation-failed' : ''}">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
                <option value="${roleType}"
                  <g:if test="${params['roles.' + i + '.type'] == roleType.toString()}">selected="selected"</g:if>>
                  <g:capdematEnumToText var="${roleType}" i18nKeyPrefix="homeFolder.role.withParticle" />
                </option>
              </g:each>
            </select>
          </li>
        </g:each>
      </g:if>
    </ul>
  </fieldset>
