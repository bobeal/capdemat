
<!--DhrRequestKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequestKind',
			   		help:message(code:'dhr.property.dhrRequestKind.help'),
			   		validation:'required validate-one-required',
			   		condition:'isCoupleRequest-trigger ',
			   		elementName:'DhrRequestKind',
			   		requestType: dhr]"/> 


<g:render template="/frontofficeRequestType/widget/radio" 
					model="[name:'dhrRequestKind', 
					validation:'required validate-one-required',	
					condition:'isCoupleRequest-trigger ',
					title:message(code:'dhr.property.dhrRequestKind.validationError'),
					checked:dhr.dhrRequestKind,	
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
					modelNamespace:'fr.cg95.cvq.business.request.social',
					elementTypeName:'DhrRequestKindType']"/>

<fieldset class="isCoupleRequest-filled ">

<!--DhrSpouse --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrSpouse',
			   		condition:'isCoupleRequest-filled ',
			   		requestType: dhr]"/>



<!--DhrSpouseTitle -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseTitle',
			   		help:message(code:'dhr.property.dhrSpouseTitle.help'),
			   		validation:'required validate-not-first',
			   		condition:'isSpouseMadam-trigger ',
			   		elementName:'DhrSpouseTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrSpouseTitle',
 					validation:'required validate-not-first', 
 					condition:'isSpouseMadam-trigger ', 
 					title:message(code:'dhr.property.dhrSpouseTitle.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrSpouseTitle.defaultOption'),
 					selected:dhr.dhrSpouseTitle, 
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'TitleType']"/>


<!--DhrSpouseFamilyStatus -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseFamilyStatus',
			   		help:message(code:'dhr.property.dhrSpouseFamilyStatus.help'),
			   		validation:'required validate-not-first',
			   		condition:'',
			   		elementName:'DhrSpouseFamilyStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrSpouseFamilyStatus',
 					validation:'required validate-not-first', 
 					condition:'', 
 					title:message(code:'dhr.property.dhrSpouseFamilyStatus.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrSpouseFamilyStatus.defaultOption'),
 					selected:dhr.dhrSpouseFamilyStatus, 
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'FamilyStatusType']"/>


<!--DhrSpouseName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseName',
			   		help:message(code:'dhr.property.dhrSpouseName.help'),
			   		validation:'required  validate-lastname',
			   		condition:'',
			   		elementName:'DhrSpouseName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseName', 
			 		validation:'required  validate-lastname', 
			 		condition:'',
			 		value:dhr.dhrSpouseName, 
			 		title:message(code:'dhr.property.dhrSpouseName.validationError')]"/>



<!--DhrSpouseFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseFirstName',
			   		help:message(code:'dhr.property.dhrSpouseFirstName.help'),
			   		validation:'required  validate-firstname',
			   		condition:'',
			   		elementName:'DhrSpouseFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseFirstName', 
			 		validation:'required  validate-firstname', 
			 		condition:'',
			 		value:dhr.dhrSpouseFirstName, 
			 		title:message(code:'dhr.property.dhrSpouseFirstName.validationError')]"/>



<!--DhrSpouseMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseMaidenName',
			   		help:message(code:'dhr.property.dhrSpouseMaidenName.help'),
			   		validation:'  validate-lastname',
			   		condition:'isSpouseMadam-filled ',
			   		elementName:'DhrSpouseMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseMaidenName', 
			 		validation:'  validate-lastname', 
			 		condition:'isSpouseMadam-filled ',
			 		value:dhr.dhrSpouseMaidenName, 
			 		title:message(code:'dhr.property.dhrSpouseMaidenName.validationError')]"/>



<!--DhrSpouseBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseBirthDate',
			   		help:message(code:'dhr.property.dhrSpouseBirthDate.help'),
			   		validation:'required  validate-date-au',
			   		condition:'',
			   		elementName:'DhrSpouseBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseBirthDate', 
			 		validation:'required  validate-date-au', 
			 		condition:'',
			 		value:dhr.dhrSpouseBirthDate, 
			 		title:message(code:'dhr.property.dhrSpouseBirthDate.validationError')]"/>



<!--DhrSpouseBirthPlace -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseBirthPlace',
			   		help:message(code:'dhr.property.dhrSpouseBirthPlace.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'DhrSpouseBirthPlace', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseBirthPlace', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:dhr.dhrSpouseBirthPlace, 
			 		title:message(code:'dhr.property.dhrSpouseBirthPlace.validationError')]"/>



<!--DhrSpouseNationality -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseNationality',
			   		help:message(code:'dhr.property.dhrSpouseNationality.help'),
			   		validation:'required validate-not-first',
			   		condition:'isSpouseNonEuropean-trigger ',
			   		elementName:'DhrSpouseNationality', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrSpouseNationality',
 					validation:'required validate-not-first', 
 					condition:'isSpouseNonEuropean-trigger ', 
 					title:message(code:'dhr.property.dhrSpouseNationality.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrSpouseNationality.defaultOption'),
 					selected:dhr.dhrSpouseNationality, 
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'NationalityType']"/>


<!--DhrSpouseFranceArrivalDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseFranceArrivalDate',
			   		help:message(code:'dhr.property.dhrSpouseFranceArrivalDate.help'),
			   		validation:'  validate-date-au',
			   		condition:'isSpouseNonEuropean-filled ',
			   		elementName:'DhrSpouseFranceArrivalDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseFranceArrivalDate', 
			 		validation:'  validate-date-au', 
			 		condition:'isSpouseNonEuropean-filled ',
			 		value:dhr.dhrSpouseFranceArrivalDate, 
			 		title:message(code:'dhr.property.dhrSpouseFranceArrivalDate.validationError')]"/>



<!--DhrSpouseIsFrenchResident -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseIsFrenchResident',
			   		help:message(code:'dhr.property.dhrSpouseIsFrenchResident.help'),
			   		validation:' validate-one-required',
			   		condition:'isSpouseNonEuropean-filled ',
			   		elementName:'DhrSpouseIsFrenchResident', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'dhrSpouseIsFrenchResident', 
			   		validation:' validate-one-required', 
			   		condition:'isSpouseNonEuropean-filled ',
			   		title:message(code:'dhr.property.dhrSpouseIsFrenchResident.validationError'),
			   		checked:dhr.dhrSpouseIsFrenchResident]" />

</fieldset>
<fieldset class="isCoupleRequest-filled ">

<!--DhrSpouseStatus --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrSpouseStatus',
			   		condition:'isCoupleRequest-filled ',
			   		requestType: dhr]"/>



<!--DhrIsSpouseRetired -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrIsSpouseRetired',
			   		help:message(code:'dhr.property.dhrIsSpouseRetired.help'),
			   		validation:'required validate-one-required',
			   		condition:'isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger ',
			   		elementName:'DhrIsSpouseRetired', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'dhrIsSpouseRetired', 
			   		validation:'required validate-one-required', 
			   		condition:'isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger ',
			   		title:message(code:'dhr.property.dhrIsSpouseRetired.validationError'),
			   		checked:dhr.dhrIsSpouseRetired]" />


<!--DhrSpousePrincipalPensionPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpousePrincipalPensionPlan',
			   		help:message(code:'dhr.property.dhrSpousePrincipalPensionPlan.help'),
			   		validation:' validate-not-first',
			   		condition:'isSpouseRetired-filled isSpouseOtherPensionPlan-trigger ',
			   		elementName:'DhrSpousePrincipalPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrSpousePrincipalPensionPlan',
 					validation:' validate-not-first', 
 					condition:'isSpouseRetired-filled isSpouseOtherPensionPlan-trigger ', 
 					title:message(code:'dhr.property.dhrSpousePrincipalPensionPlan.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrSpousePrincipalPensionPlan.defaultOption'),
 					selected:dhr.dhrSpousePrincipalPensionPlan, 
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrPrincipalPensionPlanType']"/>


<!--DhrSpousePensionPlanDetail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpousePensionPlanDetail',
			   		help:message(code:'dhr.property.dhrSpousePensionPlanDetail.help'),
			   		validation:'  validate-string',
			   		condition:'isSpouseOtherPensionPlan-filled ',
			   		elementName:'DhrSpousePensionPlanDetail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpousePensionPlanDetail', 
			 		validation:'  validate-string', 
			 		condition:'isSpouseOtherPensionPlan-filled ',
			 		value:dhr.dhrSpousePensionPlanDetail, 
			 		title:message(code:'dhr.property.dhrSpousePensionPlanDetail.validationError')]"/>



<!--DhrSpouseComplementaryPensionPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseComplementaryPensionPlan',
			   		help:message(code:'dhr.property.dhrSpouseComplementaryPensionPlan.help'),
			   		validation:'  validate-string',
			   		condition:'isSpouseRetired-filled ',
			   		elementName:'DhrSpouseComplementaryPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseComplementaryPensionPlan', 
			 		validation:'  validate-string', 
			 		condition:'isSpouseRetired-filled ',
			 		value:dhr.dhrSpouseComplementaryPensionPlan, 
			 		title:message(code:'dhr.property.dhrSpouseComplementaryPensionPlan.validationError')]"/>



<!--DhrSpouseProfession -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseProfession',
			   		help:message(code:'dhr.property.dhrSpouseProfession.help'),
			   		validation:'  validate-string',
			   		condition:'isSpouseRetired-unfilled ',
			   		elementName:'DhrSpouseProfession', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseProfession', 
			 		validation:'  validate-string', 
			 		condition:'isSpouseRetired-unfilled ',
			 		value:dhr.dhrSpouseProfession, 
			 		title:message(code:'dhr.property.dhrSpouseProfession.validationError')]"/>



