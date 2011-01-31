<form id="childIdentity_${child.id}" method="post" action="${g.createLink(action:'child')}">
<dt class="required">${message(code:'homeFolder.individual.property.lastName')}'</dt> 
<dd class="required">
	<input type="text" name="lastName" value="${child.lastName}" />
</dd>
<dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
<dd class="required">
	<input type="text" name="firstName" value="${child.firstName}" />
</dd>
<dt>${message(code:'homeFolder.individual.property.firstName2')}</dt>
<dd>
	<input type="text" name="firstName2" value="${child.firstName2}" />
</dd>
<dt>${message(code:'homeFolder.individual.property.firstName3')}</dt>
<dd>
<input type="text" name="firstName3" value="${child.firstName3}" />
</dd>
<dt class="required">${message(code:'homeFolder.individual.property.birthDate')}</dt>
<dd class="required">
	<input type="text" name="birthDate" value="${g.formatDate(formatName:'format.date', date: child.birthDate)}" /></dd>
<dt>${message(code:'homeFolder.individual.property.birthPostalCode')}</dt>
<dd>
	<input type="text" name="birthPostalCode" value="${child.birthPostalCode}" />
</dd>
<dt>${message(code:'homeFolder.individual.property.birthCity')}</dt>
<dd>
	<input type="text" name="birthCity" value="${child.birthCity}" />
</dd>
<dt>${message(code:'homeFolder.individual.property.birthCountry')}</dt>
<dd>
	<input type="text" name="birthCountry" value="${child.birthCountry}" />
</dd>
<g:render template="edit/submit" model="['object':child, 'template':'childIdentity']" />
</form>

