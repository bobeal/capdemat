<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>

<script language="JavaScript">
	function animation(){ location.href="animation.html"; }

	function validateAndSubmit(form) {
	  form.method.value='login';
	  if (true == validateLoginForm(form)){
	    form.submit();
	  }
	}
	
	function resetPassword(form) {
	  form.method.value='reset';
	  form.password.value='password';
	  if (true == validateLoginForm(form)){
	    form.submit();
	  } else {
		form.method.value='';
		form.password.value='';
	  }
	}
	
	function detectEnter() {
		if(self.event.keyCode == 13) validateAndSubmit(document.loginForm);
	}
</script>

<logic:present cookie="TERMINAL">
	<script language="JavaScript">
		setTimeout("animation()",600000);
	</script>
</logic:present>

<html:html>
  <head>
    <meta http-equiv="Content-Language" content="fr">

    <cvq:htmltitle/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
	<style type="text/css">
		body {
			background: url(assets/common/terminal/img/shoot-01.jpg) no-repeat;
			behavior:url(css/csshover.htc);
		}
		
		#banner {
			background: url(assets/common/img/banner.jpg);
			position: absolute;
			top: 0px;
			left: 1px;
			width: 767px;
			height: 78px;
		}
		#identifier {
			position: absolute;
			top: 180px;
			left: 146px;
			width: 220px;
			height: 40px;
		}
		#identifier input {
			font: 14px Arial;
			width: 223px;
			height: 20px;
			margin-bottom: 8px;
			padding: 0px;
		}
		#login {
			position: absolute;
			top: 300px;
			left: 348px;
			width: 60px;
			height: 40px;
			cursor: pointer;
		}		
		#login:hover {
			border: solid 1px blue;
		}
		#password {
			position: absolute;
			top: 240px;
			left: 226px;
			width: 146px;
			height: 22px;
			cursor: pointer;
		}		
		#password:hover {
			border: solid 1px blue;
		}
		#account {
			position: absolute;
			top: 283px;
			left: 671px;
			width: 79px;
			height: 27px;
			cursor: pointer;
		}
		#account:hover {
			border: solid 1px blue;
		}
		#public {
			position: absolute;
			top: 438px;
			left: 256px;
			width: 134px;
			height: 100px;
			cursor: pointer;
		}
		#public:hover {
			border: solid 1px blue;
		}
	</style>
  </head>

    <logic:present scope="session" name="login_error" >
      <logic:equal scope="session" name="login_error" value="errors.login.userName">
        <script for=window event=onload >
          alert("<bean:message key="errors.login.userName"/>");
        </script>
      </logic:equal>
      <logic:equal scope="session" name="login_error" value="errors.login.password">
        <script for=window event=onload >
          alert("<bean:message key="errors.login.password"/>");
        </script>
      </logic:equal>
      <logic:equal scope="session" name="login_error" value="errors.reset.password">
        <script for=window event=onload >
          alert("<bean:message key="errors.reset.password"/>");
        </script>
      </logic:equal>
      <logic:equal scope="session" name="login_error" value="message.mail.password">
        <script for=window event=onload >
          alert("<bean:message key="message.mail.password"/>");
        </script>
      </logic:equal>
      <logic:equal scope="session" name="login_error" value="message.town.password">
        <script for=window event=onload >
          alert("<bean:message key="message.town.password"/>");
        </script>
      </logic:equal>
      <logic:equal scope="session" name="login_error" value="errors.login.authentication.failed">
        <script for=window event=onload >
          alert("<bean:message key="errors.login.authentication.failed"/>");
        </script>
      </logic:equal>

    </logic:present>
    
  <body>
	<div id="banner">&nbsp;</div>
    <div id="identifier">
        <html:form method="post" focus="userName" action="/personal_loginAction.do">
		  <html:hidden property="method" value="login" />
	      <html:text property="userName" size="20" onkeypress="detectEnter()"/>
    	  <html:password property="password" size="20" onkeypress="detectEnter()"/>
	  </html:form>
    </div>
    
    <div id="password" onclick="javascript:resetPassword(document.loginForm);">&nbsp;</div>
    <div id="login" onclick="javascript:validateAndSubmit(document.loginForm);">&nbsp;</div>
    <div id="account" onclick="document.location.href='citizen_action.do'">&nbsp;</div>
    <div id="public" onclick="document.location.href='displayServicesAction.do?name=public'">&nbsp;</div>

  </body>
  <html:javascript formName="loginForm" />
</html:html>