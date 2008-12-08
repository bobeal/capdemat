
<!--HarRequestInformationProfile -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequestInformationProfile',
			   		help:message(code:'har.property.harRequestInformationProfile.help'),
			   		validation:' validate-one-required',
			   		condition:'isAdult-trigger isLessThan20-trigger ',
			   		elementName:'HarRequestInformationProfile',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/radio" 
					model="[name:'harRequestInformationProfile', 
					validation:' validate-one-required',	
					condition:'isAdult-trigger isLessThan20-trigger ',
					title:message(code:'har.property.harRequestInformationProfile.validationError'),
					checked:har.harRequestInformationProfile,	
					namespace:'http://www.cg95.fr/cvq/schema/har',
					modelNamespace:'fr.cg95.cvq.business.request.social',
					elementTypeName:'HarRequestInformationProfileType']"/>

<fieldset class="isAdult-filled ">

<!--HarRequester --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarRequester',
			   		condition:'isAdult-filled ',
			   		requestType: har]"/>



<!--HarRequesterTitle -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterTitle',
			   		help:message(code:'har.property.harRequesterTitle.help'),
			   		validation:' validate-not-first',
			   		condition:'isRequesterMadam-trigger ',
			   		elementName:'HarRequesterTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harRequesterTitle',
 					validation:' validate-not-first', 
 					condition:'isRequesterMadam-trigger ', 
 					title:message(code:'har.property.harRequesterTitle.validationError'), 
 					defaultOption:message(code:'har.property.harRequesterTitle.defaultOption'),
 					selected:har.harRequesterTitle, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarTitleType']"/>


<!--HarRequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterName',
			   		help:message(code:'har.property.harRequesterName.help'),
			   		validation:'required  validate-lastname',
			   		condition:'',
			   		elementName:'HarRequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterName', 
			 		validation:'required  validate-lastname', 
			 		condition:'',
			 		value:har.harRequesterName, 
			 		title:message(code:'har.property.harRequesterName.validationError')]"/>



<!--HarRequesterMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMaidenName',
			   		help:message(code:'har.property.harRequesterMaidenName.help'),
			   		validation:'  validate-lastname',
			   		condition:'isRequesterMadam-filled ',
			   		elementName:'HarRequesterMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterMaidenName', 
			 		validation:'  validate-lastname', 
			 		condition:'isRequesterMadam-filled ',
			 		value:har.harRequesterMaidenName, 
			 		title:message(code:'har.property.harRequesterMaidenName.validationError')]"/>



<!--HarRequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterFirstName',
			   		help:message(code:'har.property.harRequesterFirstName.help'),
			   		validation:'required  validate-firstname',
			   		condition:'',
			   		elementName:'HarRequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterFirstName', 
			 		validation:'required  validate-firstname', 
			 		condition:'',
			 		value:har.harRequesterFirstName, 
			 		title:message(code:'har.property.harRequesterFirstName.validationError')]"/>



<!--HarRequesterStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterStreetName',
			   		help:message(code:'har.property.harRequesterStreetName.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'HarRequesterStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterStreetName', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:har.harRequesterStreetName, 
			 		title:message(code:'har.property.harRequesterStreetName.validationError')]"/>



<!--HarRequesterPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPostalCode',
			   		help:message(code:'har.property.harRequesterPostalCode.help'),
			   		validation:'required  validate-postalcode',
			   		condition:'',
			   		elementName:'HarRequesterPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterPostalCode', 
			 		validation:'required  validate-postalcode', 
			 		condition:'',
			 		value:har.harRequesterPostalCode, 
			 		title:message(code:'har.property.harRequesterPostalCode.validationError')]"/>



<!--HarRequesterCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterCity',
			   		help:message(code:'har.property.harRequesterCity.help'),
			   		validation:'required  validate-city',
			   		condition:'',
			   		elementName:'HarRequesterCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterCity', 
			 		validation:'required  validate-city', 
			 		condition:'',
			 		value:har.harRequesterCity, 
			 		title:message(code:'har.property.harRequesterCity.validationError')]"/>



<!--HarRequesterPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPhone',
			   		help:message(code:'har.property.harRequesterPhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarRequesterPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterPhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harRequesterPhone, 
			 		title:message(code:'har.property.harRequesterPhone.validationError')]"/>



