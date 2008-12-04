<fieldset class="">

<!--DhrRequesterIncomes --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrRequesterIncomes',
			   		condition:'',
			   		requestType: dhr]"/>



<!--Pensions -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'pensions',
			   		help:message(code:'dhr.property.pensions.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'Pensions', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'pensions', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.pensions, 
			 		title:message(code:'dhr.property.pensions.validationError')]"/>



<!--DhrAllowances -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrAllowances',
			   		help:message(code:'dhr.property.dhrAllowances.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrAllowances', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrAllowances', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrAllowances, 
			 		title:message(code:'dhr.property.dhrAllowances.validationError')]"/>



<!--DhrFurnitureInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrFurnitureInvestmentIncome',
			   		help:message(code:'dhr.property.dhrFurnitureInvestmentIncome.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrFurnitureInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrFurnitureInvestmentIncome', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrFurnitureInvestmentIncome, 
			 		title:message(code:'dhr.property.dhrFurnitureInvestmentIncome.validationError')]"/>



<!--DhrRealEstateInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRealEstateInvestmentIncome',
			   		help:message(code:'dhr.property.dhrRealEstateInvestmentIncome.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrRealEstateInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRealEstateInvestmentIncome', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrRealEstateInvestmentIncome, 
			 		title:message(code:'dhr.property.dhrRealEstateInvestmentIncome.validationError')]"/>



<!--DhrNetIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrNetIncome',
			   		help:message(code:'dhr.property.dhrNetIncome.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrNetIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrNetIncome', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrNetIncome, 
			 		title:message(code:'dhr.property.dhrNetIncome.validationError')]"/>


</fieldset>
<fieldset class="">

<!--DhrSpouseIncomes --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrSpouseIncomes',
			   		condition:'',
			   		requestType: dhr]"/>



<!--Pensions -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'pensions',
			   		help:message(code:'dhr.property.pensions.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'Pensions', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'pensions', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.pensions, 
			 		title:message(code:'dhr.property.pensions.validationError')]"/>



<!--DhrAllowances -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrAllowances',
			   		help:message(code:'dhr.property.dhrAllowances.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrAllowances', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrAllowances', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrAllowances, 
			 		title:message(code:'dhr.property.dhrAllowances.validationError')]"/>



<!--DhrFurnitureInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrFurnitureInvestmentIncome',
			   		help:message(code:'dhr.property.dhrFurnitureInvestmentIncome.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrFurnitureInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrFurnitureInvestmentIncome', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrFurnitureInvestmentIncome, 
			 		title:message(code:'dhr.property.dhrFurnitureInvestmentIncome.validationError')]"/>



<!--DhrRealEstateInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRealEstateInvestmentIncome',
			   		help:message(code:'dhr.property.dhrRealEstateInvestmentIncome.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrRealEstateInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrRealEstateInvestmentIncome', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrRealEstateInvestmentIncome, 
			 		title:message(code:'dhr.property.dhrRealEstateInvestmentIncome.validationError')]"/>



<!--DhrNetIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrNetIncome',
			   		help:message(code:'dhr.property.dhrNetIncome.help'),
			   		validation:'',
			   		condition:'',
			   		elementName:'DhrNetIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'dhrNetIncome', 
			 		validation:'', 
			 		condition:'',
			 		value:dhr.dhrNetIncome, 
			 		title:message(code:'dhr.property.dhrNetIncome.validationError')]"/>


</fieldset>
