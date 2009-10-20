<h3>
  ${child.firstName} ${child.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd id="individuals[${index}].lastName" class="action-editField validate-lastname required-true i18n-homeFolder.individual.property.lastName">
        <span>${child.lastName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd id="individuals[${index}].firstName" class="action-editField validate-firstname required-true i18n-homeFolder.individual.property.firstName">
        <span>${child.firstName}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
      <dd id="individuals[${index}].firstName2" class="action-editField validate-firstname i18n-homeFolder.individual.property.firstName2">
        <span>${child.firstName2}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
      <dd id="individuals[${index}].firstName3" class="action-editField validate-firstname i18n-homeFolder.individual.property.firstName3">
        <span>${child.firstName3}</span>
      </dd>
    </dl>
    <dl>
      <dt><g:message code="homeFolder.child.property.sex" /> : </dt>
      <dd id="individuals[${index}].sex" class="${action}-editField validate-capdematEnum javatype-fr.cg95.cvq.business.users.SexType">
          <g:capdematEnumToField var="${child.sex}" i18nKeyPrefix="homeFolder.child.property.sex" />
      </dd>
    
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd id="individuals[${index}].birthDate" class="action-editField validate-date i18n-homeFolder.individual.property.birthDate">
        <span><g:formatDate formatName="format.date" date="${child.birthDate}"/></span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
      <dd id="individuals[${index}].birthPostalCode" class="${action}-editField validate-postalcode i18n-homeFolder.individual.property.birthPostalCode">
        <span>${child.birthPostalCode}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd id="individuals[${index}].birthCity" class="action-editField validate-city i18n-homeFolder.individual.property.birthCity">
        <span>${child.birthCity}</span>
      </dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd id="individuals[${index}].birthCountry" class="action-editField validate-string i18n-homeFolder.individual.property.birthCountry">
        <span>${child.birthCountry}</span>
      </dd>
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd id="individuals[${index}].adress" class="action-editField validate-address required-true">
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
            <g:each var="roleType" in="${individual.getIndividualRoles(child.id)}">
              <g:capdematEnumToFlag var="${roleType}" i18nKeyPrefix="homeFolder.role" />
            </g:each> 
            ${individual.firstName} ${individual.lastName}
          </li>
        </g:each>
        </ul>
      </dd>
     </dl>
           
  </div>
</div>