<!--HarRequesterMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMobilePhone',
			   		help:message(code:'har.property.harRequesterMobilePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarRequesterMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterMobilePhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harRequesterMobilePhone, 
			 		title:message(code:'har.property.harRequesterMobilePhone.validationError')]"/>



<!--HarRequesterEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterEmail',
			   		help:message(code:'har.property.harRequesterEmail.help'),
			   		validation:'  validate-email',
			   		condition:'',
			   		elementName:'HarRequesterEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterEmail', 
			 		validation:'  validate-email', 
			 		condition:'',
			 		value:har.harRequesterEmail, 
			 		title:message(code:'har.property.harRequesterEmail.validationError')]"/>



<!--HarRequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthDate',
			   		help:message(code:'har.property.harRequesterBirthDate.help'),
			   		validation:'required  validate-date-au',
			   		condition:'',
			   		elementName:'HarRequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterBirthDate', 
			 		validation:'required  validate-date-au', 
			 		condition:'',
			 		value:har.harRequesterBirthDate, 
			 		title:message(code:'har.property.harRequesterBirthDate.validationError')]"/>



<!--HarRequesterBirthCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCity',
			   		help:message(code:'har.property.harRequesterBirthCity.help'),
			   		validation:'required  validate-city',
			   		condition:'',
			   		elementName:'HarRequesterBirthCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterBirthCity', 
			 		validation:'required  validate-city', 
			 		condition:'',
			 		value:har.harRequesterBirthCity, 
			 		title:message(code:'har.property.harRequesterBirthCity.validationError')]"/>



<!--HarRequesterBirthCountry -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCountry',
			   		help:message(code:'har.property.harRequesterBirthCountry.help'),
			   		validation:'required validate-not-first',
			   		condition:'',
			   		elementName:'HarRequesterBirthCountry', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harRequesterBirthCountry',
 					validation:'required validate-not-first', 
 					condition:'', 
 					title:message(code:'har.property.harRequesterBirthCountry.validationError'), 
 					defaultOption:message(code:'har.property.harRequesterBirthCountry.defaultOption'),
 					selected:har.harRequesterBirthCountry, 
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'CountryType']"/>

</fieldset>
<fieldset class="isAdult-filled ">

<!--HarRequesterLegalAccess --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarRequesterLegalAccess',
			   		condition:'isAdult-filled ',
			   		requestType: har]"/>



<!--HarLegalAccessPresence -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessPresence',
			   		help:message(code:'har.property.harLegalAccessPresence.help'),
			   		validation:'required validate-one-required',
			   		condition:'haveLegalAccessPresence-trigger ',
			   		elementName:'HarLegalAccessPresence', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harLegalAccessPresence', 
			   		validation:'required validate-one-required', 
			   		condition:'haveLegalAccessPresence-trigger ',
			   		title:message(code:'har.property.harLegalAccessPresence.validationError'),
			   		checked:har.harLegalAccessPresence]" />


<!--HarLegalAccessKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessKind',
			   		help:message(code:'har.property.harLegalAccessKind.help'),
			   		validation:' validate-not-first',
			   		condition:'haveLegalAccessPresence-filled ',
			   		elementName:'HarLegalAccessKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harLegalAccessKind',
 					validation:' validate-not-first', 
 					condition:'haveLegalAccessPresence-filled ', 
 					title:message(code:'har.property.harLegalAccessKind.validationError'), 
 					defaultOption:message(code:'har.property.harLegalAccessKind.defaultOption'),
 					selected:har.harLegalAccessKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarLegalAccessKindType']"/>


<!--HarLegalAccessRepresentativeKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeKind',
			   		help:message(code:'har.property.harLegalAccessRepresentativeKind.help'),
			   		validation:' validate-not-first',
			   		condition:'haveLegalAccessPresence-filled isOtherLegalAccessRepresentative-trigger ',
			   		elementName:'HarLegalAccessRepresentativeKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harLegalAccessRepresentativeKind',
 					validation:' validate-not-first', 
 					condition:'haveLegalAccessPresence-filled isOtherLegalAccessRepresentative-trigger ', 
 					title:message(code:'har.property.harLegalAccessRepresentativeKind.validationError'), 
 					defaultOption:message(code:'har.property.harLegalAccessRepresentativeKind.defaultOption'),
 					selected:har.harLegalAccessRepresentativeKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarLegalAccessRepresentativeKindType']"/>


