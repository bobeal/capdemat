

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="bwcr.step.waste.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="bwcr.step.waste.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="bwcr.property.bulkyWasteType.label" /> * : </dt><dd id="bulkyWasteType" class="action-editField validate-localReferentialData required-true i18n-bwcr.property.bulkyWasteType data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'bulkyWasteType', 'lrEntries': lrTypes.bulkyWasteType?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.bulkyWasteType?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="bwcr.property.otherWaste.label" />  : </dt><dd id="otherWaste" class="action-editField validate-string i18n-bwcr.property.otherWaste" ><span>${request?.otherWaste}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="bwcr.property.collectionAddress.label" />  : </dt><dd id="collectionAddress" class="action-editField validate-address i18n-bwcr.property.collectionAddress" ><div><p class="additionalDeliveryInformation">${request?.collectionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.collectionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.collectionAddress?.streetNumber}</span> <span class="streetName">${request?.collectionAddress?.streetName}</span><p class="placeNameOrService">${request?.collectionAddress?.placeNameOrService}</p><span class="postalCode">${request?.collectionAddress?.postalCode}</span> <span class="city">${request?.collectionAddress?.city}</span><p class="countryName">${request?.collectionAddress?.countryName}</p></div></dd>
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
      
    
    
  </div>
  
</div>
