


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="scr.step.cadastre.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="scr.step.cadastre.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isTenant-trigger">${message(code:'scr.property.requesterQuality.label')}&nbsp;*&nbsp;:</dt><dd id="requesterQuality" class="action-editField validate-capdematEnum required-true i18n-scr.property.requesterQuality javatype-fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType" ><g:capdematEnumToField var="${rqt?.requesterQuality}" i18nKeyPrefix="scr.property.requesterQuality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled">${message(code:'scr.property.ownerLastName.label')}&nbsp;*&nbsp;:</dt><dd id="ownerLastName" class="action-editField validate-lastName required-true i18n-scr.property.ownerLastName maxLength-38" ><span>${rqt?.ownerLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled">${message(code:'scr.property.ownerFirstNames.label')}&nbsp;*&nbsp;:</dt><dd id="ownerFirstNames" class="action-editField validate-string required-true i18n-scr.property.ownerFirstNames" ><span>${rqt?.ownerFirstNames}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTenant-filled">${message(code:'scr.property.ownerAddress.label')}&nbsp;*&nbsp;:</dt><dd id="ownerAddress" class="action-editField validate-address required-true i18n-scr.property.ownerAddress" ><div><p class="additionalDeliveryInformation">${rqt?.ownerAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.ownerAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.ownerAddress?.streetNumber}</span> <span class="streetName">${rqt?.ownerAddress?.streetName}</span><g:if test="${!!rqt?.ownerAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.ownerAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.ownerAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.ownerAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.ownerAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.ownerAddress?.postalCode}</span> <span class="city">${rqt?.ownerAddress?.city}</span><p class="countryName">${rqt?.ownerAddress?.countryName}</p><g:if test="${!!rqt?.ownerAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.ownerAddress?.cityInseeCode}</span></g:if></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required">${message(code:'scr.property.section.label')}&nbsp;*&nbsp;:</dt><dd id="section" class="action-editField validate-string required-true i18n-scr.property.section" ><span>${rqt?.section}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'scr.property.number.label')}&nbsp;*&nbsp;:</dt><dd id="number" class="action-editField validate-positiveInteger required-true i18n-scr.property.number" ><span>${rqt?.number}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'scr.property.locality.label')}&nbsp;:</dt><dd id="locality" class="action-editField validate-string i18n-scr.property.locality" ><span>${rqt?.locality}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'scr.property.transportationRoute.label')}&nbsp;:</dt><dd id="transportationRoute" class="action-editField validate-string i18n-scr.property.transportationRoute" ><span>${rqt?.transportationRoute}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'scr.property.moreThanTwoYears.label')}&nbsp;*&nbsp;:</dt><dd id="moreThanTwoYears" class="action-editField validate-boolean required-true i18n-scr.property.moreThanTwoYears" ><span class="value-${rqt?.moreThanTwoYears}"><g:message code="${rqt?.moreThanTwoYears ? 'message.yes' : rqt?.moreThanTwoYears==null ? '' : 'message.no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
