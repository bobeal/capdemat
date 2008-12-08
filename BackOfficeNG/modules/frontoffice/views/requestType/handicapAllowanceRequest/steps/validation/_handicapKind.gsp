<fieldset class="">

<!--HarMDPHFiles --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarMDPHFiles',
			   		condition:'',
			   		requestType: har]"/>



<!--HarMDPHFile -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harMDPHFile',
			   		help:null,
			   		validation:'null',
			   		condition:'isMDPH-trigger ',
			   		elementName:'HarMDPHFile', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarMDPHFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harMDPHFile,
					type:'yesnoWidget',
					condition:'isMDPH-trigger ']" />


<!--HarMDPHNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harMDPHNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'isMDPH-filled ',
			   		elementName:'HarMDPHNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarMDPHFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harMDPHNumber,
					type:'textWidget',
					condition:'isMDPH-filled ']" />


<!--HarMDPHDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harMDPHDepartment',
			   		help:null,
			   		validation:'null',
			   		condition:'isMDPH-filled ',
			   		elementName:'HarMDPHDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarMDPHFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harMDPHDepartment,
					type:'textWidget',
					condition:'isMDPH-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isCOTOREP-trigger ',
			   		elementName:'HarCOTOREPFile', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCOTOREPFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCOTOREPFile,
					type:'yesnoWidget',
					condition:'isCOTOREP-trigger ']" />


<!--HarCOTOREPNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCOTOREPNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'isCOTOREP-filled ',
			   		elementName:'HarCOTOREPNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCOTOREPFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCOTOREPNumber,
					type:'textWidget',
					condition:'isCOTOREP-filled ']" />


<!--HarCOTOREPDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCOTOREPDepartment',
			   		help:null,
			   		validation:'null',
			   		condition:'isCOTOREP-filled ',
			   		elementName:'HarCOTOREPDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCOTOREPFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCOTOREPDepartment,
					type:'textWidget',
					condition:'isCOTOREP-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isCDES-trigger ',
			   		elementName:'HarCDESFile', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCDESFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCDESFile,
					type:'yesnoWidget',
					condition:'isCDES-trigger ']" />


<!--HarCDESNumber -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCDESNumber',
			   		help:null,
			   		validation:'null',
			   		condition:'isCDES-filled ',
			   		elementName:'HarCDESNumber', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCDESFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCDESNumber,
					type:'textWidget',
					condition:'isCDES-filled ']" />


<!--HarCDESDepartment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCDESDepartment',
			   		help:null,
			   		validation:'null',
			   		condition:'isCDES-filled ',
			   		elementName:'HarCDESDepartment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarCDESFilesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCDESDepartment,
					type:'textWidget',
					condition:'isCDES-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isDisabilityRecognition-trigger ',
			   		elementName:'HarDisabilityRecognition', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabilityRecognition,
					type:'yesnoWidget',
					condition:'isDisabilityRecognition-trigger ']" />


<!--HarDisabilityRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityRatio',
			   		help:null,
			   		validation:'null',
			   		condition:'isDisabilityRecognition-filled ',
			   		elementName:'HarDisabilityRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabilityRatio,
					type:'textWidget',
					condition:'isDisabilityRecognition-filled ']" />


<!--HarDisabilityCard -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityCard',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarDisabilityCard', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabilityCard,
					type:'yesnoWidget',
					condition:'']" />


<!--HarPainfulStandingCard -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPainfulStandingCard',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarPainfulStandingCard', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPainfulStandingCard,
					type:'yesnoWidget',
					condition:'']" />


<!--HarParkingCard -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harParkingCard',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarParkingCard', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harParkingCard,
					type:'yesnoWidget',
					condition:'']" />


<!--HarDisabledWorkerRecognition -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabledWorkerRecognition',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarDisabledWorkerRecognition', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabledWorkerRecognition,
					type:'yesnoWidget',
					condition:'']" />


