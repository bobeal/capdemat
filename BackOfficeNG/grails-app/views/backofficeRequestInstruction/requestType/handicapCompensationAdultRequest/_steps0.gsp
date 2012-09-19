



<!-- step start -->
<div id="page0">
  <h2><g:message code="property.form" />
    <span><g:message code="hcar.step.subject.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hcar.property.hcarSubject.label" /></h3>
        <dl class="required">
          
              <dt class="required"><g:message code="hcar.property.subject.label" /> : </dt>
             <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
          
          
              <dt class="required condition-isMadam-trigger">${message(code:'hcar.property.subjectTitle.label')}&nbsp;*&nbsp;:</dt><dd id="subjectTitle" class="action-editField validate-capdematEnum required-true i18n-hcar.property.subjectTitle javatype-fr.cg95.cvq.business.users.TitleType" ><g:capdematEnumToField var="${rqt?.subjectTitle}" i18nKeyPrefix="hcar.property.subjectTitle" /></dd>
          
              <dt class="required condition-isMadam-filled">${message(code:'hcar.property.subjectMaidenName.label')}&nbsp;*&nbsp;:</dt><dd id="subjectMaidenName" class="action-editField validate-lastName required-true i18n-hcar.property.subjectMaidenName maxLength-38" ><span>${rqt?.subjectMaidenName}</span></dd>
          
              <dt class="required">${message(code:'hcar.property.subjectBirthDate.label')}&nbsp;*&nbsp;:</dt><dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-hcar.property.subjectBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectBirthDate}"/></span></dd>
          
              <dt class="required">${message(code:'hcar.property.subjectBirthCity.label')}&nbsp;*&nbsp;:</dt><dd id="subjectBirthCity" class="action-editField validate-city required-true i18n-hcar.property.subjectBirthCity maxLength-32" ><span>${rqt?.subjectBirthCity}</span></dd>
          
              <dt class="required">${message(code:'hcar.property.subjectBirthCountry.label')}&nbsp;*&nbsp;:</dt><dd id="subjectBirthCountry" class="action-editField validate- required-true i18n-hcar.property.subjectBirthCountry maxLength-50" ><span>${rqt?.subjectBirthCountry}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hcar.property.legalAccess.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isLegalAccessPresence-trigger">${message(code:'hcar.property.legalAccessPresence.label')}&nbsp;*&nbsp;:</dt><dd id="legalAccessPresence" class="action-editField validate-boolean required-true i18n-hcar.property.legalAccessPresence" ><span class="value-${rqt?.legalAccessPresence}"><g:message code="message.${rqt?.legalAccessPresence ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isLegalAccessPresence-filled">${message(code:'hcar.property.legalAccessKind.label')}&nbsp;*&nbsp;:</dt><dd id="legalAccessKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.legalAccessKind javatype-fr.cg95.cvq.business.request.social.HcarLegalAccessKindType" ><g:capdematEnumToField var="${rqt?.legalAccessKind}" i18nKeyPrefix="hcar.property.legalAccessKind" /></dd>
          
              <dt class="required condition-isLegalAccessPresence-filled condition-isOtherLegalAccessRepresentative-trigger">${message(code:'hcar.property.legalAccessRepresentativeKind.label')}&nbsp;*&nbsp;:</dt><dd id="legalAccessRepresentativeKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.legalAccessRepresentativeKind javatype-fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType" ><g:capdematEnumToField var="${rqt?.legalAccessRepresentativeKind}" i18nKeyPrefix="hcar.property.legalAccessRepresentativeKind" /></dd>
          
              <dt class="required condition-isOtherLegalAccessRepresentative-filled">${message(code:'hcar.property.legalAccessRepresentativeKindDetail.label')}&nbsp;*&nbsp;:</dt><dd id="legalAccessRepresentativeKindDetail" class="action-editField validate- required-true i18n-hcar.property.legalAccessRepresentativeKindDetail maxLength-80" ><span>${rqt?.legalAccessRepresentativeKindDetail}</span></dd>
          
              <dt class="required condition-isLegalAccessPresence-filled">${message(code:'hcar.property.legalAccessRepresentativeName.label')}&nbsp;*&nbsp;:</dt><dd id="legalAccessRepresentativeName" class="action-editField validate-lastName required-true i18n-hcar.property.legalAccessRepresentativeName maxLength-38" ><span>${rqt?.legalAccessRepresentativeName}</span></dd>
          
              <dt class="required condition-isLegalAccessPresence-filled">${message(code:'hcar.property.legalAccessRepresentativeFirstName.label')}&nbsp;*&nbsp;:</dt><dd id="legalAccessRepresentativeFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.legalAccessRepresentativeFirstName maxLength-38" ><span>${rqt?.legalAccessRepresentativeFirstName}</span></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hcar.property.family.label" /></h3>
        <dl class="required">
          
              <dt class="required">${message(code:'hcar.property.familyStatus.label')}&nbsp;*&nbsp;:</dt><dd id="familyStatus" class="action-editField validate-capdematEnum required-true i18n-hcar.property.familyStatus javatype-fr.cg95.cvq.business.users.FamilyStatusType" ><g:capdematEnumToField var="${rqt?.familyStatus}" i18nKeyPrefix="hcar.property.familyStatus" /></dd>
          
              <dt class="required condition-isFamilyDependents-trigger">${message(code:'hcar.property.familyFamilyDependents.label')}&nbsp;*&nbsp;:</dt><dd id="familyFamilyDependents" class="action-editField validate-boolean required-true i18n-hcar.property.familyFamilyDependents" ><span class="value-${rqt?.familyFamilyDependents}"><g:message code="message.${rqt?.familyFamilyDependents ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-familyDependents" class="required condition-isFamilyDependents-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/familyDependents" model="['rqt':rqt]" />
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
    <span><g:message code="hcar.step.dwelling.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hcar.property.dwelling.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isNotPlaceOfResidence-trigger">${message(code:'hcar.property.dwellingKind.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.dwellingKind javatype-fr.cg95.cvq.business.request.social.HcarDwellingKindType" ><g:capdematEnumToField var="${rqt?.dwellingKind}" i18nKeyPrefix="hcar.property.dwellingKind" /></dd>
          
              <dt class="required condition-isNotPlaceOfResidence-filled">${message(code:'hcar.property.dwellingPrecision.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingPrecision" class="action-editField validate-textarea required-true i18n-hcar.property.dwellingPrecision rows-2 maxLength-120" ><span>${rqt?.dwellingPrecision}</span></dd>
          
              <dt class="required condition-isInEstablishmentReception-trigger">${message(code:'hcar.property.dwellingEstablishmentReception.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingEstablishmentReception" class="action-editField validate-boolean required-true i18n-hcar.property.dwellingEstablishmentReception" ><span class="value-${rqt?.dwellingEstablishmentReception}"><g:message code="message.${rqt?.dwellingEstablishmentReception ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isInEstablishmentReception-filled">${message(code:'hcar.property.dwellingReceptionType.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingReceptionType" class="action-editField validate-capdematEnum required-true i18n-hcar.property.dwellingReceptionType javatype-fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType" ><g:capdematEnumToField var="${rqt?.dwellingReceptionType}" i18nKeyPrefix="hcar.property.dwellingReceptionType" /></dd>
          
              <dt class="required condition-isInEstablishmentReception-filled">${message(code:'hcar.property.dwellingReceptionNaming.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingReceptionNaming" class="action-editField validate- required-true i18n-hcar.property.dwellingReceptionNaming maxLength-80" ><span>${rqt?.dwellingReceptionNaming}</span></dd>
          
              <dt class="required condition-isInEstablishmentReception-filled">${message(code:'hcar.property.dwellingReceptionAddress.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingReceptionAddress" class="action-editField validate-address required-true i18n-hcar.property.dwellingReceptionAddress" ><div><p class="additionalDeliveryInformation">${rqt?.dwellingReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.dwellingReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.dwellingReceptionAddress?.streetNumber}</span> <span class="streetName">${rqt?.dwellingReceptionAddress?.streetName}</span><g:if test="${!!rqt?.dwellingReceptionAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.dwellingReceptionAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.dwellingReceptionAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.dwellingReceptionAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.dwellingReceptionAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.dwellingReceptionAddress?.postalCode}</span> <span class="city">${rqt?.dwellingReceptionAddress?.city}</span><p class="countryName">${rqt?.dwellingReceptionAddress?.countryName}</p><g:if test="${!!rqt?.dwellingReceptionAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.dwellingReceptionAddress?.cityInseeCode}</span></g:if></div></dd>
          
              <dt class="required condition-isInSocialReception-trigger">${message(code:'hcar.property.dwellingSocialReception.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingSocialReception" class="action-editField validate-boolean required-true i18n-hcar.property.dwellingSocialReception" ><span class="value-${rqt?.dwellingSocialReception}"><g:message code="message.${rqt?.dwellingSocialReception ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isInSocialReception-filled">${message(code:'hcar.property.dwellingSocialReceptionNaming.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingSocialReceptionNaming" class="action-editField validate- required-true i18n-hcar.property.dwellingSocialReceptionNaming maxLength-80" ><span>${rqt?.dwellingSocialReceptionNaming}</span></dd>
          
              <dt class="required condition-isInSocialReception-filled">${message(code:'hcar.property.dwellingSocialReceptionAddress.label')}&nbsp;*&nbsp;:</dt><dd id="dwellingSocialReceptionAddress" class="action-editField validate-address required-true i18n-hcar.property.dwellingSocialReceptionAddress" ><div><p class="additionalDeliveryInformation">${rqt?.dwellingSocialReceptionAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.dwellingSocialReceptionAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.dwellingSocialReceptionAddress?.streetNumber}</span> <span class="streetName">${rqt?.dwellingSocialReceptionAddress?.streetName}</span><g:if test="${!!rqt?.dwellingSocialReceptionAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.dwellingSocialReceptionAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.dwellingSocialReceptionAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.dwellingSocialReceptionAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.dwellingSocialReceptionAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.dwellingSocialReceptionAddress?.postalCode}</span> <span class="city">${rqt?.dwellingSocialReceptionAddress?.city}</span><p class="countryName">${rqt?.dwellingSocialReceptionAddress?.countryName}</p><g:if test="${!!rqt?.dwellingSocialReceptionAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.dwellingSocialReceptionAddress?.cityInseeCode}</span></g:if></div></dd>
          
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
    <span><g:message code="hcar.step.socialSecurityAndPaymentAgency.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hcar.property.socialSecurity.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isSocialSecurityMemberShip-trigger">${message(code:'hcar.property.socialSecurityMemberShipKind.label')}&nbsp;*&nbsp;:</dt><dd id="socialSecurityMemberShipKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.socialSecurityMemberShipKind javatype-fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType" ><g:capdematEnumToField var="${rqt?.socialSecurityMemberShipKind}" i18nKeyPrefix="hcar.property.socialSecurityMemberShipKind" /></dd>
          
              <dt class="required condition-isSocialSecurityMemberShip-filled">${message(code:'hcar.property.socialSecurityNumber.label')}&nbsp;*&nbsp;:</dt><dd id="socialSecurityNumber" class="action-editField validate- required-true i18n-hcar.property.socialSecurityNumber" ><span>${rqt?.socialSecurityNumber}</span></dd>
          
              <dt class="required condition-isSocialSecurityMemberShip-filled">${message(code:'hcar.property.socialSecurityAgencyName.label')}&nbsp;*&nbsp;:</dt><dd id="socialSecurityAgencyName" class="action-editField validate- required-true i18n-hcar.property.socialSecurityAgencyName maxLength-50" ><span>${rqt?.socialSecurityAgencyName}</span></dd>
          
              <dt class="required condition-isSocialSecurityMemberShip-filled">${message(code:'hcar.property.socialSecurityAgencyAddress.label')}&nbsp;*&nbsp;:</dt><dd id="socialSecurityAgencyAddress" class="action-editField validate-address required-true i18n-hcar.property.socialSecurityAgencyAddress" ><div><p class="additionalDeliveryInformation">${rqt?.socialSecurityAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.socialSecurityAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.socialSecurityAgencyAddress?.streetNumber}</span> <span class="streetName">${rqt?.socialSecurityAgencyAddress?.streetName}</span><g:if test="${!!rqt?.socialSecurityAgencyAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.socialSecurityAgencyAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.socialSecurityAgencyAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.socialSecurityAgencyAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.socialSecurityAgencyAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.socialSecurityAgencyAddress?.postalCode}</span> <span class="city">${rqt?.socialSecurityAgencyAddress?.city}</span><p class="countryName">${rqt?.socialSecurityAgencyAddress?.countryName}</p><g:if test="${!!rqt?.socialSecurityAgencyAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.socialSecurityAgencyAddress?.cityInseeCode}</span></g:if></div></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hcar.property.paymentAgency.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isPaymentAgencyBeneficiary-trigger">${message(code:'hcar.property.paymentAgencyBeneficiary.label')}&nbsp;*&nbsp;:</dt><dd id="paymentAgencyBeneficiary" class="action-editField validate-capdematEnum required-true i18n-hcar.property.paymentAgencyBeneficiary javatype-fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType" ><g:capdematEnumToField var="${rqt?.paymentAgencyBeneficiary}" i18nKeyPrefix="hcar.property.paymentAgencyBeneficiary" /></dd>
          
              <dt class="required condition-isPaymentAgencyBeneficiary-filled">${message(code:'hcar.property.paymentAgencyBeneficiaryNumber.label')}&nbsp;*&nbsp;:</dt><dd id="paymentAgencyBeneficiaryNumber" class="action-editField validate- required-true i18n-hcar.property.paymentAgencyBeneficiaryNumber maxLength-20" ><span>${rqt?.paymentAgencyBeneficiaryNumber}</span></dd>
          
              <dt class="required condition-isPaymentAgencyBeneficiary-filled">${message(code:'hcar.property.paymentAgencyName.label')}&nbsp;*&nbsp;:</dt><dd id="paymentAgencyName" class="action-editField validate- required-true i18n-hcar.property.paymentAgencyName maxLength-50" ><span>${rqt?.paymentAgencyName}</span></dd>
          
              <dt class="required condition-isPaymentAgencyBeneficiary-filled">${message(code:'hcar.property.paymentAgencyAddress.label')}&nbsp;*&nbsp;:</dt><dd id="paymentAgencyAddress" class="action-editField validate-address required-true i18n-hcar.property.paymentAgencyAddress" ><div><p class="additionalDeliveryInformation">${rqt?.paymentAgencyAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.paymentAgencyAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.paymentAgencyAddress?.streetNumber}</span> <span class="streetName">${rqt?.paymentAgencyAddress?.streetName}</span><g:if test="${!!rqt?.paymentAgencyAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.paymentAgencyAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.paymentAgencyAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.paymentAgencyAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.paymentAgencyAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.paymentAgencyAddress?.postalCode}</span> <span class="city">${rqt?.paymentAgencyAddress?.city}</span><p class="countryName">${rqt?.paymentAgencyAddress?.countryName}</p><g:if test="${!!rqt?.paymentAgencyAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.paymentAgencyAddress?.cityInseeCode}</span></g:if></div></dd>
          
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
    <span><g:message code="hcar.step.occupationnalAndSchoolStatus.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hcar.property.studies.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isHighSchool-trigger">${message(code:'hcar.property.studiesHighSchool.label')}&nbsp;*&nbsp;:</dt><dd id="studiesHighSchool" class="action-editField validate-boolean required-true i18n-hcar.property.studiesHighSchool" ><span class="value-${rqt?.studiesHighSchool}"><g:message code="message.${rqt?.studiesHighSchool ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isHighSchool-filled">${message(code:'hcar.property.studiesHighSchoolGrade.label')}&nbsp;*&nbsp;:</dt><dd id="studiesHighSchoolGrade" class="action-editField validate- required-true i18n-hcar.property.studiesHighSchoolGrade maxLength-60" ><span>${rqt?.studiesHighSchoolGrade}</span></dd>
          
              <dt class="required condition-isHighSchool-filled">${message(code:'hcar.property.studiesHighSchoolName.label')}&nbsp;*&nbsp;:</dt><dd id="studiesHighSchoolName" class="action-editField validate- required-true i18n-hcar.property.studiesHighSchoolName maxLength-60" ><span>${rqt?.studiesHighSchoolName}</span></dd>
          
              <dt class="required condition-isHighSchool-filled">${message(code:'hcar.property.studiesHighSchoolAddress.label')}&nbsp;*&nbsp;:</dt><dd id="studiesHighSchoolAddress" class="action-editField validate-address required-true i18n-hcar.property.studiesHighSchoolAddress" ><div><p class="additionalDeliveryInformation">${rqt?.studiesHighSchoolAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.studiesHighSchoolAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.studiesHighSchoolAddress?.streetNumber}</span> <span class="streetName">${rqt?.studiesHighSchoolAddress?.streetName}</span><g:if test="${!!rqt?.studiesHighSchoolAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.studiesHighSchoolAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.studiesHighSchoolAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.studiesHighSchoolAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.studiesHighSchoolAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.studiesHighSchoolAddress?.postalCode}</span> <span class="city">${rqt?.studiesHighSchoolAddress?.city}</span><p class="countryName">${rqt?.studiesHighSchoolAddress?.countryName}</p><g:if test="${!!rqt?.studiesHighSchoolAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.studiesHighSchoolAddress?.cityInseeCode}</span></g:if></div></dd>
          
              <dt class="required condition-isHighSchool-filled condition-isAssistanceUnderDisability-trigger">${message(code:'hcar.property.studiesAssistanceUnderDisability.label')}&nbsp;*&nbsp;:</dt><dd id="studiesAssistanceUnderDisability" class="action-editField validate-boolean required-true i18n-hcar.property.studiesAssistanceUnderDisability" ><span class="value-${rqt?.studiesAssistanceUnderDisability}"><g:message code="message.${rqt?.studiesAssistanceUnderDisability ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isAssistanceUnderDisability-filled">${message(code:'hcar.property.studiesAssistanceUnderDisabilityDetails.label')}&nbsp;*&nbsp;:</dt><dd id="studiesAssistanceUnderDisabilityDetails" class="action-editField validate- required-true i18n-hcar.property.studiesAssistanceUnderDisabilityDetails maxLength-60" ><span>${rqt?.studiesAssistanceUnderDisabilityDetails}</span></dd>
          
        </dl>
        
      
        
        <h3><g:message code="hcar.property.formation.label" /></h3>
        <dl class="required">
          
              <dt class="">${message(code:'hcar.property.formationStudiesLevel.label')}&nbsp;:</dt><dd id="formationStudiesLevel" class="action-editField validate- i18n-hcar.property.formationStudiesLevel maxLength-30" ><span>${rqt?.formationStudiesLevel}</span></dd>
          
              <dt class="">${message(code:'hcar.property.formationDiploma.label')}&nbsp;:</dt><dd id="formationDiploma" class="action-editField validate-textarea i18n-hcar.property.formationDiploma rows-2 maxLength-120" ><span>${rqt?.formationDiploma}</span></dd>
          
              <dt class="">${message(code:'hcar.property.formationPreviousFormation.label')}&nbsp;:</dt><dd id="formationPreviousFormation" class="action-editField validate-textarea i18n-hcar.property.formationPreviousFormation rows-3 maxLength-180" ><span>${rqt?.formationPreviousFormation}</span></dd>
          
              <dt class="">${message(code:'hcar.property.formationCurrentFormation.label')}&nbsp;:</dt><dd id="formationCurrentFormation" class="action-editField validate-textarea i18n-hcar.property.formationCurrentFormation rows-2 maxLength-120" ><span>${rqt?.formationCurrentFormation}</span></dd>
          
        </dl>
        
      
    </div>
    <!-- column end -->
    
    <!-- column start -->
    <div class="yui-u">
      
        
        <h3><g:message code="hcar.property.professionalStatus.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isEmployed-trigger condition-isUnemployed-trigger">${message(code:'hcar.property.professionalStatusKind.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusKind" class="action-editField validate-capdematEnum required-true i18n-hcar.property.professionalStatusKind javatype-fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType" ><g:capdematEnumToField var="${rqt?.professionalStatusKind}" i18nKeyPrefix="hcar.property.professionalStatusKind" /></dd>
          
              <dt class="required">${message(code:'hcar.property.professionalStatusDate.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusDate" class="action-editField validate-date required-true i18n-hcar.property.professionalStatusDate" ><span><g:formatDate formatName="format.date" date="${rqt?.professionalStatusDate}"/></span></dd>
          
              <dt class="required condition-isEmployed-filled">${message(code:'hcar.property.professionalStatusEnvironment.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusEnvironment" class="action-editField validate-capdematEnum required-true i18n-hcar.property.professionalStatusEnvironment javatype-fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType" ><g:capdematEnumToField var="${rqt?.professionalStatusEnvironment}" i18nKeyPrefix="hcar.property.professionalStatusEnvironment" /></dd>
          
              <dt class="required condition-isEmployed-filled">${message(code:'hcar.property.professionalStatusProfession.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusProfession" class="action-editField validate- required-true i18n-hcar.property.professionalStatusProfession maxLength-60" ><span>${rqt?.professionalStatusProfession}</span></dd>
          
              <dt class="required condition-isEmployed-filled">${message(code:'hcar.property.professionalStatusEmployerName.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusEmployerName" class="action-editField validate-lastName required-true i18n-hcar.property.professionalStatusEmployerName maxLength-38" ><span>${rqt?.professionalStatusEmployerName}</span></dd>
          
              <dt class="condition-isEmployed-filled">${message(code:'hcar.property.professionalStatusAddress.label')}&nbsp;:</dt><dd id="professionalStatusAddress" class="action-editField validate-address i18n-hcar.property.professionalStatusAddress" ><div><p class="additionalDeliveryInformation">${rqt?.professionalStatusAddress?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.professionalStatusAddress?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.professionalStatusAddress?.streetNumber}</span> <span class="streetName">${rqt?.professionalStatusAddress?.streetName}</span><g:if test="${!!rqt?.professionalStatusAddress?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.professionalStatusAddress?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.professionalStatusAddress?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.professionalStatusAddress?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.professionalStatusAddress?.placeNameOrService}</p><span class="postalCode">${rqt?.professionalStatusAddress?.postalCode}</span> <span class="city">${rqt?.professionalStatusAddress?.city}</span><p class="countryName">${rqt?.professionalStatusAddress?.countryName}</p><g:if test="${!!rqt?.professionalStatusAddress?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.professionalStatusAddress?.cityInseeCode}</span></g:if></div></dd>
          
              <dt class="required condition-isUnemployed-filled condition-isRegisteredAsUnemployed-trigger">${message(code:'hcar.property.professionalStatusRegisterAsUnemployed.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusRegisterAsUnemployed" class="action-editField validate-boolean required-true i18n-hcar.property.professionalStatusRegisterAsUnemployed" ><span class="value-${rqt?.professionalStatusRegisterAsUnemployed}"><g:message code="message.${rqt?.professionalStatusRegisterAsUnemployed ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isRegisteredAsUnemployed-filled">${message(code:'hcar.property.professionalStatusRegisterAsUnemployedDate.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusRegisterAsUnemployedDate" class="action-editField validate-date required-true i18n-hcar.property.professionalStatusRegisterAsUnemployedDate" ><span><g:formatDate formatName="format.date" date="${rqt?.professionalStatusRegisterAsUnemployedDate}"/></span></dd>
          
              <dt class="required condition-isUnemployed-filled condition-isIndemnified-trigger">${message(code:'hcar.property.professionalStatusIndemnified.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusIndemnified" class="action-editField validate-boolean required-true i18n-hcar.property.professionalStatusIndemnified" ><span class="value-${rqt?.professionalStatusIndemnified}"><g:message code="message.${rqt?.professionalStatusIndemnified ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isIndemnified-filled">${message(code:'hcar.property.professionalStatusIndemnifiedDate.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusIndemnifiedDate" class="action-editField validate-date required-true i18n-hcar.property.professionalStatusIndemnifiedDate" ><span><g:formatDate formatName="format.date" date="${rqt?.professionalStatusIndemnifiedDate}"/></span></dd>
          
              <dt class="required condition-isElectiveFunction-trigger">${message(code:'hcar.property.professionalStatusElectiveFunction.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusElectiveFunction" class="action-editField validate-boolean required-true i18n-hcar.property.professionalStatusElectiveFunction" ><span class="value-${rqt?.professionalStatusElectiveFunction}"><g:message code="message.${rqt?.professionalStatusElectiveFunction ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="required condition-isElectiveFunction-filled">${message(code:'hcar.property.professionalStatusElectiveFunctionDetails.label')}&nbsp;*&nbsp;:</dt><dd id="professionalStatusElectiveFunctionDetails" class="action-editField validate- required-true i18n-hcar.property.professionalStatusElectiveFunctionDetails maxLength-60" ><span>${rqt?.professionalStatusElectiveFunctionDetails}</span></dd>
          
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
    <span><g:message code="hcar.step.folders.label" /></span>
  </h2>
  <div class="yui-g">
    
    
    <!-- column start -->
    <div class="yui-u first">
      
        
        <h3><g:message code="hcar.property.folders.label" /></h3>
        <dl class="required">
          
              <dt class="required condition-isMDPH-trigger">${message(code:'hcar.property.foldersMdph.label')}&nbsp;*&nbsp;:</dt><dd id="foldersMdph" class="action-editField validate-boolean required-true i18n-hcar.property.foldersMdph" ><span class="value-${rqt?.foldersMdph}"><g:message code="message.${rqt?.foldersMdph ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isMDPH-filled">${message(code:'hcar.property.foldersMdphNumber.label')}&nbsp;:</dt><dd id="foldersMdphNumber" class="action-editField validate- i18n-hcar.property.foldersMdphNumber maxLength-30" ><span>${rqt?.foldersMdphNumber}</span></dd>
          
              <dt class="condition-isMDPH-filled">${message(code:'hcar.property.foldersMdphDepartment.label')}&nbsp;:</dt><dd id="foldersMdphDepartment" class="action-editField validate-departmentCode i18n-hcar.property.foldersMdphDepartment maxLength-2" ><span>${rqt?.foldersMdphDepartment}</span></dd>
          
              <dt class="required condition-isCOTOREP-trigger">${message(code:'hcar.property.foldersCotorep.label')}&nbsp;*&nbsp;:</dt><dd id="foldersCotorep" class="action-editField validate-boolean required-true i18n-hcar.property.foldersCotorep" ><span class="value-${rqt?.foldersCotorep}"><g:message code="message.${rqt?.foldersCotorep ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isCOTOREP-filled">${message(code:'hcar.property.foldersCotorepNumber.label')}&nbsp;:</dt><dd id="foldersCotorepNumber" class="action-editField validate- i18n-hcar.property.foldersCotorepNumber maxLength-30" ><span>${rqt?.foldersCotorepNumber}</span></dd>
          
              <dt class="condition-isCOTOREP-filled">${message(code:'hcar.property.foldersCotorepDepartment.label')}&nbsp;:</dt><dd id="foldersCotorepDepartment" class="action-editField validate-departmentCode i18n-hcar.property.foldersCotorepDepartment maxLength-2" ><span>${rqt?.foldersCotorepDepartment}</span></dd>
          
              <dt class="required condition-isCDES-trigger">${message(code:'hcar.property.foldersCdes.label')}&nbsp;*&nbsp;:</dt><dd id="foldersCdes" class="action-editField validate-boolean required-true i18n-hcar.property.foldersCdes" ><span class="value-${rqt?.foldersCdes}"><g:message code="message.${rqt?.foldersCdes ? 'yes' : 'no'}" /></span></dd>
          
              <dt class="condition-isCDES-filled">${message(code:'hcar.property.foldersCdesNumber.label')}&nbsp;:</dt><dd id="foldersCdesNumber" class="action-editField validate- i18n-hcar.property.foldersCdesNumber maxLength-30" ><span>${rqt?.foldersCdesNumber}</span></dd>
          
              <dt class="condition-isCDES-filled">${message(code:'hcar.property.foldersCdesDepartment.label')}&nbsp;:</dt><dd id="foldersCdesDepartment" class="action-editField validate-departmentCode i18n-hcar.property.foldersCdesDepartment maxLength-2" ><span>${rqt?.foldersCdesDepartment}</span></dd>
          
              <dt class="required condition-isOtherFolders-trigger">${message(code:'hcar.property.foldersOtherFolders.label')}&nbsp;*&nbsp;:</dt><dd id="foldersOtherFolders" class="action-editField validate-boolean required-true i18n-hcar.property.foldersOtherFolders" ><span class="value-${rqt?.foldersOtherFolders}"><g:message code="message.${rqt?.foldersOtherFolders ? 'yes' : 'no'}" /></span></dd>
          
        </dl>
        
      
        
        <div id="widget-otherFolders" class="condition-isOtherFolders-filled">
          <g:render template="/backofficeRequestInstruction/requestType/handicapCompensationAdultRequest/otherFolders" model="['rqt':rqt]" />
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

