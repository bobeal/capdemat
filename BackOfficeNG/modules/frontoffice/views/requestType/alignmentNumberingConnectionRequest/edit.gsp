<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'autofill.js')}"></script>
  </head>  
  <body>
    <g:set var="requestTypeInfo">
      {"label": "${requestTypeLabel}"
        ,"steps": [  "requester-required",  "cadastre-required",  "validation"  ]
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
      <div class="information-box"><p>${flash.confirmationMessage}</p></div>
    </g:if>
    
    <g:render template="/frontofficeRequestType/cancelPanel" />
    <g:if test="${session.currentEcitizen && !isEdition}">
      <g:render template="/frontofficeRequestType/draftPanel" />
    </g:if>
    
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" />
    
    <h2 class="request-creation"> <g:message code="ancr.label" /></h2>
    <p><g:message code="ancr.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="ancr.duration.value" /></strong></p>
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

  
  
        <li class="${['requester', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  
          <a href="#requester"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.requester.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.requester.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="ancr.step.requester.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
        <li class="${currentStep == 'cadastre' ? 'selected' : ''}">
  
          <a href="#cadastre"><em>
          <span class="tag-state ${stepStates!= null ? stepStates.cadastre.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.cadastre.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="ancr.step.cadastre.label" /> *
          </strong>
            
          </em></a>
        </li>    
  

  
    
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

  
       <div id="requester">
         <form method="POST"  id="stepForm-requester" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.requester.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.requester.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="ancr.step.requester.label" />
             <span><g:message code="ancr.step.requester.desc" /></span>
             <span class="error">${stepStates?.requester?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/alignmentNumberingConnectionRequest/requester" />         
  
           </div>
           <div class="error" id="stepForm-requester-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-requester" name="submit-step-requester" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
  
           <a id="next-tab" href="#cadastre"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.requester != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.requester}
         </div>
         </g:if>
       </div>  
  

  
       <div id="cadastre">
         <form method="POST"  id="stepForm-cadastre" action="<g:createLink action="step" />">
           <input type="hidden" name="returnUrl" value="${returnUrl}" />
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.cadastre.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.cadastre.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="ancr.step.cadastre.label" />
             <span><g:message code="ancr.step.cadastre.desc" /></span>
             <span class="error">${stepStates?.cadastre?.errorMsg}</span>
           </h3>
           <p class="required-fields-notice"><g:message code="request.message.requiredFieldsNotice"/></p>
           <div>
  
            <g:render template="/frontofficeRequestType/alignmentNumberingConnectionRequest/cadastre" />         
  
           </div>
           <div class="error" id="stepForm-cadastre-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-cadastre" name="submit-step-cadastre" class="submit-step" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#requester"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a id="next-tab" href="#validation"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.cadastre != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.cadastre}
         </div>
         </g:if>
       </div>  
  

  
       <div id="validation">
         <form method="POST"  id="stepForm-validation" action="<g:createLink action="step" />">
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
  
             <label for="meansOfContact" class="required">
               <g:message code="request.meansOfContact.chooseMessage"/> *
             </label>
             <select name="meansOfContact" class="required">
               <g:each in="${meansOfContact}" var="moc">
                 <option value="${moc.key}" <g:if test="${rqt.meansOfContact?.type == moc.key}">selected="selected"</g:if>>${moc.label}</option>
               </g:each>
             </select>
             <div class="summary-box">
    
            <g:render template="/frontofficeRequestType/alignmentNumberingConnectionRequest/validation0" />
    
            </div>
            <h3><g:message code="request.step.note.label" /></h3>
            <g:message code="request.step.note.desc" />
            <textarea name="requestNote" rows="" cols=""></textarea>
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
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-validation" name="submit-step-validation" class="submit-step" value="${message(code:'action.send')}" ${!isRequestCreatable ? 'disabled="disabled"': ''}/>
           <g:if test="${!isRequestCreatable}">
             <div><strong><g:message code="request.step.validation.requiredSteps"/></strong></div>
           </g:if>
  
         </form>
         <div class="navTab">
  
           <a id="prev-tab" href="#cadastre"><g:message code="request.step.navigation.previous"/></a>
  
  
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
