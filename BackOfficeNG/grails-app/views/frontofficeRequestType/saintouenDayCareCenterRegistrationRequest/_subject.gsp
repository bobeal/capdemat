


  
    
            <label for="subjectId" class="required">
              <g:message code="sdccrr.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${rqt.stepStates[currentStep].state != 'complete' && !rqt.requestType.getStepAccountCompletion()}">
                <g:if test="${!fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_NONE.equals(subjectPolicy)}">
                  <g:if test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_ADULT.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:if>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_CHILD.equals(subjectPolicy)}">
                    <span>(<a id="addSubjectLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addSubject" /></a>)</span>
                  </g:elseif>
                  <g:elseif test="${fr.cg95.cvq.service.request.IRequestWorkflowService.SUBJECT_POLICY_INDIVIDUAL.equals(subjectPolicy)}">
                    <span>(<a id="addAdultLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'adult', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addAdult" /></a>
                    <g:message code="message.or" />
                    <a id="addChildLink" href="${createLink(controller : 'frontofficeRequest', action : 'individual', params : ['type' : 'child', 'requestId' : rqt.id])}"><g:message code="homeFolder.action.addChild" /></a>)</span>
                  </g:elseif>
                </g:if>
              </g:if>
            </label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['subject'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <fieldset class="required">
    <legend><g:message code="sdccrr.property.informationMere.label" /></legend>
    
      <label for="situationActuelleMere" class=""><g:message code="sdccrr.property.situationActuelleMere.label" />   <span><g:message code="sdccrr.property.situationActuelleMere.help" /></span></label>
            <select id="situationActuelleMere" name="situationActuelleMere" class="condition-estAutreSituationActuelleMere-trigger  validate-select ${rqt.stepStates['subject'].invalidFields.contains('situationActuelleMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.situationActuelleMere.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PLEIN','PARTIEL','INTERIM','ETUDIANT','STAGE','RECHERCHE','PARENT','LIBRE','CONGE','RETRAITE','AUTRE']}">
                <option value="${it}" ${it == rqt.situationActuelleMere?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sdccrr.property.situationActuelleMere" /></option>
              </g:each>
            </select>
            

    
      <label for="precisionAutreSituationActuelleMere" class="required condition-estAutreSituationActuelleMere-filled"><g:message code="sdccrr.property.precisionAutreSituationActuelleMere.label" /> *  <span><g:message code="sdccrr.property.precisionAutreSituationActuelleMere.help" /></span></label>
            <input type="text" id="precisionAutreSituationActuelleMere" name="precisionAutreSituationActuelleMere" value="${rqt.precisionAutreSituationActuelleMere?.toString()}" 
                    class="required condition-estAutreSituationActuelleMere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('precisionAutreSituationActuelleMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.precisionAutreSituationActuelleMere.validationError" />"   />
            

    
      <label for="professionMere" class=""><g:message code="sdccrr.property.professionMere.label" />   <span><g:message code="sdccrr.property.professionMere.help" /></span></label>
            <input type="text" id="professionMere" name="professionMere" value="${rqt.professionMere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('professionMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.professionMere.validationError" />"   />
            

    
      <label for="employeurMere" class=""><g:message code="sdccrr.property.employeurMere.label" />   <span><g:message code="sdccrr.property.employeurMere.help" /></span></label>
            <input type="text" id="employeurMere" name="employeurMere" value="${rqt.employeurMere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('employeurMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.employeurMere.validationError" />"   />
            

    
      <label class=""><g:message code="sdccrr.property.estHorairesReguliersMere.label" />   <span><g:message code="sdccrr.property.estHorairesReguliersMere.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['subject'].invalidFields.contains('estHorairesReguliersMere') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estHorairesReguliersMere_${it ? 'yes' : 'no'}" class="condition-estHorairesReguliersMere-trigger  validate-one-required boolean" title="" value="${it}" name="estHorairesReguliersMere" ${it == rqt.estHorairesReguliersMere ? 'checked="checked"': ''} />
                <label for="estHorairesReguliersMere_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="horairesReguliersMere" class="condition-estHorairesReguliersMere-filled"><g:message code="sdccrr.property.horairesReguliersMere.label" />   <span><g:message code="sdccrr.property.horairesReguliersMere.help" /></span></label>
            <input type="text" id="horairesReguliersMere" name="horairesReguliersMere" value="${rqt.horairesReguliersMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesReguliersMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesReguliersMere.validationError" />"   />
            

    
      <label for="horairesTravailLundiMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailLundiMere.label" />   <span><g:message code="sdccrr.property.horairesTravailLundiMere.help" /></span></label>
            <input type="text" id="horairesTravailLundiMere" name="horairesTravailLundiMere" value="${rqt.horairesTravailLundiMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailLundiMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailLundiMere.validationError" />"   />
            

    
      <label for="horairesTravailMardiMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailMardiMere.label" />   <span><g:message code="sdccrr.property.horairesTravailMardiMere.help" /></span></label>
            <input type="text" id="horairesTravailMardiMere" name="horairesTravailMardiMere" value="${rqt.horairesTravailMardiMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMardiMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailMardiMere.validationError" />"   />
            

    
      <label for="horairesTravailMercrediMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailMercrediMere.label" />   <span><g:message code="sdccrr.property.horairesTravailMercrediMere.help" /></span></label>
            <input type="text" id="horairesTravailMercrediMere" name="horairesTravailMercrediMere" value="${rqt.horairesTravailMercrediMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMercrediMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailMercrediMere.validationError" />"   />
            

    
      <label for="horairesTravailJeudiMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailJeudiMere.label" />   <span><g:message code="sdccrr.property.horairesTravailJeudiMere.help" /></span></label>
            <input type="text" id="horairesTravailJeudiMere" name="horairesTravailJeudiMere" value="${rqt.horairesTravailJeudiMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailJeudiMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailJeudiMere.validationError" />"   />
            

    
      <label for="horairesTravailVendrediMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailVendrediMere.label" />   <span><g:message code="sdccrr.property.horairesTravailVendrediMere.help" /></span></label>
            <input type="text" id="horairesTravailVendrediMere" name="horairesTravailVendrediMere" value="${rqt.horairesTravailVendrediMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailVendrediMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailVendrediMere.validationError" />"   />
            

    
      <label for="communeLieuTravailMere" class=""><g:message code="sdccrr.property.communeLieuTravailMere.label" />   <span><g:message code="sdccrr.property.communeLieuTravailMere.help" /></span></label>
            <input type="text" id="communeLieuTravailMere" name="communeLieuTravailMere" value="${rqt.communeLieuTravailMere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('communeLieuTravailMere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.communeLieuTravailMere.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="">
    <legend><g:message code="sdccrr.property.informationPere.label" /></legend>
    
      <label for="situationActuellePere" class=""><g:message code="sdccrr.property.situationActuellePere.label" />   <span><g:message code="sdccrr.property.situationActuellePere.help" /></span></label>
            <select id="situationActuellePere" name="situationActuellePere" class="condition-estAutreSituationActuellePere-trigger  validate-select ${rqt.stepStates['subject'].invalidFields.contains('situationActuellePere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.situationActuellePere.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PLEIN','PARTIEL','INTERIM','ETUDIANT','STAGE','RECHERCHE','PARENT','LIBRE','CONGE','RETRAITE','AUTRE']}">
                <option value="${it}" ${it == rqt.situationActuellePere?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sdccrr.property.situationActuellePere" /></option>
              </g:each>
            </select>
            

    
      <label for="precisionAutreSituationActuellePere" class="required condition-estAutreSituationActuellePere-filled"><g:message code="sdccrr.property.precisionAutreSituationActuellePere.label" /> *  <span><g:message code="sdccrr.property.precisionAutreSituationActuellePere.help" /></span></label>
            <input type="text" id="precisionAutreSituationActuellePere" name="precisionAutreSituationActuellePere" value="${rqt.precisionAutreSituationActuellePere?.toString()}" 
                    class="required condition-estAutreSituationActuellePere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('precisionAutreSituationActuellePere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.precisionAutreSituationActuellePere.validationError" />"   />
            

    
      <label for="professionPere" class=""><g:message code="sdccrr.property.professionPere.label" />   <span><g:message code="sdccrr.property.professionPere.help" /></span></label>
            <input type="text" id="professionPere" name="professionPere" value="${rqt.professionPere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('professionPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.professionPere.validationError" />"   />
            

    
      <label for="employeurPere" class=""><g:message code="sdccrr.property.employeurPere.label" />   <span><g:message code="sdccrr.property.employeurPere.help" /></span></label>
            <input type="text" id="employeurPere" name="employeurPere" value="${rqt.employeurPere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('employeurPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.employeurPere.validationError" />"   />
            

    
      <label class=""><g:message code="sdccrr.property.estHorairesReguliersPere.label" />   <span><g:message code="sdccrr.property.estHorairesReguliersPere.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['subject'].invalidFields.contains('estHorairesReguliersPere') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estHorairesReguliersPere_${it ? 'yes' : 'no'}" class="condition-estHorairesReguliersPere-trigger  validate-one-required boolean" title="" value="${it}" name="estHorairesReguliersPere" ${it == rqt.estHorairesReguliersPere ? 'checked="checked"': ''} />
                <label for="estHorairesReguliersPere_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="horairesReguliersPere" class="condition-estHorairesReguliersPere-filled"><g:message code="sdccrr.property.horairesReguliersPere.label" />   <span><g:message code="sdccrr.property.horairesReguliersPere.help" /></span></label>
            <input type="text" id="horairesReguliersPere" name="horairesReguliersPere" value="${rqt.horairesReguliersPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesReguliersPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesReguliersPere.validationError" />"   />
            

    
      <label for="horairesTravailLundiPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailLundiPere.label" />   <span><g:message code="sdccrr.property.horairesTravailLundiPere.help" /></span></label>
            <input type="text" id="horairesTravailLundiPere" name="horairesTravailLundiPere" value="${rqt.horairesTravailLundiPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailLundiPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailLundiPere.validationError" />"   />
            

    
      <label for="horairesTravailMardiPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailMardiPere.label" />   <span><g:message code="sdccrr.property.horairesTravailMardiPere.help" /></span></label>
            <input type="text" id="horairesTravailMardiPere" name="horairesTravailMardiPere" value="${rqt.horairesTravailMardiPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMardiPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailMardiPere.validationError" />"   />
            

    
      <label for="horairesTravailMercrediPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailMercrediPere.label" />   <span><g:message code="sdccrr.property.horairesTravailMercrediPere.help" /></span></label>
            <input type="text" id="horairesTravailMercrediPere" name="horairesTravailMercrediPere" value="${rqt.horairesTravailMercrediPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMercrediPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailMercrediPere.validationError" />"   />
            

    
      <label for="horairesTravailJeudiPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailJeudiPere.label" />   <span><g:message code="sdccrr.property.horairesTravailJeudiPere.help" /></span></label>
            <input type="text" id="horairesTravailJeudiPere" name="horairesTravailJeudiPere" value="${rqt.horairesTravailJeudiPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailJeudiPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailJeudiPere.validationError" />"   />
            

    
      <label for="horairesTravailVendrediPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailVendrediPere.label" />   <span><g:message code="sdccrr.property.horairesTravailVendrediPere.help" /></span></label>
            <input type="text" id="horairesTravailVendrediPere" name="horairesTravailVendrediPere" value="${rqt.horairesTravailVendrediPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailVendrediPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.horairesTravailVendrediPere.validationError" />"   />
            

    
      <label for="communeLieuTravailPere" class=""><g:message code="sdccrr.property.communeLieuTravailPere.label" />   <span><g:message code="sdccrr.property.communeLieuTravailPere.help" /></span></label>
            <input type="text" id="communeLieuTravailPere" name="communeLieuTravailPere" value="${rqt.communeLieuTravailPere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('communeLieuTravailPere') ? 'validation-failed' : ''}" title="<g:message code="sdccrr.property.communeLieuTravailPere.validationError" />"   />
            

    
    </fieldset>
  

