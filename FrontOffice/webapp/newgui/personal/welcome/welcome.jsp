<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

<script language="JavaScript" src="./js/validation.js">
</script>
<script language="JavaScript">
	function changeStateRadioButton(radioButtonId){
		var radioButton = document.getElementById(radioButtonId);
		updateDisplay(radioButton.name);
	}
</script>

<div id="welcome" style="margin:5px;font-size: 1.1em;color: #6e6e6e;">
	<p class="text">
		Lors de la ralisation de votre dmarche, vous avez choisi de crer votre espace personnel 
		pour suivre le traitement de celle-ci. Cet espace sera dtruit une fois votre demande traite 
		par la collectivit mais vous pouvez, si vous le souhaitez, rendre permanent cet espace personnel 
		et lutiliser pour vos dmarches ultrieures.
	</p>
	<p class="paragraph">
		Voulez-vous conserver cet espace pour vos futures dmarches :
	</p>
	<ul class="list_type_welcome">
      <li class="row">
	    <input type="radio" name="keepPersonnel" value="Oui" id="keepPersonnel" onclick="changeStateRadioButton('keepPersonnel');"/>
  		<label for="keepPersonnel" class="label_type2">OUI</label>
	  	<input type="radio" name="keepPersonnel" value="Non" id="keepPersonnel1" onclick="changeStateRadioButton('keepPersonnel');" checked/>
  		<label for="keepPersonnel1" class="label_type2">NON</label>
	  </li>
	</ul>
  	<div id="Oui">
		<p class="text">
			Vous avez choisi de garder cet espace personnel, pour y accder vous pourrez dsormais vous connecter 
			directement sur le portail des dmarches en ligne de votre collectivit. 
			Conformment  la loi  Informatique et Liberts  du 06/01/1978, vous disposez d'un droit d'accs, 
			de rectification et de suppression pour toutes les informations vous concernant. Vous pouvez exercer 
			ce droit directement sur votre espace personnel ou en crivant directement  la Mairie.
		</p>
	
		<p class="text">
			Entrer immdiatement dans votre espace personnel permanent pour valider votre choix :
		</p>
<ul class="list_type1">
  <li class="item ok"><a href="keepFolderAction.do" title=""><span class="custom_color"></span>Mon espace personnel</a></li>
</ul>
	</div>
</div>
<script language="JavaScript">
	updateDisplay('keepPersonnel');
</script>

