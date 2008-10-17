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
         <label for"" class="label temp_title_class">Biens partage, donation ou vente</label>
         <span class="input"></span>
       </div>
           <div class="form_cell form_cell1">
         <label for="notRealAssets" class="label">Biens partage, donation ou vente :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="notRealAssets">
                    <notRealAssetsAssetType,Type>
        	                <notRealAssetsAssetKind,Nature du bien>
        	                    <notRealAssetsAssetAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
		<notRealAssetsAssetAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
		<notRealAssetsAssetAddressStreetNumber,Numéro>
		<notRealAssetsAssetAddressStreetName,Libellé de la voie>
		<notRealAssetsAssetAddressPlaceNameOrService,Lieu-dit, boite postale>
		<notRealAssetsAssetAddressPostalCode,Code postal>
		<notRealAssetsAssetAddressCity,Localité>
        	                <notRealAssetsAssetBeneficiaryName,Nom du bénéficiaire>
        	                <notRealAssetsAssetBeneficiaryFirstName,Prénom du bénéficiaire>
        	                    <notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
		<notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
		<notRealAssetsAssetBeneficiaryAddressStreetNumber,Numéro>
		<notRealAssetsAssetBeneficiaryAddressStreetName,Libellé de la voie>
		<notRealAssetsAssetBeneficiaryAddressPlaceNameOrService,Lieu-dit, boite postale>
		<notRealAssetsAssetBeneficiaryAddressPostalCode,Code postal>
		<notRealAssetsAssetBeneficiaryAddressCity,Localité>
        	                <notRealAssetsAssetValue,Valeur déclarée>
        	                <notRealAssetsAssetDate,Date partage, donation ou vente>
        	                <notRealAssetsAssetNotaryName,Nom du notaire>
        	                    <notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
		<notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
		<notRealAssetsAssetNotaryAddressStreetNumber,Numéro>
		<notRealAssetsAssetNotaryAddressStreetName,Libellé de la voie>
		<notRealAssetsAssetNotaryAddressPlaceNameOrService,Lieu-dit, boite postale>
		<notRealAssetsAssetNotaryAddressPostalCode,Code postal>
		<notRealAssetsAssetNotaryAddressCity,Localité>
        	  	</cvq:toggleInput>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="notRealAssetsValuesTotal" class="label">Valeur totale des biens en donation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="notRealAssetsValuesTotal"/>
    
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

