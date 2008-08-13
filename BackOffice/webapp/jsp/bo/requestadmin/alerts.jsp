<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<html:form action="/requestAction.do?save=alert" styleClass="form_block">

<div class="grid_cell">
  <div class="block002">
    <p class="text002 XXX"><bean:write name="RequestForm" property="requestType.label"/> > Gestion de la qualité de service</p>
  </div>
  
  <div class="block004">
    <div class="grid_cell">
      <p class="text001">Pour gérer la qualité de service vous pouvez définir des délais de traitement, ainsi des alertes vous informerons si les demandes ne sont pas traitées dans les délais sélectionnés.</p>
    </div>
    <div class="grid_cell">
      <fieldset class="fieldset007">
        <div class="form_cell">
          <label for="maxDelay" class="label">Délai maximum pour traiter la demande (en jours) :</label>
          <span class="input"><html:text property="maxDelay" styleId="maxDelay" styleClass="input_short_text" size="5"/></span>
        </div>
        <div class="form_cell">
          <label for="alertDelay" class="label">Nombre de jour(s) avant le délai maximum pour être averti :</label>
          <span class="input"><html:text property="alertDelay" styleId="alertDelay" styleClass="input_short_text" size="5"/></span>
        </div>
        <div class="form_cell">
          <span class="input"><input type="submit" class="input_submit" name="save" value="<bean:message key='action.save'/>"/></span>
        </div>
      </fieldset>
    </div>
    <div class="clear-both"></div>
  </div>
</div>


</html:form>