
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

<fieldset class="">

<!--DhrFamilyReferent --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrFamilyReferent',
			   		condition:'',
			   		requestType: dhr]"/>



<!--DhrHaveFamilyReferent -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrHaveFamilyReferent',
			   		help:message(code:'dhr.property.dhrHaveFamilyReferent.help'),
			   		validation:'required validate-one-required',
			   		condition:'haveFamilyReferent-trigger ',
			   		elementName:'DhrHaveFamilyReferent', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrFamilyReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'dhrHaveFamilyReferent', 
			   		validation:'required validate-one-required', 
			   		condition:'haveFamilyReferent-trigger ',
			   		title:message(code:'dhr.property.dhrHaveFamilyReferent.validationError'),
			   		checked:dhr.dhrHaveFamilyReferent]" />


<!--DhrReferentName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentName',
			   		help:message(code:'dhr.property.dhrReferentName.help'),
			   		validation:'  validate-lastname',
			   		condition:'haveFamilyReferent-filled ',
			   		elementName:'DhrReferentName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrFamilyReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentName', 
			 		validation:'  validate-lastname', 
			 		condition:'haveFamilyReferent-filled ',
			 		value:dhr.dhrReferentName, 
			 		title:message(code:'dhr.property.dhrReferentName.validationError')]"/>



<!--DhrReferentFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentFirstName',
			   		help:message(code:'dhr.property.dhrReferentFirstName.help'),
			   		validation:'  validate-firstname',
			   		condition:'haveFamilyReferent-filled ',
			   		elementName:'DhrReferentFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrFamilyReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentFirstName', 
			 		validation:'  validate-firstname', 
			 		condition:'haveFamilyReferent-filled ',
			 		value:dhr.dhrReferentFirstName, 
			 		title:message(code:'dhr.property.dhrReferentFirstName.validationError')]"/>


<fieldset class="haveFamilyReferent-filled ">

<!--DhrReferentAddress -->
<g:render template="/frontofficeRequestType/widget/legend" 
			   		model="[forName:'dhrReferentAddress',
			   		condition:'haveFamilyReferent-filled ',
			   		elementName:'DhrReferentAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrFamilyReferentType']"/> 



<!--AdditionalDeliveryInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.additionalDeliveryInformation',
			   		help:message(code:'dhr.property.additionalDeliveryInformation.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.additionalDeliveryInformation', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.additionalDeliveryInformation, 
			 		title:message(code:'dhr.property.additionalDeliveryInformation.validationError')]"/>



<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.additionalGeographicalInformation',
			   		help:message(code:'dhr.property.additionalGeographicalInformation.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.additionalGeographicalInformation', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.additionalGeographicalInformation, 
			 		title:message(code:'dhr.property.additionalGeographicalInformation.validationError')]"/>



<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.streetNumber',
			   		help:message(code:'dhr.property.streetNumber.help'),
			   		validation:' ',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.streetNumber', 
			 		validation:' ', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.streetNumber, 
			 		title:message(code:'dhr.property.streetNumber.validationError')]"/>



<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.streetName',
			   		help:message(code:'dhr.property.streetName.help'),
			   		validation:'required  ',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.streetName', 
			 		validation:'required  ', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.streetName, 
			 		title:message(code:'dhr.property.streetName.validationError')]"/>



<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.placeNameOrService',
			   		help:message(code:'dhr.property.placeNameOrService.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.placeNameOrService', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.placeNameOrService, 
			 		title:message(code:'dhr.property.placeNameOrService.validationError')]"/>



<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.postalCode',
			   		help:message(code:'dhr.property.postalCode.help'),
			   		validation:'required  validate-postalcode',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.postalCode', 
			 		validation:'required  validate-postalcode', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.postalCode, 
			 		title:message(code:'dhr.property.postalCode.validationError')]"/>



<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.city',
			   		help:message(code:'dhr.property.city.help'),
			   		validation:'required  ',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.city', 
			 		validation:'required  ', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.city, 
			 		title:message(code:'dhr.property.city.validationError')]"/>



