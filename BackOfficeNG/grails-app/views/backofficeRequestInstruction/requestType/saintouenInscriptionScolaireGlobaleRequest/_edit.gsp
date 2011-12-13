


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="sisgr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="sisgr.step.activites.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="sisgr.step.paiement.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="sisgr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sisgr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <h3><g:message code="sisgr.property.ecoleSecteur.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="sisgr.property.idEcoleSecteur.label" /> * : </dt><dd id="idEcoleSecteur" class="action-editField validate-string required-true i18n-sisgr.property.idEcoleSecteur" ><span>${rqt?.idEcoleSecteur}</span></dd>
                
                  <dt class="required"><g:message code="sisgr.property.labelEcoleSecteur.label" /> * : </dt><dd id="labelEcoleSecteur" class="action-editField validate-string required-true i18n-sisgr.property.labelEcoleSecteur" ><span>${rqt?.labelEcoleSecteur}</span></dd>
                
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sisgr.property.estAllergique.label" /> * : </dt><dd id="estAllergique" class="action-editField validate-boolean required-true i18n-sisgr.property.estAllergique" ><span class="value-${rqt?.estAllergique}"><g:message code="message.${rqt?.estAllergique ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sisgr.property.estHandicapeInvalidant.label" /> * : </dt><dd id="estHandicapeInvalidant" class="action-editField validate-boolean required-true i18n-sisgr.property.estHandicapeInvalidant" ><span class="value-${rqt?.estHandicapeInvalidant}"><g:message code="message.${rqt?.estHandicapeInvalidant ? 'yes' : 'no'}" /></span></dd>
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
          <span><g:message code="sisgr.step.activites.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sisgr.property.estRestauration.label" /> * : </dt><dd id="estRestauration" class="action-editField validate-boolean required-true i18n-sisgr.property.estRestauration" ><span class="value-${rqt?.estRestauration}"><g:message code="message.${rqt?.estRestauration ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sisgr.property.reglementInterieur.label" /> * : </dt><dd id="reglementInterieur" class="action-editField validate-acceptance required-true i18n-sisgr.property.reglementInterieur" ><span class="value-${rqt?.reglementInterieur}"><g:message code="message.${rqt?.reglementInterieur ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="sisgr.property.inscriptionPeriscolaire.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="sisgr.property.accueilMatin.label" /> * : </dt><dd id="accueilMatin" class="action-editField validate-boolean required-true i18n-sisgr.property.accueilMatin" ><span class="value-${rqt?.accueilMatin}"><g:message code="message.${rqt?.accueilMatin ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="sisgr.property.accueilSoir.label" /> * : </dt><dd id="accueilSoir" class="action-editField validate-boolean required-true i18n-sisgr.property.accueilSoir" ><span class="value-${rqt?.accueilSoir}"><g:message code="message.${rqt?.accueilSoir ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="sisgr.property.accueilMercrediEtVacances.label" /> * : </dt><dd id="accueilMercrediEtVacances" class="action-editField validate-boolean required-true i18n-sisgr.property.accueilMercrediEtVacances" ><span class="value-${rqt?.accueilMercrediEtVacances}"><g:message code="message.${rqt?.accueilMercrediEtVacances ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="sisgr.property.etudesSurveillees.label" /> * : </dt><dd id="etudesSurveillees" class="action-editField validate-boolean required-true i18n-sisgr.property.etudesSurveillees" ><span class="value-${rqt?.etudesSurveillees}"><g:message code="message.${rqt?.etudesSurveillees ? 'yes' : 'no'}" /></span></dd>
                
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
          <span><g:message code="sisgr.step.paiement.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sisgr.property.modeReglement.label" /> * : </dt><dd id="modeReglement" class="action-editField validate-localReferentialData required-true i18n-sisgr.property.modeReglement data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'modeReglement', 'lrEntries': lrTypes.modeReglement?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.modeReglement?.isMultiple(), 'depth':0]" />
 
          </dd>
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
