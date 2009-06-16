

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="snr.step.subscription.label" /></em></a>
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
              <dd><span>${request?.subjectFirstName} ${request?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="snr.property.mobilePhone.label" />  : </dt><dd id="mobilePhone" class="action-editField validate-phone i18n-snr.property.mobilePhone maxLength-10" ><span>${request?.mobilePhone}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="snr.property.subscription.label" /> * : </dt><dd id="subscription" class="action-editField validate-boolean required-true i18n-snr.property.subscription" ><span class="value-${request?.subscription}"><g:message code="message.${request?.subscription ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="snr.property.interests.label" /> * : </dt><dd id="interests" class="action-editField validate-localReferentialData required-true i18n-snr.property.interests data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'interests', 'lrEntries': lrTypes.interests?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.interests?.entriesSupportMultiple, 'depth':0]" />
 
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
