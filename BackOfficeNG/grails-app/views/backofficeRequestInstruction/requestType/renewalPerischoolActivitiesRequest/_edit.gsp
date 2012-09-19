


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="rpar.step.enfant.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="rpar.step.reglements.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="rpar.step.enfant.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="rpar.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'rpar.property.estRestauration.label')}&nbsp;*&nbsp;:</dt><dd id="estRestauration" class="action-editField validate-boolean required-true i18n-rpar.property.estRestauration" ><span class="value-${rqt?.estRestauration}"><g:message code="${rqt?.estRestauration ? 'message.yes' : rqt?.estRestauration==null ? '' : 'message.no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'rpar.property.estPeriscolaire.label')}&nbsp;*&nbsp;:</dt><dd id="estPeriscolaire" class="action-editField validate-boolean required-true i18n-rpar.property.estPeriscolaire" ><span class="value-${rqt?.estPeriscolaire}"><g:message code="${rqt?.estPeriscolaire ? 'message.yes' : rqt?.estPeriscolaire==null ? '' : 'message.no'}" /></span></dd>
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
          <span><g:message code="rpar.step.reglements.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="">${message(code:'rpar.property.acceptationReglementInterieur.label')}&nbsp;:</dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance i18n-rpar.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
