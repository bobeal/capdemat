<form id="identity_${individual.id}" method="post" action="${g.createLink(action:'identity', id : individual.id)}">
  <dt class="required">${message(code:'homeFolder.individual.property.lastName')}'</dt> 
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
  <dt class="required">${message(code:'homeFolder.individual.property.birthDate')}</dt>
  <dd class="required">
    <input type="text" name="birthDate" value="${g.formatDate(formatName:'format.date', date: individual.birthDate)}" /></dd>
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
