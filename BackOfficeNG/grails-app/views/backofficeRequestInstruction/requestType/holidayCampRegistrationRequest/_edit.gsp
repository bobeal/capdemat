


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="hcrr.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="hcrr.step.reglements.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="hcrr.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <h3><g:message code="hcrr.property.centreSejours.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="hcrr.property.idCentreSejours.label" /> * : </dt><dd id="idCentreSejours" class="action-editField validate-string required-true i18n-hcrr.property.idCentreSejours" ><span>${rqt?.idCentreSejours}</span></dd>
                
                  <dt class="required"><g:message code="hcrr.property.labelCentreSejours.label" /> * : </dt><dd id="labelCentreSejours" class="action-editField validate-string required-true i18n-hcrr.property.labelCentreSejours" ><span>${rqt?.labelCentreSejours}</span></dd>
                
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
          <span><g:message code="hcrr.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="hcrr.property.acceptationReglementInterieur.label" /> * : </dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance required-true i18n-hcrr.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
