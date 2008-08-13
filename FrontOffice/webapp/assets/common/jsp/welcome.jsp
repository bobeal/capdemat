<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">

<head>
  <cvqw:baseref/>
  <meta http-equiv="Content-Language" content="fr"/>
  <cvq:htmltitle/>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/account/structure.css" />
  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/account/common.css" />
  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/account/form.css" />
  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/account/colors.css" />
</head>

<script type="text/javascript">
  function animation(){ location.href="animation.html"; }

  function resetPassword(form) {
    form.method.value='reset';
    form.password.value='password';
    processSubmit('loginAction.do');
    form.method.value='';
	form.password.value='';
  }
</script>

<script type="text/javascript" src="./js/utils.js">
</script>
<script type="text/javascript" src="./js/process.js">
</script>
<script type="text/javascript" src="./js/validation.js">
</script>

<logic:present cookie="TERMINAL">
	<script language="JavaScript">
		setTimeout("animation()",600000);
	</script>
</logic:present>

<body id="body">
  <div id="mainframe">
    <div id="header">
	  <div id="logo"><a href="http://www.capwebct.fr" title=""><img src="img/logo_capwebct.gif" alt="" /></a></div>
      <div id="banner"><img src="assets/common/img/banner.jpg" alt="" /></div>
    </div>

    <div id="content">
      <div id="content_top_home"></div>
      <div id="content_middle_home">

        <div class="col_type6">
		<logic:notPresent name="ResetPassword">
          <div class="block_type12">
			<cvqf:form name="loginForm" action="#">
			  <input type="hidden" name="method" value="login"/>
            <fieldset class="fieldset_type1">
              <div class="block_type13">
                <h2 class="login">CONNEXION :</h2>
              </div>
              <ul class="list_type15">
                <li class="row">
                  <label for="login" class="label_type3">Utilisateur :</label>
	    		  <cvqf:text name="userName" mode="" scope="request"/>
                </li>
                <li class="row">
                  <label for="password" class="label_type3">Mot de passe :</label>
	    		  <cvqf:text name="password" mode="password"/>
                </li>
              </ul>
              <ul class="list_type16">
                <li class="row">
                  <a href="javascript:resetPassword(document.loginForm);" title="" class="forgot_password">Mot de passe oublié</a>
                </li>
                <li class="row">
	        	  <a href="javascript:processSubmit('loginAction.do')" id="defaultbutton" class="submit_type2">SE CONNECTER</a>
                </li>
              </ul>
            </fieldset>
            </cvqf:form>
          </div>
		</logic:notPresent>
		<logic:present name="ResetPassword">
          <div class="block_type12">
			<cvqf:form name="loginForm" action="#">
			  <input type="hidden" name="method" value="login"/>
            <fieldset class="fieldset_type1">
              <div class="block_type13">
                <h2 class="login">NOUVEAU MOT DE PASSE :</h2>
              </div>
              <ul class="list_type15">
                <li class="row">
                  <label for="answer" class="label_type4"><bean:write name="loginForm" property="question"/></label>
                </li>
                <li class="row long">
	    		  <cvqf:text name="answer" mode=""/>
                </li>
              </ul>
              <ul class="list_type16">
                <li class="row">
                  <a href="resetPasswordAction.do?cancel" title="" class="forgot_password">Annuler</a>
                </li>
                <li class="row">
	        	  <a href="javascript:processSubmit('resetPasswordAction.do')" id="defaultbutton" class="submit_type2">CONFIRMER</a>
                </li>
              </ul>
            </fieldset>
            </cvqf:form>
          </div>
		</logic:present>
          <div class="block_type14">
	    <logic:equal name="fr.cg95.cvq.fo.business.RequestManager" property="requestTypeActive(eCitizen)" scope="session" value="true">
            <div class="block_type13">
              <h2 class="signin">CREER VOTRE COMPTE :</h2>
            </div>
            <div class="block_type15">
              <p class="text_type6">Vous n'avez pas encore créé votre compte. Créez-le et vous pourrez ainsi accéder à tous les services en ligne disponibles. <strong>Voulez-vous créer votre compte ?</strong></p>
              <ul class="list_type17">
                <li class="row">
                  <a href="startRequest.do?name=eCitizen&returnUrl=closeSession.do" title="">CONFIRMER</a>
                </li>
              </ul>
            </div>
        </logic:equal>
          </div>
          <div class="block_type16">
            <ul class="list_type18">
              <li class="row">
                <a href="javascript:popup('assets/common/pdf/helpcapdemat.pdf');" title=""><span class="custom_color"></span>Aide</a>
              </li>
            </ul>
          </div>
        </div>

        <div class="col_type7">
          <cvqf:processSelection name="accountManager" property="active($process)" 
          						 action="startRequest.do?returnUrl=closeSession.do" var="$process"/>
        </div>

      </div>
      <div id="content_bottom"></div>
    </div>

	    <div id="footer">
	      <ul>
	        <li class="logo firstlogo"><a href="http://www.capwebct.fr" title="" class="info"><span class="logo_img"><img src="img/logo_capwebct.gif" alt="" /></span><span class="logo_legend" style="color:red">CapWebCT.</span></a></li>
	        <li class="logo secondlogo"><a href="http://www.prai-idf.fr/public/rubrique.tpl?id=8364&titre=8364"" title="" class="info"><span class="logo_img"><img src="img/logoUE.png" alt="" /></span><span class="logo_legend" style="color:green">Projet cofinancé par lUnion Européenne (FEDER).</span></a></li>
	        <li class="legend"><p class="legend_text"><a href="javascript:popup('assets/common/pdf/legal.pdf');" title="">Mentions légales.</a></p></li>
        	<li class="logo right"><a href="http://www.capwebct.fr" title="" class="info"><span class="logo_img"><img src="img/logo_capwebct.gif" alt="" /></span><span class="logo_legend">CapWebCT.</span></a></li>
	      </ul>
	    </div>
  </div>
