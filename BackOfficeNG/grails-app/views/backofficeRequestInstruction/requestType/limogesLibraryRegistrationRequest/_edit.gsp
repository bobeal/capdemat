


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="llrr.step.registration.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="llrr.step.rules.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="llrr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="llrr.property.llrrSubscription.label" /> * : </dt><dd id="llrrSubscription" class="action-editField validate-localReferentialData required-true i18n-llrr.property.llrrSubscription data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'llrrSubscription', 'lrEntries': lrTypes.llrrSubscription?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.llrrSubscription?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="llrr.property.llrrBirthDate.label" /> * : </dt><dd id="llrrBirthDate" class="action-editField validate-date required-true i18n-llrr.property.llrrBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.llrrBirthDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="llrr.property.llrrCareer.label" /> * : </dt><dd id="llrrCareer" class="action-editField validate-localReferentialData required-true i18n-llrr.property.llrrCareer data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'llrrCareer', 'lrEntries': lrTypes.llrrCareer?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.llrrCareer?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="llrr.property.llrrSchoolType.label" />  : </dt><dd id="llrrSchoolType" class="action-editField validate-localReferentialData i18n-llrr.property.llrrSchoolType data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'llrrSchoolType', 'lrEntries': lrTypes.llrrSchoolType?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.llrrSchoolType?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="llrr.property.llrrSchoolName.label" />  : </dt><dd id="llrrSchoolName" class="action-editField validate-string i18n-llrr.property.llrrSchoolName" ><span>${rqt?.llrrSchoolName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="llrr.property.llrrSchoolClass.label" />  : </dt><dd id="llrrSchoolClass" class="action-editField validate-string i18n-llrr.property.llrrSchoolClass" ><span>${rqt?.llrrSchoolClass}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="llrr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="llrr.property.rulesAndRegulationsAcceptance.label" /> * : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance required-true i18n-llrr.property.rulesAndRegulationsAcceptance" ><span class="value-${rqt?.rulesAndRegulationsAcceptance}"><g:message code="message.${rqt?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="llrr.property.mailingList.label" /> * : </dt><dd id="mailingList" class="action-editField validate-acceptance required-true i18n-llrr.property.mailingList" ><span class="value-${rqt?.mailingList}"><g:message code="message.${rqt?.mailingList ? 'yes' : 'no'}" /></span></dd>
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
