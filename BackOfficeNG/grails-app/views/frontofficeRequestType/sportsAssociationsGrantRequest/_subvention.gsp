


  
    <fieldset class="required">
    <legend><g:message code="sagr.property.subventionPubliqueFonctionnement.label" /></legend>
    
      <label for="subventionSolliciteConseilGeneral" class="required"><g:message code="sagr.property.subventionSolliciteConseilGeneral.label" /> *  <span><g:message code="sagr.property.subventionSolliciteConseilGeneral.help" /></span></label>
            <input type="text" id="subventionSolliciteConseilGeneral" name="subventionSolliciteConseilGeneral" value="${rqt.subventionSolliciteConseilGeneral?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('subventionSolliciteConseilGeneral') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.subventionSolliciteConseilGeneral.validationError" />"   />
            

    
      <label for="subventionObtenueConseilGeneralSaisonEcoulee" class=""><g:message code="sagr.property.subventionObtenueConseilGeneralSaisonEcoulee.label" />   <span><g:message code="sagr.property.subventionObtenueConseilGeneralSaisonEcoulee.help" /></span></label>
            <input type="text" id="subventionObtenueConseilGeneralSaisonEcoulee" name="subventionObtenueConseilGeneralSaisonEcoulee" value="${rqt.subventionObtenueConseilGeneralSaisonEcoulee?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('subventionObtenueConseilGeneralSaisonEcoulee') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.subventionObtenueConseilGeneralSaisonEcoulee.validationError" />"   />
            

    
      <label for="budgetSaisonEcouleeRecette" class=""><g:message code="sagr.property.budgetSaisonEcouleeRecette.label" />   <span><g:message code="sagr.property.budgetSaisonEcouleeRecette.help" /></span></label>
            <input type="text" id="budgetSaisonEcouleeRecette" name="budgetSaisonEcouleeRecette" value="${rqt.budgetSaisonEcouleeRecette?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('budgetSaisonEcouleeRecette') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.budgetSaisonEcouleeRecette.validationError" />"   />
            

    
      <label for="budgetSaisonEcouleeDepenses" class=""><g:message code="sagr.property.budgetSaisonEcouleeDepenses.label" />   <span><g:message code="sagr.property.budgetSaisonEcouleeDepenses.help" /></span></label>
            <input type="text" id="budgetSaisonEcouleeDepenses" name="budgetSaisonEcouleeDepenses" value="${rqt.budgetSaisonEcouleeDepenses?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('budgetSaisonEcouleeDepenses') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.budgetSaisonEcouleeDepenses.validationError" />"   />
            

    
      <label for="nombreLicencieMoinsDixHuitSaisonEcoulee" class=""><g:message code="sagr.property.nombreLicencieMoinsDixHuitSaisonEcoulee.label" />   <span><g:message code="sagr.property.nombreLicencieMoinsDixHuitSaisonEcoulee.help" /></span></label>
            <input type="text" id="nombreLicencieMoinsDixHuitSaisonEcoulee" name="nombreLicencieMoinsDixHuitSaisonEcoulee" value="${rqt.nombreLicencieMoinsDixHuitSaisonEcoulee?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('nombreLicencieMoinsDixHuitSaisonEcoulee') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nombreLicencieMoinsDixHuitSaisonEcoulee.validationError" />"   />
            

    
      <label for="nombreLicenciePlusDixHuitSaisonEcoulee" class=""><g:message code="sagr.property.nombreLicenciePlusDixHuitSaisonEcoulee.label" />   <span><g:message code="sagr.property.nombreLicenciePlusDixHuitSaisonEcoulee.help" /></span></label>
            <input type="text" id="nombreLicenciePlusDixHuitSaisonEcoulee" name="nombreLicenciePlusDixHuitSaisonEcoulee" value="${rqt.nombreLicenciePlusDixHuitSaisonEcoulee?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subvention'].invalidFields.contains('nombreLicenciePlusDixHuitSaisonEcoulee') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nombreLicenciePlusDixHuitSaisonEcoulee.validationError" />"   />
            

    
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
            

  

