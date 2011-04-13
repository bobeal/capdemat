


  
    
            <label for="subjectId" class="required">
              <g:message code="request.property.subject.label" /> *
              <span><g:message code="request.property.subject.help" /></span>
              <g:if test="${rqt.stepStates[currentStep].state != 'complete'}">
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
    <legend><g:message code="dccrr.property.informationMere.label" /></legend>
    
      <label for="situationActuelleMere" class=""><g:message code="dccrr.property.situationActuelleMere.label" />   <span><g:message code="dccrr.property.situationActuelleMere.help" /></span></label>
            <select id="situationActuelleMere" name="situationActuelleMere" class="condition-estAutreSituationActuelleMere-trigger  validate-select ${rqt.stepStates['subject'].invalidFields.contains('situationActuelleMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.situationActuelleMere.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PLEIN','PARTIEL','INTERIM','ETUDIANT','STAGE','RECHERCHE','PARENT','LIBRE','CONGE','RETRAITE','AUTRE']}">
                <option value="${it}" ${it == rqt.situationActuelleMere?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.situationActuelleMere" /></option>
              </g:each>
            </select>
            

    
      <label for="precisionAutreSituationActuelleMere" class="required condition-estAutreSituationActuelleMere-filled"><g:message code="dccrr.property.precisionAutreSituationActuelleMere.label" /> *  <span><g:message code="dccrr.property.precisionAutreSituationActuelleMere.help" /></span></label>
            <input type="text" id="precisionAutreSituationActuelleMere" name="precisionAutreSituationActuelleMere" value="${rqt.precisionAutreSituationActuelleMere?.toString()}" 
                    class="required condition-estAutreSituationActuelleMere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('precisionAutreSituationActuelleMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.precisionAutreSituationActuelleMere.validationError" />"   />
            

    
      <label for="professionMere" class=""><g:message code="dccrr.property.professionMere.label" />   <span><g:message code="dccrr.property.professionMere.help" /></span></label>
            <input type="text" id="professionMere" name="professionMere" value="${rqt.professionMere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('professionMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.professionMere.validationError" />"   />
            

    
      <label class=""><g:message code="dccrr.property.estHorairesReguliersMere.label" />   <span><g:message code="dccrr.property.estHorairesReguliersMere.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['subject'].invalidFields.contains('estHorairesReguliersMere') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estHorairesReguliersMere_${it ? 'yes' : 'no'}" class="condition-estHorairesReguliersMere-trigger  validate-one-required boolean" title="" value="${it}" name="estHorairesReguliersMere" ${it == rqt.estHorairesReguliersMere ? 'checked="checked"': ''} />
                <label for="estHorairesReguliersMere_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="horairesReguliersMere" class="condition-estHorairesReguliersMere-filled"><g:message code="dccrr.property.horairesReguliersMere.label" />   <span><g:message code="dccrr.property.horairesReguliersMere.help" /></span></label>
            <input type="text" id="horairesReguliersMere" name="horairesReguliersMere" value="${rqt.horairesReguliersMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesReguliersMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesReguliersMere.validationError" />"   />
            

    
      <label for="horairesTravailLundiMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="dccrr.property.horairesTravailLundiMere.label" />   <span><g:message code="dccrr.property.horairesTravailLundiMere.help" /></span></label>
            <input type="text" id="horairesTravailLundiMere" name="horairesTravailLundiMere" value="${rqt.horairesTravailLundiMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailLundiMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailLundiMere.validationError" />"   />
            

    
      <label for="horairesTravailMardiMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="dccrr.property.horairesTravailMardiMere.label" />   <span><g:message code="dccrr.property.horairesTravailMardiMere.help" /></span></label>
            <input type="text" id="horairesTravailMardiMere" name="horairesTravailMardiMere" value="${rqt.horairesTravailMardiMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMardiMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailMardiMere.validationError" />"   />
            

    
      <label for="horairesTravailMercrediMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="dccrr.property.horairesTravailMercrediMere.label" />   <span><g:message code="dccrr.property.horairesTravailMercrediMere.help" /></span></label>
            <input type="text" id="horairesTravailMercrediMere" name="horairesTravailMercrediMere" value="${rqt.horairesTravailMercrediMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMercrediMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailMercrediMere.validationError" />"   />
            

    
      <label for="horairesTravailJeudiMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="dccrr.property.horairesTravailJeudiMere.label" />   <span><g:message code="dccrr.property.horairesTravailJeudiMere.help" /></span></label>
            <input type="text" id="horairesTravailJeudiMere" name="horairesTravailJeudiMere" value="${rqt.horairesTravailJeudiMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailJeudiMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailJeudiMere.validationError" />"   />
            

    
      <label for="horairesTravailVendrediMere" class="condition-estHorairesReguliersMere-unfilled"><g:message code="dccrr.property.horairesTravailVendrediMere.label" />   <span><g:message code="dccrr.property.horairesTravailVendrediMere.help" /></span></label>
            <input type="text" id="horairesTravailVendrediMere" name="horairesTravailVendrediMere" value="${rqt.horairesTravailVendrediMere?.toString()}" 
                    class="condition-estHorairesReguliersMere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailVendrediMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailVendrediMere.validationError" />"   />
            

    
      <label for="communeLieuTravailMere" class=""><g:message code="dccrr.property.communeLieuTravailMere.label" />   <span><g:message code="dccrr.property.communeLieuTravailMere.help" /></span></label>
            <input type="text" id="communeLieuTravailMere" name="communeLieuTravailMere" value="${rqt.communeLieuTravailMere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('communeLieuTravailMere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.communeLieuTravailMere.validationError" />"   />
            

    
    </fieldset>
  

  
    <fieldset class="">
    <legend><g:message code="dccrr.property.informationPere.label" /></legend>
    
      <label for="situationActuellePere" class=""><g:message code="dccrr.property.situationActuellePere.label" />   <span><g:message code="dccrr.property.situationActuellePere.help" /></span></label>
            <select id="situationActuellePere" name="situationActuellePere" class="condition-estAutreSituationActuellePere-trigger  validate-select ${rqt.stepStates['subject'].invalidFields.contains('situationActuellePere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.situationActuellePere.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['PLEIN','PARTIEL','INTERIM','ETUDIANT','STAGE','RECHERCHE','PARENT','LIBRE','CONGE','RETRAITE','AUTRE']}">
                <option value="${it}" ${it == rqt.situationActuellePere?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.situationActuellePere" /></option>
              </g:each>
            </select>
            

    
      <label for="precisionAutreSituationActuellePere" class="required condition-estAutreSituationActuellePere-filled"><g:message code="dccrr.property.precisionAutreSituationActuellePere.label" /> *  <span><g:message code="dccrr.property.precisionAutreSituationActuellePere.help" /></span></label>
            <input type="text" id="precisionAutreSituationActuellePere" name="precisionAutreSituationActuellePere" value="${rqt.precisionAutreSituationActuellePere?.toString()}" 
                    class="required condition-estAutreSituationActuellePere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('precisionAutreSituationActuellePere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.precisionAutreSituationActuellePere.validationError" />"   />
            

    
      <label for="professionPere" class=""><g:message code="dccrr.property.professionPere.label" />   <span><g:message code="dccrr.property.professionPere.help" /></span></label>
            <input type="text" id="professionPere" name="professionPere" value="${rqt.professionPere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('professionPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.professionPere.validationError" />"   />
            

    
      <label class=""><g:message code="dccrr.property.estHorairesReguliersPere.label" />   <span><g:message code="dccrr.property.estHorairesReguliersPere.help" /></span></label>
            <ul class="yes-no  ${rqt.stepStates['subject'].invalidFields.contains('estHorairesReguliersPere') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estHorairesReguliersPere_${it ? 'yes' : 'no'}" class="condition-estHorairesReguliersPere-trigger  validate-one-required boolean" title="" value="${it}" name="estHorairesReguliersPere" ${it == rqt.estHorairesReguliersPere ? 'checked="checked"': ''} />
                <label for="estHorairesReguliersPere_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="horairesReguliersPere" class="condition-estHorairesReguliersPere-filled"><g:message code="dccrr.property.horairesReguliersPere.label" />   <span><g:message code="dccrr.property.horairesReguliersPere.help" /></span></label>
            <input type="text" id="horairesReguliersPere" name="horairesReguliersPere" value="${rqt.horairesReguliersPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-filled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesReguliersPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesReguliersPere.validationError" />"   />
            

    
      <label for="horairesTravailLundiPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="dccrr.property.horairesTravailLundiPere.label" />   <span><g:message code="dccrr.property.horairesTravailLundiPere.help" /></span></label>
            <input type="text" id="horairesTravailLundiPere" name="horairesTravailLundiPere" value="${rqt.horairesTravailLundiPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailLundiPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailLundiPere.validationError" />"   />
            

    
      <label for="horairesTravailMardiPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="dccrr.property.horairesTravailMardiPere.label" />   <span><g:message code="dccrr.property.horairesTravailMardiPere.help" /></span></label>
            <input type="text" id="horairesTravailMardiPere" name="horairesTravailMardiPere" value="${rqt.horairesTravailMardiPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMardiPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailMardiPere.validationError" />"   />
            

    
      <label for="horairesTravailMercrediPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="dccrr.property.horairesTravailMercrediPere.label" />   <span><g:message code="dccrr.property.horairesTravailMercrediPere.help" /></span></label>
            <input type="text" id="horairesTravailMercrediPere" name="horairesTravailMercrediPere" value="${rqt.horairesTravailMercrediPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailMercrediPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailMercrediPere.validationError" />"   />
            

    
      <label for="horairesTravailJeudiPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="dccrr.property.horairesTravailJeudiPere.label" />   <span><g:message code="dccrr.property.horairesTravailJeudiPere.help" /></span></label>
            <input type="text" id="horairesTravailJeudiPere" name="horairesTravailJeudiPere" value="${rqt.horairesTravailJeudiPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailJeudiPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailJeudiPere.validationError" />"   />
            

    
      <label for="horairesTravailVendrediPere" class="condition-estHorairesReguliersPere-unfilled"><g:message code="dccrr.property.horairesTravailVendrediPere.label" />   <span><g:message code="dccrr.property.horairesTravailVendrediPere.help" /></span></label>
            <input type="text" id="horairesTravailVendrediPere" name="horairesTravailVendrediPere" value="${rqt.horairesTravailVendrediPere?.toString()}" 
                    class="condition-estHorairesReguliersPere-unfilled  validate-string ${rqt.stepStates['subject'].invalidFields.contains('horairesTravailVendrediPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.horairesTravailVendrediPere.validationError" />"   />
            

    
      <label for="communeLieuTravailPere" class=""><g:message code="dccrr.property.communeLieuTravailPere.label" />   <span><g:message code="dccrr.property.communeLieuTravailPere.help" /></span></label>
            <input type="text" id="communeLieuTravailPere" name="communeLieuTravailPere" value="${rqt.communeLieuTravailPere?.toString()}" 
                    class="  validate-string ${rqt.stepStates['subject'].invalidFields.contains('communeLieuTravailPere') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.communeLieuTravailPere.validationError" />"   />
            

    
    </fieldset>
  

