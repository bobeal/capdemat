<dt>${message(code:'homeFolder.individual.property.address')}</dt>
<dd>
  <p>${actor?.address?.additionalDeliveryInformation}</p>
  <p>${actor?.address?.additionalGeographicalInformation}</p>
  <p>${actor?.address?.streetNumber} ${actor?.address?.streetName}</p>
  <p>${actor?.address?.placeNameOrService}</p>
  <p>${actor?.address?.postalCode} ${actor?.address?.city}</p>
  <p>${actor?.address?.countryName}</p>
</dd>
