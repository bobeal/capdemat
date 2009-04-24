

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="rarr.step.subject.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="rarr.step.contact.label" /></em></a>
    </li>
  
    <li>
      <a href="#page2"><em><g:message code="rarr.step.authorization.label" /></em></a>
    </li>
  
    <li>
      <a href="#page3"><em><g:message code="rarr.step.rules.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="rarr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${request?.subjectFirstName} ${request?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="rarr.property.recreationActivity.label" /> * : </dt><dd id="recreationActivity" class="action-editField validate-localReferentialData required-true i18n-rarr.property.recreationActivity" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'recreationActivity', 'lrEntries': lrTypes.recreationActivity?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.recreationActivity?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="rarr.property.urgencyPhone.label" /> * : </dt><dd id="urgencyPhone" class="action-editField validate-phone required-true i18n-rarr.property.urgencyPhone maxLength-10" ><span>${request?.urgencyPhone}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="rarr.property.recreationCenter.label" />  : </dt><dd id="recreationCenter" class="action-editField validate-recreationCenter i18n-rarr.property.recreationCenter" ><span class="value-${request?.recreationCenter?.id}">${request?.recreationCenter?.name}</span></dd>
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
          <span><g:message code="rarr.step.contact.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-otherIndividual" class="">
                <g:render template="/backofficeRequestInstruction/requestType/recreationActivityRegistrationRequest/otherIndividual" model="['request':request]" />
              </div>
              
            
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
          <span><g:message code="rarr.step.authorization.label" /></span>
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
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="rarr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="rarr.property.rulesAndRegulationsAcceptance.label" /> * : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance required-true i18n-rarr.property.rulesAndRegulationsAcceptance" ><span class="value-${request?.rulesAndRegulationsAcceptance}"><g:message code="message.${request?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="rarr.property.classTripPermission.label" /> * : </dt><dd id="classTripPermission" class="action-editField validate-acceptance required-true i18n-rarr.property.classTripPermission" ><span class="value-${request?.classTripPermission}"><g:message code="message.${request?.classTripPermission ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="rarr.property.childPhotoExploitationPermission.label" /> * : </dt><dd id="childPhotoExploitationPermission" class="action-editField validate-acceptance required-true i18n-rarr.property.childPhotoExploitationPermission" ><span class="value-${request?.childPhotoExploitationPermission}"><g:message code="message.${request?.childPhotoExploitationPermission ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="rarr.property.hospitalizationPermission.label" /> * : </dt><dd id="hospitalizationPermission" class="action-editField validate-acceptance required-true i18n-rarr.property.hospitalizationPermission" ><span class="value-${request?.hospitalizationPermission}"><g:message code="message.${request?.hospitalizationPermission ? 'yes' : 'no'}" /></span></dd>
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
