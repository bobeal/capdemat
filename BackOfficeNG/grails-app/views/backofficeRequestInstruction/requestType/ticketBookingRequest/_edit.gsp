


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="tbr.step.requester.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="tbr.step.entertainments.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="tbr.step.rules.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="tbr.step.requester.label" /></span>
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
          <span><g:message code="tbr.step.entertainments.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-hasSubscriberNumber-trigger"><g:message code="tbr.property.isSubscriber.label" /> * : </dt><dd id="isSubscriber" class="validate-boolean required-true i18n-tbr.property.isSubscriber" ><span class="value-${rqt?.isSubscriber}"><g:message code="message.${rqt?.isSubscriber ? 'yes' : 'no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberNumber.label" /> * : </dt><dd id="subscriberNumber" class="validate-token required-true i18n-tbr.property.subscriberNumber" ><span>${rqt?.subscriberNumber}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberFirstName.label" /> * : </dt><dd id="subscriberFirstName" class="validate-string required-true i18n-tbr.property.subscriberFirstName" ><span>${rqt?.subscriberFirstName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-hasSubscriberNumber-filled"><g:message code="tbr.property.subscriberLastName.label" /> * : </dt><dd id="subscriberLastName" class="validate-string required-true i18n-tbr.property.subscriberLastName" ><span>${rqt?.subscriberLastName}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <div id="widget-tbrTicket" class="required">
                <g:render template="/backofficeRequestInstruction/requestType/ticketBookingRequest/tbrTicket" model="['rqt':rqt]" />
              </div>
              
            
              
              <dl>
                <dt class="required"><g:message code="tbr.property.totalPrice.label" /> * : </dt><dd id="totalPrice" class="validate-decimal required-true i18n-tbr.property.totalPrice" ><span>${rqt?.totalPrice}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class=""><g:message code="tbr.property.paymentReference.label" />  : </dt><dd id="paymentReference" class="validate-string i18n-tbr.property.paymentReference" ><span>${rqt?.paymentReference}</span></dd>
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
          <span><g:message code="tbr.step.rules.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="tbr.property.rulesAndRegulationsAcceptance.label" /> * : </dt><dd id="rulesAndRegulationsAcceptance" class="validate-acceptance required-true i18n-tbr.property.rulesAndRegulationsAcceptance" ><span class="value-${rqt?.rulesAndRegulationsAcceptance}"><g:message code="message.${rqt?.rulesAndRegulationsAcceptance ? 'yes' : 'no'}" /></span></dd>
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
