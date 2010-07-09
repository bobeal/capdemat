


  
    <fieldset class="required">
    <legend><g:message code="dhr.property.dhrSpouse.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrRequestKind.label" /> *  <span><g:message code="dhr.property.dhrRequestKind.help" /></span></label>
            <ul class="required ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrRequestKind') ? 'validation-failed' : ''}">
              <g:each in="${['Individual','Couple']}">
              <li>
                <input type="radio" id="dhrRequestKind_${it}" class="required condition-isCoupleRequest-trigger  validate-one-required" value="fr.cg95.cvq.business.request.social.DhrRequestKindType_${it}" name="dhrRequestKind" ${it == rqt.dhrRequestKind.toString() ? 'checked="checked"': ''} title="<g:message code="dhr.property.dhrRequestKind.validationError" />" />
                <label for="dhrRequestKind_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrRequestKind" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="dhrSpouseTitle" class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseTitle.label" /> *  <span><g:message code="dhr.property.dhrSpouseTitle.help" /></span></label>
            <select id="dhrSpouseTitle" name="dhrSpouseTitle" class="required condition-isCoupleRequest-filled condition-isSpouseMadam-trigger  validate-not-first ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseTitle') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.dhrSpouseTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrSpouseTitle" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrSpouseFamilyStatus" class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseFamilyStatus.label" /> *  <span><g:message code="dhr.property.dhrSpouseFamilyStatus.help" /></span></label>
            <select id="dhrSpouseFamilyStatus" name="dhrSpouseFamilyStatus" class="required condition-isCoupleRequest-filled  validate-not-first ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseFamilyStatus') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseFamilyStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.dhrSpouseFamilyStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrSpouseFamilyStatus" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrSpouseName" class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseName.label" /> *  <span><g:message code="dhr.property.dhrSpouseName.help" /></span></label>
            <input type="text" id="dhrSpouseName" name="dhrSpouseName" value="${rqt.dhrSpouseName?.toString()}" 
                    class="required condition-isCoupleRequest-filled  validate-lastName ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseName.validationError" />"  maxlength="38" />
            

    
      <label for="dhrSpouseFirstName" class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseFirstName.label" /> *  <span><g:message code="dhr.property.dhrSpouseFirstName.help" /></span></label>
            <input type="text" id="dhrSpouseFirstName" name="dhrSpouseFirstName" value="${rqt.dhrSpouseFirstName?.toString()}" 
                    class="required condition-isCoupleRequest-filled  validate-firstName ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseFirstName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseFirstName.validationError" />"  maxlength="38" />
            

    
      <label for="dhrSpouseMaidenName" class="required condition-isSpouseMadam-filled"><g:message code="dhr.property.dhrSpouseMaidenName.label" /> *  <span><g:message code="dhr.property.dhrSpouseMaidenName.help" /></span></label>
            <input type="text" id="dhrSpouseMaidenName" name="dhrSpouseMaidenName" value="${rqt.dhrSpouseMaidenName?.toString()}" 
                    class="required condition-isSpouseMadam-filled  validate-lastName ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseMaidenName') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseMaidenName.validationError" />"  maxlength="38" />
            

    
      <label class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseBirthDate.label" /> *  <span><g:message code="dhr.property.dhrSpouseBirthDate.help" /></span></label>
            <div class="date required condition-isCoupleRequest-filled  validate-date required condition-isCoupleRequest-filled ">
              <select class="day ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseBirthDate') ? 'validation-failed' : ''}"
                id="dhrSpouseBirthDate_day"
                name="dhrSpouseBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrSpouseBirthDate?.date == it
                      || (rqt.dhrSpouseBirthDate == null && params['dhrSpouseBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseBirthDate') ? 'validation-failed' : ''}"
                id="dhrSpouseBirthDate_month"
                name="dhrSpouseBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrSpouseBirthDate?.month == (it - 1)
                      || (rqt.dhrSpouseBirthDate == null && params['dhrSpouseBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseBirthDate') ? 'validation-failed' : ''}"
                id="dhrSpouseBirthDate_year"
                name="dhrSpouseBirthDate_year"
                value="${rqt.dhrSpouseBirthDate ? rqt.dhrSpouseBirthDate.year + 1900 : params['dhrSpouseBirthDate_year']}"
                title="<g:message code="dhr.property.dhrSpouseBirthDate.validationError" />" />
            </div>
            

    
      <label for="dhrSpouseBirthPlace" class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseBirthPlace.label" /> *  <span><g:message code="dhr.property.dhrSpouseBirthPlace.help" /></span></label>
            <input type="text" id="dhrSpouseBirthPlace" name="dhrSpouseBirthPlace" value="${rqt.dhrSpouseBirthPlace?.toString()}" 
                    class="required condition-isCoupleRequest-filled  validate-string ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseBirthPlace') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseBirthPlace.validationError" />"   />
            

    
      <label for="dhrSpouseNationality" class="required condition-isCoupleRequest-filled"><g:message code="dhr.property.dhrSpouseNationality.label" /> *  <span><g:message code="dhr.property.dhrSpouseNationality.help" /></span></label>
            <select id="dhrSpouseNationality" name="dhrSpouseNationality" class="required condition-isCoupleRequest-filled condition-isSpouseNonEuropean-trigger  validate-not-first ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseNationality') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
                <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == rqt.dhrSpouseNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrSpouseNationality" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isSpouseNonEuropean-filled"><g:message code="dhr.property.dhrSpouseFranceArrivalDate.label" /> *  <span><g:message code="dhr.property.dhrSpouseFranceArrivalDate.help" /></span></label>
            <div class="date required condition-isSpouseNonEuropean-filled  validate-date required condition-isSpouseNonEuropean-filled ">
              <select class="day ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseFranceArrivalDate') ? 'validation-failed' : ''}"
                id="dhrSpouseFranceArrivalDate_day"
                name="dhrSpouseFranceArrivalDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrSpouseFranceArrivalDate?.date == it
                      || (rqt.dhrSpouseFranceArrivalDate == null && params['dhrSpouseFranceArrivalDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseFranceArrivalDate') ? 'validation-failed' : ''}"
                id="dhrSpouseFranceArrivalDate_month"
                name="dhrSpouseFranceArrivalDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dhrSpouseFranceArrivalDate?.month == (it - 1)
                      || (rqt.dhrSpouseFranceArrivalDate == null && params['dhrSpouseFranceArrivalDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseFranceArrivalDate') ? 'validation-failed' : ''}"
                id="dhrSpouseFranceArrivalDate_year"
                name="dhrSpouseFranceArrivalDate_year"
                value="${rqt.dhrSpouseFranceArrivalDate ? rqt.dhrSpouseFranceArrivalDate.year + 1900 : params['dhrSpouseFranceArrivalDate_year']}"
                title="<g:message code="dhr.property.dhrSpouseFranceArrivalDate.validationError" />" />
            </div>
            

    
      <label class="required condition-isSpouseNonEuropean-filled"><g:message code="dhr.property.dhrSpouseIsFrenchResident.label" /> *  <span><g:message code="dhr.property.dhrSpouseIsFrenchResident.help" /></span></label>
            <ul class="yes-no required condition-isSpouseNonEuropean-filled ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseIsFrenchResident') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="dhrSpouseIsFrenchResident_${it ? 'yes' : 'no'}" class="required condition-isSpouseNonEuropean-filled  validate-one-required boolean" title="" value="${it}" name="dhrSpouseIsFrenchResident" ${it == rqt.dhrSpouseIsFrenchResident ? 'checked="checked"': ''} />
                <label for="dhrSpouseIsFrenchResident_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-isCoupleRequest-filled">
    <legend><g:message code="dhr.property.dhrSpouseStatus.label" /></legend>
    
      <label class="required"><g:message code="dhr.property.dhrIsSpouseRetired.label" /> *  <span><g:message code="dhr.property.dhrIsSpouseRetired.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrIsSpouseRetired') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="dhrIsSpouseRetired_${it ? 'yes' : 'no'}" class="required condition-isSpouseRetired-trigger  validate-one-required boolean" title="" value="${it}" name="dhrIsSpouseRetired" ${it == rqt.dhrIsSpouseRetired ? 'checked="checked"': ''} />
                <label for="dhrIsSpouseRetired_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="dhrSpousePrincipalPensionPlan" class="required condition-isSpouseRetired-filled"><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.label" /> *  <span><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.help" /></span></label>
            <select id="dhrSpousePrincipalPensionPlan" name="dhrSpousePrincipalPensionPlan" class="required condition-isSpouseRetired-filled condition-isSpouseOtherPensionPlan-trigger  validate-not-first ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpousePrincipalPensionPlan') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpousePrincipalPensionPlan.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
                <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == rqt.dhrSpousePrincipalPensionPlan?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dhr.property.dhrSpousePrincipalPensionPlan" /></option>
              </g:each>
            </select>
            

    
      <label for="dhrSpousePensionPlanDetail" class="required condition-isSpouseOtherPensionPlan-filled"><g:message code="dhr.property.dhrSpousePensionPlanDetail.label" /> *  <span><g:message code="dhr.property.dhrSpousePensionPlanDetail.help" /></span></label>
            <input type="text" id="dhrSpousePensionPlanDetail" name="dhrSpousePensionPlanDetail" value="${rqt.dhrSpousePensionPlanDetail?.toString()}" 
                    class="required condition-isSpouseOtherPensionPlan-filled  validate-string ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpousePensionPlanDetail') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpousePensionPlanDetail.validationError" />"   />
            

    
      <label for="dhrSpouseComplementaryPensionPlan" class="required condition-isSpouseRetired-filled"><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.label" /> *  <span><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.help" /></span></label>
            <input type="text" id="dhrSpouseComplementaryPensionPlan" name="dhrSpouseComplementaryPensionPlan" value="${rqt.dhrSpouseComplementaryPensionPlan?.toString()}" 
                    class="required condition-isSpouseRetired-filled  validate-string ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseComplementaryPensionPlan') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.validationError" />"   />
            

    
      <label for="dhrSpouseProfession" class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseProfession.label" /> *  <span><g:message code="dhr.property.dhrSpouseProfession.help" /></span></label>
            <input type="text" id="dhrSpouseProfession" name="dhrSpouseProfession" value="${rqt.dhrSpouseProfession?.toString()}" 
                    class="required condition-isSpouseRetired-unfilled  validate-string ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseProfession') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseProfession.validationError" />"   />
            

    
      <label for="dhrSpouseEmployer" class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseEmployer.label" /> *  <span><g:message code="dhr.property.dhrSpouseEmployer.help" /></span></label>
            <input type="text" id="dhrSpouseEmployer" name="dhrSpouseEmployer" value="${rqt.dhrSpouseEmployer?.toString()}" 
                    class="required condition-isSpouseRetired-unfilled  validate-string ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseEmployer') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrSpouseEmployer.validationError" />"   />
            

    
      <label class="required condition-isSpouseRetired-unfilled"><g:message code="dhr.property.dhrSpouseAddress.label" /> *  <span><g:message code="dhr.property.dhrSpouseAddress.help" /></span></label>
            <div class="address-fieldset required condition-isSpouseRetired-unfilled  ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress') ? 'validation-failed' : ''}">
            <label for="dhrSpouseAddress.additionalDeliveryInformation"><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.additionalDeliveryInformation') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.additionalDeliveryInformation}" maxlength="38" id="dhrSpouseAddress.additionalDeliveryInformation" name="dhrSpouseAddress.additionalDeliveryInformation" />  
            <label for="dhrSpouseAddress.additionalGeographicalInformation"><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.additionalGeographicalInformation') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.additionalGeographicalInformation}" maxlength="38" id="dhrSpouseAddress.additionalGeographicalInformation" name="dhrSpouseAddress.additionalGeographicalInformation" />
            <label for="dhrSpouseAddress.streetNumber"><g:message code="address.property.streetNumber" /></label> - 
            <label for="dhrSpouseAddress.streetName" class="required"><g:message code="address.property.streetName" /> *</label><br />
            <input type="text" class="line1 validate-streetNumber ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.streetNumber') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.streetNumber}" size="5" maxlength="5" id="dhrSpouseAddress.streetNumber" name="dhrSpouseAddress.streetNumber" />
            <input type="text" class="line2 required validate-streetName ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.streetName') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.streetName}" maxlength="32" id="dhrSpouseAddress.streetName" name="dhrSpouseAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label for="dhrSpouseAddress.placeNameOrService"><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.placeNameOrService') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.placeNameOrService}" maxlength="38" id="dhrSpouseAddress.placeNameOrService" name="dhrSpouseAddress.placeNameOrService" />
            <label for="dhrSpouseAddress.postalCode" class="required"><g:message code="address.property.postalCode" /> * </label> - 
            <label for="dhrSpouseAddress.city" class="required"><g:message code="address.property.city" /> *</label><br />
            <input type="text" class="line1 required validate-postalCode ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.postalCode') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.postalCode}" size="5" maxlength="5" id="dhrSpouseAddress.postalCode" name="dhrSpouseAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required validate-city ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.city') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.city}" maxlength="32" id="dhrSpouseAddress.city" name="dhrSpouseAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label for="dhrSpouseAddress.countryName"><g:message code="address.property.countryName" /></label>
            <input type="text" class="validate-addressLine38 ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrSpouseAddress.countryName') ? 'validation-failed' : ''}" value="${rqt.dhrSpouseAddress?.countryName}" maxlength="38" id="dhrSpouseAddress.countryName" name="dhrSpouseAddress.countryName" />
            </div>
            

    
    </fieldset>
  

  
    <fieldset class="condition-isCoupleRequest-filled">
    <legend><g:message code="dhr.property.dhrSpouseIncomes.label" /></legend>
    
      <label for="pensions" class=""><g:message code="dhr.property.pensions.label" />   <span><g:message code="dhr.property.pensions.help" /></span></label>
            <input type="text" id="pensions" name="pensions" value="${rqt.pensions?.toString()}" 
                    class="  validate-positiveInteger ${stepStates != null && stepStates['spouse']?.invalidFields.contains('pensions') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.pensions.validationError" />"   />
            

    
      <label for="dhrAllowances" class=""><g:message code="dhr.property.dhrAllowances.label" />   <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
            <input type="text" id="dhrAllowances" name="dhrAllowances" value="${rqt.dhrAllowances?.toString()}" 
                    class="  validate-positiveInteger ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrAllowances') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrAllowances.validationError" />"   />
            

    
      <label for="dhrFurnitureInvestmentIncome" class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrFurnitureInvestmentIncome" name="dhrFurnitureInvestmentIncome" value="${rqt.dhrFurnitureInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrFurnitureInvestmentIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrFurnitureInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrRealEstateInvestmentIncome" class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" />   <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
            <input type="text" id="dhrRealEstateInvestmentIncome" name="dhrRealEstateInvestmentIncome" value="${rqt.dhrRealEstateInvestmentIncome?.toString()}" 
                    class="  validate-positiveInteger ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrRealEstateInvestmentIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrRealEstateInvestmentIncome.validationError" />"   />
            

    
      <label for="dhrNetIncome" class=""><g:message code="dhr.property.dhrNetIncome.label" />   <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
            <input type="text" id="dhrNetIncome" name="dhrNetIncome" value="${rqt.dhrNetIncome?.toString()}" 
                    class="  validate-positiveInteger ${stepStates != null && stepStates['spouse']?.invalidFields.contains('dhrNetIncome') ? 'validation-failed' : ''}" title="<g:message code="dhr.property.dhrNetIncome.validationError" />"   />
            

    
    </fieldset>
  

