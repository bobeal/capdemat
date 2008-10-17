<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Residences" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="currentDwellingCurrentDwellingAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="currentDwellingCurrentDwellingAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">            
            Téléphone personnel
          </p>
          <p class="text">
            <cvqf:text name="currentDwellingCurrentDwellingPersonalPhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nature de l'habitation
          </p>
          <p class="text">
            <cvqf:select name="currentDwellingCurrentDwellingType" mode="static">
              <option value="">Choisissez un nature de l'habitation</option>
              <option value="Domicile">Domicile</option>
              <option value="EtablissmentPA">Etablissment PA</option>
              <option value="AccueilParticulierOnereux">Accueil particulier à titre onéreux</option>
              <option value="Autre">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date d'arrivée
          </p>
          <p class="text">
            <cvqf:text name="currentDwellingCurrentDwellingArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Statut Habitation
          </p>
          <p class="text">
            <cvqf:select name="currentDwellingCurrentDwellingStatus" mode="static">
              <option value="">Choisissez un statut habitation</option>
              <option value="Owner">Propriétaire</option>
              <option value="Tenant">Locataire</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nombre de pièces
          </p>
          <p class="text">
            <cvqf:text name="currentDwellingCurrentDwellingRoomNumber" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Surface habitable
          </p>
          <p class="text">
            <cvqf:text name="currentDwellingCurrentDwellingNetFloorArea" mode="static" maxlength="10"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Residences");
	</script>
