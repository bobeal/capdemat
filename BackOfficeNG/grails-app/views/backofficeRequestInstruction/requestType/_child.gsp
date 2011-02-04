<h3>
  <g:if test="${child.born}">${child.firstName} ${child.lastName}</g:if>
  <g:else><g:message code="request.subject.childNoBorn" args="${[child.fullName]}" /></g:else>
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.individual.property.born" /> : </dt>
      <dd id="individuals[${index}].born" class="action-editField validate-boolean required-true i18n-homeFolder.individual.property.born">
        <span class="value-${child.born}"><g:message code="message.${child.born ? 'yes' : 'no'}" /></span>
      </dd>

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
      <dd id="individuals[${index}].address" class="action-editField validate-address required-true">
        <div>
          <p class="additionalDeliveryInformation">${child.address.additionalDeliveryInformation}</p>
          <p class="additionalGeographicalInformation">${child.address.additionalGeographicalInformation}</p>
          
          <span class="streetNumber">${child.address.streetNumber}</span>
          <span class="streetName">${child.address.streetName}</span>
          
          <p class="placeNameOrService">${child.address.placeNameOrService}</p>
          
          <span class="postalCode">${child.address.postalCode}</span>
          <span class="city">${child.address.city}</span>
          
          <p class="countryName">${child.address.countryName}</p>
        </div>
      </dd>
      
      <dt><g:message code="homeFolder.child.property.legalResponsibles" /> : </dt>
      <dd>
        <ul>
        <g:each var="individual" in="${childLegalResponsibles}">
          <li>
            <g:each in="${individual.getIndividualRoles(child.id)}">
              <g:capdematEnumToFlag var="${it.role}" i18nKeyPrefix="homeFolder.role" />
            </g:each> 
            ${individual.firstName} ${individual.lastName}
          </li>
        </g:each>
        </ul>
      </dd>
     </dl>
           
  </div>
</div>
