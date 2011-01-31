<form id="adultContact_${adult.id}" method="post" action="${g.createLink(action:'adult')}">
<dt class="required">${message(code:'homeFolder.adult.property.email')}</dt>
<dd class="required">
  <input type="text" name="email" value="${adult.email}" />
</dd>
<dt>${message(code:'homeFolder.adult.property.homePhone')}</dt>
<dd>
  <input type="text" name="homePhone" value="${adult.homePhone}" />
</dd>
<dt>${message(code:'homeFolder.adult.property.mobilePhone')}</dt>
<dd>
  <input type="text" name="mobilePhone" value="${adult.mobilePhone}" />
</dd>
<dt>${message(code:'homeFolder.adult.property.officePhone')}</dt>
<dd>
  <input type="text" name="officePhone" value="${adult.officePhone}" />
</dd>
<g:render template="edit/submit" model="['object': adult, 'template':'adultContact']" />
</form>
