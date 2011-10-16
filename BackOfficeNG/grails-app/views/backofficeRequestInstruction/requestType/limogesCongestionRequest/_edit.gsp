


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="lcr.step.requester.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="lcr.step.work.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="lcr.step.rules.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="lcr.step.requester.label" /></span>
        </h2>
        <div class="yui-g">
          
          
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
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="lcr.step.work.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="lcr.property.lcrCompteDe.label" /> * : </dt><dd id="lcrCompteDe" class="action-editField validate-string required-true i18n-lcr.property.lcrCompteDe" ><span>${rqt?.lcrCompteDe}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lcr.property.lcrWorkAddress.label" /> * : </dt><dd id="lcrWorkAddress" class="action-editField validate-textarea required-true i18n-lcr.property.lcrWorkAddress rows-5" ><span>${rqt?.lcrWorkAddress}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lcr.property.lcrWorkNature.label" /> * : </dt><dd id="lcrWorkNature" class="action-editField validate-textarea required-true i18n-lcr.property.lcrWorkNature rows-3" ><span>${rqt?.lcrWorkNature}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lcr.property.lcrDuration.label" /> * : </dt><dd id="lcrDuration" class="action-editField validate-string required-true i18n-lcr.property.lcrDuration" ><span>${rqt?.lcrDuration}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lcr.property.lcrStartWork.label" /> * : </dt><dd id="lcrStartWork" class="action-editField validate-string required-true i18n-lcr.property.lcrStartWork" ><span>${rqt?.lcrStartWork}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lcr.property.lcrEndWork.label" /> * : </dt><dd id="lcrEndWork" class="action-editField validate-string required-true i18n-lcr.property.lcrEndWork" ><span>${rqt?.lcrEndWork}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <div id="widget-lcrDescription" class="required">
                <g:render template="/backofficeRequestInstruction/requestType/limogesCongestionRequest/lcrDescription" model="['rqt':rqt]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="lcr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="lcr.property.lcrDuesAcceptance.label" /> * : </dt><dd id="lcrDuesAcceptance" class="action-editField validate-acceptance required-true i18n-lcr.property.lcrDuesAcceptance" ><span class="value-${rqt?.lcrDuesAcceptance}"><g:message code="message.${rqt?.lcrDuesAcceptance ? 'yes' : 'no'}" /></span></dd>
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
