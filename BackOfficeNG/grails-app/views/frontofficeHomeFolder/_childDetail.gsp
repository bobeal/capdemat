
<div class="yui-g">
  <h3><g:message code="homeFolder.individual.header.generalInformations" /></h3>
  <div class="yui-u first">
    <dl>
      <dt><g:message code="property.creationDate" /> : </dt> 
      <dd><g:formatDate formatName="format.date" date="${child.creationDate}"/></dd>
      
      <dt><g:message code="property.state" /> : </dt> 
      <dd><g:capdematEnumToFlag var="${child.state}" i18nKeyPrefix="actor.state" /></dd>
    </dl>
  </div>
  <div class="yui-u">
    <dl>
      <g:if test="${!roles.isEmpty()}">
        <dt><g:message code="homeFolder.child.property.legalResponsibles" /> :</dt>
        <dd>
          <g:each var="subjectRole" in="${roles}"> 
            <p>
              ${subjectRole.fullName}
              <g:each var="role" in="${subjectRole.roles}"> 
                <g:capdematEnumToFlag var="${role}" i18nKeyPrefix="homeFolder.role" />
              </g:each>
            </p>
          </g:each>
        </dd>
      </g:if>
    </dl>
  </div>
</div>

<div class="yui-g">
  <h3><g:message code="homeFolder.individual.header.civilInformations" /></h3>
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.child.property.sex" /> : </dt> 
      <dd><g:capdematEnumToText var="${child.sex}" i18nKeyPrefix="homeFolder.child.property.sex"/></dd>
      
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd>${child.lastName}</dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd>${child.firstName}</dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName2" /> : </dt>
      <dd>${child.firstName3}</dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName3" /> : </dt>
      <dd>${child.firstName3}</dd>
      
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd><g:formatDate formatName="format.date" date="${child.birthDate}"/></dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd>${child.birthCity}</dd>
      
      <dt><g:message code="homeFolder.individual.property.birthPostalCode" /> : </dt>
      <dd>${child.birthPostalCode}</dd>
            
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd>${child.birthCountry}</dd>
     </dl>
  </div>
</div>

<div class="yui-g">
  <h3><g:message code="homeFolder.individual.header.contactInformations" /></h3>
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd>
        <div>
          <g:if test="${child.adress.additionalDeliveryInformation}">
            <p>${child.adress.additionalDeliveryInformation}</p>
          </g:if>
          <g:if test="${child.adress.additionalGeographicalInformation}">
            <p>${child.adress.additionalGeographicalInformation}</p>
          </g:if>
          <p>${child.adress.streetNumber} ${child.adress.streetName}</p>
          <g:if test="${child.adress.placeNameOrService}">
            <p>${child.adress.placeNameOrService}</p>
          </g:if>
          <p>${child.adress.postalCode} ${child.adress.city}</p>
          <g:if test="${child.adress.countryName}">
            <p>${child.adress.countryName}</p>
          </g:if>
        </div>
      </dd>
    </dl>
  </div>
  <div class="yui-u">
  </div>
</div>

