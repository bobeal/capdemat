<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<script type="text/javascript" src="<%= request.getContextPath() + "/js/calendar.js"%>">
</script>

<html:form action="/reportSearchAction.do?report=reporting" styleClass="nomargin">
  <table width="100%">
   <tr>
    <td valign="top"><!-- tableau des champs de saisie1-->
    <table>
     <tr>
      <td class="titre3">Nom&nbsp;de&nbsp;l'habitant:</td>
      <td>
       <html:text property="lastName" styleClass="saisie"/>
       </td>
      <td width="10%">&nbsp;</td>
      <td class="titre3">Type&nbsp;de&nbsp;demande&nbsp;:</td>
      <td>
       <!-- retrieve all possible types from core -->
		<cvq:referenceSelect name="stateManager" property="types" scope="session" value="reportSearch.type" id="type" styleClass="saisie2" search="true"/>
       </td>
      <td width="10%">&nbsp;</td>
     </tr>
     <tr>
      <td class="titre3">Prénom&nbsp;de&nbsp;l'habitant:</td>
      <td>
       <html:text property="firstName" styleClass="saisie"/>
       </td>
      <td width="10%">&nbsp;</td>
      <td class="titre3">Etat&nbsp;de&nbsp;la&nbsp;demande:</td>
      <td>
       <!-- retrieve all possible states from core -->
		<cvq:referenceSelect name="stateManager" property="requestStates" scope="session" value="reportSearch.state" id="state" styleClass="saisie2" search="true"/>
      </td>
      <td width="10%">&nbsp;</td>
     </tr>
     <tr>
      <td class="titre3">N°&nbsp;de&nbsp;demande:</td>
      <td>
       <html:text property="demandId" styleClass="saisie"/>
       </td>
      <td width="10%">&nbsp;</td>
      <td class="titre3">Période&nbsp;demandée:</td>
      <td class="titre3">
       <!-- get periodes -->
	   <cvq:date name="ReportSearchForm" property="period" scope="session" period="true" styleClass="saisie2" />
      </td>
      <td width="10%">&nbsp;</td>
     </tr>
     <tr>
      <td class="titre3">N°&nbsp;de&nbsp;compte:</td>
      <td>
       <html:text property="familyId" styleClass="saisie"/>
      </td>
      <td width="10%">&nbsp;</td>
      <td class="titre3">Dernier&nbsp;intervenant:</td>
      <td>
       <!-- get list of agents -->
		<cvq:referenceSelect name="stateManager" property="agents" scope="session" value="reportSearch.lastAgent" id="lastAgent" styleClass="saisie2" search="true"/>
      </td>
      <td width="10%">&nbsp;</td>
     </tr>
	 <tr>
      <td colspan="3">&nbsp;</td>
      <td class="titre3">Service:</td>
      <td>
		<cvq:referenceSelect name="stateManager" property="services" scope="session" value="reportSearch.service" id="service" styleClass="saisie2" search="true"/>
      </td>
     </tr>
    </table>
    <!-- fin de tableau des champs de saisie1-->
    </td>
   </tr>
   <tr>
    <td align="right" colspan="2">
     <input type="submit" class="boutonfix" name="search" value="<bean:message key='action.search'/>"/>
    </td>
   </tr>
  </table>
</html:form>
