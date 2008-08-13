<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:form action="/messageAction.do" styleClass="form_block">

<div class="grid_cell">
  <div class="block006">
    <p class="text002 pictoContact">Message d'information à destination des habitants concernant l'arrêt du paiement en ligne</p>
  </div>
  <div class="block004">
    <fieldset class="fieldset009">
      <div class="form_cell">
        <label for="blockPayment" class="label">Arrêter le paiement en ligne pour les habitants</label>
        <span class="input"><html:checkbox property="blockPayment" styleId="blockPayment" styleClass="input_radio"/></span>
      </div>
      <div class="form_cell">
        <span class="input"><html:textarea property="message" styleClass="input_textarea" rows="15" cols="100"/></span>
      </div>
      <div class="form_cell form_cell002">
        <span class="input"><input type="submit" class="input_submit" name="save" value="<bean:message key='action.save'/>"/></span>
      </div>
    </fieldset>
  </div>
</div>

</html:form>