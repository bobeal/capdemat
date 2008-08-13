<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<%-- <script language="javaScript" src="<%= request.getContextPath() + "/js/calendar.js"%>">
</script> --%>

<html:form action="/accountSearchAction.do?family" styleClass="form_block">
  <fieldset class="fieldset001">
    <div class="form_cell form_cell001">
      <label for="lastName" class="label">Nom de l'habitant :</label>
      <html:text property="lastName" styleClass="input_text"/>
    </div>
    
    <div class="form_cell form_cell002">
      <label for="familyId" class="label">N° du compte :</label>
      <html:text property="familyId" styleClass="input_text"/>
    </div>
    
    <div class="form_cell form_cell001">
      <label for="firstName" class="label">Prénom de l'habitant :</label>
      <html:text property="firstName" styleClass="input_text"/>
    </div>

    <div class="form_cell form_cell002">
      <label for="state" class="label">Etat du compte :</label>
  		<cvq:referenceSelect name="stateManager"
				property=""
				value="accountSearch.state"
				scope="session"
				id="state"
				styleClass="input_select"
				search="true">
  			<option value="Archived">Archivé</option>
  		</cvq:referenceSelect>
    </div>
    
    <div class="form_cell form_cell001">
      <label for="state" class="label">Date de naissance :</label>
      <div class="periodCalendar">
        <input width="126" type="text" class="input_short_text" value="" id="birthDate" name="birthDate"/>
        <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="birthDateButton" /></span>
        <script type="text/javascript">
          Calendar.setup({
            inputField :  "birthDate",
            button :      "birthDateButton"
          });
        </script>
      </div>
      <div class="clear-both"></div>
<%--        <cvq:date name="AccountSearchForm" property="birthDate" scope="session" styleClass="input_short_text" />  --%>
    </div>
    
  </fieldset>

  <fieldset class="fieldset002">
    <div class="form_cell">
      <input type="submit" class="input_submit" name="choice" value="<bean:message key='action.search'/>"/>
    </div>
  </fieldset></html:form><%-- BUG MSIE6 --%>
