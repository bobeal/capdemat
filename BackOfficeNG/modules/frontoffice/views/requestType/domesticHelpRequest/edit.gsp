
<html>
  <head>
    <meta name="layout" content="fong_main" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/frontoffice',file:'condition.js')}"></script>
  </head>  
  <body>
      <h2 class="request-creation">
      <g:message code="dhr.label" /> 
      <span><g:message code="dhr.duration.label" /><strong><g:message code="dhr.duration.value" /></strong></span>
      <span>
        Documents à fournir :
        <g:each in="${documentTypes}" var="documentType" status="index">
          <strong>
            <g:message code="${documentType.value}"/>
            <g:if test="${index < documentTypes.size() - 1}">,</g:if>
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

            
            
              
                <fieldset>
                <legend>dhrRequester</legend>
                
                  <label>dhrRequesterTitle</label>
                  
                    
          <select name="dhrRequesterTitle" class="isMadam-trigger  required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
              <option value="fr.cg95.cvq.business.users.DhrRequesterTitle_${it}" ${it == dhr.dhrRequesterTitle ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrRequesterFamilyStatus</label>
                  
                    
          <select name="dhrRequesterFamilyStatus" class=" required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
              <option value="fr.cg95.cvq.business.users.DhrRequesterFamilyStatus_${it}" ${it == dhr.dhrRequesterFamilyStatus ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrRequesterName</label>
                  
                    <input name="dhrRequesterName" value="${dhr.dhrRequesterName}" class=" required  validate-lastname" title="">
                  
                
                  <label>dhrRequesterFirstName</label>
                  
                    <input name="dhrRequesterFirstName" value="${dhr.dhrRequesterFirstName}" class=" required  validate-firstname" title="">
                  
                
                  <label>dhrRequesterMaidenName</label>
                  
                    <input name="dhrRequesterMaidenName" value="${dhr.dhrRequesterMaidenName}" class="isMadam-filled    validate-lastname" title="">
                  
                
                  <label>dhrRequesterBirthDate</label>
                  
                    <input name="dhrRequesterBirthDate" value="${dhr.dhrRequesterBirthDate}" class=" required  validate-date-au" title="">
                  
                
                  <label>dhrRequesterBirthPlace</label>
                  
                    <input name="dhrRequesterBirthPlace" value="${dhr.dhrRequesterBirthPlace}" class=" required  validate-string" title="">
                  
                
                  <label>dhrRequesterNationality</label>
                  
                    
          <select name="dhrRequesterNationality" class="isNonEuropean-trigger  required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
              <option value="fr.cg95.cvq.business.users.DhrRequesterNationality_${it}" ${it == dhr.dhrRequesterNationality ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrRequesterFranceArrivalDate</label>
                  
                    <input name="dhrRequesterFranceArrivalDate" value="${dhr.dhrRequesterFranceArrivalDate}" class="isNonEuropean-filled    validate-date-au" title="">
                  
                
                  <label>dhrRequesterIsFrenchResident</label>
                  
                    
          <ul class="isNonEuropean-filled ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isNonEuropean-filled   validate-one-required" title="" value="${it}" name="dhrRequesterIsFrenchResident" ${it == dhr.dhrRequesterIsFrenchResident ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                </fieldset>
              
              
            
            
              
                <fieldset>
                <legend>dhrRequesterPensionPlan</legend>
                
                  <label>dhrPrincipalPensionPlan</label>
                  
                    
          <select name="dhrPrincipalPensionPlan" class="isOtherPensionPlan-trigger  required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlan_${it}" ${it == dhr.dhrPrincipalPensionPlan ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrPensionPlanDetail</label>
                  
                    <input name="dhrPensionPlanDetail" value="${dhr.dhrPensionPlanDetail}" class="isOtherPensionPlan-filled    validate-string" title="">
                  
                
                  <label>dhrComplementaryPensionPlan</label>
                  
                    <input name="dhrComplementaryPensionPlan" value="${dhr.dhrComplementaryPensionPlan}" class=" required  validate-string" title="">
                  
                
                </fieldset>
              
              
            
            
              
                <fieldset>
                <legend>dhrRequesterGuardian</legend>
                
                  <label>dhrRequesterHaveGuardian</label>
                  
                    
          <ul class="haveGuardian-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="haveGuardian-trigger  required validate-one-required" title="" value="${it}" name="dhrRequesterHaveGuardian" ${it == dhr.dhrRequesterHaveGuardian ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label>dhrGuardianMeasure</label>
                  
                    
          <select name="dhrGuardianMeasure" class="haveGuardian-filled   validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['safeguardingJustice','guardianship','curatorship']}">
              <option value="fr.cg95.cvq.business.request.social.DhrGuardianMeasure_${it}" ${it == dhr.dhrGuardianMeasure ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrGuardianName</label>
                  
                    <input name="dhrGuardianName" value="${dhr.dhrGuardianName}" class="haveGuardian-filled    validate-lastname" title="">
                  
                
                  <label>dhrGuardianAddress</label>
                  
                    
          <div class="address-fieldset haveGuardian-filled ">
          <label>additional delivery information</label>
          <input type="text" value="${dhr.dhrGuardianAddress.additionalDeliveryInformation}" maxlength="38" name="dhrGuardianAddress.additionalDeliveryInformation"/>  
          <label>additional geographical information</label>
          <input type="text" value="${dhr.dhrGuardianAddress.additionalGeographicalInformation}" maxlength="38" name="dhrGuardianAddress.additionalGeographicalInformation"/>
          <label> street number - street name</label>
          <input type="text" class="line1" value="${dhr.dhrGuardianAddress.streetNumber}" maxlength="5" name="dhrGuardianAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrGuardianAddress.streetName}" maxlength="32" name="dhrGuardianAddress.streetName"/>
          <label>place name or service</label>    
          <input type="text" value="${dhr.dhrGuardianAddress.placeNameOrService}" maxlength="38" name="dhrGuardianAddress.placeNameOrService"/>
          <label> postal code - city </label>
          <input type="text" class="line1" value="${dhr.dhrGuardianAddress.postalCode}" maxlength="5" name="dhrGuardianAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrGuardianAddress.city}" maxlength="32" name="dhrGuardianAddress.city"/>
          <label>country name</label>
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

            
            
              
                <fieldset>
                <legend>dhrFamilyReferent</legend>
                
                  <label>dhrHaveFamilyReferent</label>
                  
                    
          <ul class="haveFamilyReferent-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="haveFamilyReferent-trigger  required validate-one-required" title="" value="${it}" name="dhrHaveFamilyReferent" ${it == dhr.dhrHaveFamilyReferent ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label>dhrReferentName</label>
                  
                    <input name="dhrReferentName" value="${dhr.dhrReferentName}" class="haveFamilyReferent-filled    validate-lastname" title="">
                  
                
                  <label>dhrReferentFirstName</label>
                  
                    <input name="dhrReferentFirstName" value="${dhr.dhrReferentFirstName}" class="haveFamilyReferent-filled    validate-firstname" title="">
                  
                
                  <label>dhrReferentAddress</label>
                  
                    
          <div class="address-fieldset haveFamilyReferent-filled ">
          <label>additional delivery information</label>
          <input type="text" value="${dhr.dhrReferentAddress.additionalDeliveryInformation}" maxlength="38" name="dhrReferentAddress.additionalDeliveryInformation"/>  
          <label>additional geographical information</label>
          <input type="text" value="${dhr.dhrReferentAddress.additionalGeographicalInformation}" maxlength="38" name="dhrReferentAddress.additionalGeographicalInformation"/>
          <label> street number - street name</label>
          <input type="text" class="line1" value="${dhr.dhrReferentAddress.streetNumber}" maxlength="5" name="dhrReferentAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrReferentAddress.streetName}" maxlength="32" name="dhrReferentAddress.streetName"/>
          <label>place name or service</label>    
          <input type="text" value="${dhr.dhrReferentAddress.placeNameOrService}" maxlength="38" name="dhrReferentAddress.placeNameOrService"/>
          <label> postal code - city </label>
          <input type="text" class="line1" value="${dhr.dhrReferentAddress.postalCode}" maxlength="5" name="dhrReferentAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrReferentAddress.city}" maxlength="32" name="dhrReferentAddress.city"/>
          <label>country name</label>
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

            
            
              
                <label>dhrRequestKind</label>
                
          <ul class="isCoupleRequest-trigger ">
            <g:each in="${['Individual','Couple']}">
            <li>
              <input type="radio" class="isCoupleRequest-trigger  required validate-one-required" title="" value="fr.cg95.cvq.business.request.social.DhrRequestKind_${it}" name="dhrRequestKind" ${it == dhr.dhrRequestKind.toString() ? 'checked="checked"': ''} />
	            <g:message code="${it}" />  
            </li>
            </g:each>
          </ul>
          
              
              
            
            
              
                <fieldset>
                <legend>dhrSpouse</legend>
                
                  <label>dhrSpouseTitle</label>
                  
                    
          <select name="dhrSpouseTitle" class="isSpouseMadam-trigger  required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
              <option value="fr.cg95.cvq.business.users.DhrSpouseTitle_${it}" ${it == dhr.dhrSpouseTitle ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrSpouseFamilyStatus</label>
                  
                    
          <select name="dhrSpouseFamilyStatus" class=" required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
              <option value="fr.cg95.cvq.business.users.DhrSpouseFamilyStatus_${it}" ${it == dhr.dhrSpouseFamilyStatus ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrSpouseName</label>
                  
                    <input name="dhrSpouseName" value="${dhr.dhrSpouseName}" class=" required  validate-lastname" title="">
                  
                
                  <label>dhrSpouseFirstName</label>
                  
                    <input name="dhrSpouseFirstName" value="${dhr.dhrSpouseFirstName}" class=" required  validate-firstname" title="">
                  
                
                  <label>dhrSpouseMaidenName</label>
                  
                    <input name="dhrSpouseMaidenName" value="${dhr.dhrSpouseMaidenName}" class="isSpouseMadam-filled    validate-lastname" title="">
                  
                
                  <label>dhrSpouseBirthDate</label>
                  
                    <input name="dhrSpouseBirthDate" value="${dhr.dhrSpouseBirthDate}" class=" required  validate-date-au" title="">
                  
                
                  <label>dhrSpouseBirthPlace</label>
                  
                    <input name="dhrSpouseBirthPlace" value="${dhr.dhrSpouseBirthPlace}" class=" required  validate-string" title="">
                  
                
                  <label>dhrSpouseNationality</label>
                  
                    
          <select name="dhrSpouseNationality" class="isSpouseNonEuropean-trigger  required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['French','EuropeanUnion','OutsideEuropeanUnion']}">
              <option value="fr.cg95.cvq.business.users.DhrSpouseNationality_${it}" ${it == dhr.dhrSpouseNationality ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrSpouseFranceArrivalDate</label>
                  
                    <input name="dhrSpouseFranceArrivalDate" value="${dhr.dhrSpouseFranceArrivalDate}" class="isSpouseNonEuropean-filled    validate-date-au" title="">
                  
                
                  <label>dhrSpouseIsFrenchResident</label>
                  
                    
          <ul class="isSpouseNonEuropean-filled ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isSpouseNonEuropean-filled   validate-one-required" title="" value="${it}" name="dhrSpouseIsFrenchResident" ${it == dhr.dhrSpouseIsFrenchResident ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                </fieldset>
              
              
            
            
              
                <fieldset>
                <legend>dhrSpouseStatus</legend>
                
                  <label>dhrIsSpouseRetired</label>
                  
                    
          <ul class="isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger ">
            <g:each in="${[true,false]}">
            <li>
              <input type="radio" class="isSpouseRetired-trigger isSpouseOtherPensionPlan-trigger  required validate-one-required" title="" value="${it}" name="dhrIsSpouseRetired" ${it == dhr.dhrIsSpouseRetired ? 'checked="checked"': ''} />
	            <g:message code="widget.yesno.${it ? 'yes' : 'no'}" />
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label>dhrSpousePrincipalPensionPlan</label>
                  
                    
          <select name="dhrSpousePrincipalPensionPlan" class="isSpouseOtherPensionPlan-trigger isSpouseRetired-filled   validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['CNAV','MSA','CRAM','MGEN','SNCF','Other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrSpousePrincipalPensionPlan_${it}" ${it == dhr.dhrSpousePrincipalPensionPlan ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrSpousePensionPlanDetail</label>
                  
                    <input name="dhrSpousePensionPlanDetail" value="${dhr.dhrSpousePensionPlanDetail}" class="isSpouseOtherPensionPlan-filled    validate-string" title="">
                  
                
                  <label>dhrSpouseComplementaryPensionPlan</label>
                  
                    <input name="dhrSpouseComplementaryPensionPlan" value="${dhr.dhrSpouseComplementaryPensionPlan}" class="isSpouseRetired-filled    validate-string" title="">
                  
                
                  <label>dhrSpouseProfession</label>
                  
                    <input name="dhrSpouseProfession" value="${dhr.dhrSpouseProfession}" class="isSpouseRetired-unfilled    validate-string" title="">
                  
                
                  <label>dhrSpouseEmployer</label>
                  
                    <input name="dhrSpouseEmployer" value="${dhr.dhrSpouseEmployer}" class="isSpouseRetired-unfilled    validate-string" title="">
                  
                
                  <label>dhrSpouseAddress</label>
                  
                    
          <div class="address-fieldset isSpouseRetired-unfilled ">
          <label>additional delivery information</label>
          <input type="text" value="${dhr.dhrSpouseAddress.additionalDeliveryInformation}" maxlength="38" name="dhrSpouseAddress.additionalDeliveryInformation"/>  
          <label>additional geographical information</label>
          <input type="text" value="${dhr.dhrSpouseAddress.additionalGeographicalInformation}" maxlength="38" name="dhrSpouseAddress.additionalGeographicalInformation"/>
          <label> street number - street name</label>
          <input type="text" class="line1" value="${dhr.dhrSpouseAddress.streetNumber}" maxlength="5" name="dhrSpouseAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrSpouseAddress.streetName}" maxlength="32" name="dhrSpouseAddress.streetName"/>
          <label>place name or service</label>    
          <input type="text" value="${dhr.dhrSpouseAddress.placeNameOrService}" maxlength="38" name="dhrSpouseAddress.placeNameOrService"/>
          <label> postal code - city </label>
          <input type="text" class="line1" value="${dhr.dhrSpouseAddress.postalCode}" maxlength="5" name="dhrSpouseAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrSpouseAddress.city}" maxlength="32" name="dhrSpouseAddress.city"/>
          <label>country name</label>
          <input type="text" value="${dhr.dhrSpouseAddress.countryName}" maxlength="38" name="dhrSpouseAddress.countryName"/>
          </div>
          
                  
                
                </fieldset>
              
              
            
            
              
                <fieldset>
                <legend>dhrSpouseIncomes</legend>
                
                  <label>pensions</label>
                  
                    <input name="pensions" value="${dhr.pensions}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrAllowances</label>
                  
                    <input name="dhrAllowances" value="${dhr.dhrAllowances}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrFurnitureInvestmentIncome</label>
                  
                    <input name="dhrFurnitureInvestmentIncome" value="${dhr.dhrFurnitureInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrRealEstateInvestmentIncome</label>
                  
                    <input name="dhrRealEstateInvestmentIncome" value="${dhr.dhrRealEstateInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrNetIncome</label>
                  
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

            
            
              
                <fieldset>
                <legend>dhrCurrentDwelling</legend>
                
                  <label>dhrCurrentDwellingAddress</label>
                  
                    
          <div class="address-fieldset ">
          <label>additional delivery information</label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.additionalDeliveryInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalDeliveryInformation"/>  
          <label>additional geographical information</label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.additionalGeographicalInformation}" maxlength="38" name="dhrCurrentDwellingAddress.additionalGeographicalInformation"/>
          <label> street number - street name</label>
          <input type="text" class="line1" value="${dhr.dhrCurrentDwellingAddress.streetNumber}" maxlength="5" name="dhrCurrentDwellingAddress.streetNumber"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrCurrentDwellingAddress.streetName}" maxlength="32" name="dhrCurrentDwellingAddress.streetName"/>
          <label>place name or service</label>    
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.placeNameOrService}" maxlength="38" name="dhrCurrentDwellingAddress.placeNameOrService"/>
          <label> postal code - city </label>
          <input type="text" class="line1" value="${dhr.dhrCurrentDwellingAddress.postalCode}" maxlength="5" name="dhrCurrentDwellingAddress.postalCode"/>
          <input type="text" title="" class="line2 required" value="${dhr.dhrCurrentDwellingAddress.city}" maxlength="32" name="dhrCurrentDwellingAddress.city"/>
          <label>country name</label>
          <input type="text" value="${dhr.dhrCurrentDwellingAddress.countryName}" maxlength="38" name="dhrCurrentDwellingAddress.countryName"/>
          </div>
          
                  
                
                  <label>dhrCurrentDwellingPhone</label>
                  
                    <input name="dhrCurrentDwellingPhone" value="${dhr.dhrCurrentDwellingPhone}" class="   validate-phone" title="">
                  
                
                  <label>dhrCurrentDwellingKind</label>
                  
                    
          <select name="dhrCurrentDwellingKind" class="isCurrentDwellingPlaceOfResidence-trigger  required validate-not-first" title="">
            <option value="">Choisissez...</option>
            <g:each in="${['placeOfResidence','retirementHome','other']}">
              <option value="fr.cg95.cvq.business.request.social.DhrCurrentDwellingKind_${it}" ${it == dhr.dhrCurrentDwellingKind ? 'selected="selected"': ''}><g:message code="${it}" /></option>
            </g:each>
          </select>
          
                  
                
                  <label>dhrCurrentDwellingArrivalDate</label>
                  
                    <input name="dhrCurrentDwellingArrivalDate" value="${dhr.dhrCurrentDwellingArrivalDate}" class="isCurrentDwellingPlaceOfResidence-filled    validate-date-au" title="">
                  
                
                  <label>dhrCurrentDwellingStatus</label>
                  
                    
          <ul class="isCurrentDwellingPlaceOfResidence-filled ">
            <g:each in="${['owner','tenant']}">
            <li>
              <input type="radio" class="isCurrentDwellingPlaceOfResidence-filled   validate-one-required" title="" value="fr.cg95.cvq.business.request.social.DhrCurrentDwellingStatus_${it}" name="dhrCurrentDwellingStatus" ${it == dhr.dhrCurrentDwellingStatus.toString() ? 'checked="checked"': ''} />
	            <g:message code="${it}" />  
            </li>
            </g:each>
          </ul>
          
                  
                
                  <label>dhrCurrentDwellingNumberOfRoom</label>
                  
                    <input name="dhrCurrentDwellingNumberOfRoom" value="${dhr.dhrCurrentDwellingNumberOfRoom}" class="isCurrentDwellingPlaceOfResidence-filled    " title="">
                  
                
                  <label>dhrCurrentDwellingNetArea</label>
                  
                    <input name="dhrCurrentDwellingNetArea" value="${dhr.dhrCurrentDwellingNetArea}" class="isCurrentDwellingPlaceOfResidence-filled    " title="">
                  
                
                </fieldset>
              
              
            
            
              
                <label>dhrPreviousDwelling</label>
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

            
            
              
                <fieldset>
                <legend>dhrRequesterIncomes</legend>
                
                  <label>pensions</label>
                  
                    <input name="pensions" value="${dhr.pensions}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrAllowances</label>
                  
                    <input name="dhrAllowances" value="${dhr.dhrAllowances}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrFurnitureInvestmentIncome</label>
                  
                    <input name="dhrFurnitureInvestmentIncome" value="${dhr.dhrFurnitureInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrRealEstateInvestmentIncome</label>
                  
                    <input name="dhrRealEstateInvestmentIncome" value="${dhr.dhrRealEstateInvestmentIncome}" class="   validate-positiveinteger" title="">
                  
                
                  <label>dhrNetIncome</label>
                  
                    <input name="dhrNetIncome" value="${dhr.dhrNetIncome}" class="   validate-positiveinteger" title="">
                  
                
                </fieldset>
              
              
            
            
              
                <label>dhrRealAsset</label>
                <pre>TODO -> ON TO MANY</pre>
              
              
            
            
              
                <label>dhrNotRealAsset</label>
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

            
            
              
                <fieldset>
                <legend>dhrTaxesAmount</legend>
                
                  <label>dhrIncomeTax</label>
                  
                    <input name="dhrIncomeTax" value="${dhr.dhrIncomeTax}" class="   validate-positiveinteger" title="">
                  
                
                  <label>localRate</label>
                  
                    <input name="localRate" value="${dhr.localRate}" class="   validate-positiveinteger" title="">
                  
                
                  <label>propertyTaxes</label>
                  
                    <input name="propertyTaxes" value="${dhr.propertyTaxes}" class="   validate-positiveinteger" title="">
                  
                
                  <label>professionalTaxes</label>
                  
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
      	
      	var conditionsName = ["isNonEuropean", "isOtherPensionPlan", "haveFamilyReferent", "isCurrentDwellingPlaceOfResidence", "isSpouseRetired", "isRealEstate", "isSpouseOtherPensionPlan", "isMadam", "isPreviousDwellingPlaceOfResidence", "haveGuardian", "isSpouseNonEuropean", "isCoupleRequest", "isSpouseMadam"];
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
