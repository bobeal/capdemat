<g:if test="${params.type == 'invoice'}">
   <h2><g:message code="payment.header.invoiceDetails" /></h2>
   <ul>
     <g:each var="record" in="${items}">
       <li>
         <h3>${record.label} <g:message code="message.for" /> ${record.subjectName}</h3>
         <p>
           <g:message code="payment.property.quantity" /> : ${record.quantity}
           <g:if test="${record.unitPrice}">
             (<g:message code="payment.header.unitPrice" /> : ${(record.unitPrice / 100).floatValue()} €)
           </g:if>
           <g:if test="${record.value}">
             - <g:message code="payment.header.value" /> : ${(record.value / 100).floatValue()} €
           </g:if>
         </p>
       </li>
     </g:each>
   </ul>
</g:if>
<g:elseif test="${params.type == 'deposit'}">
   <h2><g:message code="payment.header.depositAccountDetails" /></h2>
   <ul>
     <g:each var="record" in="${items}">
       <li>
         <g:if test="${record.paymentId}">
           <h3>
             <g:message code="payment.header.paymentOfMadeBy" 
               args="${[record.paymentId,(record.value/100).floatValue()+' €',record.paymentType]}"/>
           </h3>
         </g:if>
         <g:else>
           <h3>
             <g:message code="payment.header.debitOf" 
               args="${[(record.value / 100).floatValue()+' €']}" />
           </h3>
         </g:else>
         <p>
           <g:message code="payment.header.madeAtBy"
             args="${[formatDate(date:record.date,formatName:'format.fullDate'),record.holderName]}"/>
         </p>
       </li>
     </g:each>
   </ul>
</g:elseif>
 
