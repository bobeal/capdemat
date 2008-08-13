<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<script>
function printPayments(url) {
		window.open('jsp/bo/service/print.jsp?url='+ url,'print','resizable=no,top=0,left=110,width=1,height=1');
}

</script>

<logic:notPresent parameter="print">
  <logic:notEqual name="stateManager" property="currentSearch.totalRecordNb" scope="session" value="0">
  <table width="100%">
     <tr>
    	<td align="right" >
 		<input type="button" name="print" id="print" onclick="javascript:printPayments('<%=request.getContextPath() + "/jsp/bo/admin/payments.jsp?print"%>')" class="boutonfix" value="Imprimer"/>
    	</td>
   	</tr>
   </table>
   </logic:notEqual>
   <logic:equal name="stateManager" property="currentSearch.totalRecordNb" scope="session" value="0">
   Il n'y a pas eu de réglements pour les critères donnés
   </logic:equal>
</logic:notPresent>

<div style="position:relative;left:10px;overflow:auto;height:100%;min-height:100%;">
	
    <logic:iterate id="payment" name="stateManager" property="paymentSearch.wholeResultsList" scope="session">
    
    	<b><bean:write name="payment" property="label"/></b>
		<br/>
		Réf : <bean:write name="payment" property="reference"/>
		<br/>
		Montant : <bean:write name="payment" property="value"/> &euro; 
		<br/>
		Date : <bean:write name="payment" property="date"/>
		<br/>
		
		<hr width="90%"/>
	
	</logic:iterate> 
	
</div>
