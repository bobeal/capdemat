<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
        <h1 class="title child"><strong><bean:write name="child" property="fullName(38)" scope="request"/></strong></h1>
        <ul class="list_type5">
          <li class="row selected">
            <p class="text_type1">Nom:</p>
            <p class="text_type2"><bean:write name="child" property="lastName" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Prénom:</p>
            <p class="text_type2"><bean:write name="child" property="firstName" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Date de naissance:</p>
            <p class="text_type2"><bean:write name="child" property="birthDate" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Lieu de naissance:</p>
            <p class="text_type2"><bean:write name="child" property="birthPlaceCity" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Pays de naissance:</p>
            <p class="text_type2"><bean:write name="child" property="birthPlaceCountry" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Sexe:</p>
            <p class="text_type2"><bean:write name="child" property="sex" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Etg. - Esc. - App.:</p>
            <p class="text_type2"><bean:write name="child" property="additionalDeliveryInformation" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Imm. - Bât. - Rés.:</p>
            <p class="text_type2"><bean:write name="child" property="additionalGeographicalInformation" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">N&deg;, libellé de la voie:</p>
            <p class="text_type2">
            	<bean:write name="child" property="streetNumber" scope="request"/>&nbsp;
            	<bean:write name="child" property="streetName" scope="request"/>
            </p>
          </li>
          <li class="row selected">
            <p class="text_type1">Lieu-dit ou boite postale:</p>
            <p class="text_type2"><bean:write name="child" property="placeNameOrService" scope="request"/></p>
          </li>
          <li class="row selected">
            <p class="text_type1">Code postal, localité:</p>
            <p class="text_type2">
            	<bean:write name="child" property="postalCode" scope="request"/>
            	<bean:write name="child" property="city" scope="request"/>
            </p>
          </li>
 <logic:equal name="child" property="adultResponsibles.empty" scope="request" value="false">
          <li class="row selected">
            <p class="text_type1">Responsable(s) légal(aux):</p>
          </li>
   <logic:iterate name="child" property="adultResponsibles" scope="request" id="responsible">
          <li class="row selected">
            <p class="text_type2"><bean:write name="responsible" property="lastName" scope="page"/> <bean:write name="responsible" property="firstName" scope="page"/></p>
          </li>
   </logic:iterate>
 </logic:equal>
        </ul>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
 