<!--DhrSpouseEmployer -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseEmployer',
			   		help:message(code:'dhr.property.dhrSpouseEmployer.help'),
			   		validation:'  validate-string',
			   		condition:'isSpouseRetired-unfilled ',
			   		elementName:'DhrSpouseEmployer', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseEmployer', 
			 		validation:'  validate-string', 
			 		condition:'isSpouseRetired-unfilled ',
			 		value:dhr.dhrSpouseEmployer, 
			 		title:message(code:'dhr.property.dhrSpouseEmployer.validationError')]"/>


<fieldset class="isSpouseRetired-unfilled ">

<!--DhrSpouseAddress -->
<g:render template="/frontofficeRequestType/widget/legend" 
			   		model="[forName:'dhrSpouseAddress',
			   		condition:'isSpouseRetired-unfilled ',
			   		elementName:'DhrSpouseAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 



<!--AdditionalDeliveryInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.additionalDeliveryInformation',
			   		help:message(code:'dhr.property.additionalDeliveryInformation.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.additionalDeliveryInformation', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.additionalDeliveryInformation, 
			 		title:message(code:'dhr.property.additionalDeliveryInformation.validationError')]"/>



<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.additionalGeographicalInformation',
			   		help:message(code:'dhr.property.additionalGeographicalInformation.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.additionalGeographicalInformation', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.additionalGeographicalInformation, 
			 		title:message(code:'dhr.property.additionalGeographicalInformation.validationError')]"/>



<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.streetNumber',
			   		help:message(code:'dhr.property.streetNumber.help'),
			   		validation:' ',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.streetNumber', 
			 		validation:' ', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.streetNumber, 
			 		title:message(code:'dhr.property.streetNumber.validationError')]"/>



<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.streetName',
			   		help:message(code:'dhr.property.streetName.help'),
			   		validation:'required  ',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.streetName', 
			 		validation:'required  ', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.streetName, 
			 		title:message(code:'dhr.property.streetName.validationError')]"/>



<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.placeNameOrService',
			   		help:message(code:'dhr.property.placeNameOrService.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.placeNameOrService', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.placeNameOrService, 
			 		title:message(code:'dhr.property.placeNameOrService.validationError')]"/>



<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.postalCode',
			   		help:message(code:'dhr.property.postalCode.help'),
			   		validation:'required  validate-postalcode',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.postalCode', 
			 		validation:'required  validate-postalcode', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.postalCode, 
			 		title:message(code:'dhr.property.postalCode.validationError')]"/>



<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.city',
			   		help:message(code:'dhr.property.city.help'),
			   		validation:'required  ',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.city', 
			 		validation:'required  ', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.city, 
			 		title:message(code:'dhr.property.city.validationError')]"/>



<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseAddress.countryName',
			   		help:message(code:'dhr.property.countryName.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrSpouseAddress.countryName', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrSpouseAddress?.countryName, 
			 		title:message(code:'dhr.property.countryName.validationError')]"/>


</fieldset>
</fieldset>
<fieldset class="isCoupleRequest-filled ">

<!--DhrSpouseIncomes --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrSpouseIncomes',
			   		condition:'isCoupleRequest-filled ',
			   		requestType: dhr]"/>



<!--Pensions -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'pensions',
			   		help:message(code:'dhr.property.pensions.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'Pensions', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'pensions', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.pensions, 
			 		title:message(code:'dhr.property.pensions.validationError')]"/>



<!--DhrAllowances -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrAllowances',
			   		help:message(code:'dhr.property.dhrAllowances.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'DhrAllowances', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrAllowances', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.dhrAllowances, 
			 		title:message(code:'dhr.property.dhrAllowances.validationError')]"/>



<!--DhrFurnitureInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrFurnitureInvestmentIncome',
			   		help:message(code:'dhr.property.dhrFurnitureInvestmentIncome.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'DhrFurnitureInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrFurnitureInvestmentIncome', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.dhrFurnitureInvestmentIncome, 
			 		title:message(code:'dhr.property.dhrFurnitureInvestmentIncome.validationError')]"/>



<!--DhrRealEstateInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRealEstateInvestmentIncome',
			   		help:message(code:'dhr.property.dhrRealEstateInvestmentIncome.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'DhrRealEstateInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRealEstateInvestmentIncome', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.dhrRealEstateInvestmentIncome, 
			 		title:message(code:'dhr.property.dhrRealEstateInvestmentIncome.validationError')]"/>



<!--DhrNetIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrNetIncome',
			   		help:message(code:'dhr.property.dhrNetIncome.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'DhrNetIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrNetIncome', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.dhrNetIncome, 
			 		title:message(code:'dhr.property.dhrNetIncome.validationError')]"/>


</fieldset>
