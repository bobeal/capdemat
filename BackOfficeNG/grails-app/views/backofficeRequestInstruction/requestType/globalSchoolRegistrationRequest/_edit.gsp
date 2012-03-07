


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="gsrr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="gsrr.step.restauration.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="gsrr.step.periscolaire.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="gsrr.step.reglements.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="gsrr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="gsrr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estDerogation-trigger"><g:message code="gsrr.property.estDerogation.label" /> * : </dt><dd id="estDerogation" class="action-editField validate-boolean required-true i18n-gsrr.property.estDerogation" ><span class="value-${rqt?.estDerogation}"><g:message code="message.${rqt?.estDerogation ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <h3><g:message code="gsrr.property.ecoleDerogation.label" /></h3>
              <dl class="required condition-estDerogation-filled">
                
                  <dt class="required"><g:message code="gsrr.property.idEcoleDerog.label" /> * : </dt><dd id="idEcoleDerog" class="action-editField validate-string required-true i18n-gsrr.property.idEcoleDerog" ><span>${rqt?.idEcoleDerog}</span></dd>
                
                  <dt class="required"><g:message code="gsrr.property.labelEcoleDerog.label" /> * : </dt><dd id="labelEcoleDerog" class="action-editField validate-string required-true i18n-gsrr.property.labelEcoleDerog" ><span>${rqt?.labelEcoleDerog}</span></dd>
                
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estDerogation-filled"><g:message code="gsrr.property.motifsDerogationEcole.label" /> * : </dt><dd id="motifsDerogationEcole" class="action-editField validate-localReferentialData required-true i18n-gsrr.property.motifsDerogationEcole data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'motifsDerogationEcole', 'lrEntries': lrTypes.motifsDerogationEcole?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.motifsDerogationEcole?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="condition-estDerogation-filled"><g:message code="gsrr.property.informationsComplementairesDerogation.label" />  : </dt><dd id="informationsComplementairesDerogation" class="action-editField validate-regex i18n-gsrr.property.informationsComplementairesDerogation rows-10 maxLength-1024" regex="^[\w\W]{0,1024}$"><span>${rqt?.informationsComplementairesDerogation}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="gsrr.property.ecoleSecteur.label" /></h3>
              <dl class="required condition-estDerogation-unfilled">
                
                  <dt class="required"><g:message code="gsrr.property.idEcoleSecteur.label" /> * : </dt><dd id="idEcoleSecteur" class="action-editField validate-string required-true i18n-gsrr.property.idEcoleSecteur" ><span>${rqt?.idEcoleSecteur}</span></dd>
                
                  <dt class="required"><g:message code="gsrr.property.labelEcoleSecteur.label" /> * : </dt><dd id="labelEcoleSecteur" class="action-editField validate-string required-true i18n-gsrr.property.labelEcoleSecteur" ><span>${rqt?.labelEcoleSecteur}</span></dd>
                
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
          <span><g:message code="gsrr.step.restauration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="gsrr.property.estRestauration.label" /> * : </dt><dd id="estRestauration" class="action-editField validate-boolean required-true i18n-gsrr.property.estRestauration" ><span class="value-${rqt?.estRestauration}"><g:message code="message.${rqt?.estRestauration ? 'yes' : 'no'}" /></span></dd>
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
          <span><g:message code="gsrr.step.periscolaire.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="gsrr.property.estPeriscolaire.label" /> * : </dt><dd id="estPeriscolaire" class="action-editField validate-boolean required-true i18n-gsrr.property.estPeriscolaire" ><span class="value-${rqt?.estPeriscolaire}"><g:message code="message.${rqt?.estPeriscolaire ? 'yes' : 'no'}" /></span></dd>
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
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="gsrr.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="gsrr.property.acceptationReglementInterieur.label" />  : </dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance i18n-gsrr.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