<!--HarLegalAccessRepresentativeKindDetail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeKindDetail',
			   		help:message(code:'har.property.harLegalAccessRepresentativeKindDetail.help'),
			   		validation:'  validate-string',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeKindDetail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativeKindDetail', 
			 		validation:'  validate-string', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativeKindDetail, 
			 		title:message(code:'har.property.harLegalAccessRepresentativeKindDetail.validationError')]"/>



<!--HarLegalAccessRepresentativeName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeName',
			   		help:message(code:'har.property.harLegalAccessRepresentativeName.help'),
			   		validation:'  validate-lastname',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativeName', 
			 		validation:'  validate-lastname', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativeName, 
			 		title:message(code:'har.property.harLegalAccessRepresentativeName.validationError')]"/>



<!--HarLegalAccessRepresentativeFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeFirstName',
			   		help:message(code:'har.property.harLegalAccessRepresentativeFirstName.help'),
			   		validation:'  validate-firstname',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativeFirstName', 
			 		validation:'  validate-firstname', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativeFirstName, 
			 		title:message(code:'har.property.harLegalAccessRepresentativeFirstName.validationError')]"/>



<!--HarLegalAccessRepresentativeStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeStreetName',
			   		help:message(code:'har.property.harLegalAccessRepresentativeStreetName.help'),
			   		validation:'  validate-string',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativeStreetName', 
			 		validation:'  validate-string', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativeStreetName, 
			 		title:message(code:'har.property.harLegalAccessRepresentativeStreetName.validationError')]"/>



<!--HarLegalAccessRepresentativePostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativePostalCode',
			   		help:message(code:'har.property.harLegalAccessRepresentativePostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativePostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativePostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativePostalCode, 
			 		title:message(code:'har.property.harLegalAccessRepresentativePostalCode.validationError')]"/>



<!--HarLegalAccessRepresentativeCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeCity',
			   		help:message(code:'har.property.harLegalAccessRepresentativeCity.help'),
			   		validation:'  validate-city',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativeCity', 
			 		validation:'  validate-city', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativeCity, 
			 		title:message(code:'har.property.harLegalAccessRepresentativeCity.validationError')]"/>



<!--HarLegalAccessRepresentativePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativePhone',
			   		help:message(code:'har.property.harLegalAccessRepresentativePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativePhone', 
			 		validation:'  validate-phone', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativePhone, 
			 		title:message(code:'har.property.harLegalAccessRepresentativePhone.validationError')]"/>



<!--HarLegalAccessRepresentativeMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeMobilePhone',
			   		help:message(code:'har.property.harLegalAccessRepresentativeMobilePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativeMobilePhone', 
			 		validation:'  validate-phone', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativeMobilePhone, 
			 		title:message(code:'har.property.harLegalAccessRepresentativeMobilePhone.validationError')]"/>



<!--HarLegalAccessRepresentativeEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeEmail',
			   		help:message(code:'har.property.harLegalAccessRepresentativeEmail.help'),
			   		validation:'  validate-email',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLegalAccessRepresentativeEmail', 
			 		validation:'  validate-email', 
			 		condition:'isOtherLegalAccessRepresentative-filled ',
			 		value:har.harLegalAccessRepresentativeEmail, 
			 		title:message(code:'har.property.harLegalAccessRepresentativeEmail.validationError')]"/>


</fieldset>
<fieldset class="isLessThan20-filled ">

<!--HarRequesterReferent --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarRequesterReferent',
			   		condition:'isLessThan20-filled ',
			   		requestType: har]"/>



<!--HarRequesterTitle -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterTitle',
			   		help:message(code:'har.property.harRequesterTitle.help'),
			   		validation:' validate-not-first',
			   		condition:'isRequesterMadam-trigger ',
			   		elementName:'HarRequesterTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harRequesterTitle',
 					validation:' validate-not-first', 
 					condition:'isRequesterMadam-trigger ', 
 					title:message(code:'har.property.harRequesterTitle.validationError'), 
 					defaultOption:message(code:'har.property.harRequesterTitle.defaultOption'),
 					selected:har.harRequesterTitle, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarTitleType']"/>


