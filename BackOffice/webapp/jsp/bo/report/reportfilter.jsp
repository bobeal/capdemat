<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<%--  <script type="text/javascript" src="<%= request.getContextPath() + "/js/calendar.js"%>">  --%>
<%--  </script>  --%>

<html:form action="/reportFilterAction.do" styleClass="form_block">

  <fieldset class="fieldset001">
    <div class="form_cell form_cell001">
      <label for="type" class="label">Type de demande :</label>
      <cvq:referenceSelect name="stateManager" property="managerTypes" scope="session" value="reportFilter.type" id="type" styleClass="input_select" search="true"/>
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
<%--        <cvq:date name="ReportFilterForm" property="period" scope="session" period="true" styleClass="input_short_text" />  --%>
    </div>

    <div class="form_cell form_cell001">
      <label for="type" class="label">Service :</label>
      <cvq:referenceSelect name="stateManager" property="managerServices" scope="session" value="reportFilter.service" id="service" styleClass="input_select" search="true"/>
    </div>

  <logic:notEqual name="ReportFilterForm" property="search" value="quality">
    <div class="form_cell form_cell003">
      <label for="type" class="label">Etat de la demande :</label>
      <cvq:referenceSelect name="stateManager" property="requestStates" scope="session" value="reportFilter.state" id="state" styleClass="input_select" search="true"/>
    </div>
  </logic:notEqual>
  </fieldset>

  <fieldset class="fieldset002">
    <div class="form_cell">
      <input type="submit" class="input_submit" name="search" value="<bean:message key='action.filter'/>"/>
    </div>
  </fieldset></html:form><%-- BUG MSIE6 --%>

