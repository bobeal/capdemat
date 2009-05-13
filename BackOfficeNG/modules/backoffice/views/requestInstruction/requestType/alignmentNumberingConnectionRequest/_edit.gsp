

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="ancr.step.requester.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="ancr.step.cadastre.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="ancr.step.requester.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <g:render template="/backofficeRequestInstruction/requestType/requester" model="['requester':requester]" />
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-isSameAddress-trigger"><g:message code="ancr.property.isAccountAddress.label" /> * : </dt><dd id="isAccountAddress" class="action-editField validate-boolean required-true i18n-ancr.property.isAccountAddress" ><span class="value-${request?.isAccountAddress}"><g:message code="message.${request?.isAccountAddress ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSameAddress-unfilled"><g:message code="ancr.property.otherAddress.label" /> * : </dt><dd id="otherAddress" class="action-editField validate-address required-true i18n-ancr.property.otherAddress" ><div><p class="additionalDeliveryInformation">${request?.otherAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.otherAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.otherAddress?.streetNumber}</span> <span class="streetName">${request?.otherAddress?.streetName}</span><p class="placeNameOrService">${request?.otherAddress?.placeNameOrService}</p><span class="postalCode">${request?.otherAddress?.postalCode}</span> <span class="city">${request?.otherAddress?.city}</span><p class="countryName">${request?.otherAddress?.countryName}</p></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="ancr.step.cadastre.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isOwner-trigger"><g:message code="ancr.property.requesterQuality.label" /> * : </dt><dd id="requesterQuality" class="action-editField validate-capdematEnum required-true i18n-ancr.property.requesterQuality javatype-fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType" ><g:capdematEnumToField var="${request?.requesterQuality}" i18nKeyPrefix="ancr.property.requesterQuality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerLastName.label" /> * : </dt><dd id="ownerLastName" class="action-editField validate-lastName required-true i18n-ancr.property.ownerLastName maxLength-38" ><span>${request?.ownerLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerFirstNames.label" /> * : </dt><dd id="ownerFirstNames" class="action-editField validate-string required-true i18n-ancr.property.ownerFirstNames" ><span>${request?.ownerFirstNames}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isOwner-unfilled"><g:message code="ancr.property.ownerAddress.label" /> * : </dt><dd id="ownerAddress" class="action-editField validate-address required-true i18n-ancr.property.ownerAddress" ><div><p class="additionalDeliveryInformation">${request?.ownerAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.ownerAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.ownerAddress?.streetNumber}</span> <span class="streetName">${request?.ownerAddress?.streetName}</span><p class="placeNameOrService">${request?.ownerAddress?.placeNameOrService}</p><span class="postalCode">${request?.ownerAddress?.postalCode}</span> <span class="city">${request?.ownerAddress?.city}</span><p class="countryName">${request?.ownerAddress?.countryName}</p></div></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ancr.property.isAlignment.label" /> * : </dt><dd id="isAlignment" class="action-editField validate-boolean required-true i18n-ancr.property.isAlignment" ><span class="value-${request?.isAlignment}"><g:message code="message.${request?.isAlignment ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ancr.property.isNumbering.label" /> * : </dt><dd id="isNumbering" class="action-editField validate-boolean required-true i18n-ancr.property.isNumbering" ><span class="value-${request?.isNumbering}"><g:message code="message.${request?.isNumbering ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ancr.property.isConnection.label" /> * : </dt><dd id="isConnection" class="action-editField validate-boolean required-true i18n-ancr.property.isConnection" ><span class="value-${request?.isConnection}"><g:message code="message.${request?.isConnection ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="ancr.property.section.label" /> * : </dt><dd id="section" class="action-editField validate-string required-true i18n-ancr.property.section" ><span>${request?.section}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ancr.property.number.label" /> * : </dt><dd id="number" class="action-editField validate-positiveInteger required-true i18n-ancr.property.number" ><span>${request?.number}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="ancr.property.locality.label" />  : </dt><dd id="locality" class="action-editField validate-string i18n-ancr.property.locality" ><span>${request?.locality}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="ancr.property.transportationRoute.label" />  : </dt><dd id="transportationRoute" class="action-editField validate-string i18n-ancr.property.transportationRoute" ><span>${request?.transportationRoute}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ancr.property.moreThanTwoYears.label" /> * : </dt><dd id="moreThanTwoYears" class="action-editField validate-boolean required-true i18n-ancr.property.moreThanTwoYears" ><span class="value-${request?.moreThanTwoYears}"><g:message code="message.${request?.moreThanTwoYears ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="ancr.property.area.label" />  : </dt><dd id="area" class="action-editField validate-positiveInteger i18n-ancr.property.area" ><span>${request?.area}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
