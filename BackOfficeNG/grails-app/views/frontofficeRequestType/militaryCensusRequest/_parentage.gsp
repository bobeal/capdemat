


  
    <fieldset class="required">
    <legend><g:message code="mcr.property.fatherInformation.label" /></legend>
    
      <label for="fatherLastName" class=""><g:message code="mcr.property.fatherLastName.label" />   <span><g:message code="mcr.property.fatherLastName.help" /></span></label>
            <input type="text" id="fatherLastName" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['parentage'].invalidFields.contains('fatherLastName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="fatherFirstName" class=""><g:message code="mcr.property.fatherFirstName.label" />   <span><g:message code="mcr.property.fatherFirstName.help" /></span></label>
            <input type="text" id="fatherFirstName" name="fatherFirstName" value="${rqt.fatherFirstName?.toString()}" 
                    class="  validate-firstName ${rqt.stepStates['parentage'].invalidFields.contains('fatherFirstName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherFirstName.validationError" />"  maxlength="38" />
            

    
      <label class=""><g:message code="mcr.property.fatherBirthDate.label" />   <span><g:message code="mcr.property.fatherBirthDate.help" /></span></label>
            <div class="date   validate-date  ">
              <select class="day ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDate') ? 'validation-failed' : ''}"
                id="fatherBirthDate_day"
                name="fatherBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.fatherBirthDate?.date == it
                      || (rqt.fatherBirthDate == null && params['fatherBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDate') ? 'validation-failed' : ''}"
                id="fatherBirthDate_month"
                name="fatherBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.fatherBirthDate?.month == (it - 1)
                      || (rqt.fatherBirthDate == null && params['fatherBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDate') ? 'validation-failed' : ''}"
                id="fatherBirthDate_year"
                name="fatherBirthDate_year"
                value="${rqt.fatherBirthDate ? rqt.fatherBirthDate.year + 1900 : params['fatherBirthDate_year']}"
                title="<g:message code="mcr.property.fatherBirthDate.validationError" />" />
            </div>
            

    
      <label for="fatherBirthCity" class=""><g:message code="mcr.property.fatherBirthCity.label" />   <span><g:message code="mcr.property.fatherBirthCity.help" /></span></label>
            <input type="text" id="fatherBirthCity" name="fatherBirthCity" value="${rqt.fatherBirthCity?.toString()}" 
                    class="  validate-string ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthCity') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherBirthCity.validationError" />"   />
            

    
      <label for="fatherBirthDepartment" class=""><g:message code="mcr.property.fatherBirthDepartment.label" />   <span><g:message code="mcr.property.fatherBirthDepartment.help" /></span></label>
            <select id="fatherBirthDepartment" name="fatherBirthDepartment" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDepartment') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherBirthDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','DEP_01','DEP_02','DEP_03','DEP_04','DEP_05','DEP_06','DEP_07','DEP_08','DEP_09','DEP_10','DEP_11','DEP_12','DEP_13','DEP_14','DEP_15','DEP_16','DEP_17','DEP_18','DEP_19','DEP_2A','DEP_2B','DEP_21','DEP_22','DEP_23','DEP_24','DEP_25','DEP_26','DEP_27','DEP_28','DEP_29','DEP_30','DEP_31','DEP_32','DEP_33','DEP_34','DEP_35','DEP_36','DEP_37','DEP_38','DEP_39','DEP_40','DEP_41','DEP_42','DEP_43','DEP_44','DEP_45','DEP_46','DEP_47','DEP_48','DEP_49','DEP_50','DEP_51','DEP_52','DEP_53','DEP_54','DEP_55','DEP_56','DEP_57','DEP_58','DEP_59','DEP_60','DEP_61','DEP_62','DEP_63','DEP_64','DEP_65','DEP_66','DEP_67','DEP_68','DEP_69','DEP_70','DEP_71','DEP_72','DEP_73','DEP_74','DEP_75','DEP_76','DEP_77','DEP_78','DEP_79','DEP_80','DEP_81','DEP_82','DEP_83','DEP_84','DEP_85','DEP_86','DEP_87','DEP_88','DEP_89','DEP_90','DEP_91','DEP_92','DEP_93','DEP_94','DEP_95','DEP_971','DEP_972','DEP_973','DEP_974']}">
                <option value="fr.cg95.cvq.business.users.InseeDepartementCodeType_${it}" ${it == rqt.fatherBirthDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.fatherBirthDepartment" /></option>
              </g:each>
            </select>
            

    
      <label for="fatherBirthCountry" class=""><g:message code="mcr.property.fatherBirthCountry.label" />   <span><g:message code="mcr.property.fatherBirthCountry.help" /></span></label>
            <select id="fatherBirthCountry" name="fatherBirthCountry" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.fatherBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.fatherBirthCountry" /></option>
              </g:each>
            </select>
            

    
      <label for="fatherNationality" class=""><g:message code="mcr.property.fatherNationality.label" />   <span><g:message code="mcr.property.fatherNationality.help" /></span></label>
            <select id="fatherNationality" name="fatherNationality" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('fatherNationality') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bs','bh','bd','bb','be','bz','bj','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gu','gt','gn','gq','gw','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','ci','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.FullNationalityType_${it}" ${it == rqt.fatherNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.fatherNationality" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="mcr.property.motherInformation.label" /></legend>
    
      <label for="motherLastName" class="required"><g:message code="mcr.property.motherLastName.label" /> *  <span><g:message code="mcr.property.motherLastName.help" /></span></label>
            <input type="text" id="motherLastName" name="motherLastName" value="${rqt.motherLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['parentage'].invalidFields.contains('motherLastName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="motherFirstName" class="required"><g:message code="mcr.property.motherFirstName.label" /> *  <span><g:message code="mcr.property.motherFirstName.help" /></span></label>
            <input type="text" id="motherFirstName" name="motherFirstName" value="${rqt.motherFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['parentage'].invalidFields.contains('motherFirstName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherFirstName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="mcr.property.motherBirthDate.label" /> *  <span><g:message code="mcr.property.motherBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDate') ? 'validation-failed' : ''}"
                id="motherBirthDate_day"
                name="motherBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.motherBirthDate?.date == it
                      || (rqt.motherBirthDate == null && params['motherBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDate') ? 'validation-failed' : ''}"
                id="motherBirthDate_month"
                name="motherBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.motherBirthDate?.month == (it - 1)
                      || (rqt.motherBirthDate == null && params['motherBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDate') ? 'validation-failed' : ''}"
                id="motherBirthDate_year"
                name="motherBirthDate_year"
                value="${rqt.motherBirthDate ? rqt.motherBirthDate.year + 1900 : params['motherBirthDate_year']}"
                title="<g:message code="mcr.property.motherBirthDate.validationError" />" />
            </div>
            

    
      <label for="motherBirthCity" class="required"><g:message code="mcr.property.motherBirthCity.label" /> *  <span><g:message code="mcr.property.motherBirthCity.help" /></span></label>
            <input type="text" id="motherBirthCity" name="motherBirthCity" value="${rqt.motherBirthCity?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthCity') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherBirthCity.validationError" />"   />
            

    
      <label for="motherBirthDepartment" class=""><g:message code="mcr.property.motherBirthDepartment.label" />   <span><g:message code="mcr.property.motherBirthDepartment.help" /></span></label>
            <select id="motherBirthDepartment" name="motherBirthDepartment" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDepartment') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherBirthDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','DEP_01','DEP_02','DEP_03','DEP_04','DEP_05','DEP_06','DEP_07','DEP_08','DEP_09','DEP_10','DEP_11','DEP_12','DEP_13','DEP_14','DEP_15','DEP_16','DEP_17','DEP_18','DEP_19','DEP_2A','DEP_2B','DEP_21','DEP_22','DEP_23','DEP_24','DEP_25','DEP_26','DEP_27','DEP_28','DEP_29','DEP_30','DEP_31','DEP_32','DEP_33','DEP_34','DEP_35','DEP_36','DEP_37','DEP_38','DEP_39','DEP_40','DEP_41','DEP_42','DEP_43','DEP_44','DEP_45','DEP_46','DEP_47','DEP_48','DEP_49','DEP_50','DEP_51','DEP_52','DEP_53','DEP_54','DEP_55','DEP_56','DEP_57','DEP_58','DEP_59','DEP_60','DEP_61','DEP_62','DEP_63','DEP_64','DEP_65','DEP_66','DEP_67','DEP_68','DEP_69','DEP_70','DEP_71','DEP_72','DEP_73','DEP_74','DEP_75','DEP_76','DEP_77','DEP_78','DEP_79','DEP_80','DEP_81','DEP_82','DEP_83','DEP_84','DEP_85','DEP_86','DEP_87','DEP_88','DEP_89','DEP_90','DEP_91','DEP_92','DEP_93','DEP_94','DEP_95','DEP_971','DEP_972','DEP_973','DEP_974']}">
                <option value="fr.cg95.cvq.business.users.InseeDepartementCodeType_${it}" ${it == rqt.motherBirthDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.motherBirthDepartment" /></option>
              </g:each>
            </select>
            

    
      <label for="motherBirthCountry" class=""><g:message code="mcr.property.motherBirthCountry.label" />   <span><g:message code="mcr.property.motherBirthCountry.help" /></span></label>
            <select id="motherBirthCountry" name="motherBirthCountry" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.motherBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.motherBirthCountry" /></option>
              </g:each>
            </select>
            

    
      <label for="motherNationality" class="required"><g:message code="mcr.property.motherNationality.label" /> *  <span><g:message code="mcr.property.motherNationality.help" /></span></label>
            <select id="motherNationality" name="motherNationality" class="required  validate-not-first ${rqt.stepStates['parentage'].invalidFields.contains('motherNationality') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bs','bh','bd','bb','be','bz','bj','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gu','gt','gn','gq','gw','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','ci','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.FullNationalityType_${it}" ${it == rqt.motherNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.motherNationality" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

