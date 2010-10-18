


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
              <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.absenceStartDate.label" /> * : </dt><dd id="absenceStartDate" class="action-editField validate-date required-true i18n-hsr.property.absenceStartDate" ><span><g:formatDate formatName="format.date" date="${rqt?.absenceStartDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.absenceEndDate.label" /> * : </dt><dd id="absenceEndDate" class="action-editField validate-date required-true i18n-hsr.property.absenceEndDate" ><span><g:formatDate formatName="format.date" date="${rqt?.absenceEndDate}"/></span></dd>
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
                <dt class="required"><g:message code="hsr.property.rulesAndRegulationsAcceptance.label" /> * : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance required-true i18n-hsr.property.rulesAndRegulationsAcceptance" ><span class="value-${rqt?.rulesAndRegulationsAcceptance}"><g:message code="message.${rqt?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
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
                <dt class="required"><g:message code="hsr.property.alertPhone.label" /> * : </dt><dd id="alertPhone" class="action-editField validate-phone required-true i18n-hsr.property.alertPhone maxLength-10" ><span>${rqt?.alertPhone}</span></dd>
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
                <dt class="required condition-isOtherContact-trigger"><g:message code="hsr.property.otherContact.label" /> * : </dt><dd id="otherContact" class="action-editField validate-boolean required-true i18n-hsr.property.otherContact" ><span class="value-${rqt?.otherContact}"><g:message code="message.${rqt?.otherContact ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hsr.property.otherContactInformations.label" /></h3>
              <dl class="required condition-isOtherContact-filled">
                
                  <dt class="required"><g:message code="hsr.property.otherContactLastName.label" /> * : </dt><dd id="otherContactLastName" class="action-editField validate-lastName required-true i18n-hsr.property.otherContactLastName maxLength-38" ><span>${rqt?.otherContactLastName}</span></dd>
                
                  <dt class="required"><g:message code="hsr.property.otherContactFirstName.label" /> * : </dt><dd id="otherContactFirstName" class="action-editField validate-firstName required-true i18n-hsr.property.otherContactFirstName maxLength-38" ><span>${rqt?.otherContactFirstName}</span></dd>
                
                  <dt class="required"><g:message code="hsr.property.otherContactAddress.label" /> * : </dt><dd id="otherContactAddress" class="action-editField validate-address required-true i18n-hsr.property.otherContactAddress" ><div><p class="additionalDeliveryInformation">${rqt?.otherContactAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.otherContactAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.otherContactAddress?.streetNumber}</span> <span class="streetName">${rqt?.otherContactAddress?.streetName}</span><g:if test="${!!rqt?.otherContactAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.otherContactAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.otherContactAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.otherContactAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.otherContactAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.otherContactAddress?.postalCode}</span> <span class="city">${rqt?.otherContactAddress?.city}</span><p class="countryName">${rqt?.otherContactAddress?.countryName}</p><g:if test="${!!rqt?.otherContactAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.otherContactAddress?.cityInseeCode}</span></g:if></div></dd>
                
                  <dt class="required"><g:message code="hsr.property.otherContactPhone.label" /> * : </dt><dd id="otherContactPhone" class="action-editField validate-phone required-true i18n-hsr.property.otherContactPhone maxLength-10" ><span>${rqt?.otherContactPhone}</span></dd>
                
              </dl>
              
            
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
                <dt class="required"><g:message code="hsr.property.alarm.label" /> * : </dt><dd id="alarm" class="action-editField validate-boolean required-true i18n-hsr.property.alarm" ><span class="value-${rqt?.alarm}"><g:message code="message.${rqt?.alarm ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="hsr.property.light.label" /> * : </dt><dd id="light" class="action-editField validate-boolean required-true i18n-hsr.property.light" ><span class="value-${rqt?.light}"><g:message code="message.${rqt?.light ? 'yes' : 'no'}" /></span></dd>
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
