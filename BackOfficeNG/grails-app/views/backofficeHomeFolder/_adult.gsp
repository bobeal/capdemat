<h3>
  <g:capdematEnumToText var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title"/>
  ${adult.firstName} ${adult.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="homeFolder.adult.property.title"/> :</dt>
      <dd>
        <g:capdematEnumToField var="${adult.title}" i18nKeyPrefix="homeFolder.adult.title"/>
      </dd>
      
      <dt><g:message code="homeFolder.adult.property.responsible"/> :</dt>
      <dd>
        <g:if test="${adult.id == responsible}">oui
        </g:if>
        <g:else>non</g:else>
      </dd>

      <dt><g:message code="homeFolder.adult.property.familyStatus"/> :</dt>
      <dd>
        <g:capdematEnumToField var="${adult.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus"/>
      </dd>

      <dt><g:message code="homeFolder.individual.property.lastName"/> :</dt>
      <dd>
        <span>${adult.lastName}</span>
      </dd>

      <dt><g:message code="homeFolder.adult.property.maidenName"/> :</dt>
      <dd>
        <span>${adult.maidenName}</span>
      </dd>

      <dt><g:message code="homeFolder.adult.property.nameOfUse"/> :</dt>
      <dd>
        <span>${adult.nameOfUse}</span>
      </dd>

      <dt><g:message code="homeFolder.individual.property.firstName"/> :</dt>
      <dd>
        <span>${adult.firstName}</span>
      </dd>

      <dt><g:message code="homeFolder.individual.property.firstName2"/> :</dt>
      <dd>
        <span>${adult.firstName2}</span>
      </dd>

      <dt><g:message code="homeFolder.individual.property.firstName3"/> :</dt>
      <dd>
        <span>${adult.firstName3}</span>
      </dd>
    </dl>

  </div>

  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address"/> :</dt>
      <dd>
        <p>${adult?.adress?.additionalDeliveryInformation}</p>
        <p>${adult?.adress?.additionalGeographicalInformation}</p>
        <span>${adult?.adress?.streetNumber}</span>
        <span>${adult?.adress?.streetName}</span>
        <p>${adult?.adress?.placeNameOrService}</p>
        <span>${adult?.adress?.postalCode}</span>
        <span>${adult?.adress?.city}</span>
        <p>${adult?.adress?.countryName}</p>
      </dd>

      <dt><g:message code="homeFolder.adult.property.email"/> :</dt>
      <dd>
        <span>${adult.email}</span>
      </dd>

      <dt><g:message code="homeFolder.adult.property.homePhone"/> :</dt>
      <dd>
        <span>${adult.homePhone}</span>
      </dd>

      <dt><g:message code="homeFolder.adult.property.mobilePhone"/> :</dt>
      <dd>
        <span>${adult.mobilePhone}</span>
      </dd>

      <dt><g:message code="homeFolder.adult.property.officePhone"/> :</dt>
      <dd>
        <span>${adult.officePhone}</span>
      </dd>

      <dt><g:message code="homeFolder.adult.property.profession"/> :</dt>
      <dd>
        <span>${adult.profession}</span>
      </dd>
    </dl>

    <dl>
      <dt><g:message code="homeFolder.adult.property.cfbn"/> :</dt>
      <dd>
        <span>${adult.cfbn}</span>
      </dd>
      <dt><g:message code="homeFolder.adult.property.login"/> :</dt>
      <dd>
        <span>${adult.login}</span>
      </dd>
      <dt><g:message code="homeFolder.adult.property.question"/> :</dt>
      <dd>
        <span>${adult.question}</span>
      </dd>
      <dt><g:message code="homeFolder.adult.property.answer"/> :</dt>
      <dd>
        <span>${adult.answer}</span>
      </dd>
    </dl>

  </div>
</div>
