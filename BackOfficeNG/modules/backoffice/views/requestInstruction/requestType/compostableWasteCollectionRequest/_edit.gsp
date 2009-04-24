

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="cwc.step.waste.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="cwc.step.waste.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="cwc.property.compostableWasteType.label" /> * : </dt><dd id="compostableWasteType" class="action-editField validate-localReferentialData required-true i18n-cwc.property.compostableWasteType" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'compostableWasteType', 'lrEntries': lrTypes.compostableWasteType?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.compostableWasteType?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="cwc.property.otherWaste.label" />  : </dt><dd id="otherWaste" class="action-editField validate-string i18n-cwc.property.otherWaste" ><span>${request?.otherWaste}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="cwc.property.collectionAddress.label" />  : </dt><dd id="collectionAddress" class="action-editField validate-string i18n-cwc.property.collectionAddress" ><span>${request?.collectionAddress}</span></dd>
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
