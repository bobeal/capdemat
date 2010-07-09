


  
    <fieldset class="">
    <legend><g:message code="sgr.property.currentSchool.label" /></legend>
    
      <label class="required"><g:message code="sgr.property.currentSchoolName.label" /> *  <span><g:message code="sgr.property.currentSchoolName.help" /></span></label>
            <g:set var="currentSchoolNameIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'currentSchoolName', 'i18nPrefixCode':'sgr.property.currentSchoolName', 'htmlClass':'required condition-isCurrentSchoolNameOther-trigger  ', 
                              'lrEntries': lrTypes.currentSchoolName.entries, 'depth':0]" />
            

    
      <label for="currentSchoolNamePrecision" class="required condition-isCurrentSchoolNameOther-filled"><g:message code="sgr.property.currentSchoolNamePrecision.label" /> *  <span><g:message code="sgr.property.currentSchoolNamePrecision.help" /></span></label>
            <input type="text" id="currentSchoolNamePrecision" name="currentSchoolNamePrecision" value="${rqt.currentSchoolNamePrecision?.toString()}" 
                    class="required condition-isCurrentSchoolNameOther-filled  validate-string ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('currentSchoolNamePrecision') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.currentSchoolNamePrecision.validationError" />"   />
            

    
      <label for="currentSchoolPostalCode" class="required"><g:message code="sgr.property.currentSchoolPostalCode.label" /> *  <span><g:message code="sgr.property.currentSchoolPostalCode.help" /></span></label>
            <input type="text" id="currentSchoolPostalCode" name="currentSchoolPostalCode" value="${rqt.currentSchoolPostalCode?.toString()}" 
                    class="required  validate-postalCode ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('currentSchoolPostalCode') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.currentSchoolPostalCode.validationError" />"  maxlength="5" />
            

    
      <label for="currentSchoolCity" class="required"><g:message code="sgr.property.currentSchoolCity.label" /> *  <span><g:message code="sgr.property.currentSchoolCity.help" /></span></label>
            <input type="text" id="currentSchoolCity" name="currentSchoolCity" value="${rqt.currentSchoolCity?.toString()}" 
                    class="required  validate-city ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('currentSchoolCity') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.currentSchoolCity.validationError" />"  maxlength="32" />
            

    
      <label for="currentSchoolCountry" class="required"><g:message code="sgr.property.currentSchoolCountry.label" /> *  <span><g:message code="sgr.property.currentSchoolCountry.help" /></span></label>
            <select id="currentSchoolCountry" name="currentSchoolCountry" class="required  validate-not-first ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('currentSchoolCountry') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.currentSchoolCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.currentSchoolCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.currentSchoolCountry" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="sgr.property.aLevelsInformations.label" /></legend>
    
      <label for="alevelsDate" class="required"><g:message code="sgr.property.alevelsDate.label" /> *  <span><g:message code="sgr.property.alevelsDate.help" /></span></label>
            <input type="text" id="alevelsDate" name="alevelsDate" value="${rqt.alevelsDate?.toString()}" 
                    class="required  validate-regex ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('alevelsDate') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.alevelsDate.validationError" />" regex="^\d{2,4}$" maxlength="4" />
            

    
      <label for="alevels" class="required"><g:message code="sgr.property.alevels.label" /> *  <span><g:message code="sgr.property.alevels.help" /></span></label>
            <select id="alevels" name="alevels" class="required  validate-not-first ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('alevels') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.alevels.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['es','l','s','stg','sti','stl','st2s','stav','tmd','h','p']}">
                <option value="fr.cg95.cvq.business.request.school.ALevelsType_${it}" ${it == rqt.alevels?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.alevels" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="">
    <legend><g:message code="sgr.property.currentStudiesInformations.label" /></legend>
    
      <label for="currentStudiesDiploma" class="required"><g:message code="sgr.property.currentStudiesDiploma.label" /> *  <span><g:message code="sgr.property.currentStudiesDiploma.help" /></span></label>
            <select id="currentStudiesDiploma" name="currentStudiesDiploma" class="required condition-isInOtherStudies-trigger  validate-not-first ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('currentStudiesDiploma') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.currentStudiesDiploma.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['licence','licencePro','master','bts','dut','otherStudies']}">
                <option value="fr.cg95.cvq.business.request.school.CurrentStudiesType_${it}" ${it == rqt.currentStudiesDiploma?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.currentStudiesDiploma" /></option>
              </g:each>
            </select>
            

    
      <label for="otherStudiesLabel" class="required condition-isInOtherStudies-filled"><g:message code="sgr.property.otherStudiesLabel.label" /> *  <span><g:message code="sgr.property.otherStudiesLabel.help" /></span></label>
            <input type="text" id="otherStudiesLabel" name="otherStudiesLabel" value="${rqt.otherStudiesLabel?.toString()}" 
                    class="required condition-isInOtherStudies-filled  validate-string ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('otherStudiesLabel') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.otherStudiesLabel.validationError" />"   />
            

    
      <label for="currentStudiesLevel" class="required"><g:message code="sgr.property.currentStudiesLevel.label" /> *  <span><g:message code="sgr.property.currentStudiesLevel.help" /></span></label>
            <select id="currentStudiesLevel" name="currentStudiesLevel" class="required  validate-not-first ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('currentStudiesLevel') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.currentStudiesLevel.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['firstYear','secondYear','thirdYear']}">
                <option value="fr.cg95.cvq.business.request.school.CurrentStudiesLevelType_${it}" ${it == rqt.currentStudiesLevel?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.currentStudiesLevel" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="sgr.property.sandwichCourses.label" /> *  <span><g:message code="sgr.property.sandwichCourses.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('sandwichCourses') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="sandwichCourses_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="sandwichCourses" ${it == rqt.sandwichCourses ? 'checked="checked"': ''} />
                <label for="sandwichCourses_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sgr.property.abroadInternship.label" /> *  <span><g:message code="sgr.property.abroadInternship.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternship') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="abroadInternship_${it ? 'yes' : 'no'}" class="required condition-makesAbroadInternship-trigger  validate-one-required boolean" title="" value="${it}" name="abroadInternship" ${it == rqt.abroadInternship ? 'checked="checked"': ''} />
                <label for="abroadInternship_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipStartDate.label" /> *  <span><g:message code="sgr.property.abroadInternshipStartDate.help" /></span></label>
            <div class="date required condition-makesAbroadInternship-filled  validate-date required condition-makesAbroadInternship-filled ">
              <select class="day ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipStartDate') ? 'validation-failed' : ''}"
                id="abroadInternshipStartDate_day"
                name="abroadInternshipStartDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.abroadInternshipStartDate?.date == it
                      || (rqt.abroadInternshipStartDate == null && params['abroadInternshipStartDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipStartDate') ? 'validation-failed' : ''}"
                id="abroadInternshipStartDate_month"
                name="abroadInternshipStartDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.abroadInternshipStartDate?.month == (it - 1)
                      || (rqt.abroadInternshipStartDate == null && params['abroadInternshipStartDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipStartDate') ? 'validation-failed' : ''}"
                id="abroadInternshipStartDate_year"
                name="abroadInternshipStartDate_year"
                value="${rqt.abroadInternshipStartDate ? rqt.abroadInternshipStartDate.year + 1900 : params['abroadInternshipStartDate_year']}"
                title="<g:message code="sgr.property.abroadInternshipStartDate.validationError" />" />
            </div>
            

    
      <label class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipEndDate.label" /> *  <span><g:message code="sgr.property.abroadInternshipEndDate.help" /></span></label>
            <div class="date required condition-makesAbroadInternship-filled  validate-date required condition-makesAbroadInternship-filled ">
              <select class="day ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipEndDate') ? 'validation-failed' : ''}"
                id="abroadInternshipEndDate_day"
                name="abroadInternshipEndDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.abroadInternshipEndDate?.date == it
                      || (rqt.abroadInternshipEndDate == null && params['abroadInternshipEndDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipEndDate') ? 'validation-failed' : ''}"
                id="abroadInternshipEndDate_month"
                name="abroadInternshipEndDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.abroadInternshipEndDate?.month == (it - 1)
                      || (rqt.abroadInternshipEndDate == null && params['abroadInternshipEndDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipEndDate') ? 'validation-failed' : ''}"
                id="abroadInternshipEndDate_year"
                name="abroadInternshipEndDate_year"
                value="${rqt.abroadInternshipEndDate ? rqt.abroadInternshipEndDate.year + 1900 : params['abroadInternshipEndDate_year']}"
                title="<g:message code="sgr.property.abroadInternshipEndDate.validationError" />" />
            </div>
            

    
      <label for="abroadInternshipSchoolName" class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolName.label" /> *  <span><g:message code="sgr.property.abroadInternshipSchoolName.help" /></span></label>
            <input type="text" id="abroadInternshipSchoolName" name="abroadInternshipSchoolName" value="${rqt.abroadInternshipSchoolName?.toString()}" 
                    class="required condition-makesAbroadInternship-filled  validate-string ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipSchoolName') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.abroadInternshipSchoolName.validationError" />"   />
            

    
      <label for="abroadInternshipSchoolCountry" class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolCountry.label" /> *  <span><g:message code="sgr.property.abroadInternshipSchoolCountry.help" /></span></label>
            <select id="abroadInternshipSchoolCountry" name="abroadInternshipSchoolCountry" class="required condition-makesAbroadInternship-filled  validate-not-first ${stepStates != null && stepStates['currentStudies']?.invalidFields.contains('abroadInternshipSchoolCountry') ? 'validation-failed' : ''}" title="<g:message code="sgr.property.abroadInternshipSchoolCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.abroadInternshipSchoolCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sgr.property.abroadInternshipSchoolCountry" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

