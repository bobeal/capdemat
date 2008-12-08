<fieldset class="">

<!--HarSchooling --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarSchooling',
			   		condition:'',
			   		requestType: har]"/>



<!--HarSchoolingEnrolment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolingEnrolment',
			   		help:message(code:'har.property.harSchoolingEnrolment.help'),
			   		validation:'required validate-one-required',
			   		condition:'isSchoolingEnrolment-trigger ',
			   		elementName:'HarSchoolingEnrolment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harSchoolingEnrolment', 
			   		validation:'required validate-one-required', 
			   		condition:'isSchoolingEnrolment-trigger ',
			   		title:message(code:'har.property.harSchoolingEnrolment.validationError'),
			   		checked:har.harSchoolingEnrolment]" />


<!--HarSchoolName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolName',
			   		help:message(code:'har.property.harSchoolName.help'),
			   		validation:'  validate-string',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSchoolName', 
			 		validation:'  validate-string', 
			 		condition:'isSchoolingEnrolment-filled ',
			 		value:har.harSchoolName, 
			 		title:message(code:'har.property.harSchoolName.validationError')]"/>



<!--HarSchoolAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolAddress',
			   		help:message(code:'har.property.harSchoolAddress.help'),
			   		validation:'  validate-string',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSchoolAddress', 
			 		validation:'  validate-string', 
			 		condition:'isSchoolingEnrolment-filled ',
			 		value:har.harSchoolAddress, 
			 		title:message(code:'har.property.harSchoolAddress.validationError')]"/>



<!--HarSchoolPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolPostalCode',
			   		help:message(code:'har.property.harSchoolPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSchoolPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'isSchoolingEnrolment-filled ',
			 		value:har.harSchoolPostalCode, 
			 		title:message(code:'har.property.harSchoolPostalCode.validationError')]"/>



<!--HarSchoolCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolCity',
			   		help:message(code:'har.property.harSchoolCity.help'),
			   		validation:'  validate-city',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSchoolCity', 
			 		validation:'  validate-city', 
			 		condition:'isSchoolingEnrolment-filled ',
			 		value:har.harSchoolCity, 
			 		title:message(code:'har.property.harSchoolCity.validationError')]"/>



<!--HarSendToSchool -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSendToSchool',
			   		help:message(code:'har.property.harSendToSchool.help'),
			   		validation:'required validate-one-required',
			   		condition:'isSentToSchool-trigger ',
			   		elementName:'HarSendToSchool', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harSendToSchool', 
			   		validation:'required validate-one-required', 
			   		condition:'isSentToSchool-trigger ',
			   		title:message(code:'har.property.harSendToSchool.validationError'),
			   		checked:har.harSendToSchool]" />


<!--HarAttendedGrade -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAttendedGrade',
			   		help:message(code:'har.property.harAttendedGrade.help'),
			   		validation:'  validate-string',
			   		condition:'isSentToSchool-filled ',
			   		elementName:'HarAttendedGrade', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harAttendedGrade', 
			 		validation:'  validate-string', 
			 		condition:'isSentToSchool-filled ',
			 		value:har.harAttendedGrade, 
			 		title:message(code:'har.property.harAttendedGrade.validationError')]"/>



<!--HarSpecializedGrade -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedGrade',
			   		help:message(code:'har.property.harSpecializedGrade.help'),
			   		validation:'required validate-one-required',
			   		condition:'isSpecializedGrade-trigger ',
			   		elementName:'HarSpecializedGrade', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harSpecializedGrade', 
			   		validation:'required validate-one-required', 
			   		condition:'isSpecializedGrade-trigger ',
			   		title:message(code:'har.property.harSpecializedGrade.validationError'),
			   		checked:har.harSpecializedGrade]" />


<!--HarSpecializedGradeDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedGradeDetails',
			   		help:message(code:'har.property.harSpecializedGradeDetails.help'),
			   		validation:'  validate-string',
			   		condition:'isSpecializedGrade-filled ',
			   		elementName:'HarSpecializedGradeDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSpecializedGradeDetails', 
			 		validation:'  validate-string', 
			 		condition:'isSpecializedGrade-filled ',
			 		value:har.harSpecializedGradeDetails, 
			 		title:message(code:'har.property.harSpecializedGradeDetails.validationError')]"/>



