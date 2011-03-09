<form id="identity_${individual.id}" method="post" action="${g.createLink(action:'identity', id : individual.id)}">
  <dt class="required">${message(code:'homeFolder.individual.property.born')}</dt>
  <dd class="required">
    <ul class="yes-no">
      <g:each in="${[true,false]}">
        <li>
          <input type="radio" value="${it}" name="born" ${it == individual?.born ? 'checked="checked"': ''} />
          <label for="born_${it ? 'yes' : 'no'}">${message(code:'message.' + (it ? 'yes' : 'no'))}</label>
        </li>
      </g:each>
    </ul>
  <dd>
  <dt class="required">${message(code:'homeFolder.individual.property.lastName')}</dt> 
  <dd class="required">
    <input type="text" name="lastName" value="${individual.lastName}" />
  </dd>
  <dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
  <dd class="required">
    <input type="text" name="firstName" value="${individual.firstName}" />
  </dd>
  <dt>${message(code:'homeFolder.individual.property.firstName2')}</dt>
  <dd>
    <input type="text" name="firstName2" value="${individual.firstName2}" />
  </dd>
  <dt>${message(code:'homeFolder.individual.property.firstName3')}</dt>
  <dd>
    <input type="text" name="firstName3" value="${individual.firstName3}" />
  </dd>
  <dt class="required">${message(code:'homeFolder.child.property.sex')}</dt>
  <dd>
    <select name="sex">
      <option value="">${message(code:'message.select.defaultOption')}</option>
      <g:each in="${fr.cg95.cvq.business.users.SexType.allSexTypes}">
        <option value="fr.cg95.cvq.business.users.SexType_${it}"
          ${it == individual.sex ? 'selected="selected"': ''}>
          ${g.capdematEnumToText(var:it, i18nKeyPrefix:'homeFolder.child.property.sex')}
        </option>
      </g:each>
    </select>
  </dd>
  <dt class="required">${message(code:'homeFolder.individual.property.birthDate')}</dt>
  <dd class="required">
    <input type="text" name="birthDate" value="${g.formatDate(formatName:'format.date', date: individual.birthDate)}" />
  </dd>
  <dt>${message(code:'homeFolder.individual.property.birthPostalCode')}</dt>
  <dd>
    <input type="text" name="birthPostalCode" value="${individual.birthPostalCode}" />
  </dd>
  <dt>${message(code:'homeFolder.individual.property.birthCity')}</dt>
  <dd>
    <input type="text" name="birthCity" value="${individual.birthCity}" />
  </dd>
  <dt>${message(code:'homeFolder.individual.property.birthCountry')}</dt>
  <dd>
    <input type="text" name="birthCountry" value="${individual.birthCountry}" />
  </dd>
  <g:render template="edit/submit" model="['object':individual, 'template':'childIdentity']" />
</form>
