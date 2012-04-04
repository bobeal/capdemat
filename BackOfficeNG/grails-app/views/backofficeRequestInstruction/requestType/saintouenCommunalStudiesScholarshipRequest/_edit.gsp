


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="scssr.step.subject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="scssr.step.schoolingInformation.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="scssr.step.bankReference.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page5"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="scssr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.subjectBirthDate.label" /> * : </dt><dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-scssr.property.subjectBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectBirthDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.subjectDomiciliationDate.label" /> * : </dt><dd id="subjectDomiciliationDate" class="action-editField validate-date required-true i18n-scssr.property.subjectDomiciliationDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectDomiciliationDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isOtherSituation-trigger"><g:message code="scssr.property.isOtherSituation.label" /> * : </dt><dd id="isOtherSituation" class="action-editField validate-capdematEnum required-true i18n-scssr.property.isOtherSituation javatype-fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType" ><g:capdematEnumToField var="${rqt?.isOtherSituation}" i18nKeyPrefix="scssr.property.isOtherSituation" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isOtherSituation-filled"><g:message code="scssr.property.saintOuenOtherSituationDetails.label" /> * : </dt><dd id="saintOuenOtherSituationDetails" class="action-editField validate-string required-true i18n-scssr.property.saintOuenOtherSituationDetails" ><span>${rqt?.saintOuenOtherSituationDetails}</span></dd>
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
          <span><g:message code="scssr.step.schoolingInformation.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.saintOuenEstablishmentLabel.label" /> * : </dt><dd id="saintOuenEstablishmentLabel" class="action-editField validate-string required-true i18n-scssr.property.saintOuenEstablishmentLabel" ><span>${rqt?.saintOuenEstablishmentLabel}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-saintOuenIsInOtherStudies-trigger"><g:message code="scssr.property.saintOuenIsInOtherStudies.label" /> * : </dt><dd id="saintOuenIsInOtherStudies" class="action-editField validate-capdematEnum required-true i18n-scssr.property.saintOuenIsInOtherStudies javatype-fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType" ><g:capdematEnumToField var="${rqt?.saintOuenIsInOtherStudies}" i18nKeyPrefix="scssr.property.saintOuenIsInOtherStudies" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.saintOuenCurrentStudiesLevel.label" /> * : </dt><dd id="saintOuenCurrentStudiesLevel" class="action-editField validate-capdematEnum required-true i18n-scssr.property.saintOuenCurrentStudiesLevel javatype-fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType" ><g:capdematEnumToField var="${rqt?.saintOuenCurrentStudiesLevel}" i18nKeyPrefix="scssr.property.saintOuenCurrentStudiesLevel" /></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-saintOuenIsInOtherStudies-filled"><g:message code="scssr.property.saintOuenOtherStudiesLabel.label" /> * : </dt><dd id="saintOuenOtherStudiesLabel" class="action-editField validate-string required-true i18n-scssr.property.saintOuenOtherStudiesLabel" ><span>${rqt?.saintOuenOtherStudiesLabel}</span></dd>
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
          <span><g:message code="scssr.step.bankReference.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-trigger"><g:message code="scssr.property.isSubjectAccountHolder.label" /> * : </dt><dd id="isSubjectAccountHolder" class="action-editField validate-boolean required-true i18n-scssr.property.isSubjectAccountHolder" ><span class="value-${rqt?.isSubjectAccountHolder}"><g:message code="message.${rqt?.isSubjectAccountHolder ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="scssr.property.accountHolderTitle.label" /> * : </dt><dd id="accountHolderTitle" class="action-editField validate-capdematEnum required-true i18n-scssr.property.accountHolderTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.accountHolderTitle}" i18nKeyPrefix="scssr.property.accountHolderTitle" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="scssr.property.accountHolderLastName.label" /> * : </dt><dd id="accountHolderLastName" class="action-editField validate-lastName required-true i18n-scssr.property.accountHolderLastName maxLength-38" ><span>${rqt?.accountHolderLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="scssr.property.accountHolderFirstName.label" /> * : </dt><dd id="accountHolderFirstName" class="action-editField validate-firstName required-true i18n-scssr.property.accountHolderFirstName maxLength-38" ><span>${rqt?.accountHolderFirstName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isSubjectAccountHolder-unfilled"><g:message code="scssr.property.accountHolderBirthDate.label" /> * : </dt><dd id="accountHolderBirthDate" class="action-editField validate-date required-true i18n-scssr.property.accountHolderBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.accountHolderBirthDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.bankAccount.label" /> * : </dt><dd id="bankAccount" class="action-editField validate-bankAccount required-true i18n-scssr.property.bankAccount" ><div><p>${rqt?.bankAccount?.BIC}</p><p>${rqt?.bankAccount?.IBAN}</p></div></dd>
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
          <span><g:message code="request.step.administration.label" /></span>
        </h2>
        <div class="yui-g">
          
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.montantBourse.label" /> * : </dt><dd id="montantBourse" class="action-editField validate-string required-true i18n-scssr.property.montantBourse" ><span>${rqt?.montantBourse}</span></dd>
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
