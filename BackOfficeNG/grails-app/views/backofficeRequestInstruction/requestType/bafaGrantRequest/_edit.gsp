


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="bgr.step.subject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="bgr.step.internship.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="bgr.step.bankReference.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page5"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="bgr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.isChildBorn ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.subjectBirthDate.label" /> * : </dt><dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-bgr.property.subjectBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectBirthDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.subjectBirthCity.label" /> * : </dt><dd id="subjectBirthCity" class="action-editField validate-city required-true i18n-bgr.property.subjectBirthCity maxLength-32" ><span>${rqt?.subjectBirthCity}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.subjectAddress.label" /> * : </dt><dd id="subjectAddress" class="action-editField validate-address required-true i18n-bgr.property.subjectAddress" ><div><p class="additionalDeliveryInformation">${rqt?.subjectAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.subjectAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.subjectAddress?.streetNumber}</span> <span class="streetName">${rqt?.subjectAddress?.streetName}</span><g:if test="${!!rqt?.subjectAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.subjectAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.subjectAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.subjectAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.subjectAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.subjectAddress?.postalCode}</span> <span class="city">${rqt?.subjectAddress?.city}</span><p class="countryName">${rqt?.subjectAddress?.countryName}</p><g:if test="${!!rqt?.subjectAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.subjectAddress?.cityInseeCode}</span></g:if></div></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.subjectPhone.label" /> * : </dt><dd id="subjectPhone" class="action-editField validate-phone required-true i18n-bgr.property.subjectPhone maxLength-10" ><span>${rqt?.subjectPhone}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.subjectEmail.label" /> * : </dt><dd id="subjectEmail" class="action-editField validate-email required-true i18n-bgr.property.subjectEmail" ><span>${rqt?.subjectEmail}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="bgr.step.internship.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.internshipStartDate.label" /> * : </dt><dd id="internshipStartDate" class="action-editField validate-date required-true i18n-bgr.property.internshipStartDate" ><span><g:formatDate formatName="format.date" date="${rqt?.internshipStartDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.internshipEndDate.label" /> * : </dt><dd id="internshipEndDate" class="action-editField validate-date required-true i18n-bgr.property.internshipEndDate" ><span><g:formatDate formatName="format.date" date="${rqt?.internshipEndDate}"/></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.internshipInstituteName.label" /> * : </dt><dd id="internshipInstituteName" class="action-editField validate-string required-true i18n-bgr.property.internshipInstituteName" ><span>${rqt?.internshipInstituteName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.internshipInstituteAddress.label" /> * : </dt><dd id="internshipInstituteAddress" class="action-editField validate-address required-true i18n-bgr.property.internshipInstituteAddress" ><div><p class="additionalDeliveryInformation">${rqt?.internshipInstituteAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.internshipInstituteAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.internshipInstituteAddress?.streetNumber}</span> <span class="streetName">${rqt?.internshipInstituteAddress?.streetName}</span><g:if test="${!!rqt?.internshipInstituteAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.internshipInstituteAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.internshipInstituteAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.internshipInstituteAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.internshipInstituteAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.internshipInstituteAddress?.postalCode}</span> <span class="city">${rqt?.internshipInstituteAddress?.city}</span><p class="countryName">${rqt?.internshipInstituteAddress?.countryName}</p><g:if test="${!!rqt?.internshipInstituteAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.internshipInstituteAddress?.cityInseeCode}</span></g:if></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="bgr.step.bankReference.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-trigger"><g:message code="bgr.property.isSubjectAccountHolder.label" /> * : </dt><dd id="isSubjectAccountHolder" class="action-editField validate-boolean required-true i18n-bgr.property.isSubjectAccountHolder" ><span class="value-${rqt?.isSubjectAccountHolder}"><g:message code="message.${rqt?.isSubjectAccountHolder ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.frenchRIB.label" /> * : </dt><dd id="frenchRIB" class="action-editField validate-frenchRIB required-true i18n-bgr.property.frenchRIB" ><div><p class="bankCode">${rqt?.frenchRIB?.bankCode}</p><p class="counterCode">${rqt?.frenchRIB?.counterCode}</p><p class="accountNumber">${rqt?.frenchRIB?.accountNumber}</p><p class="accountKey">${rqt?.frenchRIB?.accountKey}</p></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="bgr.property.accountHolderTitle.label" /> * : </dt><dd id="accountHolderTitle" class="action-editField validate-capdematEnum required-true i18n-bgr.property.accountHolderTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.accountHolderTitle}" i18nKeyPrefix="bgr.property.accountHolderTitle" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="bgr.property.accountHolderLastName.label" /> * : </dt><dd id="accountHolderLastName" class="action-editField validate-lastName required-true i18n-bgr.property.accountHolderLastName maxLength-38" ><span>${rqt?.accountHolderLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="bgr.property.accountHolderFirstName.label" /> * : </dt><dd id="accountHolderFirstName" class="action-editField validate-firstName required-true i18n-bgr.property.accountHolderFirstName maxLength-38" ><span>${rqt?.accountHolderFirstName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="bgr.property.accountHolderBirthDate.label" /> * : </dt><dd id="accountHolderBirthDate" class="action-editField validate-date required-true i18n-bgr.property.accountHolderBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.accountHolderBirthDate}"/></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page5">
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
                <dt class="required"><g:message code="bgr.property.edemandeId.label" /> * : </dt><dd id="edemandeId" class="action-editField validate-string required-true i18n-bgr.property.edemandeId" ><span>${rqt?.edemandeId}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="bgr.property.accountHolderEdemandeId.label" /> * : </dt><dd id="accountHolderEdemandeId" class="action-editField validate-string required-true i18n-bgr.property.accountHolderEdemandeId" ><span>${rqt?.accountHolderEdemandeId}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
