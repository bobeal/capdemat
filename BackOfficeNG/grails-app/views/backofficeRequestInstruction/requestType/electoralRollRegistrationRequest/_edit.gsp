


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="errr.step.registration.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page3"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="errr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="errr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'errr.property.subjectNationality.label')}&nbsp;*&nbsp;:</dt><dd id="subjectNationality" class="action-editField validate-capdematEnum required-true i18n-errr.property.subjectNationality javatype-fr.cg95.cvq.business.users.NationalityType maxLength-32" ><g:capdematEnumToField var="${rqt?.subjectNationality}" i18nKeyPrefix="errr.property.subjectNationality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isDirect-trigger">${message(code:'errr.property.motive.label')}&nbsp;*&nbsp;:</dt><dd id="motive" class="action-editField validate-capdematEnum required-true i18n-errr.property.motive javatype-fr.cg95.cvq.business.request.election.ElectoralMotiveType" ><g:capdematEnumToField var="${rqt?.motive}" i18nKeyPrefix="errr.property.motive" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isDirect-unfilled">${message(code:'errr.property.subjectOldCity.label')}&nbsp;*&nbsp;:</dt><dd id="subjectOldCity" class="action-editField validate-postalCode required-true i18n-errr.property.subjectOldCity maxLength-5" ><span>${rqt?.subjectOldCity}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isDirect-filled">${message(code:'errr.property.subjectAddressOutsideCity.label')}&nbsp;*&nbsp;:</dt><dd id="subjectAddressOutsideCity" class="action-editField validate-address required-true i18n-errr.property.subjectAddressOutsideCity" ><div><p class="additionalDeliveryInformation">${rqt?.subjectAddressOutsideCity?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.subjectAddressOutsideCity?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.subjectAddressOutsideCity?.streetNumber}</span> <span class="streetName">${rqt?.subjectAddressOutsideCity?.streetName}</span><g:if test="${!!rqt?.subjectAddressOutsideCity?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.subjectAddressOutsideCity?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.subjectAddressOutsideCity?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.subjectAddressOutsideCity?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.subjectAddressOutsideCity?.placeNameOrService}</p><span class="postalCode">${rqt?.subjectAddressOutsideCity?.postalCode}</span> <span class="city">${rqt?.subjectAddressOutsideCity?.city}</span><p class="countryName">${rqt?.subjectAddressOutsideCity?.countryName}</p><g:if test="${!!rqt?.subjectAddressOutsideCity?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.subjectAddressOutsideCity?.cityInseeCode}</span></g:if></div></dd>
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
          <span><g:message code="request.step.administration.label" /></span>
        </h2>
        <div class="yui-g">
          
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="">${message(code:'errr.property.electoralNumber.label')}&nbsp;:</dt><dd id="electoralNumber" class="action-editField validate-long i18n-errr.property.electoralNumber" ><span>${rqt?.electoralNumber}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="">${message(code:'errr.property.pollingStation.label')}&nbsp;:</dt><dd id="pollingStation" class="action-editField validate-long i18n-errr.property.pollingStation" ><span>${rqt?.pollingStation}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'errr.property.pollingSchoolName.label')}&nbsp;:</dt><dd id="pollingSchoolName" class="action-editField validate-string i18n-errr.property.pollingSchoolName" ><span>${rqt?.pollingSchoolName}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
