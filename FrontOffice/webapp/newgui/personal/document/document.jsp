<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

  <div class="block_type5">
    <div class="box">
      <div class="box_top"></div>
      <div class="box_middle">
<logic:notEmpty name="documentForm" property="documents">
        <p class="paragraph">Il existe plusieurs documents concernant "<strong><bean:write name="documentForm" property="type" /></strong>".</p>
        <p class="paragraph">Pour afficher un de ces documents, <strong>cliquez sur la personne concernée :</strong></p>
        <h1 class="title document"><bean:write name="documentForm" property="type" /> de :</h1>

        <ul class="list_type4">
<logic:iterate name="documentForm" property="documents" id="document" indexId="documentIndex">
          <li class="row">
            <p class="item child">
              <a href="documentDisplayAction.do?documentIndex=<bean:write name="documentIndex"/>" title="">
<logic:notEmpty name="document" property="person">
                <bean:write name="document" property="person.lastName" />&nbsp;
                <bean:write name="document" property="person.firstName" />
</logic:notEmpty>
<logic:empty name="document" property="person">
                Compte
</logic:empty>
              </a>
            </p>
          </li>
</logic:iterate>
        </ul>

</logic:notEmpty>
<logic:empty name="documentForm" property="documents">
        <h1 class="title document"><bean:write name="documentForm" property="type" /></h1>

        <div class="block_type7">
          <div class="block_image">
			<cvq:documentThumbnails name="documentForm" scope="request" action="documentDisplayPageAction.do?transition=displaypage"/>
          </div>
<logic:equal name="documentForm" property="certified" value="true">
          <ul class="list_type7">
            <li class="item">
              <a href="javascript:window.open('newgui/personal/document/certified.jsp','download','resizable=yes,scrollbars=yes,top=234,left=312,width=400,height=300')" title="">
                <span class="custom_color"></span>DOCUMENT CERTIFIE
              </a>
            </li>
          </ul>
          
</logic:equal>
        </div>

        <ul class="list_type5">
          <li class="row">
            <p class="text_type1">Nature du justificatif :</p>
            <p class="text_type3"><bean:write name="documentForm" property="type" /></p>
          </li>
          <li class="row">
            <p class="text_type1">Personne :</p>
<logic:notEmpty name="documentForm" property="person">
            <p class="text_type3"><bean:write name="documentForm" property="person.firstName" /></p>
</logic:notEmpty>
<logic:empty name="documentForm" property="person">
            <p class="text_type3"></p>
</logic:empty>
          </li>
<logic:notEqual name="documentForm" property="state" value="Périmé">
          <li class="row selected">
</logic:notEqual>
<logic:equal name="documentForm" property="state" value="Périmé">
          <li class="row error">
</logic:equal>
            <p class="text_type3">ETAT :</p>
            <p class="text_type3"><bean:write name="documentForm" property="state" /></p>
          </li>
          <li class="row">
            <p class="text_type1">Expire le :</p>
            <p class="text_type3"><bean:write name="documentForm" property="expirationDate" /></p>
          </li>
          <li class="row">
            <p class="text_type1">Validé le :</p>
            <p class="text_type3"><bean:write name="documentForm" property="validationDate" /></p>
          </li>
          <li class="row">
            <p class="text_type1">Déposé le :</p>
            <p class="text_type3"><bean:write name="documentForm" property="submissionDate" /></p>
          </li>
        </ul>
</logic:empty>
      </div>
      <div class="box_bottom"></div>
    </div>
  </div>
