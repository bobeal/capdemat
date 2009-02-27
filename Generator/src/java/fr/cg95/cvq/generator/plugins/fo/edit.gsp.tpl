<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="\${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="\${createLinkTo(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="\${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
  </head>  
  <body>
    <g:set var="requestTypeInfo">
      {"label": "\${requestTypeLabel}"
        ,"steps": [ <% requestFo.steps.eachWithIndex { step, i -> %> "${step.name}${step.required ? '-required' : ''}"${i < requestFo.steps.size() -1 ? ',': ''} <% } %> ]
      }
    </g:set>
    <g:set var="requestTypeInfo" value="\${requestTypeInfo.encodeAsHTML()}" scope="request" />
    <g:render template="/frontofficeRequestType/draftPanel" />
    <g:render template="/frontofficeRequestType/cancelPanel" />
    <g:set var="requestTypeInfo" value="\${requestTypeInfo.encodeAsHTML()}" />
    
    <h2 class="request-creation"> <g:message code="${requestFo.acronym}.label" /></h2>
    <p><g:message code="${requestFo.acronym}.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="${requestFo.acronym}.duration.value" /></strong></p>
    <p>
      <g:message code="request.requiredDocuments.header" /> :
      <g:each in="\${documentTypes}" var="documentType" status="index">
        <strong>
          <g:message code="\${documentType.value.i18nKey}"/><g:if test="\${index < documentTypes.size() - 1}">,</g:if>
        </strong>
      </g:each>
    </p>
    <g:if test="\${flash.confirmationMessage}">
      <p class="message-confirmation">\${flash.confirmationMessage}</p>
    </g:if>

    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">
<% requestFo.steps.eachWithIndex { step, i -> %>
  <% if (i == 0) { %>
        <li class="\${['${step.name}', 'firstStep'].contains(currentStep) ? 'selected' : ''}">
  <% } else {%>  
        <li class="\${currentStep == '${step.name}' ? 'selected' : ''}">
  <% } %>
          <a href="#${step.name}"><em>
          <span class="tag-no_right">${step.index + 1}</span>
          <span class="tag-state \${stepStates!= null ? stepStates.${step.name}.cssClass : 'tag-pending'}"><g:message code="\${stepStates != null ? stepStates.${step.name}.i18nKey : 'request.step.state.uncomplete'}" /></span>
    <% if (step.name == 'validation' || step.required) { %>
          <strong>
            <g:message code="${['validation','document'].contains(step.name) ? 'request' : requestFo.acronym}.step.${step.name}.label" /> *
          </strong>
    <% } else {%>
          <g:message code="${['validation','document'].contains(step.name) ? 'request' : requestFo.acronym}.step.${step.name}.label" />
    <% } %>        
          </em></a>
        </li>    
<% } %>
		 </ul>
		 
     <div class="yui-content">
<% requestFo.steps.each { step -> %>
       <div id="${step.name}">
         <form method="POST" ${step.name == 'document' ? 'enctype=\"multipart/form-data\"' : ''} id="stepForm-${step.camelCaseName}" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state \${stepStates!= null ? stepStates.${step.name}.cssClass : 'tag-pending'}"><g:message code="\${stepStates != null ? stepStates.${step.name}.i18nKey : 'request.step.state.uncomplete'}" /></span>
  <% if (step.name == 'validation' || step.required) { %>
             <span class="tag-state tag-required"><g:message code="request.step.required" /></span>
  <% } %>
             <g:message code="${['validation','document'].contains(step.name) ? 'request' : requestFo.acronym}.step.${step.name}.label" />
             <span><g:message code="${['validation','document'].contains(step.name) ? 'request' : requestFo.acronym}.step.${step.name}.desc" /></span>
             <span class="error"><g:message code="\${stepStates?.${step.name}?.errorMsg}" /></span>
           </h3>
           <div>
  <% if (step.name == 'validation') { %>
             <select name="meansOfContact">
               <g:each in="\${meansOfContact}" var="moc">
                 <option value="\${moc.key}">\${moc.label}</option>
               </g:each>
             </select>
  <% } %>
            <g:render template="/frontofficeRequestType/${step.name != 'document' ? requestFo.camelCaseName + '/' : ''}${step.name}" />         
           </div>
           <div class="error" id="stepForm-${step.camelCaseName}-error"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="\${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="\${uuidString}" />
  <% if (step.name == 'validation') { %>
           <input type="submit" id="submit-step-${step.camelCaseName}" name="submit-step-${step.camelCaseName}" value="\${message(code:'action.send')}" \${!isRequestCreatable ? 'disabled=\"disabled\"': ''}/>
           <g:if test="\${!isRequestCreatable}">
           <span><g:message code="request.step.validation.requiredSteps"/></span>
           </g:if>
  <% } else if (step.name != 'document') { %>
           <input type="submit" id="submit-step-${step.camelCaseName}" name="submit-step-${step.camelCaseName}" value="\${message(code:'action.save')}" />
  <% } %>
         </form>
         <div class="navTab">
  <% if (step.index != 0) { %>
           <a id="prev-tab" href="#${requestFo.steps.get(step.index -1).name}"><g:message code="request.step.navigation.previous"/></a>
  <% } %>
  <% if (step.index != requestFo.steps.size() - 1) { %>
           <a id="next-tab" href="#${requestFo.steps.get(step.index + 1).name}"><g:message code="request.step.navigation.next"/></a>
  <% } %>
         </div>
         <g:if test="\${helps.${step.name} != null}">       
         <div class="requestHelp">
           <h3><g:message code="header.help"/></h3>
           \${helps.${step.name}}
         </div>
         </g:if>
       </div>  
<% } %>        
 	    </div><!-- end yui-content -->
    </div><!-- end requestTabView -->
  
  </body>
</html>
