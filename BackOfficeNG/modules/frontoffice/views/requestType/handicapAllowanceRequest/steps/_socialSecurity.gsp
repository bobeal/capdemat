<fieldset class="">

<!--HarSocialSecurity --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarSocialSecurity',
			   		condition:'',
			   		requestType: har]"/>



<!--HarSocialSecurityMemberShipKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityMemberShipKind',
			   		help:message(code:'har.property.harSocialSecurityMemberShipKind.help'),
			   		validation:'required validate-not-first',
			   		condition:'haveSocialSecurityMemberShip-trigger ',
			   		elementName:'HarSocialSecurityMemberShipKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harSocialSecurityMemberShipKind',
 					validation:'required validate-not-first', 
 					condition:'haveSocialSecurityMemberShip-trigger ', 
 					title:message(code:'har.property.harSocialSecurityMemberShipKind.validationError'), 
 					defaultOption:message(code:'har.property.harSocialSecurityMemberShipKind.defaultOption'),
 					selected:har.harSocialSecurityMemberShipKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarSocialSecurityMemberShipKindType']"/>


<!--HarSocialSecurityNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityNumber',
			   		help:message(code:'har.property.harSocialSecurityNumber.help'),
			   		validation:' ',
			   		condition:'haveSocialSecurityMemberShip-filled ',
			   		elementName:'HarSocialSecurityNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialSecurityNumber', 
			 		validation:' ', 
			 		condition:'haveSocialSecurityMemberShip-filled ',
			 		value:har.harSocialSecurityNumber, 
			 		title:message(code:'har.property.harSocialSecurityNumber.validationError')]"/>



<!--HarSocialSecurityAgencyName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyName',
			   		help:message(code:'har.property.harSocialSecurityAgencyName.help'),
			   		validation:'  validate-string',
			   		condition:'haveSocialSecurityMemberShip-filled ',
			   		elementName:'HarSocialSecurityAgencyName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialSecurityAgencyName', 
			 		validation:'  validate-string', 
			 		condition:'haveSocialSecurityMemberShip-filled ',
			 		value:har.harSocialSecurityAgencyName, 
			 		title:message(code:'har.property.harSocialSecurityAgencyName.validationError')]"/>



<!--HarSocialSecurityAgencyAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyAddress',
			   		help:message(code:'har.property.harSocialSecurityAgencyAddress.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarSocialSecurityAgencyAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialSecurityAgencyAddress', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harSocialSecurityAgencyAddress, 
			 		title:message(code:'har.property.harSocialSecurityAgencyAddress.validationError')]"/>



<!--HarSocialSecurityAgencyPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyPostalCode',
			   		help:message(code:'har.property.harSocialSecurityAgencyPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'',
			   		elementName:'HarSocialSecurityAgencyPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialSecurityAgencyPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'',
			 		value:har.harSocialSecurityAgencyPostalCode, 
			 		title:message(code:'har.property.harSocialSecurityAgencyPostalCode.validationError')]"/>



<!--HarSocialSecurityAgencyCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyCity',
			   		help:message(code:'har.property.harSocialSecurityAgencyCity.help'),
			   		validation:'  validate-city',
			   		condition:'',
			   		elementName:'HarSocialSecurityAgencyCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialSecurityAgencyCity', 
			 		validation:'  validate-city', 
			 		condition:'',
			 		value:har.harSocialSecurityAgencyCity, 
			 		title:message(code:'har.property.harSocialSecurityAgencyCity.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarPaymentAgency --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarPaymentAgency',
			   		condition:'',
			   		requestType: har]"/>



<!--HarPaymentAgencyBeneficiary -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyBeneficiary',
			   		help:message(code:'har.property.harPaymentAgencyBeneficiary.help'),
			   		validation:'required validate-not-first',
			   		condition:'havePaymentAgencyBeneficiary-trigger ',
			   		elementName:'HarPaymentAgencyBeneficiary', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harPaymentAgencyBeneficiary',
 					validation:'required validate-not-first', 
 					condition:'havePaymentAgencyBeneficiary-trigger ', 
 					title:message(code:'har.property.harPaymentAgencyBeneficiary.validationError'), 
 					defaultOption:message(code:'har.property.harPaymentAgencyBeneficiary.defaultOption'),
 					selected:har.harPaymentAgencyBeneficiary, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarPaymentAgencyBeneficiaryType']"/>


<!--HarPaymentAgencyBeneficiaryNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyBeneficiaryNumber',
			   		help:message(code:'har.property.harPaymentAgencyBeneficiaryNumber.help'),
			   		validation:' ',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyBeneficiaryNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harPaymentAgencyBeneficiaryNumber', 
			 		validation:' ', 
			 		condition:'havePaymentAgencyBeneficiary-filled ',
			 		value:har.harPaymentAgencyBeneficiaryNumber, 
			 		title:message(code:'har.property.harPaymentAgencyBeneficiaryNumber.validationError')]"/>



<!--HarPaymentAgencyName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyName',
			   		help:message(code:'har.property.harPaymentAgencyName.help'),
			   		validation:'  validate-string',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harPaymentAgencyName', 
			 		validation:'  validate-string', 
			 		condition:'havePaymentAgencyBeneficiary-filled ',
			 		value:har.harPaymentAgencyName, 
			 		title:message(code:'har.property.harPaymentAgencyName.validationError')]"/>



<!--HarPaymentAgencyAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyAddress',
			   		help:message(code:'har.property.harPaymentAgencyAddress.help'),
			   		validation:'  validate-string',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harPaymentAgencyAddress', 
			 		validation:'  validate-string', 
			 		condition:'havePaymentAgencyBeneficiary-filled ',
			 		value:har.harPaymentAgencyAddress, 
			 		title:message(code:'har.property.harPaymentAgencyAddress.validationError')]"/>



<!--HarPaymentAgencyPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyPostalCode',
			   		help:message(code:'har.property.harPaymentAgencyPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harPaymentAgencyPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'havePaymentAgencyBeneficiary-filled ',
			 		value:har.harPaymentAgencyPostalCode, 
			 		title:message(code:'har.property.harPaymentAgencyPostalCode.validationError')]"/>



<!--HarPaymentAgencyCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyCity',
			   		help:message(code:'har.property.harPaymentAgencyCity.help'),
			   		validation:'  validate-city',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harPaymentAgencyCity', 
			 		validation:'  validate-city', 
			 		condition:'havePaymentAgencyBeneficiary-filled ',
			 		value:har.harPaymentAgencyCity, 
			 		title:message(code:'har.property.harPaymentAgencyCity.validationError')]"/>


</fieldset>
