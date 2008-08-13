<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="familyRecord" name="stateManager" property="selectedRecord" scope="session"/>
<script type="text/javascript">
	function checkStates() {
		var elEnabled = document.getElementById("enabled");
		var elArchived = document.getElementById("archived");
		
		if (elArchived.checked) {
			elEnabled.disabled = true;
			elEnabled.checked = false;
		} else { 
			elEnabled.disabled = false;
			if (elEnabled.checked) {
				elArchived.checked = false;
			}
		}
	}
	
	function confirmArchive() {
		var elArchived = document.getElementById("archived");
		
		var submitOk = !elArchived.disabled;
		if (elArchived.checked && submitOk) {
			var confirmSubmit = window.confirm("\t\t\tATTENTION ! \nSi vous archivez un compte il ne sera plus accessible pour l'utilisateur. \nUn compte archivé ne peut être ré-activer!\nVoulez-vous continuer?");
			submitOk = ((confirmSubmit != null) && (confirmSubmit == true));
		}
		if (submitOk) {
			var sf = document.forms["saveAccount"];
			sf.submit();
		}
	}

	function popupMedia() {
		window.open('http://formation.valdoise.fr/media/media384337.pps','pps','resizable=yes,top=0,left=110,width=800,height=714')
		document.location.href = "managerWizard.do?transition=account"
	}
</script>

<cvq:indexform name="saveAccount" action="/saveAction.do?family" styleClass="form_block" styleId="saveAccount">

<div class="grid_cell">
  <div class="block006">
    <p class="text002 pictoFormular">Gestion du compte</p>
  </div>

  <div class="block004">
    <fieldset class="fieldset007">
      <div class="form_cell">
        <label for="enabled" class="label">Compte activé :</label>
        <span class="input" onclick="javascript:checkStates();"><html:checkbox name="familyRecord" property="enabled" styleId="enabled" styleClass="input_radio" /></span>
      </div>
      
      <div class="form_cell">
        <label for="archived" class="label">Compte archivé :</label>
        <span class="input" onclick="javascript:checkStates();"><html:checkbox name="familyRecord" property="archived" styleId="archived" styleClass="input_radio" /></span>
      </div>
      
      <div class="form_cell">
        <label for="familyQuotient" class="label">Quotient familial :</label>
        <span class="input" onclick="javascript:checkStates();"><html:text name="familyRecord" property="familyQuotient" styleClass="input_text"/></span>
      </div>
      
      <div class="form_cell">
        <span class="input">
          <input type="button" class="input_submit" name="save" value="Enregistrer" onclick="javascript:confirmArchive();"/>
        </span>
      </div>
    </fieldset>
  </div>
</div>
</cvq:indexform>


<div class="grid_cell">
  <div class="block002">
    <p class="text002 pictoStatus">Badges des membres du compte</p>
  </div>

  <div class="block004">
    <cvq:resultDisplay name="familyRecord" property="accounts" scope="page" styleClass="table002"/>
  </div>
</div>


<script type="text/javascript">
	var elEnabled = document.getElementById("enabled");
	var elArchived = document.getElementById("archived");

	if (elArchived.checked) {
		elEnabled.disabled = true;
		elArchived.disabled = true;
	}
</script>