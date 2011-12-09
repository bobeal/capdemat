


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="sagr.step.association.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="sagr.step.president.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="sagr.step.bureau.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="sagr.step.activites.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page4"><em><g:message code="sagr.step.subvention.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page7"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="sagr.step.association.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sagr.property.nomAssociation.label" /> * : </dt><dd id="nomAssociation" class="action-editField validate-string required-true i18n-sagr.property.nomAssociation" ><span>${rqt?.nomAssociation}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sagr.property.siegeSocialAssociation.label" /> * : </dt><dd id="siegeSocialAssociation" class="action-editField validate-address required-true i18n-sagr.property.siegeSocialAssociation" ><div><p class="additionalDeliveryInformation">${rqt?.siegeSocialAssociation?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.siegeSocialAssociation?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.siegeSocialAssociation?.streetNumber}</span> <span class="streetName">${rqt?.siegeSocialAssociation?.streetName}</span><g:if test="${!!rqt?.siegeSocialAssociation?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.siegeSocialAssociation?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.siegeSocialAssociation?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.siegeSocialAssociation?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.siegeSocialAssociation?.placeNameOrService}</p><span class="postalCode">${rqt?.siegeSocialAssociation?.postalCode}</span> <span class="city">${rqt?.siegeSocialAssociation?.city}</span><p class="countryName">${rqt?.siegeSocialAssociation?.countryName}</p><g:if test="${!!rqt?.siegeSocialAssociation?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.siegeSocialAssociation?.cityInseeCode}</span></g:if></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="sagr.property.numerosAssociation.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="sagr.property.numeroSiretAssociation.label" /> * : </dt><dd id="numeroSiretAssociation" class="action-editField validate-regex required-true i18n-sagr.property.numeroSiretAssociation maxLength-14" regex="^[\w\W]{0,14}$"><span>${rqt?.numeroSiretAssociation}</span></dd>
                
                  <dt class="required"><g:message code="sagr.property.numeroEnregistrementPrefectureAssociation.label" /> * : </dt><dd id="numeroEnregistrementPrefectureAssociation" class="action-editField validate-regex required-true i18n-sagr.property.numeroEnregistrementPrefectureAssociation maxLength-9" regex="^[\w\W]{0,9}$"><span>${rqt?.numeroEnregistrementPrefectureAssociation}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="sagr.property.contactsAssociation.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-estAdresseCorrespondantPrincipal-trigger"><g:message code="sagr.property.estAdresseCorrespondantPrincipal.label" /> * : </dt><dd id="estAdresseCorrespondantPrincipal" class="action-editField validate-boolean required-true i18n-sagr.property.estAdresseCorrespondantPrincipal" ><span class="value-${rqt?.estAdresseCorrespondantPrincipal}"><g:message code="message.${rqt?.estAdresseCorrespondantPrincipal ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required condition-estAdresseCorrespondantPrincipal-filled"><g:message code="sagr.property.nomCompletCorrespondantPrincipal.label" /> * : </dt><dd id="nomCompletCorrespondantPrincipal" class="action-editField validate-string required-true i18n-sagr.property.nomCompletCorrespondantPrincipal" ><span>${rqt?.nomCompletCorrespondantPrincipal}</span></dd>
                
                  <dt class="required condition-estAdresseCorrespondantPrincipal-filled"><g:message code="sagr.property.adresseCorrespondantPrincipal.label" /> * : </dt><dd id="adresseCorrespondantPrincipal" class="action-editField validate-address required-true i18n-sagr.property.adresseCorrespondantPrincipal" ><div><p class="additionalDeliveryInformation">${rqt?.adresseCorrespondantPrincipal?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.adresseCorrespondantPrincipal?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.adresseCorrespondantPrincipal?.streetNumber}</span> <span class="streetName">${rqt?.adresseCorrespondantPrincipal?.streetName}</span><g:if test="${!!rqt?.adresseCorrespondantPrincipal?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.adresseCorrespondantPrincipal?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.adresseCorrespondantPrincipal?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.adresseCorrespondantPrincipal?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.adresseCorrespondantPrincipal?.placeNameOrService}</p><span class="postalCode">${rqt?.adresseCorrespondantPrincipal?.postalCode}</span> <span class="city">${rqt?.adresseCorrespondantPrincipal?.city}</span><p class="countryName">${rqt?.adresseCorrespondantPrincipal?.countryName}</p><g:if test="${!!rqt?.adresseCorrespondantPrincipal?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.adresseCorrespondantPrincipal?.cityInseeCode}</span></g:if></div></dd>
                
                  <dt class=""><g:message code="sagr.property.emailClubOuCorrespondant.label" />  : </dt><dd id="emailClubOuCorrespondant" class="action-editField validate-email i18n-sagr.property.emailClubOuCorrespondant" ><span>${rqt?.emailClubOuCorrespondant}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="sagr.step.president.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-estPresident-trigger"><g:message code="sagr.property.roleDemandeur.label" /> * : </dt><dd id="roleDemandeur" class="action-editField validate-capdematEnum required-true i18n-sagr.property.roleDemandeur javatype-fr.cg95.cvq.business.request.social.SagrRoleAssociationType" ><g:capdematEnumToField var="${rqt?.roleDemandeur}" i18nKeyPrefix="sagr.property.roleDemandeur" /></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="sagr.property.precisionPresident.label" /></h3>
              <dl class="required condition-estPresident-unfilled">
                
                  <dt class="required"><g:message code="sagr.property.nomPresident.label" /> * : </dt><dd id="nomPresident" class="action-editField validate-lastName required-true i18n-sagr.property.nomPresident maxLength-38" ><span>${rqt?.nomPresident}</span></dd>
                
                  <dt class="required"><g:message code="sagr.property.prenomPresident.label" /> * : </dt><dd id="prenomPresident" class="action-editField validate-firstName required-true i18n-sagr.property.prenomPresident maxLength-38" ><span>${rqt?.prenomPresident}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.telephonePresident.label" />  : </dt><dd id="telephonePresident" class="action-editField validate-phone i18n-sagr.property.telephonePresident maxLength-10" ><span>${rqt?.telephonePresident}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.emailPresident.label" />  : </dt><dd id="emailPresident" class="action-editField validate-email i18n-sagr.property.emailPresident" ><span>${rqt?.emailPresident}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="sagr.step.bureau.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-autreMembreBureau" class="">
                <g:render template="/backofficeRequestInstruction/requestType/sportsAssociationsGrantRequest/autreMembreBureau" model="['rqt':rqt]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="sagr.step.activites.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-sagrActiviteAssociation" class="required">
                <g:render template="/backofficeRequestInstruction/requestType/sportsAssociationsGrantRequest/sagrActiviteAssociation" model="['rqt':rqt]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="sagr.property.subventionSolliciteConseilGeneral.label" />  : </dt><dd id="subventionSolliciteConseilGeneral" class="action-editField validate-decimal i18n-sagr.property.subventionSolliciteConseilGeneral" ><span>${rqt?.subventionSolliciteConseilGeneral}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page4">
        <h2><g:message code="property.form" />
          <span><g:message code="sagr.step.subvention.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="sagr.property.subventionPubliqueFonctionnement.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="sagr.property.budgetSaisonEcouleeRecette.label" />  : </dt><dd id="budgetSaisonEcouleeRecette" class="action-editField validate-string i18n-sagr.property.budgetSaisonEcouleeRecette" ><span>${rqt?.budgetSaisonEcouleeRecette}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.budgetSaisonEcouleeDepenses.label" />  : </dt><dd id="budgetSaisonEcouleeDepenses" class="action-editField validate-string i18n-sagr.property.budgetSaisonEcouleeDepenses" ><span>${rqt?.budgetSaisonEcouleeDepenses}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.nombreLicencieMoinsDixHuitSaisonEcoulee.label" />  : </dt><dd id="nombreLicencieMoinsDixHuitSaisonEcoulee" class="action-editField validate-string i18n-sagr.property.nombreLicencieMoinsDixHuitSaisonEcoulee" ><span>${rqt?.nombreLicencieMoinsDixHuitSaisonEcoulee}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.nombreLicenciePlusDixHuitSaisonEcoulee.label" />  : </dt><dd id="nombreLicenciePlusDixHuitSaisonEcoulee" class="action-editField validate-string i18n-sagr.property.nombreLicenciePlusDixHuitSaisonEcoulee" ><span>${rqt?.nombreLicenciePlusDixHuitSaisonEcoulee}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.communeAnneeN.label" />  : </dt><dd id="communeAnneeN" class="action-editField validate-string i18n-sagr.property.communeAnneeN" ><span>${rqt?.communeAnneeN}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.communeAnneeNPlusUn.label" />  : </dt><dd id="communeAnneeNPlusUn" class="action-editField validate-string i18n-sagr.property.communeAnneeNPlusUn" ><span>${rqt?.communeAnneeNPlusUn}</span></dd>
                
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sagr.property.compteBancaire.label" /> * : </dt><dd id="compteBancaire" class="action-editField validate-bankAccount required-true i18n-sagr.property.compteBancaire" ><div><p>${rqt?.compteBancaire?.BIC}</p><p>${rqt?.compteBancaire?.IBAN}</p></div></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page7">
        <h2><g:message code="property.form" />
          <span><g:message code="request.step.administration.label" /></span>
        </h2>
        <div class="yui-g">
          
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sagr.property.numeroEnregistrementAssociation.label" /> * : </dt><dd id="numeroEnregistrementAssociation" class="action-editField validate-string required-true i18n-sagr.property.numeroEnregistrementAssociation" ><span>${rqt?.numeroEnregistrementAssociation}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="sagr.property.identifiantEDemandeAssociation.label" />  : </dt><dd id="identifiantEDemandeAssociation" class="action-editField validate-string i18n-sagr.property.identifiantEDemandeAssociation" ><span>${rqt?.identifiantEDemandeAssociation}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sagr.property.montantSubvention.label" /> * : </dt><dd id="montantSubvention" class="action-editField validate-decimal required-true i18n-sagr.property.montantSubvention" ><span>${rqt?.montantSubvention}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