<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentAddress.countryName',
			   		help:message(code:'dhr.property.countryName.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrReferentAddress.countryName', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrReferentAddress?.countryName, 
			 		title:message(code:'dhr.property.countryName.validationError')]"/>


</fieldset>
</fieldset>
<fieldset class="">

<!--DhrRequester --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrRequester',
			   		condition:'',
			   		requestType: dhr]"/>



<!--DhrRequesterTitle -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterTitle',
			   		help:message(code:'dhr.property.dhrRequesterTitle.help'),
			   		validation:'required validate-not-first',
			   		condition:'isMadam-trigger ',
			   		elementName:'DhrRequesterTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrRequesterTitle',
 					validation:'required validate-not-first', 
 					condition:'isMadam-trigger ', 
 					title:message(code:'dhr.property.dhrRequesterTitle.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrRequesterTitle.defaultOption'),
 					selected:dhr.dhrRequesterTitle, 
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrTitleType']"/>


<!--DhrRequesterFamilyStatus -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterFamilyStatus',
			   		help:message(code:'dhr.property.dhrRequesterFamilyStatus.help'),
			   		validation:'required validate-not-first',
			   		condition:'',
			   		elementName:'DhrRequesterFamilyStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrRequesterFamilyStatus',
 					validation:'required validate-not-first', 
 					condition:'', 
 					title:message(code:'dhr.property.dhrRequesterFamilyStatus.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrRequesterFamilyStatus.defaultOption'),
 					selected:dhr.dhrRequesterFamilyStatus, 
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrFamilyStatusType']"/>


<!--DhrRequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterName',
			   		help:message(code:'dhr.property.dhrRequesterName.help'),
			   		validation:'required  validate-lastname',
			   		condition:'',
			   		elementName:'DhrRequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRequesterName', 
			 		validation:'required  validate-lastname', 
			 		condition:'',
			 		value:dhr.dhrRequesterName, 
			 		title:message(code:'dhr.property.dhrRequesterName.validationError')]"/>



<!--DhrRequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterFirstName',
			   		help:message(code:'dhr.property.dhrRequesterFirstName.help'),
			   		validation:'required  validate-firstname',
			   		condition:'',
			   		elementName:'DhrRequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRequesterFirstName', 
			 		validation:'required  validate-firstname', 
			 		condition:'',
			 		value:dhr.dhrRequesterFirstName, 
			 		title:message(code:'dhr.property.dhrRequesterFirstName.validationError')]"/>



<!--DhrRequesterMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterMaidenName',
			   		help:message(code:'dhr.property.dhrRequesterMaidenName.help'),
			   		validation:'  validate-lastname',
			   		condition:'isMadam-filled ',
			   		elementName:'DhrRequesterMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRequesterMaidenName', 
			 		validation:'  validate-lastname', 
			 		condition:'isMadam-filled ',
			 		value:dhr.dhrRequesterMaidenName, 
			 		title:message(code:'dhr.property.dhrRequesterMaidenName.validationError')]"/>



<!--DhrRequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterBirthDate',
			   		help:message(code:'dhr.property.dhrRequesterBirthDate.help'),
			   		validation:'required  validate-date-au',
			   		condition:'',
			   		elementName:'DhrRequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRequesterBirthDate', 
			 		validation:'required  validate-date-au', 
			 		condition:'',
			 		value:dhr.dhrRequesterBirthDate, 
			 		title:message(code:'dhr.property.dhrRequesterBirthDate.validationError')]"/>



<!--DhrRequesterBirthPlace -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterBirthPlace',
			   		help:message(code:'dhr.property.dhrRequesterBirthPlace.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'DhrRequesterBirthPlace', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRequesterBirthPlace', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:dhr.dhrRequesterBirthPlace, 
			 		title:message(code:'dhr.property.dhrRequesterBirthPlace.validationError')]"/>



<!--DhrRequesterNationality -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterNationality',
			   		help:message(code:'dhr.property.dhrRequesterNationality.help'),
			   		validation:'required validate-not-first',
			   		condition:'isNonEuropean-trigger ',
			   		elementName:'DhrRequesterNationality', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrRequesterNationality',
 					validation:'required validate-not-first', 
 					condition:'isNonEuropean-trigger ', 
 					title:message(code:'dhr.property.dhrRequesterNationality.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrRequesterNationality.defaultOption'),
 					selected:dhr.dhrRequesterNationality, 
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrNationalityType']"/>


<!--DhrRequesterFranceArrivalDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterFranceArrivalDate',
			   		help:message(code:'dhr.property.dhrRequesterFranceArrivalDate.help'),
			   		validation:'  validate-date-au',
			   		condition:'isNonEuropean-filled ',
			   		elementName:'DhrRequesterFranceArrivalDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRequesterFranceArrivalDate', 
			 		validation:'  validate-date-au', 
			 		condition:'isNonEuropean-filled ',
			 		value:dhr.dhrRequesterFranceArrivalDate, 
			 		title:message(code:'dhr.property.dhrRequesterFranceArrivalDate.validationError')]"/>



<!--DhrRequesterIsFrenchResident -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterIsFrenchResident',
			   		help:message(code:'dhr.property.dhrRequesterIsFrenchResident.help'),
			   		validation:' validate-one-required',
			   		condition:'isNonEuropean-filled ',
			   		elementName:'DhrRequesterIsFrenchResident', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'dhrRequesterIsFrenchResident', 
			   		validation:' validate-one-required', 
			   		condition:'isNonEuropean-filled ',
			   		title:message(code:'dhr.property.dhrRequesterIsFrenchResident.validationError'),
			   		checked:dhr.dhrRequesterIsFrenchResident]" />

</fieldset>
<fieldset class="">

<!--DhrRequesterPensionPlan --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrRequesterPensionPlan',
			   		condition:'',
			   		requestType: dhr]"/>



<!--DhrPrincipalPensionPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrPrincipalPensionPlan',
			   		help:message(code:'dhr.property.dhrPrincipalPensionPlan.help'),
			   		validation:'required validate-not-first',
			   		condition:'isOtherPensionPlan-trigger ',
			   		elementName:'DhrPrincipalPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterPensionPlanType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrPrincipalPensionPlan',
 					validation:'required validate-not-first', 
 					condition:'isOtherPensionPlan-trigger ', 
 					title:message(code:'dhr.property.dhrPrincipalPensionPlan.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrPrincipalPensionPlan.defaultOption'),
 					selected:dhr.dhrPrincipalPensionPlan, 
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrPrincipalPensionPlanType']"/>


<!--DhrPensionPlanDetail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrPensionPlanDetail',
			   		help:message(code:'dhr.property.dhrPensionPlanDetail.help'),
			   		validation:'  validate-string',
			   		condition:'isOtherPensionPlan-filled ',
			   		elementName:'DhrPensionPlanDetail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterPensionPlanType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrPensionPlanDetail', 
			 		validation:'  validate-string', 
			 		condition:'isOtherPensionPlan-filled ',
			 		value:dhr.dhrPensionPlanDetail, 
			 		title:message(code:'dhr.property.dhrPensionPlanDetail.validationError')]"/>



<!--DhrComplementaryPensionPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrComplementaryPensionPlan',
			   		help:message(code:'dhr.property.dhrComplementaryPensionPlan.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'DhrComplementaryPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterPensionPlanType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrComplementaryPensionPlan', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:dhr.dhrComplementaryPensionPlan, 
			 		title:message(code:'dhr.property.dhrComplementaryPensionPlan.validationError')]"/>


</fieldset>
<fieldset class="">

<!--DhrRequesterGuardian --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrRequesterGuardian',
			   		condition:'',
			   		requestType: dhr]"/>



<!--DhrRequesterHaveGuardian -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterHaveGuardian',
			   		help:message(code:'dhr.property.dhrRequesterHaveGuardian.help'),
			   		validation:'required validate-one-required',
			   		condition:'haveGuardian-trigger ',
			   		elementName:'DhrRequesterHaveGuardian', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterGuardianType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'dhrRequesterHaveGuardian', 
			   		validation:'required validate-one-required', 
			   		condition:'haveGuardian-trigger ',
			   		title:message(code:'dhr.property.dhrRequesterHaveGuardian.validationError'),
			   		checked:dhr.dhrRequesterHaveGuardian]" />


