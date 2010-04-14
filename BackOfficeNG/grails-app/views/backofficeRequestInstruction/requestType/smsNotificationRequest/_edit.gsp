


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="snr.step.subscription.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page3"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="snr.step.subscription.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="snr.property.mobilePhone.label" />  : </dt><dd id="mobilePhone" class="action-editField validate-mobilePhone i18n-snr.property.mobilePhone maxLength-10" ><span>${rqt?.mobilePhone}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="snr.property.subscription.label" /> * : </dt><dd id="subscription" class="action-editField validate-boolean required-true i18n-snr.property.subscription" ><span class="value-${rqt?.subscription}"><g:message code="message.${rqt?.subscription ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="snr.property.interests.label" /> * : </dt><dd id="interests" class="action-editField validate-localReferentialData required-true i18n-snr.property.interests data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'interests', 'lrEntries': lrTypes.interests?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.interests?.entriesSupportMultiple, 'depth':0]" />
 
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
      
      <!-- step start -->
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="request.step.administration.label" /></span>
        </h2>
        <div class="yui-g">
          
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="snr.property.cleverSmsContactId.label" /> * : </dt><dd id="cleverSmsContactId" class="action-editField validate-string required-true i18n-snr.property.cleverSmsContactId" ><span>${rqt?.cleverSmsContactId}</span></dd>
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
