


  
  <h3><g:message code="hcar.step.aid.label" /></h3>
  
  
    
    <h4><g:message code="hcar.property.familyAssistance.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.isFamilyAssistance.label" /></dt>
          <dd><g:message code="message.${rqt.isFamilyAssistance ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hcar.property.familyAssistanceMembers.label" /></h4>
    <g:each var="it" in="${rqt.familyAssistanceMembers}" status="index">
    <dl>
      
        <dt><g:message code="hcar.property.familyAssistanceMemberRelationship.label" /></dt><dd>${it.familyAssistanceMemberRelationship}</dd>

      
        <dt><g:message code="hcar.property.familyAssistanceMemberLastName.label" /></dt><dd>${it.familyAssistanceMemberLastName}</dd>

      
        <dt><g:message code="hcar.property.familyAssistanceMemberFirstName.label" /></dt><dd>${it.familyAssistanceMemberFirstName}</dd>

      
    </dl>
    </g:each>
    
  
    
    <h4><g:message code="hcar.property.homeIntervention.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.homeInterventionHomeIntervenant.label" /></dt>
          <dd><g:message code="message.${rqt.homeInterventionHomeIntervenant ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hcar.property.homeIntervenants.label" /></h4>
    <g:each var="it" in="${rqt.homeIntervenants}" status="index">
    <dl>
      
        <dt><g:message code="hcar.property.homeIntervenantKind.label" /></dt>
          <dd>
            <g:if test="${it.homeIntervenantKind}">
              <g:capdematEnumToField var="${it.homeIntervenantKind}" i18nKeyPrefix="hcar.property.homeIntervenantKind" />
            </g:if>
          </dd>
          

      
        <dt><g:message code="hcar.property.homeIntervenantDetails.label" /></dt><dd>${it.homeIntervenantDetails}</dd>

      
    </dl>
    </g:each>
    
  
    
    <h4><g:message code="hcar.property.care.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.careCareServices.label" /></dt>
          <dd><g:message code="message.${rqt.careCareServices ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hcar.property.careServices.label" /></h4>
    <g:each var="it" in="${rqt.careServices}" status="index">
    <dl>
      
        <dt><g:message code="hcar.property.careServiceKind.label" /></dt><dd>${it.careServiceKind}</dd>

      
        <dt><g:message code="hcar.property.careServiceCareServiceEmployer.label" /></dt>
          <dd><g:message code="message.${it.careServiceCareServiceEmployer ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.careServiceProviderName.label" /></dt><dd>${it.careServiceProviderName}</dd>

      
        <dt><g:message code="hcar.property.careServiceProviderAddress.label" /></dt>
          <dd>
          <g:if test="${it.careServiceProviderAddress}">
              <p>${it.careServiceProviderAddress?.additionalDeliveryInformation}</p>
              <p>${it.careServiceProviderAddress?.additionalGeographicalInformation}</p>
              <p>${it.careServiceProviderAddress?.streetNumber} ${it.careServiceProviderAddress?.streetName}</p>
              <p>${it.careServiceProviderAddress?.placeNameOrService}</p>
              <p>${it.careServiceProviderAddress?.postalCode} ${it.careServiceProviderAddress?.city}</p>
              <p>${it.careServiceProviderAddress?.countryName}</p>
          </g:if>
          </dd>
          

      
    </dl>
    </g:each>
    
  
    
    <h4><g:message code="hcar.property.facilities.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.facilitiesHousing.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesHousing ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.facilitiesHousingDetails.label" /></dt><dd>${rqt.facilitiesHousingDetails}</dd>

      
        <dt><g:message code="hcar.property.facilitiesTechnicalAssistance.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesTechnicalAssistance ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.facilitiesTechnicalAssistanceDetails.label" /></dt><dd>${rqt.facilitiesTechnicalAssistanceDetails}</dd>

      
        <dt><g:message code="hcar.property.facilitiesCustomCar.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesCustomCar ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.facilitiesCustomCarDetails.label" /></dt><dd>${rqt.facilitiesCustomCarDetails}</dd>

      
        <dt><g:message code="hcar.property.facilitiesAnimalAid.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesAnimalAid ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.facilitiesAnimalAidDetails.label" /></dt><dd>${rqt.facilitiesAnimalAidDetails}</dd>

      
        <dt><g:message code="hcar.property.facilitiesSpecializedTransport.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesSpecializedTransport ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.facilitiesSpecializedTransportDetails.label" /></dt><dd>${rqt.facilitiesSpecializedTransportDetails}</dd>

      
    </dl>
    
  
    
    <h4><g:message code="hcar.property.professionalSupport.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.professionalSupportProfessionals.label" /></dt>
          <dd><g:message code="message.${rqt.professionalSupportProfessionals ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.professionalSupportDealsWithSameProfessional.label" /></dt>
          <dd><g:message code="message.${rqt.professionalSupportDealsWithSameProfessional ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hcar.property.professionals.label" /></h4>
    <g:each var="it" in="${rqt.professionals}" status="index">
    <dl>
      
        <dt><g:message code="hcar.property.professionalLastName.label" /></dt><dd>${it.professionalLastName}</dd>

      
        <dt><g:message code="hcar.property.professionalFirstName.label" /></dt><dd>${it.professionalFirstName}</dd>

      
        <dt><g:message code="hcar.property.professionalAddress.label" /></dt>
          <dd>
          <g:if test="${it.professionalAddress}">
              <p>${it.professionalAddress?.additionalDeliveryInformation}</p>
              <p>${it.professionalAddress?.additionalGeographicalInformation}</p>
              <p>${it.professionalAddress?.streetNumber} ${it.professionalAddress?.streetName}</p>
              <p>${it.professionalAddress?.placeNameOrService}</p>
              <p>${it.professionalAddress?.postalCode} ${it.professionalAddress?.city}</p>
              <p>${it.professionalAddress?.countryName}</p>
          </g:if>
          </dd>
          

      
    </dl>
    </g:each>
    
  
    
    <h4><g:message code="hcar.property.socialService.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.professionalSupportSocialServiceSupport.label" /></dt>
          <dd><g:message code="message.${rqt.professionalSupportSocialServiceSupport ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.professionalSupportSocialServiceName.label" /></dt><dd>${rqt.professionalSupportSocialServiceName}</dd>

      
        <dt><g:message code="hcar.property.professionalSupportSocialServiceAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.professionalSupportSocialServiceAddress}">
              <p>${rqt.professionalSupportSocialServiceAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.professionalSupportSocialServiceAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.professionalSupportSocialServiceAddress?.streetNumber} ${rqt.professionalSupportSocialServiceAddress?.streetName}</p>
              <p>${rqt.professionalSupportSocialServiceAddress?.placeNameOrService}</p>
              <p>${rqt.professionalSupportSocialServiceAddress?.postalCode} ${rqt.professionalSupportSocialServiceAddress?.city}</p>
              <p>${rqt.professionalSupportSocialServiceAddress?.countryName}</p>
          </g:if>
          </dd>
          

      
    </dl>
    
  

  
  <h3><g:message code="hcar.step.health.label" /></h3>
  
  
    
    <h4><g:message code="hcar.property.health.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.healthFollowedByDoctor.label" /></dt>
          <dd><g:message code="message.${rqt.healthFollowedByDoctor ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.healthDoctorLastName.label" /></dt><dd>${rqt.healthDoctorLastName}</dd>

      
        <dt><g:message code="hcar.property.healthDoctorFirstName.label" /></dt><dd>${rqt.healthDoctorFirstName}</dd>

      
        <dt><g:message code="hcar.property.healthFollowedByProfessional.label" /></dt>
          <dd><g:message code="message.${rqt.healthFollowedByProfessional ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.healthProfessionalLastName.label" /></dt><dd>${rqt.healthProfessionalLastName}</dd>

      
        <dt><g:message code="hcar.property.healthProfessionalFirstName.label" /></dt><dd>${rqt.healthProfessionalFirstName}</dd>

      
        <dt><g:message code="hcar.property.healthFollowedByHospital.label" /></dt>
          <dd><g:message code="message.${rqt.healthFollowedByHospital ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.healthHospitalName.label" /></dt><dd>${rqt.healthHospitalName}</dd>

      
    </dl>
    
  

  
  <h3><g:message code="hcar.step.project.label" /></h3>
  
  
    
    <h4><g:message code="hcar.property.projectRequests.label" /></h4>
    <dl>
      
        <dt><g:message code="hcar.property.projectRequestsHandicapRecognition.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsHandicapRecognition ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsDisabilityCard.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabilityCard ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsDisabledPriorityCard.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabledPriorityCard ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsEuropeanParkingCard.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsEuropeanParkingCard ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsDisabledAdultAllowance.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabledAdultAllowance ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsIncreaseForIndependentLiving.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsEducationAllocationOfDisabledChildren.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsACTPRenewal.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsACTPRenewal ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsThirdPartyHelp.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsThirdPartyHelp ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsFreePensionMembership.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsFreePensionMembership ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsTechnicalHelp.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsTechnicalHelp ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsHousingFacilities.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsHousingFacilities ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsCustomCar.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsCustomCar ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsAssistance.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsAssistance ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsTransportCostAllocation.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsTransportCostAllocation ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsDisabilityCostAllocation.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabilityCostAllocation ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsDisabledWorkerRecognition.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabledWorkerRecognition ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsProfessionalOrientation.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsProfessionalOrientation ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsOrdinaryWorking.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsOrdinaryWorking ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsShelteredWork.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsShelteredWork ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsVocationalTraining.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsVocationalTraining ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsInstitutionSupport.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsInstitutionSupport ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsOther.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsOther ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hcar.property.projectRequestsOtherDetails.label" /></dt><dd>${rqt.projectRequestsOtherDetails}</dd>

      
    </dl>
    
  
    
      <dl>
      <dt><g:message code="hcar.property.projectWish.label" /></dt><dd>${rqt.projectWish}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="hcar.property.projectNeeds.label" /></dt><dd>${rqt.projectNeeds}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="hcar.property.projectComments.label" /></dt><dd>${rqt.projectComments}</dd>

      </dl>
    
  

  
  <g:if test="${!documentTypes.isEmpty()}">
    <h3>${message(code:'request.step.document.label')}</h3>
    <g:each in="${documentTypes}" var="documentType">
      <h4>${message(code:documentType.value.name)}</h4>
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">${message(code:'document.header.description')} : ${document.ecitizenNote}<br/></g:if>
          <g:if test="${document.endValidityDate}">${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:if test="${document.isNew}"><span class="tag-state tag-active">${message(code:'document.header.new')}</span></g:if>
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">${message(code:'document.header.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  
  

  
  


