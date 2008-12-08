<fieldset class="">

<!--HarMDPHFiles --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarMDPHFiles',
			   		condition:'',
			   		requestType: har]"/>



<!--HarMDPHFile -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harMDPHFile',
			   		help:message(code:'har.property.harMDPHFile.help'),
			   		validation:'required validate-one-required',
			   		condition:'isMDPH-trigger ',
			   		elementName:'HarMDPHFile', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarMDPHFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harMDPHFile', 
			   		validation:'required validate-one-required', 
			   		condition:'isMDPH-trigger ',
			   		title:message(code:'har.property.harMDPHFile.validationError'),
			   		checked:har.harMDPHFile]" />


<!--HarMDPHNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harMDPHNumber',
			   		help:message(code:'har.property.harMDPHNumber.help'),
			   		validation:'  validate-string',
			   		condition:'isMDPH-filled ',
			   		elementName:'HarMDPHNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarMDPHFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harMDPHNumber', 
			 		validation:'  validate-string', 
			 		condition:'isMDPH-filled ',
			 		value:har.harMDPHNumber, 
			 		title:message(code:'har.property.harMDPHNumber.validationError')]"/>



<!--HarMDPHDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harMDPHDepartment',
			   		help:message(code:'har.property.harMDPHDepartment.help'),
			   		validation:'  validate-string',
			   		condition:'isMDPH-filled ',
			   		elementName:'HarMDPHDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarMDPHFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harMDPHDepartment', 
			 		validation:'  validate-string', 
			 		condition:'isMDPH-filled ',
			 		value:har.harMDPHDepartment, 
			 		title:message(code:'har.property.harMDPHDepartment.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarCOTOREPFiles --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarCOTOREPFiles',
			   		condition:'',
			   		requestType: har]"/>



<!--HarCOTOREPFile -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCOTOREPFile',
			   		help:message(code:'har.property.harCOTOREPFile.help'),
			   		validation:'required validate-one-required',
			   		condition:'isCOTOREP-trigger ',
			   		elementName:'HarCOTOREPFile', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCOTOREPFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harCOTOREPFile', 
			   		validation:'required validate-one-required', 
			   		condition:'isCOTOREP-trigger ',
			   		title:message(code:'har.property.harCOTOREPFile.validationError'),
			   		checked:har.harCOTOREPFile]" />


<!--HarCOTOREPNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCOTOREPNumber',
			   		help:message(code:'har.property.harCOTOREPNumber.help'),
			   		validation:'  validate-string',
			   		condition:'isCOTOREP-filled ',
			   		elementName:'HarCOTOREPNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCOTOREPFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harCOTOREPNumber', 
			 		validation:'  validate-string', 
			 		condition:'isCOTOREP-filled ',
			 		value:har.harCOTOREPNumber, 
			 		title:message(code:'har.property.harCOTOREPNumber.validationError')]"/>



<!--HarCOTOREPDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCOTOREPDepartment',
			   		help:message(code:'har.property.harCOTOREPDepartment.help'),
			   		validation:'  validate-string',
			   		condition:'isCOTOREP-filled ',
			   		elementName:'HarCOTOREPDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCOTOREPFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harCOTOREPDepartment', 
			 		validation:'  validate-string', 
			 		condition:'isCOTOREP-filled ',
			 		value:har.harCOTOREPDepartment, 
			 		title:message(code:'har.property.harCOTOREPDepartment.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarCDESFiles --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarCDESFiles',
			   		condition:'',
			   		requestType: har]"/>



<!--HarCDESFile -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCDESFile',
			   		help:message(code:'har.property.harCDESFile.help'),
			   		validation:'required validate-one-required',
			   		condition:'isCDES-trigger ',
			   		elementName:'HarCDESFile', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCDESFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harCDESFile', 
			   		validation:'required validate-one-required', 
			   		condition:'isCDES-trigger ',
			   		title:message(code:'har.property.harCDESFile.validationError'),
			   		checked:har.harCDESFile]" />