<!--HarProfessionalOrientation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalOrientation',
			   		help:null,
			   		validation:'null',
			   		condition:'isProfessionalOrientation-trigger ',
			   		elementName:'HarProfessionalOrientation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalOrientation,
					type:'yesnoWidget',
					condition:'isProfessionalOrientation-trigger ']" />


<!--HarProfessionalOrientationDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalOrientationDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isProfessionalOrientation-filled ',
			   		elementName:'HarProfessionalOrientationDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalOrientationDetails,
					type:'textWidget',
					condition:'isProfessionalOrientation-filled ']" />


<!--HarDisabledAdultAllocation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabledAdultAllocation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarDisabledAdultAllocation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabledAdultAllocation,
					type:'yesnoWidget',
					condition:'']" />


<!--HarIncreaseForIndependentLiving -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIncreaseForIndependentLiving',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarIncreaseForIndependentLiving', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harIncreaseForIndependentLiving,
					type:'yesnoWidget',
					condition:'']" />


<!--HarEducationAllocationOfDisabledChildren -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harEducationAllocationOfDisabledChildren',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarEducationAllocationOfDisabledChildren', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harEducationAllocationOfDisabledChildren,
					type:'yesnoWidget',
					condition:'']" />


<!--HarAdditionalAllocationForEducationOfDisabledChildren -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAdditionalAllocationForEducationOfDisabledChildren',
			   		help:null,
			   		validation:'null',
			   		condition:'isAdditionalAllocationForEducationOfDisabledChildren-trigger ',
			   		elementName:'HarAdditionalAllocationForEducationOfDisabledChildren', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harAdditionalAllocationForEducationOfDisabledChildren,
					type:'yesnoWidget',
					condition:'isAdditionalAllocationForEducationOfDisabledChildren-trigger ']" />


<!--HarAdditionalAllocationForEducationOfDisabledChildrenDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAdditionalAllocationForEducationOfDisabledChildrenDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isAdditionalAllocationForEducationOfDisabledChildren-filled ',
			   		elementName:'HarAdditionalAllocationForEducationOfDisabledChildrenDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harAdditionalAllocationForEducationOfDisabledChildrenDetails,
					type:'textWidget',
					condition:'isAdditionalAllocationForEducationOfDisabledChildren-filled ']" />


<!--HarSupplementForSingleParents -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSupplementForSingleParents',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSupplementForSingleParents', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSupplementForSingleParents,
					type:'yesnoWidget',
					condition:'']" />


<!--HarThridPersonCompensatoryAllowance -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harThridPersonCompensatoryAllowance',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarThridPersonCompensatoryAllowance', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harThridPersonCompensatoryAllowance,
					type:'yesnoWidget',
					condition:'']" />


<!--HarThridPartyCompensatoryAllowance -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harThridPartyCompensatoryAllowance',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarThridPartyCompensatoryAllowance', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harThridPartyCompensatoryAllowance,
					type:'yesnoWidget',
					condition:'']" />


<!--HarCompensatoryAllowanceForExpenses -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCompensatoryAllowanceForExpenses',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarCompensatoryAllowanceForExpenses', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCompensatoryAllowanceForExpenses,
					type:'yesnoWidget',
					condition:'']" />


<!--HarDisabilityCompensation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityCompensation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarDisabilityCompensation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabilityCompensation,
					type:'yesnoWidget',
					condition:'']" />


<!--HarDisabilityPension -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityPension',
			   		help:null,
			   		validation:'null',
			   		condition:'isDisabilityPension-trigger ',
			   		elementName:'HarDisabilityPension', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabilityPension,
					type:'yesnoWidget',
					condition:'isDisabilityPension-trigger ']" />


<!--HarDisabilityPensionCategory -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDisabilityPensionCategory',
			   		help:null,
			   		validation:'null',
			   		condition:'isDisabilityPension-filled ',
			   		elementName:'HarDisabilityPensionCategory', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDisabilityPensionCategory,
					type:'textWidget',
					condition:'isDisabilityPension-filled ']" />


