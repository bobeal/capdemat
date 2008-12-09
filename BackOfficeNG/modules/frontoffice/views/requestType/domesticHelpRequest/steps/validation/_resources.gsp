<fieldset class="">

<!--DhrRequesterIncomes --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'DhrRequesterIncomes',
			   		condition:'',
			   		requestType: dhr]"/>



<!--Pensions -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'pensions',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'Pensions', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.pensions,
					type:'textWidget',
					condition:'']" />


<!--DhrAllowances -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrAllowances',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrAllowances', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrAllowances,
					type:'textWidget',
					condition:'']" />


<!--DhrFurnitureInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrFurnitureInvestmentIncome',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrFurnitureInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrFurnitureInvestmentIncome,
					type:'textWidget',
					condition:'']" />


<!--DhrRealEstateInvestmentIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrRealEstateInvestmentIncome',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrRealEstateInvestmentIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrRealEstateInvestmentIncome,
					type:'textWidget',
					condition:'']" />


<!--DhrNetIncome -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'dhrNetIncome',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'DhrNetIncome', 
			   		namespace:'http://www.cg95.fr/cvq/schema/dhr',
			   		elementTypeName : 'DhrIncomesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:dhr.dhrNetIncome,
					type:'textWidget',
					condition:'']" />

</fieldset>
