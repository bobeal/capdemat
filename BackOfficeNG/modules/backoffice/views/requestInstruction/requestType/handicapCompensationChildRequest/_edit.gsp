

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="hccr.step.subject.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="hccr.step.dwelling.label" /></em></a>
    </li>
  
    <li>
      <a href="#page2"><em><g:message code="hccr.step.socialSecurityAndPaymentAgency.label" /></em></a>
    </li>
  
    <li>
      <a href="#page3"><em><g:message code="hccr.step.occupationnalAndSchoolStatus.label" /></em></a>
    </li>
  
    <li>
      <a href="#page4"><em><g:message code="hccr.step.folders.label" /></em></a>
    </li>
  
    <li>
      <a href="#page5"><em><g:message code="hccr.step.benefits.label" /></em></a>
    </li>
  
    <li>
      <a href="#page6"><em><g:message code="hccr.step.aid.label" /></em></a>
    </li>
  
    <li>
      <a href="#page7"><em><g:message code="hccr.step.health.label" /></em></a>
    </li>
  
    <li>
      <a href="#page8"><em><g:message code="hccr.step.project.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
    <!-- step start -->
    <div id="page0">
      <h2><g:message code="property.form" />
        <span><g:message code="hccr.step.subject.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hccr.property.hccrSubject.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isLessThan18-trigger"><g:message code="hccr.property.subjectBirthDate.label" /> * : </dt>
                  <dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-hccr.property.subjectBirthDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.subjectBirthDate}"/></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.subjectBirthCity.label" /> * : </dt>
                  <dd id="subjectBirthCity" class="action-editField validate-city required-true i18n-hccr.property.subjectBirthCity" >
                    <span>${request?.subjectBirthCity}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.subjectBirthCountry.label" /> * : </dt>
                  <dd id="subjectBirthCountry" class="action-editField validate- required-true i18n-hccr.property.subjectBirthCountry" >
                    <span>${request?.subjectBirthCountry}</span>
                  </dd>
                
                  <dt class="required condition-isLessThan18-filled"><g:message code="hccr.property.subjectParentalAuthorityHolder.label" /> * : </dt>
                  <dd id="subjectParentalAuthorityHolder" class="action-editField validate-capdematEnum required-true i18n-hccr.property.subjectParentalAuthorityHolder javatype-fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType" >
                    <g:capdematEnumToField var="${request?.subjectParentalAuthorityHolder}" i18nKeyPrefix="hccr.property.subjectParentalAuthorityHolder" />
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hccr.property.father.label" /></h3>
              <dl class="required condition-isLessThan18-filled">
                
                  <dt class=""><g:message code="hccr.property.fatherLastName.label" />  : </dt>
                  <dd id="fatherLastName" class="action-editField validate-lastName i18n-hccr.property.fatherLastName" >
                    <span>${request?.fatherLastName}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.fatherFirstName.label" />  : </dt>
                  <dd id="fatherFirstName" class="action-editField validate-firstName i18n-hccr.property.fatherFirstName" >
                    <span>${request?.fatherFirstName}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.fatherJob.label" />  : </dt>
                  <dd id="fatherJob" class="action-editField validate- i18n-hccr.property.fatherJob" >
                    <span>${request?.fatherJob}</span>
                  </dd>
                
                  <dt class="condition-isFatherActivityReduction-trigger"><g:message code="hccr.property.fatherActivityReduction.label" />  : </dt>
                  <dd id="fatherActivityReduction" class="action-editField validate-boolean i18n-hccr.property.fatherActivityReduction" >
                    <span class="value-${request?.fatherActivityReduction}"><g:message code="message.${request?.fatherActivityReduction ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isFatherActivityReduction-filled"><g:message code="hccr.property.fatherActivityReductionRatio.label" />  : </dt>
                  <dd id="fatherActivityReductionRatio" class="action-editField validate-positiveInteger i18n-hccr.property.fatherActivityReductionRatio" >
                    <span>${request?.fatherActivityReductionRatio}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hccr.property.mother.label" /></h3>
              <dl class="required condition-isLessThan18-filled">
                
                  <dt class=""><g:message code="hccr.property.motherLastName.label" />  : </dt>
                  <dd id="motherLastName" class="action-editField validate-lastName i18n-hccr.property.motherLastName" >
                    <span>${request?.motherLastName}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.motherFirstName.label" />  : </dt>
                  <dd id="motherFirstName" class="action-editField validate-firstName i18n-hccr.property.motherFirstName" >
                    <span>${request?.motherFirstName}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.motherJob.label" />  : </dt>
                  <dd id="motherJob" class="action-editField validate- i18n-hccr.property.motherJob" >
                    <span>${request?.motherJob}</span>
                  </dd>
                
                  <dt class="condition-isMotherActivityReduction-trigger"><g:message code="hccr.property.motherActivityReduction.label" />  : </dt>
                  <dd id="motherActivityReduction" class="action-editField validate-boolean i18n-hccr.property.motherActivityReduction" >
                    <span class="value-${request?.motherActivityReduction}"><g:message code="message.${request?.motherActivityReduction ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isMotherActivityReduction-filled"><g:message code="hccr.property.motherActivityReductionRatio.label" />  : </dt>
                  <dd id="motherActivityReductionRatio" class="action-editField validate-positiveInteger i18n-hccr.property.motherActivityReductionRatio" >
                    <span>${request?.motherActivityReductionRatio}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hccr.property.aseReferent.label" /></h3>
              <dl class="required condition-isLessThan18-filled">
                
                  <dt class=""><g:message code="hccr.property.aseReferentLastName.label" />  : </dt>
                  <dd id="aseReferentLastName" class="action-editField validate-lastName i18n-hccr.property.aseReferentLastName" >
                    <span>${request?.aseReferentLastName}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.aseReferentDepartment.label" />  : </dt>
                  <dd id="aseReferentDepartment" class="action-editField validate-departmentCode i18n-hccr.property.aseReferentDepartment" >
                    <span>${request?.aseReferentDepartment}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hccr.property.referent.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="hccr.property.referentLastName.label" /> * : </dt>
                  <dd id="referentLastName" class="action-editField validate-lastName required-true i18n-hccr.property.referentLastName" >
                    <span>${request?.referentLastName}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.referentFirstName.label" /> * : </dt>
                  <dd id="referentFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.referentFirstName" >
                    <span>${request?.referentFirstName}</span>
                  </dd>
                
                  <dt class="required condition-isReferentMadam-trigger"><g:message code="hccr.property.referentTitle.label" /> * : </dt>
                  <dd id="referentTitle" class="action-editField validate-capdematEnum required-true i18n-hccr.property.referentTitle javatype-fr.cg95.cvq.business.users.TitleType" >
                    <g:capdematEnumToField var="${request?.referentTitle}" i18nKeyPrefix="hccr.property.referentTitle" />
                  </dd>
                
                  <dt class="required condition-isReferentMadam-filled"><g:message code="hccr.property.referentMaidenName.label" /> * : </dt>
                  <dd id="referentMaidenName" class="action-editField validate-lastName required-true i18n-hccr.property.referentMaidenName" >
                    <span>${request?.referentMaidenName}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.referentBirthDate.label" /> * : </dt>
                  <dd id="referentBirthDate" class="action-editField validate-date required-true i18n-hccr.property.referentBirthDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.referentBirthDate}"/></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.referentBirthCity.label" /> * : </dt>
                  <dd id="referentBirthCity" class="action-editField validate-city required-true i18n-hccr.property.referentBirthCity" >
                    <span>${request?.referentBirthCity}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.referentBirthCountry.label" /> * : </dt>
                  <dd id="referentBirthCountry" class="action-editField validate- required-true i18n-hccr.property.referentBirthCountry" >
                    <span>${request?.referentBirthCountry}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.referentFamilyStatus.label" /> * : </dt>
                  <dd id="referentFamilyStatus" class="action-editField validate-capdematEnum required-true i18n-hccr.property.referentFamilyStatus javatype-fr.cg95.cvq.business.users.FamilyStatusType" >
                    <g:capdematEnumToField var="${request?.referentFamilyStatus}" i18nKeyPrefix="hccr.property.referentFamilyStatus" />
                  </dd>
                
                  <dt class="required condition-isReferentFamilyDependents-trigger"><g:message code="hccr.property.referentFamilyDependents.label" /> * : </dt>
                  <dd id="referentFamilyDependents" class="action-editField validate-boolean required-true i18n-hccr.property.referentFamilyDependents" >
                    <span class="value-${request?.referentFamilyDependents}"><g:message code="message.${request?.referentFamilyDependents ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-familyDependents">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/familyDependents" model="['request':request]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page1">
      <h2><g:message code="property.form" />
        <span><g:message code="hccr.step.dwelling.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hccr.property.dwelling.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isNotPlaceOfResidence-trigger"><g:message code="hccr.property.dwellingKind.label" /> * : </dt>
                  <dd id="dwellingKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.dwellingKind javatype-fr.cg95.cvq.business.request.social.HccrDwellingKindType" >
                    <g:capdematEnumToField var="${request?.dwellingKind}" i18nKeyPrefix="hccr.property.dwellingKind" />
                  </dd>
                
                  <dt class="required condition-isNotPlaceOfResidence-filled"><g:message code="hccr.property.dwellingPrecision.label" /> * : </dt>
                  <dd id="dwellingPrecision" class="action-editField validate- required-true i18n-hccr.property.dwellingPrecision" >
                    <span>${request?.dwellingPrecision}</span>
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-trigger"><g:message code="hccr.property.dwellingEstablishmentReception.label" /> * : </dt>
                  <dd id="dwellingEstablishmentReception" class="action-editField validate-boolean required-true i18n-hccr.property.dwellingEstablishmentReception" >
                    <span class="value-${request?.dwellingEstablishmentReception}"><g:message code="message.${request?.dwellingEstablishmentReception ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hccr.property.dwellingReceptionType.label" /> * : </dt>
                  <dd id="dwellingReceptionType" class="action-editField validate-capdematEnum required-true i18n-hccr.property.dwellingReceptionType javatype-fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType" >
                    <g:capdematEnumToField var="${request?.dwellingReceptionType}" i18nKeyPrefix="hccr.property.dwellingReceptionType" />
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hccr.property.dwellingReceptionNaming.label" /> * : </dt>
                  <dd id="dwellingReceptionNaming" class="action-editField validate- required-true i18n-hccr.property.dwellingReceptionNaming" >
                    <span>${request?.dwellingReceptionNaming}</span>
                  </dd>
                
                  <dt class="required condition-isInEstablishmentReception-filled"><g:message code="hccr.property.dwellingReceptionAddress.label" /> * : </dt>
                  <dd id="dwellingReceptionAddress" class="action-editField validate-address required-true i18n-hccr.property.dwellingReceptionAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dwellingReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dwellingReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dwellingReceptionAddress?.streetNumber}</span> <span class="streetName">${request?.dwellingReceptionAddress?.streetName}</span><p class="placeNameOrService">${request?.dwellingReceptionAddress?.placeNameOrService}</p><span class="postalCode">${request?.dwellingReceptionAddress?.postalCode}</span> <span class="city">${request?.dwellingReceptionAddress?.city}</span><p class="countryName">${request?.dwellingReceptionAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isInSocialReception-trigger"><g:message code="hccr.property.dwellingSocialReception.label" /> * : </dt>
                  <dd id="dwellingSocialReception" class="action-editField validate-boolean required-true i18n-hccr.property.dwellingSocialReception" >
                    <span class="value-${request?.dwellingSocialReception}"><g:message code="message.${request?.dwellingSocialReception ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isInSocialReception-filled"><g:message code="hccr.property.dwellingSocialReceptionNaming.label" /> * : </dt>
                  <dd id="dwellingSocialReceptionNaming" class="action-editField validate- required-true i18n-hccr.property.dwellingSocialReceptionNaming" >
                    <span>${request?.dwellingSocialReceptionNaming}</span>
                  </dd>
                
                  <dt class="required condition-isInSocialReception-filled"><g:message code="hccr.property.dwellingSocialReceptionAddress.label" /> * : </dt>
                  <dd id="dwellingSocialReceptionAddress" class="action-editField validate-address required-true i18n-hccr.property.dwellingSocialReceptionAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.dwellingSocialReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.dwellingSocialReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.dwellingSocialReceptionAddress?.streetNumber}</span> <span class="streetName">${request?.dwellingSocialReceptionAddress?.streetName}</span><p class="placeNameOrService">${request?.dwellingSocialReceptionAddress?.placeNameOrService}</p><span class="postalCode">${request?.dwellingSocialReceptionAddress?.postalCode}</span> <span class="city">${request?.dwellingSocialReceptionAddress?.city}</span><p class="countryName">${request?.dwellingSocialReceptionAddress?.countryName}</p></div>
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
    <div id="page2">
      <h2><g:message code="property.form" />
        <span><g:message code="hccr.step.socialSecurityAndPaymentAgency.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hccr.property.socialSecurity.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isSocialSecurityMemberShip-trigger"><g:message code="hccr.property.socialSecurityMemberShipKind.label" /> * : </dt>
                  <dd id="socialSecurityMemberShipKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.socialSecurityMemberShipKind javatype-fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType" >
                    <g:capdematEnumToField var="${request?.socialSecurityMemberShipKind}" i18nKeyPrefix="hccr.property.socialSecurityMemberShipKind" />
                  </dd>
                
                  <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityNumber.label" /> * : </dt>
                  <dd id="socialSecurityNumber" class="action-editField validate- required-true i18n-hccr.property.socialSecurityNumber" >
                    <span>${request?.socialSecurityNumber}</span>
                  </dd>
                
                  <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityAgencyName.label" /> * : </dt>
                  <dd id="socialSecurityAgencyName" class="action-editField validate- required-true i18n-hccr.property.socialSecurityAgencyName" >
                    <span>${request?.socialSecurityAgencyName}</span>
                  </dd>
                
                  <dt class="required condition-isSocialSecurityMemberShip-filled"><g:message code="hccr.property.socialSecurityAgencyAddress.label" /> * : </dt>
                  <dd id="socialSecurityAgencyAddress" class="action-editField validate-address required-true i18n-hccr.property.socialSecurityAgencyAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.socialSecurityAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.socialSecurityAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.socialSecurityAgencyAddress?.streetNumber}</span> <span class="streetName">${request?.socialSecurityAgencyAddress?.streetName}</span><p class="placeNameOrService">${request?.socialSecurityAgencyAddress?.placeNameOrService}</p><span class="postalCode">${request?.socialSecurityAgencyAddress?.postalCode}</span> <span class="city">${request?.socialSecurityAgencyAddress?.city}</span><p class="countryName">${request?.socialSecurityAgencyAddress?.countryName}</p></div>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hccr.property.paymentAgency.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-trigger"><g:message code="hccr.property.paymentAgencyBeneficiary.label" /> * : </dt>
                  <dd id="paymentAgencyBeneficiary" class="action-editField validate-capdematEnum required-true i18n-hccr.property.paymentAgencyBeneficiary javatype-fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType" >
                    <g:capdematEnumToField var="${request?.paymentAgencyBeneficiary}" i18nKeyPrefix="hccr.property.paymentAgencyBeneficiary" />
                  </dd>
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyBeneficiaryNumber.label" /> * : </dt>
                  <dd id="paymentAgencyBeneficiaryNumber" class="action-editField validate- required-true i18n-hccr.property.paymentAgencyBeneficiaryNumber" >
                    <span>${request?.paymentAgencyBeneficiaryNumber}</span>
                  </dd>
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyName.label" /> * : </dt>
                  <dd id="paymentAgencyName" class="action-editField validate- required-true i18n-hccr.property.paymentAgencyName" >
                    <span>${request?.paymentAgencyName}</span>
                  </dd>
                
                  <dt class="required condition-isPaymentAgencyBeneficiary-filled"><g:message code="hccr.property.paymentAgencyAddress.label" /> * : </dt>
                  <dd id="paymentAgencyAddress" class="action-editField validate-address required-true i18n-hccr.property.paymentAgencyAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.paymentAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.paymentAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.paymentAgencyAddress?.streetNumber}</span> <span class="streetName">${request?.paymentAgencyAddress?.streetName}</span><p class="placeNameOrService">${request?.paymentAgencyAddress?.placeNameOrService}</p><span class="postalCode">${request?.paymentAgencyAddress?.postalCode}</span> <span class="city">${request?.paymentAgencyAddress?.city}</span><p class="countryName">${request?.paymentAgencyAddress?.countryName}</p></div>
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
        <span><g:message code="hccr.step.occupationnalAndSchoolStatus.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hccr.property.schooling.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isSchoolingEnrolment-trigger"><g:message code="hccr.property.schoolingEnrolment.label" /> * : </dt>
                  <dd id="schoolingEnrolment" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingEnrolment" >
                    <span class="value-${request?.schoolingEnrolment}"><g:message code="message.${request?.schoolingEnrolment ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolName.label" /> * : </dt>
                  <dd id="schoolingSchoolName" class="action-editField validate- required-true i18n-hccr.property.schoolingSchoolName" >
                    <span>${request?.schoolingSchoolName}</span>
                  </dd>
                
                  <dt class="required condition-isSchoolingEnrolment-filled"><g:message code="hccr.property.schoolingSchoolAddress.label" /> * : </dt>
                  <dd id="schoolingSchoolAddress" class="action-editField validate-address required-true i18n-hccr.property.schoolingSchoolAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.schoolingSchoolAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.schoolingSchoolAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.schoolingSchoolAddress?.streetNumber}</span> <span class="streetName">${request?.schoolingSchoolAddress?.streetName}</span><p class="placeNameOrService">${request?.schoolingSchoolAddress?.placeNameOrService}</p><span class="postalCode">${request?.schoolingSchoolAddress?.postalCode}</span> <span class="city">${request?.schoolingSchoolAddress?.city}</span><p class="countryName">${request?.schoolingSchoolAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isSentToSchool-trigger"><g:message code="hccr.property.schoolingSendToSchool.label" /> * : </dt>
                  <dd id="schoolingSendToSchool" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingSendToSchool" >
                    <span class="value-${request?.schoolingSendToSchool}"><g:message code="message.${request?.schoolingSendToSchool ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSentToSchool-filled"><g:message code="hccr.property.schoolingAttendedGrade.label" /> * : </dt>
                  <dd id="schoolingAttendedGrade" class="action-editField validate-capdematEnum required-true i18n-hccr.property.schoolingAttendedGrade javatype-fr.cg95.cvq.business.users.SectionType" >
                    <g:capdematEnumToField var="${request?.schoolingAttendedGrade}" i18nKeyPrefix="hccr.property.schoolingAttendedGrade" />
                  </dd>
                
                  <dt class="required condition-isSpecializedGrade-trigger"><g:message code="hccr.property.schoolingSpecializedGrade.label" /> * : </dt>
                  <dd id="schoolingSpecializedGrade" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingSpecializedGrade" >
                    <span class="value-${request?.schoolingSpecializedGrade}"><g:message code="message.${request?.schoolingSpecializedGrade ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSpecializedGrade-filled"><g:message code="hccr.property.schoolingSpecializedGradeDetails.label" /> * : </dt>
                  <dd id="schoolingSpecializedGradeDetails" class="action-editField validate- required-true i18n-hccr.property.schoolingSpecializedGradeDetails" >
                    <span>${request?.schoolingSpecializedGradeDetails}</span>
                  </dd>
                
                  <dt class="required condition-isPartTimeSchooling-trigger"><g:message code="hccr.property.schoolingSchoolingKind.label" /> * : </dt>
                  <dd id="schoolingSchoolingKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.schoolingSchoolingKind javatype-fr.cg95.cvq.business.request.social.HccrSchoolingKindType" >
                    <g:capdematEnumToField var="${request?.schoolingSchoolingKind}" i18nKeyPrefix="hccr.property.schoolingSchoolingKind" />
                  </dd>
                
                  <dt class="required condition-isPartTimeSchooling-filled"><g:message code="hccr.property.schoolingTime.label" /> * : </dt>
                  <dd id="schoolingTime" class="action-editField validate- required-true i18n-hccr.property.schoolingTime" >
                    <span>${request?.schoolingTime}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.schoolingHomeSchooling.label" /> * : </dt>
                  <dd id="schoolingHomeSchooling" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingHomeSchooling" >
                    <span class="value-${request?.schoolingHomeSchooling}"><g:message code="message.${request?.schoolingHomeSchooling ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.schoolingPersonalizedSchoolingPlan.label" /> * : </dt>
                  <dd id="schoolingPersonalizedSchoolingPlan" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingPersonalizedSchoolingPlan" >
                    <span class="value-${request?.schoolingPersonalizedSchoolingPlan}"><g:message code="message.${request?.schoolingPersonalizedSchoolingPlan ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isAccompaniedHomeSchooling-trigger"><g:message code="hccr.property.schoolingHomeSchoolingKind.label" /> * : </dt>
                  <dd id="schoolingHomeSchoolingKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.schoolingHomeSchoolingKind javatype-fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType" >
                    <g:capdematEnumToField var="${request?.schoolingHomeSchoolingKind}" i18nKeyPrefix="hccr.property.schoolingHomeSchoolingKind" />
                  </dd>
                
                  <dt class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistLastName.label" /> * : </dt>
                  <dd id="schoolingHomeSchoolingAccompanistLastName" class="action-editField validate-lastName required-true i18n-hccr.property.schoolingHomeSchoolingAccompanistLastName" >
                    <span>${request?.schoolingHomeSchoolingAccompanistLastName}</span>
                  </dd>
                
                  <dt class="required condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistFirstName.label" /> * : </dt>
                  <dd id="schoolingHomeSchoolingAccompanistFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.schoolingHomeSchoolingAccompanistFirstName" >
                    <span>${request?.schoolingHomeSchoolingAccompanistFirstName}</span>
                  </dd>
                
                  <dt class="condition-isAccompaniedHomeSchooling-filled"><g:message code="hccr.property.schoolingHomeSchoolingAccompanistAddress.label" />  : </dt>
                  <dd id="schoolingHomeSchoolingAccompanistAddress" class="action-editField validate-address i18n-hccr.property.schoolingHomeSchoolingAccompanistAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.schoolingHomeSchoolingAccompanistAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.schoolingHomeSchoolingAccompanistAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.schoolingHomeSchoolingAccompanistAddress?.streetNumber}</span> <span class="streetName">${request?.schoolingHomeSchoolingAccompanistAddress?.streetName}</span><p class="placeNameOrService">${request?.schoolingHomeSchoolingAccompanistAddress?.placeNameOrService}</p><span class="postalCode">${request?.schoolingHomeSchoolingAccompanistAddress?.postalCode}</span> <span class="city">${request?.schoolingHomeSchoolingAccompanistAddress?.city}</span><p class="countryName">${request?.schoolingHomeSchoolingAccompanistAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isExtraCurricular-trigger"><g:message code="hccr.property.schoolingExtraCurricular.label" /> * : </dt>
                  <dd id="schoolingExtraCurricular" class="action-editField validate-boolean required-true i18n-hccr.property.schoolingExtraCurricular" >
                    <span class="value-${request?.schoolingExtraCurricular}"><g:message code="message.${request?.schoolingExtraCurricular ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isExtraCurricular-filled"><g:message code="hccr.property.schoolingExtraCurricularDetails.label" /> * : </dt>
                  <dd id="schoolingExtraCurricularDetails" class="action-editField validate- required-true i18n-hccr.property.schoolingExtraCurricularDetails" >
                    <span>${request?.schoolingExtraCurricularDetails}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hccr.property.studies.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isHighSchool-trigger"><g:message code="hccr.property.studiesHighSchool.label" /> * : </dt>
                  <dd id="studiesHighSchool" class="action-editField validate-boolean required-true i18n-hccr.property.studiesHighSchool" >
                    <span class="value-${request?.studiesHighSchool}"><g:message code="message.${request?.studiesHighSchool ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolGrade.label" /> * : </dt>
                  <dd id="studiesHighSchoolGrade" class="action-editField validate- required-true i18n-hccr.property.studiesHighSchoolGrade" >
                    <span>${request?.studiesHighSchoolGrade}</span>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolName.label" /> * : </dt>
                  <dd id="studiesHighSchoolName" class="action-editField validate- required-true i18n-hccr.property.studiesHighSchoolName" >
                    <span>${request?.studiesHighSchoolName}</span>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled"><g:message code="hccr.property.studiesHighSchoolAddress.label" /> * : </dt>
                  <dd id="studiesHighSchoolAddress" class="action-editField validate-address required-true i18n-hccr.property.studiesHighSchoolAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.studiesHighSchoolAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.studiesHighSchoolAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.studiesHighSchoolAddress?.streetNumber}</span> <span class="streetName">${request?.studiesHighSchoolAddress?.streetName}</span><p class="placeNameOrService">${request?.studiesHighSchoolAddress?.placeNameOrService}</p><span class="postalCode">${request?.studiesHighSchoolAddress?.postalCode}</span> <span class="city">${request?.studiesHighSchoolAddress?.city}</span><p class="countryName">${request?.studiesHighSchoolAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger"><g:message code="hccr.property.studiesAssistanceUnderDisability.label" /> * : </dt>
                  <dd id="studiesAssistanceUnderDisability" class="action-editField validate-boolean required-true i18n-hccr.property.studiesAssistanceUnderDisability" >
                    <span class="value-${request?.studiesAssistanceUnderDisability}"><g:message code="message.${request?.studiesAssistanceUnderDisability ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isAssistanceUnderDisability-filled"><g:message code="hccr.property.studiesAssistanceUnderDisabilityDetails.label" /> * : </dt>
                  <dd id="studiesAssistanceUnderDisabilityDetails" class="action-editField validate- required-true i18n-hccr.property.studiesAssistanceUnderDisabilityDetails" >
                    <span>${request?.studiesAssistanceUnderDisabilityDetails}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hccr.property.formation.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="hccr.property.formationStudiesLevel.label" />  : </dt>
                  <dd id="formationStudiesLevel" class="action-editField validate- i18n-hccr.property.formationStudiesLevel" >
                    <span>${request?.formationStudiesLevel}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.formationDiploma.label" />  : </dt>
                  <dd id="formationDiploma" class="action-editField validate- i18n-hccr.property.formationDiploma" >
                    <span>${request?.formationDiploma}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.formationPreviousFormation.label" />  : </dt>
                  <dd id="formationPreviousFormation" class="action-editField validate- i18n-hccr.property.formationPreviousFormation" >
                    <span>${request?.formationPreviousFormation}</span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.formationCurrentFormation.label" />  : </dt>
                  <dd id="formationCurrentFormation" class="action-editField validate- i18n-hccr.property.formationCurrentFormation" >
                    <span>${request?.formationCurrentFormation}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hccr.property.professionalStatus.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isEmployed-trigger condition-isUnemployed-trigger"><g:message code="hccr.property.professionalStatusKind.label" /> * : </dt>
                  <dd id="professionalStatusKind" class="action-editField validate-capdematEnum required-true i18n-hccr.property.professionalStatusKind javatype-fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType" >
                    <g:capdematEnumToField var="${request?.professionalStatusKind}" i18nKeyPrefix="hccr.property.professionalStatusKind" />
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.professionalStatusDate.label" /> * : </dt>
                  <dd id="professionalStatusDate" class="action-editField validate-date required-true i18n-hccr.property.professionalStatusDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.professionalStatusDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEnvironment.label" /> * : </dt>
                  <dd id="professionalStatusEnvironment" class="action-editField validate-capdematEnum required-true i18n-hccr.property.professionalStatusEnvironment javatype-fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType" >
                    <g:capdematEnumToField var="${request?.professionalStatusEnvironment}" i18nKeyPrefix="hccr.property.professionalStatusEnvironment" />
                  </dd>
                
                  <dt class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusProfession.label" /> * : </dt>
                  <dd id="professionalStatusProfession" class="action-editField validate- required-true i18n-hccr.property.professionalStatusProfession" >
                    <span>${request?.professionalStatusProfession}</span>
                  </dd>
                
                  <dt class="required condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusEmployerName.label" /> * : </dt>
                  <dd id="professionalStatusEmployerName" class="action-editField validate-lastName required-true i18n-hccr.property.professionalStatusEmployerName" >
                    <span>${request?.professionalStatusEmployerName}</span>
                  </dd>
                
                  <dt class="condition-isEmployed-filled"><g:message code="hccr.property.professionalStatusAddress.label" />  : </dt>
                  <dd id="professionalStatusAddress" class="action-editField validate-address i18n-hccr.property.professionalStatusAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.professionalStatusAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.professionalStatusAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.professionalStatusAddress?.streetNumber}</span> <span class="streetName">${request?.professionalStatusAddress?.streetName}</span><p class="placeNameOrService">${request?.professionalStatusAddress?.placeNameOrService}</p><span class="postalCode">${request?.professionalStatusAddress?.postalCode}</span> <span class="city">${request?.professionalStatusAddress?.city}</span><p class="countryName">${request?.professionalStatusAddress?.countryName}</p></div>
                  </dd>
                
                  <dt class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger"><g:message code="hccr.property.professionalStatusRegisterAsUnemployed.label" /> * : </dt>
                  <dd id="professionalStatusRegisterAsUnemployed" class="action-editField validate-boolean required-true i18n-hccr.property.professionalStatusRegisterAsUnemployed" >
                    <span class="value-${request?.professionalStatusRegisterAsUnemployed}"><g:message code="message.${request?.professionalStatusRegisterAsUnemployed ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isRegisteredAsUnemployed-filled"><g:message code="hccr.property.professionalStatusRegisterAsUnemployedDate.label" /> * : </dt>
                  <dd id="professionalStatusRegisterAsUnemployedDate" class="action-editField validate-date required-true i18n-hccr.property.professionalStatusRegisterAsUnemployedDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.professionalStatusRegisterAsUnemployedDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isUnemployed-filled condition-isIndemnified-trigger"><g:message code="hccr.property.professionalStatusIndemnified.label" /> * : </dt>
                  <dd id="professionalStatusIndemnified" class="action-editField validate-boolean required-true i18n-hccr.property.professionalStatusIndemnified" >
                    <span class="value-${request?.professionalStatusIndemnified}"><g:message code="message.${request?.professionalStatusIndemnified ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isIndemnified-filled"><g:message code="hccr.property.professionalStatusIndemnifiedDate.label" /> * : </dt>
                  <dd id="professionalStatusIndemnifiedDate" class="action-editField validate-date required-true i18n-hccr.property.professionalStatusIndemnifiedDate" >
                    <span><g:formatDate formatName="format.date" date="${request?.professionalStatusIndemnifiedDate}"/></span>
                  </dd>
                
                  <dt class="required condition-isElectiveFunction-trigger"><g:message code="hccr.property.professionalStatusElectiveFunction.label" /> * : </dt>
                  <dd id="professionalStatusElectiveFunction" class="action-editField validate-boolean required-true i18n-hccr.property.professionalStatusElectiveFunction" >
                    <span class="value-${request?.professionalStatusElectiveFunction}"><g:message code="message.${request?.professionalStatusElectiveFunction ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isElectiveFunction-filled"><g:message code="hccr.property.professionalStatusElectiveFunctionDetails.label" /> * : </dt>
                  <dd id="professionalStatusElectiveFunctionDetails" class="action-editField validate- required-true i18n-hccr.property.professionalStatusElectiveFunctionDetails" >
                    <span>${request?.professionalStatusElectiveFunctionDetails}</span>
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
        <span><g:message code="hccr.step.folders.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hccr.property.folders.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isMDPH-trigger"><g:message code="hccr.property.foldersMdph.label" /> * : </dt>
                  <dd id="foldersMdph" class="action-editField validate-boolean required-true i18n-hccr.property.foldersMdph" >
                    <span class="value-${request?.foldersMdph}"><g:message code="message.${request?.foldersMdph ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphNumber.label" />  : </dt>
                  <dd id="foldersMdphNumber" class="action-editField validate- i18n-hccr.property.foldersMdphNumber" >
                    <span>${request?.foldersMdphNumber}</span>
                  </dd>
                
                  <dt class="condition-isMDPH-filled"><g:message code="hccr.property.foldersMdphDepartment.label" />  : </dt>
                  <dd id="foldersMdphDepartment" class="action-editField validate-departmentCode i18n-hccr.property.foldersMdphDepartment" >
                    <span>${request?.foldersMdphDepartment}</span>
                  </dd>
                
                  <dt class="required condition-isCOTOREP-trigger"><g:message code="hccr.property.foldersCotorep.label" /> * : </dt>
                  <dd id="foldersCotorep" class="action-editField validate-boolean required-true i18n-hccr.property.foldersCotorep" >
                    <span class="value-${request?.foldersCotorep}"><g:message code="message.${request?.foldersCotorep ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepNumber.label" />  : </dt>
                  <dd id="foldersCotorepNumber" class="action-editField validate- i18n-hccr.property.foldersCotorepNumber" >
                    <span>${request?.foldersCotorepNumber}</span>
                  </dd>
                
                  <dt class="condition-isCOTOREP-filled"><g:message code="hccr.property.foldersCotorepDepartment.label" />  : </dt>
                  <dd id="foldersCotorepDepartment" class="action-editField validate-departmentCode i18n-hccr.property.foldersCotorepDepartment" >
                    <span>${request?.foldersCotorepDepartment}</span>
                  </dd>
                
                  <dt class="required condition-isCDES-trigger"><g:message code="hccr.property.foldersCdes.label" /> * : </dt>
                  <dd id="foldersCdes" class="action-editField validate-boolean required-true i18n-hccr.property.foldersCdes" >
                    <span class="value-${request?.foldersCdes}"><g:message code="message.${request?.foldersCdes ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesNumber.label" />  : </dt>
                  <dd id="foldersCdesNumber" class="action-editField validate- i18n-hccr.property.foldersCdesNumber" >
                    <span>${request?.foldersCdesNumber}</span>
                  </dd>
                
                  <dt class="condition-isCDES-filled"><g:message code="hccr.property.foldersCdesDepartment.label" />  : </dt>
                  <dd id="foldersCdesDepartment" class="action-editField validate-departmentCode i18n-hccr.property.foldersCdesDepartment" >
                    <span>${request?.foldersCdesDepartment}</span>
                  </dd>
                
                  <dt class="required condition-isOtherFolders-trigger"><g:message code="hccr.property.foldersOtherFolders.label" /> * : </dt>
                  <dd id="foldersOtherFolders" class="action-editField validate-boolean required-true i18n-hccr.property.foldersOtherFolders" >
                    <span class="value-${request?.foldersOtherFolders}"><g:message code="message.${request?.foldersOtherFolders ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-otherFolders">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/otherFolders" model="['request':request]" />
              </div>
              
            
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
        <span><g:message code="hccr.step.benefits.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hccr.property.benefits.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isDisabilityRecognition-trigger"><g:message code="hccr.property.benefitsDisabilityRecognition.label" /> * : </dt>
                  <dd id="benefitsDisabilityRecognition" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityRecognition" >
                    <span class="value-${request?.benefitsDisabilityRecognition}"><g:message code="message.${request?.benefitsDisabilityRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isDisabilityRecognition-filled"><g:message code="hccr.property.benefitsDisabilityRatio.label" /> * : </dt>
                  <dd id="benefitsDisabilityRatio" class="action-editField validate- required-true i18n-hccr.property.benefitsDisabilityRatio" >
                    <span>${request?.benefitsDisabilityRatio}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsDisabilityCard.label" /> * : </dt>
                  <dd id="benefitsDisabilityCard" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityCard" >
                    <span class="value-${request?.benefitsDisabilityCard}"><g:message code="message.${request?.benefitsDisabilityCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsPainfulStandingCard.label" /> * : </dt>
                  <dd id="benefitsPainfulStandingCard" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsPainfulStandingCard" >
                    <span class="value-${request?.benefitsPainfulStandingCard}"><g:message code="message.${request?.benefitsPainfulStandingCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsParkingCard.label" /> * : </dt>
                  <dd id="benefitsParkingCard" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsParkingCard" >
                    <span class="value-${request?.benefitsParkingCard}"><g:message code="message.${request?.benefitsParkingCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsDisabledWorkerRecognition.label" /> * : </dt>
                  <dd id="benefitsDisabledWorkerRecognition" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabledWorkerRecognition" >
                    <span class="value-${request?.benefitsDisabledWorkerRecognition}"><g:message code="message.${request?.benefitsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isProfessionalOrientation-trigger"><g:message code="hccr.property.benefitsProfessionalOrientation.label" /> * : </dt>
                  <dd id="benefitsProfessionalOrientation" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsProfessionalOrientation" >
                    <span class="value-${request?.benefitsProfessionalOrientation}"><g:message code="message.${request?.benefitsProfessionalOrientation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isProfessionalOrientation-filled"><g:message code="hccr.property.benefitsProfessionalOrientationDetails.label" /> * : </dt>
                  <dd id="benefitsProfessionalOrientationDetails" class="action-editField validate- required-true i18n-hccr.property.benefitsProfessionalOrientationDetails" >
                    <span>${request?.benefitsProfessionalOrientationDetails}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsDisabledAdultAllocation.label" /> * : </dt>
                  <dd id="benefitsDisabledAdultAllocation" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabledAdultAllocation" >
                    <span class="value-${request?.benefitsDisabledAdultAllocation}"><g:message code="message.${request?.benefitsDisabledAdultAllocation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsIncreaseForIndependentLiving.label" /> * : </dt>
                  <dd id="benefitsIncreaseForIndependentLiving" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsIncreaseForIndependentLiving" >
                    <span class="value-${request?.benefitsIncreaseForIndependentLiving}"><g:message code="message.${request?.benefitsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsEducationAllocationOfDisabledChildren.label" /> * : </dt>
                  <dd id="benefitsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsEducationAllocationOfDisabledChildren" >
                    <span class="value-${request?.benefitsEducationAllocationOfDisabledChildren}"><g:message code="message.${request?.benefitsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isEducationOfDisabledChildren-trigger"><g:message code="hccr.property.benefitsEducationOfDisabledChildren.label" /> * : </dt>
                  <dd id="benefitsEducationOfDisabledChildren" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsEducationOfDisabledChildren" >
                    <span class="value-${request?.benefitsEducationOfDisabledChildren}"><g:message code="message.${request?.benefitsEducationOfDisabledChildren ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isEducationOfDisabledChildren-filled"><g:message code="hccr.property.benefitsEducationOfDisabledChildrenDetails.label" /> * : </dt>
                  <dd id="benefitsEducationOfDisabledChildrenDetails" class="action-editField validate- required-true i18n-hccr.property.benefitsEducationOfDisabledChildrenDetails" >
                    <span>${request?.benefitsEducationOfDisabledChildrenDetails}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsSupplementForSingleParents.label" /> * : </dt>
                  <dd id="benefitsSupplementForSingleParents" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsSupplementForSingleParents" >
                    <span class="value-${request?.benefitsSupplementForSingleParents}"><g:message code="message.${request?.benefitsSupplementForSingleParents ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsThirdPersonCompensatoryAllowance.label" /> * : </dt>
                  <dd id="benefitsThirdPersonCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsThirdPersonCompensatoryAllowance" >
                    <span class="value-${request?.benefitsThirdPersonCompensatoryAllowance}"><g:message code="message.${request?.benefitsThirdPersonCompensatoryAllowance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsThirdPartyCompensatoryAllowance.label" /> * : </dt>
                  <dd id="benefitsThirdPartyCompensatoryAllowance" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsThirdPartyCompensatoryAllowance" >
                    <span class="value-${request?.benefitsThirdPartyCompensatoryAllowance}"><g:message code="message.${request?.benefitsThirdPartyCompensatoryAllowance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsCompensatoryAllowanceForExpenses.label" /> * : </dt>
                  <dd id="benefitsCompensatoryAllowanceForExpenses" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsCompensatoryAllowanceForExpenses" >
                    <span class="value-${request?.benefitsCompensatoryAllowanceForExpenses}"><g:message code="message.${request?.benefitsCompensatoryAllowanceForExpenses ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsDisabilityCompensation.label" /> * : </dt>
                  <dd id="benefitsDisabilityCompensation" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityCompensation" >
                    <span class="value-${request?.benefitsDisabilityCompensation}"><g:message code="message.${request?.benefitsDisabilityCompensation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isDisabilityPension-trigger"><g:message code="hccr.property.benefitsDisabilityPension.label" /> * : </dt>
                  <dd id="benefitsDisabilityPension" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDisabilityPension" >
                    <span class="value-${request?.benefitsDisabilityPension}"><g:message code="message.${request?.benefitsDisabilityPension ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isDisabilityPension-filled"><g:message code="hccr.property.benefitsDisabilityPensionCategory.label" /> * : </dt>
                  <dd id="benefitsDisabilityPensionCategory" class="action-editField validate- required-true i18n-hccr.property.benefitsDisabilityPensionCategory" >
                    <span>${request?.benefitsDisabilityPensionCategory}</span>
                  </dd>
                
                  <dt class="required condition-isWorkAccidentAnnuity-trigger"><g:message code="hccr.property.benefitsWorkAccidentAnnuity.label" /> * : </dt>
                  <dd id="benefitsWorkAccidentAnnuity" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsWorkAccidentAnnuity" >
                    <span class="value-${request?.benefitsWorkAccidentAnnuity}"><g:message code="message.${request?.benefitsWorkAccidentAnnuity ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isWorkAccidentAnnuity-filled"><g:message code="hccr.property.benefitsWorkAccidentAnnuityRatio.label" /> * : </dt>
                  <dd id="benefitsWorkAccidentAnnuityRatio" class="action-editField validate- required-true i18n-hccr.property.benefitsWorkAccidentAnnuityRatio" >
                    <span>${request?.benefitsWorkAccidentAnnuityRatio}</span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsSocialWelfare.label" /> * : </dt>
                  <dd id="benefitsSocialWelfare" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsSocialWelfare" >
                    <span class="value-${request?.benefitsSocialWelfare}"><g:message code="message.${request?.benefitsSocialWelfare ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsUnemploymentBenefits.label" /> * : </dt>
                  <dd id="benefitsUnemploymentBenefits" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsUnemploymentBenefits" >
                    <span class="value-${request?.benefitsUnemploymentBenefits}"><g:message code="message.${request?.benefitsUnemploymentBenefits ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsDailyAllowances.label" /> * : </dt>
                  <dd id="benefitsDailyAllowances" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsDailyAllowances" >
                    <span class="value-${request?.benefitsDailyAllowances}"><g:message code="message.${request?.benefitsDailyAllowances ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required"><g:message code="hccr.property.benefitsThirdPartySupplement.label" /> * : </dt>
                  <dd id="benefitsThirdPartySupplement" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsThirdPartySupplement" >
                    <span class="value-${request?.benefitsThirdPartySupplement}"><g:message code="message.${request?.benefitsThirdPartySupplement ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSupportedByAnInstitution-trigger"><g:message code="hccr.property.benefitsSupportedByAnInstitution.label" /> * : </dt>
                  <dd id="benefitsSupportedByAnInstitution" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsSupportedByAnInstitution" >
                    <span class="value-${request?.benefitsSupportedByAnInstitution}"><g:message code="message.${request?.benefitsSupportedByAnInstitution ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSupportedByAnInstitution-filled"><g:message code="hccr.property.benefitsSupportedByAnInstitutionDetails.label" /> * : </dt>
                  <dd id="benefitsSupportedByAnInstitutionDetails" class="action-editField validate- required-true i18n-hccr.property.benefitsSupportedByAnInstitutionDetails" >
                    <span>${request?.benefitsSupportedByAnInstitutionDetails}</span>
                  </dd>
                
                  <dt class="required condition-isOtherBenefits-trigger"><g:message code="hccr.property.benefitsOtherBenefits.label" /> * : </dt>
                  <dd id="benefitsOtherBenefits" class="action-editField validate-boolean required-true i18n-hccr.property.benefitsOtherBenefits" >
                    <span class="value-${request?.benefitsOtherBenefits}"><g:message code="message.${request?.benefitsOtherBenefits ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-otherBenefits">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/otherBenefits" model="['request':request]" />
              </div>
              
            
              
              <div id="widget-additionalFee">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/additionalFee" model="['request':request]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page6">
      <h2><g:message code="property.form" />
        <span><g:message code="hccr.step.aid.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="hccr.property.familyAssistance.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isFamilyAssistance-trigger"><g:message code="hccr.property.isFamilyAssistance.label" /> * : </dt>
                  <dd id="isFamilyAssistance" class="action-editField validate-boolean required-true i18n-hccr.property.isFamilyAssistance" >
                    <span class="value-${request?.isFamilyAssistance}"><g:message code="message.${request?.isFamilyAssistance ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-familyAssistanceMembers">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/familyAssistanceMembers" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hccr.property.homeIntervention.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isHomeIntervenant-trigger"><g:message code="hccr.property.homeInterventionHomeIntervenant.label" /> * : </dt>
                  <dd id="homeInterventionHomeIntervenant" class="action-editField validate-boolean required-true i18n-hccr.property.homeInterventionHomeIntervenant" >
                    <span class="value-${request?.homeInterventionHomeIntervenant}"><g:message code="message.${request?.homeInterventionHomeIntervenant ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-homeIntervenants">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/homeIntervenants" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hccr.property.care.label" /></h3>
              <dl class="">
                
                  <dt class="required condition-isCareServices-trigger"><g:message code="hccr.property.careCareServices.label" /> * : </dt>
                  <dd id="careCareServices" class="action-editField validate-boolean required-true i18n-hccr.property.careCareServices" >
                    <span class="value-${request?.careCareServices}"><g:message code="message.${request?.careCareServices ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-careServices">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/careServices" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hccr.property.facilities.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isHousing-trigger"><g:message code="hccr.property.facilitiesHousing.label" /> * : </dt>
                  <dd id="facilitiesHousing" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesHousing" >
                    <span class="value-${request?.facilitiesHousing}"><g:message code="message.${request?.facilitiesHousing ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isHousing-filled"><g:message code="hccr.property.facilitiesHousingDetails.label" /> * : </dt>
                  <dd id="facilitiesHousingDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesHousingDetails" >
                    <span>${request?.facilitiesHousingDetails}</span>
                  </dd>
                
                  <dt class="required condition-isTechnicalAssistance-trigger"><g:message code="hccr.property.facilitiesTechnicalAssistance.label" /> * : </dt>
                  <dd id="facilitiesTechnicalAssistance" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesTechnicalAssistance" >
                    <span class="value-${request?.facilitiesTechnicalAssistance}"><g:message code="message.${request?.facilitiesTechnicalAssistance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isTechnicalAssistance-filled"><g:message code="hccr.property.facilitiesTechnicalAssistanceDetails.label" /> * : </dt>
                  <dd id="facilitiesTechnicalAssistanceDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesTechnicalAssistanceDetails" >
                    <span>${request?.facilitiesTechnicalAssistanceDetails}</span>
                  </dd>
                
                  <dt class="required condition-isCustomCar-trigger"><g:message code="hccr.property.facilitiesCustomCar.label" /> * : </dt>
                  <dd id="facilitiesCustomCar" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesCustomCar" >
                    <span class="value-${request?.facilitiesCustomCar}"><g:message code="message.${request?.facilitiesCustomCar ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isCustomCar-filled"><g:message code="hccr.property.facilitiesCustomCarDetails.label" /> * : </dt>
                  <dd id="facilitiesCustomCarDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesCustomCarDetails" >
                    <span>${request?.facilitiesCustomCarDetails}</span>
                  </dd>
                
                  <dt class="required condition-isAnimalAid-trigger"><g:message code="hccr.property.facilitiesAnimalAid.label" /> * : </dt>
                  <dd id="facilitiesAnimalAid" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesAnimalAid" >
                    <span class="value-${request?.facilitiesAnimalAid}"><g:message code="message.${request?.facilitiesAnimalAid ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isAnimalAid-filled"><g:message code="hccr.property.facilitiesAnimalAidDetails.label" /> * : </dt>
                  <dd id="facilitiesAnimalAidDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesAnimalAidDetails" >
                    <span>${request?.facilitiesAnimalAidDetails}</span>
                  </dd>
                
                  <dt class="required condition-isSpecializedTransport-trigger"><g:message code="hccr.property.facilitiesSpecializedTransport.label" /> * : </dt>
                  <dd id="facilitiesSpecializedTransport" class="action-editField validate-boolean required-true i18n-hccr.property.facilitiesSpecializedTransport" >
                    <span class="value-${request?.facilitiesSpecializedTransport}"><g:message code="message.${request?.facilitiesSpecializedTransport ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSpecializedTransport-filled"><g:message code="hccr.property.facilitiesSpecializedTransportDetails.label" /> * : </dt>
                  <dd id="facilitiesSpecializedTransportDetails" class="action-editField validate- required-true i18n-hccr.property.facilitiesSpecializedTransportDetails" >
                    <span>${request?.facilitiesSpecializedTransportDetails}</span>
                  </dd>
                
              </dl>
              
            
              
              <h3><g:message code="hccr.property.professionalSupport.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isProfessionals-trigger"><g:message code="hccr.property.professionalSupportProfessionals.label" /> * : </dt>
                  <dd id="professionalSupportProfessionals" class="action-editField validate-boolean required-true i18n-hccr.property.professionalSupportProfessionals" >
                    <span class="value-${request?.professionalSupportProfessionals}"><g:message code="message.${request?.professionalSupportProfessionals ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isProfessionals-filled"><g:message code="hccr.property.professionalSupportDealsWithSameProfessional.label" /> * : </dt>
                  <dd id="professionalSupportDealsWithSameProfessional" class="action-editField validate-boolean required-true i18n-hccr.property.professionalSupportDealsWithSameProfessional" >
                    <span class="value-${request?.professionalSupportDealsWithSameProfessional}"><g:message code="message.${request?.professionalSupportDealsWithSameProfessional ? 'yes' : 'no'}" /></span>
                  </dd>
                
              </dl>
              
            
              
              <div id="widget-professionals">
                <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationChildRequest/professionals" model="['request':request]" />
              </div>
              
            
              
              <h3><g:message code="hccr.property.socialService.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isSocialServiceSupport-trigger"><g:message code="hccr.property.socialServiceSupport.label" /> * : </dt>
                  <dd id="socialServiceSupport" class="action-editField validate-boolean required-true i18n-hccr.property.socialServiceSupport" >
                    <span class="value-${request?.socialServiceSupport}"><g:message code="message.${request?.socialServiceSupport ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hccr.property.socialServiceName.label" /> * : </dt>
                  <dd id="socialServiceName" class="action-editField validate- required-true i18n-hccr.property.socialServiceName" >
                    <span>${request?.socialServiceName}</span>
                  </dd>
                
                  <dt class="required condition-isSocialServiceSupport-filled"><g:message code="hccr.property.socialServiceAddress.label" /> * : </dt>
                  <dd id="socialServiceAddress" class="action-editField validate-address required-true i18n-hccr.property.socialServiceAddress" >
                    <div><p class="additionalDeliveryInformation">${request?.socialServiceAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${request?.socialServiceAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${request?.socialServiceAddress?.streetNumber}</span> <span class="streetName">${request?.socialServiceAddress?.streetName}</span><p class="placeNameOrService">${request?.socialServiceAddress?.placeNameOrService}</p><span class="postalCode">${request?.socialServiceAddress?.postalCode}</span> <span class="city">${request?.socialServiceAddress?.city}</span><p class="countryName">${request?.socialServiceAddress?.countryName}</p></div>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
        
    </div>
    <!-- step end -->
    
    <!-- step start -->
    <div id="page7">
      <h2><g:message code="property.form" />
        <span><g:message code="hccr.step.health.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hccr.property.health.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-isFollowedByDoctor-trigger"><g:message code="hccr.property.healthFollowedByDoctor.label" /> * : </dt>
                  <dd id="healthFollowedByDoctor" class="action-editField validate-boolean required-true i18n-hccr.property.healthFollowedByDoctor" >
                    <span class="value-${request?.healthFollowedByDoctor}"><g:message code="message.${request?.healthFollowedByDoctor ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hccr.property.healthDoctorLastName.label" /> * : </dt>
                  <dd id="healthDoctorLastName" class="action-editField validate-lastName required-true i18n-hccr.property.healthDoctorLastName" >
                    <span>${request?.healthDoctorLastName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByDoctor-filled"><g:message code="hccr.property.healthDoctorFirstName.label" /> * : </dt>
                  <dd id="healthDoctorFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.healthDoctorFirstName" >
                    <span>${request?.healthDoctorFirstName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByProfessional-trigger"><g:message code="hccr.property.healthFollowedByProfessional.label" /> * : </dt>
                  <dd id="healthFollowedByProfessional" class="action-editField validate-boolean required-true i18n-hccr.property.healthFollowedByProfessional" >
                    <span class="value-${request?.healthFollowedByProfessional}"><g:message code="message.${request?.healthFollowedByProfessional ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hccr.property.healthProfessionalLastName.label" /> * : </dt>
                  <dd id="healthProfessionalLastName" class="action-editField validate-lastName required-true i18n-hccr.property.healthProfessionalLastName" >
                    <span>${request?.healthProfessionalLastName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByProfessional-filled"><g:message code="hccr.property.healthProfessionalFirstName.label" /> * : </dt>
                  <dd id="healthProfessionalFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.healthProfessionalFirstName" >
                    <span>${request?.healthProfessionalFirstName}</span>
                  </dd>
                
                  <dt class="required condition-isFollowedByHospital-trigger"><g:message code="hccr.property.healthFollowedByHospital.label" /> * : </dt>
                  <dd id="healthFollowedByHospital" class="action-editField validate-boolean required-true i18n-hccr.property.healthFollowedByHospital" >
                    <span class="value-${request?.healthFollowedByHospital}"><g:message code="message.${request?.healthFollowedByHospital ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isFollowedByHospital-filled"><g:message code="hccr.property.healthHospitalName.label" /> * : </dt>
                  <dd id="healthHospitalName" class="action-editField validate- required-true i18n-hccr.property.healthHospitalName" >
                    <span>${request?.healthHospitalName}</span>
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
    <div id="page8">
      <h2><g:message code="property.form" />
        <span><g:message code="hccr.step.project.label" /></span>
      </h2>
        
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="hccr.property.projectRequests.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="hccr.property.projectRequestsHandicapRecognition.label" />  : </dt>
                  <dd id="projectRequestsHandicapRecognition" class="action-editField validate-boolean i18n-hccr.property.projectRequestsHandicapRecognition" >
                    <span class="value-${request?.projectRequestsHandicapRecognition}"><g:message code="message.${request?.projectRequestsHandicapRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsDisabilityCard.label" />  : </dt>
                  <dd id="projectRequestsDisabilityCard" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabilityCard" >
                    <span class="value-${request?.projectRequestsDisabilityCard}"><g:message code="message.${request?.projectRequestsDisabilityCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsDisabledPriorityCard.label" />  : </dt>
                  <dd id="projectRequestsDisabledPriorityCard" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabledPriorityCard" >
                    <span class="value-${request?.projectRequestsDisabledPriorityCard}"><g:message code="message.${request?.projectRequestsDisabledPriorityCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsEuropeanParkingCard.label" />  : </dt>
                  <dd id="projectRequestsEuropeanParkingCard" class="action-editField validate-boolean i18n-hccr.property.projectRequestsEuropeanParkingCard" >
                    <span class="value-${request?.projectRequestsEuropeanParkingCard}"><g:message code="message.${request?.projectRequestsEuropeanParkingCard ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsDisabledAdultAllowance.label" />  : </dt>
                  <dd id="projectRequestsDisabledAdultAllowance" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabledAdultAllowance" >
                    <span class="value-${request?.projectRequestsDisabledAdultAllowance}"><g:message code="message.${request?.projectRequestsDisabledAdultAllowance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsIncreaseForIndependentLiving.label" />  : </dt>
                  <dd id="projectRequestsIncreaseForIndependentLiving" class="action-editField validate-boolean i18n-hccr.property.projectRequestsIncreaseForIndependentLiving" >
                    <span class="value-${request?.projectRequestsIncreaseForIndependentLiving}"><g:message code="message.${request?.projectRequestsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsEducationAllocationOfDisabledChildren.label" />  : </dt>
                  <dd id="projectRequestsEducationAllocationOfDisabledChildren" class="action-editField validate-boolean i18n-hccr.property.projectRequestsEducationAllocationOfDisabledChildren" >
                    <span class="value-${request?.projectRequestsEducationAllocationOfDisabledChildren}"><g:message code="message.${request?.projectRequestsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsACTPRenewal.label" />  : </dt>
                  <dd id="projectRequestsACTPRenewal" class="action-editField validate-boolean i18n-hccr.property.projectRequestsACTPRenewal" >
                    <span class="value-${request?.projectRequestsACTPRenewal}"><g:message code="message.${request?.projectRequestsACTPRenewal ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsThirdPartyHelp.label" />  : </dt>
                  <dd id="projectRequestsThirdPartyHelp" class="action-editField validate-boolean i18n-hccr.property.projectRequestsThirdPartyHelp" >
                    <span class="value-${request?.projectRequestsThirdPartyHelp}"><g:message code="message.${request?.projectRequestsThirdPartyHelp ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsFreePensionMembership.label" />  : </dt>
                  <dd id="projectRequestsFreePensionMembership" class="action-editField validate-boolean i18n-hccr.property.projectRequestsFreePensionMembership" >
                    <span class="value-${request?.projectRequestsFreePensionMembership}"><g:message code="message.${request?.projectRequestsFreePensionMembership ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsTechnicalHelp.label" />  : </dt>
                  <dd id="projectRequestsTechnicalHelp" class="action-editField validate-boolean i18n-hccr.property.projectRequestsTechnicalHelp" >
                    <span class="value-${request?.projectRequestsTechnicalHelp}"><g:message code="message.${request?.projectRequestsTechnicalHelp ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsHousingFacilities.label" />  : </dt>
                  <dd id="projectRequestsHousingFacilities" class="action-editField validate-boolean i18n-hccr.property.projectRequestsHousingFacilities" >
                    <span class="value-${request?.projectRequestsHousingFacilities}"><g:message code="message.${request?.projectRequestsHousingFacilities ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsCustomCar.label" />  : </dt>
                  <dd id="projectRequestsCustomCar" class="action-editField validate-boolean i18n-hccr.property.projectRequestsCustomCar" >
                    <span class="value-${request?.projectRequestsCustomCar}"><g:message code="message.${request?.projectRequestsCustomCar ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsAssistance.label" />  : </dt>
                  <dd id="projectRequestsAssistance" class="action-editField validate-boolean i18n-hccr.property.projectRequestsAssistance" >
                    <span class="value-${request?.projectRequestsAssistance}"><g:message code="message.${request?.projectRequestsAssistance ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsTransportCostAllocation.label" />  : </dt>
                  <dd id="projectRequestsTransportCostAllocation" class="action-editField validate-boolean i18n-hccr.property.projectRequestsTransportCostAllocation" >
                    <span class="value-${request?.projectRequestsTransportCostAllocation}"><g:message code="message.${request?.projectRequestsTransportCostAllocation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsDisabilityCostAllocation.label" />  : </dt>
                  <dd id="projectRequestsDisabilityCostAllocation" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabilityCostAllocation" >
                    <span class="value-${request?.projectRequestsDisabilityCostAllocation}"><g:message code="message.${request?.projectRequestsDisabilityCostAllocation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsDisabledWorkerRecognition.label" />  : </dt>
                  <dd id="projectRequestsDisabledWorkerRecognition" class="action-editField validate-boolean i18n-hccr.property.projectRequestsDisabledWorkerRecognition" >
                    <span class="value-${request?.projectRequestsDisabledWorkerRecognition}"><g:message code="message.${request?.projectRequestsDisabledWorkerRecognition ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-trigger"><g:message code="hccr.property.projectRequestsProfessionalOrientation.label" />  : </dt>
                  <dd id="projectRequestsProfessionalOrientation" class="action-editField validate-boolean i18n-hccr.property.projectRequestsProfessionalOrientation" >
                    <span class="value-${request?.projectRequestsProfessionalOrientation}"><g:message code="message.${request?.projectRequestsProfessionalOrientation ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsOrdinaryWorking.label" />  : </dt>
                  <dd id="projectRequestsOrdinaryWorking" class="action-editField validate-boolean i18n-hccr.property.projectRequestsOrdinaryWorking" >
                    <span class="value-${request?.projectRequestsOrdinaryWorking}"><g:message code="message.${request?.projectRequestsOrdinaryWorking ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsShelteredWork.label" />  : </dt>
                  <dd id="projectRequestsShelteredWork" class="action-editField validate-boolean i18n-hccr.property.projectRequestsShelteredWork" >
                    <span class="value-${request?.projectRequestsShelteredWork}"><g:message code="message.${request?.projectRequestsShelteredWork ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isProfessionalOrientationRequest-filled"><g:message code="hccr.property.projectRequestsVocationalTraining.label" />  : </dt>
                  <dd id="projectRequestsVocationalTraining" class="action-editField validate-boolean i18n-hccr.property.projectRequestsVocationalTraining" >
                    <span class="value-${request?.projectRequestsVocationalTraining}"><g:message code="message.${request?.projectRequestsVocationalTraining ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class=""><g:message code="hccr.property.projectRequestsInstitutionSupport.label" />  : </dt>
                  <dd id="projectRequestsInstitutionSupport" class="action-editField validate-boolean i18n-hccr.property.projectRequestsInstitutionSupport" >
                    <span class="value-${request?.projectRequestsInstitutionSupport}"><g:message code="message.${request?.projectRequestsInstitutionSupport ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="condition-isOtherRequest-trigger"><g:message code="hccr.property.projectRequestsOther.label" />  : </dt>
                  <dd id="projectRequestsOther" class="action-editField validate-boolean i18n-hccr.property.projectRequestsOther" >
                    <span class="value-${request?.projectRequestsOther}"><g:message code="message.${request?.projectRequestsOther ? 'yes' : 'no'}" /></span>
                  </dd>
                
                  <dt class="required condition-isOtherRequest-filled"><g:message code="hccr.property.projectRequestsOtherDetails.label" /> * : </dt>
                  <dd id="projectRequestsOtherDetails" class="action-editField validate- required-true i18n-hccr.property.projectRequestsOtherDetails" >
                    <span>${request?.projectRequestsOtherDetails}</span>
                  </dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="hccr.property.projectWish.label" />  : </dt>
                <dd id="projectWish" class="action-editField validate- i18n-hccr.property.projectWish" >
                  <span>${request?.projectWish}</span>
                </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="hccr.property.projectNeeds.label" />  : </dt>
                <dd id="projectNeeds" class="action-editField validate- i18n-hccr.property.projectNeeds" >
                  <span>${request?.projectNeeds}</span>
                </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="hccr.property.projectComments.label" />  : </dt>
                <dd id="projectComments" class="action-editField validate- i18n-hccr.property.projectComments" >
                  <span>${request?.projectComments}</span>
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
