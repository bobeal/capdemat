<fieldset class="">

<!--HarSchooling --> 
<g:render template="/frontofficeRequestType/widget/legend"
			   		model="[elementName:'HarSchooling',
			   		condition:'',
			   		requestType: har]"/>



<!--HarSchoolingEnrolment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolingEnrolment',
			   		help:null,
			   		validation:'null',
			   		condition:'isSchoolingEnrolment-trigger ',
			   		elementName:'HarSchoolingEnrolment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSchoolingEnrolment,
					type:'yesnoWidget',
					condition:'isSchoolingEnrolment-trigger ']" />


<!--HarSchoolName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolName',
			   		help:null,
			   		validation:'null',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSchoolName,
					type:'textWidget',
					condition:'isSchoolingEnrolment-filled ']" />


<!--HarSchoolAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSchoolAddress,
					type:'textWidget',
					condition:'isSchoolingEnrolment-filled ']" />


<!--HarSchoolPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSchoolPostalCode,
					type:'textWidget',
					condition:'isSchoolingEnrolment-filled ']" />


<!--HarSchoolCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolCity',
			   		help:null,
			   		validation:'null',
			   		condition:'isSchoolingEnrolment-filled ',
			   		elementName:'HarSchoolCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSchoolCity,
					type:'textWidget',
					condition:'isSchoolingEnrolment-filled ']" />


<!--HarSendToSchool -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSendToSchool',
			   		help:null,
			   		validation:'null',
			   		condition:'isSentToSchool-trigger ',
			   		elementName:'HarSendToSchool', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSendToSchool,
					type:'yesnoWidget',
					condition:'isSentToSchool-trigger ']" />


<!--HarAttendedGrade -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAttendedGrade',
			   		help:null,
			   		validation:'null',
			   		condition:'isSentToSchool-filled ',
			   		elementName:'HarAttendedGrade', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harAttendedGrade,
					type:'textWidget',
					condition:'isSentToSchool-filled ']" />


<!--HarSpecializedGrade -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedGrade',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpecializedGrade-trigger ',
			   		elementName:'HarSpecializedGrade', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSpecializedGrade,
					type:'yesnoWidget',
					condition:'isSpecializedGrade-trigger ']" />


<!--HarSpecializedGradeDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSpecializedGradeDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isSpecializedGrade-filled ',
			   		elementName:'HarSpecializedGradeDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSpecializedGradeDetails,
					type:'textWidget',
					condition:'isSpecializedGrade-filled ']" />


<!--HarSchoolingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolingKind',
			   		help:null,
			   		validation:'null',
			   		condition:'isPartTimeSchooling-trigger ',
			   		elementName:'HarSchoolingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSchoolingKind,
					type:'selectWidget',
					condition:'isPartTimeSchooling-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarSchoolingKindType']" />


<!--HarSchoolingTime -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harSchoolingTime',
			   		help:null,
			   		validation:'null',
			   		condition:'isPartTimeSchooling-filled ',
			   		elementName:'HarSchoolingTime', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harSchoolingTime,
					type:'textWidget',
					condition:'isPartTimeSchooling-filled ']" />


<!--HarHomeSchooling -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchooling',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarHomeSchooling', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHomeSchooling,
					type:'yesnoWidget',
					condition:'']" />


<!--HarPersonalizedSchoolingPlan -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPersonalizedSchoolingPlan',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarPersonalizedSchoolingPlan', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPersonalizedSchoolingPlan,
					type:'yesnoWidget',
					condition:'']" />


<!--HarHomeSchoolingKind -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingKind',
			   		help:null,
			   		validation:'null',
			   		condition:'isAccompaniedHomeSchooling-trigger ',
			   		elementName:'HarHomeSchoolingKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHomeSchoolingKind,
					type:'selectWidget',
					condition:'isAccompaniedHomeSchooling-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarHomeSchoolingKindType']" />


<!--HarHomeSchoolingAccompanistLastName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistLastName',
			   		help:null,
			   		validation:'null',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistLastName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHomeSchoolingAccompanistLastName,
					type:'textWidget',
					condition:'isAccompaniedHomeSchooling-filled ']" />


