


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="sapr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="sapr.step.activites.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="sapr.step.paiement.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="sapr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sapr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sapr.property.ecoleInscription.label" /> * : </dt><dd id="ecoleInscription" class="action-editField validate-capdematEnum required-true i18n-sapr.property.ecoleInscription javatype-fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType" ><g:capdematEnumToField var="${rqt?.ecoleInscription}" i18nKeyPrefix="sapr.property.ecoleInscription" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sapr.property.saprEstAllergique.label" /> * : </dt><dd id="saprEstAllergique" class="action-editField validate-boolean required-true i18n-sapr.property.saprEstAllergique" ><span class="value-${rqt?.saprEstAllergique}"><g:message code="message.${rqt?.saprEstAllergique ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sapr.property.saprEstHandicapeInvalidant.label" /> * : </dt><dd id="saprEstHandicapeInvalidant" class="action-editField validate-boolean required-true i18n-sapr.property.saprEstHandicapeInvalidant" ><span class="value-${rqt?.saprEstHandicapeInvalidant}"><g:message code="message.${rqt?.saprEstHandicapeInvalidant ? 'yes' : 'no'}" /></span></dd>
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
          <span><g:message code="sapr.step.activites.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sapr.property.saprEstRestauration.label" /> * : </dt><dd id="saprEstRestauration" class="action-editField validate-boolean required-true i18n-sapr.property.saprEstRestauration" ><span class="value-${rqt?.saprEstRestauration}"><g:message code="message.${rqt?.saprEstRestauration ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sapr.property.saprReglementInterieur.label" /> * : </dt><dd id="saprReglementInterieur" class="action-editField validate-acceptance required-true i18n-sapr.property.saprReglementInterieur" ><span class="value-${rqt?.saprReglementInterieur}"><g:message code="message.${rqt?.saprReglementInterieur ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="sapr.property.saprInscriptionPeriscolaire.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="sapr.property.saprAccueilMatin.label" /> * : </dt><dd id="saprAccueilMatin" class="action-editField validate-boolean required-true i18n-sapr.property.saprAccueilMatin" ><span class="value-${rqt?.saprAccueilMatin}"><g:message code="message.${rqt?.saprAccueilMatin ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="sapr.property.saprAccueilSoir.label" /> * : </dt><dd id="saprAccueilSoir" class="action-editField validate-boolean required-true i18n-sapr.property.saprAccueilSoir" ><span class="value-${rqt?.saprAccueilSoir}"><g:message code="message.${rqt?.saprAccueilSoir ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="sapr.property.saprAccueilMercrediEtVacances.label" /> * : </dt><dd id="saprAccueilMercrediEtVacances" class="action-editField validate-boolean required-true i18n-sapr.property.saprAccueilMercrediEtVacances" ><span class="value-${rqt?.saprAccueilMercrediEtVacances}"><g:message code="message.${rqt?.saprAccueilMercrediEtVacances ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="required"><g:message code="sapr.property.saprEtudesSurveillees.label" /> * : </dt><dd id="saprEtudesSurveillees" class="action-editField validate-boolean required-true i18n-sapr.property.saprEtudesSurveillees" ><span class="value-${rqt?.saprEtudesSurveillees}"><g:message code="message.${rqt?.saprEtudesSurveillees ? 'yes' : 'no'}" /></span></dd>
                
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
          <span><g:message code="sapr.step.paiement.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sapr.property.saprModeReglement.label" /> * : </dt><dd id="saprModeReglement" class="action-editField validate-localReferentialData required-true i18n-sapr.property.saprModeReglement data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'saprModeReglement', 'lrEntries': lrTypes.saprModeReglement?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.saprModeReglement?.isMultiple(), 'depth':0]" />
 
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
