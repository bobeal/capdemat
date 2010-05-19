

  <g:set var="listSize" value="${rqt.dhrRealAsset.size()}" />
  <h3>
    <a class="addListItem" id="add_dhrRealAsset[${listSize}]"></a>
    <span><g:message code="dhr.property.dhrRealAsset.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.dhrRealAsset.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_dhrRealAsset[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required">
    
      <dt class="required"><g:message code="dhr.property.dhrRealAssetAddress.label" /> * : </dt>
      <dd id="dhrRealAsset[${listSize - 1 - index}].dhrRealAssetAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrRealAssetAddress" >
        <div><p class="additionalDeliveryInformation">${it?.dhrRealAssetAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${it?.dhrRealAssetAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${it?.dhrRealAssetAddress?.streetNumber}</span> <span class="streetName">${it?.dhrRealAssetAddress?.streetName}</span><g:if test="${!!it?.dhrRealAssetAddress?.streetMatriculation}"><p class="streetMatriculation">Matricule: ${it?.dhrRealAssetAddress?.streetMatriculation}</p></g:if><p class="placeNameOrService">${it?.dhrRealAssetAddress?.placeNameOrService}</p><span class="postalCode">${it?.dhrRealAssetAddress?.postalCode}</span> <span class="city">${it?.dhrRealAssetAddress?.city}</span><p class="countryName">${it?.dhrRealAssetAddress?.countryName}</p><g:if test="${!!it?.dhrRealAssetAddress?.cityInseeCode}"><p class="cityInseeCode">INSEE: ${it?.dhrRealAssetAddress?.cityInseeCode}</p></g:if></div>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrRealAssetValue.label" /> * : </dt>
      <dd id="dhrRealAsset[${listSize - 1 - index}].dhrRealAssetValue" class="action-editField validate-positiveInteger required-true i18n-dhr.property.dhrRealAssetValue" >
        <span>${it?.dhrRealAssetValue}</span>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.realAssetNetFloorArea.label" /> * : </dt>
      <dd id="dhrRealAsset[${listSize - 1 - index}].realAssetNetFloorArea" class="action-editField validate-positiveInteger required-true i18n-dhr.property.realAssetNetFloorArea" >
        <span>${it?.realAssetNetFloorArea}</span>
      </dd>
    
  </dl>
  </g:each>