<!--HarCDESNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCDESNumber',
			   		help:message(code:'har.property.harCDESNumber.help'),
			   		validation:'  validate-string',
			   		condition:'isCDES-filled ',
			   		elementName:'HarCDESNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCDESFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harCDESNumber', 
			 		validation:'  validate-string', 
			 		condition:'isCDES-filled ',
			 		value:har.harCDESNumber, 
			 		title:message(code:'har.property.harCDESNumber.validationError')]"/>



<!--HarCDESDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCDESDepartment',
			   		help:message(code:'har.property.harCDESDepartment.help'),
			   		validation:'  validate-string',
			   		condition:'isCDES-filled ',
			   		elementName:'HarCDESDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCDESFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harCDESDepartment', 
			 		validation:'  validate-string', 
			 		condition:'isCDES-filled ',
			 		value:har.harCDESDepartment, 
			 		title:message(code:'har.property.harCDESDepartment.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarBenefits --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarBenefits',
			   		condition:'',
			   		requestType: har]"/>



<!--HarDisabilityRecognition -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityRecognition',
			   		help:message(code:'har.property.harDisabilityRecognition.help'),
			   		validation:'required validate-one-required',
			   		condition:'isDisabilityRecognition-trigger ',
			   		elementName:'HarDisabilityRecognition', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabilityRecognition', 
			   		validation:'required validate-one-required', 
			   		condition:'isDisabilityRecognition-trigger ',
			   		title:message(code:'har.property.harDisabilityRecognition.validationError'),
			   		checked:har.harDisabilityRecognition]" />


<!--HarDisabilityRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityRatio',
			   		help:message(code:'har.property.harDisabilityRatio.help'),
			   		validation:'  ',
			   		condition:'isDisabilityRecognition-filled ',
			   		elementName:'HarDisabilityRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDisabilityRatio', 
			 		validation:'  ', 
			 		condition:'isDisabilityRecognition-filled ',
			 		value:har.harDisabilityRatio, 
			 		title:message(code:'har.property.harDisabilityRatio.validationError')]"/>



<!--HarDisabilityCard -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityCard',
			   		help:message(code:'har.property.harDisabilityCard.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabilityCard', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabilityCard', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabilityCard.validationError'),
			   		checked:har.harDisabilityCard]" />


<!--HarPainfulStandingCard -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPainfulStandingCard',
			   		help:message(code:'har.property.harPainfulStandingCard.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarPainfulStandingCard', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harPainfulStandingCard', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harPainfulStandingCard.validationError'),
			   		checked:har.harPainfulStandingCard]" />


<!--HarParkingCard -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harParkingCard',
			   		help:message(code:'har.property.harParkingCard.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarParkingCard', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harParkingCard', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harParkingCard.validationError'),
			   		checked:har.harParkingCard]" />


<!--HarDisabledWorkerRecognition -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabledWorkerRecognition',
			   		help:message(code:'har.property.harDisabledWorkerRecognition.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabledWorkerRecognition', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabledWorkerRecognition', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabledWorkerRecognition.validationError'),
			   		checked:har.harDisabledWorkerRecognition]" />


<!--HarProfessionalOrientation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalOrientation',
			   		help:message(code:'har.property.harProfessionalOrientation.help'),
			   		validation:'required validate-one-required',
			   		condition:'isProfessionalOrientation-trigger ',
			   		elementName:'HarProfessionalOrientation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harProfessionalOrientation', 
			   		validation:'required validate-one-required', 
			   		condition:'isProfessionalOrientation-trigger ',
			   		title:message(code:'har.property.harProfessionalOrientation.validationError'),
			   		checked:har.harProfessionalOrientation]" />


