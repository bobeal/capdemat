<h3>
  <g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" /> 
  ${adult.firstName} ${adult.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.adult.property.title" /> : </dt> 
      <dd id="individuals[${index}].title" class="${action}-editField validate-capdematEnum javatype-fr.cg95.cvq.business.users.TitleType">
          <g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title" />
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
      <dd id="individuals[${index}].familyStatus" class="${action}-editField validate-capdematEnum javatype-fr.cg95.cvq.business.users.FamilyStatusType">
        <g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" />
      </dd>

      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
      <dd id="individuals[${index}].lastName" class="${action}-editField validate-lastname required-true i18n-homeFolder.individual.property.lastName">
        <span>${adult.lastName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.maidenName" /> : </dt> 
      <dd id="individuals[${index}].maidenName" class="${action}-editField validate-lastname i18n-homeFolder.adult.property.maidenName">
        <span>${adult.maidenName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.nameOfUse" /> : </dt> 
      <dd id="individuals[${index}].nameOfUse" class="${action}-editField validate-lastname i18n-homeFolder.adult.property.nameOfUse">
        <span>${adult.nameOfUse}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd id="individuals[${index}].firstName" class="${action}-editField validate-firstname required-true i18n-homeFolder.individual.property.firstName">
        <span>${adult.firstName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
      <dd id="individuals[${index}].firstName2" class="${action}-editField validate-firstname i18n-homeFolder.individual.property.firstName2">
        <span>${adult.firstName3}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
      <dd id="individuals[${index}].firstName3" class="${action}-editField validate-firstname i18n-homeFolder.individual.property.firstName3">
        <span>${adult.firstName3}</span>
      </dd>
     </dl>
      
     <dl>
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd id="individuals[${index}].birthDate" class="${action}-editField validate-date i18n-homeFolder.individual.property.birthDate">
        <span><g:formatDate formatName="format.date" date="${adult.birthDate}"/></span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
      <dd id="individuals[${index}].birthPostalCode" class="${action}-editField validate-postalcode i18n-homeFolder.individual.property.birthPostalCode">
        <span>${adult.birthPostalCode}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd id="individuals[${index}].birthCity" class="${action}-editField validate-city i18n-homeFolder.individual.property.birthCity">
        <span>${adult.birthCity}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd id="individuals[${index}].birthCountry" class="${action}-editField validate-string i18n-homeFolder.individual.property.birthCountry">
        <span>${adult.birthCountry}</span>
      </dd>
      
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd id="individuals[${index}].address" class="${action}-editField validate-address required-true">
        <div>
          <p class="additionalDeliveryInformation">${adult.address.additionalDeliveryInformation}</p>
          <p class="additionalGeographicalInformation">${adult.address.additionalGeographicalInformation}</p>
          
          <span class="streetNumber">${adult.address.streetNumber}</span>
          <span class="streetName">${adult.address.streetName}</span>
          
          <p class="placeNameOrService">${adult.address.placeNameOrService}</p>
          
          <span class="postalCode">${adult.address.postalCode}</span>
          <span class="city">${adult.address.city}</span>
          
          <p class="countryName">${adult.address.countryName}</p>
        </div>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.email" /> : </dt>
      <dd id="individuals[${index}].email" class="${action}-editField validate-email required-true i18n-homeFolder.adult.property.email">
        <span>${adult.email}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
      <dd id="individuals[${index}].homePhone" class="${action}-editField validate-phone required-true i18n-homeFolder.adult.property.homePhone">
        <span>${adult.homePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
      <dd id="individuals[${index}].mobilePhone" class="${action}-editField validate-phone i18n-homeFolder.adult.property.mobilePhone">
        <span>${adult.mobilePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
      <dd id="individuals[${index}].officePhone" class="${action}-editField validate-phone i18n-homeFolder.adult.property.OfficePhone">
        <span>${adult.officePhone}</span>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.profession" /> : </dt>
      <dd id="individuals[${index}].profession" class="${action}-editField validate-string i18n-homeFolder.adult.property.profession">
        <span>${adult.profession}</span>
      </dd>
     </dl>
     
     <dl>
      <dt><g:message code="homeFolder.adult.property.cfbn" /> : </dt> 
      <dd id="individuals[${index}].cfbn" class="action-editField validate-string required-true i18n-homeFolder.adult.property.cfbn">
        <span>${adult.cfbn}</span>
      </dd>
      <dt><g:message code="homeFolder.adult.property.login" /> : </dt> 
      <dd id="individuals[${index}].login">
        <span>${adult.login}</span>
      </dd>
      <dt><g:message code="homeFolder.adult.property.question" /> : </dt> 
      <dd id="individuals[${index}].question">
        <span>${adult.question}</span>
      </dd>
      <dt><g:message code="homeFolder.adult.property.answer" /> : </dt> 
      <dd id="individuals[${index}].answer">
        <span>${adult.answer}</span>
      </dd>
     </dl>
     
  </div>
</div>
