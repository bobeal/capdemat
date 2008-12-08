<fieldset class="">

<!--HarProjectRequest --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarProjectRequest',
			   		condition:'',
			   		requestType: har]"/>



<!--HarDisabilityRecognitionRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityRecognitionRequest',
			   		help:message(code:'har.property.harDisabilityRecognitionRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabilityRecognitionRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabilityRecognitionRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabilityRecognitionRequest.validationError'),
			   		checked:har.harDisabilityRecognitionRequest]" />


<!--HarDisabilityCardRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityCardRequest',
			   		help:message(code:'har.property.harDisabilityCardRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabilityCardRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabilityCardRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabilityCardRequest.validationError'),
			   		checked:har.harDisabilityCardRequest]" />


<!--HarDisabledPriorityCardRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabledPriorityCardRequest',
			   		help:message(code:'har.property.harDisabledPriorityCardRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabledPriorityCardRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabledPriorityCardRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabledPriorityCardRequest.validationError'),
			   		checked:har.harDisabledPriorityCardRequest]" />


<!--HarEuropeanParkingCardRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harEuropeanParkingCardRequest',
			   		help:message(code:'har.property.harEuropeanParkingCardRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarEuropeanParkingCardRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harEuropeanParkingCardRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harEuropeanParkingCardRequest.validationError'),
			   		checked:har.harEuropeanParkingCardRequest]" />


<!--HarDisabledAdultAllowanceRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabledAdultAllowanceRequest',
			   		help:message(code:'har.property.harDisabledAdultAllowanceRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabledAdultAllowanceRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabledAdultAllowanceRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabledAdultAllowanceRequest.validationError'),
			   		checked:har.harDisabledAdultAllowanceRequest]" />


<!--HarIncreaseForIndependentLivingRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIncreaseForIndependentLivingRequest',
			   		help:message(code:'har.property.harIncreaseForIndependentLivingRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarIncreaseForIndependentLivingRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harIncreaseForIndependentLivingRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harIncreaseForIndependentLivingRequest.validationError'),
			   		checked:har.harIncreaseForIndependentLivingRequest]" />


<!--HarEducationAllocationOfDisabledChildrenRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harEducationAllocationOfDisabledChildrenRequest',
			   		help:message(code:'har.property.harEducationAllocationOfDisabledChildrenRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarEducationAllocationOfDisabledChildrenRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harEducationAllocationOfDisabledChildrenRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harEducationAllocationOfDisabledChildrenRequest.validationError'),
			   		checked:har.harEducationAllocationOfDisabledChildrenRequest]" />


<!--HarPTCARenewalRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPTCARenewalRequest',
			   		help:message(code:'har.property.harPTCARenewalRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarPTCARenewalRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harPTCARenewalRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harPTCARenewalRequest.validationError'),
			   		checked:har.harPTCARenewalRequest]" />


<!--HarThirdPartyHelpRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harThirdPartyHelpRequest',
			   		help:message(code:'har.property.harThirdPartyHelpRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarThirdPartyHelpRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harThirdPartyHelpRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harThirdPartyHelpRequest.validationError'),
			   		checked:har.harThirdPartyHelpRequest]" />


<!--HarFreePensionMembershipRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFreePensionMembershipRequest',
			   		help:message(code:'har.property.harFreePensionMembershipRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarFreePensionMembershipRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harFreePensionMembershipRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harFreePensionMembershipRequest.validationError'),
			   		checked:har.harFreePensionMembershipRequest]" />


<!--HarTechnicalHelpRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harTechnicalHelpRequest',
			   		help:message(code:'har.property.harTechnicalHelpRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarTechnicalHelpRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harTechnicalHelpRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harTechnicalHelpRequest.validationError'),
			   		checked:har.harTechnicalHelpRequest]" />


<!--HarHousingFacilitiesRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHousingFacilitiesRequest',
			   		help:message(code:'har.property.harHousingFacilitiesRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarHousingFacilitiesRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harHousingFacilitiesRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harHousingFacilitiesRequest.validationError'),
			   		checked:har.harHousingFacilitiesRequest]" />


<!--HarCustomCarRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCustomCarRequest',
			   		help:message(code:'har.property.harCustomCarRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarCustomCarRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harCustomCarRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harCustomCarRequest.validationError'),
			   		checked:har.harCustomCarRequest]" />


<!--HarAssistanceRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAssistanceRequest',
			   		help:message(code:'har.property.harAssistanceRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarAssistanceRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harAssistanceRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harAssistanceRequest.validationError'),
			   		checked:har.harAssistanceRequest]" />


<!--HarTransportCostAllocationRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harTransportCostAllocationRequest',
			   		help:message(code:'har.property.harTransportCostAllocationRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarTransportCostAllocationRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harTransportCostAllocationRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harTransportCostAllocationRequest.validationError'),
			   		checked:har.harTransportCostAllocationRequest]" />


<!--HarDisabilityCostAllocationRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityCostAllocationRequest',
			   		help:message(code:'har.property.harDisabilityCostAllocationRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabilityCostAllocationRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabilityCostAllocationRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabilityCostAllocationRequest.validationError'),
			   		checked:har.harDisabilityCostAllocationRequest]" />


<!--HarDisabledWorkerRecognitionRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabledWorkerRecognitionRequest',
			   		help:message(code:'har.property.harDisabledWorkerRecognitionRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabledWorkerRecognitionRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabledWorkerRecognitionRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabledWorkerRecognitionRequest.validationError'),
			   		checked:har.harDisabledWorkerRecognitionRequest]" />


<!--HarProfessionalOrientationRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalOrientationRequest',
			   		help:message(code:'har.property.harProfessionalOrientationRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'isProfessionalOrientationRequest-trigger ',
			   		elementName:'HarProfessionalOrientationRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harProfessionalOrientationRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'isProfessionalOrientationRequest-trigger ',
			   		title:message(code:'har.property.harProfessionalOrientationRequest.validationError'),
			   		checked:har.harProfessionalOrientationRequest]" />


<!--HarOrdinaryworkingRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harOrdinaryworkingRequest',
			   		help:message(code:'har.property.harOrdinaryworkingRequest.help'),
			   		validation:' validate-one-required',
			   		condition:'isProfessionalOrientationRequest-filled ',
			   		elementName:'HarOrdinaryworkingRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harOrdinaryworkingRequest', 
			   		validation:' validate-one-required', 
			   		condition:'isProfessionalOrientationRequest-filled ',
			   		title:message(code:'har.property.harOrdinaryworkingRequest.validationError'),
			   		checked:har.harOrdinaryworkingRequest]" />


<!--HarShelteredWorkRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harShelteredWorkRequest',
			   		help:message(code:'har.property.harShelteredWorkRequest.help'),
			   		validation:' validate-one-required',
			   		condition:'isProfessionalOrientationRequest-filled ',
			   		elementName:'HarShelteredWorkRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harShelteredWorkRequest', 
			   		validation:' validate-one-required', 
			   		condition:'isProfessionalOrientationRequest-filled ',
			   		title:message(code:'har.property.harShelteredWorkRequest.validationError'),
			   		checked:har.harShelteredWorkRequest]" />


<!--HarVocationalTrainingRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harVocationalTrainingRequest',
			   		help:message(code:'har.property.harVocationalTrainingRequest.help'),
			   		validation:' validate-one-required',
			   		condition:'isProfessionalOrientationRequest-filled ',
			   		elementName:'HarVocationalTrainingRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harVocationalTrainingRequest', 
			   		validation:' validate-one-required', 
			   		condition:'isProfessionalOrientationRequest-filled ',
			   		title:message(code:'har.property.harVocationalTrainingRequest.validationError'),
			   		checked:har.harVocationalTrainingRequest]" />


<!--HarInstitutionSupportRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harInstitutionSupportRequest',
			   		help:message(code:'har.property.harInstitutionSupportRequest.help'),
			   		validation:' validate-one-required',
			   		condition:'',
			   		elementName:'HarInstitutionSupportRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harInstitutionSupportRequest', 
			   		validation:' validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harInstitutionSupportRequest.validationError'),
			   		checked:har.harInstitutionSupportRequest]" />


<!--HarOtherRequest -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harOtherRequest',
			   		help:message(code:'har.property.harOtherRequest.help'),
			   		validation:'required validate-one-required',
			   		condition:'isOtherRequest-trigger ',
			   		elementName:'HarOtherRequest', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harOtherRequest', 
			   		validation:'required validate-one-required', 
			   		condition:'isOtherRequest-trigger ',
			   		title:message(code:'har.property.harOtherRequest.validationError'),
			   		checked:har.harOtherRequest]" />


<!--HarOtherRequestDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harOtherRequestDetails',
			   		help:message(code:'har.property.harOtherRequestDetails.help'),
			   		validation:'  validate-string',
			   		condition:'isOtherRequest-filled ',
			   		elementName:'HarOtherRequestDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProjectRequestType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harOtherRequestDetails', 
			 		validation:'  validate-string', 
			 		condition:'isOtherRequest-filled ',
			 		value:har.harOtherRequestDetails, 
			 		title:message(code:'har.property.harOtherRequestDetails.validationError')]"/>


</fieldset>

<!--HarProjectWish -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProjectWish',
			   		help:message(code:'har.property.harProjectWish.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'HarProjectWish',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProjectWish', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:har.harProjectWish, 
			 		title:message(code:'har.property.harProjectWish.validationError')]"/>



<!--HarProjectNeeds -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProjectNeeds',
			   		help:message(code:'har.property.harProjectNeeds.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'HarProjectNeeds',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProjectNeeds', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:har.harProjectNeeds, 
			 		title:message(code:'har.property.harProjectNeeds.validationError')]"/>



<!--HarProjectComments -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProjectComments',
			   		help:message(code:'har.property.harProjectComments.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'HarProjectComments',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProjectComments', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:har.harProjectComments, 
			 		title:message(code:'har.property.harProjectComments.validationError')]"/>


