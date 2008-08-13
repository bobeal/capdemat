<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<%--  <script language="javaScript" src="<%= request.getContextPath() + "/js/calendar.js"%>">  --%>
<%--  </script>  --%>

<html:form action="/paymentsAction.do?search" styleClass="form_block">
  <fieldset class="fieldset001">
    <div class="form_cell form_cell001">
      <label for="lastName" class="label">Nom de l'habitant :</label>
      <cvq:input name="stateManager" property="paymentSearch.lastName" scope="session" styleClass="input_text" type="text"/>
    </div>
    
    <div class="form_cell form_cell003">
      <label for="broker" class="label">Régie :</label>
      <cvq:input name="stateManager" property="paymentSearch.broker" scope="session" styleClass="input_text" type="text"/>
    </div>
    
    <div class="form_cell form_cell001">
      <label for="familyId" class="label">N° de compte :</label>
      <cvq:input name="stateManager" property="paymentSearch.familyId" scope="session" styleClass="input_text" type="text"/>
    </div>
    
    <div class="form_cell form_cell003">
      <label for="state" class="label">Etat du paiement :</label>
      <cvq:referenceSelect name="stateManager" property="paymentStates" scope="session" value="paymentSearch.state" id="state" styleClass="input_select" search="true"/>
    </div>
    
    <div class="form_cell form_cell001">
      <label for="bankReference" class="label">Référence bancaire :</label>
      <cvq:input name="stateManager" property="paymentSearch.bankReference" scope="session" styleClass="input_text" type="text"/>
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
  </fieldset>

  <fieldset class="fieldset002">
    <div class="form_cell">
      <input type="submit" class="input_submit" name="search" value="<bean:message key='action.search'/>"/>
    </div>
  </fieldset></html:form><%-- BUG MSIE6 --%>
