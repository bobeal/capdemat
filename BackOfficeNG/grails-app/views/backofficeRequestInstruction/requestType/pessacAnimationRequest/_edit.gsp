


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="par.step.enfant.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="par.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="par.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'par.property.telephoneSujet.label')} :</dt><dd id="telephoneSujet" class="action-editField validate-mobilePhone i18n-par.property.telephoneSujet maxLength-10" ><span>${rqt?.telephoneSujet}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'par.property.emailSujet.label')} :</dt><dd id="emailSujet" class="action-editField validate-email i18n-par.property.emailSujet" ><span>${rqt?.emailSujet}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'par.property.acceptationReglementInterieur.label')} :</dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance i18n-par.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
