<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<!-- No category configurated -->
<logic:empty name="AdminForm" property="category">
<div class="grid_cell grid_column_right">
  <html:form action="/adminAction.do?save=category" styleClass="form_block form_block003">
    <div class="block008">
      <p class="text011 pictoXXX">Aucune catégorie</p>
    </div>
    <div class="block017">
      <fieldset class="fieldset010">
        <div class="form_cell">
          <span class="input_button"><input type="submit" class="input_add" name="createChoice" value="<bean:message key='action.create'/>"/></span>
        </div>
      </fieldset>
    </div>
  </html:form>
</div>
</logic:empty>

<!-- At least one category configurated-->
<logic:notEmpty name="AdminForm" property="category">
<div class="grid_cell grid_column_right">
<html:form action="/adminAction.do?save=category" styleClass="form_block form_block003">
<html:hidden property="categoryId"/>
  <div class="block008">
    <p class="text011 pictoXXX"><bean:write name="AdminForm" property="categoryName" /></p>
  </div>
  <div class="block017">
  
    <fieldset class="fieldset010">
      <div class="form_cell">
        <span class="input_button"><input type="submit" class="input_add" name="createChoice" value="<bean:message key='action.create'/>"/></span>
        <span class="input_button"><input type="submit" class="input_delete" name="deleteChoice" value="<bean:message key='action.suppress'/>"/></span>
      </div>
    </fieldset>
    
    <fieldset class="fieldset010">
      <div class="form_cell form_cell001">
        <label for="categoryName" class="label">Nom de la catégorie :</label>
        <span class="input"><html:text property="categoryName" styleId="categoryName" styleClass="input_text"/></span>
      </div>
      <div class="form_cell form_cell001">
        <label for="categoryEmail" class="label">Courriel de contact :</label>
        <span class="input"><html:text property="categoryEmail" styleId="categoryEmail" styleClass="input_text"/></span>
      </div>
      <div class="form_cell form_cell002">
        <span class="input"><input type="submit" class="input_submit" name="saveChoice" value="<bean:message key='action.save'/>"/></span>
      </div>
    </fieldset>
    
    <div class="block018">
      <cvq:resultDisplay name="AdminForm" property="rtypes" styleClass="table007" />
    </div>
  </div>
</html:form>
</div>

<div class="grid_cell grid_column_left">
  <div class="block008">
    <p class="text010 pictoMan">Droits des agents :</p>
  </div>
  <div class="block015">
    <cvq:resultDisplay name="AdminForm" property="users" disabled="true" styleClass="table008" />
  </div>
</div>

</logic:notEmpty>
