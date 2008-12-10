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