<!--HarSchoolingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolingKind',
			   		help:message(code:'har.property.harSchoolingKind.help'),
			   		validation:'required validate-not-first',
			   		condition:'isPartTimeSchooling-trigger ',
			   		elementName:'HarSchoolingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harSchoolingKind',
 					validation:'required validate-not-first', 
 					condition:'isPartTimeSchooling-trigger ', 
 					title:message(code:'har.property.harSchoolingKind.validationError'), 
 					defaultOption:message(code:'har.property.harSchoolingKind.defaultOption'),
 					selected:har.harSchoolingKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarSchoolingKindType']"/>


<!--HarSchoolingTime -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolingTime',
			   		help:message(code:'har.property.harSchoolingTime.help'),
			   		validation:'  validate-positiveinteger',
			   		condition:'isPartTimeSchooling-filled ',
			   		elementName:'HarSchoolingTime', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harSchoolingTime', 
			 		validation:'  validate-positiveinteger', 
			 		condition:'isPartTimeSchooling-filled ',
			 		value:har.harSchoolingTime, 
			 		title:message(code:'har.property.harSchoolingTime.validationError')]"/>



<!--HarHomeSchooling -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchooling',
			   		help:message(code:'har.property.harHomeSchooling.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarHomeSchooling', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harHomeSchooling', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harHomeSchooling.validationError'),
			   		checked:har.harHomeSchooling]" />


<!--HarPersonalizedSchoolingPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPersonalizedSchoolingPlan',
			   		help:message(code:'har.property.harPersonalizedSchoolingPlan.help'),
			   		validation:'required validate-one-required',
			   		condition:'',
			   		elementName:'HarPersonalizedSchoolingPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harPersonalizedSchoolingPlan', 
			   		validation:'required validate-one-required', 
			   		condition:'',
			   		title:message(code:'har.property.harPersonalizedSchoolingPlan.validationError'),
			   		checked:har.harPersonalizedSchoolingPlan]" />


<!--HarHomeSchoolingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingKind',
			   		help:message(code:'har.property.harHomeSchoolingKind.help'),
			   		validation:'required validate-not-first',
			   		condition:'isAccompaniedHomeSchooling-trigger ',
			   		elementName:'HarHomeSchoolingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harHomeSchoolingKind',
 					validation:'required validate-not-first', 
 					condition:'isAccompaniedHomeSchooling-trigger ', 
 					title:message(code:'har.property.harHomeSchoolingKind.validationError'), 
 					defaultOption:message(code:'har.property.harHomeSchoolingKind.defaultOption'),
 					selected:har.harHomeSchoolingKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarHomeSchoolingKindType']"/>


<!--HarHomeSchoolingAccompanistLastName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistLastName',
			   		help:message(code:'har.property.harHomeSchoolingAccompanistLastName.help'),
			   		validation:'  validate-lastname',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistLastName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHomeSchoolingAccompanistLastName', 
			 		validation:'  validate-lastname', 
			 		condition:'isAccompaniedHomeSchooling-filled ',
			 		value:har.harHomeSchoolingAccompanistLastName, 
			 		title:message(code:'har.property.harHomeSchoolingAccompanistLastName.validationError')]"/>



<!--HarHomeSchoolingAccompanistFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistFirstName',
			   		help:message(code:'har.property.harHomeSchoolingAccompanistFirstName.help'),
			   		validation:'  validate-firstname',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHomeSchoolingAccompanistFirstName', 
			 		validation:'  validate-firstname', 
			 		condition:'isAccompaniedHomeSchooling-filled ',
			 		value:har.harHomeSchoolingAccompanistFirstName, 
			 		title:message(code:'har.property.harHomeSchoolingAccompanistFirstName.validationError')]"/>



<!--HarHomeSchoolingAccompanistAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistAddress',
			   		help:message(code:'har.property.harHomeSchoolingAccompanistAddress.help'),
			   		validation:'  validate-string',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHomeSchoolingAccompanistAddress', 
			 		validation:'  validate-string', 
			 		condition:'isAccompaniedHomeSchooling-filled ',
			 		value:har.harHomeSchoolingAccompanistAddress, 
			 		title:message(code:'har.property.harHomeSchoolingAccompanistAddress.validationError')]"/>



<!--HarHomeSchoolingAccompanistPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistPostalCode',
			   		help:message(code:'har.property.harHomeSchoolingAccompanistPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHomeSchoolingAccompanistPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'isAccompaniedHomeSchooling-filled ',
			 		value:har.harHomeSchoolingAccompanistPostalCode, 
			 		title:message(code:'har.property.harHomeSchoolingAccompanistPostalCode.validationError')]"/>



<!--HarHomeSchoolingAccompanistCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistCity',
			   		help:message(code:'har.property.harHomeSchoolingAccompanistCity.help'),
			   		validation:'  validate-city',
			   		condition:'',
			   		elementName:'HarHomeSchoolingAccompanistCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHomeSchoolingAccompanistCity', 
			 		validation:'  validate-city', 
			 		condition:'',
			 		value:har.harHomeSchoolingAccompanistCity, 
			 		title:message(code:'har.property.harHomeSchoolingAccompanistCity.validationError')]"/>



<!--HarExtraCurricular -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harExtraCurricular',
			   		help:message(code:'har.property.harExtraCurricular.help'),
			   		validation:'required  validate-string',
			   		condition:'',
			   		elementName:'HarExtraCurricular', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harExtraCurricular', 
			 		validation:'required  validate-string', 
			 		condition:'',
			 		value:har.harExtraCurricular, 
			 		title:message(code:'har.property.harExtraCurricular.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarStudies --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarStudies',
			   		condition:'',
			   		requestType: har]"/>



<!--HarHighSchool -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchool',
			   		help:message(code:'har.property.harHighSchool.help'),
			   		validation:'required validate-one-required',
			   		condition:'isHighSchool-trigger ',
			   		elementName:'HarHighSchool', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harHighSchool', 
			   		validation:'required validate-one-required', 
			   		condition:'isHighSchool-trigger ',
			   		title:message(code:'har.property.harHighSchool.validationError'),
			   		checked:har.harHighSchool]" />


<!--HarHighSchoolGrade -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolGrade',
			   		help:message(code:'har.property.harHighSchoolGrade.help'),
			   		validation:'  validate-string',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolGrade', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHighSchoolGrade', 
			 		validation:'  validate-string', 
			 		condition:'isHighSchool-filled ',
			 		value:har.harHighSchoolGrade, 
			 		title:message(code:'har.property.harHighSchoolGrade.validationError')]"/>



<!--HarHighSchoolName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolName',
			   		help:message(code:'har.property.harHighSchoolName.help'),
			   		validation:'  validate-string',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHighSchoolName', 
			 		validation:'  validate-string', 
			 		condition:'isHighSchool-filled ',
			 		value:har.harHighSchoolName, 
			 		title:message(code:'har.property.harHighSchoolName.validationError')]"/>



<!--HarHighSchoolAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolAddress',
			   		help:message(code:'har.property.harHighSchoolAddress.help'),
			   		validation:'  validate-string',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHighSchoolAddress', 
			 		validation:'  validate-string', 
			 		condition:'isHighSchool-filled ',
			 		value:har.harHighSchoolAddress, 
			 		title:message(code:'har.property.harHighSchoolAddress.validationError')]"/>



<!--HarHighSchoolPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolPostalCode',
			   		help:message(code:'har.property.harHighSchoolPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHighSchoolPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'isHighSchool-filled ',
			 		value:har.harHighSchoolPostalCode, 
			 		title:message(code:'har.property.harHighSchoolPostalCode.validationError')]"/>



<!--HarHighSchoolCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolCity',
			   		help:message(code:'har.property.harHighSchoolCity.help'),
			   		validation:'  validate-city',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harHighSchoolCity', 
			 		validation:'  validate-city', 
			 		condition:'isHighSchool-filled ',
			 		value:har.harHighSchoolCity, 
			 		title:message(code:'har.property.harHighSchoolCity.validationError')]"/>



<!--HarAssistanceUnderDisability -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAssistanceUnderDisability',
			   		help:message(code:'har.property.harAssistanceUnderDisability.help'),
			   		validation:'required validate-one-required',
			   		condition:'isHighSchool-filled isAssistanceUnderDisability-trigger ',
			   		elementName:'HarAssistanceUnderDisability', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harAssistanceUnderDisability', 
			   		validation:'required validate-one-required', 
			   		condition:'isHighSchool-filled isAssistanceUnderDisability-trigger ',
			   		title:message(code:'har.property.harAssistanceUnderDisability.validationError'),
			   		checked:har.harAssistanceUnderDisability]" />


<!--HarAssistanceUnderDisabilityDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAssistanceUnderDisabilityDetails',
			   		help:message(code:'har.property.harAssistanceUnderDisabilityDetails.help'),
			   		validation:'  validate-string',
			   		condition:'isAssistanceUnderDisability-filled ',
			   		elementName:'HarAssistanceUnderDisabilityDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harAssistanceUnderDisabilityDetails', 
			 		validation:'  validate-string', 
			 		condition:'isAssistanceUnderDisability-filled ',
			 		value:har.harAssistanceUnderDisabilityDetails, 
			 		title:message(code:'har.property.harAssistanceUnderDisabilityDetails.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarFormation --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarFormation',
			   		condition:'',
			   		requestType: har]"/>



