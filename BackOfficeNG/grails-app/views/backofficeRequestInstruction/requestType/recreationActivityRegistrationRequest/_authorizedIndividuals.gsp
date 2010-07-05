

  <g:set var="listSize" value="${rqt.authorizedIndividuals.size()}" />
  <h3>
    <a class="addListItem" id="add_authorizedIndividuals[${listSize}]"></a>
    <span><g:message code="rarr.property.authorizedIndividuals.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.authorizedIndividuals.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_authorizedIndividuals[${listSize - 1 - index}]"></a>
  </div>
  <dl class="">
    
      <dt class="required"><g:message code="rarr.property.lastName.label" /> * : </dt>
      <dd id="authorizedIndividuals[${listSize - 1 - index}].lastName" class="action-editField validate-lastName required-true i18n-rarr.property.lastName maxLength-38" >
        <span>${it?.lastName}</span>
      </dd>
    
      <dt class="required"><g:message code="rarr.property.firstName.label" /> * : </dt>
      <dd id="authorizedIndividuals[${listSize - 1 - index}].firstName" class="action-editField validate-firstName required-true i18n-rarr.property.firstName maxLength-38" >
        <span>${it?.firstName}</span>
      </dd>
    
      <dt class="required"><g:message code="rarr.property.address.label" /> * : </dt>
      <dd id="authorizedIndividuals[${listSize - 1 - index}].address" class="action-editField validate-address required-true i18n-rarr.property.address" >
        <div><p class="additionalDeliveryInformation">${it?.address?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${it?.address?.additionalGeographicalInformation}</p><span class="streetNumber">${it?.address?.streetNumber}</span> <span class="streetName">${it?.address?.streetName}</span><g:if test="${!!it?.address?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${it?.address?.streetMatriculation}</span></g:if><g:if test="${!!it?.address?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${it?.address?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${it?.address?.placeNameOrService}</p><span class="postalCode">${it?.address?.postalCode}</span> <span class="city">${it?.address?.city}</span><p class="countryName">${it?.address?.countryName}</p><g:if test="${!!it?.address?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${it?.address?.cityInseeCode}</span></g:if></div>
      </dd>
    
      <dt class=""><g:message code="rarr.property.homePhone.label" />  : </dt>
      <dd id="authorizedIndividuals[${listSize - 1 - index}].homePhone" class="action-editField validate-phone i18n-rarr.property.homePhone maxLength-10" >
        <span>${it?.homePhone}</span>
      </dd>
    
      <dt class=""><g:message code="rarr.property.officePhone.label" />  : </dt>
      <dd id="authorizedIndividuals[${listSize - 1 - index}].officePhone" class="action-editField validate-phone i18n-rarr.property.officePhone maxLength-10" >
        <span>${it?.officePhone}</span>
      </dd>
    
  </dl>
  </g:each>
