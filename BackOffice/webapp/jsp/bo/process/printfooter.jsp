<%@ page contentType="text/html; charset=UTF-8" %>

<script>
var mail = null;
var sms = null;

function setMail() {
	if (mail == null) {
		mail = document.getElementById('maildiv');
		mail.style.display = 'none';
	}
}

function setSms() {
	if (sms == null) {
		sms = document.getElementById('smsdiv');
		sms.style.display = 'none';	
	}
}

function select(id) {
	var contact=document.getElementById(id);
	var value = contact.value;
	
	if (value == 'Courriel') {
		mail.style.display = '';
		sms.style.display = 'none';
	} else if (value == 'SMS') {
		sms.style.display = '';
		mail.style.display = 'none';
	} else {
		mail.style.display = 'none';
		sms.style.display = 'none';
	}
}

function checkValid(idSelect, idButton) {
	var selectElem = document.getElementById(idSelect);
	if (selectElem.value == '') {
		var buttonElem = document.getElementById(idButton);
		buttonElem.disabled = true;
	}
}

function submitMail(form) {
	
		var sf = document.forms[0];
		sf.action = "notifyAction.do";
		sf.submit();
}

function submitPreview(form) {
		var sf = document.forms[0];
		sf.action = "printAction.do";
		sf.submit();
}

</script>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>



    <fieldset class="fieldset003">
      <div class="form_cell form_cell004">
        <span class="input_button">
          <cvq:input type="button"
            styleClass="input_account"
            property="compte"
            onclick="location.href='familyAction.do?action=view'"
            value="accès au compte"
            profile="profile"/>
        </span>
      </div>
    </fieldset>
  </div>
</div>

<div class="grid_cell grid_column_right">
  <div class="block006">
    <p class="text004 pictoStatus">Etat de la demande</p>
  </div>

  <div class="block007">
    <fieldset class="fieldset003">
      <div class="form_cell form_cell001">
        <span class="input">
          <cvq:referenceSelect name="stateManager"
            property="filteredRequestStates"
            scope="session"
            value="selectedRecord.state"
            id="state"
            styleClass="input_select"
            empty="false"
            profile="profile"/>
        </span>
        <span class="input">
          <cvq:input type="submit"
          styleClass="input_submit"
          property="check"
          value="Enregistrer"
          profile="profile"/>
        </span>
      </div>
    </fieldset>
  </div>
</div>

<div class="grid_cell grid_column_left">
  <div class="block006">
    <p class="text003 pictoContact">Contact avec l'habitant (<bean:write name="stateManager" property="selectedRecord.meansOfContact" scope="session"/>)</p>
  </div>

  <div class="block005">
    <fieldset class="fieldset006">
      <div class="form_cell form_cell003">
        <label for="certificat" class="label">Eléments à éditer :</label>
        <span class="input">
          <cvq:referenceSelect name="stateManager"
            property="deliveryCertificats"
            scope="session"
            key="shortLabel"
            label="shortLabel"
            value="currentLetterTypeRecord"
            id="certificat"
            styleClass="input_select"
            onchange="checkValid('certificat','print')"
            empty="false"
            profile="profile"/>
        </span>
      </div>
      <div class="form_cell form_cell003">
        <label for="contact" class="label">Moyen d'envoi :</label>
        <span class="input">
          <cvq:referenceSelect name="stateManager"
            property="meansOfContact"
            scope="session"
            value="selectedRecord.meansOfContact"
            id="contact"
            styleClass="input_select"
            onchange="select('contact')"
            empty="false"
            profile="profile"/>
        </span>
        <span class="input" id="maildiv">
          <cvq:input type="text" styleClass="input_text" name="SaveForm" property="mail" value="mail" profile="profile"/>
        </span>
        <span class="input" id="smsdiv">
          <cvq:input type="text" styleClass="input_text" name="SaveForm" property="mobilePhone" value="mobilePhone" profile="profile"/>
        </span>
        <span class="input">
          <input type="hidden" id="lp7" name="lp7"/>
          <!--<cvq:input type="submit"
            onclick="location.href='signAction.do?preview=instruction'"
            styleClass="boutonfix"
            property="sign"
            value="Signer"
            profile="profile"/>-->
        </span>
      </div>
      <div class="form_cell">
        <span class="input">
          <cvq:textarea name="stateManager" property="selectedRecord.instructionExternal" id="deliveryExternal" rows="5" cols="50" styleClass="input_textarea" profile="profile" />
        </span>
      </div>
      <div class="form_cell form_cell003">
        <span class="input_button">
          <cvq:input type="button"
            styleClass="input_view"
            property="print"
            onclick="javascript:submitPreview('SaveForm')"
            value="aperçu du document"
            profile="profile"/>
        </span>
        <span class="input_button">
          <cvq:input type="button"
            styleClass="input_send"
            property="send"
            onclick="javascript:submitMail('SaveForm')"
            value="envoyer le document"
            profile="profile"/>
        </span>
        <span class="input">
          <cvq:input type="submit"
            styleClass="input_submit"
            property="check"
            value="Enregistrer"
            profile="profile"/>
        </span>
      </div>
    </fieldset>
  </div>
</div>
<div class="grid_cell grid_column_right">
  <div class="block006">
    <p class="text004 pictoComment">Commentaires internes</p>
  </div>

  <div class="block007">
    <fieldset class="fieldset003">
      <div class="form_cell">
        <span class="input">
          <cvq:textarea name="stateManager" property="selectedRecord.instructionInternal" id="deliveryInternal" rows="5" cols="20" styleClass="input_textarea" profile="profile"/>
        </span>
      </div>
      <div class="form_cell form_cell003">
        <span class="input">
          <cvq:input type="submit"
          styleClass="input_submit"
          property="check"
          value="Enregistrer"
          profile="profile"/>
        </span>
      </div>
    </fieldset>
  </div>
</div>

<div class="clear-both"></div>
  
  
</form>

<script>
	setMail();
	setSms();
	select('contact');
	checkValid('certificat','print');
</script>
