<h3>
  ${child.firstName} ${child.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd id="homeFolder.individual[${child.id}].lastName" class="action-editField validate-lastname required-true i18n-homeFolder.individual.property.lastName">
        <span>${child.lastName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].firstName" class="action-editField validate-firstname required-true i18n-homeFolder.individual.property.firstName">
        <span>${child.firstName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].firstName2" class="action-editField validate-firstname i18n-homeFolder.individual.property.firstName2">
        <span>${child.firstName2}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].firstName3" class="action-editField validate-firstname i18n-homeFolder.individual.property.firstName3">
        <span>${child.firstName3}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].birthDate" class="action-editField validate-date i18n-homeFolder.individual.property.birthDate">
        <span><g:formatDate format="dd/MM/yyyy" date="${child.birthDate}"/></span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].birthCity" class="action-editField validate-city i18n-homeFolder.individual.property.birthCity">
        <span>${child.birthCity}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].birthCountry" class="action-editField validate-string i18n-homeFolder.individual.property.birthCountry">
        <span>${child.birthCountry}</span>
      </dd>
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd id="homeFolder.individual[${child.id}].adress" class="action-editField validate-address required-true">
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
        <g:each var="individual" in="${childLegalResponsibles}">
          <li>
            <g:each var="roleEnum" in="${individual.getIndividualRoles(child.id)}">
              <g:capdematEnumToFlag var="${roleEnum}" i18nKeyPrefix="homeFolder.role" />
            </g:each> 
            ${individual.firstName} ${individual.lastName}
          </li>
        </g:each>
        </ul>
      </dd>
     </dl>
  </div>
</div>
