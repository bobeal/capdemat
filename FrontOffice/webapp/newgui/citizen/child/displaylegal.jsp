<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Child" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Responsables légaux
          </p>
          <p class="text">
            <cvqf:check name="childAdult" mode="static" repository="adults">
            </cvqf:check>
          </p>
        </li>
<logic:iterate name="Child" property="childLegalResponsible" id="Legal" >
		<li class="text_row">
          <p class="empty_label">&nbsp;</p>
          <p class="text">
            <bean:write name="Legal" property="childLegalResponsibleLegalResponsibleFirstName"/>&nbsp;
            <bean:write name="Legal" property="childLegalResponsibleLegalResponsibleLastName"/>
          </p>
        </li>
</logic:iterate>
      </ul>
	</cvqf:form>
        