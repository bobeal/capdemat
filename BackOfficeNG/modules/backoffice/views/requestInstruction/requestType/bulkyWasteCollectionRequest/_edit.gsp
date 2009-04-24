

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="bwc.step.waste.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="bwc.step.waste.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="bwc.property.bulkyWasteType.label" /> * : </dt><dd id="bulkyWasteType" class="action-editField validate-localReferentialData required-true i18n-bwc.property.bulkyWasteType" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'bulkyWasteType', 'lrEntries': lrTypes.bulkyWasteType?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.bulkyWasteType?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="bwc.property.otherWaste.label" />  : </dt><dd id="otherWaste" class="action-editField validate-string i18n-bwc.property.otherWaste" ><span>${request?.otherWaste}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="bwc.property.collectionAddress.label" />  : </dt><dd id="collectionAddress" class="action-editField validate-string i18n-bwc.property.collectionAddress" ><span>${request?.collectionAddress}</span></dd>
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
