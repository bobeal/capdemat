


  
    <fieldset class="required">
    <legend><g:message code="sagr.property.subventionPubliqueFonctionnement.label" /></legend>
    
      <label for="subventionSolliciteConseilGeneral" class="required"><g:message code="sagr.property.subventionSolliciteConseilGeneral.label" /> *  <span><g:message code="sagr.property.subventionSolliciteConseilGeneral.help" /></span></label>
            <input type="text" id="subventionSolliciteConseilGeneral" name="subventionSolliciteConseilGeneral" value="${rqt.subventionSolliciteConseilGeneral?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('subventionSolliciteConseilGeneral') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.subventionSolliciteConseilGeneral.validationError" />"   />
            

    
      <label for="cndsAnneeN" class=""><g:message code="sagr.property.cndsAnneeN.label" />   <span><g:message code="sagr.property.cndsAnneeN.help" /></span></label>
            <input type="text" id="cndsAnneeN" name="cndsAnneeN" value="${rqt.cndsAnneeN?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('cndsAnneeN') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.cndsAnneeN.validationError" />"   />
            

    
      <label for="cndsAnneeNPlusUn" class=""><g:message code="sagr.property.cndsAnneeNPlusUn.label" />   <span><g:message code="sagr.property.cndsAnneeNPlusUn.help" /></span></label>
            <input type="text" id="cndsAnneeNPlusUn" name="cndsAnneeNPlusUn" value="${rqt.cndsAnneeNPlusUn?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('cndsAnneeNPlusUn') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.cndsAnneeNPlusUn.validationError" />"   />
            

    
      <label for="regionAnneeN" class=""><g:message code="sagr.property.regionAnneeN.label" />   <span><g:message code="sagr.property.regionAnneeN.help" /></span></label>
            <input type="text" id="regionAnneeN" name="regionAnneeN" value="${rqt.regionAnneeN?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('regionAnneeN') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.regionAnneeN.validationError" />"   />
            

    
      <label for="regionAnneeNPlusUn" class=""><g:message code="sagr.property.regionAnneeNPlusUn.label" />   <span><g:message code="sagr.property.regionAnneeNPlusUn.help" /></span></label>
            <input type="text" id="regionAnneeNPlusUn" name="regionAnneeNPlusUn" value="${rqt.regionAnneeNPlusUn?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('regionAnneeNPlusUn') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.regionAnneeNPlusUn.validationError" />"   />
            

    
      <label for="communeAnneeN" class=""><g:message code="sagr.property.communeAnneeN.label" />   <span><g:message code="sagr.property.communeAnneeN.help" /></span></label>
            <input type="text" id="communeAnneeN" name="communeAnneeN" value="${rqt.communeAnneeN?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('communeAnneeN') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.communeAnneeN.validationError" />"   />
            

    
      <label for="communeAnneeNPlusUn" class=""><g:message code="sagr.property.communeAnneeNPlusUn.label" />   <span><g:message code="sagr.property.communeAnneeNPlusUn.help" /></span></label>
            <input type="text" id="communeAnneeNPlusUn" name="communeAnneeNPlusUn" value="${rqt.communeAnneeNPlusUn?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('communeAnneeNPlusUn') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.communeAnneeNPlusUn.validationError" />"   />
            

    
    </fieldset>
  

  
    <label for="compteBancaire" class="required"><g:message code="sagr.property.compteBancaire.label" /> *  <span><g:message code="sagr.property.compteBancaire.help" /></span></label>
            <div class="address required  ${rqt.stepStates['subvention'].invalidFields.contains('compteBancaire') ? 'validation-failed' : ''}">
            <label for="compteBancaire.BIC"><g:message code="bankAccount.property.BIC" /></label>
            <input type="text" class="required ${rqt.stepStates['subvention'].invalidFields.contains('compteBancaire.BIC') ? 'validation-failed' : ''}" value="${rqt.compteBancaire?.BIC}" maxlength="11" id="compteBancaire.BIC" name="compteBancaire.BIC" />
            <label for="compteBancaire.IBAN"><g:message code="bankAccount.property.IBAN" /></label>
            <input type="text" class="required validate-IBAN ${rqt.stepStates['subvention'].invalidFields.contains('compteBancaire.IBAN') ? 'validation-failed' : ''}" value="${rqt.compteBancaire?.IBAN}" maxlength="34" id="compteBancaire.IBAN" name="compteBancaire.IBAN" />
            </div>
            

  

