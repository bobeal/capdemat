<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<form method="post" action="saveAction.do?demand" class="form_block">

<div class="grid_cell">
  <div class="block006">
    <p class="text003 pictoStatus">Information sur la <cvq:liason name="stateManager" property="selectedRecord.typeLabel" prefix="demande" article="de" scope="session"/> - référence <bean:write  name="stateManager" property="selectedRecord.id" scope="session" /></p>
	<cvq:indicator name="stateManager" property="selectedRecord.temporary" img="img/HorsFoyer.gif"/>
  </div>

  <div class="block005">

