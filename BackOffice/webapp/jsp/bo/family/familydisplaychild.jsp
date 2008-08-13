<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<logic:present name="child" scope="request">
<div class="grid_cell">
  <div class="block016">
    <p class="text011 pictoMan"><bean:write name="child" property="firstName" scope="request"/> <bean:write name="child" property="lastName" scope="request"/></p>
  </div>
  <div class="block017">
    <table class="table004">
      <tr>
        <td class="td td1">Nom:</td>
        <td class="td td2"><bean:write name="child" property="lastName" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Prénom:</td>
        <td class="td td2"><bean:write name="child" property="firstName" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Date de naissance:</td>
        <td class="td td2"><bean:write name="child" property="birthDate" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Lieu de naissance:</td>
        <td class="td td2"><bean:write name="child" property="birthPlace" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Pays de naissance:</td>
        <td class="td td2"><bean:write name="child" property="birthCountry" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Sexe:</td>
        <td class="td td2"><bean:write name="child" property="sex" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Adresse:</td>
        <td class="td td2"><bean:write name="child" property="address" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Code postal:</td>
        <td class="td td2"><bean:write name="child" property="postalCode" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Ville:</td>
        <td class="td td2"><bean:write name="child" property="city" scope="request"/></td>
      </tr>
    </table>
  </div>
</div>
</logic:present>