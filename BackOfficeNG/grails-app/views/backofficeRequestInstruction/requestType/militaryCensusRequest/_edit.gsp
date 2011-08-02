


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="mcr.step.census.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="mcr.step.parentage.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="mcr.step.situation.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="mcr.step.exemption.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="mcr.step.census.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="mcr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="mcr.property.childTitle.label" /> * : </dt><dd id="childTitle" class="action-editField validate-capdematEnum required-true i18n-mcr.property.childTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.childTitle}" i18nKeyPrefix="mcr.property.childTitle" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="mcr.property.maidenName.label" />  : </dt><dd id="maidenName" class="action-editField validate-lastName i18n-mcr.property.maidenName maxLength-38" ><span>${rqt?.maidenName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="mcr.property.childBirthCountry.label" /> * : </dt><dd id="childBirthCountry" class="action-editField validate-capdematEnum required-true i18n-mcr.property.childBirthCountry javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.childBirthCountry}" i18nKeyPrefix="mcr.property.childBirthCountry" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="mcr.property.childResidenceCountry.label" />  : </dt><dd id="childResidenceCountry" class="action-editField validate-capdematEnum i18n-mcr.property.childResidenceCountry javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.childResidenceCountry}" i18nKeyPrefix="mcr.property.childResidenceCountry" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="mcr.property.childPhone.label" /> * : </dt><dd id="childPhone" class="action-editField validate-phone required-true i18n-mcr.property.childPhone maxLength-10" ><span>${rqt?.childPhone}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="mcr.property.childMail.label" />  : </dt><dd id="childMail" class="action-editField validate-email i18n-mcr.property.childMail" ><span>${rqt?.childMail}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="mcr.property.childCountry.label" /> * : </dt><dd id="childCountry" class="action-editField validate-capdematEnum required-true i18n-mcr.property.childCountry javatype-fr.cg95.cvq.business.users.FullNationalityType" ><g:capdematEnumToField var="${rqt?.childCountry}" i18nKeyPrefix="mcr.property.childCountry" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="mcr.property.childOtherCountry.label" />  : </dt><dd id="childOtherCountry" class="action-editField validate-capdematEnum i18n-mcr.property.childOtherCountry javatype-fr.cg95.cvq.business.users.FullNationalityType" ><g:capdematEnumToField var="${rqt?.childOtherCountry}" i18nKeyPrefix="mcr.property.childOtherCountry" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="mcr.property.childConvention.label" />  : </dt><dd id="childConvention" class="action-editField validate-regex i18n-mcr.property.childConvention rows-3 maxLength-255" regex="^[\w\W]{0,255}$"><span>${rqt?.childConvention}</span></dd>
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
          <span><g:message code="mcr.step.parentage.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="mcr.property.fatherInformation.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="mcr.property.fatherLastName.label" />  : </dt><dd id="fatherLastName" class="action-editField validate-lastName i18n-mcr.property.fatherLastName maxLength-38" ><span>${rqt?.fatherLastName}</span></dd>
                
                  <dt class=""><g:message code="mcr.property.fatherFirstName.label" />  : </dt><dd id="fatherFirstName" class="action-editField validate-firstName i18n-mcr.property.fatherFirstName maxLength-38" ><span>${rqt?.fatherFirstName}</span></dd>
                
                  <dt class=""><g:message code="mcr.property.fatherBirthDate.label" />  : </dt><dd id="fatherBirthDate" class="action-editField validate-date i18n-mcr.property.fatherBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.fatherBirthDate}"/></span></dd>
                
                  <dt class=""><g:message code="mcr.property.fatherBirthCity.label" />  : </dt><dd id="fatherBirthCity" class="action-editField validate-string i18n-mcr.property.fatherBirthCity" ><span>${rqt?.fatherBirthCity}</span></dd>
                
                  <dt class=""><g:message code="mcr.property.fatherBirthDepartment.label" />  : </dt><dd id="fatherBirthDepartment" class="action-editField validate-capdematEnum i18n-mcr.property.fatherBirthDepartment javatype-fr.cg95.cvq.business.users.InseeDepartementCodeType" ><g:capdematEnumToField var="${rqt?.fatherBirthDepartment}" i18nKeyPrefix="mcr.property.fatherBirthDepartment" /></dd>
                
                  <dt class=""><g:message code="mcr.property.fatherBirthCountry.label" />  : </dt><dd id="fatherBirthCountry" class="action-editField validate-capdematEnum i18n-mcr.property.fatherBirthCountry javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.fatherBirthCountry}" i18nKeyPrefix="mcr.property.fatherBirthCountry" /></dd>
                
                  <dt class=""><g:message code="mcr.property.fatherNationality.label" />  : </dt><dd id="fatherNationality" class="action-editField validate-capdematEnum i18n-mcr.property.fatherNationality javatype-fr.cg95.cvq.business.users.FullNationalityType" ><g:capdematEnumToField var="${rqt?.fatherNationality}" i18nKeyPrefix="mcr.property.fatherNationality" /></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="mcr.property.motherInformation.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="mcr.property.motherLastName.label" /> * : </dt><dd id="motherLastName" class="action-editField validate-lastName required-true i18n-mcr.property.motherLastName maxLength-38" ><span>${rqt?.motherLastName}</span></dd>
                
                  <dt class="required"><g:message code="mcr.property.motherFirstName.label" /> * : </dt><dd id="motherFirstName" class="action-editField validate-firstName required-true i18n-mcr.property.motherFirstName maxLength-38" ><span>${rqt?.motherFirstName}</span></dd>
                
                  <dt class="required"><g:message code="mcr.property.motherBirthDate.label" /> * : </dt><dd id="motherBirthDate" class="action-editField validate-date required-true i18n-mcr.property.motherBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.motherBirthDate}"/></span></dd>
                
                  <dt class="required"><g:message code="mcr.property.motherBirthCity.label" /> * : </dt><dd id="motherBirthCity" class="action-editField validate-string required-true i18n-mcr.property.motherBirthCity" ><span>${rqt?.motherBirthCity}</span></dd>
                
                  <dt class=""><g:message code="mcr.property.motherBirthDepartment.label" />  : </dt><dd id="motherBirthDepartment" class="action-editField validate-capdematEnum i18n-mcr.property.motherBirthDepartment javatype-fr.cg95.cvq.business.users.InseeDepartementCodeType" ><g:capdematEnumToField var="${rqt?.motherBirthDepartment}" i18nKeyPrefix="mcr.property.motherBirthDepartment" /></dd>
                
                  <dt class=""><g:message code="mcr.property.motherBirthCountry.label" />  : </dt><dd id="motherBirthCountry" class="action-editField validate-capdematEnum i18n-mcr.property.motherBirthCountry javatype-fr.cg95.cvq.business.users.CountryType" ><g:capdematEnumToField var="${rqt?.motherBirthCountry}" i18nKeyPrefix="mcr.property.motherBirthCountry" /></dd>
                
                  <dt class="required"><g:message code="mcr.property.motherNationality.label" /> * : </dt><dd id="motherNationality" class="action-editField validate-capdematEnum required-true i18n-mcr.property.motherNationality javatype-fr.cg95.cvq.business.users.FullNationalityType" ><g:capdematEnumToField var="${rqt?.motherNationality}" i18nKeyPrefix="mcr.property.motherNationality" /></dd>
                
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
          <span><g:message code="mcr.step.situation.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="mcr.property.familySituationInformation.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="mcr.property.aliveChildren.label" /> * : </dt><dd id="aliveChildren" class="action-editField validate-positiveInteger required-true i18n-mcr.property.aliveChildren" ><span>${rqt?.aliveChildren}</span></dd>
                
                  <dt class="required"><g:message code="mcr.property.childStatus.label" /> * : </dt><dd id="childStatus" class="action-editField validate-capdematEnum required-true i18n-mcr.property.childStatus javatype-fr.cg95.cvq.business.users.FamilyStatusType" ><g:capdematEnumToField var="${rqt?.childStatus}" i18nKeyPrefix="mcr.property.childStatus" /></dd>
                
                  <dt class="required"><g:message code="mcr.property.childrenInCharge.label" /> * : </dt><dd id="childrenInCharge" class="action-editField validate-positiveInteger required-true i18n-mcr.property.childrenInCharge" ><span>${rqt?.childrenInCharge}</span></dd>
                
                  <dt class=""><g:message code="mcr.property.otherSituation.label" />  : </dt><dd id="otherSituation" class="action-editField validate-string i18n-mcr.property.otherSituation" ><span>${rqt?.otherSituation}</span></dd>
                
                  <dt class="required"><g:message code="mcr.property.statePupil.label" /> * : </dt><dd id="statePupil" class="action-editField validate-boolean required-true i18n-mcr.property.statePupil" ><span class="value-${rqt?.statePupil}"><g:message code="message.${rqt?.statePupil ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required condition-isPrefectPupil-trigger"><g:message code="mcr.property.prefectPupil.label" /> * : </dt><dd id="prefectPupil" class="action-editField validate-boolean required-true i18n-mcr.property.prefectPupil" ><span class="value-${rqt?.prefectPupil}"><g:message code="message.${rqt?.prefectPupil ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required condition-isPrefectPupil-filled"><g:message code="mcr.property.prefectPupilDepartment.label" /> * : </dt><dd id="prefectPupilDepartment" class="action-editField validate-capdematEnum required-true i18n-mcr.property.prefectPupilDepartment javatype-fr.cg95.cvq.business.users.InseeDepartementCodeType" ><g:capdematEnumToField var="${rqt?.prefectPupilDepartment}" i18nKeyPrefix="mcr.property.prefectPupilDepartment" /></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="mcr.property.professionalSituationInformation.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="mcr.property.childSituation.label" /> * : </dt><dd id="childSituation" class="action-editField validate-capdematEnum required-true i18n-mcr.property.childSituation javatype-fr.cg95.cvq.business.request.military.ChildSituationType" ><g:capdematEnumToField var="${rqt?.childSituation}" i18nKeyPrefix="mcr.property.childSituation" /></dd>
                
                  <dt class="required"><g:message code="mcr.property.childDiploma.label" /> * : </dt><dd id="childDiploma" class="action-editField validate-capdematEnum required-true i18n-mcr.property.childDiploma javatype-fr.cg95.cvq.business.request.military.ChildDiplomaType" ><g:capdematEnumToField var="${rqt?.childDiploma}" i18nKeyPrefix="mcr.property.childDiploma" /></dd>
                
                  <dt class=""><g:message code="mcr.property.childSpeciality.label" />  : </dt><dd id="childSpeciality" class="action-editField validate-string i18n-mcr.property.childSpeciality" ><span>${rqt?.childSpeciality}</span></dd>
                
                  <dt class=""><g:message code="mcr.property.childProfession.label" />  : </dt><dd id="childProfession" class="action-editField validate-string i18n-mcr.property.childProfession" ><span>${rqt?.childProfession}</span></dd>
                
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
          <span><g:message code="mcr.step.exemption.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="mcr.property.japdExemption.label" /> * : </dt><dd id="japdExemption" class="action-editField validate-boolean required-true i18n-mcr.property.japdExemption" ><span class="value-${rqt?.japdExemption}"><g:message code="message.${rqt?.japdExemption ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="mcr.property.highlyInfirm.label" />  : </dt><dd id="highlyInfirm" class="action-editField validate-boolean i18n-mcr.property.highlyInfirm" ><span class="value-${rqt?.highlyInfirm}"><g:message code="message.${rqt?.highlyInfirm ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="mcr.property.affectionOrDisease.label" />  : </dt><dd id="affectionOrDisease" class="action-editField validate-boolean i18n-mcr.property.affectionOrDisease" ><span class="value-${rqt?.affectionOrDisease}"><g:message code="message.${rqt?.affectionOrDisease ? 'yes' : 'no'}" /></span></dd>
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
