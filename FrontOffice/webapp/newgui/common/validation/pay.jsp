<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<script language=javascript>self.name="sitecom";</script>
<logic:notPresent name="PaymentOk" scope="session">
  <iframe src="<bean:write name="paymentUrl" scope="session"/>" width="100%" height="450" frameborder="0">
  </iframe>
</logic:notPresent>
<logic:present name="PaymentOk" scope="session">
  <iframe src="<bean:write name="paymentUrl" scope="session"/>" width="100%" height="400" frameborder="0">
  </iframe>
  <fieldset class="fieldset_zone">
    <ul class="navigation_links" style="float:right;">
      <li class="navigation_link_to_next" style="float:right;"><a href="processWizard.do?transition=print" title=""><span class="custom_color"></span>PAGE SUIVANTE</a></li>
    </ul>
  </fieldset>
</logic:present>