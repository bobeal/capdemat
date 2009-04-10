

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="scrr.step.registration.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="scrr.step.rules.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="scrr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${request?.subjectFirstName} ${request?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scrr.property.urgencyPhone.label" /> * : </dt><dd id="urgencyPhone" class="action-editField validate-phone required-true i18n-scrr.property.urgencyPhone maxLength-10" ><span>${request?.urgencyPhone}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scrr.property.foodDiet.label" /> * : </dt><dd id="foodDiet" class="action-editField validate-localReferentialData required-true i18n-scrr.property.foodDiet" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'foodDiet', 'lrEntries': lrTypes.foodDiet?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.foodDiet?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scrr.property.canteenAttendingDays.label" /> * : </dt><dd id="canteenAttendingDays" class="action-editField validate-localReferentialData required-true i18n-scrr.property.canteenAttendingDays" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'canteenAttendingDays', 'lrEntries': lrTypes.canteenAttendingDays?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.canteenAttendingDays?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scrr.property.foodAllergy.label" /> * : </dt><dd id="foodAllergy" class="action-editField validate-boolean required-true i18n-scrr.property.foodAllergy" ><span class="value-${request?.foodAllergy}"><g:message code="message.${request?.foodAllergy ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="scrr.property.doctorName.label" />  : </dt><dd id="doctorName" class="action-editField validate-string i18n-scrr.property.doctorName" ><span>${request?.doctorName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="scrr.property.doctorPhone.label" />  : </dt><dd id="doctorPhone" class="action-editField validate-phone i18n-scrr.property.doctorPhone maxLength-10" ><span>${request?.doctorPhone}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="scrr.property.school.label" /></h3>
              <dl class="">
                
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scrr.property.section.label" /> * : </dt><dd id="section" class="action-editField validate-capdematEnum required-true i18n-scrr.property.section javatype-fr.cg95.cvq.business.users.SectionType maxLength-32" ><g:capdematEnumToField var="${request?.section}" i18nKeyPrefix="scrr.property.section" /></dd>
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
          <span><g:message code="scrr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scrr.property.hospitalizationPermission.label" /> * : </dt><dd id="hospitalizationPermission" class="action-editField validate-acceptance required-true i18n-scrr.property.hospitalizationPermission" ><span>${request?.hospitalizationPermission}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scrr.property.rulesAndRegulationsAcceptance.label" /> * : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance required-true i18n-scrr.property.rulesAndRegulationsAcceptance" ><span>${request?.rulesAndRegulationsAcceptance}</span></dd>
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
