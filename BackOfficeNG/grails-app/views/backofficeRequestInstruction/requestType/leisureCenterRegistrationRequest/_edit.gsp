


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="lcrr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="lcrr.step.reglements.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="lcrr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="lcrr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <h3><g:message code="lcrr.property.centresLoisirs.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="lcrr.property.idCentreLoisirs.label" /> * : </dt><dd id="idCentreLoisirs" class="action-editField validate-string required-true i18n-lcrr.property.idCentreLoisirs" ><span>${rqt?.idCentreLoisirs}</span></dd>
                
                  <dt class="required"><g:message code="lcrr.property.labelCentreLoisirs.label" /> * : </dt><dd id="labelCentreLoisirs" class="action-editField validate-string required-true i18n-lcrr.property.labelCentreLoisirs" ><span>${rqt?.labelCentreLoisirs}</span></dd>
                
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estTransport-trigger"><g:message code="lcrr.property.estTransport.label" /> * : </dt><dd id="estTransport" class="action-editField validate-boolean required-true i18n-lcrr.property.estTransport" ><span class="value-${rqt?.estTransport}"><g:message code="message.${rqt?.estTransport ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <h3><g:message code="lcrr.property.transports.label" /></h3>
              <dl class="required condition-estTransport-filled">
                
                  <dt class="required"><g:message code="lcrr.property.idLigne.label" /> * : </dt><dd id="idLigne" class="action-editField validate-string required-true i18n-lcrr.property.idLigne" ><span>${rqt?.idLigne}</span></dd>
                
                  <dt class="required"><g:message code="lcrr.property.labelLigne.label" /> * : </dt><dd id="labelLigne" class="action-editField validate-string required-true i18n-lcrr.property.labelLigne" ><span>${rqt?.labelLigne}</span></dd>
                
                  <dt class="required"><g:message code="lcrr.property.idArret.label" /> * : </dt><dd id="idArret" class="action-editField validate-string required-true i18n-lcrr.property.idArret" ><span>${rqt?.idArret}</span></dd>
                
                  <dt class="required"><g:message code="lcrr.property.labelArret.label" /> * : </dt><dd id="labelArret" class="action-editField validate-string required-true i18n-lcrr.property.labelArret" ><span>${rqt?.labelArret}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-estDerogation-trigger"><g:message code="lcrr.property.estDerogation.label" /> * : </dt><dd id="estDerogation" class="action-editField validate-boolean required-true i18n-lcrr.property.estDerogation" ><span class="value-${rqt?.estDerogation}"><g:message code="message.${rqt?.estDerogation ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estDerogation-filled"><g:message code="lcrr.property.motifsDerogationCentreLoisirs.label" /> * : </dt><dd id="motifsDerogationCentreLoisirs" class="action-editField validate-localReferentialData required-true i18n-lcrr.property.motifsDerogationCentreLoisirs data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'motifsDerogationCentreLoisirs', 'lrEntries': lrTypes.motifsDerogationCentreLoisirs?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.motifsDerogationCentreLoisirs?.isMultiple(), 'depth':0]" />
 
          </dd>
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
          <span><g:message code="lcrr.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="lcrr.property.acceptationReglementInterieur.label" />  : </dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance i18n-lcrr.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
