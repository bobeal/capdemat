


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="mcerrr.step.registration.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="mcerrr.step.situation.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="mcerrr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="mcerrr.property.subjectSheet.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
          
                
                  <dt class="required condition-isMadam-trigger"><g:message code="mcerrr.property.subjectChoiceTitle.label" /> * : </dt><dd id="subjectChoiceTitle" class="action-editField validate-capdematEnum required-true i18n-mcerrr.property.subjectChoiceTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.subjectChoiceTitle}" i18nKeyPrefix="mcerrr.property.subjectChoiceTitle" /></dd>
                
                  <dt class="required"><g:message code="mcerrr.property.subjectChoiceLastName.label" /> * : </dt><dd id="subjectChoiceLastName" class="action-editField validate-string required-true i18n-mcerrr.property.subjectChoiceLastName" ><span>${rqt?.subjectChoiceLastName}</span></dd>
                
                  <dt class="required condition-isMadam-filled"><g:message code="mcerrr.property.subjectChoiceMaidenName.label" /> * : </dt><dd id="subjectChoiceMaidenName" class="action-editField validate-string required-true i18n-mcerrr.property.subjectChoiceMaidenName" ><span>${rqt?.subjectChoiceMaidenName}</span></dd>
                
                  <dt class="required"><g:message code="mcerrr.property.subjectChoiceFirstName.label" /> * : </dt><dd id="subjectChoiceFirstName" class="action-editField validate-string required-true i18n-mcerrr.property.subjectChoiceFirstName" ><span>${rqt?.subjectChoiceFirstName}</span></dd>
                
                  <dt class=""><g:message code="mcerrr.property.subjectChoiceAddress.label" />  : </dt><dd id="subjectChoiceAddress" class="action-editField validate-address i18n-mcerrr.property.subjectChoiceAddress" ><div><p class="additionalDeliveryInformation">${rqt?.subjectChoiceAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.subjectChoiceAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.subjectChoiceAddress?.streetNumber}</span> <span class="streetName">${rqt?.subjectChoiceAddress?.streetName}</span><p class="placeNameOrService">${rqt?.subjectChoiceAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.subjectChoiceAddress?.postalCode}</span> <span class="city">${rqt?.subjectChoiceAddress?.city}</span><p class="countryName">${rqt?.subjectChoiceAddress?.countryName}</p></div></dd>
                
                  <dt class=""><g:message code="mcerrr.property.subjectChoiceHomePhone.label" />  : </dt><dd id="subjectChoiceHomePhone" class="action-editField validate-phone i18n-mcerrr.property.subjectChoiceHomePhone maxLength-10" ><span>${rqt?.subjectChoiceHomePhone}</span></dd>
                
                  <dt class=""><g:message code="mcerrr.property.subjectChoiceMobilPhone.label" />  : </dt><dd id="subjectChoiceMobilPhone" class="action-editField validate-phone i18n-mcerrr.property.subjectChoiceMobilPhone maxLength-10" ><span>${rqt?.subjectChoiceMobilPhone}</span></dd>
                
                  <dt class=""><g:message code="mcerrr.property.subjectChoiceProPhone.label" />  : </dt><dd id="subjectChoiceProPhone" class="action-editField validate-phone i18n-mcerrr.property.subjectChoiceProPhone maxLength-10" ><span>${rqt?.subjectChoiceProPhone}</span></dd>
                
                  <dt class=""><g:message code="mcerrr.property.subjectChoiceEmail.label" />  : </dt><dd id="subjectChoiceEmail" class="action-editField validate-email i18n-mcerrr.property.subjectChoiceEmail" ><span>${rqt?.subjectChoiceEmail}</span></dd>
                
                  <dt class="required"><g:message code="mcerrr.property.subjectChoiceBirthDate.label" /> * : </dt><dd id="subjectChoiceBirthDate" class="action-editField validate-date required-true i18n-mcerrr.property.subjectChoiceBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectChoiceBirthDate}"/></span></dd>
                
                  <dt class="required"><g:message code="mcerrr.property.subjectChoiceBirthCity.label" /> * : </dt><dd id="subjectChoiceBirthCity" class="action-editField validate-city required-true i18n-mcerrr.property.subjectChoiceBirthCity maxLength-32" ><span>${rqt?.subjectChoiceBirthCity}</span></dd>
                
                  <dt class="required"><g:message code="mcerrr.property.subjectChoiceBirthPostalCode.label" /> * : </dt><dd id="subjectChoiceBirthPostalCode" class="action-editField validate-postalCode required-true i18n-mcerrr.property.subjectChoiceBirthPostalCode maxLength-5" ><span>${rqt?.subjectChoiceBirthPostalCode}</span></dd>
                
                  <dt class="required"><g:message code="mcerrr.property.subjectChoiceBirthCountry.label" /> * : </dt><dd id="subjectChoiceBirthCountry" class="action-editField validate-capdematEnum required-true i18n-mcerrr.property.subjectChoiceBirthCountry javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.subjectChoiceBirthCountry}" i18nKeyPrefix="mcerrr.property.subjectChoiceBirthCountry" /></dd>
                
              </dl>
              
            
              
              <h3><g:message code="mcerrr.property.subjectPlaceToRegister.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="mcerrr.property.registrationCity.label" /> * : </dt><dd id="registrationCity" class="action-editField validate-city required-true i18n-mcerrr.property.registrationCity maxLength-32" ><span>${rqt?.registrationCity}</span></dd>
                
                  <dt class="required"><g:message code="mcerrr.property.registrationPostalCode.label" /> * : </dt><dd id="registrationPostalCode" class="action-editField validate-departmentCode required-true i18n-mcerrr.property.registrationPostalCode maxLength-2" ><span>${rqt?.registrationPostalCode}</span></dd>
                
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
          <span><g:message code="mcerrr.step.situation.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isFrench-trigger"><g:message code="mcerrr.property.choiceNationality.label" /> * : </dt><dd id="choiceNationality" class="action-editField validate-capdematEnum required-true i18n-mcerrr.property.choiceNationality javatype-fr.cg95.cvq.business.request.election.NationalityChoiceType" ><g:capdematEnumToField var="${rqt?.choiceNationality}" i18nKeyPrefix="mcerrr.property.choiceNationality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isFrench-unfilled"><g:message code="mcerrr.property.europeanNationality.label" /> * : </dt><dd id="europeanNationality" class="action-editField validate-capdematEnum required-true i18n-mcerrr.property.europeanNationality javatype-fr.cg95.cvq.business.request.election.EuropeanNationalityType" ><g:capdematEnumToField var="${rqt?.europeanNationality}" i18nKeyPrefix="mcerrr.property.europeanNationality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isFrench-unfilled condition-isMunicipalElectoral-trigger"><g:message code="mcerrr.property.electionChoice.label" /> * : </dt><dd id="electionChoice" class="action-editField validate-capdematEnum required-true i18n-mcerrr.property.electionChoice javatype-fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType" ><g:capdematEnumToField var="${rqt?.electionChoice}" i18nKeyPrefix="mcerrr.property.electionChoice" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isMotive-trigger"><g:message code="mcerrr.property.motive.label" /> * : </dt><dd id="motive" class="action-editField validate-capdematEnum required-true i18n-mcerrr.property.motive javatype-fr.cg95.cvq.business.request.election.ElectoralSituationType" ><g:capdematEnumToField var="${rqt?.motive}" i18nKeyPrefix="mcerrr.property.motive" /></dd>
              </dl>
              
            
              
              <h3><g:message code="mcerrr.property.oldAddressInformation.label" /></h3>
              <dl class="required condition-isMotive-filled">
                
                  <dt class=""><g:message code="mcerrr.property.oldCity.label" />  : </dt><dd id="oldCity" class="action-editField validate-string i18n-mcerrr.property.oldCity" ><span>${rqt?.oldCity}</span></dd>
                
                  <dt class=""><g:message code="mcerrr.property.oldDepartment.label" />  : </dt><dd id="oldDepartment" class="action-editField validate-departmentCode i18n-mcerrr.property.oldDepartment maxLength-2" ><span>${rqt?.oldDepartment}</span></dd>
                
                  <dt class=""><g:message code="mcerrr.property.oldOverseas.label" />  : </dt><dd id="oldOverseas" class="action-editField validate-string i18n-mcerrr.property.oldOverseas" ><span>${rqt?.oldOverseas}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="mcerrr.property.additionInformationFrenchCerfa.label" /></h3>
              <dl class="required condition-isFrench-filled">
                
                  <dt class=""><g:message code="mcerrr.property.ambassyOrConsulateAFCT.label" />  : </dt><dd id="ambassyOrConsulateAFCT" class="action-editField validate-string i18n-mcerrr.property.ambassyOrConsulateAFCT" ><span>${rqt?.ambassyOrConsulateAFCT}</span></dd>
                
                  <dt class=""><g:message code="mcerrr.property.externalCountryAFCT.label" />  : </dt><dd id="externalCountryAFCT" class="action-editField validate-capdematEnum i18n-mcerrr.property.externalCountryAFCT javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.externalCountryAFCT}" i18nKeyPrefix="mcerrr.property.externalCountryAFCT" /></dd>
                
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
