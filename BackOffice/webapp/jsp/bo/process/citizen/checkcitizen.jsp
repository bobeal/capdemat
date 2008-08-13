<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

    <div class="grid_cell">
      <fieldset class="fieldset004">
        <div class="form_cell">
          <label for="" class="label">Nom des adultes :</label>
          <span class="input"><cvq:displayPerson name="stateManager" property="selectedRecord" scope="session" type="adults"/></span>
        </div>
        
        <div class="form_cell">
          <label for="" class="label">Nom des enfants :</label>
          <span class="input"><cvq:displayPerson name="stateManager" property="selectedRecord" scope="session" type="children"/></span>
        </div>
        
        <div class="form_cell">
          <label for="" class="label">Code du badge :</label>
          <span class="input"><cvq:input name="stateManager" type="text" styleClass="input_text" property="publicKey" scope="session" value="selectedRecord.publicKey" profile="profile"/></span>
        </div>
      </fieldset>
    </div>

