


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="ddr.step.requester.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="ddr.step.nature.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="ddr.step.type.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="ddr.step.requester.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <g:render template="/backofficeRequestInstruction/requestType/requester" model="['requester':requester]" />
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
          <span><g:message code="ddr.step.nature.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="ddr.property.deathLastName.label" /> * : </dt><dd id="deathLastName" class="action-editField validate-lastName required-true i18n-ddr.property.deathLastName maxLength-38" ><span>${request?.deathLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ddr.property.deathFirstNames.label" /> * : </dt><dd id="deathFirstNames" class="action-editField validate-string required-true i18n-ddr.property.deathFirstNames" ><span>${request?.deathFirstNames}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ddr.property.deathDate.label" /> * : </dt><dd id="deathDate" class="action-editField validate-date required-true i18n-ddr.property.deathDate" ><span><g:formatDate formatName="format.date" date="${request?.deathDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ddr.property.deathCity.label" /> * : </dt><dd id="deathCity" class="action-editField validate-city required-true i18n-ddr.property.deathCity maxLength-32" ><span>${request?.deathCity}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ddr.property.deathPostalCode.label" /> * : </dt><dd id="deathPostalCode" class="action-editField validate-departmentCode required-true i18n-ddr.property.deathPostalCode maxLength-2" ><span>${request?.deathPostalCode}</span></dd>
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="ddr.step.type.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="ddr.property.format.label" /> * : </dt><dd id="format" class="action-editField validate-capdematEnum required-true i18n-ddr.property.format javatype-fr.cg95.cvq.business.request.civil.DeathCertificateFormatType" ><g:capdematEnumToField var="${request?.format}" i18nKeyPrefix="ddr.property.format" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="ddr.property.copies.label" /> * : </dt><dd id="copies" class="action-editField validate-positiveInteger required-true i18n-ddr.property.copies" ><span>${request?.copies}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="ddr.property.motive.label" />  : </dt><dd id="motive" class="action-editField validate-capdematEnum i18n-ddr.property.motive javatype-fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType" ><g:capdematEnumToField var="${request?.motive}" i18nKeyPrefix="ddr.property.motive" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="ddr.property.comment.label" />  : </dt><dd id="comment" class="action-editField validate-regex i18n-ddr.property.comment rows-3" regex="^.{0,255}$"><span>${request?.comment}</span></dd>
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