<!--HarProfessionalOrientationDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalOrientationDetails',
			   		help:message(code:'har.property.harProfessionalOrientationDetails.help'),
			   		validation:'  validate-string',
			   		condition:'isProfessionalOrientation-filled ',
			   		elementName:'HarProfessionalOrientationDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProfessionalOrientationDetails', 
			 		validation:'  validate-string', 
			 		condition:'isProfessionalOrientation-filled ',
			 		value:har.harProfessionalOrientationDetails, 
			 		title:message(code:'har.property.harProfessionalOrientationDetails.validationError')]"/>



<!--HarDisabledAdultAllocation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabledAdultAllocation',
			   		help:message(code:'har.property.harDisabledAdultAllocation.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabledAdultAllocation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabledAdultAllocation', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabledAdultAllocation.validationError'),
			   		checked:har.harDisabledAdultAllocation]" />


<!--HarIncreaseForIndependentLiving -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIncreaseForIndependentLiving',
			   		help:message(code:'har.property.harIncreaseForIndependentLiving.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarIncreaseForIndependentLiving', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harIncreaseForIndependentLiving', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harIncreaseForIndependentLiving.validationError'),
			   		checked:har.harIncreaseForIndependentLiving]" />


<!--HarEducationAllocationOfDisabledChildren -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harEducationAllocationOfDisabledChildren',
			   		help:message(code:'har.property.harEducationAllocationOfDisabledChildren.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarEducationAllocationOfDisabledChildren', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harEducationAllocationOfDisabledChildren', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harEducationAllocationOfDisabledChildren.validationError'),
			   		checked:har.harEducationAllocationOfDisabledChildren]" />


<!--HarAdditionalAllocationForEducationOfDisabledChildren -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAdditionalAllocationForEducationOfDisabledChildren',
			   		help:message(code:'har.property.harAdditionalAllocationForEducationOfDisabledChildren.help'),
			   		validation:'required validate-one-required',
			   		condition:'isAdditionalAllocationForEducationOfDisabledChildren-trigger ',
			   		elementName:'HarAdditionalAllocationForEducationOfDisabledChildren', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harAdditionalAllocationForEducationOfDisabledChildren', 
			   		validation:'required validate-one-required', 
			   		condition:'isAdditionalAllocationForEducationOfDisabledChildren-trigger ',
			   		title:message(code:'har.property.harAdditionalAllocationForEducationOfDisabledChildren.validationError'),
			   		checked:har.harAdditionalAllocationForEducationOfDisabledChildren]" />


<!--HarAdditionalAllocationForEducationOfDisabledChildrenDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAdditionalAllocationForEducationOfDisabledChildrenDetails',
			   		help:message(code:'har.property.harAdditionalAllocationForEducationOfDisabledChildrenDetails.help'),
			   		validation:'  validate-string',
			   		condition:'isAdditionalAllocationForEducationOfDisabledChildren-filled ',
			   		elementName:'HarAdditionalAllocationForEducationOfDisabledChildrenDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harAdditionalAllocationForEducationOfDisabledChildrenDetails', 
			 		validation:'  validate-string', 
			 		condition:'isAdditionalAllocationForEducationOfDisabledChildren-filled ',
			 		value:har.harAdditionalAllocationForEducationOfDisabledChildrenDetails, 
			 		title:message(code:'har.property.harAdditionalAllocationForEducationOfDisabledChildrenDetails.validationError')]"/>



<!--HarSupplementForSingleParents -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSupplementForSingleParents',
			   		help:message(code:'har.property.harSupplementForSingleParents.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarSupplementForSingleParents', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harSupplementForSingleParents', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harSupplementForSingleParents.validationError'),
			   		checked:har.harSupplementForSingleParents]" />


<!--HarThridPersonCompensatoryAllowance -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harThridPersonCompensatoryAllowance',
			   		help:message(code:'har.property.harThridPersonCompensatoryAllowance.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarThridPersonCompensatoryAllowance', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harThridPersonCompensatoryAllowance', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harThridPersonCompensatoryAllowance.validationError'),
			   		checked:har.harThridPersonCompensatoryAllowance]" />


