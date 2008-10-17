<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
      </ul>
      <cvqf:title stage="Biens partage, donation ou vente"/>
      <ul class="validation_list">
        <cvqf:list name="fr.cg95.cvq.fo.common.Request" property="list(notrealasset)">
          <notRealAssetsAssetType,Type,Share=Partage,Gift=Donation,Sale=Vente>
          <notRealAssetsAssetKind,Nature du bien,RealEstate=Immobilier,Other=Autre>
          <notRealAssetsAssetAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <notRealAssetsAssetAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <notRealAssetsAssetAddressStreetNumber,Numéro>
          <notRealAssetsAssetAddressStreetName,Libellé de la voie>
          <notRealAssetsAssetAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <notRealAssetsAssetAddressPostalCode,Code postal>
          <notRealAssetsAssetAddressCity,Localité>
          <notRealAssetsAssetBeneficiaryName,Nom du bénéficiaire>
          <notRealAssetsAssetBeneficiaryFirstName,Prénom du bénéficiaire>
          <notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <notRealAssetsAssetBeneficiaryAddressStreetNumber,Numéro>
          <notRealAssetsAssetBeneficiaryAddressStreetName,Libellé de la voie>
          <notRealAssetsAssetBeneficiaryAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <notRealAssetsAssetBeneficiaryAddressPostalCode,Code postal>
          <notRealAssetsAssetBeneficiaryAddressCity,Localité>
          <notRealAssetsAssetValue,Valeur déclarée>
          <notRealAssetsAssetDate,Date partage, donation ou vente>
          <notRealAssetsAssetNotaryName,Nom du notaire>
          <notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation,Etg. - Esc. - App.>
          <notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation,Imm. - Bât. - Rés.>
          <notRealAssetsAssetNotaryAddressStreetNumber,Numéro>
          <notRealAssetsAssetNotaryAddressStreetName,Libellé de la voie>
          <notRealAssetsAssetNotaryAddressPlaceNameOrService,Lieu-dit ou boite postale>
          <notRealAssetsAssetNotaryAddressPostalCode,Code postal>
          <notRealAssetsAssetNotaryAddressCity,Localité>
        </cvqf:list>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
