

<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected">
      <a href="#page0"><em><g:message code="msrr.step.subject.label" /></em></a>
    </li>
  
    <li>
      <a href="#page1"><em><g:message code="msrr.step.rules.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="msrr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${request?.subjectFirstName} ${request?.subjectLastName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="msrr.property.activity.label" /> * : </dt><dd id="activity" class="action-editField validate-localReferentialData required-true i18n-msrr.property.activity" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'activity', 'lrEntries': lrTypes.activity?.entries, 
                             'rqt':request, 'isMultiple':lrTypes.activity?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
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
          <span><g:message code="msrr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class=""><g:message code="msrr.property.rulesAndRegulationsAcceptance.label" />  : </dt><dd id="rulesAndRegulationsAcceptance" class="action-editField validate-acceptance i18n-msrr.property.rulesAndRegulationsAcceptance" ><span class="value-${request?.rulesAndRegulationsAcceptance}"><g:message code="message.${request?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
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
