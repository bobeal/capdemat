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
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'DhrIncomeTax', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrIncomeTax', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.dhrIncomeTax, 
			 		title:message(code:'dhr.property.dhrIncomeTax.validationError')]"/>



<!--LocalRate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'localRate',
			   		help:message(code:'dhr.property.localRate.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'LocalRate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'localRate', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.localRate, 
			 		title:message(code:'dhr.property.localRate.validationError')]"/>



<!--PropertyTaxes -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'propertyTaxes',
			   		help:message(code:'dhr.property.propertyTaxes.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'PropertyTaxes', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'propertyTaxes', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.propertyTaxes, 
			 		title:message(code:'dhr.property.propertyTaxes.validationError')]"/>



<!--ProfessionalTaxes -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'professionalTaxes',
			   		help:message(code:'dhr.property.professionalTaxes.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'',
			   		elementName:'ProfessionalTaxes', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrTaxesAmountType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'professionalTaxes', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'',
			 		value:dhr.professionalTaxes, 
			 		title:message(code:'dhr.property.professionalTaxes.validationError')]"/>


</fieldset>
