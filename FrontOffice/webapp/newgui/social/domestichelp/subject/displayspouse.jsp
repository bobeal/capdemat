<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Subject" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom de jeune fille
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationMaidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Né(e) le
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationBirthDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseInformationBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Numéro de sécurité sociale
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseSocialSecurityNumber" mode="static" maxlength="13"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Clé de numéro de sécurité sociale
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseSocialSecurityKeyNumber" mode="static" maxlength="2"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nationalité
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpouseNationality" mode="static">
              <option value="">Choisissez un nationalité</option>
              <option value="French">Française</option>
              <option value="EuropeanUnion">Union Européenne</option>
              <option value="OutsideEuropeanUnion">Hors Union Européenne</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Date d'arrivée en France
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseFranceArrivalDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Retraité
          </p>
          <p class="text">
            <cvqf:radio name="requesterSpouseSpousePensionner" mode="static" label="[Oui,Non]" />
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Régime retraite
          </p>
          <p class="text">
            <cvqf:select name="requesterSpouseSpousePensionPlan" mode="static">
              <option value="">Choisissez un régime retraite</option>
              <option value="CRAMIF">CRAMIF</option>
              <option value="Other">Autre</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Profession
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseOccupation" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Employeur
          </p>
          <p class="text">
            <cvqf:text name="requesterSpouseSpouseEmployer" mode="static" maxlength="50"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="requesterSpouseSpouseEmployerAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Subject");
	</script>
