


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="scjar.step.sujet.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="scjar.step.renseignements.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="scjar.step.reglements.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page5"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="scjar.step.sujet.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scjar.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scjar.property.dateNaissance.label" /> * : </dt><dd id="dateNaissance" class="action-editField validate-date required-true i18n-scjar.property.dateNaissance" ><span><g:formatDate formatName="format.date" date="${rqt?.dateNaissance}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scjar.property.sexe.label" /> * : </dt><dd id="sexe" class="action-editField validate-capdematEnum required-true i18n-scjar.property.sexe javatype-fr.cg95.cvq.business.request.school.ScjarSexeType" ><g:capdematEnumToField var="${rqt?.sexe}" i18nKeyPrefix="scjar.property.sexe" /></dd>
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
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="scjar.step.renseignements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scjar.property.typeInscription.label" /> * : </dt><dd id="typeInscription" class="action-editField validate-capdematEnum required-true i18n-scjar.property.typeInscription javatype-fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType" ><g:capdematEnumToField var="${rqt?.typeInscription}" i18nKeyPrefix="scjar.property.typeInscription" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scjar.property.secteurHabitation.label" /> * : </dt><dd id="secteurHabitation" class="action-editField validate-localReferentialData required-true i18n-scjar.property.secteurHabitation data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'secteurHabitation', 'lrEntries': lrTypes.secteurHabitation?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.secteurHabitation?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtudiant-trigger condition-estSalarie-trigger"><g:message code="scjar.property.situationActuelle.label" /> * : </dt><dd id="situationActuelle" class="action-editField validate-capdematEnum required-true i18n-scjar.property.situationActuelle javatype-fr.cg95.cvq.business.request.school.ScjarSituationActuelleType" ><g:capdematEnumToField var="${rqt?.situationActuelle}" i18nKeyPrefix="scjar.property.situationActuelle" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtudiant-filled condition-estEtablissementAutre-trigger"><g:message code="scjar.property.etudiantTypeEtablissement.label" /> * : </dt><dd id="etudiantTypeEtablissement" class="action-editField validate-capdematEnum required-true i18n-scjar.property.etudiantTypeEtablissement javatype-fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType" ><g:capdematEnumToField var="${rqt?.etudiantTypeEtablissement}" i18nKeyPrefix="scjar.property.etudiantTypeEtablissement" /></dd>
              </dl>
              
            
              
              <h3><g:message code="scjar.property.etablissementScolaireAutre.label" /></h3>
              <dl class="required condition-estEtablissementAutre-filled">
                
                  <dt class="required"><g:message code="scjar.property.precisionEtablissementScolaireAutre.label" /> * : </dt><dd id="precisionEtablissementScolaireAutre" class="action-editField validate-string required-true i18n-scjar.property.precisionEtablissementScolaireAutre" ><span>${rqt?.precisionEtablissementScolaireAutre}</span></dd>
                
                  <dt class="required"><g:message code="scjar.property.nomEtablissementScolaireAutre.label" /> * : </dt><dd id="nomEtablissementScolaireAutre" class="action-editField validate-string required-true i18n-scjar.property.nomEtablissementScolaireAutre" ><span>${rqt?.nomEtablissementScolaireAutre}</span></dd>
                
                  <dt class="required"><g:message code="scjar.property.adresseEtablissementScolaireAutre.label" /> * : </dt><dd id="adresseEtablissementScolaireAutre" class="action-editField validate-address required-true i18n-scjar.property.adresseEtablissementScolaireAutre" ><div><p class="additionalDeliveryInformation">${rqt?.adresseEtablissementScolaireAutre?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.adresseEtablissementScolaireAutre?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.adresseEtablissementScolaireAutre?.streetNumber}</span> <span class="streetName">${rqt?.adresseEtablissementScolaireAutre?.streetName}</span><g:if test="${!!rqt?.adresseEtablissementScolaireAutre?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.adresseEtablissementScolaireAutre?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.adresseEtablissementScolaireAutre?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.adresseEtablissementScolaireAutre?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.adresseEtablissementScolaireAutre?.placeNameOrService}</p><span class="postalCode">${rqt?.adresseEtablissementScolaireAutre?.postalCode}</span> <span class="city">${rqt?.adresseEtablissementScolaireAutre?.city}</span><p class="countryName">${rqt?.adresseEtablissementScolaireAutre?.countryName}</p><g:if test="${!!rqt?.adresseEtablissementScolaireAutre?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.adresseEtablissementScolaireAutre?.cityInseeCode}</span></g:if></div></dd>
                
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estSalarie-filled"><g:message code="scjar.property.profession.label" /> * : </dt><dd id="profession" class="action-editField validate-string required-true i18n-scjar.property.profession" ><span>${rqt?.profession}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-participeActivite-trigger"><g:message code="scjar.property.participeActivite.label" /> * : </dt><dd id="participeActivite" class="action-editField validate-boolean required-true i18n-scjar.property.participeActivite" ><span class="value-${rqt?.participeActivite}"><g:message code="message.${rqt?.participeActivite ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-participeActivite-filled"><g:message code="scjar.property.typeActivite.label" /> * : </dt><dd id="typeActivite" class="action-editField validate-capdematEnum required-true i18n-scjar.property.typeActivite javatype-fr.cg95.cvq.business.request.school.ScjarTypeActiviteType" ><g:capdematEnumToField var="${rqt?.typeActivite}" i18nKeyPrefix="scjar.property.typeActivite" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-participeActivite-filled"><g:message code="scjar.property.precisionActivite.label" /> * : </dt><dd id="precisionActivite" class="action-editField validate-string required-true i18n-scjar.property.precisionActivite" ><span>${rqt?.precisionActivite}</span></dd>
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="scjar.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="scjar.property.autorisationMedicale.label" />  : </dt><dd id="autorisationMedicale" class="action-editField validate-acceptance i18n-scjar.property.autorisationMedicale" ><span class="value-${rqt?.autorisationMedicale}"><g:message code="message.${rqt?.autorisationMedicale ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="scjar.property.autorisationImage.label" />  : </dt><dd id="autorisationImage" class="action-editField validate-acceptance i18n-scjar.property.autorisationImage" ><span class="value-${rqt?.autorisationImage}"><g:message code="message.${rqt?.autorisationImage ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scjar.property.acceptationReglement.label" /> * : </dt><dd id="acceptationReglement" class="action-editField validate-acceptance required-true i18n-scjar.property.acceptationReglement" ><span class="value-${rqt?.acceptationReglement}"><g:message code="message.${rqt?.acceptationReglement ? 'yes' : 'no'}" /></span></dd>
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
      <div id="page5">
        <h2><g:message code="property.form" />
          <span><g:message code="request.step.administration.label" /></span>
        </h2>
        <div class="yui-g">
          
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          
          
          <!-- column start -->
          <div class="yui-u first">
            
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
