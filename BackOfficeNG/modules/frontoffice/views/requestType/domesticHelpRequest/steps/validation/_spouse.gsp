
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
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'TitleType']" />


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
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'FamilyStatusType']" />


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
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'NationalityType']" />


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
			   		model="[forName:'dhrSpouseAddress.additionalDeliveryInformation',
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
			   		model="[forName:'dhrSpouseAddress.additionalGeographicalInformation',
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
			   		model="[forName:'dhrSpouseAddress.streetNumber',
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
			   		model="[forName:'dhrSpouseAddress.streetName',
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
			   		model="[forName:'dhrSpouseAddress.placeNameOrService',
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
			   		model="[forName:'dhrSpouseAddress.postalCode',
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
			   		model="[forName:'dhrSpouseAddress.city',
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
			   		model="[forName:'dhrSpouseAddress.countryName',
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
<fieldset class="isCoupleRequest-filled ">

<!--DhrSpouseIncomes --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrSpouseIncomes',
			   		condition:'isCoupleRequest-filled ',
			   		requestType: dhr]"/>



<!--Pensions -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'pensions',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'Pensions', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.pensions,
					type:'textWidget',
					condition:'']" />


<!--DhrAllowances -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrAllowances',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrAllowances', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrAllowances,
					type:'textWidget',
					condition:'']" />


<!--DhrFurnitureInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrFurnitureInvestmentIncome',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrFurnitureInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrFurnitureInvestmentIncome,
					type:'textWidget',
					condition:'']" />


<!--DhrRealEstateInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRealEstateInvestmentIncome',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrRealEstateInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRealEstateInvestmentIncome,
					type:'textWidget',
					condition:'']" />


<!--DhrNetIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrNetIncome',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrNetIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrNetIncome,
					type:'textWidget',
					condition:'']" />

</fieldset>