<!--HarThridPartyCompensatoryAllowance -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harThridPartyCompensatoryAllowance',
			   		help:message(code:'har.property.harThridPartyCompensatoryAllowance.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarThridPartyCompensatoryAllowance', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harThridPartyCompensatoryAllowance', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harThridPartyCompensatoryAllowance.validationError'),
			   		checked:har.harThridPartyCompensatoryAllowance]" />


<!--HarCompensatoryAllowanceForExpenses -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCompensatoryAllowanceForExpenses',
			   		help:message(code:'har.property.harCompensatoryAllowanceForExpenses.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarCompensatoryAllowanceForExpenses', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harCompensatoryAllowanceForExpenses', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harCompensatoryAllowanceForExpenses.validationError'),
			   		checked:har.harCompensatoryAllowanceForExpenses]" />


<!--HarDisabilityCompensation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityCompensation',
			   		help:message(code:'har.property.harDisabilityCompensation.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDisabilityCompensation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabilityCompensation', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDisabilityCompensation.validationError'),
			   		checked:har.harDisabilityCompensation]" />


<!--HarDisabilityPension -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityPension',
			   		help:message(code:'har.property.harDisabilityPension.help'),
			   		validation:'required validate-one-required',
			   		condition:'isDisabilityPension-trigger ',
			   		elementName:'HarDisabilityPension', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDisabilityPension', 
			   		validation:'required validate-one-required', 
			   		condition:'isDisabilityPension-trigger ',
			   		title:message(code:'har.property.harDisabilityPension.validationError'),
			   		checked:har.harDisabilityPension]" />


<!--HarDisabilityPensionCategory -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityPensionCategory',
			   		help:message(code:'har.property.harDisabilityPensionCategory.help'),
			   		validation:'  validate-string',
			   		condition:'isDisabilityPension-filled ',
			   		elementName:'HarDisabilityPensionCategory', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDisabilityPensionCategory', 
			 		validation:'  validate-string', 
			 		condition:'isDisabilityPension-filled ',
			 		value:har.harDisabilityPensionCategory, 
			 		title:message(code:'har.property.harDisabilityPensionCategory.validationError')]"/>



<!--HarWorkAccidentAnnuity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harWorkAccidentAnnuity',
			   		help:message(code:'har.property.harWorkAccidentAnnuity.help'),
			   		validation:'required validate-one-required',
			   		condition:'isWorkAccidentAnnuity-trigger ',
			   		elementName:'HarWorkAccidentAnnuity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harWorkAccidentAnnuity', 
			   		validation:'required validate-one-required', 
			   		condition:'isWorkAccidentAnnuity-trigger ',
			   		title:message(code:'har.property.harWorkAccidentAnnuity.validationError'),
			   		checked:har.harWorkAccidentAnnuity]" />


<!--HarWorkAccidentAnnuityRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harWorkAccidentAnnuityRatio',
			   		help:message(code:'har.property.harWorkAccidentAnnuityRatio.help'),
			   		validation:'  ',
			   		condition:'isWorkAccidentAnnuity-filled ',
			   		elementName:'HarWorkAccidentAnnuityRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harWorkAccidentAnnuityRatio', 
			 		validation:'  ', 
			 		condition:'isWorkAccidentAnnuity-filled ',
			 		value:har.harWorkAccidentAnnuityRatio, 
			 		title:message(code:'har.property.harWorkAccidentAnnuityRatio.validationError')]"/>



<!--HarSocialWelfare -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialWelfare',
			   		help:message(code:'har.property.harSocialWelfare.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarSocialWelfare', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harSocialWelfare', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harSocialWelfare.validationError'),
			   		checked:har.harSocialWelfare]" />


<!--HarUnemploymentBenefits -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harUnemploymentBenefits',
			   		help:message(code:'har.property.harUnemploymentBenefits.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarUnemploymentBenefits', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harUnemploymentBenefits', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harUnemploymentBenefits.validationError'),
			   		checked:har.harUnemploymentBenefits]" />


