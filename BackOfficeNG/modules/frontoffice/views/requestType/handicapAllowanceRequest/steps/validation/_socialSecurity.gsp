<fieldset class="">

<!--HarSocialSecurity --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarSocialSecurity',
			   		condition:'',
			   		requestType: har]"/>



<!--HarSocialSecurityMemberShipKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityMemberShipKind',
			   		help:null,
			   		validation:'null',
			   		condition:'haveSocialSecurityMemberShip-trigger ',
			   		elementName:'HarSocialSecurityMemberShipKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialSecurityMemberShipKind,
					type:'selectWidget',
					condition:'haveSocialSecurityMemberShip-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarSocialSecurityMemberShipKindType']" />


<!--HarSocialSecurityNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'haveSocialSecurityMemberShip-filled ',
			   		elementName:'HarSocialSecurityNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialSecurityNumber,
					type:'textWidget',
					condition:'haveSocialSecurityMemberShip-filled ']" />


<!--HarSocialSecurityAgencyName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyName',
			   		help:null,
			   		validation:'null',
			   		condition:'haveSocialSecurityMemberShip-filled ',
			   		elementName:'HarSocialSecurityAgencyName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialSecurityAgencyName,
					type:'textWidget',
					condition:'haveSocialSecurityMemberShip-filled ']" />


<!--HarSocialSecurityAgencyAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSocialSecurityAgencyAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialSecurityAgencyAddress,
					type:'textWidget',
					condition:'']" />


<!--HarSocialSecurityAgencyPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSocialSecurityAgencyPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialSecurityAgencyPostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarSocialSecurityAgencyCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialSecurityAgencyCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSocialSecurityAgencyCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSocialSecurityType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialSecurityAgencyCity,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'havePaymentAgencyBeneficiary-trigger ',
			   		elementName:'HarPaymentAgencyBeneficiary', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPaymentAgencyBeneficiary,
					type:'selectWidget',
					condition:'havePaymentAgencyBeneficiary-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarPaymentAgencyBeneficiaryType']" />


<!--HarPaymentAgencyBeneficiaryNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyBeneficiaryNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyBeneficiaryNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPaymentAgencyBeneficiaryNumber,
					type:'textWidget',
					condition:'havePaymentAgencyBeneficiary-filled ']" />


<!--HarPaymentAgencyName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyName',
			   		help:null,
			   		validation:'null',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPaymentAgencyName,
					type:'textWidget',
					condition:'havePaymentAgencyBeneficiary-filled ']" />


<!--HarPaymentAgencyAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPaymentAgencyAddress,
					type:'textWidget',
					condition:'havePaymentAgencyBeneficiary-filled ']" />


<!--HarPaymentAgencyPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPaymentAgencyPostalCode,
					type:'textWidget',
					condition:'havePaymentAgencyBeneficiary-filled ']" />


<!--HarPaymentAgencyCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPaymentAgencyCity',
			   		help:null,
			   		validation:'null',
			   		condition:'havePaymentAgencyBeneficiary-filled ',
			   		elementName:'HarPaymentAgencyCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarPaymentAgencyType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPaymentAgencyCity,
					type:'textWidget',
					condition:'havePaymentAgencyBeneficiary-filled ']" />

</fieldset>
