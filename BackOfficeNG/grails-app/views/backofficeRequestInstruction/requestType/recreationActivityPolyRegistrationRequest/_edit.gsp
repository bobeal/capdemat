


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="raprr.step.requester.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="raprr.step.contact.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="raprr.step.authorization.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="raprr.step.rules.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page6"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="raprr.step.requester.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="raprr.property.recreationPolyActivity.label" /> * : </dt><dd id="recreationPolyActivity" class="action-editField validate-localReferentialData required-true i18n-raprr.property.recreationPolyActivity data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'recreationPolyActivity', 'lrEntries': lrTypes.recreationPolyActivity?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.recreationPolyActivity?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="raprr.property.urgencyPolyPhone.label" /> * : </dt><dd id="urgencyPolyPhone" class="action-editField validate-phone required-true i18n-raprr.property.urgencyPolyPhone maxLength-10" ><span>${rqt?.urgencyPolyPhone}</span></dd>
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
          <span><g:message code="raprr.step.contact.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-contactPolyIndividuals" class="">
                <g:render template="/backofficeRequestInstruction/requestType/recreationActivityPolyRegistrationRequest/contactPolyIndividuals" model="['rqt':rqt]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
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
          <span><g:message code="raprr.step.authorization.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-authorizedPolyIndividuals" class="">
                <g:render template="/backofficeRequestInstruction/requestType/recreationActivityPolyRegistrationRequest/authorizedPolyIndividuals" model="['rqt':rqt]" />
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
      <div id="page3">
        <h2><g:message code="property.form" />
          <span><g:message code="raprr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="raprr.property.rulesAndRegulationsPolyAcceptance.label" /> * : </dt><dd id="rulesAndRegulationsPolyAcceptance" class="action-editField validate-acceptance required-true i18n-raprr.property.rulesAndRegulationsPolyAcceptance" ><span class="value-${rqt?.rulesAndRegulationsPolyAcceptance}"><g:message code="message.${rqt?.rulesAndRegulationsPolyAcceptance ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="raprr.property.classTripPolyPermission.label" /> * : </dt><dd id="classTripPolyPermission" class="action-editField validate-acceptance required-true i18n-raprr.property.classTripPolyPermission" ><span class="value-${rqt?.classTripPolyPermission}"><g:message code="message.${rqt?.classTripPolyPermission ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="raprr.property.childPhotoExploitationPolyPermission.label" /> * : </dt><dd id="childPhotoExploitationPolyPermission" class="action-editField validate-acceptance required-true i18n-raprr.property.childPhotoExploitationPolyPermission" ><span class="value-${rqt?.childPhotoExploitationPolyPermission}"><g:message code="message.${rqt?.childPhotoExploitationPolyPermission ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="raprr.property.hospitalizationPolyPermission.label" /> * : </dt><dd id="hospitalizationPolyPermission" class="action-editField validate-acceptance required-true i18n-raprr.property.hospitalizationPolyPermission" ><span class="value-${rqt?.hospitalizationPolyPermission}"><g:message code="message.${rqt?.hospitalizationPolyPermission ? 'yes' : 'no'}" /></span></dd>
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
      <div id="page6">
        <h2><g:message code="property.form" />
          <span><g:message code="request.step.administration.label" /></span>
        </h2>
        <div class="yui-g">
          
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          
          
          
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="raprr.property.recreationPolyCenter.label" />  : </dt><dd id="recreationPolyCenter" class="action-editField validate-recreationPolyCenter i18n-raprr.property.recreationPolyCenter" ><span class="value-${rqt?.recreationPolyCenter?.id}">${rqt?.recreationPolyCenter?.name}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u first">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
