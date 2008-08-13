<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<%@ taglib uri="/WEB-INF/tlds/reporting.tld" prefix="cvq-report" %>

<div class="block_head">
  <div class="left"></div>
  <div class="center"><span class="element first pictoReport">Résultats</span></div>
  <div class="right"></div>
</div>

<div class="grid_cell">
  <div class="block019">
    <cvq:resultDisplay name="stateManager" property="reportRecords" type="type" styleClass="table009"/>
  </div>
</div>
  
<div class="grid_cell">
  <div class="block020 image_generation">
    <cvq-report:reportChart name="stateManager" property="reportRecords" type="type" styleClass="pie"/>
  </div>
</div>


