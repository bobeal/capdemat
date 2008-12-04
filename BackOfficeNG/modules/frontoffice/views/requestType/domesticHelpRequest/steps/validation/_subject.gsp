
<!--DhrRequestKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequestKind',
			   		help:null,
			   		validation:'null',
			   		condition:'isCoupleRequest-trigger ',
			   		elementName:'DhrRequestKind',
			   		requestType: dhr]"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequestKind,
					type:'radioWidget',
					condition:'isCoupleRequest-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrRequestKindType']" />

<fieldset class="">

<!--DhrFamilyReferent --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrFamilyReferent',
			   		condition:'',
			   		requestType: dhr]"/>



<!--DhrHaveFamilyReferent -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrHaveFamilyReferent',
			   		help:null,
			   		validation:'null',
			   		condition:'haveFamilyReferent-trigger ',
			   		elementName:'DhrHaveFamilyReferent', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrFamilyReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrHaveFamilyReferent,
					type:'yesnoWidget',
					condition:'haveFamilyReferent-trigger ']" />


<!--DhrReferentName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentName',
			   		help:null,
			   		validation:'null',
			   		condition:'haveFamilyReferent-filled ',
			   		elementName:'DhrReferentName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrFamilyReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentName,
					type:'textWidget',
					condition:'haveFamilyReferent-filled ']" />


<!--DhrReferentFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrReferentFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'haveFamilyReferent-filled ',
			   		elementName:'DhrReferentFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrFamilyReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentFirstName,
					type:'textWidget',
					condition:'haveFamilyReferent-filled ']" />

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
			   		model="[forName:'additionalDeliveryInformation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.additionalDeliveryInformation,
					type:'textWidget',
					condition:'']" />


<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'additionalGeographicalInformation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.additionalGeographicalInformation,
					type:'textWidget',
					condition:'']" />


<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.streetNumber,
					type:'textWidget',
					condition:'']" />


<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.streetName,
					type:'textWidget',
					condition:'']" />


<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'placeNameOrService',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.placeNameOrService,
					type:'textWidget',
					condition:'']" />


<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'postalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.postalCode,
					type:'textWidget',
					condition:'']" />


<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'city',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.city,
					type:'textWidget',
					condition:'']" />


<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'countryName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrReferentAddress?.countryName,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isMadam-trigger ',
			   		elementName:'DhrRequesterTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterTitle,
					type:'selectWidget',
					condition:'isMadam-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrTitleType']" />


<!--DhrRequesterFamilyStatus -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterFamilyStatus',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrRequesterFamilyStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterFamilyStatus,
					type:'selectWidget',
					condition:'',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrFamilyStatusType']" />


<!--DhrRequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrRequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterName,
					type:'textWidget',
					condition:'']" />


<!--DhrRequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrRequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterFirstName,
					type:'textWidget',
					condition:'']" />


<!--DhrRequesterMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterMaidenName',
			   		help:null,
			   		validation:'null',
			   		condition:'isMadam-filled ',
			   		elementName:'DhrRequesterMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterMaidenName,
					type:'textWidget',
					condition:'isMadam-filled ']" />


<!--DhrRequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterBirthDate',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrRequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterBirthDate,
					type:'textWidget',
					condition:'']" />


<!--DhrRequesterBirthPlace -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterBirthPlace',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrRequesterBirthPlace', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterBirthPlace,
					type:'textWidget',
					condition:'']" />


<!--DhrRequesterNationality -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterNationality',
			   		help:null,
			   		validation:'null',
			   		condition:'isNonEuropean-trigger ',
			   		elementName:'DhrRequesterNationality', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterNationality,
					type:'selectWidget',
					condition:'isNonEuropean-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrNationalityType']" />


<!--DhrRequesterFranceArrivalDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterFranceArrivalDate',
			   		help:null,
			   		validation:'null',
			   		condition:'isNonEuropean-filled ',
			   		elementName:'DhrRequesterFranceArrivalDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterFranceArrivalDate,
					type:'textWidget',
					condition:'isNonEuropean-filled ']" />


<!--DhrRequesterIsFrenchResident -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRequesterIsFrenchResident',
			   		help:null,
			   		validation:'null',
			   		condition:'isNonEuropean-filled ',
			   		elementName:'DhrRequesterIsFrenchResident', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterIsFrenchResident,
					type:'yesnoWidget',
					condition:'isNonEuropean-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherPensionPlan-trigger ',
			   		elementName:'DhrPrincipalPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterPensionPlanType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrPrincipalPensionPlan,
					type:'selectWidget',
					condition:'isOtherPensionPlan-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrPrincipalPensionPlanType']" />


<!--DhrPensionPlanDetail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrPensionPlanDetail',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherPensionPlan-filled ',
			   		elementName:'DhrPensionPlanDetail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterPensionPlanType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrPensionPlanDetail,
					type:'textWidget',
					condition:'isOtherPensionPlan-filled ']" />


<!--DhrComplementaryPensionPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrComplementaryPensionPlan',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrComplementaryPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterPensionPlanType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrComplementaryPensionPlan,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'haveGuardian-trigger ',
			   		elementName:'DhrRequesterHaveGuardian', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterGuardianType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRequesterHaveGuardian,
					type:'yesnoWidget',
					condition:'haveGuardian-trigger ']" />


<!--DhrGuardianMeasure -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianMeasure',
			   		help:null,
			   		validation:'null',
			   		condition:'haveGuardian-filled ',
			   		elementName:'DhrGuardianMeasure', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterGuardianType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianMeasure,
					type:'selectWidget',
					condition:'haveGuardian-filled ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrGuardianMeasureType']" />