<!--HarRequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterName',
			   		help:message(code:'har.property.harRequesterName.help'),
			   		validation:'required  validate-lastname',
			   		condition:'',
			   		elementName:'HarRequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterName', 
			 		validation:'required  validate-lastname', 
			 		condition:'',
			 		value:har.harRequesterName, 
			 		title:message(code:'har.property.harRequesterName.validationError')]"/>



<!--HarRequesterMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMaidenName',
			   		help:message(code:'har.property.harRequesterMaidenName.help'),
			   		validation:'  validate-lastname',
			   		condition:'isRequesterMadam-filled ',
			   		elementName:'HarRequesterMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterMaidenName', 
			 		validation:'  validate-lastname', 
			 		condition:'isRequesterMadam-filled ',
			 		value:har.harRequesterMaidenName, 
			 		title:message(code:'har.property.harRequesterMaidenName.validationError')]"/>



<!--HarRequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterFirstName',
			   		help:message(code:'har.property.harRequesterFirstName.help'),
			   		validation:'required  validate-firstname',
			   		condition:'',
			   		elementName:'HarRequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterFirstName', 
			 		validation:'required  validate-firstname', 
			 		condition:'',
			 		value:har.harRequesterFirstName, 
			 		title:message(code:'har.property.harRequesterFirstName.validationError')]"/>



<!--HarRequesterStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterStreetName',
			   		help:message(code:'har.property.harRequesterStreetName.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'HarRequesterStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterStreetName', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:har.harRequesterStreetName, 
			 		title:message(code:'har.property.harRequesterStreetName.validationError')]"/>



<!--HarRequesterPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPostalCode',
			   		help:message(code:'har.property.harRequesterPostalCode.help'),
			   		validation:'required  validate-postalcode',
			   		condition:'',
			   		elementName:'HarRequesterPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterPostalCode', 
			 		validation:'required  validate-postalcode', 
			 		condition:'',
			 		value:har.harRequesterPostalCode, 
			 		title:message(code:'har.property.harRequesterPostalCode.validationError')]"/>



<!--HarRequesterCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterCity',
			   		help:message(code:'har.property.harRequesterCity.help'),
			   		validation:'required  validate-city',
			   		condition:'',
			   		elementName:'HarRequesterCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterCity', 
			 		validation:'required  validate-city', 
			 		condition:'',
			 		value:har.harRequesterCity, 
			 		title:message(code:'har.property.harRequesterCity.validationError')]"/>



<!--HarRequesterPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPhone',
			   		help:message(code:'har.property.harRequesterPhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarRequesterPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterPhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harRequesterPhone, 
			 		title:message(code:'har.property.harRequesterPhone.validationError')]"/>



<!--HarRequesterMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMobilePhone',
			   		help:message(code:'har.property.harRequesterMobilePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarRequesterMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterMobilePhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harRequesterMobilePhone, 
			 		title:message(code:'har.property.harRequesterMobilePhone.validationError')]"/>



<!--HarRequesterEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterEmail',
			   		help:message(code:'har.property.harRequesterEmail.help'),
			   		validation:'  validate-email',
			   		condition:'',
			   		elementName:'HarRequesterEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterEmail', 
			 		validation:'  validate-email', 
			 		condition:'',
			 		value:har.harRequesterEmail, 
			 		title:message(code:'har.property.harRequesterEmail.validationError')]"/>



<!--HarRequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthDate',
			   		help:message(code:'har.property.harRequesterBirthDate.help'),
			   		validation:'required  validate-date-au',
			   		condition:'',
			   		elementName:'HarRequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterBirthDate', 
			 		validation:'required  validate-date-au', 
			 		condition:'',
			 		value:har.harRequesterBirthDate, 
			 		title:message(code:'har.property.harRequesterBirthDate.validationError')]"/>



<!--HarRequesterBirthCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCity',
			   		help:message(code:'har.property.harRequesterBirthCity.help'),
			   		validation:'required  validate-city',
			   		condition:'',
			   		elementName:'HarRequesterBirthCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRequesterBirthCity', 
			 		validation:'required  validate-city', 
			 		condition:'',
			 		value:har.harRequesterBirthCity, 
			 		title:message(code:'har.property.harRequesterBirthCity.validationError')]"/>



