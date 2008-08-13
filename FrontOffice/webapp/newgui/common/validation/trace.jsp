<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

<cvqf:form name="fr.cg95.cvq.fo.common.form.Validation" action="#">

	<fieldset class="fieldset_zone">
	  <div class="fieldset_title_standard">
	    <h3 class="fieldset_title">Suivi de la demande</h3>
	  </div>
	  <ul class="insert_list">
        <li class="text_row">
          <p class="paragraph">
			<strong>Mot de passe et identifiant</strong><br/>
			Un mot de passe compos de huit caractres alphanumriques vous sera demand. Une question 
			complmentaire  laquelle vous devez rpondre, vous permettra, en cas doubli de votre mot 
			de passe, daccder  vos demandes.
          </p>
          <p class="paragraph">
			Lors de lenregistrement, un identifiant vous sera attribu.<br/>
			Le mot de passe et lidentifiant vous permettront de suivre le traitement de votre demande.
          </p>
        </li>
	  </ul>
      <h3 class="fieldset_subtitle">Choix de votre mot de passe :</h3>
      <ul class="insert_list">
	    <li class="password_row">
	      <label for="password" class="suivi_label">Mot de passe<span class="required">*</span> :</label>
   		  <cvqf:text name="password" mode="password" maxlength="8"/>
            <span class="inline_text">(8 caractres)</span>
	    </li>
	    <li class="password_row">
	      <label for="passwordConfirm" class="suivi_label">Confirmation du mot de passe<span class="required">*</span> :</label>
   		  <cvqf:text name="passwordConfirm" mode="password" maxlength="8"/>
	    </li>
	  </ul>
      <h3 class="fieldset_subtitle">Choix de l'aide mmoire :</h3>
      <ul class="insert_list">
	    <li class="select_row">
	      <label for="question" class="suivi_label">Votre question<span class="required">*</span> :</label>
  		  <cvqf:select name="question" mode="">
			<option value="">Choisissez votre question</option>
			<option value="Quel est votre loisir prfr ?">Quel est votre loisir prfr ?</option>
			<option value="Quel est le nom de votre animal favori ?">Quel est le nom de votre animal favori ?</option>
			<option value="Quel est le prnom de votre enfant ?">Quel est le prnom de votre enfant ?</option>
			<option value="Quel est le prnom de votre belle-mre ?">Quel est le prnom de votre belle-mre ?</option>
		  </cvqf:select>
	    </li>
	    <li class="text_row">
	      <label for="answer" class="suivi_label">Rponse  l'aide mmoire :</label>
   		  <cvqf:text name="answer"/>
	    </li>
	  </ul>
	</fieldset>
</cvqf:form>

	<script language="JavaScript">
		function validationData() {
    	  this.password = new Function("key","this.label='Mot de passe'; this.required=true; this.minlength=8; this.type=null; return this[key];");
    	  this.question = new Function("key","this.label='Choix de l&quote;aide mmoire'; this.required=true; this.maxlength=0; this.type=null; return this[key];");
    	  this.answer = new Function("key","this.label='La rponse  la question choisie'; this.required=true; this.maxlength=0; this.minlength=0; this.type=null; return this[key];");
    	  this.passwordConfirm = new Function("key","this.label='Confirmation du mot de passe'; this.required=true; this.minlength=8; this.type=null; this.extra=checkPassword; return this[key];");
  		}
  		
  		function checkPassword() {
  			if (arguments.length == 0) {
				password = document.getElementById('password');
				passwordConfirm = document.getElementById('passwordConfirm');
				
	  			return (password.value == passwordConfirm.value);
	  		}
	  		return "Mot de passe de confirmation diffrent du mot de passe";
  		}
  		setFocus("fr.cg95.cvq.fo.common.form.Validation");
	</script>
