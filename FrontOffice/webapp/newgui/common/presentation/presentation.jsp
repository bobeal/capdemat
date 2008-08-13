<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
	<head>
	  <cvqw:baseref/>
	  <meta http-equiv="Content-Language" content="fr" />
	  <cvq:htmltitle/>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/process/structure.css" />
	  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/process/common.css" />
	  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/process/form.css" />
	  <link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/process/colors.css" />
	</head>
	  
	<script type="text/javascript" >
	  function startProcess(name) {
		var useAccount = document.getElementById("useAccount")
		if (useAccount != null) {
			if (useAccount.checked) {
				alert("Vous avez choisi d'utiliser votre compte. \nDans ce cas, veuillez vous connecter avant de commencer votre démarche.");
				return;
			}
		}

		var acceptConditions = document.getElementById("acceptConditions")
		if (acceptConditions != null) {
			if (acceptConditions.checked)
				<cvqf:processHref action="createRequest.do" script="true"/>
			else
				alert("Vous devez accepter les conditions générales d'utilisation !");
		}
	  }
	  function createAccount(name, returnUrl) {
		document.location.href = 'startRequest.do?name=eCitizen&returnUrl=startRequest.do?name=' + name + ",returnUrl=" + returnUrl;
	  }
	  
	  function resetPassword(form) {
	    form.method.value='reset';
	    form.password.value='password';
	    processSubmit('loginProcessAction.do');
	    form.method.value='';
		form.password.value='';
	  }
	  
	  function toggleLogin() {
		var form = document.forms['loginForm'];
		var useAccount = document.getElementById('useAccount');
		if ((form != null) && (useAccount != null)) {
			if (useAccount.checked)
				form.style.display='';
			else
				form.style.display='none';
		}
	  }

	  function checkAccount() {
		var useAccount = document.getElementById('useAccount');
		useAccount.checked = true;
	  }
	</script>

	<script type="text/javascript" src="./js/utils.js">
	</script>
	<script type="text/javascript" src="./js/process.js">
	</script>
	<script type="text/javascript" src="./js/validation.js">
	</script>

	<body id="body">
	  <div id="mainframe">
	    <div id="header">
		  <div id="logo"><a href="http://www.capwebct.fr" title=""><img src="img/logo_capwebct.gif" alt="" /></a></div>
	      <div id="banner"><img src="assets/common/img/banner.jpg" alt="" /></div>
	    </div>
	    <div id="content_wide">
	      <div id="content_wide_top">
	        <h2><cvqf:processTitle/></h2>
	        <ul id="content_top_links">
	          <li class="top_help"><a href="javascript:popup('assets/common/pdf/helpcapdemat.pdf');" title="">AIDE</a></li>
	        </ul>
	      </div>
	      <div id="content_wide_middle">
		<logic:notEqual name="fr.cg95.cvq.wizard.processName" value="eCitizen">
			<logic:notPresent name="BaseAction.authentification" scope="session">
			  <logic:equal name="fr.cg95.cvq.fo.common.Request" property="publik" value="false">
		        <p class="caution_paragraph"><strong>Pour effectuer cette démarche, vous devez avoir un compte ou le créer.</strong></p>
			  </logic:equal>
			  <logic:notEqual name="fr.cg95.cvq.fo.common.Request" property="publik" value="false">
		        <p class="paragraph presentation"><strong>Vous pouvez effectuer cette demande librement, ou en utilisant votre compte.</strong></p>
	            <p class="paragraph">
		            <input type="checkbox" id="useAccount" name="useAccount" onClick="javascript:toggleLogin();"/>
	                <label for="useAccount" >Je veux utiliser mon compte pour effectuer cette demande</label>
	            </p>
			  </logic:notEqual>
			  <logic:notPresent name="ResetPassword">
				<cvqf:form name="loginForm" action="#">
			  	<input type="hidden" name="method" value="login"/>
		        <fieldset class="fieldset_zone_login">
		          <div class="fieldset_title_login">
		            <h3 class="fieldset_title">CONNEXION :</h3>
		          </div>
		          <ul class="insert_list">
		            <li class="login_row">
		              <label for="login">Utilisateur :</label>
		    		  <cvqf:text name="userName" mode="" scope="request"/>
		            </li>
		            <li class="login_row">
		              <label for="password">Mot de passe :</label>
		    		  <cvqf:text name="password" mode="password"/>
		            </li>
		          </ul>
		          <ul class="submit_list">
		            <li class="forgot_pass_row">
		              <a href="javascript:resetPassword(document.loginForm);" title="">Mot de passe oublié</a>
		            </li>
		            <li class="submit_row">
		        	  <a href="javascript:processSubmit('loginProcessAction.do')" id="defaultbutton" >SE CONNECTER</a>
		            </li>
		          </ul>
		        </fieldset>
				</cvqf:form>
			  </logic:notPresent>
			  <logic:present name="ResetPassword">
				<cvqf:form name="loginForm" action="#">
		        <fieldset class="fieldset_zone_login">
		          <div class="fieldset_title_login">
		            <h3 class="fieldset_title">NOUVEAU MOT DE PASSE :</h3>
		          </div>
		          <ul class="insert_list">
		            <li class="login_row">
                  	  <label for="answer" class="question"><bean:write name="loginForm" property="question"/></label>
		            </li>
		            <li class="login_row">
	    		  	  <cvqf:text name="answer" mode=""/>
		            </li>
		          </ul>
		          <ul class="submit_list">
		            <li class="forgot_pass_row">
		              <a href="resetPasswordAction.do?cancel" title="">Annuler</a>
		            </li>
		            <li class="submit_row">
		        	  <a href="javascript:processSubmit('resetPasswordAction.do')" id="defaultbutton" >CONFIRMER</a>
		            </li>
		          </ul>
		        </fieldset>
				</cvqf:form>
			  </logic:present>
			  <logic:equal name="accountManager" property="active(eCitizen)" scope="session" value="true">
			  <logic:equal name="fr.cg95.cvq.fo.common.Request" property="publik" value="false">
		        <div class="fieldset_zone_inscription">
		          <div class="fieldset_title_inscription">
		            <h3 class="fieldset_title">CREER VOTRE COMPTE :</h3>
		          </div>
		          <p class="paragraph">Vous n'avez pas encore créé votre compte. Créez-le et vous pourrez ainsi accéder à tous les services en ligne disponibles. <strong>Voulez-vous créer votre compte ?</strong></p>
		          <ul class="list">
		            <li class="submit_row">
		              <a href="javascript:createAccount('<bean:write name="fr.cg95.cvq.wizard.processName"/>','<bean:write name="fr.cg95.cvq.fo.common.Request" property="returnUrl"/>')" title="">CONFIRMER</a>
		            </li>
		          </ul>
		        </div>
		      </logic:equal>
		      </logic:equal>
			</logic:notPresent>
			<logic:present name="BaseAction.authentification" scope="session">
		        <fieldset class="fieldset_zone_login">
		          <div class="fieldset_title_login">
		            <h3 class="fieldset_title">BIENVENUE <bean:write name="BaseAction.authentification" property="userName" scope="session"/></h3>
		          </div>
		        </fieldset>
			</logic:present>
		</logic:notEqual>
				
	        <form>
			<fieldset class="fieldset_zone_inscription_steps">
			  <div class="fieldset_title_inscription_steps">
			    <h3 class="fieldset_title">LES ETAPES DE VOTRE DEMARCHE</h3>
			  </div>
			  <cvq:timedocuments/>
			  <cvqf:processPresentation/>
	
	          <ul class="insert_list">
	            <li class="checkbox_row">
				  <logic:present name="BaseAction.authentification" scope="session">
		              <input type="checkbox" id="acceptConditions" name="acceptConditions" checked/>
				  </logic:present>
				  <logic:notPresent name="BaseAction.authentification" scope="session">
		              <input type="checkbox" id="acceptConditions" name="acceptConditions" />
				  </logic:notPresent>
	              <label for="acceptConditions">J'accepte les <a href="javascript:popup('assets/common/pdf/use.pdf');" title="">conditions générales d'utilisation du service</a></label>
	            </li>
	          </ul>
	
	          <ul class="actions_list">
	            <li class="cancel"><a href="endProcess.do" title="">ANNULER LA DEMANDE</a></li>
			<logic:equal name="fr.cg95.cvq.fo.common.Request" property="publik" value="true">
	            <li class="validation"><span class="custom_color"></span><a href="javascript:startProcess('<bean:write name="fr.cg95.cvq.wizard.processName"/>')">COMMENCER VOTRE DEMARCHE</a></li>
			</logic:equal>
			<logic:equal name="fr.cg95.cvq.fo.common.Request" property="publik" value="false">
			  <logic:present name="BaseAction.authentification" scope="session">
	            <li class="validation"><span class="custom_color"></span><a href="javascript:startProcess('<bean:write name="fr.cg95.cvq.wizard.processName"/>')">COMMENCER VOTRE DEMARCHE</a></li>
			  </logic:present>
			  <logic:notPresent name="BaseAction.authentification" scope="session">
	            <li class="validation"><span class="custom_color"></span><a href="javascript:alert('Pour effectuer cette démarche, vous devez avoir un compte ou le créer.')">COMMENCER VOTRE DEMARCHE</a></li>
			  </logic:notPresent>
			</logic:equal>
	          </ul>
	        </fieldset>
	        </form>
	      </div>
	      <div id="content_wide_bottom"></div>
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

<logic:present scope="session" name="login_error" >
  <script type="text/javascript">
	checkAccount();
  </script>
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
	toggleLogin();
</script>

</html>