<!--HarWorkAccidentAnnuity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harWorkAccidentAnnuity',
			   		help:null,
			   		validation:'null',
			   		condition:'isWorkAccidentAnnuity-trigger ',
			   		elementName:'HarWorkAccidentAnnuity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harWorkAccidentAnnuity,
					type:'yesnoWidget',
					condition:'isWorkAccidentAnnuity-trigger ']" />


<!--HarWorkAccidentAnnuityRatio -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harWorkAccidentAnnuityRatio',
			   		help:null,
			   		validation:'null',
			   		condition:'isWorkAccidentAnnuity-filled ',
			   		elementName:'HarWorkAccidentAnnuityRatio', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harWorkAccidentAnnuityRatio,
					type:'textWidget',
					condition:'isWorkAccidentAnnuity-filled ']" />


<!--HarSocialWelfare -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialWelfare',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSocialWelfare', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialWelfare,
					type:'yesnoWidget',
					condition:'']" />


<!--HarUnemploymentBenefits -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harUnemploymentBenefits',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarUnemploymentBenefits', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harUnemploymentBenefits,
					type:'yesnoWidget',
					condition:'']" />


<!--HarDailyAllowances -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDailyAllowances',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarDailyAllowances', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDailyAllowances,
					type:'yesnoWidget',
					condition:'']" />


<!--HarThridPartySupplement -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harThridPartySupplement',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarThridPartySupplement', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harThridPartySupplement,
					type:'yesnoWidget',
					condition:'']" />


<!--HarSupportedByAnInstitution -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSupportedByAnInstitution',
			   		help:null,
			   		validation:'null',
			   		condition:'isSupportedByAnInstitution-trigger ',
			   		elementName:'HarSupportedByAnInstitution', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSupportedByAnInstitution,
					type:'yesnoWidget',
					condition:'isSupportedByAnInstitution-trigger ']" />


<!--HarSupportedByAnInstitutionDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSupportedByAnInstitutionDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isSupportedByAnInstitution-filled ',
			   		elementName:'HarSupportedByAnInstitutionDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarBenefitsType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSupportedByAnInstitutionDetails,
					type:'textWidget',
					condition:'isSupportedByAnInstitution-filled ']" />

</fieldset>

<!--HarIsFamilyCarer -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIsFamilyCarer',
			   		help:null,
			   		validation:'null',
			   		condition:'isFamilyCarer-trigger ',
			   		elementName:'HarIsFamilyCarer',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harIsFamilyCarer,
					type:'yesnoWidget',
					condition:'isFamilyCarer-trigger ']" />


<!--HarIsCarer -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIsCarer',
			   		help:null,
			   		validation:'null',
			   		condition:'isCarer-trigger ',
			   		elementName:'HarIsCarer',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harIsCarer,
					type:'yesnoWidget',
					condition:'isCarer-trigger ']" />


<!--HarIsCareAssistant -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIsCareAssistant',
			   		help:null,
			   		validation:'null',
			   		condition:'isCareAssistant-trigger ',
			   		elementName:'HarIsCareAssistant',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harIsCareAssistant,
					type:'yesnoWidget',
					condition:'isCareAssistant-trigger ']" />

<fieldset class="">

<!--HarFacilities --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarFacilities',
			   		condition:'',
			   		requestType: har]"/>



<!--HarHousingFacilities -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHousingFacilities',
			   		help:null,
			   		validation:'null',
			   		condition:'isHousingFacilities-trigger ',
			   		elementName:'HarHousingFacilities', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHousingFacilities,
					type:'yesnoWidget',
					condition:'isHousingFacilities-trigger ']" />


<!--HarHousingFacilitiesDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHousingFacilitiesDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isHousingFacilities-filled ',
			   		elementName:'HarHousingFacilitiesDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHousingFacilitiesDetails,
					type:'textWidget',
					condition:'isHousingFacilities-filled ']" />


