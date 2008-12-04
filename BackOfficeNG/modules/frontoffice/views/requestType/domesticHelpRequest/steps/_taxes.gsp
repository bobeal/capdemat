<fieldset class="">

<!--DhrTaxesAmount --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrTaxesAmount',
			   		condition:'',
			   		requestType: dhr]"/>



<!--DhrIncomeTax -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrIncomeTax',
			   		help:message(code:'dhr.property.dhrIncomeTax.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrIncomeTax', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrIncomeTax', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrIncomeTax, 
			 		title:message(code:'dhr.property.dhrIncomeTax.validationError')]"/>



<!--LocalRate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'localRate',
			   		help:message(code:'dhr.property.localRate.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'LocalRate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'localRate', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.localRate, 
			 		title:message(code:'dhr.property.localRate.validationError')]"/>



<!--PropertyTaxes -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'propertyTaxes',
			   		help:message(code:'dhr.property.propertyTaxes.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'PropertyTaxes', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'propertyTaxes', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.propertyTaxes, 
			 		title:message(code:'dhr.property.propertyTaxes.validationError')]"/>



<!--ProfessionalTaxes -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'professionalTaxes',
			   		help:message(code:'dhr.property.professionalTaxes.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'ProfessionalTaxes', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'professionalTaxes', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.professionalTaxes, 
			 		title:message(code:'dhr.property.professionalTaxes.validationError')]"/>


</fieldset>
