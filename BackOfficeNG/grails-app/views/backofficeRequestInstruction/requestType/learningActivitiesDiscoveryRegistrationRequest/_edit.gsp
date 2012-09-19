


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="ladrr.step.subject.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="ladrr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="ladrr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'ladrr.property.atelierEveil.label')}&nbsp;*&nbsp;:</dt><dd id="atelierEveil" class="action-editField validate-localReferentialData required-true i18n-ladrr.property.atelierEveil data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'atelierEveil', 'lrEntries': lrTypes.atelierEveil?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.atelierEveil?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'ladrr.property.atelierEveilPrecisionChoix.label')}&nbsp;:</dt><dd id="atelierEveilPrecisionChoix" class="action-editField validate-regex i18n-ladrr.property.atelierEveilPrecisionChoix rows-3 maxLength-255" regex="^[\w\W]{0,255}$"><span>${rqt?.atelierEveilPrecisionChoix}</span></dd>
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
