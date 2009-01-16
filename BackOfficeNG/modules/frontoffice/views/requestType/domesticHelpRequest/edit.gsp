<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
  </head>  
  <body>
    <h2 class="request-creation"> <g:message code="dhr.label" /></h2>
    <p><g:message code="dhr.description" /></p> 
    <p><g:message code="request.duration.label" /><strong> : <g:message code="dhr.duration.value" /></strong></p>
    <p>
      <g:message code="request.requiredDocuments.header" /> :
      <g:each in="${documentTypes}" var="documentType" status="index">
        <strong>
          <g:message code="${documentType.value}"/><g:if test="${index < documentTypes.size() - 1}">,</g:if>
        </strong>
      </g:each>
    </p>
    
    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">

        <li class="${currentTab == 'subject' ? 'selected' : ''}">
          <a href="#subject"><em>
          <span class="tag-no_right">1</span>
          <span class="tag-state ${stepStates.subject.cssClass}"><g:message code="${stepStates.subject.i18nKey}" /></span>
          <g:message code="dhr.step.subject.label" />
          </em></a>
        </li>    

        <li class="${currentTab == 'familyReferent' ? 'selected' : ''}">
          <a href="#familyReferent"><em>
          <span class="tag-no_right">2</span>
          <span class="tag-state ${stepStates.familyReferent.cssClass}"><g:message code="${stepStates.familyReferent.i18nKey}" /></span>
          <g:message code="dhr.step.familyReferent.label" />
          </em></a>
        </li>    

        <li class="${currentTab == 'spouse' ? 'selected' : ''}">
          <a href="#spouse"><em>
          <span class="tag-no_right">3</span>
          <span class="tag-state ${stepStates.spouse.cssClass}"><g:message code="${stepStates.spouse.i18nKey}" /></span>
          <g:message code="dhr.step.spouse.label" />
          </em></a>
        </li>    

        <li class="${currentTab == 'dwelling' ? 'selected' : ''}">
          <a href="#dwelling"><em>
          <span class="tag-no_right">4</span>
          <span class="tag-state ${stepStates.dwelling.cssClass}"><g:message code="${stepStates.dwelling.i18nKey}" /></span>
          <g:message code="dhr.step.dwelling.label" />
          </em></a>
        </li>    

        <li class="${currentTab == 'resources' ? 'selected' : ''}">
          <a href="#resources"><em>
          <span class="tag-no_right">5</span>
          <span class="tag-state ${stepStates.resources.cssClass}"><g:message code="${stepStates.resources.i18nKey}" /></span>
          <g:message code="dhr.step.resources.label" />
          </em></a>
        </li>    

        <li class="${currentTab == 'taxes' ? 'selected' : ''}">
          <a href="#taxes"><em>
          <span class="tag-no_right">6</span>
          <span class="tag-state ${stepStates.taxes.cssClass}"><g:message code="${stepStates.taxes.i18nKey}" /></span>
          <g:message code="dhr.step.taxes.label" />
          </em></a>
        </li>    

        <li class="${currentTab == 'document' ? 'selected' : ''}">
          <a href="#document"><em>
          <span class="tag-no_right">7</span>
          <span class="tag-state ${stepStates.document.cssClass}"><g:message code="${stepStates.document.i18nKey}" /></span>
          <g:message code="request.step.document.label" />
          </em></a>
        </li>    

        <li class="${currentTab == 'validation' ? 'selected' : ''}">
          <a href="#validation"><em>
          <span class="tag-no_right">8</span>
          <span class="tag-state ${stepStates.validation.cssClass}"><g:message code="${stepStates.validation.i18nKey}" /></span>
          <g:message code="request.step.validation.label" />
          </em></a>
        </li>    

		 </ul>
		 
     <div class="yui-content">

       <div id="subject">
         <form method="POST" id="stepForm-subject" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.subject.cssClass}"><g:message code="${stepStates.subject.i18nKey}" /></span>
             <g:message code="dhr.step.subject.label" />
             <span><g:message code="dhr.step.subject.desc" /></span>
           </h3>
           <div>
    
            <g:render template="/frontofficeRequestType/domesticHelpRequest/subject" />         
           </div>
           <div class="error" id="subjectFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-subject" name="stepSubmit-subject" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
  
           <a href="#familyReferent" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  
         </div>       
         <g:if test="${help.subject}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.subject}
           </div>
         </g:if>
       </div>  

       <div id="familyReferent">
         <form method="POST" id="stepForm-familyReferent" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.familyReferent.cssClass}"><g:message code="${stepStates.familyReferent.i18nKey}" /></span>
             <g:message code="dhr.step.familyReferent.label" />
             <span><g:message code="dhr.step.familyReferent.desc" /></span>
           </h3>
           <div>
    
            <g:render template="/frontofficeRequestType/domesticHelpRequest/familyReferent" />         
           </div>
           <div class="error" id="familyReferentFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-familyReferent" name="stepSubmit-familyReferent" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
           <a href="#subject" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a href="#spouse" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  
         </div>       
         <g:if test="${help.familyReferent}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.familyReferent}
           </div>
         </g:if>
       </div>  

       <div id="spouse">
         <form method="POST" id="stepForm-spouse" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.spouse.cssClass}"><g:message code="${stepStates.spouse.i18nKey}" /></span>
             <g:message code="dhr.step.spouse.label" />
             <span><g:message code="dhr.step.spouse.desc" /></span>
           </h3>
           <div>
    
            <g:render template="/frontofficeRequestType/domesticHelpRequest/spouse" />         
           </div>
           <div class="error" id="spouseFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-spouse" name="stepSubmit-spouse" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
           <a href="#familyReferent" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a href="#dwelling" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  
         </div>       
         <g:if test="${help.spouse}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.spouse}
           </div>
         </g:if>
       </div>  

       <div id="dwelling">
         <form method="POST" id="stepForm-dwelling" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.dwelling.cssClass}"><g:message code="${stepStates.dwelling.i18nKey}" /></span>
             <g:message code="dhr.step.dwelling.label" />
             <span><g:message code="dhr.step.dwelling.desc" /></span>
           </h3>
           <div>
    
            <g:render template="/frontofficeRequestType/domesticHelpRequest/dwelling" />         
           </div>
           <div class="error" id="dwellingFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-dwelling" name="stepSubmit-dwelling" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
           <a href="#spouse" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a href="#resources" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  
         </div>       
         <g:if test="${help.dwelling}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.dwelling}
           </div>
         </g:if>
       </div>  

       <div id="resources">
         <form method="POST" id="stepForm-resources" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.resources.cssClass}"><g:message code="${stepStates.resources.i18nKey}" /></span>
             <g:message code="dhr.step.resources.label" />
             <span><g:message code="dhr.step.resources.desc" /></span>
           </h3>
           <div>
    
            <g:render template="/frontofficeRequestType/domesticHelpRequest/resources" />         
           </div>
           <div class="error" id="resourcesFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-resources" name="stepSubmit-resources" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
           <a href="#dwelling" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a href="#taxes" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  
         </div>       
         <g:if test="${help.resources}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.resources}
           </div>
         </g:if>
       </div>  

       <div id="taxes">
         <form method="POST" id="stepForm-taxes" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.taxes.cssClass}"><g:message code="${stepStates.taxes.i18nKey}" /></span>
             <g:message code="dhr.step.taxes.label" />
             <span><g:message code="dhr.step.taxes.desc" /></span>
           </h3>
           <div>
    
            <g:render template="/frontofficeRequestType/domesticHelpRequest/taxes" />         
           </div>
           <div class="error" id="taxesFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-taxes" name="stepSubmit-taxes" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
           <a href="#resources" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a href="#document" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  
         </div>       
         <g:if test="${help.taxes}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.taxes}
           </div>
         </g:if>
       </div>  

       <div id="document">
         <form method="POST" id="stepForm-document" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.document.cssClass}"><g:message code="${stepStates.document.i18nKey}" /></span>
             <g:message code="request.step.document.label" />
             <span><g:message code="request.step.document.desc" /></span>
           </h3>
           <div>
    
            <g:render template="/frontofficeRequestType/document" />         
           </div>
           <div class="error" id="documentFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-document" name="stepSubmit-document" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
           <a href="#taxes" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  
  
           <a href="#validation" class="nextTab"><g:message code="request.step.navigation.next"/></a>
  
         </div>       
         <g:if test="${help.document}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.document}
           </div>
         </g:if>
       </div>  

       <div id="validation">
         <form method="POST" id="stepForm-validation" action="<g:createLink action="step" />">
           <h3>
             <span class="tag-state ${stepStates.validation.cssClass}"><g:message code="${stepStates.validation.i18nKey}" /></span>
             <g:message code="request.step.validation.label" />
             <span><g:message code="request.step.validation.desc" /></span>
           </h3>
           <div>
    
             <select name="meansOfContact">
               <g:each in="${meansOfContact}" var="moc">
                 <option value="${moc.key}">${moc.label}</option>
               </g:each>
             </select>
    
            <g:render template="/frontofficeRequestType/domesticHelpRequest/validation" />         
           </div>
           <div class="error" id="validationFormErrors"> </div>
           <!-- Input submit-->
           <input type="hidden" name="requestTypeLabel" value="${requestTypeLabel}" />
           <input type="submit" id="stepSubmit-validation" name="stepSubmit-validation" value="${message(code:'action.save')}" />
         </form>

         <!-- navigation link -->
         <div class="navTab">
  
           <a href="#document" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
  
  
         </div>       
         <g:if test="${help.validation}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.validation}
           </div>
         </g:if>
       </div>  
        
 	    </div><!-- end yui-content -->
    </div><!-- end requestTabView -->
  
  </body>
</html>
