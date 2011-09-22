


  
    
            <label for="subjectId" class="required">
              <g:message code="serrr.property.subject.label" /> *
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
            <select id="subjectId" name="subjectId" <g:if test="${isEdition || rqt.stepStates[currentStep].state == 'complete'}">disabled="disabled"</g:if> class="required validate-not-first  ${rqt.stepStates['inscription'].invalidFields.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="nomJeuneFille" class=""><g:message code="serrr.property.nomJeuneFille.label" />   <span><g:message code="serrr.property.nomJeuneFille.help" /></span></label>
            <input type="text" id="nomJeuneFille" name="nomJeuneFille" value="${rqt.nomJeuneFille?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['inscription'].invalidFields.contains('nomJeuneFille') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.nomJeuneFille.validationError" />"  maxlength="38" />
            

  

  
    <label class="required"><g:message code="serrr.property.sexe.label" /> *  <span><g:message code="serrr.property.sexe.help" /></span></label>
            <ul class="required ${rqt.stepStates['inscription'].invalidFields.contains('sexe') ? 'validation-failed' : ''}">
              <g:each in="${['FEMININ','MASCULIN']}">
              <li>
                <input type="radio" id="sexe_${it}" class="required  validate-one-required" value="${it}" name="sexe" ${it == rqt.sexe.toString() ? 'checked="checked"': ''} title="<g:message code="serrr.property.sexe.validationError" />" />
                <label for="sexe_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.sexe" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
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
              <g:each in="${['NONE','D_E_P_01','D_E_P_02','D_E_P_03','D_E_P_04','D_E_P_05','D_E_P_06','D_E_P_07','D_E_P_08','D_E_P_09','D_E_P_10','D_E_P_11','D_E_P_12','D_E_P_13','D_E_P_14','D_E_P_15','D_E_P_16','D_E_P_17','D_E_P_18','D_E_P_19','D_E_P_2_A','D_E_P_2_B','D_E_P_21','D_E_P_22','D_E_P_23','D_E_P_24','D_E_P_25','D_E_P_26','D_E_P_27','D_E_P_28','D_E_P_29','D_E_P_30','D_E_P_31','D_E_P_32','D_E_P_33','D_E_P_34','D_E_P_35','D_E_P_36','D_E_P_37','D_E_P_38','D_E_P_39','D_E_P_40','D_E_P_41','D_E_P_42','D_E_P_43','D_E_P_44','D_E_P_45','D_E_P_46','D_E_P_47','D_E_P_48','D_E_P_49','D_E_P_50','D_E_P_51','D_E_P_52','D_E_P_53','D_E_P_54','D_E_P_55','D_E_P_56','D_E_P_57','D_E_P_58','D_E_P_59','D_E_P_60','D_E_P_61','D_E_P_62','D_E_P_63','D_E_P_64','D_E_P_65','D_E_P_66','D_E_P_67','D_E_P_68','D_E_P_69','D_E_P_70','D_E_P_71','D_E_P_72','D_E_P_73','D_E_P_74','D_E_P_75','D_E_P_76','D_E_P_77','D_E_P_78','D_E_P_79','D_E_P_80','D_E_P_81','D_E_P_82','D_E_P_83','D_E_P_84','D_E_P_85','D_E_P_86','D_E_P_87','D_E_P_88','D_E_P_89','D_E_P_90','D_E_P_91','D_E_P_92','D_E_P_93','D_E_P_94','D_E_P_95','D_E_P_971','D_E_P_972','D_E_P_973','D_E_P_974']}">
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
            

  

  
    <fieldset class="required condition-estElectionEuropenne-filled">
    <legend><g:message code="serrr.property.lieuDerniereInscription.label" /></legend>
    
      <label for="paysPrecedent" class=""><g:message code="serrr.property.paysPrecedent.label" />   <span><g:message code="serrr.property.paysPrecedent.help" /></span></label>
            <select id="paysPrecedent" name="paysPrecedent" class="  validate-select ${rqt.stepStates['inscription'].invalidFields.contains('paysPrecedent') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.paysPrecedent.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['UNKNOWN','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BJ','BS','BH','BD','BB','PW','BE','BZ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','CI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GP','GU','GT','GN','GQ','GW','GY','GF','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.paysPrecedent?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.paysPrecedent" /></option>
              </g:each>
            </select>
            

    
      <label for="subdivisionAdministrativePrecedente" class=""><g:message code="serrr.property.subdivisionAdministrativePrecedente.label" />   <span><g:message code="serrr.property.subdivisionAdministrativePrecedente.help" /></span></label>
            <input type="text" id="subdivisionAdministrativePrecedente" name="subdivisionAdministrativePrecedente" value="${rqt.subdivisionAdministrativePrecedente?.toString()}" 
                    class="  validate-string ${rqt.stepStates['inscription'].invalidFields.contains('subdivisionAdministrativePrecedente') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.subdivisionAdministrativePrecedente.validationError" />"   />
            

    
      <label for="communeOuLocalitePrecedente" class=""><g:message code="serrr.property.communeOuLocalitePrecedente.label" />   <span><g:message code="serrr.property.communeOuLocalitePrecedente.help" /></span></label>
            <input type="text" id="communeOuLocalitePrecedente" name="communeOuLocalitePrecedente" value="${rqt.communeOuLocalitePrecedente?.toString()}" 
                    class="  validate-city ${rqt.stepStates['inscription'].invalidFields.contains('communeOuLocalitePrecedente') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.communeOuLocalitePrecedente.validationError" />"  maxlength="32" />
            

    
    </fieldset>
  

