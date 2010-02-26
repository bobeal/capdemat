


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="rsr.step.subject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="rsr.step.contact.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="rsr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="rsr.property.rsrSubject.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
          
                
                  <dt class="required"><g:message code="rsr.property.subjectTitle.label" /> * : </dt><dd id="subjectTitle" class="action-editField validate-capdematEnum required-true i18n-rsr.property.subjectTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.subjectTitle}" i18nKeyPrefix="rsr.property.subjectTitle" /></dd>
                
                  <dt class="required"><g:message code="rsr.property.subjectBirthDate.label" /> * : </dt><dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-rsr.property.subjectBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectBirthDate}"/></span></dd>
                
                  <dt class="required"><g:message code="rsr.property.subjectResideWith.label" /> * : </dt><dd id="subjectResideWith" class="action-editField validate-capdematEnum required-true i18n-rsr.property.subjectResideWith javatype-fr.cg95.cvq.business.request.social.RsrSubjectResideWithType" ><g:capdematEnumToField var="${rqt?.subjectResideWith}" i18nKeyPrefix="rsr.property.subjectResideWith" /></dd>
                
                  <dt class="required"><g:message code="rsr.property.subjectIsTaxable.label" /> * : </dt><dd id="subjectIsTaxable" class="action-editField validate-boolean required-true i18n-rsr.property.subjectIsTaxable" ><span class="value-${rqt?.subjectIsTaxable}"><g:message code="message.${rqt?.subjectIsTaxable ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="rsr.property.subjectIsAPABeneficiary.label" /> * : </dt><dd id="subjectIsAPABeneficiary" class="action-editField validate-boolean required-true i18n-rsr.property.subjectIsAPABeneficiary" ><span class="value-${rqt?.subjectIsAPABeneficiary}"><g:message code="message.${rqt?.subjectIsAPABeneficiary ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="rsr.property.subjectIsDisabledPerson.label" /> * : </dt><dd id="subjectIsDisabledPerson" class="action-editField validate-boolean required-true i18n-rsr.property.subjectIsDisabledPerson" ><span class="value-${rqt?.subjectIsDisabledPerson}"><g:message code="message.${rqt?.subjectIsDisabledPerson ? 'yes' : 'no'}" /></span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="rsr.property.requestInformation.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isCoupleRequest-trigger"><g:message code="rsr.property.requestInformationRequestKind.label" /> * : </dt><dd id="requestInformationRequestKind" class="action-editField validate-capdematEnum required-true i18n-rsr.property.requestInformationRequestKind javatype-fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType" ><g:capdematEnumToField var="${rqt?.requestInformationRequestKind}" i18nKeyPrefix="rsr.property.requestInformationRequestKind" /></dd>
                
                  <dt class="required condition-isEmergency-trigger"><g:message code="rsr.property.requestInformationEmergency.label" /> * : </dt><dd id="requestInformationEmergency" class="action-editField validate-boolean required-true i18n-rsr.property.requestInformationEmergency" ><span class="value-${rqt?.requestInformationEmergency}"><g:message code="message.${rqt?.requestInformationEmergency ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required condition-isEmergency-filled"><g:message code="rsr.property.requestInformationEmergencyMotive.label" /> * : </dt><dd id="requestInformationEmergencyMotive" class="action-editField validate-textarea required-true i18n-rsr.property.requestInformationEmergencyMotive rows-3 maxLength-180" ><span>${rqt?.requestInformationEmergencyMotive}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="rsr.property.spouse.label" /></h3>
              <dl class="required condition-isCoupleRequest-filled">
                
                  <dt class="required"><g:message code="rsr.property.spouseLastName.label" /> * : </dt><dd id="spouseLastName" class="action-editField validate-lastName required-true i18n-rsr.property.spouseLastName maxLength-38" ><span>${rqt?.spouseLastName}</span></dd>
                
                  <dt class="required"><g:message code="rsr.property.spouseFirstName.label" /> * : </dt><dd id="spouseFirstName" class="action-editField validate-firstName required-true i18n-rsr.property.spouseFirstName maxLength-38" ><span>${rqt?.spouseFirstName}</span></dd>
                
                  <dt class="required"><g:message code="rsr.property.spouseTitle.label" /> * : </dt><dd id="spouseTitle" class="action-editField validate-capdematEnum required-true i18n-rsr.property.spouseTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.spouseTitle}" i18nKeyPrefix="rsr.property.spouseTitle" /></dd>
                
                  <dt class="required"><g:message code="rsr.property.spouseBirthDate.label" /> * : </dt><dd id="spouseBirthDate" class="action-editField validate-date required-true i18n-rsr.property.spouseBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.spouseBirthDate}"/></span></dd>
                
                  <dt class="required"><g:message code="rsr.property.spouseIsDisabledPerson.label" /> * : </dt><dd id="spouseIsDisabledPerson" class="action-editField validate-boolean required-true i18n-rsr.property.spouseIsDisabledPerson" ><span class="value-${rqt?.spouseIsDisabledPerson}"><g:message code="message.${rqt?.spouseIsDisabledPerson ? 'yes' : 'no'}" /></span></dd>
                
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
          <span><g:message code="rsr.step.contact.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isOtherContact-trigger"><g:message code="rsr.property.contactKind.label" /> * : </dt><dd id="contactKind" class="action-editField validate-capdematEnum required-true i18n-rsr.property.contactKind javatype-fr.cg95.cvq.business.request.social.RsrContactKindType" ><g:capdematEnumToField var="${rqt?.contactKind}" i18nKeyPrefix="rsr.property.contactKind" /></dd>
              </dl>
              
            
              
              <h3><g:message code="rsr.property.firstContact.label" /></h3>
              <dl class="required condition-isOtherContact-filled">
                
                  <dt class="required"><g:message code="rsr.property.contactLastName.label" /> * : </dt><dd id="contactLastName" class="action-editField validate-lastName required-true i18n-rsr.property.contactLastName maxLength-38" ><span>${rqt?.contactLastName}</span></dd>
                
                  <dt class="required"><g:message code="rsr.property.contactFirstName.label" /> * : </dt><dd id="contactFirstName" class="action-editField validate-firstName required-true i18n-rsr.property.contactFirstName maxLength-38" ><span>${rqt?.contactFirstName}</span></dd>
                
                  <dt class="required"><g:message code="rsr.property.contactPhone.label" /> * : </dt><dd id="contactPhone" class="action-editField validate-phone required-true i18n-rsr.property.contactPhone maxLength-10" ><span>${rqt?.contactPhone}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="rsr.property.secondContact.label" /></h3>
              <dl class="required condition-isOtherContact-filled">
                
                  <dt class=""><g:message code="rsr.property.secondContactLastName.label" />  : </dt><dd id="secondContactLastName" class="action-editField validate-lastName i18n-rsr.property.secondContactLastName maxLength-38" ><span>${rqt?.secondContactLastName}</span></dd>
                
                  <dt class=""><g:message code="rsr.property.secondContactFirstName.label" />  : </dt><dd id="secondContactFirstName" class="action-editField validate-firstName i18n-rsr.property.secondContactFirstName maxLength-38" ><span>${rqt?.secondContactFirstName}</span></dd>
                
                  <dt class=""><g:message code="rsr.property.secondContactPhone.label" />  : </dt><dd id="secondContactPhone" class="action-editField validate-phone i18n-rsr.property.secondContactPhone maxLength-10" ><span>${rqt?.secondContactPhone}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="rsr.property.trustee.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="rsr.property.trusteeLastName.label" />  : </dt><dd id="trusteeLastName" class="action-editField validate-lastName i18n-rsr.property.trusteeLastName maxLength-38" ><span>${rqt?.trusteeLastName}</span></dd>
                
                  <dt class=""><g:message code="rsr.property.trusteeFirstName.label" />  : </dt><dd id="trusteeFirstName" class="action-editField validate-firstName i18n-rsr.property.trusteeFirstName maxLength-38" ><span>${rqt?.trusteeFirstName}</span></dd>
                
                  <dt class=""><g:message code="rsr.property.trusteePhone.label" />  : </dt><dd id="trusteePhone" class="action-editField validate-phone i18n-rsr.property.trusteePhone maxLength-10" ><span>${rqt?.trusteePhone}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
