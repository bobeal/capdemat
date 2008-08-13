<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

  <logic:iterate id="itemAdult" name="stateManager" property="selectedRecord.family.adults">
    <div class="grid_cell">
      <div class="block009">
        <p class="text005 pictoAdults"><bean:message key="adult"/><bean:message key="field.simple"/></p>
      </div>
      <div class="block010">
        <fieldset class="fieldset005">
          <div class="form_cell form_cell1">
            <label for="familyHomeResponsible" class="label"><bean:message key="adult.familyHomeResponsible"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="familyHomeResponsible" id="id" type="yesno" profile="profile"/></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="title" class="label"><bean:message key="adult.title"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="title" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="familyStatus" class="label"><bean:message key="adult.familyStatus"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="familyStatus" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="lastName" class="label"><bean:message key="adult.lastName"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="lastName" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="firstName" class="label"><bean:message key="adult.firstName"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="firstName" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="additionalDeliveryInformation" class="label">Etg. - Esc. - App.<bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="additionalDeliveryInformation" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="additionalGeographicalInformation" class="label">Imm. - Bât. - Rés.<bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="additionalGeographicalInformation" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="streetNumber" class="label">Numéro<bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="streetNumber" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="streetName" class="label">Libellé de la voie<bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="streetName" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="placeNameOrService" class="label">Lieu-dit, boite postale<bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="placeNameOrService" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="postalCode" class="label"><bean:message key="adult.postalCode"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="postalCode" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="city" class="label">Localité:</label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="city" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="homePhone" class="label"><bean:message key="adult.homePhone"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="homePhone" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="birthDay" class="label"><bean:message key="adult.birthDay"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="birthDay" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="birthPlace" class="label"><bean:message key="adult.birthPlace"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="birthPlace" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="userName" class="label"><bean:message key="adult.userName"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="userName" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="maidenName" class="label"><bean:message key="adult.maidenName"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="maidenName" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="officePhone" class="label"><bean:message key="adult.officePhone"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="officePhone" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="mobilePhone" class="label"><bean:message key="adult.mobilePhone"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="mobilePhone" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="caseOfFamilyBenifitsNumber" class="label"><bean:message key="adult.caseOfFamilyBenifitsNumber"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="caseOfFamilyBenifitsNumber" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="profession" class="label"><bean:message key="adult.profession"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="profession" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="email" class="label"><bean:message key="adult.email"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemAdult" property="email" id="id" profile="profile" /></span>
          </div>
        </fieldset>
      </div>
    </div>
  </logic:iterate>

<logic:present name="stateManager" property="selectedRecord.family.children">
  <logic:iterate id="itemChild" name="stateManager" property="selectedRecord.family.children">
    <div class="grid_cell">
      <div class="block009">
        <p class="text005 pictoAdults"><bean:message key="child"/><bean:message key="field.simple"/></p>
      </div>

      <div class="block010">
        <fieldset class="fieldset005">
          <div class="form_cell form_cell1">
            <label for="lastName" class="label"><bean:message key="child.lastName"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemChild" property="lastName" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="firstName" class="label"><bean:message key="child.firstName"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemChild" property="firstName" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="birthDay" class="label"><bean:message key="child.birthDay"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemChild" property="birthDay" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="birthPlace" class="label"><bean:message key="child.birthPlace"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemChild" property="birthPlace" id="id" profile="profile" /></span>
          </div>

          <div class="form_cell form_cell1">
            <label for="sex" class="label"><bean:message key="child.sex"/><bean:message key="field.simple"/></label>
            <span class="input"><cvq:toggleInput name="itemChild" property="sex" id="id" profile="profile" /></span>
          </div>
        </fieldset>
      </div>
    </div>
  </logic:iterate>
</logic:present>

    <script language="JavaScript">
	    function selectionData() {
		    this.yesno = new Function("key","this.values=new Array('Oui', 'Non'); return this[key];");
		    this.sex = new Function("key","this.values=new Array('M', 'F', '?'); return this[key];");
		    this.title = new Function("key","this.values=new Array('Monsieur', 'Madame', 'Mademoiselle'); return this[key];");
		    this.state = new Function("key","this.values=new Array('Célibataire', 'Divorcé', 'Veuf(ve)', 'Marié', 'Concubinage', 'Autre'); return this[key];");
	    }
    </script>
    <div class="clear-both"></div>