<!--HarStudiesLevel -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harStudiesLevel',
			   		help:message(code:'har.property.harStudiesLevel.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarStudiesLevel', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harStudiesLevel', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harStudiesLevel, 
			 		title:message(code:'har.property.harStudiesLevel.validationError')]"/>



<!--HarDiploma -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDiploma',
			   		help:message(code:'har.property.harDiploma.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarDiploma', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harDiploma', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harDiploma, 
			 		title:message(code:'har.property.harDiploma.validationError')]"/>



<!--HarPreviousFormation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPreviousFormation',
			   		help:message(code:'har.property.harPreviousFormation.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarPreviousFormation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harPreviousFormation', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harPreviousFormation, 
			 		title:message(code:'har.property.harPreviousFormation.validationError')]"/>



<!--HarCurrentFormation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCurrentFormation',
			   		help:message(code:'har.property.harCurrentFormation.help'),
			   		validation:'  validate-string',
			   		condition:'',
			   		elementName:'HarCurrentFormation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harCurrentFormation', 
			 		validation:'  validate-string', 
			 		condition:'',
			 		value:har.harCurrentFormation, 
			 		title:message(code:'har.property.harCurrentFormation.validationError')]"/>


</fieldset>
<fieldset class="">

<!--HarProfessionalStatus --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarProfessionalStatus',
			   		condition:'',
			   		requestType: har]"/>



<!--HarProfessionalStatusKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusKind',
			   		help:message(code:'har.property.harProfessionalStatusKind.help'),
			   		validation:'required validate-not-first',
			   		condition:'isEmployed-trigger isUnemployed-trigger ',
			   		elementName:'HarProfessionalStatusKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harProfessionalStatusKind',
 					validation:'required validate-not-first', 
 					condition:'isEmployed-trigger isUnemployed-trigger ', 
 					title:message(code:'har.property.harProfessionalStatusKind.validationError'), 
 					defaultOption:message(code:'har.property.harProfessionalStatusKind.defaultOption'),
 					selected:har.harProfessionalStatusKind, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarProfessionalStatusKindType']"/>


<!--HarProfessionalStatusDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusDate',
			   		help:message(code:'har.property.harProfessionalStatusDate.help'),
			   		validation:'required  validate-date-au',
			   		condition:'',
			   		elementName:'HarProfessionalStatusDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProfessionalStatusDate', 
			 		validation:'required  validate-date-au', 
			 		condition:'',
			 		value:har.harProfessionalStatusDate, 
			 		title:message(code:'har.property.harProfessionalStatusDate.validationError')]"/>



<!--HarProfessionalStatusEnvironment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusEnvironment',
			   		help:message(code:'har.property.harProfessionalStatusEnvironment.help'),
			   		validation:' validate-not-first',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusEnvironment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/select"
					model="[name:'harProfessionalStatusEnvironment',
 					validation:' validate-not-first', 
 					condition:'isEmployed-filled ', 
 					title:message(code:'har.property.harProfessionalStatusEnvironment.validationError'), 
 					defaultOption:message(code:'har.property.harProfessionalStatusEnvironment.defaultOption'),
 					selected:har.harProfessionalStatusEnvironment, 
 					namespace:'http://www.cg95.fr/cvq/schema/har', 
 					modelNamespace:'fr.cg95.cvq.business.request.social',
 					elementTypeName:'HarProfessionalStatusEnvironmentType']"/>


<!--HarProfessionalStatusProfession -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusProfession',
			   		help:message(code:'har.property.harProfessionalStatusProfession.help'),
			   		validation:'  validate-string',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusProfession', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProfessionalStatusProfession', 
			 		validation:'  validate-string', 
			 		condition:'isEmployed-filled ',
			 		value:har.harProfessionalStatusProfession, 
			 		title:message(code:'har.property.harProfessionalStatusProfession.validationError')]"/>



<!--HarProfessionalStatusAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusAddress',
			   		help:message(code:'har.property.harProfessionalStatusAddress.help'),
			   		validation:'  validate-string',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProfessionalStatusAddress', 
			 		validation:'  validate-string', 
			 		condition:'isEmployed-filled ',
			 		value:har.harProfessionalStatusAddress, 
			 		title:message(code:'har.property.harProfessionalStatusAddress.validationError')]"/>



