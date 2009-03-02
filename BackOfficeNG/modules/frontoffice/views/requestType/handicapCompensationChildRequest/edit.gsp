<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
  </head>  
  <body>
    <g:set var="requestTypeInfo">
      {"label": "${requestTypeLabel}"
        ,"steps": [  "subject-required",  "dwelling-required",  "socialSecurityAndPaymentAgency-required",  "occupationnalAndSchoolStatus-required",  "folders-required",  "benefits-required",  "aid-required",  "health-required",  "project-required",  "document",  "validation"  ]
      }
    </g:set>
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" scope="request" />
    <g:render template="/frontofficeRequestType/draftPanel" />
    <g:render template="/frontofficeRequestType/cancelPanel" />
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" />
    
    <h2 class="request-creation"> <g:message code="hccr.label" /></h2>
    <p><g:message code="hccr.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="hccr.duration.value" /></strong></p>
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
    <g:if test="${flash.confirmationMessage}">
      <div class="request-information">${flash.confirmationMessage}</div>
    </g:if>

    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">

  
  
        <li class="${['subject', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  
          <a href="#subject"><em>
          <span class="tag-no_right">1</span>
          <span class="tag-state ${stepStates!= null ? stepStates.subject.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.subject.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.subject.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'dwelling' ? 'selected' : ''}">
  
          <a href="#dwelling"><em>
          <span class="tag-no_right">2</span>
          <span class="tag-state ${stepStates!= null ? stepStates.dwelling.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.dwelling.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.dwelling.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'socialSecurityAndPaymentAgency' ? 'selected' : ''}">
  
          <a href="#socialSecurityAndPaymentAgency"><em>
          <span class="tag-no_right">3</span>
          <span class="tag-state ${stepStates!= null ? stepStates.socialSecurityAndPaymentAgency.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.socialSecurityAndPaymentAgency.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.socialSecurityAndPaymentAgency.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'occupationnalAndSchoolStatus' ? 'selected' : ''}">
  
          <a href="#occupationnalAndSchoolStatus"><em>
          <span class="tag-no_right">4</span>
          <span class="tag-state ${stepStates!= null ? stepStates.occupationnalAndSchoolStatus.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.occupationnalAndSchoolStatus.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.occupationnalAndSchoolStatus.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'folders' ? 'selected' : ''}">
  
          <a href="#folders"><em>
          <span class="tag-no_right">5</span>
          <span class="tag-state ${stepStates!= null ? stepStates.folders.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.folders.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.folders.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'benefits' ? 'selected' : ''}">
  
          <a href="#benefits"><em>
          <span class="tag-no_right">6</span>
          <span class="tag-state ${stepStates!= null ? stepStates.benefits.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.benefits.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.benefits.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'aid' ? 'selected' : ''}">
  
          <a href="#aid"><em>
          <span class="tag-no_right">7</span>
          <span class="tag-state ${stepStates!= null ? stepStates.aid.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.aid.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.aid.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'health' ? 'selected' : ''}">
  
          <a href="#health"><em>
          <span class="tag-no_right">8</span>
          <span class="tag-state ${stepStates!= null ? stepStates.health.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.health.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.health.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'project' ? 'selected' : ''}">
  
          <a href="#project"><em>
          <span class="tag-no_right">9</span>
          <span class="tag-state ${stepStates!= null ? stepStates.project.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.project.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="hccr.step.project.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
        <g:if test="${!documentTypes.isEmpty()}">
  
    
        <li class="${currentStep == 'document' ? 'selected' : ''}">
  
          <a href="#document"><em>
          <span class="tag-no_right">10</span>
          <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <g:message code="request.step.document.label" />
            
          </em></a>
        </li>    
  
        </g:if>
  

  
    
        <li class="${currentStep == 'validation' ? 'selected' : ''}">
  
          <a href="#validation"><em>
          <span class="tag-no_right">11</span>
          <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="request.step.validation.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

		 </ul>
		 
     <div class="yui-content">

  
       <div id="subject">
         <form method="POST"  id="stepForm-subject" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.subject.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.subject.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.subject.label" />
             <span><g:message code="hccr.step.subject.desc" /></span>
             <span class="error"><g:message code="${stepStates?.subject?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/subject" />         
  
           </div>
           <div class="error" id="stepForm-subject-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-subject" name="submit-step-subject" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
  
           <a id="next-tab" href="#dwelling"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.subject != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.subject}
         </div>
         </g:if>
       </div>  
  

  
       <div id="dwelling">
         <form method="POST"  id="stepForm-dwelling" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.dwelling.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.dwelling.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.dwelling.label" />
             <span><g:message code="hccr.step.dwelling.desc" /></span>
             <span class="error"><g:message code="${stepStates?.dwelling?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/dwelling" />         
  
           </div>
           <div class="error" id="stepForm-dwelling-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-dwelling" name="submit-step-dwelling" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#subject"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#socialSecurityAndPaymentAgency"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.dwelling != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.dwelling}
         </div>
         </g:if>
       </div>  
  

  
       <div id="socialSecurityAndPaymentAgency">
         <form method="POST"  id="stepForm-socialSecurityAndPaymentAgency" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.socialSecurityAndPaymentAgency.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.socialSecurityAndPaymentAgency.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.socialSecurityAndPaymentAgency.label" />
             <span><g:message code="hccr.step.socialSecurityAndPaymentAgency.desc" /></span>
             <span class="error"><g:message code="${stepStates?.socialSecurityAndPaymentAgency?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/socialSecurityAndPaymentAgency" />         
  
           </div>
           <div class="error" id="stepForm-socialSecurityAndPaymentAgency-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-socialSecurityAndPaymentAgency" name="submit-step-socialSecurityAndPaymentAgency" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#dwelling"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#occupationnalAndSchoolStatus"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.socialSecurityAndPaymentAgency != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.socialSecurityAndPaymentAgency}
         </div>
         </g:if>
       </div>  
  

  
       <div id="occupationnalAndSchoolStatus">
         <form method="POST"  id="stepForm-occupationnalAndSchoolStatus" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.occupationnalAndSchoolStatus.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.occupationnalAndSchoolStatus.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.occupationnalAndSchoolStatus.label" />
             <span><g:message code="hccr.step.occupationnalAndSchoolStatus.desc" /></span>
             <span class="error"><g:message code="${stepStates?.occupationnalAndSchoolStatus?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/occupationnalAndSchoolStatus" />         
  
           </div>
           <div class="error" id="stepForm-occupationnalAndSchoolStatus-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-occupationnalAndSchoolStatus" name="submit-step-occupationnalAndSchoolStatus" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#socialSecurityAndPaymentAgency"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#folders"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.occupationnalAndSchoolStatus != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.occupationnalAndSchoolStatus}
         </div>
         </g:if>
       </div>  
  

  
       <div id="folders">
         <form method="POST"  id="stepForm-folders" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.folders.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.folders.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.folders.label" />
             <span><g:message code="hccr.step.folders.desc" /></span>
             <span class="error"><g:message code="${stepStates?.folders?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/folders" />         
  
           </div>
           <div class="error" id="stepForm-folders-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-folders" name="submit-step-folders" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#occupationnalAndSchoolStatus"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#benefits"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.folders != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.folders}
         </div>
         </g:if>
       </div>  
  

  
       <div id="benefits">
         <form method="POST"  id="stepForm-benefits" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.benefits.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.benefits.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.benefits.label" />
             <span><g:message code="hccr.step.benefits.desc" /></span>
             <span class="error"><g:message code="${stepStates?.benefits?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/benefits" />         
  
           </div>
           <div class="error" id="stepForm-benefits-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-benefits" name="submit-step-benefits" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#folders"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#aid"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.benefits != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.benefits}
         </div>
         </g:if>
       </div>  
  

  
       <div id="aid">
         <form method="POST"  id="stepForm-aid" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.aid.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.aid.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.aid.label" />
             <span><g:message code="hccr.step.aid.desc" /></span>
             <span class="error"><g:message code="${stepStates?.aid?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/aid" />         
  
           </div>
           <div class="error" id="stepForm-aid-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-aid" name="submit-step-aid" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#benefits"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#health"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.aid != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.aid}
         </div>
         </g:if>
       </div>  
  

  
       <div id="health">
         <form method="POST"  id="stepForm-health" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.health.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.health.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.health.label" />
             <span><g:message code="hccr.step.health.desc" /></span>
             <span class="error"><g:message code="${stepStates?.health?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/health" />         
  
           </div>
           <div class="error" id="stepForm-health-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-health" name="submit-step-health" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#aid"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#project"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.health != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.health}
         </div>
         </g:if>
       </div>  
  

  
       <div id="project">
         <form method="POST"  id="stepForm-project" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.project.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.project.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="hccr.step.project.label" />
             <span><g:message code="hccr.step.project.desc" /></span>
             <span class="error"><g:message code="${stepStates?.project?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/project" />         
  
           </div>
           <div class="error" id="stepForm-project-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-project" name="submit-step-project" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#health"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#document"><g:message code="request.step.navigation.next"/></a>
  
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
         <form method="POST" enctype="multipart/form-data" id="stepForm-document" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <g:message code="request.step.document.label" />
             <span><g:message code="request.step.document.desc" /></span>
             <span class="error"><g:message code="${stepStates?.document?.errorMsg}" /></span>
           </h3>
           <div>
  
            <g:render template="/frontofficeRequestType/document" />         
  
           </div>
           <div class="error" id="stepForm-document-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#project"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#validation"><g:message code="request.step.navigation.next"/></a>
  
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
         <form method="POST"  id="stepForm-validation" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="request.step.validation.label" />
             <span><g:message code="request.step.validation.desc" /></span>
             <span class="error"><g:message code="${stepStates?.validation?.errorMsg}" /></span>
           </h3>
           <div>
  
             <label for="meansOfContact" class="required">
               <g:message code="request.meansOfContact.chooseMessage"/> *
             </label>
             <select name="meansOfContact" class="required">
               <g:each in="${meansOfContact}" var="moc">
                 <option value="${moc.key}">${moc.label}</option>
               </g:each>
             </select>
    
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/validation0" />
    
            <g:render template="/frontofficeRequestType/handicapCompensationChildRequest/validation1" />
    
  
           </div>
           <div class="error" id="stepForm-validation-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <div id="useAcceptance">
             <input type="checkbox" name="useAcceptance" class="required" />
             <a href="${createLink(controller:'localAuthorityResource',action:'pdf',id:'use')}" target="blank">
               <g:message code="request.step.validation.useAcceptance"/>
             </a>
           </div>
           <input type="submit" id="submit-step-validation" name="submit-step-validation" class="submit-step" value="${message(code:'action.send')}" ${!isRequestCreatable ? 'disabled="disabled"': ''}/>
           <g:if test="${!isRequestCreatable}">
             <div><g:message code="request.step.validation.requiredSteps"/></div>
           </g:if>
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#document"><g:message code="request.step.navigation.previous"/></a>
  
  
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
