<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>

<div class="label-field">
  	<label for="requesterLastName" class="label">
		Nom :
	</label>
      	<cvq:toggleInput name="record" property="requesterLastName"/>
  </div>
<div class="label-field">
  	<label for="requesterFirstName" class="label">
		Prénom :
	</label>
      	<cvq:toggleInput name="record" property="requesterFirstName"/>
  </div>
<div class="label-field">
  	<label for="paymentReference" class="label">
		Référence du paiement :
	</label>
      	<cvq:toggleInput name="record" property="paymentReference"/>
  </div>

<script type="text/javascript">
	function selectionData() {
      		}
</script>
