<a href="${createLink(action:'adult', params:['id':adult.id, 'fragment':'identity'])}#identity" class="modify">
  ${message(code:'action.modify')}
</a>
<dl>
  <dt>${message(code:'homeFolder.adult.property.title')} : </dt>
  <dd><g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /></dd>
  <dt>${message(code:'homeFolder.individual.property.lastName')} : </dt>
  <dd>${adult.lastName}</dd>
  <dt>${message(code:'homeFolder.adult.property.familyStatus')} : </dt>
  <dd><g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>
  <dt>${message(code:'homeFolder.adult.property.maidenName')} : </dt>
  <dd>${adult.maidenName}</dd>
  <dt>${message(code:'homeFolder.adult.property.nameOfUse')} : </dt>
  <dd>${adult.nameOfUse}</dd>
  <dt>${message(code:'homeFolder.individual.property.firstName')} : </dt>
  <dd>${adult.firstName}</dd>
  <dt>${message(code:'homeFolder.individual.property.firstName2')} : </dt>
  <dd>${adult.firstName2}</dd>
  <dt>${message(code:'homeFolder.individual.property.firstName3')} : </dt>
  <dd>${adult.firstName3}</dd>
  <dt>${message(code:'homeFolder.adult.property.profession')} : </dt>
  <dd>${adult.profession}</dd>
%{--  <dt>${message(code:'homeFolder.individual.property.birthDate')} : </dt>--}%
%{--  <dd><g:formatDate formatName="format.date" date="${adult.birthDate}" /></dd>--}%
%{--  <dt>${message(code:'homeFolder.individual.property.birthCity')} : </dt>--}%
%{--  <dd>${adult.birthCity}</dd>--}%
%{--  <dt>${message(code:'homeFolder.individual.property.birthPostalCode')} : </dt>--}%
%{--  <dd>${adult.birthPostalCode}</dd>--}%
%{--  <dt>${message(code:'homeFolder.individual.property.birthCountry')} : </dt>--}%
%{--  <dd>${adult.birthCountry}</dd>--}%
</dl>
