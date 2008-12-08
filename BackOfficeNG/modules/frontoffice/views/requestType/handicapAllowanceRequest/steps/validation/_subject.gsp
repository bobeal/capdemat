
<!--HarRequestInformationProfile -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequestInformationProfile',
			   		help:null,
			   		validation:'null',
			   		condition:'isAdult-trigger isLessThan20-trigger ',
			   		elementName:'HarRequestInformationProfile',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequestInformationProfile,
					type:'radioWidget',
					condition:'isAdult-trigger isLessThan20-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarRequestInformationProfileType']" />

<fieldset class="isAdult-filled ">

<!--HarRequester --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarRequester',
			   		condition:'isAdult-filled ',
			   		requestType: har]"/>



<!--HarRequesterTitle -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterTitle',
			   		help:null,
			   		validation:'null',
			   		condition:'isRequesterMadam-trigger ',
			   		elementName:'HarRequesterTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterTitle,
					type:'selectWidget',
					condition:'isRequesterMadam-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarTitleType']" />


<!--HarRequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterName,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMaidenName',
			   		help:null,
			   		validation:'null',
			   		condition:'isRequesterMadam-filled ',
			   		elementName:'HarRequesterMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterMaidenName,
					type:'textWidget',
					condition:'isRequesterMadam-filled ']" />


<!--HarRequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterFirstName,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterStreetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterStreetName,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterPostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterCity,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterPhone,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMobilePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterMobilePhone,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterEmail',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterEmail,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthDate',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterBirthDate,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterBirthCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterBirthCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterBirthCity,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterBirthCountry -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCountry',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterBirthCountry', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterBirthCountry,
					type:'selectWidget',
					condition:'',
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'CountryType']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'haveLegalAccessPresence-trigger ',
			   		elementName:'HarLegalAccessPresence', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessPresence,
					type:'yesnoWidget',
					condition:'haveLegalAccessPresence-trigger ']" />


<!--HarLegalAccessKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessKind',
			   		help:null,
			   		validation:'null',
			   		condition:'haveLegalAccessPresence-filled ',
			   		elementName:'HarLegalAccessKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessKind,
					type:'selectWidget',
					condition:'haveLegalAccessPresence-filled ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarLegalAccessKindType']" />


<!--HarLegalAccessRepresentativeKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeKind',
			   		help:null,
			   		validation:'null',
			   		condition:'haveLegalAccessPresence-filled isOtherLegalAccessRepresentative-trigger ',
			   		elementName:'HarLegalAccessRepresentativeKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeKind,
					type:'selectWidget',
					condition:'haveLegalAccessPresence-filled isOtherLegalAccessRepresentative-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarLegalAccessRepresentativeKindType']" />


<!--HarLegalAccessRepresentativeKindDetail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeKindDetail',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeKindDetail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeKindDetail,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativeName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeName',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeName,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativeFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeFirstName,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativeStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeStreetName',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeStreetName,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativePostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativePostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativePostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativePostalCode,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativeCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeCity',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeCity,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativePhone,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativeMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeMobilePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeMobilePhone,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />


<!--HarLegalAccessRepresentativeEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLegalAccessRepresentativeEmail',
			   		help:null,
			   		validation:'null',
			   		condition:'isOtherLegalAccessRepresentative-filled ',
			   		elementName:'HarLegalAccessRepresentativeEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterLegalAccessType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLegalAccessRepresentativeEmail,
					type:'textWidget',
					condition:'isOtherLegalAccessRepresentative-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isRequesterMadam-trigger ',
			   		elementName:'HarRequesterTitle', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterTitle,
					type:'selectWidget',
					condition:'isRequesterMadam-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarTitleType']" />


<!--HarRequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterName,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterMaidenName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMaidenName',
			   		help:null,
			   		validation:'null',
			   		condition:'isRequesterMadam-filled ',
			   		elementName:'HarRequesterMaidenName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterMaidenName,
					type:'textWidget',
					condition:'isRequesterMadam-filled ']" />


<!--HarRequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterFirstName,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterStreetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterStreetName,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterPostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterCity,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterPhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterPhone,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterMobilePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterMobilePhone,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterEmail',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterEmail,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthDate',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterBirthDate,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterBirthCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterBirthCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterBirthCity,
					type:'textWidget',
					condition:'']" />


