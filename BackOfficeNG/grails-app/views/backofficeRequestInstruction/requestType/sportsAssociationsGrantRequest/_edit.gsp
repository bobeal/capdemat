


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="sagr.step.association.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="sagr.step.bureau.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="sagr.step.activites.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="sagr.step.subvention.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page6"><em><g:message code="request.step.administration.label" /></em></a>
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
                
                  <dt class=""><g:message code="sagr.property.numeroAgrementJeunesseSportAssociation.label" />  : </dt><dd id="numeroAgrementJeunesseSportAssociation" class="action-editField validate-string i18n-sagr.property.numeroAgrementJeunesseSportAssociation" ><span>${rqt?.numeroAgrementJeunesseSportAssociation}</span></dd>
                
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
          <span><g:message code="sagr.step.bureau.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sagr.property.roleDemandeur.label" /> * : </dt><dd id="roleDemandeur" class="action-editField validate-capdematEnum required-true i18n-sagr.property.roleDemandeur javatype-fr.cg95.cvq.business.request.social.SagrRoleAssociationType" ><g:capdematEnumToField var="${rqt?.roleDemandeur}" i18nKeyPrefix="sagr.property.roleDemandeur" /></dd>
              </dl>
              
            
              
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="sagr.step.activites.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-activiteAssociation" class="required">
                <g:render template="/backofficeRequestInstruction/requestType/sportsAssociationsGrantRequest/activiteAssociation" model="['rqt':rqt]" />
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
          <span><g:message code="sagr.step.subvention.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="sagr.property.subventionPubliqueFonctionnement.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="sagr.property.subventionSolliciteConseilGeneral.label" /> * : </dt><dd id="subventionSolliciteConseilGeneral" class="action-editField validate-string required-true i18n-sagr.property.subventionSolliciteConseilGeneral" ><span>${rqt?.subventionSolliciteConseilGeneral}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.cndsAnneeN.label" />  : </dt><dd id="cndsAnneeN" class="action-editField validate-string i18n-sagr.property.cndsAnneeN" ><span>${rqt?.cndsAnneeN}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.cndsAnneeNPlusUn.label" />  : </dt><dd id="cndsAnneeNPlusUn" class="action-editField validate-string i18n-sagr.property.cndsAnneeNPlusUn" ><span>${rqt?.cndsAnneeNPlusUn}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.regionAnneeN.label" />  : </dt><dd id="regionAnneeN" class="action-editField validate-string i18n-sagr.property.regionAnneeN" ><span>${rqt?.regionAnneeN}</span></dd>
                
                  <dt class=""><g:message code="sagr.property.regionAnneeNPlusUn.label" />  : </dt><dd id="regionAnneeNPlusUn" class="action-editField validate-string i18n-sagr.property.regionAnneeNPlusUn" ><span>${rqt?.regionAnneeNPlusUn}</span></dd>
                
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
      <div id="page6">
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
                <dt class="required"><g:message code="sagr.property.montantSubvention.label" /> * : </dt><dd id="montantSubvention" class="action-editField validate-string required-true i18n-sagr.property.montantSubvention" ><span>${rqt?.montantSubvention}</span></dd>
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