<!--HarProfessionalStatusPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusPostalCode',
			   		help:message(code:'har.property.harProfessionalStatusPostalCode.help'),
			   		validation:'  validate-postalcode',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProfessionalStatusPostalCode', 
			 		validation:'  validate-postalcode', 
			 		condition:'isEmployed-filled ',
			 		value:har.harProfessionalStatusPostalCode, 
			 		title:message(code:'har.property.harProfessionalStatusPostalCode.validationError')]"/>



<!--HarProfessionalStatusCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusCity',
			   		help:message(code:'har.property.harProfessionalStatusCity.help'),
			   		validation:'  validate-city',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harProfessionalStatusCity', 
			 		validation:'  validate-city', 
			 		condition:'isEmployed-filled ',
			 		value:har.harProfessionalStatusCity, 
			 		title:message(code:'har.property.harProfessionalStatusCity.validationError')]"/>



<!--HarRegisterAsUnemployed -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRegisterAsUnemployed',
			   		help:message(code:'har.property.harRegisterAsUnemployed.help'),
			   		validation:' validate-one-required',
			   		condition:'isRegisteredAsUnemployed-trigger isUnemployed-filled ',
			   		elementName:'HarRegisterAsUnemployed', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harRegisterAsUnemployed', 
			   		validation:' validate-one-required', 
			   		condition:'isRegisteredAsUnemployed-trigger isUnemployed-filled ',
			   		title:message(code:'har.property.harRegisterAsUnemployed.validationError'),
			   		checked:har.harRegisterAsUnemployed]" />


<!--HarRegisterAsUnemployedDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRegisterAsUnemployedDate',
			   		help:message(code:'har.property.harRegisterAsUnemployedDate.help'),
			   		validation:'  validate-date-au',
			   		condition:'isRegisteredAsUnemployed-filled ',
			   		elementName:'HarRegisterAsUnemployedDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harRegisterAsUnemployedDate', 
			 		validation:'  validate-date-au', 
			 		condition:'isRegisteredAsUnemployed-filled ',
			 		value:har.harRegisterAsUnemployedDate, 
			 		title:message(code:'har.property.harRegisterAsUnemployedDate.validationError')]"/>



<!--HarIndemnified -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIndemnified',
			   		help:message(code:'har.property.harIndemnified.help'),
			   		validation:' validate-one-required',
			   		condition:'isIndemnified-trigger isUnemployed-filled ',
			   		elementName:'HarIndemnified', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harIndemnified', 
			   		validation:' validate-one-required', 
			   		condition:'isIndemnified-trigger isUnemployed-filled ',
			   		title:message(code:'har.property.harIndemnified.validationError'),
			   		checked:har.harIndemnified]" />


<!--HarIndemnifiedDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIndemnifiedDate',
			   		help:message(code:'har.property.harIndemnifiedDate.help'),
			   		validation:'  validate-date-au',
			   		condition:'isIndemnified-filled ',
			   		elementName:'HarIndemnifiedDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/text" 
			 		model="[name:'harIndemnifiedDate', 
			 		validation:'  validate-date-au', 
			 		condition:'isIndemnified-filled ',
			 		value:har.harIndemnifiedDate, 
			 		title:message(code:'har.property.harIndemnifiedDate.validationError')]"/>



<!--HarElectiveFunction -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harElectiveFunction',
			   		help:message(code:'har.property.harElectiveFunction.help'),
			   		validation:'required validate-one-required',
			   		condition:'isElectiveFunction-trigger ',
			   		elementName:'HarElectiveFunction', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harElectiveFunction', 
			   		validation:'required validate-one-required', 
			   		condition:'isElectiveFunction-trigger ',
			   		title:message(code:'har.property.harElectiveFunction.validationError'),
			   		checked:har.harElectiveFunction]" />


<!--HarElectiveFunctionDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harElectiveFunctionDetails',
			   		help:message(code:'har.property.harElectiveFunctionDetails.help'),
			   		validation:'required validate-one-required',
			   		condition:'isElectiveFunction-filled ',
			   		elementName:'HarElectiveFunctionDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/yesno"
			   		model="[name:'harElectiveFunctionDetails', 
			   		validation:'required validate-one-required', 
			   		condition:'isElectiveFunction-filled ',
			   		title:message(code:'har.property.harElectiveFunctionDetails.validationError'),
			   		checked:har.harElectiveFunctionDetails]" />

</fieldset>
