

  <g:set var="listSize" value="${rqt.personnesAutorisees.size()}" />
  <h3>
    <a class="addListItem" id="add_personnesAutorisees[${listSize}]"></a>
    <span><g:message code="ladrr.property.personnesAutorisees.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.personnesAutorisees.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_personnesAutorisees[${listSize - 1 - index}]"></a>
  </div>
  <dl class="">
    
      <dt class="required"><g:message code="ladrr.property.nom.label" /> * : </dt>
      <dd id="personnesAutorisees[${listSize - 1 - index}].nom" class="action-editField validate-lastName required-true i18n-ladrr.property.nom maxLength-38" >
        <span>${it?.nom}</span>
      </dd>
    
      <dt class="required"><g:message code="ladrr.property.prenom.label" /> * : </dt>
      <dd id="personnesAutorisees[${listSize - 1 - index}].prenom" class="action-editField validate-firstName required-true i18n-ladrr.property.prenom maxLength-38" >
        <span>${it?.prenom}</span>
      </dd>
    
      <dt class="required"><g:message code="ladrr.property.adresse.label" /> * : </dt>
      <dd id="personnesAutorisees[${listSize - 1 - index}].adresse" class="action-editField validate-address required-true i18n-ladrr.property.adresse" >
        <div><p class="additionalDeliveryInformation">${it?.adresse?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${it?.adresse?.additionalGeographicalInformation}</p><span class="streetNumber">${it?.adresse?.streetNumber}</span> <span class="streetName">${it?.adresse?.streetName}</span><p class="placeNameOrService">${it?.adresse?.placeNameOrService}</p><span class="postalCode">${it?.adresse?.postalCode}</span> <span class="city">${it?.adresse?.city}</span><p class="countryName">${it?.adresse?.countryName}</p></div>
      </dd>
    
      <dt class=""><g:message code="ladrr.property.telephoneDomicile.label" />  : </dt>
      <dd id="personnesAutorisees[${listSize - 1 - index}].telephoneDomicile" class="action-editField validate-phone i18n-ladrr.property.telephoneDomicile maxLength-10" >
        <span>${it?.telephoneDomicile}</span>
      </dd>
    
      <dt class=""><g:message code="ladrr.property.telephoneBureau.label" />  : </dt>
      <dd id="personnesAutorisees[${listSize - 1 - index}].telephoneBureau" class="action-editField validate-phone i18n-ladrr.property.telephoneBureau maxLength-10" >
        <span>${it?.telephoneBureau}</span>
      </dd>
    
      <dt class=""><g:message code="ladrr.property.email.label" />  : </dt>
      <dd id="personnesAutorisees[${listSize - 1 - index}].email" class="action-editField validate-email i18n-ladrr.property.email" >
        <span>${it?.email}</span>
      </dd>
    
  </dl>
  </g:each>
