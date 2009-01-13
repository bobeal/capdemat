<% import org.apache.commons.lang.StringUtils %>

<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="\${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
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
    
    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">
<% requestFo.steps.each { step -> %>
        <li class="\${currentTab == '${step.name}' ? 'selected' : ''}">
          <a href="#${step.name}"><em>
          <span class="tag-no_right">${step.index + 1}</span>
          <span class="tag-state \${stepStates.${step.name}.cssClass}"><g:message code="\${stepStates.${step.name}.i18nKey}" /></span>
  <% if (step.name == 'documentRef') { %>
          <g:message code="request.step.document.label" />
  <% } else if (step.name == 'validationRef') { %>
          <g:message code="request.step.validation.label" />
  <% } else { %>
          <g:message code="${requestFo.acronym}.step.${step.name}.label" />
  <% } %>
          </em></a>
        </li>    
<% } %>
		 </ul>
		 
     <div class="yui-content">
<% requestFo.steps.each { step -> %>
       <div id="${step.name}">
  <% if (step.name == 'documentRef') { %>
         <g:render template="/frontofficeRequestType/documentStep"/>
  <% } else { %>
         <form method="POST" id="${StringUtils.uncapitalize(step.name)}Form" action="<g:createLink action="valid${StringUtils.capitalize(step.name)}" />">
           <h3>
             <span class="tag-state \${stepStates.${step.name}.cssClass}"><g:message code="\${stepStates.${step.name}.i18nKey}" /></span>
    <% if (step.name == 'validationRef') { %>
             <g:message code="request.step.validation.label" />
             <span><g:message code="request.step.validation.desc" /></span>
    <% } else { %>
             <g:message code="${requestFo.acronym}.step.${step.name}.label" />
             <span><g:message code="${requestFo.acronym}.step.${step.name}.desc" /></span>
    <% } %>
           </h3>
    <% if (step.name == 'validationRef') { %>
           <select name="meansOfContact">
             <g:each in="\${meansOfContact}" var="moc">
               <option value="\${moc.key}">\${moc.label}</option>
             </g:each>
           </select>
           <g:render template="/frontofficeRequestType/${StringUtils.uncapitalize(requestFo.name)}/summary" />
    <% } else { %>
           <g:render template="/frontofficeRequestType/${StringUtils.uncapitalize(requestFo.name)}/${step.name}" />         
    <% } %>
           <div class="error" id="${StringUtils.uncapitalize(step.name)}FormErrors"> </div>
           <!-- Input submit-->
           <input type="button" 
              id="submit${StringUtils.capitalize(step.name)}" 
              name="submit${StringUtils.capitalize(step.name)}" 
              value="\${message(code:'action.save')}" />
         </form>
  <% } %>         
         <!-- navigation link -->
         <div class="navTab">
  <% if (step.index != 0) { %>
           <a href="#${requestFo.steps.get(step.index -1).name}" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  <% } %>
  <% if (step.index != requestFo.steps.size() - 1) { %>
           <a href="#${requestFo.steps.get(step.index + 1).name}" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  <% }%>
         </div>       
         <g:if test="\${help.${step.name}}">
           <div class="requestHelp">
             <h3>Aide</h3>
             \${help.${step.name}}
           </div>
         </g:if>
       </div>  
<% } %>        
 	    </div><!-- end yui-content -->
    </div><!-- end requestTabView -->
  
  </body>
</html>
