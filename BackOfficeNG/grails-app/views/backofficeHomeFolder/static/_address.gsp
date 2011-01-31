<%
 def object = adult != null ? adult : homeFolder
%>
<dt>${message(code:'homeFolder.individual.property.address')}</dt>
<dd>
  <p>${object?.address?.additionalDeliveryInformation}</p>
  <p>${object?.address?.additionalGeographicalInformation}</p>
  <p>${object?.address?.streetNumber} ${object?.address?.streetName}</p>
  <p>${object?.address?.placeNameOrService}</p>
  <p>${object?.address?.postalCode} ${object?.address?.city}</p>
  <p>${object?.address?.countryName}</p>
</dd>