<!--HarRequesterBirthCountry -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequesterBirthCountry',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequesterBirthCountry', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarRequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequesterBirthCountry,
					type:'selectWidget',
					condition:'',
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'CountryType']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterGender', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterGender,
					type:'radioWidget',
					condition:'',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarGenderType']" />


<!--HarLessThan20RequesterName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterFirstName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterStreetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterStreetName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterPostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterCity,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterPhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterPhone,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterMobilePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterMobilePhone,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterEmail -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterEmail',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterEmail', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterEmail,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterBirthDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterBirthDate',
			   		help:null,
			   		validation:'null',
			   		condition:'isLessThan18-trigger ',
			   		elementName:'HarLessThan20RequesterBirthDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterBirthDate,
					type:'textWidget',
					condition:'isLessThan18-trigger ']" />


<!--HarLessThan20RequesterBirthCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterBirthCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterBirthCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterBirthCity,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterBirthCountry -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterBirthCountry',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterBirthCountry', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterBirthCountry,
					type:'selectWidget',
					condition:'',
					namespace:'http://www.cg95.fr/cvq/schema/common',
 					elementTypeName:'CountryType']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentFirstName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentStreetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentStreetName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentPostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentCity,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentPhone,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentMobilePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentMobilePhone,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentJob -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentJob',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentJob', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentJob,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativeActivityReduction -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeActivityReduction',
			   		help:null,
			   		validation:'null',
			   		condition:'haveActivityReduction-trigger ',
			   		elementName:'HarLessThan20RequesterRepresentativeActivityReduction', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeActivityReduction,
					type:'yesnoWidget',
					condition:'haveActivityReduction-trigger ']" />


<!--HarLessThan20RequesterRepresentativeReductionRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeReductionRatio',
			   		help:null,
			   		validation:'null',
			   		condition:'haveActivityReduction-filled ',
			   		elementName:'HarLessThan20RequesterRepresentativeReductionRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeReductionRatio,
					type:'textWidget',
					condition:'haveActivityReduction-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentFirstName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentStreetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentStreetName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentPostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentCity,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentPhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentPhone,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentMobilePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentMobilePhone,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterParentJob -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterParentJob',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterParentJob', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterParentJob,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativeActivityReduction -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeActivityReduction',
			   		help:null,
			   		validation:'null',
			   		condition:'haveActivityReduction-trigger ',
			   		elementName:'HarLessThan20RequesterRepresentativeActivityReduction', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeActivityReduction,
					type:'yesnoWidget',
					condition:'haveActivityReduction-trigger ']" />


<!--HarLessThan20RequesterRepresentativeReductionRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeReductionRatio',
			   		help:null,
			   		validation:'null',
			   		condition:'haveActivityReduction-filled ',
			   		elementName:'HarLessThan20RequesterRepresentativeReductionRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterParentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeReductionRatio,
					type:'textWidget',
					condition:'haveActivityReduction-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativeFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeFirstName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativeStreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeStreetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeStreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeStreetName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativePostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativePostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativePostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativePostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativeCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeCity,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativePhone,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativeMobilePhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeMobilePhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeMobilePhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterRepresentativeType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeMobilePhone,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterWelfareReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeName,
					type:'textWidget',
					condition:'']" />


<!--HarLessThan20RequesterRepresentativeDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harLessThan20RequesterRepresentativeDepartment',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarLessThan20RequesterRepresentativeDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarLessThan20RequesterWelfareReferentType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harLessThan20RequesterRepresentativeDepartment,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'FamilyStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFamilyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.familyStatus,
					type:'selectWidget',
					condition:'',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarFamilyStatusType']" />


<!--FamilyHasFamilyDependents -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'familyHasFamilyDependents',
			   		help:null,
			   		validation:'null',
			   		condition:'haveFamilyDependent-trigger ',
			   		elementName:'FamilyHasFamilyDependents', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFamilyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.familyHasFamilyDependents,
					type:'yesnoWidget',
					condition:'haveFamilyDependent-trigger ']" />

</fieldset>
