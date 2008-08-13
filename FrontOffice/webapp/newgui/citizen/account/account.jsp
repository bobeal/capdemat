<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Account" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <cvqf:hidden name="loginNewAccount" property=""/>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Choix de votre mot de passe :</h3>
        <ul class="insert_list">
          <li class="password_row">
			<label for="loginPassword" class="label">Mot de passe<span class="required">*</span></label>
            <cvqf:text name="loginPassword" mode="password"/>
            <span class="inline_text">(min. 8 caractères)</span>
          </li>
          <li class="password_row">
			<label for="loginConfirmPassword" class="label">Confirmation du mot de passe<span class="required">*</span></label>
            <cvqf:text name="loginConfirmPassword" mode="password"/>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Choix de l'aide mémoire :</h3>
        <ul class="insert_list">
          <li class="select_row">
			<label for="loginQuestion" class="label">Votre question<span class="required">*</span></label>
            <cvqf:select name="loginQuestion" mode="">
              <option value="">Choisissez votre question</option>
              <option value="Quel est votre loisir préféré ?">Quel est votre loisir préféré ?</option>
              <option value="Quel est le nom de votre animal favori ?">Quel est le nom de votre animal favori ?</option>
              <option value="Quel est le prénom de votre enfant ?">Quel est le prénom de votre enfant ?</option>
              <option value="Quel est le prénom de votre belle-mère ?">Quel est le prénom de votre belle-mère ?</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="loginAnswer" class="label">Donner la réponse à la question choisie<span class="required">*</span></label>
            <cvqf:text name="loginAnswer" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.loginNewAccount = new Function("key","this.label='Login[].NewAccount'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.loginPassword = new Function("key","this.label='Mot de passe'; this.msg=null; this.required=true; this.minlength=8; this.maxlength=0; this.type=null; return this[key];");
     		  this.loginConfirmPassword = new Function("key","this.label='Confirmation du mot de passe'; this.msg=null; this.required=true; this.minlength=8; this.maxlength=0; this.type=null; return this[key];");
     		  this.loginQuestion = new Function("key","this.label='Votre question'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.loginAnswer = new Function("key","this.label='Donner la réponse à la question choisie'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("loginNewAccount");
        updateDisplay("loginQuestion");
  		setFocus("Account");
	</script>
