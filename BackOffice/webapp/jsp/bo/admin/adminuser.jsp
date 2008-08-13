<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<div class="grid_cell grid_column_right">
<html:form action="/adminAction.do?save=user" styleClass="form_block form_block003">
<html:hidden property="userId"/>
  <div class="block008">
    <p class="text011 pictoMan"><bean:write name="AdminForm" property="lastName"/> <bean:write name="AdminForm" property="firstName"/></p>
  </div>
  <div class="block017">
    <fieldset class="fieldset010">
      <div class="form_cell">
        <span class="label">Login de l'agent :</span>
        <span class="input input_value"><bean:write name="AdminForm" property="displayLogin(25)" filter="false"/></span>
      </div>
      <div class="form_cell">
        <span class="label">Nom de l'agent :</span>
        <span class="input input_value"><bean:write name="AdminForm" property="lastName"/></span>
      </div>
      <div class="form_cell">
        <span class="label">Prénom de l'agent :</span>
        <span class="input input_value"><bean:write name="AdminForm" property="firstName"/></span>
      </div>
      <div class="form_cell">
        <span class="label">Droits de l'agent :</span>
        <span class="input input_value"><bean:write name="AdminForm" property="profile"/></span>
      </div>
    </fieldset>
    
    <div class="block018">
      <cvq:resultDisplay name="AdminForm" property="categories" styleClass="table007"/>
    </div>
    
    <fieldset class="fieldset010">
      <div class="form_cell form_cell003">
        <span class="input"><input type="submit" class="input_submit" name="choice" value="<bean:message key='action.save'/>"/></span>
      </div>
    </fieldset>
  </div>
  
</html:form>
</div>