<!--HarRequesterBirthCountry -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCountry',
			   		help:message(code:'har.property.harRequesterBirthCountry.help'),
			   		validation:'required validate-not-first',
			   		condition:'',
			   		elementName:'HarRequesterBirthCountry', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harRequesterBirthCountry',
 					validation:'required validate-not-first', 
 					condition:'', 
 					title:message(code:'har.property.harRequesterBirthCountry.validationError'), 
 					defaultOption:message(code:'har.property.harRequesterBirthCountry.defaultOption'),
 					selected:har.harRequesterBirthCountry, 
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'CountryType']"/>

</fieldset>
<fieldset class="isLessThan20-filled ">

<!--HarLessThan20Requester --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarLessThan20Requester',
			   		condition:'isLessThan20-filled ',
			   		requestType: har]"/>



<!--HarLessThan20RequesterGender -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterGender',
			   		help:message(code:'har.property.harLessThan20RequesterGender.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterGender', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/radio" 
					model="[name:'harLessThan20RequesterGender', 
					validation:'required validate-one-required',	
					condition:'',
					title:message(code:'har.property.harLessThan20RequesterGender.validationError'),
					checked:har.harLessThan20RequesterGender,	
					namespace:'http://www.cg95.fr/cvq/schema/har',
					modelNamespace:'fr.cg95.cvq.business.request.social',
					elementTypeName:'HarGenderType']"/>


<!--HarLessThan20RequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterName',
			   		help:message(code:'har.property.harLessThan20RequesterName.help'),
			   		validation:'required  validate-lastname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterName', 
			 		validation:'required  validate-lastname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterName, 
			 		title:message(code:'har.property.harLessThan20RequesterName.validationError')]"/>



<!--HarLessThan20RequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterFirstName',
			   		help:message(code:'har.property.harLessThan20RequesterFirstName.help'),
			   		validation:'required  validate-firstname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterFirstName', 
			 		validation:'required  validate-firstname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterFirstName, 
			 		title:message(code:'har.property.harLessThan20RequesterFirstName.validationError')]"/>



<!--HarLessThan20RequesterStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterStreetName',
			   		help:message(code:'har.property.harLessThan20RequesterStreetName.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterStreetName', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harLessThan20RequesterStreetName, 
			 		title:message(code:'har.property.harLessThan20RequesterStreetName.validationError')]"/>



<!--HarLessThan20RequesterPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterPostalCode',
			   		help:message(code:'har.property.harLessThan20RequesterPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'',
			 		value:har.harLessThan20RequesterPostalCode, 
			 		title:message(code:'har.property.harLessThan20RequesterPostalCode.validationError')]"/>



<!--HarLessThan20RequesterCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterCity',
			   		help:message(code:'har.property.harLessThan20RequesterCity.help'),
			   		validation:'  validate-city',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterCity', 
			 		validation:'  validate-city', 
			 		condition:'',
			 		value:har.harLessThan20RequesterCity, 
			 		title:message(code:'har.property.harLessThan20RequesterCity.validationError')]"/>



<!--HarLessThan20RequesterPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterPhone',
			   		help:message(code:'har.property.harLessThan20RequesterPhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterPhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterPhone, 
			 		title:message(code:'har.property.harLessThan20RequesterPhone.validationError')]"/>



<!--HarLessThan20RequesterMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterMobilePhone',
			   		help:message(code:'har.property.harLessThan20RequesterMobilePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterMobilePhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterMobilePhone, 
			 		title:message(code:'har.property.harLessThan20RequesterMobilePhone.validationError')]"/>



<!--HarLessThan20RequesterEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterEmail',
			   		help:message(code:'har.property.harLessThan20RequesterEmail.help'),
			   		validation:'  validate-email',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterEmail', 
			 		validation:'  validate-email', 
			 		condition:'',
			 		value:har.harLessThan20RequesterEmail, 
			 		title:message(code:'har.property.harLessThan20RequesterEmail.validationError')]"/>



<!--HarLessThan20RequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterBirthDate',
			   		help:message(code:'har.property.harLessThan20RequesterBirthDate.help'),
			   		validation:'required  validate-date-au',
			   		condition:'isLessThan18-trigger ',
			   		elementName:'HarLessThan20RequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterBirthDate', 
			 		validation:'required  validate-date-au', 
			 		condition:'isLessThan18-trigger ',
			 		value:har.harLessThan20RequesterBirthDate, 
			 		title:message(code:'har.property.harLessThan20RequesterBirthDate.validationError')]"/>



