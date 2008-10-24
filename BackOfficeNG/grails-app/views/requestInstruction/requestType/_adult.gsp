<h3>
  <g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /> 
  ${adult.firstName} ${adult.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.adult.property.title" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].title" class="capdematEnum fr.cg95.cvq.business.users.TitleType">
          <g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" />
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].lastName" class="string required">
        <span>${adult.lastName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].maidenName" class="string">
        <span>${adult.maidenName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].nameOfUse" class="string">
        <span>${adult.nameOfUse}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName" class="string required">
        <span>${adult.firstName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.secondFirstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName2" class="string">
        <span>${adult.firstName3}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.thirdFirstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName3" class="string">
        <span>${adult.firstName3}</span>
      </dd>
      
      
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthDate" class="date">
        <span><g:formatDate format="dd/MM/yyyy" date="${adult.birthDate}"/></span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthCity" class="string">
        <span>${adult.birthCity}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthCountry" class="string">
        <span>${adult.birthCountry}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].familyStatus" class="capdematEnum fr.cg95.cvq.business.users.FamilyStatusType">
        <g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" />
      </dd>
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].adress" class="address required">
        <div>
          <p>${adult.adress.additionalDeliveryInformation}</p>
          <p>${adult.adress.additionalGeographicalInformation}</p>
          
          <span>${adult.adress.streetNumber}</span>
          <span>${adult.adress.streetName}</span>
          
          <p>${adult.adress.placeNameOrService}</p>
          
          <span>${adult.adress.postalCode}</span>
          <span>${adult.adress.city}</span>
          
          <p>${adult.adress.countryName}</p>
        </div>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.eMail" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].email" class="email required">
        <span>${adult.email}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].homePhone" class="number required">
        <span>${adult.homePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].mobilePhone" class="number">
        <span>${adult.mobilePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].officePhone" class="number">
        <span>${adult.officePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].profession" class="string">
        <span>${adult.profession}</span>
      </dd>
     </dl>
  </div>
</div>
