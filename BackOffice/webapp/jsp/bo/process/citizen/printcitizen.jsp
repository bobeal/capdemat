<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<fieldset class="fieldset004">
  <div class="form_cell">
    <label for="adults" class="label">Nom des adultes :</label>
    <span class="input"><cvq:displayPerson name="stateManager" property="selectedRecord" scope="session" type="adults"/></span>
  </div>
  
  <div class="form_cell">
    <label for="children" class="label">Nom des enfants :</label>
    <span class="input"><cvq:displayPerson name="stateManager" property="selectedRecord" scope="session" type="children"/></span>
  </div>
</fieldset>

<fieldset class="fieldset003">
  <div class="form_cell form_cell004">
    <span class="input_button">
      <cvq:input type="button"
        styleClass="input_print"
        property="ticket"
        value="Imprimer le ticket"
        onclick="document.location.href='printAction.do?ticket'"
        profile="profile"/>
    </span>
  </div>
</fieldset>
