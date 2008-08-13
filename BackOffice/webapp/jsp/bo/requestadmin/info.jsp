<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<div class="grid_cell">
  <div class="block008">
    <p class="text011 pictoDigitize">Paramètres de numérisation des pièces justificatives</p>
  </div>
  
  <div class="block017">
    <html:form action="/requestAction.do?save=global" styleClass="form_block form_block002">
      <fieldset class="fieldset008">
        <div class="form_cell form_cell001">
          <span class="input"><html:checkbox property="scanDocumentData" value="yes" disabled="true" styleClass="input_radio" /></span>
          <label for="name" class="label">Les justificatifs sont fournis sous format numérique.</label>
        </div>
      </fieldset>
      
      
      <p class="text013">Cette option est mis en place dans les fichiers de configuration, elle est générale à l'ensemble des télé-services.</p>
      <ul class="list002">
        <li class="element">Si l'option est activée, vous pouvez numériser les pièces justificatives.</li>
        <li class="element">Si l'option est désactivée, les pièces justificatives pourront être demandées mais ne pourront pas être numérisées.</li>
      </ul>

<%--          <a href="requestAction.do?tab=8">Accès aux paramètres.</a>  --%>
    </html:form>
  </div>
</div>


