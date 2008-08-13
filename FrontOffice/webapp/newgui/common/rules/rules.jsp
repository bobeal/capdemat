<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<form>
</form>
    <fieldset class="fieldset_zone" style="margin:0px;">
      <h3 class="fieldset_subtitle"><bean:write name="fr.cg95.cvq.fo.common.Request" property="rules.title" scope="session"/></h3>
      <ul class="insert_list">
        <li class="textarea_row">
          <html:textarea name="fr.cg95.cvq.fo.common.Request" property="rules.content" styleId="RegulationRules" cols="80" rows="10" readonly="true" />
        </li>
      </ul>
    </fieldset>
