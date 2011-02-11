<dl>
  <dt>${message(code:'property.creationDate')}: </dt>
  <dd><g:formatDate formatName="format.date" date="${child.creationDate}"/></dd>
  <dt>${message(code:'property.state')} : </dt>
  <dd><g:capdematEnumToFlag var="${child.state}" i18nKeyPrefix="user.state" /></dd>
</dl>
