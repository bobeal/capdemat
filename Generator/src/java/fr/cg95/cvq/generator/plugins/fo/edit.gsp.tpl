<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="\${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="\${createLinkTo(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="\${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
  </head>  
  <body>
    <h2 class="request-creation"> <g:message code="${requestFo.acronym}.label" /></h2>
    <p><g:message code="${requestFo.acronym}.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="${requestFo.acronym}.duration.value" /></strong></p>
    <p>
      <g:message code="request.requiredDocuments.header" /> :
      <g:each in="\${documentTypes}" var="documentType" status="index">
        <strong>
          <g:message code="\${documentType.value}"/><g:if test="\${index < documentTypes.size() - 1}">,</g:if>
        </strong>
      </g:each>
    </p>

<g:set var="requestTypeInfo">
  {"label": "\${requestTypeLabel}"
    ,"steps": [ <% requestFo.steps.eachWithIndex { step, i -> %> "${step.name}"${i < requestFo.steps.size() -1 ? ',': ''} <% } %> ]
  }
</g:set>
<g:set var="requestTypeInfo" value="\${requestTypeInfo.encodeAsHTML()}" />

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
          <g:message code="${['validation','document'].contains(step.name) ? 'request' : requestFo.acronym}.step.${step.name}.label" />
          </em></a>
        </li>    
<% } %>
		 </ul>
		 
     <div class="yui-content">
<% requestFo.steps.each { step -> %>
       <div id="${step.name}">
         <form method="POST" id="stepForm-${step.camelCaseName}" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state \${stepStates!= null ? stepStates.${step.name}.cssClass : 'tag-pending'}"><g:message code="\${stepStates != null ? stepStates.${step.name}.i18nKey : 'request.step.state.uncomplete'}" /></span>
             <g:message code="${['validation','document'].contains(step.name) ? 'request' : requestFo.acronym}.step.${step.name}.label" />
             <span><g:message code="${['validation','document'].contains(step.name) ? 'request' : requestFo.acronym}.step.${step.name}.desc" /></span>
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
           <div class="error" id="${step.camelCaseName}FormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" id="requestTypeInfo" name="requestTypeInfo" value="\${requestTypeInfo}" />
           <input type="hidden" name="uuidString" value="\${uuidString}" />
           
           <input type="submit" id="submit-step-${step.camelCaseName}" name="submit-step-${step.camelCaseName}" value="\${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  <% if (step.index != 0) { %>
           <a href="#${requestFo.steps.get(step.index -1).name}" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  <% } %>
  <% if (step.index != requestFo.steps.size() - 1) { %>
           <a href="#${requestFo.steps.get(step.index + 1).name}" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  <% }%>
         </div>       
         <div class="requestHelp">
           <h3>Aide</h3>
           <!-- help -->
         </div>
       </div>  
<% } %>        
 	    </div><!-- end yui-content -->
    </div><!-- end requestTabView -->
  
  </body>
</html>
