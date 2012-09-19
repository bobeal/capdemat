


  
    
            <label for="subjectId" class="required">
              <g:message code="serrr.property.subject.label" /> *
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectFirstNamesFilling-trigger ${rqt.stepStates['inscription'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="nomNaissance" class="required"><g:message code="serrr.property.nomNaissance.label" /> *  <span><g:message code="serrr.property.nomNaissance.help" /></span></label>
            <input type="text" id="nomNaissance" name="nomNaissance" value="${rqt.nomNaissance?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['inscription'].invalidFields.contains('nomNaissance') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.nomNaissance.validationError" />"  maxlength="38" />
            

  

  
    <label for="prenom" class="required"><g:message code="serrr.property.prenom.label" /> *  <span><g:message code="serrr.property.prenom.help" /></span></label>
            <input type="text" id="prenom" name="prenom" value="${rqt.prenom?.toString()}" 
                    class="required autofill-subjectFirstNamesFilling-listener-FirstName validate-firstName ${rqt.stepStates['inscription'].invalidFields.contains('prenom') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.prenom.validationError" />"  maxlength="38" />
            

  

  
    <label for="deuxiemePrenom" class=""><g:message code="serrr.property.deuxiemePrenom.label" />   <span><g:message code="serrr.property.deuxiemePrenom.help" /></span></label>
            <input type="text" id="deuxiemePrenom" name="deuxiemePrenom" value="${rqt.deuxiemePrenom?.toString()}" 
                    class=" autofill-subjectFirstNamesFilling-listener-FirstName2 validate-firstName ${rqt.stepStates['inscription'].invalidFields.contains('deuxiemePrenom') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.deuxiemePrenom.validationError" />"  maxlength="38" />
            

  

  
    <label for="troisiemePrenom" class=""><g:message code="serrr.property.troisiemePrenom.label" />   <span><g:message code="serrr.property.troisiemePrenom.help" /></span></label>
            <input type="text" id="troisiemePrenom" name="troisiemePrenom" value="${rqt.troisiemePrenom?.toString()}" 
                    class=" autofill-subjectFirstNamesFilling-listener-FirstName3 validate-firstName ${rqt.stepStates['inscription'].invalidFields.contains('troisiemePrenom') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.troisiemePrenom.validationError" />"  maxlength="38" />
            

  

  
    <label class="required"><g:message code="serrr.property.sexe.label" /> *  <span><g:message code="serrr.property.sexe.help" /></span></label>
            <ul class="required ${rqt.stepStates['inscription'].invalidFields.contains('sexe') ? 'validation-failed' : ''}">
              <g:each in="${['FEMININ','MASCULIN']}">
              <li>
                <input type="radio" id="sexe_${it}" class="required condition-estFemme-trigger  validate-one-required" value="${it}" name="sexe" ${it == rqt.sexe.toString() ? 'checked="checked"': ''} title="<g:message code="serrr.property.sexe.validationError" />" />
                <label for="sexe_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.sexe" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="nomMarital" class="condition-estFemme-filled"><g:message code="serrr.property.nomMarital.label" />   <span><g:message code="serrr.property.nomMarital.help" /></span></label>
            <input type="text" id="nomMarital" name="nomMarital" value="${rqt.nomMarital?.toString()}" 
                    class="condition-estFemme-filled  validate-lastName ${rqt.stepStates['inscription'].invalidFields.contains('nomMarital') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.nomMarital.validationError" />"  maxlength="38" />
            

  

  
    <label class="required"><g:message code="serrr.property.dateNaissance.label" /> *  <span><g:message code="serrr.property.dateNaissance.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['inscription'].invalidFields.contains('dateNaissance') ? 'validation-failed' : ''}"
                id="dateNaissance_day"
                name="dateNaissance_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dateNaissance?.date == it
                      || (rqt.dateNaissance == null && params['dateNaissance_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['inscription'].invalidFields.contains('dateNaissance') ? 'validation-failed' : ''}"
                id="dateNaissance_month"
                name="dateNaissance_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dateNaissance?.month == (it - 1)
                      || (rqt.dateNaissance == null && params['dateNaissance_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['inscription'].invalidFields.contains('dateNaissance') ? 'validation-failed' : ''}"
                id="dateNaissance_year"
                name="dateNaissance_year"
                value="${rqt.dateNaissance ? rqt.dateNaissance.year + 1900 : params['dateNaissance_year']}"
                title="<g:message code="serrr.property.dateNaissance.validationError" />" />
            </div>
            

  

  
    <fieldset class="required">
    <legend><g:message code="serrr.property.lieuNaissance.label" /></legend>
    
      <label for="villeNaissanceCodePostal" class="required"><g:message code="serrr.property.villeNaissanceCodePostal.label" /> *  <span><g:message code="serrr.property.villeNaissanceCodePostal.help" /></span></label>
            <input type="text" id="villeNaissanceCodePostal" name="villeNaissanceCodePostal" value="${rqt.villeNaissanceCodePostal?.toString()}" 
                    class="required  validate-city ${rqt.stepStates['inscription'].invalidFields.contains('villeNaissanceCodePostal') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.villeNaissanceCodePostal.validationError" />"  maxlength="32" />
            

    
      <label for="lieuNaissanceDepartement" class=""><g:message code="serrr.property.lieuNaissanceDepartement.label" />   <span><g:message code="serrr.property.lieuNaissanceDepartement.help" /></span></label>
            <select id="lieuNaissanceDepartement" name="lieuNaissanceDepartement" class="  validate-select ${rqt.stepStates['inscription'].invalidFields.contains('lieuNaissanceDepartement') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.lieuNaissanceDepartement.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NONE','D_E_P01','D_E_P02','D_E_P03','D_E_P04','D_E_P05','D_E_P06','D_E_P07','D_E_P08','D_E_P09','D_E_P10','D_E_P11','D_E_P12','D_E_P13','D_E_P14','D_E_P15','D_E_P16','D_E_P17','D_E_P18','D_E_P19','D_E_P2_A','D_E_P2_B','D_E_P21','D_E_P22','D_E_P23','D_E_P24','D_E_P25','D_E_P26','D_E_P27','D_E_P28','D_E_P29','D_E_P30','D_E_P31','D_E_P32','D_E_P33','D_E_P34','D_E_P35','D_E_P36','D_E_P37','D_E_P38','D_E_P39','D_E_P40','D_E_P41','D_E_P42','D_E_P43','D_E_P44','D_E_P45','D_E_P46','D_E_P47','D_E_P48','D_E_P49','D_E_P50','D_E_P51','D_E_P52','D_E_P53','D_E_P54','D_E_P55','D_E_P56','D_E_P57','D_E_P58','D_E_P59','D_E_P60','D_E_P61','D_E_P62','D_E_P63','D_E_P64','D_E_P65','D_E_P66','D_E_P67','D_E_P68','D_E_P69','D_E_P70','D_E_P71','D_E_P72','D_E_P73','D_E_P74','D_E_P75','D_E_P76','D_E_P77','D_E_P78','D_E_P79','D_E_P80','D_E_P81','D_E_P82','D_E_P83','D_E_P84','D_E_P85','D_E_P86','D_E_P87','D_E_P88','D_E_P89','D_E_P90','D_E_P91','D_E_P92','D_E_P93','D_E_P94','D_E_P95','D_E_P971','D_E_P972','D_E_P973','D_E_P974']}">
                <option value="${it}" ${it == rqt.lieuNaissanceDepartement?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.lieuNaissanceDepartement" /></option>
              </g:each>
            </select>
            

    
      <label for="lieuNaissancePays" class=""><g:message code="serrr.property.lieuNaissancePays.label" />   <span><g:message code="serrr.property.lieuNaissancePays.help" /></span></label>
            <select id="lieuNaissancePays" name="lieuNaissancePays" class="  validate-select ${rqt.stepStates['inscription'].invalidFields.contains('lieuNaissancePays') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.lieuNaissancePays.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['UNKNOWN','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BJ','BS','BH','BD','BB','PW','BE','BZ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','CI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GP','GU','GT','GN','GQ','GW','GY','GF','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.lieuNaissancePays?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.lieuNaissancePays" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="serrr.property.nationalite.label" /> *  <span><g:message code="serrr.property.nationalite.help" /></span></label>
            <ul class="required ${rqt.stepStates['inscription'].invalidFields.contains('nationalite') ? 'validation-failed' : ''}">
              <g:each in="${['FRANCAISE','RESSORTISSANT_U_E']}">
              <li>
                <input type="radio" id="nationalite_${it}" class="required condition-estUnionEuropenne-trigger  validate-one-required" value="${it}" name="nationalite" ${it == rqt.nationalite.toString() ? 'checked="checked"': ''} title="<g:message code="serrr.property.nationalite.validationError" />" />
                <label for="nationalite_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.nationalite" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required condition-estUnionEuropenne-filled">
    <legend><g:message code="serrr.property.fieldsetEstUnionEuropeenne.label" /></legend>
    
      <label for="precisionNationalite" class="required condition-estUnionEuropenne-filled"><g:message code="serrr.property.precisionNationalite.label" /> *  <span><g:message code="serrr.property.precisionNationalite.help" /></span></label>
            <select id="precisionNationalite" name="precisionNationalite" class="required condition-estUnionEuropenne-filled  validate-not-first ${rqt.stepStates['inscription'].invalidFields.contains('precisionNationalite') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.precisionNationalite.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['DE','AD','AT','BE','GB','BG','CY','DK','ES','EE','FI','GR','HU','IE','IT','LV','LT','LU','MT','NL','PL','PT','RO','SI','SK','SE','CZ']}">
                <option value="${it}" ${it == rqt.precisionNationalite?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.precisionNationalite" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-estUnionEuropenne-filled"><g:message code="serrr.property.typeElection.label" /> *  <span><g:message code="serrr.property.typeElection.help" /></span></label>
            <ul class="required condition-estUnionEuropenne-filled ${rqt.stepStates['inscription'].invalidFields.contains('typeElection') ? 'validation-failed' : ''}">
              <g:each in="${['ELECTION_MUNICIPALE','ELECTION_EUROPEENNE']}">
              <li>
                <input type="radio" id="typeElection_${it}" class="required condition-estUnionEuropenne-filled condition-estElectionEuropenne-trigger  validate-one-required" value="${it}" name="typeElection" ${it == rqt.typeElection.toString() ? 'checked="checked"': ''} title="<g:message code="serrr.property.typeElection.validationError" />" />
                <label for="typeElection_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.typeElection" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="paysPrecedent" class="condition-estElectionEuropenne-filled"><g:message code="serrr.property.paysPrecedent.label" />   <span><g:message code="serrr.property.paysPrecedent.help" /></span></label>
            <select id="paysPrecedent" name="paysPrecedent" class="condition-estElectionEuropenne-filled  validate-select ${rqt.stepStates['inscription'].invalidFields.contains('paysPrecedent') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.paysPrecedent.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['UNKNOWN','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BJ','BS','BH','BD','BB','PW','BE','BZ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','CI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GP','GU','GT','GN','GQ','GW','GY','GF','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.paysPrecedent?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.paysPrecedent" /></option>
              </g:each>
            </select>
            

    
      <label for="subdivisionAdministrativePrecedente" class="condition-estElectionEuropenne-filled"><g:message code="serrr.property.subdivisionAdministrativePrecedente.label" />   <span><g:message code="serrr.property.subdivisionAdministrativePrecedente.help" /></span></label>
            <input type="text" id="subdivisionAdministrativePrecedente" name="subdivisionAdministrativePrecedente" value="${rqt.subdivisionAdministrativePrecedente?.toString()}" 
                    class="condition-estElectionEuropenne-filled  validate-string ${rqt.stepStates['inscription'].invalidFields.contains('subdivisionAdministrativePrecedente') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.subdivisionAdministrativePrecedente.validationError" />"   />
            

    
      <label for="communeOuLocalitePrecedente" class="condition-estElectionEuropenne-filled"><g:message code="serrr.property.communeOuLocalitePrecedente.label" />   <span><g:message code="serrr.property.communeOuLocalitePrecedente.help" /></span></label>
            <input type="text" id="communeOuLocalitePrecedente" name="communeOuLocalitePrecedente" value="${rqt.communeOuLocalitePrecedente?.toString()}" 
                    class="condition-estElectionEuropenne-filled  validate-city ${rqt.stepStates['inscription'].invalidFields.contains('communeOuLocalitePrecedente') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.communeOuLocalitePrecedente.validationError" />"  maxlength="32" />
            

    
    </fieldset>
  

