<h3><g:message code="vcr.step.adults.label" /></h3>
<g:each var="it" in="${individuals?.adults}" status="index">
  <dl>
    <dt><g:message code="homeFolder.adult.property.title" /> : </dt>
    <dd> <g:capdematEnumToField var="${it?.title}" i18nKeyPrefix="homeFolder.adult.title" /></dd>

    <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
    <dd>${it?.lastName}</dd>

    <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
    <dd>${it?.firstName}</dd>

    <dt><g:message code="homeFolder.adult.property.familyStatus" /> : </dt>
    <dd> <g:capdematEnumToField var="${it?.familyStatus}" i18nKeyPrefix="homeFolder.adult.familyStatus" /></dd>

    <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
    <dd>
      <div>
        <p class="additionalDeliveryInformation">${it?.adress?.additionalDeliveryInformation}</p>
        <p class="additionalGeographicalInformation">${it?.adress?.additionalGeographicalInformation}</p>
        <span class="streetNumber">${it?.adress?.streetNumber}</span>
        <span class="streetName">${it?.adress?.streetName}</span>
        <p class="placeNameOrService">${it?.adress?.placeNameOrService}</p>
        <span class="postalCode">${it?.adress?.postalCode}</span>
        <span class="city">${it?.adress?.city}</span>
        <p class="countryName">${it?.adress?.countryName}</p>
      </div>
    </dd>

    <dt><g:message code="homeFolder.adult.property.email" /> : </dt>
    <dd>${it?.email}</dd>

    <dt><g:message code="homeFolder.adult.property.homePhone" /> : </dt>
    <dd>${it?.homePhone}</dd>

    <dt><g:message code="homeFolder.adult.property.mobilePhone" /> : </dt>
    <dd>${it?.mobilePhone}</dd>

    <dt><g:message code="homeFolder.adult.property.officePhone" /> : </dt>
    <dd>${it?.officePhone}</dd>
  </dl>
</g:each>

<h3><g:message code="vcr.step.children.label" /></h3>
<g:each var="it" in="${individuals?.children}" status="index">
  <dl>
    <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt>
    <dd>${it?.lastName}</dd>

    <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
    <dd>${it?.firstName}</dd>

    <dt><g:message code="homeFolder.child.property.sex" /> : </dt>
    <dd><g:capdematEnumToField var="${it?.sex}" i18nKeyPrefix="homeFolder.child.sex" /></dd>

    <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
    <dd><span><g:formatDate formatName="format.date" date="${it?.birthDate}"/></span></dd>
  </dl>
</g:each>
