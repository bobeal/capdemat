<h3>
  ${child.firstName} ${child.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd id="homeFolder.individual[${child.id}].lastName" class="string required">
        <span>${child.lastName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].firstName" class="string required">
        <span>${child.firstName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.secondFirstName" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].firstName2" class="string">
        <span>${child.firstName2}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.thirdFirstName" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].firstName3" class="string">
        <span>${child.firstName3}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].birthDate" class="date">
        <span><g:formatDate format="dd/MM/yyyy" date="${child.birthDate}"/></span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].birthCity" class="string">
        <span>${child.birthCity}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].birthCountry" class="string">
        <span>${child.birthCountry}</span>
      </dd>
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].adress" class="address required">
        <div>
          <p class="additionalDeliveryInformation">${child.adress.additionalDeliveryInformation}</p>
          <p class="additionalGeographicalInformation">${child.adress.additionalGeographicalInformation}</p>
          
          <span class="streetNumber">${child.adress.streetNumber}</span>
          <span class="streetName">${child.adress.streetName}</span>
          
          <p class="placeNameOrService">${child.adress.placeNameOrService}</p>
          
          <span class="postalCode">${child.adress.postalCode}</span>
          <span class="city">${child.adress.city}</span>
          
          <p class="countryName">${child.adress.countryName}</p>
        </div>
      </dd>
      
      <dt><g:message code="homeFolder.child.property.legalResponsibles" /> : </dt>
      <dd>
        <ul>
        <g:each var="clr" in="${childLegalResponsibles}">
          <li>
            <g:capdematEnumToFlag var="${clr.role}" i18nKeyPrefix="homeFolder.child.LegalResponsibleRole" /> 
            ${clr.legalResponsible.firstName} ${clr.legalResponsible.lastName}
          </li>
        </g:each>
        </ul>
      </dd>
     </dl>
  </div>
</div>
