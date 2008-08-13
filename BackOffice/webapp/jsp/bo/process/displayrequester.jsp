<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="requester" name="stateManager" property="selectedRecord.demander" scope="session"/>

  <div class="grid_cell">
    <div class="block009">
      <p class="text005 pictoAdults">Demandeur</p>
    </div>

    <div class="block010">
      <fieldset class="fieldset005">
        <div class="form_cell form_cell1">
          <label for="title" class="label">Civilité :</label>
          <span class="input"><cvq:toggleInput name="requester" property="title" id="id" type="title"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="lastName" class="label">Nom :</label>
          <span class="input"><cvq:toggleInput name="requester" property="lastName" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="firstName" class="label">Prénom :</label>
          <span class="input"><cvq:toggleInput name="requester" property="firstName" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="maidenName" class="label">Nom de jeune fille :</label>
          <span class="input"><cvq:toggleInput name="requester" property="maidenName" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="birthDate" class="label">Date de naissance :</label>
          <span class="input"><cvq:toggleInput name="requester" property="birthDate" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="additionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
          <span class="input"><cvq:toggleInput name="requester" property="additionalDeliveryInformation" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="additionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
          <span class="input"><cvq:toggleInput name="requester" property="additionalGeographicalInformation" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="streetNumber" class="label">Numéro :</label>
          <span class="input"><cvq:toggleInput name="requester" property="streetNumber" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="streetName" class="label">Libellé de la voie :</label>
          <span class="input"><cvq:toggleInput name="requester" property="streetName" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="placeNameOrService" class="label">Lieu-dit, boite postale :</label>
          <span class="input"><cvq:toggleInput name="requester" property="placeNameOrService" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="postalCode" class="label">Code postal :</label>
          <span class="input"><cvq:toggleInput name="requester" property="postalCode" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="city" class="label">Localité :</label>
          <span class="input"><cvq:toggleInput name="requester" property="city" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="homePhone" class="label">Téléphone :</label>
          <span class="input"><cvq:toggleInput name="requester" property="homePhone" id="id"/></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="email" class="label">Courriel :</label>
          <span class="input"><cvq:toggleInput name="requester" property="email" id="id"/></span>
        </div>

        <div class="form_cell form_cell1">
          <label for="meansOfContact" class="label">Moyen de contact :</label>
          <span class="input"><cvq:toggleInput name="stateManager" property="selectedRecord.meansOfContact" id="selectedRecord.id" scope="session"/></span>
        </div>
      </fieldset>
    </div>
  </div>


