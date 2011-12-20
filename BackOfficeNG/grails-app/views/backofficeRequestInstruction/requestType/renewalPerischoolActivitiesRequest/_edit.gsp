


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
                <dt class="required condition-estRestauration-trigger"><g:message code="rpar.property.estRestauration.label" /> * : </dt><dd id="estRestauration" class="action-editField validate-boolean required-true i18n-rpar.property.estRestauration" ><span class="value-${rqt?.estRestauration}"><g:message code="message.${rqt?.estRestauration ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estRestauration-filled"><g:message code="rpar.property.regimeAlimentaireRenouvellement.label" /> * : </dt><dd id="regimeAlimentaireRenouvellement" class="action-editField validate-localReferentialData required-true i18n-rpar.property.regimeAlimentaireRenouvellement data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'regimeAlimentaireRenouvellement', 'lrEntries': lrTypes.regimeAlimentaireRenouvellement?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.regimeAlimentaireRenouvellement?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="rpar.property.estPeriscolaire.label" /> * : </dt><dd id="estPeriscolaire" class="action-editField validate-boolean required-true i18n-rpar.property.estPeriscolaire" ><span class="value-${rqt?.estPeriscolaire}"><g:message code="message.${rqt?.estPeriscolaire ? 'yes' : 'no'}" /></span></dd>
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
                <dt class=""><g:message code="rpar.property.acceptationReglementInterieur.label" />  : </dt><dd id="acceptationReglementInterieur" class="action-editField validate-acceptance i18n-rpar.property.acceptationReglementInterieur" ><span class="value-${rqt?.acceptationReglementInterieur}"><g:message code="message.${rqt?.acceptationReglementInterieur ? 'yes' : 'no'}" /></span></dd>
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
