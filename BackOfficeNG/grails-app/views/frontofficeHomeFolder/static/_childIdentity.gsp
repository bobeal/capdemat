<a href="${createLink(action:'child', params:['id':child.id, 'fragment':'identity'])}#identity" class="modify">
  ${message(code:'action.modify')}
</a>
<dl>
  <dt><g:message code="homeFolder.child.property.sex" /> : </dt>
  <dd><g:capdematEnumToText var="${child.sex}" i18nKeyPrefix="homeFolder.child.property.sex"/></dd>
  <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
  <dd>${child.lastName}</dd>
  <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
  <dd>${child.firstName}</dd>
  <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
  <dd>${child.firstName2}</dd>
  <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
  <dd>${child.firstName3}</dd>
  <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
  <dd><g:formatDate formatName="format.date" date="${child.birthDate}"/></dd>
  <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
  <dd>${child.birthPostalCode}</dd>
  <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
  <dd>${child.birthCity}</dd>
  <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
  <dd>${child.birthCountry}</dd>
</dl>
