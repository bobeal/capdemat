

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="tir.step.subject.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="tir.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-otherIntervention-trigger"><g:message code="tir.property.interventionType.label" /> * : </dt><dd id="interventionType" class="action-editField validate-localReferentialData required-true i18n-tir.property.interventionType data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'interventionType', 'lrEntries': lrTypes.interventionType?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.interventionType?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-otherIntervention-filled"><g:message code="tir.property.otherInterventionLabel.label" /> * : </dt><dd id="otherInterventionLabel" class="action-editField validate-string required-true i18n-tir.property.otherInterventionLabel" ><span>${request?.otherInterventionLabel}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="tir.property.interventionPlace.label" /> * : </dt><dd id="interventionPlace" class="action-editField validate-address required-true i18n-tir.property.interventionPlace" ><div><p class="additionalDeliveryInformation">${request?.interventionPlace?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.interventionPlace?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.interventionPlace?.streetNumber}</span> <span class="streetName">${request?.interventionPlace?.streetName}</span><p class="placeNameOrService">${request?.interventionPlace?.placeNameOrService}</p><span class="postalCode">${request?.interventionPlace?.postalCode}</span> <span class="city">${request?.interventionPlace?.city}</span><p class="countryName">${request?.interventionPlace?.countryName}</p></div></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="tir.property.interventionDescription.label" /> * : </dt><dd id="interventionDescription" class="action-editField validate-textarea required-true i18n-tir.property.interventionDescription rows-3" ><span>${request?.interventionDescription}</span></dd>
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
