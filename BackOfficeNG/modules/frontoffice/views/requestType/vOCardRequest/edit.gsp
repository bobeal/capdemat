<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'format.js')}"></script>
  </head>  
  <body>
    <g:set var="requestTypeInfo">
      {"label": "${requestTypeLabel}"
	  ,"steps": [  "adults-required", "children", "account-required", "document", "validation"  ]
	  }
    </g:set>
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" scope="request" />
    <form action="${module.createLink(controller:'VoCardRequestCreationController',action:'condition')}" 
      method="post" id="conditionsForm">
      <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
      <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
    </form>
	<g:render template="/frontofficeRequestType/cancelPanel" />
    <g:set var="requestTypeInfo" value="${requestTypeInfo.encodeAsHTML()}" />
    
	<h2 class="request-creation"> <g:message code="vcr.label" /></h2>
    <p><g:message code="vcr.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="vcr.duration.value" /></strong></p>
    <p>
      <g:message code="request.requiredDocuments.header" /> :
      <g:each in="${documentTypes}" var="documentType" status="index">
        <strong>
          <g:message code="${documentType.value.i18nKey}"/><g:if test="${index < documentTypes.size() - 1}">,</g:if>
        </strong>
      </g:each>
    </p>
    <g:if test="${flash.confirmationMessage}">
      <p class="message-confirmation">${flash.confirmationMessage}</p>
    </g:if>


    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">
        <li class="${['adults', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  
          <a href="#adults"><em>
          <span class="tag-no_right">1</span>
          <span class="tag-state ${stepStates!= null ? stepStates.adults.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.adults.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="vcr.step.adults.label" />
          </strong>
            
          </em></a>
        </li>    

        <li class="${currentStep == 'children' ? 'selected' : ''}">
  
          <a href="#children"><em>
          <span class="tag-no_right">2</span>
          <span class="tag-state ${stepStates!= null ? stepStates.children.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.children.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="vcr.step.children.label" />
          </strong>
            
          </em></a>
        </li>          
        
        <li class="${currentStep == 'account' ? 'selected' : ''}">
  
          <a href="#account"><em>
          <span class="tag-no_right">3</span>
          <span class="tag-state ${stepStates!= null ? stepStates.account.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.account.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="vcr.step.account.label" />
          </strong>
            
          </em></a>
        </li>

        <li class="${currentStep == 'document' ? 'selected' : ''}">

          <a href="#document"><em>
          <span class="tag-no_right">4</span>
          <span class="tag-state ${stepStates!= null ? stepStates.document.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.document.i18nKey : 'request.step.state.uncomplete'}" /></span>

          <g:message code="request.step.document.label" />

          </em></a>
        </li>   

        <li class="${currentStep == 'validation' ? 'selected' : ''}">
  
          <a href="#validation"><em>
          <span class="tag-no_right">5</span>
          <span class="tag-state ${stepStates!= null ? stepStates.validation.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.validation.i18nKey : 'request.step.state.uncomplete'}" /></span>
    
          <strong>
            <g:message code="request.step.validation.label" />
          </strong>
            
          </em></a>
        </li>    

		 </ul>
		 
     <div class="yui-content">

       <div id="adults">
         <form method="POST"  id="stepForm-adults" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.adults.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.adults.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="vcr.step.adults.label" />
             <span><g:message code="vcr.step.adults.desc" /></span>
             <span class="error"><g:message code="${stepStates?.adults?.errorMsg}" /></span>
           </h3>
           <div>
         	   <g:render template="/frontofficeRequestType/vOCardRequest/adults" /> 
           </div>

           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-adults" name="submit-step-adults" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
           <a id="next-tab" href="#children"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.adults != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.adults}
         </div>
         </g:if>
       </div>  
       
       <div id="children">
         <form method="POST"  id="stepForm-children" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.children.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.children.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <g:message code="vcr.step.children.label" />
             <span><g:message code="vcr.step.children.desc" /></span>
             <span class="error"><g:message code="${stepStates?.children?.errorMsg}" /></span>
           </h3>
           <div>
         	   <g:render template="/frontofficeRequestType/vOCardRequest/children" /> 
           </div>

           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
           <g:if test="${!isChildLegalResponsibleEdit}">
             <input type="submit" id="submit-step-children" name="submit-step-children" value="${message(code:'action.save')}" />
           </g:if>
           <g:else>
             <input type="submit" id="submit-legalResponsibles-children" name="submit-legalResponsibles-children" value="${message(code:'action.save')}" />
           </g:else>
  
         </form>
         <div class="navTab">
         
   		   <a id="prev-tab" href="#adults"><g:message code="request.step.navigation.previous"/></a>
           <a id="next-tab" href="#account"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.children != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.children}
         </div>
         </g:if>
       </div> 
       
       <div id="account">
         <form method="POST"  id="stepForm-account" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates!= null ? stepStates.account.cssClass : 'tag-pending'}"><g:message code="${stepStates != null ? stepStates.account.i18nKey : 'request.step.state.uncomplete'}" /></span>
  
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  
             <g:message code="vcr.step.account.label" />
             <span><g:message code="vcr.step.account.desc" /></span>
             <span class="error"><g:message code="${stepStates?.account?.errorMsg}" /></span>
           </h3>
           <div>
         	   <g:render template="/frontofficeRequestType/vOCardRequest/account" /> 
           </div>
           <div class="error" id="stepForm-account-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-account" name="submit-step-account" value="${message(code:'action.save')}" />
  
         </form>
         <div class="navTab">
  
    	   <a id="prev-tab" href="#children"><g:message code="request.step.navigation.previous"/></a>
           <a id="next-tab" href="#document"><g:message code="request.step.navigation.next"/></a>
  
         </div>
         <g:if test="${helps.account != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.account}
         </div>
         </g:if>
       </div>

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

           <a id="prev-tab" href="#account"><g:message code="request.step.navigation.previous"/></a>
           <a id="next-tab" href="#validation"><g:message code="request.step.navigation.next"/></a>

         </div>
         <g:if test="${helps.document != null}">
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           ${helps.document}
         </div>
         </g:if>
       </div>  

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
             
             <select name="meansOfContact">
               <g:each in="${meansOfContact}" var="moc">
                 <option value="${moc.key}">${moc.label}</option>
               </g:each>
             </select>
  
             <g:render template="/frontofficeRequestType/vOCardRequest/summary" /> 

						 <h3><g:message code="vcr.property.monitoring" /></h3>
						 <div class="required captcha">
  						 <label class="required"><g:message code="vcr.property.captcha" /></label>
  						 <jcaptcha:jpeg name="image" class="image"/>
  						 <input type="text" name="response" class="required response" value=""/>
						 </div>
        
           </div>
           <div class="error" id="stepForm-validation-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="${uuidString}" />
  
           <input type="submit" id="submit-step-validation" name="submit-step-validation" value="${message(code:'action.send')}" ${!isRequestCreatable ? 'disabled="disabled"': ''}/>
           <g:if test="${!isRequestCreatable}">
           <span><g:message code="request.step.validation.requiredSteps"/></span>
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
