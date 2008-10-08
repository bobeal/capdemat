<h3>
  <g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /> 
  ${adult.firstName} ${adult.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.adult.property.title" /> : </dt> 
      <dd><g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /> </dd>
      
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd>${adult.lastName}</dd>
      
      <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt> 
      <dd>${adult.maidenName}</dd>
      
      <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt> 
      <dd>${adult.nameOfUse}</dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd>${adult.firstName}</dd>
      
      <dt><g:message code="homeFolder.individual.property.secondFirstName" /> : </dt>
      <dd>${adult.firstName3}</dd>
      
      <dt><g:message code="homeFolder.individual.property.thirdFirstName" /> : </dt>
      <dd>${adult.firstName3}</dd>
      
      
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd><g:formatDate format="dd/MM/yyyy" date="${adult.birthDate}"/></dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd>${adult.birthCity}</dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd>${adult.birthCountry}</dd>
      
      <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt> 
      <dd><g:capdematEnumToText var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd>
        <p>${adult.adress.streetName}</p>
        <p>
          ${adult.adress.postalCode}&nbsp;
          ${adult.adress.city}
        </p>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.eMail" /> : </dt>
      <dd>${adult.email}</dd>
      
      <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
      <dd>${adult.mobilePhone}</dd>
      
      <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
      <dd>${adult.homePhone}</dd>
      
      <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
      <dd>${adult.officePhone}</dd>
      
      <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
      <dd>${adult.profession}</dd>
     </dl>
  </div>
</div>
