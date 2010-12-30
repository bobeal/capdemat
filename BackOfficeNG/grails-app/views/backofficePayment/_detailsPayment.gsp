<h3>
  <g:message code="payment.details.general" />
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="payment.property.requester.lastName" /> : </dt> 
      <dd>
        <span>${payment.requesterLastName}</span>
      </dd>
    
      <dt><g:message code="payment.property.requester.firstName" /> : </dt>
      <dd>
        <span>${payment.requesterFirstName}</span>
      </dd>
    
      <dt><g:message code="payment.property.initializationDate" /> : </dt>
      <dd>
        <span><g:formatDate formatName="format.date" date="${payment.initializationDate}" /></span>
      </dd>
    
      <dt><g:message code="payment.property.paymentMode" /> : </dt>
      <dd >
        <span>${payment.paymentMode}</span>
      </dd>
    </dl>
    </div>
    
    <div class="yui-u">
    <dl>
      <dt><g:message code="payment.property.broker" /> : </dt>
      <dd>
        <span>${payment.broker}</span>
      </dd>
    
      <dt><g:message code="payment.property.cvqReference" /> : </dt>
      <dd>
        <span>${payment.cvqReference}</span>
      </dd>
    
      <dt><g:message code="payment.property.bankReference" /> : </dt>
      <dd>
        <span>${payment.bankReference}</span>
      </dd>
    </dl>
    </div>
  </div>

</div>