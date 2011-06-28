


  
    <label for="choiceNationality" class="required"><g:message code="mcerrr.property.choiceNationality.label" /> *  <span><g:message code="mcerrr.property.choiceNationality.help" /></span></label>
            <select id="choiceNationality" name="choiceNationality" class="required condition-isFrench-trigger  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('choiceNationality') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.choiceNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['FrenchNationality','EuropeanNationality']}">
                <option value="fr.cg95.cvq.business.request.election.NationalityChoiceType_${it}" ${it == rqt.choiceNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.choiceNationality" /></option>
              </g:each>
            </select>
            

  

  
    <label for="europeanNationality" class="required condition-isFrench-unfilled"><g:message code="mcerrr.property.europeanNationality.label" /> *  <span><g:message code="mcerrr.property.europeanNationality.help" /></span></label>
            <select id="europeanNationality" name="europeanNationality" class="required condition-isFrench-unfilled  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('europeanNationality') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.europeanNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['none','de','ad','at','be','bg','cy','dk','es','ee','fi','gr','hu','ie','it','lv','lt','lu','mt','nl','pl','pt','cz','ro','gb','si','sk','se']}">
                <option value="fr.cg95.cvq.business.request.election.EuropeanNationalityType_${it}" ${it == rqt.europeanNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.europeanNationality" /></option>
              </g:each>
            </select>
            

  

  
    <label for="electionChoice" class="required condition-isFrench-unfilled"><g:message code="mcerrr.property.electionChoice.label" /> *  <span><g:message code="mcerrr.property.electionChoice.help" /></span></label>
            <select id="electionChoice" name="electionChoice" class="required condition-isFrench-unfilled condition-isMunicipalElectoral-trigger  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('electionChoice') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.electionChoice.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['MunicipalElectoral','EuropeanElectoral']}">
                <option value="fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType_${it}" ${it == rqt.electionChoice?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.electionChoice" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="mcerrr.property.motive.label" /> *  <span><g:message code="mcerrr.property.motive.help" /></span></label>
            <ul class="required ${stepStates != null && stepStates['situation']?.invalidFields?.contains('motive') ? 'validation-failed' : ''}">
              <g:each in="${['FirstSubscription','MoveSubscription','MoveOtherSubscription']}">
              <li>
                <input type="radio" id="motive_${it}" class="required condition-isMotive-trigger  validate-one-required" value="fr.cg95.cvq.business.request.election.ElectoralSituationType_${it}" name="motive" ${it == rqt.motive.toString() ? 'checked="checked"': ''} title="<g:message code="mcerrr.property.motive.validationError" />" />
                <label for="motive_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.motive" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required condition-isMotive-filled">
    <legend><g:message code="mcerrr.property.oldAddressInformation.label" /></legend>
    
      <label for="oldCity" class=""><g:message code="mcerrr.property.oldCity.label" />   <span><g:message code="mcerrr.property.oldCity.help" /></span></label>
            <input type="text" id="oldCity" name="oldCity" value="${rqt.oldCity?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('oldCity') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.oldCity.validationError" />"   />
            

    
      <label for="oldDepartment" class=""><g:message code="mcerrr.property.oldDepartment.label" />   <span><g:message code="mcerrr.property.oldDepartment.help" /></span></label>
            <input type="text" id="oldDepartment" name="oldDepartment" value="${rqt.oldDepartment?.toString()}" 
                    class="  validate-departmentCode ${stepStates != null && stepStates['situation']?.invalidFields?.contains('oldDepartment') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.oldDepartment.validationError" />"  maxlength="2" />
            

    
      <label for="oldOverseas" class=""><g:message code="mcerrr.property.oldOverseas.label" />   <span><g:message code="mcerrr.property.oldOverseas.help" /></span></label>
            <input type="text" id="oldOverseas" name="oldOverseas" value="${rqt.oldOverseas?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('oldOverseas') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.oldOverseas.validationError" />"   />
            

    
    </fieldset>
  

  
    <label for="externalCountryAECT" class="required condition-isMunicipalElectoral-filled"><g:message code="mcerrr.property.externalCountryAECT.label" /> *  <span><g:message code="mcerrr.property.externalCountryAECT.help" /></span></label>
            <select id="externalCountryAECT" name="externalCountryAECT" class="required condition-isMunicipalElectoral-filled  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('externalCountryAECT') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.externalCountryAECT.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['none','de','ad','at','be','bg','cy','dk','es','ee','fi','gr','hu','ie','it','lv','lt','lu','mt','nl','pl','pt','cz','ro','gb','si','sk','se']}">
                <option value="fr.cg95.cvq.business.request.election.EuropeanNationalityType_${it}" ${it == rqt.externalCountryAECT?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.externalCountryAECT" /></option>
              </g:each>
            </select>
            

  

  
    <label for="externalDistrictAECT" class="required condition-isMunicipalElectoral-filled"><g:message code="mcerrr.property.externalDistrictAECT.label" /> *  <span><g:message code="mcerrr.property.externalDistrictAECT.help" /></span></label>
            <input type="text" id="externalDistrictAECT" name="externalDistrictAECT" value="${rqt.externalDistrictAECT?.toString()}" 
                    class="required condition-isMunicipalElectoral-filled  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('externalDistrictAECT') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.externalDistrictAECT.validationError" />"   />
            

  

  
    <label for="externalCityAECT" class="required condition-isMunicipalElectoral-filled"><g:message code="mcerrr.property.externalCityAECT.label" /> *  <span><g:message code="mcerrr.property.externalCityAECT.help" /></span></label>
            <input type="text" id="externalCityAECT" name="externalCityAECT" value="${rqt.externalCityAECT?.toString()}" 
                    class="required condition-isMunicipalElectoral-filled  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('externalCityAECT') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.externalCityAECT.validationError" />"   />
            

  

  
    <fieldset class="required condition-isFrench-filled">
    <legend><g:message code="mcerrr.property.additionInformationFrenchCerfa.label" /></legend>
    
      <label for="ambassyOrConsulateAFCT" class=""><g:message code="mcerrr.property.ambassyOrConsulateAFCT.label" />   <span><g:message code="mcerrr.property.ambassyOrConsulateAFCT.help" /></span></label>
            <input type="text" id="ambassyOrConsulateAFCT" name="ambassyOrConsulateAFCT" value="${rqt.ambassyOrConsulateAFCT?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('ambassyOrConsulateAFCT') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.ambassyOrConsulateAFCT.validationError" />"   />
            

    
      <label for="externalCountryAFCT" class=""><g:message code="mcerrr.property.externalCountryAFCT.label" />   <span><g:message code="mcerrr.property.externalCountryAFCT.help" /></span></label>
            <select id="externalCountryAFCT" name="externalCountryAFCT" class="  validate-select ${stepStates != null && stepStates['situation']?.invalidFields?.contains('externalCountryAFCT') ? 'validation-failed' : ''}" title="<g:message code="mcerrr.property.externalCountryAFCT.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.externalCountryAFCT?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcerrr.property.externalCountryAFCT" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

