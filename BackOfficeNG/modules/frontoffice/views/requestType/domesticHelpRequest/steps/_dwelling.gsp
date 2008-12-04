<fieldset class="">

<!--DhrCurrentDwelling --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrCurrentDwelling',
			   		condition:'',
			   		requestType: dhr]"/>


<fieldset class="">

<!--DhrCurrentDwellingAddress -->
<g:render template="/frontofficeRequestType/widget/legend" 
			   		model="[forName:'dhrCurrentDwellingAddress',
			   		condition:'',
			   		elementName:'DhrCurrentDwellingAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 



<!--AdditionalDeliveryInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'additionalDeliveryInformation',
			   		help:message(code:'dhr.property.additionalDeliveryInformation.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'additionalDeliveryInformation', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.additionalDeliveryInformation, 
			 		title:message(code:'dhr.property.additionalDeliveryInformation.validationError')]"/>



<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'additionalGeographicalInformation',
			   		help:message(code:'dhr.property.additionalGeographicalInformation.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'additionalGeographicalInformation', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.additionalGeographicalInformation, 
			 		title:message(code:'dhr.property.additionalGeographicalInformation.validationError')]"/>



<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetNumber',
			   		help:message(code:'dhr.property.streetNumber.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'streetNumber', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.streetNumber, 
			 		title:message(code:'dhr.property.streetNumber.validationError')]"/>



<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetName',
			   		help:message(code:'dhr.property.streetName.help'),
			   		validation:'required ',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'streetName', 
			 		validation:'required ', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.streetName, 
			 		title:message(code:'dhr.property.streetName.validationError')]"/>



<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'placeNameOrService',
			   		help:message(code:'dhr.property.placeNameOrService.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'placeNameOrService', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.placeNameOrService, 
			 		title:message(code:'dhr.property.placeNameOrService.validationError')]"/>



<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'postalCode',
			   		help:message(code:'dhr.property.postalCode.help'),
			   		validation:'required ',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'postalCode', 
			 		validation:'required ', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.postalCode, 
			 		title:message(code:'dhr.property.postalCode.validationError')]"/>



<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'city',
			   		help:message(code:'dhr.property.city.help'),
			   		validation:'required ',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'city', 
			 		validation:'required ', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.city, 
			 		title:message(code:'dhr.property.city.validationError')]"/>



<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'countryName',
			   		help:message(code:'dhr.property.countryName.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'countryName', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingAddress?.countryName, 
			 		title:message(code:'dhr.property.countryName.validationError')]"/>


</fieldset>

<!--DhrCurrentDwellingPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingPhone',
			   		help:message(code:'dhr.property.dhrCurrentDwellingPhone.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrCurrentDwellingPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrCurrentDwellingPhone', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrCurrentDwellingPhone, 
			 		title:message(code:'dhr.property.dhrCurrentDwellingPhone.validationError')]"/>



<!--DhrCurrentDwellingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingKind',
			   		help:message(code:'dhr.property.dhrCurrentDwellingKind.help'),
			   		validation:'required validate-not-first',
			   		condition:'isCurrentDwellingPlaceOfResidence-trigger ',
			   		elementName:'DhrCurrentDwellingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'dhrCurrentDwellingKind',
 					validation:'required validate-not-first', 
 					condition:'isCurrentDwellingPlaceOfResidence-trigger ', 
 					title:message(code:'dhr.property.dhrCurrentDwellingKind.validationError'), 
 					defaultOption:message(code:'dhr.property.dhrCurrentDwellingKind.defaultOption'),
 					selected:dhr.dhrCurrentDwellingKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/dhr', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'DhrDwellingKindType']"/>


<!--DhrCurrentDwellingArrivalDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingArrivalDate',
			   		help:message(code:'dhr.property.dhrCurrentDwellingArrivalDate.help'),
			   		validation:'',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingArrivalDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrCurrentDwellingArrivalDate', 
			 		validation:'', 
			 		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			 		value:dhr.dhrCurrentDwellingArrivalDate, 
			 		title:message(code:'dhr.property.dhrCurrentDwellingArrivalDate.validationError')]"/>



<!--DhrCurrentDwellingStatus -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingStatus',
			   		help:message(code:'dhr.property.dhrCurrentDwellingStatus.help'),
			   		validation:'',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/radio" 
					model="[name:'dhrCurrentDwellingStatus', 
					validation:'',	
					condition:'isCurrentDwellingPlaceOfResidence-filled ',
					title:message(code:'dhr.property.dhrCurrentDwellingStatus.validationError'),
					checked:dhr.dhrCurrentDwellingStatus,	
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
					modelNamespace:'fr.cg95.cvq.business.request.social',
					elementTypeName:'DhrDwellingStatusType']"/>


<!--DhrCurrentDwellingNumberOfRoom -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingNumberOfRoom',
			   		help:message(code:'dhr.property.dhrCurrentDwellingNumberOfRoom.help'),
			   		validation:'',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingNumberOfRoom', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrCurrentDwellingNumberOfRoom', 
			 		validation:'', 
			 		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			 		value:dhr.dhrCurrentDwellingNumberOfRoom, 
			 		title:message(code:'dhr.property.dhrCurrentDwellingNumberOfRoom.validationError')]"/>



<!--DhrCurrentDwellingNetArea -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingNetArea',
			   		help:message(code:'dhr.property.dhrCurrentDwellingNetArea.help'),
			   		validation:'',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingNetArea', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrCurrentDwellingNetArea', 
			 		validation:'', 
			 		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			 		value:dhr.dhrCurrentDwellingNetArea, 
			 		title:message(code:'dhr.property.dhrCurrentDwellingNetArea.validationError')]"/>


</fieldset>
