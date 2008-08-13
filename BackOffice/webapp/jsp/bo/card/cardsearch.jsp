<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<script language="javaScript" src="<%= request.getContextPath() + "/js/calendar.js"%>">
</script>

<html:form action="/accountSearchAction.do?card" styleClass="nomargin">
  <table width="100%">
   <tr>
    <td valign="top"><!-- tableau des champs de saisie1-->
    <table>
     <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td width="10%">&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td width="10%">&nbsp;</td>
     </tr>
     <tr>
      <td class="titre3">Nom&nbsp;de&nbsp;l'habitant:</td>
      <td>
       <html:text property="lastName" styleClass="saisie"/>
       </td>
      <td width="10%">&nbsp;</td>
      <td class="titre3">Etat&nbsp;de&nbsp;la&nbsp;carte:</td>
      <td>
		<cvq:referenceSelect name="stateManager" property="cardStates" scope="session" value="accountSearch.state" id="state" styleClass="saisie" search="true"/>
      </td>
      <td width="10%">&nbsp;</td>
     </tr>
     <tr>
      <td class="titre3">Prénom&nbsp;de&nbsp;l'habitant:</td>
      <td>
       <html:text property="firstName" styleClass="saisie"/>
       </td>
      <td width="10%">&nbsp;</td>
      <td class="titre3">Date de naissance:</td>
      <td>
	   <cvq:date name="AccountSearchForm" property="birthDate" scope="session" styleClass="saisie" />
      </td>
      <td width="10%">&nbsp;</td>
     </tr>
     <tr>
      <td class="titre3">N°&nbsp;de&nbsp;compte:</td>
      <td>
       <html:text property="familyId" styleClass="saisie"/>
      </td>
      <td width="10%">&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td width="10%">&nbsp;</td>
     </tr>
    </table>
    <!-- fin de tableau des champs de saisie1-->
    </td>
   </tr>
   <tr>
    <td align="right" colspan="2">
     <input type="submit" class="boutonfix" name="choice" value="<bean:message key='action.search'/>"/>
    </td>
   </tr>
  </table>
</html:form>
