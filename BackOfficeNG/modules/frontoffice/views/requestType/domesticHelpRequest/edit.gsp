

<html>
  <head>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/frontoffice', file:'request.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
  </head>  
  <body>
      <h2 class="request-creation">
      <g:message code="dhr.label" />
      <span><g:message code="dhr.description" /></span> 
      <span><g:message code="request.duration.label" /><strong> : <g:message code="dhr.duration.value" /></strong></span>
      <span>
        <g:message code="request.requiredDocuments.header" /> :
        <g:each in="${documentTypes}" var="documentType" status="index">
          <strong>
            <g:message code="${documentType.value}"/><g:if test="${index < documentTypes.size() - 1}">,</g:if>
          </strong>
        </g:each>
      </span>
    </h2>
    
    <div id="requestTabView" class="yui-navset">
      <ul class="yui-nav">
       
       <li class="${currentTab == 'subject' ? 'selected' : ''}">
        <a href="#subject"><em>
         <span class="tag-no_right">1</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.subject.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'familyReferent' ? 'selected' : ''}">
        <a href="#familyReferent"><em>
         <span class="tag-no_right">2</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.familyReferent.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'spouse' ? 'selected' : ''}">
        <a href="#spouse"><em>
         <span class="tag-no_right">3</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.spouse.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'dwelling' ? 'selected' : ''}">
        <a href="#dwelling"><em>
         <span class="tag-no_right">4</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.dwelling.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'resources' ? 'selected' : ''}">
        <a href="#resources"><em>
         <span class="tag-no_right">5</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.resources.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'taxes' ? 'selected' : ''}">
        <a href="#taxes"><em>
         <span class="tag-no_right">6</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.taxes.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'documentRef' ? 'selected' : ''}">
        <a href="#documentRef"><em>
         <span class="tag-no_right">7</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="request.step.document.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'validationRef' ? 'selected' : ''}">
        <a href="#validationRef"><em>
         <span class="tag-no_right">8</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="request.step.validation.label" />

       </em></a>
       </li>    
		 
		 </ul>
		 
     <div class="yui-content">
     
       <div id="subject">

         <form method="POST" id="subjectForm" action="<g:createLink action="validSubject" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.subject.label" />
             <span><g:message code="dhr.step.subject.desc" /></span>

           </h3>

            <g:render template="/frontofficeRequestType/domesticHelpRequest/subject" />         

           <div class="error" id="subjectFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitSubject" 
              name="submitSubject" 
              value="${message(code:'action.save')}" />
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

         <form method="POST" id="familyReferentForm" action="<g:createLink action="validFamilyReferent" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.familyReferent.label" />
             <span><g:message code="dhr.step.familyReferent.desc" /></span>

           </h3>

            <g:render template="/frontofficeRequestType/domesticHelpRequest/familyReferent" />         

           <div class="error" id="familyReferentFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitFamilyReferent" 
              name="submitFamilyReferent" 
              value="${message(code:'action.save')}" />
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

         <form method="POST" id="spouseForm" action="<g:createLink action="validSpouse" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.spouse.label" />
             <span><g:message code="dhr.step.spouse.desc" /></span>

           </h3>

            <g:render template="/frontofficeRequestType/domesticHelpRequest/spouse" />         

           <div class="error" id="spouseFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitSpouse" 
              name="submitSpouse" 
              value="${message(code:'action.save')}" />
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

         <form method="POST" id="dwellingForm" action="<g:createLink action="validDwelling" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.dwelling.label" />
             <span><g:message code="dhr.step.dwelling.desc" /></span>

           </h3>

            <g:render template="/frontofficeRequestType/domesticHelpRequest/dwelling" />         

           <div class="error" id="dwellingFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitDwelling" 
              name="submitDwelling" 
              value="${message(code:'action.save')}" />
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

         <form method="POST" id="resourcesForm" action="<g:createLink action="validResources" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.resources.label" />
             <span><g:message code="dhr.step.resources.desc" /></span>

           </h3>

            <g:render template="/frontofficeRequestType/domesticHelpRequest/resources" />         

           <div class="error" id="resourcesFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitResources" 
              name="submitResources" 
              value="${message(code:'action.save')}" />
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

         <form method="POST" id="taxesForm" action="<g:createLink action="validTaxes" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.taxes.label" />
             <span><g:message code="dhr.step.taxes.desc" /></span>

           </h3>

            <g:render template="/frontofficeRequestType/domesticHelpRequest/taxes" />         

           <div class="error" id="taxesFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitTaxes" 
              name="submitTaxes" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#resources" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#documentRef" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.taxes}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.taxes}
           </div>
         </g:if>
       </div>  
     
       <div id="documentRef">

         <g:render template="/frontofficeRequestType/documentStep"/>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#taxes" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#validationRef" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.documentRef}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.documentRef}
           </div>
         </g:if>
       </div>  
     
       <div id="validationRef">

         <form method="POST" id="validationRefForm" action="<g:createLink action="validValidationRef" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="request.step.validation.label" />
             <span><g:message code="request.step.validation.desc" /></span>

           </h3>

           <!-- render template of final summary -->
             
           <!-- render means of contact selection list -->
           <select name="meansOfContact">
             <g:each in="${meansOfContact}" var="moc">
               <option value="${moc.key}">${moc.label}</option>
             </g:each>
           </select>
           
           <g:render template="/frontofficeRequestType/domesticHelpRequest/summary" />

           <div class="error" id="validationRefFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitValidationRef" 
              name="submitValidationRef" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#documentRef" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
         </div>
         
         <g:if test="${help.validationRef}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.validationRef}
           </div>
         </g:if>
       </div>  
             
 	 </div><!-- end yui-content -->
 </div><!-- end requestTabView -->
 	  
    <script type="text/javascript">
      // next Links
      var activeNextTabByLink = function(e) {
	      YAHOO.util.Event.preventDefault(e);
        var requestFormTabView = new YAHOO.widget.TabView('requestTabView');
	      var activeTabIndex = requestFormTabView.get('activeIndex');
	      requestFormTabView.set('activeIndex' , activeTabIndex + 1);
      }
      
      YAHOO.util.Event.addListener(
          YAHOO.util.Dom.getElementsByClassName("nextTab", "a" ),
          "click", 
          activeNextTabByLink
      );
      
      // prev Links
      var activePrevTabByLink = function(e) {
	      YAHOO.util.Event.preventDefault(e);
        var requestFormTabView = new YAHOO.widget.TabView('requestTabView');
	      var activeTabIndex = requestFormTabView.get('activeIndex');
	      requestFormTabView.set('activeIndex' , activeTabIndex - 1);
      }
      
      YAHOO.util.Event.addListener(
          YAHOO.util.Dom.getElementsByClassName("prevTab", "a" ),
          "click", 
          activePrevTabByLink
      );

 	  function checkAllConditions() {
      	
      	var conditionsName = ["isNonEuropean", "isOtherPensionPlan", "isCurrentDwellingPlaceOfResidence", "haveFamilyReferent", "isRealEstate", "isSpouseRetired", "isSpouseOtherPensionPlan", "isMadam", "isPreviousDwellingPlaceOfResidence", "haveGuardian", "isSpouseNonEuropean", "isCoupleRequest", "isSpouseMadam"];
        Condition.checkConditions(conditionsName, "domesticHelpRequest");
      }
      
      function conditionChange(e) {
      	Condition.change(this.className, "domesticHelpRequest");
      }
      
      // CONDITION TRIGGER
	    YAHOO.util.Event.addListener(
          YAHOO.util.Dom.getElementsByClassName("*trigger", "select" ),
          "change", 
          conditionChange
        );
          
      // CONDITION TRIGGER
	    YAHOO.util.Event.addListener(
          YAHOO.util.Dom.getElementsByClassName("*trigger", "input" ),
          "change", 
          conditionChange
        );
         
	  YAHOO.util.Event.onDOMReady(checkAllConditions);
	  
	  // VALIDATION
	  
	  var submitSubjectButton = new YAHOO.widget.Button("submitSubject");
      submitSubjectButton.on("click", FIC_checkForm, document.getElementById('subjectFormErrors'));
      submitSubjectButton.on("click", onSubmitClick, "subjectForm");
	  
	  var submitFamilyReferentButton = new YAHOO.widget.Button("submitFamilyReferent");
      submitFamilyReferentButton.on("click", FIC_checkForm, document.getElementById('familyReferentFormErrors'));
      submitFamilyReferentButton.on("click", onSubmitClick, "familyReferentForm");
	  
	  var submitSpouseButton = new YAHOO.widget.Button("submitSpouse");
      submitSpouseButton.on("click", FIC_checkForm, document.getElementById('spouseFormErrors'));
      submitSpouseButton.on("click", onSubmitClick, "spouseForm");
	  
	  var submitDwellingButton = new YAHOO.widget.Button("submitDwelling");
      submitDwellingButton.on("click", FIC_checkForm, document.getElementById('dwellingFormErrors'));
      submitDwellingButton.on("click", onSubmitClick, "dwellingForm");
	  
	  var submitResourcesButton = new YAHOO.widget.Button("submitResources");
      submitResourcesButton.on("click", FIC_checkForm, document.getElementById('resourcesFormErrors'));
      submitResourcesButton.on("click", onSubmitClick, "resourcesForm");
	  
	  var submitTaxesButton = new YAHOO.widget.Button("submitTaxes");
      submitTaxesButton.on("click", FIC_checkForm, document.getElementById('taxesFormErrors'));
      submitTaxesButton.on("click", onSubmitClick, "taxesForm");
	  
	  var submitDocumentRefButton = new YAHOO.widget.Button("submitDocumentRef");
      submitDocumentRefButton.on("click", FIC_checkForm, document.getElementById('documentRefFormErrors'));
      submitDocumentRefButton.on("click", onSubmitClick, "documentRefForm");
	  
	  var submitValidationRefButton = new YAHOO.widget.Button("submitValidationRef");
      submitValidationRefButton.on("click", FIC_checkForm, document.getElementById('validationRefFormErrors'));
      submitValidationRefButton.on("click", onSubmitClick, "validationRefForm");
	  
	  
	  function onSubmitClick(ev, formId) {
        document.getElementById(formId).submit();
	  }
	  
	  function resetFormErrors(formErrors) { 
		YAHOO.util.Dom.get(formErrors).innerHTML = '';
	  }
	  
    // Request TabView Initialization
    function initRequest() {
      var requestFormTabView = new YAHOO.widget.TabView('requestTabView');
    }

    YAHOO.util.Event.onDOMReady(initRequest);
   </script>

  </body>
</html>
