


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="scjer.step.sujet.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="scjer.step.renseignements.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="scjer.step.reglements.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page5"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="scjer.step.sujet.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scjer.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scjer.property.telephonePortable.label" /> * : </dt><dd id="telephonePortable" class="action-editField validate-mobilePhone required-true i18n-scjer.property.telephonePortable maxLength-10" ><span>${rqt?.telephonePortable}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="scjer.property.email.label" />  : </dt><dd id="email" class="action-editField validate-email i18n-scjer.property.email" ><span>${rqt?.email}</span></dd>
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
          <span><g:message code="scjer.step.renseignements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scjer.property.typeInscription.label" /> * : </dt><dd id="typeInscription" class="action-editField validate-capdematEnum required-true i18n-scjer.property.typeInscription javatype-fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType" ><g:capdematEnumToField var="${rqt?.typeInscription}" i18nKeyPrefix="scjer.property.typeInscription" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scjer.property.secteurHabitation.label" /> * : </dt><dd id="secteurHabitation" class="action-editField validate-localReferentialData required-true i18n-scjer.property.secteurHabitation data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'secteurHabitation', 'lrEntries': lrTypes.secteurHabitation?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.secteurHabitation?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtablissementFrequenteCollege-trigger condition-estEtablissementFrequenteLycee-trigger condition-estEtablissementFrequenteAutre-trigger"><g:message code="scjer.property.typeEtablissementScolaireFrenquente.label" /> * : </dt><dd id="typeEtablissementScolaireFrenquente" class="action-editField validate-capdematEnum required-true i18n-scjer.property.typeEtablissementScolaireFrenquente javatype-fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType" ><g:capdematEnumToField var="${rqt?.typeEtablissementScolaireFrenquente}" i18nKeyPrefix="scjer.property.typeEtablissementScolaireFrenquente" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtablissementFrequenteCollege-filled"><g:message code="scjer.property.etablissementScolaireCollege.label" /> * : </dt><dd id="etablissementScolaireCollege" class="action-editField validate-localReferentialData required-true i18n-scjer.property.etablissementScolaireCollege data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'etablissementScolaireCollege', 'lrEntries': lrTypes.etablissementScolaireCollege?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.etablissementScolaireCollege?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtablissementFrequenteLycee-filled"><g:message code="scjer.property.etablissementScolaireLycee.label" /> * : </dt><dd id="etablissementScolaireLycee" class="action-editField validate-localReferentialData required-true i18n-scjer.property.etablissementScolaireLycee data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'etablissementScolaireLycee', 'lrEntries': lrTypes.etablissementScolaireLycee?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.etablissementScolaireLycee?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutre.label" /> * : </dt><dd id="etablissementScolaireAutre" class="action-editField validate-string required-true i18n-scjer.property.etablissementScolaireAutre" ><span>${rqt?.etablissementScolaireAutre}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutreNom.label" /> * : </dt><dd id="etablissementScolaireAutreNom" class="action-editField validate-string required-true i18n-scjer.property.etablissementScolaireAutreNom" ><span>${rqt?.etablissementScolaireAutreNom}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutreAdresse.label" /> * : </dt><dd id="etablissementScolaireAutreAdresse" class="action-editField validate-address required-true i18n-scjer.property.etablissementScolaireAutreAdresse" ><div><p class="additionalDeliveryInformation">${rqt?.etablissementScolaireAutreAdresse?.additionalDeliveryInformation}</p><p class="additionalGeographicalInformation">${rqt?.etablissementScolaireAutreAdresse?.additionalGeographicalInformation}</p><span class="streetNumber">${rqt?.etablissementScolaireAutreAdresse?.streetNumber}</span> <span class="streetName">${rqt?.etablissementScolaireAutreAdresse?.streetName}</span><g:if test="${!!rqt?.etablissementScolaireAutreAdresse?.streetMatriculation}"><br /><em><g:message code="address.property.streetMatriculation" /></em><span class="streetMatriculation">${rqt?.etablissementScolaireAutreAdresse?.streetMatriculation}</span></g:if><g:if test="${!!rqt?.etablissementScolaireAutreAdresse?.streetRivoliCode}"><br /><em><g:message code="address.property.streetRivoliCode" /></em><span class="streetRivoliCode">${rqt?.etablissementScolaireAutreAdresse?.streetRivoliCode}</span></g:if><p class="placeNameOrService">${rqt?.etablissementScolaireAutreAdresse?.placeNameOrService}</p><span class="postalCode">${rqt?.etablissementScolaireAutreAdresse?.postalCode}</span> <span class="city">${rqt?.etablissementScolaireAutreAdresse?.city}</span><p class="countryName">${rqt?.etablissementScolaireAutreAdresse?.countryName}</p><g:if test="${!!rqt?.etablissementScolaireAutreAdresse?.cityInseeCode}"><em><g:message code="address.property.cityInseeCode" /></em><span class="cityInseeCode">${rqt?.etablissementScolaireAutreAdresse?.cityInseeCode}</span></g:if></div></dd>
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
          <span><g:message code="scjer.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="scjer.property.autorisationMedicale.label" />  : </dt><dd id="autorisationMedicale" class="action-editField validate-acceptance i18n-scjer.property.autorisationMedicale" ><span class="value-${rqt?.autorisationMedicale}"><g:message code="message.${rqt?.autorisationMedicale ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="scjer.property.autorisationImage.label" />  : </dt><dd id="autorisationImage" class="action-editField validate-acceptance i18n-scjer.property.autorisationImage" ><span class="value-${rqt?.autorisationImage}"><g:message code="message.${rqt?.autorisationImage ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scjer.property.acceptationReglement.label" /> * : </dt><dd id="acceptationReglement" class="action-editField validate-acceptance required-true i18n-scjer.property.acceptationReglement" ><span class="value-${rqt?.acceptationReglement}"><g:message code="message.${rqt?.acceptationReglement ? 'yes' : 'no'}" /></span></dd>
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
