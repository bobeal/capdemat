<g:each in="${children}" var="child">
  <h3>
    ${child.firstName} ${child.lastName}
  </h3>
  <div class="yui-g">
    <div class="yui-u first">
      <dl>
        <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
        <dd>
          <span>${child.lastName}</span>
        </dd>
      
        <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
        <dd>
          <span>${child.firstName}</span>
        </dd>
      
        <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
        <dd>
          <span>${child.firstName2}</span>
        </dd>
      
        <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
        <dd >
          <span>${child.firstName3}</span>
        </dd>
      </dl>
      <dl>
        <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
        <dd>
          <span><g:formatDate formatName="format.date" date="${child.birthDate}"/></span>
        </dd>
      
        <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
        <dd>
          <span>${child.birthPostalCode}</span>
        </dd>
      
        <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
        <dd>
          <span>${child.birthCity}</span>
        </dd>
      
        <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
        <dd>
          <span>${child.birthCountry}</span>
        </dd>
      </dl>
    </div>
  
    <div class="yui-u">
      <dl>
        <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
        <dd>
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
          <g:each var="individual" in="${responsibles[child.id]}">
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

</g:each>