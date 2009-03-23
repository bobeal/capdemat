<g:if test="${params.type == 'invoice'}">
   <h2><g:message code="payment.header.invoiceDetails" /></h2>
   <ul>
     <g:each var="record" in="${items}">
       <li>
         <p> Lebele : ${record.label}</p>
         <p> Subject:  ${record.subjectName}</p>
         <g:if test="${record?.unitPrice}">
          <p> Prix à l'unité:  ${record.unitPrice / 100} €</p>
         </g:if>
         <p> Quantité:  ${record.quantity}</p>
         <g:if test="${record?.value}">
          <p> Valeur:  ${record.value / 100} €</p>
         </g:if>
       </li>
     </g:each>
   </ul>
 </g:if>
 <g:elseif test="${params.type == 'deposit'}">
   <h2><g:message code="payment.header.depositAccountDetails" /></h2>
   <ul>
     <g:each var="record" in="${items}">
       <li>
         <p> ID : ${record.paymentId}</p>
         <p> Type : ${record.paymentType}</p>
         <p> Réf banque : ${record.bankReference}</p>
         <p> Holder:  ${record.holderName}</p>
         <p> Date:  <g:formatDate date="${record.date}" formatName="format.date"/></p>
         <g:if test="${record?.value}">
          <p> Valeur:  ${record.value / 100} €</p>
         </g:if>
       </li>
     </g:each>
   </ul>
 </g:elseif>
 