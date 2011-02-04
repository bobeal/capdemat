


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="herr.step.subject.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="herr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="herr.property.telephone.label" /> * : </dt><dd id="telephone" class="action-editField validate-phone required-true i18n-herr.property.telephone maxLength-10" ><span>${rqt?.telephone}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required"><g:message code="herr.property.dateDepart.label" /> * : </dt><dd id="dateDepart" class="action-editField validate-date required-true i18n-herr.property.dateDepart" ><span><g:formatDate formatName="format.date" date="${rqt?.dateDepart}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="herr.property.duree.label" /> * : </dt><dd id="duree" class="action-editField validate-regex required-true i18n-herr.property.duree maxLength-2" regex="[0-9]{1,2}$"><span>${rqt?.duree}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
