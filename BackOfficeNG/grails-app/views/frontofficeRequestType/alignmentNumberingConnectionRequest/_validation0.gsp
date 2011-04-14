


  
    <h3><g:message code="ancr.step.address.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ancr.property.isAccountAddress.label" /></dt>
          <dd><g:message code="message.${rqt.isAccountAddress ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.otherAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.otherAddress}">
              <p>${rqt.otherAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.otherAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.otherAddress?.streetNumber} ${rqt.otherAddress?.streetName}</p>
              <p>${rqt.otherAddress?.placeNameOrService}</p>
              <p>${rqt.otherAddress?.postalCode} ${rqt.otherAddress?.city}</p>
              <p>${rqt.otherAddress?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
  

  
    <h3><g:message code="ancr.step.cadastre.label" /></h3>
    
      
      <dl>
        <dt><g:message code="ancr.property.requesterQuality.label" /></dt>
          <dd>
            <g:if test="${rqt.requesterQuality}">
              <g:capdematEnumToField var="${rqt.requesterQuality}" i18nKeyPrefix="ancr.property.requesterQuality" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.ownerLastName.label" /></dt><dd>${rqt.ownerLastName?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.ownerFirstNames.label" /></dt><dd>${rqt.ownerFirstNames?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.ownerAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.ownerAddress}">
              <p>${rqt.ownerAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.ownerAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.ownerAddress?.streetNumber} ${rqt.ownerAddress?.streetName}</p>
              <p>${rqt.ownerAddress?.placeNameOrService}</p>
              <p>${rqt.ownerAddress?.postalCode} ${rqt.ownerAddress?.city}</p>
              <p>${rqt.ownerAddress?.countryName}</p>
          </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.section.label" /></dt><dd>${rqt.section?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.number.label" /></dt><dd>${rqt.number?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.locality.label" /></dt><dd>${rqt.locality?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.transportationRoute.label" /></dt><dd>${rqt.transportationRoute?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.moreThanTwoYears.label" /></dt>
          <dd><g:message code="message.${rqt.moreThanTwoYears ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.area.label" /></dt><dd>${rqt.area?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.isAlignment.label" /></dt>
          <dd><g:message code="message.${rqt.isAlignment ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.isNumbering.label" /></dt>
          <dd><g:message code="message.${rqt.isNumbering ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="ancr.property.isConnection.label" /></dt>
          <dd><g:message code="message.${rqt.isConnection ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  


