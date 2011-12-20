


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="strr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="strr.step.autorisations.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="strr.step.reglements.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="strr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="strr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <h3><g:message code="strr.property.ligne.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="strr.property.idLigne.label" /> * : </dt><dd id="idLigne" class="action-editField validate-string required-true i18n-strr.property.idLigne" ><span>${rqt?.idLigne}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.labelLigne.label" /> * : </dt><dd id="labelLigne" class="action-editField validate-string required-true i18n-strr.property.labelLigne" ><span>${rqt?.labelLigne}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="strr.property.arret.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="strr.property.idArret.label" /> * : </dt><dd id="idArret" class="action-editField validate-string required-true i18n-strr.property.idArret" ><span>${rqt?.idArret}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.labelArret.label" /> * : </dt><dd id="labelArret" class="action-editField validate-string required-true i18n-strr.property.labelArret" ><span>${rqt?.labelArret}</span></dd>
                
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
          <span><g:message code="strr.step.autorisations.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-estMaternelleElementaire-trigger"><g:message code="strr.property.estMaternelleElementaireAutorisations.label" /> * : </dt><dd id="estMaternelleElementaireAutorisations" class="action-editField validate-boolean required-true i18n-strr.property.estMaternelleElementaireAutorisations" ><span class="value-${rqt?.estMaternelleElementaireAutorisations}"><g:message code="message.${rqt?.estMaternelleElementaireAutorisations ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estMaternelleElementaire-filled condition-autoriseTiers-trigger condition-autoriseFrereOuSoeur-trigger"><g:message code="strr.property.autorisation.label" /> * : </dt><dd id="autorisation" class="action-editField validate-capdematEnum required-true i18n-strr.property.autorisation javatype-fr.cg95.cvq.business.request.school.AutorisationType" ><g:capdematEnumToField var="${rqt?.autorisation}" i18nKeyPrefix="strr.property.autorisation" /></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <div id="widget-tiersAutorises" class="required condition-autoriseTiers-filled">
                <g:render template="/backofficeRequestInstruction/requestType/schoolTransportRegistrationRequest/tiersAutorises" model="['rqt':rqt]" />
              </div>
              
            
              
              <h3><g:message code="strr.property.frereOuSoeurAutorise.label" /></h3>
              <dl class="required condition-autoriseFrereOuSoeur-filled">
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurNom.label" /> * : </dt><dd id="frereOuSoeurNom" class="action-editField validate-lastName required-true i18n-strr.property.frereOuSoeurNom maxLength-38" ><span>${rqt?.frereOuSoeurNom}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurPrenom.label" /> * : </dt><dd id="frereOuSoeurPrenom" class="action-editField validate-firstName required-true i18n-strr.property.frereOuSoeurPrenom maxLength-38" ><span>${rqt?.frereOuSoeurPrenom}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurEcole.label" /> * : </dt><dd id="frereOuSoeurEcole" class="action-editField validate-string required-true i18n-strr.property.frereOuSoeurEcole" ><span>${rqt?.frereOuSoeurEcole}</span></dd>
                
                  <dt class="required"><g:message code="strr.property.frereOuSoeurClasse.label" /> * : </dt><dd id="frereOuSoeurClasse" class="action-editField validate-string required-true i18n-strr.property.frereOuSoeurClasse" ><span>${rqt?.frereOuSoeurClasse}</span></dd>
                
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
          <span><g:message code="strr.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="strr.property.acceptationReglementInterieur.label" />  : </dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance i18n-strr.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
