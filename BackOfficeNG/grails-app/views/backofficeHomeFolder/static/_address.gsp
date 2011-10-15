<dt class="required">${message(code:'homeFolder.individual.property.address')}</dt>
<dd class="required">
  <p>${user?.address?.additionalDeliveryInformation}</p>
  <p>${user?.address?.additionalGeographicalInformation}</p>
  <p>${user?.address?.streetNumber} ${user?.address?.streetName}
    <g:if test="${user?.address?.streetRivoliCode != null}">
      (<g:message code="address.property.streetRivoliCode" /> : ${user?.address?.streetRivoliCode})
    </g:if>
    <g:elseif test="${user?.address?.streetMatriculation != null}">
      (<g:message code="address.property.streetMatriculation" /> : ${user?.address?.streetMatriculation})
    </g:elseif>
  </p>
  <p>${user?.address?.placeNameOrService}</p>
  <p>${user?.address?.postalCode} ${user?.address?.city}</p>
  <p>${user?.address?.countryName}</p>
</dd>
