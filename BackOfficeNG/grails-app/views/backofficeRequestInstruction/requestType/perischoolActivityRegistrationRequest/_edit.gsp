


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="parr.step.registration.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="parr.step.contact.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="parr.step.authorization.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="parr.step.rules.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page6"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="parr.step.registration.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="parr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="parr.property.perischoolActivity.label" /> * : </dt><dd id="perischoolActivity" class="action-editField validate-localReferentialData required-true i18n-parr.property.perischoolActivity data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'perischoolActivity', 'lrEntries': lrTypes.perischoolActivity?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.perischoolActivity?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="parr.property.urgencyPhone.label" /> * : </dt><dd id="urgencyPhone" class="action-editField validate-phone required-true i18n-parr.property.urgencyPhone maxLength-10" ><span>${rqt?.urgencyPhone}</span></dd>
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
          <span><g:message code="parr.step.contact.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-contactIndividuals" class="">
                <g:render template="/backofficeRequestInstruction/requestType/perischoolActivityRegistrationRequest/contactIndividuals" model="['rqt':rqt]" />
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
          <span><g:message code="parr.step.authorization.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-authorizedIndividuals" class="">
                <g:render template="/backofficeRequestInstruction/requestType/perischoolActivityRegistrationRequest/authorizedIndividuals" model="['rqt':rqt]" />
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
          <span><g:message code="parr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="parr.property.rulesAndRegulationsAcceptance.label" />  : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance i18n-parr.property.rulesAndRegulationsAcceptance" ><span class="value-${rqt?.rulesAndRegulationsAcceptance}"><g:message code="message.${rqt?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="parr.property.classTripPermission.label" />  : </dt><dd id="classTripPermission" class="action-editField validate-acceptance i18n-parr.property.classTripPermission" ><span class="value-${rqt?.classTripPermission}"><g:message code="message.${rqt?.classTripPermission ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="parr.property.childPhotoExploitationPermission.label" />  : </dt><dd id="childPhotoExploitationPermission" class="action-editField validate-acceptance i18n-parr.property.childPhotoExploitationPermission" ><span class="value-${rqt?.childPhotoExploitationPermission}"><g:message code="message.${rqt?.childPhotoExploitationPermission ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="parr.property.hospitalizationPermission.label" />  : </dt><dd id="hospitalizationPermission" class="action-editField validate-acceptance i18n-parr.property.hospitalizationPermission" ><span class="value-${rqt?.hospitalizationPermission}"><g:message code="message.${rqt?.hospitalizationPermission ? 'yes' : 'no'}" /></span></dd>
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
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="parr.property.school.label" />  : </dt><dd id="school" class="action-editField validate-school i18n-parr.property.school" ><span class="value-${rqt?.school?.id}">${rqt?.school?.name}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="parr.property.section.label" /> * : </dt><dd id="section" class="action-editField validate-capdematEnum required-true i18n-parr.property.section javatype-fr.cg95.cvq.business.users.SectionType maxLength-32" ><g:capdematEnumToField var="${rqt?.section}" i18nKeyPrefix="parr.property.section" /></dd>
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
