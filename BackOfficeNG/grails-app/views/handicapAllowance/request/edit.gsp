<html>
  <head>
    <meta name="layout" content="fong_main" />
	<link rel="stylesheet" type="text/css" href="/BackOfficeNG/handicapAllowanceRequest/css/har.css" />
  </head>  
  <body>
    <h2>
<!--      <a href="#" id="requestSubmit">envoyer</a>-->
      Demande de compensation du handicap
      <span>Ici, une brève description du télé-service</span>
      <span>Durée de la démarche : <strong>X min</strong></span>
      <span>
        Documents à fournir :
		<strong>Certificat médical - </strong>		
		<strong>Projet de vie (Confidentiel)-</strong>				
		<strong>Justificatifs de domicile - </strong>		
		<strong>Jugement concernant l'autorité parentale - </strong>
		<strong>Attestation d'employeur - </strong>
		<strong>Attestation d'inscription à l'ANPE - </strong>	
		<strong>Justificatifs de fonction élective - </strong>	
		<strong>Attestation d'emploi d'une tièrce personne - </strong>
		<strong>Dernier avis d'imposition - </strong>
		<strong>Relevé d'Identité Bancaire - </strong>	
		<strong>Déclaration de situation CAF ou MSA - </strong>
		<strong>Attestation de sécurité sociale - </strong>
		<strong>Justificatifs des besoins et/ou des frais liés au handicap - </strong>	
		<strong>Jugement de tutelle, de curatelle ou de mesure de sauvegarde pour les majeurs - </strong>
		<strong class="mandatory">Pièce d'identité</strong>	
      </span>
    </h2>
    <div id="yui-main"> 
     <div id="main" class="yui-b">
       <div id="requestTabView" class="yui-navset">
         <ul class="yui-nav">
           <li class="${currentTab == 'tab1' ? 'selected' : ''}"><a href="#tab1"><em>
             <span class="tag-no_right">1</span>
             <span class="tag-validated">c</span>
             Personne(s) concernée(s)
           </em></a></li>
           
           <li class="${currentTab == 'tab2' ? 'selected' : ''}"><a href="#tab2"><em>
             <span class="tag-no_right">2</span>
             <span class="tag-rejected">i</span>
             Habitation
           </em></a></li>
           
           <li class="${currentTab == 'tab3' ? 'selected' : ''}"><a href="#tab3"><em>
             <span class="tag-no_right">3</span>
             <span class="tag-rejected">i</span>
             Situation de famille
           </em></a></li>
           
           <li class="${currentTab == 'tab4' ? 'selected' : ''}"><a href="#tab4"><em>
             <span class="tag-no_right">4</span>
             <span class="tag-rejected">i</span>
             Sécurité Sociale
           </em></a></li>
           
           <li class="${currentTab == 'tab5' ? 'selected' : ''}"><a href="#tab5"><em>
             <span class="tag-no_right">5</span>
			 <span class="tag-rejected">i</span>
             Organisme payeur
           </em></a></li>
           
           <li class="${currentTab == 'tab6' ? 'selected' : ''}"><a href="#tab6"><em>
             <span class="tag-no_right">6</span>
			 <span class="tag-rejected">i</span> 
             Situation actuelle de votre handicap
           </em></a></li>

		   <li class="${currentTab == 'tab7' ? 'selected' : ''}"><a href="#tab7"><em>
             <span class="tag-no_right">7</span>
			 <span class="tag-rejected">i</span>
             Situation scolaire et/ou professionnelle
           </em></a></li>
           
		   <li class="${currentTab == 'tab8' ? 'selected' : ''}"><a href="#tab8"><em>
             <span class="tag-no_right">8</span>
			 <span class="tag-rejected">i</span>
             Situation scolaire et/ou professionnelle
           </em></a></li>

		   <li class="${currentTab == 'tab9' ? 'selected' : ''}"><a href="#tab9"><em>
             <span class="tag-no_right">9</span>
			 <span class="tag-rejected">i</span>
             Projet de vie
           </em></a></li>

		   <li class="${currentTab == 'tab10' ? 'selected' : ''}"><a href="#tab10"><em>
             <span class="tag-no_right">10</span>
			 <span class="tag-rejected">i</span>
             Documents
           </em></a></li>

           <li><a href="#tab11"><em>
             <span class="tag-no_right">11</span>
             <span class="tag-rejected">i</span>
             Contact
           </em></a></li>
           
           <li><a href="#tab12"><em>
             <span class="tag-no_right">12</span>
			 <span class="tag-rejected">i</span>
             Valider
           </em></a></li>
         </ul>  
         <div class="yui-content">	           
           <div id="tab1">
             <form method="POST" action="<g:createLink action="validRequester" />">
               <h3>
                 <span class="tag-rejected">imcomplet</span>
                 Demandeur
                 <span>Informations conçernant le demandeur</span>
               </h3>
               
               <!-- requestInformationRequesterProfile -->
               <label for="requestInformationRequesterProfile">
               		<strong><g:message code="har.requester.property.requestInformationRequesterProfile" /></strong>
               		<span class="span-required"> * </span>
               	</label>
			   <cvq:select name="requestInformationRequesterProfile" class="validate-not-first" 
			   		title="Le profil du demandeur est obligatoire" selected="${har?.requestInformationRequesterProfile.toString()}"
			   		isCondition="true">
			     <option value=""><g:message code="har.requester.property.requestInformationRequesterProfile.null" /></option>
				 <option value="Adult"><g:message code="har.requester.property.requestInformationRequesterProfile.adult" /></option>
				 <option value="LessThan20"><g:message code="har.requester.property.requestInformationRequesterProfile.lessThan20" /></option>
			   </cvq:select>  
			   
               <!-- ########################### AdultRequester########################### -->
               <fieldset id="adultRequester"><legend>Demandeur</legend>
				 
				<!-- adultRequesterTitle -->
				
			   <cvq:select name="adultRequesterTitle" class="validate-not-first" 
			   		title="La civilté du demandeur est obligatoire"
			   		selected="${har?.adultRequesterTitle.toString()}">
			     <option value=""><g:message code="har.requester.property.adultRequesterTitle.null" /></option>
				 <option value="Mister"><g:message code="har.requester.property.adultRequesterTitle.mister" /></option>
				 <option value="Madam"><g:message code="har.requester.property.adultRequesterTitle.madam" /></option>
				 <option value="Miss"><g:message code="har.requester.property.adultRequesterTitle.miss" /></option>
				 <option value="Agency"><g:message code="har.requester.property.adultRequesterTitle.agency" /></option>
				 <option value="Unknow"><g:message code="har.requester.property.adultRequesterTitle.other" /></option>
			   </cvq:select>
				
			    <label for="adultRequesterLastName">
			    	<strong><g:message code="har.requester.property.adultRequesterLastName" /></strong>
			    	<span class="span-required"> * </span>
			    </label>	
			   	<cvq:text name="adultRequesterLastName" value="${har?.adultRequesterLastName}" class="required" title="Le nom est obligatoire"/>
                   
                 <label for="adultRequesterFirstName">
                 	<strong><g:message code="har.requester.property.adultRequesterFirstName" /></strong>
                 	<span class="span-required"> * </span>
                 </label>
                 <cvq:text name="adultRequesterFirstName" value="${har?.adultRequesterFirstName}" class="required" title="Le Prénom est obligatoire"/>

				 <fieldset><legend>Adresse</legend>
		            <label for="adultRequesterAddress.streetName">
                 		<strong><g:message code="har.requester.property.adultRequesterAddressStreetName" /></strong>
                 		<span class="span-required"> * </span>
                 	</label>
		            <cvq:text name="adultRequesterAddress.streetName" value="${har.adultRequesterAddress?.streetName}" class="required" title="Rue est obligatoire"/>
		            
		            <label for="adultRequesterAddress.postalCode">
                 		<strong><g:message code="har.requester.property.adultRequesterAddressPostalCode" /></strong>
                 		<span class="span-required"> * </span>
                 	</label>
		            <cvq:text name="adultRequesterAddress.postalCode" value="${har.adultRequesterAddress?.postalCode}" class="required validate-regex" regex="[0-9]{5}" title="Code postal est obligatoire"/>
		            
		            <label for="adultRequesterAddress.city">
                 		<strong><g:message code="har.requester.property.adultRequesterAddressCity" /></strong>
                 		<span class="span-required"> * </span>
                 	</label>
		            <cvq:text name="adultRequesterAddress.city" value="${har.adultRequesterAddress?.city}" class="required" title="La ville est obligatoire"/>
               	 </fieldset>
				 
				 <label for="adultRequesterHomePhone">
                 	<strong><g:message code="har.requester.property.adultRequesterHomePhone" /></strong>
                 	<span> <g:message code="har.requester.property.adultRequesterHomePhone.help" /></span>
                 </label>
                 <cvq:text name="adultRequesterHomePhone" value="${har?.adultRequesterHomePhone}" class="validate-digits" />
                 
                 <label for="adultRequesterMobilePhone">
                 	<strong><g:message code="har.requester.property.adultRequesterMobilePhone" /></strong>
                 	<span> <g:message code="har.requester.property.adultRequesterMobilePhone.help" /></span>
                 </label>
                 <cvq:text name="adultRequesterMobilePhone" value="${har?.adultRequesterMobilePhone}" class="validate-digits"/>
                 
                 <label for="adultRequesterEmail">
                 	<strong><g:message code="har.requester.property.adultRequesterEmail" /></strong>
                 	<span> <g:message code="har.requester.property.adultRequesterEmail.help" /></span>
                 </label>
                 <cvq:text name="adultRequesterEmail" value="${har?.adultRequesterMobilePhone}" class="validate-email" title="Mauvais format d'email"/>
			 	 
			 	 <label for="adultRequesterBirthDate">
                 	<strong><g:message code="har.requester.property.adultRequesterBirthDate" /></strong>
                 	<span class="span-required"> * </span>
                 	<span> <g:message code="har.requester.property.adultRequesterBirthDate.help" /></span>
                 </label>
                 <cvq:calendar name="adultRequesterBirthDate" class="validate-date-au" title="Mauvais format de date" title="Title3" class="validate-date-au" value="${har?.adultRequesterBirthDate}" index="1"/>


				 <label for="adultRequesterBirthPlaceCity">
                 	<strong><g:message code="har.requester.property.adultRequesterBirthPlaceCity" /></strong>
                 	<span class="span-required"> * </span>
                 </label>
                 <cvq:text name="adultRequesterBirthPlaceCity" value="${har?.adultRequesterBirthPlaceCity}" class="required" title="Ville de naissance est obligatoire"/>
               
                 <label for="adultRequesterBirthPlaceCountry">
                 	<strong><g:message code="har.requester.property.adultRequesterBirthPlaceCountry" /></strong>
                 	<span class="span-required"> * </span>
                 </label>
                 <cvq:select name="adultRequesterBirthPlaceCountry" class="validate-not-first" 
			   		title="Le pays de naissance est obligatoire"
			   		selected="${har?.adultRequesterBirthPlaceCountry.toString()}"
			   		isCondition="true">
			   		 <option value=""><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.null" /></option>
					 <option value="es"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.es" /></option>
					 <option value="ee"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.ee" /></option>
					 <option value="us"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.us" /></option>
					 <option value="et"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.et" /></option>
					 <option value="fi"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.fi" /></option>
					 <option value="fr"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.fr" /></option>
			   	 </cvq:select>
               
                <label for="adultLegalAccessPresence">
                	<strong>Présence de protection juridique</strong>
                	<span class="span-required"> * </span>
                </label>
			    <cvq:yesno name="adultLegalAccessPresence" mode="INLINE" class="validate-one-required" title="Présence de protection juridique est obligatoire" checked="${har?.adultLegalAccessPresence}" isCondition="true"/>
				</fieldset>

			   <!-- ########################### AdultLegalAccess ########################### -->
			   <fieldset id="adultLegalAccess"><legend>Informations conçernant la protection juridique</legend>
               
			   <label for="adultLegalAccessKind" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessKind" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:select name="adultLegalAccessKind" class="validate-not-first" 
			   		title="La mesure de protection juridique du demandeur est obligatoire"
			   		selected="${har?.adultLegalAccessKind.toString()}" >
			     <option value=""><g:message code="har.requester.property.adultLegalAccessKind.null" /></option>
				 <option value="SauvegardeJustice"><g:message code="har.requester.property.adultLegalAccessKind.sauvegardeJustice" /></option>
				 <option value="Tutelle"><g:message code="har.requester.property.adultLegalAccessKind.tutelle" /></option>
				 <option value="Curatelle"><g:message code="har.requester.property.adultLegalAccessKind.curatelle" /></option>
			   </cvq:select>

			   <label for="adultLegalAccessRepresentativeKind" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeKind" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:select name="adultLegalAccessRepresentativeKind" class="validate-not-first"
			    	title="La nature du représentant est obligatoire" selected="${har?.adultLegalAccessRepresentativeKind.toString()}" isCondition="true">
			     <option value=""><g:message code="har.requester.property.adultLegalAccessRepresentativeKind.null" /></option>
				 <option value="FamilyMember"><g:message code="har.requester.property.adultLegalAccessRepresentativeKind.familyMember" /></option>
				 <option value="Agency"><g:message code="har.requester.property.adultLegalAccessRepresentativeKind.agency" /></option>
				 <option value="Other"><g:message code="har.requester.property.adultLegalAccessRepresentativeKind.other" /></option>
			   </cvq:select>   
 		
			   	<label for="adultLegalAccessRepresentativePrecision" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativePrecision" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:text rows="3" name="adultLegalAccessRepresentativePrecision" value="${har?.adultLegalAccessRepresentativePrecision}"
			   		class="required" title="Préciser est obligatoire"/>
			    
			   <label for="adultLegalAccessRepresentativeLastName" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeLastName" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:text name="adultLegalAccessRepresentativeLastName" value="${har?.adultLegalAccessRepresentativeLastName}"
			   		class="required" title="Nom du représentant légal est obligatoire"/>

			   <label for="adultLegalAccessRepresentativeFirstName" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeFirstName" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:text name="adultLegalAccessRepresentativeFirstName" value="${har?.adultLegalAccessRepresentativeFirstName}"
			   		class="required" title="Nom du représentant légal est obligatoire"/>
			   	
			   <fieldset id="adultLegalAccessRepresentativeAddress" ><legend>Adresse</legend>
				   <label for="adultLegalAccessRepresentativeAddressStreetName" >
				   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeAddressStreetName" /></strong>
				   		<span class="span-required"> * </span>
				   </label>
				   <cvq:text name="adultLegalAccessRepresentativeAddressStreetName" value="${har.adultLegalAccessRepresentativeAddress?.streetName}"
				   		class="required" title="Rue du représentant légal est obligatoire"/>
				   		
		       	   <label for="adultLegalAccessRepresentativeAddressPostalCode" >
				   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeAddressPostalCode" /></strong>
				   		<span class="span-required"> * </span>
				   </label>
				   <cvq:text name="adultLegalAccessRepresentativeAddressPostalCode" value="${har.adultLegalAccessRepresentativeAddress?.postalCode}"
				   		class="required" title="Code postal du représentant légal est obligatoire"/>
				   		
				   <label for="adultLegalAccessRepresentativeAddressCity" >
				   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeAddressCity" /></strong>
				   		<span class="span-required"> * </span>
				   </label>
				   <cvq:text name="adultLegalAccessRepresentativeAddressCity" value="${har.adultLegalAccessRepresentativeAddress?.city}"
				   		class="required" title="Ville du représentant légal est obligatoire"/>
				   		
               </fieldset>
               
               <label for="adultLegalAccessRepresentativeHomePhone" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeHomePhone" /></strong>
			   </label>
			   <cvq:text name="adultLegalAccessRepresentativeHomePhone" value="${har?.adultLegalAccessRepresentativeHomePhone}"
			   		class="" title=""/>

			   <label for="adultLegalAccessRepresentativeMobilePhone" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeMobilePhone" /></strong>
			   </label>
			   <cvq:text name="adultLegalAccessRepresentativeMobilePhone" value="${har?.adultLegalAccessRepresentativeMobilePhone}"
			   		class="" title=""/>	   
			   		
			   <label for="adultLegalAccessRepresentativeEmail" >
			   		<strong><g:message code="har.requester.property.adultLegalAccessRepresentativeEmail" /></strong>
			   </label>
			   <cvq:text name="adultLegalAccessRepresentativeEmail" value="${har?.adultLegalAccessRepresentativeEmail}"
			   		class="validate-email" title="Le format de l'email est incorrect"/>	
			   </fieldset>

			   <!-- LessThan20Requester -->
 
			   <fieldset id="lessThan20Requester"><legend>Informations conçernant le demandeur</legend>
			   <label for="adultLegalAccessKind" >
			   		<strong><g:message code="har.requester.property.lessThan20RequesterSex" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:select name="lessThan20RequesterSex" class="validate-not-first" 
			   		title="Sex du demandeur est obligatoire"
			   		selected="${har?.lessThan20Requester?.sex.toString()}">
			     <option value=""><g:message code="har.requester.property.lessThan20RequesterSex.null" /></option>
				 <option value="Male"><g:message code="har.requester.property.lessThan20RequesterSex.male" /></option>
				 <option value="Female"><g:message code="har.requester.property.lessThan20RequesterSex.female" /></option>
				 <option value="Unknown"><g:message code="har.requester.property.lessThan20RequesterSex.unknown" /></option>
			   </cvq:select>

			   <label for="lessThan20RequesterLastName" >
			   		<strong><g:message code="har.requester.property.lessThan20RequesterLastName" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:text name="lessThan20RequesterLastName" value="${har.lessThan20Requester?.lastName}"
			   		class="required" title="Nom du demandeur est obligatoire"/>

			   <label for="lessThan20RequesterFirstName" >
			   		<strong><g:message code="har.requester.property.lessThan20RequesterFirstName" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:text name="lessThan20RequesterFirstName" value="${har.lessThan20Requester?.firstName}"
			   		class="required" title="Prénom du représentant légal est obligatoire"/>
			   	
			   <fieldset id="lessThan20RequesterAddress" ><legend>Adresse</legend>
				   <label for="lessThan20RequesterAddressStreetName" >
				   		<strong><g:message code="har.requester.property.lessThan20RequesterAddressStreetName" /></strong>
				   		<span class="span-required"> * </span>
				   </label>
				   <cvq:text name="lessThan20RequesterAddressStreetName" value="${har.lessThan20Requester?.adress?.streetName}"
				   		class="required" title="Rue du demandeur est obligatoire"/>
				   		
		       	   <label for="lessThan20RequesterAddressPostalCode" >
				   		<strong><g:message code="har.requester.property.lessThan20RequesterAddressPostalCode" /></strong>
				   		<span class="span-required"> * </span>
				   </label>
				   <cvq:text name="lessThan20RequesterAddressPostalCode" value="${har.lessThan20Requester?.adress?.postalCode}"
				   		class="required" title="Code postal du représentant légal est obligatoire"/>
				   		
				   <label for="lessThan20RequesterAddressCity" >
				   		<strong><g:message code="har.requester.property.lessThan20RequesterAddressCity" /></strong>
				   		<span class="span-required"> * </span>
				   </label>
				   <cvq:text name="lessThan20RequesterAddressCity" value="${har.lessThan20Requester?.adress?.city}"
				   		class="required" title="Ville du représentant légal est obligatoire"/>
				   		
               </fieldset>
             
               <label for="lessThan20RequestereHomePhone" >
			   		<strong><g:message code="har.requester.property.lessThan20RequesterHomePhone" /></strong>
			   </label>
			   <cvq:text name="lessThan20RequesterHomePhone" value="${har?.lessThan20RequesterHomePhone}"
			   		class="" title=""/>

			   <label for="lessThan20RequesterMobilePhone" >
			   		<strong><g:message code="har.requester.property.lessThan20RequesterMobilePhone" /></strong>
			   </label>
			   <cvq:text name="lessThan20RequesterMobilePhone" value="${har?.lessThan20RequesterMobilePhone}"
			   		class="" title=""/>	   
			   		
			   <label for="lessThan20RequesterEmail" >
			   		<strong><g:message code="har.requester.property.lessThan20RequesterEmail" /></strong>
			   </label>
			   <cvq:text name="lessThan20RequestereEmail" value="${har?.lessThan20RequesterEmail}"
			   		class="validate-email" title="Le format de l'email est incorrect"/>
                 
               <label for="lessThan20RequesterBirthDate">
                 	<strong><g:message code="har.requester.property.lessThan20RequesterBirthDate" /></strong>
                 	<span class="span-required"> * </span>
               </label>

               <cvq:text name="lessThan20RequesterBirthDate" value="${har.lessThan20Requester?.birthDate}" class="required" 
               	 	title="Date de naissance est obligatoire" isCondition="true"/>
			   <label for="lessThan20RequesterBirthCity" >
			   		<strong><g:message code="har.requester.property.lessThan20RequesterBirthCity" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:text name="lessThan20RequesterBirthCity" value="${har.lessThan20Requester?.birthCity}"
			   		class="required" title="La ville de naissance est obligatoire"/>

			   <label for="lessThan20RequesterBirthCountry">
                 	<strong><g:message code="har.requester.property.lessThan20RequesterBirthCountry" /></strong>
                 	<span class="span-required"> * </span>
               </label>
               <cvq:select name="lessThan20RequesterBirthCountry" class="validate-not-first" 
			   		title="Le pays de naissance est obligatoire"
			   		selected="${har?.lessThan20Requester?.birthCountry.toString()}"
			   		isCondition="true">
			   		 <option value=""><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.null" /></option>
					 <option value="es"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.es" /></option>
					 <option value="ee"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.ee" /></option>
					 <option value="us"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.us" /></option>
					 <option value="et"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.et" /></option>
					 <option value="fi"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.fi" /></option>
					 <option value="fr"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.fr" /></option>
			   </cvq:select>
               </fieldset>

			   <!-- LessThan20Referent -->      
			   <fieldset id="lessThan20Referent"><legend>Informations conçernant le référent du demandeur</legend>

			   <cvq:select name="lessThan20ReferentTitle" class="validate-not-first" 
			   		title="La civilté du demandeur est obligatoire"
			   		selected="${har?.lessThan20ReferentTitle.toString()}">
			     <option value=""><g:message code="har.requester.property.adultRequesterTitle.null" /></option>
				 <option value="Mister"><g:message code="har.requester.property.adultRequesterTitle.mister" /></option>
				 <option value="Madam"><g:message code="har.requester.property.adultRequesterTitle.madam" /></option>
				 <option value="Miss"><g:message code="har.requester.property.adultRequesterTitle.miss" /></option>
				 <option value="Agency"><g:message code="har.requester.property.adultRequesterTitle.agency" /></option>
				 <option value="Unknow"><g:message code="har.requester.property.adultRequesterTitle.other" /></option>
			   </cvq:select>
				
			   <label for="lessThan20ReferentLastName">
			   		<strong><g:message code="har.requester.property.lessThan20ReferentLastName" /></strong>
			    	<span class="span-required"> * </span>
			   </label>	
			   <cvq:text name="lessThan20ReferentLastName" value="${har?.lessThan20ReferentLastName}" class="required" title="Le nom est obligatoire"/>
                   
               <label for="lessThan20ReferentFirstName">
                	<strong><g:message code="har.requester.property.lessThan20ReferentFirstName" /></strong>
                 	<span class="span-required"> * </span>
               </label>
               <cvq:text name="lessThan20ReferentFirstName" value="${har?.lessThan20ReferentFirstName}" class="required" title="Le Prénom est obligatoire"/>
			  
			   <fieldset><legend>Adresse</legend>
		            <label for="lessThan20ReferentAddressStreetName">
                 		<strong><g:message code="har.requester.property.lessThan20ReferentAddressStreetName" /></strong>
                 		<span class="span-required"> * </span>
                 	</label>
		            <cvq:text name="lessThan20ReferentAddressStreetName" value="${har?.lessThan20ReferentAddress?.streetName}" class="required" title="Rue est obligatoire"/>
		            
		            <label for="lessThan20ReferentAddressPostalCode">
                 		<strong><g:message code="har.requester.property.lessThan20ReferentAddressPostalCode" /></strong>
                 		<span class="span-required"> * </span>
                 	</label>
		            <cvq:text name="lessThan20ReferentAddressPostalCode" value="${har?.lessThan20ReferentAddress?.postalCode}" class="required validate-regex" regex="[0-9]{5}" title="Code postal est obligatoire"/>
		            
		            <label for="lessThan20ReferentAddressCity">
                 		<strong><g:message code="har.requester.property.lessThan20ReferentAddressCity" /></strong>
                 		<span class="span-required"> * </span>
                 	</label>
		            <cvq:text name="lessThan20ReferentAddressCity" value="${har?.lessThan20ReferentAddress?.city}" class="required" title="La ville est obligatoire"/>
               </fieldset>
				 
			   <label for="lessThan20ReferentHomePhone">
                	<strong><g:message code="har.requester.property.lessThan20ReferentHomePhone" /></strong>
               </label>
               <cvq:text name="lessThan20ReferentHomePhone" value="${har?.lessThan20ReferentHomePhone}" class="validate-digits" />
                
               <label for="lessThan20ReferentMobilePhone">
               		<strong><g:message code="har.requester.property.lessThan20ReferentMobilePhone" /></strong>
               </label>
               <cvq:text name="lessThan20ReferentMobilePhone" value="${har?.lessThan20ReferentMobilePhone}" class="validate-digits"/>
                 
               <label for="lessThan20ReferentEmail">
               		<strong><g:message code="har.requester.property.lessThan20ReferentEmail" /></strong>
               </label>
               <cvq:text name="lessThan20ReferentEmail" value="${har?.lessThan20ReferentMobilePhone}" class="validate-email" title="Mauvais format d'email"/>
			 	 <label for="adultRequesterBirthDate">
                 	<strong><g:message code="har.requester.property.adultRequesterBirthDate" /></strong>
                 	<span class="span-required"> * </span>
               </label>
               
               <cvq:calendar name="lessThan20ReferentBirthDate" class="validate-date-au" title="Mauvais format de date" title="La date de naissance du référent est obligatoire"  value="${har?.lessThan20ReferentBirthDate}" index="2"/>
               
              

			   <label for="lessThan20ReferentBirthPlaceCity">
                 	<strong><g:message code="har.requester.property.lessThan20ReferentBirthPlaceCity" /></strong>
                 	<span class="span-required"> * </span>
               </label>
               <cvq:text name="lessThan20ReferentBirthPlaceCity" value="${har?.lessThan20ReferentBirthPlaceCity}" class="required" title="Ville de naissance est obligatoire"/>
               
               <label for="lessThan20ReferentBirthPlaceCountry">
                	<strong><g:message code="har.requester.property.lessThan20ReferentBirthPlaceCountry" /></strong>
                 	<span class="span-required"> * </span>
               </label>
               <cvq:select name="lessThan20ReferentBirthPlaceCountry" class="validate-not-first" 
			   		title="Le pays de naissance est obligatoire"
			   		selected="${har?.lessThan20ReferentBirthPlaceCountry.toString()}"
			   		isCondition="true">
			   		 <option value=""><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.null" /></option>
					 <option value="es"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.es" /></option>
					 <option value="ee"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.ee" /></option>
					 <option value="us"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.us" /></option>
					 <option value="et"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.et" /></option>
					 <option value="fi"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.fi" /></option>
					 <option value="fr"><g:message code="har.requester.property.adultRequesterBirthPlaceCountry.fr" /></option>
			   </cvq:select>
			   </fieldset>
			                    
				<!-- LessThan20Father -->
			   <fieldset id="lessThan20Father"><legend>Informations conçernant le père du demandeur</legend>

			   <label for="lessThan20FatherLastName">
			   		<strong><g:message code="har.requester.property.lessThan20FatherLastName" /></strong>
			   </label>	
			   <cvq:text name="lessThan20FatherLastName" value="${har?.lessThan20FatherLastName}"/>
                   
               <label for="lessThan20FatherFirstName">
                	<strong><g:message code="har.requester.property.lessThan20FatherFirstName" /></strong>
               </label>
               <cvq:text name="lessThan20FatherFirstName" value="${har?.lessThan20FatherFirstName}" />
			  
			   <fieldset><legend>Adresse</legend>
		            <label for="lessThan20FatherAddressStreetName">
                 		<strong><g:message code="har.requester.property.lessThan20FatherAddressStreetName" /></strong>
                 	</label>
		            <cvq:text name="lessThan20FatherAddressStreetName" value="${har?.lessThan20FatherAddress?.streetName}" />
		            
		            <label for="lessThan20FatherAddressPostalCode">
                 		<strong><g:message code="har.requester.property.lessThan20FatherAddressPostalCode" /></strong>
                 	</label>
		            <cvq:text name="lessThan20FatherAddressPostalCode" value="${har?.lessThan20FatherAddress?.postalCode}" class="validate-regex" regex="[0-9]{5}" />	            
		            <label for="lessThan20FatherAddressCity">
                 		<strong><g:message code="har.requester.property.lessThan20FatherAddressCity" /></strong>
                 	</label>
		            <cvq:text name="lessThan20FatherAddressCity" value="${har?.lessThan20FatherAddress?.city}" />
               </fieldset>
				 
			   <label for="lessThan20FatherHomePhone">
                	<strong><g:message code="har.requester.property.lessThan20FatherHomePhone" /></strong>
               </label>
               <cvq:text name="lessThan20FatherHomePhone" value="${har?.lessThan20FatherHomePhone}" class="validate-digits" />
                
               <label for="lessThan20FatherMobilePhone">
               		<strong><g:message code="har.requester.property.lessThan20FatherMobilePhone" /></strong>
               </label>
               <cvq:text name="lessThan20FatherMobilePhone" value="${har?.lessThan20FatherMobilePhone}" class="validate-digits"/>
                 
               <label for="lessThan20FatherEmail">
               		<strong><g:message code="har.requester.property.lessThan20FatherEmail" /></strong>
               </label>
               <cvq:text name="lessThan20FatherEmail" value="${har?.lessThan20FatherMobilePhone}" class="validate-email" title="Mauvais format d'email"/>

			   <label for="lessThan20FatherJob">
               		<strong><g:message code="har.requester.property.lessThan20FatherJob" /></strong>
               </label>
               <cvq:text name="lessThan20FatherJob" value="${har?.lessThan20FatherJob}"/>
               
 			   <label for="lessThan20FatherActivityReduction">
                	<strong><g:message code="har.requester.property.lessThan20FatherActivityReduction" /></strong>
               </label>
			   <cvq:yesno name="lessThan20FatherActivityReduction" mode="INLINE" class="validate-one-required" title="Réduction de l'activité est obligatoire" checked="${har?.lessThan20FatherActivityReduction}" isCondition="true"/>
			   
			   <label for="lessThan20FatherReductionRatio">
               		<strong><g:message code="har.requester.property.lessThan20FatherReductionRatio" /></strong>
               </label>
               <cvq:text name="lessThan20FatherReductionRatio" value="${har?.lessThan20FatherReductionRatio}"/>
                  
               </fieldset>	
		
			   <!-- LessThan20Mother -->
			   <fieldset id="lessThan20Mother"><legend>Informations conçernant la mère du demandeur</legend>

			   <label for="lessThan20MotherLastName">
			   		<strong><g:message code="har.requester.property.lessThan20MotherLastName" /></strong>
			   </label>	
			   <cvq:text name="lessThan20MotherLastName" value="${har?.lessThan20MotherLastName}" />
                   
               <label for="lessThan20MotherFirstName">
                	<strong><g:message code="har.requester.property.lessThan20MotherFirstName" /></strong>
               </label>
               <cvq:text name="lessThan20MotherFirstName" value="${har?.lessThan20MotherFirstName}" />
			  
			   <fieldset><legend>Adresse</legend>
		            <label for="lessThan20MotherAddressStreetName">
                 		<strong><g:message code="har.requester.property.lessThan20MotherAddressStreetName" /></strong>
                 	</label>
		            <cvq:text name="lessThan20MotherAddressStreetName" value="${har?.lessThan20MotherAddress?.streetName}" />
		            
		            <label for="lessThan20MotherAddressPostalCode">
                 		<strong><g:message code="har.requester.property.lessThan20MotherAddressPostalCode" /></strong>
                 	</label>
		            <cvq:text name="lessThan20MotherAddressPostalCode" value="${har?.lessThan20MotherAddress?.postalCode}" class="validate-regex" regex="[0-9]{5}" />
		            
		            <label for="lessThan20MotherAddressCity">
                 		<strong><g:message code="har.requester.property.lessThan20MotherAddressCity" /></strong>
                 	</label>
		            <cvq:text name="lessThan20MotherAddressCity" value="${har?.lessThan20MotherAddress?.city}" />
               </fieldset>
				 
			   <label for="lessThan20MotherHomePhone">
                	<strong><g:message code="har.requester.property.lessThan20MotherHomePhone" /></strong>
               </label>
               <cvq:text name="lessThan20MotherHomePhone" value="${har?.lessThan20MotherHomePhone}" class="validate-digits" />
                
               <label for="lessThan20MotherMobilePhone">
               		<strong><g:message code="har.requester.property.lessThan20MotherMobilePhone" /></strong>
               </label>
               <cvq:text name="lessThan20MotherMobilePhone" value="${har?.lessThan20MotherMobilePhone}" class="validate-digits"/>
                 
               <label for="lessThan20MotherEmail">
               		<strong><g:message code="har.requester.property.lessThan20MotherEmail" /></strong>
               </label>
               <cvq:text name="lessThan20MotherEmail" value="${har?.lessThan20MotherMobilePhone}" class="validate-email" title="Mauvais format d'email"/>

			   <label for="lessThan20MotherJob">
               		<strong><g:message code="har.requester.property.lessThan20MotherJob" /></strong>
               </label>
               <cvq:text name="lessThan20MotherJob" value="${har?.lessThan20MotherJob}"/>
               
 			   <label for="lessThan20MotherActivityReduction">
                	<strong><g:message code="har.requester.property.lessThan20MotherActivityReduction" /></strong>
               </label>
			   <cvq:yesno name="lessThan20MotherActivityReduction" mode="INLINE" class="validate-one-required" title="Réduction de l'activité est obligatoire" checked="${har?.lessThan20MotherActivityReduction}" isCondition="true"/>
			   
			   <label for="lessThan20MotherReductionRatio">
               		<strong><g:message code="har.requester.property.lessThan20MotherReductionRatio" /></strong>
               </label>
               <cvq:text name="lessThan20MotherReductionRatio" value="${har?.lessThan20MotherReductionRatio}"/>
                  
               </fieldset>	
			  	<!-- LessThan20LegalRepresentative -->
			   <fieldset id="lessThan20LegalRepresentative" ><legend>Informations conçernant le représentant légal du demandeur</legend>

			   <label for="lessThan20LegalRepresentativeLastName">
			   		<strong><g:message code="har.requester.property.lessThan20LegalRepresentativeLastName" /></strong>
			   </label>	
			   <cvq:text name="lessThan20LegalRepresentativeLastName" value="${har?.lessThan20LegalRepresentativeLastName}"/>
                   
               <label for="lessThan20LegalRepresentativeFirstName">
                	<strong><g:message code="har.requester.property.lessThan20LegalRepresentativeFirstName" /></strong>
               </label>
               <cvq:text name="lessThan20LegalRepresentativeFirstName" value="${har?.lessThan20LegalRepresentativeFirstName}" />
			  
			   <fieldset><legend>Adresse</legend>
		            <label for="lessThan20LegalRepresentativeAddressStreetName">
                 		<strong><g:message code="har.requester.property.lessThan20LegalRepresentativeAddressStreetName" /></strong>
                 	</label>
		            <cvq:text name="lessThan20LegalRepresentativeAddressStreetName" value="${har?.lessThan20LegalRepresentativeAddress?.streetName}" />
		            
		            <label for="lessThan20LegalRepresentativeAddressPostalCode">
                 		<strong><g:message code="har.requester.property.lessThan20LegalRepresentativeAddressPostalCode" /></strong>
                 	</label>
		            <cvq:text name="lessThan20LegalRepresentativeAddressPostalCode" value="${har?.lessThan20LegalRepresentativeAddress?.postalCode}" class=" validate-regex" regex="[0-9]{5}" />
		            
		            <label for="lessThan20LegalRepresentativeAddressCity">
                 		<strong><g:message code="har.requester.property.lessThan20LegalRepresentativeAddressCity" /></strong>
                 	</label>
		            <cvq:text name="lessThan20LegalRepresentativeAddressCity" value="${har?.lessThan20LegalRepresentativeAddress?.city}" />
               </fieldset>
				 
			   <label for="lessThan20LegalRepresentativeHomePhone">
                	<strong><g:message code="har.requester.property.lessThan20LegalRepresentativeHomePhone" /></strong>
               </label>
               <cvq:text name="lessThan20LegalRepresentativeHomePhone" value="${har?.lessThan20LegalRepresentativeHomePhone}" class="validate-digits" />
                
               <label for="lessThan20LegalRepresentativeMobilePhone">
               		<strong><g:message code="har.requester.property.lessThan20LegalRepresentativeMobilePhone" /></strong>
               </label>
               <cvq:text name="lessThan20LegalRepresentativeMobilePhone" value="${har?.lessThan20LegalRepresentativeMobilePhone}" class="validate-digits"/>
			   	 
               </fieldset>

			   <!-- LessThan20ParentalAuthority -->
			   <fieldset id="lessThan20LegalParentalAuthority"><legend>Informations conçernant les détenteur(s) de l'autorité parentale</legend>
			   
               <label for="lessThan20ParentalAuthorityHolder">
                	<strong><g:message code="har.requester.property.lessThan20ParentalAuthorityHolder" /></strong>
                 	<span class="span-required"> * </span>
               </label>
               <cvq:select name="lessThan20ParentalAuthorityHolder" class="validate-not-first" 
			   		title="Détenteur(s) de l'autorité parentale est obligatoire"
			   		selected="${har?.lessThan20ParentalAuthorityHolder.toString()}"
			   		isCondition="true">
			   		 <option value=""><g:message code="har.requester.property.lessThan20ParentalAuthorityHolder.null" /></option>
					 <option value="Father"><g:message code="har.requester.property.lessThan20ParentalAuthorityHolder.father" /></option>
					 <option value="Mother"><g:message code="har.requester.property.lessThan20ParentalAuthorityHolder.mother" /></option>
					 <option value="Other"><g:message code="har.requester.property.lessThan20ParentalAuthorityHolder.other" /></option>
			   </cvq:select>
               <strong style="color:red;">TODO Replace by a checkbox</strong>
			   <label for="lessThan20ParentalAuthorityName">
                	<strong><g:message code="har.requester.property.lessThan20ParentalAuthorityName" /></strong>
               </label>
               <cvq:text name="lessThan20ParentalAuthorityName" value="${har?.lessThan20ParentalAuthorityName}" />
                
			   <label for="lessThan20ParentalAuthorityDepartment">
                	<strong><g:message code="har.requester.property.lessThan20ParentalAuthorityDepartment" /></strong>
               </label>
               <cvq:text name="lessThan20ParentalAuthorityDepartment" value="${har?.lessThan20ParentalAuthorityDepartment}" />
                 
               </fieldset>
               <div class="error" id="harRequesterFormErrors"></div> 
               <!-- Input submit-->
               <input type="submit" name="submitHarRequester" id="submitHarRequester" value="Valider cette page" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab2" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>
          
           <div id="tab2">
             <form method="POST" action="<g:createLink action="validResidence" />">
               <h3>
                 <span class="tag-rejected">imcomplet</span>
                 Habitation
                 <span>Informations conçernant l'habitation</span>
               </h3>
               <label for="dwellingKind">
                	<strong><g:message code="har.requester.property.dwellingKind" /></strong>
                 	<span class="span-required"> * </span>
               </label>
               <cvq:select name="dwellingKind" class="validate-not-first" 
			   		title="Nature de l'habitation est obligatoire"
			   		selected="${har?.dwellingKind.toString()}"
			   		isCondition="true">
			   		 <option value=""><g:message code="har.requester.property.dwellingKind.null" /></option>
					 <option value="Domicile"><g:message code="har.requester.property.dwellingKind.domicile" /></option>
					 <option value="ThirdPartyDomicile"><g:message code="har.requester.property.dwellingKind.thirdPartyDomicile" /></option>
					 <option value="Other"><g:message code="har.requester.property.dwellingKind.other" /></option>
			   </cvq:select>
			   
			   	<label for="dwellingPrecision" >
			   		<strong><g:message code="har.requester.property.dwellingPrecision" /></strong>
			   		<span class="span-required"> * </span>
			   </label>
			   <cvq:text rows="3" name="dwellingPrecision" value="${har?.dwellingPrecision}"
			   		class="required" title="Préciser est obligatoire"/>			   
              
			   <label for="dwellingEstablishmentReception">
                	<strong>Accueil en établissement</strong>
                	<span class="span-required"> * </span>
                </label>
                <cvq:yesno name="dwellingEstablishmentReception" mode="INLINE" class="validate-one-required" title="Accueil en établissement est obligatoire" checked="${har?.dwellingEstablishmentReception}" isCondition="true"/>
                
              
			   <label for="dwellingReceptionType">
			   		<strong>Type de l'accueil</strong>
			   		<span class="span-required"> * </span>
			   </label>
               <select name="dwellingReceptionType">
                 <option value="Internship" ${har?.dwellingReceptionType.toString() == 'Internship' ? 'selected' : ''}>Internat</option>
                 <option value="Clerkship" ${har?.dwellingReceptionType.toString() == 'Clerkship' ? 'selected' : ''}>Externat</option>
               </select>		
			   
			   <label for="dwellingReceptionNaming">
			   		<strong>Dénomination</strong>
			   		<span class="span-required"> * </span>
			   </label>
               <input name="dwellingReceptionNaming" type="text" value="${har?.dwellingReceptionNaming}"/>

			   <fieldset id="dwellingReceptionAddress" ><legend>Adresse</legend>
		       		<label for="dwellingReceptionAddressStreetName"><strong>Rue</strong></label>
		            <input name="dwellingReceptionAddressStreetName" type="text" value="${har.dwellingReceptionAddress?.streetName}" />
		             
		            <label for="dwellingReceptionAddressPostalCode"><strong>Code Postal</strong></label>
		            <input name="dwellingReceptionAddressPostalCode" type="text" value="${har.dwellingReceptionAddress?.postalCode}" />
		             
		            <label for="dwellingReceptionAddressCity"><strong>Ville</strong></label>
		      	    <input name="dwellingReceptionAddressCity" type="text" value="${har.dwellingReceptionAddress?.city}" />
               </fieldset>

			   
			   <label for="dwellingSocialReception">
                	<strong>Accueil social</strong>
                	<span class="span-required"> * </span>
                </label>
                <cvq:yesno name="dwellingSocialReception" mode="INLINE" class="validate-one-required" title="Accueil socialest obligatoire" checked="${har?.dwellingSocialReception}" isCondition="true"/>
			   		                   

			   <label for="dwellingSocialReceptionNaming">
			   		<strong>Dénomination</strong>
			   		<span class="span-required"> * </span>
			   </label>
               <input name="dwellingSocialReceptionNaming" type="text" value="${har?.dwellingSocialReceptionNaming}"/>

			   <fieldset id="dwellingSocialReceptionAddress" ><legend>Adresse</legend>
		       		<label for="dwellingSocialReceptionAddressStreetName"><strong>Rue</strong></label>
		            <input name="dwellingSocialReceptionAddressStreetName" type="text" value="${har.dwellingSocialReceptionAddress?.streetName}" />
		             
		            <label for="dwellingSocialReceptionAddressPostalCode"><strong>Code Postal</strong></label>
		            <input name="dwellingSocialReceptionAddressPostalCode" type="text" value="${har.dwellingSocialReceptionAddress?.postalCode}" />
		             
		            <label for="dwellingSocialReceptionAddressCity"><strong>Ville</strong></label>
		      	    <input name="dwellingSocialReceptionAddressCity" type="text" value="${har.dwellingSocialReceptionAddress?.city}" />
               </fieldset>
               
               <!-- Input submit-->
               <input type="submit" name="submitHarResidence" value="Valider cette page" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab1" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab3" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>

           <div id="tab3">
             <form method="POST" action="<g:createLink action="validFamily" />">
               <h3>
                 Situation de famille
                 <span>Informations conçernant la famille</span>
               </h3>
               <label for="lessThan20ParentalAuthorityName">
                	<strong><g:message code="har.requester.property.lessThan20ParentalAuthorityName" /></strong>
               </label>
               <cvq:text name="lessThan20ParentalAuthorityName" value="${har?.lessThan20ParentalAuthorityName}" />
               
               <label for="familyStatus"><strong>Situation de famille</strong></label>
               <select name="familyStatus">
                 <option value="Married" ${har?.familyStatus.toString() == 'Married' ? 'selected' : ''}>Marié(e)</option>
                 <option value="Single" ${har?.familyStatus.toString() == 'Single' ? 'selected' : ''}>Célibataire</option>
                 <option value="Divorced" ${har?.familyStatus.toString() == 'Divorced' ? 'selected' : ''}>Divorcé(e)</option>
                 <option value="Widow" ${har?.familyStatus.toString() == 'Widow' ? 'selected' : ''}>Veuf(ve)</option>
                 <option value="CommonLawMarriage" ${har?.familyStatus.toString() == 'CommonLawMarriage' ? 'selected' : ''}>Concubinage</option>
                 <option value="Other" ${har?.familyStatus.toString() == 'Other' ? 'selected' : ''}>Autre</option>
               </select>

			   <label for="familyHasFamilyDependents"><strong>Enfants et personnes à charge</strong></label>
			   <ul class="radio_list">
			     <li class="radio_inline">
					<input type=radio name="familyHasFamilyDependents" value="true" ${har.familyHasFamilyDependents == true ? 'checked' : ''}> Oui
				 </li>
			   	 <li class="radio_inline">
			   		<input type=radio name="familyHasFamilyDependents" value="false" ${har.familyHasFamilyDependents == false ? 'checked' : ''}> Non
				 </li>
			   </ul>	
			 <ul>
			 
			 <g:each in="${har.familyDependents}">
			 	<li><a href="#">Firstname: ${it.familyDependentFirstName}</a></li>
			 </g:each>
			
			 </ul>
			<!--
			 <input type="submit" name="createFamilyDependent" value="Créer" />
			-->
			  <!-- Input submit-->
              <input type="submit" name="submitHarFamily" value="Valider cette page" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab2" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab4" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>
           
           <div id="tab4">
             <form method="POST" action="<g:createLink action="validSocialSecurity" />">
               <h3>
                 Sécurité sociale
                 <span>Informations conçernant votre sécurité sociale</span>
               </h3>

               <label for="socialSecurityNumber"><strong>Numéro de sécurité sociale</strong></label>
               <input name="socialSecurityNumber" type="text" value="${har?.socialSecurityNumber}"/>

			   <label for="socialSecurityAgencyName"><strong>Nom de l'organisme</strong></label>
               <input name="socialSecurityAgencyName" type="text" value="${har?.socialSecurityAgencyName}"/>

				<fieldset id="socialSecurityAgencyAddress" ><legend>Adresse</legend>
		       		<label for="socialSecurityAgencyAddressStreetName"><strong>Rue</strong></label>
		            <input name="socialSecurityAgencyAddressStreetName" type="text" value="${har.socialSecurityAgencyAddress?.streetName}" />
		             
		            <label for="socialSecurityAgencyAddressCode"><strong>Code Postal</strong></label>
		            <input name="socialSecurityAgencyAddressPostalCode" type="text" value="${har.socialSecurityAgencyAddress?.postalCode}" />
		             
		            <label for="socialSecurityAgencyAddressCity"><strong>Ville</strong></label>
		      	    <input name="socialSecurityAgencyAddressCity" type="text" value="${har.socialSecurityAgencyAddress?.city}" />
                 </fieldset>
 			   <!-- Input submit-->
               <input type="submit" name="submitHarSocialSecurity" value="Valider cette page" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab3" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab5" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>
           
           <div id="tab5">
             <form method="POST" action="<g:createLink action="sendRequest" />">
               <h3>
                 Organisme payeur
                 <span>Informations conçernant l'organisme payeur</span>
               </h3>

			   <label for="paymentAgencyName"><strong>Nom de l'organisme</strong></label>
               <input name="paymentAgencyName" type="text" value="${har?.paymentAgencyName}"/>

				<fieldset id="paymentAgencyAddress" ><legend>Adresse</legend>
		       		<label for="paymentAgencyAddressStreetName"><strong>Rue</strong></label>
		            <input name="paymentAgencyAddressStreetName" type="text" value="${har.paymentAgencyAddress?.streetName}" />
		             
		            <label for="paymentAgencyAddressCode"><strong>Code Postal</strong></label>
		            <input name="paymentAgencyAddressPostalCode" type="text" value="${har.paymentAgencyAddress?.postalCode}" />
		             
		            <label for="paymentAgencyAddressCity"><strong>Ville</strong></label>
		      	    <input name="paymentAgencyAddressCity" type="text" value="${har.paymentAgencyAddress?.city}" />
                 </fieldset>

             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab4" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab6" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>

		   <div id="tab6">
             <form method="POST" action="<g:createLink action="sendRequest" />">
               <h3>
                 Validation
                 <span>Vérifiez les données saisies et envoyez votre demande</span>
               </h3>
               
              <P>Etape 7 <P>

             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab5" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab7" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>

		   <div id="tab7">
             <form method="POST" action="<g:createLink action="sendRequest" />">
               <h3>
                 Validation
                 <span>Vérifiez les données saisies et envoyez votre demande</span>
               </h3>
               
              <P>Etape 8 <P>

             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab6" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab8" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>

           <div id="tab8">
             <form method="POST" action="<g:createLink action="sendRequest" />">
               <h3>
                 Validation
                 <span>Vérifiez les données saisies et envoyez votre demande</span>
               </h3>
               
              <P>Etape 9 <P>
                
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab7" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab9" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>

           <div id="tab9">
             <form method="POST" action="<g:createLink action="sendRequest" />">
               <h3>
                 Validation
                 <span>Vérifiez les données saisies et envoyez votre demande</span>
               </h3>
               
              <P>Etape 10 <P>
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab8" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab10" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>

		   <div id="tab10">
             <form action="#">
               <h3>
                 <span class="tag-rejected">incomplet</span> 
                 Documents
                 <span>Cette étape vous permet de fournir des justificatifs numérisés, elle n'est pas obligatoire</span>
               </h3>
               
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
               
               <!-- Input submit-->
               <input type="submit" value="Valider cette page" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab9" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab11" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>
           
            <div id="tab11">
             <form method="POST" action="<g:createLink action="validDetailsNature" />">
               <h3>
                 Contact
                 <span>Comment souhaitez-vous être contacté pour cette demande</span>
               </h3>
               
               <label>Moyen de contact</label>
               <select name="requestMeansOfContactSelect">
                 <option>Courriel</option>
                 <option>Téléphone</option>
                 <option>Courrier</option>
                 <option>SMS</option>
                 <option>Mobile</option>
               </select>
                
               <!-- Input submit-->
               <input type="submit" value="Valider cette page" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab10" class="prevTab">&lt;&lt; Page précédente</a>
               <a href="#tab12" class="nextTab">Page suivante &gt;&gt;</a>
             </div>
           </div>
           
           <div id="tab12">
             <form method="POST" action="<g:createLink action="sendRequest" />">
               <h3>
                 Validation
                 <span>Vérifiez les données saisies et envoyez votre demande</span>
               </h3>
               
              <P>Ici la visualisation des données saisies ...<P>
			  <P>Ici les tests d'affichage<P>
			  
			<h4> type="text" </h4>
			
			  <h4>Mode</h4>
			  	<ul>
					<li>'static'</li>
					<li>'required'</li>
					<li>'inline'</li>
					<li>'notrequired'</li>
					<li>'blockrequired'</li>
					<li>'labelonly'</li>
					<li>'title'</li>
				</ul>
              <div class="message ${message != null ? '' : 'hidden'}">
                ${message}
              </div>
                
               <!-- Input submit-->
               <input name="submitMdrSend" type="submit" value="Envoyer la demande" />
             </form>
             <!-- navigation link -->
             <div class="navTab">
               <a href="#tab11" class="prevTab">&lt;&lt; Page précédente</a>
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
	      checkConditionsForm(activeTabIndex + 1);
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
	      checkConditionsForm(activeTabIndex + 1);
      }
      
      YAHOO.util.Event.addListener(
          YAHOO.util.Dom.getElementsByClassName("prevTab", "a" ),
          "click", 
          activePrevTabByLink
      );
      
      YAHOO.util.Event.addListener(
          document.getElementById('submitHarRequester'),
          "click", 
          FIC_checkForm, 
          document.getElementById('harRequesterFormErrors')
      );
      
      
      // Calendar
      YAHOO.capdematBo.calendar.cal = new Array(5);
      YAHOO.util.Event.onDOMReady(
          YAHOO.capdematBo.calendar.init, 
          {id : 0, label : "initDateFrom"});	
          YAHOO.util.Event.onDOMReady(
          YAHOO.capdematBo.calendar.init, 
          {id : 1, label : "adultRequesterBirthDate"});
          YAHOO.util.Event.onDOMReady(
          YAHOO.capdematBo.calendar.init, 
          {id : 2, label : "lessThan20ReferentBirthDate"});
          YAHOO.util.Event.onDOMReady(
          YAHOO.capdematBo.calendar.init, 
          {id : 3, label : "lessThan20RequesterBirthDate"});
      
   </script>
	<script src="/BackOfficeNG/handicapAllowanceRequest/js/har_conditions.js" type="text/javascript"></script>
  </body>
</html>

