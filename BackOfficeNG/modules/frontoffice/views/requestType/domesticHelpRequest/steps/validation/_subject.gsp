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
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'TitleType']" />


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
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'FamilyStatusType']" />


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
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'NationalityType']" />


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
			   		model="[forName:'dhrGuardianAddress.additionalDeliveryInformation',
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
			   		model="[forName:'dhrGuardianAddress.additionalGeographicalInformation',
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
			   		model="[forName:'dhrGuardianAddress.streetNumber',
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
			   		model="[forName:'dhrGuardianAddress.streetName',
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
			   		model="[forName:'dhrGuardianAddress.placeNameOrService',
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
			   		model="[forName:'dhrGuardianAddress.postalCode',
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
			   		model="[forName:'dhrGuardianAddress.city',
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
			   		model="[forName:'dhrGuardianAddress.countryName',
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
