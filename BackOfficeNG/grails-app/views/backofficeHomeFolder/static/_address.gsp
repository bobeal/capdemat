<dt>${message(code:'homeFolder.individual.property.address')}</dt>
<dd>
  <p>${user?.address?.additionalDeliveryInformation}</p>
  <p>${user?.address?.additionalGeographicalInformation}</p>
  <p>${user?.address?.streetNumber} ${user?.address?.streetName}</p>
  <p>${user?.address?.placeNameOrService}</p>
  <p>${user?.address?.postalCode} ${user?.address?.city}</p>
  <p>${user?.address?.countryName}</p>
</dd>
