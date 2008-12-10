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
			   		model="[forName:'dhrReferentAddress.additionalDeliveryInformation',
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
			   		model="[forName:'dhrReferentAddress.additionalGeographicalInformation',
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
			   		model="[forName:'dhrReferentAddress.streetNumber',
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
			   		model="[forName:'dhrReferentAddress.streetName',
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
			   		model="[forName:'dhrReferentAddress.placeNameOrService',
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
			   		model="[forName:'dhrReferentAddress.postalCode',
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
			   		model="[forName:'dhrReferentAddress.city',
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
			   		model="[forName:'dhrReferentAddress.countryName',
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
