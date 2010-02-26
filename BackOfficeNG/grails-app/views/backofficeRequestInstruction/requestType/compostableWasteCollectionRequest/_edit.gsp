


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="cwcr.step.waste.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="cwcr.step.waste.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="cwcr.property.compostableWasteType.label" /> * : </dt><dd id="compostableWasteType" class="action-editField validate-localReferentialData required-true i18n-cwcr.property.compostableWasteType data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'compostableWasteType', 'lrEntries': lrTypes.compostableWasteType?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.compostableWasteType?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="cwcr.property.otherWaste.label" />  : </dt><dd id="otherWaste" class="action-editField validate-string i18n-cwcr.property.otherWaste" ><span>${rqt?.otherWaste}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="cwcr.property.collectionAddress.label" />  : </dt><dd id="collectionAddress" class="action-editField validate-address i18n-cwcr.property.collectionAddress" ><div><p class="additionalDeliveryInformation">${rqt?.collectionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.collectionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.collectionAddress?.streetNumber}</span> <span class="streetName">${rqt?.collectionAddress?.streetName}</span><p class="placeNameOrService">${rqt?.collectionAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.collectionAddress?.postalCode}</span> <span class="city">${rqt?.collectionAddress?.city}</span><p class="countryName">${rqt?.collectionAddress?.countryName}</p></div></dd>
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
