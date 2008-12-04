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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalDeliveryInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.additionalDeliveryInformation,
					type:'textWidget',
					condition:'']" />


<!--AdditionalGeographicalInformation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'additionalGeographicalInformation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'AdditionalGeographicalInformation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.additionalGeographicalInformation,
					type:'textWidget',
					condition:'']" />


<!--StreetNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.streetNumber,
					type:'textWidget',
					condition:'']" />


<!--StreetName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'streetName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'StreetName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.streetName,
					type:'textWidget',
					condition:'']" />


<!--PlaceNameOrService -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'placeNameOrService',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PlaceNameOrService', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.placeNameOrService,
					type:'textWidget',
					condition:'']" />


<!--PostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'postalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.postalCode,
					type:'textWidget',
					condition:'']" />


<!--City -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'city',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'City', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.city,
					type:'textWidget',
					condition:'']" />


<!--CountryName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'countryName',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'CountryName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/common',
			   		elementTypeName : 'AddressType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingAddress?.countryName,
					type:'textWidget',
					condition:'']" />

</fieldset>

<!--DhrCurrentDwellingPhone -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingPhone',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrCurrentDwellingPhone', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingPhone,
					type:'textWidget',
					condition:'']" />


<!--DhrCurrentDwellingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingKind',
			   		help:null,
			   		validation:'null',
			   		condition:'isCurrentDwellingPlaceOfResidence-trigger ',
			   		elementName:'DhrCurrentDwellingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingKind,
					type:'selectWidget',
					condition:'isCurrentDwellingPlaceOfResidence-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrDwellingKindType']" />


<!--DhrCurrentDwellingArrivalDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingArrivalDate',
			   		help:null,
			   		validation:'null',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingArrivalDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingArrivalDate,
					type:'textWidget',
					condition:'isCurrentDwellingPlaceOfResidence-filled ']" />


<!--DhrCurrentDwellingStatus -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingStatus',
			   		help:null,
			   		validation:'null',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingStatus', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingStatus,
					type:'radioWidget',
					condition:'isCurrentDwellingPlaceOfResidence-filled ',
					namespace:'http://www.cg95.fr/cvq/schema/dhr',
 					elementTypeName:'DhrDwellingStatusType']" />


<!--DhrCurrentDwellingNumberOfRoom -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingNumberOfRoom',
			   		help:null,
			   		validation:'null',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingNumberOfRoom', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingNumberOfRoom,
					type:'textWidget',
					condition:'isCurrentDwellingPlaceOfResidence-filled ']" />


<!--DhrCurrentDwellingNetArea -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrCurrentDwellingNetArea',
			   		help:null,
			   		validation:'null',
			   		condition:'isCurrentDwellingPlaceOfResidence-filled ',
			   		elementName:'DhrCurrentDwellingNetArea', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrCurrentDwellingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrCurrentDwellingNetArea,
					type:'textWidget',
					condition:'isCurrentDwellingPlaceOfResidence-filled ']" />

</fieldset>
