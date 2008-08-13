<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<logic:greaterThan name="stateManager" property="reportSearch.totalRecordNb" scope="session" value="0">
  <html:form action="/editReportAction.do?print" styleClass="nomargin">
    <table width="100%">
      <tr>
        <td class="titre3" width="25%">
          Etat à utiliser pour le rapport:
        </td>
        <td>
		  	<cvq:referenceSelect name="ReportPrintForm" property="reports" scope="session" value="reportName" id="reportName" styleClass="saisie" empty="false"/>
        </td>
        <td align="right">
          <input type="submit" class="boutonfix" name="print" value="<bean:message key='action.print'/>"/>
        </td>
      </tr>
     </table>
   </html:form>
</logic:greaterThan>   
<cvq:resultDisplay name="stateManager" property="reportSearch" />
