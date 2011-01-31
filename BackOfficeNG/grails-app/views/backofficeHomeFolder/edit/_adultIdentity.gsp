<form id="adultIdentity_${adult.id}" method="post" action="${g.createLink(action:'adult')}">
<dt class="required">${message(code:'homeFolder.adult.property.title')}</dt>
<dd class="required">
  <select name="title">
    <g:each var="title" in="${fr.cg95.cvq.business.users.TitleType.allTitleTypes}">
      <option value="fr.cg95.cvq.business.users.TitleType_${title}" ${title == adult.title ? 'selected="selected"' : ''}>
      ${g.capdematEnumToText(var:title, i18nKeyPrefix:'homeFolder.adult.title')}
      </option>
    </g:each>
  </select>
</dd>
<dt>${message(code:'homeFolder.adult.property.familyStatus')}</dt>
<dd> 
  <select name="familyStatus">
    <g:each var="familyStatus" in="${fr.cg95.cvq.business.users.FamilyStatusType.allFamilyStatusTypes}">
      <option value="fr.cg95.cvq.business.users.FamilyStatusType_${familyStatus}" ${familyStatus == adult.familyStatus ? 'selected="selected"' : ''}>
      ${g.capdematEnumToText(var:familyStatus, i18nKeyPrefix:'homeFolder.adult.familyStatus')}
      </option>
    </g:each>
  </select>
</dd>
<dt class="required">${message(code:'homeFolder.individual.property.lastName')}</dt>
<dd class="required">
  <input type="text" name="lastName" value="${adult.lastName}" />
</dd>
<dt>${message(code:'homeFolder.adult.property.maidenName')}</dt>
<dd>
  <input type="text" name="maidenName" value="${adult.maidenName}" />
</dd>
<dt>${message(code:'homeFolder.adult.property.nameOfUse')}</dt>
<dd>
  <input type="text" name="nameOfUse" value="${adult.nameOfUse}" />
</dd>
<dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
<dd class="required">
  <input type="text" name="firstName" value="${adult.firstName}" />
</dd>
<dt>${message(code:'homeFolder.individual.property.firstName2')}</dt>
<dd>
  <input type="text" name="firstName2" value="${adult.firstName2}" />
</dd>
<dt>${message(code:'homeFolder.individual.property.firstName3')}</dt>
<dd>
  <input type="text" name="firstName3" value="${adult.firstName3}" />
</dd>
<dt>${message(code:'homeFolder.adult.property.profession')}</dt>
<dd>
  <input type="text" name="profession" value="${adult.profession}" />
</dd>
<g:render template="edit/submit" model="['object':adult, 'template':'adultIdentity']" />
</form>