<!--HarHomeSchoolingAccompanistFirstName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistFirstName',
			   		help:null,
			   		validation:'null',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistFirstName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHomeSchoolingAccompanistFirstName,
					type:'textWidget',
					condition:'isAccompaniedHomeSchooling-filled ']" />


<!--HarHomeSchoolingAccompanistAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHomeSchoolingAccompanistAddress,
					type:'textWidget',
					condition:'isAccompaniedHomeSchooling-filled ']" />


<!--HarHomeSchoolingAccompanistPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'isAccompaniedHomeSchooling-filled ',
			   		elementName:'HarHomeSchoolingAccompanistPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHomeSchoolingAccompanistPostalCode,
					type:'textWidget',
					condition:'isAccompaniedHomeSchooling-filled ']" />


<!--HarHomeSchoolingAccompanistCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHomeSchoolingAccompanistCity',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarHomeSchoolingAccompanistCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHomeSchoolingAccompanistCity,
					type:'textWidget',
					condition:'']" />


<!--HarExtraCurricular -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harExtraCurricular',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarExtraCurricular', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarSchoolingType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harExtraCurricular,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isHighSchool-trigger ',
			   		elementName:'HarHighSchool', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHighSchool,
					type:'yesnoWidget',
					condition:'isHighSchool-trigger ']" />


<!--HarHighSchoolGrade -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolGrade',
			   		help:null,
			   		validation:'null',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolGrade', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHighSchoolGrade,
					type:'textWidget',
					condition:'isHighSchool-filled ']" />


<!--HarHighSchoolName -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolName',
			   		help:null,
			   		validation:'null',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolName', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHighSchoolName,
					type:'textWidget',
					condition:'isHighSchool-filled ']" />


<!--HarHighSchoolAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHighSchoolAddress,
					type:'textWidget',
					condition:'isHighSchool-filled ']" />


<!--HarHighSchoolPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHighSchoolPostalCode,
					type:'textWidget',
					condition:'isHighSchool-filled ']" />


<!--HarHighSchoolCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harHighSchoolCity',
			   		help:null,
			   		validation:'null',
			   		condition:'isHighSchool-filled ',
			   		elementName:'HarHighSchoolCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harHighSchoolCity,
					type:'textWidget',
					condition:'isHighSchool-filled ']" />


<!--HarAssistanceUnderDisability -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAssistanceUnderDisability',
			   		help:null,
			   		validation:'null',
			   		condition:'isHighSchool-filled isAssistanceUnderDisability-trigger ',
			   		elementName:'HarAssistanceUnderDisability', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harAssistanceUnderDisability,
					type:'yesnoWidget',
					condition:'isHighSchool-filled isAssistanceUnderDisability-trigger ']" />


<!--HarAssistanceUnderDisabilityDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harAssistanceUnderDisabilityDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isAssistanceUnderDisability-filled ',
			   		elementName:'HarAssistanceUnderDisabilityDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarStudiesType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harAssistanceUnderDisabilityDetails,
					type:'textWidget',
					condition:'isAssistanceUnderDisability-filled ']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarStudiesLevel', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harStudiesLevel,
					type:'textWidget',
					condition:'']" />


<!--HarDiploma -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harDiploma',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarDiploma', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harDiploma,
					type:'textWidget',
					condition:'']" />


<!--HarPreviousFormation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harPreviousFormation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarPreviousFormation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harPreviousFormation,
					type:'textWidget',
					condition:'']" />


<!--HarCurrentFormation -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harCurrentFormation',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarCurrentFormation', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarFormationType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harCurrentFormation,
					type:'textWidget',
					condition:'']" />

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
			   		help:null,
			   		validation:'null',
			   		condition:'isEmployed-trigger isUnemployed-trigger ',
			   		elementName:'HarProfessionalStatusKind', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalStatusKind,
					type:'selectWidget',
					condition:'isEmployed-trigger isUnemployed-trigger ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarProfessionalStatusKindType']" />


