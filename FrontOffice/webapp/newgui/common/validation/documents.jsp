<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<logic:equal name="fr.cg95.cvq.fo.common.Request" property="scanDocuments" scope="session" value="false">
	<logic:equal name="fr.cg95.cvq.fo.common.Request" property="hasDocuments" scope="session" value="true">
        <div class="fieldset_title_document">
          <h3 class="fieldset_title">DOCUMENTS ORIGINAUX A PRESENTER A LA MAIRIE</h3>
        </div>
        <ul class="validation_list">
		  <logic:iterate id="itemDocument" name="fr.cg95.cvq.fo.common.Request" property="expectedDocument">        
            <li class="text_row">
              <p class="label">
                <bean:write name="itemDocument" property="type"/>
              </p>
            </li>
		  </logic:iterate>
		</ul>
	</logic:equal>
</logic:equal>
<logic:equal name="fr.cg95.cvq.fo.common.Request" property="scanDocuments" scope="session" value="true">
	<logic:equal name="fr.cg95.cvq.fo.common.Request" property="hasDocuments" scope="session" value="true">
        <div class="fieldset_title_document">
          <h3 class="fieldset_title">DOCUMENT(S) FOURNI(S)</h3>
        </div>
        <ul class="validation_list">
		  <logic:iterate id="itemDocument" name="fr.cg95.cvq.fo.common.Request" property="suppliedDocument">        
            <li class="text_row">
              <p class="label">
                <bean:write name="itemDocument" property="type"/>
              </p>
            </li>
		  </logic:iterate>
		</ul>
        <div class="fieldset_title_document">
          <h3 class="fieldset_title">DOCUMENT(S) A FOURNIR</h3>
        </div>
        <ul class="validation_list">
		  <logic:iterate id="itemDocument" name="fr.cg95.cvq.fo.common.Request" property="expectedDocument">        
            <li class="text_row">
              <p class="label">
                <bean:write name="itemDocument" property="type"/>
              </p>
            </li>
		  </logic:iterate>
		</ul>
	</logic:equal>
</logic:equal>