<!--HarDailyAllowances -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDailyAllowances',
			   		help:message(code:'har.property.harDailyAllowances.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarDailyAllowances', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harDailyAllowances', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harDailyAllowances.validationError'),
			   		checked:har.harDailyAllowances]" />


<!--HarThridPartySupplement -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harThridPartySupplement',
			   		help:message(code:'har.property.harThridPartySupplement.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarThridPartySupplement', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harThridPartySupplement', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harThridPartySupplement.validationError'),
			   		checked:har.harThridPartySupplement]" />


<!--HarSupportedByAnInstitution -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSupportedByAnInstitution',
			   		help:message(code:'har.property.harSupportedByAnInstitution.help'),
			   		validation:'required validate-one-required',
			   		condition:'isSupportedByAnInstitution-trigger ',
			   		elementName:'HarSupportedByAnInstitution', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harSupportedByAnInstitution', 
			   		validation:'required validate-one-required', 
			   		condition:'isSupportedByAnInstitution-trigger ',
			   		title:message(code:'har.property.harSupportedByAnInstitution.validationError'),
			   		checked:har.harSupportedByAnInstitution]" />


<!--HarSupportedByAnInstitutionDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSupportedByAnInstitutionDetails',
			   		help:message(code:'har.property.harSupportedByAnInstitutionDetails.help'),
			   		validation:'  validate-string',
			   		condition:'isSupportedByAnInstitution-filled ',
			   		elementName:'HarSupportedByAnInstitutionDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSupportedByAnInstitutionDetails', 
			 		validation:'  validate-string', 
			 		condition:'isSupportedByAnInstitution-filled ',
			 		value:har.harSupportedByAnInstitutionDetails, 
			 		title:message(code:'har.property.harSupportedByAnInstitutionDetails.validationError')]"/>


</fieldset>

<!--HarIsFamilyCarer -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIsFamilyCarer',
			   		help:message(code:'har.property.harIsFamilyCarer.help'),
			   		validation:'required validate-one-required',
			   		condition:'isFamilyCarer-trigger ',
			   		elementName:'HarIsFamilyCarer',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harIsFamilyCarer', 
			   		validation:'required validate-one-required', 
			   		condition:'isFamilyCarer-trigger ',
			   		title:message(code:'har.property.harIsFamilyCarer.validationError'),
			   		checked:har.harIsFamilyCarer]" />


<!--HarIsCarer -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIsCarer',
			   		help:message(code:'har.property.harIsCarer.help'),
			   		validation:'required validate-one-required',
			   		condition:'isCarer-trigger ',
			   		elementName:'HarIsCarer',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harIsCarer', 
			   		validation:'required validate-one-required', 
			   		condition:'isCarer-trigger ',
			   		title:message(code:'har.property.harIsCarer.validationError'),
			   		checked:har.harIsCarer]" />


<!--HarIsCareAssistant -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIsCareAssistant',
			   		help:message(code:'har.property.harIsCareAssistant.help'),
			   		validation:'required validate-one-required',
			   		condition:'isCareAssistant-trigger ',
			   		elementName:'HarIsCareAssistant',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harIsCareAssistant', 
			   		validation:'required validate-one-required', 
			   		condition:'isCareAssistant-trigger ',
			   		title:message(code:'har.property.harIsCareAssistant.validationError'),
			   		checked:har.harIsCareAssistant]" />

<fieldset class="">

<!--HarFacilities --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarFacilities',
			   		condition:'',
			   		requestType: har]"/>



<!--HarHousingFacilities -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHousingFacilities',
			   		help:message(code:'har.property.harHousingFacilities.help'),
			   		validation:'required validate-one-required',
			   		condition:'isHousingFacilities-trigger ',
			   		elementName:'HarHousingFacilities', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harHousingFacilities', 
			   		validation:'required validate-one-required', 
			   		condition:'isHousingFacilities-trigger ',
			   		title:message(code:'har.property.harHousingFacilities.validationError'),
			   		checked:har.harHousingFacilities]" />