<!--HarProfessionalStatusDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusDate',
			   		help:null,
			   		validation:'null',
			   		condition:'',
			   		elementName:'HarProfessionalStatusDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalStatusDate,
					type:'textWidget',
					condition:'']" />


<!--HarProfessionalStatusEnvironment -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusEnvironment',
			   		help:null,
			   		validation:'null',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusEnvironment', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalStatusEnvironment,
					type:'selectWidget',
					condition:'isEmployed-filled ',
					namespace:'http://www.cg95.fr/cvq/schema/har',
 					elementTypeName:'HarProfessionalStatusEnvironmentType']" />


<!--HarProfessionalStatusProfession -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusProfession',
			   		help:null,
			   		validation:'null',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusProfession', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalStatusProfession,
					type:'textWidget',
					condition:'isEmployed-filled ']" />


<!--HarProfessionalStatusAddress -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusAddress',
			   		help:null,
			   		validation:'null',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusAddress', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalStatusAddress,
					type:'textWidget',
					condition:'isEmployed-filled ']" />


<!--HarProfessionalStatusPostalCode -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusPostalCode',
			   		help:null,
			   		validation:'null',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusPostalCode', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalStatusPostalCode,
					type:'textWidget',
					condition:'isEmployed-filled ']" />


<!--HarProfessionalStatusCity -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harProfessionalStatusCity',
			   		help:null,
			   		validation:'null',
			   		condition:'isEmployed-filled ',
			   		elementName:'HarProfessionalStatusCity', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harProfessionalStatusCity,
					type:'textWidget',
					condition:'isEmployed-filled ']" />


<!--HarRegisterAsUnemployed -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRegisterAsUnemployed',
			   		help:null,
			   		validation:'null',
			   		condition:'isRegisteredAsUnemployed-trigger isUnemployed-filled ',
			   		elementName:'HarRegisterAsUnemployed', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRegisterAsUnemployed,
					type:'yesnoWidget',
					condition:'isRegisteredAsUnemployed-trigger isUnemployed-filled ']" />


<!--HarRegisterAsUnemployedDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harRegisterAsUnemployedDate',
			   		help:null,
			   		validation:'null',
			   		condition:'isRegisteredAsUnemployed-filled ',
			   		elementName:'HarRegisterAsUnemployedDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harRegisterAsUnemployedDate,
					type:'textWidget',
					condition:'isRegisteredAsUnemployed-filled ']" />


<!--HarIndemnified -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIndemnified',
			   		help:null,
			   		validation:'null',
			   		condition:'isIndemnified-trigger isUnemployed-filled ',
			   		elementName:'HarIndemnified', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harIndemnified,
					type:'yesnoWidget',
					condition:'isIndemnified-trigger isUnemployed-filled ']" />


<!--HarIndemnifiedDate -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harIndemnifiedDate',
			   		help:null,
			   		validation:'null',
			   		condition:'isIndemnified-filled ',
			   		elementName:'HarIndemnifiedDate', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harIndemnifiedDate,
					type:'textWidget',
					condition:'isIndemnified-filled ']" />


<!--HarElectiveFunction -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harElectiveFunction',
			   		help:null,
			   		validation:'null',
			   		condition:'isElectiveFunction-trigger ',
			   		elementName:'HarElectiveFunction', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harElectiveFunction,
					type:'yesnoWidget',
					condition:'isElectiveFunction-trigger ']" />


<!--HarElectiveFunctionDetails -->
<g:render template="/frontofficeRequestType/widget/label" 
			   		model="[forName:'harElectiveFunctionDetails',
			   		help:null,
			   		validation:'null',
			   		condition:'isElectiveFunction-filled ',
			   		elementName:'HarElectiveFunctionDetails', 
			   		namespace:'http://www.cg95.fr/cvq/schema/har',
			   		elementTypeName : 'HarProfessionalStatusType']"/> 


<g:render template="/frontofficeRequestType/widget/outputText"
					model="[value:har.harElectiveFunctionDetails,
					type:'yesnoWidget',
					condition:'isElectiveFunction-filled ']" />

</fieldset>
