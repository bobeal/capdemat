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
    <p>${requester?.address?.additionalDeliveryInformation}</p>
    <p>${requester?.address?.additionalGeographicalInformation}</p>
    <p>${requester?.address?.streetNumber} ${requester?.address?.streetName}</p>
    <p>${requester?.address?.placeNameOrService}</p>
    <p>${requester?.address?.postalCode} ${requester?.address?.city}</p>
    <p>${requester?.address?.countryName}</p>
  </dd>

  <dt><g:message code="homeFolder.adult.property.email" /></dt>
  <dd>${requester?.email}</dd>

  <dt><g:message code="homeFolder.adult.property.homePhone" /></dt>
  <dd>${requester?.homePhone}</dd>
