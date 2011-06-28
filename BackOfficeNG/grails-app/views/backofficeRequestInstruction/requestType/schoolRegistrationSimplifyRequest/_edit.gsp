


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="srsr.step.registration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="srsr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="srsr.property.section.label" /> * : </dt><dd id="section" class="action-editField validate-localReferentialData required-true i18n-srsr.property.section data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'section', 'lrEntries': lrTypes.section?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.section?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isExistRegistration-trigger"><g:message code="srsr.property.existRegistration.label" /> * : </dt><dd id="existRegistration" class="action-editField validate-boolean required-true i18n-srsr.property.existRegistration" ><span class="value-${rqt?.existRegistration}"><g:message code="message.${rqt?.existRegistration ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-isExistRegistration-filled"><g:message code="srsr.property.currentSchoolName.label" /> * : </dt><dd id="currentSchoolName" class="action-editField validate-string required-true i18n-srsr.property.currentSchoolName" ><span>${rqt?.currentSchoolName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isExistRegistration-filled"><g:message code="srsr.property.currentSchoolAddress.label" /> * : </dt><dd id="currentSchoolAddress" class="action-editField validate-string required-true i18n-srsr.property.currentSchoolAddress" ><span>${rqt?.currentSchoolAddress}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isExistRegistration-filled"><g:message code="srsr.property.currentSchoolLevel.label" /> * : </dt><dd id="currentSchoolLevel" class="action-editField validate-string required-true i18n-srsr.property.currentSchoolLevel" ><span>${rqt?.currentSchoolLevel}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="srsr.property.emergencyContactName.label" /> * : </dt><dd id="emergencyContactName" class="action-editField validate-string required-true i18n-srsr.property.emergencyContactName" ><span>${rqt?.emergencyContactName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="srsr.property.emergencyPhone.label" /> * : </dt><dd id="emergencyPhone" class="action-editField validate-string required-true i18n-srsr.property.emergencyPhone" ><span>${rqt?.emergencyPhone}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
