
<!--HarDwellingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingKind',
			   		help:null,
			   		validation:'null',
			   		condition:'isDwellingPlaceOfResidence-trigger ',
			   		elementName:'HarDwellingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingKind,
					type:'selectWidget',
					condition:'isDwellingPlaceOfResidence-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarDwellingKindType']" />


<!--HarDwellingPrecision -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingPrecision',
			   		help:null,
			   		validation:'null',
			   		condition:'isDwellingPlaceOfResidence-unfilled ',
			   		elementName:'HarDwellingPrecision', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingPrecision,
					type:'textWidget',
					condition:'isDwellingPlaceOfResidence-unfilled ']" />


<!--HarDwellingEstablishmentReception -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingEstablishmentReception',
			   		help:null,
			   		validation:'null',
			   		condition:'isInEstablishmentReception-trigger ',
			   		elementName:'HarDwellingEstablishmentReception', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingEstablishmentReception,
					type:'yesnoWidget',
					condition:'isInEstablishmentReception-trigger ']" />


<!--HarDwellingReceptionType -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionType',
			   		help:null,
			   		validation:'null',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionType', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingReceptionType,
					type:'selectWidget',
					condition:'isInEstablishmentReception-filled ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarDwellingReceptionKindType']" />


<!--DwellingReceptionNaming -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dwellingReceptionNaming',
			   		help:null,
			   		validation:'null',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'DwellingReceptionNaming', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.dwellingReceptionNaming,
					type:'textWidget',
					condition:'isInEstablishmentReception-filled ']" />


<!--HarDwellingReceptionAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingReceptionAddress,
					type:'textWidget',
					condition:'isInEstablishmentReception-filled ']" />


<!--HarDwellingReceptionPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingReceptionPostalCode,
					type:'textWidget',
					condition:'isInEstablishmentReception-filled ']" />


<!--HarDwellingReceptionCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingReceptionCity',
			   		help:null,
			   		validation:'null',
			   		condition:'isInEstablishmentReception-filled ',
			   		elementName:'HarDwellingReceptionCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingReceptionCity,
					type:'textWidget',
					condition:'isInEstablishmentReception-filled ']" />


<!--HarDwellingSocialReception -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReception',
			   		help:null,
			   		validation:'null',
			   		condition:'isInSocialReception-trigger ',
			   		elementName:'HarDwellingSocialReception', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingSocialReception,
					type:'yesnoWidget',
					condition:'isInSocialReception-trigger ']" />


<!--HarDwellingSocialReceptionNaming -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionNaming',
			   		help:null,
			   		validation:'null',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionNaming', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingSocialReceptionNaming,
					type:'textWidget',
					condition:'isInSocialReception-filled ']" />


<!--HarDwellingSocialReceptionAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingSocialReceptionAddress,
					type:'textWidget',
					condition:'isInSocialReception-filled ']" />


<!--HarDwellingSocialReceptionPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingSocialReceptionPostalCode,
					type:'textWidget',
					condition:'isInSocialReception-filled ']" />


<!--HarDwellingSocialReceptionCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDwellingSocialReceptionCity',
			   		help:null,
			   		validation:'null',
			   		condition:'isInSocialReception-filled ',
			   		elementName:'HarDwellingSocialReceptionCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDwellingSocialReceptionCity,
					type:'textWidget',
					condition:'isInSocialReception-filled ']" />

