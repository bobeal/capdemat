<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>

<bean:define id="loginCreationErrorMessage">
 <bean:message key="message.login.creation.error"/>
</bean:define>

<script type="text/javascript">
function checkPassword(form){
 var password = form.password.value;
 var passwordConfirm = form.passwordConfirm.value;
 
 if (password == passwordConfirm && password.length >= 8){
   return true;
 }
 return false;
}

function validatePassword(form) {
    if (true == checkPassword(form)){
      form.submit();
    } else{
      alert("<%=loginCreationErrorMessage%>");
    }
}
</script>

	<html:form action="/changePassword" focus="oldPassword">
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="password_row">
			<label for="oldPassword" class="label">Ancien mot de passe<span class="required">*</span></label>
	    	<html:password property="oldPassword" styleId="oldPassword" size="28" maxlength="16"/>
          </li>
          <li class="password_row">
			<label for="newPassword" class="label">Nouveau mot de passe<span class="required">*</span></label>
	    <html:password property="password" styleId="newPassword" size="28" maxlength="16"/>
          </li>
          <li class="password_row">
			<label for="confPassword" class="label">Confirmation du mot de passe<span class="required">*</span></label>
	    	<html:password property="passwordConfirm" styleId="confPassword" size="28" maxlength="16"/>
          </li>
          <li class="password_row"></li>
        </ul>
      </fieldset>
	</html:form>

<ul class="list_type_password">
  <li class="item cancel"><a href="managerWizard.do" title=""><span class="custom_color"></span>ANNULER</a></li>
  <li class="item ok"><a href="javascript:validatePassword(document.loginForm)" title=""><span class="custom_color"></span>CHANGER</a></li>
</ul>

<logic:present scope="request" name="login_error" >
  <script type="text/javascript">
	alert("<%=request.getAttribute("login_error")%>");
  </script>
</logic:present>
