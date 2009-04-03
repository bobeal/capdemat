


  
  <h3><g:message code="hccr.step.aid.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.familyAssistance.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.isFamilyAssistance.label" /></dt>
          <dd><g:message code="message.${rqt.isFamilyAssistance ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.familyAssistanceMembers.label" /></h4>
    <g:each var="it" in="${rqt.familyAssistanceMembers}" status="index">
    <dl>
      
        <dt><g:message code="hccr.property.familyAssistanceMemberRelationship.label" /></dt><dd>${it.familyAssistanceMemberRelationship}</dd>

      
        <dt><g:message code="hccr.property.familyAssistanceMemberLastName.label" /></dt><dd>${it.familyAssistanceMemberLastName}</dd>

      
        <dt><g:message code="hccr.property.familyAssistanceMemberFirstName.label" /></dt><dd>${it.familyAssistanceMemberFirstName}</dd>

      
    </dl>
    </g:each>
    
  
    
    <h4><g:message code="hccr.property.homeIntervention.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.homeInterventionHomeIntervenant.label" /></dt>
          <dd><g:message code="message.${rqt.homeInterventionHomeIntervenant ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.homeIntervenants.label" /></h4>
    <g:each var="it" in="${rqt.homeIntervenants}" status="index">
    <dl>
      
        <dt><g:message code="hccr.property.homeIntervenantKind.label" /></dt>
          <dd>
            <g:if test="${it.homeIntervenantKind}">
              <g:capdematEnumToField var="${it.homeIntervenantKind}" i18nKeyPrefix="hccr.property.homeIntervenantKind" />
            </g:if>
          </dd>
          

      
        <dt><g:message code="hccr.property.homeIntervenantDetails.label" /></dt><dd>${it.homeIntervenantDetails}</dd>

      
    </dl>
    </g:each>
    
  
    
    <h4><g:message code="hccr.property.care.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.careCareServices.label" /></dt>
          <dd><g:message code="message.${rqt.careCareServices ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.careServices.label" /></h4>
    <g:each var="it" in="${rqt.careServices}" status="index">
    <dl>
      
        <dt><g:message code="hccr.property.careServiceKind.label" /></dt><dd>${it.careServiceKind}</dd>

      
        <dt><g:message code="hccr.property.careServiceCareServiceEmployer.label" /></dt>
          <dd><g:message code="message.${it.careServiceCareServiceEmployer ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.careServiceProviderName.label" /></dt><dd>${it.careServiceProviderName}</dd>

      
        <dt><g:message code="hccr.property.careServiceProviderAddress.label" /></dt>
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
    
  
    
    <h4><g:message code="hccr.property.facilities.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.facilitiesHousing.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesHousing ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.facilitiesHousingDetails.label" /></dt><dd>${rqt.facilitiesHousingDetails}</dd>

      
        <dt><g:message code="hccr.property.facilitiesTechnicalAssistance.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesTechnicalAssistance ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.facilitiesTechnicalAssistanceDetails.label" /></dt><dd>${rqt.facilitiesTechnicalAssistanceDetails}</dd>

      
        <dt><g:message code="hccr.property.facilitiesCustomCar.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesCustomCar ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.facilitiesCustomCarDetails.label" /></dt><dd>${rqt.facilitiesCustomCarDetails}</dd>

      
        <dt><g:message code="hccr.property.facilitiesAnimalAid.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesAnimalAid ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.facilitiesAnimalAidDetails.label" /></dt><dd>${rqt.facilitiesAnimalAidDetails}</dd>

      
        <dt><g:message code="hccr.property.facilitiesSpecializedTransport.label" /></dt>
          <dd><g:message code="message.${rqt.facilitiesSpecializedTransport ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.facilitiesSpecializedTransportDetails.label" /></dt><dd>${rqt.facilitiesSpecializedTransportDetails}</dd>

      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.professionalSupport.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.professionalSupportProfessionals.label" /></dt>
          <dd><g:message code="message.${rqt.professionalSupportProfessionals ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.professionalSupportDealsWithSameProfessional.label" /></dt>
          <dd><g:message code="message.${rqt.professionalSupportDealsWithSameProfessional ? 'yes' : 'no'}" /></dd>
          

      
    </dl>
    
  
    
    <h4><g:message code="hccr.property.professionals.label" /></h4>
    <g:each var="it" in="${rqt.professionals}" status="index">
    <dl>
      
        <dt><g:message code="hccr.property.professionalLastName.label" /></dt><dd>${it.professionalLastName}</dd>

      
        <dt><g:message code="hccr.property.professionalFirstName.label" /></dt><dd>${it.professionalFirstName}</dd>

      
        <dt><g:message code="hccr.property.professionalAddress.label" /></dt>
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
    
  
    
    <h4><g:message code="hccr.property.socialService.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.socialServiceSupport.label" /></dt>
          <dd><g:message code="message.${rqt.socialServiceSupport ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.socialServiceName.label" /></dt><dd>${rqt.socialServiceName}</dd>

      
        <dt><g:message code="hccr.property.socialServiceAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.socialServiceAddress}">
              <p>${rqt.socialServiceAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.socialServiceAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.socialServiceAddress?.streetNumber} ${rqt.socialServiceAddress?.streetName}</p>
              <p>${rqt.socialServiceAddress?.placeNameOrService}</p>
              <p>${rqt.socialServiceAddress?.postalCode} ${rqt.socialServiceAddress?.city}</p>
              <p>${rqt.socialServiceAddress?.countryName}</p>
          </g:if>
          </dd>
          

      
    </dl>
    
  

  
  <h3><g:message code="hccr.step.health.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.health.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.healthFollowedByDoctor.label" /></dt>
          <dd><g:message code="message.${rqt.healthFollowedByDoctor ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.healthDoctorLastName.label" /></dt><dd>${rqt.healthDoctorLastName}</dd>

      
        <dt><g:message code="hccr.property.healthDoctorFirstName.label" /></dt><dd>${rqt.healthDoctorFirstName}</dd>

      
        <dt><g:message code="hccr.property.healthFollowedByProfessional.label" /></dt>
          <dd><g:message code="message.${rqt.healthFollowedByProfessional ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.healthProfessionalLastName.label" /></dt><dd>${rqt.healthProfessionalLastName}</dd>

      
        <dt><g:message code="hccr.property.healthProfessionalFirstName.label" /></dt><dd>${rqt.healthProfessionalFirstName}</dd>

      
        <dt><g:message code="hccr.property.healthFollowedByHospital.label" /></dt>
          <dd><g:message code="message.${rqt.healthFollowedByHospital ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.healthHospitalName.label" /></dt><dd>${rqt.healthHospitalName}</dd>

      
    </dl>
    
  

  
  <h3><g:message code="hccr.step.project.label" /></h3>
  
  
    
    <h4><g:message code="hccr.property.projectRequests.label" /></h4>
    <dl>
      
        <dt><g:message code="hccr.property.projectRequestsHandicapRecognition.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsHandicapRecognition ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsDisabilityCard.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabilityCard ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsDisabledPriorityCard.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabledPriorityCard ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsEuropeanParkingCard.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsEuropeanParkingCard ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsDisabledAdultAllowance.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabledAdultAllowance ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsIncreaseForIndependentLiving.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsIncreaseForIndependentLiving ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsEducationAllocationOfDisabledChildren.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsEducationAllocationOfDisabledChildren ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsACTPRenewal.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsACTPRenewal ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsThirdPartyHelp.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsThirdPartyHelp ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsFreePensionMembership.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsFreePensionMembership ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsTechnicalHelp.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsTechnicalHelp ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsHousingFacilities.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsHousingFacilities ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsCustomCar.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsCustomCar ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsAssistance.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsAssistance ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsTransportCostAllocation.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsTransportCostAllocation ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsDisabilityCostAllocation.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabilityCostAllocation ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsDisabledWorkerRecognition.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsDisabledWorkerRecognition ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsProfessionalOrientation.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsProfessionalOrientation ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsOrdinaryWorking.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsOrdinaryWorking ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsShelteredWork.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsShelteredWork ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsVocationalTraining.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsVocationalTraining ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsInstitutionSupport.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsInstitutionSupport ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsOther.label" /></dt>
          <dd><g:message code="message.${rqt.projectRequestsOther ? 'yes' : 'no'}" /></dd>
          

      
        <dt><g:message code="hccr.property.projectRequestsOtherDetails.label" /></dt><dd>${rqt.projectRequestsOtherDetails}</dd>

      
    </dl>
    
  
    
      <dl>
      <dt><g:message code="hccr.property.projectWish.label" /></dt><dd>${rqt.projectWish}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="hccr.property.projectNeeds.label" /></dt><dd>${rqt.projectNeeds}</dd>

      </dl>
    
  
    
      <dl>
      <dt><g:message code="hccr.property.projectComments.label" /></dt><dd>${rqt.projectComments}</dd>

      </dl>
    
  

  
  <g:if test="${!documentTypes.isEmpty()}">
    <h3><g:message code="request.step.document.label" /></h3>
    <g:each in="${documentTypes}" var="documentType">
      <h4>${message(code:documentType.value.name)}</h4>
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">description : ${document.ecitizenNote}<br/></g:if>
          <g:if test="${document.endValidityDate}">expire le ${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:if test="${document.isNew}"><span class="tag-state tag-active">nouveau</span></g:if>
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank">aperçu</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        Aucun document joint
      </g:else>
    </g:each>
  </g:if>
  
  

  
  


