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
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'TitleType']"/>


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
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'FamilyStatusType']"/>


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
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'NationalityType']"/>


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