<!--HarLessThan20RequesterBirthCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterBirthCity',
			   		help:message(code:'har.property.harLessThan20RequesterBirthCity.help'),
			   		validation:'required  validate-city',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterBirthCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterBirthCity', 
			 		validation:'required  validate-city', 
			 		condition:'',
			 		value:har.harLessThan20RequesterBirthCity, 
			 		title:message(code:'har.property.harLessThan20RequesterBirthCity.validationError')]"/>



<!--HarLessThan20RequesterBirthCountry -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterBirthCountry',
			   		help:message(code:'har.property.harLessThan20RequesterBirthCountry.help'),
			   		validation:'required validate-not-first',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterBirthCountry', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harLessThan20RequesterBirthCountry',
 					validation:'required validate-not-first', 
 					condition:'', 
 					title:message(code:'har.property.harLessThan20RequesterBirthCountry.validationError'), 
 					defaultOption:message(code:'har.property.harLessThan20RequesterBirthCountry.defaultOption'),
 					selected:har.harLessThan20RequesterBirthCountry, 
 					namespace:'http://www.cg95.fr/cvq/schema/common', 
 					modelNamespace:'fr.cg95.cvq.business.users',
 					elementTypeName:'CountryType']"/>

</fieldset>
<fieldset class="isLessThan18-filled ">

<!--HarLessThan20RequesterFather --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarLessThan20RequesterFather',
			   		condition:'isLessThan18-filled ',
			   		requestType: har]"/>



<!--HarLessThan20RequesterParentName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentName',
			   		help:message(code:'har.property.harLessThan20RequesterParentName.help'),
			   		validation:'  validate-lastname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentName', 
			 		validation:'  validate-lastname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentName, 
			 		title:message(code:'har.property.harLessThan20RequesterParentName.validationError')]"/>



<!--HarLessThan20RequesterParentFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentFirstName',
			   		help:message(code:'har.property.harLessThan20RequesterParentFirstName.help'),
			   		validation:'  validate-firstname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentFirstName', 
			 		validation:'  validate-firstname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentFirstName, 
			 		title:message(code:'har.property.harLessThan20RequesterParentFirstName.validationError')]"/>



<!--HarLessThan20RequesterParentStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentStreetName',
			   		help:message(code:'har.property.harLessThan20RequesterParentStreetName.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentStreetName', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentStreetName, 
			 		title:message(code:'har.property.harLessThan20RequesterParentStreetName.validationError')]"/>



<!--HarLessThan20RequesterParentPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPostalCode',
			   		help:message(code:'har.property.harLessThan20RequesterParentPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentPostalCode, 
			 		title:message(code:'har.property.harLessThan20RequesterParentPostalCode.validationError')]"/>



<!--HarLessThan20RequesterParentCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentCity',
			   		help:message(code:'har.property.harLessThan20RequesterParentCity.help'),
			   		validation:'  validate-city',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentCity', 
			 		validation:'  validate-city', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentCity, 
			 		title:message(code:'har.property.harLessThan20RequesterParentCity.validationError')]"/>



<!--HarLessThan20RequesterParentPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPhone',
			   		help:message(code:'har.property.harLessThan20RequesterParentPhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentPhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentPhone, 
			 		title:message(code:'har.property.harLessThan20RequesterParentPhone.validationError')]"/>



<!--HarLessThan20RequesterParentMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentMobilePhone',
			   		help:message(code:'har.property.harLessThan20RequesterParentMobilePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentMobilePhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentMobilePhone, 
			 		title:message(code:'har.property.harLessThan20RequesterParentMobilePhone.validationError')]"/>



<!--HarLessThan20RequesterParentJob -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentJob',
			   		help:message(code:'har.property.harLessThan20RequesterParentJob.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentJob', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentJob', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentJob, 
			 		title:message(code:'har.property.harLessThan20RequesterParentJob.validationError')]"/>



<!--HarLessThan20RequesterRepresentativeActivityReduction -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeActivityReduction',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeActivityReduction.help'),
			   		validation:'required validate-one-required',
			   		condition:'haveActivityReduction-trigger ',
			   		elementName:'HarLessThan20RequesterRepresentativeActivityReduction', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harLessThan20RequesterRepresentativeActivityReduction', 
			   		validation:'required validate-one-required', 
			   		condition:'haveActivityReduction-trigger ',
			   		title:message(code:'har.property.harLessThan20RequesterRepresentativeActivityReduction.validationError'),
			   		checked:har.harLessThan20RequesterRepresentativeActivityReduction]" />


