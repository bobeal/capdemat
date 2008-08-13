<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
        <h1 class="title adult"><strong><bean:write name="adult" property="fullName(38)" scope="request"/></strong></h1>
        <ul class="list_type5">
          <li class="row selected">
            <p class="text_type1">Civilité:</p>
            <p class="text_type2"><bean:write name="adult" property="title" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Situation familiale:</p>
            <p class="text_type2"><bean:write name="adult" property="familyStatus" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Nom:</p>
            <p class="text_type2"><bean:write name="adult" property="lastName" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Prénom:</p>
            <p class="text_type2"><bean:write name="adult" property="firstName" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Date de naissance:</p>
            <p class="text_type2"><bean:write name="adult" property="birthDate" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Lieu de naissance:</p>
            <p class="text_type2"><bean:write name="adult" property="birthPlaceCity" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Pays de naissance:</p>
            <p class="text_type2"><bean:write name="adult" property="birthPlaceCountry" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Etg. - Esc. - App.:</p>
            <p class="text_type2"><bean:write name="adult" property="additionalDeliveryInformation" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Imm. - Bât. - Rés.:</p>
            <p class="text_type2"><bean:write name="adult" property="additionalGeographicalInformation" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">N&deg;, libellé de la voie:</p>
            <p class="text_type2">
            	<bean:write name="adult" property="streetNumber" scope="request"/>&nbsp;
            	<bean:write name="adult" property="streetName" scope="request"/>
            </p>
          </li>
          <li class="row selected">
            <p class="text_type1">Lieu-dit ou boite postale:</p>
            <p class="text_type2"><bean:write name="adult" property="placeNameOrService" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Code postal, localité:</p>
            <p class="text_type2">
            	<bean:write name="adult" property="postalCode" scope="request"/>
            	<bean:write name="adult" property="city" scope="request"/>
            </p>
          </li>
          <li class="row selected">
            <p class="text_type1">Tel domicile:</p>
            <p class="text_type2"><bean:write name="adult" property="domicilePhone" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Tel portable:</p>
            <p class="text_type2"><bean:write name="adult" property="mobilePhone" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Courriel:</p>
            <p class="text_type2"><bean:write name="adult" property="email" scope="request"/></p>
          </li>
 <logic:equal name="adult" property="familyHomeResponsible" scope="request" value="true">
          <li class="row selected">
            <p class="text_type1">Identifiant:</p>
            <p class="text_type2"><bean:write name="adult" property="displayLogin(50)" filter="false" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Question:</p>
            <p class="text_type2"><bean:write name="adult" property="question" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Réponse:</p>
            <p class="text_type2"><bean:write name="adult" property="answer" scope="request"/></p>
          </li>
 </logic:equal>
        </ul>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