<!--HarHousingFacilitiesDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHousingFacilitiesDetails',
			   		help:message(code:'har.property.harHousingFacilitiesDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isHousingFacilities-filled ',
			   		elementName:'HarHousingFacilitiesDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHousingFacilitiesDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isHousingFacilities-filled ',
			 		value:har.harHousingFacilitiesDetails, 
			 		title:message(code:'har.property.harHousingFacilitiesDetails.validationError')]"/>



<!--HarTechnicalAssistance -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harTechnicalAssistance',
			   		help:message(code:'har.property.harTechnicalAssistance.help'),
			   		validation:'required validate-one-required',
			   		condition:'isTechnicalAssistance-trigger ',
			   		elementName:'HarTechnicalAssistance', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harTechnicalAssistance', 
			   		validation:'required validate-one-required', 
			   		condition:'isTechnicalAssistance-trigger ',
			   		title:message(code:'har.property.harTechnicalAssistance.validationError'),
			   		checked:har.harTechnicalAssistance]" />


<!--HarTechnicalAssistanceDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harTechnicalAssistanceDetails',
			   		help:message(code:'har.property.harTechnicalAssistanceDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isTechnicalAssistance-filled ',
			   		elementName:'HarTechnicalAssistanceDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harTechnicalAssistanceDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isTechnicalAssistance-filled ',
			 		value:har.harTechnicalAssistanceDetails, 
			 		title:message(code:'har.property.harTechnicalAssistanceDetails.validationError')]"/>



<!--HarCustomCar -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCustomCar',
			   		help:message(code:'har.property.harCustomCar.help'),
			   		validation:'required validate-one-required',
			   		condition:'isCustomCar-trigger ',
			   		elementName:'HarCustomCar', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harCustomCar', 
			   		validation:'required validate-one-required', 
			   		condition:'isCustomCar-trigger ',
			   		title:message(code:'har.property.harCustomCar.validationError'),
			   		checked:har.harCustomCar]" />


<!--HarCustomCarDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCustomCarDetails',
			   		help:message(code:'har.property.harCustomCarDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isCustomCar-filled ',
			   		elementName:'HarCustomCarDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harCustomCarDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isCustomCar-filled ',
			 		value:har.harCustomCarDetails, 
			 		title:message(code:'har.property.harCustomCarDetails.validationError')]"/>



<!--HarAnimalAid -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAnimalAid',
			   		help:message(code:'har.property.harAnimalAid.help'),
			   		validation:'required validate-one-required',
			   		condition:'isAnimalAid-trigger ',
			   		elementName:'HarAnimalAid', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harAnimalAid', 
			   		validation:'required validate-one-required', 
			   		condition:'isAnimalAid-trigger ',
			   		title:message(code:'har.property.harAnimalAid.validationError'),
			   		checked:har.harAnimalAid]" />


<!--HarAnimalAidDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAnimalAidDetails',
			   		help:message(code:'har.property.harAnimalAidDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isAnimalAid-filled ',
			   		elementName:'HarAnimalAidDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harAnimalAidDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isAnimalAid-filled ',
			 		value:har.harAnimalAidDetails, 
			 		title:message(code:'har.property.harAnimalAidDetails.validationError')]"/>



<!--HarSpecializedTransport -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedTransport',
			   		help:message(code:'har.property.harSpecializedTransport.help'),
			   		validation:'required validate-one-required',
			   		condition:'isSpecializedTransport-trigger ',
			   		elementName:'HarSpecializedTransport', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harSpecializedTransport', 
			   		validation:'required validate-one-required', 
			   		condition:'isSpecializedTransport-trigger ',
			   		title:message(code:'har.property.harSpecializedTransport.validationError'),
			   		checked:har.harSpecializedTransport]" />


