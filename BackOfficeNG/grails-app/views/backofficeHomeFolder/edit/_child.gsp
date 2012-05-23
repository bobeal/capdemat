<div id="child_" class="individual">
  <h3>${message(code:'homeFolder.individual.header.newChild')}</h3>
  <form id="addChild" method="post" action="${g.createLink(action:'child')}">
    <dl>
      <dt class="required">${message(code:'homeFolder.individual.property.born')}</dt>
      <dd class="required">
        <ul class="yes-no">
          <g:each in="${[true,false]}">
            <li>
              <input type="radio" value="${it}" name="born" ${it == child?.born ? 'checked="checked"': ''} />
              <label for="born_${it ? 'yes' : 'no'}">${message(code:'message.' + (it ? 'yes' : 'no'))}</label>
            </li>
          </g:each>
        </ul>
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.lastName')}</dt> 
      <dd class="required">
        <input type="text" name="lastName" value="${child.lastName}" />
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
      <dd class="required">
        <input type="text" name="firstName" value="${child.firstName}" />
      </dd>
      <dt class="required">${message(code:'homeFolder.child.property.sex')}</dt>
      <dd>
        <select name="sex">
          <option value="">${message(code:'message.select.defaultOption')}</option>
          <g:each in="${fr.cg95.cvq.business.users.SexType.allSexTypes}">
            <option value="${it.name()}"
              ${it == child.sex ? 'selected="selected"': ''}>
              ${g.capdematEnumToText(var:it, i18nKeyPrefix:'homeFolder.child.property.sex')}
            </option>
          </g:each>
        </select>
      </dd>
      <dt class="required">${message(code:'homeFolder.individual.property.birthDate')} <span class="help"><g:message code="homeFolder.individual.property.birthDate.help" /></span></dt>
      <dd class="required">
        <input type="text" name="birthDate" value="${g.formatDate(formatName:'format.date', date: child.birthDate)}" />
      </dd>
    </dl>
    <h3>${message(code:'homeFolder.individual.header.responsibles')}</h3>
    <dl>
      <p>${message(code:'homeFolder.child.property.legalResponsibles.help')}</p>
      <g:each var="adult" in="${adults}" status="index">
        <dt class="required">
          ${adult.fullName}
          <input type="hidden" name="roles.${index}.owner" value="${adult.id}" />
        </dt>
        <dd>
          <select name="roles.${index}.type">
            <option value="">${message(code:'homeFolder.role.message.none')}</option>
            <g:each var="roleType" in="${fr.cg95.cvq.business.users.RoleType.childRoleTypes}">
              <option value="${roleType.name()}">
                ${g.capdematEnumToText(var:roleType, i18nKeyPrefix:'homeFolder.role.withParticle')}
              </option>
            </g:each>
          </select>
        </dd>
      </g:each>
    </dl>
    <dl style="margin-top:1em">
      <g:render template="edit/submit" model="['object':child]" />
    </dl>
  </form>
</div>