<!--HarLessThan20RequesterRepresentativeReductionRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeReductionRatio',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeReductionRatio.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'haveActivityReduction-filled ',
			   		elementName:'HarLessThan20RequesterRepresentativeReductionRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeReductionRatio', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'haveActivityReduction-filled ',
			 		value:har.harLessThan20RequesterRepresentativeReductionRatio, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeReductionRatio.validationError')]"/>


</fieldset>
<fieldset class="isLessThan18-filled ">

<!--HarLessThan20RequesterMother --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarLessThan20RequesterMother',
			   		condition:'isLessThan18-filled ',
			   		requestType: har]"/>



<!--HarLessThan20RequesterParentName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentName',
			   		help:message(code:'har.property.harLessThan20RequesterParentName.help'),
			   		validation:'  validate-lastname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentName', 
			 		validation:'  validate-lastname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentName, 
			 		title:message(code:'har.property.harLessThan20RequesterParentName.validationError')]"/>



<!--HarLessThan20RequesterParentFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentFirstName',
			   		help:message(code:'har.property.harLessThan20RequesterParentFirstName.help'),
			   		validation:'  validate-firstname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentFirstName', 
			 		validation:'  validate-firstname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentFirstName, 
			 		title:message(code:'har.property.harLessThan20RequesterParentFirstName.validationError')]"/>



<!--HarLessThan20RequesterParentStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentStreetName',
			   		help:message(code:'har.property.harLessThan20RequesterParentStreetName.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentStreetName', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentStreetName, 
			 		title:message(code:'har.property.harLessThan20RequesterParentStreetName.validationError')]"/>



<!--HarLessThan20RequesterParentPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPostalCode',
			   		help:message(code:'har.property.harLessThan20RequesterParentPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentPostalCode, 
			 		title:message(code:'har.property.harLessThan20RequesterParentPostalCode.validationError')]"/>



<!--HarLessThan20RequesterParentCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentCity',
			   		help:message(code:'har.property.harLessThan20RequesterParentCity.help'),
			   		validation:'  validate-city',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentCity', 
			 		validation:'  validate-city', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentCity, 
			 		title:message(code:'har.property.harLessThan20RequesterParentCity.validationError')]"/>



<!--HarLessThan20RequesterParentPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPhone',
			   		help:message(code:'har.property.harLessThan20RequesterParentPhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentPhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentPhone, 
			 		title:message(code:'har.property.harLessThan20RequesterParentPhone.validationError')]"/>



<!--HarLessThan20RequesterParentMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentMobilePhone',
			   		help:message(code:'har.property.harLessThan20RequesterParentMobilePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentMobilePhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentMobilePhone, 
			 		title:message(code:'har.property.harLessThan20RequesterParentMobilePhone.validationError')]"/>



<!--HarLessThan20RequesterParentJob -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentJob',
			   		help:message(code:'har.property.harLessThan20RequesterParentJob.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentJob', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterParentJob', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harLessThan20RequesterParentJob, 
			 		title:message(code:'har.property.harLessThan20RequesterParentJob.validationError')]"/>



<!--HarLessThan20RequesterRepresentativeActivityReduction -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeActivityReduction',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeActivityReduction.help'),
			   		validation:'required validate-one-required',
			   		condition:'haveActivityReduction-trigger ',
			   		elementName:'HarLessThan20RequesterRepresentativeActivityReduction', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harLessThan20RequesterRepresentativeActivityReduction', 
			   		validation:'required validate-one-required', 
			   		condition:'haveActivityReduction-trigger ',
			   		title:message(code:'har.property.harLessThan20RequesterRepresentativeActivityReduction.validationError'),
			   		checked:har.harLessThan20RequesterRepresentativeActivityReduction]" />


<!--HarLessThan20RequesterRepresentativeReductionRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeReductionRatio',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeReductionRatio.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'haveActivityReduction-filled ',
			   		elementName:'HarLessThan20RequesterRepresentativeReductionRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeReductionRatio', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'haveActivityReduction-filled ',
			 		value:har.harLessThan20RequesterRepresentativeReductionRatio, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeReductionRatio.validationError')]"/>


