

  <g:set var="listSize" value="${rqt.dhrNotRealAsset.size()}" />
  <h3>
    <a class="addListItem" id="add_dhrNotRealAsset[${listSize}]"></a>
    <span><g:message code="dhr.property.dhrNotRealAsset.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.dhrNotRealAsset.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_dhrNotRealAsset[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required">
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetType.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetType" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrNotRealAssetType javatype-fr.cg95.cvq.business.request.social.DhrAssetTypeType" >
        <g:capdematEnumToField var="${it?.dhrNotRealAssetType}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" />
      </dd>
    
      <dt class="required condition-isRealEstate-trigger"><g:message code="dhr.property.dhrNotRealAssetKind.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetKind" class="action-editField validate-capdematEnum required-true i18n-dhr.property.dhrNotRealAssetKind javatype-fr.cg95.cvq.business.request.social.DhrAssetKindType" >
        <g:capdematEnumToField var="${it?.dhrNotRealAssetKind}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" />
      </dd>
    
      <dt class="required condition-isRealEstate-filled"><g:message code="dhr.property.dhrNotRealAssetAddress.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrNotRealAssetAddress" >
        <div><p class="additionalDeliveryInformation">${it?.dhrNotRealAssetAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${it?.dhrNotRealAssetAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${it?.dhrNotRealAssetAddress?.streetNumber}</span> <span class="streetName">${it?.dhrNotRealAssetAddress?.streetName}</span><g:if test="${!!it?.dhrNotRealAssetAddress?.streetMatriculation}"><p class="streetMatriculation">Matricule: ${it?.dhrNotRealAssetAddress?.streetMatriculation}</p></g:if><p class="placeNameOrService">${it?.dhrNotRealAssetAddress?.placeNameOrService}</p><span class="postalCode">${it?.dhrNotRealAssetAddress?.postalCode}</span> <span class="city">${it?.dhrNotRealAssetAddress?.city}</span><p class="countryName">${it?.dhrNotRealAssetAddress?.countryName}</p><g:if test="${!!it?.dhrNotRealAssetAddress?.cityInseeCode}"><p class="cityInseeCode">INSEE: ${it?.dhrNotRealAssetAddress?.cityInseeCode}</p></g:if></div>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetBeneficiaryName" class="action-editField validate-lastName required-true i18n-dhr.property.dhrNotRealAssetBeneficiaryName maxLength-38" >
        <span>${it?.dhrNotRealAssetBeneficiaryName}</span>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetBeneficiaryFirstName" class="action-editField validate-firstName required-true i18n-dhr.property.dhrNotRealAssetBeneficiaryFirstName maxLength-38" >
        <span>${it?.dhrNotRealAssetBeneficiaryFirstName}</span>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetBeneficiaryAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrNotRealAssetBeneficiaryAddress" >
        <div><p class="additionalDeliveryInformation">${it?.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${it?.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${it?.dhrNotRealAssetBeneficiaryAddress?.streetNumber}</span> <span class="streetName">${it?.dhrNotRealAssetBeneficiaryAddress?.streetName}</span><g:if test="${!!it?.dhrNotRealAssetBeneficiaryAddress?.streetMatriculation}"><p class="streetMatriculation">Matricule: ${it?.dhrNotRealAssetBeneficiaryAddress?.streetMatriculation}</p></g:if><p class="placeNameOrService">${it?.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}</p><span class="postalCode">${it?.dhrNotRealAssetBeneficiaryAddress?.postalCode}</span> <span class="city">${it?.dhrNotRealAssetBeneficiaryAddress?.city}</span><p class="countryName">${it?.dhrNotRealAssetBeneficiaryAddress?.countryName}</p><g:if test="${!!it?.dhrNotRealAssetBeneficiaryAddress?.cityInseeCode}"><p class="cityInseeCode">INSEE: ${it?.dhrNotRealAssetBeneficiaryAddress?.cityInseeCode}</p></g:if></div>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetValue.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetValue" class="action-editField validate-positiveInteger required-true i18n-dhr.property.dhrNotRealAssetValue" >
        <span>${it?.dhrNotRealAssetValue}</span>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetDate.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetDate" class="action-editField validate-date required-true i18n-dhr.property.dhrNotRealAssetDate" >
        <span><g:formatDate formatName="format.date" date="${it?.dhrNotRealAssetDate}"/></span>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetNotaryName" class="action-editField validate-lastName required-true i18n-dhr.property.dhrNotRealAssetNotaryName maxLength-38" >
        <span>${it?.dhrNotRealAssetNotaryName}</span>
      </dd>
    
      <dt class="required"><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /> * : </dt>
      <dd id="dhrNotRealAsset[${listSize - 1 - index}].dhrNotRealAssetNotaryAddress" class="action-editField validate-address required-true i18n-dhr.property.dhrNotRealAssetNotaryAddress" >
        <div><p class="additionalDeliveryInformation">${it?.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${it?.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${it?.dhrNotRealAssetNotaryAddress?.streetNumber}</span> <span class="streetName">${it?.dhrNotRealAssetNotaryAddress?.streetName}</span><g:if test="${!!it?.dhrNotRealAssetNotaryAddress?.streetMatriculation}"><p class="streetMatriculation">Matricule: ${it?.dhrNotRealAssetNotaryAddress?.streetMatriculation}</p></g:if><p class="placeNameOrService">${it?.dhrNotRealAssetNotaryAddress?.placeNameOrService}</p><span class="postalCode">${it?.dhrNotRealAssetNotaryAddress?.postalCode}</span> <span class="city">${it?.dhrNotRealAssetNotaryAddress?.city}</span><p class="countryName">${it?.dhrNotRealAssetNotaryAddress?.countryName}</p><g:if test="${!!it?.dhrNotRealAssetNotaryAddress?.cityInseeCode}"><p class="cityInseeCode">INSEE: ${it?.dhrNotRealAssetNotaryAddress?.cityInseeCode}</p></g:if></div>
      </dd>
    
  </dl>
  </g:each>
