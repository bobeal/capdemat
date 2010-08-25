<h3>
  ${item.label} - ${item.id}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      <dt><g:message code="payment.item.property.type"/> :</dt>
      <dd>
        <g:message code="payment.item.property.type.${item.type()}"/>
      </dd>

      <dt><g:message code="payment.item.property.amount"/> :</dt>
      <dd>
         ${item.amount}
      </dd>
      <!-- InternalInvoiceItem -->
      <g:if test="${item.type() == 'InternalInvoiceItem'}">
        <dt><g:message code="payment.item.property.quantity"/> :</dt>
        <dd>
         ${item.quantity}
        </dd>
        <dt><g:message code="payment.item.property.unitPrice"/> :</dt>
        <dd>
         ${item.unitPrice}
        </dd>
      </g:if>
      
      <!-- ExternalInvoiceItem -->
      <g:if test="${item.type() == 'ExternalInvoiceItem'}">
        <dt><g:message code="payment.item.property.externalServiceLabel"/> :</dt>
        <dd>
        ${item.externalServiceLabel}
        </dd>
        <dt><g:message code="payment.item.property.issueDate"/> :</dt>
        <dd>
        <g:formatDate formatName="format.date" date="${item.issueDate}" />
        </dd>
        <dt><g:message code="payment.item.property.expirationDate"/> :</dt>
        <dd>
        <g:formatDate formatName="format.date" date="${item.expirationDate}" />
        </dd>
      </g:if>
      
      <!-- ExternalDepositAccountItem -->
      <g:if test="${item.type() == 'ExternalDepositAccountItem'}">
        <dt><g:message code="payment.item.property.externalServiceLabel"/> :</dt>
        <dd>
        ${item.externalServiceLabel}
        </dd>
        <dt><g:message code="payment.item.property.oldValue"/> :</dt>
        <dd>
         ${item.oldValue}
        </dd>
        <dt><g:message code="payment.item.property.oldValueDate"/> :</dt>
        <dd>
        <g:formatDate formatName="format.date" date="${item.oldValueDate}" />
        </dd>
      </g:if>
      
      <!-- ExternalTicketingContractItem -->
      <g:if test="${item.type() =='ExternalTicketingContractItem'}">
        <dt><g:message code="payment.item.property.externalServiceLabel"/> :</dt>
        <dd>
        ${item.externalServiceLabel}
        </dd>
        <dt><g:message code="payment.item.property.oldQuantity"/> :</dt>
        <dd>
         ${item.oldQuantity}
        </dd>
        <dt><g:message code="payment.item.property.creationDate"/> :</dt>
        <dd>
         <g:formatDate formatName="format.date" date="${item.creationDate}" />
        </dd>
      </g:if>
    </dl>

  </div>
</div>