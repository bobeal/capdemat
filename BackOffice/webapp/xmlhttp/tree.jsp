<%@ page contentType="text/html; charset=UTF-8" %>

<style type="text/css">
	/*@import "css/formular.css";*/
	@import "xmlhttp/css/referential.css";
</style>

<script src="xmlhttp/TreeMenu.js" type="text/javascript" language="javascript" >;</script>
<script src="xmlhttp/AsyncManager.js" type="text/javascript" language="javascript" >;</script>
<script src="xmlhttp/DataNode.js" type="text/javascript" language="javascript" >;</script>
<script src="xmlhttp/TreeManager.js" type="text/javascript" language="javascript" >;</script>

<div class="form_block">

<div class="grid_cell">
  <div class="block008">
    <p class="text007 pictoParams">Paramètres</p>
  </div>
  <div class="block015">
    <div id="tree"></div>
  </div>
</div>

<div class="grid_cell">
  <div class="block008">
    <p class="text008 pictoParams" id="ancestors">&nbsp;</p>
  </div>
  <div class="block013">
    <fieldset class="fieldset008">
      <div id="treeaction">
        <div id="rootaction" class="form_cell form_cell001">
          <span class="input_button"><input type="button" class="input_add" value="Ajouter" onclick="displayAdd('addaction', 'rootaction', 'selectaction', 'modifyaction')"/></span>
        </div>
        <div id="selectaction" class="form_cell form_cell001">
          <span class="input_button"><input type="button" class="input_edit" value="Modifier" onclick="displayModify('modifyaction', 'rootaction', 'selectaction', 'addaction')"/></span>
          <span class="input_button"><input type="button" class="input_add" value="Ajouter" onclick="displayAdd('addaction', 'rootaction', 'selectaction', 'modifyaction')"/></span>
          <span class="input_button"><input type="button" class="input_delete" value="Supprimer" onclick="deleteData()"/></span>
        </div>
        <div id="modifyaction" class="form_cell form_cell001">
          <span class="input_button input_button001"><input type="button" class="input_submit" value="Enregistrer" onclick="modifyData()"/></span>
          <span class="input_button"><input type="button" class="input_cancel" value="Annuler" onclick="displaySelect()"/></span>
        </div>
        <div id="addaction" class="form_cell form_cell001">
          <span class="input_button input_button001"><input type="button" class="input_submit" value="Enregistrer" onclick="addData()"/></span>
          <span class="input_button"><input type="button" class="input_cancel" value="Annuler" onclick="displaySelect()"/></span>
        </div>
      </div>
    </fieldset>
    
    <fieldset class="fieldset008" id="treedetail">
      <div class="form_cell">
        <label for="key" class="label">Clé :</label>
        <span class="input" id="key"></span>
      </div>
      
      <div class="form_cell">
        <label for="label" class="label">Libellé :</label>
        <span class="input" id="label"></span>
      </div>
      
      <div class="form_cell">
        <label for="message" class="label">Message :</label>
        <span class="input" id="message"></span>
      </div>
      
      <div class="form_cell">
        <label for="eventDate" class="label">Date :</label>
        <span class="input" id="eventDate"></span>
      </div>
      
      <div class="form_cell">
        <label for="reservationStartDate" class="label">Début :</label>
        <span class="input" id="reservationStartDate"></span>
      </div>
      
      <div class="form_cell">
        <label for="reservationEndDate" class="label">Fin :</label>
        <span class="input" id="reservationEndDate"></span>
      </div>
      <div class="form_cell">
        <label for="quota" class="label">Places disponibles :</label>
        <span class="input" id="quota"></span>
      </div>
      
      <div class="form_cell">
        <label for="remainingPlaces" class="label">Places restantes :</label>
        <span class="input" id="remainingPlaces"></span>
      </div>
      
      <div class="form_cell">
        <label for="price" class="label">Prix unitaire :</label>
        <span class="input" id="price"></span>
      </div>
      
      <div class="form_cell">
        <label for="subscriber" class="label">Tarif abonnée :</label>
        <span class="input" id="subscriber"></span>
      </div>
      
      <div class="form_cell">
        <label for="supportMultiple" class="label">Support multiple :</label>
        <span class="input" id="supportMultipleDisabled"></span>
      </div>
      
      <div class="form_cell">
        <label for="supportQuota" class="label">Support quota :</label>
        <span class="input" id="supportQuotaDisabled"></span>
      </div>
      
      <div class="form_cell">
        <label for="supportPriority" class="label">Demande priorité :</label>
        <span class="input" id="supportPriority"></span>
      </div>
      
      <div class="form_cell">
        <label for="labelPriority" class="label">Libellé priorité :</label>
        <span class="input" id="labelPriorityDisabled"></span>
      </div>
      
      <div class="form_cell">
        <label for="supportPrecision" class="label">Demande précision :</label>
        <span class="input" id="supportPrecision"></span>
      </div>
      
      <div class="form_cell">
        <label for="labelPrecision" class="label">Libellé précision :</label>
        <span class="input" id="labelPrecisionDisabled"></span>
      </div>
    </fieldset>
  </div>
</div>

</div>


<script type="text/javascript" language="javascript" >
	initXmlTree('tree','treedetail','treeaction');
	resetSelectDisplay('selectaction', 'rootaction', 'modifyaction', 'addaction');
	resetRootDisplay('rootaction', 'selectaction', 'modifyaction', 'addaction');
</script>

