<fieldset class="">

<!--DhrTaxesAmount --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrTaxesAmount',
			   		condition:'',
			   		requestType: dhr]"/>



<!--DhrIncomeTax -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrIncomeTax',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrIncomeTax', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrIncomeTax,
					type:'textWidget',
					condition:'']" />


<!--LocalRate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'localRate',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'LocalRate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.localRate,
					type:'textWidget',
					condition:'']" />


<!--PropertyTaxes -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'propertyTaxes',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'PropertyTaxes', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.propertyTaxes,
					type:'textWidget',
					condition:'']" />


<!--ProfessionalTaxes -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'professionalTaxes',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'ProfessionalTaxes', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.professionalTaxes,
					type:'textWidget',
					condition:'']" />

</fieldset>
