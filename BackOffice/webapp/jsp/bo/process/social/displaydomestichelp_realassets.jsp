<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
    <div class="block009">
     <p class="text005 pictoTable">Formulaire</p>
   </div>
   <div class="block010">
     <fieldset class="fieldset005">
 
         <div class="form_cell">
         <label for"" class="label temp_title_class">Biens Immobiliers</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="realAssets" class="label">Bien(s) :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="realAssets">
                        <realAssetsRealAssetAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
		<realAssetsRealAssetAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
		<realAssetsRealAssetAddressStreetNumber,Numéro>
		<realAssetsRealAssetAddressStreetName,Libellé de la voie>
		<realAssetsRealAssetAddressPlaceNameOrService,Lieu-dit, boite postale>
		<realAssetsRealAssetAddressPostalCode,Code postal>
		<realAssetsRealAssetAddressCity,Localité>
        	                <realAssetsRealAssetValue,Valeur estimée>
        	                <realAssetsRealAssetNetFloorArea,Superficie>
        	  	</cvq:toggleInput>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="realAssetsValuesTotal" class="label">Valeur totale des biens immobiliers :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="realAssetsValuesTotal"/>
    
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
          		}
</script>
 <div class="clear-both"></div>

