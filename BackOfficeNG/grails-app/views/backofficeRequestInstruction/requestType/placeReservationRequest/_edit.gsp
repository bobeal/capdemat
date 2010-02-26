


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="prr.step.requester.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="prr.step.subscriber.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="prr.step.places.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="prr.step.requester.label" /></span>
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
          <span><g:message code="prr.step.subscriber.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-hasSubscriberNumber-trigger"><g:message code="prr.property.isSubscriber.label" /> * : </dt><dd id="isSubscriber" class="action-editField validate-boolean required-true i18n-prr.property.isSubscriber" ><span class="value-${rqt?.isSubscriber}"><g:message code="message.${rqt?.isSubscriber ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="condition-hasSubscriberNumber-filled"><g:message code="prr.property.subscriberNumber.label" />  : </dt><dd id="subscriberNumber" class="action-editField validate- i18n-prr.property.subscriberNumber" ><span>${rqt?.subscriberNumber}</span></dd>
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
          <span><g:message code="prr.step.places.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <div id="widget-placeReservation" class="required">
                <g:render template="/backofficeRequestInstruction/requestType/placeReservationRequest/placeReservation" model="['rqt':rqt]" />
              </div>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="prr.property.paymentReference.label" />  : </dt><dd id="paymentReference" class="action-editField validate-string i18n-prr.property.paymentReference" ><span>${rqt?.paymentReference}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
