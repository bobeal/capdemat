<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<div class="grid_cell">
  <div class="block002">
    <p class="text002 pictoStatus">Historique de la <cvq:liason name="stateManager" property="selectedRecord.typeLabel" prefix="demande" article="de" scope="session"/> - référence <bean:write  name="stateManager" property="selectedRecord.id" scope="session" /></p>
  </div>

  <div class="block004">
    <cvq:resultDisplay name="stateManager" property="selectedRecord.history" styleClass="table002" />
  </div>
</div>