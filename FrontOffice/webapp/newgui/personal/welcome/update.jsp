<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

<%request.getSession().removeAttribute("fr.cg95.cvq.fo.common.Request");%>

<ul class="list_type1">
  <li class="item"><a href="<cvqf:processHref action="createRequest.do" name="eFamily"/>" title=""><span class="custom_color"></span>MODIFIER MON COMPTE</a></li>
  <li class="item"><a href="changePassword.do?changepassword" title=""><span class="custom_color"></span>CHANGER MON MOT DE PASSE</a></li>
<logic:notEmpty name="accountManager" property="contactMail" scope="session">
  <li class="item contact"><a href="mailto:<bean:write  name="accountManager" property="contactMail" scope="session"/>" title="">Nous contacter</a></li>
</logic:notEmpty>
</ul>
