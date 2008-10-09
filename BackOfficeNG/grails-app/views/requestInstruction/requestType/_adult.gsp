<h3>
  <g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /> 
  ${adult.firstName} ${adult.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.adult.property.title" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].title" class="capdematEnum"><g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /> </dd>
      
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].lastName" class="string">${adult.lastName}</dd>
      
      <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].maidenName" class="string">${adult.maidenName}</dd>
      
      <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].nameOfUse" class="string">${adult.nameOfUse}</dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName" class="string">${adult.firstName}</dd>
      
      <dt><g:message code="homeFolder.individual.property.secondFirstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName2" class="string">${adult.firstName3}</dd>
      
      <dt><g:message code="homeFolder.individual.property.thirdFirstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName3" class="string">${adult.firstName3}</dd>
      
      
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthDate" class="date"><g:formatDate format="dd/MM/yyyy" date="${adult.birthDate}"/></dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthCity" class="string">${adult.birthCity}</dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthCountry" class="string">${adult.birthCountry}</dd>
      
      <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].familyStatus" class="capdematEnum"><g:capdematEnumToText var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].address" class="address">
        <p>${adult.adress.streetName}</p>
        <p>
          ${adult.adress.postalCode}&nbsp;
          ${adult.adress.city}
        </p>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.eMail" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].eMail" class="email">${adult.email}</dd>
      
      <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].mobilePhone" class="phoneNumber">${adult.mobilePhone}</dd>
      
      <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].homePhone" class="phoneNumber">${adult.homePhone}</dd>
      
      <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].officePhone" class="phoneNumber">${adult.officePhone}</dd>
      
      <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].profession" class="string">${adult.profession}</dd>
     </dl>
  </div>
</div>
