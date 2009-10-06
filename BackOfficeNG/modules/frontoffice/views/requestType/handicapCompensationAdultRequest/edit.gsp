<html>
  <head>
     <title>${message(code:'hcar.description')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'autofill.js')}"></script>
    <g:if test="${customJS}">
      <script type="text/javascript" src="${createLinkTo(dir:customJS.dir,file:customJS.file)}"></script>
    </g:if>
  </head>  
  <body>
    <g:set var="requestTypeInfo">
      {"label": "${requestTypeLabel}"
        ,"steps": [  "subject-required",  "dwelling-required",  "socialSecurityAndPaymentAgency-required",  "occupationnalAndSchoolStatus-required",  "folders-required",  "benefits-required",  "aid-required",  "health-required",  "project-required",  "document",  "validation"  ]
      }
    </g:set>
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" scope="request" />
    <form action="${module.createLink(controller:'RequestCreationController',action:'condition')}" 
      method="post" id="conditionsForm">
      <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
      <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
    </form>
    <form action="${module.createLink(controller:'RequestCreationController',action:'autofill')}"
      method="post" id="autofillForm">
      <input type="hidden" id="autofillContainer" name="autofillContainer" value="" />
      <input type="hidden" id="triggerName" name="triggerName" value="" />
      <input type="hidden" id="triggerValue" name="triggerValue" value="" />
    </form>
    <g:if test="${flash.isOutOfAccountRequest}">
      <g:render template="/frontofficeRequestType/loginPanel" />
    </g:if>
    <g:if test="${flash.confirmationMessage}">
      <div class="information-box">
      	<p>${flash.confirmationMessage}</p>
      	<g:if test="${flash.confirmationMessageNotice}">
      	  <strong>${flash.confirmationMessageNotice}</strong>
      	</g:if>
      </div>
    </g:if>
    
    <g:render template="/frontofficeRequestType/cancelPanel" />
    <g:if test="${session.currentEcitizen && !isEdition}">
      <g:render template="/frontofficeRequestType/draftPanel" />
    </g:if>
    
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" />
    
    <h2 class="request-creation"> <g:message code="hcar.label" /></h2>
    <p><g:message code="hcar.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="hcar.duration.value" /></strong></p>
    <p>
      <g:message code="request.requiredDocuments.header" /> :
      <g:if test="${!documentTypes.isEmpty()}">
        <g:each in="${documentTypes}" var="documentType" status="index">
          <strong>${documentType.value.name}<g:if test="${index < documentTypes.size() - 1}">,</g:if></strong>
        </g:each>
      </g:if>
      <g:else>
        <g:message code="message.none" />
      </g:else>
    </p>

    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">

  
  
        <li class="${['subject', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  
          <a href="#subject"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.subject.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.subject.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.subject.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'dwelling' ? 'selected' : ''}">
  
          <a href="#dwelling"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.dwelling.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.dwelling.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.dwelling.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'socialSecurityAndPaymentAgency' ? 'selected' : ''}">
  
          <a href="#socialSecurityAndPaymentAgency"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.socialSecurityAndPaymentAgency.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.socialSecurityAndPaymentAgency.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.socialSecurityAndPaymentAgency.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'occupationnalAndSchoolStatus' ? 'selected' : ''}">
  
          <a href="#occupationnalAndSchoolStatus"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.occupationnalAndSchoolStatus.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.occupationnalAndSchoolStatus.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.occupationnalAndSchoolStatus.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'folders' ? 'selected' : ''}">
  
          <a href="#folders"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.folders.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.folders.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.folders.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'benefits' ? 'selected' : ''}">
  
          <a href="#benefits"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.benefits.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.benefits.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.benefits.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'aid' ? 'selected' : ''}">
  
          <a href="#aid"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.aid.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.aid.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.aid.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'health' ? 'selected' : ''}">
  
          <a href="#health"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.health.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.health.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.health.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'project' ? 'selected' : ''}">
  
          <a href="#project"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.project.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.project.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hcar.step.project.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
    
        <li class="${currentStep == 'document' ? 'selected' : ''}">
  
          <a href="#document"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <g:message code="request.step.document.label" />
            
          </em></a>
        </li>    
  
        </g:if>
  

  
    
        <li class="${currentStep == 'validation' ? 'selected' : ''}">
  
          <a href="#validation"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="request.step.validation.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

		 </ul>
		 
     <div class="yui-content">

  
       <div id="subject">
         <form method="post"  id="stepForm-subject" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.subject.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.subject.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.subject.label" />
             <span><g:message code="hcar.step.subject.desc" /></span>
             <span class="error">${stepStates?.subject?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/subject" />         
  
           </div>
           <div class="error" id="stepForm-subject-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-subject" name="submit-step-subject" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
  
           <a id="next-tab-subject" class="next-tab" href="#dwelling"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.subject != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.subject}
         </div>
         </g:if>
       </div>  
  

  
       <div id="dwelling">
         <form method="post"  id="stepForm-dwelling" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.dwelling.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.dwelling.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.dwelling.label" />
             <span><g:message code="hcar.step.dwelling.desc" /></span>
             <span class="error">${stepStates?.dwelling?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/dwelling" />         
  
           </div>
           <div class="error" id="stepForm-dwelling-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-dwelling" name="submit-step-dwelling" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-dwelling" class="prev-tab" href="#subject"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-dwelling" class="next-tab" href="#socialSecurityAndPaymentAgency"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.dwelling != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.dwelling}
         </div>
         </g:if>
       </div>  
  

  
       <div id="socialSecurityAndPaymentAgency">
         <form method="post"  id="stepForm-socialSecurityAndPaymentAgency" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.socialSecurityAndPaymentAgency.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.socialSecurityAndPaymentAgency.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.socialSecurityAndPaymentAgency.label" />
             <span><g:message code="hcar.step.socialSecurityAndPaymentAgency.desc" /></span>
             <span class="error">${stepStates?.socialSecurityAndPaymentAgency?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/socialSecurityAndPaymentAgency" />         
  
           </div>
           <div class="error" id="stepForm-socialSecurityAndPaymentAgency-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-socialSecurityAndPaymentAgency" name="submit-step-socialSecurityAndPaymentAgency" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-socialSecurityAndPaymentAgency" class="prev-tab" href="#dwelling"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-socialSecurityAndPaymentAgency" class="next-tab" href="#occupationnalAndSchoolStatus"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.socialSecurityAndPaymentAgency != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.socialSecurityAndPaymentAgency}
         </div>
         </g:if>
       </div>  
  

  
       <div id="occupationnalAndSchoolStatus">
         <form method="post"  id="stepForm-occupationnalAndSchoolStatus" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.occupationnalAndSchoolStatus.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.occupationnalAndSchoolStatus.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.occupationnalAndSchoolStatus.label" />
             <span><g:message code="hcar.step.occupationnalAndSchoolStatus.desc" /></span>
             <span class="error">${stepStates?.occupationnalAndSchoolStatus?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/occupationnalAndSchoolStatus" />         
  
           </div>
           <div class="error" id="stepForm-occupationnalAndSchoolStatus-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-occupationnalAndSchoolStatus" name="submit-step-occupationnalAndSchoolStatus" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-occupationnalAndSchoolStatus" class="prev-tab" href="#socialSecurityAndPaymentAgency"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-occupationnalAndSchoolStatus" class="next-tab" href="#folders"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.occupationnalAndSchoolStatus != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.occupationnalAndSchoolStatus}
         </div>
         </g:if>
       </div>  
  

  
       <div id="folders">
         <form method="post"  id="stepForm-folders" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.folders.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.folders.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.folders.label" />
             <span><g:message code="hcar.step.folders.desc" /></span>
             <span class="error">${stepStates?.folders?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/folders" />         
  
           </div>
           <div class="error" id="stepForm-folders-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-folders" name="submit-step-folders" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-folders" class="prev-tab" href="#occupationnalAndSchoolStatus"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-folders" class="next-tab" href="#benefits"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.folders != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.folders}
         </div>
         </g:if>
       </div>  
  

  
       <div id="benefits">
         <form method="post"  id="stepForm-benefits" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.benefits.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.benefits.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.benefits.label" />
             <span><g:message code="hcar.step.benefits.desc" /></span>
             <span class="error">${stepStates?.benefits?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/benefits" />         
  
           </div>
           <div class="error" id="stepForm-benefits-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-benefits" name="submit-step-benefits" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-benefits" class="prev-tab" href="#folders"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-benefits" class="next-tab" href="#aid"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.benefits != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.benefits}
         </div>
         </g:if>
       </div>  
  

  
       <div id="aid">
         <form method="post"  id="stepForm-aid" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.aid.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.aid.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.aid.label" />
             <span><g:message code="hcar.step.aid.desc" /></span>
             <span class="error">${stepStates?.aid?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/aid" />         
  
           </div>
           <div class="error" id="stepForm-aid-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-aid" name="submit-step-aid" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-aid" class="prev-tab" href="#benefits"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-aid" class="next-tab" href="#health"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.aid != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.aid}
         </div>
         </g:if>
       </div>  
  

  
       <div id="health">
         <form method="post"  id="stepForm-health" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.health.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.health.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.health.label" />
             <span><g:message code="hcar.step.health.desc" /></span>
             <span class="error">${stepStates?.health?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/health" />         
  
           </div>
           <div class="error" id="stepForm-health-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-health" name="submit-step-health" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-health" class="prev-tab" href="#aid"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-health" class="next-tab" href="#project"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.health != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.health}
         </div>
         </g:if>
       </div>  
  

  
       <div id="project">
         <form method="post"  id="stepForm-project" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.project.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.project.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hcar.step.project.label" />
             <span><g:message code="hcar.step.project.desc" /></span>
             <span class="error">${stepStates?.project?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/project" />         
  
           </div>
           <div class="error" id="stepForm-project-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-project" name="submit-step-project" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-project" class="prev-tab" href="#health"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-project" class="next-tab" href="#document"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.project != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.project}
         </div>
         </g:if>
       </div>  
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
       <div id="document">
         <form method="post" enctype="multipart/form-data" id="stepForm-document" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <g:message code="request.step.document.label" />
             <span><g:message code="request.step.document.desc" /></span>
             <span class="error">${stepStates?.document?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/document" />         
  
           </div>
           <div class="error" id="stepForm-document-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-document" class="prev-tab" href="#project"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab-document" class="next-tab" href="#validation"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.document != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.document}
         </div>
         </g:if>
       </div>  
  
        </g:if>
  

  
       <div id="validation">
         <form method="post"  id="stepForm-validation" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="request.step.validation.label" />
             <span><g:message code="request.step.validation.desc" /></span>
             <span class="error">${stepStates?.validation?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
             <g:if test="${meansOfContact.size() > 0}">
              <label for="meansOfContact" class="required">
               <g:message code="request.meansOfContact.chooseMessage"/> *
              </label>
              <select id="meansOfContact" name="meansOfContact" class="required">
               <g:each in="${meansOfContact}" var="moc">
                 <option value="${moc.key}" <g:if test="${rqt.meansOfContact?.type == moc.key}">selected="selected"</g:if>>${moc.label}</option>
               </g:each>
              </select>
             </g:if>
             <g:else>
               <p>${message(code:'request.meansOfContact.message.notAvailable')}</p>
             </g:else>
             <div class="summary-box">
    
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/validation0" />
    
            <g:render template="/frontofficeRequestType/handicapCompensationAdultRequest/validation1" />
    
            </div>
            <h3><g:message code="request.step.note.label" /></h3>
            <g:message code="request.step.note.desc" />
            <textarea id="requestNote" name="requestNote" rows="" cols=""></textarea>
            <label><span id="requestNoteLimit"></span></label>
            <h3><g:message code="request.step.validation.label" /></h3>
            <g:if test="${!hasHomeFolder}">
              <g:render template="/frontofficeRequestType/outOfAccountValidation" />
            </g:if>
            <div id="useAcceptance">
             <input type="checkbox" name="useAcceptance" class="required validate-one-required"
                    title="${message(code:'request.error.useAcceptanceRequired')}" />
             <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'use')}" target="blank">
               <g:message code="request.step.validation.useAcceptance"/>
             </a>
           </div>
  
           </div>
           <div class="error" id="stepForm-validation-error"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-validation" name="submit-step-validation" class="submit-step" value="${message(code:'action.send')}" ${!isRequestCreatable ? 'disabled="disabled"': ''}/>
           <g:if test="${!isRequestCreatable}">
             <div><strong><g:message code="request.step.validation.requiredSteps"/></strong></div>
           </g:if>
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab-validation" class="prev-tab" href="#document"><g:message code="request.step.navigation.previous"/></a>
  
  
         </div>
         <g:if test="${helps.validation != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.validation}
         </div>
         </g:if>
       </div>  
  
        
 	    </div><!-- end yui-content -->
    </div><!-- end requestTabView -->
  
  </body>
</html>
