<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="child" name="stateManager" property="selectedRecord.subject" scope="session"/>

  </div>
</div>
<div class="grid_cell">
  <div class="block002">
    <p class="text002 pictoInformation">Informations complémentaires</p>
  </div>

  <div class="block004">
    <div class="grid_cell">
      <div class="block009">
        <p class="text005 pictoTable">Adresse du foyer</p>
      </div>
      <div class="block010">
        <fieldset class="fieldset005">
        <div class="form_cell form_cell1">
          <label for="additionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
          <span class="input"><bean:write name="child" property="additionalDeliveryInformation" scope="page" /></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="additionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
          <span class="input"><bean:write name="child" property="additionalGeographicalInformation" scope="page" /></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="streetNumber" class="label">Numéro :</label>
          <span class="input"><bean:write name="child" property="streetNumber" scope="page" /></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="streetName" class="label">Libellé de la voie :</label>
          <span class="input"><bean:write name="child" property="streetName" scope="page" /></span>
        </div>
        
        <div class="form_cell form_cell1">
          <label for="placeNameOrService" class="label">Lieu-dit, boite postale :</label>
          <span class="input"><bean:write name="child" property="placeNameOrService" scope="page" /></span>
        </div>
        
          <div class="form_cell form_cell1">
            <label for="postalCode" class="label">
              <bean:message key="adult.postalCode"/>
              <bean:message key="field.simple"/>
              </label>
            <span class="input">
              <bean:write name="child" property="postalCode" scope="page" />
            </span>
          </div>
          <div class="form_cell form_cell1">
            <label for="city" class="label">
              <bean:message key="adult.city"/>
              <bean:message key="field.simple"/>
              </label>
            <span class="input">
              <bean:write name="child" property="city" scope="page" />
            </span>
          </div>
        </fieldset>
      </div>
    </div>
    
    <div class="grid_cell">
      <div class="block009">
        <p class="text005 pictoTable">Responsables légaux de l'enfant</p>
      </div>
      <div class="block010">
        <fieldset class="fieldset005">
          <logic:iterate id="adult" name="child" property="legalResponsibles">
          <div class="form_cell form_cell1">
            <label for="name" class="label">
              <bean:write name="adult" property="role" scope="page" />
              <bean:message key="field.simple"/>
            </label>
            <span class="input">
              <bean:write name="adult" property="name" scope="page" filter="false"/>
            </span>
          </div>
          </logic:iterate>
        </fieldset>
      </div>
    </div>
    
    <div class="grid_cell">
      <div class="block008">
        <p class="text006 pictoTable">Frères et soeurs scolarisés</p>
      </div>
      <div class="block011">
        <!-- TABLE TYPE 2 -->
        <cvq:resultDisplay name="child" property="siblings" scope="page" type="children" styleClass="table002"/>
      </div>
    </div>
    
    <div class="clear-both"></div>
