
<!--HarDwellingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingKind',
			   		help:message(code:'har.property.harDwellingKind.help'),
			   		validation:'required validate-not-first',
			   		condition:'isDwellingPlaceOfResidence-trigger ',
			   		elementName:'HarDwellingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harDwellingKind',
 					validation:'required validate-not-first', 
 					condition:'isDwellingPlaceOfResidence-trigger ', 
 					title:message(code:'har.property.harDwellingKind.validationError'), 
 					defaultOption:message(code:'har.property.harDwellingKind.defaultOption'),
 					selected:har.harDwellingKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarDwellingKindType']"/>


<!--HarDwellingPrecision -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingPrecision',
			   		help:message(code:'har.property.harDwellingPrecision.help'),
			   		validation:'  validate-string',
			   		condition:'isDwellingPlaceOfResidence-unfilled ',
			   		elementName:'HarDwellingPrecision', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingPrecision', 
			 		validation:'  validate-string', 
			 		condition:'isDwellingPlaceOfResidence-unfilled ',
			 		value:har.harDwellingPrecision, 
			 		title:message(code:'har.property.harDwellingPrecision.validationError')]"/>



<!--HarDwellingEstablishmentReception -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingEstablishmentReception',
			   		help:message(code:'har.property.harDwellingEstablishmentReception.help'),
			   		validation:'required validate-one-required',
			   		condition:'isInEstablishmentReception-trigger ',
			   		elementName:'HarDwellingEstablishmentReception', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDwellingEstablishmentReception', 
			   		validation:'required validate-one-required', 
			   		condition:'isInEstablishmentReception-trigger ',
			   		title:message(code:'har.property.harDwellingEstablishmentReception.validationError'),
			   		checked:har.harDwellingEstablishmentReception]" />


<!--HarDwellingReceptionType -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionType',
			   		help:message(code:'har.property.harDwellingReceptionType.help'),
			   		validation:' validate-not-first',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionType', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harDwellingReceptionType',
 					validation:' validate-not-first', 
 					condition:'isInEstablishmentReception-filled ', 
 					title:message(code:'har.property.harDwellingReceptionType.validationError'), 
 					defaultOption:message(code:'har.property.harDwellingReceptionType.defaultOption'),
 					selected:har.harDwellingReceptionType, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarDwellingReceptionKindType']"/>


<!--DwellingReceptionNaming -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dwellingReceptionNaming',
			   		help:message(code:'har.property.dwellingReceptionNaming.help'),
			   		validation:'  validate-string',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'DwellingReceptionNaming', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dwellingReceptionNaming', 
			 		validation:'  validate-string', 
			 		condition:'isInEstablishmentReception-filled ',
			 		value:har.dwellingReceptionNaming, 
			 		title:message(code:'har.property.dwellingReceptionNaming.validationError')]"/>



<!--HarDwellingReceptionAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionAddress',
			   		help:message(code:'har.property.harDwellingReceptionAddress.help'),
			   		validation:'  validate-string',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingReceptionAddress', 
			 		validation:'  validate-string', 
			 		condition:'isInEstablishmentReception-filled ',
			 		value:har.harDwellingReceptionAddress, 
			 		title:message(code:'har.property.harDwellingReceptionAddress.validationError')]"/>



<!--HarDwellingReceptionPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionPostalCode',
			   		help:message(code:'har.property.harDwellingReceptionPostalCode.help'),
			   		validation:'required  validate-postalcode',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingReceptionPostalCode', 
			 		validation:'required  validate-postalcode', 
			 		condition:'isInEstablishmentReception-filled ',
			 		value:har.harDwellingReceptionPostalCode, 
			 		title:message(code:'har.property.harDwellingReceptionPostalCode.validationError')]"/>



<!--HarDwellingReceptionCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionCity',
			   		help:message(code:'har.property.harDwellingReceptionCity.help'),
			   		validation:'  validate-city',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingReceptionCity', 
			 		validation:'  validate-city', 
			 		condition:'isInEstablishmentReception-filled ',
			 		value:har.harDwellingReceptionCity, 
			 		title:message(code:'har.property.harDwellingReceptionCity.validationError')]"/>



<!--HarDwellingSocialReception -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReception',
			   		help:message(code:'har.property.harDwellingSocialReception.help'),
			   		validation:'required validate-one-required',
			   		condition:'isInSocialReception-trigger ',
			   		elementName:'HarDwellingSocialReception', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDwellingSocialReception', 
			   		validation:'required validate-one-required', 
			   		condition:'isInSocialReception-trigger ',
			   		title:message(code:'har.property.harDwellingSocialReception.validationError'),
			   		checked:har.harDwellingSocialReception]" />


<!--HarDwellingSocialReceptionNaming -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionNaming',
			   		help:message(code:'har.property.harDwellingSocialReceptionNaming.help'),
			   		validation:'  validate-string',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionNaming', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingSocialReceptionNaming', 
			 		validation:'  validate-string', 
			 		condition:'isInSocialReception-filled ',
			 		value:har.harDwellingSocialReceptionNaming, 
			 		title:message(code:'har.property.harDwellingSocialReceptionNaming.validationError')]"/>



<!--HarDwellingSocialReceptionAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionAddress',
			   		help:message(code:'har.property.harDwellingSocialReceptionAddress.help'),
			   		validation:'  validate-string',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingSocialReceptionAddress', 
			 		validation:'  validate-string', 
			 		condition:'isInSocialReception-filled ',
			 		value:har.harDwellingSocialReceptionAddress, 
			 		title:message(code:'har.property.harDwellingSocialReceptionAddress.validationError')]"/>



<!--HarDwellingSocialReceptionPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionPostalCode',
			   		help:message(code:'har.property.harDwellingSocialReceptionPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingSocialReceptionPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'isInSocialReception-filled ',
			 		value:har.harDwellingSocialReceptionPostalCode, 
			 		title:message(code:'har.property.harDwellingSocialReceptionPostalCode.validationError')]"/>



<!--HarDwellingSocialReceptionCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionCity',
			   		help:message(code:'har.property.harDwellingSocialReceptionCity.help'),
			   		validation:'  validate-city',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDwellingSocialReceptionCity', 
			 		validation:'  validate-city', 
			 		condition:'isInSocialReception-filled ',
			 		value:har.harDwellingSocialReceptionCity, 
			 		title:message(code:'har.property.harDwellingSocialReceptionCity.validationError')]"/>


