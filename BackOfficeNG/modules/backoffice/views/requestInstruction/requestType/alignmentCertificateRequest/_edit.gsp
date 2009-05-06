

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="acr.step.requester.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="acr.step.cadastre.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="acr.step.requester.label" /></span>
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
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="acr.step.cadastre.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isTenant-trigger"><g:message code="acr.property.requesterQuality.label" /> * : </dt><dd id="requesterQuality" class="action-editField validate-capdematEnum required-true i18n-acr.property.requesterQuality javatype-fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType" ><g:capdematEnumToField var="${request?.requesterQuality}" i18nKeyPrefix="acr.property.requesterQuality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled"><g:message code="acr.property.ownerLastName.label" /> * : </dt><dd id="ownerLastName" class="action-editField validate-lastName required-true i18n-acr.property.ownerLastName maxLength-38" ><span>${request?.ownerLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled"><g:message code="acr.property.ownerFirstNames.label" /> * : </dt><dd id="ownerFirstNames" class="action-editField validate-string required-true i18n-acr.property.ownerFirstNames" ><span>${request?.ownerFirstNames}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled"><g:message code="acr.property.ownerAddress.label" /> * : </dt><dd id="ownerAddress" class="action-editField validate-address required-true i18n-acr.property.ownerAddress" ><div><p class="additionalDeliveryInformation">${request?.ownerAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.ownerAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.ownerAddress?.streetNumber}</span> <span class="streetName">${request?.ownerAddress?.streetName}</span><p class="placeNameOrService">${request?.ownerAddress?.placeNameOrService}</p><span class="postalCode">${request?.ownerAddress?.postalCode}</span> <span class="city">${request?.ownerAddress?.city}</span><p class="countryName">${request?.ownerAddress?.countryName}</p></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="acr.property.section.label" /> * : </dt><dd id="section" class="action-editField validate-string required-true i18n-acr.property.section" ><span>${request?.section}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="acr.property.number.label" /> * : </dt><dd id="number" class="action-editField validate-positiveInteger required-true i18n-acr.property.number" ><span>${request?.number}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="acr.property.locality.label" />  : </dt><dd id="locality" class="action-editField validate-string i18n-acr.property.locality" ><span>${request?.locality}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="acr.property.transportationRoute.label" />  : </dt><dd id="transportationRoute" class="action-editField validate-string i18n-acr.property.transportationRoute" ><span>${request?.transportationRoute}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
