<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>

<div class="label-field">
  	<label for="meansOfContact" class="label">
		Moyen de contact :
	</label>
      	<cvq:toggleInput name="record" property="meansOfContact" id="id" profile="profile"/>
  </div>
<div class="label-field">
  	<label for="total" class="label">
		Total :
	</label>
      	<cvq:toggleInput name="record" property="total" id="id" profile="profile"/>
  </div>
<div class="label-field">
  	<label for="invoice" class="label">
		Factures payés :
	</label>
      	<cvq:toggleInput name="record" property="invoice">
          <invoiceCategory,Service>
	      <invoicePeriod,Période>
	      <invoiceAmount,Montant>
	      <invoiceReference,Réf. facture>
		</cvq:toggleInput>
  </div>

<script type="text/javascript">
	function selectionData() {
            		this.meansOfContact = new Function("key","this.multiple=true;this.values=new Array(); return this[key];");
	                            		}
</script>
