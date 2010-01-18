


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="hsr.step.registration.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="hsr.step.rules.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="hsr.step.contactphone.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="hsr.step.contact.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page4"><em><g:message code="hsr.step.additional.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="hsr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${request?.subjectFirstName} ${request?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.absenceStartDate.label" /> * : </dt><dd id="absenceStartDate" class="action-editField validate-date required-true i18n-hsr.property.absenceStartDate" ><span><g:formatDate formatName="format.date" date="${request?.absenceStartDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.absenceEndDate.label" /> * : </dt><dd id="absenceEndDate" class="action-editField validate-date required-true i18n-hsr.property.absenceEndDate" ><span><g:formatDate formatName="format.date" date="${request?.absenceEndDate}"/></span></dd>
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
          <span><g:message code="hsr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.rulesAndRegulationsAcceptance.label" /> * : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance required-true i18n-hsr.property.rulesAndRegulationsAcceptance" ><span class="value-${request?.rulesAndRegulationsAcceptance}"><g:message code="message.${request?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="hsr.step.contactphone.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.alertPhone.label" /> * : </dt><dd id="alertPhone" class="action-editField validate-phone required-true i18n-hsr.property.alertPhone maxLength-10" ><span>${request?.alertPhone}</span></dd>
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
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="hsr.step.contact.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.otherContactLastName.label" /> * : </dt><dd id="otherContactLastName" class="action-editField validate-lastName required-true i18n-hsr.property.otherContactLastName maxLength-38" ><span>${request?.otherContactLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.otherContactFirstName.label" /> * : </dt><dd id="otherContactFirstName" class="action-editField validate-firstName required-true i18n-hsr.property.otherContactFirstName maxLength-38" ><span>${request?.otherContactFirstName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.otherContactAddress.label" /> * : </dt><dd id="otherContactAddress" class="action-editField validate-address required-true i18n-hsr.property.otherContactAddress" ><div><p class="additionalDeliveryInformation">${request?.otherContactAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.otherContactAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.otherContactAddress?.streetNumber}</span> <span class="streetName">${request?.otherContactAddress?.streetName}</span><p class="placeNameOrService">${request?.otherContactAddress?.placeNameOrService}</p><span class="postalCode">${request?.otherContactAddress?.postalCode}</span> <span class="city">${request?.otherContactAddress?.city}</span><p class="countryName">${request?.otherContactAddress?.countryName}</p></div></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.otherContactPhone.label" /> * : </dt><dd id="otherContactPhone" class="action-editField validate-phone required-true i18n-hsr.property.otherContactPhone maxLength-10" ><span>${request?.otherContactPhone}</span></dd>
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
      <div id="page4">
        <h2><g:message code="property.form" />
          <span><g:message code="hsr.step.additional.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.alarm.label" /> * : </dt><dd id="alarm" class="action-editField validate-boolean required-true i18n-hsr.property.alarm" ><span class="value-${request?.alarm}"><g:message code="message.${request?.alarm ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.light.label" /> * : </dt><dd id="light" class="action-editField validate-boolean required-true i18n-hsr.property.light" ><span class="value-${request?.light}"><g:message code="message.${request?.light ? 'yes' : 'no'}" /></span></dd>
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
