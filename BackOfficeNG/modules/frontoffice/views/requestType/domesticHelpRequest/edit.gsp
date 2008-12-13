
<html>
  <head>
    <meta name="layout" content="fong_main" />
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
       
       <li class="${currentTab == 'tab1' ? 'selected' : ''}">
        <a href="#tab1"><em>
         <span class="tag-no_right">1</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.subject.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'tab2' ? 'selected' : ''}">
        <a href="#tab2"><em>
         <span class="tag-no_right">2</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.familyReferent.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'tab3' ? 'selected' : ''}">
        <a href="#tab3"><em>
         <span class="tag-no_right">3</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.spouse.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'tab4' ? 'selected' : ''}">
        <a href="#tab4"><em>
         <span class="tag-no_right">4</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.dwelling.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'tab5' ? 'selected' : ''}">
        <a href="#tab5"><em>
         <span class="tag-no_right">5</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.resources.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'tab6' ? 'selected' : ''}">
        <a href="#tab6"><em>
         <span class="tag-no_right">6</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="dhr.step.taxes.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'tab7' ? 'selected' : ''}">
        <a href="#tab7"><em>
         <span class="tag-no_right">7</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="request.step.document.label" />

       </em></a>
       </li>    
		  
       <li class="${currentTab == 'tab8' ? 'selected' : ''}">
        <a href="#tab8"><em>
         <span class="tag-no_right">8</span>
         <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete" /></span>

         <g:message code="request.step.validation.label" />

       </em></a>
       </li>    
		 
		 </ul>
		 
     <div class="yui-content">
     
       <div id="tab1">

         <form method="POST" id="subjectForm" action="<g:createLink action="validSubject" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.subject.label" />
             <span><g:message code="dhr.step.subject.desc" /></span>

           </h3>

            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrRequester.label" /></legend>
                
                  <label class="isMadam-trigger "><g:message code="dhr.property.dhrRequesterTitle.label" /> <span><g:message code="dhr.property.dhrRequesterTitle.help" /></span></label>
                  
                    
          <select name="dhrRequesterTitle" class="isMadam-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
              <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == dhr.dhrRequesterTitle ? 'selected="selected"': ''}><g:message code="dhr.property.dhrRequesterTitle.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class=""><g:message code="dhr.property.dhrRequesterFamilyStatus.label" /> <span><g:message code="dhr.property.dhrRequesterFamilyStatus.help" /></span></label>
                  
                    
          <select name="dhrRequesterFamilyStatus" class=" required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
              <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == dhr.dhrRequesterFamilyStatus ? 'selected="selected"': ''}><g:message code="dhr.property.dhrRequesterFamilyStatus.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class=""><g:message code="dhr.property.dhrRequesterName.label" /> <span><g:message code="dhr.property.dhrRequesterName.help" /></span></label>
                  
                    <input name="dhrRequesterName" value="${dhr.dhrRequesterName}" class=" required  validate-lastname" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrRequesterFirstName.label" /> <span><g:message code="dhr.property.dhrRequesterFirstName.help" /></span></label>
                  
                    <input name="dhrRequesterFirstName" value="${dhr.dhrRequesterFirstName}" class=" required  validate-firstname" title="">
                  
                
                  <label class="isMadam-filled "><g:message code="dhr.property.dhrRequesterMaidenName.label" /> <span><g:message code="dhr.property.dhrRequesterMaidenName.help" /></span></label>
                  
                    <input name="dhrRequesterMaidenName" value="${dhr.dhrRequesterMaidenName}" class="isMadam-filled    validate-lastname" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrRequesterBirthDate.label" /> <span><g:message code="dhr.property.dhrRequesterBirthDate.help" /></span></label>
                  
                    <input name="dhrRequesterBirthDate" value="${dhr.dhrRequesterBirthDate}" class=" required  validate-date-au" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrRequesterBirthPlace.label" /> <span><g:message code="dhr.property.dhrRequesterBirthPlace.help" /></span></label>
                  
                    <input name="dhrRequesterBirthPlace" value="${dhr.dhrRequesterBirthPlace}" class=" required  validate-string" title="">
                  
                
                  <label class="isNonEuropean-trigger "><g:message code="dhr.property.dhrRequesterNationality.label" /> <span><g:message code="dhr.property.dhrRequesterNationality.help" /></span></label>
                  
                    
          <select name="dhrRequesterNationality" class="isNonEuropean-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
              <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == dhr.dhrRequesterNationality ? 'selected="selected"': ''}><g:message code="dhr.property.dhrRequesterNationality.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="isNonEuropean-filled "><g:message code="dhr.property.dhrRequesterFranceArrivalDate.label" /> <span><g:message code="dhr.property.dhrRequesterFranceArrivalDate.help" /></span></label>
                  
                    <input name="dhrRequesterFranceArrivalDate" value="${dhr.dhrRequesterFranceArrivalDate}" class="isNonEuropean-filled    validate-date-au" title="">
                  
                
                  <label class="isNonEuropean-filled "><g:message code="dhr.property.dhrRequesterIsFrenchResident.label" /> <span><g:message code="dhr.property.dhrRequesterIsFrenchResident.help" /></span></label>
                  
                    
          <ul class="isNonEuropean-filled ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isNonEuropean-filled   validate-one-required" title="" value="${it}" name="dhrRequesterIsFrenchResident" ${it == dhr.dhrRequesterIsFrenchResident ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                </fieldset>
              
              
            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrRequesterPensionPlan.label" /></legend>
                
                  <label class="isOtherPensionPlan-trigger "><g:message code="dhr.property.dhrPrincipalPensionPlan.label" /> <span><g:message code="dhr.property.dhrPrincipalPensionPlan.help" /></span></label>
                  
                    
          <select name="dhrPrincipalPensionPlan" class="isOtherPensionPlan-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == dhr.dhrPrincipalPensionPlan ? 'selected="selected"': ''}><g:message code="dhr.property.dhrPrincipalPensionPlan.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="isOtherPensionPlan-filled "><g:message code="dhr.property.dhrPensionPlanDetail.label" /> <span><g:message code="dhr.property.dhrPensionPlanDetail.help" /></span></label>
                  
                    <input name="dhrPensionPlanDetail" value="${dhr.dhrPensionPlanDetail}" class="isOtherPensionPlan-filled    validate-string" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrComplementaryPensionPlan.label" /> <span><g:message code="dhr.property.dhrComplementaryPensionPlan.help" /></span></label>
                  
                    <input name="dhrComplementaryPensionPlan" value="${dhr.dhrComplementaryPensionPlan}" class=" required  validate-string" title="">
                  
                
                </fieldset>
              
              
            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrRequesterGuardian.label" /></legend>
                
                  <label class="haveGuardian-trigger "><g:message code="dhr.property.dhrRequesterHaveGuardian.label" /> <span><g:message code="dhr.property.dhrRequesterHaveGuardian.help" /></span></label>
                  
                    
          <ul class="haveGuardian-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="haveGuardian-trigger  required validate-one-required" title="" value="${it}" name="dhrRequesterHaveGuardian" ${it == dhr.dhrRequesterHaveGuardian ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label class="haveGuardian-filled "><g:message code="dhr.property.dhrGuardianMeasure.label" /> <span><g:message code="dhr.property.dhrGuardianMeasure.help" /></span></label>
                  
                    
          <select name="dhrGuardianMeasure" class="haveGuardian-filled   validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
              <option value="fr.cg95.cvq.business.request.social.DhrGuardianMeasureType_${it}" ${it == dhr.dhrGuardianMeasure ? 'selected="selected"': ''}><g:message code="dhr.property.dhrGuardianMeasure.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="haveGuardian-filled "><g:message code="dhr.property.dhrGuardianName.label" /> <span><g:message code="dhr.property.dhrGuardianName.help" /></span></label>
                  
                    <input name="dhrGuardianName" value="${dhr.dhrGuardianName}" class="haveGuardian-filled    validate-lastname" title="">
                  
                
                  <label class="haveGuardian-filled "><g:message code="dhr.property.dhrGuardianAddress.label" /> <span><g:message code="dhr.property.dhrGuardianAddress.help" /></span></label>
                  
                    
          <div class="address-fieldset haveGuardian-filled ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.additionalDeliveryInformation}" maxlength="38" name="dhrGuardianAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.additionalGeographicalInformation}" maxlength="38" name="dhrGuardianAddress.additionalGeographicalInformation"/>
          <label><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrGuardianAddress.streetNumber}" maxlength="5" name="dhrGuardianAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrGuardianAddress.streetName}" maxlength="32" name="dhrGuardianAddress.streetName"/>
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.placeNameOrService}" maxlength="38" name="dhrGuardianAddress.placeNameOrService"/>
          <label><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1" value="${dhr.dhrGuardianAddress.postalCode}" maxlength="5" name="dhrGuardianAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrGuardianAddress.city}" maxlength="32" name="dhrGuardianAddress.city"/>
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrGuardianAddress.countryName}" maxlength="38" name="dhrGuardianAddress.countryName"/>
          </div>
          
                  
                
                </fieldset>
              
              
            
           

           <div class="error" id="subjectFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitSubject" 
              name="submitSubject" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           
           <a href="#tab2" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.subject}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.subject}
           </div>
         </g:if>
       </div>  
     
       <div id="tab2">

         <form method="POST" id="familyReferentForm" action="<g:createLink action="validFamilyReferent" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.familyReferent.label" />
             <span><g:message code="dhr.step.familyReferent.desc" /></span>

           </h3>

            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrFamilyReferent.label" /></legend>
                
                  <label class="haveFamilyReferent-trigger "><g:message code="dhr.property.dhrHaveFamilyReferent.label" /> <span><g:message code="dhr.property.dhrHaveFamilyReferent.help" /></span></label>
                  
                    
          <ul class="haveFamilyReferent-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="haveFamilyReferent-trigger  required validate-one-required" title="" value="${it}" name="dhrHaveFamilyReferent" ${it == dhr.dhrHaveFamilyReferent ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label class="haveFamilyReferent-filled "><g:message code="dhr.property.dhrReferentName.label" /> <span><g:message code="dhr.property.dhrReferentName.help" /></span></label>
                  
                    <input name="dhrReferentName" value="${dhr.dhrReferentName}" class="haveFamilyReferent-filled    validate-lastname" title="">
                  
                
                  <label class="haveFamilyReferent-filled "><g:message code="dhr.property.dhrReferentFirstName.label" /> <span><g:message code="dhr.property.dhrReferentFirstName.help" /></span></label>
                  
                    <input name="dhrReferentFirstName" value="${dhr.dhrReferentFirstName}" class="haveFamilyReferent-filled    validate-firstname" title="">
                  
                
                  <label class="haveFamilyReferent-filled "><g:message code="dhr.property.dhrReferentAddress.label" /> <span><g:message code="dhr.property.dhrReferentAddress.help" /></span></label>
                  
                    
          <div class="address-fieldset haveFamilyReferent-filled ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.additionalDeliveryInformation}" maxlength="38" name="dhrReferentAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.additionalGeographicalInformation}" maxlength="38" name="dhrReferentAddress.additionalGeographicalInformation"/>
          <label><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrReferentAddress.streetNumber}" maxlength="5" name="dhrReferentAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrReferentAddress.streetName}" maxlength="32" name="dhrReferentAddress.streetName"/>
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.placeNameOrService}" maxlength="38" name="dhrReferentAddress.placeNameOrService"/>
          <label><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1" value="${dhr.dhrReferentAddress.postalCode}" maxlength="5" name="dhrReferentAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrReferentAddress.city}" maxlength="32" name="dhrReferentAddress.city"/>
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrReferentAddress.countryName}" maxlength="38" name="dhrReferentAddress.countryName"/>
          </div>
          
                  
                
                </fieldset>
              
              
            
           

           <div class="error" id="familyReferentFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitFamilyReferent" 
              name="submitFamilyReferent" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#tab1" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#tab3" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.familyReferent}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.familyReferent}
           </div>
         </g:if>
       </div>  
     
       <div id="tab3">

         <form method="POST" id="spouseForm" action="<g:createLink action="validSpouse" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.spouse.label" />
             <span><g:message code="dhr.step.spouse.desc" /></span>

           </h3>

            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrSpouse.label" /></legend>
                
                  <label class="isCoupleRequest-trigger "><g:message code="dhr.property.dhrRequestKind.label" /> <span><g:message code="dhr.property.dhrRequestKind.help" /></span></label>
                  
                    
          <ul class="isCoupleRequest-trigger ">
            <g:each in="${['Individual','Couple']}">
            <li>
              <input type="radio" class="isCoupleRequest-trigger  required validate-one-required" title="" value="fr.cg95.cvq.business.request.social.DhrRequestKindType_${it}" name="dhrRequestKind" ${it == dhr.dhrRequestKind.toString() ? 'checked="checked"': ''} />
	            <g:message code="dhr.property.dhrRequestKind.${it}" />  
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label class="isCoupleRequest-filled isSpouseMadam-trigger "><g:message code="dhr.property.dhrSpouseTitle.label" /> <span><g:message code="dhr.property.dhrSpouseTitle.help" /></span></label>
                  
                    
          <select name="dhrSpouseTitle" class="isCoupleRequest-filled isSpouseMadam-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
              <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == dhr.dhrSpouseTitle ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpouseTitle.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="isCoupleRequest-filled "><g:message code="dhr.property.dhrSpouseFamilyStatus.label" /> <span><g:message code="dhr.property.dhrSpouseFamilyStatus.help" /></span></label>
                  
                    
          <select name="dhrSpouseFamilyStatus" class="isCoupleRequest-filled  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
              <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == dhr.dhrSpouseFamilyStatus ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpouseFamilyStatus.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="isCoupleRequest-filled "><g:message code="dhr.property.dhrSpouseName.label" /> <span><g:message code="dhr.property.dhrSpouseName.help" /></span></label>
                  
                    <input name="dhrSpouseName" value="${dhr.dhrSpouseName}" class="isCoupleRequest-filled  required  validate-lastname" title="">
                  
                
                  <label class="isCoupleRequest-filled "><g:message code="dhr.property.dhrSpouseFirstName.label" /> <span><g:message code="dhr.property.dhrSpouseFirstName.help" /></span></label>
                  
                    <input name="dhrSpouseFirstName" value="${dhr.dhrSpouseFirstName}" class="isCoupleRequest-filled  required  validate-firstname" title="">
                  
                
                  <label class="isSpouseMadam-filled "><g:message code="dhr.property.dhrSpouseMaidenName.label" /> <span><g:message code="dhr.property.dhrSpouseMaidenName.help" /></span></label>
                  
                    <input name="dhrSpouseMaidenName" value="${dhr.dhrSpouseMaidenName}" class="isSpouseMadam-filled    validate-lastname" title="">
                  
                
                  <label class="isCoupleRequest-filled "><g:message code="dhr.property.dhrSpouseBirthDate.label" /> <span><g:message code="dhr.property.dhrSpouseBirthDate.help" /></span></label>
                  
                    <input name="dhrSpouseBirthDate" value="${dhr.dhrSpouseBirthDate}" class="isCoupleRequest-filled  required  validate-date-au" title="">
                  
                
                  <label class="isCoupleRequest-filled "><g:message code="dhr.property.dhrSpouseBirthPlace.label" /> <span><g:message code="dhr.property.dhrSpouseBirthPlace.help" /></span></label>
                  
                    <input name="dhrSpouseBirthPlace" value="${dhr.dhrSpouseBirthPlace}" class="isCoupleRequest-filled  required  validate-string" title="">
                  
                
                  <label class="isSpouseNonEuropean-trigger isCoupleRequest-filled "><g:message code="dhr.property.dhrSpouseNationality.label" /> <span><g:message code="dhr.property.dhrSpouseNationality.help" /></span></label>
                  
                    
          <select name="dhrSpouseNationality" class="isSpouseNonEuropean-trigger isCoupleRequest-filled  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
              <option value="fr.cg95.cvq.business.users.NationalityType_${it}" ${it == dhr.dhrSpouseNationality ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpouseNationality.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="isSpouseNonEuropean-filled "><g:message code="dhr.property.dhrSpouseFranceArrivalDate.label" /> <span><g:message code="dhr.property.dhrSpouseFranceArrivalDate.help" /></span></label>
                  
                    <input name="dhrSpouseFranceArrivalDate" value="${dhr.dhrSpouseFranceArrivalDate}" class="isSpouseNonEuropean-filled    validate-date-au" title="">
                  
                
                  <label class="isSpouseNonEuropean-filled "><g:message code="dhr.property.dhrSpouseIsFrenchResident.label" /> <span><g:message code="dhr.property.dhrSpouseIsFrenchResident.help" /></span></label>
                  
                    
          <ul class="isSpouseNonEuropean-filled ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isSpouseNonEuropean-filled   validate-one-required" title="" value="${it}" name="dhrSpouseIsFrenchResident" ${it == dhr.dhrSpouseIsFrenchResident ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                </fieldset>
              
              
            
              
                <fieldset class="isCoupleRequest-filled ">
                <legend><g:message code="dhr.property.dhrSpouseStatus.label" /></legend>
                
                  <label class="isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger "><g:message code="dhr.property.dhrIsSpouseRetired.label" /> <span><g:message code="dhr.property.dhrIsSpouseRetired.help" /></span></label>
                  
                    
          <ul class="isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger  required validate-one-required" title="" value="${it}" name="dhrIsSpouseRetired" ${it == dhr.dhrIsSpouseRetired ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label class="isSpouseRetired-filled isSpouseOtherPensionPlan-trigger "><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.label" /> <span><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.help" /></span></label>
                  
                    
          <select name="dhrSpousePrincipalPensionPlan" class="isSpouseRetired-filled isSpouseOtherPensionPlan-trigger   validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType_${it}" ${it == dhr.dhrSpousePrincipalPensionPlan ? 'selected="selected"': ''}><g:message code="dhr.property.dhrSpousePrincipalPensionPlan.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="isSpouseOtherPensionPlan-filled "><g:message code="dhr.property.dhrSpousePensionPlanDetail.label" /> <span><g:message code="dhr.property.dhrSpousePensionPlanDetail.help" /></span></label>
                  
                    <input name="dhrSpousePensionPlanDetail" value="${dhr.dhrSpousePensionPlanDetail}" class="isSpouseOtherPensionPlan-filled    validate-string" title="">
                  
                
                  <label class="isSpouseRetired-filled "><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.label" /> <span><g:message code="dhr.property.dhrSpouseComplementaryPensionPlan.help" /></span></label>
                  
                    <input name="dhrSpouseComplementaryPensionPlan" value="${dhr.dhrSpouseComplementaryPensionPlan}" class="isSpouseRetired-filled    validate-string" title="">
                  
                
                  <label class="isSpouseRetired-unfilled "><g:message code="dhr.property.dhrSpouseProfession.label" /> <span><g:message code="dhr.property.dhrSpouseProfession.help" /></span></label>
                  
                    <input name="dhrSpouseProfession" value="${dhr.dhrSpouseProfession}" class="isSpouseRetired-unfilled    validate-string" title="">
                  
                
                  <label class="isSpouseRetired-unfilled "><g:message code="dhr.property.dhrSpouseEmployer.label" /> <span><g:message code="dhr.property.dhrSpouseEmployer.help" /></span></label>
                  
                    <input name="dhrSpouseEmployer" value="${dhr.dhrSpouseEmployer}" class="isSpouseRetired-unfilled    validate-string" title="">
                  
                
                  <label class="isSpouseRetired-unfilled "><g:message code="dhr.property.dhrSpouseAddress.label" /> <span><g:message code="dhr.property.dhrSpouseAddress.help" /></span></label>
                  
                    
          <div class="address-fieldset isSpouseRetired-unfilled ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.additionalDeliveryInformation}" maxlength="38" name="dhrSpouseAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.additionalGeographicalInformation}" maxlength="38" name="dhrSpouseAddress.additionalGeographicalInformation"/>
          <label><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrSpouseAddress.streetNumber}" maxlength="5" name="dhrSpouseAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrSpouseAddress.streetName}" maxlength="32" name="dhrSpouseAddress.streetName"/>
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.placeNameOrService}" maxlength="38" name="dhrSpouseAddress.placeNameOrService"/>
          <label><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1" value="${dhr.dhrSpouseAddress.postalCode}" maxlength="5" name="dhrSpouseAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrSpouseAddress.city}" maxlength="32" name="dhrSpouseAddress.city"/>
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrSpouseAddress.countryName}" maxlength="38" name="dhrSpouseAddress.countryName"/>
          </div>
          
                  
                
                </fieldset>
              
              
            
              
                <fieldset class="isCoupleRequest-filled ">
                <legend><g:message code="dhr.property.dhrSpouseIncomes.label" /></legend>
                
                  <label class=""><g:message code="dhr.property.pensions.label" /> <span><g:message code="dhr.property.pensions.help" /></span></label>
                  
                    <input name="pensions" value="${dhr.pensions}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrAllowances.label" /> <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
                  
                    <input name="dhrAllowances" value="${dhr.dhrAllowances}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
                  
                    <input name="dhrFurnitureInvestmentIncome" value="${dhr.dhrFurnitureInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
                  
                    <input name="dhrRealEstateInvestmentIncome" value="${dhr.dhrRealEstateInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrNetIncome.label" /> <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
                  
                    <input name="dhrNetIncome" value="${dhr.dhrNetIncome}" class="   validate-positiveinteger" title="">
                  
                
                </fieldset>
              
              
            
           

           <div class="error" id="spouseFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitSpouse" 
              name="submitSpouse" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#tab2" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#tab4" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.spouse}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.spouse}
           </div>
         </g:if>
       </div>  
     
       <div id="tab4">

         <form method="POST" id="dwellingForm" action="<g:createLink action="validDwelling" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.dwelling.label" />
             <span><g:message code="dhr.step.dwelling.desc" /></span>

           </h3>

            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrCurrentDwelling.label" /></legend>
                
                  <label class=""><g:message code="dhr.property.dhrCurrentDwellingAddress.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingAddress.help" /></span></label>
                  
                    
          <div class="address-fieldset ">
          <label><g:message code="address.property.additionalDeliveryInformation" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.additionalDeliveryInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalDeliveryInformation"/>  
          <label><g:message code="address.property.additionalGeographicalInformation" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.additionalGeographicalInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalGeographicalInformation"/>
          <label><g:message code="address.property.streetNumber" /> - <g:message code="address.property.streetName" /></label>
          <input type="text" class="line1" value="${dhr.dhrCurrentDwellingAddress.streetNumber}" maxlength="5" name="dhrCurrentDwellingAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrCurrentDwellingAddress.streetName}" maxlength="32" name="dhrCurrentDwellingAddress.streetName"/>
          <label><g:message code="address.property.placeNameOrService" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.placeNameOrService}" maxlength="38" name="dhrCurrentDwellingAddress.placeNameOrService"/>
          <label><g:message code="address.property.postalCode" /> - <g:message code="address.property.city" /></label>
          <input type="text" class="line1" value="${dhr.dhrCurrentDwellingAddress.postalCode}" maxlength="5" name="dhrCurrentDwellingAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrCurrentDwellingAddress.city}" maxlength="32" name="dhrCurrentDwellingAddress.city"/>
          <label><g:message code="address.property.countryName" /></label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.countryName}" maxlength="38" name="dhrCurrentDwellingAddress.countryName"/>
          </div>
          
                  
                
                  <label class=""><g:message code="dhr.property.dhrCurrentDwellingPhone.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingPhone.help" /></span></label>
                  
                    <input name="dhrCurrentDwellingPhone" value="${dhr.dhrCurrentDwellingPhone}" class="   validate-phone" title="">
                  
                
                  <label class="isCurrentDwellingPlaceOfResidence-trigger "><g:message code="dhr.property.dhrCurrentDwellingKind.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingKind.help" /></span></label>
                  
                    
          <select name="dhrCurrentDwellingKind" class="isCurrentDwellingPlaceOfResidence-trigger  required validate-not-first" title="">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${['placeOfResidence','retirementHome','other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrDwellingKindType_${it}" ${it == dhr.dhrCurrentDwellingKind ? 'selected="selected"': ''}><g:message code="dhr.property.dhrCurrentDwellingKind.${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label class="isCurrentDwellingPlaceOfResidence-filled "><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingArrivalDate.help" /></span></label>
                  
                    <input name="dhrCurrentDwellingArrivalDate" value="${dhr.dhrCurrentDwellingArrivalDate}" class="isCurrentDwellingPlaceOfResidence-filled    validate-date-au" title="">
                  
                
                  <label class="isCurrentDwellingPlaceOfResidence-filled "><g:message code="dhr.property.dhrCurrentDwellingStatus.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingStatus.help" /></span></label>
                  
                    
          <ul class="isCurrentDwellingPlaceOfResidence-filled ">
            <g:each in="${['owner','tenant']}">
            <li>
              <input type="radio" class="isCurrentDwellingPlaceOfResidence-filled   validate-one-required" title="" value="fr.cg95.cvq.business.request.social.DhrDwellingStatusType_${it}" name="dhrCurrentDwellingStatus" ${it == dhr.dhrCurrentDwellingStatus.toString() ? 'checked="checked"': ''} />
	            <g:message code="dhr.property.dhrCurrentDwellingStatus.${it}" />  
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label class="isCurrentDwellingPlaceOfResidence-filled "><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingNumberOfRoom.help" /></span></label>
                  
                    <input name="dhrCurrentDwellingNumberOfRoom" value="${dhr.dhrCurrentDwellingNumberOfRoom}" class="isCurrentDwellingPlaceOfResidence-filled    " title="">
                  
                
                  <label class="isCurrentDwellingPlaceOfResidence-filled "><g:message code="dhr.property.dhrCurrentDwellingNetArea.label" /> <span><g:message code="dhr.property.dhrCurrentDwellingNetArea.help" /></span></label>
                  
                    <input name="dhrCurrentDwellingNetArea" value="${dhr.dhrCurrentDwellingNetArea}" class="isCurrentDwellingPlaceOfResidence-filled    " title="">
                  
                
                </fieldset>
              
              
            
              
                <label class=""><g:message code="dhr.property.dhrPreviousDwelling.label" /> <span><g:message code="dhr.property.dhrPreviousDwelling.help" /></span></label>
                <pre>TODO -> ON TO MANY</pre>
              
              
            
           

           <div class="error" id="dwellingFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitDwelling" 
              name="submitDwelling" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#tab3" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#tab5" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.dwelling}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.dwelling}
           </div>
         </g:if>
       </div>  
     
       <div id="tab5">

         <form method="POST" id="resourcesForm" action="<g:createLink action="validResources" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.resources.label" />
             <span><g:message code="dhr.step.resources.desc" /></span>

           </h3>

            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrRequesterIncomes.label" /></legend>
                
                  <label class=""><g:message code="dhr.property.pensions.label" /> <span><g:message code="dhr.property.pensions.help" /></span></label>
                  
                    <input name="pensions" value="${dhr.pensions}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrAllowances.label" /> <span><g:message code="dhr.property.dhrAllowances.help" /></span></label>
                  
                    <input name="dhrAllowances" value="${dhr.dhrAllowances}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrFurnitureInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrFurnitureInvestmentIncome.help" /></span></label>
                  
                    <input name="dhrFurnitureInvestmentIncome" value="${dhr.dhrFurnitureInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrRealEstateInvestmentIncome.label" /> <span><g:message code="dhr.property.dhrRealEstateInvestmentIncome.help" /></span></label>
                  
                    <input name="dhrRealEstateInvestmentIncome" value="${dhr.dhrRealEstateInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.dhrNetIncome.label" /> <span><g:message code="dhr.property.dhrNetIncome.help" /></span></label>
                  
                    <input name="dhrNetIncome" value="${dhr.dhrNetIncome}" class="   validate-positiveinteger" title="">
                  
                
                </fieldset>
              
              
            
              
                <label class=""><g:message code="dhr.property.dhrRealAsset.label" /> <span><g:message code="dhr.property.dhrRealAsset.help" /></span></label>
                <pre>TODO -> ON TO MANY</pre>
              
              
            
              
                <label class=""><g:message code="dhr.property.dhrNotRealAsset.label" /> <span><g:message code="dhr.property.dhrNotRealAsset.help" /></span></label>
                <pre>TODO -> ON TO MANY</pre>
              
              
            
           

           <div class="error" id="resourcesFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitResources" 
              name="submitResources" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#tab4" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#tab6" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.resources}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.resources}
           </div>
         </g:if>
       </div>  
     
       <div id="tab6">

         <form method="POST" id="taxesForm" action="<g:createLink action="validTaxes" />">
           <h3>
             <span class="tag-state tag-uncomplete"><g:message code="request.step.state.uncomplete"/></span>

             <g:message code="dhr.step.taxes.label" />
             <span><g:message code="dhr.step.taxes.desc" /></span>

           </h3>

            
              
                <fieldset class="">
                <legend><g:message code="dhr.property.dhrTaxesAmount.label" /></legend>
                
                  <label class=""><g:message code="dhr.property.dhrIncomeTax.label" /> <span><g:message code="dhr.property.dhrIncomeTax.help" /></span></label>
                  
                    <input name="dhrIncomeTax" value="${dhr.dhrIncomeTax}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.localRate.label" /> <span><g:message code="dhr.property.localRate.help" /></span></label>
                  
                    <input name="localRate" value="${dhr.localRate}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.propertyTaxes.label" /> <span><g:message code="dhr.property.propertyTaxes.help" /></span></label>
                  
                    <input name="propertyTaxes" value="${dhr.propertyTaxes}" class="   validate-positiveinteger" title="">
                  
                
                  <label class=""><g:message code="dhr.property.professionalTaxes.label" /> <span><g:message code="dhr.property.professionalTaxes.help" /></span></label>
                  
                    <input name="professionalTaxes" value="${dhr.professionalTaxes}" class="   validate-positiveinteger" title="">
                  
                
                </fieldset>
              
              
            
           

           <div class="error" id="taxesFormErrors"> </div>
           
           <!-- Input submit-->
           <input type="button" 
              id="submitTaxes" 
              name="submitTaxes" 
              value="${message(code:'action.save')}" />
         </form>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#tab5" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#tab7" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.taxes}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.taxes}
           </div>
         </g:if>
       </div>  
     
       <div id="tab7">

         <g:render template="/frontofficeRequestType/documentStep"/>
         
         <!-- navigation link -->
         <div class="navTab">
           
           <a href="#tab6" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
           <a href="#tab8" class="nextTab"><g:message code="request.step.navigation.next"/></a>
         </div>
         
         <g:if test="${help.documentRef}">
           <div class="requestHelp">
             <h3>Aide</h3>
             ${help.documentRef}
           </div>
         </g:if>
       </div>  
     
       <div id="tab8">

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
           
           <a href="#tab7" class="prevTab"><g:message code="request.step.navigation.previous"/></a>
           
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
      	
      	var conditionsName = ["isNonEuropean", "haveFamilyReferent", "isOtherPensionPlan", "isCurrentDwellingPlaceOfResidence", "isRealEstate", "isSpouseRetired", "isSpouseOtherPensionPlan", "isMadam", "isPreviousDwellingPlaceOfResidence", "haveGuardian", "isSpouseNonEuropean", "isCoupleRequest", "isSpouseMadam"];
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
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitSubject");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('subjectFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "subjectForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitFamilyReferent");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('familyReferentFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "familyReferentForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitSpouse");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('spouseFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "spouseForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitDwelling");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('dwellingFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "dwellingForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitResources");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('resourcesFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "resourcesForm");
	  
	  var submitRsrSubjectButton = new YAHOO.widget.Button("submitTaxes");
      submitRsrSubjectButton.on("click", FIC_checkForm, document.getElementById('taxesFormErrors'));
      submitRsrSubjectButton.on("click", onSubmitClick, "taxesForm");
	  
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
