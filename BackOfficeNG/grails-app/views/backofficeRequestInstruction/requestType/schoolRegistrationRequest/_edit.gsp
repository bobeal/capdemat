


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="srr.step.registration.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="srr.step.rules.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page4"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="srr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="srr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="srr.property.section.label" /> * : </dt><dd id="section" class="action-editField validate-capdematEnum required-true i18n-srr.property.section javatype-fr.cg95.cvq.business.users.SectionType maxLength-32" ><g:capdematEnumToField var="${rqt?.section}" i18nKeyPrefix="srr.property.section" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="srr.property.urgencyPhone.label" /> * : </dt><dd id="urgencyPhone" class="action-editField validate-phone required-true i18n-srr.property.urgencyPhone maxLength-10" ><span>${rqt?.urgencyPhone}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="srr.property.currentSchool.label" /></h3>
              <dl class="required">
                
                  <dt class=""><g:message code="srr.property.currentSchoolName.label" />  : </dt><dd id="currentSchoolName" class="action-editField validate-string i18n-srr.property.currentSchoolName" ><span>${rqt?.currentSchoolName}</span></dd>
                
                  <dt class=""><g:message code="srr.property.currentSchoolAddress.label" />  : </dt><dd id="currentSchoolAddress" class="action-editField validate-string i18n-srr.property.currentSchoolAddress" ><span>${rqt?.currentSchoolAddress}</span></dd>
                
                  <dt class=""><g:message code="srr.property.currentSection.label" />  : </dt><dd id="currentSection" class="action-editField validate-capdematEnum i18n-srr.property.currentSection javatype-fr.cg95.cvq.business.users.SectionType maxLength-32" ><g:capdematEnumToField var="${rqt?.currentSection}" i18nKeyPrefix="srr.property.currentSection" /></dd>
                
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
          <span><g:message code="srr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="srr.property.rulesAndRegulationsAcceptance.label" />  : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance i18n-srr.property.rulesAndRegulationsAcceptance" ><span class="value-${rqt?.rulesAndRegulationsAcceptance}"><g:message code="message.${rqt?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
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
      <div id="page4">
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
                <dt class=""><g:message code="srr.property.school.label" />  : </dt><dd id="school" class="action-editField validate-school i18n-srr.property.school" ><span class="value-${rqt?.school?.id}">${rqt?.school?.name}</span></dd>
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
