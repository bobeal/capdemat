  <dt><g:message code="homeFolder.adult.property.title" /></dt>
  <dd>
  <g:if test="${requester?.title}">
    <g:capdematEnumToField var="${requester?.title}" i18nKeyPrefix="homeFolder.adult.title" />
  </g:if>
  </dd>

  <dt><g:message code="homeFolder.individual.property.lastName" /></dt>
  <dd>${requester?.lastName}</dd>

  <dt><g:message code="homeFolder.individual.property.firstName" /></dt>
  <dd>${requester?.firstName}</dd>

  <dt><g:message code="homeFolder.individual.property.address" /></dt>
  <dd>
    <p>${requester?.adress?.additionalDeliveryInformation}</p>
    <p>${requester?.adress?.additionalGeographicalInformation}</p>
    <p>${requester?.adress?.streetNumber} ${requester?.adress?.streetName}</p>
    <p>${requester?.adress?.placeNameOrService}</p>
    <p>${requester?.adress?.postalCode} ${requester?.adress?.city}</p>
    <p>${requester?.adress?.countryName}</p>
  </dd>

  <dt><g:message code="homeFolder.adult.property.email" /></dt>
  <dd>${requester?.email}</dd>

  <dt><g:message code="homeFolder.adult.property.homePhone" /></dt>
  <dd>${requester?.homePhone}</dd>
