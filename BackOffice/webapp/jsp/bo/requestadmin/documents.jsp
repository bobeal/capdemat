<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<html:form action="/requestAction.do?save=documents" styleClass="form_block">

<div class="grid_cell">
  <div class="block002">
		<p class="text002 XXX"><bean:write name="RequestForm" property="requestType.label"/> > Gestion des pièces justificatives</p>
  </div>
  
  <div class="block004">
    <div class="grid_cell">
		  <p class="text001">Vous pouvez demander dans le cadre du télé-service la présentation de pièces justificatives sous format numérique. Sélectionnez dans la liste les pièces choisies et validez en appuyant sur « enregistrer ».</p>
    </div>
		<div class="grid_cell">
      <div class="block011">
			  <cvq:resultDisplay name="RequestForm" property="documents" styleClass="table002" height="overflow003"/>
      </div>
		</div>
    <div class="grid_cell">
      <fieldset class="fieldset007">
        <div class="form_cell">
          <span class="input"><input type="submit" class="input_submit" name="save" value="<bean:message key='action.save'/>"/></span>
        </div>
      </fieldset>
    </div>
    <div class="clear-both"></div>
  </div>
</div>

</html:form>