<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div class="grid_cell">
  <div class="block008">
    <p class="text011 XXX"><bean:write name="RequestForm" property="groupName" /></p>
  </div>
  
  <div class="block017">
<%--  <form>  --%>
    <table class="table_default table005">
      <tr>  
        <th class="th">Nature du justificatif</th>
        <th class="th">Etat</th>
      </tr>
    <logic:iterate id="process" indexId="index" name="RequestForm" property="grouprtypes" scope="session">
      <tr>
        <td class="td <%if(index.intValue()%2 == 0) {%>td2<%}%>">
          <a href="requestAction.do?select=type&amp;tab=1&amp;index=<bean:write name="index"/>" class="link"><span><bean:write name="process" property="label"/></span></a>
        </td>
        <td class="td <%if(index.intValue()%2 == 0) {%>td2<%}%>">
        <logic:equal name="process" property="activated" value="true">
          <span class="yes">Publié</span>
        </logic:equal>
        <logic:equal name="process" property="activated" value="false">
          <span class="no">Non publié</span>
        </logic:equal>
        </td>
      </tr>
    </logic:iterate>
    </table>
<%--  </form>  --%>
  </div>

  <div class="block017">
    <p class="text012 pictoInformation">Après avoir sélectionné un télé-service vous pourrez le configurer dans les onglets proposés.</p>
  </div>
</div>