</body>
</html>

<logic:present scope="session" name="login_error" >
  <logic:equal scope="session" name="login_error" value="errors.login.userName">
	<script type="text/javascript">
      alert("<bean:message key="errors.login.userName"/>");
    </script>
  </logic:equal>
  <logic:equal scope="session" name="login_error" value="errors.login.password">
	<script type="text/javascript">
      alert("<bean:message key="errors.login.password"/>");
    </script>
  </logic:equal>
  <logic:equal scope="session" name="login_error" value="errors.reset.password">
	<script type="text/javascript">
      alert("<bean:message key="errors.reset.password"/>");
    </script>
  </logic:equal>
  <logic:equal scope="session" name="login_error" value="message.mail.password">
	<script type="text/javascript">
      alert("<bean:message key="message.mail.password"/>");
    </script>
  </logic:equal>
  <logic:equal scope="session" name="login_error" value="message.town.password">
	<script type="text/javascript">
      alert("<bean:message key="message.town.password"/>");
    </script>
  </logic:equal>
  <logic:equal scope="session" name="login_error" value="errors.login.authentication.failed">
	<script type="text/javascript">
      alert("<bean:message key="errors.login.authentication.failed"/>");
    </script>
  </logic:equal>
  <logic:equal scope="session" name="login_error" value="errors.login.disabled.account">
	<script type="text/javascript">
      alert("<bean:message key="errors.login.disabled.account"/>");
    </script>
  </logic:equal>
  <logic:equal scope="session" name="login_error" value="errors.login.accountManager">
	<script type="text/javascript">
      alert("<bean:message key="errors.login.accountManager"/>");
    </script>
  </logic:equal>
</logic:present>
    
<script type="text/javascript">
	function validationData() {
  	  this.userName = new Function("key","this.label='Utilisateur'; this.required=true; this.maxlength=0; this.type=null; return this[key];");
  	  this.password = new Function("key","this.label='Mot de passe'; this.required=true; this.maxlength=0; this.type=null; return this[key];");
  	  this.answer = new Function("key","this.label='Reponse'; this.required=true; this.maxlength=0; this.type=null; return this[key];");
	}
</script>
