

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
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.taxHouseholdLastName.label" /> * : </dt>
                  <dd id="taxHouseholdLastName" class="action-editField validate-lastName required-true i18n-sgr.property.taxHouseholdLastName maxLength-38" >
                    <span>${request?.taxHouseholdLastName}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.taxHouseholdFirstName.label" /> * : </dt>
                  <dd id="taxHouseholdFirstName" class="action-editField validate-firstName required-true i18n-sgr.property.taxHouseholdFirstName maxLength-38" >
                    <span>${request?.taxHouseholdFirstName}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.taxHouseholdPhone.label" /> * : </dt>
                  <dd id="taxHouseholdPhone" class="action-editField validate-phone required-true i18n-sgr.property.taxHouseholdPhone maxLength-10" >
                    <span>${request?.taxHouseholdPhone}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.taxHouseholdIncome.label" /> * : </dt>
                  <dd id="taxHouseholdIncome" class="action-editField validate-regex required-true i18n-sgr.property.taxHouseholdIncome" regex="^\d+(?:\.\d{1,2})?$">
                    <span>${request?.taxHouseholdIncome}</span>
                  </dd>
                </dl>
                
              
            </div>
            <!-- column end -->
            
            <!-- column start -->
            <div class="yui-u">
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.taxHouseholdAddress.label" /> * : </dt>
                  <dd id="taxHouseholdAddress" class="action-editField validate-address required-true i18n-sgr.property.taxHouseholdAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.taxHouseholdAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.taxHouseholdAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.taxHouseholdAddress?.streetNumber}</span> <span class="streetName">${request?.taxHouseholdAddress?.streetName}</span><p class="placeNameOrService">${request?.taxHouseholdAddress?.placeNameOrService}</p><span class="postalCode">${request?.taxHouseholdAddress?.postalCode}</span> <span class="city">${request?.taxHouseholdAddress?.city}</span><p class="countryName">${request?.taxHouseholdAddress?.countryName}</p></div>
                  </dd>
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
          <span><g:message code="sgr.step.otherHelps.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.hasCROUSHelp.label" /> * : </dt>
                  <dd id="hasCROUSHelp" class="action-editField validate-boolean required-true i18n-sgr.property.hasCROUSHelp" >
                    <span class="value-${request?.hasCROUSHelp}"><g:message code="message.${request?.hasCROUSHelp ? 'yes' : 'no'}" /></span>
                  </dd>
                </dl>
                
              
            </div>
            <!-- column end -->
            
            <!-- column start -->
            <div class="yui-u">
              
                
                <dl>
                  <dt class="required condition-otherHelpObtained-trigger"><g:message code="sgr.property.hasOtherHelp.label" /> * : </dt>
                  <dd id="hasOtherHelp" class="action-editField validate-boolean required-true i18n-sgr.property.hasOtherHelp" >
                    <span class="value-${request?.hasOtherHelp}"><g:message code="message.${request?.hasOtherHelp ? 'yes' : 'no'}" /></span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required condition-otherHelpObtained-filled"><g:message code="sgr.property.otherHelpInformations.label" /> * : </dt>
                  <dd id="otherHelpInformations" class="action-editField validate-string required-true i18n-sgr.property.otherHelpInformations" >
                    <span>${request?.otherHelpInformations}</span>
                  </dd>
                </dl>
                
              
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
              
                
                <h3><g:message code="sgr.property.aLevelsInformations.label" /></h3>
                <dl class="required">
                  
                    <dt class="required condition-notInLastYear-trigger"><g:message code="sgr.property.isInLastYear.label" /> * : </dt>
                    <dd id="isInLastYear" class="action-editField validate-boolean required-true i18n-sgr.property.isInLastYear" >
                      <span class="value-${request?.isInLastYear}"><g:message code="message.${request?.isInLastYear ? 'yes' : 'no'}" /></span>
                    </dd>
                  
                    <dt class="required condition-notInLastYear-filled"><g:message code="sgr.property.lastYearDate.label" /> * : </dt>
                    <dd id="lastYearDate" class="action-editField validate-regex required-true i18n-sgr.property.lastYearDate maxLength-4" regex="^\d{2,4}$">
                      <span>${request?.lastYearDate}</span>
                    </dd>
                  
                    <dt class="required condition-notInLastYear-filled"><g:message code="sgr.property.lastYearType.label" /> * : </dt>
                    <dd id="lastYearType" class="action-editField validate-string required-true i18n-sgr.property.lastYearType" >
                      <span>${request?.lastYearType}</span>
                    </dd>
                  
                </dl>
                
              
            </div>
            <!-- column end -->
            
            <!-- column start -->
            <div class="yui-u">
              
                
                <h3><g:message code="sgr.property.currentStudiesInformations.label" /></h3>
                <dl class="required condition-notInLastYear-filled">
                  
                    <dt class="required condition-isInAbroadInternship-trigger condition-isInSandwichCourses-trigger condition-isInOtherStudies-trigger"><g:message code="sgr.property.currentStudies.label" /> * : </dt>
                    <dd id="currentStudies" class="action-editField validate-capdematEnum required-true i18n-sgr.property.currentStudies javatype-fr.cg95.cvq.business.request.school.CurrentStudiesType" >
                      <g:capdematEnumToField var="${request?.currentStudies}" i18nKeyPrefix="sgr.property.currentStudies" />
                    </dd>
                  
                    <dt class="required condition-isInSandwichCourses-filled"><g:message code="sgr.property.sandwichCoursesLabel.label" /> * : </dt>
                    <dd id="sandwichCoursesLabel" class="action-editField validate-string required-true i18n-sgr.property.sandwichCoursesLabel" >
                      <span>${request?.sandwichCoursesLabel}</span>
                    </dd>
                  
                    <dt class="required condition-isInAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipStartDate.label" /> * : </dt>
                    <dd id="abroadInternshipStartDate" class="action-editField validate-date required-true i18n-sgr.property.abroadInternshipStartDate" >
                      <span><g:formatDate formatName="format.date" date="${request?.abroadInternshipStartDate}"/></span>
                    </dd>
                  
                    <dt class="required condition-isInAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipEndDate.label" /> * : </dt>
                    <dd id="abroadInternshipEndDate" class="action-editField validate-date required-true i18n-sgr.property.abroadInternshipEndDate" >
                      <span><g:formatDate formatName="format.date" date="${request?.abroadInternshipEndDate}"/></span>
                    </dd>
                  
                    <dt class="required condition-isInOtherStudies-filled"><g:message code="sgr.property.otherStudiesLabel.label" /> * : </dt>
                    <dd id="otherStudiesLabel" class="action-editField validate-string required-true i18n-sgr.property.otherStudiesLabel" >
                      <span>${request?.otherStudiesLabel}</span>
                    </dd>
                  
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
          <span><g:message code="sgr.step.futureSchool.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.futureSchoolName.label" /> * : </dt>
                  <dd id="futureSchoolName" class="action-editField validate-string required-true i18n-sgr.property.futureSchoolName" >
                    <span>${request?.futureSchoolName}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.futureSchoolAddress.label" /> * : </dt>
                  <dd id="futureSchoolAddress" class="action-editField validate-address required-true i18n-sgr.property.futureSchoolAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.futureSchoolAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.futureSchoolAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.futureSchoolAddress?.streetNumber}</span> <span class="streetName">${request?.futureSchoolAddress?.streetName}</span><p class="placeNameOrService">${request?.futureSchoolAddress?.placeNameOrService}</p><span class="postalCode">${request?.futureSchoolAddress?.postalCode}</span> <span class="city">${request?.futureSchoolAddress?.city}</span><p class="countryName">${request?.futureSchoolAddress?.countryName}</p></div>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.futureSchoolPhone.label" /> * : </dt>
                  <dd id="futureSchoolPhone" class="action-editField validate-phone required-true i18n-sgr.property.futureSchoolPhone maxLength-10" >
                    <span>${request?.futureSchoolPhone}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.futureDiplomaName.label" /> * : </dt>
                  <dd id="futureDiplomaName" class="action-editField validate-string required-true i18n-sgr.property.futureDiplomaName" >
                    <span>${request?.futureDiplomaName}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.futureDiplomaLevel.label" /> * : </dt>
                  <dd id="futureDiplomaLevel" class="action-editField validate-string required-true i18n-sgr.property.futureDiplomaLevel" >
                    <span>${request?.futureDiplomaLevel}</span>
                  </dd>
                </dl>
                
              
            </div>
            <!-- column end -->
            
            <!-- column start -->
            <div class="yui-u">
              
                
                <dl>
                  <dt class="required condition-willDoAbroadInternship-trigger"><g:message code="sgr.property.futureSchoolIsAbroad.label" /> * : </dt>
                  <dd id="futureSchoolIsAbroad" class="action-editField validate-boolean required-true i18n-sgr.property.futureSchoolIsAbroad" >
                    <span class="value-${request?.futureSchoolIsAbroad}"><g:message code="message.${request?.futureSchoolIsAbroad ? 'yes' : 'no'}" /></span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required condition-willDoAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolName.label" /> * : </dt>
                  <dd id="abroadInternshipSchoolName" class="action-editField validate-string required-true i18n-sgr.property.abroadInternshipSchoolName" >
                    <span>${request?.abroadInternshipSchoolName}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required condition-willDoAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolAddress.label" /> * : </dt>
                  <dd id="abroadInternshipSchoolAddress" class="action-editField validate-string required-true i18n-sgr.property.abroadInternshipSchoolAddress" >
                    <span>${request?.abroadInternshipSchoolAddress}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required condition-willDoAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolCountry.label" /> * : </dt>
                  <dd id="abroadInternshipSchoolCountry" class="action-editField validate-capdematEnum required-true i18n-sgr.property.abroadInternshipSchoolCountry javatype-fr.cg95.cvq.business.users.CountryType" >
                    <g:capdematEnumToField var="${request?.abroadInternshipSchoolCountry}" i18nKeyPrefix="sgr.property.abroadInternshipSchoolCountry" />
                  </dd>
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
          <span><g:message code="sgr.step.calculationElements.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.distance.label" /> * : </dt>
                  <dd id="distance" class="action-editField validate-capdematEnum required-true i18n-sgr.property.distance javatype-fr.cg95.cvq.business.request.school.DistanceType" >
                    <g:capdematEnumToField var="${request?.distance}" i18nKeyPrefix="sgr.property.distance" />
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
      <div id="page6">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.bankReference.label" /></span>
        </h2>
          
          <div class="yui-g">
            
            <!-- column start -->
            <div class="yui-u first">
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.bankName.label" /> * : </dt>
                  <dd id="bankName" class="action-editField validate-string required-true i18n-sgr.property.bankName" >
                    <span>${request?.bankName}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.bankAgency.label" /> * : </dt>
                  <dd id="bankAgency" class="action-editField validate-string required-true i18n-sgr.property.bankAgency" >
                    <span>${request?.bankAgency}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.accountNumber.label" /> * : </dt>
                  <dd id="accountNumber" class="action-editField validate-regex required-true i18n-sgr.property.accountNumber maxLength-11" regex="^[a-zA-Z0-9]{1,11}$">
                    <span>${request?.accountNumber}</span>
                  </dd>
                </dl>
                
              
            </div>
            <!-- column end -->
            
            <!-- column start -->
            <div class="yui-u">
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.bankCode.label" /> * : </dt>
                  <dd id="bankCode" class="action-editField validate-regex required-true i18n-sgr.property.bankCode maxLength-5" regex="^\d{1,5}$">
                    <span>${request?.bankCode}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.counterCode.label" /> * : </dt>
                  <dd id="counterCode" class="action-editField validate-regex required-true i18n-sgr.property.counterCode maxLength-5" regex="^\d{1,5}$">
                    <span>${request?.counterCode}</span>
                  </dd>
                </dl>
                
              
                
                <dl>
                  <dt class="required"><g:message code="sgr.property.accountKey.label" /> * : </dt>
                  <dd id="accountKey" class="action-editField validate-regex required-true i18n-sgr.property.accountKey maxLength-2" regex="^(?:O[1-9])|(?:[1-8]\d)|(?:9[0-7])$">
                    <span>${request?.accountKey}</span>
                  </dd>
                </dl>
                
              
            </div>
            <!-- column end -->
            
          </div>
          <!-- data step  end -->
          
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
