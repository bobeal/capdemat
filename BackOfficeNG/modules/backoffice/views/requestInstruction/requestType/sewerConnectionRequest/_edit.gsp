

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="scr.step.requester.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="scr.step.cadastre.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="scr.step.requester.label" /></span>
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
          <span><g:message code="scr.step.cadastre.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isTenant-trigger"><g:message code="scr.property.requesterQuality.label" /> * : </dt><dd id="requesterQuality" class="action-editField validate-capdematEnum required-true i18n-scr.property.requesterQuality javatype-fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType" ><g:capdematEnumToField var="${request?.requesterQuality}" i18nKeyPrefix="scr.property.requesterQuality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled"><g:message code="scr.property.ownerLastName.label" /> * : </dt><dd id="ownerLastName" class="action-editField validate-lastName required-true i18n-scr.property.ownerLastName maxLength-38" ><span>${request?.ownerLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled"><g:message code="scr.property.ownerFirstNames.label" /> * : </dt><dd id="ownerFirstNames" class="action-editField validate-string required-true i18n-scr.property.ownerFirstNames" ><span>${request?.ownerFirstNames}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled"><g:message code="scr.property.ownerAddress.label" /> * : </dt><dd id="ownerAddress" class="action-editField validate-address required-true i18n-scr.property.ownerAddress" ><div><p class="additionalDeliveryInformation">${request?.ownerAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.ownerAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.ownerAddress?.streetNumber}</span> <span class="streetName">${request?.ownerAddress?.streetName}</span><p class="placeNameOrService">${request?.ownerAddress?.placeNameOrService}</p><span class="postalCode">${request?.ownerAddress?.postalCode}</span> <span class="city">${request?.ownerAddress?.city}</span><p class="countryName">${request?.ownerAddress?.countryName}</p></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="scr.property.section.label" /> * : </dt><dd id="section" class="action-editField validate-string required-true i18n-scr.property.section" ><span>${request?.section}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scr.property.number.label" /> * : </dt><dd id="number" class="action-editField validate-positiveInteger required-true i18n-scr.property.number" ><span>${request?.number}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="scr.property.locality.label" />  : </dt><dd id="locality" class="action-editField validate-string i18n-scr.property.locality" ><span>${request?.locality}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="scr.property.transportationRoute.label" />  : </dt><dd id="transportationRoute" class="action-editField validate-string i18n-scr.property.transportationRoute" ><span>${request?.transportationRoute}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scr.property.moreThanTwoYears.label" /> * : </dt><dd id="moreThanTwoYears" class="action-editField validate-boolean required-true i18n-scr.property.moreThanTwoYears" ><span class="value-${request?.moreThanTwoYears}"><g:message code="message.${request?.moreThanTwoYears ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
