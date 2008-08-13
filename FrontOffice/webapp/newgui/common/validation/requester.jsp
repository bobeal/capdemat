<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

    <p class="high_paragraph">
      <strong>
    	Cette étape est la dernière, vérifiez que les informations ci-dessous sont conformes
    	et validez les en appuyant sur le bouton "Page suivante".
      </strong>
    </p>

<logic:empty name="BaseAction.authentification" scope="session">
	<cvqf:form name="fr.cg95.cvq.wizard.process.ProcessStageAction.request" action="#">
	
        <div class="fieldset_title_people">
          <h3 class="fieldset_title">DEMANDEUR</h3>
        </div>
        <ul class="validation_list">
          <li class="text_row">
            <p class="label">
              Civilité : 
            </p>
            <p class="text">
              <cvqf:select name="requester.title" mode="static">
				<option value="">Choisissez une civilité</option>
				<option value="Mister">Monsieur</option>
				<option value="Madam">Madame</option>
				<option value="Miss">Mademoiselle</option>
				<option value="Agency">Organisme</option>
			  </cvqf:select>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
              Nom :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.lastName" mode="static" maxlength="38"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
              Prénom :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.firstName" mode="static" maxlength="38"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Nom de jeune fille :
            </p>
            <p class="text">
   			  <cvqf:text name="requester.maidenName" mode="static" maxlength="38"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Date de naissance :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.birthDate" mode="static" maxlength="10"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Etg. - Esc. - App. :			
            </p>
            <p class="text">
    		  <cvqf:text name="requester.address.additionalDeliveryInformation" mode="static" maxlength="38"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Imm. - Bât. - Rés. :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.address.additionalGeographicalInformation" mode="static" maxlength="38"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				N&deg;, libellé de la voie :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.address.streetNumber" mode="static" maxlength="5"/>
              <cvqf:text name="requester.address.streetName" mode="static" maxlength="32" size="35"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Lieu-dit, boite postale :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.address.placeNameOrService" mode="static" maxlength="38"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Code postal, Localité :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.address.postalCode" mode="static" maxlength="5"/>
              <cvqf:text name="requester.address.city" mode="static" maxlength="32" size="35"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Téléphone				
            </p>
            <p class="text">
    		  <cvqf:text name="requester.homePhone" mode="static" maxlength="10"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
				Courriel				
            </p>
            <p class="text">
   			  <cvqf:text name="requester.email" mode="static" maxlength="10"/>
            </p>
          </li>
        </ul>
   	</cvqf:form>
</logic:empty>
<logic:notEmpty name="BaseAction.authentification" scope="session">

	<cvqf:form name="fr.cg95.cvq.wizard.process.ProcessStageAction.request" action="#">
        <div class="fieldset_title_people">
          <h3 class="fieldset_title">DEMANDEUR</h3>
        </div>
        <ul class="validation_list">
          <li class="text_row">
            <p class="label">
              Civilité : 
            </p>
            <p class="text">
              <cvqf:select name="requester.title" mode="static">
				<option value="">Choisissez une civilité</option>
				<option value="Mister">Monsieur</option>
				<option value="Madam">Madame</option>
				<option value="Miss">Mademoiselle</option>
				<option value="Agency">Organisme</option>
			  </cvqf:select>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
              Nom :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.lastName" mode="static" maxlength="38"/>
            </p>
          </li>
          <li class="text_row">
            <p class="label">
              Prénom :
            </p>
            <p class="text">
    		  <cvqf:text name="requester.firstName" mode="static" maxlength="38"/>
            </p>
          </li>
        </ul>
   	</cvqf:form>
</logic:notEmpty>
  		