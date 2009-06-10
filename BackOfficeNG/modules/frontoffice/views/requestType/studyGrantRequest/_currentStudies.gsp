


  
    <fieldset class="required">
    <legend><g:message code="sgr.property.aLevelsInformations.label" /></legend>
    
      <label class="required"><g:message code="sgr.property.alevelsDate.label" /> *  <span><g:message code="sgr.property.alevelsDate.help" /></span></label>
            <input type="text" name="alevelsDate" value="${rqt.alevelsDate}" 
                    class="required  validate-regex" title="<g:message code="sgr.property.alevelsDate.validationError" />" regex="^\d{2,4}$" maxLength="4"/>
            

    
      <label class="required"><g:message code="sgr.property.alevels.label" /> *  <span><g:message code="sgr.property.alevels.help" /></span></label>
            <select name="alevels" class="required  validate-not-first" title="<g:message code="sgr.property.alevels.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['es','l','s','stg','sti','stl','st2s','stav','tmd','h','p']}">
                <option value="fr.cg95.cvq.business.request.school.ALevelsType_${it}" ${it == rqt.alevels?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.alevels" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <label class="required"><g:message code="sgr.property.currentSchoolName.label" /> *  <span><g:message code="sgr.property.currentSchoolName.help" /></span></label>
            <g:set var="currentSchoolNameIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'currentSchoolName', 'i18nPrefixCode':'sgr.property.currentSchoolName', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.currentSchoolName.entries, 'depth':0]" />
            

  

  
    <fieldset class="required">
    <legend><g:message code="sgr.property.currentSchool.label" /></legend>
    
      <label class="required"><g:message code="sgr.property.currentSchoolPostalCode.label" /> *  <span><g:message code="sgr.property.currentSchoolPostalCode.help" /></span></label>
            <input type="text" name="currentSchoolPostalCode" value="${rqt.currentSchoolPostalCode}" 
                    class="required  validate-postalCode" title="<g:message code="sgr.property.currentSchoolPostalCode.validationError" />"  maxLength="5"/>
            

    
      <label class="required"><g:message code="sgr.property.currentSchoolCity.label" /> *  <span><g:message code="sgr.property.currentSchoolCity.help" /></span></label>
            <input type="text" name="currentSchoolCity" value="${rqt.currentSchoolCity}" 
                    class="required  validate-city" title="<g:message code="sgr.property.currentSchoolCity.validationError" />"  maxLength="32"/>
            

    
      <label class="required"><g:message code="sgr.property.currentSchoolCountry.label" /> *  <span><g:message code="sgr.property.currentSchoolCountry.help" /></span></label>
            <select name="currentSchoolCountry" class="required  validate-not-first" title="<g:message code="sgr.property.currentSchoolCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.currentSchoolCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.currentSchoolCountry" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="">
    <legend><g:message code="sgr.property.currentStudiesInformations.label" /></legend>
    
      <label class="required"><g:message code="sgr.property.currentStudies.label" /> *  <span><g:message code="sgr.property.currentStudies.help" /></span></label>
            <select name="currentStudies" class="required condition-isInOtherStudies-trigger  validate-not-first" title="<g:message code="sgr.property.currentStudies.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['licence','licencePro','master','bts','dut','otherStudies']}">
                <option value="fr.cg95.cvq.business.request.school.CurrentStudiesType_${it}" ${it == rqt.currentStudies?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.currentStudies" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-isInOtherStudies-filled"><g:message code="sgr.property.otherStudiesLabel.label" /> *  <span><g:message code="sgr.property.otherStudiesLabel.help" /></span></label>
            <input type="text" name="otherStudiesLabel" value="${rqt.otherStudiesLabel}" 
                    class="required condition-isInOtherStudies-filled  validate-string" title="<g:message code="sgr.property.otherStudiesLabel.validationError" />"  />
            

    
      <label class="required"><g:message code="sgr.property.currentStudiesLevel.label" /> *  <span><g:message code="sgr.property.currentStudiesLevel.help" /></span></label>
            <select name="currentStudiesLevel" class="required  validate-not-first" title="<g:message code="sgr.property.currentStudiesLevel.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['firstYear','secondYear','thirdYear']}">
                <option value="fr.cg95.cvq.business.request.school.CurrentStudiesLevelType_${it}" ${it == rqt.currentStudiesLevel?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.currentStudiesLevel" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="sgr.property.sandwichCourses.label" /> *  <span><g:message code="sgr.property.sandwichCourses.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="sandwichCourses" ${it == rqt.sandwichCourses ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="sgr.property.abroadInternship.label" /> *  <span><g:message code="sgr.property.abroadInternship.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-makesAbroadInternship-trigger  validate-boolean" title="" value="${it}" name="abroadInternship" ${it == rqt.abroadInternship ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipStartDate.label" /> *  <span><g:message code="sgr.property.abroadInternshipStartDate.help" /></span></label>
            <input type="text" name="abroadInternshipStartDate" value="${formatDate(formatName:'format.date',date:rqt.abroadInternshipStartDate)}" 
                   class="required condition-makesAbroadInternship-filled  validate-date" title="<g:message code="sgr.property.abroadInternshipStartDate.validationError" />" />
            

    
      <label class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipEndDate.label" /> *  <span><g:message code="sgr.property.abroadInternshipEndDate.help" /></span></label>
            <input type="text" name="abroadInternshipEndDate" value="${formatDate(formatName:'format.date',date:rqt.abroadInternshipEndDate)}" 
                   class="required condition-makesAbroadInternship-filled  validate-date" title="<g:message code="sgr.property.abroadInternshipEndDate.validationError" />" />
            

    
      <label class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolName.label" /> *  <span><g:message code="sgr.property.abroadInternshipSchoolName.help" /></span></label>
            <input type="text" name="abroadInternshipSchoolName" value="${rqt.abroadInternshipSchoolName}" 
                    class="required condition-makesAbroadInternship-filled  validate-string" title="<g:message code="sgr.property.abroadInternshipSchoolName.validationError" />"  />
            

    
      <label class="required condition-makesAbroadInternship-filled"><g:message code="sgr.property.abroadInternshipSchoolCountry.label" /> *  <span><g:message code="sgr.property.abroadInternshipSchoolCountry.help" /></span></label>
            <select name="abroadInternshipSchoolCountry" class="required condition-makesAbroadInternship-filled  validate-not-first" title="<g:message code="sgr.property.abroadInternshipSchoolCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.abroadInternshipSchoolCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.abroadInternshipSchoolCountry" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

