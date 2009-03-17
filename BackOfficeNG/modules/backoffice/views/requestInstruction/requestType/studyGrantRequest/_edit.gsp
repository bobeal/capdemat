

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="sgr.step.subject.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="sgr.step.taxHousehold.label" /></em></a>
    </li>
  
    <li>
      <a href="#page2"><em><g:message code="sgr.step.otherHelps.label" /></em></a>
    </li>
  
    <li>
      <a href="#page3"><em><g:message code="sgr.step.currentStudies.label" /></em></a>
    </li>
  
    <li>
      <a href="#page4"><em><g:message code="sgr.step.futureSchool.label" /></em></a>
    </li>
  
    <li>
      <a href="#page5"><em><g:message code="sgr.step.calculationElements.label" /></em></a>
    </li>
  
    <li>
      <a href="#page6"><em><g:message code="sgr.step.bankReference.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.subject.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
                
                <h3><g:message code="sgr.property.subjetInformations.label" /></h3>
                <dl class="required">
                  
                    <dt class="required"><g:message code="sgr.property.subjectPhone.label" /> * : </dt>
                    <dd id="subjectPhone" class="action-editField validate-phone required-true i18n-sgr.property.subjectPhone maxLength-10" >
                      <span>${request?.subjectPhone}</span>
                    </dd>
                  
                    <dt class="required"><g:message code="sgr.property.subjectMobilePhone.label" /> * : </dt>
                    <dd id="subjectMobilePhone" class="action-editField validate-phone required-true i18n-sgr.property.subjectMobilePhone maxLength-10" >
                      <span>${request?.subjectMobilePhone}</span>
                    </dd>
                  
                    <dt class="required"><g:message code="sgr.property.subjectEmail.label" /> * : </dt>
                    <dd id="subjectEmail" class="action-editField validate-email required-true i18n-sgr.property.subjectEmail" >
                      <span>${request?.subjectEmail}</span>
                    </dd>
                  
                    <dt class="required"><g:message code="sgr.property.subjectBirthDate.label" /> * : </dt>
                    <dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-sgr.property.subjectBirthDate" >
                      <span><g:formatDate formatName="format.date" date="${request?.subjectBirthDate}"/></span>
                    </dd>
                  
                    <dt class="required"><g:message code="sgr.property.subjectBirthPlace.label" /> * : </dt>
                    <dd id="subjectBirthPlace" class="action-editField validate-string required-true i18n-sgr.property.subjectBirthPlace" >
                      <span>${request?.subjectBirthPlace}</span>
                    </dd>
                  
                    <dt class="required condition-livesWithParents-trigger"><g:message code="sgr.property.hasParentsAddress.label" /> * : </dt>
                    <dd id="hasParentsAddress" class="action-editField validate-boolean required-true i18n-sgr.property.hasParentsAddress" >
                      <span class="value-${request?.hasParentsAddress}"><g:message code="message.${request?.hasParentsAddress ? 'yes' : 'no'}" /></span>
                    </dd>
                  
                    <dt class="required condition-livesWithParents-unfilled"><g:message code="sgr.property.subjectAddress.label" /> * : </dt>
                    <dd id="subjectAddress" class="action-editField validate-address required-true i18n-sgr.property.subjectAddress" >
                      <div><p class="additionalDeliveryInformation">${request?.subjectAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.subjectAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.subjectAddress?.streetNumber}</span> <span class="streetName">${request?.subjectAddress?.streetName}</span><p class="placeNameOrService">${request?.subjectAddress?.placeNameOrService}</p><span class="postalCode">${request?.subjectAddress?.postalCode}</span> <span class="city">${request?.subjectAddress?.city}</span><p class="countryName">${request?.subjectAddress?.countryName}</p></div>
                    </dd>
                  
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
          <span><g:message code="sgr.step.taxHousehold.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.otherHelps.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
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
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.currentStudies.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
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
      <div id="page4">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.futureSchool.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
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
      <div id="page5">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.calculationElements.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
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
      <div id="page6">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.bankReference.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
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
