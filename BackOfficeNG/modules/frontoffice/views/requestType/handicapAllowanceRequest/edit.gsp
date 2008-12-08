
<html>
  <head>
    <meta name="layout" content="fong_main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
  </head>  
  <body>
      <h2 class="request-creation">
<!--      <a href="#" id="requestSubmit">envoyer</a>-->
      <g:render template="/frontofficeRequestType/widget/requestDesc" model="[requestType: har]"/> 
      <span><g:message code="har.duration.label" /><strong><g:message code="har.duration.value" /></strong></span>
      <span>
        Documents à fournir :
        <strong>Pièce d'identité</strong>, 
        <strong class="mandatory">Livret de famille</strong>
      </span>
    </h2>
  <div id="yui-main"> 
    <div id="main" class="yui-b">
       <div id="requestTabView" class="yui-navset">
         <ul class="yui-nav">
          
         <li class="${currentTab == 'tab1' ? 'selected' : ''}"><a href="#tab1"><em>
             <span class="tag-no_right">1</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.subject.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab2' ? 'selected' : ''}"><a href="#tab2"><em>
             <span class="tag-no_right">2</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.dwelling.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab3' ? 'selected' : ''}"><a href="#tab3"><em>
             <span class="tag-no_right">3</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.socialSecurity.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab4' ? 'selected' : ''}"><a href="#tab4"><em>
             <span class="tag-no_right">4</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.position.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab5' ? 'selected' : ''}"><a href="#tab5"><em>
             <span class="tag-no_right">5</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.handicapKind.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab6' ? 'selected' : ''}"><a href="#tab6"><em>
             <span class="tag-no_right">6</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.followup.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab7' ? 'selected' : ''}"><a href="#tab7"><em>
             <span class="tag-no_right">7</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.project.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab8' ? 'selected' : ''}"><a href="#tab8"><em>
             <span class="tag-no_right">8</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.documentRef.label" />
           </em></a></li>
         
		  
         <li class="${currentTab == 'tab9' ? 'selected' : ''}"><a href="#tab9"><em>
             <span class="tag-no_right">9</span>
             <span class="tag-rejected"><g:message code="har.step.tag.rejected.short" /></span>
             <g:message code="har.step.validationRef.label" />
           </em></a></li>
         
		 
		 </ul>
         <div class="yui-content">
         
           <div id="tab1">
             <form method="POST" id="subjectForm" action="<g:createLink action="validSubject" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.subject.label" />
                 <span><g:message code="har.step.subject.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/subject" /> 
               
               <div class="error" id="subjectFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitSubject" 
		           name="submitSubject" 
		           value="<g:message code='har.step.subject.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               
               <a href="#tab2" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab2">
             <form method="POST" id="dwellingForm" action="<g:createLink action="validDwelling" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.dwelling.label" />
                 <span><g:message code="har.step.dwelling.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/dwelling" /> 
               
               <div class="error" id="dwellingFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitDwelling" 
		           name="submitDwelling" 
		           value="<g:message code='har.step.dwelling.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab1" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
               <a href="#tab3" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab3">
             <form method="POST" id="socialSecurityForm" action="<g:createLink action="validSocialSecurity" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.socialSecurity.label" />
                 <span><g:message code="har.step.socialSecurity.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/socialSecurity" /> 
               
               <div class="error" id="socialSecurityFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitSocialSecurity" 
		           name="submitSocialSecurity" 
		           value="<g:message code='har.step.socialSecurity.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab2" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
               <a href="#tab4" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab4">
             <form method="POST" id="positionForm" action="<g:createLink action="validPosition" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.position.label" />
                 <span><g:message code="har.step.position.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/position" /> 
               
               <div class="error" id="positionFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitPosition" 
		           name="submitPosition" 
		           value="<g:message code='har.step.position.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab3" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
               <a href="#tab5" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab5">
             <form method="POST" id="handicapKindForm" action="<g:createLink action="validHandicapKind" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.handicapKind.label" />
                 <span><g:message code="har.step.handicapKind.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/handicapKind" /> 
               
               <div class="error" id="handicapKindFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitHandicapKind" 
		           name="submitHandicapKind" 
		           value="<g:message code='har.step.handicapKind.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab4" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
               <a href="#tab6" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab6">
             <form method="POST" id="followupForm" action="<g:createLink action="validFollowup" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.followup.label" />
                 <span><g:message code="har.step.followup.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/followup" /> 
               
               <div class="error" id="followupFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitFollowup" 
		           name="submitFollowup" 
		           value="<g:message code='har.step.followup.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab5" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
               <a href="#tab7" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab7">
             <form method="POST" id="projectForm" action="<g:createLink action="validProject" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.project.label" />
                 <span><g:message code="har.step.project.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/project" /> 
               
               <div class="error" id="projectFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitProject" 
		           name="submitProject" 
		           value="<g:message code='har.step.project.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab6" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
               <a href="#tab8" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab8">
             <form method="POST" id="documentRefForm" action="<g:createLink action="validDocumentRef" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.documentRef.label" />
                 <span><g:message code="har.step.documentRef.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/documentRef" /> 
               
               <div class="error" id="documentRefFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitDocumentRef" 
		           name="submitDocumentRef" 
		           value="<g:message code='har.step.documentRef.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab7" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
               <a href="#tab9" class="nextTab"><g:message code="har.step.navigation.next"/></a>
             </div>
           </div>  
         
           <div id="tab9">
             <form method="POST" id="validationRefForm" action="<g:createLink action="validValidationRef" />">
               <h3>
                 <span class="tag-rejected"><g:message code="har.step.tag.rejected"/></span>
                 <g:message code="har.step.validationRef.label" />
                 <span><g:message code="har.step.validationRef.desc" /></span>
               </h3>
               
               <g:render template="/frontofficeRequestType/handicapAllowanceRequest/steps/validationRef" /> 
               
               <div class="error" id="validationRefFormErrors"> </div>
               
               <!-- Input submit-->
               <input type="button"
                   id="submitValidationRef" 
		           name="submitValidationRef" 
		           value="<g:message code='har.step.validationRef.submitLabel'/>" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               
               <a href="#tab8" class="prevTab"><g:message code="har.step.navigation.previous"/></a>
               
             </div>
           </div>  
                 
       	 </div><!-- end yui-content -->
       </div><!-- end requestTabView -->
 	  