<!--DhrGuardianName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrGuardianName',
			   		help:null,
			   		validation:'null',
			   		condition:'haveGuardian-filled ',
			   		elementName:'DhrGuardianName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrRequesterGuardianType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianName,
					type:'textWidget',
					condition:'haveGuardian-filled ']" />

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
			   		model="[forName:'additionalDeliveryInformation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.additionalDeliveryInformation,
					type:'textWidget',
					condition:'']" />


<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'additionalGeographicalInformation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.additionalGeographicalInformation,
					type:'textWidget',
					condition:'']" />


<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.streetNumber,
					type:'textWidget',
					condition:'']" />


<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.streetName,
					type:'textWidget',
					condition:'']" />


<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'placeNameOrService',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.placeNameOrService,
					type:'textWidget',
					condition:'']" />


<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'postalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.postalCode,
					type:'textWidget',
					condition:'']" />


<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'city',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.city,
					type:'textWidget',
					condition:'']" />


<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'countryName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrGuardianAddress?.countryName,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseMadam-trigger ',
			   		elementName:'DhrSpouseTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseTitle,
					type:'selectWidget',
					condition:'isSpouseMadam-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrTitleType']" />


<!--DhrSpouseFamilyStatus -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseFamilyStatus',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrSpouseFamilyStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseFamilyStatus,
					type:'selectWidget',
					condition:'',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrFamilyStatusType']" />


<!--DhrSpouseName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrSpouseName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseName,
					type:'textWidget',
					condition:'']" />


<!--DhrSpouseFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrSpouseFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseFirstName,
					type:'textWidget',
					condition:'']" />


<!--DhrSpouseMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseMaidenName',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseMadam-filled ',
			   		elementName:'DhrSpouseMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseMaidenName,
					type:'textWidget',
					condition:'isSpouseMadam-filled ']" />


<!--DhrSpouseBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseBirthDate',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrSpouseBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseBirthDate,
					type:'textWidget',
					condition:'']" />


<!--DhrSpouseBirthPlace -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseBirthPlace',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrSpouseBirthPlace', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseBirthPlace,
					type:'textWidget',
					condition:'']" />


<!--DhrSpouseNationality -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseNationality',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseNonEuropean-trigger ',
			   		elementName:'DhrSpouseNationality', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseNationality,
					type:'selectWidget',
					condition:'isSpouseNonEuropean-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrNationalityType']" />


<!--DhrSpouseFranceArrivalDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseFranceArrivalDate',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseNonEuropean-filled ',
			   		elementName:'DhrSpouseFranceArrivalDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseFranceArrivalDate,
					type:'textWidget',
					condition:'isSpouseNonEuropean-filled ']" />


<!--DhrSpouseIsFrenchResident -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseIsFrenchResident',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseNonEuropean-filled ',
			   		elementName:'DhrSpouseIsFrenchResident', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseIsFrenchResident,
					type:'yesnoWidget',
					condition:'isSpouseNonEuropean-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger ',
			   		elementName:'DhrIsSpouseRetired', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrIsSpouseRetired,
					type:'yesnoWidget',
					condition:'isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger ']" />


<!--DhrSpousePrincipalPensionPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpousePrincipalPensionPlan',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseRetired-filled isSpouseOtherPensionPlan-trigger ',
			   		elementName:'DhrSpousePrincipalPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpousePrincipalPensionPlan,
					type:'selectWidget',
					condition:'isSpouseRetired-filled isSpouseOtherPensionPlan-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrPrincipalPensionPlanType']" />


<!--DhrSpousePensionPlanDetail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpousePensionPlanDetail',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseOtherPensionPlan-filled ',
			   		elementName:'DhrSpousePensionPlanDetail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpousePensionPlanDetail,
					type:'textWidget',
					condition:'isSpouseOtherPensionPlan-filled ']" />


<!--DhrSpouseComplementaryPensionPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseComplementaryPensionPlan',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseRetired-filled ',
			   		elementName:'DhrSpouseComplementaryPensionPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseComplementaryPensionPlan,
					type:'textWidget',
					condition:'isSpouseRetired-filled ']" />


<!--DhrSpouseProfession -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseProfession',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseRetired-unfilled ',
			   		elementName:'DhrSpouseProfession', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseProfession,
					type:'textWidget',
					condition:'isSpouseRetired-unfilled ']" />


<!--DhrSpouseEmployer -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrSpouseEmployer',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpouseRetired-unfilled ',
			   		elementName:'DhrSpouseEmployer', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrSpouseStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseEmployer,
					type:'textWidget',
					condition:'isSpouseRetired-unfilled ']" />

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
			   		model="[forName:'additionalDeliveryInformation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.additionalDeliveryInformation,
					type:'textWidget',
					condition:'']" />


<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'additionalGeographicalInformation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.additionalGeographicalInformation,
					type:'textWidget',
					condition:'']" />


<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.streetNumber,
					type:'textWidget',
					condition:'']" />


<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.streetName,
					type:'textWidget',
					condition:'']" />


<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'placeNameOrService',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.placeNameOrService,
					type:'textWidget',
					condition:'']" />


<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'postalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.postalCode,
					type:'textWidget',
					condition:'']" />


<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'city',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.city,
					type:'textWidget',
					condition:'']" />


<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'countryName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrSpouseAddress?.countryName,
					type:'textWidget',
					condition:'']" />

</fieldset>
</fieldset>
