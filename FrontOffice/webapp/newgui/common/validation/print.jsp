<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

    <!-- NUMERO DEMANDE -->
    <p class="paragraph validation_paragraph"><strong>Votre demande a été envoyée. Vous pouvez imprimer votre demande en appuyant sur le bouton "Imprimer".</strong></p>
    <ul class="validation_list">
      <li class="text_row"><p class="strong_label">DEMANDE N° : <bean:write name="fr.cg95.cvq.fo.common.Request" property="id" scope="session"/></p></li>
    </ul>
    <ul class="tool_list">
      <li class="print"><a href="printRequestAction.do" title=""><span class="custom_color"></span>IMPRIMER LA DEMANDE</a></li>
    </ul>
    <!-- / NUMERO DEMANDE -->

<logic:empty name="BaseAction.authentification" scope="session">
  <logic:notEmpty name="fr.cg95.cvq.wizard.process.ProcessStageAction.request" property="requester.password" scope="session">
    <!-- BLOC IDENTIFIANT -->
    <p class="paragraph validation_paragraph"><strong>Votre identifiant.</strong></p>
    <ul class="validation_list">
      <li class="text_row"><p class="strong_label">IDENTIFIANT : <bean:write name="fr.cg95.cvq.fo.common.Request" property="login" /></p></li>
    </ul>
    <!-- / BLOC IDENTIFIANT -->
  </logic:notEmpty>
</logic:empty>

<logic:notEmpty name="BaseAction.authentification" scope="session">
<logic:present name="Account" scope="session">
<logic:equal name="Account" property="loginNewAccount" scope="session" value="true">
    <!-- BLOC IDENTIFIANT -->
    <p class="paragraph validation_paragraph"><strong>Votre identifiant.</strong></p>
    <ul class="validation_list">
      <li class="text_row"><p class="strong_label">IDENTIFIANT : <bean:write name="fr.cg95.cvq.fo.common.Request" property="login" /></p></li>
    </ul>
    <!-- / BLOC IDENTIFIANT -->
</logic:equal>
</logic:present>
</logic:notEmpty>

    <ul class="validation_list">
      <li class="cross"><a href="endProcess.do" title=""><span class="custom_color"></span>QUITTER</a></li>
    </ul>
