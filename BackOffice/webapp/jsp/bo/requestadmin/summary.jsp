<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<script language="JavaScript">
function confirmSave(form, activate) {
	var message = "Si vous dépubliez une demande, la télé-procédure ne sera plus accessible pour l'usager. "
	if (activate)
		message = "Si vous publiez une demande, la télé-procédure sera immédiatement disponible pour l'usager. "
	var cancelWindow = window.confirm("\t\t\tATTENTION ! \n" + message + "\nVoulez-vous continuer?");
	if (cancelWindow != null) {
		if (cancelWindow == true) {
			form.submit();
		}
	}
}
</script>
  

<html:form action="/requestAction.do?save=activate" styleClass="form_block">

<div class="grid_cell">
  <div class="block002">
    <p class="text002 XXX"><bean:write name="RequestForm" property="requestType.label"/> > Récapitulatif</p>
  </div>
  
  <div class="block004">
    <div class="grid_cell">
      <fieldset class="fieldset003">
          
        <logic:equal name="RequestForm" property="requestType.activated" value="true">
          <div class="form_cell form_cell001">
            <div class="block004">
              <p class="text005 pictoOk"><bean:write name="RequestForm" property="requestType.label"/> : <span class="text015">Publié</span></p>
            </div>
          </div>
          <div class="form_cell form_cell005">
            <span class="input">
              <select name="publish_service" id="publish_service" class="input_select">
                <option value="0">Dépublier le télé-service</option>
              </select>
            </span>
            <span class="input"><input type="button" class="input_submit" name="save" value="Enregistrer" onclick="confirmSave(RequestForm, false)"/></span>
          </div>
        </logic:equal>
          
        <logic:equal name="RequestForm" property="requestType.activated" value="false">
          <div class="form_cell form_cell001">
            <div class="block004">
              <p class="text005 pictoNo"><bean:write name="RequestForm" property="requestType.label"/> : <span class="text014">Non publié</span></p>
            </div>
          </div>
          <div class="form_cell form_cell005">
            <span class="input">
              <select name="publish_service" id="publish_service" class="input_select">
                <option value="1">Publier le télé-service</option>
              </select>
            </span>
            <span class="input"><input type="button" class="input_submit" name="save" value="Enregistrer" onclick="confirmSave(RequestForm, true)"/></span>
          </div>
        </logic:equal>

      </fieldset>
    </div>

  <logic:equal name="RequestForm" property="scanDocumentData" value="true">  
    <div class="grid_cell">
      <div class="block008">
        <p class="text006 pictoInformation">Justificatifs demandés :</p>
      </div>
      <div class="block011">
        <table class="table_default table006">
          <logic:iterate name="RequestForm" property="documents" scope="session" id="document">
            <logic:equal name="document" property="used" value="true">
            <tr>
              <td class="td"><bean:write name="document" property="label"/></td>
            </tr>
            </logic:equal>
          </logic:iterate>
        </table>
      </div>
    </div>
  </logic:equal>

  <logic:equal name="RequestForm" property="requestType.seasonable" value="true">
    <div class="grid_cell">
      <div class="block008">
        <p class="text006 pictoInformation">Résumé des saisons :</p>
      </div>
      <div class="block011">
        <cvq:resultDisplay name="RequestForm" property="seasons" onclick="select" styleClass="table002" />
      </div>
    </div>
  </logic:equal>

  <logic:equal name="RequestForm" property="alertsEnabled" value="true">
    <div class="grid_cell">
      <div class="block008">
        <p class="text006 pictoInformation">Les alertes :</p>
      </div>
      <div class="block011">
        <table class="table_default table006">
          <tr>
            <td class="td">Délai maximum pour traiter la demande (en jours):</td>
            <td class="td"><bean:write name="RequestForm" property="maxDelay"/></td>
          </tr>
          <tr>
            <td class="td">Nombre de jour(s) avant le délai maximum pour être averti :</td>
            <td class="td"><bean:write name="RequestForm" property="alertDelay"/></td>
          </tr>
        </table>
      </div>
    </div>
  </logic:equal>
  
  <logic:equal name="RequestForm" property="requestType.configurable" value="true">
    <div class="grid_cell">
      <div class="block008">
        <p class="text006 pictoInformation">Les paramètres :</p>
      </div>
      <div class="block004">
        <cvq:referentialDisplay name="RequestForm" property="requestType.parameters" height="100"/>
        <div class="clear-both"></div>
      </div>
    </div>
  </logic:equal>
    
    <div class="grid_cell">
      <div class="block008">
        <p class="text006 pictoInformation">Courriers types fournis :</p>
      </div>
      <div class="block011">
        <table class="table_default table006">
          <logic:iterate name="RequestForm" property="letterTypes" scope="session" id="letterType">
            <tr>
              <td class="td"><bean:write name="letterType" property="shortLabel"/></td>
              <td class="td"><bean:write name="letterType" property="label"/></td>
            </tr>
          </logic:iterate>
        </table>
      </div>
    </div>
    <div class="clear-both"></div>
  </div>
</div>

</html:form>