<div class="helpBox">
        <h3>Aide</h3>
        <dl>
          <dt>Sujet</dt>
          <dd>
            Afin d'améliorer la communication et les échanges et de favoriser la participation 
            et la contribution, le projet CapDémat se dote de nouveaux moyens de discussion
          </dd>
          <dt>Documents</dt>
          <dd>
            Afin d'améliorer la communication et les échanges et de favoriser la participation 
          </dd>
          <dt>Formulaire</dt>
          <dd>
             et la contribution, le projet CapDémat se dote de nouveaux moyens de discussion
            Afin d'améliorer la communication et les échanges et de favoriser la participation
          </dd>
          <dt>Moyen de contact</dt>
          <dd>
            de favoriser la participation 
            et la contribution, le projet CapDémat se dote de nouveaux moyens de discussion
          </dd>
        </dl>
      </div>
     
     </div> <!-- end main -->
    </div> <!-- end yui-main -->

    <div id="narrow" class="yui-b">
      
      <div id="requestSubject" class="requestBox">
        <h3>
          <span class="tag-validated">v</span>
          <em>Sujet de la demande</em>
        </h3>
        <div class="body">
          <strong>M. Hervé Martin</strong>
          <a href="#">choisir un autre sujet</a>
        </div>
      </div>
      
      <div id="requestMeansOfContact" class="requestBox">
        <h3>
          <em>Moyen de contact</em>
        </h3>
        <div class="body">
          <form action="#">
            <select name="requestMeansOfContactSelect">
              <option>Courriel</option>
              <option>Téléphone</option>
              <option>Courrier</option>
              <option>SMS</option>
              <option>Mobile</option>
            </select>
          </form>
        </div>
      </div>
     
      <div id="requestDocument" class="requestBox">
        <h3>
          <span class="tag-rejected">r</span>
          <em>Documents à fournir</em>
        </h3>
        <div class="body">
          <ul>
            <li>
              <span class="tag-rejected">r</span> 
              <a href="#"><strong>Pièce d'identité</strong></a>
            </li>
            <li>
              <span class="tag-validated">v</span> 
              <a href="#"><strong>Livret de famille</strong></a>
            </li>
          </ul>
        </div>
      </div>
    
      <!-- 
      <div class="nobox">
        <h3>Broullons</h3>
        <ul>
         <li><span class="tag-validated">complet</span>Demande d'assistance à distance </li>
         <li><span class="tag-validated">complet</span>Inscription scolair</li>
         <li><span class="tag-pending">partiel</span>Inscription à la cantine scolaire</li>
        </ul>
      </div>
      -->
      
      <!--
      <h3>Denières demandes</h3>
      <ul>
       <li><span class="tag-pending">traitée</span>Demande d'assistance à distance - 12/08/2008</li>
       <li><span class="tag-validated">validée</span>Inscription scolair - 10/08/2008</li>
       <li><span class="tag-rejected">annulée</span>Inscription à la cantine scolaire - 10/08/2008</li>
      </ul>

      <h3>Documents</h3>
      <ul>
       <li>Carte d'identité - rafik</li>
       <li>Passeport - superman</li>
       <li>Lvret de famille - Zenexity</li>
       <li>Justificatif de domocile - rue Taitbout</li>
      </ul>

      <h3>Compte famille</h3>
      <ul>
       <li>Rafik DJEJDIG - 10/10/1910</li>
       <li>Rafik DJEJDIG - 10/10/1910</li>
       <li>Rafik DJEJDIG - 10/10/1910</li>
       <li>Rafik DJEJDIG - 10/10/1910</li>
      </ul>
      -->     
    </div><!-- end of narrow -->
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
      	
      	var conditionsName = ["isFamilyCarer", "isSentToSchool", "isCarer", "isAccompaniedHomeSchooling", "isElectiveFunction", "haveActivityReduction", "isDwellingPlaceOfResidence", "isTechnicalAssistance", "haveLegalAccessPresence", "isEmployer", "isInEstablishmentReception", "isIndemnified", "isUnemployed", "isAssistanceUnderDisability", "isDisabilityRecognition", "isWorkAccidentAnnuity", "isRegisteredAsUnemployed", "isOtherCarer", "haveFamilyDependent", "isAdditionalAllocationForEducationOfDisabledChildren", "isSupportedByAnInstitution", "isProfessionalOrientationRequest", "isReferentMadam", "isOtherRequest", "havePaymentAgencyBeneficiary", "isHighSchool", "isAnimalAid", "haveSocialSecurityMemberShip", "isCustomCar", "isOtherLegalAccessRepresentative", "isDisabilityPension", "isFollowUp", "isCDES", "isEmployed", "isLessThan20", "isCareAssistant", "isSchoolingEnrolment", "isRequesterMadam", "isFollowedByProfessional", "isAdult", "isCOTOREP", "isHousingFacilities", "isProfessionalEvaluation", "isProfessionalOrientation", "isSpecializedGrade", "isInSocialReception", "isPartTimeSchooling", "isMDPH", "isSpecializedTransport", "isFollowedByPhysician", "isFollowedByHospital", "isLessThan18"];
        Condition.checkConditions(conditionsName, "handicapAllowanceRequest");
      }
      
      function conditionChange(e) {
      	Condition.change(this.className, "handicapAllowanceRequest");
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
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitSubject");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('subjectFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "subjectForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitDwelling");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('dwellingFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "dwellingForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitSocialSecurity");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('socialSecurityFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "socialSecurityForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitPosition");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('positionFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "positionForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitHandicapKind");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('handicapKindFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "handicapKindForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitFollowup");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('followupFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "followupForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitProject");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('projectFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "projectForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitDocumentRef");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('documentRefFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "documentRefForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitValidationRef");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('validationRefFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "validationRefForm");
	  
	  
	  function onSubmitClick(ev, formId) {
		zenexity.capdemat.common.doAjaxFormSubmitCall(formId ,null,  
		function(o) {
		     if (o.status == "200")
		     	resetFormErrors(formId + "Errors");
		});
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
