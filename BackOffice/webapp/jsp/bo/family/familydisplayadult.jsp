<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<logic:present name="adult" scope="request">
<div class="grid_cell">
  <div class="block016">
    <p class="text011 pictoMan"><bean:write name="adult" property="firstName" scope="request"/> <bean:write name="adult" property="lastName" scope="request"/></p>
  </div>
  <div class="block017">
    <table class="table004">
      <tr>
        <td class="td td1">Situation familiale :</td>
        <td class="td td2"><bean:write name="adult" property="familyStatus" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Nom :</td>
        <td class="td td2"><bean:write name="adult" property="lastName" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Prénom :</td>
        <td class="td td2"><bean:write name="adult" property="firstName" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Date de naissance :</td>
        <td class="td td2"><bean:write name="adult" property="birthDate" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Lieu de naissance :</td>
        <td class="td td2"><bean:write name="adult" property="birthPlace" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Pays de naissance :</td>
        <td class="td td2"><bean:write name="adult" property="birthCountry" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Sexe :</td>
        <td class="td td2"><bean:write name="adult" property="sex" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Adresse :</td>
        <td class="td td2"><bean:write name="adult" property="address" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Code postal :</td>
        <td class="td td2"><bean:write name="adult" property="postalCode" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Ville :</td>
        <td class="td td2"><bean:write name="adult" property="city" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Tel domicile :</td>
        <td class="td td2"><bean:write name="adult" property="homePhone" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Tel portable :</td>
        <td class="td td2"><bean:write name="adult" property="mobilePhone" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Courriel :</td>
        <td class="td td2"><bean:write name="adult" property="email" scope="request"/></td>
      </tr>
      <logic:equal name="adult" property="familyHomeResponsible" scope="request" value="true">
      <tr>
        <td class="td td1">Identifiant :</td>
        <td class="td td2"><bean:write name="adult" property="displayLogin(60)" filter="false" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Question :</td>
        <td class="td td2"><bean:write name="adult" property="question" scope="request"/></td>
      </tr>
      <tr>
        <td class="td td1">Réponse :</td>
        <td class="td td2"><bean:write name="adult" property="answer" scope="request"/></td>
      </tr>
      </logic:equal>
    </table>
  </div>
</div>
</logic:present>