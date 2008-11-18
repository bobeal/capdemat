<h3>
  <g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /> 
  ${adult.firstName} ${adult.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.adult.property.title" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].title" class="editField capdematEnum fr.cg95.cvq.business.users.TitleType">
          <g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" />
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].lastName" class="editField string required">
        <span>${adult.lastName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].maidenName" class="editField string">
        <span>${adult.maidenName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt> 
      <dd id="homeFolder.individual[${adult.id}].nameOfUse" class="editField string">
        <span>${adult.nameOfUse}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName" class="editField string required">
        <span>${adult.firstName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.secondFirstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName2" class="editField string">
        <span>${adult.firstName3}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.thirdFirstName" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].firstName3" class="editField string">
        <span>${adult.firstName3}</span>
      </dd>
      
      
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthDate" class="editField date">
        <span><g:formatDate format="dd/MM/yyyy" date="${adult.birthDate}"/></span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthCity" class="editField string">
        <span>${adult.birthCity}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].birthCountry" class="editField string">
        <span>${adult.birthCountry}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].familyStatus" class="editField capdematEnum fr.cg95.cvq.business.users.FamilyStatusType">
        <g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" />
      </dd>
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].adress" class="editField address required">
        <div>
          <p class="additionalDeliveryInformation">${adult.adress.additionalDeliveryInformation}</p>
          <p class="additionalGeographicalInformation">${adult.adress.additionalGeographicalInformation}</p>
          
          <span class="streetNumber">${adult.adress.streetNumber}</span>
          <span class="streetName">${adult.adress.streetName}</span>
          
          <p class="placeNameOrService">${adult.adress.placeNameOrService}</p>
          
          <span class="postalCode">${adult.adress.postalCode}</span>
          <span class="city">${adult.adress.city}</span>
          
          <p class="countryName">${adult.adress.countryName}</p>
        </div>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.eMail" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].email" class="editField email required">
        <span>${adult.email}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].homePhone" class="editField number required">
        <span>${adult.homePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].mobilePhone" class="editField number">
        <span>${adult.mobilePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].officePhone" class="editField number">
        <span>${adult.officePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
      <dd id="homeFolder.individual[${adult.id}].profession" class="editField string">
        <span>${adult.profession}</span>
      </dd>
     </dl>
  </div>
</div>
