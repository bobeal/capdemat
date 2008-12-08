<fieldset class="">

<!--HarCareFollowUp --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarCareFollowUp',
			   		condition:'',
			   		requestType: har]"/>



<!--HarFollowedByPhysician -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByPhysician',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowedByPhysician-trigger ',
			   		elementName:'HarFollowedByPhysician', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harFollowedByPhysician,
					type:'yesnoWidget',
					condition:'isFollowedByPhysician-trigger ']" />


<!--HarFollowedByPhysicianDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByPhysicianDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowedByPhysician-filled ',
			   		elementName:'HarFollowedByPhysicianDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harFollowedByPhysicianDetails,
					type:'textWidget',
					condition:'isFollowedByPhysician-filled ']" />


<!--HarFollowedByProfessional -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByProfessional',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowedByProfessional-trigger ',
			   		elementName:'HarFollowedByProfessional', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harFollowedByProfessional,
					type:'yesnoWidget',
					condition:'isFollowedByProfessional-trigger ']" />


<!--HarFollowedByProfessionalDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByProfessionalDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowedByProfessional-filled ',
			   		elementName:'HarFollowedByProfessionalDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harFollowedByProfessionalDetails,
					type:'textWidget',
					condition:'isFollowedByProfessional-filled ']" />


<!--HarFollowedByHospital -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByHospital',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowedByHospital-trigger ',
			   		elementName:'HarFollowedByHospital', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harFollowedByHospital,
					type:'yesnoWidget',
					condition:'isFollowedByHospital-trigger ']" />


<!--HarFollowedByHospitalDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByHospitalDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowedByHospital-filled ',
			   		elementName:'HarFollowedByHospitalDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harFollowedByHospitalDetails,
					type:'textWidget',
					condition:'isFollowedByHospital-filled ']" />

</fieldset>