<!--HarSpecializedTransportDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedTransportDetails',
			   		help:message(code:'har.property.harSpecializedTransportDetails.help'),
			   		validation:'required  validate-string',
			   		condition:'isSpecializedTransport-filled ',
			   		elementName:'HarSpecializedTransportDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSpecializedTransportDetails', 
			 		validation:'required  validate-string', 
			 		condition:'isSpecializedTransport-filled ',
			 		value:har.harSpecializedTransportDetails, 
			 		title:message(code:'har.property.harSpecializedTransportDetails.validationError')]"/>


</fieldset>

<!--HarProfessionalEvaluation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalEvaluation',
			   		help:message(code:'har.property.harProfessionalEvaluation.help'),
			   		validation:'required validate-one-required',
			   		condition:'isProfessionalEvaluation-trigger ',
			   		elementName:'HarProfessionalEvaluation',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harProfessionalEvaluation', 
			   		validation:'required validate-one-required', 
			   		condition:'isProfessionalEvaluation-trigger ',
			   		title:message(code:'har.property.harProfessionalEvaluation.validationError'),
			   		checked:har.harProfessionalEvaluation]" />


<!--HarRequestDealWithSameProfessional -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequestDealWithSameProfessional',
			   		help:message(code:'har.property.harRequestDealWithSameProfessional.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarRequestDealWithSameProfessional',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harRequestDealWithSameProfessional', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harRequestDealWithSameProfessional.validationError'),
			   		checked:har.harRequestDealWithSameProfessional]" />

<fieldset class="">

<!--HarFollowUp --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarFollowUp',
			   		condition:'',
			   		requestType: har]"/>



<!--HarFollowUp -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowUp',
			   		help:message(code:'har.property.harFollowUp.help'),
			   		validation:'required validate-one-required',
			   		condition:'isFollowUp-trigger ',
			   		elementName:'HarFollowUp', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harFollowUp', 
			   		validation:'required validate-one-required', 
			   		condition:'isFollowUp-trigger ',
			   		title:message(code:'har.property.harFollowUp.validationError'),
			   		checked:har.harFollowUp]" />


<!--HarSocialProfessionalLastName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalLastName',
			   		help:message(code:'har.property.harSocialProfessionalLastName.help'),
			   		validation:'  validate-string',
			   		condition:'isFollowUp-filled ',
			   		elementName:'HarSocialProfessionalLastName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialProfessionalLastName', 
			 		validation:'  validate-string', 
			 		condition:'isFollowUp-filled ',
			 		value:har.harSocialProfessionalLastName, 
			 		title:message(code:'har.property.harSocialProfessionalLastName.validationError')]"/>



<!--HarSocialProfessionalAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalAddress',
			   		help:message(code:'har.property.harSocialProfessionalAddress.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'HarSocialProfessionalAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialProfessionalAddress', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:har.harSocialProfessionalAddress, 
			 		title:message(code:'har.property.harSocialProfessionalAddress.validationError')]"/>



<!--HarSocialProfessionalPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalPostalCode',
			   		help:message(code:'har.property.harSocialProfessionalPostalCode.help'),
			   		validation:'required  validate-postalcode',
			   		condition:'',
			   		elementName:'HarSocialProfessionalPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialProfessionalPostalCode', 
			 		validation:'required  validate-postalcode', 
			 		condition:'',
			 		value:har.harSocialProfessionalPostalCode, 
			 		title:message(code:'har.property.harSocialProfessionalPostalCode.validationError')]"/>



<!--HarSocialProfessionalCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalCity',
			   		help:message(code:'har.property.harSocialProfessionalCity.help'),
			   		validation:'  validate-city',
			   		condition:'',
			   		elementName:'HarSocialProfessionalCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSocialProfessionalCity', 
			 		validation:'  validate-city', 
			 		condition:'',
			 		value:har.harSocialProfessionalCity, 
			 		title:message(code:'har.property.harSocialProfessionalCity.validationError')]"/>


</fieldset>
