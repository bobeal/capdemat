<g:if test="${params.type == 'invoice'}">
   <h2><g:message code="payment.header.invoiceDetails" /></h2>
   <ul>
     <g:each var="record" in="${items}">
       <li>
         <p>${record.label} <g:message code="message.for" /> ${record.subjectName}</p>
         <p>
           <g:message code="payment.header.quality" /> : ${record.quantity}
           <g:if test="${record.unitPrice}">
             (<g:message code="payment.header.unitPrice" /> : ${record.unitPrice / 100} €)
           </g:if>
           <g:if test="${record.value}">
             - <g:message code="payment.header.value" /> : ${record.value / 100} €
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
           <p>
             <g:message 
               code="payment.header.paymentOfMadeBy" 
               args="${[record.paymentId,(record.value/100)+' €',record.paymentType]}"
             />
           </p>
           <p>
             <g:message 
               code="payment.header.madeAtBy"
               args="${[formatDate(date:record.date,formatName:'format.date'),record.holderName]}"
             />
           </p>
         </g:if>
         <g:else>
           <p>
             <g:message code="payment.header.debitOf" args="${[(record.value / 100)+' €']}" />
           </p>
         </g:else>
       </li>
     </g:each>
   </ul>
 </g:elseif>
 