<!--HarTechnicalAssistance -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harTechnicalAssistance',
			   		help:null,
			   		validation:'null',
			   		condition:'isTechnicalAssistance-trigger ',
			   		elementName:'HarTechnicalAssistance', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harTechnicalAssistance,
					type:'yesnoWidget',
					condition:'isTechnicalAssistance-trigger ']" />


<!--HarTechnicalAssistanceDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harTechnicalAssistanceDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isTechnicalAssistance-filled ',
			   		elementName:'HarTechnicalAssistanceDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harTechnicalAssistanceDetails,
					type:'textWidget',
					condition:'isTechnicalAssistance-filled ']" />


<!--HarCustomCar -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCustomCar',
			   		help:null,
			   		validation:'null',
			   		condition:'isCustomCar-trigger ',
			   		elementName:'HarCustomCar', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCustomCar,
					type:'yesnoWidget',
					condition:'isCustomCar-trigger ']" />


<!--HarCustomCarDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCustomCarDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isCustomCar-filled ',
			   		elementName:'HarCustomCarDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCustomCarDetails,
					type:'textWidget',
					condition:'isCustomCar-filled ']" />


<!--HarAnimalAid -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAnimalAid',
			   		help:null,
			   		validation:'null',
			   		condition:'isAnimalAid-trigger ',
			   		elementName:'HarAnimalAid', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harAnimalAid,
					type:'yesnoWidget',
					condition:'isAnimalAid-trigger ']" />


<!--HarAnimalAidDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAnimalAidDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isAnimalAid-filled ',
			   		elementName:'HarAnimalAidDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harAnimalAidDetails,
					type:'textWidget',
					condition:'isAnimalAid-filled ']" />


<!--HarSpecializedTransport -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedTransport',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpecializedTransport-trigger ',
			   		elementName:'HarSpecializedTransport', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSpecializedTransport,
					type:'yesnoWidget',
					condition:'isSpecializedTransport-trigger ']" />


<!--HarSpecializedTransportDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedTransportDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpecializedTransport-filled ',
			   		elementName:'HarSpecializedTransportDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFacilitiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSpecializedTransportDetails,
					type:'textWidget',
					condition:'isSpecializedTransport-filled ']" />

</fieldset>

<!--HarProfessionalEvaluation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalEvaluation',
			   		help:null,
			   		validation:'null',
			   		condition:'isProfessionalEvaluation-trigger ',
			   		elementName:'HarProfessionalEvaluation',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalEvaluation,
					type:'yesnoWidget',
					condition:'isProfessionalEvaluation-trigger ']" />


<!--HarRequestDealWithSameProfessional -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRequestDealWithSameProfessional',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarRequestDealWithSameProfessional',
			   		requestType: har]"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRequestDealWithSameProfessional,
					type:'yesnoWidget',
					condition:'']" />

<fieldset class="">

<!--HarFollowUp --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarFollowUp',
			   		condition:'',
			   		requestType: har]"/>



<!--HarFollowUp -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harFollowUp',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowUp-trigger ',
			   		elementName:'HarFollowUp', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harFollowUp,
					type:'yesnoWidget',
					condition:'isFollowUp-trigger ']" />


<!--HarSocialProfessionalLastName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalLastName',
			   		help:null,
			   		validation:'null',
			   		condition:'isFollowUp-filled ',
			   		elementName:'HarSocialProfessionalLastName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialProfessionalLastName,
					type:'textWidget',
					condition:'isFollowUp-filled ']" />


<!--HarSocialProfessionalAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSocialProfessionalAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialProfessionalAddress,
					type:'textWidget',
					condition:'']" />


<!--HarSocialProfessionalPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSocialProfessionalPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialProfessionalPostalCode,
					type:'textWidget',
					condition:'']" />


<!--HarSocialProfessionalCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSocialProfessionalCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarSocialProfessionalCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarDisabilityFollowUpType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSocialProfessionalCity,
					type:'textWidget',
					condition:'']" />

</fieldset>
