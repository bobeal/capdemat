

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="errr.step.subject.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="errr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${request?.subjectFirstName} ${request?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="errr.property.subjectNationality.label" /> * : </dt><dd id="subjectNationality" class="action-editField validate-capdematEnum required-true i18n-errr.property.subjectNationality javatype-fr.cg95.cvq.business.users.NationalityType maxLength-32" ><g:capdematEnumToField var="${request?.subjectNationality}" i18nKeyPrefix="errr.property.subjectNationality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isDirect-trigger"><g:message code="errr.property.motive.label" /> * : </dt><dd id="motive" class="action-editField validate-capdematEnum required-true i18n-errr.property.motive javatype-fr.cg95.cvq.business.request.election.ElectoralMotiveType" ><g:capdematEnumToField var="${request?.motive}" i18nKeyPrefix="errr.property.motive" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isDirect-unfilled"><g:message code="errr.property.subjectOldCity.label" /> * : </dt><dd id="subjectOldCity" class="action-editField validate-city required-true i18n-errr.property.subjectOldCity maxLength-32" ><span>${request?.subjectOldCity}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isDirect-filled"><g:message code="errr.property.subjectAddressOutsideCity.label" /> * : </dt><dd id="subjectAddressOutsideCity" class="action-editField validate-address required-true i18n-errr.property.subjectAddressOutsideCity" ><div><p class="additionalDeliveryInformation">${request?.subjectAddressOutsideCity?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.subjectAddressOutsideCity?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.subjectAddressOutsideCity?.streetNumber}</span> <span class="streetName">${request?.subjectAddressOutsideCity?.streetName}</span><p class="placeNameOrService">${request?.subjectAddressOutsideCity?.placeNameOrService}</p><span class="postalCode">${request?.subjectAddressOutsideCity?.postalCode}</span> <span class="city">${request?.subjectAddressOutsideCity?.city}</span><p class="countryName">${request?.subjectAddressOutsideCity?.countryName}</p></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="errr.property.electoralNumber.label" />  : </dt><dd id="electoralNumber" class="action-editField validate-long i18n-errr.property.electoralNumber" ><span>${request?.electoralNumber}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="errr.property.pollingStation.label" />  : </dt><dd id="pollingStation" class="action-editField validate-long i18n-errr.property.pollingStation" ><span>${request?.pollingStation}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="errr.property.pollingSchoolName.label" />  : </dt><dd id="pollingSchoolName" class="action-editField validate-string i18n-errr.property.pollingSchoolName" ><span>${request?.pollingSchoolName}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