<!--DhrGuardianMeasure -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianMeasure',
			   		help:message(code:'dhr.property.dhrGuardianMeasure.help'),
			   		validation:' validate-not-first',
			   		condition:'haveGuardian-filled ',
			   		elementName:'DhrGuardianMeasure', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterGuardianType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrGuardianMeasure',
 					validation:' validate-not-first', 
 					condition:'haveGuardian-filled ', 
 					title:message(code:'dhr.property.dhrGuardianMeasure.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrGuardianMeasure.defaultOption'),
 					selected:dhr.dhrGuardianMeasure, 
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrGuardianMeasureType']"/>


<!--DhrGuardianName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianName',
			   		help:message(code:'dhr.property.dhrGuardianName.help'),
			   		validation:'  validate-lastname',
			   		condition:'haveGuardian-filled ',
			   		elementName:'DhrGuardianName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterGuardianType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianName', 
			 		validation:'  validate-lastname', 
			 		condition:'haveGuardian-filled ',
			 		value:dhr.dhrGuardianName, 
			 		title:message(code:'dhr.property.dhrGuardianName.validationError')]"/>


<fieldset class="haveGuardian-filled ">

<!--DhrGuardianAddress -->
<g:render template="/frontofficeRequestType/widget/legend" 
			   		model="[forName:'dhrGuardianAddress',
			   		condition:'haveGuardian-filled ',
			   		elementName:'DhrGuardianAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterGuardianType']"/> 



<!--AdditionalDeliveryInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.additionalDeliveryInformation',
			   		help:message(code:'dhr.property.additionalDeliveryInformation.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.additionalDeliveryInformation', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.additionalDeliveryInformation, 
			 		title:message(code:'dhr.property.additionalDeliveryInformation.validationError')]"/>



<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.additionalGeographicalInformation',
			   		help:message(code:'dhr.property.additionalGeographicalInformation.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.additionalGeographicalInformation', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.additionalGeographicalInformation, 
			 		title:message(code:'dhr.property.additionalGeographicalInformation.validationError')]"/>



<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.streetNumber',
			   		help:message(code:'dhr.property.streetNumber.help'),
			   		validation:' ',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.streetNumber', 
			 		validation:' ', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.streetNumber, 
			 		title:message(code:'dhr.property.streetNumber.validationError')]"/>



<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.streetName',
			   		help:message(code:'dhr.property.streetName.help'),
			   		validation:'required  ',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.streetName', 
			 		validation:'required  ', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.streetName, 
			 		title:message(code:'dhr.property.streetName.validationError')]"/>



<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.placeNameOrService',
			   		help:message(code:'dhr.property.placeNameOrService.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.placeNameOrService', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.placeNameOrService, 
			 		title:message(code:'dhr.property.placeNameOrService.validationError')]"/>



<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.postalCode',
			   		help:message(code:'dhr.property.postalCode.help'),
			   		validation:'required  validate-postalcode',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.postalCode', 
			 		validation:'required  validate-postalcode', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.postalCode, 
			 		title:message(code:'dhr.property.postalCode.validationError')]"/>



<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.city',
			   		help:message(code:'dhr.property.city.help'),
			   		validation:'required  ',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.city', 
			 		validation:'required  ', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.city, 
			 		title:message(code:'dhr.property.city.validationError')]"/>



<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianAddress.countryName',
			   		help:message(code:'dhr.property.countryName.help'),
			   		validation:'  ',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrGuardianAddress.countryName', 
			 		validation:'  ', 
			 		condition:'',
			 		value:dhr.dhrGuardianAddress?.countryName, 
			 		title:message(code:'dhr.property.countryName.validationError')]"/>


</fieldset>
</fieldset>
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
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrTitleType']"/>


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
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrFamilyStatusType']"/>


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
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrNationalityType']"/>


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
			   		condition:'isSpouseOtherPensionPlan-trigger isSpouseRetired-trigger ',
			   		elementName:'DhrIsSpouseRetired', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'dhrIsSpouseRetired', 
			   		validation:'required validate-one-required', 
			   		condition:'isSpouseOtherPensionPlan-trigger isSpouseRetired-trigger ',
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
