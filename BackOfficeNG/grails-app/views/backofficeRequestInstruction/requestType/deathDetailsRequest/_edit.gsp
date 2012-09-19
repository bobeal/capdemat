


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="ddr.step.nature.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="ddr.step.type.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="ddr.step.nature.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required">${message(code:'ddr.property.deathLastName.label')}&nbsp;*&nbsp;:</dt><dd id="deathLastName" class="action-editField validate-lastName required-true i18n-ddr.property.deathLastName maxLength-38" ><span>${rqt?.deathLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'ddr.property.deathFirstNames.label')}&nbsp;*&nbsp;:</dt><dd id="deathFirstNames" class="action-editField validate-string required-true i18n-ddr.property.deathFirstNames" ><span>${rqt?.deathFirstNames}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'ddr.property.deathDate.label')}&nbsp;*&nbsp;:</dt><dd id="deathDate" class="action-editField validate-date required-true i18n-ddr.property.deathDate" ><span><g:formatDate formatName="format.date" date="${rqt?.deathDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'ddr.property.deathCity.label')}&nbsp;*&nbsp;:</dt><dd id="deathCity" class="action-editField validate-city required-true i18n-ddr.property.deathCity maxLength-32" ><span>${rqt?.deathCity}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'ddr.property.deathPostalCode.label')}&nbsp;*&nbsp;:</dt><dd id="deathPostalCode" class="action-editField validate-departmentCode required-true i18n-ddr.property.deathPostalCode maxLength-2" ><span>${rqt?.deathPostalCode}</span></dd>
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
          <span><g:message code="ddr.step.type.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required">${message(code:'ddr.property.format.label')}&nbsp;*&nbsp;:</dt><dd id="format" class="action-editField validate-capdematEnum required-true i18n-ddr.property.format javatype-fr.cg95.cvq.business.request.civil.DeathCertificateFormatType" ><g:capdematEnumToField var="${rqt?.format}" i18nKeyPrefix="ddr.property.format" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'ddr.property.copies.label')}&nbsp;*&nbsp;:</dt><dd id="copies" class="action-editField validate-positiveInteger required-true i18n-ddr.property.copies" ><span>${rqt?.copies}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'ddr.property.motive.label')}&nbsp;:</dt><dd id="motive" class="action-editField validate-capdematEnum i18n-ddr.property.motive javatype-fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType" ><g:capdematEnumToField var="${rqt?.motive}" i18nKeyPrefix="ddr.property.motive" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'ddr.property.comment.label')}&nbsp;:</dt><dd id="comment" class="action-editField validate-regex i18n-ddr.property.comment rows-3 maxLength-255" regex="^[\w\W]{0,255}$"><span>${rqt?.comment}</span></dd>
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
