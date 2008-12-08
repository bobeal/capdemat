<fieldset class="">

<!--HarCareFollowUp --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarCareFollowUp',
			   		condition:'',
			   		requestType: har]"/>



<!--HarFollowedByPhysician -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByPhysician',
			   		help:message(code:'har.property.harFollowedByPhysician.help'),
			   		validation:'required validate-one-required',
			   		condition:'isFollowedByPhysician-trigger ',
			   		elementName:'HarFollowedByPhysician', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harFollowedByPhysician', 
			   		validation:'required validate-one-required', 
			   		condition:'isFollowedByPhysician-trigger ',
			   		title:message(code:'har.property.harFollowedByPhysician.validationError'),
			   		checked:har.harFollowedByPhysician]" />


<!--HarFollowedByPhysicianDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByPhysicianDetails',
			   		help:message(code:'har.property.harFollowedByPhysicianDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isFollowedByPhysician-filled ',
			   		elementName:'HarFollowedByPhysicianDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harFollowedByPhysicianDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isFollowedByPhysician-filled ',
			 		value:har.harFollowedByPhysicianDetails, 
			 		title:message(code:'har.property.harFollowedByPhysicianDetails.validationError')]"/>



<!--HarFollowedByProfessional -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByProfessional',
			   		help:message(code:'har.property.harFollowedByProfessional.help'),
			   		validation:'required validate-one-required',
			   		condition:'isFollowedByProfessional-trigger ',
			   		elementName:'HarFollowedByProfessional', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harFollowedByProfessional', 
			   		validation:'required validate-one-required', 
			   		condition:'isFollowedByProfessional-trigger ',
			   		title:message(code:'har.property.harFollowedByProfessional.validationError'),
			   		checked:har.harFollowedByProfessional]" />


<!--HarFollowedByProfessionalDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByProfessionalDetails',
			   		help:message(code:'har.property.harFollowedByProfessionalDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isFollowedByProfessional-filled ',
			   		elementName:'HarFollowedByProfessionalDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harFollowedByProfessionalDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isFollowedByProfessional-filled ',
			 		value:har.harFollowedByProfessionalDetails, 
			 		title:message(code:'har.property.harFollowedByProfessionalDetails.validationError')]"/>



<!--HarFollowedByHospital -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByHospital',
			   		help:message(code:'har.property.harFollowedByHospital.help'),
			   		validation:'required validate-one-required',
			   		condition:'isFollowedByHospital-trigger ',
			   		elementName:'HarFollowedByHospital', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harFollowedByHospital', 
			   		validation:'required validate-one-required', 
			   		condition:'isFollowedByHospital-trigger ',
			   		title:message(code:'har.property.harFollowedByHospital.validationError'),
			   		checked:har.harFollowedByHospital]" />


<!--HarFollowedByHospitalDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowedByHospitalDetails',
			   		help:message(code:'har.property.harFollowedByHospitalDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isFollowedByHospital-filled ',
			   		elementName:'HarFollowedByHospitalDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCareFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harFollowedByHospitalDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isFollowedByHospital-filled ',
			 		value:har.harFollowedByHospitalDetails, 
			 		title:message(code:'har.property.harFollowedByHospitalDetails.validationError')]"/>


</fieldset>