</fieldset>
<fieldset class="isLessThan18-filled ">

<!--HarLessThan20RequesterRepresentative --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarLessThan20RequesterRepresentative',
			   		condition:'isLessThan18-filled ',
			   		requestType: har]"/>



<!--HarLessThan20RequesterRepresentativeName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeName',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeName.help'),
			   		validation:'  validate-lastname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeName', 
			 		validation:'  validate-lastname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativeName, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeName.validationError')]"/>



<!--HarLessThan20RequesterRepresentativeFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeFirstName',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeFirstName.help'),
			   		validation:'  validate-firstname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeFirstName', 
			 		validation:'  validate-firstname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativeFirstName, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeFirstName.validationError')]"/>



<!--HarLessThan20RequesterRepresentativeStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeStreetName',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeStreetName.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeStreetName', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativeStreetName, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeStreetName.validationError')]"/>



<!--HarLessThan20RequesterRepresentativePostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativePostalCode',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativePostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativePostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativePostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativePostalCode, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativePostalCode.validationError')]"/>



<!--HarLessThan20RequesterRepresentativeCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeCity',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeCity.help'),
			   		validation:'  validate-city',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeCity', 
			 		validation:'  validate-city', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativeCity, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeCity.validationError')]"/>



<!--HarLessThan20RequesterRepresentativePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativePhone',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativePhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativePhone, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativePhone.validationError')]"/>



<!--HarLessThan20RequesterRepresentativeMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeMobilePhone',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeMobilePhone.help'),
			   		validation:'  validate-phone',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeMobilePhone', 
			 		validation:'  validate-phone', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativeMobilePhone, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeMobilePhone.validationError')]"/>


</fieldset>
<fieldset class="isLessThan18-filled ">

<!--HarLessThan20RequesterAuthorityHolder --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarLessThan20RequesterAuthorityHolder',
			   		condition:'isLessThan18-filled ',
			   		requestType: har]"/>


</fieldset>
<fieldset class="isLessThan18-filled ">

<!--HarLessThan20RequesterWelfareReferent --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarLessThan20RequesterWelfareReferent',
			   		condition:'isLessThan18-filled ',
			   		requestType: har]"/>



<!--HarLessThan20RequesterRepresentativeName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeName',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeName.help'),
			   		validation:'  validate-lastname',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterWelfareReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeName', 
			 		validation:'  validate-lastname', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativeName, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeName.validationError')]"/>



<!--HarLessThan20RequesterRepresentativeDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeDepartment',
			   		help:message(code:'har.property.harLessThan20RequesterRepresentativeDepartment.help'),
			   		validation:'  validate-departmentcode',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterWelfareReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harLessThan20RequesterRepresentativeDepartment', 
			 		validation:'  validate-departmentcode', 
			 		condition:'',
			 		value:har.harLessThan20RequesterRepresentativeDepartment, 
			 		title:message(code:'har.property.harLessThan20RequesterRepresentativeDepartment.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarFamily --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarFamily',
			   		condition:'',
			   		requestType: har]"/>



<!--FamilyStatus -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'familyStatus',
			   		help:message(code:'har.property.familyStatus.help'),
			   		validation:'required validate-not-first',
			   		condition:'',
			   		elementName:'FamilyStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFamilyType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'familyStatus',
 					validation:'required validate-not-first', 
 					condition:'', 
 					title:message(code:'har.property.familyStatus.validationError'), 
 					defaultOption:message(code:'har.property.familyStatus.defaultOption'),
 					selected:har.familyStatus, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarFamilyStatusType']"/>


<!--FamilyHasFamilyDependents -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'familyHasFamilyDependents',
			   		help:message(code:'har.property.familyHasFamilyDependents.help'),
			   		validation:'required validate-one-required',
			   		condition:'haveFamilyDependent-trigger ',
			   		elementName:'FamilyHasFamilyDependents', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFamilyType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'familyHasFamilyDependents', 
			   		validation:'required validate-one-required', 
			   		condition:'haveFamilyDependent-trigger ',
			   		title:message(code:'har.property.familyHasFamilyDependents.validationError'),
			   		checked:har.familyHasFamilyDependents]" />

</fieldset>
