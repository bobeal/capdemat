<g:if test="${params.type == 'invoice'}">
   <h2><g:message code="payment.header.invoiceDetails" /></h2>
   <ul>
     <g:each var="record" in="${items}">
       <li>
         <p>${record.label} pour ${record.subjectName}</p>
         <p>
           Quantité : ${record.quantity}
           <g:if test="${record.unitPrice}">
             (prix unitaire : ${record.unitPrice / 100} €)
           </g:if>
           <g:if test="${record.value}">
             - Valeur : ${record.value / 100} €
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
             Paiement ${record.paymentId} de ${record.value / 100} € fait par ${record.paymentType}
           </p>
           <p>
             Effectué le <g:formatDate date="${record.date}" formatName="format.date"/> par ${record.holderName}
           </p>
         </g:if>
         <g:else>
           <p>Débit de ${record.value / 100} €</p>
         </g:else>
       </li>
     </g:each>
   </ul>
 </g:elseif>
 