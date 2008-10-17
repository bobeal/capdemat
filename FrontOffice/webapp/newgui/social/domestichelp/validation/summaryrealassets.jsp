<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
      </ul>
      <cvqf:title stage="Biens immobiliers"/>
      <ul class="validation_list">
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(assets)">
          <realAssetsRealAssetAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <realAssetsRealAssetAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <realAssetsRealAssetAddressStreetNumber,Numéro>
          <realAssetsRealAssetAddressStreetName,Libellé de la voie>
          <realAssetsRealAssetAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <realAssetsRealAssetAddressPostalCode,Code postal>
          <realAssetsRealAssetAddressCity,Localité>
          <realAssetsRealAssetValue,Valeur estimée>
          <realAssetsRealAssetNetFloorArea,Superficie>
        </cvqf:list>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
