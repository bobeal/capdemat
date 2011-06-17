


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="sgr.step.subject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="sgr.step.taxHousehold.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="sgr.step.otherHelps.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="sgr.step.currentStudies.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page4"><em><g:message code="sgr.step.calculationElements.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page5"><em><g:message code="sgr.step.bankReference.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page8"><em><g:message code="request.step.administration.label" /></em></a>
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
            
              
              <h3><g:message code="sgr.property.subjectInformations.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
                
                  <dt class="required"><g:message code="sgr.property.subjectBirthDate.label" /> * : </dt><dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-sgr.property.subjectBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectBirthDate}"/></span></dd>
                
                  <dt class="required"><g:message code="sgr.property.subjectFirstRequest.label" /> * : </dt><dd id="subjectFirstRequest" class="action-editField validate-boolean required-true i18n-sgr.property.subjectFirstRequest" ><span class="value-${rqt?.subjectFirstRequest}"><g:message code="message.${rqt?.subjectFirstRequest ? 'yes' : 'no'}" /></span></dd>
                
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
                <dt class="required"><g:message code="sgr.property.taxHouseholdLastName.label" /> * : </dt><dd id="taxHouseholdLastName" class="action-editField validate-lastName required-true i18n-sgr.property.taxHouseholdLastName maxLength-38" ><span>${rqt?.taxHouseholdLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.taxHouseholdFirstName.label" /> * : </dt><dd id="taxHouseholdFirstName" class="action-editField validate-firstName required-true i18n-sgr.property.taxHouseholdFirstName maxLength-38" ><span>${rqt?.taxHouseholdFirstName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTaxHouseholdCityOther-trigger"><g:message code="sgr.property.taxHouseholdCity.label" /> * : </dt><dd id="taxHouseholdCity" class="action-editField validate-localReferentialData required-true i18n-sgr.property.taxHouseholdCity data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'taxHouseholdCity', 'lrEntries': lrTypes.taxHouseholdCity?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.taxHouseholdCity?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isTaxHouseholdCityOther-filled"><g:message code="sgr.property.taxHouseholdCityPrecision.label" /> * : </dt><dd id="taxHouseholdCityPrecision" class="action-editField validate-string required-true i18n-sgr.property.taxHouseholdCityPrecision" ><span>${rqt?.taxHouseholdCityPrecision}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.taxHouseholdIncome.label" /> * : </dt><dd id="taxHouseholdIncome" class="action-editField validate-regex required-true i18n-sgr.property.taxHouseholdIncome" regex="^\d+(?:\.\d{1,2})?$"><span>${rqt?.taxHouseholdIncome}</span></dd>
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
          <span><g:message code="sgr.step.otherHelps.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.hasCROUSHelp.label" /> * : </dt><dd id="hasCROUSHelp" class="action-editField validate-boolean required-true i18n-sgr.property.hasCROUSHelp" ><span class="value-${rqt?.hasCROUSHelp}"><g:message code="message.${rqt?.hasCROUSHelp ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.hasRegionalCouncilHelp.label" /> * : </dt><dd id="hasRegionalCouncilHelp" class="action-editField validate-boolean required-true i18n-sgr.property.hasRegionalCouncilHelp" ><span class="value-${rqt?.hasRegionalCouncilHelp}"><g:message code="message.${rqt?.hasRegionalCouncilHelp ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.hasEuropeHelp.label" /> * : </dt><dd id="hasEuropeHelp" class="action-editField validate-boolean required-true i18n-sgr.property.hasEuropeHelp" ><span class="value-${rqt?.hasEuropeHelp}"><g:message code="message.${rqt?.hasEuropeHelp ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.hasOtherHelp.label" /> * : </dt><dd id="hasOtherHelp" class="action-editField validate-boolean required-true i18n-sgr.property.hasOtherHelp" ><span class="value-${rqt?.hasOtherHelp}"><g:message code="message.${rqt?.hasOtherHelp ? 'yes' : 'no'}" /></span></dd>
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
            
              
              <h3><g:message code="sgr.property.currentSchool.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isCurrentSchoolNameOther-trigger"><g:message code="sgr.property.currentSchoolName.label" /> * : </dt><dd id="currentSchoolName" class="action-editField validate-localReferentialData required-true i18n-sgr.property.currentSchoolName data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'currentSchoolName', 'lrEntries': lrTypes.currentSchoolName?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.currentSchoolName?.isMultiple(), 'depth':0]" />
 
          </dd>
                
                  <dt class="required condition-isCurrentSchoolNameOther-filled"><g:message code="sgr.property.currentSchoolNamePrecision.label" /> * : </dt><dd id="currentSchoolNamePrecision" class="action-editField validate-string required-true i18n-sgr.property.currentSchoolNamePrecision" ><span>${rqt?.currentSchoolNamePrecision}</span></dd>
                
                  <dt class="required"><g:message code="sgr.property.currentSchoolPostalCode.label" /> * : </dt><dd id="currentSchoolPostalCode" class="action-editField validate-postalCode required-true i18n-sgr.property.currentSchoolPostalCode maxLength-5" ><span>${rqt?.currentSchoolPostalCode}</span></dd>
                
                  <dt class="required"><g:message code="sgr.property.currentSchoolCity.label" /> * : </dt><dd id="currentSchoolCity" class="action-editField validate-city required-true i18n-sgr.property.currentSchoolCity maxLength-32" ><span>${rqt?.currentSchoolCity}</span></dd>
                
                  <dt class="required"><g:message code="sgr.property.currentSchoolCountry.label" /> * : </dt><dd id="currentSchoolCountry" class="action-editField validate-capdematEnum required-true i18n-sgr.property.currentSchoolCountry javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.currentSchoolCountry}" i18nKeyPrefix="sgr.property.currentSchoolCountry" /></dd>
                
              </dl>
              
            
              
              <h3><g:message code="sgr.property.aLevelsInformations.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="sgr.property.alevelsDate.label" /> * : </dt><dd id="alevelsDate" class="action-editField validate-regex required-true i18n-sgr.property.alevelsDate maxLength-4" regex="^\d{2,4}$"><span>${rqt?.alevelsDate}</span></dd>
                
                  <dt class="required"><g:message code="sgr.property.alevels.label" /> * : </dt><dd id="alevels" class="action-editField validate-capdematEnum required-true i18n-sgr.property.alevels javatype-fr.cg95.cvq.business.request.school.ALevelsType" ><g:capdematEnumToField var="${rqt?.alevels}" i18nKeyPrefix="sgr.property.alevels" /></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="sgr.property.currentStudiesInformations.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isInOtherStudies-trigger"><g:message code="sgr.property.currentStudiesDiploma.label" /> * : </dt><dd id="currentStudiesDiploma" class="action-editField validate-capdematEnum required-true i18n-sgr.property.currentStudiesDiploma javatype-fr.cg95.cvq.business.request.school.CurrentStudiesType" ><g:capdematEnumToField var="${rqt?.currentStudiesDiploma}" i18nKeyPrefix="sgr.property.currentStudiesDiploma" /></dd>
                
                  <dt class="required condition-isInOtherStudies-filled"><g:message code="sgr.property.otherStudiesLabel.label" /> * : </dt><dd id="otherStudiesLabel" class="action-editField validate-string required-true i18n-sgr.property.otherStudiesLabel" ><span>${rqt?.otherStudiesLabel}</span></dd>
                
                  <dt class="required"><g:message code="sgr.property.currentStudiesLevel.label" /> * : </dt><dd id="currentStudiesLevel" class="action-editField validate-capdematEnum required-true i18n-sgr.property.currentStudiesLevel javatype-fr.cg95.cvq.business.request.school.CurrentStudiesLevelType" ><g:capdematEnumToField var="${rqt?.currentStudiesLevel}" i18nKeyPrefix="sgr.property.currentStudiesLevel" /></dd>
                
                  <dt class="required"><g:message code="sgr.property.sandwichCourses.label" /> * : </dt><dd id="sandwichCourses" class="action-editField validate-boolean required-true i18n-sgr.property.sandwichCourses" ><span class="value-${rqt?.sandwichCourses}"><g:message code="message.${rqt?.sandwichCourses ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required condition-makesAbroadInternship-trigger"><g:message code="sgr.property.abroadInternship.label" /> * : </dt><dd id="abroadInternship" class="action-editField validate-boolean required-true i18n-sgr.property.abroadInternship" ><span class="value-${rqt?.abroadInternship}"><g:message code="message.${rqt?.abroadInternship ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipStartDate.label" /> * : </dt><dd id="abroadInternshipStartDate" class="action-editField validate-date required-true i18n-sgr.property.abroadInternshipStartDate" ><span><g:formatDate formatName="format.date" date="${rqt?.abroadInternshipStartDate}"/></span></dd>
                
                  <dt class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipEndDate.label" /> * : </dt><dd id="abroadInternshipEndDate" class="action-editField validate-date required-true i18n-sgr.property.abroadInternshipEndDate" ><span><g:formatDate formatName="format.date" date="${rqt?.abroadInternshipEndDate}"/></span></dd>
                
                  <dt class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolName.label" /> * : </dt><dd id="abroadInternshipSchoolName" class="action-editField validate-string required-true i18n-sgr.property.abroadInternshipSchoolName" ><span>${rqt?.abroadInternshipSchoolName}</span></dd>
                
                  <dt class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolCountry.label" /> * : </dt><dd id="abroadInternshipSchoolCountry" class="action-editField validate-capdematEnum required-true i18n-sgr.property.abroadInternshipSchoolCountry javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.abroadInternshipSchoolCountry}" i18nKeyPrefix="sgr.property.abroadInternshipSchoolCountry" /></dd>
                
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
          <span><g:message code="sgr.step.calculationElements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.distance.label" /> * : </dt><dd id="distance" class="action-editField validate-capdematEnum required-true i18n-sgr.property.distance javatype-fr.cg95.cvq.business.request.school.DistanceType" ><g:capdematEnumToField var="${rqt?.distance}" i18nKeyPrefix="sgr.property.distance" /></dd>
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
      <div id="page5">
        <h2><g:message code="property.form" />
          <span><g:message code="sgr.step.bankReference.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-trigger"><g:message code="sgr.property.isSubjectAccountHolder.label" /> * : </dt><dd id="isSubjectAccountHolder" class="action-editField validate-boolean required-true i18n-sgr.property.isSubjectAccountHolder" ><span class="value-${rqt?.isSubjectAccountHolder}"><g:message code="message.${rqt?.isSubjectAccountHolder ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderTitle.label" /> * : </dt><dd id="accountHolderTitle" class="action-editField validate-capdematEnum required-true i18n-sgr.property.accountHolderTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.accountHolderTitle}" i18nKeyPrefix="sgr.property.accountHolderTitle" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderLastName.label" /> * : </dt><dd id="accountHolderLastName" class="action-editField validate-lastName required-true i18n-sgr.property.accountHolderLastName maxLength-38" ><span>${rqt?.accountHolderLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderFirstName.label" /> * : </dt><dd id="accountHolderFirstName" class="action-editField validate-firstName required-true i18n-sgr.property.accountHolderFirstName maxLength-38" ><span>${rqt?.accountHolderFirstName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="sgr.property.accountHolderBirthDate.label" /> * : </dt><dd id="accountHolderBirthDate" class="action-editField validate-date required-true i18n-sgr.property.accountHolderBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.accountHolderBirthDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.bankAccount.label" /> * : </dt><dd id="bankAccount" class="action-editField validate-bankAccount required-true i18n-sgr.property.bankAccount" ><div><p>${rqt?.bankAccount?.BIC}</p><p>${rqt?.bankAccount?.IBAN}</p></div></dd>
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
      <div id="page8">
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
                <dt class="required"><g:message code="sgr.property.accountHolderEdemandeId.label" /> * : </dt><dd id="accountHolderEdemandeId" class="action-editField validate-string required-true i18n-sgr.property.accountHolderEdemandeId" ><span>${rqt?.accountHolderEdemandeId}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sgr.property.edemandeId.label" /> * : </dt><dd id="edemandeId" class="action-editField validate-string required-true i18n-sgr.property.edemandeId" ><span>${rqt?.edemandeId}</span></dd>
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
