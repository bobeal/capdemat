


  
    <h3><g:message code="dhr.step.subject.label" /></h3>
    
      
      <h4><g:message code="dhr.property.dhrRequester.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

        
          <dt><g:message code="dhr.property.dhrRequesterBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.dhrRequesterBirthDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrRequesterBirthPlace.label" /></dt><dd>${rqt.dhrRequesterBirthPlace?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrRequesterNationality.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrRequesterNationality}">
              <g:capdematEnumToField var="${rqt.dhrRequesterNationality}" i18nKeyPrefix="dhr.property.dhrRequesterNationality" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.dhrRequesterFranceArrivalDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /></dt>
          <dd><g:message code="message.${rqt.dhrRequesterIsFrenchResident ? 'yes' : 'no'}" /></dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrPrincipalPensionPlan}">
              <g:capdematEnumToField var="${rqt.dhrPrincipalPensionPlan}" i18nKeyPrefix="dhr.property.dhrPrincipalPensionPlan" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrPensionPlanDetail.label" /></dt><dd>${rqt.dhrPensionPlanDetail?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /></dt><dd>${rqt.dhrComplementaryPensionPlan?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="dhr.property.dhrRequesterGuardian.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /></dt>
          <dd><g:message code="message.${rqt.dhrRequesterHaveGuardian ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="dhr.property.dhrGuardianMeasure.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrGuardianMeasure}">
              <g:capdematEnumToField var="${rqt.dhrGuardianMeasure}" i18nKeyPrefix="dhr.property.dhrGuardianMeasure" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrGuardianName.label" /></dt><dd>${rqt.dhrGuardianName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrGuardianAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.dhrGuardianAddress}">
              <p>${rqt.dhrGuardianAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dhrGuardianAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dhrGuardianAddress?.streetNumber} ${rqt.dhrGuardianAddress?.streetName}</p>
              <p>${rqt.dhrGuardianAddress?.placeNameOrService}</p>
              <p>${rqt.dhrGuardianAddress?.postalCode} ${rqt.dhrGuardianAddress?.city}</p>
              <p>${rqt.dhrGuardianAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
      </dl>
      
    
  

  
    <h3><g:message code="dhr.step.familyReferent.label" /></h3>
    
      
      <h4><g:message code="dhr.property.dhrFamilyReferent.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.dhrHaveFamilyReferent.label" /></dt>
          <dd><g:message code="message.${rqt.dhrHaveFamilyReferent ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="dhr.property.dhrReferentName.label" /></dt><dd>${rqt.dhrReferentName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrReferentFirstName.label" /></dt><dd>${rqt.dhrReferentFirstName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrReferentAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.dhrReferentAddress}">
              <p>${rqt.dhrReferentAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dhrReferentAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dhrReferentAddress?.streetNumber} ${rqt.dhrReferentAddress?.streetName}</p>
              <p>${rqt.dhrReferentAddress?.placeNameOrService}</p>
              <p>${rqt.dhrReferentAddress?.postalCode} ${rqt.dhrReferentAddress?.city}</p>
              <p>${rqt.dhrReferentAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
      </dl>
      
    
  

  
    <h3><g:message code="dhr.step.spouse.label" /></h3>
    
      
      <h4><g:message code="dhr.property.dhrSpouse.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.dhrRequestKind.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrRequestKind}">
              <g:capdematEnumToField var="${rqt.dhrRequestKind}" i18nKeyPrefix="dhr.property.dhrRequestKind" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrSpouseTitle.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrSpouseTitle}">
              <g:capdematEnumToField var="${rqt.dhrSpouseTitle}" i18nKeyPrefix="dhr.property.dhrSpouseTitle" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrSpouseFamilyStatus.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrSpouseFamilyStatus}">
              <g:capdematEnumToField var="${rqt.dhrSpouseFamilyStatus}" i18nKeyPrefix="dhr.property.dhrSpouseFamilyStatus" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrSpouseName.label" /></dt><dd>${rqt.dhrSpouseName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseFirstName.label" /></dt><dd>${rqt.dhrSpouseFirstName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseMaidenName.label" /></dt><dd>${rqt.dhrSpouseMaidenName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.dhrSpouseBirthDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrSpouseBirthPlace.label" /></dt><dd>${rqt.dhrSpouseBirthPlace?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseNationality.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrSpouseNationality}">
              <g:capdematEnumToField var="${rqt.dhrSpouseNationality}" i18nKeyPrefix="dhr.property.dhrSpouseNationality" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrSpouseFranceArrivalDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.dhrSpouseFranceArrivalDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrSpouseIsFrenchResident.label" /></dt>
          <dd><g:message code="message.${rqt.dhrSpouseIsFrenchResident ? 'yes' : 'no'}" /></dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dhr.property.dhrSpouseStatus.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.dhrIsSpouseRetired.label" /></dt>
          <dd><g:message code="message.${rqt.dhrIsSpouseRetired ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrSpousePrincipalPensionPlan}">
              <g:capdematEnumToField var="${rqt.dhrSpousePrincipalPensionPlan}" i18nKeyPrefix="dhr.property.dhrSpousePrincipalPensionPlan" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrSpousePensionPlanDetail.label" /></dt><dd>${rqt.dhrSpousePensionPlanDetail?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.label" /></dt><dd>${rqt.dhrSpouseComplementaryPensionPlan?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseProfession.label" /></dt><dd>${rqt.dhrSpouseProfession?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseEmployer.label" /></dt><dd>${rqt.dhrSpouseEmployer?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrSpouseAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.dhrSpouseAddress}">
              <p>${rqt.dhrSpouseAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dhrSpouseAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dhrSpouseAddress?.streetNumber} ${rqt.dhrSpouseAddress?.streetName}</p>
              <p>${rqt.dhrSpouseAddress?.placeNameOrService}</p>
              <p>${rqt.dhrSpouseAddress?.postalCode} ${rqt.dhrSpouseAddress?.city}</p>
              <p>${rqt.dhrSpouseAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dhr.property.dhrSpouseIncomes.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.pensions.label" /></dt><dd>${rqt.pensions?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrAllowances.label" /></dt><dd>${rqt.dhrAllowances?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /></dt><dd>${rqt.dhrFurnitureInvestmentIncome?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /></dt><dd>${rqt.dhrRealEstateInvestmentIncome?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrNetIncome.label" /></dt><dd>${rqt.dhrNetIncome?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="dhr.step.dwelling.label" /></h3>
    
      
      <h4><g:message code="dhr.property.dhrCurrentDwelling.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /></dt>
          <dd>
          <g:if test="${rqt.dhrCurrentDwellingAddress}">
              <p>${rqt.dhrCurrentDwellingAddress?.additionalDeliveryInformation}</p>
              <p>${rqt.dhrCurrentDwellingAddress?.additionalGeographicalInformation}</p>
              <p>${rqt.dhrCurrentDwellingAddress?.streetNumber} ${rqt.dhrCurrentDwellingAddress?.streetName}</p>
              <p>${rqt.dhrCurrentDwellingAddress?.placeNameOrService}</p>
              <p>${rqt.dhrCurrentDwellingAddress?.postalCode} ${rqt.dhrCurrentDwellingAddress?.city}</p>
              <p>${rqt.dhrCurrentDwellingAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrCurrentDwellingPhone.label" /></dt><dd>${rqt.dhrCurrentDwellingPhone?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrCurrentDwellingKind.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrCurrentDwellingKind}">
              <g:capdematEnumToField var="${rqt.dhrCurrentDwellingKind}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingKind" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.dhrCurrentDwellingArrivalDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /></dt>
          <dd>
            <g:if test="${rqt.dhrCurrentDwellingStatus}">
              <g:capdematEnumToField var="${rqt.dhrCurrentDwellingStatus}" i18nKeyPrefix="dhr.property.dhrCurrentDwellingStatus" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /></dt><dd>${rqt.dhrCurrentDwellingNumberOfRoom?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /></dt><dd>${rqt.dhrCurrentDwellingNetArea?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="dhr.property.dhrPreviousDwelling.label" /></h4>
      <g:each var="it" in="${rqt.dhrPreviousDwelling}" status="index">
      <dl>
        
          <dt><g:message code="dhr.property.dhrPreviousDwellingAddress.label" /></dt>
          <dd>
          <g:if test="${it.dhrPreviousDwellingAddress}">
              <p>${it.dhrPreviousDwellingAddress?.additionalDeliveryInformation}</p>
              <p>${it.dhrPreviousDwellingAddress?.additionalGeographicalInformation}</p>
              <p>${it.dhrPreviousDwellingAddress?.streetNumber} ${it.dhrPreviousDwellingAddress?.streetName}</p>
              <p>${it.dhrPreviousDwellingAddress?.placeNameOrService}</p>
              <p>${it.dhrPreviousDwellingAddress?.postalCode} ${it.dhrPreviousDwellingAddress?.city}</p>
              <p>${it.dhrPreviousDwellingAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrPreviousDwellingKind.label" /></dt>
          <dd>
            <g:if test="${it.dhrPreviousDwellingKind}">
              <g:capdematEnumToField var="${it.dhrPreviousDwellingKind}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingKind" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrPreviousDwellingStatus.label" /></dt>
          <dd>
            <g:if test="${it.dhrPreviousDwellingStatus}">
              <g:capdematEnumToField var="${it.dhrPreviousDwellingStatus}" i18nKeyPrefix="dhr.property.dhrPreviousDwellingStatus" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrPreviousDwellingArrivalDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingArrivalDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrPreviousDwellingDepartureDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${it.dhrPreviousDwellingDepartureDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrPreviousDwellingComment.label" /></dt><dd>${it.dhrPreviousDwellingComment?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
  

  
    <h3><g:message code="dhr.step.resources.label" /></h3>
    
      
      <h4><g:message code="dhr.property.dhrRequesterIncomes.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.pensions.label" /></dt><dd>${rqt.pensions?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrAllowances.label" /></dt><dd>${rqt.dhrAllowances?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /></dt><dd>${rqt.dhrFurnitureInvestmentIncome?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /></dt><dd>${rqt.dhrRealEstateInvestmentIncome?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrNetIncome.label" /></dt><dd>${rqt.dhrNetIncome?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="dhr.property.dhrRealAsset.label" /></h4>
      <g:each var="it" in="${rqt.dhrRealAsset}" status="index">
      <dl>
        
          <dt><g:message code="dhr.property.dhrRealAssetAddress.label" /></dt>
          <dd>
          <g:if test="${it.dhrRealAssetAddress}">
              <p>${it.dhrRealAssetAddress?.additionalDeliveryInformation}</p>
              <p>${it.dhrRealAssetAddress?.additionalGeographicalInformation}</p>
              <p>${it.dhrRealAssetAddress?.streetNumber} ${it.dhrRealAssetAddress?.streetName}</p>
              <p>${it.dhrRealAssetAddress?.placeNameOrService}</p>
              <p>${it.dhrRealAssetAddress?.postalCode} ${it.dhrRealAssetAddress?.city}</p>
              <p>${it.dhrRealAssetAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrRealAssetValue.label" /></dt><dd>${it.dhrRealAssetValue?.toString()}</dd>

        
          <dt><g:message code="dhr.property.realAssetNetFloorArea.label" /></dt><dd>${it.realAssetNetFloorArea?.toString()}</dd>

        
      </dl>
      </g:each>
      
    
      
      <h4><g:message code="dhr.property.dhrNotRealAsset.label" /></h4>
      <g:each var="it" in="${rqt.dhrNotRealAsset}" status="index">
      <dl>
        
          <dt><g:message code="dhr.property.dhrNotRealAssetType.label" /></dt>
          <dd>
            <g:if test="${it.dhrNotRealAssetType}">
              <g:capdematEnumToField var="${it.dhrNotRealAssetType}" i18nKeyPrefix="dhr.property.dhrNotRealAssetType" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrNotRealAssetKind.label" /></dt>
          <dd>
            <g:if test="${it.dhrNotRealAssetKind}">
              <g:capdematEnumToField var="${it.dhrNotRealAssetKind}" i18nKeyPrefix="dhr.property.dhrNotRealAssetKind" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrNotRealAssetAddress.label" /></dt>
          <dd>
          <g:if test="${it.dhrNotRealAssetAddress}">
              <p>${it.dhrNotRealAssetAddress?.additionalDeliveryInformation}</p>
              <p>${it.dhrNotRealAssetAddress?.additionalGeographicalInformation}</p>
              <p>${it.dhrNotRealAssetAddress?.streetNumber} ${it.dhrNotRealAssetAddress?.streetName}</p>
              <p>${it.dhrNotRealAssetAddress?.placeNameOrService}</p>
              <p>${it.dhrNotRealAssetAddress?.postalCode} ${it.dhrNotRealAssetAddress?.city}</p>
              <p>${it.dhrNotRealAssetAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryName.label" /></dt><dd>${it.dhrNotRealAssetBeneficiaryName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryFirstName.label" /></dt><dd>${it.dhrNotRealAssetBeneficiaryFirstName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrNotRealAssetBeneficiaryAddress.label" /></dt>
          <dd>
          <g:if test="${it.dhrNotRealAssetBeneficiaryAddress}">
              <p>${it.dhrNotRealAssetBeneficiaryAddress?.additionalDeliveryInformation}</p>
              <p>${it.dhrNotRealAssetBeneficiaryAddress?.additionalGeographicalInformation}</p>
              <p>${it.dhrNotRealAssetBeneficiaryAddress?.streetNumber} ${it.dhrNotRealAssetBeneficiaryAddress?.streetName}</p>
              <p>${it.dhrNotRealAssetBeneficiaryAddress?.placeNameOrService}</p>
              <p>${it.dhrNotRealAssetBeneficiaryAddress?.postalCode} ${it.dhrNotRealAssetBeneficiaryAddress?.city}</p>
              <p>${it.dhrNotRealAssetBeneficiaryAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
          <dt><g:message code="dhr.property.dhrNotRealAssetValue.label" /></dt><dd>${it.dhrNotRealAssetValue?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrNotRealAssetDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${it.dhrNotRealAssetDate}"/></dd>
          

        
          <dt><g:message code="dhr.property.dhrNotRealAssetNotaryName.label" /></dt><dd>${it.dhrNotRealAssetNotaryName?.toString()}</dd>

        
          <dt><g:message code="dhr.property.dhrNotRealAssetNotaryAddress.label" /></dt>
          <dd>
          <g:if test="${it.dhrNotRealAssetNotaryAddress}">
              <p>${it.dhrNotRealAssetNotaryAddress?.additionalDeliveryInformation}</p>
              <p>${it.dhrNotRealAssetNotaryAddress?.additionalGeographicalInformation}</p>
              <p>${it.dhrNotRealAssetNotaryAddress?.streetNumber} ${it.dhrNotRealAssetNotaryAddress?.streetName}</p>
              <p>${it.dhrNotRealAssetNotaryAddress?.placeNameOrService}</p>
              <p>${it.dhrNotRealAssetNotaryAddress?.postalCode} ${it.dhrNotRealAssetNotaryAddress?.city}</p>
              <p>${it.dhrNotRealAssetNotaryAddress?.countryName}</p>
          </g:if>
          </dd>
          

        
      </dl>
      </g:each>
      
    
  

  
    <h3><g:message code="dhr.step.taxes.label" /></h3>
    
      
      <h4><g:message code="dhr.property.dhrTaxesAmount.label" /></h4>
      <dl>
        
          <dt><g:message code="dhr.property.dhrIncomeTax.label" /></dt><dd>${rqt.dhrIncomeTax?.toString()}</dd>

        
          <dt><g:message code="dhr.property.localRate.label" /></dt><dd>${rqt.localRate?.toString()}</dd>

        
          <dt><g:message code="dhr.property.propertyTaxes.label" /></dt><dd>${rqt.propertyTaxes?.toString()}</dd>

        
          <dt><g:message code="dhr.property.professionalTaxes.label" /></dt><dd>${rqt.professionalTaxes?.toString()}</dd>

        
      </dl>
      
    
  

  
  <g:if test="${!documentsByTypes.isEmpty()}">
    <h3>${message(code:'request.step.document.label')}</h3>
    <g:each in="${documentsByTypes}" var="documentType">
      <h4>${message(code:documentType.value.name)}</h4>
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">${message(code:'document.header.description')} : ${document.ecitizenNote}<br/></g:if>
          <g:if test="${document.endValidityDate}">${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">${message(code:'document.message.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


