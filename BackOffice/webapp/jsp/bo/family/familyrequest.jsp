<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<div class="grid_cell">
  <div class="block002">
    <p class="text002 pictoStatus">Liste des demandes</p>
  </div>

  <div class="block004">
    <cvq:resultDisplay name="stateManager" property="selectedRecord.demands" styleClass="table002"/>
  </div>
</div>


