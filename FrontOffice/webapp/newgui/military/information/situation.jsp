<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Information" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="aliveChildren" class="label">Nombre de frères et soeurs vivants<span class="required">*</span></label>
            <cvqf:text name="aliveChildren" mode="" maxlength="10"/>
          </li>
          <li class="select_row">
			<label for="childStatus" class="label">Situation familiale<span class="required">*</span></label>
            <cvqf:select name="childStatus" mode="">
              <option value="">Choisissez une situation familiale</option>
              <option value="Married">Marié(e)</option>
              <option value="Single">Célibataire</option>
              <option value="Divorced">Divorcé(e)</option>
              <option value="Widow">Veuf(ve)</option>
              <option value="CommonLawMarriage">Concubinage</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="childrenInCharge" class="label">Nombre d'enfants à charge<span class="required">*</span></label>
            <cvqf:text name="childrenInCharge" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="otherSituation" class="label">Autre situation</label>
            <cvqf:text name="otherSituation" mode=""/>
          </li>
          <li class="radio_row">
			<label for="statePupil" class="large_radio_label">Pupille de l'état<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="statePupil" mode="" label="[Oui,Non]" />
          <li class="radio_row">
			<label for="prefectPupil" class="large_radio_label">Pupille du préfet<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="prefectPupil" mode="" label="[Oui,Non]" />
          <li class="select_row">
			<label for="prefectPupilDepartment" class="label">Pupille du préfet du département</label>
            <cvqf:select name="prefectPupilDepartment" mode="">
              <option value="">Choisissez un département</option>
              <option value="None">Aucun</option>
              <option value="DEP_01">Ain</option>
              <option value="DEP_02">Aisne</option>
              <option value="DEP_03">Allier</option>
              <option value="DEP_04">Alpes-de-Haute-Provence</option>
              <option value="DEP_05">Hautes-Alpes</option>
              <option value="DEP_06">Alpes-Maritimes</option>
              <option value="DEP_07">Ardèche</option>
              <option value="DEP_08">Ardennes</option>
              <option value="DEP_09">Ariège</option>
              <option value="DEP_10">Aube</option>
              <option value="DEP_11">Aude</option>
              <option value="DEP_12">Aveyron</option>
              <option value="DEP_13">Bouches-du-Rhône</option>
              <option value="DEP_14">Calvados</option>
              <option value="DEP_15">Cantal</option>
              <option value="DEP_16">Charente</option>
              <option value="DEP_17">Charente-Maritime</option>
              <option value="DEP_18">Cher</option>
              <option value="DEP_19">Corrèze</option>
              <option value="DEP_2A">Corse-du-Sud</option>
              <option value="DEP_2B">Haute-Corse</option>
              <option value="DEP_21">Côte-d'Or</option>
              <option value="DEP_22">Côtes-d'Armor</option>
              <option value="DEP_23">Creuse</option>
              <option value="DEP_24">Dordogne</option>
              <option value="DEP_25">Doubs</option>
              <option value="DEP_26">Drôme</option>
              <option value="DEP_27">Eure</option>
              <option value="DEP_28">Eure-et-Loir</option>
              <option value="DEP_29">Finistère</option>
              <option value="DEP_30">Gard</option>
              <option value="DEP_31">Haute-Garonne</option>
              <option value="DEP_32">Gers</option>
              <option value="DEP_33">Gironde</option>
              <option value="DEP_34">Hérault</option>
              <option value="DEP_35">Ille-et-Vilaine</option>
              <option value="DEP_36">Indre</option>
              <option value="DEP_37">Indre-et-Loire</option>
              <option value="DEP_38">Isère</option>
              <option value="DEP_39">Jura</option>
              <option value="DEP_40">Landes</option>
              <option value="DEP_41">Loir-et-Cher</option>
              <option value="DEP_42">Loire</option>
              <option value="DEP_43">Haute-Loire</option>
              <option value="DEP_44">Loire-Atlantique</option>
              <option value="DEP_45">Loiret</option>
              <option value="DEP_46">Lot</option>
              <option value="DEP_47">Lot-et-Garonne</option>
              <option value="DEP_48">Lozère</option>
              <option value="DEP_49">Maine-et-Loire</option>
              <option value="DEP_50">Manche</option>
              <option value="DEP_51">Marne</option>
              <option value="DEP_52">Haute-Marne</option>
              <option value="DEP_53">Mayenne</option>
              <option value="DEP_54">Meurthe-et-Moselle</option>
              <option value="DEP_55">Meuse</option>
              <option value="DEP_56">Morbihan</option>
              <option value="DEP_57">Moselle</option>
              <option value="DEP_58">Nièvre</option>
              <option value="DEP_59">Nord</option>
              <option value="DEP_60">Oise</option>
              <option value="DEP_61">Orne</option>
              <option value="DEP_62">Pas-de-Calais</option>
              <option value="DEP_63">Puy-de-Dôme</option>
              <option value="DEP_64">Pyrénes-Atlantiques</option>
              <option value="DEP_65">Hautes-Pyrénées</option>
              <option value="DEP_66">Pyrénées-Orientales</option>
              <option value="DEP_67">Bas-Rhin</option>
              <option value="DEP_68">Haut-Rhin</option>
              <option value="DEP_69">Rhône</option>
              <option value="DEP_70">Haute-Saône</option>
              <option value="DEP_71">Saône-et-Loire</option>
              <option value="DEP_72">Sarthe</option>
              <option value="DEP_73">Savoie</option>
              <option value="DEP_74">Haute-Savoie</option>
              <option value="DEP_75">Paris</option>
              <option value="DEP_76">Seine-Maritime</option>
              <option value="DEP_77">Seine-et-Marne</option>
              <option value="DEP_78">Yvelines</option>
              <option value="DEP_79">Deux-Sèvres</option>
              <option value="DEP_80">Somme</option>
              <option value="DEP_81">Tarn</option>
              <option value="DEP_82">Tarn-et-Garonne</option>
              <option value="DEP_83">Var</option>
              <option value="DEP_84">Vaucluse</option>
              <option value="DEP_85">Vendée</option>
              <option value="DEP_86">Vienne</option>
              <option value="DEP_87">Haute-Vienne</option>
              <option value="DEP_88">Vosges</option>
              <option value="DEP_89">Yonne</option>
              <option value="DEP_90">Territoire de Belfort</option>
              <option value="DEP_91">Essonne</option>
              <option value="DEP_92">Hauts-de-Seine</option>
              <option value="DEP_93">Seine-Saint-Denis</option>
              <option value="DEP_94">Val-de-Marne</option>
              <option value="DEP_95">Val-d'Oise</option>
              <option value="DEP_971">Guadeloupe</option>
              <option value="DEP_972">Martinique</option>
              <option value="DEP_973">Guyane</option>
              <option value="DEP_974">Réunion</option>
            </cvqf:select>
          </li>
          <li class="select_row">
			<label for="childSituation" class="label">Situation scolaire ou professionnelle<span class="required">*</span></label>
            <cvqf:select name="childSituation" mode="">
              <option value="">Choisissez une situation</option>
              <option value="College">Lycéen(ne)</option>
              <option value="Highschool">Collégien(ne)</option>
              <option value="Student">Etudiant(e)</option>
              <option value="Employee">Salarié(e)</option>
              <option value="Apprentice">Apprenti(e)</option>
              <option value="Other">Autre</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </li>
          <li class="select_row">
			<label for="childDiploma" class="label">Diplôme<span class="required">*</span></label>
            <cvqf:select name="childDiploma" mode="">
              <option value="">Choisissez un diplôme</option>
              <option value="BAC">BAC</option>
              <option value="BEP">BEP</option>
              <option value="BEPC">BEPC</option>
              <option value="Brevet">Brevet</option>
              <option value="CFG">CFG</option>
              <option value="CAP">CAP</option>
              <option value="DAEU">DAEU</option>
              <option value="DEA">DEA</option>
              <option value="DEUG">DEUG</option>
              <option value="Licence">Licence</option>
              <option value="Maîtrise">Maîtrise</option>
              <option value="Unknown">Inconnu</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="childSpeciality" class="label">Spécialité</label>
            <cvqf:text name="childSpeciality" mode=""/>
          </li>
          <li class="text_row">
			<label for="childProfession" class="label">Profession</label>
            <cvqf:text name="childProfession" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.aliveChildren = new Function("key","this.label='Nombre de frères et soeurs vivants'; this.msg=null; this.required=true; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.childStatus = new Function("key","this.label='Situation familiale'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childrenInCharge = new Function("key","this.label='Nombre d&quote;enfants à charge'; this.msg=null; this.required=true; this.mask=/[0-9]+/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.otherSituation = new Function("key","this.label='Autre situation'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.statePupil = new Function("key","this.label='Pupille de l&quote;état'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.prefectPupil = new Function("key","this.label='Pupille du préfet'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.prefectPupilDepartment = new Function("key","this.label='Pupille du préfet du département'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childSituation = new Function("key","this.label='Situation scolaire ou professionnelle'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childDiploma = new Function("key","this.label='Diplôme'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childSpeciality = new Function("key","this.label='Spécialité'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childProfession = new Function("key","this.label='Profession'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("childStatus");
        updateDisplay("statePupil");
        updateDisplay("prefectPupil");
        updateDisplay("prefectPupilDepartment");
        updateDisplay("childSituation");
        updateDisplay("childDiploma");
  		setFocus("Information");
	</script>
