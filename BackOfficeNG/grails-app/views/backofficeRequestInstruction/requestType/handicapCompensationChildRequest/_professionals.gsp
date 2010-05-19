

  <g:set var="listSize" value="${rqt.professionals.size()}" />
  <h3>
    <a class="addListItem" id="add_professionals[${listSize}]"></a>
    <span><g:message code="hccr.property.professionals.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.professionals.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_professionals[${listSize - 1 - index}]"></a>
  </div>
  <dl class="condition-isProfessionals-filled">
    
      <dt class="required"><g:message code="hccr.property.professionalLastName.label" /> * : </dt>
      <dd id="professionals[${listSize - 1 - index}].professionalLastName" class="action-editField validate-lastName required-true i18n-hccr.property.professionalLastName maxLength-38" >
        <span>${it?.professionalLastName}</span>
      </dd>
    
      <dt class="required"><g:message code="hccr.property.professionalFirstName.label" /> * : </dt>
      <dd id="professionals[${listSize - 1 - index}].professionalFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.professionalFirstName maxLength-38" >
        <span>${it?.professionalFirstName}</span>
      </dd>
    
      <dt class="required"><g:message code="hccr.property.professionalAddress.label" /> * : </dt>
      <dd id="professionals[${listSize - 1 - index}].professionalAddress" class="action-editField validate-address required-true i18n-hccr.property.professionalAddress" >
        <div><p class="additionalDeliveryInformation">${it?.professionalAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${it?.professionalAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${it?.professionalAddress?.streetNumber}</span> <span class="streetName">${it?.professionalAddress?.streetName}</span><g:if test="${!!it?.professionalAddress?.streetMatriculation}"><p class="streetMatriculation">Matricule: ${it?.professionalAddress?.streetMatriculation}</p></g:if><p class="placeNameOrService">${it?.professionalAddress?.placeNameOrService}</p><span class="postalCode">${it?.professionalAddress?.postalCode}</span> <span class="city">${it?.professionalAddress?.city}</span><p class="countryName">${it?.professionalAddress?.countryName}</p><g:if test="${!!it?.professionalAddress?.cityInseeCode}"><p class="cityInseeCode">INSEE: ${it?.professionalAddress?.cityInseeCode}</p></g:if></div>
      </dd>
    
  </dl>
  </g:each>
