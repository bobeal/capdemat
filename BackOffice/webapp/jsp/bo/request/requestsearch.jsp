<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<%-- <script type="text/javascript" src="<%= request.getContextPath() + "/js/calendar.js"%>">
</script> --%>

<html:form action="/searchAction.do?request" styleClass="form_block">
  <fieldset class="fieldset001">
    <div class="form_cell form_cell001">
      <label for="lastName" class="label">Nom de l'habitant :</label>
      <html:text property="lastName" styleId="lastName" styleClass="input_text"/>
    </div>
    
    <div class="form_cell form_cell002">
      <label for="type" class="label">Type de demande :</label>
      <cvq:referenceSelect name="stateManager" property="types" scope="session" value="currentSearch.type" id="type" styleClass="input_select" search="true"/>
    </div>
    
    <div class="form_cell form_cell001">
      <label for="firstName" class="label">Prénom de l'habitant :</label>
      <html:text property="firstName" styleId="firstName" styleClass="input_text"/>
    </div>
    
    <div class="form_cell form_cell002">
      <label for="state" class="label">Etat de demande :</label>
      <cvq:referenceSelect name="stateManager" property="requestStates" scope="session" value="currentSearch.state" id="state" styleClass="input_select" search="true"/>
    </div>
    
    <div class="form_cell form_cell001">
      <label for="demandId" class="label">N° de demande :</label>
      <html:text property="demandId" styleId="demandId" styleClass="input_text"/>
    </div>
    
    <div class="form_cell form_cell003">
      <label for="periodBegin" class="label">Période de la demande :</label>
      <div class="periodCalendar">
        <input width="126" type="text" class="input_short_text" value="" id="periodBegin" name="periodBegin"/>
        <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="periodBeginButton" /></span>
        <span class="text001">au</span>
        <input width="126" type="text" class="input_short_text" value="" id="periodEnd" name="periodEnd"/>
        <span class="block001"><img border="0" alt="" src="/BackOffice/images/calendrier.gif" id="periodEndButton" /></span>
        <script type="text/javascript">
          Calendar.setup({
            inputField :  "periodBegin",
            button :      "periodBeginButton"
          });
          Calendar.setup({
            inputField :  "periodEnd",
            button :      "periodEndButton"
          });
        </script>
      </div>
      <div class="clear-both"></div>
<%--        <cvq:date name="SearchForm" property="period" scope="session" period="true" styleClass="input_short_text" />  --%>
    </div>
    
    <div class="form_cell form_cell001">
      <label for="familyId" class="label">N° de compte :</label>
      <html:text property="familyId" styleId="familyId" styleClass="input_text"/>
    </div>
    
    <div class="form_cell form_cell002">
      <label for="lastAgent" class="label">Dernier intervenant :</label>
      <cvq:referenceSelect name="stateManager" property="agents" scope="session" value="currentSearch.lastAgent" id="lastAgent" styleClass="input_select" search="true"/>
    </div>
  </fieldset>

  <fieldset class="fieldset002">
    <div class="form_cell">
      <input type="submit" class="input_submit" name="search" value="<bean:message key='action.search'/>"/>
    </div>
  </fieldset></html:form><%-- BUG MSIE6 --%>
