


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="lpsrr.step.requester.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="lpsrr.step.reservation.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="lpsrr.step.complement.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page3"><em><g:message code="lpsrr.step.rules.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="lpsrr.step.requester.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
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
          <span><g:message code="lpsrr.step.reservation.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-AddressOne-trigger"><g:message code="lpsrr.property.requesterFirstAddressKind.label" /> * : </dt><dd id="requesterFirstAddressKind" class="action-editField validate-capdematEnum required-true i18n-lpsrr.property.requesterFirstAddressKind javatype-fr.cg95.cvq.business.request.urbanism.AccountAddressKindType" ><g:capdematEnumToField var="${rqt?.requesterFirstAddressKind}" i18nKeyPrefix="lpsrr.property.requesterFirstAddressKind" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-AddressOne-filled"><g:message code="lpsrr.property.requesterFirstAddress.label" /> * : </dt><dd id="requesterFirstAddress" class="action-editField validate-string required-true i18n-lpsrr.property.requesterFirstAddress" ><span>${rqt?.requesterFirstAddress}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="condition-AddressTwo-trigger"><g:message code="lpsrr.property.requesterOtherAddressKind.label" />  : </dt><dd id="requesterOtherAddressKind" class="action-editField validate-capdematEnum i18n-lpsrr.property.requesterOtherAddressKind javatype-fr.cg95.cvq.business.request.urbanism.AccountAddressKindType" ><g:capdematEnumToField var="${rqt?.requesterOtherAddressKind}" i18nKeyPrefix="lpsrr.property.requesterOtherAddressKind" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-AddressTwo-filled"><g:message code="lpsrr.property.requesterOtherAddress.label" /> * : </dt><dd id="requesterOtherAddress" class="action-editField validate-string required-true i18n-lpsrr.property.requesterOtherAddress" ><span>${rqt?.requesterOtherAddress}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lpsrr.property.startDate.label" /> * : </dt><dd id="startDate" class="action-editField validate-date required-true i18n-lpsrr.property.startDate" ><span><g:formatDate formatName="format.date" date="${rqt?.startDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="lpsrr.property.duration.label" /> * : </dt><dd id="duration" class="action-editField validate-localReferentialData required-true i18n-lpsrr.property.duration data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'duration', 'lrEntries': lrTypes.duration?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.duration?.isMultiple(), 'depth':0]" />
 
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="lpsrr.step.complement.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
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
          <span><g:message code="lpsrr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
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
